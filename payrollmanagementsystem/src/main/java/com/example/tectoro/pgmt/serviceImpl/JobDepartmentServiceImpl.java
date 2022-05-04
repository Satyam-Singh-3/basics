package com.example.tectoro.pgmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tectoro.pgmt.dao.JobDepartmentDao;
import com.example.tectoro.pgmt.domain.JobDepartmentDomain;
import com.example.tectoro.pgmt.model.JobDepartmentModel;
import com.example.tectoro.pgmt.service.JobDepartmentService;

@Component
public class JobDepartmentServiceImpl implements JobDepartmentService {

	@Autowired
	private JobDepartmentDao jobDao;

	@Override
	public JobDepartmentModel createJobDepartment(JobDepartmentModel jobdeptModel) throws Exception {

		try {
			if (jobdeptModel != null) {
				JobDepartmentDomain jobdeptDomain = new JobDepartmentDomain();
				populateDomainFromBean(jobdeptModel, jobdeptDomain);

				jobdeptDomain = jobDao.createJobDepartment(jobdeptDomain);
				if (jobdeptDomain != null) {
					populateBeanFromDomain(jobdeptModel, jobdeptDomain);
					return jobdeptModel;
				} else {
					return null;
				}
			} else {
				throw new Exception("JobDepartment object can't be null or empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public JobDepartmentModel updateJobDepartment(JobDepartmentModel jobdeptModel) throws Exception {

		try {
			JobDepartmentDomain jobdeptDomain = new JobDepartmentDomain();
			if (jobdeptModel != null) {
				jobdeptDomain.setJobId(Integer.parseInt(jobdeptModel.getJobId()));
				if (jobdeptModel.getJobDept() != null) {
					jobdeptDomain.setJobDept(jobdeptModel.getJobDept());
				}
				if (jobdeptModel.getName() != null) {
					jobdeptDomain.setName(jobdeptModel.getName());
				}
				if (jobdeptModel.getDescription() != null) {
					jobdeptDomain.setDescription(jobdeptModel.getDescription());
				}
				if (jobdeptModel.getSalaryRange() != null) {
					jobdeptDomain.setSalaryRange(Integer.parseInt(jobdeptModel.getSalaryRange()));
				}

				jobdeptDomain = jobDao.updateJobDepartment(jobdeptDomain);
				if (jobdeptDomain != null) {
					populateBeanFromDomain(jobdeptModel, jobdeptDomain);
					return jobdeptModel;
				} else {
					return null;
				}
			} else {
				throw new Exception("object is empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public JobDepartmentModel getJobDepartment(Integer jobId) throws Exception {

		try {
			JobDepartmentDomain jobdeptDomain = new JobDepartmentDomain();
			if (jobId != null) {
				jobdeptDomain.setJobId(jobId);

				jobdeptDomain = jobDao.getJobDepartment(jobId);
				if (jobdeptDomain != null) {
					JobDepartmentModel jobdeptModel = new JobDepartmentModel();
					populateBeanFromDomain(jobdeptModel, jobdeptDomain);
					return jobdeptModel;
				} else {
					return null;
				}
			} else {
				throw new Exception("object is empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteJobDepartment(Integer empId) throws Exception {
		int flag = 0;
		try {
			if (empId != 0) {
				flag = jobDao.deleteJobDepartment(empId);

				return flag;
			} else {
				throw new Exception("not empid is available ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	private void populateDomainFromBean(JobDepartmentModel jobdeptModel, JobDepartmentDomain jobdeptDomain) {
		jobdeptDomain.setJobDept(jobdeptModel.getJobDept());
		jobdeptDomain.setName(jobdeptModel.getName());
		jobdeptDomain.setDescription(jobdeptModel.getDescription());
		jobdeptDomain.setSalaryRange(Integer.parseInt(jobdeptModel.getSalaryRange()));
	}

	private void populateBeanFromDomain(JobDepartmentModel jobdeptModel, JobDepartmentDomain jobdeptDomain) {
		jobdeptModel.setJobId(String.valueOf(jobdeptDomain.getJobId()));
		jobdeptModel.setJobDept(jobdeptDomain.getJobDept());
		jobdeptModel.setName(jobdeptDomain.getName());
		jobdeptModel.setDescription(jobdeptDomain.getDescription());
		jobdeptModel.setSalaryRange(String.valueOf(jobdeptDomain.getSalaryRange()));
	}
}
