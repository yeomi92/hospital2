<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/gnb.jsp"/>
<div id="container">
	<form id="registerForm">
		<table>
			<tr>
				<td>
					<font size="2">담당의사&담당간호사</font>
					<select name="doctor">
						<option value="" selected>의사 선택</option>
						<option value="dlee">이태정(소아과)</option>
						<option value="dahn">안성기(내과)</option>
						<option value="dkim">김민종(외과)</option>
						<option value="dlee2">이태서(피부과)</option>
					</select>
					<select name="nurse">
						<option value="" selected>간호사 선택</option>
						<option value="nkim">김은영(소아과)</option>
						<option value="nyoon">윤성애(내과)</option>
						<option value="nshin">신지원(피부과)</option>
						<option value="nyou">유정화(방사선과)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">아이디</font>
					<input type="text" name="id" placeholder="아이디"/>
					<input type="button" value="중복확인"/>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">이름</font>
					<input type="text" name="name" placeholder="이름"/>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">email</font>
					<input type="text" name="email" placeholder="이메일"/>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">비밀번호</font>
					<input type="text" name="password" placeholder="비밀번호"/>
					<font size="2">비밀번호 확인</font>
					<input type="text" name="ckPassword" placeholder="비밀번호 확인"/>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">주소</font>
					<input type="text" name="addr" placeholder="address"/>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">생년월일</font>
					<select name="year">
						<option value="" selected>생년 선택</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
						<option value="1995">1995</option>
						<option value="1996">1996</option>
						<option value="1997">1997</option>
						<option value="1998">1998</option>
						<option value="1999">1999</option>
						<option value="2000">2000</option>
						<option value="2001">2001</option>
					</select>
					<select name="month">
						<option value="" selected>월 선택</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
					<select name="date">
						<option value="" selected>일 선택</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">휴대폰 번호</font><br/>
					<select name="telecom">
						<option value="" selected>통신사 선택</option>
						<option value="SKT">SKT</option>
						<option value="KT">KT</option>
						<option value="LGU+">LGU+</option>
					</select><br/>
					<select name="phoneNo1">
						<option value="" selected>번호 선택</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
					</select>
				  - <input type="text" name="phoneNo2"/>
				  - <input type="text" name="phoneNo3"/>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">
						<font size="2">직업</font><br/>
						<input type="checkbox" name="job" value="employee"/>회사원
						<input type="checkbox" name="job" value="developer"/>개발자<br/>
						<input type="checkbox" name="job" value="staff"/>스탭
						<input type="checkbox" name="job" value="doctor"/>의사
						<input type="checkbox" name="job" value="nurse"/>간호사
						<input type="checkbox" name="job" value="admin"/>관리자
					</font>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">
						<font size="2">성별</font>
						<input type="radio" name="gender" value="M" checked="checked"/>남자
						<input type="radio" name="gender" value="F"/>여자
					</font>
				</td>
			</tr>
		</table>
		<input type="hidden" name="action" value="register" />
		<input type="hidden" name="page" value="loginForm" />
		<input type="button" name="test" value="이전"/>
		<input type="submit" name="register" value="다음"/>
	</form>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>
$(function(){
	var $registerForm=$('#registerForm');
	var tab=$registerForm.find('table');
	$('input[name=register]').click(function(){
		$registerForm.attr('action','${context}/patient.do');
		$registerForm.attr('method','post');
		alert('전송직전');
		$registerForm.submit();
	});
	
	
	$('#container').addClass('width_full_size');
	$registerForm.add('margin_center').css('width','40%');
	tab.addClass('table_default');
	tab.find('tr:nth-child(1) p:nth-child(1)').addClass('color_blue');
	tab.find('select').addClass('join_select');
	tab.find('tr:nth-child(4) input').css('width','80px').css('height','14px');
	tab.find('tr:nth-child(6) span').addClass('font_bold');
	tab.find('tr:nth-child(7) td').addClass('color_blue');
	$registerForm.find('table~input:nth-child(3)').addClass('color_white').css('background-color','#ff0000').css('width','500px');
	$registerForm.find('table~input:nth-child(4)').addClass('color_white').css('background-color','#3c70c5').css('width','200px');	
});
</script>