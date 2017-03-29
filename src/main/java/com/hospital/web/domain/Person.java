package com.hospital.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component @Data
public class Person<T extends Info> {
	public T info;
	public Person(T info){
		this.info=info;
	}
}
