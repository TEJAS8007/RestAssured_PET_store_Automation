package api.tests;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints;
import api.Endpoints.UserEndpoints2;
import api.Payloads.StoreUser;
import api.Payloads.User;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	Faker faker1;
	User userpayload;
	StoreUser StoreUserPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void generateTestData()
	{
		faker=new Faker();
		faker1=new Faker();
	    userpayload=new User();
	    StoreUserPayload=new StoreUser();
	
	    userpayload.setId(faker.idNumber().hashCode());
	    userpayload.setUsername(faker.name().username());
	    userpayload.setFirstName(faker.name().firstName());
	    userpayload.setLastName(faker.name().lastName());
	    userpayload.setEmail(faker.internet().safeEmailAddress());
	    userpayload.setPassword(faker.internet().password());
	    userpayload.setPhone(faker.phoneNumber().cellPhone());
	  
	    StoreUserPayload.setId(faker1.number().numberBetween(1,3));
	    StoreUserPayload.setPetId(faker1.idNumber().hashCode());
	    StoreUserPayload.setQuantity(faker1.number().randomDigit());
	    StoreUserPayload.setShipdate(faker1.date().toString());
	    
	    //logs
	    logger=LogManager.getLogger(this.getClass());
	    logger.debug("debugging ***********");
	}
	
	@Test(priority = 1)
	public void testCreateUser()
	{
		logger.info("*****Creating the User*****");

		Response res=UserEndpoints2.CreateUser(userpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200, "check for status code 200");
	}
	
	@Test(priority = 2)
	public void testgetUser()
	{
		logger.info("*****Getting  the User Data*****");
		Response res=UserEndpoints2.GetUser(this.userpayload.getUsername());
	    res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200, "check for status code 200");
	}
	
	@Test(priority = 3)
	public void testupdateUser()
	{
		logger.info("*****Updating  the User Data*****");
		Response res=UserEndpoints2.UpdateUser(userpayload,this.userpayload.getFirstName());
		System.out.println("After Update User Data");
	    res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200, "check for status code 200");
	}
	
	@Test(priority = 4)
	public void testDeleteUser()
	{
		logger.info("*****Deleting the User Data*****");

		Response res=UserEndpoints2.DeleteUser(this.userpayload.getUsername());
	    res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200, "check for status code 200");
	}

/*	
	@Test(priority = 5)
	public void storeUserpostTest()
	{
		
		Response res=UserEndpoints.StorePost(StoreUserPayload);
		res.then().log().all();
	}
	
	@Test(priority = 6)
	public void storeUsergetTest()
	{
		Response res=UserEndpoints.storegetId(this.StoreUserPayload.getId());
		res.then().log().all();
	}
	
	@Test(priority = 7)
	public void storeUserdeleteTest()
	{
	  
		Response res=UserEndpoints.storedeleteId();
		res.then().log().all();
	}
	*/
}
