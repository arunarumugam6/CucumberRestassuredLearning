package stepdefinition;

import utilities.Utlities;
import utilities.crudoperations;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Loginvalidation {

	public Response response;
	public static JsonPath js;

	@Given("Trigger the {string} with {string} method with Username and Password")
	public void trigger_the_with_method_with_username_and_password(String apiName, String method) {
		if (method.equalsIgnoreCase("POST")) {
			response = crudoperations.performPostCall(apiName);
		}
	}

	@Then("Validate the status code {int} in the response")
	public void validate_the_status_code_in_the_response(Integer expectedResponsecode) {

		int expected = expectedResponsecode;
		int actualstatusCode = response.getStatusCode();
		Assert.assertEquals(actualstatusCode, expected);

	}

	@Then("validate the error response message {string} in the response")
	public void validate_the_error_response_message_in_the_response(String expectedtokenValue) {

		js = Utlities.validateResponsemessage(response);
		String tokenValue = js.getString("error");
		Assert.assertEquals(tokenValue, expectedtokenValue);
	}

}
