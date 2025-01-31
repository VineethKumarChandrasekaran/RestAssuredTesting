package com.backend.graphql;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Ninza_HRM_AddProject{
	
	@Test
	public void getAll() {
		String query = "mutation { addProject( projectName: \"TEK_1997\", teamSize: 0, createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/addProject-graphql")
		.then().log().all();
	}

}
