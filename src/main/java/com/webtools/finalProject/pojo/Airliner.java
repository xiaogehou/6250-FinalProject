package com.webtools.finalProject.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airliner_table")
public class Airliner {
	
	@Id
	@Column(name="airliner_name")
	private String name;

	@OneToMany(mappedBy="airliner", cascade = CascadeType.ALL)
    private List<Airplane> fleet;
	
	public Airliner() {
		
	}
	
	public Airliner(String name) {
		this.name = name;
		this.fleet = new ArrayList<Airplane>();
	}
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

 
}
