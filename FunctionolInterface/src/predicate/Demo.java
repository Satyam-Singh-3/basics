
package predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

class Employee {
	int salary;
    String name;

	public Employee(int salary, String name) {
		super();
		this.salary = salary;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary+ ", name=" + name + "]";
	}
	

}

public class Demo {
	public static void main(String[] args) {

		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1000, "Satyam"));
		list.add(new Employee(2000, "Arun"));
		list.add(new Employee(3000, "Mohan"));
		
		Predicate<Employee>emp=e ->e.salary>1000 && e.salary<3000;
		for (Employee employee : list) {
			if(emp.test(employee))
			{
				//System.out.println( employee.salary +":"+employee.name);
				 System.out.println(employee);
			}
		}
	}
}
