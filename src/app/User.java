package app;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	
	//Atributes
	private String user;
	private String password;
	private String email;
	private String name;
	private int age;
	private ArrayList <Animal> animals;
	private boolean isEnabledForFostering;
	private Wallet myWallet;
	
	//Constructor
	
	public User() {
		//Constructor vacio porque seteamos todos los atributos desde el registro (PetApp.java)
		animals = new ArrayList<Animal>(); //Inicializamos la lista de animales del usuario vacia para luego utilizar metodos
		myWallet = new Wallet();
	}
	
//	public User(String user, String password, String name, int age, HashMap<String, Animal> animals,
//			boolean isEnabledForFostering) {
//		super();
//		this.user = user;
//		this.password = password;
//		this.name = name;
//		this.age = age;
//		this.animals = animals;
//		this.isEnabledForFostering = isEnabledForFostering;
//	}

	//Getters & Setters
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public void removeAnimal(int animal) {
		animals.remove(animal);
	}
	
	public void addAnimalAfterEdit(int index, Animal animal) {
		animals.add(index, animal);
	}

	public boolean isEnabledForFostering() {
		return isEnabledForFostering;
	}

	public void setEnabledForFostering(boolean isEnabledForFostering) {
		this.isEnabledForFostering = isEnabledForFostering;
	}	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Wallet getMyWallet() {
		return myWallet;
	}
	
	public void setMyWallet(Wallet myWallet) {
		this.myWallet = myWallet;
	}

	@Override
	public String toString() {
		
		String aux = "";
		
		aux = "Usuario: " + user + "\n" + 
			  "Nombre: " + name + "\n" + 
			  "Correo electronico: " + email + "\n" +
			  "Edad: " + age + "\n" + 
			  "Transito: " + isEnabledForFostering + "\n";
		
		return aux;
	}
	
}