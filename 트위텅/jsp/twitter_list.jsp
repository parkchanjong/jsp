<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>
<title>트위터 리스트</title>

</head>

<body>

<div class="container mx-auto m-5 p-5 bg-wite w-60 shadow">			

<h2>내 심플 트위터</h2>
<hr>
<form method="post" action="/twitter">
<input type="hidden" name="action" value="">
<div class="input-group w-75">
	<button type="button" class="btn btn-outline-success">@${user }</button>&nbsp;
	<input type="text" class="form-control" name="msg" />
	<input type="submit" class="btn btn-warning" value="Tweet" />&nbsp;
	<a href="/twitter" class="btn btn-secondary">로그아웃</a>
</form>
</div>
<hr>

<div>

<ul class="list-group">

<c:forEach var="msg" items="${msgs}">
	<li class="list-group-item list-group-item-action">${msg}</li>
</c:forEach>
</ul>


</div>

</div>


</body>
</html>