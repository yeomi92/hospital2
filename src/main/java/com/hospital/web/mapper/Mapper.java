package com.hospital.web.mapper;

import java.sql.SQLException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hospital.web.domain.Patient;

@Repository
public interface Mapper {
	public int insert(Patient member)throws SQLException;
	public Patient selectById(String uid)throws SQLException;
	public boolean login(Patient member)throws SQLException;
	public int update(Patient[] member)throws SQLException;
	public int delete(Patient member)throws SQLException;
	public int count();
	public int exist(String id) throws Exception;
}
