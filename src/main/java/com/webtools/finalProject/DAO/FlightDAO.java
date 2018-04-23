package com.webtools.finalProject.DAO;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webtools.finalProject.pojo.Customer;
import com.webtools.finalProject.pojo.Flight;
import com.webtools.finalProject.pojo.Seat;
import com.webtools.finalProject.pojo.User;

@Repository
public class FlightDAO extends DAO {

	public List<Flight> getAllFlights() {
		try {
			begin();
			Query q = getSession().createQuery("from Flight");
			List<Flight> allflights = q.list();
			commit();
			return allflights;
		} catch (HibernateException e) {
			rollback();
			System.out.println(e.toString());
			throw e;
		}
	}

	public List<Flight> getFlights(String from, String to, Date departure) throws Exception {
		try {
			begin();
			Criteria crit = getSession().createCriteria(Flight.class);
			crit.add(Restrictions.ilike("departure", from, MatchMode.ANYWHERE));
			crit.add(Restrictions.ilike("destination", to, MatchMode.ANYWHERE));

			Date maxDate = new Date(departure.getTime() + TimeUnit.DAYS.toMillis(1));
			crit.add(Restrictions.ge("departureTime", departure));
			crit.add(Restrictions.lt("departureTime", maxDate));

			List<Flight> flights = crit.list();

			commit();
			return flights;
		} catch (HibernateException e) {
			rollback();
			throw e;
		}
	}
	
	public List<Flight> getFlights(String from, String to) throws Exception {
		try {
			begin();
			Criteria crit = getSession().createCriteria(Flight.class);
			crit.add(Restrictions.ilike("departure", from, MatchMode.ANYWHERE));
			crit.add(Restrictions.ilike("destination", to, MatchMode.ANYWHERE));

			List<Flight> flights = crit.list();

			commit();
			return flights;
		} catch (HibernateException e) {
			rollback();
			throw e;
		}
	}
	
	public void deleteFlight(Flight flight) throws Exception {
		try {
			begin();
			getSession().delete(flight);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete flight");
		}
	}

	public Flight getFlight(int flightNum) {
		try {
			begin();
			Query q = getSession().createQuery("from Flight WHERE flightNum= :flightNum");
			q.setInteger("flightNum", flightNum);
			Flight flight = (Flight) q.uniqueResult();
			commit();
			return flight;
		} catch (HibernateException e) {
			rollback();
			System.out.println(e.toString());
			throw e;
		}
	}
	
	public void updateFlight(Flight f) throws Exception {
		try {
			begin();
			getSession().merge(f);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while updating flight: " + e.getMessage());
		}
	}
	

	public void updateSeat(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		try {
			begin();
			getSession().merge(seat);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while updating seat: " + e.getMessage());
		}
	}
	
	public void create(Flight f) throws Exception {
		try {
			begin();
			getSession().save(f);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw e;
		}
	}
}
