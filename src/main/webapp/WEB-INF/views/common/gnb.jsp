<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="commonGnb">
	<ul>
		<li><a>홈으로</a></li>
		<li><a href="${context.path}/board.do?action=list&page=articleList&pageNO=1">게시판</a></li>
		<li><a>관리자</a></li>
		<li><a>의사</a></li>
		<li>
			<div>
				<a>병원소개</a>
				<span>구현되지 않았습니다.</span>
			</div>
		</li>
		<li><a>회원 가입</a></li>
		<li><a>로그인</a></li>
	</ul>
</div>
<script>
$(function(){
	var commonGnb=$('#commonGnb');
	commonGnb.addClass('gnb').addClass('width_full_size');
	commonGnb.find('li:nth-child(1)').click(function(){/* 객체.메서드  근데 여기서 메서드의 파라미터로 메서드를 던졌다. 그래서 이 메서드는 객체로 던진 것이다.(일급객체) */
		goPage('${context.path}/home');
	});
	commonGnb.find('li:nth-child(2)').click(function(){/* 콜백함수 */
		goPage('${context.path}/board/list');
	});
	commonGnb.find('li:nth-child(3)').click(function(){
		goPage('${context.path}/admin/login');
	});
	commonGnb.find('li:nth-child(4)').click(function(){
		goPage('${context.path}/doctor/login');
	});
	commonGnb.find('li:nth-child(6)').css('float','right').css('margin-right','45px').click(function(){
		goPage('${context.path}/patient/join');
	});
	commonGnb.find('li:nth-child(7)').css('float','right').click(function(){
		goPage('${context.path}/patient/login');
	});
	commonGnb.find('ul').css('margin','0px');
	commonGnb.find('p>a').addClass('active');
	commonGnb.find('li:nth-child(5)>div').addClass('tooltip');
	commonGnb.find('li:nth-child(5)>div>a').addClass('text_no_underline');
	commonGnb.find('li:nth-child(5)>div>span').addClass('tooltiptext');
	commonGnb.find('ul li a').addClass('text_no_underline').addClass('color_black');
});
</script>