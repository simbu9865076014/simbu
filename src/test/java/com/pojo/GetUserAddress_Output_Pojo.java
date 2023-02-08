package com.pojo;

import java.util.ArrayList;

public class GetUserAddress_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<GetUserAddress> data;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public ArrayList<GetUserAddress> getData() {
		return data;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(ArrayList<GetUserAddress> data) {
		this.data = data;
	}
	
	

}
