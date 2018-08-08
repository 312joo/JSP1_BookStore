<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.GroupListBean" %>
    <%@page import="vo.PageInfo" %>
	<%@page import="java.util.*" %>
	<%@page import="java.text.SimpleDateFormat" %>
	
	<%
	

		ArrayList<GroupListBean> articleList=(ArrayList<GroupListBean>)request.getAttribute("articleList");
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
<title>책모임 게시판</title>
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
	widht:450px;
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
#emptyTable{
	width: 300px;
	padding-top: 30px;
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
</head>
<body>
<table id="wrap">
<tr>
	<td colspan="2"><jsp:include page="../header.jsp"></jsp:include></td>
</tr>
<tr>
     <td colspan="2" id="category_td"><jsp:include page="../category.jsp"></jsp:include></td>
</tr>
<tr>

<td id="contents">
<div id="listFrom">
	<h2>
		함께 읽어요!<br><br>
	</h2>

	<table id="wrap">
	<%
		if((articleList != null) && listCount>0){
	%>
		 
		 <tr id="tr_top">
		 	<td>번호</td>
		 	<td>그룹명</td>
		 	<td>모집내용</td>
		 	<td>분야</td>
		 	<td>지역</td>
		 	<td>모집여부</td>
		 	<td>조회수</td>
		 </tr>
		 
		 <%
		 	for(int i=0;i<articleList.size();i++){
				
		 		String field_kor="";
		 		switch(articleList.get(i).getField()){
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
		 		}
		 		String area_kor="";
		 		switch(articleList.get(i).getGroup_area()){
		 		case 1: area_kor="서울"; break;
		 		case 2: area_kor="부산"; break;
		 		case 3: area_kor="대구"; break;
		 		case 4: area_kor="대전"; break;
		 		case 5: area_kor="광주"; break;
		 		case 6: area_kor="제주"; break;
		 		case 7: area_kor="인천"; break;
		 		}
		 		
		 		String rec;
				if(articleList.get(i).getGroup_recruiting()==true) {rec="모집중";%>
					<tr class="rec_open">
					 	<td><%=articleList.get(i).getGroup_num() %></td>
					 	<td><%=articleList.get(i).getGroup_name() %></td>
					 	<td><a href="detail.bo?group_num=<%=articleList.get(i).getGroup_num() %>&nowPage=<%=nowPage %>&customer_id=<%=articleList.get(i).getCustomer_id()%>">
					 	<%=articleList.get(i).getGroup_subject() %></a><br>
					 	<%=articleList.get(i).getCustomer_id() %>&nbsp;
					 	<%=articleList.get(i).getGroup_date() %></td>		 
					 	<td><%=field_kor%></td>
					 	<td><%=area_kor %></td>
					 	<td><%=rec %></td>
					 	<td><%=articleList.get(i).getGroup_readcount() %></td>
					</tr>
				<%}
				else if(articleList.get(i).getCustomer_id().equals(request.getAttribute("customer_id"))){
					rec="모집마감";%>
					<tr class="rec_mine">
					 	<td><%=articleList.get(i).getGroup_num() %></td>
					 	<td><%=articleList.get(i).getGroup_name() %></td>
					 	<td><a href="detail.bo?group_num=<%=articleList.get(i).getGroup_num() %>&nowPage=<%=nowPage %>&customer_id=<%=articleList.get(i).getCustomer_id()%>">
					 	<%=articleList.get(i).getGroup_subject() %></a><br>
					 	<%=articleList.get(i).getCustomer_id() %>&nbsp;
					 	<%=articleList.get(i).getGroup_date() %></td>		 
					 	<td><%=field_kor%></td>
					 	<td><%=area_kor %></td>
					 	<td><%=rec %></td>
					 	<td><%=articleList.get(i).getGroup_readcount() %></td>
					</tr>
				<%}
				else {rec="모집마감";%>
					<tr class="rec_close">
					 	<td><%=articleList.get(i).getGroup_num() %></td>
					 	<td><%=articleList.get(i).getGroup_name() %></td>
					 	<td><%=articleList.get(i).getGroup_subject() %><br>
					 	<%=articleList.get(i).getCustomer_id() %>&nbsp;
					 	<%=articleList.get(i).getGroup_date() %></td>		 
					 	<td><%=field_kor%></td>
					 	<td><%=area_kor %></td>
					 	<td><%=rec %></td>
					 	<td><%=articleList.get(i).getGroup_readcount() %></td>
					 </tr>
				<%}
		 	}
		 %>
		 <tr>
		 	<td colspan="3"></td>
		 	<td id="writing"><a href="writeForm.bo">모임개설</a></td>
		 	<td id="writing"><a href="listMinePro.bo">내가 쓴 글</a>
		 </tr>
		 	
	</table>
</div>

<div id="pageList">
	<% if(nowPage<=1){ %>
		[이전]&nbsp;
	<%}else{ %>
		<a href="boardList.bo?nowPage=<%=nowPage-1 %>">[이전]</a>&nbsp;
	<%} %>
	
	<%for(int a=startPage;a<=endPage;a++){
		if(a==nowPage){%>
			[<%=a %>]
		<%}else{ %>
			<a href="boardList.bo?nowPage=<%=a %>">[<%=a %>]</a>&nbsp;
		<%}%>
	<%}%>
	
	<%if(nowPage>=maxPage){ %>
		[다음]
	<%}else{ %>
		<a href="boardList.bo?nowPage=<%=nowPage+1 %>">[다음]</a>
	<%}%>
</div>

	<%}

	else{%>
	<div id="emptyArea">등록된 글이 없습니다.</div>
	<table id="emptyTable">
	<tr> 	
		 	<td id="writing"><a href="writeForm.bo">모임개설</a></td>
		 	<td id="writing"><a href="listMinePro.bo">내가 쓴 글</a>
	</tr>
	</table>
	<%}%>
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