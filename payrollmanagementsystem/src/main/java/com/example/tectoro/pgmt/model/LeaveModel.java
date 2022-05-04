package com.example.tectoro.pgmt.model;

public class LeaveModel {
	
	private String leaveId;
	private String date;
	private String status;
	private String reason;
	private Employee employee;
	
	public String getLeaveId() {
		return leaveId;
	}
	public String getDate() {
		return date;
	}
	public String getStatus() {
		return status;
	}
	public String getReason() {
		return reason;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
