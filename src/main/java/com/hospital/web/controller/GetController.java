package com.hospital.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.web.domain.Admin;
import com.hospital.web.domain.Command;
import com.hospital.web.domain.Doctor;
import com.hospital.web.domain.Nurse;
import com.hospital.web.domain.Patient;
import com.hospital.web.mapper.Mapper;

public class GetController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@RequestMapping("/get/{group}/{target}")
	public @ResponseBody Object get(@PathVariable("group") String group, @PathVariable("target") String target) throws Exception{
		logger.info("PersonController get() {}", "OK");
		Object o=null;
		switch(group){
		case "patient":
			logger.info("group.equals({})", group);
		//	o=getPatient();
			patient.setId("hong");
			patient.setName("홍길동");
			patient.setPass("1234");
			o=patient;
			break;
		case "doctor":
			logger.info("group.equals({})", group);
			o=getDoctor();
			break;
		case "nurse":
			logger.info("group.equals({})", group);
			o=getNurse();
			break;
		case "admin":
			logger.info("group.equals({})", group);
			o=getAdmin();
			break;
		default:
			break;
		}
		return o;
	}
	
	@RequestMapping(value="/list/{group}",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody List<?> list(@PathVariable String group, @RequestBody Command command) throws Exception{
		logger.info("PersonController-list() {}!!", "ENTER");
		List<?> list=new ArrayList<>();
		switch(group){
		case "patient":
			logger.info("group.equals({})", group);
			list=getPatients();
			break;
		case "doctor":
			logger.info("group.equals({})", group);
			list=getDoctors();
			break;
		case "nurse":
			logger.info("group.equals({})", group);
			list=getNurses();
			break;
		case "admin":
			logger.info("group.equals({})", group);
			list=getAdmins();
			break;
		default:
			break;
		}
		return list;
	}
	
	@SuppressWarnings("unused")
	private Doctor getDoctor(){
		Doctor doctor=new Doctor();
		return doctor;
	}
	@SuppressWarnings("unused")
	private Patient getPatient(){
		Patient patient=new Patient();
		return patient;
	}
	@SuppressWarnings("unused")
	private Nurse getNurse(){
		Nurse nurse=new Nurse();
		return nurse;
	}
	@SuppressWarnings("unused")
	private Admin getAdmin(){
		Admin admin=new Admin();
		return admin;
	}
	
	private List<?> getPatients(){
		List<?>list=new ArrayList<>();
		return list;
	}
	private List<?> getDoctors(){
		List<?>list=new ArrayList<>();
		return list;
	}
	private List<?> getNurses(){
		List<?>list=new ArrayList<>();
		return list;
	}
	private List<?> getAdmins(){
		List<?>list=new ArrayList<>();
		return list;
	}
}
