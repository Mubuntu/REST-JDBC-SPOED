package edu.ap.rest;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.jdbc.JDBConnection;

public class RegistratieResource extends ServerResource{
	

	@Get("txt")
	public String allRegistraties(){
		JDBConnection c = JDBConnection.getJDBConnection();
		c.openConnection("spoed", "root", "root");
		ArrayList<String> resultArray = c.selectAll();
		c.closeConnection();
		
		JSONObject json = new JSONObject();
		json.put("operation", "selectAll");
		json.put("length", resultArray.size());
		JSONArray jsonArray = new JSONArray();
		
		int i = 0;
		for(String s : resultArray) {
			JSONObject obj = new JSONObject();
			obj.put("" + i, s);
			jsonArray.put(obj);
			i++;
		}
		
		json.put("result", jsonArray);
		System.out.println(json);
		return json.toString();

	}
	
	@Post("txt")
	public void newRegistratie(String json) {
		
		JSONObject newRegistration = new JSONObject(json);
		String naam = newRegistration.getString("naam");
		String naamVerpleegkundige = newRegistration.getString("naamverpleegkundige");
		String diagnose = newRegistration.getString("diagnose");
				
		JDBConnection c = JDBConnection.getJDBConnection();
		c.openConnection("spoed", "root", "root");
		c.executeInsert("registratie", naam, naamVerpleegkundige, diagnose);
		c.closeConnection();
	}
}
