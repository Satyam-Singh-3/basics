package map.com;

import java.util.HashMap;
import java.util.Set;

public class AllListOfKeyInMap {

	public static void main(String[] args) {
		HashMap<Integer, String>map=new HashMap<>();
		map.put(101, "satyam");
		map.put(102, "mohan");
		map.put(103, "arun");
		
		Set<Integer>set=map.keySet();
		for (Integer integer : set) {
			System.out.println("set of key--->"+integer);
		}
	}
}
