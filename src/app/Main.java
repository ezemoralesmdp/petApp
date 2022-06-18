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
		
		//JSONUtiles
		String fuente = JSONUtiles.leer("veterinarias");
		
		try {
			JSONArray array = new JSONArray(fuente);
			
			JSONObject obj = array.getJSONObject(0);
			
			String nombre = obj.getString("nombre");
			String horarios = obj.getString("horarios");
			String direccion = obj.getString("direccion");
			String barrio = obj.getString("barrio");
			String descripcion = obj.getString("descripcion");
			
			JSONArray arrayInterno = obj.getJSONArray("servicios");
			
			JSONObject obj2 = arrayInterno.getJSONObject(0);
			boolean castracion = obj2.getBoolean("castracion");
			
			obj2 = arrayInterno.getJSONObject(1);
			boolean desparacitacion = obj2.getBoolean("desparacitacion");
			
			obj2 = arrayInterno.getJSONObject(2);
			boolean adopcion = obj2.getBoolean("adopcion");
			
			obj2 = arrayInterno.getJSONObject(3);
			boolean peluqueria = obj2.getBoolean("peluqueria");
			
			obj2 = arrayInterno.getJSONObject(4);
			boolean isTienda = obj2.getBoolean("isTienda");
			
			System.out.println(nombre);
			System.out.println(horarios);
			System.out.println(direccion);
			System.out.println(barrio);
			System.out.println(descripcion);
			
			System.out.println(castracion);
			System.out.println(desparacitacion);
			System.out.println(adopcion);
			System.out.println(peluqueria);
			System.out.println(isTienda);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
		PetShop aPetShop = new PetShop(testSubject);
		aPetShop.cargarProductos();
		
		//Entramos al menu directamente para ahorrarnos el inicio de sesion
		UserMenuApp menu = new UserMenuApp(testSubject, aPetShop);
		menu.menu();
		
	}
	
}