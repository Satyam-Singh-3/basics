package com.tectoro.ems.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tectoro.ems.dao.LocationDao;
import com.tectoro.ems.db.config.JdbcConnection;
import com.tectoro.ems.domain.Location;

public class LocationDaoImpl implements LocationDao {

	@Override
	public List<Location> getLocations(String code) throws Exception  {
		
		List<Location> locationList = new ArrayList<>();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "select location_code,city,postal_code,state_province,street_address from location where country_code = '"+code+"'";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Location location = new Location();
				location.setLocationCode(rs.getString("location_code"));
				location.setCity(rs.getString("city"));
                location.setPostalCode(rs.getInt("postal_code"));
                location.setStateProvience(rs.getString("state_province"));
                location.setStreetAddress(rs.getString("street_address"));
                locationList.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return locationList;


	}

	@Override
	public Location getLocationCode(String locationCode) throws Exception {
		Location location = new Location();
		String code= locationCode;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "select location_code,city,postal_code,state_province,street_address from location where locationcode = '"+code+"'";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				location.setLocationCode(rs.getString("location_code"));
				location.setCity(rs.getString("city"));
                location.setPostalCode(rs.getInt("postal_code"));
                location.setStateProvience(rs.getString("state_province"));
                location.setStreetAddress(rs.getString("street_address"));
               
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return location;
	}

	@Override
	public List<Location> getLocationByCountryCode(String countryCode) throws Exception {
		List<Location> locationList = new ArrayList<>();
		//String code=countryCode;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "select location_code,city,postal_code,state_province,street_address from location where country_code = '"+countryCode+"'";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Location location = new Location();
				location.setLocationCode(rs.getString("location_code"));
				location.setCity(rs.getString("city"));
                location.setPostalCode(rs.getInt("postal_code"));
                location.setStateProvience(rs.getString("state_province"));
                location.setStreetAddress(rs.getString("street_address"));
                locationList.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return locationList;
	}

	@Override
	public Location addLocation(Location location) {
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
		
			StringBuilder query= new StringBuilder();
			query.append("INSERT ");
			query.append("INTO ");
			query.append("LOCATION ");
			query.append("VALUES ");
			query.append("( ");
			query.append("'"+location.getLocationCode()+"',");
			query.append("'"+location.getStreetAddress()+"',");
			query.append(location.getPostalCode()+",");
			query.append("'"+location.getCity()+"',");
			query.append("'"+location.getStateProvience()+"',");
			query.append("'"+location.getCountry().getCode()+"'");
			query.append(" )");
			System.out.println(query);
			
			//String query= "Insert into country values location_code,city,postal_code,state_province,street_address,country_code"+location;
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return location;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Location updateLoacation(Location location) {
		
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
		
			StringBuilder query= new StringBuilder();
			query.append("UPDATE ");
			query.append("LOCATION ");
			query.append("SET city= ");
			query.append("'"+location.getCity()+"',");
			query.append("postal_code= ");
			query.append(location.getPostalCode()+",");
			query.append("state_province= ");
			query.append("'"+location.getStateProvience()+"',");
			query.append("street_address= ");
			query.append("'"+location.getStreetAddress()+"',");
			query.append("country_code= ");
			query.append("'"+location.getCountry().getCode()+"'");
			query.append("WHERE location_code= ");
			query.append("'"+location.getLocationCode()+"'");
			System.out.println(query);
			
			int rs= JdbcConnection.executeUpdate(st, query.toString());
			if(rs>0) {
				return location;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Location deleteLocation(Location locationCode) {
		
		try {
			Connection conn= JdbcConnection.getConnection();
				Statement st = conn.createStatement();
				StringBuilder query = new StringBuilder();
				query.append("DELETE ");
				query.append("FROM ");
				query.append("LOCATION ");
				query.append("WHERE ");
				query.append("location_code= ");
				query.append("'"+locationCode.getLocationCode()+"'");
				System.out.println(query);
				int rs= JdbcConnection.executeDelete(st, query.toString());
				if(rs>0) {
					return locationCode;
					}
				} catch (Exception e) {
					e.printStackTrace();
			}
			
			return null;

	}

}
