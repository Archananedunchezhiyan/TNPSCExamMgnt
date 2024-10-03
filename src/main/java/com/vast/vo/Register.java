package com.vast.vo;

public class Register {
	  String name;
	  String email;
	  String pwd;
	  String confrmpwd;
	  Long phone;
	  
	  public Register(){
		  
	  }
	public Register(String name, String email, String pwd, String confrmpwd, Long phone) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.confrmpwd = confrmpwd;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getConfrmpwd() {
		return confrmpwd;
	}
	public void setConfrmpwd(String confrmpwd) {
		this.confrmpwd = confrmpwd;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Register [name=" + name + ", email=" + email + ", pwd=" + pwd + ", confrmpwd=" + confrmpwd + ", phone="
				+ phone + "]";
	}
	
	  
	  
}
