package com.webtools.finalProject.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airliner_table")
public class Airliner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;

	@OneToMany(mappedBy="airliner")
    private List<Airplane> fleet;
    
	@OneToMany(mappedBy="airplane")
    private List<Flight> flightSchedule;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Airplane> getFleet() {
		return fleet;
	}

	public void setFleet(List<Airplane> fleet) {
		this.fleet = fleet;
	}

	public List<Flight> getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(List<Flight> flightSchedule) {
		this.flightSchedule = flightSchedule;
	}


    
}
