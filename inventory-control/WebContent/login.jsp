<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>ログイン画面</title>
          <link rel="stylesheet" href="css/style.css">
     </head>
     <body>
     <p>refrigerator</p>
     <article>
     <form action="login.do" method="post">
		<h1>ログイン</h1><br>
     <table id="tableb">
		<tr>
		<th>
			<h3>メールアドレス</h3>
		</th>
		<td>
			<input type="text" name="email">	
		</td>
		</tr>
		<tr>
		<th>
			<h3>パスワード</h3>
		</th>
		<td>
			<input type="password" name="password">
		</td>
		</tr>
		</table>
		<br><br>
			<input id="submit_buttona" type= "submit" value= "ログイン">
		<br><br>
			<h3>会員でない方は<a href="new-account.jsp">こちら</a></h3>
	 </form>
	 </article>
     </body>
</html>