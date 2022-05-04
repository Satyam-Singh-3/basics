package com.tectoro.ems.service.impl;

import java.util.List;

import com.tectoro.ems.dao.LocationDao;
import com.tectoro.ems.dao.impl.LocationDaoImpl;
import com.tectoro.ems.domain.Location;
import com.tectoro.ems.service.LocationService;

public class LocationServiceImpl implements LocationService {
	
	private static LocationDao locationDao = new LocationDaoImpl(); 

	@Override
	public List<Location> getLocationByCountryCode(String countryCode) throws Exception {
		
		return locationDao.getLocationByCountryCode(countryCode);
	}

	@Override
	public Location getLocationCode(String locationCode) throws Exception {
		
		try {
			return locationDao.getLocationCode(locationCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Location addLocation(Location location) {
		Location locationOutput = locationDao.addLocation(location);
		
		if(locationOutput!= null) {
			return location;
		}
		return null;
	}

	@Override
	public Location updateLoacation(Location location) {
		
		Location locationOutput = locationDao.updateLoacation(location);
		
		if(locationOutput!= null) {
			return location;
		}
		return null;
	}

	@Override
	public Location deleteLocation(Location locationCode) {
		
		Location locationOutput = locationDao.deleteLocation(locationCode);
		
		if(locationOutput!= null) {
			return locationCode;
		}
		return null;
	}

}
