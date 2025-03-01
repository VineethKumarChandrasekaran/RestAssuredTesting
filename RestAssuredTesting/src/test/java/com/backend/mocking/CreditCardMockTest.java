package com.backend.mocking;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;

public class CreditCardMockTest {

	public static void main(String[] args) {
		
		Spark.port(8889);
		Spark.post("/credit-card", (req,res)->{
			String response = "";
			String card = JsonPath.read(req.body().toString(),  "$.creditcard");
			if (StringUtils.equalsAny(card, "1234567891234","1234567891235")) {
				response = "{\"status\":\"Payment Success\"}";
				res.status(200);
			} else {
				response = "{\"status\":\"Payment Failed\"}";
				res.status(404);
			}
			res.type("appilcation/json");
			return response;
		});
      System.out.println("====Running....====");
	}

}
