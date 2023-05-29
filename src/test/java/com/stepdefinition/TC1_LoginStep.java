package com.stepdefinition;

import java.awt.AWTException;
import org.junit.Assert;
import com.baseclass.BaseClass;
import com.pageManager.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

	/**
	 * 
	 * @author Jayavel
	 * @date 03-10-2022
	 * @see used to maintain login page business logic steps
	 *
	 */
	public class TC1_LoginStep extends BaseClass {
	
	PageObjectManager pom =new PageObjectManager();
	
	/**
	 * @see user is on adactin page	
	 */
	@Given("User is on the Adactin page")
	public void userIsOnTheAdactinPage() {

	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @see user perform login
	 */
	
	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String username, String password) {

		pom.getLoginHotelPage().login(username, password);
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws AWTException
	 * @see user perform login with enter 
	 */
	
	@When("User should perform login {string},{string} with Enter key")
	public void userShouldPerformLoginWithEnterKey(String username, String password) throws AWTException {
			
		pom.getLoginHotelPage().loginwithEnterKey(username, password);
	}
	
	/**
	 * 
	 * @param loginErrorMsg
	 * @see user perform with invalid credential
	 */
	
	@Then("User should verify after login with invalid credential error msg contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMsgContains(String loginErrorMsg) {
					
						/// baseclassmethod
		
		Assert.assertTrue(getTextmethod(pom.getLoginHotelPage().getWithoutLoginErrorMsg()).contains(loginErrorMsg));
		
		
	}










}
