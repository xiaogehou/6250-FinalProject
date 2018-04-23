package com.webtools.finalProject.DAO;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.webtools.finalProject.pojo.Airliner;
import com.webtools.finalProject.pojo.Airplane;
import com.webtools.finalProject.pojo.Flight;

@Repository
public class AirlinerDAO extends DAO {

	public void generateDatas() throws Exception {
		// Create airliners:
		String[] names = { "JetBlue", "United Airline", "American Airline" };
		for (String name : names) {
			Airliner airliner = new Airliner(name);

			create(airliner);

			// Create airplanes for each airliner
			List<Airplane> fleet = airliner.getFleet();
			String[] modelNumberList = { "Boeing 787", "Airbus a380", "Boeing 777", "Airbus b220" };
			for (int i = 0; i < 5; i++) {
				for (String modelNumber : modelNumberList) {
					String mn = modelNumber + "_" + i;
					Airplane airplane = new Airplane(mn, airliner);
					fleet.add(airplane);
					create(airplane);
				}
			}

			// Create flight schedule based on airplanes each airliner have
			Random r = new Random();

			for (int i = 0; i < fleet.size() - 2; i++) {
				Airplane ap = fleet.get(i);
				int j = 3;
				while (j > 0) {
					Flight flight = new Flight();
					flight.setAirplane(ap);
					String[] locations = { "Boston", "New York", "Chicago", "Sanfransico", "Los Angeles", "Houston",
							"Philadelphia", "Phoenix", "San Antonio", "San Diego", "Dallas", "San Jose",
							"Washington,DC", "Oklahoma", "Las Vegas" };
					int from = r.nextInt(locations.length);
					int to = r.nextInt(locations.length);
					while (to == from) {
						to = r.nextInt(locations.length);
					}
					Date depatureTime = randomGenerateDate();
					Date arrivingTime = randomGenerateDate();
					while (depatureTime.after(arrivingTime)) {
						arrivingTime = randomGenerateDate();
					}
					flight.setDepartureTime(depatureTime);
					flight.setArrivingTime(arrivingTime);
					flight.setDeparture(locations[from]);
					flight.setDestination(locations[to]);
					flight.generatePrice();
					flight.setAvailSeatsNum(flight.getAvailSeatsNum());
					ap.getFlights().add(flight);
					create(flight);
					j--;
				}

			}
		}
	}

	private Date randomGenerateDate() {
		Date d1 = new Date();
		Date d2 = new Date(d1.getTime() + (long) 365 * 24 * 3600 * 1000);
		ThreadLocalRandom random = ThreadLocalRandom.current();
		Long l = random.nextLong(0, 365 * 24 * 3600 * 1000);
		Date randomDate = new Date(d1.getTime() + l);
		return randomDate;
	}

	// save airliner:
	public Airliner create(Airliner airliner) throws Exception {
		try {
			begin();
			getSession().save(airliner);
			commit();
			return airliner;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not create airliner");
		}
	}

	// save airplane
	public Airplane create(Airplane airplane) throws Exception {
		try {
			begin();
			getSession().save(airplane);
			commit();
			return airplane;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not create airplane");
		}
	}

	// save flight:
	public Flight create(Flight flight) throws Exception {
		try {
			begin();
			getSession().save(flight);
			commit();
			return flight;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not create flight");
		}
	}
	
	//get airliners:
	public List<Airliner> getAllAirliners() throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Airliner");
			List<Airliner> allAirliners = q.list();
			commit();
			return allAirliners;
		} catch (HibernateException e) {
			rollback();
			throw e;
		}
	}
	
	//get airliner:
	public Airliner getAirliner(String name) throws Exception{
		try {
			begin();
			Query q = getSession().createQuery("from Airliner where name= :name");
			q.setString("name", name);
			Airliner airliner = (Airliner) q.uniqueResult();
			commit();
			return airliner;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get airliner");
		}
	}
	//get airplane:
	public Airplane getAirplane(Airliner airliner, String name) throws Exception{
		try {
			begin();
			Query q = getSession().createQuery("from Airplane where airliner= :airliner and modelNumber= :modelNumber");
			q.setEntity("airliner", airliner);
			q.setString("modelNumber", name);
			Airplane airplane = (Airplane) q.uniqueResult();
			commit();
			return airplane;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get airplane");
		}
	}
	
	//update:
	public void updateAirplane(Airplane airplane ) throws Exception {
		try {
			begin();
			getSession().update(airplane);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw e;
		}
	}

}
