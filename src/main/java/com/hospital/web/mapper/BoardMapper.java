package com.hospital.web.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.hospital.web.domain.ArticleDTO;
import com.hospital.web.imapper.IBoardMapper;

@Repository
public class BoardMapper implements IBoardMapper{
	@Override
	public int insertArticle(ArticleDTO param) throws Exception {
		String sql=String.format("INSERT INTO Article(art_seq,id,title,content,regdate,read_count)VALUES(art_seq.nextval,'%s','%s','%s','%s','0')");
		return 0;
	}

	@Override
	public ArticleDTO selectBySeq(ArticleDTO param) throws Exception {
		ArticleDTO temp=null;
		String sql=String.format("SELECT art_seq,id,title,content,regdate,read_count FROM ARTICLE WHERE art_seq='%s'");
		return temp;
	}

	@Override
	public List<ArticleDTO> selectByWord(String[] param) throws Exception {
		List<ArticleDTO> list=new ArrayList<ArticleDTO>();
		ArticleDTO temp=null;
		return list;
	}

	@Override
	public List<ArticleDTO> selectAll() throws Exception {
		ArticleDTO temp=null;
		List<ArticleDTO> list=new ArrayList<ArticleDTO>();
		return list;
	}

	@Override
	public int update(ArticleDTO param) throws Exception {
		return 0;
	}

	@Override
	public int delete(ArticleDTO param) throws Exception {
		String sql=String.format("DELETE FROM article WHERER art_seq='%s'");
		return 0;
	}
}
