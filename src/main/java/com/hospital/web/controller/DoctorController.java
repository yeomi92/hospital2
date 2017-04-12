package com.hospital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/doctor")
public class DoctorController {
	@RequestMapping(value="/login")
	public String goDocLogin(){
		return "public:common/loginForm";
	}
}
