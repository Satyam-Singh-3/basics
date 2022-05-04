package com.example.tectoro.pgmt.model;

public class JobDepartmentModel {
	
	private String jobId;
	private String jobDept;
	private String name;
	private String description;
	private String salaryRange;
	
	public String getJobId() {
		return jobId;
	}
	public String getJobDept() {
		return jobDept;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getSalaryRange() {
		return salaryRange;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public void setJobDept(String jobDept) {
		this.jobDept = jobDept;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}
		
}
