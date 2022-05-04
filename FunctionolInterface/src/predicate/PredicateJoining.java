package predicate;

import java.util.function.Predicate;

public class PredicateJoining {

	public static void main(String[] args) {
		int[] x= {10,15,20,25,30,35,40};
		
		Predicate<Integer>p=y->y%2==0;
		Predicate<Integer>p1=y ->y>20;
		
		for (int x1 : x) {
			if(p.negate().test(x1))
			//if(p.and(p1).test(x1))
			{
				System.out.println(x1);
			}
		}
	}
}
