package com.backend.assertion;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DataExtractionUsingJsonPath {
	
	@Test
	public void jsonPathData() {
		Response response = given().get("http://49.249.28.218:8091/projects-paginated");
		//response.then().log().all();
		List<String> projectIdList = response.jsonPath().get("content.projectId");
		for (String projectId : projectIdList) {
			System.out.println(projectId);
		}
	}

}
