<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<table border=0>
<tr>
  <th width="120">interviewID</th>
  <th width="120">candidateID</th>
  <th width="120">techID</th>
  <th width="120">techRating</th>
  <th width="120">empHRID</th>
  <th width="120">empHRRating</th>
</tr>
<tr>
 <td>${view.interviewID}</td>
 <td>${view.candidateID}</td>
 <td>${view.techID}</td>
 <td>${view.techRating}</td>
 <td>${view.empHRID}</td>
 <td>${view.empHRRating}</td>
</tr>
</table>

</body>
</html>