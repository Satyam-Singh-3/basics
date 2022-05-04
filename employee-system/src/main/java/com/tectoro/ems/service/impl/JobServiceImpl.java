package com.tectoro.ems.service.impl;

import java.util.List;

import com.tectoro.ems.dao.DependDao;
import com.tectoro.ems.dao.EmployeeDao;
import com.tectoro.ems.dao.JobDao;
import com.tectoro.ems.dao.impl.DependDaoImpl;
import com.tectoro.ems.dao.impl.EmployeeDaoImpl;
import com.tectoro.ems.dao.impl.JobDaoImpl;
import com.tectoro.ems.domain.Depend;
import com.tectoro.ems.domain.Employee;
import com.tectoro.ems.domain.Job;
import com.tectoro.ems.service.JobService;

public class JobServiceImpl implements JobService {
	private static JobDao jobDao= new JobDaoImpl();
	private static EmployeeDao employeeDao= new EmployeeDaoImpl();
	private static DependDao dependDao= new DependDaoImpl();
	

	@Override
	public List<Job> getJob() throws Exception {
		
		return jobDao.getJob();
	}


	@Override
	public Job getJobById(int jobId) throws Exception {
		
		return jobDao.getJobById(jobId);
	}

	@Override
	public Job addJob(Job job) {
		
		Job jobOutput = jobDao.addJob(job);
		
		if(jobOutput!= null) {
			return job;
		}
		return null;
	}

	@Override
	public Job updateJob(Job job) {

		Job jobOutput = jobDao.updateJob(job);
		
		if(jobOutput!= null) {
			return job;
		}
		return null;
	}

	@Override
	public String deleteJob(int jobId) {
		String msg=jobDao.deleteJob(jobId);
		return msg;
	}
	
	@Override
	public List<Job> getGeoData() throws Exception {
		
		List<Job> jobs= jobDao.getJob();
		for(Job job:jobs) {
		List<Employee> employees= employeeDao.getEmployee(job.getJobId());
		job.setEmployees(employees);
		for(Employee employee: employees) {
			List<Depend> depends = dependDao.getDepend(employee.getEmpId());
			employee.setDepends(depends);
		}
	}
	
	return jobs;
	}

}
