package com.webtools.finalProject.controller;

import java.util.List;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webtools.finalProject.DAO.FlightDAO;
import com.webtools.finalProject.pojo.Flight;

@Controller
public class FlightController {

	@Autowired
	FlightDAO flightDao;

	@RequestMapping(value = "/user/search.htm", method = RequestMethod.GET)
	public ModelAndView handleSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date = formatter.parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// List<Flight> flights = flightDao.getFlights(from, to, date);
		List<Flight> flights = flightDao.getFlights(from, to, date);

		for (Flight f : flights) {
			System.out.println(f.getFlightNum());
			System.out.println(f.getDeparture());
			System.out.println(f.getDestination());
			System.out.println(f.getArrivingTime());
		}

		return new ModelAndView("search-result", "results", flights);
	}

	@RequestMapping(value = "/user/buyTicket.htm", method = RequestMethod.GET)
	public ModelAndView buyTicket(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("user") != null) {
			mav.setViewName("buyTickets");
			return mav;
		} else {
			out.println("<meta http-equiv='refresh' content='2;URL=/finalProject/user/login.htm'>");// redirects after 3 seconds
			out.println("<p>Please Login Before Buying Tickets!</p>");
			return null;
		}

	}
}
