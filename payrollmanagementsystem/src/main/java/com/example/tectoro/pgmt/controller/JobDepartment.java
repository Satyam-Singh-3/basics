package com.example.tectoro.pgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tectoro.pgmt.model.JobDepartmentModel;
import com.example.tectoro.pgmt.responsebean.ResponseBean;
import com.example.tectoro.pgmt.service.JobDepartmentService;

@RestController
@RequestMapping(value = "/jobapi")
public class JobDepartment {

	@Autowired
	private JobDepartmentService service;

	@PostMapping(value = "/applyJobDept")
	public ResponseEntity<ResponseBean> createJobDepartment(@RequestBody JobDepartmentModel jobdeptModel) {
		ResponseBean response = null;
		try {
			jobdeptModel = service.createJobDepartment(jobdeptModel);
			response = new ResponseBean(jobdeptModel, "JobDepartment added succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			e.getMessage();
		}
		return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/updateJobDept")
	public ResponseEntity<ResponseBean> updateJobDepartment(@RequestBody JobDepartmentModel jobdeptModel) {
		ResponseBean response = null;
		try {
			jobdeptModel = service.updateJobDepartment(jobdeptModel);
			response = new ResponseBean(jobdeptModel, "JobDepartment updated succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@GetMapping(value = "/getJobDept")
	public ResponseEntity<ResponseBean> getJobDepartment(@RequestParam("jobId") Integer jobId) {
		JobDepartmentModel jobdeptModel = null;
		ResponseBean response = null;
		try {
			jobdeptModel = service.getJobDepartment(jobId);
			response = new ResponseBean(jobdeptModel, "JobDepartment reading succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@DeleteMapping(value = "/deleteJobDept")
	public String delete(@RequestParam("param") Integer jobid) {

		int flag = 0;
		try {
			flag = service.deleteJobDepartment(jobid);
			if (flag == 1) {
				return "jobdepartment deleted successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

}
