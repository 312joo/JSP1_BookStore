<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
#registForm{
width:600px;
height:100px;
border:1px solid #ccc;
margin:auto;
}

table{
	margin:auto;
	width: 600px;
	height: 150px;
	background:#d9d9d9;
	text-align: center;
}
.td_review{
	padding: 10px 0;
}
#submit_review{
	width: 50px;
	height: 50px;
}

</style>
<link rel="stylesheet" href="styles/5star.css">

<body>
<form action="bookRegist.book" method="post" name="registform" enctype="multipart/form-data">
	<input type="hidden" name="book_num" value="<%=book_num %>" />
		<table>
			<tr>
				<td><h3>My Review</h3></td>
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
				<td class="td_review" colspan="2"><textarea name="book_review" id="book_review" rows="5" cols="70" required="required"></textarea></td>
				<td><input type="submit" value="등록" id="submit_review"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>

