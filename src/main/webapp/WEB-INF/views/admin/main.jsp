<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="../../css/hanbit.css" />
<style>
</style>
</head>
<body>
<div id="wrapper" class="width_full_size">
<div id="header" class="width_full_size" style="height: 100px;position: fixed;height: 68px;z-index: 2; background-color: white;">
	<div class="logo_box width_full_size">
	<img src="../../images/common/index_logo.png"/>
	</div>
	<div class="gnb width_full_size">
	<ul style="margin: 0px;">
		<li><a class="text_no_underline color_black" href="../../index.html">홈으로</a></li>
		<li><a class="text_no_underline color_black" href="../bbs/bbs_list.html">게시판</a></li>
		<li><div class="dropdown">
			<a class="text_no_underline color_black" href="../admin/admin.html">관리자</a>
				<div class="dropdown_content">
				   <p><a class="active" href="../staff/doctors.html">의사</a></p>
				   <p><a class="active" href="../staff/nurses.html">간호사</a></p>
				   <p><a class="active" href="../customer/patients.html">환자</a></p>
				   <p><a class="active" href="../chart/chart_list.html">차트</a></p>
				</div>
			</div>
		</li>
		<li>
			<div class="tooltip">
				<a class="text_no_underline color_black" href="#">병원소개</a>
					<span class="tooltiptext">구현되지 않았습니다.</span>
			</div>
		</li>
		<li style="float:right;margin-right: 45px;"><a class="text_no_underline color_black" href="../common/join.html">회원 가입</a></li>
		<li style="float:right;"><a class="text_no_underline color_black" href="../common/login.html">로그인</a></li>
	</ul>
	</div>
</div>
<div style="height: 87px"></div>
<div id="container" class="width_full_size" style="height: 500px;">
	<ul class="lnb" style="float: left; width: 20%">
	  <li><a class="active" href="../staff/doctors.html">의사</a></li>
	  <li><a href="..//staff/nurses.html">간호사</a></li>
	  <li><a href="#contact">환자</a></li>
	  <li><a href="#about">진료</a></li>
	  <li><a href="../chart/chart_list.html">차트</a></li>
	</ul>
	
	<table class="table_default margin_center table_odd" style="margin-left: 380px;margin-top: 50px;height: 250px;">
			<tr>
				<td colspan="8" class="font_bold text_center" style="background-color: #dac7cf;font-size: 14px;">현 황</td>
			</tr>
			<tr style="background-color: #b1899a;">
				<th>순서</th>
				<th>의사 아이디</th>
				<th>진료과</th>
				<th>의사 이름</th>
				<th>의사 성별</th>
				<th>의사 휴대폰번호</th>
				<th>의사 email</th>
				<th>의사 포지션</th>
			</tr>
			<tr>
				<td class="text_center">1</td>
				<td>980312</td>
				<td>소아과</td>
				<td>이태정</td>
				<td class="text_center">M</td>
				<td>010-333-1340</td>
				<td>ltj@hanbh.com</td>
				<td>과장</td>
			</tr>
			<tr>
				<td class="text_center">2</td>
				<td>000601</td>
				<td>내과</td>
				<td><a href="../staff/staff_detail.html" class="text_no_underline">안성기</a></td>
				<td class="text_center">M</td>
				<td>011-222-0987</td>
				<td>ask@hanbh.com</td>
				<td>과장</td>
			</tr>
			<tr>
				<td class="text_center">3</td>
				<td>001208</td>
				<td>외과</td>
				<td>김민종</td>
				<td class="text_center">M</td>
				<td>010-333-8743</td>
				<td>kmj@hanbh.com</td>
				<td>과장</td>
			</tr>
			<tr>
				<td class="text_center">4</td>
				<td>020403</td>
				<td>피부과</td>
				<td>이태서</td>
				<td class="text_center">M</td>
				<td>019-777-3764</td>
				<td>lts@hanbh.com</td>
				<td>과장</td>
			</tr>
			<tr>
				<td class="text_center">5</td>
				<td>050900</td>
				<td>소아과</td>
				<td>김연아</td>
				<td class="text_center">F</td>
				<td>010-555-3746</td>
				<td>kya@hanbh.com</td>
				<td>전문의</td>
			</tr>
			<tr>
				<td colspan="8" class="text_center font_bold" style=" white;border-color: white;">1  2  3  4  5   ▶</td>
			</tr>
		</table>

</div>
<div id="footer" class="width_full_size" style="height: 100px; border-top:2px solid black;">
	<dl class="notice">
		<dt><a href="/NOTICE" class="h_notice">공지사항</a></dt>
	</dl>
	<dl class="policy">
		<dt>네이버 정책 및 약관</dt>
		<dd class="f"><a href="http://www.navercorp.com/" target="_blank" id="plc.intronhn">회사소개</a></dd>
		<dd><a href="http://mktg.naver.com/" id="plc.adinfo">광고</a></dd>
		<dd><a href="https://submit.naver.com/" id="plc.search">마이비즈니스</a></dd>
		<dd><a href="https://www.navercorp.com/ko/company/proposalGuide.nhn" target="_blank" id="plc.contact">제휴제안</a></dd>
		<dd><a href="rules/service.html" id="plc.service">이용약관</a></dd>
		<dd><a href="rules/privacy.html" id="plc.privacy"><strong>개인정보처리방침</strong></a></dd>
		<dd><a href="rules/youthpolicy.html" id="plc.youth">청소년보호정책</a></dd>
		<dd><a href="rules/spamcheck.html" id="plc.policy">네이버 정책</a></dd>
		<dd><a href="https://help.naver.com/" id="plc.helpcenter">네이버 고객센터</a></dd>
	</dl>
	<address>&copy; <strong><a href="http://www.navercorp.com/" target="_blank">NAVER Corp.</a></strong></address>
</div>
</div>
</body>
</html>