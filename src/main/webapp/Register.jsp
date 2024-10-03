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
<h1>Registration Form</h1>
<div><a href="index.jsp">Home</a></div>
</header>
<article>
<div class="ahead">Register</div>
<c:if test="${not empty errorMessage}">
    <div class="error">${errorMessage}</div>
</c:if>
<form action="register" >
<div class="loginfrm">
<section>
<div>User Name</div>
<div><input type="text" name="txtname"/></div>
</section>

<section>
<div>Email</div>
<div><input type="email" name="txtemail"/></div>
</section>
<section>
<div>Password</div>
<div><input type="password" name="txtpass"/></div>
</section>

<section>
<div>confrmPassword</div>
<div><input type="password" name="txtconfrmpass"/></div>
</section>

<div>
<input type="submit" value="Register"/>
</div>
</div>
</body>
</html>