package com.learning.cuke.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.learning.cuke.utilities.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {

	public static Properties config = new Properties();
	public static FileInputStream fis;

	public static String client_id;
	public static String secret;

	// Using it in Steps to save the response of createOrder API

	// Global variable
	public static Response response;

	public static void init() {

		try {
			fis = new FileInputStream(Constants.Properties_Config);

			// fis = new
			// FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * RestAssured.baseURI = config.getProperty("baseURI"); client_id =
		 * config.getProperty("paypalClientID"); secret =
		 * config.getProperty("paypalSecret");
		 */

		RestAssured.baseURI = Constants.PayPal_BaseURI;
		client_id = Constants.PayPal_Client_ID;
		secret = Constants.PayPal_Secret;

	}

}
