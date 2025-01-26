package com.backend.crudwithoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETTest {
	
	@Test
	public void getDataFromServer() {
		Response response = RestAssured.get("http://49.249.28.218:8091/projects");
		response.then().assertThat().statusCode(200);
		response.then().log().all();
	}

}
