package comparator.com;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	int id;
	String fname;
	String lname;
	int age;
	
	public Employee() {
		super();
	}

	public Employee(int id, String fname, String lname, int age) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
	
     public List<Employee> getEmployees()
	{
		List<Employee>list=new ArrayList<Employee>();
		list.add(new Employee(101,"Arun","Kumar",20));
		list.add(new Employee(103,"Satyam","Singh",23));
		list.add(new Employee(102,"Mohan","Babu",22));
		return list;
	}
	
}
