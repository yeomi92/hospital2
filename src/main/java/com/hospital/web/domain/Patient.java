package com.hospital.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component @Lazy @Data
public class Patient extends Info{ 
	private String job,jumin,addr,nurID,docID;
	private Doctor doctor;
	private Nurse nurse;
	@Override
	public String getGroup() {
		return "Patient";
	}
}
