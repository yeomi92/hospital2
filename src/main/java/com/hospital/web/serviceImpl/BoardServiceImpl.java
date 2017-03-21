package com.hospital.web.serviceImpl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.web.dao.BoardDAO;
import com.hospital.web.domain.ArticleDTO;
import com.hospital.web.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardDAO dao;
	@Autowired ArticleDTO param;
	private List<ArticleDTO> list;
	private int seq;
	
	@Override
	public int addArticle(ArticleDTO param) throws Exception {
		return dao.insertArticle(param);
	}
	@Override
	public ArticleDTO findRecentArticle(ArticleDTO param) throws Exception {
		ArticleDTO article=new ArticleDTO();
		for(int i=0;i<list.size();i++){
			if(i==(list.size()-1)){
				article=list.get(i);
				//list.get(i).setReadCount(String.valueOf((Integer.parseInt((list.get(i).getReadCount()))+1)));
			}
		}
		return article;
	}
	@Override
	public ArticleDTO findBySeq(ArticleDTO param) throws Exception {
		return dao.selectBySeq(param);
	}
	@Override
	public List<ArticleDTO> findSome(String[] param) throws Exception {
		return dao.selectByWord(param);
	}

	@Override
	public List<ArticleDTO> boardList() throws Exception {
		return dao.selectAll();
	}

	@Override
	public int changeContent(ArticleDTO param) throws Exception {
		int rs=0;
		for(ArticleDTO i : list){
			/*if(param.getSeq().equals(i.getSeq())){
				i.setTitle((param.getTitle().equals(""))?i.getTitle():param.getTitle());
				i.setContent((param.getContent().equals(""))?i.getContent():param.getContent());
			}*/
		}
		return rs;
	}

	@Override
	public int removeContent(ArticleDTO param) throws Exception {
		return dao.delete(param);
	}

	@Override
	public int changeSeq(int seq) throws Exception {
		int rs=0;
		for(int i=seq;i<list.size()+1;i++){
			//list.get(i-1).setSeq(String.valueOf(seq));
			seq++;
		}
		this.seq=seq;
		return rs;
	}
}
