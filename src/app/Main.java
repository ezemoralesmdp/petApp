package app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		String fuente = JSONUtilities.leer("veterinarias");
		
		System.out.println(fuente);
		
		try {
			JSONArray obj = new JSONArray(fuente);
		} catch (JSONException e) {
			
			e.printStackTrace();
		}	
		
		
	}
	
}