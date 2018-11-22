<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="inc_header.html" %>

	<script type="text/javascript">
		function delcheck() {
			result = confirm("Do you really want to delete ?");
		
			if(result == true){
				document.form1.action.value="delete";
				document.form1.submit();
			}
			else
				return;
		}
	</script>
<title>AddressBook::Update</title>
</head>

<body>
<div class="container mx-auto mt-5 p-5 shadow" style="width: 50%">
<H2>AddressBook::Update</H2>
<HR>
<a href="javascript:history.go(-1)"  class="btn btn-info">Back to List</a> <P>
<form name=form1 method=post action="/javaweb/addrbook">
<input type=hidden name="ab_id" value="${ab.ab_id}">
<input type=hidden name="action" value="update">

<div class="form-group">
    <label for="ab_name">Name:</label>
    <input type="text" class="form-control" name="ab_name" value="${ab.ab_name}">
    <label for="ab_email">email:</label>
    <input type="text" class="form-control" name="ab_email" value="${ab.ab_email}">
    <label>CellPhone:</label>
    <input type="text" class="form-control" name="ab_tel" value="${ab.ab_tel}">
    <label for="ab_birth">Birth Date:</label>
    <input type="date" class="form-control" name="ab_birth" value="${ab.ab_birth}">
    <label for="ab_comdept">Company</label>
    <input type="text" class="form-control" name="ab_comdept" value="${ab.ab_comdept}">
    <label for="ab_memo">Memo</label>
    <input type="text" class="form-control" name="ab_memo" value="${ab.ab_memo}">
</div>
	<button type="submit" class="btn btn-primary">Save</button>
	<button class="btn btn-warning" onclick="delcheck()">Delete</button>
</form>
</div>
</body>
</html>