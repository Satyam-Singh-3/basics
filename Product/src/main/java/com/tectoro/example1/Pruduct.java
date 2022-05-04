package com.tectoro.example1;

public class Pruduct {

	private int pid;
	private String pname;
	private String cname;
	private int pcost;
	public Pruduct() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public String getCname() {
		return cname;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	@Override
	public String toString() {
		return "Pruduct [pid=" + pid + ", pname=" + pname + ", cname=" + cname + ", pcost=" + pcost + "]";
	}
	
	
}
