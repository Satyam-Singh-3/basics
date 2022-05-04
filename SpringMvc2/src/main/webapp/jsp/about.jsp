<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page isELIgnored="false" %>   
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>This is about page..!</h1>
<%--  <% 
   String sa=(String)request.getAttribute("s");
 
   LocalDateTime dateTime=(LocalDateTime)request.getAttribute("satyam");
 %>
 <h1><%=sa %></h1>
 
 <h1><%=dateTime.toString() %></h1> --%>
 ${s}
 ${satyam}
</body>
</html>