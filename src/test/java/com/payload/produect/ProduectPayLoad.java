package com.payload.produect;

import com.pojo.produect.SearchProduect_Input_Pojo;

public class ProduectPayLoad {
	public SearchProduect_Input_Pojo searchProduectPayLoad(String text) {
		SearchProduect_Input_Pojo searchProduect_Input_Pojo=new SearchProduect_Input_Pojo(text);
		return searchProduect_Input_Pojo;

	}
	

}
