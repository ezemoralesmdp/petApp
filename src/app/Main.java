package app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		//Cargar hashMap con usuarios antes de inicializar la PetApp
		//MainMenuApp petApp = new MainMenuApp();
			
		//petApp.menu();
		
		//Wallete de Garfield
		Wallet aWallet = new Wallet();
		aWallet.addCash(5000);
		
		//Sujeto de prueba Garfield
		User testSubject = new User();
		testSubject.setUser("michi666");
		testSubject.setPassword("miau123");
		testSubject.setEmail("iamsocute@gmail.com");
		testSubject.setName("Garfield");
		testSubject.setAge(5);
		testSubject.setEnabledForFostering(true);
		testSubject.setMyWallet(aWallet);
		
		
		
//		Animal cat = new Cat("papri", "cat", "female", "healthy", 1, "tricolor", false);
//		testSubject.addAnimal(cat);
		
		//Creamos un shop
		//A partir del segundo usuario setear el usuario que ya existe
		PetShop aPetShop = new PetShop(testSubject);
		aPetShop.cargarProductos();
		
		//Creamos turnos
		PetAppointment petAppointment = new PetAppointment();
		
		//Entramos al menu directamente para ahorrarnos el inicio de sesion
		UserMenuApp menu = new UserMenuApp(testSubject, aPetShop, petAppointment);
		menu.menu();
		
//		Service services = new Service(true,true,true,true,true);
//		
//		Veterinary walrus = new Veterinary("walrus","9:00 a 18:00", "pepe 323", "parque luro", "una vet de walrus",services);
//
//		Appointment ajsja = new Appointment(1,"18:20","28/06/2022",testSubject.getName(),testSubject.getAnimals().get(0));
//		
//		walrus.getListOfAppointments().add(ajsja);
	}
	
}