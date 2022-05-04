package function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
//Student class
class Student
{
	String name;
	int marks;
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
	
	
}
//Testing class .
public class FunctionInterface {
    public static void main(String[] args) {
		
	
	Student[]s= {
			     new Student("Satyam",100),
			     new Student("Mohan", 90),
			     new Student("Arun", 70)
			     };
	//Function Functional interface-->Used to perform Business related operation;
	Function<Student, String> f=stu ->
	{
	  int mark=stu.marks;	
	  String grade="";
	  if(mark>90)
	  {
		  grade="A";
	  }
	  else if(mark>80)
	  {
		  grade="B";
	  }
	  else if(mark>=70)
	  {
		  grade="C";
	  }
	  return grade;
	};
	
	//Predicate Functional Interface:-->Used to perform conditional operation;
	Predicate<Student>p=stu->stu.marks>70;		
	
	
	
	for (Student s1 : s) {
		if(p.test(s1)) {
		System.out.println(s1.name);
		System.out.println(s1.marks);
		System.out.println(f.apply(s1));}
	}
	
	//Function chaining
	//Function<Integer, Integer>f2= per->per*2;
	//Function<Integer, Integer>f3=cub->cub*cub*cub;
	//andThen()---->first f2 then f3
	//System.out.println(f2.andThen(f3).apply(4));
	
	//compose()--->f3 first then f2.
	
	//System.out.println(f2.compose(f3).apply(2));
	}
}
