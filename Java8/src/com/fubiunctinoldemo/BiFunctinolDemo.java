package com.fubiunctinoldemo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctinolDemo {
  public static void main(String[] args) {
	
	  //Anonymous implementation
	  
	  BiFunction<Integer,Integer, Integer> biFunction=new BiFunction<Integer, Integer, Integer>() {
		
		@Override
		public Integer apply(Integer t, Integer u) {
			// TODO Auto-generated method stub
			return t+u;
		}
	};
	System.out.println(biFunction.apply(10, 20));
	
	//lambda Implementation-->
	
	 BiFunction<Integer,Integer, Integer> biFunction1=(t,u)->(t+u);
     System.out.println( biFunction1.apply(10, 20));
     
     //Combined function with biFunction--->
     Function<Integer, Integer>function=(num)->num*num;
     Integer integer = biFunction1.andThen(function).apply(10, 20);
     System.out.println(integer);
     

	 
}

}
