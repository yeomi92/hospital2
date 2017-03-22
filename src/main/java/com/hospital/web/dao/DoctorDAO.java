package com.hospital.web.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.hospital.web.domain.DoctorDTO;
@Component
public interface DoctorDAO {
	public int insert(DoctorDTO member)throws SQLException;
	public DoctorDTO selectById(DoctorDTO member)throws SQLException;
	public boolean login(DoctorDTO member)throws SQLException;
	public int update(DoctorDTO[] member)throws SQLException;
	public int delete(DoctorDTO member)throws SQLException;
}
