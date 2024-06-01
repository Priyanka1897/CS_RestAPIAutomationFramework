package RestAssuredTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test_DeleteMethod {

	@Test
	
	public void test3() {
		
		
		baseURI="https://reqres.in/api/users/2";
		given()
		.when().delete()
		.then().statusCode(204).log().all();
		
		
	}
}
