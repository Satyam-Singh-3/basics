package map.com;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


class Student
{
	 int id;
     String name;
	 int age;
	
	public Student() {
		super();
	}

	public Student(int id, String name, int age) {
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

		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
class SortById implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.id-o2.id;
	}
	
}

class SortByAge implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		
		return o2.age-o1.age;
	}
	
}
public class Sorting {

	public static void main(String[] args) {
		
		TreeMap<Student ,Integer>map=new TreeMap<>(new SortById());
		
		map.put(new Student(101,"satyam",21),101);
		map.put(new Student(103,"arun",23),103);
		map.put(new Student(102,"mohan",22),102);
		
		System.out.println("<----Assecending order sorting---->");
		
		
		for (Entry<Student, Integer> entry:map.entrySet()) {
			
			System.out.println(entry);
		}
		
		System.out.println("<-----desending order mapping----->");
		
		TreeMap<Student,Integer>map1=new TreeMap<Student, Integer>(new SortByAge());
		map1.put(new Student(201,"arun",22),101);
		map1.put(new Student(203,"satyam",23),103);
		map1.put(new Student(202,"mohan",21),102);
		
		System.out.println("Before sorting map----->"+map1);
		
		
		for (Entry<Student, Integer> string : map1.entrySet()) {
			System.out.println("<-----Aftre descending order-->"+string);
		}
		
	
	}
}
