package map.com;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapToList {

	public static void main(String[] args) {
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("a",10);
		map.put("b",20);
		map.put("c", 30);
		
	   Map<String,Integer>map1=new TreeMap<String, Integer>();
	   map1.putAll(map);
	   System.out.println(map1);
	}
}
