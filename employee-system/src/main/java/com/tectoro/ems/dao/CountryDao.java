package com.tectoro.ems.dao;

import java.util.List;

import com.tectoro.ems.domain.Country;

public interface CountryDao {


	List<Country> getCountries(int i) throws Exception;

	List<Country> getCountries() throws Exception;

	List<Country> getCountriesbyRegionId(int regionId) throws Exception;

	Country getCountryBycountryCode(String countryCode) throws Exception;

	Country addCountry(Country country) throws Exception;

	Country updateCountry(Country country) throws Exception;

	String deleteCountry(String countryCode) throws Exception;

	

}
