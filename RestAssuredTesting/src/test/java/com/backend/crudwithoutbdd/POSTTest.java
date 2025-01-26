package com.backend.crudwithoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTTest {

	@Test
	public void postDataToServer() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "Vineeth Kumar C");
		jsonobj.put("projectName", "TEK_0987");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
		
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(jsonobj);
		Response response = request.post("http://49.249.28.218:8091/addProject");
		response.then().log().all();
		response.then().assertThat().statusCode(201);
	}

}
