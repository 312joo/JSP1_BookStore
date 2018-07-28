<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.GroupListBean" %>

    <%
    	String nowPage= request.getParameter("nowPage");
    	GroupListBean bean=(GroupListBean) request.getAttribute("bean");
    	String customer_id=bean.getCustomer_id();
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>책모임 게시판</title>
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
		width: 450px;
	}
	
	.td_left{
		width: 150px;
		background: orange;
	}
	
	.td_right{
		width: 300px;
		background: skyblue;
	}
	
	#commandCell{
		text-align: center;
	}
</style>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="writeForm">
	<h2>게시판글 수정</h2>
	<form action="ModifyPro.bo" method="post" name="modifyform">
		<input type="hidden" name="group_num" id="group_num" value="<%=bean.getGroup_num() %>"/>
		<input type="hidden" name="nowPage" id="nowPage" value="<%=nowPage %>"/>
		<input type="hidden" name="customer_id" id="customer_id" value="<%=customer_id %>"/>
		<table>
			<tr>
				<td class="td_left"><label for="group_subject">제 목</label></td>
				<td class="td_right">
				<input type="text" name="group_subject" id="group_subject" value="<%=bean.getGroup_subject() %>" required="required"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="customer_id">작성자</label></td>
				<td class="td_right"><label><%=bean.getCustomer_id() %></label></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="group_name">모임명</label></td>
				<td class="td_right">
				<input type="text" name="group_name" id="group_name" required="required" value="<%=bean.getGroup_name()%>"/></td>
			</tr>
			<tr>
				<td class="td_left"><label for="field">관련 분야</label></td>
				<td class="td_right"><select name="selectField" id="selectField">
									<option value=1> 예술/사진</option>
									<option value=2> 자연과학</option>
									<option value=3> 경제경영</option>
									<option value=4> 음식/취미</option>
									<option value=5> 역사</option>
									<option value=6> 문학/에세이</option>
									<option value=7> 미스터리/추리 소설</option>
									<option value=8> 로맨스소설</option>
									<option value=9> 인문/철학</option>
									<option value=10> 자기계발</option>
									<option value=11> 기타</option>
									</select></td>
			</tr>
			<tr>
				<td class="td_left"><label for="group_area">모임 지역</label></td>
				<td class="td_right"><select name="selectArea" id="selectArea">
									<option value=1> 서울</option>
									<option value=2> 부산</option>
									<option value=3> 대구</option>
									<option value=4> 대전</option>
									<option value=5> 광주</option>
									<option value=6> 제주</option>
									<option value=7> 인천</option>
									</select></td>
			</tr>
			<tr>
				<td class="td_left"><label for="group_content">내 용</label></td>
				<td class="td_right">
				<textarea name="group_content" id="group_content" cols="40" rows="15" required="required"><%=bean.getGroup_content()%></textarea></td>
			</tr>
			<tr>
				<td class="td_left"><label for="group_recruiting">모집진행 여부</label></td>
				<%if(bean.getGroup_recruiting()){ %>
				<td class="td_right"><input type="radio" name="group_recruiting" value="open" checked/>모집중
									<input type="radio" name="group_recruiting" value="close"/>모집마감	
				</td>
				<%}else{ %>
				<td class="td_right"><input type="radio" name="group_recruiting" value="open"/>모집중
				<input type="radio" name="group_recruiting" value="close" checked/>모집마감	
				</td>
				<%} %>
			</tr>
		</table>
		<div id="commandCell">
			<input type="submit" value="완료">&nbsp;&nbsp;
			<input type="button" onClick=history.back() value="취소">
		</div>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>