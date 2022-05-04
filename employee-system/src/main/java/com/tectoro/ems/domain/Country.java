/**
 * 
 */
package com.tectoro.ems.domain;

import java.io.Serializable;
import java.sql.Ref;
import java.util.List;

/**
 * @author tectoro
 *
 */
public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private Region region;
	private List<Location> locations;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocations(List<Location> locations) {
		this.locations=locations;
		
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public List<Location> getLocations() {
		return locations;
	}
	
	

	
}
