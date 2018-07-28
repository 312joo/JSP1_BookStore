<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
     <link href="http://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet">
<style>
.nivoSlider{
	width: 600px;
	height: 300px;
}
    
</style>    
</head>
<link rel="stylesheet" href="css/themes/default/default.css">
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css">
<body>

<table id="wrap">
<tr>
	<td colspan="2"><jsp:include page="header.jsp"></jsp:include></td>
</tr>
<tr>
     <td colspan="2" id="category_td"><jsp:include page="category.jsp"></jsp:include></td>
</tr>
<tr>
<td width="20%" height="100%" id="contents">
 <jsp:include page="left.jsp"></jsp:include>
</td>
<td id="contents">
      <div>
      <article>
          <div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <img src="imgs/slider1.jpg" width="600" height="300">
                <img src="imgs/slider2.jpg" width="600" height="300">
                <img src="imgs/slider3.jpg" width="600" height="300">
                <img src="imgs/slider4.jpg" width="600" height="300">
            </div>  
      </div>
        
      </article>
	</div>
</td>
</tr>
<tr>
	<td colspan="2">
      <jsp:include page="footer.jsp"></jsp:include>
     </td>
</tr>
</table>
</body>
</html>
 <script src="http://code.jquery.com/jquery-latest.js"></script>
 <script type="text/javascript" src="scripts/jquery.nivo.slider.js"></script>
 <script type="text/javascript">
        $(window).load(function(){
            $('#slider').nivoSlider();
        });
        
        $(document).ready(function(){
            $(".tab_content").hide( );
            $("ul.tabs li:first").addClass("active").show();
            $(".tab_content:first").show();
            $("ul.tabs li").click(function(){
                $("ul.tabs li").removeClass("active");
                $(this).addClass("active");
                $(".tab_content").hide();
                var activeTab=$(this).find("a").attr("href");
                $(activeTab).fadeIn();
                return false;
            });
        });
 </script>
    