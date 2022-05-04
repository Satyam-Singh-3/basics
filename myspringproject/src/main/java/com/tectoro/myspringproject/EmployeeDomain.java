package com.tectoro.myspringproject;

public class EmployeeDomain {
	
	private String empName;
	private int empId;
	private String salary;
	
	public EmployeeDomain(String empName, int empId, String salary) {
		
		this.empName = empName;
		this.empId = empId;
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}

	public int getEmpId() {
		return empId;
	}

	public String getSalary() {
		return salary;
	}

	
	
	
}
