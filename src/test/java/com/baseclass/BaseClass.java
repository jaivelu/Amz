package com.baseclass;


	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Date;
	import java.util.List;
import java.util.Properties;
import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriver.Navigation;
	import org.openqa.selenium.WebDriver.TargetLocator;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	/**
	 * @author Jayavel
	 * @date 03-10-2022
	 * @see base class methods are used to method calling
	 */
	
	
	public class BaseClass {
		public static WebDriver driver;
		
		/**
		 * 
		 * @param browser
		 * @see launch the any browser
		 */
		
			public WebDriver getDriver(String browser) {
				
				switch (browser) {
				
				case "microsoftedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
					
				case "firefox" :
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					System.out.println("Invalid browser");
					break;
				}
				return driver;	
			
			}
			
		////////////   Screenshot        /////////
			/**
			 * 
			 * @return byte[]
			 * @see to take screenshot
			 */
			public byte[] screenshot() {
				
				TakesScreenshot ts=(TakesScreenshot) driver;
				byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
				return screenshotAs;
			}
			
			
			//Read value from properties file
			/**
			 * 
			 * @param key
			 * @return String
			 * @throws FileNotFoundException
			 * @throws IOException
			 * @see to get value from configuration file
			 */
			
			public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
				Properties p = new Properties();
				p.load(new FileInputStream(System.getProperty("user.dir")+ "\\Config\\Config.properties"));
				String s=(String) p.get(key);
				return s;
				
			}
			
			/**
			 * 
			 * @param e
			 * @see webdriver wait until the expected visibility element 
			 */
			
			public  static void elementVisibility(WebElement e) {
				WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(100));
				wait.until(ExpectedConditions.visibilityOf(e));
			}
			
			
			
			

////////////   Maximize window    ==========>>>>>>>>>>>
			
		/**
		 * @see maximize the  window
		 */
		
			public void maximize() {
				driver.manage().window().maximize();

			}
			
			
////////////	    Waits     ===========>>>>>>>>>>>>>>
			/**
			 * @see apply for all location
			 */
			
		
			public void implicitwait() {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			}
			
			/**
			 * 
			 * @param d
			 * @see apply for one locator
			 */
			
			
			public void webdriverWait(WebDriverWait d) {
				
				d = new WebDriverWait(driver,Duration.ofSeconds(10));
				
			}
			
			/**
			 * 
			 * @param f
			 * @see apply for one locator
			 */
			
			
			public void fluentWait(FluentWait f) {
				f = new FluentWait(driver).
						withTimeout(Duration.ofSeconds(50)).
						pollingEvery(Duration.ofSeconds(5)).
						ignoring(Throwable.class);
				
				
				
			}
		
			
	///////////////    Load URL   ==========>>>>>>>>>>>>>>
			
			/**
			 * 
			 * @param url
			 * @ see load the url
			 */
			
			public void loadurl(String url) {
				driver.get(url);
			
			}
			
			
//////////	       Load Current uRL   ==========>>>>>>>>>>>
			
			/**
			 * 
			 * @return String
			 * @see get the current url
			 */
			
			public String getpageurl() {
				String currentUrl = driver.getCurrentUrl();
				return currentUrl;
				
				
			}
			
			
	///////////      Sendkeys            =============>>>>>>>>>>
			
			/**
			 * 
			 * @param w
			 * @param name
			 * @see enter the text box inside value
			 */
			
			public  void setText(WebElement w, String name) {
				w.sendKeys(name);
			
			}
			
//////////			Clear   ==========>>>>>>>>>>>
			
			/**
			 * 
			 * @param w
			 * @see clear the text box value
			 */
			public void clearmethod(WebElement w) {
				w.clear();

			}
			
			
			
//////////	    Button Click  &&&   Radio button ==========>>>>>>>>>>>	
			/**
			 * @see click the button
			 */
			
			public void btnClick(WebElement w) {
				w.click();

			}
			
	/////////      Quit Browser   ==========>>>>>>>>>>>		
			
			/**
			 * @see quit the browser
			 */
			
			public void quitbrowser() {
			  driver.quit();

			}
			
			
