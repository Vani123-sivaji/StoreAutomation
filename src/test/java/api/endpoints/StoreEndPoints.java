package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response CreateanOrderforaPet(User payload)
	{

		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(routes.post_url);
			
			return response;

}
	public static Response readOrder(int id)
	{
		Response response=given()
				.pathParam("id", id)
				
				.when()
				.get(routes.get_url);
			
			return response;
	}
	
	public static Response deleteorder(int id)
	{
		Response response=given()
				.pathParam("id", id)
				
				.when()
				.delete(routes.delete_url);
			
			return response;
	
	}
	
		
		
	}

