<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/gnb.jsp"/>
<div id="container">
	<div>
		<form action="articleSome.jsp">
			<select name="property" name="property">
			    <option value="id">작성자</option>
			    <option value="title">제목</option>
			</select>
			<input type="text" name="searchKeyword"/>
			<input type="submit" value="검색"/>
		</form>
	<table id="articleList">
		<tr>
			<td>총게시글수: ${requestScope.count}</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="article" items="${requestScope.list}">
			<tr>
				<td>${article.seq}</td>
				<td><a href="${context}/board.do?action=detail&page=article&seq=${article.seq}">${article.title}</a></td>
				<td>${article.id}</td>
				<td>${article.regdate}</td>
				<td>${article.readCount}</td>
			</tr>
		</c:forEach>
	</table>
	<nav id="pagination">
		<ul>
		<c:if test="${requestScope.prevBlock gt 0}">
			<a href="${context}/board.do?action=list&page=articleList&pageNO=${requestScope.prevBlock}">◀prev</a>
		</c:if>
			<c:forEach begin="${requestScope.blockStart}" end="${requestScope.blockEnd}" step="1" varStatus="i">
				<li>
					<c:choose>
						<c:when test="${i.index eq pageNO}">
							<a href="#"><font>${i.index}</font></a>
						</c:when>
						<c:otherwise>
							<a href="${context}/board.do?action=list&page=articleList&pageNO=${i.index}">${i.index}</a>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
			<c:if test="${requestScope.nextBlock le pageCount}">
				<a href="${context}/board.do?action=list&page=articleList&pageNO=${requestScope.nextBlock}">next▶</a>
			</c:if>
		</ul>
	</nav>
	</div>
	</div>
<jsp:include page="../common/footer.jsp"/>
<script>
$(function(){
	var $articleList=$('#articleList');
	var $pagination=$('#pagination');
	$('#container').addClass('width_full_size');
	$('#container>div').addClass('margin_center').css('width','500px');
	$articleList.addClass('table_default').addClass('margin_center').css('width','500px').css('height','180px');
	$pagination.css('"width','500px').css('margin','0 auto').css('text-align','center');
	$pagination.find('a').css('text-decoration','none');
	$pagination.find('li').css('text-align','center').css('width','38px').css('display','inline');
	$pagination.find('font').css('color','red');
	
})
</script>