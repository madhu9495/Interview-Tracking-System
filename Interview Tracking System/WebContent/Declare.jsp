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
		var radios = document.getElementsByName("shareResult");
	    var formValid = false;

	    var i = 0;
	    while (!formValid && i < radios.length) {
	        if (radios[i].checked) formValid = true;
	        i++;        
	    }

	    if (!formValid) alert("please choose shareResult");
	    return formValid;
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
	<form method="get" action="Declare" name="myForm"
		onsubmit="return valid();">
		<table align="center" border="0" bgcolor="#ffb3ff">
			<tr>
				<td>interviewID
				<td><input type="text" name="interviewID"></td>
			</tr>
			<tr>
				<td>shareResult
				<td><input type="radio" value=1 name="shareResult">Tech
					<input type="radio" value=2 name="shareResult">HR <input
					type="radio" value=3 name="shareResult">ALL</td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>