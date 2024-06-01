package RestAssuredTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ClientAuthAuthentication {

	@Test
	
	public void Basicauthmethod() {
		
		RequestSpecification requestspec= RestAssured.given();
		requestspec.baseUri("https://data.gov.in/resource/location-wise-daily-ambient-air-quality-delhi-year-1987");
		requestspec.basePath("/resource/");
		
		requestspec.queryParam("Mumbai", "Maharashtra").queryParam("airtableKey", "579b464db66ec23bdd000001cdd3946e44ce4aad7209ff7b23ac571b");
		
		Response response = requestspec.get();
		System.out.println(response.body().asString());
		
	}
	
}
