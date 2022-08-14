package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.entity.Customers;

public class CustomersDAO {

	private Connection conn;

	
	public CustomersDAO(Connection conn)
	{
		super();
		this.conn = conn;
	}
	
	public boolean addCustomers(Customers customers)
	{
		boolean f = false;
		
		try {
			
			String sqlINS = "insert into customers(name,dob,address,email,password,phone) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sqlINS);
			
			ps.setString(1, customers.getFullName());
			ps.setString(2, customers.getDob());
			ps.setString(3, customers.getAddress());
			ps.setString(4, customers.getEmail());
			ps.setString(5, customers.getPassword());
			ps.setString(6, customers.getPhone());
			
		    int i = ps.executeUpdate();
		    
		    if(i==1)
		    {
		    	f  = true;
		    }
		    
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return f;
	}
	
	public List<Customers> getAllCustomers()
	{
		List<Customers> list = new ArrayList<Customers>();
		Customers cust = null;
		
		try {
			String sqlGet = "select * from customers";
			PreparedStatement ps = conn.prepareStatement(sqlGet);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cust = new Customers();
				cust.setId(rs.getInt(1));
				cust.setFullName(rs.getString(2));
				cust.setDob(rs.getString(3));
				cust.setAddress(rs.getString(4));
				cust.setEmail(rs.getString(5));
				cust.setPassword(rs.getString(6));
				cust.setPhone(rs.getString(7));
				list.add(cust);
			}
			
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return list;
	}
	
	public Customers getCustomersById(int id)
	{
		Customers cust = null;
		
		try {
			String sqlGet = "select * from customers where id = ? ";
			PreparedStatement ps = conn.prepareStatement(sqlGet);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cust = new Customers();
				cust.setId(rs.getInt(1));
				cust.setFullName(rs.getString(2));
				cust.setDob(rs.getString(3));
				cust.setAddress(rs.getString(4));
				cust.setEmail(rs.getString(5));
				cust.setPassword(rs.getString(6));
				cust.setPhone(rs.getString(7));
			}
			
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return cust;
	}
	
	public boolean updateCustomer(Customers customers)
	{
		boolean f = false;
		
		try {
			
			String sqlUPD = "update customers set name=?,dob=?,address=?,email=?,password=?,phone=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sqlUPD);
			
			ps.setString(1, customers.getFullName());
			ps.setString(2, customers.getDob());
			ps.setString(3, customers.getAddress());
			ps.setString(4, customers.getEmail());
			ps.setString(5, customers.getPassword());
			ps.setString(6, customers.getPhone());
			ps.setInt(7, customers.getId());
			
		    int i = ps.executeUpdate();
		    
		    if(i==1)
		    {
		    	f  = true;
		    }
		    
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteCustomer(int id)
	{
		boolean f =false;
		
		try {
			
			String sqlDEL = "delete from customers where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sqlDEL);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i == 1)
			{
				f = true;
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return f; 
	}
	
}
