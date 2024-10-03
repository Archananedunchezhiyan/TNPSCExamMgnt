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
<h1>Application form</h1>
<div><a href="">Home</a></div>
</header>
 <article>
<div class="ahead">Apply Group4 Exam</div>
<div class="err">${requestScope.msg}</div>
<form action="group4">
<div class="loginfrm">
<section>
<div>User Name</div>
<div><input type="text" name="txtname"/></div>
</section>

<section>
<div>Age</div>
<div><input type="number" name="txtage"/></div>
</section>

<section>
<div>Degree</div>
<div><input type="text" name="txtdegree"/></div>
</section>

<section>
<div>Location</div>
<div><input type="text" name="txtloc"/></div>
</section>
<div><input type="submit" value="Apply"/></div>
</div>
</form>
</article>
</body>
</html>