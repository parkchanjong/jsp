<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>
<title>이벤트 웹</title>

</head>

<body>

<div class="container mx-auto m-5 bg-light shadow">			

<h2>이벤트 레지스터 폼</h2>
<hr>
<form method="post" action="/javaweb/event">
이름: <input type="text" name="name">
이메일: <input type="email" name="email">
<input type="submit" value="Register">
</form>
<hr>
</div>

<div class="container mx-auto mt-5 p-5 bg-warning">
<h2>레지스트 리스트</h2>	
</div>



</body>
</html>