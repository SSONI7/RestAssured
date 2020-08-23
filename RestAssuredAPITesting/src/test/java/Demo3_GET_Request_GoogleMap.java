import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3_GET_Request_GoogleMap {
	
	@Test
	void GoogleMapTest() {
		
		//Spacify baseURI
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response Object
		Response response = httprequest.request(Method.GET,"/maps/api/place/nearbysearch/json\r\n" + 
				"  ?location=-33.8670522,151.1957362\r\n" + 
				"  &radius=500\r\n" + 
				"  &types=food\r\n" + 
				"  &name=harbour\r\n" + 
				"  &key=AIzaSyAaSiDqha6d1KS2kbeyfQ_zrZbDoGo8HGk");
		
		// Print the respone in the console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);
		
		//Validate the Content type
		String contentType = response.header("Content-Type");
		System.out.println("Content Type is :- "+contentType);
		Assert.assertEquals(contentType,"text/html; charset=UTF-8");
		
		//Validate the content length
		String contentLength = response.header("Content-Length");
		System.out.println("Content Length is :- "+contentLength);
		Assert.assertEquals(contentLength, "1783");
		
		
	}

}
