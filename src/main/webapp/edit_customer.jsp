<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import =  "com.dao.CustomersDAO" %>    
<%@page import =  "com.conn.DBConnect" %>    
<%@page import =  "java.util.*" %>    
<%@page import =  "com.entity.Customers"%>    


 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" ></link>
<title>Edit Customers</title>
</head>
<body>
<%@include file ="navbar.jsp" %>
<div class="container">
  <h2>All Users Details</h2>
  <ul class="responsive-table">
    <li class="table-header">
      <div class="col col-1">ID</div>
      <div class="col col-2">Customer Name</div>
      <div class="col col-3">Date Of Birth</div>
      <div class="col col-4">Address</div>
      <div class="col col-5">Email</div>
      <div class="col col-6">Password</div>
      <div class="col col-7">Phone</div>
      <div class="col col-8">Action</div>
    </li>	
    
   
    <%
    CustomersDAO dao = new CustomersDAO(DBConnect.getConn());
    List<Customers> list = dao.getAllCustomers();
    for(Customers cust : list){ 
    %>
    
    <li class="table-row">
      <div class="col col-1" data-label="ID"><%=cust.getId() %></div>
      <div class="col col-2" data-label="Customer Name"><%=cust.getFullName() %></div>
      <div class="col col-3" data-label="Date Of Birth"><%=cust.getDob() %></div>
      <div class="col col-4" data-label="Address"><%=cust.getAddress() %></div>
      <div class="col col-5" data-label="Email"><%=cust.getEmail()%></div>
      <div class="col col-6" data-label="Password"><%=cust.getPassword()%></div>
      <div class="col col-7" data-label="Phone"><%=cust.getPhone()%></div>
      <div class="col col-8" data-label="Action">
  <div class="button2">
  <span></span>
  <span></span>
  <span></span>
  <span></span>
  <a href="edit_customerDetails.jsp?id=<%=cust.getId()%>">
  Edit
  </a>
</div>

  <div class="button2">
  <span></span>
  <span></span>
  <span></span>
  <span></span>
  <a href="delete?id=<%=cust.getId()%>">
  Delete
  </a>
</div>
      </div>
    </li>
    	
    <% 
    }
    %>
    
    
    
  </ul>
</div>
</body>
</html>