<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function valid() {
		if (document.f1.userID.value == "") {
			alert("Please provide your userid!");
			document.f1.userID.focus();
			return false;
		}
		if (document.f1.password.value == "") {
			alert("Please enter your old password!");
			document.f1.password.focus();
			return false;
		}
		if (document.f1.newpassword.value == "") {
			alert("Please enter your new password!");
			document.f1.newpassword.focus();
			return false;
		}
		if (document.f1.confirmpassword.value == "") {
			alert("Please enter confirm password!");
			document.f1.confirmpassword.focus();
			return false;
		}
		if (document.f1.newpassword.value != (document.f1.confirmpassword.value)) {
			alert("Please enter same password");
			document.f1.confirmpassword.focus();
			return false;
		}
	}
</script>
<style>
table {
    border-collapse: collapse;
    width: 70%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
	<form name="f1" method="get" action=changepassword
		onsubmit="return valid()">
		<table bgcolor="#99e6ff" border="0" align="center">
			<tr>
				<td>Userid
				<td><input type=text name=userID></td>
			</tr>
			<tr>
				<td>old password
				<td><input type=password name=password></td>
			</tr>
			<tr>
				<td>new password
				<td><input type=password name=newpassword></td>
			</tr>
			<tr>
				<td>confirm password
				<td><input type=password name=confirmpassword></td>
			</tr>
			<tr>
				<td>
				<td><input type=submit value="changepassword"></td>
			</tr>
		</table>
	</form>
</body>