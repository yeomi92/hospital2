package com.hospital.web.imapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hospital.web.domain.ArticleDTO;
@Component
public interface IBoardMapper {
	//Create
		public int insertArticle(ArticleDTO param) throws Exception;
		//Read
		public ArticleDTO selectBySeq(ArticleDTO param) throws Exception;//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
		public List<ArticleDTO> selectByWord(String[] param)  throws Exception;
		public List<ArticleDTO> selectAll() throws Exception;;
		//Update
		public int update(ArticleDTO param) throws Exception;
		//Delete
		public int delete(ArticleDTO param) throws Exception;
}
