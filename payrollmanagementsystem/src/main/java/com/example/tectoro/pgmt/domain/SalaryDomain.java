package com.example.tectoro.pgmt.domain;

import java.util.Date;

public class SalaryDomain {
	
	private int salaryId;
	private int amount;
	private Date annual;
	private Date bonous;
	private JobDepartmentDomain jobdept;
	
	public int getSalaryId() {
		return salaryId;
	}
	public int getAmount() {
		return amount;
	}
	public Date getAnnual() {
		return annual;
	}
	public Date getBonous() {
		return bonous;
	}
	public JobDepartmentDomain getJobdept() {
		return jobdept;
	}
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setAnnual(Date annual) {
		this.annual = annual;
	}
	public void setBonous(Date bonous) {
		this.bonous = bonous;
	}
	public void setJobdept(JobDepartmentDomain jobdept) {
		this.jobdept = jobdept;
	}
	
	
}
