package RestAssuredTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod {

	@Test
	
	public void test3() {
		
		JSONObject jsondata= new JSONObject();
		jsondata.put("name", "Prachi");
		jsondata.put("job", "QAA");
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RestAssured.given().header("Content-Type","application/json")
		.contentType(ContentType.JSON).
		body(jsondata.toJSONString())
		.when().put()
		.then().statusCode(200).log().all();
		
		
	}
}
