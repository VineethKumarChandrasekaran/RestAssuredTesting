package com.backend.testing;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MethodChainingTest {
	
	@Test
	public void getTest() {
		get("https://reqres.in/api/users?page=2").then().log().all();
	}

}
