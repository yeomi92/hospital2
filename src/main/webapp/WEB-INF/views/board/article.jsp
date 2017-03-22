<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/gnb.jsp"/>
<div style="height: 140px;"></div>
<div id="container">
	<div>
		<table id="article">
			<tr>
				<td colspan="4">${article.title}</td>
			</tr>
			<tr>
				<td colspan="2">작성자:${article.id}</td>
				<td>작성일: ${article.regdate}</td>
				<td>조회수: ${article.readCount}</td>
			</tr>
			<tr>
				<td colspan="4">${article.content}</td>
			</tr>
		</table>
		<a href="${context}/board.do?action=list&page=articleList">목록으로</a>
	</div>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>
	var $article=$('#article');
	$('#container').addClass('width_full_size').css('height','300px');
	$('#container').find('div').addClass('margin_center').css('width','500px').css('height','180px');
	$article.addClass('table_default').addClasee('margin_center').css('width','500px').css('height','180px');
</script>