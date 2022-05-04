package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>
{
	private int id;
	private String name;
	private int age;
	
	
	
	public Employee() {
		super();
	}
  
	
	public Employee(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

//CompareTo method
	@Override
	public int compareTo(Employee e) {
		// TODO Auto-generated method stub
		return this.age-e.age;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

   
	
	
	
}

public class CustomObjectSorting 
{

	public static void main(String[] args) {
		
		List<Employee> e=new ArrayList<Employee>();
		
		e.add(new Employee(102,"Satyam",22));
		e.add(new Employee(103,"Mohan",24));
		e.add(new Employee(101,"Arun",23));
		
		System.out.println("=================After Sorting ==============================");
		
		Collections.sort(e);
		
		System.out.println(e);
		
		System.out.println("============================Reverse Order Sorting==================================================");
		
		Collections.sort(e,Collections.reverseOrder());
		
		System.out.println(e);
	}
}
