package com.hospital.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value="/board/list")
	public String goBoard(){
		logger.info("BoardController goBoard진입 {}","OK");
		return "";
	}
}
