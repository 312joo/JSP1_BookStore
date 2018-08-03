<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String customer_id=(String) session.getAttribute("customer_id");
	if(!customer_id.equals("admin")){
		//로그인해야 글을 쓸 수 있음
		%>
		<script>alert("관리자 로그인이 필요합니다.");</script>
		<%
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<form action="bookRegist.book" method="post" name="registform" enctype="multipart/form-data">
	<h2>새 책 등록</h2>
		<table>
			<tr>
				<td class="td_left"><label for="book_subject">제 목</label></td>
				<td class="td_right">
				<input type="text" name="book_subject" id="book_subject" required="required"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="author">저 자</label></td>
				<td class="td_right"><input type="text" name="author" id="author" required="required"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="translator">역 자</label></td>
				<td class="td_right">
				<input type="text" name="translator" id="translator" required="required" /></td>
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
				<td class="td_left"><label for="publisher">출판사</label></td>
				<td class="td_right">
				<input type="text" name="publisher" id="publisher" required="required" ></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="price">가 격</label></td>
				<td class="td_right">
				<input type="text" name="price" id="price" required="required"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="stock">재고량</label></td>
				<td class="td_right">
				<input type="text" name="stock" id="stock" required="required"/></td>
			</tr>
			<tr>
				<td class="td_left"><label for="book_content1">요 약</label></td>
				<td class="td_right">
				<textarea name="book_content1" id="book_content1" cols="40" rows="15" required="required"></textarea></td>
			</tr>
			<tr>
				<td class="td_left"><label for="book_content2">상세내용</label></td>
				<td class="td_right">
				<textarea name="book_content2" id="book_content2" cols="40" rows="15" required="required"></textarea></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="image_file">이미지 파일</label></td>
				<td class="td_right"><input type="file" name="image_file" id="image_file" />
				</td>
			</tr>
			<tr>
				<td class="td_left"><label for="special">분류</label></td>
				<td class="td_right"><input type="radio" name="special" id="special" value="0" checked/>없음
				<input type="radio" name="special" id="special" value="1"/>추천
				<input type="radio" name="special" id="special" value="2"/>Awards
			</tr>
		</table>
		<div id="commandCell">
			<input type="submit" value="등록">&nbsp;&nbsp;
			<input type="button" onclick=history.back() value="취소">
		</div>
	</form>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>

