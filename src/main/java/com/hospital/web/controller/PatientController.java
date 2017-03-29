package com.hospital.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hospital.web.domain.Patient;
import com.hospital.web.domain.Person;
import com.hospital.web.mapper.Mapper;
import com.hospital.web.service.CRUD;
import com.hospital.web.util.Util;
import com.hospital.web.domain.Info;


@Controller
@RequestMapping(value = "/patient")
public class PatientController {
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	@Autowired
	Mapper mapper;

	

	@RequestMapping(value = "/join")
	public String goRegister() {
		logger.info("PatientController goRegister() {}", "OK");
		return "public:patient/registerForm";
	}

	

	@RequestMapping(value = "/doctor/{docID}")
	public String getDoctorInfo(@PathVariable String docID, Model model) {
		model.addAttribute("docID", docID);
		return "patient:patient/doctorInfo";
	}
}
