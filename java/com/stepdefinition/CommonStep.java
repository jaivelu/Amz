package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to maintain all commonstep in step definition
 *
 */
public class CommonStep extends BaseClass {
	
	
	PageObjectManager pom = new PageObjectManager();
	
	
	/**
	 * 
	 * @param expectedWelcomemsg
	 * @see verify the login success message
	 */
	
	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expectedWelcomemsg) {
		
		Assert.assertEquals("Verify after login success", expectedWelcomemsg,
				getAttributemethod(pom.getSearchHotelPage().getLoginSuccesMsg()));

	}

}
