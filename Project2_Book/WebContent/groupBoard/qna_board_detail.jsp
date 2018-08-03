<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.GroupListBean" %>

    
    <%
		String id=null;
	
		if(session.getAttribute("customer_id")!=null){
			id=(String)session.getAttribute("customer_id");
		}else{
			%><script>alert("로그인이 필요합니다."); location.href("LoginForm.lo");</script><%
		}
	
    	GroupListBean bean=(GroupListBean) request.getAttribute("bean");
    	String nowPage=(String) request.getAttribute("nowPage");

    	String rec="";
    	if(bean.getGroup_recruiting()==true) rec="모집중";
    	else rec="모집마감";

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
    	
    	String area="";
    	switch(bean.getGroup_area()){
    	case 1:area="서울";break;
    	case 2:area="부산";break;
    	case 3:area="대구";break;
    	case 4:area="대전";break;
    	case 5:area="광주";break;
    	case 6:area="제주";break;
    	case 7:area="인천";break;
    	
     	}	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>책모임 게시판</title>
</head>
<style type="text/css">

#articleForm{
	width: 500px;
	height: 500px;
	border: 1px solid red;
	margin: auto;
}

h2{
	text-align: center;
}

#basicInfoArea{
	height: 40px;
	text-align:center;
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
	<h2>글 내용 상세보기</h2>
	<div id="basicInfoArea">
		제 목 : <%=bean.getGroup_subject() %>
		작성자: <%=bean.getCustomer_id() %>
		모임명: <%=bean.getGroup_name() %>
		관련분야: <%=field %>
		지역: <%=area %>
		모집여부: <%=rec %>
	</div>
	<div id="articleContentArea">
		<%=bean.getGroup_content() %>
	</div>
	<div id="commandList">
		<%
		if(bean.getCustomer_id().equals(id)){ %>
			
			<a href="ModifyForm.bo?group_num=<%=bean.getGroup_num() %>&nowPage=<%=nowPage %>">[수정]</a>
			<a href="DeletePro.bo?group_num=<%=bean.getGroup_num() %>&nowPage=<%=nowPage %>">[삭제]</a>
		<%} %>
			<a href="boardList.bo?nowPage=<%=nowPage %>">[목록]</a>		
			&nbsp;&nbsp;
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>