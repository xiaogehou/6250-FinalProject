package com.webtools.finalProject.pojo;

import java.io.Serializable;

public class SeatPK implements Serializable {

	private String rowNumber;
	private String column;
	private Airplane airplane;

	public SeatPK(String rowNumber, String column, Airplane airplane) {
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

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	@Override

	public int hashCode() {

		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((rowNumber == null) ? 0 : rowNumber.hashCode());
		result = PRIME * result + ((column == null) ? 0 : column.hashCode());
		result = PRIME * result + ((airplane == null) ? 0 : airplane.hashCode());
		return result;

	}

	@Override

	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		final SeatPK other = (SeatPK) obj;

		if (rowNumber == null) {
			if (other.rowNumber != null)
				return false;
		} else if (!rowNumber.equals(other.rowNumber))
			return false;
		
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		
		if (airplane == null) {
			if (other.airplane != null)
				return false;
		} else if (!airplane.equals(other.airplane))
			return false;

		return true;

	}

}
