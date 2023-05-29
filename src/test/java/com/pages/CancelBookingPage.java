package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Jayavel
 * @see used to cancel booking  locator and business logic
 *
 */
public class CancelBookingPage extends BaseClass{
	
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//a[@href='BookedItinerary.php']")
	private WebElement bookedItinerary;
	
	@FindBy (id = "order_id_text")
	private WebElement searchOrderIdTextBox;
	
	@FindBy (id = "search_hotel_id")
	private WebElement gobtn;
	
	@FindBy(xpath = "//input[contains(@value,'Cancel ')]")
	private WebElement btnCancel;
	
	
	
	
	@FindBy(id = "search_result_error")
	private WebElement msgHotelCancel;
	
	
	
	

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getMsgHotelCancel() {
		return msgHotelCancel;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getSearchOrderIdTextBox() {
		return searchOrderIdTextBox;
	}

	public WebElement getGobtn() {
		return gobtn;
	}
	
	
	
	
	
	
	
	////////////////////
	
	/**
	 * 
	 * @param orderId
	 * @see business logic for cancel hotel booking 
	 */
	
	
	public void clickBookIterate(String orderId) {

		btnClick(getBookedItinerary());
		setText(getSearchOrderIdTextBox(), orderId);
		btnClick(getGobtn());
		btnClick(getBtnCancel());
		acceptAlert();
		
		
	}
	
	
	
	
	
	

}
