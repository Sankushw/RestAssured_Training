package pack2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Comment;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class D1_RestAssured_JIRA_UpdateIssue {

	SessionFilter session=new SessionFilter();
	int commentId=0;
	@Test(priority=0)
	public void JiraAPI_AddComments()
	{
		/*This is how cookie-based authentication works in Jira at a high level:
	   1 The client requests a new session for the user via the Jira REST API .
       2 Jira returns a session object that has information about the session including the session cookie. The client stores this session object.
	   3 The client can now set the cookie in the header for all subsequent requests to the Jira REST API. */
		
		//Login to JIRA to create session id using login API
		//Add comment to existing defect using add comment API
		//add attachment to existing defect using Add attachment API
		//Get issue details and verify added comment and attachment using Get issue API

		RestAssured.baseURI= "http://localhost:8090";

		//Login to JIRA to create session id using login API----------------------------
		//using session filter method to get the session id automatically. Alternatively we can get it by parsing json response.
		//use relaxedHTTPSValidation() method on Given() to handle HTTPS Certification validation if required.
		String Session_Id=given().relaxedHTTPSValidation().log().all().
				header("Content-Type","application/json").
				body(Payload.LoginCredentials()).filter(session).
				when().
				post("rest/auth/1/session").
				then().log().all().extract().response().asString();	

		//Add comment to existing defect using add comment API-----------------------------------
		//path parameter is given in {} under post. Any name can be given to path para variable like--"key" or "id" etc
		String response=given().pathParam("key", "10003").log().all().
				//header("JSESSIONID","E73E4AA882E8BD62ECFAB1FC89B876C4").
				header("Content-Type","application/json").
				body(Payload.AddComment()).
				when().filter(session).
				post("/rest/api/2/issue/{key}/comment").
				then().log().all().and().
				assertThat().statusCode(201).extract().response().asString();

		JsonPath js =new JsonPath(response);
		commentId=js.getInt("id");
		System.out.println("comment id for comment added id= "+commentId);
	}

	//add attachment to existing defect using Add attachment API---using multipart method-------------------------
	@Test(priority=1)
	public void JiraAPI_AddAttachment()
	{
		//details are available in website in form of curl commands--understand it and use it: -D=parameters,-u=credentials,  -X=http method, -H=header, -F=file
		//curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: no-check" -F "file=@myfile.txt" https://your-domain.atlassian.net/rest/api/3/issue/TEST-123/attachments

		given().pathParam("key", "10003").log().all().filter(session).
		header("X-Atlassian-Token","no-check").
		header("Content-Type","multipart/form-data").
		multiPart("file",new File(System.getProperty("user.dir")+"\\src\\test\\java\\jiraAttachment.txt")).
		when().post("/rest/api/2/issue/{key}/attachments").
		then().log().all().
		assertThat().statusCode(200);

	}
	@Test(priority=2)
	public void JiraAPI_GetIssue()
	{
		/*		//details are available in website in form of curl commands--understand it and use it: -D=parameters,-u=credentials,  -X=http method, -H=header, -F=file
		//curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: no-check" -F "file=@myfile.txt" https://your-domain.atlassian.net/rest/api/3/issue/TEST-123/attachments
		// below code gets all fields of the issue.
		String response=given().pathParam("key", "10003").log().all().filter(session).
				when().get("/rest/api/2/issue/{key}").
				then().log().all().
				extract().response().asString();
		System.out.println(response);*/


		//Limiting o/p fields using query parameter--to get only required fields, use query parameter.
		// path parameter--to reroute to sub resource..... query parameter--to filter(drill down) in the fetched results
		String filteredResponse=given().pathParam("key", "10003").
				queryParam("fields", "comment").
				log().all().filter(session).
				when().get("/rest/api/2/issue/{key}").
				then().log().all().
				extract().response().asString();
		System.out.println("Comments fields= "+filteredResponse);

		JsonPath js=new JsonPath(filteredResponse);
		int CommentsCount=js.getInt("fields.comment.comments.size()");
		System.out.println("Comments Count= "+CommentsCount);
		System.out.println("Id of comment added through this script= "+ commentId);
		for(int i=0;i<CommentsCount;i++)
		{
			int commentIdIssue=js.getInt("fields.comment.comments["+i+"].id");
			System.out.println("commentIdIssue= "+commentIdIssue);
			
			if(commentIdIssue==commentId)
			{
				String commentFetched=js.get("fields.comment.comments["+i+"].body").toString();
				System.out.println("Comment fetched= "+commentFetched);
				Assert.assertEquals(commentFetched, Payload.CommentToAdd);
				break;
			}
		}
	}
}
