package com.servlets;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.CustomersDAO;
import com.entity.Customers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dateofbirth");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		int id = Integer.parseInt(req.getParameter("id")); 
			
			
			
			Customers customers = new Customers(id,name,dob,address,email,password,phone);
			
			CustomersDAO dao = new CustomersDAO(DBConnect.getConn());
			
			HttpSession session = req.getSession();
			
			boolean  f = dao.updateCustomer(customers);
			
			if(f)
			{
				session.setAttribute("successMsg", "Data Updated Successfully");
				resp.sendRedirect("edit_customer.jsp");
			}
			else
			{
				session.setAttribute("errorMsg", "Something went wrong");
				resp.sendRedirect("edit_customer.jsp");
			}
		
		
		
		
	}

}
