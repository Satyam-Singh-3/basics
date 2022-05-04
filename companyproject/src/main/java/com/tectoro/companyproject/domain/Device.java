package com.tectoro.companyproject.domain;

public class Device {
	
	private String deviceId;
	private String deviceType;
	private String deviceName;
	private int devicePrice;
	private String vendor;
	private String status;
	private String details;
	
	

	public Device(String deviceId, String deviceType, String deviceName, int devicePrice, String vendor, String status,
			String details) {
		super();
		this.deviceId = deviceId;
		this.deviceType = deviceType;
		this.deviceName = deviceName;
		this.devicePrice = devicePrice;
		this.vendor = vendor;
		this.status = status;
		this.details = details;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public int getDevicePrice() {
		return devicePrice;
	}

	public String getVendor() {
		return vendor;
	}

	public String getStatus() {
		return status;
	}

	public String getDetails() {
		return details;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setDevicePrice(int devicePrice) {
		this.devicePrice = devicePrice;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDetails(String details) {
		this.details = details;
	}


	
	

}
