package com.hospital.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component @Lazy @Data
public class Person<T extends Info> {
	public T info;
	public Person(T info){
		this.info=info;
	}
}
