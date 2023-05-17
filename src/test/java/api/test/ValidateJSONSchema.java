package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ValidateJSONSchema {

	User userPayload;
	Faker faker;

	@BeforeClass
	public void setup() {
		userPayload = new User();
		faker = new Faker();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUserName(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test
	public void testSchemaPostUser() {
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/postSchema.json"))
				.statusCode(200).body("type", equalTo("unknown"));
	}
}
