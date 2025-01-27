package com.backend.mocking;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PaymentTest {
	
	@Test
	public void creditCard() {
		JSONObject json = new JSONObject();
		json.put("creditcard", "1234567891234");
		json.put("cvv", "123");
		json.put("cardname", "Vineeth Kumar C");
		given()
		.contentType(ContentType.JSON)
		.body(json)
		.log().all()
		.when()
		.post("http://localhost:8889/credit-card")
		.then().log().all();
	}

}
