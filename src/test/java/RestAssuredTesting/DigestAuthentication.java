package RestAssuredTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DigestAuthentication {
	
	@Test
	public void Basicauth() {

		RequestSpecification requestspec= RestAssured.given();
		requestspec.baseUri("https://httpbin.org");
		requestspec.basePath("/digest-auth/undefined/priyanka/priyanka");
		//perform get request
		//non preemptive type
		Response response =requestspec.auth().digest("priyanka", "priyanka").get();
		//print status line
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Responsne status:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());	
		
	}

}
