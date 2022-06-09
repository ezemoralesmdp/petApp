package app;

import java.util.HashMap;

public class PetApp {
	private HashMap<String, User> users;
	
	
	public void menu() {
		System.out.println("Bienvenido a Pet App!");
		
		System.out.println("1-Sign up");
		System.out.println("2-Sign in");
		System.out.println("3-Close app");
	}
}
