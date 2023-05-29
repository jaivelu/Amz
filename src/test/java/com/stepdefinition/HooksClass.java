package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to maintain the browser,url intialize screenshot for failed scenario business logic
 *
 */

public class HooksClass extends BaseClass {
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see launching the browser and load url
	 */
	
	@Before
	public void BeforeMethod() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		loadurl(getPropertyFileValue("url"));
		maximize();
		implicitwait();
	}
	
	/**
	 * 
	 * @param sce
	 * @see take screenshot and quit browser
	 */

	@After
	public void afterMethod(Scenario sce) {
		if (sce.isFailed()) {
			sce.attach(screenshot(), "images/png", "Every after success ");
		}
		quitbrowser();

}
}