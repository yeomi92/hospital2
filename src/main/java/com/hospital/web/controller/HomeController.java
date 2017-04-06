package com.hospital.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hospital.web.composite.Complex;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("Welcome", "home");
		model.addAttribute("context", Complex.ContextFactory.create());
		return "index";
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		logger.info("home진입", "OK");
		return "public:common/main";
	}
}
