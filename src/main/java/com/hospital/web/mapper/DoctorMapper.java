package com.hospital.web.mapper;

import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.hospital.web.domain.DoctorDTO;
import com.hospital.web.imapper.IDoctorMapper;

@Repository
public class DoctorMapper implements IDoctorMapper{
	@Override
	public int insert(DoctorDTO member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DoctorDTO selectById(DoctorDTO member) throws SQLException {
		DoctorDTO temp=new DoctorDTO();
		return temp;
	}

	@Override
	public boolean login(DoctorDTO member) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(DoctorDTO[] member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DoctorDTO member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
