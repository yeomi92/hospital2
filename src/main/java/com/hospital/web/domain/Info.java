package com.hospital.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component @Lazy @Data
public abstract class Info {
	protected String id,pass,name,gen,phone,email;
	public abstract String getGroup();
}
