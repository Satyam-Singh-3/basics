package com.tectoro.ems.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tectoro.ems.dao.DepartmentDao;
import com.tectoro.ems.db.config.JdbcConnection;
import com.tectoro.ems.domain.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> getDepartment() throws Exception {

		List<Department> dept= new ArrayList();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "select dept_id,dept_name from department d ; ";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Department department = new Department();
				department.setDeptId(rs.getInt("dept_id"));
				department.setDeptName(rs.getString("dept_name"));
				dept.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	@Override
	public Department getDepartmentById(int deptId) throws Exception {
		Department dept = new Department();
		int code= deptId;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "select dept_id,dept_name from department d where dept_id= "+code;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				dept.setDeptId(rs.getInt("dept_id"));
				dept.setDeptName(rs.getString("dept_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	@Override
	public Department addDepartment(Department department) {
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("INSERT ");
			query.append("INTO ");
			query.append("DEPARTMENT ");
			query.append("VALUES ");
			query.append("( ");
			query.append(department.getDeptId()+",");
			query.append("'"+department.getDeptName()+"'");
			query.append(" )");
			
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return department;
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
	public Department updateDepartmaent(Department department) {
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("UPDATE ");
			query.append("DEPARTMENT ");
			query.append("SET dept_name= ");
			query.append("'"+department.getDeptName()+"'");
			query.append("WHERE dept_id= ");
			query.append(department.getDeptId());
			System.out.println(query);
			
			int rs= JdbcConnection.executeUpdate(st, query.toString());
			if(rs>0) {
				return department;
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
	public String deleteDepartment(int deptId) {
		
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("DELETE ");
			query.append("FROM ");
			query.append("DEPARTMENT ");
			query.append("WHERE ");
			query.append("dept_id= ");
			query.append(deptId);
			System.out.println(query);
			int rs= JdbcConnection.executeDelete(st, query.toString());
			if(rs>0) {
				return "deleted sucessfully";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "not available in Department";	
		
	
	}

}
