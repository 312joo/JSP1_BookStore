<meta charset="utf-8">
<link href="http://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet">

<style>

</style>
<html>
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
     <jsp:include page="bookList.jsp"></jsp:include>
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