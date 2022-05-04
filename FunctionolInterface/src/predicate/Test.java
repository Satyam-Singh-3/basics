
package predicate;

import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
		
		String[] st= {"Satyam","arun","Mohan","Salman","Salim"};
		
		Predicate<String>str= s->s.length()%2==0;
		
		for ( String s1 : st) 
		{
		 if(str.test(s1))
		 {
			 System.out.println(s1);
		 }
		}
	}
}
