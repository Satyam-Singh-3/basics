package com.tectoro.ems.service;

import java.util.List;

import com.tectoro.ems.domain.Job;

public interface JobService {

	public List<Job> getJob() throws Exception;
	public Job getJobById(int jobId) throws Exception;
	public Job addJob(Job job);
	public Job updateJob(Job job);
	public String deleteJob(int jobId);
	
	

	public List<Job> getGeoData() throws Exception;

}
