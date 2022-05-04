package com.tectoro.ems.service.impl;

import java.util.List;

import com.tectoro.ems.dao.EmployeeDao;
import com.tectoro.ems.dao.impl.EmployeeDaoImpl;
import com.tectoro.ems.domain.Employee;
import com.tectoro.ems.domain.Location;
import com.tectoro.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeDao employeeDao= new EmployeeDaoImpl();

	@Override
	public List<Employee> getEmployee() throws Exception {
		
		return employeeDao.getEmployee();
	}

	@Override
	public Employee getEmployeeById(int empId) throws Exception {
		
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public List<Employee> getEmployeeByDepartment(int deptId) throws Exception {
		
		return employeeDao.getEmployeeByDepartment(deptId);
	}

	@Override
	public List<Employee> getEmployeeByJob(int jobId) throws Exception {
		
		return employeeDao.getEmployeeByJob(jobId);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee locationOutput = employeeDao.addEmployee(employee);
		
		if(locationOutput!= null) {
			return employee;
		}
		
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Employee locationOutput = employeeDao.updateEmployee(employee);

		if(locationOutput!= null) {
			return employee;
		}

		return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		String msg= employeeDao.deleteEmployee(empId);
		return msg;
	}

	

	

}
