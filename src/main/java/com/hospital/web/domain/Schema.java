package com.hospital.web.domain;

public enum Schema {
	PATIENT("pat_id"),DOCTOR("doc_id"),NURSE("nur_id"),ADMIN("id");
	private String name;
	private Schema(String val) {
		this.name=val;
	}
	public String getName(){
		return name;
	}
	

}
