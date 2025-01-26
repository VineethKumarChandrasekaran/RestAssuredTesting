package com.backend.datadriventesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestByDataProvider {
	
	@Test(dataProvider = "test")
	public void datadriver(String projectname, String status) {
		String request = "{\r\n"
				+ "  \"createdBy\": \"Vineeth Kumar C\",\r\n"
				+ "  \"projectName\": \""+projectname+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		
		given()
		.contentType(ContentType.JSON)
		.body(request)
		.log().all()
		.post("http://49.249.28.218:8091/addProject")
		.then().log().all();
	}

	@DataProvider(name = "test")
	public Object[][] dataprovider(){
		Random rand = new Random();
		int random = rand.nextInt(1000);
		Object[][] obj = new Object[2][2];
		obj[0][0] = "TEK_"+random;
		obj[0][1] = "Created";
		obj[1][0] = "TEK_"+random;
		obj[1][1] = "Created";
		return obj;
	}
}
