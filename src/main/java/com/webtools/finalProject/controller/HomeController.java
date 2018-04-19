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

	@Autowired
	AirlinerDAO airlinerDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() throws Exception {
		
		//test generate airliners:
//		airlinerDao.generateDatas();
		
		
		return "home";
	}

}
