package com.hospital.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component @Data
public class Context {
	private String path,js,css,img;
}
