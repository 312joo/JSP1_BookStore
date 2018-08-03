<%@page language="java" contentType="text/html; charset=utf-8"%>
<%
    	String customer_id=null;
    	
    	if(session.getAttribute("customer_id")!=null){
    		customer_id=(String)session.getAttribute("customer_id");
    	}
    	
    	/*
    	
    		font-size:0.75em;
	font-family:"맑은 고딕",sans-serif;
	color:#333;
	line-height:1.2em;
    	
    	*/
    %>

<!DOCTYPE HTML>

<html>

 <TITLE>YJ BookStore</TITLE>
<meta charset="utf-8">
     <link href="http://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet">
    <link rel="stylesheet" href="css/themes/default/default.css">
    <link rel="stylesheet" href="css/nivo-slider.css" type="text/css">
<head>
   </head>
    
<style>

*{
	margin:0;
	padding:0;
}
body{
	color:#777;
    margin-left: 10px;
    margin-top: 10px;
    font-family:  Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    font-weight: lighter;
    font-size:0.75em;
    line-height:2.5em;
    line-width: 3em;
}
#wrap{
	margin:0 auto;
	background:#fff;
	width:1000px;
	height: auto;
}

a{
	text-decoration:none;
	color:#333;
}
a:hover{
	color:#39f;
}
.clear{
	clear:both;
}
#logo{
	float:left;
	text-indent:-9999px;			
	background:url("imgs/logo.png") no-repeat left top;
	margin:20px 0 20px 18px;
	width: 500px;
	height: 100px;
}
#logo a{
	width: 500px;
	height: 100px;
	display:block;
}		
#hlink{
	float:right;
	margin: 80px 70px;
}
#hlink ul{
	list-style:none;
}
#hlink ul li{
	float:left;
}
#hlink ul li a{
	padding:0 10px;
}
      
footer{
       padding: 20px 0;
       margin: 10px 20px;
       border-top: 1px solid #ccc;
}
footer address{
    width: 510px;
    height: 50px;
    margin: 10px auto;
    padding: 0 0 0 90px;
    text-align: center;
    font-style:normal;
    line-height: 1.8em;
    background: url(imgs/foot_logo.jpg) no-repeat left center;
}
#contents{
	padding-top: 10px;
	padding-left: 30px;
}

    </style>
   
     
<body>
	<header>
			<div id="logo">
				<a href="template.jsp">YJ BookStore</a>
			</div>
			<div id="hlink">
			<%if(customer_id==null){ %>
				<a href="LoginForm.lo">로그인</a>&nbsp;&nbsp;
				<a href="JoinForm.lo">회원가입</a>
				<%}else{ %>
				<h3><a href="cusInfoModifyForm.lo"><%=customer_id %>님 환영합니다!</a></h3><br>
				<%if(customer_id.equals("admin")){%>
					<a href="admin_main.jsp">관리자 페이지</a>
				<%}else{%>
				<a href="bookCartList.ca">장바구니</a>
				<a href="boardList.bo">나의모임</a>
				<%} %>
				<a href="LogoutPro.lo">로그아웃</a>
			<%} %>	
			</div>
	</header>


<div class="clear"></div>