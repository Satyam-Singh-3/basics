package com.empproject.service;

import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.empproject.entity.Employee;
import com.empproject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> saveAllEmp(List<Employee> emp) {
		return employeeRepository.saveAll(emp);
	}

	public void updateSalary(Integer id, Employee employee) {
		Employee employee2 = employeeRepository.getById(id);
		employee2.setSalary(employee.getSalary());
		employeeRepository.save(employee2);
	}

	public void deleteEmpByName(String name) {
		employeeRepository.deleteEmpName(name);
		;
	}

	public List<Employee> salaryAboveFive() {
		List<Employee> list = employeeRepository.findAll();
		
		List<Employee>empList=list.stream().filter(l->l.getSalary()>500000).collect(Collectors.toList());
		
		/*
		 * List<Employee> empList = new ArrayList<Employee>(); for (Employee employee2 :
		 * list) { if (employee2.getSalary() > 500000) empList.add(employee2); }
		 */

		return empList;
	}

	public List<Employee> getEmpExperienceMoreThanTwoYears() {
		List<Employee> list = employeeRepository.findAll();

		List<Employee> employees = list.stream().filter(e->e.getExperiance()>2).collect(Collectors.toList());
		
		/*List<Employee> employees=new ArrayList<Employee>();
		for (Employee emp : list) {
			if (emp.getExperiance() > 2) {
				employees.add(emp);
			}
		}*/
		
		return employees;
	}

	public List<Employee> reverseEmpBasedOnNames() {
		List<Employee> employees = employeeRepository.findAll();

		// employees.sort((Employee e1, Employee e2) ->
		// e2.getFirst_name().compareTo(e1.getFirst_name()));
		Collections.sort(employees, Comparator.comparing(Employee::getFirst_name).reversed());
		return employees;
	}
	
	
	public Optional<Employee> findEmpById(Integer eid)
	{
		return employeeRepository.findById(eid);
	}
	
	publi

}
