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
#listFrom{
	width: 1000px;
	height: auto;
	border: 1px solid #ccc;
	margin: auto;
}

h2{
	text-align: center;
}
td{
	text-align: center;
}

#tr_top{
	background: #eee;
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
#cart_amount{
	text-align: center;
	width: 30px;
}
#book_img{
	text-align: center;
}
</style>
<script>
//체크박스 전체 체크&해제시 
	function checkAll(count){

		for(var i=1;i<=count;i++){
			var id='remove'+i;
			if(document.getElementById("allCheck").checked){
				document.getElementById(id).checked=true;		
			}
			else{
				document.getElementById(id).checked=false;
			}	
		}
	}
	
//체크된 책 삭제
	function deleteChecked(count){
		
	for(var i=1;i<=count;i++){
		var id='remove'+i;
		if(document.getElementById(id).checked){
			location.href("template.jsp"); 
		}
	}	
}

	function dd(){
		
	}
</script>


<jsp:include page="../header.jsp"></jsp:include>
<div id="listFrom">
	<h2>
		장바구니<br><br>
	</h2>

	<table id="wrap"> 
		 <tr id="tr_top">
		 	<td colspan="2"><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(<%=cartList.size()%>)"/>
		 	<input type="button" onClick="location.href('template.jsp')" value="선택 삭제"/></td>
		 	<td>제목</td>
		 	<td>가격</td>
		 	<td>수량</td>
		 	<td>총 금액</td>
		 </tr>
		 <%for(int i=0;i<cartList.size();i++){
			 int price=cartList.get(i).getPrice(); 
			 int amount=cartList.get(i).getCart_amount();%>

		<tr class="remove">
			<td><input type="checkbox" id="remove<%=i+1 %>" value="<%=cartList.get(i).getBook_num() %>"/></td>
		 	<td id="book_img"><img src="imgs/<%=cartList.get(i).getImage_file() %>" width="150" height="200" /></td>
		 	<td><%=cartList.get(i).getBook_subject() %></td>
		 	<td><%=price %></td>
		 	<td><form action="updateCartAmount.ca" method="post"><input type="text" id="cart_amount" name="cart_amount" value="<%=amount%>"/><br>
		 	<input type="submit" id="changeAmount" name="changeAmount" value="변경"/>
		 	<input type="hidden" id="book_num" name="book_num" value="<%=cartList.get(i).getBook_num()%>"/></form></td>
		 	<td><%=price*amount %></td>
		</tr>
		<%} %>
	</table>
</div>	

<jsp:include page="../footer.jsp"></jsp:include>


</body>
</html>
