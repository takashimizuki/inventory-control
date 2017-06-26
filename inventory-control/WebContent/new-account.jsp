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
		<table>
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
			<input type="text" name="accountname">
		</td>
		</tr>
		</table>
		<br><br>
		<input id="submit_buttonc" type="reset" value= "リセット">
		<input id="submit_buttond" type= "submit" value= "登録">
		</form>
		<br>		
		<a href="login.jsp"><input id="submit_buttonb" type= "submit" value= "キャンセル"></a>
		</article>
     </body>
</html>