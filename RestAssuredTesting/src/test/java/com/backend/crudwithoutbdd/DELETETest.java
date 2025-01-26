package com.backend.crudwithoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETETest {
	
	@Test
	public void deleteDataFromServer() {
		Response response = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_12224");
		response.then().assertThat().statusCode(204);
		response.then().log().all();
	}

}
