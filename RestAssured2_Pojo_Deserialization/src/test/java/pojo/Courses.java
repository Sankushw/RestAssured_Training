package pojo;

import java.util.List;

public class Courses {
	private List<WebAutomation> webAutomation;
	private List<Api> api;
	private List<Mobile> mobile;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}


/*	POJO classes(Plain old java object)
	Serialization--converting java object to Request body(Payload).Implemented using POJO classes.(like encapsulation)--we use setters for this
	Deserialization--converting Response body to java object.--we use getters for this
	--need jackson and gson jars to use these features in Java project.
	--need JAXB library(jar) for Maven project.
	advantages:
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
