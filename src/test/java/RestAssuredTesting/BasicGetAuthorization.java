package RestAssuredTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicGetAuthorization {
	
	@Test
	public void Basicauth() {

		RequestSpecification requestspec= RestAssured.given();
		requestspec.baseUri("https://httpbin.org");
		requestspec.basePath("/basic-auth/priyanka/priyanka");
		//perform get request
		//non preemptive type
		Response response =requestspec.auth().basic("priyanka", "priyanka").get();
		//print status line
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Responsne status:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());	
		
		//preemptive type
		Response response1 =requestspec.auth().preemptive().basic("priyanka", "priyanka").get();

		//print status line
		Assert.assertEquals(response1.statusCode(), 200);
		System.out.println("Responsne status:" + response1.statusLine());
		System.out.println("Response body:" + response1.body().asString());
	}

}
