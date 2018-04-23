package com.webtools.finalProject.controller;


import java.util.List;

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

import com.webtools.finalProject.DAO.FlightDAO;
import com.webtools.finalProject.DAO.UserDAO;
import com.webtools.finalProject.pojo.Customer;
import com.webtools.finalProject.pojo.User;
import com.webtools.finalProject.pojo.Flight;
import com.webtools.finalProject.pojo.User.Role;
import com.webtools.finalProject.validator.UserValidator;


@Controller
public class UserController {
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	FlightDAO flightDao;
	
	@Autowired
	UserValidator validator;
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String showLoginForm() {

		return "user-login";
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView handleLoginForm(HttpServletRequest request, UserDAO userDao) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try {
			User u = userDao.get(username, password);

			if (u != null) {
				if(u.getRole().equals(User.Role.customer)) {

					session.setAttribute("user", u.getUserId());
					session.setAttribute("u", u);
					return new ModelAndView("home");
					
				}else {
					List<Flight> allFlights = flightDao.getAllFlights();
					return new ModelAndView("adminHome","flights", allFlights);
				}
				
			} else {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	@RequestMapping(value = "/user/logout.htm", method = RequestMethod.GET)
	public String handleLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.print("registerUser");

		return new ModelAndView("register-user", "user", new User());

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {

		validator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("register-user", "user", user);
		}

		try {

			user.setRole(Role.customer);

			User u = userDao.register(user);
			
			request.getSession().setAttribute("user", u.getUserId());
			request.getSession().setAttribute("u", u);
			
			return new ModelAndView("home");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
	@RequestMapping(value = "/user/addCustomer.htm", method = RequestMethod.POST)
	protected ModelAndView addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user");
		User u = userDao.getUser(userId);
		
		String name = request.getParameter("newName");
		Customer c = new Customer();
		c.setUser(u);
		c.setName(name);
		u.getCustomers().add(c);
		
		userDao.register(c);
		userDao.updateUser(u);
		
		return new ModelAndView("buyTickets","user",u);
		
	}
	@RequestMapping(value = "/user/tickets.htm", method = RequestMethod.GET)
	protected ModelAndView viewCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user");
		User u = userDao.getUser(userId);
		
		return new ModelAndView("viewCart","user",u);
	}
	
	
	
}
