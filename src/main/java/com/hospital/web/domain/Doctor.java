package com.hospital.web.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import lombok.Data;

@Qualifier("doctor") @Lazy @Data
public class Doctor extends Info{
	private String major,position;
	@Override
	public String getGroup() {
		return "Doctor";
	}
}
