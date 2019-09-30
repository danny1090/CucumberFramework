package com.orangehrm.practice;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {

	@Test
	public void createStudent() {
		Map<String, Object> map=new LinkedHashMap();
		map.put("id", 0);
		map.put("firstName", "Tanya");
		map.put("lastName", "Smith");
		map.put("age", "25");
		map.put("batch", 5);
		map.put("batchStartDate", "2019-09-14");
		map.put("batchEndDate", "2020-03-01");
		map.put("course", "Selenium");
		map.put("attendanceNature", "nj");
		map.put("streetAddress", "123 test");
		map.put("city", "Clifton");
		map.put("state", "NJ");
		map.put("zipCode", "12345");
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		Response rsp=
		given().
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(map).
		when().
			post("/api/createStudentProfile");
		rsp.then().assertThat().statusCode(201);
		rsp.prettyPrint();
		 
		int studentId=rsp.jsonPath().get("id");
		System.out.println(studentId);
		
		Map<String, Object> responseMap = rsp.as(Map.class);
		System.out.println(responseMap);
	}
	
	@Test
	public void putRequest() {
		Map<String, Object> map=new LinkedHashMap();
		map.put("id", 0);
		map.put("firstName", "Tanya");
		map.put("lastName", "Smith");
		map.put("age", "25");
		map.put("batch", 5);
		map.put("batchStartDate", "2019-09-14");
		map.put("batchEndDate", "2020-03-01");
		map.put("course", "Selenium");
		map.put("attendanceNature", "nj");
		map.put("streetAddress", "123 test");
		map.put("city", "Clifton");
		map.put("state", "NJ");
		map.put("zipCode", "12345");
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		Response rsp= 
		given().
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(map).
		when().
			post("/api/updateStudentProfile");
		rsp.then().assertThat().statusCode(200);
		rsp.prettyPrint();
		
	}
	
	
	
}
