package com.hospital.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.web.domain.Article;
import com.hospital.web.mapper.Mapper;
import com.hospital.web.service.BoardService;

@RestController
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired Mapper mapper;
	@Autowired Article article;
	@Autowired BoardService boardService;
	@RequestMapping(value="/list/bbs/{pageNo}")
	private @ResponseBody Map<?,?> getArticle(@PathVariable String pageNo) throws Exception{
		logger.info("BoardController goBoard진입 {}","OK");
		logger.info("pageNo {}",pageNo);
		List<Article>list=new ArrayList<>();
		Map<String, Object>map=new HashMap<>();
		list=boardService.boardList();
		map.put("list",list);
		map.put("count", list.size());
		return map;
	}
	@RequestMapping(value="/find")
	public String find(@RequestParam(value="search",required=false)String search,@RequestParam(value="search",defaultValue="1")String pageNO){
		logger.info("BoardController find진입 {}","OK");
		return "public:board/containerList";
	}
}
