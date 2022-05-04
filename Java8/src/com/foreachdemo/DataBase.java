package com.foreachdemo;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

	public static List<Employee> getEmployee() {
		List<Employee>empList=new ArrayList<Employee>();
		empList.add(new Employee(1,"Satyam",500000.00));
		empList.add(new Employee(1,"Saurabh",600000.00));
		empList.add(new Employee(1,"Sandeep",700000.00));
		empList.add(new Employee(1,"Arun",300000.00));
		return empList;
		
	}
}
