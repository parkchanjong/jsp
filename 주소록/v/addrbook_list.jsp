<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>
<meta charset="UTF-8">
<title>AddressBook List</title>
</head>
<body>
<H2>AddressBook::List</H2>
<HR>
<a href="addrbook/addrbook_form.jsp">New Entry</a>
<p>
<table border=1>
	<thead>
		<tr>
			<th>#No</th>
			<th>Name</th>
			<th>Email</th>
			<th>CellPhone</th>
			<th>Birth Date</th>
			<th>Company</th>
			<th>Memo</th>
		</tr>
	</thead>
		<c:forEach items="${datas}" var="ab">	
		<tr>
			<td><a href="/javaweb/addrbook?action=edit&ab_id=${ab.ab_id}">${ab.ab_id}</a></td>
			<td>${ab.ab_name}</td>
			<td>${ab.ab_email}</td>
			<td>${ab.ab_tel}</td>
			<td>${ab.ab_birth}</td>
			<td>${ab.ab_comdept}</td>
			<td>${ab.ab_memo}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>