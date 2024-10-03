<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="vast.css" rel="stylesheet"/>
</head>
<body>

<header>
<h1>TNPSC Exam Management System</h1>
<div><a href="index.jsp">home</a></div>
</header>
<article>
<div class="ahead">Apply for the Exam</div>
<div class="err">${requestScope.msg}</div>
<form>
<div class="assign">
<nav>

<div><a href="<%=response.encodeURL("ApplyG1.jsp")%>">Apply Group1 Exam</a></div>
<div><a href="<%=response.encodeURL("ApplyG2.jsp")%>">Apply Group2 Exam</a></div>
<div><a href="<%=response.encodeURL("ApplyG2A.jsp")%>">Apply Group2A Exam</a></div>
<div><a href="<%=response.encodeURL("ApplyG4.jsp")%>">Apply Group4 Exam</a></div>


</nav>

</div>

</form>
</article>
</body>
</html>