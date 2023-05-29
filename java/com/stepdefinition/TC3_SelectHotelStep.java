package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Then;


	/**
	 * 
	 * @author Jayavel
	 * @date 03-10-2022
	 * @see used to maintain select hotel page business logic steps
	 *
	 */
	public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	
	/**
	 * @see user select hotel and continue 
	 */
	@Then("User should select a hotel name")
	public void userShouldSelectAHotelName() {
		pom.getSelectHotelPage().selectBtn();

	}
	
	/**
	 * 
	 * @param expectedTxtBookHotel
	 * @see verify navigate to book hotel
	 */
	
	@Then("User should verify after select hotel its navigate to success {string}")
	public void userShouldVerifyAfterSelectHotelItsNavigateToSuccess(String expectedTxtBookHotel) {

		Assert.assertEquals("Verify after seleced the hotel", expectedTxtBookHotel,
				getTextmethod(pom.getBookHotelPage().getTxtBookHotel()));
	}

	/**
	 * @see user click continue without select hotel
	 */
	
	@Then("User should click continue without select hotel name")
	public void userShouldClickContinueWithoutSelectHotelName() {

		pom.getSelectHotelPage().withoutSelectClick();
	}
	
	/**
	 * 
	 * @param expectedErrSelectHotel
	 * @see verify book hotel error message
	 */
	@Then("User should verify after select hotel error msg {string}")
	public void userShouldVerifyAfterSelectHotelErrorMsg(String expectedErrSelectHotel) {

		Assert.assertEquals("Verify err msg select hotel", expectedErrSelectHotel,
				getTextmethod(pom.getSelectHotelPage().getErrSelecthotel()));
		
	}



	
}
