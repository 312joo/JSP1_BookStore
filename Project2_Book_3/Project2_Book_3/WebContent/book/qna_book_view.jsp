<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.BookListBean" %>

    
    <%
		String id=null;
	
		if(session.getAttribute("customer_id")!=null){
			id=(String)session.getAttribute("customer_id");
		}else if(session.getAttribute("customer_id")!="admin"){
			%><script>alert("관리자 로그인이 필요합니다."); location.history(-1);</script><%
		}else{%>
			<script>alert("로그인이 필요합니다."); location.href("LoginForm.lo");</script>
		<%}
	
    	BookListBean bean=(BookListBean) request.getAttribute("bean");
    	String nowPage=(String)request.getAttribute("nowPage");
		
    	
    	String field="";
    	switch(bean.getField()){
    	case 1: field="예술/사진"; break;
    	case 2: field="자연과학"; break;
    	case 3: field="경제경영"; break;
    	case 4: field="음식/취미"; break;
    	case 5: field="역사"; break;
    	case 6: field="문학/에세이"; break;
    	case 7: field="미스터리/추리 소설";break;
    	case 8: field="로맨스소설";break;
    	case 9: field="인문/철학";break;
    	case 10: field="자기계발";break;
    	case 11: field="기타";break;
    	    	
     	}	
    	

    	String img_path="../book_img/"+bean.getImage_file();
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<style type="text/css">

#articleForm{
	width: 600px;
	height: auto;
	border: 1px solid red;
	margin:auto;
}

h2{
	text-align: center;
}

#basicInfoArea{
	width: 600px;
	height: 200px;
	text-align: center;
	margin-top: 50px;
}

#articleContentArea{
	background: orange;
	margin-top: 20px;
	height: 350px;
	text-align: center;
	overflow: auto;
}

#commandList{
	margin: auto;
	width: 500px;
	text-align: center;
}


</style>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="articleForm">
	<h2>책 내용 상세보기</h2>
	<div id="basicInfoArea">
		<table width="600px" >
			<tr><td rowspan="9"><img src="<%=img_path %>"/></td></tr>
			<tr><td>제 목</td><td> <%=bean.getBook_subject() %></td></tr>
			<tr><td>저 자</td><td> <%=bean.getAuthor() %></td></tr>
			<tr><td>역 자</td><td> <%=bean.getTranslator() %></td></tr>
			<tr><td>관련분야</td><td> <%=field %></td></tr>
			<tr><td>출판사</td><td> <%=bean.getPublisher() %></td></tr>
			<tr><td>가 격</td><td> <%=bean.getPrice() %></td></tr>
			<tr><td>재고량</td><td> <%=bean.getStock() %></td></tr>
			<tr><td>판매량</td><td> <%=bean.getSales() %></td></tr>
		</table>

	</div>
	<div id="articleContentArea">
		<h3>요 약</h3><br> <%=bean.getBook_content1() %><br><br>
		<h3>상세내용</h3><br> <%=bean.getBook_content2() %>
	</div>
	<div id="commandList">
			<a href="bookModifyForm.book?book_num=<%=bean.getBook_num() %>&nowPage=<%=nowPage %>">[수정]</a>
			<a href="bookDelete.book?book_num=<%=bean.getBook_num() %>&nowPage=<%=nowPage %>">[삭제]</a>
			<a href="bookList.book?nowPage=<%=nowPage %>">[목록]</a>		
			&nbsp;&nbsp;
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>