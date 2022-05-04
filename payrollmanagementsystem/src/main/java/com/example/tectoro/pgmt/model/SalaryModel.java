package com.example.tectoro.pgmt.model;

public class SalaryModel {
	
	private String salaryId;
	private String amount;
	private String annual;
	private String bonous;
	private JobDepartmentModel jobdept;
	
	public String getSalaryId() {
		return salaryId;
	}
	public String getAmount() {
		return amount;
	}
	public String getAnnual() {
		return annual;
	}
	public String getBonous() {
		return bonous;
	}
	public JobDepartmentModel getJobdept() {
		return jobdept;
	}
	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setAnnual(String annual) {
		this.annual = annual;
	}
	public void setBonous(String bonous) {
		this.bonous = bonous;
	}
	public void setJobdept(JobDepartmentModel jobdept) {
		this.jobdept = jobdept;
	}
	
	

}
