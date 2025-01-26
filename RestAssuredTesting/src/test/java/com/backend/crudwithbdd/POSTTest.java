package com.backend.crudwithbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class POSTTest {
	@Test
	public void postDataToServer() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "Vineeth Kumar C");
		jsonobj.put("projectName", "TEK_0987");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj)
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}
