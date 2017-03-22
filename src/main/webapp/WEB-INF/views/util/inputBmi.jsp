<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="../../css/hanbit.css" />
</head>
<body>
<div style="width: 90%; margin-top: 100px">
<form action="/hanbitee/JSP/util/outputBmi.jsp" class="border_solid margin_center" style="width: 300px; padding: 10px;">
나이: <input type="text" name="age" size="10"/><br>
몸무게: <input type="text" name="weight" size="10"/><br>
키: <input type="text" name="height" size="10"/><br>
<input type="submit" value="전송">
</form>
</div>
</body>
</html>