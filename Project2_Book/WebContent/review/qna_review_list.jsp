<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="vo.ReviewBean" %>
        <%@page import="vo.BookListBean" %>
	<%@page import="java.util.*" %>

    <%
	String customer_id=null;
	
	if(session.getAttribute("customer_id")!=null){
		customer_id=(String)session.getAttribute("customer_id");
	}
    	
    	ArrayList<ReviewBean> review=(ArrayList<ReviewBean>)request.getAttribute("review");   	
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<style>
#td_list_id{
	width:600px;
	text-align: left;
}
#td_list_review{
	width:650px;
	text-align: left;
	background: #eee;
}
#delete_button{
	float: right;
}
</style>
<body>
<div class="clear"></div>

		
		<%
		BookListBean bean=(BookListBean) request.getAttribute("bean");	
		int book_num=bean.getBook_num(); 
		
			for(int i=0;i<review.size();i++){
		
			int point=review.get(i).getBook_star(); String star;
				if(point==5){
					star="star50.png";
				}else if(point==4){
					star="star40.png";
				}else if(point==3){
					star="star30.png";
				}else if(point==2){
					star="star20.png";
				}else if(point==1){
					star="star10.png";
				}else{
					star="star0.png";
				}
			%>
			<form action="reviewDelete.book" method="post">
			<input type="hidden" name="book_num" id="book_num" value="<%=book_num %>" />
			<div id="td_list_id"><h3><%=review.get(i).getCustomer_id() %>&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="imgs/<%=star %>" id="imgRating" width="90" height="15" />
				<%if(review.get(i).getCustomer_id().equals(customer_id)){%>
					<input type="submit" value="리뷰 삭제" id="delete_button"/><%}%></h3></div>
			<div id="td_list_review"> <%=review.get(i).getBook_review() %></div>
			
			</form>
			<%} %>
</body>
</html>