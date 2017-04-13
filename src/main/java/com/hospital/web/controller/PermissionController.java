package com.hospital.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hospital.web.domain.Info;
import com.hospital.web.domain.Patient;
import com.hospital.web.domain.Person;
import com.hospital.web.domain.Enums;
import com.hospital.web.mapper.Mapper;
import com.hospital.web.service.IGetService;
import com.hospital.web.util.Util;

//tiles활용한 것
@RestController
@SessionAttributes("permission")
public class PermissionController {
	private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
	@Autowired
	Mapper mapper;
	@RequestMapping(value = "/test/login")
	public String goLogin() {
		logger.info("PermissionController goLogin() {}", "OK");
		return "public:common/loginForm";
	}
	@RequestMapping(value = "/{permission}/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String pw, @PathVariable String permission, HttpSession session, Model model) throws Exception {
		logger.info("PermissionController login() {}", "POST");
		logger.info("PermissionController login() id,pw: {}", id + pw);
		logger.info("PermissionController login() group: {}", permission); 
		Person<?> person = new Person<Info>(new Patient());
		Patient patient = (Patient) person.getInfo();
		patient.setId(id);
		patient.setPass(pw);
		String movePosition = "";
		Map<String, String> map= new HashMap<>();
		switch (permission) {
		case "patient":
			map.put("group", patient.getGroup());
			map.put("key", Enums.PATIENT.val());
			map.put("value", id);
			logger.info("key, group, value {}", map.get("key")+map.get("group")+map.get("value"));
			IGetService exist2=new IGetService() {
				@Override
				public Object execute(Map<?, ?> map) throws Exception {
					return mapper.exist(map);
				}
			};
			//Lambda
			IGetService exist=(paramMap)->mapper.exist(paramMap);
			Integer count = (Integer) exist.execute(map);
			
			logger.info("ID Exist?  {}", count);
			if (count == 0) {
				logger.info("DB RESULT: {}", "ID not exist");
				movePosition = "public:patient/loginForm";
			} else {
				logger.info("DB RESULT: {}", "ID exist");
				
				//Lambda
				IGetService login=(paramMap)->mapper.findPatient(paramMap);
				patient = (Patient) login.execute(map);
				if (patient.getPass().equals(pw)) {
					logger.info("DB RESULT: {}", "Success");
					session.setAttribute("permission", patient);
					String[] getInfo = Util.getInfo(patient.getJumin());
					model.addAttribute("user", patient);
					model.addAttribute("age", getInfo[0]);
					model.addAttribute("birth", getInfo[1]);
					logger.info("DB RESULT: {}", patient);
					movePosition = "patient:patient/detail";
				} else {
					logger.info("DB RESULT: {}", "Password not match!");
					movePosition = "public:common/loginForm";
				}
			}
			break;
		case "doctor":
			break;
		case "nurse":
			break;
		case "admin":
			break;
		default:
			break;
		}
		return movePosition;
	}
	
	
	@RequestMapping(value = "/{permission}/update", method = RequestMethod.POST)
	public String update(@RequestParam("id") String id, @PathVariable String permission, HttpSession session, Model model) throws Exception {
		logger.info("PermissionController login() {}", "POST");
		logger.info("PermissionController login() group: {}", permission);
		switch(permission){
		case "patient":break;
		case "doctor":break;
		case "nurse":break;
		}
		return "";
	}
	
	@RequestMapping("/test/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
