package comparator.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student
{
	int sid;
	String sname;
	int srollno;
	
	//Default constructor;
	
	public Student() {
		super();
	}

    //Parameterized constructor;
	
	public Student(int sid, String sname, int srollno) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.srollno = srollno;
	}

	//gettesr() method
	
	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public int getSrollno() {
		return srollno;
	}

	//toString method;
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", srollno=" + srollno + "]";
	}
	
	
}

//Sort BY Id class

class SortById implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.sid-o2.sid;
	}
	
}

//Sort By name class
class SortByName implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.sname.compareTo(o2.sname);
	}
	
}

//Sort By roll no
class SortByRollno implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.srollno-o2.srollno;
	}
	
}
public class ComparatorExample {

	public static void main(String[] args) {
		List<Student>list=new ArrayList<Student>();
		list.add(new Student(101,"Satyam",1002));
		list.add(new Student(103,"Pankaj",1004));
		list.add(new Student(102,"Arun",1003));
		
		System.out.println("===========<Sort By Id >==============================");
		
		Collections.sort(list,new SortById());
		
		for (Student student : list) {
			
			System.out.println(student);
		}
		
		System.out.println("===========<Sort By Name >==============================");
		
        Collections.sort(list,new SortByName());
		
		for (Student student : list) {
			
			System.out.println(student);
		}
		
        System.out.println("===========<Sort By Rollno>==============================");
		
        Collections.sort(list,new SortByRollno());
		
		for (Student student : list) {
			
			System.out.println(student);
		}
	}
}
