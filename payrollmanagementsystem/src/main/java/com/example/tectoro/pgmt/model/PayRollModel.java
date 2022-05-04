package com.example.tectoro.pgmt.model;

public class PayRollModel {

	private String payrollId;
	private String date;
	private String report;
	private String totalAmount;
	private Employee emp;
	private JobDepartmentModel jobdept;
	private SalaryModel salray;
	private LeaveModel leave;

	public String getPayrollId() {
		return payrollId;
	}

	public String getDate() {
		return date;
	}

	public String getReport() {
		return report;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public Employee getEmp() {
		return emp;
	}

	public JobDepartmentModel getJobdept() {
		return jobdept;
	}

	public SalaryModel getSalray() {
		return salray;
	}

	public LeaveModel getLeave() {
		return leave;
	}

	public void setPayrollId(String payrollId) {
		this.payrollId = payrollId;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public void setJobdept(JobDepartmentModel jobdept) {
		this.jobdept = jobdept;
	}

	public void setSalray(SalaryModel salray) {
		this.salray = salray;
	}

	public void setLeave(LeaveModel leave) {
		this.leave = leave;
	}

}
