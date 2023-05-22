//package api.endpoints;
//
//import static io.restassured.RestAssured.given;
//
//import com.beust.jcommander.ResourceBundle;
//
//import api.payload.User;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//public class UserEndPointsWithPropertiesFile {
//	
//	// pulls url's from properties file
//	static ResourceBundle getURL() {
//		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load properties file. No need to mention path of properties file and file extension
//		return routes;
//	}
//
//	public static Response createUser(User payload) {
//		String post_Url = getURL().getString("post_url");
//		
//		Response response = given()
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.body(payload)
//		.when()
//			.post(post_Url);
//		
//		return response;
//	}
//	
//	public static Response readUser(String userName) {
//		String get_Url = getURL().getString("get_url");
//		
//		Response response = given()
//			.pathParam("username", userName)
//		.when()	
//			.get(get_Url);
//		
//		return response;
//	}
//	
//	public static Response updateUser(String userName, User payload) {
//		String put_Url = getURL().getString("put_url");
//		
//		Response response = given()
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.pathParam("username", userName)
//			.body(payload)
//		.when()	
//			.put(put_Url);
//		
//		return response;
//	}
//	
//	public static Response deleteUser(String userName) {
//		String delete_Url = getURL().getString("delete_url");
//		
//		Response response = given()
//			.pathParam("username", userName)
//		.when()	
//			.delete(delete_Url);
//		
//		return response;
//	}
//}
