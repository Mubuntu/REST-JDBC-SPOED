package edu.ap.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.resource.ClientResource;

public class RegistratieClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {
          	ClientResource resource = new ClientResource("http://127.0.0.1:8181/registratie/registratieTable");
          	// Post a new record
          	JSONObject json = new JSONObject();
      		json.put("naam", "kik");
      		json.put("naamverpleegkundige", "kek");
      		json.put("diagnose", "verokken spier tijdens het programmeren.");
      		resource.post(json.toString());
          	System.out.println(json);
          	// Write the response entity on the console
          	resource.get().write(System.out);
          	System.out.println();
          	// Process the resource
              JSONObject obj1 = new JSONObject(resource.get(String.class));
              JSONArray array1 = obj1.getJSONArray("result");
             
              for(int i = 0; i < array1.length(); i++) {
                  JSONObject obj2 = array1.getJSONObject(i);
                  System.out.println(obj2.toString());
               }
          }
          catch (Exception e) {
              System.out.println("In main : " + e.getMessage());
          }
	}

}
