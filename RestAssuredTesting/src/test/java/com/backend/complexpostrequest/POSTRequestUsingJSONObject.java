package com.backend.complexpostrequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class POSTRequestUsingJSONObject {

  @Test
  public void postJsonObject() {
	  JSONObject jobj = new JSONObject();
	  jobj.put("createdBy","Vineeth Kumar C");
	  jobj.put("projectName","TEK_997" );
	  jobj.put("status","Created" );
	  jobj.put("teamSize",0 );
	  
	  given()
	  .contentType(ContentType.JSON)
	  .body(jobj)
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
  }


}
