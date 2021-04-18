package Step_definition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import enum_Resources.enumResourceAPI;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;
import pojo.AddPlace;
import pojo.Location;
import resources.TestdataBuild;
import resources.Utils;
//we are extending(inheritence) to access methods of Utils. Alternatively we can create Object of Utils class and callt he method
//We are keeping all generic code like RequestSpecification in separate class(Utils) and calling it so we can use it for all Add place. delete, getPlace APIs.
//We are calling Payload from other class. Payload is made at runtime by Seialization using POJO classes.
//for logs we can use log().All() on given() and then() methods. Here we are using logging functionality using Add filter filter() in Utils class.
public class Definition extends Utils
{
	WebDriver driver;

	ResponseSpecification resspec;
	RequestSpecification reqspec;
	Response responseJson;
	String responseText;
	JsonPath js;
	static String PlaceId;
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		reqspec=given().log().all().spec(RequestSpecs())
				.body(TestdataBuild.AddPlacePayLoad(name,language,address));
	}


	@When("user calls {string} with {string} HTTPS request")
	public void user_calls_with_https_request(String resource, String HttpMethod) {
		//setting resource link in post() method by calling it from properties file but here we are using concept of eNum where
		//we can declare methods and constructer and call the methods here.has many advantages.-
		//like if we call from properties file or other class then we have to create getters for each parameter which is not good practice
		//but in case of enum we create only 1 constructer and 1 getter to access any paramter.
		//below we are calling constructer OfenumResourceAPI (enum type class) --to pass value of resource.


		enumResourceAPI updatedResource=enumResourceAPI.valueOf(resource);
		String resource_link=updatedResource.getresource();
		System.out.println("resource url= "+resource_link);

		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if(HttpMethod.equalsIgnoreCase("POST"))
			responseJson =reqspec.when().post(resource_link).
			then().log().all().spec(resspec).extract().response();

		else if(HttpMethod.equalsIgnoreCase("GET"))
			responseJson =reqspec.when().get(resource_link)
			.then().log().all().spec(resspec).extract().response();

		else if(HttpMethod.equalsIgnoreCase("DELETE"))
			responseJson =reqspec.when().delete(resource_link)
			.then().log().all().spec(resspec).extract().response();
	}
	@Then("The Api call should be success with status code {string}")
	public void the_api_call_should_be_success_with_status_code(String ExpectedRespCode) {
		//import static org.junit.Assert.*;
		String respcode=String.valueOf(responseJson.getStatusCode());

		System.out.println("response status code= "+respcode);
		assertEquals(ExpectedRespCode,respcode);


	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		responseText=responseJson.asString();
		js=new JsonPath(responseText);
		System.out.println("The value of "+key+" is "+value);

		assertEquals(js.get(key), value);
	}

	@Then("verify place created maps to {string} using {string}")
	public void verify_place_created_maps_to_using(String expectedName, String resource) throws IOException {

		//get the response and extract Place_id
		js=new JsonPath(responseJson.asString());
		PlaceId=js.get("place_id");
		System.out.println("Place id created is= "+PlaceId);
		reqspec=given().log().all().spec(RequestSpecs()).queryParam("place_id", PlaceId);
		//reusing existing method from above
		user_calls_with_https_request(resource, "GET");
		js=new JsonPath(responseJson.asString());
		System.out.println("name fetched from GetAPI response= "+js.get("name"));
		System.out.println("name that got added by AddPlaceAPI= "+expectedName);
		assertEquals(expectedName,js.get("name"));

	}
	@Given("delete place payload")
	public void delete_place_payload() throws IOException {
		//make the placeId variable as static so that it retains the value from previous scenario(test) when this scenario(test) gets started
		//other methods @When, @then are not required in this scenario as these are reused from previous scenario
		reqspec= given().log().all().spec(RequestSpecs()).body(TestdataBuild.DeletePlacePayload(PlaceId));

	}



}