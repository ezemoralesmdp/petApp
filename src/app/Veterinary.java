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
	private ArrayList<Appointment> listOfAppointments;
	
	public Veterinary(String name, String openingHours, String address, String neighborhood, String description,
			Service services) {
		super();
		this.name = name;
		this.openingHours = openingHours;
		this.address = address;
		this.neighborhood = neighborhood;
		this.description = description;
		this.services = services;
		listOfAppointments = new ArrayList<>();
	}
	
	public Service getServices() {
		return services;
	}

	@Override
	public String toString() {
		return "Veterinary [name=" + name + ", openingHours=" + openingHours + ", address=" + address
				+ ", neighborhood=" + neighborhood + ", description=" + description + ", services=" + services + "]";
	}
	
	public ArrayList<Appointment> getListOfAppointments() {
		return listOfAppointments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setServices(Service services) {
		this.services = services;
	}

	public void setListOfAppointments(ArrayList<Appointment> listOfAppointments) {
		this.listOfAppointments = listOfAppointments;
	}

	
}
