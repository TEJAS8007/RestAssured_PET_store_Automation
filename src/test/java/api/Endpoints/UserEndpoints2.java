package api.Endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.Payloads.StoreUser;
import api.Payloads.User;
import io.restassured.http.ContentType;
public class UserEndpoints2 {

	// getting url from Properties File
	public static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	
	public static Response CreateUser(User Payload)
	{
		// get url from properties
		String post_url=getURL().getString("post_url");
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)

				.when()
				.post(post_url);

		return response;
	}

	public static Response GetUser(String userPayload)
	{
		String get_url=getURL().getString("get_url");
		
		Response response=given()
				.pathParam("username",  userPayload)
				.accept(ContentType.JSON)

				.when()
				.get(get_url);

		return response;
	}
	
	public static Response UpdateUser(User Payload,String username)
	{
		String put_url=getURL().getString("put_url");
		
		Response response=given()
				.pathParam("username",  username)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(Payload)

				.when()
				.put(put_url);

		return response;
	}

	public static Response DeleteUser(String username)
	{
		String delete_url=getURL().getString("delete_url");
		
		Response response=given()
				.pathParam("username",  username)
				.accept(ContentType.JSON)

				.when()
				.delete(delete_url);

		return response;
	}

	/*
	public static Response StorePost(StoreUser payload)
	{
		Response res= given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when().post(Routes.post_url1);
		
		return res;
	}
	
	public static Response storegetId(int orderid)
	{
		Response response=given()
		.accept(ContentType.JSON)
		.pathParam("orderId", orderid)
		
		.when().get(Routes.get_url1);
		
		return response;
	}
	
	public static Response storedeleteId()
	{
		Response res= given()
		.accept(ContentType.JSON)
		
		
		.when().delete(Routes.delete_url1);
		
		return res;
	}
	*/
}
