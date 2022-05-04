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
import com.example.tectoro.pgmt.dao.SalaryDao;
import com.example.tectoro.pgmt.domain.JobDepartmentDomain;
import com.example.tectoro.pgmt.domain.SalaryDomain;

@Repository
public class SalaryDaoImpl implements SalaryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private PayRollDao payrollDao;

	@Override
	public SalaryDomain createSalary(SalaryDomain salaryDomain) {

		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO payroll.salary ");
			sqlQuery.append("(");
			sqlQuery.append("job_id, ");
			sqlQuery.append("amount, ");
			sqlQuery.append("annual, ");
			sqlQuery.append("bonous ");
			sqlQuery.append(") ");
			sqlQuery.append("values");
			sqlQuery.append("(?, ?, ?, ?)");
			System.out.println(sqlQuery);

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sqlQuery.toString(), new String[] { "salary_id" });
					ps.setInt(1, salaryDomain.getJobdept().getJobId());
					ps.setInt(2, salaryDomain.getAmount());
					java.util.Date utilDate = salaryDomain.getAnnual();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					ps.setDate(3, sqlDate);
					java.util.Date utilDate1 = salaryDomain.getBonous();
					java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
					ps.setDate(4, sqlDate1);
					return ps;
				}
			}, keyHolder);
			salaryDomain.setSalaryId(keyHolder.getKey().intValue());
			return salaryDomain;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SalaryDomain updateSalary(SalaryDomain salaryDomain) {

		try {

			StringBuilder query = new StringBuilder();
			query.append("update payroll.salary set ");
			if (salaryDomain.getJobdept() != null) {
				query.append("job_id =  " + salaryDomain.getJobdept().getJobId() + ", ");
			}
			if (salaryDomain.getAmount() != 0) {
				query.append("amount = " + salaryDomain.getAmount() + ", ");
			}
			if (salaryDomain.getAnnual() != null) {
				java.util.Date utilDate = salaryDomain.getAnnual();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				query.append("annual = '" + sqlDate + "', ");
			}
			if (salaryDomain.getBonous() != null) {
				java.util.Date utilDate = salaryDomain.getBonous();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				query.append("bonous = '" + sqlDate + "', ");
			}
			StringBuilder query2 = new StringBuilder();
			query2.append(query.substring(0, query.length() - 2));
			query2.append("where salary_id = " + salaryDomain.getSalaryId());
			jdbcTemplate.batchUpdate(query2.toString());
			return salaryDomain;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public SalaryDomain getSalary(Integer salaryId) throws Exception {
		SalaryDomain domain = null;
		try {
			StringBuilder query = new StringBuilder();
			query.append("select * from  payroll.salary");
			query.append(" where salary_id = " + salaryId);
			domain = jdbcTemplate.query(query.toString(), new ResultSetExtractor<SalaryDomain>() {
				@Override
				public SalaryDomain extractData(ResultSet rs) throws SQLException, DataAccessException {

					SalaryDomain domain1 = new SalaryDomain();
					while (rs.next()) {
						domain1.setSalaryId(rs.getInt("salary_id"));
						JobDepartmentDomain job = new JobDepartmentDomain();
						job.setJobId(rs.getInt("job_id"));
						domain1.setJobdept(job);
						domain1.setAmount(rs.getInt("amount"));
						domain1.setAnnual(rs.getDate("annual"));
						domain1.setBonous(rs.getDate("bonous"));
					}
					return domain1;
				}
			});
			if(domain!=null) {
				return domain;
			}else {
				throw new Exception("slary id is not exist");
			}
		} catch (Exception e) {
			throw e;
		}
		//return null;
	}

	@Override
	public int deleteSalary(Integer salaryId) {
		int flag = 0;
		try {
			StringBuilder query = new StringBuilder();
			query.append("delete from salary ");
			query.append("where salary_id = " + salaryId);
			flag = payrollDao.deleteRelationShiptoSalary(salaryId);
			if (flag == 1) {
				flag = jdbcTemplate.update(query.toString());
				if (flag == 1) {
					return flag;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
	}

	public int deleteRelationshipWithJob(Integer id) {
		int flag = 0;
		try {
			StringBuilder query = new StringBuilder();
			query.append(" delete from salary ");
			query.append(" where job_id = " + id);
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