//////////	    Close Browser  ==========>>>>>>>>>>>
			
			/**
			 * @see close the browser
			 */
			public void closebrowser() {
				driver.close();

			}
			
			
			
	///////////   Dropdown   select methods   ==========>>>>>>>>>>>>>>
			
			/**
			 * 
			 * @param w
			 * @param index
			 * @see select by the index in dropdown
			 */
			
			public void selectByIndex(WebElement w,int index) {
				Select s = new Select(w);
				s.selectByIndex(index);
			}
			
			/**
			 * 
			 * @param w
			 * @param value
			 * @see select by the value in dropdown
			 */
			
			public void selectByValue(WebElement w, String value) {
				Select s = new Select(w);
			    s.selectByValue(value);
				
			}
			
			       //////   Visible Text       ////////
			
			/**
			 * 
			 * @param w
			 * @param data
			 * @see select by visible text in dropdown
			 */
			
			public void selectByText(WebElement w,String data) {
				Select s = new Select(w);
				s.selectByVisibleText(data);
			
			}
			
			/**
			 * 
			 * @param w
			 * @param data
			 * @return WebElement
			 * @see get the options in dropdown
			 */
			
			public WebElement getOptions(WebElement w,int data) {
				Select s = new Select(w);
				List<WebElement> options = s.getOptions();
				WebElement element = options.get(data);
				//String text = element.getText();
				//return text;
				return element;
				
				
			}
			
			
			/**
			 * 
			 * @param w
			 * @param data
			 * @return WebElement
			 * @see get all selected options in dropdown
			 */
			
			public WebElement getAllSelectedOptions(WebElement w,int data) {
			   Select s = new Select(w);
			   List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			   WebElement element = allSelectedOptions.get(data);
			return element;
			   
			   
			}
			
			/**
			 * 
			 * @param w
			 * @return WebElement
			 * @see first selected option in dropdown
			 */
			
			public WebElement getFirstSelectedOption(WebElement w) {
				Select s = new Select(w);
				WebElement firstSelectedOption = s.getFirstSelectedOption();
				//String text = firstSelectedOption.getText();
				// return text;
				return firstSelectedOption;
				
				
			}
			
			
			/**
			 * 
			 * @param w
			 * @param index
			 * @see deselect by index in dropdown
			 */
			
			
			public void deselectByIndex(WebElement w,int index) {
				Select s = new Select(w);
				s.deselectByIndex(index);
				
				
			}
			
			/**
			 * 
			 * @param w
			 * @param data
			 * @see deselect by value in dropdown
			 */
			
			public void deselectByValue(WebElement w,String data) {
				Select s = new Select(w);
				s.deselectByValue(data);
			}
			
			
			/**
			 * 
			 * @param w
			 * @param data
			 * @see deselect by visible text in dropdown
			 */
			public void deselectByVisibleText(WebElement w, String data) {
				Select s = new Select(w);
				s.deselectByVisibleText(data);
			}
			
			/**
			 * 
			 * @param w
			 * @return
			 * @see multiple select or Not in dropdown
			 */
			
			public boolean isMultiple(WebElement w) {
				Select s = new Select(w);
				boolean multiple = s.isMultiple();
				return multiple;
				
				
			}
