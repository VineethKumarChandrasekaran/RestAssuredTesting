package com.backend.automationexercise;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class POSTToVerifyLoginWithValidDetails {
	
	@Test
	public void verifyLogin() {
		Random ran = new Random();
		int random = ran.nextInt(10000);
		
		JSONObject json = new JSONObject();
		json.put("email", "vineethkumar"+random+"@gmail.com");
		json.put("password","Vineeth"+random);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(json)
		.log().all()
		.when()
		.post("https://automationexercise.com/api/verifyLogin");
		response.then()
		.assertThat().contentType(ContentType.HTML)
		.assertThat().statusCode(200)
		.log().all();
	}

}
