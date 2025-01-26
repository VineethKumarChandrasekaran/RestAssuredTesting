package com.backend.crudwithoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTTest {
	
	@Test
	public void putDataToServer() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "Vineeth Kumar C");
		jsonobj.put("projectName", "TEK_009");
		jsonobj.put("status", "On going");
		jsonobj.put("teamSize", 0);
		
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(jsonobj);
		Response response = request.put("http://49.249.28.218:8091/project/NH_PROJ_12224");
		response.then().assertThat().statusCode(200);
		response.then().log().all();
	}

}
