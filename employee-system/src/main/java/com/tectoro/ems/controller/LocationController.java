package com.tectoro.ems.controller;

import java.util.List;

import com.tectoro.ems.domain.Location;
import com.tectoro.ems.service.LocationService;
import com.tectoro.ems.service.impl.LocationServiceImpl;

public class LocationController {
	private static LocationService locationService = new LocationServiceImpl();
	
	public Location getLocationCode(String locationCode) throws Exception {
		
		Location location=locationService.getLocationCode(locationCode);
		
		return location;		
	}
	
	public List<Location>getLocationByCountryCode(String countryCode){
		
		List<Location> location=null;
		try {
			location=locationService.getLocationByCountryCode(countryCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return location;
	}
	
	public Location addLocation(Location location) {
		Location locationOutput= new Location();
		try {
			locationOutput= locationService.addLocation(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationOutput;
	}
	
	public Location updateLoacation(Location location){
		Location locationOutput= new Location();
		try {
			locationOutput= locationService.updateLoacation(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationOutput;
	}
	
	public Location deleteLocation(Location locationCode) {
		Location locationOutput= new Location();
		try {
			locationOutput= locationService.deleteLocation(locationCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationOutput;
		
	}

	
	
	public static void main(String[] args) throws Exception {
		
		LocationController locationcontroller = new LocationController();
		List<Location> locations=locationcontroller.getLocationByCountryCode("IN");
		for(Location location:locations) {
			System.out.println("location details by country code:");
			System.out.println("location code:"+location.getLocationCode());
			System.out.println("location streetaddress:"+location.getStreetAddress());
			System.out.println("location postalcode:"+location.getPostalCode());
			System.out.println("locatoion city"+location.getCity());
			System.out.println("location sate provience:"+location.getStateProvience());	
		}
		
		
//		Location location = new LocationController().getLocationCode("bng");
//		System.out.println("===========================");
//		System.out.println("location details by location code:");
//		System.out.println("location code:"+location.getLocationCode());
//		System.out.println("location streetaddress:"+location.getStreetAddress());
//		System.out.println("location postalcode:"+location.getPostalCode());
//		System.out.println("locatoion city"+location.getCity());
//		System.out.println("location sate provience:"+location.getStateProvience());
		/*
		System.out.println("============================");
		Location location1 = new Location();
		location1.setLocationCode("brt");
		location1.setPostalCode(45511);
		location1.setCity("brazileas");
		location1.setStreetAddress("balane");
		location1.setStateProvience("braz");
		Country count= new Country(); 
		location1.setCountry(count);;
		location1.getCountry().setCode("BR");
		Location locationOutput = new LocationController().addLocation(location1);
		if(locationOutput!= null) {
			System.out.println("Insert operation in country:-");
			System.out.println("Location code:"+locationOutput.getLocationCode()+"\t"
								+"postal code:"+locationOutput.getPostalCode()+"\t"
								+"city:"+locationOutput.getCity()+"\t"
								+"street adress:"+locationOutput.getStreetAddress()+"\t"
								+"StateProvience:"+locationOutput.getStateProvience()+"\t"
								+"country:"+locationOutput.getCountry().getCode());	
		}
		else
		{
			System.out.println("location already exists in the database");
		}
		

		System.out.println("============================");
		Location location2 = new Location();
		location2.setLocationCode("brt");
		location2.setPostalCode(47711);
		location2.setCity("brazile");
		location2.setStreetAddress("balan");
		location2.setStateProvience("brazl");
		Country count1= new Country(); 
		location2.setCountry(count1);;
		location2.getCountry().setCode("BR");
		Location locationOutput1 = new LocationController().updateLoacation(location2);
		if(locationOutput1!= null) {
			System.out.println("Update operation in country:-");
			System.out.println("Location code:"+locationOutput1.getLocationCode()+"\t"
								+"postal code:"+locationOutput1.getPostalCode()+"\t"
								+"city:"+locationOutput1.getCity()+"\t"
								+"street adress:"+locationOutput1.getStreetAddress()+"\t"
								+"StateProvience:"+locationOutput1.getStateProvience()+"\t"
								+"country:"+locationOutput1.getCountry().getCode());	
		}
		else
		{
			System.out.println("location already exists in the database");
		}
		*/
//
//		System.out.println("============================");
//		Location location3 = new Location();
//		location3.setLocationCode("brt");
//		Location locationOutput2 = new LocationController().deleteLocation(location3);
//		if(locationOutput2!= null) {
//			System.out.println("Delete operation sucess in country");
//		}
//		else
//		{
//			System.out.println("location already exists in the database");
//		}
		
	}
	
}
