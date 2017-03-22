<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/gnb.jsp"/>
<div id="divContainer"></div>
<div id="container">
	<form id="loginForm">
		<table>
			<tr>
				<td colspan="3">
					<span>로그인 또는
						<a href="join.html">
							<span>회원가입</span>
						</a>
					</span>
				</td>
			</tr>
			<tr>
				<td colspan="3">아이디</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="text" placeholder="아이디" name="id"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">비밀번호</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="password" placeholder="비밀번호" name="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">비밀번호가 기억나지 않으세요?</td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="login" />
		<input type="hidden" name="page" value="main" />
		<input type="submit" value="로그인"/>
	</form>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>
$(function(){
	var $loginForm=$('#loginForm');
	var tab=$loginForm.find('table');
	$loginForm.addClass('margin_center').css('width','20%');
	$('#divContainer').css('height','100px');
	$('#container').addClass('width_full_size').css('height','200px');
	tab.find('tr:nth-child(1)>td>span').css('font-size','20px');
	tab.find('tr:nth-child(1) a').css('text-decoration','none').css('line-height','inherit');
	tab.find('tr:nth-child(1) a>span').css('color','#254391');
	tab.find('tr:nth-child(2) td').addClass('font_bold').css('font-size','10px');
	tab.find('tr:nth-child(3) input').addClass('width_full_size').css('font-size','10px').css('padding','4px');
	tab.find('tr:nth-child(4) td').addClass('font_bold').css('font-size','10px');
	tab.find('tr:nth-child(5) input').addClass('width_full_size').css('font-size','10px').css('padding','4px');
	tab.find('tr:nth-child(5) td:nth-child(1)').css('font-size','10px').css('color','#254391');
	tab.find('tr:nth-child(5) td:nth-child(2)').css('height','20px').css('color','#254391');
	$('#loginForm input[value=로그인]').click(function(event){
		$loginForm.attr("action","${context}/patient.do");
		$loginForm.attr("method","post");
		var idVal=tab.find('input[name=id]').val();
		var pwVal=tab.find('input[name=password]').val();
		if(idVal==''||pwVal==''){
			alert('값을 먼저 입력해주세요');
		}else{
			alert('아이디는 '+idVal+', pw는 '+pwVal);
			loginForm.submit();
		}
	});
});
</script>