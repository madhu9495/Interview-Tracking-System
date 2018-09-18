<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style >
h1{

  font-size: 40px;
}
h2 {
    font-size: 30px;
}
</style>
</head>
<body background="D:\INTERVIEW.jpg">

<table border="0" CELLPADDING="5" CELLSPACING="8" align="center">
		  <caption align="center">
			<p align="center">
				<font  color="red"><h1>UserId or Password Incorrect<h1></font>
			</p>
		</caption>
<form method="post" action="login">
			<tr>
			<td><h2>UserID</h2></td>
				<td><input type="text" name="userID" maxlength="8"
					style="height:40px;width:270px"></td>
			</tr>

			<tr>
			<td><h2>Password</h2></td>
				<td><input type="password" name="password" maxlength="8"
					style="height:40px;width:270px"></td>
			</tr>

			<tr>
				<td><td><p align="center"><input type="submit" value="login" style="height:40px;width:90px"/></td>
			</tr>
</form>
</table>
</pre>
</body>
</html>
