<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:if test="${!empty param.id && empty error}">
	<sql:query var="rs" dataSource="ds/elsamariadb">
	 SELECT b.id, a.name, b.price, b.quantity, b.date, b.consumptionDate FROM FOODS a JOIN PURCHASE b ON a.id = b.foodsId WHERE b.id = '${param.id}';
	</sql:query>
</c:if>

<c:set var="purchase" value="${rs.rows[0]}"/>


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
	 <form action="edit.do?id=${param.id}" method="post">
     <h1>変更</h1><br>
     <table id="newtable">
       	<tr>
		<th>
		<h3>商品名</h3>
		<input type="text" name="foodsname" value="${purchase.name}">
		</th>
		<td>
		<h3>購入日</h3>
		<input type="date" name="date" min="2017-06-01" value="${purchase.date}">
		</td>
		</tr>
		<tr>		
		<th>
		<h3>値段</h3>
		<input type="text" name="price" value="${purchase.price}">
		</th>
		<td>
		<h3>消費期限</h3>
		<input type="date" name="consumptionDate" min="2017-06-01" value="${purchase.consumptionDate}">
		</td>
		<tr>
		<th>
		<h3>数量</h3>
		<input type="number" name="quantity" min="1" max="999" value="${purchase.quantity}" step="1" required>
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