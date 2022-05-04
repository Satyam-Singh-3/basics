package com.example.tectoro.pgmt.domain;

import java.util.Date;

public class PayRollDomain {
	
	private int payrollId;
	private Date date;
	private String report;
	private int totalAmount;
	private EmployeeDomain emp;
	private JobDepartmentDomain jobdept;
	private SalaryDomain salray;
	private LeaveDomain leave;
	public int getPayrollId() {
		return payrollId;
	}
	
	public Date getDate() {
		return date;
	}
	public String getReport() {
		return report;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public EmployeeDomain getEmp() {
		return emp;
	}
	public JobDepartmentDomain getJobdept() {
		return jobdept;
	}
	public SalaryDomain getSalray() {
		return salray;
	}
	public LeaveDomain getLeave() {
		return leave;
	}
	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setEmp(EmployeeDomain emp) {
		this.emp = emp;
	}
	public void setJobdept(JobDepartmentDomain jobdept) {
		this.jobdept = jobdept;
	}
	public void setSalray(SalaryDomain salray) {
		this.salray = salray;
	}
	public void setLeave(LeaveDomain leave) {
		this.leave = leave;
	}
	

}
