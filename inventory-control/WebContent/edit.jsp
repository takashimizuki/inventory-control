<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>変更画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
     <jsp:include page="header.jsp"></jsp:include>
	 <article>
	 <form action="edit.do" method="post">
     <h1>変更</h1><br>
     <table id="newtable">
       	<tr>
		<th>
		<h3>商品名</h3>
		<input type="text" name="foodsname">
		</th>
		<td>
		<h3>購入日</h3>
		<input type="date" name="date" min="2017-06-01">
		</td>
		</tr>
		<tr>		
		<th>
		<h3>値段</h3>
		<input type="text" name="price"> 円
		</th>
		<td>
		<h3>消費期限</h3>
		<input type="date" name="consumptionDate" min="2017-06-01">
		</td>
		<tr>
		<th>
		<h3>数量</h3>
		<input type="number" name="quantity" min="1" max="999" value="1" step="1" required>
		</th>
		<td></td>
		</tr>
		</table>
		<br><br>
		<table id="botton">
		<tr>
		<th>
	 	<input id="submit_buttonc" type="reset" value= "リセット">
	 	</th>
	 	<td>
		<input id="submit_buttond" type= "submit" value= "決定">
		</td>
		</table>
		</form>
		<br>
		<a href="main.jsp"><input id="submit_buttonb" type= "submit" value= "キャンセル"></a>
		</article>
	 <jsp:include page="footer.jsp"></jsp:include>
     </body>
</html>