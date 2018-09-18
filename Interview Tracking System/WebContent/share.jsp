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
			alert("Please provide candidateID!");
			document.myForm.candidateID.focus();
			return false;
		}
		var radios = document.getElementsByName("panel");
	    var formValid = false;

	    var i = 0;
	    while (!formValid && i < radios.length) {
	        if (radios[i].checked) formValid = true;
	        i++;        
	    }

	    if (!formValid) alert("please choose panel");
	    return formValid;
	}
</script>
<style>
table {
    border-collapse: collapse;
    width: 60%;
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
	<form action="share" method="get" name="myForm"
		onsubmit="return valid();">
		<table bgcolor="#99e6ff" border="0" align="center">
			<tr>
				<td>candidateID
				<td><input type="text" name="candidateID"></td>
			</tr>
			<tr>
				<td>shareDetails
				<td><input type="radio" value="Tech" name="panel">Tech
					<input type="radio" value="HR" name="panel">HR <input
					type="radio" value="All" name="panel">All</td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>