package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utlities {

	int responseCode;

	public int validateResponseCode(Response response) {
		int responseCode = response.getStatusCode();
		return responseCode;
	}
	public static JsonPath validateResponsemessage(Response response) {

		JsonPath js = new JsonPath(response.getBody().asString());
		return js;

	}
}
