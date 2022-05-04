package linkedlist.com;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<>();
		list.add("Satyam");
		list.add("Arun");
		list.add("MOhan");
		list.add("Saurabh");
		list.add("Arun");
		
		
		System.out.println("Linked list:->"+list);
		
		
		System.out.println("Check weather given string contains:->"+list.contains("Satyam"));
		System.out.println("============<Getting First and Last Index>=====================");
		System.out.println("First Index of:->"+list.indexOf("Arun"));
		System.out.println("Last Index of :->"+list.lastIndexOf("Arun"));
	}
}
