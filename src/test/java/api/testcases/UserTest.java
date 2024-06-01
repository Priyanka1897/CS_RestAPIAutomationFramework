package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	user userPayload;
	public static Logger logger;

	@BeforeClass
	public void generateTestData() {
		faker= new Faker();
		userPayload =new user();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		logger = LogManager.getLogger(UserTest.class);
	}

	@Test(priority=1)

	public void testcreatemethod() {

		Response response = userendpoints.createuser(userPayload);

	
		//log

		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
      logger.info("Create Method executed");
	}

	@Test(priority=2)
	public void getuserdata() {

		Response response = userendpoints.Getuser(this.userPayload.getUsername());

		//log
		System.out.println("Read user data");
		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Get method executed");

	}

	@Test(priority=3)
	public void updateuserdata() {

		userPayload.setFirstName(faker.name().firstName());
		Response response = userendpoints.Updateuser(this.userPayload.getUsername(), userPayload);
		System.out.println("Update user data");
		//log

		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);

		//read data after update
		Response responseafterupdate = userendpoints.Getuser(this.userPayload.getUsername());
		System.out.println("After update user data");
		responseafterupdate.then().log().all();
		
		//log
		logger.info("Update method executed");
	}

	@Test(priority=4)
	public void Deleteuserdata() {


		Response response = userendpoints.Deleteuser(this.userPayload.getUsername());
		System.out.println("Delete user data");
		//log

		response.then().log().all();

		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Delete method executed");

	}





}
