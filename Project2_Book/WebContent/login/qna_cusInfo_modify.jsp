<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.CustomerBean" %>
    <%
    	CustomerBean bean=(CustomerBean) request.getAttribute("bean");
    	String customer_id=bean.getCustomer_id();
 		String customer_name=bean.getCustomer_name();
 		int customer_gender=bean.getCustomer_gender();
 		int customer_age=bean.getCustomer_age();
 		String customer_email=bean.getCustomer_email();
 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>
</head>
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
	<td colspan="2"><jsp:include page="header.jsp"></jsp:include></td>
</tr>

<tr>
<td colspan="2" id="contents">
<div id="loginFormArea">
	
<form name="joinform" action="cusInfoModify.lo" method="post" onsubmit="return formCheck(this)" id="joinFormArea">
	<h3>회원가입</h3>
	<table>
		<tr>
			<td class="td_left"><label for="customer_id">아이디 : </label></td>
			<td class="td_right"><%=customer_id %></td>
			<td></td>
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
			<td class="td_right"><input type="text" name="customer_name" id="customer_name" value="<%=customer_name%>"></td>
			<td></td>
		</tr>
		<tr>
			<td class="td_left"><label for="customer_age">나이 : </label></td>
			<td class="td_right"><input type="text" name="customer_age" id="customer_age" value="<%=customer_age%>"></td>
			<td></td>
		</tr>
		<tr>
			<td><label for="customer_gender">성별 : </label></td>
			<%if(customer_gender==0){%>
				<td class="td_right"><input type="radio" name="customer_gender" value="남" checked id="man"/>남자
				<input type="radio" name="customer_gender" value="여" id="woman"/>여자</td>
			<% }else { %>
				<td class="td_right"><input type="radio" name="customer_gender" value="남"  id="man"/>남자
				<input type="radio" name="customer_gender" value="여" checked id="woman"/>여자</td>
			<%} %>
			<td></td>
		</tr>
		<tr>
			<td><label for="customer_email">이메일 주소 : </label></td>
			<td class="td_right"><input type="text" name="customer_email" id="customer_email" value="<%=customer_email%>"/></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="회원정보수정"/>&nbsp;&nbsp; 
				<input type="reset" value="다시작성"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
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