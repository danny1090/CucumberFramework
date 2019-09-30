package com.orangehrm.practice;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class HamcrestDemo {

	/*
	 * Retrieve quote of specific character(varys)and verify that response code is 200
	 * and response contains
	 */
	
	//@Test
	public void verifyResponse() {
		RestAssured.baseURI="https://got-quotes.herokuapp.com/quotes";
		Response resp=
				given().queryParam("char", "varys").
				when().get("/quotes");
		String respBody=resp.asString();
		System.out.println(respBody);
		
		
		//2nd way to complete request * assertion
		given().
			queryParam("char", "varys").
		when().
			get("/quotes").
		then().
			assertThat().statusCode(200).
		and().
			assertThat().body("character", equalTo("Varys"));
		
		//3rd way 
		Response rsp1=
		given().
			queryParam("char", "varys").
		when().
			get("/quotes");
		rsp1.then().
			assertThat().statusCode(200).
		and().
			body("character", equalTo("Varys"));
			
		
		//retrieve student with id 123 & verify that response status code is 200
		//and first name of a student is Vladimir
		
		
	}
	
	@Test
	public void getStudentId() {
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		given().
			pathParam("studentId", "123").
		when().
			get("/api/getStudentProfile/{studentId}").
		then().
			assertThat().statusCode(200).
		and().
			body("firstName", equalTo("Vladimir"));
	}
	
	
	
}
