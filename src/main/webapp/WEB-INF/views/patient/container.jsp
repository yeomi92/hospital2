<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="height: 100px;"></div>
<div id="container" class="width_full_size" style="height: 200px;">
	<form action="<%= application.getContextPath() %>/login.do" style="width: 20%;" class="margin_center">
		<table class="table_default margin_center" style="width: 500px;height: 90px">
			<tr>
				<th>순서</th>
				<th>진료일</th>
				<th>진료NO</th>
				<th>담당의사</th>
				<th>직책</th>
				<th>진료과목</th>
				<th>병명</th>
				<th>처방내역</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../common/footer.jsp"/>