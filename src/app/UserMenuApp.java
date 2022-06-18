package app;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserMenuApp implements I_Administration {
	
	Scanner input = new Scanner(System.in);
	String source = JSONUtiles.leer("veterinarias");
	PetShop shop;
	User loggedUser;
	
	//Constructor
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
				menuVeterinaries();
				break;

			//Agrega tu mascota
			case 3:
				addAnimal();
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
		
		int option = 0;
		
		do {
			
			System.out.println("\n[ADMINISTRAR TUS MASCOTAS]\n");
			
			System.out.println("1) Agregar mascota");
			System.out.println("2) Editar mascota");
			System.out.println("3) Eliminas mascota");
			System.out.println("4) Ver todas tus mascotas");
			
			System.out.println();
			System.out.println("0) Salir");
			
			System.out.print("\nOpcion: ");
			option = input.nextInt();
			
			switch(option) {
			
			case 0:
				break;
				
			case 1:
				System.out.println("\n[AGREGAR MASCOTA]");
				add();
				break;
				
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				System.out.println("\n[VER TODAS LAS MASCOTAS]");
				seeAll();
				break;
				
			}
			
		}while(option >= 1 || option >= 4);
		
	}
	
	public void menuVeterinaries() {
		
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
				filterByOption("castracion", -1);
				break;
				
			case 2:
				System.out.println("[FILTRADO POR DESPARACITACIÓN]\n");
				filterByOption("desparacitacion", 0);
				break;
				
			case 3:
				System.out.println("[FILTRADO POR ADOPCION]\n");
				filterByOption("adopcion", 1);
				break;
				
			case 4:
				System.out.println("[FILTRADO POR PELUQUERIA]\n");
				filterByOption("peluqueria", 2);
				break;
				
			case 5:
				System.out.println("[FILTRADO POR TIENDA - SHOP]\n");
				filterByOption("isTienda", 3);
				break;
				
			case 9:
				
				System.out.println(source);
				break;
			}
			
		}while(option >= 1 || option >= 9);
		
	}
	
	public void filterByOption(String option, int selectionCase) {
		
		try {
			
			JSONArray array = new JSONArray(source);
			
			for(int i = 0; i < array.length(); i++) {
					
				JSONObject obj = array.getJSONObject(i);
				JSONArray array_services = obj.getJSONArray("servicios");
				JSONObject obj2 = array_services.getJSONObject(selectionCase + 1);
				
				if(obj2.getBoolean(option) == true) {
					
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

	
	@Override
	public void add() {
		
		String name = "";

		int optionSpecie = 0;
		
		String gender = "";
		int optionGender = 0;
		
		String healthStatus = "";
		int optionHealthStatus = 0;
		
		int age = 0;
		
		String breed = "";
		
		boolean isCastrate = false;
		int optionisCastrate = 0;
		
		//Tipo de mascota
		System.out.println("Seleccione el tipo de mascota que desea agregar:\n");
		System.out.println("1- Perro");
		System.out.println("2- Gato");
		System.out.print("\nOpcion: ");
		optionSpecie = input.nextInt();
		
		//Nombre mascota
		System.out.println();
		input.nextLine();
		System.out.print("Ingrese el nombre de su mascota: ");
		name = input.nextLine();
		
		//Genero mascota
		System.out.println("\nIngrese el genero de su mascota:\n");
		System.out.println("1- Macho");
		System.out.println("2- Hembra");
		System.out.print("\nOpcion: ");
		
		optionGender = input.nextInt();
		
		if(optionGender == 1) {
			gender = "Macho";
		} else if(optionGender == 2) {
			gender = "Hembra";
		}
		
		//Estado de salud mascota
		System.out.println("\nIngrese el estado de su mascota:\n");
		System.out.println("1- Saludable");
		System.out.println("2- Reservado");
		System.out.println("3- Malo");
		System.out.print("\nOpcion: ");
		optionHealthStatus = input.nextInt();
		
		if(optionHealthStatus == 1) {
			healthStatus = "Saludable";
		} else if(optionHealthStatus == 2) {
			healthStatus = "Reservado";
		} else if(optionHealthStatus == 3) {
			healthStatus = "Malo";
		}
		
		//Edad
		System.out.print("\nIngrese la edad de su mascota: ");
		age = input.nextInt();
		
		//Raza
		input.nextLine();
		System.out.print("\nIngrese la raza de su mascota (Si no es de raza aclararlo): ");
		breed = input.nextLine();
		
		//Castracion
		System.out.println("\nConfirme si su mascota se encuentra castrada o no");
		System.out.println();
		System.out.println("1- Se encuentra castrada");
		System.out.println("2- No se encuentra castrada");
		optionisCastrate = input.nextInt();
		
		if(optionisCastrate == 1) {
			isCastrate = true;
		} else if (optionisCastrate == 2) {
			isCastrate = false;
		}
		
		if(optionSpecie == 1) {
			
			Dog aux = new Dog(name, "Canino", gender, healthStatus, age, breed, isCastrate);
			loggedUser.addAnimal(aux);
			System.out.println(aux.getName() + " ha sido agregado con exito !");
			
		} else if(optionSpecie == 2) {
			
			Cat aux = new Cat(name, "Felino", gender, healthStatus, age, breed, isCastrate);
			loggedUser.addAnimal(aux);
			System.out.println(aux.getName() + " ha sido agregado con exito !");
		}
	}
	

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seeAll() {
		
		for (Animal pet : loggedUser.getAnimals()) {
			
			System.out.println(pet.toString());
			//Falta mostrar vacunas y CARGARLAS
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}