package com.hospital.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.web.domain.Admin;
import com.hospital.web.domain.Command;
import com.hospital.web.domain.Doctor;
import com.hospital.web.domain.Info;
import com.hospital.web.domain.Nurse;
import com.hospital.web.domain.Patient;
import com.hospital.web.domain.Person;
import com.hospital.web.mapper.Mapper;
@RestController
public class PostController {
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@RequestMapping(value="/post/{group}",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> post(@PathVariable String group, @SuppressWarnings("rawtypes") @RequestBody Person target, Command command) throws Exception {
		logger.info("PersonController register() {}","OK");
		Map<?,?>map=new HashMap<>();
		switch (group) {
		case "patient":
			map=postPatient(target);
			break;
		case "doctor":
			map=postDoctor(target);
			break;
		case "nurse":
			map=postNurse(target);
			break;
		case "admin":
			map=postAdmin(target);
			break;
		default:
			break;
		}
		return map;
	}
	
	private Map<?,?> postPatient(Object o){
		Map<?,?>map=new HashMap<>();
		Person<?> person=new Person<Info>(new Patient());
		Patient patient=(Patient) person.getInfo();
		logger.info("PersonController postPatient() patientID: {}",patient.getId());
		patient.getGen();
		patient.setJob("환자");
		patient.getJumin();
		patient.getName();
		logger.info("PersonController postPatient( {}","update진입");
		return map;
	}
	private Map<?,?> postDoctor(Object o){
		Map<?,?>map=new HashMap<>();
		Person<?> person=new Person<Info>(new Patient());
		Doctor doctor=(Doctor) person.getInfo();
		logger.info("PersonController postPatient() patientID: {}",doctor.getId());
		doctor.getGen();
		//doctor.setJob("환자");
		doctor.getName();
		logger.info("PersonController postPatient( {}","update진입");
		return map;
	}
	private Map<?,?> postNurse(Object o){
		Map<?,?>map=new HashMap<>();
		Person<?> person=new Person<Info>(new Patient());
		/*Nurse nurse=nurs
		logger.info("PersonController postPatient() patientID: {}",patient.getId());
		patient.getGen();
		patient.setJob("환자");
		patient.getJumin();
		patient.getName();*/
		logger.info("PersonController postPatient( {}","update진입");
		return map;
	}
	private Map<?,?> postAdmin(Object o){
		Map<?,?>map=new HashMap<>();
		Person<?> person=new Person<Info>(new Patient());
		Patient patient=(Patient) person.getInfo();
		logger.info("PersonController postPatient() patientID: {}",patient.getId());
		patient.getGen();
		patient.setJob("환자");
		patient.getJumin();
		patient.getName();
		logger.info("PersonController postPatient( {}","update진입");
		return map;
	}
}
