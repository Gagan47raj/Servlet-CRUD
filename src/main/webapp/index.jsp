

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css"></link>
<title>Home</title>
</head>
<body>

<%@include file = "navbar.jsp" %>

 <c:if test = "${not empty successMsg }">
    <h2>${successMsg}</h2>
    <c:remove var="successMsg"/>
    </c:if>
    
    <c:if test = "${not empty errorMsg }">
    <h2>${errorMsg}</h2>
    <c:remove var = "errorMsg"/>
    </c:if>

</body>
</html>