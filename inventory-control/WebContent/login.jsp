<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>ログイン画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
     <jsp:include page="header.jsp"></jsp:include>
     <article>
     <form action="login.do" method="post">
		<h1>ログイン</h1><br>
		<div>
			<h3>メールアドレス</h3>
			<input type="text" name="email">	
			<h3>パスワード</h3>
			<input type="password" name="password">
		</div>
		<br><br>
			<input type= "submit" value= "ログイン">
		<br><br>
			<h3>会員でない方は<a href="new-account.jsp">こちら</a></h3>
	 </form>
	 </article>
     </body>
</html>