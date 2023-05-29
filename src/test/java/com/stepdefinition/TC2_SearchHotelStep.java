package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to maintain search hotel page business logic steps
 *
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom=new PageObjectManager();
	
	/**
	 * 
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param noOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsperRoom
	 * @param childPerRoom
	 * @see user select all field
	 */
	
	
	@Then("User should search hotel with enter {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelWithEnterAnd(String location, String hotel, String roomType, String noOfRoom, String checkInDate, String checkOutDate, String adultsperRoom, String childPerRoom) {

		pom.getSearchHotelPage().searchHotelAllField(location, hotel, roomType, noOfRoom, checkInDate, checkOutDate, adultsperRoom, childPerRoom);
	}
	
	/**
	 * 
	 * @param expectedTxtSelectHotel
	 * @see verify navigate to select hotel
	 */
	
	@Then("User should verify after search hotel its navigate to success {string}")
	public void userShouldVerifyAfterSearchHotelItsNavigateToSuccess(String expectedTxtSelectHotel) {

		Assert.assertEquals("verify after search hotel", expectedTxtSelectHotel, getTextmethod(pom.getSelectHotelPage().getTxtSearchHotel()));
	}

	/**
	 * 
	 * @param location
	 * @param noOfRooms
	 * @param checkIn
	 * @param checkOut
	 * @param adultPerRoom
	 * @see select only mandatory fields
	 */
	
	@Then("User should search hotel with enter mandatory {string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelWithEnterMandatoryAnd(String location, String noOfRooms, String checkIn, String checkOut, String adultPerRoom) {

		pom.getSearchHotelPage().mandatoryfields(location, noOfRooms, checkIn, checkOut, adultPerRoom);
	}
	
	/**
	 * 
	 * @param expectedCheckINErr
	 * @param expectedCheckOutErr
	 * @see veify date error message
	 */
	@Then("User should verify after search hotel error message {string},{string}")
	public void userShouldVerifyAfterSearchHotelErrorMessage(String expectedCheckINErr, String expectedCheckOutErr) {

		Assert.assertEquals("Verify CheckIn Error msg", expectedCheckINErr, getTextmethod(pom.getSearchHotelPage().getErrCheckIn()));
		Assert.assertEquals("Verify CheckOut Error msg", expectedCheckOutErr, getTextmethod(pom.getSearchHotelPage().getErrCheckOut()));
	}
	
	/**
	 * @see select without enter the all fields 
	 */

	@Then("User should search hotel without enter the all fields")
	public void userShouldSearchHotelWithoutEnterTheAllFields() {

		pom.getSearchHotelPage().clicksearch();
	}
	
	/**
	 * 
	 * @param expectedLocationErr
	 * @see verify error message
	 */
	@Then("User should verify after search hotel error message {string}")
	public void userShouldVerifyAfterSearchHotelErrorMessage(String expectedLocationErr) {

		Assert.assertEquals("Verify select loctaion Error msg", expectedLocationErr, getTextmethod(pom.getSearchHotelPage().getWithoutSelectSearchHotelErrorMsg()));
		
	}







	

}
