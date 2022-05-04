package iterable.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveOperation {

	public static void main(String[] args) {
		List<Integer> it=new ArrayList<Integer>();
		it.add(10);
		it.add(20);
		it.add(30);
		it.add(40);
		
		Iterator<Integer> itr=it.iterator();
		
		while(itr.hasNext())
		{
			Integer i=itr.next();
			if(i<=40)
			{
				itr.remove();
			}
			System.out.println(it);
		}
	}
}
