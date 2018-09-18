<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function valid() {
	if (document.myform.skills.value == "") {
		alert("Please provide Skills!");
		document.myform.skills.focus();
		return false;
	}
	if (document.myform.experience.value == "") {
		alert("Please provide experience!");
		document.myform.experience.focus();
		return false;
	}
	else
		{
		if (document.myform.experience.value <0.1 || document.myform.experience.value>0.99) {
			alert("Please provide qualification! above 0.1 and below 0.99");
			document.myform.experience.focus();
			return false;
		}
		}
	if (document.myform.qualification.value == "") {
		alert("Please provide qualification!");
		document.myform.qualification.focus();
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
	<form action="search" method="get" name=myform onsubmit="return valid();">
		<table border="0" bgcolor="#ffb3ff" align="center">
			<tr>
				<td>Skills
				<td><input type="text" name="skills" value=""></td>
			</tr>
			<tr>
				<td>Experience
				<td><input type="text" name="experience" value=""></td>
			</tr>
			<tr>
				<td>Qualification
				<td><input type="text" name="qualification" value=""></td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="ok"></td>
			</tr>
		</table>
	</form>
</body>
</html>