package comparator.com;

import java.util.Comparator;
import java.util.List;

import javax.swing.GroupLayout.Group;

public class SortingTest {

	public static void main(String[] args) {
		
		Employee e=new Employee();
		
		List<Employee>emp=e.getEmployees();
		
		 System.out.println("=========<lambda expression...!>========");
		 System.out.println("=========<Sort By Fname...!>");
		 emp.sort(Comparator.comparing(i ->i.getFname()));
		 
		 for (Employee s: emp) {
			System.out.println(s);
		}
		 
		 System.out.println("=========<Method Refrence...!>========");
		 System.out.println("=========<Sort By Fname...!>");
		 emp.sort(Comparator.comparing(Employee::getFname));
		 
		 for (Employee s: emp) {
			System.out.println(s);
		}
		 
		 
		 System.out.println("=========<Sort By lname...!>");
		 emp.sort(Comparator.comparing(i ->i.getLname()));
		 
		 for (Employee s: emp) {
			System.out.println(s);
		} 
		 
		 System.out.println("=========<lambda expression...!>========");
		 System.out.println("=========<Sort By Age...!>");
		 
		 emp.sort(Comparator.comparing(i ->i.getAge()));
		 
		 for (Employee s: emp) {
			System.out.println(s);
		}
		 
		 
		System.out.println("=========<Reverse sorting by age"); 
		Comparator<Employee>e1=Comparator.comparing(em->em.getAge());
		emp.sort(e1.reversed());
		System.out.println(emp);
		
		
		System.out.println("============<Group sorting>==================");
		Comparator<Employee>groupsort=Comparator.comparing(Employee::getAge).thenComparing(Employee::getFname).thenComparing(Employee::getLname);
		emp.sort(groupsort);
		System.out.println(emp);
	}
	
	
}
