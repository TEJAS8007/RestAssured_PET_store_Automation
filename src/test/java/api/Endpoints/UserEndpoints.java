package api.Endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import api.Payloads.StoreUser;
import api.Payloads.User;
import io.restassured.http.ContentType;
public class UserEndpoints {

	public static Response CreateUser(User Payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)

				.when()
				.post(Routes.post_url);

		return response;
	}

	public static Response GetUser(String userPayload)
	{
		Response response=given()
				.pathParam("username",  userPayload)
				.accept(ContentType.JSON)

				.when()
				.get(Routes.get_url);

		return response;
	}
	
	public static Response UpdateUser(User Payload,String username)
	{
		Response response=given()
				.pathParam("username",  username)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(Payload)

				.when()
				.put(Routes.put_url);

		return response;
	}

	public static Response DeleteUser(String username)
	{
		Response response=given()
				.pathParam("username",  username)
				.accept(ContentType.JSON)

				.when()
				.delete(Routes.delete_url);

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
