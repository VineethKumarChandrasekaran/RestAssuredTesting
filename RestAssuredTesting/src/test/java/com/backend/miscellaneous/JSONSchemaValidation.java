package com.backend.miscellaneous;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import com.backend.pojoutility.POJOFileForPOSTRequest;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class JSONSchemaValidation {
	
	@Test
	public void validation() {
		Random rand = new Random();
		int random = rand.nextInt(10000);
		
		POJOFileForPOSTRequest pojo = new POJOFileForPOSTRequest("John Doe", "TEK_"+random, "Created", 0);
		
		String jsonschema = "{\r\n"
				+ "            \"msg\": \"Successfully Added\",\r\n"
				+ "            \"createdBy\": \"John Doe\",\r\n"
				+ "            \"projectName\": \"TEK_1997\",\r\n"
				+ "            \"projectId\": \"NH_PROJ_13048\",\r\n"
				+ "            \"createdOn\": \"2024-07-05\",\r\n"
				+ "            \"status\": \"Created\"\r\n"
				+ "        }";
		
		 Response response = given()
		.contentType(ContentType.JSON)
		.body(pojo).log().all()
		.when()
		.post("http://49.249.28.218:8091/addProject");
		 response.then()
		 .assertThat().contentType(ContentType.JSON)
		 .log().all();
		 response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resource/jsonschema.json")));
		 //response.then().assertThat().body("msg", instanceof(String.class ));
		 
	}

}
