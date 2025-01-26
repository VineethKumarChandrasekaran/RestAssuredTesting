package com.backend.assertion;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseHeaderTest {
	
	@Test
	public void responseHeader() {
		Response response = given().get("http://49.249.28.218:8091/projects");
		response.then().assertThat().statusCode(200);
		response.then().contentType(ContentType.JSON);
		response.then().assertThat().statusLine("HTTP/1.1 200 ");
		response.then().assertThat().header("Transfer-Encoding", "chunked");
		response.then().log().all();
	}

}
