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
			alert("Please provide your interviewID!");
			document.myForm.interviewID.focus();
			return false;
		}
		if (document.myForm.empHRID.value == "") {
			alert("Please provide your empHRID!");
			document.myForm.empHRID.focus();
			return false;
		}
		re = /^\d{2}\-\w{3}\-\d{4}$/;

		if (document.myForm.empHRInterviewDate.value == ""||!document.myForm.interviewDate.value.match(re)) {
			alert("Please provide empHRInterviewDate! in dd-mmm-yyyy");
			document.myForm.empHRInterviewDate.focus();
			return false;
		}
		if (document.myForm.empHRInterviewTime.value == "") {
			alert("Please provide your empHRInterviewTime!");
			document.myForm.empHRInterviewTime.focus();
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
	<form method="post" action="scheduleHR" name="myForm"
		onsubmit="return valid();">
		<table bgcolor="#99e6ff" border="0" align="center">
			<tr>
				<td>interviewID:
				<td><input type="text" name="interviewID" /></td>
			</tr>
			<tr>
				<td>EmpHRID:
				<td><input type="text" name="empHRID" /></td>
			</tr>
			<tr>
				<td>EmpHRInterviewDate:
				<td><input type="text" name="empHRInterviewDate" /></td>
			</tr>
			<tr>
				<td>EmpHRInterviewTime:
				<td><input type="text" name="empHRInterviewTime" /></td>
			</tr>
			<tr>
				<td>
				<td><input type="Submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>