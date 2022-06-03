package app;

import java.util.HashMap;

public class User {
	
	//Atributes
	private String user;
	private String password;
	private String name;
	private int age;
	private HashMap<String, Animal> animals;
	private boolean isEnabledForFostering;
	
	//Constructor
	public User(String user, String password, String name, int age, HashMap<String, Animal> animals,
			boolean isEnabledForFostering) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.age = age;
		this.animals = animals;
		this.isEnabledForFostering = isEnabledForFostering;
	}

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

	public HashMap<String, Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(HashMap<String, Animal> animals) {
		this.animals = animals;
	}

	public boolean isEnabledForFostering() {
		return isEnabledForFostering;
	}

	public void setEnabledForFostering(boolean isEnabledForFostering) {
		this.isEnabledForFostering = isEnabledForFostering;
	}	
}