<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.BookListBean" %>
    <%@page import="vo.PageInfo" %>
    <%@page import="vo.ReviewBean" %>
	<%@page import="java.util.*" %>
	
	<%

		BookListBean bean=(BookListBean) request.getAttribute("bean");	
		int book_num=bean.getBook_num(); 
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
    	
    	boolean translator=false;
		if(!bean.getTranslator().equals("-")) translator=true;
    	String img_path="../imgs/"+bean.getImage_file();
    	
    	ArrayList<ReviewBean> review=new ArrayList<ReviewBean>(); 
    	
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
	#bookView{
		width: 700px;
		height: auto;
	}
	#bookView.td{
		margin: auto;
		text-align: left;
	}
	h1{
		margin-left: 100px;
	}
	.td_left{
		padding: 0, 30px;
		width: 500px;
		text-align: center;
	}
	#td_price{
		color: red;
	}
	.content{
		padding: 10px;
	}
	.intro{
		bolder: 2px solid #ccc; 
		margin: 70px, 0;
	}
	
	#registForm{
		width:700px;
		height:100px;
		border:1px solid #ccc;
		margin:auto;
	}
	
	#review_table{
		margin:auto;
		width: 1000px;
		height: 150px;
		background:#eee;
		text-align: right;
	}
	.td_review{
		width: 700px;
	}
	#submit_review{
		width: 50px;
		height: 50px;
	}
	.td_submit{
		width: 300px;
		text-align:left;
		padding-left: 30px;
	}
	
	#baguni{
		background: white;
		background:url("imgs/baguni.png") no-repeat left top;
		background-size: 15px;
		text-align:right;
		margin-right:5px;
		width: 110px;
	}
	
	#cart_amount{
		width: 18px;
		height: 18px;
		text-align:center;
	}

</style>
<link rel="stylesheet" href="book/css/5star.css">
<script type="text/javascript" src="book/Check.js"></script>





<body>

		
<table id="wrap">
<tr>
	<td colspan="2"><jsp:include page="../header.jsp"></jsp:include></td>
</tr>
<tr>
     <td colspan="2" id="category_td"><jsp:include page="../category.jsp"></jsp:include></td>
</tr>
<tr>
<td width="20%" height="100%" id="contents">
 <jsp:include page="../left.jsp"></jsp:include>
</td>


<td id="contents">
<form action="bookCartAdd.ca" method="post">
<input type="hidden" name="book_num" id="book_num" value="<%=book_num %>" />
<input type="hidden" name="book_subject" id="book_subject" value="<%=bean.getBook_subject() %>" />
     <table id="bookView">
		<tr>		
			<td colspan="2" height="100" id="book_subject"><h1><%=bean.getBook_subject()%></h1></td>	
		</tr>
		<%
				int avg=bean.getStar_average(); String star;
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
				}
			%>
		<tr>
			<td rowspan="3" class=td_left ><img src="imgs/<%=bean.getImage_file() %>" width="200" height="250" id="bookImg"/>
			<input type="hidden" name="image_file" id="image_file" value="<%=bean.getImage_file() %>" /></td>
			<td>
			<a href="#" id="valueRating"><img src="imgs/<%=star %>" id="imgRating" width="90" height="15"/>&nbsp;&nbsp;<%=avg*0.1 %></a></td>
		</tr>

		<tr>
			<td class=td_right><h3>저자: <a href="#"><%=bean.getAuthor() %></a>
			<%if(translator){%><br><br>역자: <a href="#"><%=bean.getTranslator() %></a>
			<%}%><br><br>
			출판사: <a href="#"><%=bean.getPublisher() %></a></h3></td>
		</tr>

		<tr>
			<td class=td_right id="td_price"><h2><div id="ch"><%=bean.getPrice() %>원</div></h2>
			<input type="hidden" name="price" id="price" value="<%=bean.getPrice() %>" />
			<h3><input type="text" value="1" id="cart_amount" name="cart_amount" onChange="changeCheck()">개 &nbsp;
			<input type="submit" value="    장바구니 담기" id="baguni"></h3></td>
		</tr>
		
		<tr>
			<td colspan="2" class="intro"><h2>책소개</h2></td>
		</tr>
		<tr>
			<td colspan="2" class="content" ><%=bean.getBook_content1() %></td>
		</tr>
		<tr>
			<td colspan="2" ><h2>출판사 서평</h2></td>
		</tr>
		<tr>
			<td colspan="2"  class="content" ><%=bean.getBook_content2() %></td>
		</tr>		
	</table>
</form>
</td>




<tr>
	<td colspan="2">
	<form action="reviewRegist.book" method="post" name="registform" 
							id="registform" onsubmit="return loginCheck(this)">
	<input type="hidden" name="book_num" id="book_num" value="<%=book_num %>" />
	
		<table id="review_table">
			<tr>
				<td align="center"><h3>My Review</h3></td>
				<td class="rate-area" colspan="2">
				  <input type="radio" id="5-star" name="rating" value="5"/>
				  <label for="5-star" title="Amazing">5 stars</label>
				  <input type="radio" id="4-star" name="rating" value="4" />
				  <label for="4-star" title="Good">4 stars</label>
				  <input type="radio" id="3-star" name="rating" value="3" />
				  <label for="3-star" title="Average">3 stars</label>
				  <input type="radio" id="2-star" name="rating" value="2" />
				  <label for="2-star" title="Not Good">2 stars</label>
				  <input type="radio" id="1-star" name="rating" value="1" />
				  <label for="1-star" title="Bad">1 star</label>
				</td>	
			</tr>
			<tr>	
				<td class="td_review">
					<textarea name="book_review" id="book_review" rows="5" cols="70" required="required"></textarea>
				</td>
				<td class="td_submit">
					<input type="submit" value="등록" id="submit_review">
				</td>
			</tr>
		</table>
	</form>	
	</td>
</tr>



	
<tr>
	<td colspan="2" align="center"><jsp:include page="../review/qna_review_list.jsp"></jsp:include></td>
</tr>	
<tr>
	<td colspan="2">
      <jsp:include page="../footer.jsp"></jsp:include>
    </td>
</tr>
</table>
</body>
</html>



<script>
function changeCheck(){
	document.getElementById("ch").innerText=document.getElementById("cart_amount").value*<%=bean.getPrice() %>+"원";
}
</script>
