package com.hospital.web.imapper;

import java.sql.SQLException;
import org.springframework.stereotype.Component;
import com.hospital.web.domain.PatientDTO;

@Component
public interface IPatientMapper {
	public int insert(PatientDTO member)throws SQLException;
	public PatientDTO selectById(String uid)throws SQLException;
	public boolean login(PatientDTO member)throws SQLException;
	public int update(PatientDTO[] member)throws SQLException;
	public int delete(PatientDTO member)throws SQLException;
	public int count();
	public int exist(String id) throws Exception;
}
