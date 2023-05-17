package api.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	 public void testPostUser(String id, String username, String fName, String lName, String email, String pass, String phone) {
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUserName(username);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(pass);
		userPayload.setPhone(phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
		Response response = UserEndPoints.deleteUser(username);
		response.then().log().body().statusCode(200);
	}

}
