package com.backend.crudwithbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


public class PUTTest {


	@Test
	public void putDataToServer() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "Vineeth Kumar C");
		jsonobj.put("projectName", "TEK_009");
		jsonobj.put("status", "On going");
		jsonobj.put("teamSize", 0);
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj)
		.put("http://49.249.28.218:8091/project/NH_PROJ_12281")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
