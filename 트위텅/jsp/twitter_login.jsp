<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>


<title>트위터 로그인</title>

</head>

<body>
<div class="container mx-auto m-5 p-5 bg-info w-50 shadow">			<!-- 마진 5 패딩 5 백그라운드-info-->

<h2>트위터 :: 로그인</h2>

<form action="/twitter" method="post">
	<input type="hidden" name="action" value="login" />
<div class="input-group">
	<input type="text" class="form-control" name="username" placeholder="로그인 아이디" />
	<input type="submit" class="btn btn-warning" value=login />
</form>
</div>
</div>


</body>
</html>