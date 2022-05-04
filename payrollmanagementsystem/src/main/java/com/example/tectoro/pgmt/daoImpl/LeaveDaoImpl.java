package com.example.tectoro.pgmt.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.tectoro.pgmt.dao.LeaveDao;
import com.example.tectoro.pgmt.dao.PayRollDao;
import com.example.tectoro.pgmt.domain.EmployeeDomain;
import com.example.tectoro.pgmt.domain.LeaveDomain;

@Repository
public class LeaveDaoImpl implements LeaveDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PayRollDao payrollDao;

	@Override
	public LeaveDomain createLeave(LeaveDomain domain) throws Exception {
		
		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO payroll.leave ");
			sqlQuery.append("(");
			sqlQuery.append("emp_id, ");
			sqlQuery.append("date, ");
			sqlQuery.append("status, ");
			sqlQuery.append("reason ");
			sqlQuery.append(") ");
			sqlQuery.append("values");
			sqlQuery.append("(?, ?, ?, ?)");
			System.out.println(sqlQuery);
						
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sqlQuery.toString(), new String[] { "leave_id" });
 					ps.setInt(1,domain.getEmp().getEmpId());
 					java.util.Date utilDate = domain.getDate();
 					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					ps.setDate(2,sqlDate);
					ps.setString(3,domain.getStatus());
					ps.setString(4,domain.getReason());
					return ps;
				}
			},keyHolder);
			domain.setLeaveId(keyHolder.getKey().intValue());
			if(domain!=null) {
			return domain;
			}else {
				throw new Exception("employee id not exist");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public LeaveDomain updateLeave(LeaveDomain domain) {
		
		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("update ");
			sqlQuery.append("payroll.leave ");
			sqlQuery.append("set ");
			sqlQuery.append("emp_id = ");
			sqlQuery.append("" + domain.getEmp().getEmpId() + ",");
			sqlQuery.append("date = ");
			java.util.Date utilDate = domain.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			sqlQuery.append("'" + sqlDate + "',");
			sqlQuery.append("status = ");
			sqlQuery.append("'" + domain.getStatus() + "',");
			sqlQuery.append("reason = ");
			sqlQuery.append("'" + domain.getReason()+"' ");
			sqlQuery.append("where leave_id = ");
			sqlQuery.append("" + domain.getLeaveId() + "");
			System.out.println(sqlQuery);
			jdbcTemplate.execute(sqlQuery.toString());
			return domain;
	}catch (Exception e) {
		e.printStackTrace();
	}
		return null;
		
}

	@Override
	public LeaveDomain getLeave(Integer leaveId) {
		
		LeaveDomain leavedomain = null;
		try {
			StringBuilder sqlQuery= new StringBuilder();
			sqlQuery.append("select * from payroll.leave ");
			sqlQuery.append("where leave_id ="+ leaveId);
			System.out.println(sqlQuery);
			leavedomain=jdbcTemplate.query(sqlQuery.toString(), new ResultSetExtractor<LeaveDomain>(){

				@Override
				public LeaveDomain extractData(ResultSet rs) throws SQLException, DataAccessException {
					LeaveDomain leavedomain1 = new LeaveDomain();
					while(rs.next()) {
						leavedomain1.setLeaveId(rs.getInt("leave_id"));
						EmployeeDomain emp = new EmployeeDomain();
						emp.setEmpId(rs.getInt("emp_id"));
						leavedomain1.setEmp(emp);
						leavedomain1.setDate(rs.getDate("date"));
						leavedomain1.setStatus(rs.getString("status"));
						leavedomain1.setReason(rs.getString("reason"));
					}
					return leavedomain1;
				}
			});
			return leavedomain;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int deleteLeave(Integer leaveId) {

		int flag = 0;
		try {
			StringBuilder query = new StringBuilder();
			query.append("delete from leave");
			query.append(" where leave_id = " + leaveId);
			flag = payrollDao.deleteLeaveRelationShipwithPayroll(leaveId);
			if (flag == 1) {
				flag = jdbcTemplate.update(query.toString());
				if (flag == 1) {
					return flag;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return flag;
	}

	public int deleteRelationShipWithEmployee(int id) {
		int flag = 0;
		try {
			StringBuilder query = new StringBuilder();
			query.append("delete from leave");
			query.append(" where emp_id = " + id);
			flag = jdbcTemplate.update(query.toString());
			if (flag == 1) {
				return flag;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return flag;

	}



}
