<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자모드</title>
</head>
<style>
table{
	margin: auto;
	width: 600px;
	text-align: center;
}
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table>
	<tr>
		<td><h3><a href="bookList.book">도서 관리</a></h3></td>
	</tr>
	<tr>
		<td><h3><a href="customerList.lo">회원 목록</a></h3></td>
	</tr>
	<tr>
		<td><h3><a href="#">광고 이미지</a></h3></td>
	</tr>
	<tr>
		<td><h3><a href="#">독서모임 관리</a></h3></td>
	</tr>
</table>

</body>
</html>