//package api.test;
//
////import org.testng.annotations.Test;
//import org.testng.annotations.BeforeClass;
//import org.testng.AssertJUnit;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.github.javafaker.Faker;
//
//import api.endpoints.UserEndPoints;
//import api.endpoints.UserEndPointsWithPropertiesFile;
//import api.payload.User;
//import io.restassured.response.Response;
//
//public class UserTestsWithPropertiesFile {
//
//	User userPayload;
//	Faker faker;
//	public Logger logger;
//
//	@BeforeClass
//	public void setup() {
//		userPayload = new User();
//		faker = new Faker();
//
//		userPayload.setId(faker.idNumber().hashCode());
//		userPayload.setUserName(faker.name().username());
//		userPayload.setFirstName(faker.name().firstName());
//		userPayload.setLastName(faker.name().lastName());
//		userPayload.setEmail(faker.internet().emailAddress());
//		userPayload.setPassword(faker.internet().password(5, 10));
//		userPayload.setPhone(faker.phoneNumber().cellPhone());
//
//		// logs
//		logger = LogManager.getLogger(this.getClass());
//	}
//
//	@Test(priority = 1)
//	public void testPostUser() {
//		logger.info("############# Creating User #############");
//
//		Response response = UserEndPointsWithPropertiesFile.createUser(userPayload);
//		System.out.println("Username in post==>" + userPayload.getUserName());
//		response.then().log().all();
//		Assert.assertEquals(response.statusCode(), 200);
//
//		logger.info("############# User Created #############");
//	}
//
////	@Test(priority = 2)
//	public void testGetUserByUserName() {
//		logger.info("############# Getting user info #############");
//		Response response = UserEndPointsWithPropertiesFile.readUser(userPayload.getUserName());
//		System.out.println("Username==>" + userPayload.getFirstName());
//		response.then().log().all();
//		Assert.assertEquals(response.getStatusCode(), 200);
//		logger.info("############# User info is displayed #############");
//	}
//
//	@Test(priority = 2)
//	public void testUpdateUser() {
//		// Change data
//
//		logger.info("############# Updating User #############");
//		userPayload.setFirstName(faker.name().firstName());
//		userPayload.setLastName(faker.name().lastName());
//		userPayload.setEmail(faker.internet().emailAddress());
//
//		// Update data in Put call
//		Response response = UserEndPointsWithPropertiesFile.updateUser(userPayload.getUserName(), userPayload);
//		System.out.println("Username in put==>" + userPayload.getFirstName());
//		response.then().log().body();
//		Assert.assertEquals(response.getStatusCode(), 200);
//
//		logger.info("############# User updated #############");
//
//		// Checking data after update
////		Response responseAfterUpdate = UserEndPoints.readUser(userPayload.getUserName());
////		logger.debug("debugging......");
////		responseAfterUpdate.then().statusCode(200);
//	}
//
////	@Test(priority = 3)
//	public void testDeleteUser() {
//		logger.info("############# Deleting User #############");
//		Response response = UserEndPointsWithPropertiesFile.deleteUser(userPayload.getUserName());
//		response.then().log().body().statusCode(200);
//		Assert.assertEquals(response.getStatusCode(), 200);
//		logger.info("############# User deleted #############");
//	}
//
//}
