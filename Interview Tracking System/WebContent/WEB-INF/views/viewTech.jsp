<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<c:if test="${!empty listinterview}">

	<table class="tg" border="0">
	 <tr>
		<th width="120">candidateID</th>
		<th width="120">primarySkills</th>
		<th width="120">secondarySkills</th>
		<th width="120">experience</th>
		<th width="120">qualification</th>
		<th width="120">designation</th>
		<th width="120">noticePeriod</th>
		<th width="120">location</th>
		
	</tr>
	<c:forEach items="${listinterview}" var="candidate">
		<tr>
			<td>${candidate.candidateID}</td>
			<td>${candidate.primarySkills}</td>
			<td>${candidate.secondarySkills}</td>
			<td>${candidate.experience}</td>
		    <td>${candidate.qualification}</td>
			<td>${candidate.designation}</td>
			<td>${candidate.noticePeriod}</td>
			<td>${candidate.location}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>