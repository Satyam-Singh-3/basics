package com.example.tectoro.pgmt.service;

import com.example.tectoro.pgmt.model.JobDepartmentModel;

public interface JobDepartmentService {

	JobDepartmentModel createJobDepartment(JobDepartmentModel jobdeptModel) throws Exception;

	JobDepartmentModel updateJobDepartment(JobDepartmentModel jobdeptModel) throws Exception;

	JobDepartmentModel getJobDepartment(Integer jobId) throws Exception;

	int deleteJobDepartment(Integer jobid) throws Exception;

	

}
