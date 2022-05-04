package com.tectoro.ems.controller;

import java.util.List;

import com.tectoro.ems.domain.Depend;
import com.tectoro.ems.domain.Employee;
import com.tectoro.ems.domain.Job;

import com.tectoro.ems.service.JobService;
import com.tectoro.ems.service.impl.JobServiceImpl;

public class JobController {

	private static JobService  service = new JobServiceImpl();

	public List<Job> getJob(){

		List<Job> jobs = null;
		try {
			jobs = service.getJob();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobs;
	}
	
	public Job getJobById(int jobId) throws Exception {
		
		Job job= service.getJobById(jobId);
		return job;
	}	




	public List<Job> getGeoData(){

		List<Job> jobs = null;
		try {
			jobs = service.getGeoData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobs; 

	}
	
	public Job addJob(Job job) {
		
		Job jobOutput= new Job();
		try {
			jobOutput= service.addJob(job);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobOutput;
	}
	
	public Job updateJob(Job job) {
		
		Job jobOutput= new Job();
		try {
			jobOutput= service.updateJob(job);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobOutput;
		
	}
	
	public String deleteJob(int jobId) {
		String deleteJob= service.deleteJob(jobId);
		return "Delete operation is successful";
	}

	public static void main(String[] args) throws Exception {

		JobController jobController =  new JobController();
		List<Job> jobs =  jobController.getGeoData();
		for(Job job: jobs) {
			System.out.println("**************************************************");
			System.out.println("job id:"+job.getJobId());
			System.out.println("job title:"+job.getJobTitle());
			System.out.println("max salary:"+job.getMaxSalary());
			System.out.println("min salary:"+job.getMinSalary());
			System.out.println("------------------------------------------");

			List<Employee> employees = job.getEmployees();
			for(Employee employee : employees ) {

				System.out.println("empid : "+employee.getEmpId());
				System.out.println("firstname : "+employee.getFirstName());
				System.out.println("lastname : "+employee.getLastName());
				System.out.println("salary : "+employee.getSalary());
				System.out.println("email : "+employee.getEmail());
				System.out.println("phoneno : "+employee.getPhoneNum());
				System.out.println("mgrid : "+employee.getManagerId());
				System.out.println("deptid : "+employee.getDeptId());
				System.out.println("locationcode : "+employee.getLocationCode());
				System.out.println("hiredate : "+employee.getHireDate());
				System.out.println("------------------------------------------");

				List<Depend> depends= employee.getDepends();
				for(Depend depend: depends) {

					System.out.println("depend id:"+depend.getDependId());
					System.out.println("depend firstname:"+depend.getFirstName());
					System.out.println("depend lastname:"+depend.getLastName());
					System.out.println("depend relation:"+depend.getRelation());
					System.out.println("**************************************************");

				}
			}
		}

		List<Job> jobs1 =  jobController.getJob();
		for(Job job: jobs1) {
			System.out.println("**************************************************");
			System.out.println("job id:"+job.getJobId());
			System.out.println("job title:"+job.getJobTitle());
			System.out.println("max salary:"+job.getMaxSalary());
			System.out.println("min salary:"+job.getMinSalary());
			System.out.println("------------------------------------------");
		}
		
		Job job= new JobController().getJobById(101);
		System.out.println("Job Detatils by Job id:");
		System.out.println("**************************************************");
		System.out.println("job id:"+job.getJobId());
		System.out.println("job title:"+job.getJobTitle());
		System.out.println("max salary:"+job.getMaxSalary());
		System.out.println("min salary:"+job.getMinSalary());
		System.out.println("------------------------------------------");
		/*
		System.out.println("==========================");
		Job insertJob = new Job();
		insertJob.setJobId(105);;
		insertJob.setJobTitle("production manager");
		insertJob.setMaxSalary(25000);
		insertJob.setMinSalary(20000);
		Job outputJob = new JobController().addJob(insertJob);
		if(outputJob!= null) {
			System.out.println("Insert operation in Job:-");
			System.out.println("job id:"+outputJob.getJobId()
								+"\t"+"job title:"+outputJob.getJobTitle()
								+"\t"+"depend lastname:"+outputJob.getMaxSalary()
								+"\t"+"depend relation:"+outputJob.getMinSalary());
		}
		else
		{
			System.out.println("job already exists in the database");
		}	
		
		*/
		
		System.out.println("==========================");
		Job updateJob = new Job();
		updateJob.setJobId(105);;
		updateJob.setJobTitle("production");
		updateJob.setMaxSalary(24000);
		updateJob.setMinSalary(16000);
		Job outputJob1= new JobController().updateJob(updateJob);
		if(outputJob1!= null) {
			System.out.println("update operation in Job:-");
			System.out.println("job id:"+outputJob1.getJobId()
								+"\t"+"job title:"+outputJob1.getJobTitle()
								+"\t"+"depend lastname:"+outputJob1.getMaxSalary()
								+"\t"+"depend relation:"+outputJob1.getMinSalary());
		}
		else
		{
			System.out.println("job already exists in the database");
		}	

		System.out.println("=================================");
		System.out.println("Delete operation in job:");
		String delete=new JobController().deleteJob(105);
		System.out.println(delete);

	}
}
