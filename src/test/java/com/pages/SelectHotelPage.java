package com.pages;

import org.dom4j.swing.BranchTreeNode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to select hotel page  locator and business logic
 *
 */

public class SelectHotelPage extends BaseClass {
	
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id ="radiobutton_0")
	private WebElement btnclick;

	@FindBy (id ="continue")
	private WebElement btnclickcontinue;
	
	@FindBy (id ="reg_error")
	private WebElement withoutSelectHotelToClick;
	
	@FindBy(className="login_title")
	private WebElement txtSearchHotel;
	
	@FindBy(id="radiobutton_span")
	private WebElement errSelecthotel;
	
	
	
	public WebElement getErrSelecthotel() {
		return errSelecthotel;
	}

	public WebElement getTxtSearchHotel() {
		return txtSearchHotel;
	}

	public WebElement getBtnclick() {
		return btnclick;
	}

	public WebElement getBtnclickcontinue() {
		return btnclickcontinue;
	}

	public WebElement getWithoutSelectHotelToClick() {
		return withoutSelectHotelToClick;
	}
	
	
	
	/////////////////
	
	
	/**
	 * @see business logic for common step in click select hotel
	 */
	
	public void commonContinuebtnClick() {
		btnClick(btnclickcontinue);	
	}
	
	/**
	 * @see business logic for select hotel and continue
	 */
	 
	public void selectBtn() {
		btnClick(getBtnclick());
		commonContinuebtnClick();
		
	}
	
	/**
	 * @see business logic for without select hotel click and continue
	 */
	
	
	public void withoutSelectClick() {
		commonContinuebtnClick();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
