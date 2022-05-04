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

import com.example.tectoro.pgmt.dao.PayRollDao;
import com.example.tectoro.pgmt.domain.EmployeeDomain;
import com.example.tectoro.pgmt.domain.JobDepartmentDomain;
import com.example.tectoro.pgmt.domain.LeaveDomain;
import com.example.tectoro.pgmt.domain.PayRollDomain;
import com.example.tectoro.pgmt.domain.SalaryDomain;

@Repository
public class PayRollDaoImpl implements PayRollDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public PayRollDomain createPayroll(PayRollDomain domain) throws Exception {
		
		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO payroll.payroll ");
			sqlQuery.append("(");
			sqlQuery.append("salary_id, ");
			sqlQuery.append("job_id, ");
			sqlQuery.append("leave_id, ");
			sqlQuery.append("emp_id, ");
			sqlQuery.append("date, ");
			sqlQuery.append("report, ");
			sqlQuery.append("total_amount ");
			sqlQuery.append(") ");
			sqlQuery.append("values");
			sqlQuery.append("(?, ?, ?, ?, ?, ?, ?)");
			System.out.println(sqlQuery);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sqlQuery.toString(), new String[] { "payroll_id" });
 					ps.setInt(1,domain.getSalray().getSalaryId());
 					ps.setInt(2,domain.getJobdept().getJobId());
 					ps.setInt(3,domain.getLeave().getLeaveId());
					ps.setInt(4,domain.getEmp().getEmpId());
					java.util.Date utilDate = domain.getDate();
 					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					ps.setDate(5,sqlDate);
					ps.setString(6,domain.getReport());
					ps.setInt(7, domain.getTotalAmount());					
					return ps;
				}
			},keyHolder);
			domain.setPayrollId(keyHolder.getKey().intValue());
			return domain;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public PayRollDomain updatePayroll(PayRollDomain domain) throws Exception{

		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("update ");
			sqlQuery.append("payroll.payroll ");
			sqlQuery.append("set ");
			sqlQuery.append("emp_id = ");
			sqlQuery.append("" + domain.getEmp().getEmpId() + ",");
			sqlQuery.append("date = ");
			java.util.Date utilDate = domain.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			sqlQuery.append("'" + sqlDate + "',");
			sqlQuery.append("salary_id = ");
			sqlQuery.append("" + domain.getSalray().getSalaryId() + ",");
			sqlQuery.append("report = ");
			sqlQuery.append("'" + domain.getReport() + "',");
			sqlQuery.append("total_amount = ");
			sqlQuery.append("" + domain.getTotalAmount() + ",");
			sqlQuery.append("job_id = ");
			sqlQuery.append("" + domain.getJobdept().getJobId() + ",");
			sqlQuery.append("leave_id = ");
			sqlQuery.append("" + domain.getLeave().getLeaveId()+" ");
			sqlQuery.append("where payroll_id = ");
			sqlQuery.append("" + domain.getPayrollId() + "");
			System.out.println(sqlQuery);
			jdbcTemplate.execute(sqlQuery.toString());
			return domain;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public PayRollDomain getPayroll(PayRollDomain domain) throws Exception {
		PayRollDomain paydomain = null;
		try {
			StringBuilder sqlQuery= new StringBuilder();
			sqlQuery.append("select * from payroll.payroll ");
			sqlQuery.append("where payroll_id ="+ domain.getPayrollId());
			System.out.println(sqlQuery);
			paydomain=jdbcTemplate.query(sqlQuery.toString(), new ResultSetExtractor<PayRollDomain>(){

				@Override
				public PayRollDomain extractData(ResultSet rs) throws SQLException, DataAccessException {
					PayRollDomain domain1 = new PayRollDomain();
					while(rs.next()) {
						domain1.setPayrollId(rs.getInt("payroll_id"));
						EmployeeDomain emp = new EmployeeDomain();
						emp.setEmpId(rs.getInt("emp_id"));
						domain.setEmp(emp);
						JobDepartmentDomain job = new JobDepartmentDomain();
						job.setJobId(rs.getInt("job_id"));
						domain.setJobdept(job);
						SalaryDomain sal = new SalaryDomain();
						sal.setSalaryId(rs.getInt("salary_id"));
						domain.setSalray(sal);
						LeaveDomain lev = new LeaveDomain();
						lev.setLeaveId(rs.getInt("leave_id"));
						domain.setLeave(lev);
						domain.setDate(rs.getDate("date"));
						domain.setReport(rs.getString("report"));
						domain.setTotalAmount(rs.getInt("total_amount"));
					}
					return domain;			
				}
			});
			return paydomain;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deletePayroll(Integer payrollId) throws Exception{
		int flag = 0;
		try {
			StringBuilder query = new StringBuilder();
			query.append(" delete from payroll.payroll ");
			query.append(" where payroll_id = " + payrollId);
			flag = jdbcTemplate.update(query.toString());
			if (flag == 1) {
				return flag;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return flag;
	}
	public int deleteRelationShiptoSalary(Integer id)throws Exception {
		int flag = 0;
		try {
			StringBuilder query = new StringBuilder();
			query.append("delete from payroll ");
			query.append(" where salary_id = " + id);
			flag = jdbcTemplate.update(query.toString());
			if (flag == 1) {
				return flag;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public int deleteRelationShiptoLeave(int id) throws Exception{
		int flag = 0;
		try {

			StringBuilder query = new StringBuilder();
			query.append(" delete from payroll");
			query.append(" where emp_id = " + id);
			flag = jdbcTemplate.update(query.toString());
			if (flag == 1) {
				return flag;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public int deleteLeaveRelationShipwithPayroll(Integer id) throws Exception {
		int flag = 0;
		try {

			StringBuilder query = new StringBuilder();
			query.append(" delete from payroll");
			query.append(" where leave_id = " + id);
			flag = jdbcTemplate.update(query.toString());
			if (flag == 1) {
				return flag;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	



}
