package com.tectoro.ems.service;

import java.util.List;

import com.tectoro.ems.domain.Region;

public interface RegionService {

	public List<Region> getRegions() throws Exception;
	public List<Region> getGeoData() throws Exception;
	public Region getRegionById(int regionId) throws Exception;
	public Region addRegion(Region region) throws Exception;
	public Region updateRegion(Region region) throws Exception;
	public String deleteRegion(int regionId) throws Exception;
	
	
	
}
