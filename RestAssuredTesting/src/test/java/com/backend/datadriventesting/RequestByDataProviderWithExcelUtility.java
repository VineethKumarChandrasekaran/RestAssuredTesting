package com.backend.datadriventesting;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.backend.excelutility.ExcelUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.Random;

public class RequestByDataProviderWithExcelUtility {
	
	@Test(dataProvider = "test")
	public void datadriver(String projectname, String status) {
		String request = "{\r\n"
				+ "  \"createdBy\": \"Vineeth Kumar C\",\r\n"
				+ "  \"projectName\": \""+projectname+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
		.contentType(ContentType.JSON)
		.body(request)
		.log().all()
		.post("http://49.249.28.218:8091/addProject")
		.then().log().all()
		.assertThat().statusCode(201);
	}
	
	@DataProvider(name = "test")
	public Object[][] testdata() throws EncryptedDocumentException, IOException{
		Random rand = new Random();
		ExcelUtility excel = new ExcelUtility();
	 	int rowcount = excel.getRowCount("Sheet1");
		Object[][] obj = new Object[rowcount][2];
	 	for(int i=0;i<rowcount;i++) {
	 		int random = rand.nextInt(1000);
	 		obj[i][0] = excel.getDataFromExcel("Sheet1", i+1, 0).toString() + random;
	 		obj[i][1] = excel.getDataFromExcel("Sheet1", i+1, 1);
	 	}
	 	
		return obj;
	}

}
