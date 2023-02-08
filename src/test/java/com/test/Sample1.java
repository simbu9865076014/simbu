package com.test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sample1   {
	public static void main(String[] args) throws IOException, ParseException {
		//1.Mention the path of json file
		FileReader fileReader=new FileReader("C:\\Users\\s\\eclipse-workspace\\APIClass\\src\\test\\resources\\Features\\jsonArray.json");
		//2.create the object for JSONParser class
		JSONParser jsonParser=new JSONParser();
		//3.pass the json file fetch data
		Object parse = jsonParser.parse(fileReader);
		//4.convert object to jsonObject ------->classcast
		JSONObject jsonObject= (JSONObject)parse;
		
		Object object = jsonObject.get("data");
		
		JSONArray array=(JSONArray)object;
		for (int i = 0; i < array.size(); i++) {
			Object object2 = array.get(i);
			JSONObject jsonObject2=(JSONObject)object2;
			System.out.println(jsonObject2.get("id"));
			System.out.println(jsonObject2.get("email"));
			System.out.println(jsonObject2.get("first_name"));
			System.out.println(jsonObject2.get("last_name"));
			System.out.println(jsonObject2.get("avatar"));
		}

	}
}
