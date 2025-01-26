package com.backend.testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SampleGetTest {
	
	@Test
	public void getMethod() {
		RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
		RestAssured.get("https://reqres.in/api/users?page=2").prettyPeek();
	}

}
