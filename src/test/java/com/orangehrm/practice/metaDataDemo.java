package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class metaDataDemo {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";
	
	@Test
	public void getMetaData() throws SQLException {
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData=conn.getMetaData();
		//printing database name
		String dbName=dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		//print database version
		String dbVers=dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVers);
		//-------------------------------------------------------------
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from employees where job_id = 'IT_PROG'");
		
		ResultSetMetaData rsMetaData=rs.getMetaData();
		//get total # of cols
		int colNum=rsMetaData.getColumnCount();
		System.out.println(colNum);
		
		//get name of specified col
		String colName=rsMetaData.getColumnName(2);
		System.out.println(colName);
		
		//print all col names
		
		for(int i=1; i<=colNum; i++) {
			String allCol=rsMetaData.getColumnName(i);
			System.out.println(allCol);
		}
		
		
		
		
		rs.close();
		st.close();
		conn.close();
		
	
		
		
		
		
		
	}
}
