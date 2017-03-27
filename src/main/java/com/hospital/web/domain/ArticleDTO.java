package com.hospital.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component @Data
public class ArticleDTO {
	@Getter @Setter
	private String seq,id,title,content,regdate,readCount;
	
	@Override
	public String toString() {
		return String.format("[ %s | %s | %s | %s | %s | %s ]\n", seq,id,title,content,readCount,regdate);
	}
}
