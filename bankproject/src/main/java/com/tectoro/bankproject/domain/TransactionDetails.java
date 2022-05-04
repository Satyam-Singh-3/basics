package com.tectoro.bankproject.domain;

public class TransactionDetails {
	
	private long transacId;
    private AccountDetails details;
	private double deposite;
	private double withdraw;
	private double balance;
	private String transacTime;
	public long getTransacId() {
		return transacId;
	}
	public AccountDetails getDetails() {
		return details;
	}
	public double getDeposite() {
		
		return deposite;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public double getBalance() {
		return balance;
	}
	public String getTransacTime() {
		return transacTime;
	}
	public void setTransacId(long transacId) {
		this.transacId = transacId;
	}
	public void setDetails(AccountDetails details) {
		this.details = details;
	}
	public void setDeposite(double deposite) {
		this.deposite = deposite;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setTransacTime(String transacTime) {
		this.transacTime = transacTime;
	}
	
}