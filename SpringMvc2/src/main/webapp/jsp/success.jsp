<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1 class="text-center">${head}</h1>
 <p class="text-center">${desc}</p>
 <hr>
 
 <h1>Welcome back to our site...!</h1>
 <h2>Your_name is:${user.name}</h2>
 <h2>your_Email is:${user.email}</h2>
 <h2>Your_PasswordUserName is:${user.pwd}</h2>
</body>
</html>