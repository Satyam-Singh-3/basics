package map.com;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LargestValueEntry {

	public static <k,v extends Comparable<V>, V, K>Map.Entry<K, V>getMaxValue(Map<K, V> map)
	{
		Map.Entry<K, V>maxvalue=null;
		
		for (Map.Entry<K, V>currententry:map.entrySet()) {
			
			if(maxvalue==null||((Comparable<V>) currententry.getValue()).compareTo(maxvalue.getValue())>0)
					
		    {
				maxvalue=currententry;
			}
		}
		return maxvalue;
	}
	

	public static void main(String[] args) {
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("m", 10);
		map.put("s", 20);
		map.put("a", 30);
		System.out.println("maximum value is-->"+getMaxValue(map));
		
		System.out.println("<----by using max() method of collections class---->");
		
		int maxvalue=Collections.max(map.values());
		for (Entry<String, Integer> entry:map.entrySet()) {
			
			if(entry.getValue()==maxvalue)
			{
				System.out.println("corresponding key for max value==>"+entry.getKey()+"-->");
			}
		}
		
		
	}
}
