package linkedlist.com;

import java.util.LinkedList;

class EmployeeData
{
	int id;
	String name;
	int age;
	
	public EmployeeData() {
		super();
	}

	public EmployeeData(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeData [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
public class Employee {

	public static void main(String[] args) {
		LinkedList<EmployeeData>elist=new LinkedList<>();
		elist.add(new EmployeeData(101,"Satyam",20));
		elist.add(new EmployeeData(102,"mohan",21));
		elist.add(new EmployeeData(103,"Arun",22));
		elist.add(new EmployeeData(104,"John",23));
		
		//System.out.println(elist);
		
		elist.add(2,new EmployeeData(102,"John",21));
		
		for (EmployeeData employeeData : elist) {
			System.out.println(employeeData);
		}
		
		
		System.out.println(elist.lastIndexOf("john"));
	}
}
