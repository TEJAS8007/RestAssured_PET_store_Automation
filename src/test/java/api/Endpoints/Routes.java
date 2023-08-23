package api.Endpoints;
/*
 * post : https://petstore.swagger.io/v2/user
 * get : https://petstore.swagger.io/v2/user/{username}
 * put : https://petstore.swagger.io/v2/user/{username}
 * delete : https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {

	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module Url's
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";

	//store Module
	
	public static String post_url1=base_url+"/store/order";
	public static String get_url1=base_url+"/store/order/{orderId}";
	public static String delete_url1="https://petstore.swagger.io/v2/store/order/3";
	
	
}
