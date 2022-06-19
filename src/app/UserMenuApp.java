package app;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserMenuApp implements I_Administration {

	Scanner input = new Scanner(System.in);
	String source = JSONUtiles.leer("veterinarias");
	PetShop shop;
	User loggedUser;

	// Constructor
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
			System.out.println("2) Ver veterinarias"); //x
			System.out.println("3) Agrega tu mascota"); //x
			System.out.println("4) Poner en adopcion");
			System.out.println("5) Ver mascotas en adopcion");
			System.out.println("6) Ir a la tienda"); //x
			System.out.println("7) Opciones de usuario");
			System.out.println("8) Cargar / Ver saldo"); //x

			System.out.println();
			System.out.print("Opcion: ");

			option = input.nextInt();

			switch (option) {

			// Reserva un Turno
			case 1:
				break;

			// Ver veterinarias
			case 2:
				menuVeterinaries();
				break;

			// Agrega tu mascota
			case 3:
				addAnimal();
				break;

			// Poner en adopcion
			case 4:
				break;

			// Ver mascotas en adopcion
			case 5:
				break;

			// Ir a la tienda
			case 6:
				shop.shopMenu();
				break;

			// Opciones de usuario
			case 7:
				editUser();
				break;

			case 8:
				loadAndViewMoneyInMyWallet();
				break;

			default:
				System.out.println("Error. N�mero de operaci�n incorrecta, por favor vuelva a ingresar la opci�n");
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
			System.out.println("3) Eliminar mascota");
			System.out.println("4) Ver todas tus mascotas");

			System.out.println();
			System.out.println("0) Salir");

			System.out.print("\nOpcion: ");
			option = input.nextInt();

			switch (option) {

			case 0:
				break;

			case 1:
				System.out.println("\n[AGREGAR MASCOTA]");
				add();
				break;

			case 2:
				System.out.println("\n[EDITAR MASCOTA]");
				edit();
				break;

			case 3:
				System.out.println("\n[REMOVER MASCOTA]");
				remove();
				break;

			case 4:
				System.out.println("\n[VER TODAS LAS MASCOTAS]");
				seeAll();
				break;

			}

		} while (option >= 1 || option >= 4);

	}

	public void menuVeterinaries() {

		int option = 0;

		do {

			System.out.println("\n[VETERINARIAS DISPONIBLES]\n");

			System.out.println("Filtrar por: ");
			System.out.println("1) Castracion");
			System.out.println("2) Desparacitaci�n");
			System.out.println("3) Adopci�n");
			System.out.println("4) Peluquer�a");
			System.out.println("5) Venta de Articulos");
			System.out.println("6) Ver todas las veterinarias disponibles");

			System.out.println();
			System.out.println("0) Volver al menu principal");

			System.out.println();
			System.out.print("Opcion: ");

			option = input.nextInt();

			System.out.println();

			switch (option) {

			case 1:
				System.out.println("[FILTRADO POR CASTRACION]\n");
				filterByOption("castracion", -1);
				break;

			case 2:
				System.out.println("[FILTRADO POR DESPARACITACI�N]\n");
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

			case 6:
				System.out.println("[MOSTRANDO TODAS LAS VETERINARIAS]\n");
				filterByOption("",6);
				break;
			}

		} while (option >= 1 || option >= 6);

	}

	public void filterByOption(String option, int selectionCase) {

		try {

			JSONArray array = new JSONArray(source);
			if (selectionCase == 6) {
				for (int i = 0; i < array.length(); i++) {
					JSONObject obj = array.getJSONObject(i);
					
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
			} else {
				for (int i = 0; i < array.length(); i++) {

					JSONObject obj = array.getJSONObject(i);
					JSONArray array_services = obj.getJSONArray("servicios");
					JSONObject obj2 = array_services.getJSONObject(selectionCase + 1);

					if (obj2.getBoolean(option) == true) {

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
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
	}

	public void loadAndViewMoneyInMyWallet() {

		int loadMoney = 0;
		double addCash = 0;

		System.out.println("Tu saldo actual es de: " + loggedUser.getMyWallet().getAmount());
		System.out.println("�Desea cargar saldo?\n 1 - Si | 2 - No\n");

		System.out.print("Opcion: ");

		loadMoney = input.nextInt();

		if (loadMoney == 1) {

			System.out.print("Ingrese un monto: ");

			addCash = input.nextDouble();

			loggedUser.getMyWallet().addCash(addCash);

			System.out.println("\nFelicitaciones, se han cargado $" + addCash + ". Su saldo actual es de: $"
					+ loggedUser.getMyWallet().getAmount() + "\n");

		} else {

			System.out.println("Volviendo al menu principal...\n");
		}
	}

	public void editUser() {
		
		int option = 0;
		
		do {

			 String password;
			 String email;
			 String name;
			 int age;
			 boolean isEnabledForFostering;
			
			System.out.println("[EDITAR USUARIO]");
			System.out.println("1) Ver informacion de usuario");
			System.out.println("2) Cambiar contraseña");
			System.out.println("3) Cambiar direccion de correo electronico");
			System.out.println("4) Cambiar nombre");
			System.out.println("5) Cambiar edad");
			System.out.println("6) Cambiar disposicion a dar transito");
			
			System.out.println("\n0) Salir");
			
			System.out.println("\nOpcion: ");
			
			option = input.nextInt();
			
			switch(option) {
			
				case 1:
					System.out.println(loggedUser.toString());
					break;
			
				case 2: 
					System.out.print("Ingrese su nueva contraseña: ");
					password = input.nextLine();
					loggedUser.setPassword(password);
					System.out.println("La contraseña ha sido modificada exitosamente !");
					break;
				
				case 3:
					System.out.print("Ingrese su nueva direccion de correo electronico: ");
					email = input.nextLine();
					loggedUser.setEmail(email);
					System.out.println("La direccion de correo electronico ha sido modificada exitosamente !");
					break;
					
				case 4:
					System.out.print("Ingrese su nuevo nombre: ");
					name = input.nextLine();
					loggedUser.setName(name);
					System.out.println("La direccion de correo electronico ha sido modificada exitosamente !");
					break;
				
				case 5:
					System.out.print("Ingrese su nueva edad: ");
					age = input.nextInt();
					loggedUser.setAge(age);
					System.out.println("La direccion de correo electronico ha sido modificada exitosamente !");
					break;
					
				case 6:
					System.out.println("Actualmente su disposicion a dar transito es: " + loggedUser.isEnabledForFostering());
					System.out.println("Desea modificarlo? 1- Si | 2- No");
					System.out.print("Opcion: ");
					
					isEnabledForFostering = (loggedUser.isEnabledForFostering() == true) ? false : true;
					
					loggedUser.setEnabledForFostering(isEnabledForFostering);
					System.out.println("La disposicion a dar transido ha sido modificada exitosamente !");
					break;
			}
			
			System.out.println();
			
		}while(option >= 1 || option >= 6);
		
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

		// Tipo de mascota
		System.out.println("Seleccione el tipo de mascota que desea agregar:\n");
		System.out.println("1- Perro");
		System.out.println("2- Gato");
		System.out.print("\nOpcion: ");
		optionSpecie = input.nextInt();

		// Nombre mascota
		System.out.println();
		input.nextLine();
		System.out.print("Ingrese el nombre de su mascota: ");
		name = input.nextLine();

		// Genero mascota
		System.out.println("\nIngrese el genero de su mascota:\n");
		System.out.println("1- Macho");
		System.out.println("2- Hembra");
		System.out.print("\nOpcion: ");

		optionGender = input.nextInt();

		if (optionGender == 1) {
			gender = "Macho";
		} else if (optionGender == 2) {
			gender = "Hembra";
		}

		// Estado de salud mascota
		System.out.println("\nIngrese el estado de su mascota:\n");
		System.out.println("1- Saludable");
		System.out.println("2- Reservado");
		System.out.println("3- Malo");
		System.out.print("\nOpcion: ");
		optionHealthStatus = input.nextInt();

		if (optionHealthStatus == 1) {
			healthStatus = "Saludable";
		} else if (optionHealthStatus == 2) {
			healthStatus = "Reservado";
		} else if (optionHealthStatus == 3) {
			healthStatus = "Malo";
		}

		// Edad
		System.out.print("\nIngrese la edad de su mascota: ");
		age = input.nextInt();

		// Raza
		input.nextLine();
		System.out.print("\nIngrese la raza de su mascota (Si no es de raza aclararlo): ");
		breed = input.nextLine();

		// Castracion
		System.out.println("\nConfirme si su mascota se encuentra castrada o no");
		System.out.println();
		System.out.println("1- Se encuentra castrada");
		System.out.println("2- No se encuentra castrada");
		optionisCastrate = input.nextInt();

		if (optionisCastrate == 1) {
			isCastrate = true;
		} else if (optionisCastrate == 2) {
			isCastrate = false;
		}

		if (optionSpecie == 1) {

			Dog aux = new Dog(name, "Canino", gender, healthStatus, age, breed, isCastrate);
			loggedUser.addAnimal(aux);
			System.out.println(aux.getName() + " ha sido agregado con exito !");

		} else if (optionSpecie == 2) {

			Cat aux = new Cat(name, "Felino", gender, healthStatus, age, breed, isCastrate);
			loggedUser.addAnimal(aux);
			System.out.println(aux.getName() + " ha sido agregado con exito !");
		}
	}

	@Override
	public void remove() {
		String name;
		int index=0;
		System.out.print("Ingrese el nombre de la mascota que quiere eliminar: ");
		input.nextLine();
		name=input.nextLine();
		
		for (int i = 0; i < loggedUser.getAnimals().size(); i++) {
			if(loggedUser.getAnimals().get(i).getName().equals(name)) {
				index=i;
			}
		}
		loggedUser.removeAnimal(index);
	}

	@Override
	public void edit() {
		String name;
		int index;
		Animal aux = null;
		boolean find=false;
		
		String newName = "";

		int optionSpecie = 0;

		String gender = "";
		int optionGender = 0;

		String healthStatus = "";
		int optionHealthStatus = 0;

		int age = 0;

		String breed = "";

		boolean isCastrate = false;
		
		int optionisCastrate = 0;
		
		System.out.print("Ingrese el nombre de la mascota que quiere editar: ");
		input.nextLine();
		name=input.nextLine();
		
		for (int i = 0; i < loggedUser.getAnimals().size(); i++) {
			if(loggedUser.getAnimals().get(i).getName().equals(name)) {
				index=i;
				aux=loggedUser.getAnimals().get(index);
				find=true;
				
				// Nombre mascota
				System.out.println();
				System.out.print("Ingrese el nombre de su mascota: ");
				newName = input.nextLine();

				// Genero mascota
				System.out.println("\nIngrese el genero de su mascota:\n");
				System.out.println("1- Macho");
				System.out.println("2- Hembra");
				System.out.print("\nOpcion: ");

				optionGender = input.nextInt();

				if (optionGender == 1) {
					gender = "Macho";
				} else if (optionGender == 2) {
					gender = "Hembra";
				}

				// Estado de salud mascota
				System.out.println("\nIngrese el estado de su mascota:\n");
				System.out.println("1- Saludable");
				System.out.println("2- Reservado");
				System.out.println("3- Malo");
				System.out.print("\nOpcion: ");
				optionHealthStatus = input.nextInt();

				if (optionHealthStatus == 1) {
					healthStatus = "Saludable";
				} else if (optionHealthStatus == 2) {
					healthStatus = "Reservado";
				} else if (optionHealthStatus == 3) {
					healthStatus = "Malo";
				}

				// Edad
				System.out.print("\nIngrese la edad de su mascota: ");
				age = input.nextInt();

				// Raza
				input.nextLine();
				System.out.print("\nIngrese la raza de su mascota (Si no es de raza aclararlo): ");
				breed = input.nextLine();

				// Castracion
				System.out.println("\nConfirme si su mascota se encuentra castrada o no");
				System.out.println();
				System.out.println("1- Se encuentra castrada");
				System.out.println("2- No se encuentra castrada");
				optionisCastrate = input.nextInt();

				if (optionisCastrate == 1) {
					isCastrate = true;
				} else if (optionisCastrate == 2) {
					isCastrate = false;
				}

					aux.setName(newName);
					aux.setGender(gender);
					aux.setHealthStatus(healthStatus);
					aux.setAge(age);
					aux.setBreed(breed);
					aux.setCastrate(isCastrate);
					
					System.out.println(aux.getName() + " ha sido modificado con exito !");
			}
		}
		
		if(find==false) {
			System.out.println("La mascota con el nombre "+ name + " no existe.");
		}
	}

	@Override
	public void seeAll() {

		for (Animal pet : loggedUser.getAnimals()) {

			System.out.println(pet.toString());
			// Falta mostrar vacunas y CARGARLAS
		}
	}

}