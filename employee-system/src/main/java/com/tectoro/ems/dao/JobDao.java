package com.tectoro.ems.dao;

import java.util.List;

import com.tectoro.ems.domain.Job;

public interface JobDao {

	List<Job> getJob() throws Exception;

	Job getJobById(int jobId) throws Exception;

	Job addJob(Job job);

	Job updateJob(Job job);

	String deleteJob(int jobId);

}
