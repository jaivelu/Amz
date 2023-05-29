package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to maintain cancel hotel page business logic steps
 *
 */
public class TC5_CancelBooking extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * @see user should cancel booking with gendreate order id
	 */

	@Then("User should cancel gendreate order id")
	public void userShouldCancelGendreateOrderId() {
		pom.getCancelBookingPage().clickBookIterate(pom.getBookingConfirmationPage().confirmBookingOrder());

	}
	
	/**
	 * 
	 * @param expectedMsgHotelCancel
	 * @see verify the cancel booking message
	 */
	@Then("User should after cancelled order id success message {string}")
	public void userShouldAfterCancelledOrderIdSuccessMessage(String expectedMsgHotelCancel) {
		
		Assert.assertEquals("verify success msg", expectedMsgHotelCancel,
				getTextmethod(pom.getCancelBookingPage().getMsgHotelCancel()));

	}
	
	/**
	 * 
	 * @param orderID
	 * @see user should cancel booking with existing order id
	 */

	@Then("User should cancel existing order id {string}")
	public void userShouldCancelExistingOrderId(String orderID) {

		
		pom.getCancelBookingPage().clickBookIterate(orderID);
	}





}
