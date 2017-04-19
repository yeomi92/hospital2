package com.hospital.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.web.domain.Admin;
import com.hospital.web.domain.Chart;
import com.hospital.web.domain.Doctor;
import com.hospital.web.domain.Nurse;
import com.hospital.web.domain.Patient;
import com.hospital.web.mapper.Mapper;
import com.hospital.web.service.ChartService;

@RestController
public class ChartController {
	private static final Logger logger = LoggerFactory.getLogger(ChartController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@Autowired ChartService chartService;
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/chart",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> chartList(@RequestBody Patient patient) throws Exception{
		Map<String,Object>map=new HashMap<>();
		logger.info("ChartController getChart() {}", "Enter");
		logger.info("=================================ChartController patient ID: {}", patient.getId());
		map.put("id",patient.getId());
		List<Chart> list = chartService.chartList(map);
		if(list.isEmpty()){
	         map.put("result", "fail");
	    }else{
	         map.put("result", "success");
	         map.put("list", list);
	    }
		return map;
	}
}
