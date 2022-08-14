package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.entity.Customers;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private LoginDAO loginDao;
	
	
	 public void init() {
	        loginDao = new LoginDAO();
	    }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Customers cust = new Customers();
        cust.setEmail(email);
		cust.setPassword(password);
		HttpSession session = request.getSession();
		try {
            if (loginDao.validate(cust)) {
            	session.setAttribute("successMsg", "Login Successfully");
                response.sendRedirect("index.jsp");
            } else {
            	session.setAttribute("errorMsg", "Wrong Credential");
    			response.sendRedirect("login_customer.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		
	}

}
