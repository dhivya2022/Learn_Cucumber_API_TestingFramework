package com.learning.cuke.steps;

import org.testng.Assert;

import com.learning.cuke.APIs.OrderAPI;
import com.learning.cuke.base.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PayPalSteps {

	@Before
	public void setup() {

		BaseTest.init();
	}

	@Given("I want to get access token from PayPal api")
	public void I_want_to_get_access_token_from_PayPal_api() {
		OrderAPI.getAccessToken();
	}

	// Method name can be anything
	@When("I set currency code as {string} and value as {string}")
	public void setCurrencyCodeAndValue(String currencyCode, String currencyValue) {
		System.out.println("Code: " + currencyCode);
		System.out.println("Value: " + currencyValue);

		BaseTest.response = OrderAPI.createOrder(currencyCode, currencyValue);

	}

	@And("I verify the status as CREATED")
	public void verifyStatusAsCreated() {

		Assert.assertEquals(BaseTest.response.jsonPath().get("status"), "CREATED");
	}

	@When("I get order from the paypal api")
	public void getOrderFromPayPalAPI() {
		BaseTest.response = OrderAPI.getOrderDetails();
	}

	@And("I verify the status code as {string}")
	public void verifyStatusCode(String statusCode) {
		Assert.assertEquals(BaseTest.response.getStatusCode(), statusCode);

	}

}
