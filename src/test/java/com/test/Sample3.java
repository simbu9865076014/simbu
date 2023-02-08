package com.test;

import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import io.restassured.response.Response;

public class Sample3 extends BaseClass {	
	@Test(priority=2)
	public void listUsers() {
		addHeader("accept", "application/json");
		Response response = getRequestType("GET", "https://reqres.in/api/users?page=2");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	    String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);
		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);
	}
	@Test(priority=3)
	public void create() {
		addHeader("accept", "application");
		addBody("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}");
		
		Response response = getRequestType("POST", "https://reqres.in/api/users");
		int statusCode = getStatusCode(response);
		
		System.out.println(statusCode);
		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);
		String resBodyPrettyString = getResBodyPrettyString(response);
		
		System.out.println(resBodyPrettyString);

	}
	@Test(priority=4)
	 public void update() {
		addHeader("accept", "application");
		addBody( "{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}");
			Response response =getRequestType("PUT", "https://reqres.in/api/users/2");
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			String resBodyAsString = getResBodyAsString(response);
			
			System.out.println(resBodyAsString);
			String resBodyPrettyString = getResBodyPrettyString(response);
			System.out.println(resBodyPrettyString);
	}
	@Test(priority=1)
	public void delete() {
		addHeader("accept", "application");
		Response response = getRequestType("DELETE", "https://reqres.in/api/users/2");
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			
	
	}
	
}
