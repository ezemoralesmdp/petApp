package app;

import java.util.*;

public class Veterinary {

	//Atributes
	private String name;
	private String openingHours;
	private String address;
	private String neighborhood;
	private String description;
	
	private Service services;
	
	public Veterinary(String name, String openingHours, String address, String neighborhood, String description,
			Service services) {
		super();
		this.name = name;
		this.openingHours = openingHours;
		this.address = address;
		this.neighborhood = neighborhood;
		this.description = description;
		this.services = services;
	}
	
	public Service getServices() {
		return services;
	}

	@Override
	public String toString() {
		return "Veterinary [name=" + name + ", openingHours=" + openingHours + ", address=" + address
				+ ", neighborhood=" + neighborhood + ", description=" + description + ", services=" + services + "]";
	}

}
