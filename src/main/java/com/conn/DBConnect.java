package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private  static Connection conn = null;
	

	
	public static Connection getConn()
	{
		String url = "jdbc:mysql://localhost:3306/customer_db";
		String userId = "root";
		String pass = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
			conn = DriverManager.getConnection(url,userId,pass);

		}catch(Exception ex)
		{
           ex.printStackTrace();
		}
		return conn;
	}
}
