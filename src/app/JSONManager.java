package app;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONManager {
		
	
	public static void createJSON(User aux) {
		
		
		
	}
	
	
	public static void newUser() {
		
	}
	
	
	
	public ArrayList<User> JSONtoUsersArray() {
		
		String source=JSONUtiles.leer("users.json");
		
		ArrayList <User> arrayUsers=new ArrayList<>();
		
		try {
			JSONArray jsonArrayUsers=new JSONArray(source);
			for (int i = 0; i < jsonArrayUsers.length(); i++) {
				User auxUser=new User();
				JSONObject jsonUser=jsonArrayUsers.getJSONObject(i);
				auxUser.setUser(jsonUser.getString("user"));
				auxUser.setPassword(jsonUser.getString("password"));
				auxUser.setEmail(jsonUser.getString("email"));
				auxUser.setName(jsonUser.getString("name"));
				auxUser.setAge(jsonUser.getInt("age"));
				
				JSONArray jsonArrayAnimals=jsonUser.getJSONArray("animals");
				ArrayList<Animal> arrayAnimals=new ArrayList<>();
				
				for (int j = 0; j < jsonArrayAnimals.length(); j++) {
					JSONObject jsonAnimal=jsonArrayAnimals.getJSONObject(j);
					Animal auxAnimal=new Animal();
					for (int k = 0; k < jsonArrayAnimals.length(); k++) {
						auxAnimal.setName(jsonAnimal.getString("name"));
						auxAnimal.setSpecie(jsonAnimal.getString("specie"));
						auxAnimal.setGender(jsonAnimal.getString("gender"));
						auxAnimal.setHealthStatus(jsonAnimal.getString("healthStatus"));
						auxAnimal.setAge(jsonAnimal.getInt("age"));
					}
				}
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return arrayUsers;
	}
	
	
	public void userArrayToJSONFile() {
		
		
		
	}
	
	
	
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
