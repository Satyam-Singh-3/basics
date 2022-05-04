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

import com.example.tectoro.pgmt.model.LeaveModel;
import com.example.tectoro.pgmt.responsebean.ResponseBean;
import com.example.tectoro.pgmt.service.LeaveService;

@RestController
@RequestMapping(value = "/leaveapi")
public class LeaveController {

	@Autowired
	private LeaveService service;

	@PostMapping(value = "/applyleave")
	public ResponseEntity<ResponseBean> createLeave(@RequestBody LeaveModel leaveModel) {
		ResponseBean response = null;
		try {
			leaveModel = service.createLeave(leaveModel);
			response = new ResponseBean(leaveModel, "Leave created succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		} catch (Exception e) {

			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@PutMapping(value = "/updateleave")
	public ResponseEntity<ResponseBean> updateLeave(@RequestBody LeaveModel leaveModel) {
		ResponseBean response = null;
		try {
			leaveModel = service.updateLeave(leaveModel);

			response = new ResponseBean(leaveModel, "Leave update succusfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@GetMapping(value = "/getleave")
	public ResponseEntity<ResponseBean> getLeave(@RequestParam("leaveId") Integer leaveId) {
		ResponseBean response = null;
		LeaveModel leaveModel = null;
		try {
			leaveModel = service.getLeave(leaveId);
			response = new ResponseBean(leaveModel, "leave getting sucessfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		}
	}

	@DeleteMapping(value = "/delete")
	public String deleteLeave(@RequestParam("leaveId") Integer leaveId) {
		int flag = 0;
		try {

			flag = service.deleteLeave(leaveId);
			if (flag == 1) {
				return "leave deleted successfully";
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return "error";
	}
}
