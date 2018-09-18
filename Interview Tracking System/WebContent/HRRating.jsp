<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function valid() {
		if (document.myForm.interviewID.value == "") {
			alert("Please provide interviewID!");
			document.myForm.interviewID.focus();
			return false;
		}
		if (document.myForm.empHRID.value == "") {
			alert("Please provide empHRID!");
			document.myForm.empHRID.focus();
			return false;
		}
		if (document.myForm.empHRRating.value == "") {
			alert("Please provide empHRRating!");
			document.myForm.empHRRating.focus();
			return false;
		}
		else
			{
			if (document.myForm.empHRRating.value <=0&&document.myForm.empHRRating.value>5) {
				alert("Please provide empHRRating in between 1.0 to 5.0");
				document.myForm.empHRRating.focus();
				return false;
			}
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
	<form method="get" action="HRRating" name="myForm"
		onsubmit="return valid();">
		<table bgcolor="#99e6ff" border="0" align="center">
			<tr>
				<td>interviewID
				<td><input type="text" name="interviewID"></td>
			</tr>
			<tr>
				<td>empHRID
				<td><input type="text" name="empHRID"></td>
			</tr>
			<tr>

				<td>empHRRating
				<td><input type="text" name="empHRRating"></td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>