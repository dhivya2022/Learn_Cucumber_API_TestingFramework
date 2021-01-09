package com.learning.cuke.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = "com.learning.cuke.steps", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RunCuke extends AbstractTestNGCucumberTests {

}

//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,glue="com.w2a.APITestingFramework.cuke.steps")
