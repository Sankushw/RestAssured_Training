package enum_Resources;

public enum enumResourceAPI
{
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource=null;

	enumResourceAPI(String resource)
	{
		this.resource=resource;
	}

	public String getresource()
	{
		return resource;
	}
}
