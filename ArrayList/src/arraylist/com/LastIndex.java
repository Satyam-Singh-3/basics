package arraylist.com;

import java.util.ArrayList;

public class LastIndex {

	public static void main(String[] args) {
		ArrayList<String>s=new ArrayList<String>(5);
		s.add("P");
		s.add("Q");
		s.add("R");
		s.add("p");
		s.add("R");
		
		System.out.println("First Occurence Of P:"+s.indexOf("P"));		
		System.out.println("Last Occurence Of R:"+s.lastIndexOf("R"));
        
       
        
	}
}
