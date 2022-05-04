package com.example.tectoro.pgmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tectoro.pgmt.dao.EmployeeDao;
import com.example.tectoro.pgmt.domain.EmployeeDomain;
import com.example.tectoro.pgmt.model.Employee;
import com.example.tectoro.pgmt.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;

	@Override
	public Employee createEmployee(Employee employeeModel) throws Exception {

		try {

			if (employeeModel != null) {
				EmployeeDomain employeedomain = new EmployeeDomain();
				populateDomainFromBean(employeeModel, employeedomain);

				employeedomain = empDao.createEmployee(employeedomain);
				populateBeanFromDomain(employeeModel, employeedomain);
				return employeeModel;
			} else {
				throw new Exception("Employee object is empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		//return null;
	}

	@Override
	public Employee updateEmployee(Employee employeeModel) throws Exception {

		try {
			if (employeeModel != null) {
				EmployeeDomain employeedomain = new EmployeeDomain();
				employeedomain.setEmpId(Integer.parseInt(employeeModel.getEmpId()));
				populateDomainFromBean(employeeModel, employeedomain);

				employeedomain = empDao.updateEmployee(employeedomain);
				Employee model = new Employee();
				populateBeanFromDomain(employeeModel, employeedomain);
				return model;

			} else {
				throw new Exception("Employee object is empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(Integer empId) throws Exception {

		EmployeeDomain employeedomain = null;
		try {
			if (empId != null) {
				EmployeeDomain empdomain = new EmployeeDomain();
				empdomain.setEmpId(empId);

				employeedomain = empDao.getEmployee(empId);
				if (employeedomain != null) {
					Employee employeeModel = new Employee();
					populateBeanFromDomain(employeeModel, employeedomain);
					return employeeModel;
				} else {
					return null;
				}
			} else {
				throw new Exception("Employee object is empty");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void populateDomainFromBean(Employee employeeModel, EmployeeDomain employeedomain) {
		//employeedomain.setEmpId(Integer.parseInt(employeeModel.getEmpId()));
		employeedomain.setFname(employeeModel.getFname());
		employeedomain.setLname(employeeModel.getLname());
		employeedomain.setGender(employeeModel.getGender());
		employeedomain.setAge(Integer.parseInt(employeeModel.getAge()));
		employeedomain.setConactAdd(employeeModel.getConactAdd());
		employeedomain.setEmpEmail(employeeModel.getEmpEmail());
		employeedomain.setEmpPass(employeeModel.getEmpPass());
	}

	private void populateBeanFromDomain(Employee employeeModel, EmployeeDomain employeedomain) {
		employeeModel.setEmpId(String.valueOf(employeedomain.getEmpId()));
		employeeModel.setFname(employeedomain.getFname());
		employeeModel.setLname(employeedomain.getLname());
		employeeModel.setGender(employeedomain.getGender());
		employeeModel.setAge(String.valueOf(employeedomain.getAge()));
		employeeModel.setConactAdd(employeedomain.getConactAdd());
		employeeModel.setEmpEmail(employeedomain.getEmpEmail());
		employeeModel.setEmpPass(employeedomain.getEmpPass());
	}

	@Override
	public int deleteEmployee(Integer empId) throws Exception {
		int flag = 0;
		EmployeeDomain domain1 = new EmployeeDomain();
		try {
			domain1 = empDao.getEmployee(empId);
			if (domain1.getEmpId() != 0) {
				flag = empDao.deleteEmployee(empId);
				return flag;

			}
		} catch (Exception e) {
			throw new Exception("not a valid empid to delete");
		}
		return flag;
	}

}
