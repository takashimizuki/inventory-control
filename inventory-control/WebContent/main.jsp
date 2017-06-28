<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>一覧画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
     <jsp:include page="header.jsp"></jsp:include>
     
     <sql:query var="table" dataSource="ds/elsamariadb">
	 SELECT a.name, b.price, b.quantity, b.date, b.consumptionDate FROM FOODS a JOIN PURCHASE b ON a.id = b.foodsId;
	 </sql:query>
	 
     <br><br>
     <table id="maintable">
     <tr>
     <th>
	 <a href="new.jsp"><input id="submit_buttona" type= "submit" value= "新規"></a>
	 </th>
	 <th colspan="6">
	 </tr>
	 <tr>
	 <th>
	 <h3>商品名</h3>
	 </th>
	 <th>	 
	 <h3>値段(円)</h3>
	 </th>
	 <th>
	 <h3>数量</h3>
	 </th>
	 <th>
	 <h3>購入日</h3>
	 </th>
	 <th>
	 <h3>消費期限</h3>
	 </th>
	 <th colspan="2">
	 </tr>
	 <c:forEach var="record" items="${table.rowsByIndex}">
	 <tr>
	 <c:forEach var="data" items="${record}">
	 <td>${data}</td>
	 </c:forEach>
     <td>
     <form action="edit.do">
     <a href="edit.jsp"><input id="submit_buttond" type= "submit" value= "変更"></a>
     </form>
     </td>
	 <td>
     <form action="remove.do">
	 <input id="submit_buttonb" type= "submit" value= "削除">
	 </form>
	 </td>
	 </tr>
	 </c:forEach>
	 </table>
	 <jsp:include page="footer.jsp"></jsp:include>
	 </body>
</html>