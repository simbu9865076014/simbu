package com.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sample {
	public static void main(String[] args) throws IOException, ParseException {
		//1.Mention the path of json file
		FileReader fileReader=new FileReader("C:\\Users\\s\\eclipse-workspace\\APIClass\\src\\test\\resources\\Features\\reqres.json");
		//2.create the object for JSONParser class
		JSONParser jsonParser=new JSONParser();
		//3.pass the json file fetch data
		Object parse = jsonParser.parse(fileReader);
		//4.convert object to jsonObject ------->classcast
		JSONObject jsonObject= (JSONObject)parse;
		
		Object object = jsonObject.get("data");
		
		System.out.println(object);
		JSONObject jsonObject2=(JSONObject)object;
		Object object2 = jsonObject2.get("id");
		Object object3 = jsonObject2.get("email");
		Object object4 = jsonObject2.get("first_name");
		Object object5 = jsonObject2.get("last_name");
		Object object6 = jsonObject2.get("avatar");
		
		System.out.println(object2);
		System.out.println(object3);
		System.out.println(object4);
		System.out.println(object5);
		System.out.println(object6);
		Object object7 = jsonObject.get("support");
		System.out.println(object7);
		JSONObject jsonObject3=(JSONObject)object7;
		Object object8 = jsonObject3.get("url");
		Object object9 = jsonObject3.get("text");
		System.out.println(object8);
		System.out.println(object9);
		
		
	}

}
