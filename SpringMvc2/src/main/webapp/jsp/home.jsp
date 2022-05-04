<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Hello welcome..!</h1>
 <%
       String name=(String)request.getAttribute("name");
       List<String>name1=(List<String>)request.getAttribute("L"); 
 %>
<h1>My_Name_is=><%=name %></h1> 

<%
 for(String f:name1)
 {
%> 
<h1><%=f %></h1>
<%
 }
 %>
</body>
</html>