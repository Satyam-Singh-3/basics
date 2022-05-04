package com.tectoro.example;

public class Employee {
private int empid;
private String empname;
private double sal;
private String dept;
public Employee() {
	super();
}
public int getEmpid() {
	return empid;
}
public String getEmpname() {
	return empname;
}
public double getSal() {
	return sal;
}
public String getDept() {
	return dept;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public void setSal(double sal) {
	this.sal = sal;
}
public void setDept(String dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + ", sal=" + sal + ", dept=" + dept + "]";
}


}
