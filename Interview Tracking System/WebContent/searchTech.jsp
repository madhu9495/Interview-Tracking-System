<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function valid() {
		if (document.myForm.techID.value == "") {
			alert("Please provide techID!");
			document.myForm.techID.focus();
			return false;
		}
		re = /^\d{2}\-\w{3}\-\d{4}$/;

		if (document.myForm.interviewDate.value == ""||!document.myForm.interviewDate.value.match(re)) {
			alert("Please provide interviewDate! in dd-mmm-yyyy");
			document.myForm.interviewDate.focus();
			return false;
		}

	}
</script>
<style>
table {
    border-collapse: collapse;
    width: 50%;
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
	<form method="get" action="seachTech" name="myForm"
		onsubmit="return valid();">
		<table border="0" bgcolor="#ffb3ff" align="center">
			<tr>
				<td>TechId
				<td><input type="text" name="techID"></td>
			</tr>
			<tr>
				<td>InterviewDate
				<td><input type="text" name="interviewDate"></td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>