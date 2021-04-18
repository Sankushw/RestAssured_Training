package pack1;

import static io.restassured.RestAssured.given; //add this static import manually for given()

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*; //add this static import for equalTo() 

public class D1_BasicRestAssured_AddPlace_Post {

	@Test
	public void Post()
	{
		//to paste payload in String format--> Windows--preferences--Javascript-Editor-Typing--Uncheck escape text while pasting
		//Validate if add place API is working as expected
		//Rest Assured works on BDD framework ie- on 3 principles--> Given, when and then
		//Given-->all inputs
		//When-->Call API (resource and HTTP method)
		//Then-->Validate response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"")
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");



	}
}
