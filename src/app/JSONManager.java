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
	
	public static void createPersonalJSON(User loggedUser) {
		
		JSONObject myPersonalInfo = new JSONObject();
		
		try {
			myPersonalInfo.put("user", loggedUser.getUser());
			myPersonalInfo.put("email", loggedUser.getEmail());
			myPersonalInfo.put("name", loggedUser.getName());
			myPersonalInfo.put("age", loggedUser.getAge());
			myPersonalInfo.put("enabledForFostering", loggedUser.isEnabledForFostering());
			
			JSONArray arrayAnimals = new JSONArray();
			ArrayList<Animal> animals = null;
			
			if(loggedUser.getAnimals() != null) {
				
				animals = loggedUser.getAnimals();
				
				for(int i = 0; i < animals.size(); i++) {
					
					JSONObject animal = new JSONObject();
					Animal aux = new Animal();
					
					aux = animals.get(i);
					
					animal.put("name", aux.getName());
					animal.put("specie", aux.getSpecie());
					animal.put("gender", aux.getGender());
					animal.put("healthStatus", aux.getHealthStatus());
					animal.put("age", aux.getAge());
					animal.put("age", aux.getBreed());
					animal.put("castrate", aux.isCastrate());
					
					arrayAnimals.put(animal);
				}
				
				myPersonalInfo.put("animals", arrayAnimals);
				
			} else {
				
				JSONObject animal = new JSONObject();
				
				animal.put("name", "");
				animal.put("specie", "");
				animal.put("gender", "");
				animal.put("healthStatus", "");
				animal.put("age", "");
				animal.put("age", "");
				animal.put("castrate", "");
				
				arrayAnimals.put(animal);
				
				myPersonalInfo.put("animals", arrayAnimals);
			}
			
			//------------------------------------------------------------------------------------------------------------------
			
			JSONArray arrayAppointment = new JSONArray();
			LinkedList<Appointment> appointments = null;
			
			if(loggedUser.getListOfAssignedAppointments() != null) {
				
				appointments = loggedUser.getListOfAssignedAppointments();
				
				for(int i = 0; i < appointments.size(); i++) {
					
					JSONObject appointment = new JSONObject();
					Appointment aux = new Appointment();
					
					aux = appointments.get(i);
					
					appointment.put("id", aux.getId());
					appointment.put("time", aux.getTime());
					appointment.put("date", aux.getDate());
					appointment.put("castration", aux.isCastration());
					appointment.put("desparasitization", aux.isDeparasitization());
					appointment.put("adoption", aux.isAdoption());
					appointment.put("groomer", aux.isGroomer());
					appointment.put("userAssigned", aux.getUserAssigned());
					
					JSONObject myAnimal = new JSONObject();
					Animal aux2 = aux.getUsersPetAssigned();
					
					myAnimal.put("name", aux2.getName());
					myAnimal.put("specie", aux2.getSpecie());
					myAnimal.put("gender", aux2.getGender());
					myAnimal.put("healthStatus", aux2.getHealthStatus());
					myAnimal.put("age", aux2.getAge());
					myAnimal.put("breed", aux2.getBreed());
					myAnimal.put("castrate", aux2.isCastrate());
					
					appointment.put("animal", myAnimal);
					
					arrayAppointment.put(appointment);
				}
				
				myPersonalInfo.put("appointments", arrayAppointment);
				
			} else {
				
				JSONObject appointment = new JSONObject();
				
				appointment.put("id", "");
				appointment.put("time", "");
				appointment.put("date", "");
				appointment.put("castration", "");
				appointment.put("desparasitization", "");
				appointment.put("adoption", "");
				appointment.put("groomer", "");
				appointment.put("userAssigned", "");
				
				JSONObject myAnimal = new JSONObject();
				myAnimal.put("name", "");
				myAnimal.put("specie", "");
				myAnimal.put("gender", "");
				myAnimal.put("healthStatus", "");
				myAnimal.put("age", "");
				myAnimal.put("breed", "");
				myAnimal.put("castrate", "");
				
				appointment.put("animal", myAnimal);
				
				arrayAppointment.put(appointment);
				
				myPersonalInfo.put("appointments", arrayAppointment);
			}
			
			JSONUtiles.grabar(myPersonalInfo);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}