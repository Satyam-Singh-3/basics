package com.tectoro.ems.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tectoro.ems.dao.DependDao;
import com.tectoro.ems.db.config.JdbcConnection;
import com.tectoro.ems.domain.Depend;


public class DependDaoImpl implements DependDao {

	@Override
	public List<Depend> getDepend(int empId) {
		List<Depend> dependList= new ArrayList();

		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select depend_id, first_name, last_name, relation, emp_id from depend d where emp_id="+empId;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Depend depend = new Depend();
				depend.setDependId(rs.getInt("depend_id"));
				depend.setFirstName(rs.getString("first_name"));
				depend.setLastName(rs.getString("last_name"));
				depend.setRelation(rs.getString("relation"));
				depend.setEmpId(rs.getInt("emp_id"));
				dependList.add(depend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dependList;
	}

	@Override
	public List<Depend> getDependById(int empId) {
		List<Depend> dependList= new ArrayList();

		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select depend_id, first_name, last_name, relation, emp_id from depend d where emp_id="+empId;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Depend depend = new Depend();
				depend.setDependId(rs.getInt("depend_id"));
				depend.setFirstName(rs.getString("first_name"));
				depend.setLastName(rs.getString("last_name"));
				depend.setRelation(rs.getString("relation"));
				depend.setEmpId(rs.getInt("emp_id"));
				dependList.add(depend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dependList;
	}

	@Override
	public Depend addDepend(Depend depend) {
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("INSERT ");
			query.append("INTO ");
			query.append("DEPEND ");
			query.append("VALUES ");
			query.append("( ");
			query.append(depend.getDependId()+",");
			query.append("'"+depend.getFirstName()+"',");
			query.append("'"+depend.getLastName()+"',");
			query.append("'"+depend.getRelation()+"',");
			query.append(depend.getEmpId());
			query.append(" )");
			
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return depend;
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
	public Depend updateDepend(Depend depend) {
		
		try {
			Connection conn= JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("UPDATE ");
			query.append("DEPEND ");
			query.append("SET first_name= ");
			query.append("'"+depend.getFirstName()+"',");
			query.append("last_name= ");
			query.append("'"+depend.getLastName()+"',");
			query.append("relation= ");
			query.append("'"+depend.getRelation()+"',");
			query.append("emp_id= ");
			query.append(depend.getEmpId());
			query.append("WHERE depend_id= ");
			query.append(depend.getDependId());
			System.out.println(query);
		int rs= JdbcConnection.executeUpdate(st, query.toString());
		if(rs>0) {
			return depend;
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public String delteDepend(int dependId) {
		try {
			Connection conn= JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("DELETE ");
			query.append("FROM ");
			query.append("DEPEND ");
			query.append("WHERE depend_id= ");
			query.append(dependId);
			System.out.println(query);
		int rs= JdbcConnection.executeDelete(st, query.toString());
		if(rs>0) {
			return "delete sucessfully";
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	
	
	
	
	

}