////////////	      Actions    =============>>>>>>>>>>>
			
			/**
			 * 
			 * @param w
			 * @see action class using in mouse over action
			 */
			
			
			public void moveToElement(WebElement w) {
				Actions actions = new Actions(driver);
				actions.moveToElement(w).perform();
				
			}
			
			/**
			 * 
			 * @param s
			 * @param d
			 * @see action class using in drag and drop
			 */
			
			
			public void dragAndDrop(WebElement s , WebElement d ) {
			//	webelement w = driver.findElement(by)   ====>>>   Source file 
			//	webelement w = driver.findElement(by)   ====>>>   Designation file
				
				Actions actions = new Actions(driver);
				actions.dragAndDrop(s,d).perform();
			}
			
			
			/**
			 * @see action class using in right click
			 */
			
			public void contextClick() {     
				Actions actions = new Actions(driver);
				actions.contextClick().perform();
			}
			
			
			/**
			 * @see action class using in double click
			 */
			public void doubleClick() {
				Actions actions = new Actions(driver);
				actions.doubleClick().perform();
				
			}
			
			/**
			 * @see action class using in key down
			 */
			
			public void keyDown() {            
				Actions actions = new Actions(driver);
				actions.keyDown(null).perform();
				
			}
			
			/**
			 * @see action class using in key up
			 */

			public void keyUp() {            
				Actions actions = new Actions(driver);
				actions.keyUp(null).perform();
				
			}
			
			/**
			 * 
			 * @param w
			 * @param data
			 * @return
			 * @see action class using in send keys
			 */
			public Actions sedkeysAction(WebElement w, String data) {
				Actions actions = new Actions(driver);
				Actions sendKeys = actions.sendKeys(w , data);
				return sendKeys;
				
			}
			
			
			
////////	          Robot    =========>>>>>>>>>
			
			/**
			 * 
			 * @throws AWTException
			 * @see robot class in keypress
			 */
			
			public void keyPress() throws AWTException {
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_A);
			
			}
			
			/**
			 * 
			 * @throws AWTException
			 * @see robot class in key release
			 */
			
			public void keyRelease() throws AWTException {
				
				Robot robot = new Robot();
				robot.keyRelease(KeyEvent.VK_A);
				
				}
			
			
			
			
////////	    GetText       ==========>>>>>>>>>
			
			/**
			 * 
			 * @param w
			 * @return String
			 * @see use to get the text
			 */
			
			public String getTextmethod(WebElement w) {
				String text = w.getText();
				return text;
				
				
			}
			
			
	///////    GetAttribute       ==========>>>>>>>>>		
			
			/**
			 * 
			 * @param w
			 * @param value
			 * @return String
			 * @see use to get the inside of text box text
			 */
			public String getattributevalue(WebElement w , String value) {
			    String attribute = w.getAttribute(value);
				return attribute;
				
			}
			
			////////////////        OR       //////////////////
			
			/**
			 * 
			 * @param w
			 * @return String
			 * @see use to get the inside of text box text
			 */
			
			public String getAttributemethod(WebElement w) {
				String attribute = w.getAttribute("value");
				return attribute;
			
			}
			
			
			
			
			
			
	//////////   NAVIGATE   ===============>>>>>>>>>>>>>>
			
			/**
			 * 
			 * @return Navigation
			 * @see navigate
			 */
			
			public Navigation navigate() {
			    Navigation navigate = driver.navigate();
				return navigate;
			    
			}
			
			/**
			 * @see navigate back page
			 */
			
			public void navigateback() {
				//driver.navigate().back();            we writen in this type of
				navigate().back();
			
			}
			
			/**
			 * @see navigate forward page
			 */
			
			public void navigatefordward() {
				navigate().forward();
				
			}
			
			/**
			 * @see navigate refresh page
			 */
			
			public void navigaterefersh() {
				navigate().refresh();
				
			}
			
			
			
			
	/////////////////////////   Locaters   ===================>>>>>>>>>>>>>>>>>
			
			/**
			 * 
			 * @return WebElement
			 * @see locator of id
			 */
			
			public WebElement locaterid() {
			    WebElement element = driver.findElement(By.id("id"));
				return element;
			  
			}
			
			/**
			 * 
			 * @return WebElement
			 * @see loactor of name
			 */
			
			public WebElement locatername() {
				WebElement element = driver.findElement(By.name("name"));
				return element;
				
				
			}
			
			/**
			 * 
			 * @return WebElement
			 * @see loactor of classname
			 */
			
			public WebElement locaterclassname() {
			    WebElement element = driver.findElement(By.className("className"));
				return element;
				
			}
			
			/**
			 * 
			 * @return WebElement
			 * @see loactor of xpath
			 */
			
			public WebElement locaterxpath() {
				WebElement element = driver.findElement(By.xpath("xpathExpression"));
				return element;
				
			}
			
	//////////////   Enable or Disable      ==========>>>>>>>>>>>
			
			/**
			 * 
			 * @param w
			 * @return boolean
			 * @see enable or not
			 */
			
			public boolean isEnabled(WebElement w) {
				boolean enabled = w.isEnabled();
				return enabled;
				
			}
			
			
