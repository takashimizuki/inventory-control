<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>新規会員登録画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
     <jsp:include page="header.jsp"></jsp:include>
     	<article>
        <form action="new-account.do" method="post">
		<h1>新規会員登録</h1><br>
		<div>
			<h3>メールアドレス</h3>
			<input type="text" name="email">	
			<h3>パスワード</h3>
			<input type="password" name="password">	
			<h3>ユーザー名</h3>
			<input type="text" name="accountname">
		</div>
		<br><br>
		<input type="reset" value= "リセット">
		<input type= "submit" value= "登録">
		</form>
		<a href="login.jsp"><input type= "submit" value= "キャンセル"></a>
		</article>
     </body>
</html>