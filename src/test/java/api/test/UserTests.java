package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		
	faker=new Faker();
	userPayload=new User();
	
	 userPayload.setId(faker.idNumber().hashCode());
     userPayload.setPetId(faker.idNumber().hashCode());
     userPayload.setQuantity(faker.number().randomDigitNotZero()); // Generates a random number for quantity
     userPayload.setShipDate(faker.date().future(10, java.util.concurrent.TimeUnit.DAYS)); // Ship date within the next 10 days
     userPayload.setStatus(faker.options().option("Pending", "Shipped", "Delivered", "Cancelled")); // Random status
     userPayload.setComplete(faker.bool().bool()); // Random boolean value for 'complete'

	//logs
	logger=LogManager.getLogger(this.getClass());
	
	
	}
	public void testPostUser()
	{
		
		logger.info("********** Creating oreder  ***************");
		Response response=UserEndPoints.CreateanOrderforaPet(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********order is created  ***************");
}
	
	@Test(priority=2)
	
	public void testGetorderByid()
	{
		
		logger.info("********** Reading Order Info ***************");
		Response response=UserEndPoints.readOrder(this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**********Order info  is displayed ***************");
		
	}

	@Test(priority=3)
	public void testDeleteUserByorderid()
	{
		logger.info("**********   Deleting order  ***************");
	
	Response response=UserEndPoints.deleteorder(this.userPayload.getId());
	Assert.assertEquals(response.getStatusCode(),200);
	
	logger.info("********** order deleted ***************");
	
}

}
