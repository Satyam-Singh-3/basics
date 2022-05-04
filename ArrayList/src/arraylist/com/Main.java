package arraylist.com;

import java.util.ArrayList;
import java.util.Comparator;

class Employee1 {
	int id;
	String name;
	public Employee1() {
		// TODO Auto-generated constructor stub
	}

	public Employee1(int id, String name) {
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

}

public class Main implements Comparator<Employee1> {
	@Override
	public int compare(Employee1 o1, Employee1 o2) {
		// TODO Auto-generated method stub
		return o1.name.length() - o2.name.length();
	}

	class MainClass {
		public static void main(String[] args) {

			ArrayList<Employee1> arrayList = new ArrayList<>();
			Employee1 employee1 = new Employee1();
			employee1.setId(101);
			employee1.setName("Satyam");
			arrayList.add(employee1);
			System.out.println(arrayList);

		}
	}

}
