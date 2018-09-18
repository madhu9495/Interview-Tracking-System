<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function valid() {
		if (document.myForm.candidateID.value == "") {
			alert("Please provide your candidateID!");
			document.myForm.candidateID.focus();
			return false;
		}
		if (document.myForm.Subjects.value == "") {
			alert("Please provide your Subjects!");
			document.myForm.Subjects.focus();
			return false;
		} else {
			if (document.myForm.Subjects.value.length< 2) {
				alert("Please provide your Subjects! above two letters");
				document.myForm.Subjects.focus();
				return false;
			}
		}
		if (document.myForm.techID.value == "") {
			alert("Please provide your techID!");
			document.myForm.techID.focus();
			return false;
		}
		re = /^\d{2}\-\w{3}\-\d{4}$/;

		if (document.myForm.interviewDate.value == ""||!document.myForm.interviewDate.value.match(re)) {
			alert("Please provide interviewDate! in dd-mmm-yyyy");
			document.myForm.interviewDate.focus();
			return false;
		}
		if (document.myForm.interviewTime.value == "") {
			alert("Please provide your interviewTime!");
			document.myForm.interviewTime.focus();
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
	<form method="post" action="scheduleTech" name="myForm"
		onsubmit="return valid();">
		<table border="0" bgcolor="#ffb3ff" align="center">
			<tr>
				<td>CandidateId:
				<td><input type="text" name="candidateID" /></td>
			</tr>
			<tr>
				<td>Subject:
				<td><input type="text" name="Subject" /></td>
			</tr>
			<tr>
				<td>TechID:
				<td><input type="text" name="techID" /></td>
			</tr>
			<tr>
				<td>InterviewDate:
				<td><input type="text" name="interviewDate" /></td>
			</tr>
			<tr>
				<td>InterviewTime:
				<td><input type="text" name="interviewTime" /></td>
			</tr>
			<tr>
				<td><td><input type="Submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>