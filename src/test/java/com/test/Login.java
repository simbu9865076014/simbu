 package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.endpoits.EndPoints;
import com.payload.address.AddressPayload;
import com.payload.produect.ProduectPayLoad;
import com.pojo.AddUserAddress_Input_Pojo;
import com.pojo.AddUserAddress_Output_Pojo;
import com.pojo.CityList;
import com.pojo.CityList_Input_Pojo;
import com.pojo.CityList_Output_Pojo;
import com.pojo.DeleteUserAddress_Input_Pojo;
import com.pojo.DeleteUserAddress_Output_Pojo;
import com.pojo.GetUserAddress_Output_Pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.SearchProduect_Input_Pojo;
import com.pojo.SearchProduect_Output_Pojo;
import com.pojo.StateList;
import com.pojo.StateList_Output_Pojo;
import com.pojo.UpdateUserAddress_Input_Pojo;
import com.pojo.UpdateUserAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Login extends BaseClass {
	String logtoken;
	String state_Id;
	int stateIdNum;
	int cityId;
	String address_id;
	 static AddressPayload addressPayload = new AddressPayload();
	 static ProduectPayLoad produectPayload = new ProduectPayLoad();
	
	
	@Test(priority=8)
	public void searchProduect() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h3=new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		
//		SearchProduect_Input_Pojo   searchProduect_Input_Pojo  = new SearchProduect_Input_Pojo( "nuts");
		com.pojo.produect.SearchProduect_Input_Pojo searchProduect_Input_Pojo = produectPayload.searchProduectPayLoad("nuts");
		addBody(searchProduect_Input_Pojo);
		Response response = getRequestType( "POST", EndPoints.SEARCHPRODUECT);
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200,"verify statuscode");
		
		SearchProduect_Output_Pojo searchProduect_Output_Pojo = response.as(SearchProduect_Output_Pojo.class);
		String actMessage = searchProduect_Output_Pojo.getMessage();
		Assert.assertEquals(actMessage, "OK","verify Search produect");
		
		

	}
	
	@Test(priority=7)
	public void deleteUserAddress() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer " +logtoken);
		Header h3=new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		
//		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo=new DeleteUserAddress_Input_Pojo(address_id);
		com.pojo.address.DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = addressPayload.deleteUserAddress(address_id);
		addBody(deleteUserAddress_Input_Pojo);
		
		Response response = getRequestType("DELETE", EndPoints.DELETEUSERADDRESS);
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200,"verify statuscode");
		
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String actMessage = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(actMessage, "Address deleted successfully","verify Address deleted successfully");

	}
	
	
	@Test(priority=6)
	public void getUserAddress() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer " +logtoken);
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		Response response = getRequestType("GET", EndPoints.GETUSERADDRESS);
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200,"verify statuscode");
		
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String actMessage = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(actMessage, "OK","verify get User Address ");
		
	}
	
	@Test(priority=5)
	public void updateUserAddress() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer " +logtoken);
		Header h3=new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		
//		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo=new UpdateUserAddress_Input_Pojo("45637", "simbu", "s", "9865076014", "18",
//				stateIdNum, cityId, 101, "600028", "chennai", "Home");
		com.pojo.address.UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = addressPayload.updateUserAddress("45637", "simbu", "s", "9865076014", "18",
				stateIdNum, cityId, 101, "600028", "chennai", "Home");
		addBody(updateUserAddress_Input_Pojo);
		Response response = getRequestType("PUT", EndPoints.UPDATEUSERADDRESS);
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200,"verify statuscode");
		
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String actMessage = updateUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(actMessage, "Address updated successfully","verify Address updated successfully");
		
		

	}
	
	@Test(priority=3)
	public void getCityList() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
//		CityList_Input_Pojo cityList_Input_Pojo=new CityList_Input_Pojo(state_Id);
		com.pojo.address.CityList_Input_Pojo cityList_Input_Pojo = addressPayload.cityListPayLoad(state_Id);
		addBody(cityList_Input_Pojo);
		
		Response response = getRequestType("POST",EndPoints.GETCITYLIST);
		int actStatusCode = response.getStatusCode();
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode,200, "verify status code");
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityList> cityList = cityList_Output_Pojo.getData();
		for (CityList eactCityList : cityList) {
			String actCityName = eactCityList.getName();
			if (actCityName.equals("Vriddhachalam")) {
				int cityId = eactCityList.getId();
				System.out.println(cityId);
				Assert.assertEquals(actCityName, "Vriddhachalam", "verify City name as Vriddhachalam");
				break;
				
			}
		}

	}
	
	
	@Test(priority=2)
	public void getStateList() {
		addHeader("accept", "application/json");
		Response response = getRequestType("GET", EndPoints.GETSTATELIST);
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200,"verify statuscode");
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		ArrayList<StateList> stateList = stateList_Output_Pojo.getData();
		for (StateList eachStateList : stateList) {
			String actStateName = eachStateList.getName();
			
			if (actStateName.equals("Tamil Nadu")) {
				stateIdNum = eachStateList.getId();
				state_Id = String.valueOf(stateIdNum);
				 System.out.println(stateIdNum);
				 Assert.assertEquals(actStateName,"Tamil Nadu", "verify state name as TN");
				 break;
			}
		}
	}
	@Test(priority=1)
	public void login() {
		
		addHeader("accept", "application/json");
		addBasicAuth("silambarasonmech@gmail.com", "Password@123");
		Response response = getRequestType("POST", EndPoints.POSTMANBASICAUTHLOGIN);
		int actStatusCode = getStatusCode(response);
	    Assert.assertEquals(actStatusCode, 200,"verify statuscode");
	    Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
	    String actFirst_name = login_Output_Pojo.getData().getFirst_name();
	    Assert.assertEquals(actFirst_name, "Simbu","verify firstname");
	     logtoken = login_Output_Pojo.getData().getLogtoken();
	    
	}
	@Test(priority=4)
	public void addUserAddress() {
		//1.Header
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer " +logtoken);
		Header h3=new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
//		//2.payload
//		AddUserAddress_Input_Pojo address_Input_Pojo=new AddUserAddress_Input_Pojo("simbu", "s", "9626836118","18", stateIdNum, cityId, 101, "600028", "chennai", "Home");
		
		com.pojo.address.AddUserAddress_Input_Pojo address_Input_Pojo = addressPayload.addUserAddressPayload("simbu", "s", "9626836118","18", stateIdNum, cityId, 101, "600028", "chennai", "Home");
		
		addBody(address_Input_Pojo);
		//3. Method type
		Response response = getRequestType("POST", EndPoints.ADDUSERADDRESS);
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200,"verify statuscode");
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actMessage = addUserAddress_Output_Pojo.getMessage();
		int address = addUserAddress_Output_Pojo.getAddress_id();
		address_id = String.valueOf(address);
		Assert.assertEquals(actMessage, "Address added successfully", "verify Address added successfully");
		
		
		
	}

}
