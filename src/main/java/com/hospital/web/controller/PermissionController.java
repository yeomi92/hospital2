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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hospital.web.domain.Info;
import com.hospital.web.domain.Patient;
import com.hospital.web.domain.Person;
import com.hospital.web.domain.Schema;
import com.hospital.web.mapper.Mapper;
import com.hospital.web.service.CRUD;
import com.hospital.web.util.Util;

@Controller
@SessionAttributes("permission")
public class PermissionController {
	private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
	@Autowired
	Mapper mapper;
	@RequestMapping(value = "/login")
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
		switch (permission) {
		case "patient":
			Map<String, String> map= new HashMap<>();
			map.put("group", patient.getGroup());
			map.put("key", Schema.PATIENT.getName());
			map.put("value", id);
			logger.info("key, group, value {}", map.get("key")+map.get("group")+map.get("value"));
			CRUD.Service ex = new CRUD.Service() {
				@Override
				public Object execute(Object o) throws Exception {
					logger.info("--------------ID ?  {} ---------", o);
					return mapper.exist(map);
				}
			};
			Integer count = (Integer) ex.execute(id);
			logger.info("ID Exist?  {}", count);
			if (count == 0) {
				logger.info("DB RESULT: {}", "ID not exist");
				movePosition = "public:patient/loginForm";
			} else {
				logger.info("DB RESULT: {}", "ID exist");
				CRUD.Service login = new CRUD.Service() {
					@Override
					public Object execute(Object o) throws Exception {	
						return mapper.findPatient(map);
					}
				};
				patient = (Patient) login.execute(patient);
				if (patient.getPass().equals(pw)) {
					logger.info("DB RESULT: {}", "Success");
					session.setAttribute("permission", patient);
					String[] getInfo = Util.getInfo(patient.getJumin());
					model.addAttribute("patient", patient);
					model.addAttribute("name", patient.getName());
					model.addAttribute("address", patient.getAddr());
					model.addAttribute("email", patient.getEmail());
					model.addAttribute("phone", patient.getPhone());
					model.addAttribute("job", patient.getJob());
					model.addAttribute("age", getInfo[0]);
					model.addAttribute("birth", getInfo[1]);
					model.addAttribute("gender", patient.getGen());
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
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
