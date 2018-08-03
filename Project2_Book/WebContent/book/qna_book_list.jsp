<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.BookListBean" %>
    <%@page import="vo.PageInfo" %>
	<%@page import="java.util.*" %>

	
	<%
		ArrayList<BookListBean> bookList=(ArrayList<BookListBean>)request.getAttribute("bookList");
		PageInfo pageInfo=(PageInfo)request.getAttribute("pageInfo");
		int listCount=pageInfo.getListCount();
		int nowPage=pageInfo.getNowPage();
		int maxPage=pageInfo.getMaxPage();
		int startPage=pageInfo.getStartPage();
		int endPage=pageInfo.getEndPage();
		
		//System.out.print("listCount:"+listCount+" nowPage:"+nowPage+" maxPage:"+maxPage+" startPage:"+startPage+" endPage:"+endPage+" listSize:"+articleList.size());
	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
#registForm{
	width: 500px;
	height: auto;
	border: 1px solid red;
	margin: auto;
}

h2{
	text-align: center;
}


#tr_top{
	background: orange;
	text-align: center;
}
#tr_list{
	text-align: center;
}
#td_list{
	margin: 10px 0;
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
	width: 880px;
	text-align: right;
}

</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="listFrom">
	<h2>
		도서목록<br><br>
	</h2>

	<table id="wrap">
	<%
		if((bookList != null) && listCount>0){
	%>
		 
		 <tr id="tr_top">
		 	<td>번호</td>
		 	<td>도서명</td>
		 	<td>저자</td>
		 	<td>역자</td>
		 	<td>출판사</td>
		 	<td>분야</td>
		 	<td>가격</td>
		 	<td>재고량</td>
		 	<td>판매량</td>
		 </tr>
		 
		 <%
		 	for(int i=0;i<bookList.size();i++){
		 		String field_kor="";
		 		switch(bookList.get(i).getField()){
		 		case 1: field_kor="예술/사진"; break;
		 		case 2: field_kor="자연과학"; break;
		 		case 3: field_kor="경제경영"; break;
		 		case 4: field_kor="음식/취미"; break;
		 		case 5: field_kor="역사"; break;
		 		case 6: field_kor="문학/에세이"; break;
		 		case 7: field_kor="미스터리/추리 소설"; break;
		 		case 8: field_kor="로맨스소설"; break;
		 		case 9: field_kor="인문/철학"; break;
		 		case 10: field_kor="자기계발"; break;
		 		case 11: field_kor="기타"; break;
		 		}%>
			<tr id="tr_list">
				<td><%=bookList.get(i).getBook_num() %></td>
			 	<td><a href="bookView.book?book_num=<%=bookList.get(i).getBook_num() %>&nowPage=<%=nowPage%>"><%=bookList.get(i).getBook_subject() %></a></td>
			 	<td><a href="#"><%=bookList.get(i).getAuthor() %></a></td>
			 	<td id="td_list"><%=bookList.get(i).getTranslator() %></td>
			 	<td><%=bookList.get(i).getPublisher() %></td>
			 	<td><%=field_kor %></td>
			 	<td><%=bookList.get(i).getPrice() %></td>
			 	<td><%=bookList.get(i).getStock() %></td>
			 	<td><a href="#"><%=bookList.get(i).getSales() %></a></td>
			</tr>
		 		
		 	<%}%>
		 	
	</table>
</div>

<div id="pageList"><br>
	<% if(nowPage<=1){ %>
		[이전]&nbsp;
	<%}else{ %>
		<a href="bookList.book?nowPage=<%=nowPage-1 %>">[이전]</a>&nbsp;
	<%} %>
	
	<%for(int a=startPage;a<=endPage;a++){
		if(a==nowPage){%>
			[<%=a %>]
		<%}else{ %>
			<a href="bookList.book?nowPage=<%=a %>">[<%=a %>]</a>&nbsp;
		<%}%>
	<%}%>
	
	<%if(nowPage>=maxPage){ %>
		[다음]
	<%}else{ %>
		<a href="bookList.book?nowPage=<%=nowPage+1 %>">[다음]</a>
	<%}%>
</div>

	<%}

	else{%>
	<div id="emptyArea">등록된 책이 없습니다.</div>
	<%}%>
	<br>
	<table>
	<tr>
		 <td id="writing"><a href="bookRegistForm.book">책 등록</a></td>
	</tr>
	</table>
	
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>