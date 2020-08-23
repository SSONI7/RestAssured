import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2_POST_Request {

	@Test
	void CreateUser() {
		
		//Specify the BaseURI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request Payload sending along with post request
		JSONObject js = new JSONObject();
		
		//Put the values which are in json formate
		js.put( "name","morpheus");
		js.put("job", "leader");
		
		//Create header
		httprequest.header("Content-Type","application/json");
		
		//Attach the values to the request
		httprequest.body(js.toJSONString());
		
		//Response Object
		Response response = httprequest.request(Method.POST);
		
		//Get the response body
		String responseBody = response.asString();
		System.out.println("Response Body is :- "+responseBody);
		
		//Get the response code
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :- "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		
	}
	
}
