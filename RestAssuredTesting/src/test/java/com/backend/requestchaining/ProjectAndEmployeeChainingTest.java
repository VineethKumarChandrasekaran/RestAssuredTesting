package com.backend.requestchaining;

import org.testng.annotations.Test;

import com.backend.pojoutility.POJOFileForAddEmployee;
import com.backend.pojoutility.POJOFileForPOSTRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class ProjectAndEmployeeChainingTest {

	@Test
	public void projectandemployee() {
		Random rand = new Random();
		int random = rand.nextInt(10000);
		
		POJOFileForPOSTRequest pojo = new POJOFileForPOSTRequest("Vineeth Kumar C","TEK_"+random,"Created",0);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.post("http://49.249.28.218:8091/addProject");
		response.then().log().all()
		.statusCode(201);
		
		String projectName = response.jsonPath().get("projectName");
		String projectId = response.jsonPath().get("projectId");
		
		POJOFileForAddEmployee pojo1 = new POJOFileForAddEmployee("TestEngineer","14/02/2025","testengineer@gmail.com","testengineer"+random,3.5,"9876543210",projectName,"ROLE_EMPLOYEE","testengineer"+random);
		
		Response response1 = given()
		.contentType(ContentType.JSON)
		.body(pojo1)
		.post("http://49.249.28.218:8091/employees");
		response1.then().log().all();
		
		String employeeId = response1.jsonPath().get("employeeId");
		
		given().delete("http://49.249.28.218:8091/employee/"+employeeId)
		 .then().log().all();
		
		 
		 given().delete("http://49.249.28.218:8091/project/"+projectId)
		 .then().log().all()
		 .assertThat().statusCode(204);
	}
}
