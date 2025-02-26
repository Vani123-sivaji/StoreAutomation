package api.test;

import com.github.javafaker.Faker;

import api.payload.Pet;
import java.io.File; 
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import com.github.javafaker.Faker;
import api.endpoints.PetEndPoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tag;
import io.restassured.response.Response;
public class PetsTest {
	Faker faker;
    Pet petPayload;
    public Logger logger;
	private int id; // For logs
 
    @BeforeClass
    public void setup() {
        faker = new Faker();
        petPayload = new Pet();
 
        // Creating test data using Faker
        Category category = new Category();
        category.setId(faker.number().numberBetween(1, 100));
        category.setName(faker.animal().name());
 
        Tag tag = new Tag();
        tag.setId(faker.number().randomDigit());
        tag.setName(faker.color().name());
 
        petPayload.setId(faker.number().numberBetween(1000, 9999));
        petPayload.setCategory(category);
        petPayload.setName(faker.dog().name());
        petPayload.setPhotoUrls(Collections.singletonList(faker.internet().url()));
        petPayload.setTags(Collections.singletonList(tag));
        petPayload.setStatus(faker.options().option("available","adopted","pending"));
       // petPayload.setStatus("available");
        // Logs
        logger = LogManager.getLogger(this.getClass());
        logger.debug("Debugging.....");
    }
 
    @Test(priority = 1)
    public void testPostPets() {
        logger.info("********** Creating pet ***************");
        Response response = PetEndPoints.createPets(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("********** Pet is created ***************");
    }
 
   @Test(priority = 2)
    public void testPostPetsUpload() {
        logger.info("********** Uploading pet image ***************");
 
        // Get pet ID from payload
        int id = this.petPayload.getId();
        System.out.println("Uploading image for Pet ID: " + id); // Debugging
 
        // ✅ Correct File Path (Update path if necessary)
        String filePath = "C:/Users/HP/Pictures/krishna.jpg";  
        File imageFile = new File(filePath);
 
        // ✅ Ensure file exists before uploading
        if (!imageFile.exists()) {
            throw new RuntimeException("File does not exist at path: " + filePath);
        }
 
        // ✅ Upload pet image
        Response response = PetEndPoints.UploadPetImage(id, imageFile);
        response.then().log().all();
 
        // ✅ Assert status code
        Assert.assertEquals(response.getStatusCode(), 200, "Image upload failed!");
 
        logger.info("********** Pet image uploaded successfully ***************");
    }
   
   
   @Test(priority=3)
   
	public void testreadPet()

	{

		logger.info("********** Reading Pet Info ***************");

		Response response=PetEndPoints.readPet(this.petPayload.getId());

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);

		logger.info("**********Pet info  is displayed ***************");

	}
   
   
   @Test(priority = 4)
   public void testPutPets() {
       logger.info("********** Creating pet ***************");
       Category category = new Category();
       category.setId(faker.number().numberBetween(1, 100));
       category.setName(faker.animal().name());

       Tag tag = new Tag();
       tag.setId(faker.number().randomDigit());
       tag.setName(faker.color().name());

       petPayload.setId(faker.number().numberBetween(1000, 9999));
       petPayload.setCategory(category);
       petPayload.setName(faker.dog().name());
       petPayload.setPhotoUrls(Collections.singletonList(faker.internet().url()));
       petPayload.setTags(Collections.singletonList(tag));
       petPayload.setStatus(faker.options().option("available","Adopted","Pending"));

       Response response = PetEndPoints.updatePets(petPayload);
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
       logger.info("********** Pet is created ***************");
   }
   
   
   @Test(priority=5)
   
  	public void testgetpetbystatus()

  	{

  		logger.info("********** Reading Pet Info ***************");
  		
  		petPayload.setStatus(faker.options().option("available","adopted","pending"));
  		
  		Response response=PetEndPoints.getPetbystatus(this.petPayload.getStatus());

  		response.then().log().all();

  		Assert.assertEquals(response.getStatusCode(),200);

  		logger.info("**********Pet info  is displayed ***************");

  	}
   @Test(priority = 6)
   public void testDeletePets() {
	   
       logger.info("********** Delete pet ***************");
       Response response = PetEndPoints.DeletePet(this.petPayload.getId());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
       logger.info("********** pet is deleted ***************");
   }
  
    
}
	
	
	
	

