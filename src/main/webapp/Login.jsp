<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="vast.css" rel="stylesheet"/>


<script>
function redirectToRegister() {
  window.location.href = "Register.jsp";  
}

</script>
</head>
<body>
<header>
<h1>TNPSC Exam Mgnt System</h1>
<div><a href="index.jsp">Home</a></div>
</header>
<article>
<div class="ahead">Login</div>
<c:if test="${not empty errorMessage}">
    <div class="error">${errorMessage}</div>
</c:if>
<form action="login"  >
<div class="loginfrm">
<section>
<div>User Name</div>
<div><input type="text" name="txtname"/></div>
</section>

<section>
<div>Password</div>
<div><input type="password" name="txtpass"/></div>
</section>
<div><input type="submit" value="login"/>
<!--  <input type="button" value="Register" onclick="redirectToRegister()"/>-->
</div>
</div>
</form>
</article>
</body>
</html>