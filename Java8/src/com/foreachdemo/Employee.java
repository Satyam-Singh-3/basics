package com.foreachdemo;

public class Employee {

	private Integer eid;
	private String ename;
	private Double sal;
	
	public Employee() {
		super();
	}

	public Employee(Integer eid, String ename, Double sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
	}

	public Integer getEid() {
		return eid;
	}

	public String getEname() {
		return ename;
	}

	public Double getSal() {
		return sal;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + "]";
	}
	
	
}