////////////	        Windows         =================>>>>>>>>>>>>>
			
			/**
			 * 
			 * @param id
			 * @return WebDriver
			 * @see switch to window
			 */
			
			public WebDriver switchToWindow(String id) {
				WebDriver window = driver.switchTo().window(id);
				return window;
				
			}
			
			/**
			 * 
			 * @return WebDriver
			 * @see switch to default window
			 */
			
			public WebDriver switchToDefaulteWindow() {
				WebDriver defaultContent = driver.switchTo().defaultContent();
				return defaultContent;
				
			}
			
			/**
			 * 
			 * @param parentwindowId
			 * @return WebDriver
			 * @see switch to default parent window
			 */
			
			public WebDriver returnToParentWindow(String parentwindowId) {
				WebDriver window = driver.switchTo().window(parentwindowId);
				return window;
				
			}
			
			/**
			 * 
			 * @return String
			 * @see get the window handle
			 */
			
			public String getWindowHandle() {
				String windowHandle = driver.getWindowHandle();
				return windowHandle;
				
			}
			
			/**
			 * 
			 * @return Set<String>
			 * @see get the window handles
			 */
			
			public Set<String> getWindowHandles() {
				Set<String> windowHandles = driver.getWindowHandles();
				return windowHandles;
			}
			
			
			
	/////////////////     Alert     =================>>>>>>>>>>>
			
			/**
			 * 
			 * @return TargetLocator
			 * @see switch 
			 */
			
			public TargetLocator switchToElement() {
				TargetLocator locator = driver.switchTo();
				return locator;
				
			}
			
			/**
			 * 
			 * @return Alert
			 * @see switch to alert
			 */
			
			public Alert switchToAlert() {	
				Alert alert = switchToElement().alert();
				return alert;	
				
			}
			
			/**
			 * @see simple alert
			 */
			
			public void acceptAlert() {
				switchToAlert().accept();
				
			}
			
			/**
			 * @see confirm alert
			 */
			
			public void dismissAlert() {
				switchToAlert().dismiss();
				
			}
			
			/**
			 * @see prompt alert
			 */
			
			public void alertboxSendkeys() {
				//Alert alert = driver.switchTo().alert();
				switchToAlert().sendKeys("Data");
		    	 
			}
			
		

			
			
