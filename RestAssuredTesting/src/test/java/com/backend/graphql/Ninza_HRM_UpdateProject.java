package com.backend.graphql;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Ninza_HRM_UpdateProject {

	@Test
	public void getAll() {
		String query = "mutation { updateProject( projectId: \"NH_PROJ_13048\" projectName: \"TEK_1997\", teamSize: 0, createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/updateProject-graphql")
		.then().log().all();
	}
}
