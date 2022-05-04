package com.empproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Table")
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
	private Integer eid;
	private String first_name;
	private String last_name;
	private Integer experiance;
	private Double salary;
	
	public Employee() {
		super();
	}

	public Employee(Integer eid, String first_name, String last_name, Integer experiance, Double salary) {
		super();
		this.eid = eid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.experiance = experiance;
		this.salary = salary;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getExperiance() {
		return experiance;
	}

	public void setExperiance(Integer experiance) {
		this.experiance = experiance;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", first_name=" + first_name + ", last_name=" + last_name + ", experiance="
				+ experiance + ", salary=" + salary + "]";
	}
	
	
	
	
	
}
