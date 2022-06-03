package app;

import java.util.ArrayList;

public class Cat extends Animal {
	
	//Atributes
	private String breed;
	private boolean isCastrate;
	private ArrayList<String> vaccines; //Ver que tipo de coleccion usar
	
	//Constructor
	public Cat(String name, String specie, String gender, String healthStatus, int age, String breed, boolean isCastrate) {
		super(name, specie, gender, healthStatus, age);
		this.breed = breed;
		this.isCastrate = isCastrate;
		vaccines = new ArrayList<String>();
	}

	//Getters & Setters
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isCastrate() {
		return isCastrate;
	}

	public void setCastrate(boolean isCastrate) {
		this.isCastrate = isCastrate;
	}

	public ArrayList<String> getVaccines() {
		return vaccines;
	}

	public void setVaccines(ArrayList<String> vaccines) {
		this.vaccines = vaccines;
	}
	
}
