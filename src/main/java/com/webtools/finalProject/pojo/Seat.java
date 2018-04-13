package com.webtools.finalProject.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "seat_table")
@IdClass(SeatPK.class)
public class Seat implements Serializable {

	@Id
	@Column(name = "rowNumber")
	private String rowNumber;

	@Id
	@Column(name = "columnNum")
	private String columnNum;

	@OneToOne
	@JoinColumn
	private Customer customer;

	@Column(name = "price")
	private int price;

	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "airplane_modelNum"), @JoinColumn(name = "airplane_airliner") })
	private Airplane airplane;

	public Seat(String rowNumber, String columnNum, Airplane airplane) {
		this.rowNumber = rowNumber;
		this.columnNum = columnNum;
		this.airplane = airplane;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getColumnNum() {
		return columnNum;
	}

	public void setColumnNum(String columnNum) {
		this.columnNum = columnNum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
}
