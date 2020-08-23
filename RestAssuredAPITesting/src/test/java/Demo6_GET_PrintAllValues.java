import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo6_GET_PrintAllValues {
	
	@Test
	void PrintValues() {
		
		//Specify BaseURI
		RestAssured.baseURI = "https://reqres.in";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET,"/api/unknown/2");
		
		//String responseBody = response.getBody().asString();
		//System.out.println("Response Body is :- " +responseBody);
		
		JsonPath path = response.jsonPath();
		
		System.out.println(path.get("data.id"));
		System.out.println(path.get("data.name"));
		System.out.println(path.get("data.year"));
		System.out.println(path.get("data.color"));
		System.out.println(path.get("data.pantone_value"));
		System.out.println(path.get("ad.company"));
		System.out.println(path.get("ad.url"));
		System.out.println(path.get("ad.text"));
		
		Assert.assertEquals(path.get("data.id"),2);
		Assert.assertEquals(path.get("data.name"),"fuchsia rose");
		
	}	

}
