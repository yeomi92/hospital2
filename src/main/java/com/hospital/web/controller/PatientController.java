package com.hospital.web.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.web.domain.PatientDTO;
import com.hospital.web.service.PatientService;

@Controller
@RequestMapping(value="/patient")
public class PatientController {
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	@Autowired PatientService service;
	@Autowired PatientDTO patient;
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
	public String login(@RequestParam("id") String id,@RequestParam("password") String pw, Model model) throws SQLException{
		logger.info("PatientController login() {}", "POST");
		logger.info("PatientController login() id: {}", id);
		logger.info("PatientController login() pw: {}", pw);
		patient.setPatID(id);
		patient.setPatPass(pw);
		patient=service.login(patient);
		logger.info("PatientController service.login()다녀온 후 patient: {}", patient.toString());
		model.addAttribute("name", patient.getPatName());
		return "patient:patient/detail";
	}
	@RequestMapping(value="/doctor/{docID}")
	public String getDoctorInfo(@PathVariable String docID,Model model){
		model.addAttribute("docID", docID);
		return "patient:patient/doctorInfo";
	}
}
