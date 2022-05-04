package com.tectoro.ems.service;

import java.util.List;

import com.tectoro.ems.domain.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee() throws Exception;
	public Employee getEmployeeById(int empId) throws Exception;
	public List<Employee> getEmployeeByDepartment(int deptId) throws Exception;
	public List<Employee> getEmployeeByJob(int jobId) throws Exception;
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public String deleteEmployee(int empId);

}
