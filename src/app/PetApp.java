package app;

import java.util.HashMap;
import java.util.Scanner;

public class PetApp {
	
	private HashMap<String, User> users = FileManager.fileToHashMap();
	
	Scanner input = new Scanner(System.in);
	
	//Menu interactivo para el usuario
	public void menu() {
		
		int option = 0;
		boolean goSingUp = false; 
		
		do {
			
			System.out.println("Bienvenido a Pet App!");
			
			System.out.println("1- Sign up");
			System.out.println("2- Sign in");
			System.out.println("3- Close app");
			
			option = input.nextInt();
			
			switch(option) {
			
				case 1:
					singUp(); //El usuario se registra
					singIn(); //Lo redireccionamos directamente a iniciar sesion
					
					break;
					
				case 2:
					singIn();
					break;
					
				case 3:
					System.out.println("Vuelva pronto!");
					break;
					
				default:
					System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
					break;
			}
			
		}while(option < 1 && option > 3);
		
	}
	
	//Registro
	//Una vez que se crea el nuevo usuario, se carga el archivo
	public void singUp() {
		
		User temporary = new User(); //Usuario temporal para setear datos
		
		try {
			
			input.nextLine();
			
			System.out.println("Ingrese el nombre de usuario: ");
			temporary.setUser(input.nextLine()); 
			
			System.out.println("Ingrese la contraseña: ");
			temporary.setPassword(input.nextLine()); 
			
			System.out.println("Ingrese el correo electrónico: ");
			temporary.setEmail(input.nextLine()); 
			
			System.out.println("Ingrese su nombre: ");
			temporary.setName(input.nextLine()); 
			
			System.out.println("Ingrese su edad: ");
			temporary.setAge(input.nextInt()); 
			
			input.nextLine();
			
			System.out.println("¿Esta dispuesto a dar tránsito a animales? 1- Si || 2- No");
			int response = input.nextInt();
			
			if(response == 1) {
				temporary.setEnabledForFostering(true);
			}else {
				temporary.setEnabledForFostering(false);
			}
			
			System.out.println(temporary.getUser() + " fue registrado exitosamente!");
		
			
		}catch(Exception e) {
			
		}
		
	}
	
	//Inicio de sesión
	//Primero se carga el archivo a un HashMap y se busca en él al usuario, por clave.
	public void singIn() {
		
		String name;
		String password;
		
		try {
			
			System.out.println("Ingrese el nombre de usuario: ");
			name = input.nextLine();
			
			input.nextLine();
			
			System.out.println("Ingrese la contraseña: ");
			password = input.nextLine();
			
			
		}catch(Exception e) {
			
		}
	}
	
}
