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

import com.example.tectoro.pgmt.dao.EmployeeDao;
import com.example.tectoro.pgmt.dao.LeaveDao;
import com.example.tectoro.pgmt.dao.PayRollDao;
import com.example.tectoro.pgmt.domain.EmployeeDomain;
import com.example.tectoro.pgmt.domain.LeaveDomain;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	LeaveDao leavedao;
	@Autowired
	PayRollDao payrolldao;

	@Override
	public EmployeeDomain createEmployee(EmployeeDomain empdomain)throws Exception {

		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO payroll.employee ");
			sqlQuery.append("(");
			sqlQuery.append("fname , ");
			sqlQuery.append("lname , ");
			sqlQuery.append("gender, ");
			sqlQuery.append("age, ");
			sqlQuery.append("contact_add, ");
			sqlQuery.append("emp_email,");
			sqlQuery.append("emp_pass ");
			sqlQuery.append(") ");
			sqlQuery.append("values");
			sqlQuery.append("(?, ?, ?, ?, ?, ?, ?)");
			System.out.println(sqlQuery);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sqlQuery.toString(), new String[] { "emp_id" });
					ps.setString(1,empdomain.getFname());
					ps.setString(2,empdomain.getLname());
					ps.setString(3,empdomain.getGender());
					ps.setInt(4, empdomain.getAge());
					ps.setString(5,empdomain.getConactAdd());
					ps.setString(6,empdomain.getEmpEmail());
					ps.setString(7,empdomain.getEmpPass());
					return ps;
				}
			}, keyHolder);
			empdomain.setEmpId(keyHolder.getKey().intValue());
			return empdomain;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public EmployeeDomain updateEmployee(EmployeeDomain empdomain) throws Exception{

		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("update ");
			sqlQuery.append("payroll.employee ");
			sqlQuery.append("set ");
			sqlQuery.append("fname = ");
			sqlQuery.append("'" + empdomain.getFname() + "',");
			sqlQuery.append("lname = ");
			sqlQuery.append("'" + empdomain.getLname() + "',");
			sqlQuery.append("gender = ");
			sqlQuery.append("'" + empdomain.getGender() + "',");
			sqlQuery.append("age = ");
			sqlQuery.append("'" + empdomain.getAge() + "',");
			sqlQuery.append("contact_add = ");
			sqlQuery.append("'" + empdomain.getConactAdd() + "',");
			sqlQuery.append("emp_email= ");
			sqlQuery.append("'" + empdomain.getEmpEmail() + "'");
			sqlQuery.append("where emp_id = ");
			sqlQuery.append("'" + empdomain.getEmpId() + "'");
			System.out.println(sqlQuery);
			jdbcTemplate.execute(sqlQuery.toString());
			return empdomain;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public EmployeeDomain getEmployee(Integer empId)throws Exception {

		EmployeeDomain domain=null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from employee ");
			sql.append(" where emp_id  = "+empId);
			domain=jdbcTemplate.query(sql.toString(), new ResultSetExtractor<EmployeeDomain>(){

				@Override
				public EmployeeDomain  extractData(ResultSet rs) throws SQLException, DataAccessException {
					EmployeeDomain domain =  new EmployeeDomain();
					while(rs.next())
					{
						domain.setEmpId(rs.getInt("emp_id"));
						domain.setFname(rs.getString("fname"));
						domain.setLname(rs.getString("lname"));
						domain.setGender(rs.getString("gender"));
						domain.setAge(rs.getInt("age"));
						domain.setConactAdd(rs.getString("contact_add"));
						domain.setEmpEmail(rs.getString("emp_email"));
						domain.setEmpPass(rs.getString("emp_pass"));
					}
					return domain;
				}
			});
			if(domain.getEmpId()!=0) {
				return domain;
			}else {
				throw new Exception("Employee information is not valid");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int deleteEmployee(Integer empId) throws Exception{

		int flag = 0;
		try {
			StringBuilder query = new StringBuilder();
			query.append("delete from employee");
			query.append(" where emp_id  = " + empId);
			LeaveDomain domain = leavedao.getLeave(empId);
			int leaveid = domain.getLeaveId();
			flag = payrolldao.deleteLeaveRelationShipwithPayroll(leaveid);
			if (flag >= 0) {

				flag = jdbcTemplate.update(query.toString());
				if (flag >= 0) {
					flag = 1;
					return flag;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

}
