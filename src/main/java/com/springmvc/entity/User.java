package com.springmvc.entity;

public class User {
    private String name;  
    private String password;  
    private Role role;

	public  User(String name,String password){
    	this.name=name;
    	this.password=password;
    }
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}  
}
