package api.tests;

import org.testng.annotations.Test;

import api.Endpoints.UserEndpoints;
import api.Payloads.User;
import api.Utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	User userPayload;
	
	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void dpTest01(String id,String username,String firstName,String lastName,String email,String pwd,String ph)
	{
	    userPayload=new User();
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response res=UserEndpoints.CreateUser(userPayload);
		res.then().log().all();

	}
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testgetUser(String username)
	{
		Response res=UserEndpoints.GetUser(username);
	    res.then().log().all();
	}
	
	@Test(priority = 3,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username)
	{
		Response res=UserEndpoints.DeleteUser(username);
	    res.then().log().all();
	}
}
