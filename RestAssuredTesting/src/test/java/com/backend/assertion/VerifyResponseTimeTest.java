package com.backend.assertion;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {
	
	@Test
	public void responseTime() {
		Response response = given().get("http://49.249.28.218:8091/projects");
		response.then().log().all();
		System.out.println(response.time()); 
		System.out.println(response.timeIn(TimeUnit.SECONDS));
		response.then().assertThat().time(Matchers.lessThanOrEqualTo(1000L));
		response.then().assertThat().time(Matchers.greaterThanOrEqualTo(300L));
		response.then().assertThat().time(Matchers.both(Matchers.lessThanOrEqualTo(1000L)).and(Matchers.greaterThanOrEqualTo(300L)));
	}

}
