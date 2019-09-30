package com.orangehrm.practice;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class HeaderTest {

	/*
	 * When I send GET request to the "/api/getAllStudentProfiles"
	 * Then response status code is 200
	 * And response header "Content-Type" contains "application/json"
	 */
	
	public void task() {
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		Response resp=given().when().get("/api/getAllStudentProfiles");
		
		resp.then().assertThat().statusCode(200).
		and().header("Content-Type", equalTo("application/json;charset=UTF-8"));
		
	}
}
