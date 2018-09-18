<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function valid() {
		if (document.myForm.empHRID.value == "") {
			alert("Please provide empHRID!");
			document.myForm.empHRID.focus();
			return false;
		}
		re = /^\d{2}\-\w{3}\-\d{4}$/;

		if (document.myForm.empHRInterviewDate.value == ""||!document.myForm.interviewDate.value.match(re)) {
			alert("Please provide empHRInterviewDate! in dd-mmm-yyyy");
			document.myForm.empHRInterviewDate.focus();
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
	<form method="get" action="searchHr" name="myForm"
		onsubmit="return valid();">
		<table border="0" bgcolor="#ffb3ff" align="center">
			<tr>

				<td>EmpHRID
				<td><input type="text" name="empHRID"></td>
			</tr>
			<tr>
				<td>EmpHRInterviewDate
				<td><input type="text" name="empHRInterviewDate"></td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="submit"></td>


			</tr>
		</table>
	</form>
</body>
</html>