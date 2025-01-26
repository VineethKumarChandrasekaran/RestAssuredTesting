package com.backend.complexpostrequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.backend.pojoutility.POJOFileForPOSTRequest;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class POSTRequestUsingPOJOClass {

  @Test
  public void postJsonObject() {
	 Random rand = new Random();
	 int random = rand.nextInt(10000);
	  
	  POJOFileForPOSTRequest pojo = new POJOFileForPOSTRequest("Vineeth Kumar C","TEK_"+random,"Created",0);
	  
	  given()
	  .contentType(ContentType.JSON)
	  .body(pojo)
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
  }


}
