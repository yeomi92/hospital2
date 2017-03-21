package com.hospital.web.dao;

import java.sql.SQLException;
import com.hospital.web.domain.DoctorDTO;

public interface DoctorDAO {
	public int insert(DoctorDTO member)throws SQLException;
	public DoctorDTO selectById(DoctorDTO member)throws SQLException;
	public boolean login(DoctorDTO member)throws SQLException;
	public int update(DoctorDTO[] member)throws SQLException;
	public int delete(DoctorDTO member)throws SQLException;
}
