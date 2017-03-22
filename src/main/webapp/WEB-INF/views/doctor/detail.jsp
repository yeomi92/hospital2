<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../patient/gnb.jsp"/>
<div id="container" class="width_full_size" style="height: 500px;">
<div class="margin_center text_right" style="width: 380px">
<a href="admin.html" style="background-color: white;color: #31939d;"><b>목록으로</b></a>
</div>
<h3 class="text_center font_border">의사 상세정보</h3>
<table class="table_default margin_center" style="width: 300px">
	<tr class="text_center">
		<td rowspan="4"><img src="${img}/common/profile_img.png" width="85px" height="100px"/></td>
		<td class="bg_color_gray">ID</td>
		<td>${doctor.docID}</td>
	</tr>
	<tr class="text_center">
		<td class="bg_color_gray">소속</td>
		<td>${doctor.majorTreat}</td>
	</tr>
	<tr class="text_center">
		<td class="bg_color_gray">성별</td>                                                                        
		<td>${doctor.docGen}</td>
	</tr>
	<tr class="text_center">
		<td class="bg_color_gray">휴대폰번호</td>
		<td>${doctor.docPhone}</td>
	</tr>
	<tr class="text_center">
		<td><span class="font_bold">${doctor.docName}</span> <span style="font-size: 12px">${doctor.docPosition}</span></td>
		<td class="bg_color_gray">email</td>
		<td>${doctor.docEmail}</td>
	</tr>
</table>
<div style="width:380px;" class="margin_center">
<br>
<table class="margin_center" style="width: 300px">
	<tr>
		<td class="text_center"><a href="" class="font_bold">담당 환자</a></td>
		<td class="text_center"><a href="" class="font_bold">담당 진료</a></td>
		<td class="text_center"><a href="" class="font_bold">담당 차트</a></td>
	</tr>
</table>
</div>
</div>
<jsp:include page="../common/footer.jsp"/>