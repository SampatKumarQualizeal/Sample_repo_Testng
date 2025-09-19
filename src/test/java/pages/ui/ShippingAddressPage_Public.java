package pages.ui;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShippingAddressPage_Public extends BasePage {
	PublicCommon publicCommon;
	
	public ShippingAddressPage_Public(WebDriver driver) {
		super(driver);		
		publicCommon = new PublicCommon(driver);
		} 
	
	
	public By firstNameTextbox = By.cssSelector("div[name='shippingAddress.firstname'] input");
	public By lastNameTextbox = By.cssSelector("div[name='shippingAddress.lastname'] input");
	public By middleNameTextbox = By.cssSelector("div[name='shippingAddress.middlename'] input");
	public By shippingAddress1Textbox = By.cssSelector("div[name='shippingAddress.street.0'] input");
	public By shippingAddress2Textbox = By.cssSelector("div[name='shippingAddress.street.1'] input");
	public By shippingAddress3Textbox = By.cssSelector("div[name*='shippingAddress.street.2'] input");
	public By shippingCompanyName= By.cssSelector("div[name='shippingAddress.company'] input");
	public By companyTextbox = By.cssSelector("div[name='shippingAddress.company'] input");
	
	private By cannotShipSAText = By.xpath("//div[@name='shippingAddress.street.0']//span[contains(text(),'ASTM cannot')]");
	private By errorMessageForStateRequired = By.xpath("//*[@name='shippingAddress.region_id']//*[text()='This is a required field.']");
	public By clickHereSALink = By.xpath("//div[@name='shippingAddress.street.0']//a[contains(text(),'Click')]");
	public By clickHerePopup = By.xpath("//h5[text()='Shipping to PO Box addresses']");
	//form[@class='form methods-shipping']//span[text()='Continue']
	public By cityTextbox = By.cssSelector("div[name='shippingAddress.city'] input");
	public By stateTextbox = By.cssSelector("div[name='shippingAddress.region'] input");
	public By stateDropdown = By.cssSelector("div[name='shippingAddress.region_id'] select");
	public By postalCodeTextbox = By.cssSelector("div[name*='shippingAddress.postcode'] input");
	public By countryDropdown = By.cssSelector("div[name*='shippingAddress.country_id'] select");
	private By closePoBox = By.cssSelector("#astm_po_box .close");
	
	
	private By errorMessageList = By.cssSelector(".shipping-address-step .field-error");
	public By shippingAddressHeader = By.xpath("//h2[text()='Shipping Address']");
	public By shippingAddressContinueButton = By.xpath("//form[@class='form methods-shipping']//span[text()='Continue']");
	
	private By textBoxListElement = By.xpath("//div[@class='shipping-address-step']//div[not(contains(@style,'none'))]/div[@class='control']/input[@type='text']");
	public By sameCountryErrorMsg = By.xpath("//*[text()='Ship-to country must be the same as the billing country.']");
	private By emailTextbox = By.cssSelector(".shipping-address-step *[name='email']");
	public By phoneTextbox = By.cssSelector(".shipping-address-step *[name='telephone']");
	public By goBackButton =By.xpath("//*[@id='shipping-method-buttons-container']//*[text()='Go Back']");
	public By stateDropdown2 = By.cssSelector("div[name='shippingAddress.region_id']");
	
	public By firstNameLabel =By.xpath("//div[@name='shippingAddress.firstname']//span");
	public By middleNameLabel =By.xpath("//div[@name='shippingAddress.middlename']//span");
	public By lastNameLabel =By.xpath("//div[@name='shippingAddress.lastname']//span");
	//public By lastNameVeribage= By.xpath("//div[@name='shippingAddress.lastname']//span[contains(text(),'customer contact')]");
	public By orgCompanyField =By.xpath("//div[@name='shippingAddress.company']//input");
	public By streetLabel= By.cssSelector(".shipping-address-step *[class*='field street'] legend span");
	//public By streetVeribage =By.xpath("//div[@name='shippingAddress.street.0']//span[contains(text(),'ASTM cannot')]");
	public By cityLabel =By.xpath("//div[@name='shippingAddress.city']//span");
	public By stateLabel=By.xpath("//div[@name='shippingAddress.region']//span");
	public By postCodeLabel=By.xpath("//div[@name='shippingAddress.postcode']//span");
	public By countryLabel=By.xpath("//div[@name='shippingAddress.country_id']//span");
	public By phoneLabel =By.xpath("//div[@name='shippingAddress.telephone']//span[text()='Phone Number']");
	public By phoneVeribage=By.xpath("//div[@name='shippingAddress.telephone']//span[contains(text(),'country code')]");
	public By emailLabel=By.xpath("//div[@class='shipping-address-step']//span[text()='Email']");
	//public By emailVeribage =By.xpath("//div[@name='shippingAddress.email']//span[contains(text(),'Required for Order')]");
	public By warningMessageVisible = By.xpath("//*[@id='shipping']//*[@class='astm-alert-text']/ancestor::div[contains(@data-bind,'visible:')]");
	public By countyNotChangeError=By.xpath("//div[@class='field-error']//span");
	//for PTP Product
	public By paymentPageHeader = By.xpath("//h4[contains(text(),'Select Payment Method')]");
	
	//for StandardProsuctPaymentHeader
	public By stdPaymentHeader = By.xpath("//h4[contains(text(),'Payment Information')]");
	
	public WebElement getWarningMessageVisible() {
		return getElement(warningMessageVisible);
	}
	public WebElement getStdPaymentHeader() {
		return getElement(stdPaymentHeader);
	}
	public WebElement getstateDropdown() {
		return getElement(stateDropdown2);
	}
	public WebElement getCountryDropdown() {
		return getElement(countryDropdown);
	}
	
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
			System.out.println("Some error occured while creating element" + locator.toString());
			e.getStackTrace();
		}
		return element;
	}
	public String getPhoneVeribage() {
		ReusableMethods.scrollIntoView(getElement(phoneVeribage), driver);
		return getElement(phoneVeribage).getText();
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
	
	@Step("Check Organisation textbox is disabled.")
	public boolean checkOrganisationTextBoxIsDisabled() {
		try {
			return getElement(companyTextbox).isEnabled();

		} catch (Exception e) {
			e.getStackTrace();
			return true;// TODO: handle exception
		}
	}

	public boolean clickGoBackButton() 
	{
		try {
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
			System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>"+fieldValue);
			for(int i=0;i<fieldValue;i++) {
				String attribute = getTextBoxListElement().get(i).getAttribute("name");
				if(attribute.contentEquals("email")||attribute.contentEquals("region")) {
					System.out.println(attribute);
				}
				else {
			list.add(publicCommon.JSExecutorGetText(getTextBoxListElement().get(i),driver));
				}
			}
			System.out.println(list);
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
			ReusableMethods.scrollIntoView(getElement(clickHereSALink), driver);
			getElement(clickHereSALink).click();
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter Shipping Page Details.")
	public void addShippingPageDetails(String test) {
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),test);

			setFirstName(dataMap.get("First Name"));
			setMiddleName(dataMap.get("Middle Name"));
			setLastName(dataMap.get("Last Name"));
			setStreetAddressValue(dataMap.get("Add1"), dataMap.get("Add2"), dataMap.get("Add3"));
			setCityValue(dataMap.get("City"));
			scrollToPostalCodeField();
			setPostalCodeValue(dataMap.get("Postal Code"));
			setCountryValue(dataMap.get("Country"));
			if (getstateDropdown().getAttribute("class").contains("field _required")) {
				setStateValueDropdown(dataMap.get("State"));
			} else {
				setStateValue(dataMap.get("State"));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Shipping Page Details.")
	public void addShippingPageDetailsPTP(String test) {
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),test);

			setFirstName(dataMap.get("First NameSA"));
			setMiddleName(dataMap.get("Middle NameSA"));
			setLastName(dataMap.get("Last NameSA"));
			setPhoneNumber(dataMap.get("TelephoneSA"));
	//		setStateValue(dataMap.get("StateSA"));
			setStreetAddressValue(dataMap.get("Add1SA"), dataMap.get("Add2SA"), dataMap.get("Add3SA"));
			setCityValue(dataMap.get("CitySA"));
			scrollToPostalCodeField();
			setPostalCodeValue(dataMap.get("Postal CodeSA"));

			setCountryValue(dataMap.get("CountrySA"));
			if (getstateDropdown().getAttribute("class").contains("field _required")) {
				setStateValueDropdown(dataMap.get("StateSA"));
			} else {
				setStateValue(dataMap.get("StateSA"));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Shipping Page Details.")
	public void addShippingPageDetailsPTPWithOrgName(String sheetName, String orgName) {
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),sheetName);
			setFirstName(dataMap.get("First NameSA"));
			setMiddleName(dataMap.get("Middle NameSA"));
			setLastName(dataMap.get("Last NameSA"));
			setPhoneNumber(dataMap.get("TelephoneSA"));
			//		setStateValue(dataMap.get("StateSA"));
			setOrgCompanyField(orgName);
			setStreetAddressValue(dataMap.get("Add1SA"), dataMap.get("Add2SA"), dataMap.get("Add3SA"));
			setCityValue(dataMap.get("CitySA"));
			scrollToPostalCodeField();
			setPostalCodeValue(dataMap.get("Postal CodeSA"));

			setCountryValue(dataMap.get("CountrySA"));
			if (getstateDropdown().getAttribute("class").contains("field _required")) {
				setStateValueDropdown(dataMap.get("StateSA"));
			} else {
				setStateValue(dataMap.get("StateSA"));
			}

		} catch (Exception e) {
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


	@Step("Enter Org Name :'{0}' in TextBox.")
	public void setOrgCompanyField(String OrgName)
	{
		try {
			getElement(orgCompanyField).clear();
			getElement(orgCompanyField).sendKeys(OrgName);

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
	public void setStreetAddressValue(String streetAddress1,String streetAddress2,String streetAddress3) 
	{
		try {
			getElement(shippingAddress1Textbox).clear();
			getElement(shippingAddress1Textbox).sendKeys(streetAddress1);
			getElement(shippingAddress2Textbox).clear();
			getElement(shippingAddress2Textbox).sendKeys(streetAddress2);
			getElement(shippingAddress3Textbox).clear();
			getElement(shippingAddress3Textbox).sendKeys(streetAddress3);
			
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
	
	@Step("Enter State:'{0}' in TextBox.")
	public void setStateValueDropdown(String state) 
	{
		try {
			getElement(stateDropdown).click();
			PublicCommon.selectValueInDropdown(getElement(stateDropdown), state);
			getElement(stateDropdown).click();
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
	
	@Step("Check 'Shipping Country' Header is visible.")
	public boolean verifyShippingAddressHeaderIsVisible() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(shippingAddressHeader), driver);
			return getElement(shippingAddressHeader).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}

	@Step("Check 'PAyment Page' Header is visible.")
	public boolean verifyPaymentPageHeaderIsVisible()
	{
		try {
			ReusableMethods.scrollIntoView(getElement(paymentPageHeader), driver);
			return getElement(paymentPageHeader).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	@Step("Check 'PAyment Information page' Header is visible.")
	public boolean verifyPaymentInformationPageHeaderIsVisible()
	{
		try {
			ReusableMethods.scrollIntoView(getElement(stdPaymentHeader), driver);
			return getElement(stdPaymentHeader).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
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
	
	@Step("Click Continue Button on Shipping Address Page.")
	public PaymentDetailsPage_Public clickContinueButton() 
	{
		try {
			 getElement(shippingAddressContinueButton).click();
			 return getInstance(PaymentDetailsPage_Public.class);
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
			// TODO: handle exception
		}	
	}
	
	@Step("Click Continue Button on Shipping Address Page.")
	public boolean clickContinueButtonOnShippingPage() 
	{
		try {
			 getElement(shippingAddressContinueButton).click();
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}	
	}
	
	
	@Step("Scroll to View Postal code field on the page.")
	public void scrollToPostalCodeField() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(postalCodeTextbox), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	
//	public WebElement getAnnualBookOfASTMStandardsHeader() 
//	{	return getElement(annualBookOfASTMStandardsHeader);
//		}
//	
//	@Step("Click 'Scroll Down Arrow' that heads to BrowseBy Section .")
//	public void clickScrollDownArrowToBrowseBySection() 
//	{
//		try {
//			 getElement(scrollDownArrowToBrowseBySection).click();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			// TODO: handle exception
//		}	
//	}
//	
//	@Step("Click 'Scroll Down Arrow' that heads to Product Alerts Section .")
//	public void clickScrollDownArrowToProductAlertsSection() 
//	{
//		try {
//			 getElement(scrollDownArrowToProductAlertsSection).click();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			// TODO: handle exception
//		}	
//	}
//	
//	
//	@Step("Check BOS sections' list.")
//	public Boolean verifyBOSSectionList(List<String> expectedList) {
//
//		try {
//			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getBookOfStandardsSectionsList(), driver);
//			System.out.println(actualList);
//			return actualList.equals(expectedList);
//		} catch (Exception e) {
//			e.getStackTrace();
//			return false;
//		}
//	}
//	
//	public List<WebElement> getElements(By locator) {
//		List<WebElement> element = null;
//		try {
//			waitForElementPresent(locator);
//			element = driver.findElements(locator);
//		} catch (Exception e) {
//			System.out.println("Some error occured while creating element" + locator.toString());
//			e.getStackTrace();
//		}
//		return element;
//	}
//	
//	@Step("Scroll to View 'Annual Book of ASTM Standards' Header on the page.")
//	public void scrollToAnnualBookOfASTMStandardsHeader() 
//	{
//		try {
//			ReusableMethods.scrollIntoView(getElement(annualBookOfASTMStandardsHeader), driver);
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			// TODO: handle exception
//		}	
//	}
//	
//	@Step("Scroll to View 'Books Of Standards' Header on the page.")
//	public void scrollToBooksOfStandardsHeader() 
//	{
//		try {
//			ReusableMethods.scrollIntoView(getElement(bookOfStandardsSectionHeader), driver);
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			// TODO: handle exception
//		}	
//	}
//	
//	@Step("Scroll to View 'Browse By' Header on the page.")
//	public void scrollToBrowseByHeader() 
//	{
//		try {
//			ReusableMethods.scrollIntoView(getElement(browseBySectionHeader), driver);
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			// TODO: handle exception
//		}	
//	}
//	@Step("Scroll to View 'Product Alerts' Header on the page.")
//	public void scrollToProductAlertsHeader() 
//	{
//		try {
//			ReusableMethods.scrollIntoView(getElement(productAlertsHeader), driver);
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			// TODO: handle exception
//		}	
//	}
//	
//	
//		
//	
//	@Step("Get 'Annual Book of ASTM Standards' Header text.")
//	public String getAnnualBookOfASTMStandardsHeaderText() 
//	{
//		try {
//			return getElement(annualBookOfASTMStandardsHeader).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Get 'Books Of Standards' Header text.")
//	public String getBooksOfStandardsHeaderText() 
//	{
//		try {
//			return getElement(bookOfStandardsSectionHeader).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Get 'Browse By' Header text.")
//	public String getBrowseByHeaderText() 
//	{
//		try {
//			return getElement(browseBySectionHeader).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Get 'Product Alerts' Header text.")
//	public String getProductAlertsHeaderText() 
//	{
//		try {
//			return getElement(productAlertsHeader).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'BOS Book' Image is visible.")
//	public boolean verifyBOSBookImageIsVisible() 
//	{
//		try {
//			return getElement(BOSBookImage).isDisplayed();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'BOS Laptop' Image is visible.")
//	public boolean verifyBOSLaptopImageIsVisible() 
//	{
//		try {
//			return getElement(BOSLaptopImage).isDisplayed();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'BOS Tablet' Image is visible.")
//	public boolean verifyBOSTabletImageIsVisible() 
//	{
//		try {
//			return getElement(BOSTabletImage).isDisplayed();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'BOS Standards By Category' Image is visible in 'Browse By' section.")
//	public boolean verifyBOSStandardsByCategoryImageIsVisible() 
//	{
//		try {
//			return getElement(BOSStandardsByCategoryImage).isDisplayed();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'BOS Compilations' Image is visible in 'Browse By' section.")
//	public boolean verifyBOSCompilationsImageIsVisible() 
//	{
//		try {
//			return getElement(BOSCompilationsImage).isDisplayed();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	@Step("Check 'ASTM Compass' Image is visible in 'Browse By' section.")
//	public boolean verifyASTMCompassImageIsVisible() 
//	{
//		try {
//			return getElement(ASTMCompassImage).isDisplayed();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Get 'Standards By Category' text in 'Browse By' section.")
//	public String getStandardsByCategoryText() 
//	{
//		try {
//			return getElement(standardsByCategoryText).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Get 'Compilations' text in 'Browse By' section.")
//	public String getCompilationsText() 
//	{
//		try {
//			return getElement(compilationsText).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Get 'ASTM Compass' text in 'Browse By' section..")
//	public String getASTMCompassText() 
//	{
//		try {
//			return getElement(ASTMCompassText).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'Standards By Category' Description text.")
//	public boolean verifyStandardsByCategoryDescriptionText(String expectedDescription) 
//	{
//		try {
//			return getElement(standardsByCategoryDescription).getText().equals(expectedDescription);
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'Compilations' Description text.")
//	public boolean verifyCompilationsDescriptionText(String expectedDescription) 
//	{
//		try {
//			return getElement(compilationsDescription).getText().equals(expectedDescription);
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'ASTM Compass' Description text.")
//	public boolean verifyASTMCompassDescriptionText(String expectedDescription) 
//	{
//		try {
//			return getElement(ASTMCompassDescription).getText().equals(expectedDescription);
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return false;// TODO: handle exception
//		}	
//	}
//		
//	@Step("Get 'Product Alerts' Description text.")
//	public String getProductAlertsDescriptionText() 
//	{
//		try {
//			return getElement(productAlertsDescription).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'Browse By Category'  button is clickable and get text on button.")
//	public String getBrowseByCategoryButtonText() 
//	{
//		try {
//			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(learnMoreAboutCompassButton));
//			return getElement(browseByCategoryButton).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'Browse Compilations'  button is clickable and get text on button.")
//	public String getBrowseCompilationsButtonText() 
//	{
//		try {
//			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(browseCompilationsButton));
//			return getElement(browseCompilationsButton).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	@Step("Check 'Signup For Product Alerts'  button is clickable and get text on button.")
//	public String getSignupForProductAlertsButtonText() 
//	{
//		try {
//			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(signupForProductAlertsButton));
//			return getElement(signupForProductAlertsButton).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	
//	@Step("Get 'Learn more about Compass'  button is clickable and get text on button.")
//	public String getASTMProductLearnButtonText() 
//	{
//		try {
//			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(learnMoreAboutCompassButton));
//			return getElement(learnMoreAboutCompassButton).getText();
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//			return null;// TODO: handle exception
//		}	
//	}
//	
//	
}
