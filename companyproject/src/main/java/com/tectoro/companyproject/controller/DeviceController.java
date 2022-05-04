package com.tectoro.companyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tectoro.companyproject.domain.Device;
import com.tectoro.companyproject.service.DeviceService;

@RestController
@RequestMapping(value="/deviceapi")
public class DeviceController {
	
	@Autowired
	private DeviceService service;
	@PostMapping("/adddevice")
	public Device addDevice(@RequestBody Device device){
		
		Device device1 = null;
		try {
			device1=service.addDevice(device);
			//System.out.println("In Device controller");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return device;
	}

}
