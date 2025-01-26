package com.backend.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ComplexJsonPath {
	
	@Test
	public void jsonPath() {
		Response response = given().get("http://49.249.28.218:8091/projects-paginated");
		List<String> projectIdList = JsonPath.read(response.asString(), ".content[*].projectId");
		for (String projectId : projectIdList) {
			System.out.println(projectId);
		}
		
		List<String> projectname = JsonPath.read(response.asString(), ".content[*].[?(@.projectId=='NH_PROJ_9972')].projectName");
		System.out.println(projectname);
		
		Assert.assertEquals(projectname.get(0), "BSNL_1101_20");
	}

}
