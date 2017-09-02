package edu.ap.jdbc;

import java.util.ArrayList;
import java.util.Iterator;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBConnection conn = JDBConnection.getJDBConnection();
		conn.openConnection("spoed", "root", "root");
		conn.executeInsert("registratie", "Mubuntu", "Kris gevaerts", "overslapen voor het examen");
		ArrayList<String> arr = conn.selectAll();
		for (Iterator iterator = arr.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			
		}
	}

}
