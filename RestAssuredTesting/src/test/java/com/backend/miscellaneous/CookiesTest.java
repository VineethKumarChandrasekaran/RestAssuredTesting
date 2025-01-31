package com.backend.miscellaneous;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CookiesTest {
	
	@Test
	public void cookies() {
		given().cookie("username" , "deepak").log().all()
		.when()
		.get("http://49.249.28.218:8091/project/NH_PROJ_4271")
		.then().log().all();
	}
}
