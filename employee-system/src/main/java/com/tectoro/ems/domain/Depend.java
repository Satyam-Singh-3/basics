package com.tectoro.ems.domain;

import java.io.Serializable;

public class Depend implements Serializable{
	private static final long serialVersionUID = 1L;
	private int dependId;
	private String firstName;
	private String lastName;
	private String relation;
	private int empId;
	private Employee employee;
	
	public int getDependId() {
		return dependId;
	}
	public void setDependId(int dependId) {
		this.dependId = dependId;
	}
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
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
