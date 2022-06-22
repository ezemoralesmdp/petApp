package app;

import java.util.ArrayList;

public class Dog extends Animal  {
	
	//Atributes
	private ArrayList<String> vaccines; //Ver que tipo de coleccion usar
	
	//Constructor
	public Dog(String name, String specie, String gender, String healthStatus, int age, String breed, boolean isCastrate) {
		super(name, specie, gender, healthStatus, age, breed, isCastrate);
		vaccines = new ArrayList<String>();
	}

	//Getters & Setters
	public ArrayList<String> getVaccines() {
		return vaccines;
	}

	public void setVaccines(ArrayList<String> vaccines) {
		this.vaccines = vaccines;
	}
}
