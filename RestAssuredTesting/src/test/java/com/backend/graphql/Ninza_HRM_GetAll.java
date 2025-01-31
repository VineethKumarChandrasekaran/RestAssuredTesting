package com.backend.graphql;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Ninza_HRM_GetAll {

	@Test
	public void getAll() {
		String query = "{ getAllProjects{ projectId projectName status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/getAll")
		.then().log().all();
	}
}
