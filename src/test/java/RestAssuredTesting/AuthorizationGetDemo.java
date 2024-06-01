package RestAssuredTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationGetDemo {
	
	@Test
	public void Bearertoken() {
		//Create request specification
		RequestSpecification requestspec= RestAssured.given();
		requestspec.baseUri("https://gorest.co.in");
		requestspec.basePath("/public/v2/users/127115");
		
		/*JSONObject jsonobject= new JSONObject();
		jsonobject.put("name", "PriyankaJK");
		jsonobject.put("gender", "Female");
		jsonobject.put("email", "priyankajk18@gmail.com");
		jsonobject.put("status", "Active");*/
		
		String AuthToken ="Bearer 3312351f5abe4f1c7233b6614bbc34326b9c82155d18b00f42856a462c5af3a8";
		
		requestspec.header("Authorization",AuthToken);
		
		Response response =requestspec.get();
		
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Response status line " + response.getStatusLine());
		System.out.println("Response body " + response.body().asString());
	}

}
