package com.baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response; 
	
	public void addHeader(String key , String value) {
		 reqSpec = RestAssured.given().header(key,value);
		 

	}
	public void addHeaders(Headers headers) {
		 reqSpec=RestAssured.given().headers(headers);

	}
	public void addBasicAuth(String username,String password) {
		reqSpec.auth().preemptive().basic(username, password);

	}
	
	
	public void addQueryParm(String key , String value) {
		 reqSpec = reqSpec.queryParam(key, value);
		 
		}
	public void addPthParm(String key , String value) {
		 reqSpec = reqSpec.pathParam(key, value);
		 
		}
	public void addBody(String body ) {
		 reqSpec = reqSpec.body(body);
		 
		}
	public void addBody(Object body ) {
		 reqSpec = reqSpec.body(body);
		 
		}
	
	public Response getRequestType(String type , String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;

		default:
			break;
		}
		return response;

	}
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}
	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;

	}
	public String getResBodyPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}


}
