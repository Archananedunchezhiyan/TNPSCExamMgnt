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
<h1> TNPSC Exam Management System</h1>
<div>
<% if(null==session.getAttribute("login")){%>
 <a href="<%=response.encodeURL("Login.jsp")%>">Login</a>

<%}else{ %>
<a href="Logout">Logout</a>

<%} %>
</div>
</header>
<article>
<div class="ahead">
<nav>

<div><a href="<%=response.encodeURL("Apply.jsp")%>">Apply</a></div>
<div><a href="<%=response.encodeURL("Group1Exam.jsp")%>">Group1 Exam</a></div>
<div><a href="<%=response.encodeURL("Group2Exam.jsp")%>">Group2 Exam</a></div>
<div><a href="<%=response.encodeURL("Group2AExam.jsp")%>">Group2A Exam</a></div>
<div><a href="<%=response.encodeURL("Group4Exam.jsp")%>">Group4 Exam</a></div>


</nav>
</div>


</article>

<div class="err">${requestScope.res}</div>

</body>
</html>