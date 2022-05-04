package com.optinol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

	public static void main(String[] args) {
		
		//Sort List in ascending order
		List<String>list=new ArrayList<String>(Arrays.asList("Mohan","Arun","Saurabh","Pavan","Vikash"));
		
		System.out.println("<----------------------------!  !---------------------------------->");
		
		list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		System.out.println("<----------------------------!  !---------------------------------->");

		System.out.println("<----------------------------!  !---------------------------------->");
		
		//Using comparator
		
		List<String> sortedList = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		
		System.out.println("<----------------------------!  !---------------------------------->");

		//using lambda 
		
		
		List<String> sortedList1 = list.stream().sorted((o1,o2)->o1.compareTo(o2)).collect(Collectors.toList());
        sortedList1.forEach(System.out::println);
        
		System.out.println("<----------------------------!  !---------------------------------->");
		
		//default sorted() method
		
		List<String> sortedList2 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList2);
		
		//Descending Order

		
		//Sort List in ascending order
		List<String>list4=new ArrayList<String>(Arrays.asList("Mohan","Arun","Saurabh","Pavan","Vikash"));
		
		System.out.println("<----------------------------!  !---------------------------------->");
		
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("<----------------------------!  !---------------------------------->");
		
		//Using comparator
		
		List<String> sortedList5 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		sortedList5.forEach(System.out::println);
		
		System.out.println("<----------------------------!  !---------------------------------->");

		//using lambda 
		
		
		List<String> sortedList6= list.stream().sorted((o1,o2)->o2.compareTo(o1)).collect(Collectors.toList());
        sortedList6.forEach(System.out::println);
        
		System.out.println("<----------------------------!  !---------------------------------->");
		
		//default sorted() method
		
		List<String> sortedList7 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList7);
		
		
		System.out.println("<----------------------------!  !---------------------------------->");

		//Sort Product
		
		


	}
}
