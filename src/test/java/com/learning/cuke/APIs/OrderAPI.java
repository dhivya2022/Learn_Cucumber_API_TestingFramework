package com.learning.cuke.APIs;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import com.learning.cuke.base.BaseTest;
import com.learning.cuke.pojo.Orders;
import com.learning.cuke.pojo.PurchaseUnits;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderAPI extends BaseTest {

	// static String access_token;
	static String orderId;

	public static String getAccessToken() {

		String access_token = given().param("grant_type", "client_credentials").auth().preemptive()
				.basic(client_id, secret).post("v1/oauth2/token").jsonPath().get("access_token").toString();
		System.out.println("access_token: " + access_token);
		return access_token;
	}

	public static Response createOrder(String currencyCode, String currencyValue) {

		ArrayList<PurchaseUnits> listOfPurchaseUnits = new ArrayList<PurchaseUnits>();
		listOfPurchaseUnits.add(new PurchaseUnits(currencyCode, currencyValue));
		Orders order = new Orders("CAPTURE", listOfPurchaseUnits);

		Response response = given().contentType(ContentType.JSON).auth().oauth2(getAccessToken()).body(order)
				.post("v2/checkout/orders");

		// Using this orderId in getOrderDetails()
		orderId = response.jsonPath().get("id").toString();
		return response;
	}

	public static Response getOrderDetails() {
		Response response = given().contentType(ContentType.JSON).auth().oauth2(getAccessToken())
				.get("v2/checkout/orders/" + orderId);

		return response;
	}

}
