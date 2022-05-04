package com.tectoro.ems.service;

import java.util.List;

import com.tectoro.ems.domain.Department;

public interface DepartmentService {
	
	public List<Department> getDepartment() throws Exception;
	public Department getDepartmentById(int deptId) throws Exception;
	public Department addDepartment(Department department);
	public Department updateDepartmaent(Department department);
	public String deleteDepartment(int deptId);
	
}
