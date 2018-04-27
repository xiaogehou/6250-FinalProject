package com.webtools.finalProject.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webtools.finalProject.DAO.AirlinerDAO;
import com.webtools.finalProject.DAO.UserDAO;
import com.webtools.finalProject.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	AirlinerDAO airlinerDao;
	
	@Autowired
	UserDAO userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() throws Exception {
		
//		//new a admin:
//		User admin = new User();
//		admin.setUsername("admin");
//		admin.setPassword("123");
//		admin.setEnabled(true);;
//		userDao.register(admin);
//		
//		Authority authority = new Authority();
//		authority.setAuthority("ROLE_ADMIN");
//		authority.setUser(admin);
//		
//		admin.getAuthorities().add(authority);
//		userDao.create(authority);
//		
//		
//	
//		//test generate airliners:
//		airlinerDao.generateDatas();
		
		
		return "home";
	}

	@RequestMapping(value = "/check.htm", method = RequestMethod.GET)
	@ResponseBody
	public String checkName(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String username = request.getParameter("username"); 
		 User user = userDao.getUser(username);
		 if(user!=null) {
			 return "false";
		 }else {
			 return "true";
		 }
	}
}
