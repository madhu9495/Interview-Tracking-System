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
		var radios = document.getElementsByName("result");
	    var formValid = false;

	    var i = 0;
	    while (!formValid && i < radios.length) {
	        if (radios[i].checked) formValid = true;
	        i++;        
	    }

	    if (!formValid) alert("please choose result");
	    return formValid;
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
	<form method="get" action="Finalresult" name="myForm" onsubmit="return valid();">
		<table align="center" bgcolor="#99e6ff" border="0">
			<tr>
				<td>interviewID
				<td><input type="text" name="interviewID"></td>
			</tr>
			<tr>
				<td>result
				<td><input type="radio" value="Selected" name="result">selected
					<input type="radio" value="Not Selected" name="result">Not
					selected</td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>