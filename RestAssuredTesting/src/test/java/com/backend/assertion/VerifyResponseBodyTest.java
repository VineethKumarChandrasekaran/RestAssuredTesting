package com.backend.assertion;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseBodyTest {
	
	@Test
	public void responseBody() {
	
	Response response = given().get("http://49.249.28.218:8091/projects-paginated");
	response.then().log().all();
	Object data = response.jsonPath().get("numberOfElements");
	Object data1 = response.jsonPath().get("empty");
	Object data2 = response.jsonPath().get("content[1].projectId");
	response.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
	response.then().assertThat().body("empty", Matchers.equalTo(false));
	response.then().assertThat().body("content[1].projectId", Matchers.equalTo("NH_PROJ_9945"));
	System.out.println(data);
	System.out.println(data1);
	System.out.println(data2);
	}

}
