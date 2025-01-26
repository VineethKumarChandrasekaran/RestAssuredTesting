package com.backend.requestchaining;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;
import com.backend.pojoutility.POJOFileForPOSTRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostAndDeleteChainingTest {
	
	@Test
	public void postanddelete() {
		 Random rand = new Random();
		 int random = rand.nextInt(10000);
		
		POJOFileForPOSTRequest pojo = new POJOFileForPOSTRequest("Vineeth Kumar C","TEK_"+random,"Created",0);
		 Response response = given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.post("http://49.249.28.218:8091/addProject");
		 response.then().log().all()
		 .assertThat().statusCode(201);
		 
		 Object projectId = response.jsonPath().get("projectId");
		 
		 given().delete("http://49.249.28.218:8091/project/"+projectId)
		 .then().log().all()
		 .assertThat().statusCode(204);
		
	}

}
