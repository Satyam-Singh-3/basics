package arraylist.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Occurence {
	
	/*
	 * public static void countFrequency(ArrayList<String> list) {
	 * Set<String>set=new HashSet<String>(list);
	 * 
	 * for (String s:set) { System.out.println(s+":"+Collections.frequency(list,
	 * s));
	 * 
	 * }
	 * 
	 * System.out.println(set); }
	 */
    public static void main(String[] args) {
		
	ArrayList<String>list=new ArrayList<String>();
	 list.add("java");
	 list.add("java");
	 list.add("java");
	 list.add("core");
	 list.add("core");
	 
		
		  System.out.println(
		  "---------------------------------------------------------------");
		  
		  int occuranceOfJava=Collections.frequency(list, "java");
		  System.out.println("occorance of java:"+occuranceOfJava);
		  
		  int occuranceOfOrracle=Collections.frequency(list, "core");
		  System.out.println("occuranceOfOrracle:"+occuranceOfOrracle);
		  
		  System.out.println(
		  "------------------------------------------------------------");
		  
		
	 
	
	 Iterator<String> i=list.iterator();
	 
	  while(i.hasNext()) 
	  {
		  
	  if(occuranceOfJava<occuranceOfOrracle)
	  {
		 if((i.next()).equals("java"))
		 {
			 
		  i.remove();
		 }
	  }
	  
	  else if(occuranceOfJava>occuranceOfOrracle);
	  {
		
		  if(i.next().equals("core"))
		  {
		  i.remove();
		  }
	  }
	  
	  }
	  
	  
	  System.out.println(list);
	
	 
    }
	  
    }	


