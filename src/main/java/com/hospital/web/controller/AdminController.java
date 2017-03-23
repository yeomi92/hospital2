package com.hospital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping(value="/admin/login")
	public String goAdminLogin(){
		return "public:common/loginForm";
	}
}
