package RestAssuredTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicPostAuthorization {
	
	@Test
	public void Basicauth() {

		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("username", "priyanka1");
		jsonobject.put("password", "priyanka1");

		RequestSpecification requestspec= RestAssured.given()
				.baseUri("https://httpbin.org")
				.basePath("/basic-auth/priyanka/priyanka")
				.auth().basic("priyanka", "priyanka")
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.body(jsonobject.toJSONString());


				Response response = requestspec.post();
		response.then().log().all();

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());


		
	}

}
