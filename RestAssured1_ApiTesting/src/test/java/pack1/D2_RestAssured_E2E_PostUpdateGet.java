package pack1;

import static io.restassured.RestAssured.given; //add this static import manually for given()

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*; //add this static import for equalTo() 

public class D2_RestAssured_E2E_PostUpdateGet {
	String PlaceId="null";
	String UpdatedPlaceAddress="70 winter walk, USA";

	@Test(priority=0)
	public void Post()
	{
		////refer Library+API doc for API contract at C:\Users\SanjayKushwaha\Videos\API testing_Udemy\Postman_APIContract
		//Validate if add API is working as expected
		//Rest Assured works on BDD framework ie- on 3 principles--> Given, when and then
		//Given-->all inputs
		//When-->Submit API (resource and HTTP method)
		//Then-->Validate response
		// Body is kept in separate file and called here.
		//response is extracted and stored in string variable

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
				.body(Payload.UpdatePlace())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

		System.out.println(response);
		JsonPath js= new JsonPath(response); //convert raw text to json and parse json values
		PlaceId=js.getString("place_id"); //store some value from response in var to use it further

		System.out.println("place id obtained from response= "+PlaceId);


	}
	@Test(priority=1)
	public void Update()
	{
		//use Place id variable from above Post method as input in payload body below

		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+PlaceId+"\",\r\n" + 
				"\"address\":\""+UpdatedPlaceAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
	}

	@Test(priority=2)
	public void Get()
	{
		given().log().all().queryParam("key","qaclick123").queryParam("place_id", PlaceId)

		.when().put("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).body("address", equalTo(UpdatedPlaceAddress));
	}

}
