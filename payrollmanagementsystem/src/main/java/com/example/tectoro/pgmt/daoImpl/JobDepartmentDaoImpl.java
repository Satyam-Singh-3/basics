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

import com.example.tectoro.pgmt.dao.JobDepartmentDao;
import com.example.tectoro.pgmt.dao.PayRollDao;
import com.example.tectoro.pgmt.dao.SalaryDao;
import com.example.tectoro.pgmt.domain.JobDepartmentDomain;

@Repository
public class JobDepartmentDaoImpl implements JobDepartmentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PayRollDao payrollDao;
	@Autowired
	private SalaryDao salDao;

	@Override
	public JobDepartmentDomain createJobDepartment(JobDepartmentDomain jobdeptDomain) throws Exception {
		
		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO payroll.job_department ");
			sqlQuery.append("(");
			sqlQuery.append("job_dept , ");
			sqlQuery.append("name , ");
			sqlQuery.append("description, ");
			sqlQuery.append("salary_range ");
			sqlQuery.append(") ");
			sqlQuery.append("values");
			sqlQuery.append("(?, ?, ?, ?)");
			System.out.println(sqlQuery);
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sqlQuery.toString(), new String[] { "job_id" });
					ps.setString(1,jobdeptDomain.getJobDept());
					ps.setString(2,jobdeptDomain.getName());
					ps.setString(3,jobdeptDomain.getDescription());
					ps.setInt(4, jobdeptDomain.getSalaryRange());
					return ps;
				}
			}, keyHolder);
			jobdeptDomain.setJobId(keyHolder.getKey().intValue());
			return jobdeptDomain;
			
		} catch (Exception e) {
			System.out.println("Error in Dao");
			e.printStackTrace();
			throw e;
		}
		//return null;
	}

	@Override
	public JobDepartmentDomain updateJobDepartment(JobDepartmentDomain jobdeptDomain)throws Exception {
		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("update ");
			sqlQuery.append("payroll.job_department ");
			sqlQuery.append("set ");
			sqlQuery.append("job_dept = ");
			sqlQuery.append("'" + jobdeptDomain.getJobDept() + "',");
			sqlQuery.append("name = ");
			sqlQuery.append("'" + jobdeptDomain.getName() + "',");
			sqlQuery.append("description = ");
			sqlQuery.append("'" + jobdeptDomain.getDescription() + "',");
			sqlQuery.append("salary_range = ");
			sqlQuery.append("" + jobdeptDomain.getSalaryRange()+"");
			sqlQuery.append("where job_id = ");
			sqlQuery.append("" + jobdeptDomain.getJobId() + "");
			System.out.println(sqlQuery);
			jdbcTemplate.execute(sqlQuery.toString());
			return jobdeptDomain;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		//return null;
	}

	@Override
	public JobDepartmentDomain getJobDepartment(Integer jobId)throws Exception {
		
		JobDepartmentDomain jobdeptDomain = null;
		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("select * from payroll.job_department ");
			sqlQuery.append("where job_id = " +jobId);
			jobdeptDomain=jdbcTemplate.query(sqlQuery.toString(), new ResultSetExtractor<JobDepartmentDomain>(){

				@Override
				public JobDepartmentDomain extractData(ResultSet rs) throws SQLException, DataAccessException {
					JobDepartmentDomain jobDomain = new JobDepartmentDomain();
					while(rs.next()){
						jobDomain.setJobId(rs.getInt("job_id"));
						jobDomain.setJobDept(rs.getString("job_dept"));
						jobDomain.setDescription(rs.getString("description"));
						jobDomain.setName(rs.getString("name"));
						jobDomain.setSalaryRange(rs.getInt("salary_range"));
					}
					return jobDomain;
				}
			});
			return jobdeptDomain;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	//return null;
	}
	
	
		@Override
		public int deleteJobDepartment(Integer empId) throws Exception {
			int flag = 0;
			try {
				StringBuilder query = new StringBuilder();
				query.append("delete from jobdepartment");
				query.append(" where job_id = " + empId);
				flag = payrollDao.deleteRelationShiptoSalary(empId);

				if (flag>=0) {
					flag = salDao.deleteRelationshipWithJob(empId);
					if (flag >=0 ) {
						flag = jdbcTemplate.update(query.toString());
						if (flag >=0) {
							return flag;
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return flag;
		}

}



