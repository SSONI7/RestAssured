import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_Request {
	

	@Test
	void UnkownListDetails() {
		
		//specify the baseUri
		RestAssured.baseURI = "https://reqres.in/api/unknown";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET);
		
		// Print the respone in the console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :-" +responseBody);
		
		
		// Get the status code
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :- "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// Get the status line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is :- "+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		
		
	}

}
