package com.entity;

public class Customers {

	
	private int id;
	private String fullName;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String phone;
	
	public Customers() {
		super();
		
	}

	public Customers(String fullName, String dob, String address, String email, String password,String phone) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phone = phone;
		}
	
	

	public Customers(int id, String fullName, String dob, String address, String email, String password,String phone) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String password) {
		this.password = phone;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", address=" + address + ", email="
				+ email + ", password=" + password + ", phone=" + phone + "]";
	}

	
	
	
	
	
}
