 package com.sample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class A {
	
	public void listUsers() {
		RequestSpecification given = RestAssured.given();
		RequestSpecification pathParam = given.header("accept","application");
		Response response = pathParam.get("https://reqres.in/api/users?page=2");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asString = response.asString();
		System.out.println(asString);
		
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		
	}
	private void create() {
		RequestSpecification given = RestAssured.given();
		RequestSpecification pathParam = given.header("accept","application");
		pathParam.body("{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"cityslicka\"\r\n" + 
				"} ");
		Response response = pathParam.post("https://reqres.in/api/login");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asString = response.asString();
		System.out.println(asString);
		
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

	}
	 private void update() {
		 RequestSpecification given = RestAssured.given();
			RequestSpecification pathParam = given.header("accept","application");
			pathParam.body("{\r\n" + 
					"    \"name\": \"morpheus\",\r\n" + 
					"    \"job\": \"zion resident\"\r\n" + 
					"} ");
			Response response = pathParam.put("https://reqres.in/api/users/2");
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			String asString = response.asString();
			System.out.println(asString);
			
			String asPrettyString = response.asPrettyString();
			System.out.println(asPrettyString);
		

	}
	 private void delete() {
		 RequestSpecification given = RestAssured.given();
			RequestSpecification pathParam = given.header("accept","application");
			Response response = pathParam.delete("https://reqres.in/api/users/2");
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			
	
	}
	public static void main(String[] args) {
		A a= new A();
		a.listUsers();
		a.create();
		a.update();
		a. delete();
	}

}
