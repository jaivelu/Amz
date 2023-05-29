package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;

/**
 * 
 * @author Jayavel
 * @date 03-10-2022
 * @see used to login page locator and business logic
 *
 */

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "username")
	private	WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy (id = "login")
	private WebElement btnlogin;
	
	@FindBy (className="auth_error")
	private WebElement withoutLoginErrorMsg;
	

	/////////////////
	
	
	public WebElement getWithoutLoginErrorMsg() {
		return withoutLoginErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
		
	
	
	
	////////////
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @see business logic for login common step
	 */
	
	
	
	public void loginCommonStep(String userName, String password) {

		setText(txtUserName, userName);
		setText(txtPassword, password);
		
	}
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @see business logic for performlogin
	 */
	
	public void login(String userName, String password) {
		
		loginCommonStep(userName,password);
		btnClick(getBtnlogin());
	}
	
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @throws AWTException
	 * @see business logic for login with enter key
	 */
	
	public void loginwithEnterKey(String userName, String password) throws AWTException {
		
		
		loginCommonStep(userName,password);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	

		
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

