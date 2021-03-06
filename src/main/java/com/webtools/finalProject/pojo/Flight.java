package com.webtools.finalProject.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="flight_table")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightNum;

	@Column(name="departure")
	private String departure;

	@Column(name="destination")
	private String destination;

	@ManyToOne
	private Airplane airplane;

	@Column(name="departureTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime;

	@Column(name="arrivingTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivingTime;

	@Column(name="availSeatsNum")
	private int availSeatsNum;

	@ManyToMany(mappedBy="flights", cascade = CascadeType.ALL)
	private List<Customer> customers;

	public Flight() {
		customers = new ArrayList<Customer>();
	}


	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplanes) {
		this.airplane = airplanes;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivingTime() {
		return arrivingTime;
	}

	public void setArrivingTime(Date arrivingTime) {
		this.arrivingTime = arrivingTime;
	}
	
	


	public List<Customer> getCustomers() {
		return customers;
	}


	public int getAvailSeatsNum() {
		int i = 0;
		for (Seat s : airplane.getSeats()) {
			if (s.getCustomer() == null) {
				i++;
			}
		}
		return i;
	}

	public void setAvailSeatsNum(int availSeatsNum) {
		this.availSeatsNum = availSeatsNum;
	}

	public void generatePrice() {
		Random r = new Random();
		for (Seat s : airplane.getSeats()) {
			s.setPrice(r.nextInt(1000) + 200);
		}
	}

	@Override
	public String toString() {
		return airplane.getModelNumber();
	}

	public void buySeats(Seat seat, Customer customer) {
		seat.setCustomer(customer);
	}

	public Seat AvailSeatLowestSeat() {
		List<Seat> availSeats = new ArrayList<Seat>();
		for (Seat st : airplane.getSeats()) {
			if (st.getCustomer() == null) {
				availSeats.add(st);
			}
		}
		int lowestPrice = Integer.MAX_VALUE;
		Seat lowestSeat = null;
		for (Seat st : availSeats) {
			if (st.getPrice() <= lowestPrice) {
				lowestPrice = st.getPrice();
				lowestSeat = st;
			}
		}
		return lowestSeat;
	}
	
	
}
