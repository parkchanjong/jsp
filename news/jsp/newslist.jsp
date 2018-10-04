<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News Desk</title>
</head>
   <body>
   <div>
    <h2>News List</h2>
    <hr>
    <ul>
		<c:forEach var="i" items="${newslist}" varStatus="status">
		  <li>
		  <a href="news.nhn?action=view&aid=${i.aid}">
		  [${status.count}] ${i.title}, ${i.date}</a>
		</c:forEach>
	</ul>
	</div>
</body>
</html>