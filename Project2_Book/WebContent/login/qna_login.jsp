<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script>
	function joinClick(){
		location.href='JoinForm.lo';
	}
</script>
<style>
#wrap{
	border: 2px bouble purple;
	border-radius: 10px;
}
#loginFormArea{
	
	text-align: center;
	border: none;
}
#selectButton{
	margin-top: 10px;
}
table{
	margin: auto;
}

.td_left{
	width: 180px;
}
.td_right{
	width: 200px;
}
.td_top{
	height: 100px;
}
</style>
<body>
<table id="wrap">
<tr>
	<td colspan="2"><jsp:include page="header.jsp"></jsp:include></td>
</tr>

<tr>
<td colspan="2" id="contents">
<div id="loginFormArea">
	
	<form action="LoginPro.lo" method="post">
			<table>
				<tr class="td_top"><td colspan="2"><h1>�α���</h1></td>
				<tr>
					<td class="td_left"><label for="customer_id">���̵�: </label></td>
					<td class="td_right"><input type="text" name="customer_id" id="customer_id"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="customer_pass">��й�ȣ: </label></td>
					<td class="td_right"><input type="password" name="customer_pass" id="customer_pass"/></td>
				</tr>
			</table>	
			<input type="submit" value="�α���" id="selectButton"/>
			<input type="button" value="ȸ������" id="selectButton" onClick="joinClick()"/>		
	</form>
</div>
</td>
</tr>
<tr>
	<td colspan="2">
      <jsp:include page="../footer.jsp"></jsp:include>
     </td>
</tr>
</table>

</body>
</html>
