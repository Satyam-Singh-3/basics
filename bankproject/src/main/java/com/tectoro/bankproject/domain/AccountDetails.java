package com.tectoro.bankproject.domain;

import java.util.Random;

public class AccountDetails {
	
	private int id;
	private long accNo;
	private String name;
	private String dob;
	private String panNo;
	private String phnNo;
	private String adharNo;
	private String email;
	private String address;
	
	public int getId() {
		return id;
	}

	public long getAccNo() {

		Random rand = new Random();
		long x = (long) (rand.nextDouble() * 100000000000000L);
		String s = String.valueOf(52) + String.format("%014d", x);
		this.accNo = Long.valueOf(s);
		return accNo;
	}
	public String getName() {
		return name;
	}
	public String getDob() {
		return dob;
	}
	public String getPanNo() {
		return panNo;
	}
	public String getPhnNo() {
		return phnNo;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}