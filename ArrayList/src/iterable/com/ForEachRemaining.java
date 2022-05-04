package iterable.com;

import java.util.ArrayList;
import java.util.List;

public class ForEachRemaining {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		
		list.iterator().forEachRemaining(System.out::println);
		
	}
}
