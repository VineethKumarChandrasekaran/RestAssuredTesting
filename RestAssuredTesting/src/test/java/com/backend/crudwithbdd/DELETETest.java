package com.backend.crudwithbdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DELETETest {
	
	@Test
	public void deleteDataFromServer() {
		given()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_12281")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}
