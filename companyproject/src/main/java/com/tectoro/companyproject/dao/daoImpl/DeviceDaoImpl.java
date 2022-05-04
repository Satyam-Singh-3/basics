package com.tectoro.companyproject.dao.daoImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tectoro.companyproject.dao.DeviceDao;
import com.tectoro.companyproject.domain.Device;


@Repository
public class DeviceDaoImpl implements DeviceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Device addDevice(Device device) {
		
		StringBuilder query = new StringBuilder();
		query.append("insert into"); 
		query.append(" devices values (");
		query.append("'" + device.getDeviceId() + "'"); 
		query.append(",");

		query.append("'" + device.getDeviceType() + "'");
		query.append(",");

		query.append("'" + device.getDeviceName() + "'");
		query.append(",");

		query.append(+device.getDevicePrice()); 
		query.append(",");

		query.append("'" + device.getVendor() + "'");
		query.append(",");

		query.append("'" + device.getStatus() + "'");
		query.append(",");

		query.append("'" + device.getStatus() + "'");
		query.append(")");
		jdbcTemplate.execute(query.toString());
		return null;
	
	}

}
