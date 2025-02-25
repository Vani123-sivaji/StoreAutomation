package api.test;


import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
    public void testPostCreateorder(int id, int petId, int quantity, Date shipDate, String status, boolean complete) {
        // Create a new User object
        User userPayload = new User();

        // Set the userPayload fields with the test data provided by the DataProvider
        userPayload.setId(id);          // Use the provided 'id'
        userPayload.setPetId(petId);    // Use the provided 'petId'
        userPayload.setQuantity(quantity); // Use the provided 'quantity'
        userPayload.setShipDate(shipDate); // Use the provided 'shipDate'
        userPayload.setStatus(status);   // Use the provided 'status'
        userPayload.setComplete(complete); // Use the provided 'complete'

        // Call the UserEndPoints method to create an order
        Response response = UserEndPoints.CreateanOrderforaPet(userPayload);

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 200);
    }
	
	@Test(priority=2, dataProvider="id", dataProviderClass=DataProviders.class)
	
	public void testDeleteorder(int id)
	{
			Response response=UserEndPoints.deleteorder(id);
			Assert.assertEquals(response.getStatusCode(),200);	
	
	}
	
	
	
	
}


