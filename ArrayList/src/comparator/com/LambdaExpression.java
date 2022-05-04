package comparator.com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {

	public static void main(String[] args) {
		
	
    List<Student>list=new ArrayList<Student>();
    list.add(new Student(201,"satyam",301));
    list.add(new Student(203,"mohan",303));
    list.add(new Student(202,"arun",302));
    
    System.out.println("==========<Anonymous class>=========================");
    
        list.sort(new Comparator<Student>() {
    	public int compare(Student o1, Student o2) {
    		
    		return o1.getSname().compareTo(o2.sname);
    	};
    	
	});
    
    System.out.println("===========<Sort By Id>==============================");
	
    
	
	for (Student student : list) {
		
		System.out.println(student);
	}	
    
	
   System.out.println("==========<lambda expression>=========================");
   
  
   list.sort(Comparator.comparing(e->e.getSid()));
   
   
   System.out.println("===========<Sort By Id>==============================");
	
   
	
	for (Student student : list) {
		
		System.out.println(student);
	}
    
	
	System.out.println("======<Method reference::>=========================");
	
	
	 list.sort(Comparator.comparing(Student::getSname));
	 
	 System.out.println("===========<Sort By name>==============================");
		
     
		
		for (Student student : list) {
			
			System.out.println(student);
		}
}
}
