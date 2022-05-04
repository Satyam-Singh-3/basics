package com.methodrefrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable {
	void print(String msg);
}

public class MethodRDemo {
	public static Integer add(Integer a,Integer b) {
		return(a+b);
	}
	
	public void display(String msg) {
		msg=msg.toUpperCase();
		System.out.println(msg);
	}

	public static void main(String[] args) {
		//Lambda Expression
		
		Function<Integer, Double>function=(input)->Math.sqrt(input);
		System.out.println(function.apply(4));
		
		//Method Reference
		
		Function<Integer, Double>functionMethodRef=Math::sqrt;
		System.out.println(functionMethodRef.apply(6));
		
		
		//Method reference for static add()method=?
		
		BiFunction<Integer, Integer, Integer>addition=MethodRDemo::add;
		System.out.println(addition.apply(10, 21));
		
		//object of this class
		
		MethodRDemo demo=new MethodRDemo();
		
		//LambdaExpression reference to an instance method for an object
		
		Printable printable=(msg)->demo.display(msg);
		printable.print("Welcome back......!");
		
		//Method reference to an instance method for an object
		
		Printable printable1=demo::display;
		printable1.print("Hii.......!");
		
		//Reference to the an instance method of an arbitrary  object
		
		//Lambda Expression
		
		Function<String, String>orbitraryObject=(input)->input.toLowerCase();
		System.out.println(orbitraryObject.apply("SATYAM"));
		
		
		
		//Method Reference
		
		Function<String, String>orbitraryObject1=String :: toLowerCase;
		System.out.println(orbitraryObject1.apply("SATYAM"));
		
		String []strArray= {"A","C","e","w","Z","a"};
		Arrays.sort(strArray,(s1,s2)->s1.compareToIgnoreCase(s2));
		
		
		Arrays.sort(strArray,String::compareToIgnoreCase);
		
		//Reference to a constructor
		
	  	List<String>fruit=new ArrayList<String>(Arrays.asList("Banana","Orange","Apple","Mango","Grapes","Banana"));
		
		//LambdaExpression
	  	
	  	Function<List<String>, Set<String>>fruitList=(fruits)->new HashSet(fruits);
	  	System.out.println(fruitList.apply(fruit));
	  	
	  	//Method reference
	  	
	  	Function<List<String>, Set<String>>fruitList1= HashSet::new;
	  	System.out.println(fruitList1.apply(fruit));
	  	
		
		
		
	}
}
