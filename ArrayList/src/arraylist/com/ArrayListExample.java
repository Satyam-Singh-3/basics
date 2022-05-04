package arraylist.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayListExample {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<>();

		System.out.println("taking input from console========================");
		
		System.out.println("Enter your string");

		for (int i = 0; i <= 3; i++) {

			String str = input.nextLine();
			list.add(str);

		}
		System.out.println(list);

		System.out.println("Enter string which you want to check===============================");
		
		String str1 = input.nextLine();

		
		  for(int i=0;i<list.size();i++) { if(str1.equals(list.get(i)) ) {
		  list.remove(i); } } 
		  System.out.println(list);
		  
		  // System.out.println("yes it is available:"+list.contains(str1));

		
		  
		/*
		 * Iterator<String>itr=list.iterator(); while(itr.hasNext()) {
		 * if((itr.next()).equals(str1)) { itr.remove(); } } System.out.println(list);
		 * 
		 * 
		 */

		/*
		 * System.out.println("from "); List<String> list2 =
		 * list.stream().distinct().collect(Collectors.toList());
		 * System.out.println(list2);
		 */

	}

}
