package map.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveAnEntryUsingKey {

	public static void main(String[] args) {
		HashMap<Integer, String>map=new HashMap<Integer, String>();
		map.put(101, "satyam");
	    map.put(102, "mphan");
	    map.put(103, "arun");
	    
	    int removekey=102;
	    Iterator<Entry<Integer, String>>itr=map.entrySet().iterator();
	    
	    while (itr.hasNext()) {
		 Map.Entry<Integer,String> str=itr.next();
		 if(removekey==str.getKey())
		 {
			 itr.remove();
		 }
		}
	    System.out.println("modified map-->"+map);
	}
}
