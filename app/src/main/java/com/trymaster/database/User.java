package com.trymaster.database;

public class User
{
	private int id;
	private String fullname,username,
					email,contact,password;

	public User(int id,String fullname, String username, String email, String password,String contact)
	{
		this.id = id;
		this.fullname=fullname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.contact=contact;
	}
	public User(){}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
	public void setFullname(String s){
		this.fullname=s;
	}
	public String getFullName(){
		return this.fullname;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setContact(String s){
		this.contact=s;
	}
	public String getContact(){
		return this.contact;
	}
	
	}
