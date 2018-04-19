package com.webtools.finalProject.controller;


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

import com.webtools.finalProject.DAO.UserDAO;
import com.webtools.finalProject.pojo.Customer;
import com.webtools.finalProject.pojo.User;
import com.webtools.finalProject.pojo.User.Role;
import com.webtools.finalProject.validator.UserValidator;


@Controller
public class UserController {
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	UserValidator validator;
	
	@RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
	public String showLoginForm() {

		return "user-login";
	}

	@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	public String handleLoginForm(HttpServletRequest request, UserDAO userDao) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try {
			User u = userDao.get(username, password);

			if (u != null) {
				session.setAttribute("user", u);
				return "home";
			} else {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
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
	
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.print("registerUser");

		return new ModelAndView("register-user", "user", new User());

	}
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {

		validator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("register-user", "user", user);
		}

		try {

			user.setRole(Role.customer);

			User u = userDao.register(user);
			
			request.getSession().setAttribute("user", u);
			
			return new ModelAndView("home", "user", u);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
	@RequestMapping(value = "/user/addCustomer.htm", method = RequestMethod.POST)
	protected ModelAndView addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		String name = request.getParameter("newName");
		Customer c = new Customer();
		c.setUser(u);
		c.setName(name);
		u.getCustomers().add(c);
		
		userDao.register(c);
		userDao.updateUser(u);
		
		for(Customer cs: u.getCustomers()) {
			System.out.println(cs.getName());
		}
		return new ModelAndView("buyTickets");
		
	}
}
