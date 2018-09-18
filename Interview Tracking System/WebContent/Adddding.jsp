<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
 
	function valid() {
		if (document.myForm.primarySkills.value == "") {
			alert("Please provide your primarySkills!");
			document.myForm.primarySkills.focus();
			return false;
		}

		if (document.myForm.secondarySkills.value == "") {
			alert("Please provide your secondarySkills!");
			document.myForm.secondarySkills.focus();
			return false;
		}

		if (document.myForm.experience.value == "")
			alert("Please provide your experience!");
		if (isNaN(document.myForm.experience.value)
				|| document.myForm.experience.value >= 1) {
			alert("Please provide valid experience!");
			document.myForm.experience.focus();
			return false;
		}

		/*if (document.myForm.shareDetails.value == "")
			alert("Please provide your shareDetails!");
		if (isNaN(document.myForm.shareDetails.value)
				|| document.myForm.shareDetails.value >= 4) {
			alert("Please provide valid shareDetails!");
			document.myForm.shareDetails.focus();
			return false;
		}*/
		if (document.myForm.qualification.value == "") {
			alert("Please provide your qualification!");
			document.myForm.qualification.focus();
			return false;
		}
		if (document.myForm.firstName.value == "") {
			alert("Please provide your firstName!");
			document.myForm.firstName.focus();
			return false;
		}
		if (document.myForm.lastName.value == "") {
			alert("Please provide your lastName!");
			document.myForm.lastName.focus();
			return false;
		}
		if (document.myForm.gender.value=="") {
			alert("Please provide your gender!");
			document.myForm.gender.focus();
			return false;
		}
		if (document.myForm.pincode.value == ""
				|| isNaN(document.myForm.pincode.value)
				|| document.myForm.pincode.value.length != 6) {
			alert("Please provide a pincode in the format 533105.");
			document.myForm.pincode.focus();
			return false;
		}
		if (document.myForm.mobileNo.value=="") {
			alert("Please provide your mobileNo!");
			document.myForm.mobileNo.focus();
			return false;
		}
		if (document.myForm.emailID.value=="") {
			alert("Please provide your emailID!");
			document.myForm.emailID.focus();
			return false;
		}
	}
	function ValidateAlpha() {
		var keyCode = window.event.keyCode;
		if ((keyCode< 65 || keyCode>90) && (keyCode<97 || keyCode>123)
				&& keyCode != 32) {
			window.event.returnValue = false;
			alert("Only alphabets or space..please");
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
<center>
<form method="post" action="Adding" name="myForm" onsubmit="return valid();">
<table bgcolor="#99e6ff" border="0" align="center">
<tr><td>PrimarySkills:<td><input type="text" name="primarySkills"/>
<tr><td>SecondarySkills:<td><input type="text" name="secondarySkills"/>
<tr><td>Experience:<td><input type="text" name="experience"/>
<tr><td>Qualification:<td><input type="text" name="qualification"/>
<tr><td>Designation:<td><input type="text" name="designation"/>
<tr><td>NoticePeriod:<td><input type="text" name="noticePeriod"/>
<tr><td>Location:<td><input type="text" name="location"/>
<tr><td>Firstname:<td><input type="text" name="firstName" onkeypress="return ValidateAlpha();"/>
<tr><td>Lastname:<td><input type="text" name="lastName" onkeypress="return ValidateAlpha();"/>
<tr><td>Dateofbirth:<td><input type="text" name="dateOfBirth"/>
<tr><td>Gender:<td><input type="text" name="gender"/>
<tr><td>Street:<td><input type="text" name="street"/>
<tr><td>City:<td><input type="text" name="city"/>
<tr><td>State:<td><input type="text" name="state"/>
<tr><td>Pincode:<td><input type="text" name="pincode"/>
<tr><td>MobileNo:<td><input type="text" name="mobileNo"/>
<tr><td>EmailId:<td><input type="text" name="emailID"/>
<tr><td><td><input type="Submit" value="submit"/>
</table>
</form>
</center>
</body>
</html>