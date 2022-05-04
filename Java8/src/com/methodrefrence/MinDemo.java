package com.methodrefrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinDemo {

	public static void main(String[] args) {
		List<Integer>numList=new  ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		
		//count()--->
		
		long countOfNumber = numList.stream().count();
		System.out.println(countOfNumber);
		
		//min()--->
		
		Integer integer = numList.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(integer);
		
		//max()--->
		
		Integer maxNum = numList.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(maxNum);
	}
	
}
