package com.tectoro.ems.dao;

import java.util.List;

import com.tectoro.ems.domain.Employee;

public interface EmployeeDao {

	List<Employee> getEmployee() throws Exception;

	List<Employee> getEmployee(int jobId) throws Exception;

	Employee getEmployeeById(int empId) throws Exception;

	List<Employee> getEmployeeByDepartment(int deptId) throws Exception;

	List<Employee> getEmployeeByJob(int jobId) throws Exception;

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	String deleteEmployee(int empId);



}
