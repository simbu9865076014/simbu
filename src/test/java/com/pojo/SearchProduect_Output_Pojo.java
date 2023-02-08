package com.pojo;

import java.util.ArrayList;

public class SearchProduect_Output_Pojo {
	
	private int status;
    private String message;
    private ArrayList<SearchProduect> data;
    private String currency;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public ArrayList<SearchProduect> getData() {
		return data;
	}
	public String getCurrency() {
		return currency;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(ArrayList<SearchProduect> data) {
		this.data = data;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
    
    
    


}
