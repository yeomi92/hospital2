package com.hospital.web.serviceImpl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.web.dao.DoctorDAO;
import com.hospital.web.domain.DoctorDTO;
import com.hospital.web.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired DoctorDAO dao;
	@Override
	public int join(DoctorDTO member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DoctorDTO findById(DoctorDTO member) throws SQLException {
		return dao.selectById(member);
	}

	@Override
	public DoctorDTO login(DoctorDTO member) throws SQLException {
		
		return null;
	}

	@Override
	public int change(DoctorDTO member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(DoctorDTO member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getBirth(String jumin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO getSession() {
		// TODO Auto-generated method stub
		return null;
	}
}
