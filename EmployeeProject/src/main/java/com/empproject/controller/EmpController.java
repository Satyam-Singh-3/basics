package com.empproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empproject.entity.Employee;
import com.empproject.service.EmployeeService;

@RestController
public class EmpController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public List<Employee> addAllEmp(@RequestBody List<Employee> emp) {
		return employeeService.saveAllEmp(emp);
	}

	@PutMapping("/update/{id}")
	public void updateEMpSalary(@PathVariable Integer id, @RequestBody Employee employee) {

		employeeService.updateSalary(id, employee);

	}

	@DeleteMapping("/delete/{name}")
	public void deleteEmployeeByName(@PathVariable String name) {
		employeeService.deleteEmpByName(name);
	}

	@GetMapping("/find")
	public List<Employee> getEmployeeBySalary() {
		return employeeService.salaryAboveFive();
	}

	@GetMapping("/exp")
	public List<Employee> getExperiencedSalary() {
		return employeeService.getEmpExperienceMoreThanTwoYears();
	}

	@GetMapping("/emp_reverse")
	public List<Employee> getEmpInReverseOrder() {
		return employeeService.reverseEmpBasedOnNames();
	}
	
	@GetMapping("/get/{eid}")
	public Optional<Employee> findById(@PathVariable Integer eid)
	{
		return employeeService.findEmpById(eid);
	}

}
