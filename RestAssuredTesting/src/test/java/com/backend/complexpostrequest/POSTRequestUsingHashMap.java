package com.backend.complexpostrequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class POSTRequestUsingHashMap {

  @Test
  public void postJsonObject() {
	  HashMap<String, Object> obj = new HashMap<String, Object>();
	  obj.put("createdBy","Vineeth Kumar C");
	  obj.put("projectName","TEK_998" );
	  obj.put("status","Created" );
	  obj.put("teamSize",0 );
	  given()
	  .contentType(ContentType.JSON)
	  .body(obj)
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
  }


}
