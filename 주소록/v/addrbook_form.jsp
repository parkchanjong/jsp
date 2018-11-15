<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H2>AddressBook::New Entry</H2>
<HR>
<a href="javascript:history.go(-1)">Back to List</a> <P>
<form name=form1 method=post action="/javaweb/addrbook">
<input type=hidden name="action" value="insert">
<div>
	<label for="ab_name">Name:</label>	
  	<input type="text" name="ab_name">
</div>

<div>
  	<label for="ab_email">Email:</label>
    <input type="email" name="ab_email">		//엔티티폼이랑 맞춰줘야 된다
</div>

<div>
	<label for="ab_tel">CellPhone:</label>
    <input type="text"  name="ab_tel">
</div>

<div>
	<label for="ab_birth">Birth Date:</label>
    <input type="date" name="ab_birth">
</div>

<div>
	<label for="ab_comdept">Company:</label>
	<input type="text" name="ab_comdept">
</div>
<div>
	<label for="ab_memo">Memo:</label>
	<input type="text" name="ab_memo">
</div>
	<button type="submit">Save</button>
	<button type="reset">Cancel</button>
</form>

</body>
</html>