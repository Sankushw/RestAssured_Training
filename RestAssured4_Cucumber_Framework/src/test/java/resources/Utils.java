package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import javax.security.auth.kerberos.KerberosPrincipal;

import org.junit.runners.Parameterized;
import org.openqa.selenium.ElementNotSelectableException;

import groovy.util.logging.Log;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation;

public class Utils {
	//Here we are using logging functionality using Add filter().we are passing PrintStream Object logRequestTo() which
	//directs all logs coming from req/response to a file using FileOutputStream object
	//import "hamcrestAll" jar file otherwise error-->java.lang.SecurityException: class "org.hamcrest.Matchers"'s signer information does not match signer information of other classes in the same package
	// "hamcrestAll" dependency in POM is not working so import the jar---its a rare issue.
	//we are setting baseUrl using properties class. Properties class can read a file with .properties extension.
	
	/*When when Parameterized test UsingInstrumentation examples in feature file to run multiple times then
	Log file is Overwritten evrytime, so to Keep the logs of each iteration of run, use if ElementNotSelectableException as below
	Also we have to declare req variable as static to retain value of previous iterations otherwise it gets reset to null everytime*/
	public static RequestSpecification reqspec;
	public  RequestSpecification RequestSpecs() throws IOException
	{
		if(reqspec==null)
		{
			PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
			reqspec =new RequestSpecBuilder().setBaseUri(GetGlobalValues("baseUrl"))
					.addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return reqspec;
		}
		return reqspec;

	}

	public static String GetGlobalValues(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\golbal.properties");
		prop.load(fileInputStream);
		return prop.getProperty(key);

	}


}
