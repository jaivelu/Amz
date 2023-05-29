package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;


/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to booking confirmation page locator and business logic
 *
 */
public class BookingConfirmationPage extends BaseClass {
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id = "order_no")
	public WebElement bookingNumber;
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement txtBookConfirmation;

	public WebElement getTxtBookConfirmation() {
		return txtBookConfirmation;
	}

	public WebElement getBookingNumber() {
		return bookingNumber;
	}
	
	
	/**
	 * 
	 * @return String
	 * @see business logic for get the confirm order id of hotel booking
	 */
	
	public String confirmBookingOrder() {
		
	String attributemethod = getAttributemethod(getBookingNumber());
	return attributemethod;

	}
	
	
	
	
	

}
