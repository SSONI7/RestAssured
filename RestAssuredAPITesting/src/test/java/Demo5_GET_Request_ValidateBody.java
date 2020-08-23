import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo5_GET_Request_ValidateBody {
	
	@Test
	void ValidateBody() {
		
		//specify baseuri
		RestAssured.baseURI = "https://reqres.in";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//response object
		Response response = httprequest.request(Method.GET,"/api/unknown/2");
		
		// Print the respone in the console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);
		
		Assert.assertEquals(responseBody.contains("StatusCode Weekly"),true);
	}

}
