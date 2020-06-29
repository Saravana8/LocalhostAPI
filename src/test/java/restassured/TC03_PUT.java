package restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_PUT {
	
	@Test
	public void upate() {
		RestAssured.baseURI="http://localhost:3000/";
		
		RequestSpecification request=RestAssured.given();
		
		Response response = request.request(Method.DELETE,"/users/16");
		String body = response.getBody().asString();
		System.out.println(body);
		
		
	}
	
}
