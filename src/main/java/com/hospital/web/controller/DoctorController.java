package com.hospital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {
	@RequestMapping(value="/doctor/login")
	public String goDocLogin(){
		return "public:common/loginForm";
	}

}
