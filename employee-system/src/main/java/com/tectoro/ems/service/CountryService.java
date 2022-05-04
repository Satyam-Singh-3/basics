package com.tectoro.ems.service;

import java.util.List;

import com.tectoro.ems.domain.Country;

public interface CountryService {

	public List<Country> getCountries() throws Exception;
	public List<Country> getCountriesbyRegionId(int regionId) throws Exception;
	public Country getCountryBycountryCode();
	public Country addCountry(Country country) throws Exception;
	public Country updateCountry(Country country) throws Exception;
	public String deleteCountry(String countryCode) throws Exception;
	public Country getCountryBycountryCode(String countryCode) throws Exception;
}
