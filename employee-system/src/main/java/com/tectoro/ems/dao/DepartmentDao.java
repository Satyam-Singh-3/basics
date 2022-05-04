package com.tectoro.ems.dao;

import java.util.List;

import com.tectoro.ems.domain.Department;

public interface DepartmentDao {

	List<Department> getDepartment() throws Exception;

	Department getDepartmentById(int deptId) throws Exception;

	Department addDepartment(Department department);

	Department updateDepartmaent(Department department);

	String deleteDepartment(int deptId);

}
