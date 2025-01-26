package com.backend.crudwithbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PATCHTest {

	@Test
	public void patchDataToServer() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("status", "Completed");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj)
		.patch("http://49.249.28.218:8091/project/NH_PROJ_12281")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
