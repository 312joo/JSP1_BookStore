<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.BookListBean" %>

    <%
    	String nowPage= request.getParameter("nowPage");
    	BookListBean bean=(BookListBean) request.getAttribute("bean");
    	int book_num=bean.getBook_num();
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>

<style type="text/css">
	#registForm{
		width: 600px;
		height: auto;
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
	<h2>책 정보 수정</h2>
	<form action="bookModify.book" method="post" name="modifyform">
		<input type="hidden" name="book_num" id="book_num" value="<%=bean.getBook_num() %>"/>
		<input type="hidden" name="nowPage" id="nowPage" value="<%=nowPage %>"/>
		<input type="hidden" name="sales" id="sales" value="<%=bean.getSales() %>"/>
		<input type="hidden" name="image_file" id="image_file" value="<%=bean.getImage_file()%>"/>
		<table>
			<tr>
				<td class="td_left"><label for="book_subject">제 목</label></td>
				<td class="td_right">
				<input type="text" name="book_subject" id="book_subject" value="<%=bean.getBook_subject() %>" required="required"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="author">저 자</label></td>
				<td class="td_right"><input type="text" name="author" id="author" required="required" value="<%=bean.getAuthor() %>"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="translator">역 자</label></td>
				<td class="td_right">
				<input type="text" name="translator" id="translator" required="required" value="<%=bean.getTranslator()%>"/></td>
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
				<input type="text" name="publisher" id="publisher" required="required" value="<%=bean.getPublisher()%>"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="price">가 격</label></td>
				<td class="td_right">
				<input type="text" name="price" id="price" required="required" value="<%=bean.getPrice()%>"/></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="stock">재고량</label></td>
				<td class="td_right">
				<input type="text" name="stock" id="stock" required="required" value="<%=bean.getStock()%>"/></td>
			</tr>
			<tr>
				<td class="td_left"><label for="book_content1">요 약</label></td>
				<td class="td_right">
				<textarea name="book_content1" id="book_content1" cols="40" rows="15" required="required"><%=bean.getBook_content1()%></textarea></td>
			</tr>
			<tr>
				<td class="td_left"><label for="book_content2">상세내용</label></td>
				<td class="td_right">
				<textarea name="book_content2" id="book_content2" cols="40" rows="15" required="required"><%=bean.getBook_content2()%></textarea></td>
			</tr>
			<tr>								
				<td class="td_left"><label for="image_file">이미지 파일</label></td>
				<td class="td_right">
				<a href="#"><%=bean.getImage_file()%></a></td>
			</tr>
			<tr>
				<td class="td_left"><label for="special">분류</label></td>
				<td class="td_right"><input type="radio" name="special" id="special" value="0" checked/>없음
				<input type="radio" name="special" id="special" value="1"/>추천
				<input type="radio" name="special" id="special" value="2"/>Awards
			</tr>
		</table>
		<div id="commandCell">
			<input type="submit" value="저장">&nbsp;&nbsp;
			<input type="button" onclick=history.back() value="취소">
		</div>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>