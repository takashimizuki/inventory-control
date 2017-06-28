<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>新規会員登録画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
        <p>refrigerator</p>
     	<article>
        <form action="new-account.do" method="post">
		<h1>新規会員登録</h1><br>
     <table id="tableb">
		<tr>
		<th>
			<h3>メールアドレス</h3>
		</th>
		<td>
			<input type="text" name="email">	
		</td>
		<tr>
		<th>
			<h3>パスワード</h3>
		</th>
		<td>
			<input type="password" name="password">	
		</td>
		<tr>
		<th>
			<h3>ユーザー名</h3>
		</th>
		<td>
			<input type="text" name="username">
		</td>
		</tr>
		</table>
		<br>
		<table id="botton">
		<tr>
		<th>
	 	<input id="submit_buttonc" type="reset" value= "リセット">
	 	</th>
	 	<td>
		<input id="submit_buttond" type= "submit" value= "登録">
		</td>
		</table>
		</form>
		<br>
		<a href="login.jsp"><input id="submit_buttonb" type= "submit" value= "キャンセル"></a>
		</article>
	 <jsp:include page="footer.jsp"></jsp:include>
     </body>
</html>