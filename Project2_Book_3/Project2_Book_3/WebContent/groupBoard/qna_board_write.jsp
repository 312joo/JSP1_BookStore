<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String customer_id=(String) session.getAttribute("customer_id");
	if(customer_id==null){
		//로그인해야 글을 쓸 수 있음
		%>
		<jsp:forward page="LoginForm.lo"></jsp:forward>
		<%
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>책모임 개설</title>
</head>
<style>
#registForm{
width:500px;
height:610px;
border:1px solid red;
margin:auto;
}

h2{
	text-align:center;
}

table{
	margin:auto;
	width: 450px;
}

.td_left{
	width:150px;
	background:orange;
}

.td_right{
	width:300px;
	background:skyblue;
}

#commandCell{
	text-align:center;
}
</style>
<body>
<div>
	<h2>새 글 등록</h2>
	<form action="writePro.bo" method="post" name="boardform">
	<input type="hidden" name="customer_id" id="customer_id" value=<%=customer_id %>>
		<table>
			<tr>
				<td class="td_left"><label for="group_subject">제 목</label></td>
				<td class="td_right"><input type="text" name="group_subject" id="group_subject" required="required"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="customer_id">작성자</label></td>
				<td class="td_right"><label><%=customer_id %></label></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="group_name">모임명</label></td>
				<td class="td_right"><input type="text" name="group_name" id="group_name" required="required"/></td>
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
				<td class="td_right"><textarea name="group_content" id="group_content" cols="40" rows="15" required="required"></textarea></td>
			</tr>
			<tr>
				<td class="td_left"><label for="group_recruiting">모집진행 여부</label></td>
				<td class="td_right"><input type="radio" name="group_recruiting" value="open" checked/>모집중
									<input type="radio" name="group_recruiting" value="close"/>모집마감	
				</td>
			</tr>
		</table>
		<div id="commandCell">
			<input type="submit" value="등록"/>&nbsp;&nbsp;
			<input type="reset" value="다시 작성"/>&nbsp;&nbsp;
			<input type="button" value="취소" onClick='onCancel'/>
		</div>
	</form>
</div>
</body>
</html>
<script>
	function onCancel(){
		history.back();
	}
</script>
