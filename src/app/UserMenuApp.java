package app;

import java.util.Scanner;

public class UserMenuApp {
	
	Scanner input = new Scanner(System.in);
	PetShop shop=new PetShop();
	
	public void menu(User loggedUser) {
		int option = 0;

		do {

			System.out.println("Bienvenido "+loggedUser.getName()+"!");

			System.out.println("1)Reserva un Turno");
			System.out.println("2)Ver veterinarias");
			System.out.println("3)Agrega tu mascota");
			System.out.println("4)Poner en adopcion");
			System.out.println("5)Ver mascotas en adopcion");
			System.out.println("6)Ir a la tienda");
			System.out.println(")Opciones de usuario"); 

			option = input.nextInt();

			switch (option) {

			case 1:
				
				break;

			case 2:
				
				break;

			case 3:
				
				break;
			case 4:
				
			break;
			case 5:
				break;
			case 6:
				
				shop.cargarProductos();
				shop.shopMenu();
				break;

			default:
				System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
				break;
			}

		} while (option < 1 || option > 3);
	}

	public void addAnimal(User loggedUser) {

	}
}
