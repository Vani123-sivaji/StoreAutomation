package api.endpoints;
 
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;
 
import com.github.javafaker.File;
 
import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 
public class PetEndPoints {
	// method created for getting URL's from properties file
		static ResourceBundle getURL()
		{
			ResourceBundle routes= ResourceBundle.getBundle("routes"); // Load properties file  // name of the properties file
			return routes;
		}
 
		
 
		public static Response createPets(Pet Payload) {
           String postpets_url=getURL().getString("PostPet_url");

			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
			.when()
				.post(postpets_url);
			return response;
		}
		public static Response UploadPetImage(int id, java.io.File imageFile) {
			String poststore_url=getURL().getString("PostuploadImage_url");
			Response response=given()
		        .pathParam("id", id)  // Ensure id is correctly passed
		        .multiPart("file", imageFile)
		        .header("Content-Type", "multipart/form-data")
		    .when()
		      		    .post(poststore_url);
			return response;
			/*from routes.java class if we wan to pass
			public static Response UploadPetImage(int id, File file) {
			    return given()
			        .pathParam("id", id)  // Ensure ID is correctly passed
			        .multiPart("file", file)
			        .header("Content-Type", "multipart/form-data")
			    .when()
			        .post(Routes.PostuploadImage_url); // Ensure this contains "/pet/{id}/uploadImage"
			}*/
		}
		public static Response readPet(int id)
		{
		
			Response response=given()
					.pathParam("id", id)
					
					.when()
					.get(routes.getpetId_url);
				
				return response;
			
		}
		
		public static Response updatePets(Pet Payload) {
	         
			   // Update the age if needed
				Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(Payload)
					
				.when()
				.put(routes.putpet_url);
				
				return response;
				
				   
}
		public static Response getPetbystatus(String status)
		{
		
			Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("Status", status)
					
					.when()
					.get(routes.getPetStatus_url);
				
				return response;
			
		}
		public static Response DeletePet(int id)
		{
		
			Response response=given()
					.pathParam("id", id)
					
					.when()
					.delete(routes.deletepetId_url);
				
				return response;
			
		}
}
