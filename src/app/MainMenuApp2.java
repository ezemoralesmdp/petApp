package app;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenuApp2 {

	Scanner input = new Scanner(System.in);
	private ArrayList<User> users;

	public MainMenuApp2() {
		users = new ArrayList<User>();
	}

	public void menu() {

		int option = 0;

		do {

			System.out.println("Bienvenido a Pet App!");

			System.out.println("1- Sign up"); // Registrarse
			System.out.println("2- Sign in"); // Iniciar de sesion
			System.out.println("3- Close app"); // Cerrar la aplicación

			option = input.nextInt();

			switch (option) {

			case 1:
				signUp(); // El usuario se registra
				break;

			case 2:
				//signIn();
				break;

			case 3:
				System.out.println("Vuelva pronto!");
				break;

			default:
				System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
				break;
			}

		} while (option < 1 || option > 3);
	}

	public void signUp() {

		User aux=new User();		

		input.nextLine();

		System.out.println("Ingrese el nombre de usuario: ");
		aux.setUser(input.nextLine());
		
		System.out.println("Ingrese la contraseña: ");
		aux.setPassword(input.nextLine());
		System.out.println("Ingrese el correo electrónico: ");
		aux.setEmail(input.nextLine());
		System.out.println("Ingrese su nombre: ");
		aux.setName(input.nextLine());
		System.out.println("Ingrese su edad: ");
		aux.setAge(input.nextInt());
		System.out.println("¿Esta dispuesto a dar tránsito a animales? 1- Si || 2- No");
		int response = input.nextInt();

		if (response == 1) {
			aux.setEnabledForFostering(true);
		} else {
			aux.setEnabledForFostering(false);
		}
		
		if(users.size()==0) {
			
		}
		else {
			for (int i = 0; i < users.size(); i++) {
				if(aux.equals(users.get(i))) {
					System.out.println("Este usuario ya esta registrado");
				}
				else {
					
				}
			}
		}

		System.out.println(aux.getUser() + " fue registrado exitosamente!");

	}
}
