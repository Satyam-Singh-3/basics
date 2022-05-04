package com.foreachdemo;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

	public static List<Employee> getTaxService(String msg){
		return(msg.equalsIgnoreCase("tax"))
	        	? DataBase.getEmployee().stream().filter(emp->emp.getSal()>500000.00).collect(Collectors.toList())
		        : DataBase.getEmployee().stream().filter(emp->emp.getSal()<=500000.00).collect(Collectors.toList());

	}
	
	public static void main(String[] args) {
		List<Employee> taxService = TaxService.getTaxService("notax");
		System.out.println(taxService);
	}
}
