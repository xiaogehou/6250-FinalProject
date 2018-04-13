package com.webtools.finalProject.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webtools.finalProject.DAO.AirlinerDAO;
import com.webtools.finalProject.pojo.Airliner;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
//
//	@Autowired
//	AirlinerDAO airlinerDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		// Create airplanes for each airliner
//		for (Airliner airliner : airliners.getAirlinerlist()) {
//			Fleet fleet = airliner.getFleet();
//			String[] modelNumberList = { "Boeing 787", "Airbus a380", "Boeing 777", "Airbus b220" };
//			for (int i = 0; i < 10; i++) {
//				for (String modelNumber : modelNumberList) {
//					Airplane airplane = new Airplane(modelNumber);
//					airplane.generateSeats(airplane);
//					airplane.setAirliner(airliner);
//					fleet.addAirplane(airplane);
//				}
//			}
//
//			// Create flight schedule based on airplanes each airliner have
//			FlightSchedule flightSchedule = airliner.getFlightSchedule();
//
//			Random r = new Random();
//
//			for (int i = 0; i < fleet.getFleet().size() - 5; i++) {
//				Airplane airpalne = fleet.getFleet().get(i);
//				Flight flight = new Flight();
//				flight.setAirplane(airpalne);
//				flight.setFlightNum("FlightNumber_00" + i);
//				String[] locations = { "Boston", "New York", "Chicago", "Sanfransico", "Los Angeles", "Houston",
//						"Philadelphia", "Phoenix", "San Antonio", "San Diego", "Dallas", "San Jose", "Washington,DC",
//						"Oklahoma", "Las Vegas" };
//				int from = r.nextInt(locations.length);
//				int to = r.nextInt(locations.length);
//				while (to == from) {
//					to = r.nextInt(locations.length);
//				}
//				Date depatureTime = randomGenerateDate();
//				Date arrivingTime = randomGenerateDate();
//				while (depatureTime.after(arrivingTime)) {
//					arrivingTime = randomGenerateDate();
//				}
//				flight.setDepartureTime(depatureTime);
//				flight.setArrivingTime(arrivingTime);
//				flight.setDeparture(locations[from]);
//				flight.setDestination(locations[to]);
//				flight.generatePrice();
//				airpalne.setFlight(flight);
//				flightSchedule.addFlight(flight);
//			}
//
//			// Populate data to master schedule
//			masterSchedule.getFlightSchedule().getFlightSchedule()
//					.addAll(airliner.getFlightSchedule().getFlightSchedule());
//		}

		return "home";
	}

}
