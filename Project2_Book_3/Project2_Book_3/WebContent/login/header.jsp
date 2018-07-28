<%@page language="java" contentType="text/html; charset=utf-8"%>
<%
    	String customer_id=null;
    	
    	if(session.getAttribute("customer_id")!=null){
    		customer_id=(String)session.getAttribute("customer_id");
    	}
    %>

<!DOCTYPE HTML>

<html>

 <TITLE>YJ BookStore</TITLE>
<meta charset="utf-8">
     <link href="http://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet">
    <link rel="stylesheet" href="css/themes/default/default.css">
    <link rel="stylesheet" href="css/nivo-slider.css" type="text/css">

<style>

*{
	margin:0;
	padding:0;
}
body{
	font-size:0.75em;
	font-family:"맑은 고딕",sans-serif;
	color:#333;
	line-height:1.2em;
}
#wrap{
	margin:0 auto;
	background:#fff;
	width:600px;
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
			
	</header>


<div class="clear"></div>