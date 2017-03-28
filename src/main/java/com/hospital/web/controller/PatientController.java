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
import com.hospital.web.mapper.PatientMapper;
import com.hospital.web.service.IExist;
import com.hospital.web.service.PatientService;

@Controller
@RequestMapping(value="/patient")
public class PatientController {
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	@Autowired PatientService service;
	@Autowired PatientDTO patient;
	@Autowired PatientMapper mapper;
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
	public String login(@RequestParam("id") String id,@RequestParam("password") String pw, Model model) throws Exception{
		logger.info("PatientController login() {}", "POST");
		logger.info("PatientController login() id: {}", id);
		logger.info("PatientController login() pw: {}", pw);
		patient.setPatID(id);
		patient.setPatPass(pw);
		IExist ex = new IExist() {
						@Override
						public int exist(Object o) throws Exception {
							logger.info("--------------ID ?  {} ---------", o);
							return mapper.exist(id);
						}
					};
					int count = ex.exist(patient.getPatID());
					logger.info("ID Exist?  {}", count);
					String movePosition = "";
					if(count==0) {
						logger.info("DB RESULT: {}", "ID not exist");
						movePosition = "public:patient/loginForm";
					} else {
						logger.info("DB RESULT: {}", "ID exist");
						patient=service.login(patient);
						if(patient.getPatPass().equals(pw)) {
							logger.info("DB RESULT: {}", "Success");
							String[] getInfo = service.getBirth(patient.getPatJumin());
							model.addAttribute("patient", patient);
							model.addAttribute("name",patient.getPatName());
							model.addAttribute("address",patient.getPatAddr());
							model.addAttribute("email",patient.getPatEmail());
							model.addAttribute("phone",patient.getPatPhone());
							model.addAttribute("job",patient.getPatJob());
							model.addAttribute("age",getInfo[0]);
							model.addAttribute("birth",getInfo[1]);
							model.addAttribute("gender",patient.getPatGen());
							logger.info("DB RESULT: {}",patient);
							movePosition = "public:patient/detail";
						} else {
							logger.info("DB RESULT: {}", "Password not match");
							movePosition = "public:common/loginForm";
						}
					}
					return movePosition;
	}
	@RequestMapping(value="/doctor/{docID}")
	public String getDoctorInfo(@PathVariable String docID,Model model){
		model.addAttribute("docID", docID);
		return "patient:patient/doctorInfo";
	}
}
