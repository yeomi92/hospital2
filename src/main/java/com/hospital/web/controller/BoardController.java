package com.hospital.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@RequestMapping(value="/board/list")
	public String goBoard(){
		logger.info("BoardController goBoard진입 {}","OK");
		return "";
	}
	@RequestMapping(value="/find")
	public String find(@RequestParam(value="search",required=false)String search,@RequestParam(value="search",defaultValue="1")String pageNO){
		logger.info("BoardController find진입 {}","OK");
		return "public:board/containerList";
	}
}
