package com.tectoro.companyproject.jdbc;
/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

/**
 * @author suresh
 *
 */
@Component
public class DatabaseConfig {

	private static Connection connection = null;
	private static Statement stmt = null;
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
	private static final String username = "postgres";
	private static final String password = "postgres";

	private DatabaseConfig() {
		createConnection();
	}

	public Connection getConnection() {
		return connection;
	}

	private void createConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DB_URL, username, password);
		} catch (Exception e) {
			System.out.println("DB Connection Error. 'createConnection()'." + e.getMessage());
			System.exit(0);
		}
	}

	public ResultSet execQuery(String query) {
		
		ResultSet result;
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println("Exception at 'execQuery()' :" + ex.getLocalizedMessage());
			return null;
		}
		return result;
	}
}
