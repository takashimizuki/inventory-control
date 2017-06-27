<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>一覧画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
     <jsp:include page="header.jsp"></jsp:include>
     <br><br>
     <table id="maintable">
     <tr>
     <th>
	 <a href="new.jsp"><input id="submit_buttona" type= "submit" value= "新規"></a>
	 </th>
	 <th colspan="6">
	 </tr>
	 <tr>
	 <c:forEach var="columnName" items="${table.columnNames}">
	 <th>
	 ${columnName}
	 </th>
	 </c:forEach>
	 <th colspan="2">
	 </tr>
	 <c:forEach var="record" items="${table.readIndex}">
	 <tr>
	 <c:forEach var="data" items="${record}">
	 <td>${data}</td>
	 </c:forEach>
     <td><a href="edit.jsp"><input id="submit_buttond" type= "submit" value= "変更"></a></td>
	 <td><a href="remove.do"><input id="submit_buttond" type= "submit" value= "削除"></a></td>
	 </tr>
	 </c:forEach>
	 </table>
	 </body>
</html>