package com.webtools.finalProject.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="seat_table")
@IdClass(SeatPK.class)
public class Seat implements Serializable{
	
	@Id
	@Column(name="rowNumber")
	private String rowNumber;

	@Id
	@Column(name="column")
    private String column;

	@OneToOne
	@PrimaryKeyJoinColumn
    private Customer customer;

	@Column(name="price")
    private int price;

    @Id
    @ManyToOne
    private Airplane airplane;

    public Seat(String rowNumber, String column, Airplane airplane) {
        this.rowNumber = rowNumber;
        this.column = column;
        this.airplane = airplane;
    }
    

	public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
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
