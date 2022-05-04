package com.optinol;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Java8Stream {

	public static void main(String[] args) {
		
		//create stream
		
		Stream<String>stream=Stream.of("s","a","t","y","a","m");
		
		stream.forEach(System.out::println);
		
		System.out.println("<--------------------------------------------------------------------->");
		
		//create stream from sources-->
		
		Collection<String>collection=Arrays.asList("java","c","kotlin",".net");
		Stream<String>stream1=collection.stream();
		stream1.forEach(System.out::println);
		
		System.out.println("<--------------------------------------------------------------------->");
		
		List<String>list=Arrays.asList("java","c","kotlin",".net");
		Stream<String>stream2=collection.stream();
		stream2.forEach(System.out::println);
		
		System.out.println("<--------------------------------------------------------------------->");
		
		Set<String>set=new HashSet<>(list);
		Stream<String>stream3=collection.stream();
		stream3.forEach(System.out::println);
		
		
		
	}
}
