package com.foreachdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {

	public static void main(String[] args) {
		List<Integer>numList=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println("<---------------------------------------------------------------------------->");

		//forEach()--->
		//iteration of list with stream 

		numList.stream().forEach(t->System.out.println(t));
		
		System.out.println("<---------------------------------------------------------------------------->");

		//forEach()--->
		//iteration of map with stream 
		
		Map<Integer, String>map=new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		
		map.forEach((k,v)->System.out.println(k+":"+v));
		
		System.out.println("<---------------------------------------------------------------------------->");

		map.entrySet().stream().forEach(obj->System.out.println(obj));
		
		System.out.println("<---------------------------------------------------------------------------->");
		
		//filter with map

		map.entrySet().stream().filter(k->k.getKey()%2==0).forEach(System.out::println);
		
		System.out.println("<---------------------------------------------------------------------------->");

		
		//filter()--with list>
		List<String>nameList=new ArrayList<>(Arrays.asList("Satyam","Mohan","Saurabh","Salman"));
		nameList.stream().filter(n->n.startsWith("S")).forEach(System.out::println);;
		
		
		
	}
}
