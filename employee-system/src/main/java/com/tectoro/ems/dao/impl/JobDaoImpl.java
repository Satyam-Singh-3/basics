package com.tectoro.ems.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tectoro.ems.dao.JobDao;
import com.tectoro.ems.db.config.JdbcConnection;
import com.tectoro.ems.domain.Job;

public class JobDaoImpl implements JobDao {

	@Override
	public List<Job> getJob() throws Exception {
		List<Job> jobList = new ArrayList<>();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select job_id,job_title,max_sal,min_sal from jobs j ";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Job jobs = new Job();
				jobs.setJobId(rs.getInt("job_id"));
				jobs.setJobTitle(rs.getString("job_title"));
				jobs.setMaxSalary(rs.getInt("max_sal"));
				jobs.setMinSalary(rs.getInt("min_sal"));
				jobList.add(jobs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobList;
	}

	@Override
	public Job getJobById(int jobId) throws Exception {
		
		Job jobs= new Job();
		int code= jobId;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select job_id,job_title,max_sal,min_sal from jobs j where j.job_id = "+code;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				jobs.setJobId(rs.getInt("job_id"));
				jobs.setJobTitle(rs.getString("job_title"));
				jobs.setMaxSalary(rs.getInt("max_sal"));
				jobs.setMinSalary(rs.getInt("min_sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	@Override
	public Job addJob(Job job) {
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("INSERT ");
			query.append("INTO ");
			query.append("JOBS ");
			query.append("VALUES ");
			query.append("( ");
			query.append(job.getJobId()+",");
			query.append("'"+job.getJobTitle()+"',");
			query.append(job.getMaxSalary()+",");
			query.append(job.getMaxSalary());
			query.append(" )");
			
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return job;
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
	public Job updateJob(Job job) {

		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("UPDATE ");
			query.append("JOBS ");
			query.append("SET job_title= ");
			query.append("'"+job.getJobTitle()+"', ");
			query.append("max_sal= ");
			query.append(job.getMaxSalary()+", ");
			query.append("min_sal= ");
			query.append(job.getMinSalary());
			query.append("WHERE job_id= ");
			query.append(job.getJobId());
			System.out.println(query);
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return job;
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
	public String deleteJob(int jobId) {

		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("DELETE ");
			query.append("FROM ");
			query.append("JOBS ");
			query.append("WHERE ");
			query.append("job_id= ");
			query.append(jobId);
			System.out.println(query);
	
			int rs= JdbcConnection.executeDelete(st, query.toString());
			if(rs>0) {
				return "deleted sucessfully";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "not available in job";	
		
	}

}
