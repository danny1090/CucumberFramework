package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProcessResultSet {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";
	
	@Test
	public void getResultSetData() throws SQLException {
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select first_name, last_name from employees where job_id='IT_PROG'");
		
		List<Map<String, String>> rsList=new ArrayList();
		
		while(rs.next()) {
			Map<String, String> rsMap=new HashMap();
			rsMap.put("First_name", rs.getString("first_name"));
			rsMap.put("Last_name", rs.getString("last_name"));
			rsList.add(rsMap);
			
		}
		System.out.println(rsList);
		
		rs.close();
		st.close();
		conn.close();
	}
	//process query that will give result of street address, city and country name and store results inside list
	
	
	@Test
	public void location() throws SQLException {
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select street_address, city, country_name from locations l join countries c on l.country_id=c.country_id");
		
		List<Map<String, String>> rsList=new ArrayList();
		
		while(rs.next()) {
			Map<String, String> rsMap=new HashMap();
			rsMap.put("STREET_ADDRESS", rs.getString("street_address"));
			rsMap.put("CITY", rs.getString("city"));
			rsMap.put("COUNTRY_NAME", rs.getString("country_name"));
			rsList.add(rsMap);
			
		}
		System.out.println(rsList);
	}
	
	
	
	
	
	
	
	
	
}
