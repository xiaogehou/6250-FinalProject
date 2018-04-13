package com.webtools.finalProject.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="airplane_table")
@IdClass(AirplanePK.class)
public class Airplane {
	
	@Id
	@Column(name="modelNumber")
	private String modelNumber;
	
	@Id
	@ManyToOne
	@JoinColumn
	private Airliner airliner;
	
	@OneToOne
	@JoinColumn
	private Flight flight;
	
	@OneToMany(mappedBy="airplane",cascade = CascadeType.ALL)
	private List<Seat> seats;

	public Airplane(String modelNumber) {
		this.modelNumber = modelNumber;
		seats = new ArrayList<Seat>();
	}

	public void generateSeats(Airplane airplane) {
		String[] columns = { "Window_left", "Middle_left", "Aisle_left", "Window_right", "Middle_right",
				"Aisle_right" };
		for (int row = 1; row <= 25; row++) {
			String r = String.valueOf(row);
			for (String column : columns) {
				Seat seat = new Seat(r, column, airplane);
				seats.add(seat);
			}
		}
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}

	public Airliner getAirliner() {
		return airliner;
	}

	public void setAirliner(Airliner airliner) {
		this.airliner = airliner;
	}

}
