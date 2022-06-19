package app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		//Cargar hashMap con usuarios antes de inicializar la PetApp
		
		//MainMenuApp petApp = new MainMenuApp();
		//petApp.menu();
		
//		String fuente = JSONUtilities.leer("veterinarias");
//		
//		System.out.println(fuente);
//		
//		try {
//			JSONArray obj = new JSONArray(fuente);
//		} catch (JSONException e) {
//			
//			e.printStackTrace();
//		}	
		

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
		
		//Creamos un shop
		//A partir del segundo usuario setear el usuario que ya existe
		PetShop aPetShop = new PetShop(testSubject);
		aPetShop.cargarProductos();
		
		//Entramos al menu directamente para ahorrarnos el inicio de sesion
		UserMenuApp menu = new UserMenuApp(testSubject, aPetShop);
		menu.menu();
		
	}
	
}