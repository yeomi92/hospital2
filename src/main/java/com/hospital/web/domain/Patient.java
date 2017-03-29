package com.hospital.web.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import lombok.Data;
import lombok.ToString;

@Qualifier("patient") @Lazy @Data @ToString
public class Patient extends Info{ 
	private String job,jumin,addr,nurID,docID;
	private Doctor doctor;
	private Nurse nurse;
	@Override
	public String getGroup() {
		return "Patient";
	}
}
