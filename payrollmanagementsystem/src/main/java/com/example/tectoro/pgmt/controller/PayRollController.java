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

import com.example.tectoro.pgmt.model.PayRollModel;
import com.example.tectoro.pgmt.responsebean.ResponseBean;
import com.example.tectoro.pgmt.service.PayRollService;

@RestController
@RequestMapping(value= "/payrollapi")
public class PayRollController {

	@Autowired
	private PayRollService service;

	@PostMapping(value="/applypayroll")
	public ResponseEntity<ResponseBean> createSalary(@RequestBody PayRollModel payrollModel){
		ResponseBean response = null;
		try {
			payrollModel  = service.createPayroll(payrollModel);
			response = new ResponseBean(payrollModel, "Payroll created succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		} catch (Exception e) {

			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		}
	}

	@PutMapping(value="/updatepayroll")
	public ResponseEntity<ResponseBean> updatePayroll(@RequestBody PayRollModel payrollModel){
		ResponseBean response = null;
		try {
			payrollModel  = service.updatePayroll(payrollModel);
			response = new ResponseBean(payrollModel, "Payroll update succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		} catch (Exception e) {

			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value="/getpayroll")
	public ResponseEntity<ResponseBean> getPayroll(@RequestParam ("payrollId") Integer payrollId){
		ResponseBean response = null;
		PayRollModel payrollModel=null;
		try {
			payrollModel  = service.getPayroll(payrollId);
			response = new ResponseBean(payrollModel, "Payroll gettting succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		} catch (Exception e) {

			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		}
	}

	@DeleteMapping(value="/deletepayroll")
	public String deletePayroll(@RequestParam("payrollId") Integer payrollId){
	 int flag =0;
		try {
		 flag = service.deletePayroll(payrollId);
		 if(flag==1) {
			 return "Payroll details sucessfully deleted";
		 }else {
			 throw new Exception("no payroll details found to delete");
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}



}
