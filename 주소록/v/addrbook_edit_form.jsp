<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>
<meta charset="UTF-8">
<title>AddressBook::Update</title>
</head>
<body>
<H2>AddressBook::Update</H2>
<HR>
<a href="javascript:history.go(-1)">Back to List</a> <P>
<form name=form1 method=post action="/javaweb/addrbook">
<input type=hidden name="action" value="update">
<div>
	<label for="ab_name">Name:</label>	
  	<input type="text" name="ab_name" value="${ab.ab_name}">
</div>

<div>
  	<label for="ab_email">Email:</label>
    <input type="email" name="ab_email" value="${ab.ab_email}">
</div>

<div>
	<label for="ab_tel">CellPhone:</label>
    <input type="text"  name="ab_tel" value="${ab.ab_tel}">
</div>

<div>
	<label for="ab_birth">Birth Date:</label>
    <input type="date" name="ab_birth" value="${ab.ab_birth}">
</div>

<div>
	<label for="ab_comdept">Company:</label>
	<input type="text" name="ab_comdept" value="${ab.ab_comdept}">
</div>
<div>
	<label for="ab_memo">Memo:</label>
	<input type="text" name="ab_memo" value="${ab.ab_memo}">
</div>
	<button type="submit">Update</button>
	<button>Delete</button>
</form>

</body>
</html>