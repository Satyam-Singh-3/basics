package com.example.tectoro.pgmt.domain;

public class JobDepartmentDomain {
	
	private int jobId;
	private String jobDept;
	private String name;
	private String description;
	private int salaryRange;
	
	public int getJobId() {
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
	public int getSalaryRange() {
		return salaryRange;
	}
	public void setJobId(int jobId) {
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
	public void setSalaryRange(int salaryRange) {
		this.salaryRange = salaryRange;
	}
	
	
}
