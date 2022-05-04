package com.tectoro.companyproject.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tectoro.companyproject.dao.DeviceDao;
import com.tectoro.companyproject.domain.Device;
import com.tectoro.companyproject.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceDao devicedao;

	@Override
	public Device addDevice(Device device) {
		
		return devicedao.addDevice(device) ;
	}

}
