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
import com.hospital.web.service.IPostService;
@RestController
public class PostController {
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;	
	@RequestMapping(value="/post/doctor",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> post(@RequestBody Doctor doctor) throws Exception{
		logger.info("PostController post() {}","OK");
		Map<String,String>map=new HashMap<>();
		map=postDoctor(doctor);
		logger.info("PostController post() map name{}",map.get("name"));
		return map;
	}
	@RequestMapping(value="/post/patient",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> post(@RequestBody Patient patient) throws Exception{
		logger.info("PostController post() {}","OK");
		Map<String,String>map=new HashMap<>();
		map=postPatient(patient);
		logger.info("PostController post() map name{}",map.get("name"));
		return map;
	}
	@RequestMapping(value="/post/nurse",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> post(@RequestBody Nurse nurse) throws Exception{
		logger.info("PostController post() {}","OK");
		Map<String,String>map=new HashMap<>();
		map=postNurse(nurse);
		logger.info("PostController post() map name{}",map.get("name"));
		return map;
	}
	private Map<String,String> postPatient(Object o) throws Exception{
		Map<String,String>map=new HashMap<>();
		logger.info("PostController postPatient( {}","진입");
		((Patient) o).setDocID("dahn");
		((Patient) o).setNurID("nkim");
		IPostService join=(param)->mapper.registPatient(param);
		join.execute(o);
		map.put("name", ((Patient) o).getName());
		return map;
	}
	private Map<String,String> postDoctor(Object o) throws Exception{
		logger.info("PostController postDoctor( {}","진입");
		Map<String,String>map=new HashMap<>();
		IPostService join=(param)->mapper.registDoctor(param);
		join.execute(o);
		map.put("name", ((Doctor) o).getName());
		return map;
	}
	private Map<String,String> postNurse(Object o) throws Exception{
		logger.info("PostController postNurse( {}","진입");
		Map<String,String>map=new HashMap<>();
		IPostService join=(param)->mapper.registNurse(param);
		join.execute(o);
		map.put("name", ((Nurse) o).getName());
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
