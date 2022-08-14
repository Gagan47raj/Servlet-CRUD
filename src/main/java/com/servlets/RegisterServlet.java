package com.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.CustomersDAO;
import com.entity.Customers;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dateofbirth");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		
		
		Customers customers = new Customers(name,dob,address,email,password,phone);
		
		CustomersDAO dao = new CustomersDAO(DBConnect.getConn());
		
		HttpSession session = req.getSession();
		
		boolean f = dao.addCustomers(customers);
		
		if(f)
		{
			session.setAttribute("successMsg", "Data inserted Successfully");
			resp.sendRedirect("register_customer.jsp");
		}
		else
		{
			session.setAttribute("errorMsg", "Something went wrong");
			resp.sendRedirect("register_customer.jsp");
		}
		
	}

	
}
