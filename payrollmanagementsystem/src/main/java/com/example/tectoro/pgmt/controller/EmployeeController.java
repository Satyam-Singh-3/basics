package com.example.tectoro.pgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.tectoro.pgmt.model.Employee;
import com.example.tectoro.pgmt.responsebean.ResponseBean;
import com.example.tectoro.pgmt.service.EmployeeService;

@RestController
@RequestMapping(value = "/employeeapi")
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping(value = "/applyemployee")
	public ResponseEntity<ResponseBean> createEmployee(@RequestBody Employee employeeModel) {
		ResponseBean response = null;
		try {
			employeeModel = service.createEmployee(employeeModel);
			response = new ResponseBean(employeeModel, "employee added succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@PutMapping(value = "/updateEmployee")
	public ResponseEntity<ResponseBean> updateEmployee(@RequestBody Employee employeeModel) {
		ResponseBean response = null;
		try {
			employeeModel = service.updateEmployee(employeeModel);

			response = new ResponseBean(employeeModel, "employee update succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@GetMapping(value = "/getEmployee")
	public ResponseEntity<ResponseBean> getEmployee(@RequestParam("empId")  Integer empId) {
		ResponseBean response = null;
		Employee employeeModel = null;
		try {
			employeeModel = service.getEmployee(empId);
			response = new ResponseBean(employeeModel, "employee data read succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@DeleteMapping(value = "/deleteemployee")
	public String delete(@RequestParam("empId") Integer empId) throws Exception {

		int flag = 0;

		try {
			flag = service.deleteEmployee(empId);
			if (flag == 1) {
				return "employee deleted successfully";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return "errror";
	}

}
