package com.tectoro.ems.service;

import java.util.List;

import com.tectoro.ems.domain.Location;

public interface LocationService {
	public List<Location>getLocationByCountryCode(String countryCode) throws Exception;
	public Location getLocationCode(String locationCode) throws Exception;
	public Location addLocation(Location location);
	public Location updateLoacation(Location location);
	public Location deleteLocation(Location locationCode);

	
}
