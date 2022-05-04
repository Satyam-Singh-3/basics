package comparator.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GroupBYComapare {

public static void main(String[] args) {
	ArrayList<Student>list=new ArrayList<Student>();
	list.add(new Student(101,"Satyam",204));
	list.add(new Student(103,"mohan",203));
	list.add(new Student(102,"arun",202));
	list.add(new Student(104,"saurabh",201));
	

	
	Collections.sort(list,new SortByName().thenComparing(new SortByRollno()).thenComparing(new SortById()));
	
	System.out.println("===========<Group sort>==============================");
	
    
	
	for (Student student : list) {
		
		System.out.println(student);
	}	
}
}
