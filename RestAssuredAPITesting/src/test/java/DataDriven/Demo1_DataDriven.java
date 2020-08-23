package DataDriven;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_DataDriven {
	
	@Test(dataProvider="saniket")
	void PostDataDriven(String ename, String ejob) {
		
		//Specify baseURI
				RestAssured.baseURI = "https://reqres.in";
				
				//Request Object
				RequestSpecification httprequest = RestAssured.given();
				
				//Add the member data to send with the request
				JSONObject js = new JSONObject();
				
				js.put("name", ename);
				js.put("job", ejob);
				
				// adding header stating that the request body is json
				httprequest.headers("Content-Type","application/json");
				
				//add json to the body of request
				httprequest.body(js.toJSONString());
				
				//Response Object
				Response response = httprequest.request(Method.POST,"/api/users");
				
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is :- "+responseBody);
		
		
	}
	
	@DataProvider(name = "saniket")
	String[][] getMember() throws IOException {
		
	   String file = "C:\\Users\\Saniket\\eclipse-workspace\\RestAssuredAPITesting\\src\\test\\java\\DataDriven\\DataFile.xlsx";
	   int rowcount = XlUtils.getRowCount(file, "Sheet1");
	   int colcount = XlUtils.getCellCount(file, "Sheet1",1);
	   
	   String [][] Member = new String[rowcount][colcount];
	   
	   for(int i=1;i<rowcount;i++) {
		   for(int j=0;j<colcount;j++) {
			     
			  Member[i-1][j] =XlUtils.getData(file, "Sheet1", i, j);
		   }
	   }
	   //String[][] member = {{"soni","member"},{"deshmukh","leader"},{"sharma","consultant"},{"namdeo","devloper"}};
		return(Member);
	}

}
