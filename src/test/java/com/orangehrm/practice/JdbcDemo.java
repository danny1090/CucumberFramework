package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";

	//@Test
	public void dbConnection() throws SQLException {
		// CREATING CONNECTION TO SQL FROM SELENIUM
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		// create a statement
		Statement statement = connection.createStatement();
		//execute Query and store results from database in ResultSet object
		ResultSet resultSet=statement.executeQuery("select * from Countries");
		//get values from ResultSet
		resultSet.next();
		String columnData=resultSet.getString("country_Name");
		System.out.println(columnData);
		
		resultSet.next();
		columnData=resultSet.getString("country_Name");
		String columnId=resultSet.getString("Country_id");
		System.out.println(columnData);
		
		System.out.println("------Printing values using while loop------");
		while(resultSet.next()) {
			columnData=resultSet.getString("Country_Name");
			columnId=resultSet.getString("Country_id");
			System.out.println(columnId+" "+columnData);
		}

		//close all db connections 
		resultSet.close();
		statement.close();
		connection.close();

	}
	
	@Test
	public void printRowData() throws SQLException {
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery("Select department_id, department_name from departments");
		
		while(rs.next()) {
			int dep_id=rs.getInt("department_id");
			String dep_name=rs.getString("department_name");
			System.out.println(dep_id+" "+dep_name);
		}
		rs.close();
		statement.close();
		conn.close();
	}
	
	
	
	

}
