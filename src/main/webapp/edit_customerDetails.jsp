<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored ="false" %>   

<%@page import =  "com.dao.CustomersDAO" %>    
<%@page import =  "com.conn.DBConnect" %>  
<%@page import =  "com.entity.Customers"%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css"></link>
<title>Edit Customers Details</title>
</head>
<body>
<%@include file ="navbar.jsp" %>


<form autocomplete='off' class='form' action="update" method="post">
  <div class='control'>
    <h1>
      Edit Details
    </h1>
    
     <c:if test = "${not empty successMsg }">
    <h2>${successMsg}</h2>
    <c:remove var="successMsg"/>
    </c:if>
    
    <c:if test = "${not empty errorMsg }">
    <h2>${errorMsg}</h2>
    <c:remove var = "errorMsg"/>
    </c:if>
    
    <%
    int id = Integer.parseInt(request.getParameter("id"));
    CustomersDAO dao = new CustomersDAO(DBConnect.getConn());
    Customers  cust = dao.getCustomersById(id);
    %>
    
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
    <input name='name' placeholder='Name' type='text' value ="<%=cust.getFullName()%>">
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
    <input name='dateofbirth' placeholder='Date Of Birth' type='date' value ="<%=cust.getDob()%>">
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
    <input name='address' placeholder='Address' type='text' value ="<%=cust.getAddress()%>" >
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
    <input name='email' placeholder='Email' type='email' value ="<%=cust.getEmail()%>">
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
    <input name='password' placeholder='Password' type='password' value ="<%=cust.getPassword()%>">
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
    <input name='password' placeholder='Password' type='password' value ="<%=cust.getPhone()%>">
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
  
  <input type="hidden" name = "id" value="<%=cust.getId()%>">
  
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
     Update Data
    </div>
  </button>
</form>
</body>
</html>