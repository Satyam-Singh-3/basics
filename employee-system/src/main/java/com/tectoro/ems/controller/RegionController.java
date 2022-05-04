/**
 * 
 */
package com.tectoro.ems.controller;

import java.util.List;

import com.tectoro.ems.domain.Country;
import com.tectoro.ems.domain.Location;
import com.tectoro.ems.domain.Region;
import com.tectoro.ems.service.RegionService;
import com.tectoro.ems.service.impl.RegionServiceImpl;

/**
 * @author tectoro
 *
 */
public class RegionController {

	private static RegionService service = new RegionServiceImpl();

	public List<Region> getRegions() throws Exception{

		List<Region> regions = null;
		try {
			regions = service.getRegions();
		} catch (Exception e) {
			//throw new Exception("dao getRegion returning null value");
		
			throw  e;
		}
		return regions;
	}

	
	public Region getRegionById(int regionId)throws Exception {

		Region regions = null;
		try {
			regions = service.getRegionById(regionId);
		} catch (Exception e) {
			//throw new Exception("dao getRegion returning null value");
			throw e;
		}
		return regions;

	}

	public Region addRegion(Region region) throws Exception {

		Region regionOutput =  new Region();
		try {
			regionOutput= service.addRegion(region);
		} catch (Exception e) {
			throw e;
			
		}

		return regionOutput;
	}

	public Region updateRegion(Region region) throws Exception {

		Region regionOutput =  new Region();
		try {
			regionOutput= service.updateRegion(region); 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return regionOutput;
	}
	
	public String deleteRegion(int regionId) throws Exception {
		try {
		Region region = getRegionById(regionId);
		List<Region> regions1= new RegionController().getRegions();

			String regionOutput= service.deleteRegion(regionId); 
			if( regionOutput!=null) {		
				return "deleted sucessfullly";
			}
		
			return "table is already exists";
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	public List<Region> getGeoData() throws Exception{

		List<Region> regions = null;
		try {
			regions = service.getGeoData();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return regions; 

	}

	public static void main(String[] args) throws Exception {

		/*List<Region> regions = new RegionController().getGeoData();
		for (Region region : regions) {
			//
//			Region region1 = new RegionController().getRegionById(1);
//			System.out.println("-------------------");
//			System.out.println("Region Details by RegionId:");
//			System.out.println(region1.getId());
//			System.out.println(region1.getName());
//			System.out.println("-------------------");System.out.println("Region Id : " + region.getId());
			System.out.println("-------------------");
			System.out.println("Region Name : " + region.getName());

			List<Country> countries = region.getCountries();
			for (Country country : countries) {

				System.out.println("Country Code:\t"+country.getCode());
				System.out.println("Country Name:\t"+country.getName());
				System.out.println(" ");

				List<Location> locations = country.getLocations();
				for(Location location : locations) {

					System.out.println("Location Code:\t"+location.getLocationCode());
					System.out.println("Street Address:\t"+location.getStreetAddress());
					System.out.println("Postal Code:\t"+location.getPostalCode());
					System.out.println("City:\t"+location.getCity());
					System.out.println("State Province:\t"+location.getStateProvience());
					System.out.println(" ");
				}
			}

		}

		*/
//		try {
//		List<Region> regions1= new RegionController().getRegions();
//		System.out.println("-------------------");
//		for (Region region : regions1) {
//			System.out.println("Region Id : " + region.getId());
//			System.out.println("Region Name : " + region.getName());
//		}
//		}catch (Exception e) {
//			//System.err.println("get method returning null value so correct it");
//			System.err.println(e.getMessage());
//			e.printStackTrace();
//
//		}
//		
//		try {
//		Region region1 = new RegionController().getRegionById(1);
//		System.out.println("-------------------");
//		System.out.println("Region Details by RegionId:");
//		System.out.println(region1.getId());
//		System.out.println(region1.getName());
//		System.out.println("-------------------");
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//		Region insertRegion = new Region();
//		insertRegion.setId(5);
//		insertRegion.setName("NorthEast");
//		Region regionOutput = new RegionController().addRegion(insertRegion);
//		if(regionOutput!= null) {
//			System.out.println("Insert operation in Region:-");
//			System.out.println("Region Id:"+regionOutput.getId()+"\t"+"Region name:"+regionOutput.getName());	
//		}
//		else
//		{
//			System.out.println("Region already exists in the database");
//		}
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//		System.out.println("=================================");
//		System.out.println("Update operation in Region:");
//		Region region2= new Region();
//		region2.setId(5);
//		region2.setName("sudhanshu");
//		Region region=new RegionController().updateRegion(region2);
//		System.out.println("region id:"+region.getId());
//		System.out.println("region name:"+region.getName());
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//		System.out.println("=================================");
//		System.out.println("Delete operation in Region:");
//		String delete=new RegionController().deleteRegion(2);
//		System.out.println(delete);
//		}catch (Exception e) {
//		System.out.println(e.getMessage());
//	}
	
	}
	
}