package com.demo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		logger.info("model{}", model);
		return "login";
	}

	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String currentTime() {
		logger.info("currentTime");
		return new Date() + "";
	}
	
	@RequestMapping(value = "/showbody", method = RequestMethod.POST)
	public String showBody(String body) {
		logger.info("showBody={}", body);
		return body;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		logger.info("showWelcomePage-model{}", model);
		boolean isValidUser = service.validateUser(name, password);
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}