package function;

import java.util.function.Function;

public class Test {

	public static void main(String[] args) {
		Function<Integer, Integer>f=s->s*s;
		System.out.println(f.apply(4));
		
		//String size
		Function<String,String>f1=s1->s1.toUpperCase();
		System.out.println(f1.apply("satyam"));
	}
}
