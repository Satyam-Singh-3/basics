package iterable.com;

import java.util.Arrays;
import java.util.*;
import java.util.List;

public class ArrayListIterator {

	public static void main(String[] args) {
		//Initializing array list
		List<Integer>list =Arrays.asList(10,20,30,40,50,60,70,80,90,100);
		
		//Iterating array list through iterator
		Iterator<Integer> it=list.iterator();
		
		System.out.println("................................................................");
        while(it.hasNext())
        {
        	Integer i=it.next();
        	System.out.println(i);
        }
       
       System.out.println("...................................................................");
       
       System.out.println(list);
	}
}
