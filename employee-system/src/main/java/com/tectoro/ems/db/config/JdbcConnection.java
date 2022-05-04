package com.tectoro.ems.db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {
	
	private static String connectionUrl = "jdbc:postgresql://localhost:5432/postgres?currentSchema=ems";
	private static String userName = "postgres";
	private static String password = "postgres";
	
	public static ResultSet executeSelect(Statement st, String query) throws Exception {
		
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (Exception e) {
			throw new Exception("Exception in Dao class");
		}
		return rs;
	}

	public static ResultSet executeInsert() {
		return null;
	}

	public static int executeUpdate(Statement st, String query) throws Exception {
		int flag=0;
		try {
			flag=st.executeUpdate(query);
		}catch(Exception e){
			//System.out.println("Table already exists in database");
			throw new Exception("Exception in Dao class");
		}
		return flag;	
		}

	public static int executeDelete(Statement st, String query) throws Exception {
		int flag=0;
		try {
			flag=st.executeUpdate(query);
		}catch(Exception e){
			//System.out.println("Table already exists in database");
			throw new Exception("Exception in Dao class");
		}
		return flag;
	}
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
	}

	public static int executeInsert(Statement st, String query) throws Exception {
		int flag=0;
		try {
			flag=st.executeUpdate(query);
		}catch(Exception e){
			throw new Exception("Exception in Dao class");
		}
		return flag;
	}
	
}
