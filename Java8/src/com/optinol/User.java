package com.optinol;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class User {
	public static void main(String[] args) {
		List<Employee>empList=new ArrayList<Employee>();
		empList.add(new Employee(1,"satyam","satyam@321","satyam@gmail.com"));
		empList.add(new Employee(2,"arun","arun@321","arun@gmail.com"));
		
		System.out.println(empList);
		
		System.out.println("<---------------------------map with lambda------------------------------------------>");
		
		empList.stream().map((Employee emp)->new EmployeeDto(emp.getEid(),emp.getEname(),emp.getEmail())).forEach(System.out::println);;
		
		System.out.println("<---------------------------map with Function functinol interface------------------------------------------>");
        
		empList.stream().map(new Function<Employee, EmployeeDto>() {

			@Override
			public EmployeeDto apply(Employee emp) {
				// TODO Auto-generated method stub
				return new EmployeeDto(emp.getEid(),emp.getEname(),emp.getEmail());
			}
		}).forEach(System.out::println);
	}

}
//EmployeeDto

class EmployeeDto{
	private Integer eid;
	private String ename;
	private String email;
	
	public EmployeeDto() {
		super();
	}

	public EmployeeDto(Integer eid, String ename, String email) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
	}

	public Integer getEid() {
		return eid;
	}

	public String getEname() {
		return ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeDto [eid=" + eid + ", ename=" + ename + ", email=" + email + "]";
	}
	
	
	
}

//Employee

class Employee{
	private Integer eid;
	private String ename;
	private String email;
	private String pwd;
	
	public Employee() {
		super();
	}

	public Employee(Integer eid, String ename, String email, String pwd) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.pwd = pwd;
	}

	public Integer getEid() {
		return eid;
	}

	public String getEname() {
		return ename;
	}

	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
	
}