package com.tectoro.ems.dao;

import java.util.List;

import com.tectoro.ems.domain.Region;

public interface RegionDao {

	List<Region> getRegions() throws Exception;

	Region getRegionById(int regionId) throws Exception;

	Region addRegion(Region region) throws Exception;

	Region updateRegion(Region region) throws Exception;

	String deleteRegion(int regionId) throws Exception;

}
