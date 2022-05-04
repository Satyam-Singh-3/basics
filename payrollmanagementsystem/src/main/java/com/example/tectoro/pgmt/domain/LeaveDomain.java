package com.example.tectoro.pgmt.domain;

import java.util.Date;

public class LeaveDomain {
	
	private int leaveId;
	private Date date;
	private String status;
	private String reason;
	private EmployeeDomain emp;
	
	public int getLeaveId() {
		return leaveId;
	}
	public Date getDate() {
		return  date;
	}
	public String getStatus() {
		return status;
	}
	public String getReason() {
		return reason;
	}
	public EmployeeDomain getEmp() {
		return emp;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public void setDate(java.util.Date date1) {
		this.date = (Date) date1;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setEmp(EmployeeDomain emp) {
		this.emp = emp;
	}
	
	


}
