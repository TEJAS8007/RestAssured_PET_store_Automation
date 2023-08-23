package api.Payloads;

public class StoreUser {
/*
	  "id": 0,
	  "petId": 0,
	  "quantity": 0,
	  "shipDate": "2023-08-21T12:06:01.659Z",
	  "status": "placed",
	  "complete": true
	*/
	
	private int id;
	private int petId;
	private int quantity;
	private String shipdate="2023-08-21T12:06:01.659Z";
	private String status="placed";
	private boolean complete =true;
	
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
	public String getShipdate() {
		return shipdate;
	}
	public void setShipdate(String shipdate) {
		this.shipdate = shipdate;
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
