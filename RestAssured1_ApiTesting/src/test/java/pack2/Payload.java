package pack2;


public class Payload {
	static String CommentToAdd="I am adding comment From Rest Assured";
	public static String AddComment()
	{
		return "{\r\n" + 
				"    \"body\": \""+CommentToAdd+"\"\r\n" + 
				"}";


	}

	public static String LoginCredentials()
	{
		return "{ \"username\": \"sankushw\", \"password\": \"sUMMER1@\" }";

	}

}