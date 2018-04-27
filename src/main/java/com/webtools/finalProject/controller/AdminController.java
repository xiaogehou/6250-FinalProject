package com.webtools.finalProject.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webtools.finalProject.DAO.AirlinerDAO;
import com.webtools.finalProject.DAO.FlightDAO;
import com.webtools.finalProject.DAO.UserDAO;
import com.webtools.finalProject.pojo.Airliner;
import com.webtools.finalProject.pojo.Airplane;
import com.webtools.finalProject.pojo.Flight;

@Controller
public class AdminController {

	@Autowired
	AirlinerDAO airlinerDao;

	@Autowired
	UserDAO userDao;

	@Autowired
	FlightDAO flightDao;


	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView handleHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Flight> flights = flightDao.getAllFlights();

		return new ModelAndView("adminHome", "flights", flights);
	}

	@RequestMapping(value = "/admin/search.htm", method = RequestMethod.POST)
	public ModelAndView handleSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String from = request.getParameter("from");
		String to = request.getParameter("to");

		List<Flight> flights = flightDao.getFlights(from, to);

		return new ModelAndView("adminHome", "flights", flights);
	}

	@RequestMapping(value = "/admin/manageFlight", method = RequestMethod.GET)
	public ModelAndView handleManageFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer flightNum = Integer.parseInt(request.getParameter("flightNum"));
		Flight flight = flightDao.getFlight(flightNum);

		return new ModelAndView("editFlight", "flight", flight);
	}

	@RequestMapping(value = "/admin/delete.htm", method = RequestMethod.GET)
	public ModelAndView handleDeleteFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer flightNum = Integer.parseInt(request.getParameter("flightNum"));
		Flight flight = flightDao.getFlight(flightNum);
		// delete method:
		flightDao.deleteFlight(flight);
		return new ModelAndView("deleteSuccess", "flight", flight);
	}

	@RequestMapping(value = "/admin/updateFlight.htm", method = RequestMethod.POST)
	public ModelAndView handleUpdateFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer flightNum = Integer.parseInt(request.getParameter("flightNum"));
		Flight flight = flightDao.getFlight(flightNum);
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String departing = request.getParameter("departing");
		String arriving = request.getParameter("arriving");
		Date depart = (Date) formatter.parse(departing);
		Date arrive = (Date) formatter.parse(arriving);

		flight.setDeparture(from);
		flight.setDestination(to);
		flight.setDepartureTime(depart);
		flight.setArrivingTime(arrive);
		flightDao.updateFlight(flight);

		return new ModelAndView("updateSuccess", "flight", flight);
	}

	@RequestMapping(value = "/admin/newFlight.htm", method = RequestMethod.GET)
	public ModelAndView newFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Airliner> allAirliner = airlinerDao.getAllAirliners();
		mv.addObject("airliners", allAirliner);
		mv.setViewName("select-airliner");
		return mv;
	}

	@RequestMapping(value = "/admin/newFlight-2.htm", method = RequestMethod.GET)
	public ModelAndView createNewFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String name = request.getParameter("airliner");
		Airliner airliner = airlinerDao.getAirliner(name);
		List<Airplane> airplanes = airliner.getFleet();
		mv.addObject("airplanes", airplanes);
		mv.addObject("airliner",airliner);
		mv.setViewName("flight-form");
		return mv;
	}

	@RequestMapping(value = "/admin/createFlight.htm", method = RequestMethod.POST)
	public ModelAndView createFlight(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Flight flight = new Flight();
		Airliner airliner = airlinerDao.getAirliner(request.getParameter("airliner"));
		String model = request.getParameter("airplane");
		Airplane airplane = airlinerDao.getAirplane(airliner, model);
		flight.setAirplane(airplane);
		
		flight.setDeparture(request.getParameter("from"));
		flight.setDestination(request.getParameter("to"));
		
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String departing = request.getParameter("departing");
		String arriving = request.getParameter("arriving");
		Date depart = (Date) formatter.parse(departing);
		Date arrive = (Date) formatter.parse(arriving);
		if(arrive.before(depart)) {
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert(\"Time error!!\");" + "window.history.go(-1);</script>");
			return null;
		}
		flight.setDepartureTime(depart);
		flight.setArrivingTime(arrive);
		
		flight.setAvailSeatsNum(flight.getAvailSeatsNum());
		
		airplane.getFlights().add(flight);
		
		flightDao.create(flight);
		airlinerDao.updateAirplane(airplane);
		
		return new ModelAndView("add-success","flight",flight);
	}

}
