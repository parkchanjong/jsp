<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>
<title>Event Web</title>
</head>
<body>
<div class="container mx-auto mt-5 shadow bg-light">
<H2>Event Register Form</H2>
<HR>
<form method="post" action="/javaweb/event">
Name: <input type="text" name="name">
Email: <input type="email" name="email">
<input type="submit" value="Register">
</form>
<hr>
</div>

<div class="container mx-auto mt-5 p-5 shadow bg-warning">
<H2>Registered List</H2>
<hr>
<ul>
<c:forEach var="event" items="${eventlist}">			<!-- 목록 보여주는 것 -->
	<li class="list-group-item list-group-item-action">${event.name}, ${event.email}</li>  <!--이벤트 이름 과 이벤트 이메일 찍어줌  -->
</c:forEach>
</ul>
</div>
</body>
</html>