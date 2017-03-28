package com.hospital.web.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.hospital.web.domain.ArticleDTO;
import com.hospital.web.domain.PatientDTO;

@Component
public interface PatientService {
	public int join(PatientDTO member) throws SQLException ;
	public PatientDTO findById(String uid) throws SQLException ;
	public PatientDTO login(PatientDTO member) throws SQLException ;
	public int change(PatientDTO member) throws SQLException ;
	public int remove(PatientDTO member) throws SQLException ;
	//util
	public int count();
	public String[] getBirth(String jumin);
	public PatientDTO getSession();
}
