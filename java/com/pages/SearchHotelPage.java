package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to search hotel page locator and business logic
 *
 */


public class SearchHotelPage extends BaseClass {
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy (id = "location")
	private WebElement location;
	
	@FindBy (id = "hotels")
	private WebElement hotel;
	
	@FindBy (id = "room_type")
	private WebElement roomType;
	
	@FindBy (id = "room_nos")
	private WebElement roomNUM;
	
	
	@FindBy (id = "datepick_in")
	private WebElement inDate;
	
	@FindBy (id = "datepick_out")
	private WebElement outDate;

	@FindBy (id = "adult_room")
	private WebElement Adultroom;
	
	@FindBy (id = "child_room")
	private WebElement childroom;
	
	
	@FindBy (id = "Submit")
	private WebElement btnclick;
	
	@FindBy (id = "username_show" )
	private WebElement loginSuccesMsg;
	
	@FindBy (id = "location_span" )
	private WebElement withoutSelectSearchHotelErrorMsg;
	
	@FindBy(id="checkin_span")
	private WebElement errCheckIn;
	
	@FindBy(id="checkout_span")
	private WebElement errCheckOut;
	
	

	
	
	
	

	public WebElement getErrCheckIn() {
		return errCheckIn;
	}

	public WebElement getErrCheckOut() {
		return errCheckOut;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNUM() {
		return roomNUM;
	}

	public WebElement getInDate() {
		return inDate;
	}

	public WebElement getOutDate() {
		return outDate;
	}


	public WebElement getAdultroom() {
		return Adultroom;
	}

	public WebElement getChildroom() {
		return childroom;
	}

	public WebElement getBtnclick() {
		return btnclick;
	}

	public WebElement getLoginSuccesMsg() {
		return loginSuccesMsg;
	}

	public WebElement getWithoutSelectSearchHotelErrorMsg() {
		return withoutSelectSearchHotelErrorMsg;
	}
	
	
	///////////////////
	
	/**
	 * 
	 * @param location
	 * @param noOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsperRoom
	 * @see business logic for common step in search hotel
	 */
	
	public void searchHotelCommonSteps(String location,String noOfRoom,String checkInDate,
			String checkOutDate, String adultsperRoom) {
		
		selectByText(getLocation(), location);
		selectByText(getRoomNUM(), noOfRoom);
		getInDate().clear();
		setText(getInDate(), checkInDate);
		getOutDate().clear();
		setText(getOutDate(), checkOutDate);
		selectByText(getAdultroom(), adultsperRoom);
	}
	
	/**
	 * @see business logic for common step in click search hotel
	 */
	public void clickSearchCommon() {
		
		btnClick(btnclick);

	}
	
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
	 * @see business logic for search hotel all fields
	 */
	
	public void searchHotelAllField(String location, String hotel, String roomType, String noOfRoom, String checkInDate, String checkOutDate, String adultsperRoom, String childPerRoom) {
	
		searchHotelCommonSteps(location,noOfRoom,checkInDate,checkOutDate,adultsperRoom);
		selectByText(getHotel(), hotel);
		selectByText(getRoomType(), roomType);
		selectByText(getChildroom(), childPerRoom);
		clickSearchCommon();
		
		
	}
	
	/**
	 * 
	 * @param location
	 * @param noOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsperRoom
	 * @see business logic for search hotel mandatory fields
	 */
	
	
	public void mandatoryfields(String location,String noOfRoom,String checkInDate,
			String checkOutDate, String adultsperRoom) {
		
		searchHotelCommonSteps(location,noOfRoom,checkInDate,checkOutDate,adultsperRoom);
		clickSearchCommon();

	}
	
	/**
	 * @see business logic for search hotel without enter fiels to clicksearch
	 */
	
	public void clicksearch() {
		clickSearchCommon();
		
	}
	
	
	
	
	
	
	
	
}






















