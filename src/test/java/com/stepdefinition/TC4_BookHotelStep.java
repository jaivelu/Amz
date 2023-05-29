package com.stepdefinition;

import org.junit.Assert;
import com.baseclass.BaseClass;
import com.pageManager.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;


	/**
	 * 
	 * @author Jayavel
	 * @date 03-10-2022
	 * @see used to maintain book hotel page business logic steps
	 *
	 */

	public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	

	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 * @see user enter details and click book now
	 */
	
	@Then("User should book hotel with enter {string},{string} and {string}")
	public void userShouldBookHotelWithEnterAnd(String firstName, String lastName, String address, DataTable dataTable) {
	    
				pom.getBookHotelPage().selectBookAll(firstName, lastName, address, dataTable);
	}
	
	/**
	 * 
	 * @param expectedTxtBookConfirm
	 * @see verify navigate to booking confirmation page
	 */
	
	@Then("User should verify after book hotel its navigate to success {string}")
	public void userShouldVerifyAfterBookHotelItsNavigateToSuccess(String expectedTxtBookConfirm) {
		
		Assert.assertEquals("Error Book Cofirm", expectedTxtBookConfirm,
				getTextmethod(pom.getBookingConfirmationPage().getTxtBookConfirmation()));

	}
	
	/**
	 * @see user click booknow without given details
	 */
	
	@Then("User should click bookNow without select all feilds")
	public void userShouldClickBookNowWithoutSelectAllFeilds() {

			pom.getBookHotelPage().withoutSelectClick();
		
	}
	
	/**
	 * 
	 * @param expectedErrFN
	 * @param expectedErrLN
	 * @param expectedErrAddress
	 * @param expectedErrCardNo
	 * @param expectedErrCardType
	 * @param expectedErrExp
	 * @param expectedErrCvv
	 * @see verify all error messages in book hotel page
	 */
	
	@Then("User should verify after book hotel error msg {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterBookHotelErrorMsgAnd(String expectedErrFN, String expectedErrLN, String expectedErrAddress, String expectedErrCardNo, String expectedErrCardType, String expectedErrExp, String expectedErrCvv) {

		Assert.assertEquals("Error Firstname", expectedErrFN, getTextmethod(pom.getBookHotelPage().getErrorFirstName()));
		Assert.assertEquals("Error Lastname", expectedErrLN, getTextmethod(pom.getBookHotelPage().getErrorLastName()));
		Assert.assertEquals("Error Address", expectedErrAddress,
				getTextmethod(pom.getBookHotelPage().getErrorAddress()));
		Assert.assertEquals("Error Card No", expectedErrCardNo, getTextmethod(pom.getBookHotelPage().getErrorCreditCardNo()));
		Assert.assertEquals("Error Card Type", expectedErrCardType,
				getTextmethod(pom.getBookHotelPage().getErrorCreditCardType()));
		Assert.assertEquals("Error Expiry", expectedErrExp, getTextmethod(pom.getBookHotelPage().getErrorDateYear()));
		Assert.assertEquals("Error Card Cvv", expectedErrCvv, getTextmethod(pom.getBookHotelPage().getErrorCvv()));
		
	}






	
	
	
	
}
