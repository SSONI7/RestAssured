import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo4_GET_Request_PrintAllHeader {

	@Test
	void PrintAllHeader() {
		
		//Specify baseURI
		RestAssured.baseURI= "https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response Object
		
		Response response = httprequest.request(Method.GET,"/maps/api/place/nearbysearch/json\\r\\n\" + \r\n" + 
				"				\"  ?location=-33.8670522,151.1957362\\r\\n\" + \r\n" + 
				"				\"  &radius=500\\r\\n\" + \r\n" + 
				"				\"  &types=food\\r\\n\" + \r\n" + 
				"				\"  &name=harbour\\r\\n\" + \r\n" + 
				"				\"  &key=AIzaSyAaSiDqha6d1KS2kbeyfQ_zrZbDoGo8HGk");
		
		//Print response body in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);
		
		Headers header = response.getHeaders();
		
		for(Header hd:header) {
		
			System.out.println(hd.getName()+ " = " +hd.getValue());
	}
	
	
	}
}
