package com.hospital.web.mapper;

import java.sql.SQLException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hospital.web.domain.Doctor;

@Repository
public interface DoctorMapper {
	public int insert(Doctor member)throws SQLException;
	public Doctor selectById(Doctor member)throws SQLException;
	public boolean login(Doctor member)throws SQLException;
	public int update(Doctor[] member)throws SQLException;
	public int delete(Doctor member)throws SQLException;
}
