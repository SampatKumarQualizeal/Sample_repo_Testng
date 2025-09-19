package pages.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ConfigReader;
import io.qameta.allure.Step;

public class ContactPersonAddressPage_Public extends BasePage {
	PublicCommon publicCommon;
	
	public ContactPersonAddressPage_Public(WebDriver driver) {
		super(driver);		
		publicCommon = new PublicCommon(driver);
		} 
	
	
	public By firstNameTextbox = By.cssSelector("div[name='contactShippingData.first_name'] input");
	public By lastNameTextbox = By.cssSelector("div[name='contactShippingData.last_name'] input");
	public By phoneTextbox = By.cssSelector(".contact-shipping-step *[name='phone']");
	private By phoneMessage = By.xpath("//div[@name='contactShippingData.phone']//span[contains(text(),'Please do not')]");
	private By emailTextbox = By.xpath("//div[@name='contactShippingData.email']//input");
	private By emailMessage = By.xpath("//span[text()='Required for Order Confirmation and Support']");
	
	private By errorMessageList = By.cssSelector(".contact-shipping-step .field-error");
	
	public By contactPersonHeader = By.xpath("//h2[text()='Shipping Contact Person']");
	
	private By textBoxListElement = By.xpath("//div[@id='contact-shipping-container']//input");
	
	public By firstNameLabel =By.xpath("//div[@name='contactShippingData.first_name']//span");
	
	public By lastNameLabel =By.xpath("//div[@name='contactShippingData.lastname']//span");
	
	public By goBackButton =By.xpath(" //*[@id='contact-shipping-container']//*[text()='Go Back']");
//	public By continueButton =By.xpath("//*[@id='contact-person-container']//*[text()='Continue']");
	public By continueButton =By.xpath("//button[@data-bind='click: saveContactData']");
	
	
	public WebElement getHeader() { return
			  getElement(contactPersonHeader); }
	
	
	public List<WebElement> getErrorMessageListElement() { return
			  getElements(errorMessageList); }
	
	public List<WebElement> getTextBoxListElement() { return
			  getElements(textBoxListElement); }
		
	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return element;
	}
	
	public boolean clickGoBackButton() 
	{
		try {
			PublicCommon.JSClick(getElement(goBackButton), driver);
			//ReusableMethods.mouseHoverAndClick(driver, getElement(goBackButton), "Go Back button");
			/// getElement(goBackButton).click();
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			
		}	
	}
	
	
	public boolean checkMessageUnderEmailFieldIsDisplayed() {
		try {
			return getElement(emailMessage).isDisplayed();

		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}
	
	public boolean checkMessageUnderPhoneFieldIsDisplayed() {
		try {
			return getElement(phoneMessage).isDisplayed();

		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}
	
	
	@Step("Get 'Email Address' from TextBox.")
	public String getEmailAddressValue() 
	{
		try {
			return publicCommon.JSExecutorGetText(getElement(emailTextbox),driver);
				
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	
	
	@Step("Get all field values from TextBox.")
	public List<String> getAllFieldValues() 
	{
		try {
			int fieldValue = getTextBoxListElement().size();
			List<String> list = new ArrayList<String>();
			
			for(int i=0;i<fieldValue;i++) {
			list.add(publicCommon.JSExecutorGetText(getTextBoxListElement().get(i),driver));
			}
			return list;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}	
	}
	
	
	@Step("Enter Contact Person Details.")
	public boolean addContactPersonDetails(String test) 
	{
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"), test);
			
			setFirstName(dataMap.get("First NameCP"));
			setLastName(dataMap.get("Last NameCP"));
			setPhoneNumber(dataMap.get("TelephoneCP"));
			setEmailAddressValue(dataMap.get("emailCP"));
			getHeader().click();
			return true;			
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	
	@Step("Clear the Email Address TextBox.")
	public void clearEmailAddressValue() 
	{
		try {
			getElement(emailTextbox).clear();
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter {0}:'{1}' in TextBox.")
	public void setValueInTextbox(String fieldName ,String fieldValue, WebElement element) 
	{
		try {
			element.clear();
			element.sendKeys(fieldValue);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter First Name :'{0}' in TextBox.")
	public void setFirstName(String firstName) 
	{
		try {
			getElement(firstNameTextbox).clear();
			getElement(firstNameTextbox).sendKeys(firstName);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
	@Step("Enter Last Name :'{0}' in TextBox.")
	public void setLastName(String lastName) 
	{
		try {
			getElement(lastNameTextbox).clear();
			getElement(lastNameTextbox).sendKeys(lastName);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
	
	@Step("Enter Phone Number :'{0}' in TextBox.")
	public void setPhoneNumber(String telephone) 
	{
		try {	
			getElement(phoneTextbox).clear();
			getElement(phoneTextbox).sendKeys(telephone);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
	
	@Step("Enter Email Address:'{0}' in TextBox.")
	public void setEmailAddressValue(String email) 
	{
		try {
			getElement(emailTextbox).clear();
			getElement(emailTextbox).sendKeys(email);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	

	
	
	public boolean verifyContactPersonHeaderIsVisible() 
	{
		try {
			return getElement(contactPersonHeader).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	

	public List<String> getErrorMessageList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getErrorMessageListElement(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	

	public boolean clickContinueButton() 
	{
		try {
			 getElement(continueButton).click();
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	@Step("Enter Contact Person Address Details.")
	public void addbillingPageDetails(String test) 
	{
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"), test);
			
			setFirstName(dataMap.get("First Name"));
			setLastName(dataMap.get("Last Name"));
			setPhoneNumber(dataMap.get("Telephone"));
						
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
}
