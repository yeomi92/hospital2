package com.hospital.web.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hospital.web.domain.Article;
@Repository
public interface BoardMapper {
	//Create
		public int insertArticle(Article param) throws Exception;
		//Read
		public Article selectBySeq(Article param) throws Exception;//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
		public List<Article> selectByWord(String[] param)  throws Exception;
		public List<Article> selectAll() throws Exception;;
		//Update
		public int update(Article param) throws Exception;
		//Delete
		public int delete(Article param) throws Exception;
}
