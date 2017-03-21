package com.hospital.web.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.hospital.web.domain.DoctorDTO;

@Component
public interface DoctorService {
	public int join(DoctorDTO member) throws SQLException ;
	public DoctorDTO findById(DoctorDTO member) throws SQLException ;
	public DoctorDTO login(DoctorDTO member) throws SQLException ;
	public int change(DoctorDTO member) throws SQLException ;
	public int remove(DoctorDTO member) throws SQLException ;
	//util
	public String[] getBirth(String jumin);
	public DoctorDTO getSession();
}
