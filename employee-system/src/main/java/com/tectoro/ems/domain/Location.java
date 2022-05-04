package com.tectoro.ems.domain;

import java.io.Serializable;
import java.util.List;

public class Location implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	private String locationCode;
	private String streetAddress;
	private int postalCode;
	private String city;
	private String stateProvience;
	private Country country;
	
	
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvience() {
		return stateProvience;
	}
	public void setStateProvience(String stateProvience) {
		this.stateProvience = stateProvience;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
		
}
