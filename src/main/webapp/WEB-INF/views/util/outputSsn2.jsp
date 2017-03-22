<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<%!
	public String calcSsn(String ssn){
		String gender="";
		switch(ssn.charAt(7)){
		case '1':case '3':
			gender="남자";
			break;
		case '2':case '4':
			gender="여자";
			break;
		case '5':case '6':
			gender="외국인";
			break;
		default:
			gender="잘못된 값";
		}
		return gender;
	}
%>
<%
String ssn=request.getParameter("ssn");
%>
<%= calcSsn(ssn) %>입니다.
</body>
</html>