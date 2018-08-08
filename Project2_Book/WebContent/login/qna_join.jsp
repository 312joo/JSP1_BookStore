<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="svc.JoinService" %>
<%
	String checkId=null;
	if(request.getAttribute("checkId")!=null){
		checkId=(String)request.getAttribute("checkId");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
</head>
<script type="text/javascript" src="login/formCheck.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>

h3{
	text-align:center;
}
#joinFormArea{
	margin: auto;
	width: 400px;
	height: 200px;
	border: 2px bouble purple;
	border-radius: 10px;
	text-align:center;
}
table{
	width: 460px;
	margin: auto;
}

.td_left{
	width: 200px;
}
.td_right{
	width: 250px;
}
.td_side{
	width: 100px;
}
</style>

<body>
<table id="wrap">
<tr>
	<td><jsp:include page="header.jsp"></jsp:include></td>
</tr>

<tr>
<td id="contents">
<div id="joinFormArea">
	<form name="joinform" action="JoinPro.lo" method="post" onsubmit="return formCheck(this)">
	<h3>회원가입</h3>
	<table>
		<tr>
			<td class="td_left"><label for="customer_id">아이디 : </label></td>
			<td class="td_right">
			<%if(checkId!=null){ %>
			<input type="text" name="customer_id" id="customer_id" value="<%=checkId%>">
			<%}else{ %><input type="text" name="customer_id" id="customer_id"/><%} %>
			</td>
			<td class="td_side"><input type="button" id="id_check" value="아이디 중복확인" onClick="idCheck(this.form)"/></td>
		</tr>
		<tr>
			<td colspan="3" id="id_result"></td>
		</tr>
		<tr>
			<td class="td_left"><label for="customer_pass">비밀번호 : </label></td>
			<td class="td_right"><input type="password" name="customer_pass" id="customer_pass"></td>
			<td></td>
		</tr>
		<tr>
			<td class="td_left"><label for="pass2">비밀번호 재입력: </label></td>
			<td class="td_right"><input type="password" name="pass2" id="pass2"></td>
			<td class="td_side" id="pass2_ans"></td>	
		</tr>
		<tr>
			<td class="td_left"><label for="customer_name">이름 : </label></td>
			<td class="td_right"><input type="text" name="customer_name" id="customer_name"></td>
			<td></td>
		</tr>
		<tr>
			<td class="td_left"><label for="customer_age">나이 : </label></td>
			<td class="td_right"><input type="text" name="customer_age" id="customer_age"></td>
			<td></td>
		</tr>
		<tr>
			<td><label for="customer_gender">성별 : </label></td>
			<td class="td_right"><input type="radio" name="customer_gender" value="남" checked id="man"/>남자
			<input type="radio" name="customer_gender" value="여" id="woman"/>여자</td>
			<td></td>
		</tr>
		<tr>
			<td><label for="customer_email">이메일 주소 : </label></td>
			<td class="td_right"><input type="text" name="customer_email" id="customer_email"/></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="회원가입"/>&nbsp;&nbsp; 
				<input type="reset" value="다시작성"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
	</form>
</div>
</td>
</tr>
</body>
</html>

<script>
	function idCheck(inputForm){
		if(inputForm.customer_id.value==""){
			alert("아이디를 입력하세요");
			return;
		}
		
		url="idCheck.lo?customer_id="+inputForm.customer_id.value;
		open(url, "아이디 중복확인","resizable=no, width=500, height=300, top=100, left=700");
	}

      	
</script>