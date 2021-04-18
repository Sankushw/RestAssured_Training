package Step_definition;

import java.io.IOException;

import io.cucumber.java.Before;
import io.restassured.path.json.JsonPath;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException{
//this hook ois created to handle scenario when only DeletePlace API is run---we creat object of Step definition class and resue methods
		Definition def=new Definition();
		if(Definition.PlaceId==null){
			def.add_place_payload_with("Sanjay Residence", "Eng", "Lalganj, Lucknow,U.P");
			def.user_calls_with_https_request("addPlaceAPI", "POST");
			def.verify_place_created_maps_to_using("Sanjay Residence","getPlaceAPI");

		}
	}
}
