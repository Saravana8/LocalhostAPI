package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_GET_Request {
	
	@Test
	void retriveData()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/users");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :"+responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.statusLine();
		System.out.println("Status line is :"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
