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

import com.example.tectoro.pgmt.model.SalaryModel;
import com.example.tectoro.pgmt.responsebean.ResponseBean;
import com.example.tectoro.pgmt.service.SalaryService;

@RestController
@RequestMapping(value = "/salaryapi")
public class SalaryController {

	@Autowired
	private SalaryService service;

	@PostMapping(value = "/applysalary")
	public ResponseEntity<ResponseBean> createSalary(@RequestBody SalaryModel salaryModel) {
		ResponseBean response = null;
		try {
			salaryModel = service.createSalary(salaryModel);
			response = new ResponseBean(salaryModel, "Leave created succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@PutMapping(value = "/updatesalary")
	public ResponseEntity<ResponseBean> updateSalary(@RequestBody SalaryModel salaryModel) {
		ResponseBean responseBean = null;
		try {
			salaryModel = service.updateSalary(salaryModel);
			responseBean = new ResponseBean(salaryModel, "salary updated successfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
		} catch (Exception e) {
			responseBean = new ResponseBean(salaryModel, "error", e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/getsalary")
	public ResponseEntity<ResponseBean> getSalary(@RequestParam("salaryId") Integer salaryId) {
		ResponseBean bean = null;
		SalaryModel model = null;
		try {
			model = service.getSalary(salaryId);
			bean = new ResponseBean(model, "salary details retrieved", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);
		} catch (Exception e) {
			bean = new ResponseBean(model, "error", e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/delete")
	public String deleteSalary(@RequestParam("salaryId") Integer salaryId) {
		int flag = 0;
		try {
			flag = service.deleteSalary(salaryId);
			if (flag == 1) {
				return "salary details successfully";
			} else {
				throw new Exception("no salarydetails found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "error foreignkey relationship is there";
	}

}
