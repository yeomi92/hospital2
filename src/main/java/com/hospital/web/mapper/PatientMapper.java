package com.hospital.web.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hospital.web.domain.PatientDTO;
import com.hospital.web.imapper.IPatientMapper;

@Repository
public class PatientMapper implements IPatientMapper{
	private static final Logger logger = LoggerFactory.getLogger(PatientMapper.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	String namespace="com.hospital.web.mapper.PatientMapper";
	@Override
	public int insert(PatientDTO patient){
		logger.info("PatientMapperImpl insert진입 {}", "OK");
		return 0;
	}
	
	@Override
	public PatientDTO selectById(String id){
		logger.info("PatientMapperImpl selectById진입 {}", "OK");
		return sqlSession.selectOne(namespace+".selectById",id);
	}
	
	@Override
	public boolean login(PatientDTO patient){
		logger.info("PatientMapperImpl login진입 {}", "OK");
		boolean loginch=false;
		return loginch;
	}
	
	@Override
	public int update(PatientDTO[] patient){
		logger.info("PatientMapperImpl update진입 {}", "OK");
		return 0;
	}
	
	@Override
	public int delete(PatientDTO patient){
		logger.info("PatientMapperImpl delete진입 {}", "OK");
		String sql="";
		return 0;
	}
}
