package app;

import java.io.Serializable;

public abstract class Animal implements Serializable {

	//Atributes
	private String name;
	private String specie;
	private String gender;
	private String healthStatus;
	private int age;
	private String birthdate;
	
	//Constructor
	public Animal(String name, String specie, String gender, String healthStatus, int age) {
		this.name = name;
		this.specie = specie;
		this.gender = gender;
		this.healthStatus = healthStatus;
		this.age = age;
	}

	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
}
