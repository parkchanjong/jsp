<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>    
<html>
<head>
<%@ include file="inc_header.html" %>
<title>twitter_login.jsp</title>
</head>
<body>
<div class="container mx-auto m-5 p-5  w-50 shadow bg-info">
	<H2>Twitter::Login</H2>
	<form name="form1" method="post" action="/javaweb/twitter">
		<input type="hidden" name="action" value="login" />
		<div class="input-group">
		<input class="form-control" type="text" name="username" placeholder="login id"/>
		<input class="btn btn-warning" type="submit" value="Login"/>
		</div>
	</form>
</div>
</body>
</html>