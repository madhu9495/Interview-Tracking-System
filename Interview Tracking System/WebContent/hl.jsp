<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a.ex3:hover, a.ex3:active {
background: skyblue;
}
a:link{
 text-decoration:none;
}
</style>
<script type="text/javascript">
        window.history.forward();
        function noBack()
        {
            window.history.forward();
        }
</script>
</head>
<body background="D:\standing.jpg" onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<p align="right">
<a href="Administrator.jsp" target="_parent" class="ex3">Home&nbsp;&nbsp;</a>
&nbsp;&nbsp;<a href="logout" target="_parent" class="ex3">&nbsp;&nbsp;Logout</a></p>
</body>
</html>