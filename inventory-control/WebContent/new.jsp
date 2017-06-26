<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>新規画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
     <jsp:include page="header.jsp"></jsp:include>
     <article>
	 <form action="new.do" method="post">
     <h1>新規</h1><br>    
		<div class="blocka">		
			<h3>商品名</h3>
			<input type="text" name="foodsname">		
			<h3>値段</h3>
			￥<input type="text" name="price">	
			<h3>数量</h3>
		<input type="number" name="quantity" min="1" max="999" value="1" step="1" required>
		</div>
		<div class="blockb">
			<h3>購入日</h3>
		<input type="date" name="date" min="2017-07-01">
			<h3>消費期限</h3>
		<input type="date" name="consumptionDate" min="2017-07-01">
			<br><br><br>
		</div>
		<input type="reset" value= "リセット">
		<input type= "submit" value= "決定">
		</form>
		<a href="main.jsp"><input type= "submit" value= "キャンセル"></a>
		</article>
     </body>
</html>