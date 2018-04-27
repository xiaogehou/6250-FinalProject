package com.webtools.finalProject.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webtools.finalProject.DAO.FlightDAO;
import com.webtools.finalProject.DAO.UserDAO;
import com.webtools.finalProject.pojo.Authority;
import com.webtools.finalProject.pojo.User;
import com.webtools.finalProject.pojo.Flight;

@Controller
public class UserController {

	@Autowired
	UserDAO userDao;

	@Autowired
	FlightDAO flightDao;


	@RequestMapping(value = "/dispatch", method = RequestMethod.GET)
	public ModelAndView dispatch(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		// String basePath =
		// request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

		Set<String> roles = AuthorityUtils
				.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {
			List<Flight> allFlights = flightDao.getAllFlights();
			return new ModelAndView("adminHome", "flights", allFlights);
		}else {
			UserDetails cud = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = cud.getUsername();
			User user = userDao.getUser(username);
			session.setAttribute("user", username);
			session.setAttribute("u", user);
			return new ModelAndView("home");
		}
		

	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String showLoginForm() {

		return "user-login";
	}

//	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
//	public ModelAndView handleLoginForm(HttpServletRequest request, UserDAO userDao) {
//
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		HttpSession session = request.getSession();
//		try {
//			User u = userDao.get(username, password);
//
//			if (u != null) {
//				if (u.getRole().equals(User.Role.customer)) {
//
//					session.setAttribute("user", u.getUserId());
//					session.setAttribute("u", u);
//					return new ModelAndView("home");
//
//				} else {
//					List<Flight> allFlights = flightDao.getAllFlights();
//					return new ModelAndView("adminHome", "flights", allFlights);
//				}
//
//			} else {
//				System.out.println("UserName/Password does not exist");
//				session.setAttribute("errorMessage", "UserName/Password does not exist");
//				return new ModelAndView("error");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;
//
//	}
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public ModelAndView handleLoginFailed(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("UserName/Password does not exist");
		session.setAttribute("errorMessage", "UserName/Password does not exist");
		return new ModelAndView("error");
	}
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String handleLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		
		return new ModelAndView("register-user");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request) throws Exception {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEnabled(true);
			User u = userDao.register(user);
			
			Authority authority = new Authority();
			authority.setAuthority("ROLE_USER");
			authority.setUser(user);
			userDao.create(authority);
			user.getAuthorities().add(authority);

			request.getSession().setAttribute("user", u.getUsername());
			request.getSession().setAttribute("u", u);

			return new ModelAndView("home");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while register");
		}
	}


}
