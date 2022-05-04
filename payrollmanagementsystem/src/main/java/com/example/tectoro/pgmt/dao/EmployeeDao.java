package com.example.tectoro.pgmt.dao;

import com.example.tectoro.pgmt.domain.EmployeeDomain;

public interface EmployeeDao {

	EmployeeDomain createEmployee(EmployeeDomain empdomain) throws Exception;

	EmployeeDomain updateEmployee(EmployeeDomain empdomain) throws Exception;

	EmployeeDomain getEmployee(Integer empId) throws Exception;

	int deleteEmployee(Integer empId) throws Exception;



}
