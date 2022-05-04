/**
 * 
 */
package com.tectoro.ems.service.impl;

import java.util.List;

import com.tectoro.ems.dao.CountryDao;
import com.tectoro.ems.dao.LocationDao;
import com.tectoro.ems.dao.RegionDao;
import com.tectoro.ems.dao.impl.CountryDaoImpl;
import com.tectoro.ems.dao.impl.LocationDaoImpl;
import com.tectoro.ems.dao.impl.RegionDaoImpl;
import com.tectoro.ems.domain.Country;
import com.tectoro.ems.domain.Location;
import com.tectoro.ems.domain.Region;
import com.tectoro.ems.service.RegionService;

/**
 * @author tectoro
 *
 */
public class RegionServiceImpl implements RegionService {

	private static RegionDao regionDao = new RegionDaoImpl();
	private static CountryDao countriesDao = new CountryDaoImpl();
	private static LocationDao locationDao = new LocationDaoImpl();

	@Override
	public List<Region> getRegions() throws Exception {
		try {
			List<Region> region = regionDao.getRegions();
			if(region != null && !region.isEmpty()) {
				return region;
			}

		}catch (Exception e) {
			throw e;
		}
		return null;

	}

	@Override
	public Region getRegionById(int regionId) throws Exception{
		try {
			Region region= regionDao.getRegionById(regionId);
			if(region != null) {
				return region;
			}
			else {
				throw new Exception("Dao getRegion returning null value");
			}
		}catch (Exception e) {
			throw e;
		}
	}
	@Override
	public Region addRegion(Region region) throws Exception {
		try {
			Region regionOutput = regionDao.addRegion(region);

			if(regionOutput!= null) {
				return region;
			}
			return null;
		}catch (Exception e) {
			throw e;
		}
		//return null;
	}
	@Override
	public Region updateRegion(Region region) throws Exception {
		try {
			Region regionOutput= regionDao.updateRegion(region);
			if(regionOutput!= null  ) {
				return region;
			}
		}catch(Exception e){
			throw e;
		}
		return null;
	}

	@Override
	public String deleteRegion(int regionId) throws Exception {
		try {
			String msg= regionDao.deleteRegion(regionId);
			if(msg!=null && !msg.isEmpty()) {
				return msg;
			}
		}catch (Exception e) {
			throw e;
		}
		return null;
	}


	@Override
	public List<Region> getGeoData() throws Exception {

		List<Region> regions= regionDao.getRegions();
		for(Region region:regions) {
			List<Country> countries= countriesDao.getCountries(region.getId());
			region.setCountries(countries);
			for(Country country: countries) {
				List<Location> locations = locationDao.getLocations(country.getCode());
				country.setLocations(locations);
			}
		}

		return regions;
	}


}
