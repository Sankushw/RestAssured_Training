package demo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.Courses;
import pojo.GetCourseDetails;

public class oAuthTest {

	/*POJO classes(Plain old java object)
	Serialization--converting java object to Request body(Payload).Implemented using POJO classes.(like encapsulation)--we use setters for this
	Deserialization--converting Response body to java object.--we use getters for this
	--need jackson and gson jars to use these features in Java project.
	--need JAXB library(jar) for Maven project.*/

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] courseTitles= { "Selenium Webdriver Java","Cypress","Protractor"};
		/*	 System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss");
			driver.findElement(By.cssSelector("input[type='email']")).sendKeys("fdfd");
			driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys("fxfe");
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			String url=driver.getCurrentUrl();*/

		String url="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2F0AY0e-g6-OiE3NGcoHE1O22ADwgg2M6jA8K7apZPKcWREKjp_nR7NcAlzD7BDkL-Smtlqxw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		System.out.println(code);


		//   tagname[attribute='value']

		String accessTokenResponse=	given().urlEncodingEnabled(false)
				.queryParams("code",code)
				.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type","authorization_code")
				.when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js=new JsonPath(accessTokenResponse);
		String accessToken=js.getString("access_token");



		//using .as(GetCourseDetails.class) to convert/wrap json response to java object of main POJO class=deserialization
		//if content-type is not set to application/json in header then use expect().defaultParser(Parser.JSON) to tell RestAssured what is response type.
		GetCourseDetails gc=given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourseDetails.class);

		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

		//to get the price of course:oapUI Webservices testing	
		List<Api> apiCourses=gc.getCourses().getApi();
		for(int i=0;i<apiCourses.size();i++)
		{
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println(apiCourses.get(i).getPrice());
			}
		}
		//or use this for loop-----------
		/*	int api_size=gc.getCourses().getApi().size();
		for(int i=0;i<api_size;i++)
		{
			if(gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
				System.out.println(gc.getCourses().getApi().get(i).getPrice());
					}
		}*/

		//Get the course names of WebAutomation
		ArrayList<String> a= new ArrayList<String>();


		List<pojo.WebAutomation> w=gc.getCourses().getWebAutomation();

		for(int j=0;j<w.size();j++)
		{
			a.add(w.get(j).getCourseTitle());
			System.out.println("Course title "+j+" = "+w.get(j).getCourseTitle());
		}

		List<String> expectedList=	Arrays.asList(courseTitles);
		//we converted array to arraylist because in future size may change.we can compare list with list only.
		Assert.assertTrue(a.equals(expectedList));
		//System.out.println(response);


	}
	/*advantages of POJO classes:
		1 easy to parse and extract response values if they are wrapped as java objects	
		2 user friendly methods can be made which makes code more readable.

		design approach:
		POJO classes are made based on response/request payload
		using .as(classname.class) to convert json response to java object=deserialization
		Objects of pojo classes are created and used in the script

		There are Hundreds of QA Recruiters (especially from US, India) in my Linkedin Network.
		So Complete the course 100% and Udemy will honour you with Certificate of Completion on Rest API Automation with Rest Assured.
		Post the certificate in your Linkedin and Tag me.
		You can find my linkedIn details on my Udemy profile page under Image icon*/
}
