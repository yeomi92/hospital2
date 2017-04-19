package com.hospital.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.hospital.web.service.IGetService;
import com.hospital.web.service.PersonService;
import com.hospital.web.util.Util;

@RestController
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@Autowired PersonService personService;
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
	public @ResponseBody Map<?,?> login(@RequestBody Map<String,String>paramMap) throws Exception{
		Map<String,Object>map=new HashMap<>();
		logger.info("PersonController login() {}", "Enter");
		String id=paramMap.get("id");
		String password=paramMap.get("password");
		logger.info("PersonController login() id: {}, pw: {}", id,password);
		String[] arr={"Patient/pat_id","Doctor/doc_id","Nurse/nur_id"};
		Integer rs=0;
		for(int i=0;i<arr.length;i++){
			paramMap.put("group",arr[i].split("/")[0]);
			paramMap.put("idType",arr[i].split("/")[1]);
			rs=personService.exist(paramMap);
			if(rs==1){
				map.put("group",paramMap.get("group"));
				map.put("id",id);
				break;
			}
		}
		if(rs==0){
			System.out.println("if문 rs==0");
			map.put("group","fail");
		}else{
			switch (paramMap.get("group")){
				case "Patient":
					IGetService loginP=(a)->mapper.findPatient(a);
					patient = (Patient) loginP.execute(paramMap);
					logger.info("patient 정보 {}",patient);
					if (patient.getPass().equals(password)) {
						logger.info("DB RESULT: {}", "Success");
						map.put("patient",patient);
						map.put("group","Doctor");
						map.put("idType","doc_id");
						map.put("id", patient.getDocID());
						doctor=personService.getDoctor(map);
						logger.info("doctor name: {}", doctor.getName());
						map.put("docName",doctor.getName());
					}
					break;
				case "Doctor":
					IGetService loginD=(a)->mapper.findDoctor(a);
					doctor = (Doctor) loginD.execute(paramMap);
					logger.info("doctor 정보 {}",doctor);
					if (doctor.getPass().equals(password)) {
						logger.info("DB RESULT: {}", "Success");
						map.put("name",doctor.getName());
					}
					break;
				case "Nurse":
					IGetService loginN=(a)->mapper.findNurse(a);
					nurse = (Nurse) loginN.execute(paramMap);
					logger.info("nurse 정보 {}",nurse);
					if (nurse.getPass().equals(password)) {
						logger.info("DB RESULT: {}", "Success");
						map.put("name",nurse.getName());
					}
					break;
			}
		}
		return map;
	}
}
