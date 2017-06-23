<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>変更画面</title>
     </head>
     <body>
	 <form action="new-account" method="post">
     <h1>変更</h1>
		<div>
			<h3>商品コード</h3>
			<select name="foodsId">
			<option value="1"></option>
			<option value="2"></option>
			<option value="3"></option>
			</select>
		</div>
		<div>		
			<h3>商品名</h3>
			<input type="text" name="foodsname">
		</div>
		<div>		
			<h3>値段</h3>
			￥<input type="text" name="price">
		</div>
		<div>		
			<h3>数量</h3>
		<input type="number" name="quantity" min="1" max="999" value="1" step="1" required>
		</div>
		<div>
			<h3>購入日</h3>
		<input type="date" name="date" min="2017-07-01">
		</div>
		<div>
			<h3>消費期限</h3>
		<input type="date" name="consumptionDate" min="2017-07-01">
		</div>
				<br><br>
		<input type="reset" value= "リセット">
		<input type= "submit" value= "決定">
		</form>
		<a href="main.jsp"><input type= "submit" value= "キャンセル"></a>
     </body>
</html>