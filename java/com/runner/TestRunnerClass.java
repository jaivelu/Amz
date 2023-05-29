package com.runner;

import java.io.FileNotFoundException;

import java.io.IOException;
import org.junit.runner.RunWith;

import com.baseclass.BaseClass;
import com.reporting.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * @author Jayavel
 * @date 03-10-2022
 * @see Runner Class of Adactin Hotel project
 */


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources",stepNotifications=true,publish=true,
dryRun=false,glue="com.stepdefinition",monochrome=true,plugin = {"pretty","json:target\\output.json","json:target/cucumber-reports/cucumber.json"},
tags=("@Login"),snippets=SnippetType.CAMELCASE)




public class TestRunnerClass extends BaseClass{
	
	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @see used to create the jvm report after the test runner class of Adactin Hotel project
	 */
	
	public void afterClass() throws FileNotFoundException, IOException {
		
		Reporting.generateJvmReport(System.getProperty("user.dir")+getPropertyFileValue("jsonpath"));
		
		
	}
		
}		
	
