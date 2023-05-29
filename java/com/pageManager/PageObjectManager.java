package com.pageManager;

import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

/**
 * 
 * @author jayavel
 * @date 03-10-2022
 * @see used to maintain all pages object in pagefactorymanager
 *
 */


public class PageObjectManager extends BaseClass  {
	
	
	public PageObjectManager() {
		PageFactory.initElements(driver, this);
	}
	
	private LoginPage loginHotelPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private CancelBookingPage cancelBookingPage;
	
	/**
	 * 
	 * @return LoginPage
	 * @see used to create object for Loginpage if not create return the object
	 */
	
	public LoginPage getLoginHotelPage() {
		return (loginHotelPage==null)?loginHotelPage=new LoginPage():loginHotelPage;
	}
	
	/**
	 * 
	 * @return SearchHotelPage
	 * @see used to create object for SearchHotelPage if not create return the object
	 */
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage==null)?searchHotelPage=new SearchHotelPage():searchHotelPage;
	}
	
	/**
	 * 
	 * @return SelectHotelPage
	 * @see used to create object for SelectHotelPage if not create return the object
	 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)?selectHotelPage =new SelectHotelPage():selectHotelPage;
		}
	
	/**
	 * 
	 * @return BookHotelPage
	 * @see used to create object for BookHotelPage if not create return the object
	 */
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)?bookHotelPage=new BookHotelPage():bookHotelPage;
	}
	
	/**
	 * 
	 * @return BookingConfirmationPage
	 * @see used to create object for BookingConfirmationPage if not create return the object
	 */
	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage==null)?bookingConfirmationPage =new BookingConfirmationPage():bookingConfirmationPage;
	}
	
	/**
	 * 
	 * @return CancelBookingPage
	 * @see used to create object for CancelBookingPage if not create return the object
	 */
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage==null)?cancelBookingPage = new CancelBookingPage():cancelBookingPage;
	}

	
	

	
	

}
