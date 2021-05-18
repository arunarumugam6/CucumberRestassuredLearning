package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Payload;


public class crudoperations {

	static Response response;
	//static RequestSpecification reqspec;
	static String URL = "https://reqres.in/api/login";
	
	public static Response performPostCall(String apiName) {
		
		if(apiName.equalsIgnoreCase("LoginAPI")) {
		
			System.out.println("Sending POST request to: "+URL+" service");
			response = RestAssured
					.given()
					.body(Payload.loginPayload())
			        .when().post(URL)
				    .then()
				    .extract().response();
	}
		return response;
	
	}
	
	
	
	
}
	

