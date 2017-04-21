package com.hospital.web.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hospital.web.domain.Article;
import com.hospital.web.mapper.Mapper;

@Service
public class BoardService {
	private static final Logger logger=LoggerFactory.getLogger(BoardService.class);
	@Autowired Mapper mapper;
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Article> boardList()throws Exception{
		logger.info("BoardService boardList() {}","enter");
		IGetService service=(map)->mapper.boardList();
		List<Article>list=(List<Article>) service.execute(null);
		logger.info("BoardService boardList()의 list: {}",list);
		return list;
	}
}
