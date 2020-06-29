package restassured;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import restassured.UtilityClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_DataDrivern {
	
	@Test(dataProvider="bulk")
	void multiData(String s1,String s2, String s3) {
RestAssured.baseURI="http://localhost:3000/";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject js=new JSONObject();
		js.put("firstName", s1);
		js.put("lastName", s2);
		js.put("email", s3);
		
		httpRequest.header("content-Type", "application/json");
		httpRequest.body(js.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/users");
		
		System.out.println(response.getBody().asString());
	}
	
	@DataProvider(name="bulk")
	public String[][] getData() throws IOException{
		
		String path="C:\\Users\\sadhana\\Downloads\\LocalHost.xlsx";
		int rowCount = UtilityClass.getRowCount(path, "sheet1");
		int cellCount = UtilityClass.getCellCount(path, "sheet1", 1);
		
		String empData[][]=new String[rowCount][cellCount];
		
		for (int i=1; i<=rowCount; i++) {
			
			for(int j=0; j<cellCount; j++) {
				empData[i-1][j] = UtilityClass.getCellData(path, "sheet1", i, j);
			}
			
		}
		
		return empData;
	}
}
