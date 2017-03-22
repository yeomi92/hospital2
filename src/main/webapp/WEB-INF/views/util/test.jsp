<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	public int multiply(int a, int b){
	int c=a*b;
	return c;
	}
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<% 
	int sum=0;
	for(int i=0;i<10;i++){
		sum+=i;
	}
%>
sum: <%= sum %>
10*2= <%= multiply(10,2) %>
</body>
</html>