package api.endpoints;

/*
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
*/

public class Routes {
	
	public static String base_Url = "https://petstore.swagger.io/v2";
	
	// User model
	public static String post_Url = base_Url + "/user";
	public static String get_Url = base_Url + "/user/{username}";
	public static String put_Url = base_Url + "/user/{username}";
	public static String delete_Url = base_Url + "/user/{username}";
	

}
