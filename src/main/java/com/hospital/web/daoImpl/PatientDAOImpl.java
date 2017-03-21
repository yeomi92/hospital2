package com.hospital.web.daoImpl;

import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.hospital.web.dao.PatientDAO;
import com.hospital.web.domain.PatientDTO;

@Repository
public class PatientDAOImpl implements PatientDAO {
	@Override
	public int insert(PatientDTO patient) throws SQLException {
		return 0;
	}
	
	@Override
	public PatientDTO selectById(String uid) throws SQLException {
		PatientDTO temp=new PatientDTO();
		return temp;
	}
	
	@Override
	public boolean login(PatientDTO patient) throws SQLException {
		boolean loginch=false;
		return loginch;
	}
	
	@Override
	public int update(PatientDTO[] patient) throws SQLException {
		return 0;
	}
	
	@Override
	public int delete(PatientDTO patient) throws SQLException{
		String sql="";
		return 0;
	}
}
