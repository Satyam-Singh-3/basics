package comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegersSorting {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(10,5,7,20,4,18);
		
		System.out.println("=================================================");
		
		Collections.sort(list);
		
		System.out.println("=================================================");
		
		System.out.println("After sorting -->"+list);
		
		System.out.println("=================================================");
		
		Collections.sort(list,Collections.reverseOrder());
		
		System.out.println("Reverse order sorting-->"+list);
	}
}
