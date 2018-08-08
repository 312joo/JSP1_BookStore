<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.BookListBean" %>
<%@page import="java.util.*" %>

<%
	ArrayList<BookListBean> list=null;
	
	if(request.getAttribute("bookList")!=null){
		list=(ArrayList<BookListBean>)request.getAttribute("bookList");
	}
	else{
		%><script>history.back();</script><%
	}
%>

<html>
<style>

	#td_booklist{
		padding: 20px;
	}

	#valueRating{
		color: red;
		
	}


</style>
<body>
<table id="wrap">
<tr>
	<td colspan="2"><jsp:include page="header.jsp"></jsp:include></td>
</tr>
<tr>
     <td colspan="2" id="category_td"><jsp:include page="category.jsp"></jsp:include></td>
</tr>
<tr>
<td width="20%" height="100%" id="contents">
 <jsp:include page="left.jsp"></jsp:include>
</td>
<td id="contents">
     <table>
		<tr>
			<%for(int i=0;i<list.size();i++){ %>
			
			<td align= "center" id="td_booklist">
				<a href="cusBookView.book?book_num=<%=list.get(i).getBook_num() %>">
					<img src="imgs/<%=list.get(i).getImage_file() %>" width="150" height="200" id="bookImg"/></a><br>
				<a href="cusBookView.book?book_num=<%=list.get(i).getBook_num() %>" id="subject"><%=list.get(i).getBook_subject() %></a><br>
				<%
				int avg=list.get(i).getStar_average(); String star;
				if(avg>=45){
					star="star50.png";
				}else if(avg>40){
					star="star45.png";
				}else if(avg>=35){
					star="star40.png";
				}else if(avg>30){
					star="star35.png";
				}else if(avg>=25){
					star="star30.png";
				}else if(avg>20){
					star="star25.png";
				}else if(avg>=15){
					star="star20.png";
				}else if(avg>10){
					star="star15.png";
				}else if(avg>=5){
					star="star10.png";
				}else if(avg>0){
					star="star5.png";
				}else{
					star="star0.png";
				}%>
				<a href="#" id="valueRating"><img src="imgs/<%=star %>" id="imgRating" width="90" height="15"/>&nbsp;&nbsp;<%=avg*0.1 %></a><br>
				<a href="#" id="author"><%=list.get(i).getAuthor() %></a><br>
				<label id="price"><%=list.get(i).getPrice() %>원</label>	
			</td>
				<%if((i+1)==list.size()) break; 
				  else if(i%4==3){ %></tr><tr>
			<%}
			} %>
		</tr>
	</table>
</td>
</tr>
<tr>
	<td colspan="2">
      <jsp:include page="footer.jsp"></jsp:include>
     </td>
</tr>
</table>
	
</body>
</html>	
	