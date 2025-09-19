package pages.ui;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PTPThirdPartyShippingPage_Public extends BasePage{
	PublicCommon publicCommon;
	
	public PTPThirdPartyShippingPage_Public(WebDriver driver) {
	super(driver);
	publicCommon = new PublicCommon(driver);
}
	
	public By firstNameTextbox = By.cssSelector("div[name='freightForwardAddress.firstname'] input");
	public By lastNameTextbox = By.cssSelector("div[name='freightForwardAddress.lastname'] input");
	private By middleNameTextbox = By.cssSelector("div[name='freightForwardAddress.middlename'] input");
	public By shippingAddress1Textbox = By.cssSelector("div[name='freightForwardAddress.street.0'] input");
	public By shippingAddress2Textbox = By.cssSelector("div[name='freightForwardAddress.street.1'] input");
	public By shippingAddress3Textbox = By.cssSelector("div[name*='freightForwardAddress.street.2'] input");
	public By shippingAddress4Textbox = By.cssSelector("div[name*='freightForwardAddress.street.3'] input");
	
	private By cannotShipSAText = By.xpath("//div[@name='freightForwardAddress.street.0']//span[contains(text(),'ASTM cannot')]");
	private By errorMessageForStateRequired = By.xpath("//*[@name='freightForwardAddress.region_id']//*[text()='This is a required field.']");
	private By clickHereSALink = By.xpath("//div[@name='freightForwardAddress.street.0']//a[contains(text(),'Click')]");
	private By clickHerePopup = By.xpath("//h5[text()='Shipping to PO Box addresses']");
	
	public By cityTextbox = By.cssSelector("div[name='freightForwardAddress.city'] input");
	public By stateTextbox = By.cssSelector("div[name='freightForwardAddress.region'] input");
	public By stateDropdown = By.cssSelector("div[name='freightForwardAddress.region_id'] select");
	public By postalCodeTextbox = By.cssSelector("div[name*='freightForwardAddress.postcode'] input");
	private By countryDropdown = By.cssSelector("div[name*='freightForwardAddress.country_id'] select");
	private By closePoBox = By.cssSelector("#astm_po_box .close");
	public By companyDropdown = By.xpath("//select[@name='carrier_company']");
	public By AddressValidationHeader = By.xpath("//header[@class='modal-header']/h1[contains(text(),'Address Validation')]");
	public By AddressValContinueBtn = By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']/span[text()='Continue']");
	public By SuggestedAddressHeader = By.xpath("//header[@class='modal-header']/h1[contains(text(),'Confirm Address')]");
	public By SuggestedAddressContinueBtn = By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']/span[text()='Use Selected Address']");
	
	private By requiredFieldList = By.xpath("//*[@id='third-party-shipping-container']//*[contains(@class,' _required') and @name!='freightForwardAddress.region']");
	private By errorMessageList = By.cssSelector("#third-party-shipping-container .field-error");
	private By thirdPartyHeader = By.xpath("//*[text()='Third Party Shipping Information']");


	public By thirdPartyContinueButton = By.xpath("//parent::button[@type='button' and contains(@data-bind,'click: saveThirdPartyShippingAddress')]");
	//public By thirdPartyContinueButton = By.xpath("//*[@class='actions-toolbar d-flex justify-content-end border-top mt-5 pt-4']//button[@type='button' and contains(.,'Continue')]");      
	//*[@id='freight-forward-container']//span[text()='Continue']"
	
	private By textBoxListElement = By.cssSelector("div[name*='freightForwardAddress'] input");
	private By sameCountryErrorMsg = By.xpath("//*[text()='Ship-to country must be the same as the billing country.']");
	public By emailTextbox = By.cssSelector("#third-party-shipping-container *[name='email']");
	public By phoneTextbox = By.cssSelector("#third-party-shipping-container *[name='telephone']");
	public By goBackButton =By.xpath("//*[@id='third-party-shipping-container']//*[text()='Go Back']");
	
	public By companyTextbox = By.cssSelector("div[name='freightForwardAddress.organization'] input");
	public By accountNumberError = By.cssSelector("div[name='courierService.carrier_account'] .field-error span");
	public By accountNumberTextbox = By.cssSelector("div[name='courierService.carrier_account'] input");
	public By changeBtnFrightForwarder = By.xpath("//div[contains(@class,'freight-forwarder-information ')]//child::button");
	public By courierServicesHeader = By.xpath("//*[text()='Courier Services']");
	public By onlyFillPTPLink=By.xpath("//a[text()='ptp@astm.org']");
	
	public By errorMessageTPS = By.id("thirdPartyShippingMessage");
	
	public WebElement getErrorMessageTPSElement() { return
			  getElement(errorMessageTPS); }
	
	public WebElement getCompanyDropdownElement() { return
			  getElement(companyDropdown); }
	
	public WebElement getFirstNameTextboxElement() { return
			  getElement(firstNameTextbox); }
	
	public WebElement getCountryDropdownElement() { return
			  getElement(countryDropdown); }
	
	public List<WebElement> getErrorMessageListElement() { return
			  getElements(errorMessageList); }
	
	public List<WebElement> getRequiredFieldListElement() { return
			  getElements(requiredFieldList); }
	
	public List<WebElement> getTextBoxListElement() { return
			  getElements(textBoxListElement); }
		
	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some error occured while creating element" + locator.toString());
			e.getStackTrace();
		}
		return element;
	}
	
	
	public int getRequiredFieldListCount() 
	{
		try {
			return getElements(requiredFieldList).size();
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return (Integer) null;// TODO: handle exception
		}	
	}
	
	
	@Step("Get 'Country' from TextBox.")
	public String getCountryValue() 
	{
		try {
			Assert.assertEquals(PublicCommon.getAllSelectedValueInDropdown(getElement(countryDropdown),driver).size(), 1,"More than one country has been selected");
			System.out.println("Country Options:::::"+PublicCommon.getFirstSelectedValueInDropdown(getElement(countryDropdown)).getText());
			return PublicCommon.getFirstSelectedValueInDropdown(getElement(countryDropdown)).getText();
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'State' from Dropdown.")
	public String getStateValue() 
	{
		try {
			Assert.assertEquals(PublicCommon.getAllSelectedValueInDropdown(getElement(stateDropdown),driver).size(), 1,"More than one country has been selected");
			System.out.println("State Options:::::"+PublicCommon.getFirstSelectedValueInDropdown(getElement(stateDropdown)).getText());
			return PublicCommon.getFirstSelectedValueInDropdown(getElement(stateDropdown)).getText();
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	
	
	public String getAccountNumberError() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(accountNumberError), driver);
			return getElement(accountNumberError).getText();
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	
	
	public boolean clickGoBackButton() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(goBackButton), driver);
			 getElement(goBackButton).click();
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			
		}	
	}
	@Step("Close ASTM PO Box")
	public boolean clickClosePOBoxIcon() 
	{
		try {
			 getElement(closePoBox).click();
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			
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
			return null;// TODO: handle exception
		}	
	}
	@Step("Get all field values from TextBox.")
	public List<String> getAllFieldValuesPTP() 
	{
		try {
			int fieldValue = getTextBoxListElement().size();
			List<String> list = new ArrayList<String>();
			
			for(int i=0;i<fieldValue;i++) {
				if(i!=3) {
			list.add(publicCommon.JSExecutorGetText(getTextBoxListElement().get(i),driver));}
			}
			return list;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}

	@Step("Click on 'Click Here' Link.")
	public void clickOnClickHereLink() 
	{
		try {
			getElement(clickHereSALink).click();
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	

	@Step("Enter Third Party Shipping Page Details.")
	public boolean addThirdPartyShippingPageDetailsPTP(String test, String tptService) {
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),
					test);
			if(tptService.equalsIgnoreCase("FF")) {
			setOrganisationValue(dataMap.get("Organisation NameTP"));
			setFirstName(dataMap.get("First NameTP"));
			setLastName(dataMap.get("Last NameTP"));
			setEmailAddressValue(dataMap.get("emailTP"));
			setPhoneNumber(dataMap.get("TelephoneTP"));
			setStreetAddressValue(dataMap.get("Add1TP"), dataMap.get("Add2TP"), dataMap.get("Add3TP"), dataMap.get("Add4TP"));
			scrollToCityField();
			setCountryValue(dataMap.get("CountryTP"));
			setCityValue(dataMap.get("CityTP"));
			setPostalCodeValue(dataMap.get("Postal CodeTP"));
			setStateValueDropdown(dataMap.get("StateTP"));
			
			}
			else {
				setCompanyValue(dataMap.get("CompanyTP"));
				setAccountNumber(dataMap.get("Account NumberTP"));
			}
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
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
	

	@Step("Enter Organisation :'{0}' in TextBox.")
	public void setOrganisationValue(String company) 
	{
		try {
			getElement(companyTextbox).clear();
			getElement(companyTextbox).sendKeys(company);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Clear Organisation TextBox.")
	public void clearOrganisationValue() 
	{
		try {
			getElement(companyTextbox).clear();
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
	
	@Step("Enter Middle Name :'{0}' in TextBox.")
	public void setMiddleName(String middleName) 
	{
		try {
			getElement(middleNameTextbox).clear();
			getElement(middleNameTextbox).sendKeys(middleName);
			
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
	

	@Step("Enter Street Address in TextBox.")
	public void setStreetAddressValue(String streetAddress1,String streetAddress2,String streetAddress3,String streetAddress4) 
	{
		try {
			getElement(shippingAddress1Textbox).clear();
			getElement(shippingAddress1Textbox).sendKeys(streetAddress1);
			getElement(shippingAddress2Textbox).clear();
			getElement(shippingAddress2Textbox).sendKeys(streetAddress2);
			getElement(shippingAddress3Textbox).clear();
			getElement(shippingAddress3Textbox).sendKeys(streetAddress3);
			//getElement(shippingAddress4Textbox).clear();
			//getElement(shippingAddress4Textbox).sendKeys(streetAddress4);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
	
	@Step("Enter City:'{0}' in TextBox.")
	public void setCityValue(String city) 
	{
		try {
			getElement(cityTextbox).clear();
			getElement(cityTextbox).sendKeys(city);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
	@Step("Enter Account Number:'{0}' in TextBox.")
	public boolean setAccountNumber(String accountNum) 
	{
		try {
			getElement(accountNumberTextbox).clear();
			getElement(accountNumberTextbox).sendKeys(accountNum);
			return true;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	
	@Step("Enter State:'{0}' in TextBox.")
	public void setStateValue(String state) 
	{
		try {
			getElement(stateTextbox).clear();
			getElement(stateTextbox).sendKeys(state);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter Country:'{0}' in TextBox.")
	public void setCountryValue(String country) 
	{
		try {
			getElement(countryDropdown).click();
			PublicCommon.selectValueInDropdown(getElement(countryDropdown), country);
			getElement(countryDropdown).click();
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter Company:'{0}' in TextBox.")
	public boolean setCompanyValue(String company) 
	{
		try {
			Thread.sleep(4000);
			ReusableMethods.scrollIntoView(getElement(companyDropdown), driver);
//			getElement(companyDropdown).click();
			PublicCommon.selectValueInDropdown(getElement(companyDropdown), company);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	
	
	@Step("Enter State:'{0}' in TextBox.")
	public void setStateValueDropdown(String state) 
	{
		try {
			getElement(stateDropdown).click();
			PublicCommon.selectValueInDropdown(getElement(stateDropdown), state);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
	@Step("Enter Postal Code:'{0}' in TextBox.")
	public void setPostalCodeValue(String postalCode) 
	{
		try {
			getElement(postalCodeTextbox).clear();
			getElement(postalCodeTextbox).sendKeys(postalCode);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}

	public boolean checkStateErrorMsgIsVisible() {
		try {
			return getElement(errorMessageForStateRequired).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean checkAccountNumberErrorMsgIsVisible() {
		try {
			return getElement(accountNumberError).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * This method used to Verify the Third Party Shipping Header visibility
	 * @return True/false
	 */
	public boolean verifyThirdPartyShippingHeaderIsVisible() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(thirdPartyHeader), driver);
			return getElement(thirdPartyHeader).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}

	
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
	
	
	public boolean setEmailAddressValue(String email) 
	{
		try {
			getElement(emailTextbox).clear();
			getElement(emailTextbox).sendKeys(email);
			return true;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	
	public boolean setPhoneNumber(String telephone) 
	{
		try {	
			getElement(phoneTextbox).clear();
			getElement(phoneTextbox).sendKeys(telephone);
			return true;
			
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	@Step("Check 'Ship-to country must be the same as the billing country.' Error is visible.")
	public boolean verifySameCountryIsVisible() 
	{
		try {
			return getElement(sameCountryErrorMsg).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	
	
	@Step("Check 'Shipping to PO Box Addresses' Pop-up is visible.")
	public boolean verifyAddressPopupIsVisible() 
	{
		try {
			return getElement(clickHerePopup).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	
	
	@Step("Check Error Messages for mandatory fields.")
	public List<String> getErrorMessageList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getErrorMessageListElement(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	
	
	//@Step("Click Continue Button on Shipping Address Page.")
	public boolean clickContinueButton() 
	{
		try {
			 getElement(thirdPartyContinueButton).click();
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	
	@Step("Scroll to View City field on the page.")
	public void scrollToCityField() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(cityTextbox), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	
	
	
	
	
	
}
