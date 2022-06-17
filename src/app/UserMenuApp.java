package app;

import java.util.Scanner;

public class UserMenuApp {
	
	Scanner input = new Scanner(System.in);
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

	public void addAnimal(User loggedUser) {

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