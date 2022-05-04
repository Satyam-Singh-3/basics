package iterable.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class IteratorDmo{

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Satyam");
		list.add("Pankaj");
		list.add("Arun");

		System.out.println("....................................................................................");

		

		Iterator<String> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			
			String string = (String) iterator.next();
			System.out.println(string);	
		}
	}
}
