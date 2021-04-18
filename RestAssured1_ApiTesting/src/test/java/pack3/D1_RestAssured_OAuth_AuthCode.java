package pack3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import groovyjarjarasm.asm.commons.Method;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class D1_RestAssured_OAuth_AuthCode {
	String accessToken=null;
	String code=null;
	@Test //get permission code using RestAssured and selenium
	public void GetCode()
	{
		/*		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		//driver.findElement(By.id("profileIdentifier")).click();

		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sanjay1893@gmail.com");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("password")).sendKeys("Summerhai1@");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		String Url=driver.getCurrentUrl();
		System.out.println("Title of page after logging with cred= "+Url);*/

		// with the recent update google is not allowing to authenticate with automated frameworks.So above lines will not work now.
		//So manually put the uRL 
		String Url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AY0e-g5KNJpX5bTAKL0VY9cmjk1y5nJB5A_Z4-UOEhVRY5Cj3tw6hefR3by59mtXeZaeYw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent";
		//now use split method from Java to split URL into 2 parts using code parameter and return 2nd part(index=1)
		String partialUrl=Url.split("code=")[1];
		code=partialUrl.split("&scope")[0];
		System.out.println("code= "+code);
	}

	@Test //get access Token
	public void GetToken()
	{
		//set url encoding to false because by default RestAssured will convert specialChars in code to numbers.
		String response =given() 
				.urlEncodingEnabled(false)
				.queryParams("code",code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("grant_type", "authorization_code")
				.queryParams("state", "verifyfjdss")
				.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
				// .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath jsonPath = new JsonPath(response);
		accessToken = jsonPath.getString("access_token");
		System.out.println("access Token generated= "+accessToken);

	}	
	@Test //login using access token got from previous method and get the list of courses by RahulShetty Academy
	public void LoginWith_AccessToken()
	{
		//get actual session details using login Api
		//we need to tell rest assured what kind of response are we expecting using expect() method--we can 
		//avoid this if in header we give content-type as application/json
		//when we use expect() Method then we can't use log().all() methods
		String r2=given().contentType("application/json").
				queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php")
				.asString();
		System.out.println("Courses offered by Rahul Shetty Academy= "+r2);

	}
}

/*Handling Google/Facebook oauth 2.0 Authorization.
OAuth2.0-- the industry-standard protocol for authorization. The more you give away your passwords, the more 
likely it is that your passwords will get compromised.That's where OAuth comes in. OAuth, which stands for “Open Authorization,”
allows third-party services to exchange your information without you having to give away your password
--comes with multiple grants--authorization code and client credentials are most used.

--Process that happens in backend in Oauth2.0-authorization code grant technique: with example of BookMyShow.com
step1:User opens BookMyShow, selects Login By Gmail.User sign in to Google by hitting google authorization server-->sends back a auth/prmission code to BookMyShow.
step2:BookMyShow uses this code and other details which it requires(scope: like name,email etc) to hit google resource server-->returns access token along with requested scope details.

Now access token is stored in cookies by browser and scope details in BookMyShow DB server. After that all requests(actions) done on BookMyshow,access token
in checked then only action ois performed. If cookies deleted, then access token gets expired.

---API contract for Oauth project: C:\Users\SanjayKushwaha\Videos\API testing_Udemy\OAuth+2+contract.docx
mandatory query parameter for end point URL of Auth server:-->to get code
scope:  what all details is required by client(website)
auth_url: url of auth server
client id: client id got after registration.
response_type: response type like: code
redirect_Url: to which url to redirect after this req
state: to verify client(unique to client)
mandatory query parameter for end point URL of Resource server:-->to get access token
code: that is received from auth server
client id:
client secret id:
redirect_Url:
grant_type:
state:

Client Credentials:
When application requests its own data from resource server. It doesn't need to authenticate any user. So step 1 is skipped and only step2 is there.
eg: RahulShetty Academy website requesting Twitter to send back tweets with tagname "RahulShetty"*/