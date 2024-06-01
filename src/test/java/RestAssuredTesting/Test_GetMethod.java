package RestAssuredTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test_GetMethod {

	@Test
	 public void test01() {
		
		Response response = get("https://petstore.swagger.io/v2/user/user1");
		System.out.println("Response status code" + response.getStatusCode());
		System.out.println("Response body" + response.getBody().asString());
		System.out.println("Response time" + response.getTime());
		System.out.println("Response content type" + response.getHeader("Content-Type"));
		
		//Validate status code
		
		int ExceptedStatusCode=404;
		int ActualStatusCode= response.getStatusCode();
		
		Assert.assertEquals(ExceptedStatusCode, ActualStatusCode);		
		
	}
	
	@Test
	public void test2() {

		baseURI ="https://petstore.swagger.io/v2/";
		given()
		.queryParam("user"," 1")
		.when().get().
		then().statusCode(404);


	}


}
