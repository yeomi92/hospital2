package com.hospital.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component @Data
public class Chart {
	private String charID,treatID,docID,patID,nurID,chartContents;
}
