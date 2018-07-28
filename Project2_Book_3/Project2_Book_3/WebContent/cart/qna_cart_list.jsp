<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.CartListBean" %>
    <%@page import="java.util.*" %>

<%
	ArrayList<CartListBean> cartList=(ArrayList<CartListBean>)request.getAttribute("cartList");
	
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
<script>
	function checkAll(theForm){
		if(theForm.remove.length==undefined){
			theForm.remove.checked=theForm.allCheck.checked;
		}else{
			for(var i=0;i<theForm.remove.length;i++){
				theForm.remove[i].checked=theForm.allCheck.checked;
			}
		}
	}
	
	
	}
</script>
<jsp:include page="../header.jsp"></jsp:include>
<div id="listFrom">
	<h2>
		장바구니<br><br>
	</h2>

	<table id="wrap">
	<%
		if((cartList != null)){
	%>
		 
		 <tr id="tr_top">
		 	<td colspan="2"><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(this.form)"/></td>
		 	<td>제목</td>
		 	<td>가격</td>
		 	<td>수량</td>
		 	<td>총 금액</td>
		 </tr>
		 <%for(int i=0;i<cartList.size();i++){ int price=cartList.get(i).getPrice(); int amount=cartList.get(i).getCart_amount();%>

		<tr>
			<td><input type="checkbox" id="remove" name="remove" value="<%=cartList.get(i).getBook_num() %>"/></td>
		 	<td><img src="../imgs/<%=cartList.get(i).getImage_file() %>"/></td>
		 	<td><%=cartList.get(i).getBook_subject() %></td>
		 	<td><%=price %></td>
		 	<td><form action="updateCartAmount.ca" method="post"><input type="text" id="cart_amount" name="cart_amount" value="<%=amount%>"/><br>
		 	<input type="submit" id="changeAmount" name="changeAmount" value="변경"/>
		 	<input type="hidden" id="book_num" name="book_num" value="<%=cartList.get(i).getBook_num()%>"/></form></td>
		 	<td><%=price*amount %></td>
		</tr>

		<tr>
			<td colspan="6" style="text-align: left;">
				<input type="button" onclick="document.location('bookCartDelete.ca')" value="삭제"/>
			</td>
		</tr>
	 	<%}}else{ %>
	 		<tr><td><h3>장바구니에 담은 상품이 없습니다.</h3></td></tr>
		<%} %>
	</table>
	<a href="#" >책 둘러보기</a>

</div>

</body>
</html>
