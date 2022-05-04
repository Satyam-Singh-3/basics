package com.example.tectoro.pgmt.domain;

public class EmployeeDomain {
	 
	private int empId;
	private String fname;
	private String lname;
	private String gender;
	private int age;
	private String conactAdd;
	private String empEmail;
	private String empPass;
	
	public int getEmpId() {
		return empId;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public String getConactAdd() {
		return conactAdd;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public String getEmpPass() {
		return empPass;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setConactAdd(String conactAdd) {
		this.conactAdd = conactAdd;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	

}