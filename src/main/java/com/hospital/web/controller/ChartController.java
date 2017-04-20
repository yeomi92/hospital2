package com.hospital.web.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hospital.web.domain.Admin;
import com.hospital.web.domain.Chart;
import com.hospital.web.domain.Doctor;
import com.hospital.web.domain.Nurse;
import com.hospital.web.domain.Patient;
import com.hospital.web.mapper.Mapper;
import com.hospital.web.service.ChartService;
import com.hospital.web.service.PersonService;

import javafx.animation.Interpolator;

@SessionAttributes("storage")
@RestController
public class ChartController {
	private static final Logger logger = LoggerFactory.getLogger(ChartController.class);
	@Autowired Mapper mapper;
	@Autowired Patient patient;
	@Autowired Doctor doctor;
	@Autowired Nurse nurse;
	@Autowired Admin admin;
	@Autowired Chart chart;
	@Autowired ChartService chartService;
	@Autowired PersonService personService;
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/chart",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> chartList(@RequestBody Patient p) throws Exception{
		Map<String,Object>map=new HashMap<>();
		logger.info("ChartController getChart() {}", "Enter");
		logger.info("=================================ChartController patient ID: {}", patient.getId());
		map.put("id",p.getId());
		List<Chart> list = chartService.chartList(map);
		if(list.isEmpty()){
	         map.put("result", "fail");
	    }else{
	         map.put("result", "success");
	         map.put("list", list);
	         map.put("chart",list.get(0));
	    }
		return map;
	}
	@RequestMapping(value="/post/chart/id",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> setChartId(@RequestBody Chart c,HttpSession session){
		logger.info("ChartController setChartId() {}", "Enter");
		Map<String,String>map=new HashMap<>();
		if(!c.getChartId().equals("")){
			session.setAttribute("storage", c.getChartId());
			map.put("chartResult", "success");
		}else{
			map.put("chartResult", "fail");
		}
		return map;
	}
	
	@RequestMapping(value="/post/chart/image",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Map<?,?> fileUpload(MultipartHttpServletRequest request, HttpSession session)throws Exception{
		logger.info("ChartController fileUpload() {}", "Enter");
		Map<String,Object>map=new HashMap<>();
		Iterator<String>it=request.getFileNames();
		if(it.hasNext()){
			MultipartFile file=request.getFile(it.next());
			logger.info("fileUpload result {}", "success");
			logger.info("upload file: ", file.getOriginalFilename());
			String rootPath=request.getSession().getServletContext().getRealPath("/");
			String uploadPath="resources/img/";
			String filename=file.getOriginalFilename();
			chart.setChartContents(filename);
			chart.setChartId(session.getAttribute("storage").toString());
			logger.info("chart id: {}",session.getAttribute("storage").toString());
			session.invalidate();
			int rs=chartService.registerChartFile(chart);
			if(rs==1){
				File dest=new File(rootPath+uploadPath+filename);
				file.transferTo(dest);
				logger.info("file upload {}","success");
				map.put("result", "success");
			}else{
				logger.info("file upload {}","fail");
				map.put("result", "fail");
			}
		}else{
			map.put("result", "fail");
		}
		return map;
	}
}
