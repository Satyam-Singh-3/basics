package comparator.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CompareMoreThanOne implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		int name=o1.getSname().compareTo(o2.getSname());
		int id=o1.getSid()-o2.getSid();
		
		return(name==0)?id
				       :name;
		
	}
	
}

public class CompareMultipleField {

	public static void main(String[] args) {
		List<Student>list2=new ArrayList<Student>();
		list2.add(new Student(201,"Satyam",501));
		list2.add(new Student(203,"Satyam",503));
		list2.add(new Student(202,"Arun",502));
		
		 System.out.println("===========<Sort By Rollno>==============================");
			
	        Collections.sort(list2,new CompareMoreThanOne());
			
			for (Student student : list2) {
				
				System.out.println(student);
			}
	}
}
