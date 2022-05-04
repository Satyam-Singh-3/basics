package com.tectoro.ems.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tectoro.ems.dao.CountryDao;
import com.tectoro.ems.db.config.JdbcConnection;
import com.tectoro.ems.domain.Country;


public class CountryDaoImpl implements CountryDao {

	public List<Country> getCountries(int id) throws Exception {
		
		List<Country> countryList = new ArrayList<>();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "SELECT c.country_code, c.country_name from country c where c.region_id = '"+id+"'";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Country country = new Country();
				country.setCode(rs.getString("country_code"));
				country.setName(rs.getString("country_name"));
				countryList.add(country);
			}
		} catch (Exception e) {
			throw e;
		}
		return countryList;
	}


	@Override
	public List<Country> getCountries() throws Exception {
		List<Country> count = new ArrayList();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "SELECT c.country_code, c.country_name from country c ";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Country country = new Country();
				country.setCode(rs.getString("country_code"));
				country.setName(rs.getString("country_name"));
				count.add(country);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			throw e;
		}
		return count;
	}


	@Override
	public List<Country> getCountriesbyRegionId(int regionId) throws Exception {
		List<Country> countryList = new ArrayList();
		int code =regionId;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "SELECT c.country_code, c.country_name from country c where c.region_id = "+code;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Country country = new Country();
				country.setCode(rs.getString("country_code"));
				country.setName(rs.getString("country_name"));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return countryList;
	}


	@Override
	public Country getCountryBycountryCode(String countryCode) throws Exception {
		Country countryList = new Country();
		String code=countryCode;
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query = "SELECT c.country_code, c.country_name from country c where c.country_code= '"+code+"'";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				countryList.setCode(rs.getString("country_code"));
				countryList.setName(rs.getString("country_name"));
				
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return countryList;
	}


	@Override
	public Country addCountry(Country country) throws Exception {
		try {
			Connection conn= JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("INSERT ");
			query.append("INTO ");
			query.append("COUNTRY ");
			query.append("VALUES ");
			query.append("( ");
			query.append("'"+country.getCode()+"',");
			query.append("'"+country.getName()+"',");
			query.append("'"+country.getRegion().getId()+"'");
			query.append(" )");
			
		int rs= JdbcConnection.executeInsert(st, query.toString());
		if(rs>0) {
			return country;
		}
		
		} 
		catch (Exception e) {
		//e.printStackTrace();
		throw e;
	}
	return null;
	}


	@Override
	public Country updateCountry(Country country) throws Exception {
		try {
			Connection conn= JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("UPDATE ");
			query.append("COUNTRY ");
			query.append("SET country_name= ");
			query.append("'"+country.getName()+"',");
			query.append("region_id= ");
			query.append(country.getRegion().getId());
			query.append("WHERE country_code= ");
			query.append("'"+country.getCode()+"'");
			System.out.println(query);
		int rs= JdbcConnection.executeUpdate(st, query.toString());
		if(rs>0) {
			return country;
		}
	}catch (Exception e) {
		//e.printStackTrace();
		throw e;
	}
	return null;
	
	}


	@Override
	public String deleteCountry(String countryCode) throws Exception {
		try {
		Connection conn= JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("DELETE ");
			query.append("FROM ");
			query.append("COUNTRY ");
			query.append("WHERE ");
			query.append("country_code= ");
			query.append("'"+countryCode+"'");
			System.out.println(query);
			int rs= JdbcConnection.executeDelete(st, query.toString());
			if(rs>0) {
				return countryCode;
				}
			} catch (Exception e) {
				//e.printStackTrace();
				throw e;
		}
		
		return null;
	}
	
	
	
	
	
}
