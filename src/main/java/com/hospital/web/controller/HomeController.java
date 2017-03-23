package com.hospital.web.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hospital.web.composite.Complex;
import com.hospital.web.domain.ContextDTO;
import com.sun.xml.bind.v2.ContextFactory;

@Controller
@SessionAttributes("context")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpSession session) {
		logger.info("Welcome", "home");
		session.setAttribute("context", Complex.ContextFactory.create());
		return "index";
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		logger.info("home진입", "OK");
		return "public:common/main";
	}
}
