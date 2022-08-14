package com.servlets;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.CustomersDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		CustomersDAO dao = new CustomersDAO(DBConnect.getConn());
		boolean f = dao.deleteCustomer(id);
		
		HttpSession session = req.getSession();
		
		if(f)
		{
			session.setAttribute("successMsg", "Customer Deleted Successfully");
			resp.sendRedirect("edit_customer.jsp");
		}
		else
		{
			session.setAttribute("errorMsg", "Something went wrong");
			resp.sendRedirect("edit_customer.jsp");
		}
	}

}
