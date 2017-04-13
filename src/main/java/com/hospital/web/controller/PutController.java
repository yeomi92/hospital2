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
import com.hospital.web.domain.Doctor;
import com.hospital.web.domain.Nurse;
import com.hospital.web.domain.Patient;
import com.hospital.web.domain.Person;
import com.hospital.web.mapper.Mapper;
@RestController
public class PutController {
	private static final Logger logger = LoggerFactory.getLogger(PutController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@RequestMapping(value="/put/{group}",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> put(@PathVariable String group, @RequestBody Person target) throws Exception{
		logger.info("PersonController-put() {}!!", "ENTER");
		Map<?,?> map=new HashMap<>();
		switch(group){
		case "patient":
			logger.info("group.equals({})", group);
			map=putPatient(target);
			break;
		case "doctor":
			logger.info("group.equals({})", group);
			map=putDoctor(target);
			break;
		case "nurse":
			logger.info("group.equals({})", group);
			map=putNurse(target);
			break;
		case "admin":
			logger.info("group.equals({})", group);
			map=putAdmin(target);
			break;
		default:
			break;
		}
		return map;
	}
	
	private Map<?,?> putPatient(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
	private Map<?,?> putDoctor(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
	private Map<?,?> putNurse(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
	private Map<?,?> putAdmin(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
}
