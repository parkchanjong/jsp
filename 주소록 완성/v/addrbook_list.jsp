<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inc_header.html"%>

<script type="text/javascript">
	function check(ab_id) {
		pwd = prompt('수정/삭제 하려면 비밀번호를 넣으세요');
		document.location.href = "/javaweb/addrbook?action=edit&ab_id=" + ab_id
				+ "&upasswd=" + pwd;
	}
</script>
<title>AddressBook List</title>
</head>

<body>
	<div class="container w-75 mx-auto mt-5">
		<H2>AddressBook::List</H2>
		<HR>
		<form>
			<a href="/javaweb/addrbook/addrbook_form.jsp" class="btn btn-info">New Entry</a>
			<P>
			<table class="table table-hover table-striped">
				<thead class="thead-dark">
					<tr>
						<th>#No</th>
						<th>Name</th>
						<th>CellPhone</th>
						<th>Birth Date</th>
						<th>Company</th>
						<th>Memo</th>
					</tr>
				</thead>
				<c:forEach items="${datas}" var="ab">
				<tr>
					<td><a href="javascript:check(${ab.ab_id})">${ab.ab_id}</a></td>
					<td>${ab.ab_name}</td>
					<td>${ab.ab_tel}</td>
					<td>${ab.ab_birth}</td>
					<td>${ab.ab_comdept}</td>
					<td>${ab.ab_memo}</td>
				</tr>
				</c:forEach>
			</table>
		</form>

		<div class="container-fluid w-50 mx-auto">
			<ul class="pagination">
				<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item active"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</div>

	</div>

</body>
</html>