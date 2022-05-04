package com.tectoro.ems.service.impl;

import java.util.List;

import com.tectoro.ems.dao.DepartmentDao;
import com.tectoro.ems.dao.impl.DepartmentDaoImpl;
import com.tectoro.ems.domain.Department;
import com.tectoro.ems.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private static DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	public List<Department> getDepartment() throws Exception {
		
		return departmentDao.getDepartment();
	}

	@Override
	public Department getDepartmentById(int deptId) throws Exception {
		
		return departmentDao.getDepartmentById(deptId);
	}

	@Override
	public Department addDepartment(Department department) {
		Department departmentOutput = departmentDao.addDepartment(department);
		
		if(departmentOutput!= null) {
			return department;
		}
		return null;
	}

	@Override
	public Department updateDepartmaent(Department department) {
		Department departmentOutput = departmentDao.updateDepartmaent(department);
		
		if(departmentOutput!= null) {
			return department;
		}
		return null;

		
	}

	@Override
	public String deleteDepartment(int deptId) {
		String msg = departmentDao.deleteDepartment(deptId);
		return msg;
	}

}
