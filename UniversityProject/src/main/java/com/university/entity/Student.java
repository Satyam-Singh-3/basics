package com.university.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Table")
public class Student {

	@Id
	private Integer sid;
	private String sname;
	private Integer marks;
	private Integer age;
	private LocalDate joiningDate = LocalDate.now();
	private LocalDate passedoutdate = LocalDate.of(2026, 04, 30);
	private Long credit;

	public Student() {
		super();
	}

	public Student(Integer sid, String sname, Integer marks, Integer age, LocalDate joiningDate,
			LocalDate passedoutdate, Long credit) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.marks = marks;
		this.age = age;
		this.joiningDate = joiningDate;
		this.passedoutdate = passedoutdate;
		this.credit = credit;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDate getPassedoutdate() {
		return passedoutdate;
	}

	public void setPassedoutdate(LocalDate passedoutdate) {
		this.passedoutdate = passedoutdate;
	}

	public Long getCredit() {
		return credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", age=" + age + ", joiningDate="
				+ joiningDate + ", passedoutdate=" + passedoutdate + ", Credit=" + credit + "]";
	}

}
