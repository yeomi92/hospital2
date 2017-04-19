package com.hospital.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component @Data
public class Chart {
	private String patientId,doctorId,nurseId,pass,name,gen,jumin,addr,phone,email,job,chartId,treatmentId,chartContents,doctorMajor,doctorName,doctorPosition,nursePosition,treatContents,treatDate;
}
