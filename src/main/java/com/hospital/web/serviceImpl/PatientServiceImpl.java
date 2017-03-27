package com.hospital.web.serviceImpl;

import java.sql.SQLException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.web.daoImpl.PatientDAOImpl;
import com.hospital.web.domain.PatientDTO;
import com.hospital.web.mapper.PatientMapper;
import com.hospital.web.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
	@Autowired PatientMapper mapper;

	
	@Override
	public int join(PatientDTO member) throws SQLException {
		logger.info("PatientServiceImpl join() {}","OK");
		return mapper.insert(member);
	}

	@Override
	public PatientDTO findById(String uid) throws SQLException {
		logger.info("PatientServiceImpl findById() {}","OK");
		return mapper.selectById(uid);
	}

	@Override
	public PatientDTO login(PatientDTO member) throws SQLException {
		logger.info("PatientServiceImpl login() {}","OK");
		return mapper.selectById(member.getPatID());
	}

	@Override
	public int change(PatientDTO member) throws SQLException {
		logger.info("PatientServiceImpl change() {}","OK");
		PatientDTO[] memArr=new PatientDTO[2];
		memArr[0]=member;
		memArr[1]=member;		
		System.out.println("serviceImp session"+memArr[1]);
		return mapper.update(memArr);
	}

	@Override
	public int remove(PatientDTO member) throws SQLException {
		logger.info("PatientServiceImpl remove() {}","OK");
		PatientDTO bean=new PatientDTO();
		return mapper.delete(bean);
	}
	
	@Override
	public String[] getBirth(String jumin) {
		logger.info("PatientServiceImpl getBirth() {}","OK");
		String[] birth=new String[2];
		int ssn=Integer.parseInt(jumin.substring(0,2));
		switch(jumin.charAt(7)){
			case '1':case '2':
				birth[0]=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-(1900+ssn)+1)+"¼¼";
				birth[1]="19"+jumin.substring(0,2)+"³â"+jumin.substring(2,4)+"¿ù"+jumin.substring(4,6)+"ÀÏ";
				break;
			case '3':case '4':
				birth[0]=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-(2000+ssn)+1)+"¼¼";
				birth[1]="20"+jumin.substring(0,2)+"³â"+jumin.substring(2,4)+"¿ù"+jumin.substring(4,6)+"ÀÏ";
				break;
		}
		return birth;
	}

	@Override
	public PatientDTO getSession() {
		logger.info("PatientServiceImpl getSession() {}","OK");
		// TODO Auto-generated method stub
		return null;
	}
}
