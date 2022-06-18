package app;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserMenuApp {
	
	Scanner input = new Scanner(System.in);
	String source = JSONUtiles.leer("veterinarias");
	PetShop shop;
	User loggedUser;
	
	public UserMenuApp(User loggedUser, PetShop aPetShop) {
		this.loggedUser = loggedUser;
		this.shop = aPetShop;
	}
	
	public void menu() {
		
		int option = 0;

		do {

			System.out.println("Bienvenido " + loggedUser.getName() + "!");
			System.out.println("SALDO ACTUAL: $" + loggedUser.getMyWallet().getAmount() + "\n");

			System.out.println("1) Reserva un Turno");
			System.out.println("2) Ver veterinarias");
			System.out.println("3) Agrega tu mascota");
			System.out.println("4) Poner en adopcion");
			System.out.println("5) Ver mascotas en adopcion");
			System.out.println("6) Ir a la tienda");
			System.out.println("7) Opciones de usuario");
			System.out.println("8) Cargar / Ver saldo");
			
			System.out.println();
			System.out.print("Opcion: ");

			option = input.nextInt();

			switch (option) {

			//Reserva un Turno
			case 1:
				break;

			//Ver veterinarias
			case 2:
				seeAllVeterinaries();
				break;

			//Agrega tu mascota
			case 3:
				break;
				
			//Poner en adopcion
			case 4:
				break;
			
			//Ver mascotas en adopcion
			case 5:
				break;
			
			//Ir a la tienda
			case 6:
				shop.shopMenu();
				break;
				
			//Opciones de usuario
			case 7:
				break;
				
			case 8:
				loaAndViewMoneyInMyWallet();
				break;

			default:
				System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
				break;
			}

		} while (option >= 1 || option >= 8);
	}

	public void addAnimal() {

	}
	
	public void seeAllVeterinaries() {
		
		int option = 0;
		
		do {
			
			System.out.println("\n[VETERINARIAS DISPONIBLES]\n");
			
			System.out.println("Filtrar por: ");
			System.out.println("1) Castracion");
			System.out.println("2) Desparacitación");
			System.out.println("3) Adopción");
			System.out.println("4) Peluquería");
			System.out.println("5) Venta de Articulos");
			
			System.out.println();
			System.out.println("9) Ver todas las veterinarias disponibles");
			
			System.out.println();
			System.out.print("Opcion: ");
			
			option = input.nextInt();
			
			System.out.println();
			
			switch(option) {
			
			case 1:
				System.out.println("[FILTRADO POR CASTRACION]\n");
				filterByCastration();
				break;
				
			case 2:
				System.out.println("[FILTRADO POR DESPARACITACIÓN]\n");
				filterByDeworming();
				break;
				
			case 3:
				System.out.println("[FILTRADO POR ADOPCION]\n");
				filterByAdoption();
				break;
				
			case 4:
				System.out.println("[FILTRADO POR PELUQUERIA]\n");
				filterByHairdresser();
				break;
				
			case 5:
				System.out.println("[FILTRADO POR TIENDA - SHOP]\n");
				filterByShop();
				break;
				
			case 9:
				
				System.out.println(source);
				break;
			}
			
		}while(option >= 1 || option >= 9);
		
	}
	
	//Filtrados
	public void filterByCastration() {
		
		try {
			
			JSONArray array = new JSONArray(source);
			
			for(int i = 0; i < array.length(); i++) {
					
				JSONObject obj = array.getJSONObject(i);
				JSONArray array_services = obj.getJSONArray("servicios");
				JSONObject obj2 = array_services.getJSONObject(0);
				
				if(obj2.getBoolean("castracion") == true) {
					
					String nombre = obj.getString("nombre");
					String horarios = obj.getString("horarios");
					String direccion = obj.getString("direccion");
					String barrio = obj.getString("barrio");
					String descripcion = obj.getString("descripcion");
					
					System.out.println(nombre);
					System.out.println(horarios);
					System.out.println(direccion);
					System.out.println(barrio);
					System.out.println(descripcion);
					System.out.println();

				}
			}
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void filterByDeworming() {
		
		try {
			
			JSONArray array = new JSONArray(source);
			
			for(int i = 0; i < array.length(); i++) {
					
				JSONObject obj = array.getJSONObject(i);
				JSONArray array_services = obj.getJSONArray("servicios");
				JSONObject obj2 = array_services.getJSONObject(1);
				
				if(obj2.getBoolean("desparacitacion") == true) {
					
					String nombre = obj.getString("nombre");
					String horarios = obj.getString("horarios");
					String direccion = obj.getString("direccion");
					String barrio = obj.getString("barrio");
					String descripcion = obj.getString("descripcion");
					
					System.out.println(nombre);
					System.out.println(horarios);
					System.out.println(direccion);
					System.out.println(barrio);
					System.out.println(descripcion);
					System.out.println();

				}
			}
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void filterByAdoption() {
		
		try {
			
			JSONArray array = new JSONArray(source);
			
			for(int i = 0; i < array.length(); i++) {
					
				JSONObject obj = array.getJSONObject(i);
				JSONArray array_services = obj.getJSONArray("servicios");
				JSONObject obj2 = array_services.getJSONObject(2);
				
				if(obj2.getBoolean("adopcion") == true) {
					
					String nombre = obj.getString("nombre");
					String horarios = obj.getString("horarios");
					String direccion = obj.getString("direccion");
					String barrio = obj.getString("barrio");
					String descripcion = obj.getString("descripcion");
					
					System.out.println(nombre);
					System.out.println(horarios);
					System.out.println(direccion);
					System.out.println(barrio);
					System.out.println(descripcion);
					System.out.println();

				}
			}
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void filterByHairdresser() {
		
		try {
			
			JSONArray array = new JSONArray(source);
			
			for(int i = 0; i < array.length(); i++) {
					
				JSONObject obj = array.getJSONObject(i);
				JSONArray array_services = obj.getJSONArray("servicios");
				JSONObject obj2 = array_services.getJSONObject(3);
				
				if(obj2.getBoolean("peluqueria") == true) {
					
					String nombre = obj.getString("nombre");
					String horarios = obj.getString("horarios");
					String direccion = obj.getString("direccion");
					String barrio = obj.getString("barrio");
					String descripcion = obj.getString("descripcion");
					
					System.out.println(nombre);
					System.out.println(horarios);
					System.out.println(direccion);
					System.out.println(barrio);
					System.out.println(descripcion);
					System.out.println();

				}
			}
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}

	public void filterByShop() {
		
		try {
			
			JSONArray array = new JSONArray(source);
			
			for(int i = 0; i < array.length(); i++) {
					
				JSONObject obj = array.getJSONObject(i);
				JSONArray array_services = obj.getJSONArray("servicios");
				JSONObject obj2 = array_services.getJSONObject(4);
				
				if(obj2.getBoolean("isTienda") == true) {
					
					String nombre = obj.getString("nombre");
					String horarios = obj.getString("horarios");
					String direccion = obj.getString("direccion");
					String barrio = obj.getString("barrio");
					String descripcion = obj.getString("descripcion");
					
					System.out.println(nombre);
					System.out.println(horarios);
					System.out.println(direccion);
					System.out.println(barrio);
					System.out.println(descripcion);
					System.out.println();

				}
			}
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	public void loaAndViewMoneyInMyWallet() {
		
		int loadMoney = 0;
		double addCash = 0;
		
		System.out.println("Tu saldo actual es de: " + loggedUser.getMyWallet().getAmount());
		System.out.println("¿Desea cargar saldo?\n 1 - Si | 2 - No\n");
		
		System.out.print("Opcion: ");
		
		loadMoney = input.nextInt();
		
		if(loadMoney == 1) {
			
			System.out.print("Ingrese un monto: ");
			
			addCash = input.nextDouble();
			
			loggedUser.getMyWallet().addCash(addCash);
			
			System.out.println("\nFelicitaciones, se han cargado $" + addCash + ". Su saldo actual es de: $" + loggedUser.getMyWallet().getAmount() + "\n");
			
		} else {
			
			System.out.println("Volviendo al menu principal...\n");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}