package com.backend.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2O {
	
	@Test
	public void oauth() {
		Response response = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		 response.then().log().all();
		 
		 String token = response.jsonPath().get("access_token");
		 
		 given()
		 .auth().oauth2(token)
		 .get("http://49.249.28.218:8091/admin/payrolls")
		  .then().log().all();
	}

}
