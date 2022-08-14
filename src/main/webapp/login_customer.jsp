<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored ="false" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css"></link>
<title>Add new customer</title>
</head>
<body>
<%@include file ="navbar.jsp" %>


<form autocomplete='off' class='form' action="login" method="post">
  <div class='control'>
    <h1>
      Login
    </h1>
    
    <c:if test = "${not empty successMsg }">
    <h2>${successMsg}</h2>
    <c:remove var="successMsg"/>
    </c:if>
    
    <c:if test = "${not empty errorMsg }">
    <h2>${errorMsg}</h2>
    <c:remove var = "errorMsg"/>
    </c:if>
    
  </div>
  
  
   
  
  
  
  <div class='control block-cube block-input'>
    <input name='email' placeholder='Email' type='email'>
    <div class='bg-top'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg-right'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg'>
      <div class='bg-inner'></div>
    </div>
  </div>
  

  
  
  
  <div class='control block-cube block-input'>
    <input name='password' placeholder='Password' type='password'>
    <div class='bg-top'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg-right'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg'>
      <div class='bg-inner'></div>
    </div>
  </div>
  
  <button class='btn block-cube block-cube-hover' type='submit'>
    <div class='bg-top'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg-right'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg'>
      <div class='bg-inner'></div>
    </div>
    <div class='text'>
     Login
    </div>
  </button>
  <br><br><br>
   <button class='btn block-cube block-cube-hover' type='submit'>
    <div class='bg-top'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg-right'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg'>
      <div class='bg-inner'></div>
    </div>
    <div class='text'>
     Reset Password
    </div>
  </button>
</form>
</body>
</html>