package com.employee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity

public class RegisterUser  implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

public RegisterUser(int id,String username,String firstName,String lastName,String password){
	this.id=id;
	this.username= username;
	this.firstName=firstName;
	this.lastName=lastName;
	this.password=password;
	
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public RegisterUser(String username,String firstName,String lastName,String password){
	this.username= username;
	this.firstName=firstName;
	this.lastName=lastName;
	this.password=password;
	
	
}
public RegisterUser(){
	
}

}