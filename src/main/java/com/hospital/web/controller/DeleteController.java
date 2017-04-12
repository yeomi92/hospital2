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

import com.hospital.web.domain.Admin;
import com.hospital.web.domain.Doctor;
import com.hospital.web.domain.Nurse;
import com.hospital.web.domain.Patient;
import com.hospital.web.domain.Person;
import com.hospital.web.mapper.Mapper;

public class DeleteController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@RequestMapping(value="/put/{group}/{target}",method=RequestMethod.POST)
	public @ResponseBody Map<?,?> delete(@PathVariable("group") String group,@PathVariable("target") Person target, @RequestBody Map<?,?> param)throws Exception{
		logger.info("PersonController-delete() {}!!", "ENTER");
		Map<?,?> map=new HashMap<>();
		switch(group){
		case "patient":
			logger.info("group.equals({})", group);
			map=deletePatient(target);
			break;
		case "doctor":
			logger.info("group.equals({})", group);
			map=deleteDoctor(target);
			break;
		case "nurse":
			logger.info("group.equals({})", group);
			map=deleteNurse(target);
			break;
		case "admin":
			logger.info("group.equals({})", group);
			map=deleteAdmin(target);
			break;
		default:
			break;
		}
		return map;
	}
	
	private Map<?,?> deletePatient(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
	private Map<?,?> deleteDoctor(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
	private Map<?,?> deleteNurse(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
	private Map<?,?> deleteAdmin(@SuppressWarnings("rawtypes") Person target){
		Map<?,?>map=new HashMap<>();
		return map;
	}
}
