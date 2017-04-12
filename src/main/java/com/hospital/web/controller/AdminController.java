package com.hospital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@RequestMapping(value="/admin/login")
	public String goAdminLogin(){
		return "public:common/loginForm";
	}
}
