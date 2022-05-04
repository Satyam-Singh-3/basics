package com.university.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "University_Table")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	private String dept;

	@OneToMany(targetEntity = Student.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	@JoinColumn(name = "us_fk")
	private List<Student> student;

	public University() {
		super();
	}

	public University(Integer uid, String dept, List<Student> student) {
		super();
		this.uid = uid;
		this.dept = dept;
		this.student = student;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "University [uid=" + uid + ", dept=" + dept + ", student=" + student + "]";
	}

}
