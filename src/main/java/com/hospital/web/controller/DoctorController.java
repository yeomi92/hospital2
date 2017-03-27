package com.hospital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/doctor")
public class DoctorController {
	@RequestMapping(value="/login")
	public String goDocLogin(){
		return "public:common/loginForm";
	}
}
