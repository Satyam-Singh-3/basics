package map.com;

import java.util.HashMap;
import java.util.Map;

public class ContainsKey {

	public static void main(String[] args) {
		Map<Integer, String>map=new HashMap<>();
		map.put(1, "satyam");
		map.put(2,"mohan");
		map.put(3, "arun");
		System.out.println("map is---->"+map);
		
		System.out.println("=======<-checking the given key is existed->==========");
		
		System.out.println("is given key existed---->"+map.containsKey(2));
		
		System.out.println("<-------gettting the value with particuler associated key------>");
		
		System.out.println("value associated with key 2-->"+map.get(2));
		
		System.out.println("<---------replace the value for specified key--------->");
		System.out.println("replaced value for key 2-->"+map.replace(2, "saurabh"));
		
		System.out.println("map after replacement-->"+map.toString());
	     
	}
}
