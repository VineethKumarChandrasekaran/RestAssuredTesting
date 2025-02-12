package com.backend.wiremock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class WireMockTest {
	
	@Test
	public void wiremock() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("debitCardNum", "1234567887654321");
		jobj.put("cvv","543");
		jobj.put("expDate", "28/30");
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.log().all()
		.when()
		.post("http://localhost:9999/debitCard");
		
		response.then()
		.assertThat().statusCode(200)
		.log().all();
	}

}
