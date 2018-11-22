<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html" %>		
<title>New Entry</title>
</head>

<body>
<div class="container mx-auto mt-5 p-5 shadow" style="width: 50%">
<H2>AddressBook::New Entry</H2>
<HR>
<a href="javascript:history.go(-1)"  class="btn btn-info">Back to List</a> <P>
<form name=form1 method=post action="/javaweb/addrbook">
<input type=hidden name="action" value="insert">

<div class="form-group">
	<label for="ab_name">Name:</label>	
  	<input type="text" class="form-control" name="ab_name">
</div>
<div class="form-group">
  	<label for="ab_email">Email:</label>
    <input type="email" class="form-control" name="ab_email">
</div>

<div class="form-group">
	<label for="ab_tel">CellPhone:</label>
    <input type="text" class="form-control" name="ab_tel">
	<label for="ab_birth">Birth Date:</label>
    <input type="date" class="form-control" name="ab_birth">
</div>

<div class="form-group">
	<label for="ab_comdept">Company:</label>
	<input type="text" class="form-control" name="ab_comdept">
	<label for="ab_memo">Memo:</label>
	<input type="text" class="form-control" name="ab_memo">
</div>

<button type="submit" class="btn btn-primary">Save</button>
<button type="reset" class="btn btn-warning">Cancel</button>
</form>

</div>
</body>
</html>