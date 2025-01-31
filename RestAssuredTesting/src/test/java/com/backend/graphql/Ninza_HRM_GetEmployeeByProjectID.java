package com.backend.graphql;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Ninza_HRM_GetEmployeeByProjectID {
	
	@Test
	public void getAll() {
		String query = "{ findEmployees(projectId:\"NH_PROJ_13048\"){ empId empName mobileNo email dob experience username designation role project } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/getEmployeesByProjectId-graphql")
		.then().log().all();
	}

}
