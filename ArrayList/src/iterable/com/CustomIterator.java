package iterable.com;
import java.util.*;


class Students implements Iterable
{
    List<String> list=null;
    public Students()
    {   
    	list=new ArrayList<String>();
    	list.add("Satyam");
    	list.add("Arun");
    	list.add("Mohan");
    	list.add("Saurabh");
    }
    
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}
	
}

public class CustomIterator
{
   public static void main(String[] args)
   {
	 Students students=new Students();
	 for (String string : students.list) {
		
		 System.out.println(string);
	    
	}
	 
   }
}
