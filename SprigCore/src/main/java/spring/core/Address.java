package spring.core;

public class Address {

	private String street;
	private String city;
	private String district;
	public Address() {
		super();
	}
	public Address(String street, String city, String district) {
		super();
		this.street = street;
		this.city = city;
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", district=" + district + "]";
	}
	
	
}
