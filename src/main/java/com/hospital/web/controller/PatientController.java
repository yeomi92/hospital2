package com.hospital.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/patient")
public class PatientController {
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	@RequestMapping(value="/login")
	public String goLogin(){
		logger.info("PatientController goLogin() {}", "OK");
		return "public:common/loginForm";
	}
	@RequestMapping(value="/join")
	public String goRegister(){
		logger.info("PatientController goRegister() {}", "OK");
		return "public:patient/registerForm";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model){
		logger.info("PatientController login() {}", "POST");
		model.addAttribute("name", "홍길동");
		return "patient:patient/detail";
	}
	@RequestMapping(value="/doctor/{docID}")
	public String getDoctorInfo(@PathVariable String docID,Model model){
		model.addAttribute("docID", docID);
		return "patient:patient/doctorInfo";
	}
}
