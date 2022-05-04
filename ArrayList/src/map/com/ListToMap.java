package map.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class student
{
	int id ;
	String name;
	public student() {
		super();
	}
	public student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + "]";
	}
	
	
}
public class ListToMap {

	public static void main(String[] args) {
		List<student>list=new ArrayList<student>();
		list.add(new student(101,"satyam"));
		list.add(new student(102,"arun"));
		list.add(new student(103,"mohan"));
		
		Map<Integer, String>map=new HashMap<Integer, String>();
		for (student entry:list) {
			map.put(entry.getId(), entry.getName());
			
		}
		System.out.println("<----map--->"+map);
		
	}
}
