package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

import io.cucumber.datatable.DataTable;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to book hotel page locator and business logic
 *
 */

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (id = "first_name")
	private WebElement txtfirstname;
	
	@FindBy (id = "last_name")
	private WebElement txtlastname;
	
	@FindBy (id = "address")
	private WebElement txtaddress;
	
	@FindBy (id = "cc_num")
	private WebElement cardnum;
	
	@FindBy (id = "cc_type")
	private WebElement cardType;
	
	@FindBy (id = "cc_exp_month")
	private WebElement Expmonth;
	
	@FindBy (id = "cc_exp_year")
	private WebElement Expyear;
	
	@FindBy (id = "cc_cvv")
	private WebElement cvvnumber;
	
	@FindBy (id = "book_now")
	private WebElement btnBooknow;
	
	
	
	@FindBy (id = "first_name_span")
	private WebElement errorFirstName;

	@FindBy (id = "last_name_span")
	private WebElement errorLastName;
	
	@FindBy (id = "address_span")
	private WebElement errorAddress;
	
	@FindBy (id = "cc_num_span")
	private WebElement errorCreditCardNo;
	
	@FindBy (id = "cc_type_span")
	private WebElement errorCreditCardType;
	
	@FindBy (id = "cc_expiry_span")
	private WebElement errorDateYear;
	
	@FindBy (id = "cc_cvv_span")
	private WebElement errorCvv;
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHotel;
	
	
	
	


	public WebElement getTxtBookHotel() {
		return txtBookHotel;
	}

	public WebElement getTxtfirstname() {
		return txtfirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getCardnum() {
		return cardnum;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpmonth() {
		return Expmonth;
	}

	public WebElement getExpyear() {
		return Expyear;
	}

	public WebElement getCvvnumber() {
		return cvvnumber;
	}

	public WebElement getBtnBooknow() {
		return btnBooknow;
	}

	public WebElement getErrorFirstName() {
		return errorFirstName;
	}

	public WebElement getErrorLastName() {
		return errorLastName;
	}

	public WebElement getErrorAddress() {
		return errorAddress;
	}

	public WebElement getErrorCreditCardNo() {
		return errorCreditCardNo;
	}

	public WebElement getErrorCreditCardType() {
		return errorCreditCardType;
	}

	public WebElement getErrorDateYear() {
		return errorDateYear;
	}

	public WebElement getErrorCvv() {
		return errorCvv;
	}
	
	
	
	
	/////////////////////////////
	
	/**
	 * @see business logic for common step in click booknow
	 */
	
	public void clickBookNowCommon() {
		btnClick(getBtnBooknow());
		
	}
	
	/**
	 * 
	 * @param dataTable
	 * @see business logic for book hotel creditcard fields
	 */
	
	public void creditCard(DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String cardNum = map.get("creditCardNo");
		setText(getCardnum(), cardNum);
		String cardType = map.get("creditCardType");
		selectByText(getCardType(), cardType);
		String cardExpMonth = map.get("expiryMonth");
		selectByText(getExpmonth(), cardExpMonth);
		String cardExpYear = map.get("expiryYear");
		selectByText(getExpyear(), cardExpYear);
		String cardCvv = map.get("cvv");
		setText(getCvvnumber(), cardCvv);
	}
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 * @see business logic for book hotel all fields
	 */
	
	public void selectBookAll(String firstName,String lastName,String address,DataTable dataTable) {
		
		setText(getTxtfirstname(), firstName);
		setText(getTxtlastname(), lastName);
		setText(getTxtaddress(), address);
		creditCard(dataTable);		
		clickBookNowCommon();
	
	}
	
	/**
	 * @see business logic for book hotel without enter the  fields
	 */
	
	public void withoutSelectClick() {
		clickBookNowCommon();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
