package com.tectoro.ems.dao;

import java.util.List;

import com.tectoro.ems.domain.Country;
import com.tectoro.ems.domain.Location;

public interface LocationDao {

	List<Location> getLocations(String code) throws Exception;

	Location getLocationCode(String locationCode) throws Exception;

	List<Location> getLocationByCountryCode(String countryCode) throws Exception;

	Location addLocation(Location location);

	Location updateLoacation(Location location);

	Location deleteLocation(Location locationCode);

	
	

}
