package app;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONManager {
		
	public static ArrayList<Veterinary> readJson() {
		
		String source = JSONUtiles.leer("veterinarias");
				
		ArrayList<Veterinary> arrayVeterinary = new ArrayList<>();
		Veterinary aux = null;
		
		try {
			
			JSONArray array = new JSONArray(source);
			
			for (int i = 0; i < array.length(); i++) {
			
				JSONObject obj = array.getJSONObject(i);
				
				String name = obj.getString("nombre");
				String openingHours = obj.getString("horarios");
				String address = obj.getString("direccion");
				String neighborhood = obj.getString("barrio");
				String description = obj.getString("descripcion");
				
				JSONObject obj_services = obj.getJSONObject("servicios");
				
				Service services_veterinary = null;
					
					services_veterinary = new Service(obj_services.getBoolean("castracion"), 
							obj_services.getBoolean("desparacitacion"), 
							obj_services.getBoolean("adopcion"), 
							obj_services.getBoolean("peluqueria"), 
							obj_services.getBoolean("isTienda"));		
				
				aux = new Veterinary(name, openingHours, address, neighborhood, description, services_veterinary);
				
				arrayVeterinary.add(aux);
			}
					
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return arrayVeterinary;
		
	}
	
}
