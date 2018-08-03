<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.CustomerBean" %>
    <%@page import="java.util.*" %>

<%
	ArrayList<CustomerBean> customerList=(ArrayList<CustomerBean>)request.getAttribute("customerList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style type="text/css">
#registForm{
	width: 500px;
	height: 600px;
	border: 1px solid red;
	margin: auto;
}

h2{
	text-align: center;
}


table{
	margin: auto;
	widht:600px;
}

#tr_top{
	background: orange;
	text-align: center;
}

#pageList{
	margin: auto;
	width: 500px;
	text-align: center;
}

#emptyArea{
	margin: auto;
	width: 500px;
	text-align: center;
}
#writing{
	text-align: center;
}
.rec_open{

}
.rec_mine{
	background-color: #ddd;
	color: red;
}
.rec_close{
	background-color: #ddd;
}
</style>
<jsp:include page="../header.jsp"></jsp:include>
<div id="listFrom">
	<h2>
		회원목록<br><br>
	</h2>

	<table id="wrap">
	<%
		if((customerList != null)){
	%>		 
		 <tr id="tr_top">
		 	<td>ID</td>
		 	<td>이름</td>
		 	<td>성별</td>
		 	<td>나이</td>
		 	<td colspan="2">이메일</td>
		 </tr>
		 <%for(int i=0;i<customerList.size();i++){%>
		<tr>
			<td><%=customerList.get(i).getCustomer_id() %></td>
		 	<td><%=customerList.get(i).getCustomer_name() %></td>
		 	<%if(customerList.get(i).getCustomer_gender()==0){%>
		 	<td>남성</td>
		 	<%}else{ %>
		 	<td>여성</td>
		 	<%} %>
		 	<td><%=customerList.get(i).getCustomer_age() %></td>
		 	<td><%=customerList.get(i).getCustomer_email() %></td>
		 	<td><a href="customerDelete.lo?customer_id=<%=customerList.get(i).getCustomer_id() %>" >삭제</a></td>
		</tr>
	 	<%}} %>
	</table>
</div>

</body>
</html>