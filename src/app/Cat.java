package app;

import java.util.ArrayList;

public class Cat extends Animal {
	
	
	//Constructor
	public Cat(String name, String specie, String gender, String healthStatus, int age, String breed, boolean isCastrate) {
		super(name, specie, gender, healthStatus, age, breed, isCastrate);

	}

	@Override
	public String toString() {
		return "Cat []" + toString();
	}

	//Getters & Setters

	
	
}
