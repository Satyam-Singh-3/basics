package com.tectoro.ems.service.impl;

import java.util.List;

import com.tectoro.ems.dao.CountryDao;
import com.tectoro.ems.dao.impl.CountryDaoImpl;
import com.tectoro.ems.domain.Country;
import com.tectoro.ems.service.CountryService;

public class CountryServiceImpl implements CountryService {
	
	private static CountryDao countryDao = new CountryDaoImpl();
	
	

	@Override
	public List<Country> getCountries() throws Exception {
		try {
			List<Country> country = countryDao.getCountries();
			if(country!= null & !country.isEmpty()) {
				return country;
			}
		}catch (Exception e) {
			throw e;
		}
		return null;
	}


	@Override
	public List<Country> getCountriesbyRegionId(int regionId) throws Exception {
		
		try {
			List<Country> country = countryDao.getCountriesbyRegionId(regionId);
			if(country!= null & !country.isEmpty()) {
				return country;
			}
		}catch (Exception e) {
			throw e;
		}
		return null;
	}



	@Override
	public Country getCountryBycountryCode() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Country addCountry(Country country) throws Exception {
		Country countryOutput;
		try {
			countryOutput = countryDao.addCountry(country);
			if(countryOutput!=null) {
				return country;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return null;
	}



	@Override
	public Country updateCountry(Country country) throws Exception {
		Country countryOutput;
		try {
			countryOutput = countryDao.updateCountry(country);
			if(countryOutput!=null) {
				return country;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}		
		return null;
	}



	@Override
	public String deleteCountry(String countryCode) throws Exception {
		String msg;
		try {
			msg = countryDao.deleteCountry(countryCode);
			return msg;
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		
	}


	@Override
	public Country getCountryBycountryCode(String countryCode) throws Exception {
		
		try {
			return countryDao.getCountryBycountryCode(countryCode) ;
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
	}

}
