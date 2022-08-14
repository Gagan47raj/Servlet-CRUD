package com.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.DBConnect;
import com.entity.Customers;

public class LoginDAO {

	
	public boolean validate(Customers custLogin) throws ClassNotFoundException{
		
		boolean status = false;
		
		CustomersDAO dao = new CustomersDAO(DBConnect.getConn());
		
		try(PreparedStatement PS = DBConnect.getConn().prepareStatement("select * from customers where email=? and password = ?")) {
					{
				 PS.setString(1, custLogin.getEmail());
				 PS.setString(2, custLogin.getPassword());
				 
				 System.out.print(PS);
				 ResultSet rs = PS.executeQuery();
				 status =rs.next();
					}
			
		}catch(SQLException ex)
		{
			printSQLException(ex);	
			}
		return status;
		
	}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
