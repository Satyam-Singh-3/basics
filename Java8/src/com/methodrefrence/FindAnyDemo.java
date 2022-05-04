package com.methodrefrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyDemo {

	public static void main(String[] args) {
		List<Integer>numberList=new ArrayList<Integer>(Arrays.asList(11,2,3,4,5,6,7,10,8,9));
		
		//findAny() method-->
		
		Optional<Integer> findFirst = numberList.stream().findFirst();
		if(findFirst.isPresent()) {
			System.out.println(findFirst.get());
		}else {
			System.out.println("not find ");
		}
		
		//findFirst() --->
		
		Optional<Integer> findAny = numberList.stream().findAny();
		if(findAny.isPresent()) {
			System.out.println(findAny.get());
		}else {
			System.out.println("not found");
		}
	}
}
