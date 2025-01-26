package com.backend.complexpostrequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

public class POSTRequestUsingJsonFile {

  @Test
  public void postJsonObject() {
	 
	  File file = new File("./PostProject.json");
	  
	  given()
	  .contentType(ContentType.JSON)
	  .body(file)
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
  }


}