////////////////	      Frames       ================>>>>>>>>>>>>>>>>>>
			
			/**
			 * 
			 * @param data
			 * @return WebDriver
			 * @see switch to frame 
			 */
			
			public WebDriver switchToFrame(String data) {
				WebDriver frame = switchToElement().frame(data);                 //    =========>>>>>>>> switchToElement() used in alert 
				return frame;
			}
			
			
			// id , name ,element , index   if all use in this method
			
			/**
			 * 
			 * @param data
			 * @return WebDriver
			 * @see switch to frame by name, id , index ,
			 */
			
			public WebDriver switchToFrameByName(String data) {
				WebDriver switchToFrame = switchToFrame(data);
				return switchToFrame;
				 
			}
			
			/**
			 * 
			 * @param reffName
			 * @return WebDriver
			 * @see switch to frame using element refname
			 */
			
			public WebDriver switchToReffName(WebElement reffName) {
				 WebDriver frame = switchToElement().frame(reffName);
				return frame;
			}
				
			/**
			 * 
			 * @return WebDriver
			 * @see switch to parentframe
			 */
			
			public WebDriver switchToParentFrame() {
				WebDriver parentFrame = switchToElement().parentFrame();
				return parentFrame;
			}
			
			/**
			 * 
			 * @return WebDriver
			 * @see switch to defaultframe
			 */
			
			public WebDriver switchToDefaultFrames() {
				WebDriver defaultContent = switchToElement().defaultContent();
				return defaultContent;
			}
		
			
			
	//////////   Data Driven     ==============>>>>>>>>>>>>>>>>>>
			
			/**
			 * 
			 * @param sheetname
			 * @param rownum
			 * @param cellnum
			 * @return String
			 * @throws IOException
			 * @see data driven base class
			 */
			
			public String getData(String sheetname,int rownum,int cellnum) throws IOException {
				
				String value = null;
				
				
				File excel = new File(System.getProperty("user.dir") + "\\ExcelSheet\\Excel Write.xlsx");
				
				FileInputStream stream = new FileInputStream(excel);
				
				Workbook w = new XSSFWorkbook(stream);

				Sheet s = w.getSheet(sheetname);
				
				Row row = s.getRow(rownum);
				
				Cell cell = row.getCell(cellnum);
				
				int Type = cell.getCellType();
				
				
				switch (Type) {
				case 1:				//  String Cell Data
					  value = cell.getStringCellValue();
					break;
		
				case 0 :   			 // Numeric cell  &  date cell	
					
					if(DateUtil.isCellDateFormatted(cell)) {
					   Date date = cell.getDateCellValue();
					   SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY");
					   dateformat.format(date);
				
					}else {
						
					   double d = cell.getNumericCellValue();
					   long l = (long)d ;
					   value = String.valueOf(l);
						
					}
					
				default:
					break;
				}
				return value;
					
				
			}

			
//////////	       JavaScriptExecutor    ===========>>>>>>>>>>
			
			/**
			 * 
			 * @param w
			 * @param data
			 * @return Object
			 * @see insert value for javascript
			 */
			
			public Object javaScriptInsertValue (WebElement w, String data) {	
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Object executeScript = js.executeScript("arguments[0].setAttribute('value','data')",w);
				return executeScript;
			
			}
			
			/**
			 * 
			 * @param w
			 * @return Object
			 * @see get value for javascript
			 */
			
			public Object javaScriptGetValue (WebElement w) {	
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Object execute = js.executeScript("return arguments[0].getAttribute('value')",w);
				return execute;
			
			}
			
			
			/**
			 * 
			 * @param w
			 * @return Object
			 * @see javascript use in click
			 */
			

			public Object javaScriptClick (WebElement w) {	
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Object script = js.executeScript("arguments[0].click()",w);
			return script;
		
			
			}
			
						//////////   Scroll Down      //////////
			/**
			 * 
			 * @param w
			 * @return Object
			 * @see use in javascript ScrollDown
			 */

			public Object javascriptScrollDown (WebElement w) {	
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Object executeScript = js.executeScript("arguments[0].scrollIntoView(true)", w);          
				return executeScript;
		
			
			}
			
						///////////    Scroll Up     //////////////
			/**
			 * 
			 * @param w
			 * @return Object
			 * @see use in javascript ScrollUp
			 */
			
			public Object javascriptScrollUp (WebElement w) {	
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Object executeScript = js.executeScript("arguments[0].scrollIntoView(false)", w);
				return executeScript;
				
		
			
			}
			
			
			
//////////////////////	    ScreenshotAs      /////////////////////
			
			/**
			 * 
			 * @return File
			 * @see use in takescreenshot
			 */
			
			public File screenShot() {
				
				TakesScreenshot screen =(TakesScreenshot)driver;
				File screenshotAs = screen.getScreenshotAs(OutputType.FILE);
				return screenshotAs;
				
			}
			
			/**
			 * 
			 * @param data
			 * @throws IOException
			 * @see use in take screenshot as store use in fileutils class in copyfile 
			 */
			public void copyFile (String data) throws IOException {
				
				TakesScreenshot screen =(TakesScreenshot)driver;
				File s = screen.getScreenshotAs(OutputType.FILE);
				
				File d = new File(data);
				FileUtils.copyFile(s, d);
				
				
			}
			
			
			
			
			
			
			
	}


