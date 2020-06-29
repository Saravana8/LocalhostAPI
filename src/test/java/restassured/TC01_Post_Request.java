package restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_Post_Request {
	
	@Test
	void createData() {
		
		RestAssured.baseURI="http://localhost:3000/";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject js=new JSONObject();
		
		js.put("firstName", "kural");
		js.put("lastName", "arasan");
		js.put("email", "kural2@gmail.com");
		
		
		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(js.toJSONString());

		Response response = httpRequest.request(Method.POST, "/users");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		
	}

}
