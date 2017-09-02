package edu.ap.jdbc;

import java.sql.*;
import java.util.ArrayList;

public class JDBConnection {

	private static JDBConnection instance = null;
	private Connection conn = null;

	private JDBConnection() {
	}

	public void openConnection(String database, String user, String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3307/" + database;
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				System.out.println("Error: " + ex);
			}
		}
	}

	public static synchronized JDBConnection getJDBConnection() {

		if (instance == null) {
			instance = new JDBConnection();
		}
		return instance;
	}

	public void executeInsert(String table, String namePatient, String nameVerpleegkundige, String diagnose) {

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO " + table + "(naam, naamverpleegkundige, diagnose"
					+ ")" + " VALUES('" + namePatient + "','" + nameVerpleegkundige + "','" + diagnose + "');");
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Error: " + ex);
		}
	}

	public String selectName(String name) {

		ResultSet rs = null;
		String result = "";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM registratie WHERE name='" + name + "'");
			if (rs.next()) {
				result = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " "
						+ rs.getString(5);
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Error: " + ex);
		}

		return result;
	}

	public ArrayList<String> selectAll() {

		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM REGISTRATIE ORDER BY interventiedatum DESC");
			while (rs.next()) {
				result.add(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
						+ rs.getString(5));
			}
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Error: " + ex);
		}

		return result;
	}
}
