<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 액션</title>
</head>
<body>
<h2>인클루드 액션에서 풋터 호출</h2>
인클루드에서 호출한 메시지<br>
<jsp:include page="footer.jsp">
	<jsp:param name="email" value="sdfasdf" />
	<jsp:param name="tel" value="sdfassdfasdfsdfdf" />
</jsp:include>
</body>
</html>