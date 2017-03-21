package com.hospital.web.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.hospital.web.domain.ArticleDTO;

@Component
public interface BoardService {
	//Create
	public int addArticle(ArticleDTO param) throws Exception;
	//Read
	public ArticleDTO findRecentArticle(ArticleDTO param)  throws Exception;//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public ArticleDTO findBySeq(ArticleDTO param)  throws Exception;//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public List<ArticleDTO> findSome(String[] param)  throws Exception;
	public List<ArticleDTO> boardList()  throws Exception;
	//Update
	public int changeContent(ArticleDTO param)  throws Exception;
	//Delete
	public int removeContent(ArticleDTO param)  throws Exception;
	//util
	public int changeSeq(int seq)  throws Exception;
}
