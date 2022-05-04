package com.tectoro.ems.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tectoro.ems.dao.EmployeeDao;
import com.tectoro.ems.db.config.JdbcConnection;
import com.tectoro.ems.domain.Employee;


public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployee() throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select emp_id, first_name,last_name,email,phone_num ,hire_date,job_id,salary,manager_id,dept_id ,location_code from employee ";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setPhoneNum(rs.getInt("phone_num"));
				employee.setHireDate(rs.getString("hire_date"));
				employee.setJobId(rs.getInt("job_id"));
				employee.setSalary(rs.getString("salary"));
				employee.setManagerId(rs.getInt("manager_id"));
				employee.setDeptId(rs.getInt("dept_id"));
				employee.setLocationCode(rs.getString("location_code")); 
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public List<Employee> getEmployee(int jobId) throws Exception {
		List<Employee> employeeList = new ArrayList();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select emp_id, first_name,last_name,email,phone_num ,hire_date,job_id,salary,manager_id,dept_id ,location_code from employee where job_id= "+jobId;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
			
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setPhoneNum(rs.getInt("phone_num"));
				employee.setHireDate(rs.getString("hire_date"));
				employee.setJobId(rs.getInt("job_id"));
				employee.setSalary(rs.getString("salary"));
				employee.setManagerId(rs.getInt("manager_id"));
				employee.setDeptId(rs.getInt("dept_id"));
				employee.setLocationCode(rs.getString("location_code")); 
				employeeList.add(employee);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int empId) throws Exception {
		Employee employee= new Employee();
		int code=empId;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select emp_id, first_name,last_name,email,phone_num ,hire_date,job_id,salary,manager_id,dept_id ,location_code from employee where emp_id= "+code;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setPhoneNum(rs.getInt("phone_num"));
				employee.setHireDate(rs.getString("hire_date"));
				employee.setJobId(rs.getInt("job_id"));
				employee.setSalary(rs.getString("salary"));
				employee.setManagerId(rs.getInt("manager_id"));
				employee.setDeptId(rs.getInt("dept_id"));
				employee.setLocationCode(rs.getString("location_code"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
		
	}

	@Override
	public List<Employee> getEmployeeByDepartment(int deptId) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		int code=deptId;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select emp_id, first_name,last_name,email,phone_num ,hire_date,job_id,salary,manager_id,dept_id ,location_code from employee where dept_id= "+code;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setPhoneNum(rs.getInt("phone_num"));
				employee.setHireDate(rs.getString("hire_date"));
				employee.setJobId(rs.getInt("job_id"));
				employee.setSalary(rs.getString("salary"));
				employee.setManagerId(rs.getInt("manager_id"));
				employee.setDeptId(rs.getInt("dept_id"));
				employee.setLocationCode(rs.getString("location_code"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByJob(int jobId) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		int code=jobId;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select emp_id, first_name,last_name,email,phone_num ,hire_date,job_id,salary,manager_id,dept_id ,location_code from employee where job_id= "+code;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setPhoneNum(rs.getInt("phone_num"));
				employee.setHireDate(rs.getString("hire_date"));
				employee.setJobId(rs.getInt("job_id"));
				employee.setSalary(rs.getString("salary"));
				employee.setManagerId(rs.getInt("manager_id"));
				employee.setDeptId(rs.getInt("dept_id"));
				employee.setLocationCode(rs.getString("location_code"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("INSERT ");
			query.append("INTO ");
			query.append("EMPLOYEE ");
			query.append("VALUES ");
			query.append("( ");
			query.append(employee.getEmpId()+",");
			query.append("'"+employee.getFirstName()+"',");
			query.append("'"+employee.getLastName()+"',");
			query.append("'"+employee.getEmail()+"',");
			query.append("'"+employee.getPhoneNum()+"',");
			query.append("'"+employee.getHireDate()+"',");
			query.append(employee.getJobId()+",");
			query.append(employee.getSalary()+",");
			query.append(employee.getManagerId()+",");
			query.append(employee.getDeptId()+",");
			query.append("'"+employee.getLocationCode()+"'");
			query.append(" )");
			System.out.println(query);
			
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return employee;
			}
			else {
				return null;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("UPDATE ");
			query.append("EMPLOYEE ");
			query.append("SET first_name= ");
			query.append("'"+employee.getFirstName()+"',");
			query.append("last_name= ");
			query.append("'"+employee.getLastName()+"',");
			query.append("email= ");
			query.append("'"+employee.getEmail()+"',");
			query.append("phone_num= ");
			query.append("'"+employee.getPhoneNum()+"',");
			query.append("hire_date= ");
			query.append("'"+employee.getHireDate()+"',");
			query.append("job_id= ");
			query.append(employee.getJobId()+",");
			query.append("salary= ");
			query.append(employee.getSalary()+",");
			query.append("manager_id= ");
			query.append(employee.getManagerId()+",");
			query.append("dept_id= ");
			query.append(employee.getDeptId()+",");
			query.append("location_code= ");
			query.append("'"+employee.getLocationCode()+"'");
			query.append("WHERE emp_id= ");
			query.append(employee.getEmpId());
	
			System.out.println(query);
			
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return employee;
			}
			else {
				return null;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("DELETE ");
			query.append("FROM ");
			query.append("EMPLOYEE ");
			query.append("WHERE ");
			query.append("emp_id= ");
			query.append(empId);
			System.out.println(query);
			//String query = "DELETE FROM region WHERE region_id= "+regionId;
			int rs= JdbcConnection.executeDelete(st, query.toString());
			if(rs>0) {
				return "deleted sucessfully";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "not available in region";
	}

}
