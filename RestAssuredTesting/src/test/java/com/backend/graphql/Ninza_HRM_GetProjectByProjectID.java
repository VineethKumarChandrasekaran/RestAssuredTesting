package com.backend.graphql;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Ninza_HRM_GetProjectByProjectID {

	@Test
	public void getAll() {
		String query = "{ findProject(projectId:\"NH_PROJ_13048\"){ projectId projectName status createdBy teamSize } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/getProjectByProjectId")
		.then().log().all();
	}
}
