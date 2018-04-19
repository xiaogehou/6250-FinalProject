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

import com.webtools.finalProject.pojo.Flight;

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
}
