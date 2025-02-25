package api.payload;

import java.util.Date;

public class User {
	  private int id;
	    private int petId;
	    private int quantity;
	    private Date shipDate; // Change this to Date
	    private String status;
	    private boolean complete=true;

    
   
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getPetId() {
	        return petId;
	    }

	    public void setPetId(int petId) {
	        this.petId = petId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public Date getShipDate() {
	        return shipDate;
	    }

	    public void setShipDate(Date shipDate) { // Change parameter type to Date
	        this.shipDate = shipDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public boolean isComplete() {
	        return complete;
	    }

	    public void setComplete(boolean complete) {
	        this.complete = complete;
	    }
	

}
