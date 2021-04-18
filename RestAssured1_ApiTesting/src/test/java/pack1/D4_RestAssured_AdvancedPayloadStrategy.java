package pack1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.xml.bind.v2.runtime.reflect.Lister.Pack;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class D4_RestAssured_AdvancedPayloadStrategy {


	@Test(priority=0)
	public void DynamicJson_WithSingleTestData()
	{
		// Handling Dynamic Json Payloads with Parameterization
		//Sending parameters to payload from Test
		//refer Library+API doc for API contract at C:\Users\SanjayKushwaha\Videos\API testing_Udemy
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json")
				.body(Payload.AddBook("hksai","6053467"))
				.when().post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added"))
				.extract().response().asString();

		JsonPath js= new JsonPath(response);
		String id=	js.get("ID");
		System.out.println("Id of the book added is= "+id);

	}
	@Test(priority=1, dataProvider="TestData")
	public void DynamicJson_WithMultipleTestData(String isbn, String aisle)
	{
		//Sending parameters to payload using dataProvider to run test multiple times with different test data
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json")
				.body(Payload.AddBook(isbn,aisle))
				.when().post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added"))
				.extract().response().asString();

		JsonPath js= new JsonPath(response);
		String id=	js.get("ID");
		System.out.println("Id of the book added is= "+id);
	}

	@DataProvider(name="TestData")
	public Object[][] getData()
	{
		//array---collection of data
		//multi dimensional array---collection of arrays
		//create object of multi dim array and initialize with 3 sets of test data to run test 3 times. Add return .
		return new Object[][]{{"gsydtj","675462"},{"gdyuejf","87436325"},{"ytmlsh","983517"}};

	}

	@Test(priority=3)
	public void StaticJson() throws IOException
	{
		//Sending payload directly from a file (without creating any method for payLoad) if payload is static ie- never changes
		//There are methods in JAVA which read string in file and convert to Bytes and then byte to String to use in script
		//Files.readAllBytes(Path path)--> this converts to byte. To convert byte to String-->create String Object-- 
		//-- and pass Files.readAllBytes(Path path) as the argument.
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\SanjayKushwaha\\Videos\\API testing_Udemy\\Postman_APIContract\\AddPlace.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");	

	}
	
}
