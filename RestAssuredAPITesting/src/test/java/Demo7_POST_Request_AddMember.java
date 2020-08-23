import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Demo7_POST_Request_AddMember {
	
	@Test
	void AddMember(){
		
		//Specify baseURI
		RestAssured.baseURI = "https://reqres.in";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Add the member data to send with the request
		JSONObject js = new JSONObject();
		
		js.put("name", "devesh");
		js.put("job", "member");
		
		httprequest.headers("Content-Type","application/json");
		
		httprequest.body(js.toJSONString());
		
		//Response Object
		Response response = httprequest.request(Method.POST,"/api/users");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);
		
		Assert.assertEquals(responseBody.contains("devesh"),true);
		Assert.assertEquals(responseBody.contains("member"),true);
		
		
	}

}
