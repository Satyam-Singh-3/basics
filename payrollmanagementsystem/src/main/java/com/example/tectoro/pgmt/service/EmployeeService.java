package com.example.tectoro.pgmt.service;

import com.example.tectoro.pgmt.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employeeModel) throws Exception;

	Employee updateEmployee(Employee employeeModel) throws Exception;

	Employee getEmployee(Integer empId) throws Exception;

	int deleteEmployee(Integer empId) throws Exception;

}
