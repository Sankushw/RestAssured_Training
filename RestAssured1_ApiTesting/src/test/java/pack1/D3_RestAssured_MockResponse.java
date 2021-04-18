package pack1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class D3_RestAssured_MockResponse {


	@Test(priority=0)
	public void TestMockedResponses()
	{
		// refer Library+API doc for API contract at C:\Users\SanjayKushwaha\Videos\API testing_Udemy\MockResponse_CoursePrice
		// NoClassDefFoundError --when some jar is missing
		// Retrieving the Json Array Size and its elements using JsonPath api---------------------------------
		//	1. Print No of courses returned by API
		//	2. Print Purchase Amount
		//	3. Print Title of the first course
		//	4. Print All course titles and their respective Prices
		//	5. Print no of copies sold by RPA Course
		//  6. Verify if Sum of all Course prices matches with Purchase Amount
		//  Use online json editor for easier view of complex json files.

		//1. Print No of courses returned by API
		JsonPath js= new JsonPath(Payload.MockResponse_CoursePrice()); //convert raw text to json and parse json values
		int Course_Size=js.getInt("courses.size()"); //store value of course count in int

		System.out.println("Number of courses= "+Course_Size);

		//2.Print Purchase Amount
		int Total_Amount=js.getInt("dashboard.purchaseAmount"); //store value of courses total amount in int
		System.out.println("purchase amount of all courses= "+Total_Amount);

		//		3. Print Title of the first course
		String FirstCourseTitle=js.get("courses[0].title"); //store value of 1st course title in String
		System.out.println("Title of first course is= "+FirstCourseTitle);

		// Iterating over every element of Json Array and accessing elements in it-----------------------------
		//4. Print All course titles and their respective Prices
		for(int i=0;i<Course_Size;i++)
		{
			String CourseTitle=js.get("courses["+i+"].title"); 
			int CourseCost=js.getInt("courses["+i+"].price"); 
			System.out.println("Title of "+i+" course is= "+CourseTitle+" and its cost is= "+CourseCost);

		}

		//If Array size in json is dynamic-->Retrieving Json Nodes on Condition logic using JsonPath----------
		//5. Print no of copies purchased for RPA Course

		for(int i=0;i<Course_Size;i++)
		{
			String CourseTitle=js.get("courses["+i+"].title");
			if(CourseTitle.equalsIgnoreCase("RPA"))
			{
				int CopiesCount=js.getInt("courses["+i+"].copies"); 
				System.out.println("Number of copies purchased for RPA course is= "+CopiesCount);
				break;
			}
		}


		//  6. Verify if Sum of all Course prices matches with Purchase Amount
		int Sum=0;
		for(int i=0;i<Course_Size;i++)
		{

			int price=js.getInt("courses["+i+"].price"); 
			int Copies=js.getInt("courses["+i+"].copies"); 
			int amount=price*Copies;
			Sum=Sum+amount;
		}
		System.out.println("calculated sum is= "+Sum);
		Assert.assertEquals(Sum, Total_Amount);


	}

}
