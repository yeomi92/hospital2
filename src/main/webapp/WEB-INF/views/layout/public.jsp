<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title><tiles:getAsString name="title"/></title>
	<link rel="stylesheet" type="text/css" href="${context}/resources/css/hanbit.css" />
	<script src="${context}/resources/js/jquery-3.1.1.js"></script>
	<script src="${context}/resources/js/hospital.js"></script>
</head>
<body>
	<header>
		<div id="publicHeader">
			<tiles:insertAttribute name="header"/>
		</div>
	</header>
	<section>
		<article id="publicGnb">
			<tiles:insertAttribute name="gnb"/>
		</article>
		<article id="publicArticle">
			<tiles:insertAttribute name="container"/>
		</article>
	</section>
	<footer>
		<tiles:insertAttribute name="footer"/>
	</footer>
</body>
</html>