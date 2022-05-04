package com.tectoro.ems.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tectoro.ems.dao.RegionDao;
import com.tectoro.ems.db.config.JdbcConnection;
import com.tectoro.ems.domain.Region;

public class RegionDaoImpl implements RegionDao {

	@Override
	public List<Region> getRegions() throws Exception {
		
		List<Region> regionList = new ArrayList<>();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select region_id,region_name from region";
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				Region region = new Region();
				region.setId(rs.getInt("REGION_ID"));
				region.setName(rs.getString("REGION_NAME"));
				regionList.add(region);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			throw e;
			
			
		}
		//return null;
		return regionList;
	}

	@Override
	public Region getRegionById(int regionId) throws Exception {
		Region region = new Region();
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			String query= "select r.region_id,r.region_name  from region r where r.region_id ="+regionId;
			ResultSet rs = JdbcConnection.executeSelect(st, query);
			while (rs.next()) {
				region.setId(rs.getInt("REGION_ID"));
				region.setName(rs.getString("REGION_NAME"));
				}
		}
			catch (Exception e) {
			e.printStackTrace();
			//throw new Exception("Exception in Dao class");
			throw e;
		}
		return region;
		}
	

	@Override
	public Region addRegion(Region region) throws Exception {
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("INSERT ");
			query.append("INTO ");
			query.append("REGION ");
			query.append("VALUES ");
			query.append("( ");
			query.append(region.getId()+",");
			query.append("'"+region.getName()+"'");
			query.append(" )");
			
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return region;
			}
			else {
				return null;
			}
				
		} catch (Exception e) {
			throw e;
			
		}
		//return null;
	}

	@Override
	public Region updateRegion(Region region) throws Exception {
		
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("UPDATE ");
			query.append("REGION ");
			query.append("SET region_name= ");
			query.append("'"+region.getName()+"' ");
			
			query.append("WHERE region_id= ");
			query.append(region.getId());
			//Region region5=new Region();
			System.out.println();
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return region;
			}
			else {
				return null;
			}
				
		} catch (Exception e) {
			throw e;
		}
		//return null;
	}

	@Override
	public String deleteRegion(int regionId) throws Exception {
		
		try {
			Connection conn = JdbcConnection.getConnection();
			Statement st = conn.createStatement();
			StringBuilder query= new StringBuilder();
			query.append("DELETE ");
			query.append("FROM ");
			query.append("REGION ");
			query.append("WHERE ");
			query.append("region_id= ");
			query.append(regionId);
			System.out.println(query);
			//String query = "DELETE FROM region WHERE region_id= "+regionId;
			int rs= JdbcConnection.executeInsert(st, query.toString());
			if(rs>0) {
				return "deleted sucessfully";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return "not available in region";
	}
}

