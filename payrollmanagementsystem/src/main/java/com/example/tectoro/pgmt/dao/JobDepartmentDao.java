package com.example.tectoro.pgmt.dao;

import com.example.tectoro.pgmt.domain.JobDepartmentDomain;

public interface JobDepartmentDao {

	JobDepartmentDomain createJobDepartment(JobDepartmentDomain jobdeptDomain) throws Exception;

	JobDepartmentDomain updateJobDepartment(JobDepartmentDomain jobdeptDomain) throws Exception;

	JobDepartmentDomain getJobDepartment(Integer jobId) throws Exception;

	int deleteJobDepartment(Integer empId) throws Exception;

}
