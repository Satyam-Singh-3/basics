package com.tectoro.myspringproject;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/employeeapi")
public class EmployeeController {
	
	@GetMapping("/employee")
	public List<EmployeeDomain> getEmployee(){
		
		return  Arrays.asList(new EmployeeDomain("sudhansu",101,"1000"));
		
	}

	

}