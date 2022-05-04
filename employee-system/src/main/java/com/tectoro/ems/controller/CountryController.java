package com.tectoro.ems.controller;

import java.util.List;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import com.tectoro.ems.domain.Country;
import com.tectoro.ems.domain.Region;
import com.tectoro.ems.service.CountryService;
import com.tectoro.ems.service.impl.CountryServiceImpl;

public class CountryController {
	private static CountryService service = new CountryServiceImpl();

	public List<Country> getCountries() throws Exception{

		List<Country> countries = null;
		try {
			countries = service.getCountries();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return countries;
	}

	public List<Country> getCountriesbyRegionId(int regionId)throws Exception{

		List<Country> countries=null;
		try {
			countries= service.getCountriesbyRegionId(regionId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return countries;
	}




	public Country getCountriesbyCountryCode(String countryCode) throws Exception {
		Country countries = new Country();
		try {
			countries= service.getCountryBycountryCode(countryCode);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return countries;
	}

	public Country addCountry(Country country) throws Exception {

		Country countryOutput= new Country();
		try {
			countryOutput= service.addCountry(country);
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return countryOutput;
	}

	public Country updateCountry(Country country) {

		Country countryOutput= new Country();
		try {
			countryOutput= service.updateCountry(country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryOutput;

	}

	public String deleteCountry(String countryCode) throws Exception {
		try {
		String countryOutput= service.deleteCountry(countryCode); 
		if( countryOutput!=null) {		
			return "deleted sucessfullly";
			}
		}catch (Exception e) {
			throw e;
		}
		return "table is already exists";
		
	}

	public static void main(String[] args) throws Exception {

		//		try {
		//		List<Country> countries = new CountryController().getCountries();
		//		for (Country country : countries) {
		//			System.out.println("Country Code : " + country.getCode());
		//			System.out.println("Country Name : " + country.getName());
		//			//System.out.println("Region Region Id : " + country.getRegion());
		//		}
		//		}catch (Exception e) {
		//			System.err.println(e.getMessage());
		//			//e.printStackTrace();
		//		}

		//		try {
		//			System.out.println("============Exception=================");
		//		List<Country> countries1 = new CountryController().getCountriesbyRegionId(1);	
		//			for (Country country : countries1) {
		//			System.out.println("Country Code:\t"+country.getCode());
		//			System.out.println("Country Name:\t"+country.getName());
		//			System.out.println(" ");
		//			}
		//		}catch (Exception e) {
		//			System.err.println(e.getMessage());
		//		}
		//		
		//		try {
		//			Country country1 = new CountryController().getCountriesbyCountryCode("IN");
		//			System.out.println("=============================");
		//			System.out.println("Country Code:\t"+country1 .getCode());
		//			System.out.println("Country Name:\t"+country1.getName());
		//			System.out.println(" ");
		//		}catch (Exception e) {
		//			System.err.println(e.getMessage());
		//		}
		//		 try {
		//			System.out.println("=============================");
		//			System.out.println("Insert operation in country");
		//			Country countryInsert= new Country();
		//			countryInsert.setCode("MS");
		//			countryInsert.setName("Middle Australia");
		//			countryInsert.setRegion(new Region());
		//			countryInsert.getRegion().setId(3);
		//			Country con = new CountryController().addCountry(countryInsert);
		//			System.out.println("Country code:"+con.getCode());
		//			System.out.println("Country name:"+ con.getName());
		//			System.out.println("Country region:"+con.getRegion().getId());
		//		 }catch (Exception e) {
		//			 System.err.println(e.getMessage());
		//		}
		
//			try {
//			System.out.println("=============================");
//			System.out.println("Update operation in country");
//			Country countryUpdate= new Country();
//			countryUpdate.setCode("MS");
//			countryUpdate.setName("Middleaus");
//			countryUpdate.setRegion(new Region());
//			countryUpdate.getRegion().setId(3);
//			Country con1 = new CountryController().updateCountry(countryUpdate);
//			System.out.println("Country code:"+con1.getCode());
//			System.out.println("Country name:"+ con1.getName());
//			System.out.println("Country region:"+con1.getRegion().getId());
//			}catch (Exception e) {
//				 System.err.println(e.getMessage());
//			}
			try {
			System.out.println("=============================");
			System.out.println("Delete operation in country");
			String con1 = new CountryController().deleteCountry("MS");
			System.out.println(con1);
			}catch (Exception e) {
				 System.err.println(e.getMessage());
			}

	}


}
