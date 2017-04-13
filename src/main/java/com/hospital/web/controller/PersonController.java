package com.hospital.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.web.domain.Admin;
import com.hospital.web.domain.Doctor;
import com.hospital.web.domain.Info;
import com.hospital.web.domain.Nurse;
import com.hospital.web.domain.Patient;
import com.hospital.web.domain.Person;
import com.hospital.web.mapper.Mapper;

@RestController
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@RequestMapping("/patient/doctor/{docID}")
	public String getDoctorInfo(@PathVariable String docID, Model model) {
		logger.info("PersonController getDoctorInfo() {}", "OK");
		if (docID.equals("")) {
			return "rediect:/{permission}/login";
		}
		model.addAttribute("docID", docID);
		return "patient:patient/doctorInfo";
	}

	@RequestMapping("/join")
	public String join() {
		logger.info("PersonController getDoctorInfo() {}", "OK");
		return "public:common/registerForm";
	}
	
	private Person<? extends Info> getPatient(String target) throws Exception{
		Person<?> person=new Person<Info>(new Patient());
		Patient patient=(Patient) person.getInfo();
		String temp=patient.getId();
		logger.info("PersonController() {}", "===temp값: "+temp+"Delete진입===");
		logger.info("PersonController() {}", patient+"===delete DB가기 직전===");
		//
		//
		//
		return person;
	}	
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> login(){
		logger.info("PersonController login() {}", "Enter");
		Map<String,String>map=new HashMap<>();
		map.put("name", "박준용");
		map.put("login", "success");
		return map;
	}
}
