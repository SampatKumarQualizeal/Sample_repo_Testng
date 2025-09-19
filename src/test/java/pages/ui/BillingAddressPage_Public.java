package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class BillingAddressPage_Public extends BasePage {
	PublicCommon publicCommon;
	JsonFileReader jsonFileReader;

	public BillingAddressPage_Public(WebDriver driver) {
		super(driver);
		publicCommon = new PublicCommon(driver);
	}
	public By addressValidationPopupContinueBtn=By.xpath("//button[contains(@class,'action-accept')]/span[text()='Continue']");
	public By firstNameTextbox = By.cssSelector("div[name='billingAddress.firstname'] input");
	public By lastNameTextbox = By.cssSelector("div[name='billingAddress.lastname'] input");
	public By middleNameTextbox = By.cssSelector("div[name='billingAddress.middlename'] input");
	public By companyTextbox = By.cssSelector("div[name='billingAddress.company'] input");
	public By companytextbox = By.cssSelector("div[name='billingAddress.company']");
	public By companyAffiliationCheckbox = By.cssSelector("div[class='field company_affiliation'] input");
	public By companyAffiliation = By.xpath("//label[@class='admin__field-label custom-control-label']");
	private By companyAffiliationText = By
			.cssSelector("div[class='field company_affiliation'] label[class*='field-label']");
	public By billingAddress1Textbox = By.cssSelector("div[name='billingAddress.street.0'] input");
	public By billingAddress2Textbox = By.cssSelector("div[name='billingAddress.street.1'] input");
	public By billingAddress3Textbox = By.cssSelector("div[name*='billingAddress.street.2'] input");
	public By cartButton=By.xpath("//span[text()='Cart']");
	public By spinner = By.cssSelector(".spinner-border");


	private By ContinueBtn=By.xpath("//button[contains(@class,'action-accept')]");
	private By cannotShipBAText = By
			.xpath("//div[@name='billingAddress.street.0']//span[contains(text(),'ASTM cannot')]");
	private By clickHereBALink = By.xpath("//div[@name='billingAddress.street.0']//a[contains(text(),'Click')]");
	private By clickHerePopup = By.xpath("//h5[text()='Shipping to PO Box addresses']");
	public By cityTextbox = By.cssSelector("div[name='billingAddress.city'] input");
	public By stateTextbox = By.cssSelector("div[name='billingAddress.region'] input");
	public By stateDropdown = By.cssSelector("div[name='billingAddress.region_id'] select");
	public By stateDropdown2 = By.cssSelector("div[name='billingAddress.region_id']");
	public By postalCodeTextbox = By.cssSelector("div[name*='billingAddress.postcode'] input");
	public By countryDropdown = By.xpath("//div[@name='billingAddress.country_id']//select");
	public By phoneTextbox = By.name("telephone");
	private By phoneMessage = By
			.xpath("//div[@name='billingAddress.telephone']//span[contains(text(),'Please do not')]");
	public By emailTextbox = By.cssSelector("*[name='billingAddress.email'] *[name='email']");
	private By emailMessage = By.xpath("//span[text()='Required for Order Confirmation and Support']");
	private By SAMessage = By.xpath("//span[text()='Shipping address is the same as billing address']");
	public By SAMessageCheckbox = By.xpath("//input[@type='checkbox' and @name='shipping-address-same-as-billing']");

	private By errorMessageForStateRequired = By
			.xpath("//*[@name='billingAddress.region_id']//*[text()='This is a required field.']");

	public By countrySanctionedErrorMessage = By.xpath("//div[@class='alert astm-alert bg-danger--light']/div");
	public By countrySanctionedMessageCloseButton = By
			.xpath("//div[@class='alert astm-alert bg-danger--light']/button");
	private By errorMessageList = By.className("field-error");
	public By billingAddressHeader = By.xpath("//h2[text()='Billing Address']");
	public By billingAddressContinueButton = By.xpath("(//button[@class='continue primary btn astm-btn btn-primary']/span[text()='Continue'])[1]");
	public By UseSelectedAddress = By.xpath("//span[text()='Use Selected Address']");
			//By.xpath("//button[contains(@data-bind,'click: saveBillingAddress')]");
	// By.cssSelector("button[data-bind*='saveBillingAddress']");
	public By loader = By.id("checkout-loader");
	private By textBoxListElement = By.cssSelector("div[name*='billingAddress'] input");
	private By textBoxListExceptStateByRegion = By
			.xpath("//div[contains(@name,'billingAddress')]//input[@name!='region']");
	private By getShippingOptionsListElement = By.cssSelector(".ptp-shipping-address-group label");

	private By getShipToSameAddressAndSameContactPersonOption = By
			.xpath("//*[text()='Ship to same address and same contact person']");
	private By getShipToSameAddressAndDifferentContactPersonOption = By
			.xpath("//*[text()='Ship to same address and different contact person ']");
	private By getShipToDifferentAddressOption = By.xpath("//*[text()='Ship to different address']");

	public By firstNameLabel = By.xpath("//div[@name='billingAddress.firstname']//span");
	public By middleNameLabel = By.xpath("//div[@name='billingAddress.middlename']//span");
	public By lastNameLabel = By.xpath("//div[@name='billingAddress.lastname']//span");
	public By lastNameVeribage = By
			.xpath("//div[@name='billingAddress.lastname']//span[contains(text(),'customer contact')]");
	public By orgCompanyLabel = By.xpath("//div[@name='billingAddress.company']//span");
	public By streetLabel = By.xpath("//fieldset[@id='billing-new-address-form']/fieldset/legend/span");
	public By streetVeribage = By.xpath("//div[@name='billingAddress.street.0']//span[contains(text(),'ASTM cannot')]");
	public By streetVeribageAPI = By
			.xpath("//div[@name='billingAddress.street.0']//span[contains(text(),'API cannot')]");
	public By cityLabel = By.xpath("//div[@name='billingAddress.city']//span");
	public By stateLabel = By.xpath("//div[@name='billingAddress.region']//span");
	public By postCodeLabel = By.xpath("//div[@name='billingAddress.postcode']//span");
	public By countryLabel = By.xpath("//div[@name='billingAddress.country_id']//span");
	public By phoneLabel = By.xpath("//div[@name='billingAddress.telephone']//span[text()='Phone']");
	public By phoneVeribage = By
			.xpath("//div[@name='billingAddress.telephone']//span[contains(text(),'country code')]");
	public By emailLabel = By.xpath("//div[@name='billingAddress.email']//span[text()='Email']");
	public By emailVeribage = By
			.xpath("//div[@name='billingAddress.email']//span[contains(text(),'Required for Order')]");
	public By emailErrorMessage = By.xpath(
			"//div[@name='billingAddress.email']//span[contains(text(),'Please enter a valid email address (Ex: johndoe@domain.com).')]");
	public By checkboxVeribage = By
			.xpath("//div[@name='billingAddress.company']//following::label[contains(text(),'Check here')]");
	public By warningMessages =By.xpath("//*[@class='astm-alert-text' and contains(text(),'United States Department of Treasury')]");
	public By warningMessagesList = By.className("astm-alert-text");// By.cssSelector(".warning-container div");
	public By warningMessageVisible = By
			.xpath("//*[@class='astm-alert-text']/ancestor::div[contains(@data-bind,'visible:')]");
	public By billingAddressAlert = By.xpath("//span[@class='astm-alert-text'][contains(text(),'One or more')]");
	public By allBillingAddressFields = By.xpath(
			"//div[@class='billing-address-step']//div[not(contains(@style,'none'))]/div[@class='control']/input[@type='text']");
	public By billingCountryAndState = By.xpath(
			"//div[@class='billing-address-step']//div[not(contains(@style,'none'))]/div[@class='control']/select");
	public By billingNotSameAsShippingRadioButton = By
			.xpath("//*[@id='checkout-step-shipping']/div[1]/div[2]/label/span");
	public By shippingDetailsTextBoxes = By.xpath(
			"//div[@class='shipping-address-step']//div[not(contains(@style,'none'))]/div[@class='control']/input[@type='text']");
	public By shippingDetailDropDown = By.xpath(
			"//div[@class='shipping-address-step']//div[not(contains(@style,'none'))]/div[@class='control']/select");
	public By noChangeBtn = By.xpath("//button[contains(@data-bind,'cancelChangesBilling')]");
	public By continueBtn = By.xpath("//button[contains(@data-bind,'saveBillingAddress')]");
	public By AddressValidationHeader = By.xpath("//header[@class='modal-header']/h1[contains(text(),'Address Validation')]");
	public By AddressValContinueBtn = By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']/span[text()='Continue']");
	public By HazardousWarningText = By.xpath("//span[contains(text(),'One or more of the products in your cart contains a hazardous material')]");

	private By useSelectedAddressBTN=By.xpath("//span[contains(text(),'Use Selected Address')]/parent::button");
	public By AddmodelBoxText=By.xpath("//div[contains(text(),'We can not')]");
	private By useSelAddressTitleMagento=By.xpath("(//h1[@class='modal-title'])[4]");
	private By AddressEnteredRadio=By.xpath("//input[@id='entered']");
	public By UseSelAddText=By.xpath("//div[contains(text(),'We have slightly modified')]");
	public By confirmAddressValidation = By.xpath("//div[@class='address-modal-description']");
	public By wrongAddressValidation = By.xpath("//div[contains(text(),'Do you want to proceed')]/..");
	private By useSelAddressTitle=By.xpath("//div[contains(text(),'We can not')]/parent::div/parent::div/descendant::h1");

	public WebElement getFirstNameTextboxElement() {
		return getElement(firstNameTextbox);
	}

	public WebElement getMiddleNameTextFieldElement() {
		return getElement(middleNameTextbox);
	}

	public WebElement getLastNameAccountPageElement() {
		return getElement(lastNameTextbox);
	}

	public By getnoChangeBtn()
	{
		return noChangeBtn;
	}
	public By getcontinueBtn()
	{
		return continueBtn;
	}
	/*
	 * public WebElement getEmailTextboxElement() { return getElement(emailTextbox);
	 * }
	 */
	public String getEmailTextboxElement1() {
		try {
			return getElement(emailTextbox).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getFirstNameText() {
		try {
			return getElement(firstNameTextbox).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getMiddleNameText() {
		try {
			return getElement(middleNameTextbox).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getLastNameText() {
		try {
			return getElement(lastNameTextbox).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getCountySanctionedErrorMsg() {
		return getElements(countrySanctionedErrorMessage);
	}

	public WebElement getstateDropdown() {
		return getElement(stateDropdown2);
	}

	public WebElement getWarningMessageVisible() {
		return getElement(warningMessageVisible);
	}

	public String getLastNameVeribage() {
		return getElement(lastNameVeribage).getText();
	}

	public String getStreetVeribage() {
		return getElement(streetVeribage).getText();
	}

	public String getStreetVeribageAPI() {
		return getElement(streetVeribageAPI).getText();
	}

	public String getEmailVeribage() {
		return getElement(emailVeribage).getText();
	}

	public String getPhoneVeribage() {
		return getElement(phoneVeribage).getText();
	}

	public String getCheckboxVeribage() {
		return getElement(checkboxVeribage).getText();
	}

	public By getCountryDropdown() {
		return countryDropdown;
	}

	public void setCountryDropdown(By countryDropdown) {
		this.countryDropdown = countryDropdown;
	}

	public PublicCommon getPublicCommon() {
		return publicCommon;
	}

	public By getFirstNameTextbox() {
		return firstNameTextbox;
	}

	public By getLastNameTextbox() {
		return lastNameTextbox;
	}

	public By getMiddleNameTextbox() {
		return middleNameTextbox;
	}

	public By getCompanyTextbox() {
		return companyTextbox;
	}

	public By getCompanyAffiliationCheckbox() {
		return companyAffiliationCheckbox;
	}

	public By getCompanyAffiliationText() {
		return companyAffiliationText;
	}

	public By getBillingAddress1Textbox() {
		return billingAddress1Textbox;
	}
	public WebElement BillingAddress1Textbox() {
		return getElement(billingAddress1Textbox);
	}
	public WebElement BillingAddress2Textbox() {
		return getElement(billingAddress2Textbox);
	}

	public By getBillingAddress2Textbox() {
		return billingAddress2Textbox;
	}

	public By getBillingAddress3Textbox() {
		return billingAddress3Textbox;
	}

	public By getCannotShipBAText() {
		return cannotShipBAText;
	}

	public By getClickHereBALink() {
		return clickHereBALink;
	}

	public By getClickHerePopup() {
		return clickHerePopup;
	}

	public By getCityTextbox() {
		return cityTextbox;
	}

	public By getStateTextbox() {
		return stateTextbox;
	}

	public By getStateDropdown() {
		return stateDropdown;
	}

	public By getPostalCodeTextbox() {
		return postalCodeTextbox;
	}

	public WebElement getPostalCodeTextboxElement() {
		return getElement(postalCodeTextbox);
	}

	public By getPhoneTextbox() {
		return phoneTextbox;
	}
	public String getPhoneTextbox1() {
		try {
			return getElement(phoneTextbox).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public By getPhoneMessage() {
		return phoneMessage;
	}

	public By getEmailTextbox() {
		return emailTextbox;
	}

	public WebElement getEmailTextboxElement() {
		return getElement(emailTextbox);
	}

	public By getEmailMessage() {
		return emailMessage;
	}

	public By getSAMessage() {
		return SAMessage;
	}

	public By getSAMessageCheckbox() {
		return SAMessageCheckbox;
	}

	public By getErrorMessageForStateRequired() {
		return errorMessageForStateRequired;
	}

	public By getCountrySanctionedErrorMessage() {
		return countrySanctionedErrorMessage;
	}

	public By getCountrySanctionedMessageCloseButton() {
		return countrySanctionedMessageCloseButton;
	}

	public By getBillingAddressHeader() {
		return billingAddressHeader;
	}

	public By getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}

	public WebElement getBillingAddressContinueBtn() {
		return getElement(billingAddressContinueButton);
	}

	public By getLoader() {
		return loader;
	}

	public By getGetShippingOptionsListElement() {
		return getShippingOptionsListElement;
	}

	public By getGetShipToSameAddressAndSameContactPersonOption() {
		return getShipToSameAddressAndSameContactPersonOption;
	}

	public By getGetShipToSameAddressAndDifferentContactPersonOption() {
		return getShipToSameAddressAndDifferentContactPersonOption;
	}

	public By getGetShipToDifferentAddressOption() {
		return getShipToDifferentAddressOption;
	}

	public By getFirstNameLabel() {
		return firstNameLabel;
	}

	public By getMiddleNameLabel() {
		return middleNameLabel;
	}

	public By getLastNameLabel() {
		return lastNameLabel;
	}

	public By getOrgCompanyLabel() {
		return orgCompanyLabel;
	}

	public By getStreetLabel() {
		return streetLabel;
	}

	public By getCityLabel() {
		return cityLabel;
	}

	public By getStateLabel() {
		return stateLabel;
	}

	public By getPostCodeLabel() {
		return postCodeLabel;
	}

	public By getCountryLabel() {
		return countryLabel;
	}

	public By getPhoneLabel() {
		return phoneLabel;
	}

	public By getEmailLabel() {
		return emailLabel;
	}

	public By getWarningMessagesList() {
		return warningMessagesList;
	}

	public WebElement getCompanyAffilationCheckbox() {
		return getElement(companyAffiliationCheckbox);
	}

	public List<WebElement> getWarningMessageListElement() {
		return getElements(warningMessagesList);
	}

	public String getHazardousWarningMessage(){
		return getElement(HazardousWarningText).getText();
	}

	public WebElement getWarningMessageElement() {
		return getElement(warningMessages);
	}
	public List<WebElement> getErrorMessageListElement() {
		return getElements(errorMessageList);
	}

	public List<WebElement> getTextBoxListElement() {
		return getElements(textBoxListElement);
	}

	public List<WebElement> getTextBoxListElementExceptState() {
		return getElements(textBoxListExceptStateByRegion);
	}

	public List<WebElement> getAllBillingDetails() {
		return getElements(allBillingAddressFields);
	}

	public List<WebElement> getAllShippingDetails() {
		return getElements(shippingDetailsTextBoxes);
	}

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

	@Step("Enter Billing Address Details.")
	public boolean addbillingPageDetails_WithoutContinue(String test) {
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),
					test);
			setFirstName(dataMap.get("First Name"));
			setMiddleName(dataMap.get("Middle Name"));
			setLastName(dataMap.get("Last Name"));
//			setOrganisationValue(dataMap.get("Company"));
			setStreetAddressValue(dataMap.get("Add1"), dataMap.get("Add2"), dataMap.get("Add3"));
			setCityValue(dataMap.get("City"));
			scrollToPostalCodeField();
			setPostalCodeValue(dataMap.get("Postal Code"));
			setPhoneNumber(dataMap.get("Telephone"));
			setCountryValue(dataMap.get("Country"));
//			if (getstateDropdown().getAttribute("class").contains("field _required")) {
//				setStateValueDropdown(dataMap.get("State"));
//			} else {
//				setStateValue(dataMap.get("State"));
//			}
			setStateValueDropdown(dataMap.get("State"));
			// clickContinueButton();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public boolean selectShipToSameAddressAndSameContactPersonOption() {
		try {
			ReusableMethods.scrollIntoView(getElement(getShipToSameAddressAndSameContactPersonOption), driver);
			getElement(getShipToSameAddressAndSameContactPersonOption).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	public boolean selectShipToSameAddressAndDifferentContactPersonOption() {
		try {
			getElement(getShipToSameAddressAndDifferentContactPersonOption).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	public boolean selectShipToDifferentAddressOption() {
		try {
			getElement(getShipToDifferentAddressOption).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			publicCommon.reportFailAssert("Exception occured while selecting Shipping option", e);
			return false;// TODO: handle exception
		}
	}

	/**
	 * This method used to Select Shipping Option <br>
	 * "Same Contact" --- select ShipTo Same Address And Same Contact Person Option
	 * <br>
	 * "Different Contact" -- select ShipTo Same Address And Different Contact
	 * Person Option <br>
	 * "Different Address" -- select ShipTo Different Address Option
	 * 
	 * @param shippingOption
	 * @return True/false
	 */
	public boolean selectShippingOption(String shippingOption) {
		try {
			if(isElementDisplayed(getElement(getShipToSameAddressAndSameContactPersonOption))) {
				PublicCommon.waitForSec(6);
				if (shippingOption.equalsIgnoreCase("Same Contact")) {
					PublicCommon.JSClick(getElement(getShipToSameAddressAndSameContactPersonOption), driver);
					// getElement(getShipToSameAddressAndSameContactPersonOption).click();
				} else if (shippingOption.equalsIgnoreCase("Different Contact")) {
					PublicCommon.JSClick(getElement(getShipToSameAddressAndDifferentContactPersonOption), driver);
				} else if (shippingOption.equalsIgnoreCase("Different Address")) {
					PublicCommon.JSClick(getElement(getShipToDifferentAddressOption), driver);
					// getElement(getShipToDifferentAddressOption).click();
				} else {
					System.out.println("Shipping Option not valid");
					return false;
				}
			}
			else {
				if (shippingOption.equalsIgnoreCase("Different Address")) {
					ReusableMethods.scrollIntoView(getElement(SAMessageCheckbox),driver);
					unCheckShippingAddressCheckbox();
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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

	@Step("Check Shipping Address is same as Billing Address Checkbox Is Selected.")
	public boolean checkShippingAddressSameCheckboxIsSelected() {
		try {
			return getElement(SAMessageCheckbox).isSelected();

		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check Shipping Address is same as Billing Address Checkbox Is Not Selected.")
	public boolean checkShippingAddressSameCheckboxIsNotSelected() {
		try {
			return getElement(SAMessageCheckbox).isSelected();

		} catch (Exception e) {
			e.getStackTrace();
			return true;// TODO: handle exception
		}
	}

	public boolean unCheckShippingAddressCheckbox() {
		try {
			System.out.println(getElement(SAMessageCheckbox).isSelected());
			System.out.println(getElement(SAMessage).isSelected());
			if (getElement(SAMessageCheckbox).isSelected()) {
				PublicCommon.JSClick(getElement(SAMessageCheckbox), driver);
				// getElement(SAMessageCheckbox).click();
			}
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Check 'Shipping address is the same as billing address' Checkbox.")
	public void checkShippingAddressCheckbox() {
		try {
			if (!getElement(SAMessageCheckbox).isSelected()) {
				getElement(SAMessage).click();
			}

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Get 'Email Address' from TextBox.")
	public String getEmailAddressValue() {
		try {
			return publicCommon.JSExecutorGetText(getElement(emailTextbox), driver);

		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Get 'Country' from TextBox.")
	public String getCountryValue() {
		try {
			Assert.assertEquals(PublicCommon.getAllSelectedValueInDropdown(getElement(countryDropdown), driver).size(),
					1, "More than one country has been selected");
			System.out.println("Country Options:::::"
					+ PublicCommon.getFirstSelectedValueInDropdown(getElement(countryDropdown)).getText());
			return PublicCommon.getFirstSelectedValueInDropdown(getElement(countryDropdown)).getText();

		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
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

	@Step("Get 'State' from Dropdown.")
	public String getStateValue() {
		try {
			Assert.assertEquals(PublicCommon.getAllSelectedValueInDropdown(getElement(stateDropdown), driver).size(), 1,
					"More than one country has been selected");
			System.out.println("State Options:::::"
					+ PublicCommon.getFirstSelectedValueInDropdown(getElement(stateDropdown)).getText());
			return PublicCommon.getFirstSelectedValueInDropdown(getElement(stateDropdown)).getText();

		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Get all field values from TextBox.")
	public List<String> getAllFieldValues() {
		try {
			int fieldValue = getTextBoxListElement().size();
			List<String> list = new ArrayList<String>();

			for (int i = 0; i < fieldValue; i++) {

				list.add(publicCommon.JSExecutorGetText(getTextBoxListElement().get(i), driver));
			}
			return list;

		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Get all field values from TextBox.")
	public List<String> getAllFieldValuesExceptState() {
		try {
			int fieldValue = getTextBoxListElementExceptState().size();
			List<String> list = new ArrayList<String>();

			for (int i = 0; i < fieldValue; i++) {

				list.add(publicCommon.JSExecutorGetText(getTextBoxListElementExceptState().get(i), driver));
			}
			return list;

		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public List<String> getAllShippingOptions() {
		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getElements(getShippingOptionsListElement), driver);

		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public boolean clearEmailAddressValue() {
		try {
			getElement(emailTextbox).clear();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Click on 'Click Here' Link.")
	public void clickOnClickHereLink() {
		try {
			ReusableMethods.scrollIntoView(getElement(clickHereBALink), driver);
			getElement(clickHereBALink).click();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Click Company Affiliation Checkbox.")
	public void clickCompanyAffiliationCheckbox() {
		try {
			if (!getElement(companyAffiliationCheckbox).isSelected()) {
				getElement(companyAffiliationText).click();
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter {0}:'{1}' in TextBox.")
	public void setValueInTextbox(String fieldName, String fieldValue, WebElement element) {
		try {
			element.clear();
			element.sendKeys(fieldValue);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter First Name :'{0}' in TextBox.")
	public void setFirstName(String firstName) {
		try {
			getElement(firstNameTextbox).clear();
			getElement(firstNameTextbox).sendKeys(firstName);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Middle Name :'{0}' in TextBox.")
	public void setMiddleName(String middleName) {
		try {
			getElement(middleNameTextbox).clear();
			getElement(middleNameTextbox).sendKeys(middleName);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Last Name :'{0}' in TextBox.")
	public void setLastName(String lastName) {
		try {
			getElement(lastNameTextbox).clear();
			getElement(lastNameTextbox).sendKeys(lastName);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Organisation :'{0}' in TextBox.")
	public void setOrganisationValue(String company) {
		try {
			getElement(companyTextbox).clear();
			getElement(companyTextbox).sendKeys(company);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Street Address in TextBox.")
	public void setStreetAddressValue(String streetAddress1, String streetAddress2, String streetAddress3) {
		try {
			getElement(billingAddress1Textbox).clear();
			getElement(billingAddress1Textbox).sendKeys(streetAddress1);
			getElement(billingAddress2Textbox).clear();
			getElement(billingAddress2Textbox).sendKeys(streetAddress2);
			getElement(billingAddress3Textbox).clear();
			getElement(billingAddress3Textbox).sendKeys(streetAddress3);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Street Address in TextBox.")
	public void setStreetAddress1Value(String streetAddress1) {
		try {
			getElement(billingAddress1Textbox).clear();
			getElement(billingAddress1Textbox).sendKeys(streetAddress1);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter City:'{0}' in TextBox.")
	public void setCityValue(String city) {
		try {
			getElement(cityTextbox).clear();
			getElement(cityTextbox).sendKeys(city);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter State:'{0}' in TextBox.")
	public void setStateValue(String state) {
		try {
			getElement(stateTextbox).clear();
			Thread.sleep(1000);
			getElement(stateTextbox).sendKeys(state);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Country:'{0}' in TextBox.")
	public void setCountryValue(String country) {
		try {
			waitForElementPresent(countryDropdown);
			PublicCommon.JSClick(getElement(countryDropdown), driver);
			PublicCommon.selectValueInDropdown(getElement(countryDropdown), country);
			getElement(countryDropdown).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public boolean clickOnCountryDopDown() {

		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(countryDropdown));
			getElement(countryDropdown).click();
			// PublicCommon.JSClick(getElement(countryDropdown), driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Enter State:'{0}' in TextBox.")
	public void setStateValueDropdown(String state) {
		try {
			getElement(stateDropdown).click();
			PublicCommon.selectValueInDropdown(getElement(stateDropdown), state);
			getElement(stateDropdown).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Postal Code:'{0}' in TextBox.")
	public void setPostalCodeValue(String postalCode) {
		try {
			getElement(postalCodeTextbox).clear();
			getElement(postalCodeTextbox).sendKeys(postalCode);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Phone Number :'{0}' in TextBox.")
	public void setPhoneNumber(String telephone) {
		try {
			getElement(phoneTextbox).clear();
			getElement(phoneTextbox).sendKeys(telephone);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Enter Email Address:'{0}' in TextBox.")
	public void setEmailAddressValue(String email) {
		try {
			getElement(emailTextbox).clear();
			getElement(emailTextbox).sendKeys(email);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Check 'Billing Address' Header is visible.")
	public boolean verifyBillingAddressHeaderIsVisible() {
		try {
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(loader)));
			} catch (Exception e) {

			}
			return getElement(billingAddressHeader).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Shipping to PO Box Addresses' Pop-up is visible.")
	public boolean verifyAddressPopupIsVisible() {
		try {
			return getElement(clickHerePopup).isDisplayed();
		} catch (Exception e) {
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
	public String getErrorMsg(){
		try {
			ReusableMethods.scrollIntoView(getElement(warningMessagesList), driver);
			return PublicCommon.getText(driver, warningMessages);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public List<String> getWarningMessageList() {

		try {
			// if (getWarningMessageListElement().size() > 0)
			ReusableMethods.scrollIntoView(getElement(warningMessagesList), driver);
			return PublicCommon.getListOfTextFromListOfWebelements(getWarningMessageListElement(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Click Continue Button on Billing Address Page and navigate to Shipping Address Page.")
	public ShippingAddressPage_Public clickContinueSAButton() {
		try {
			getElement(billingAddressContinueButton).click();
			return getInstance(ShippingAddressPage_Public.class);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
			// TODO: handle exception
		}
	}

	@Step("Click Continue Button on Billing Address Page.")
	public boolean clickContinueButton() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(billingAddressContinueButton));
			getElement(billingAddressContinueButton).click();
			PublicCommon.waitForSec(10);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			Assert.fail("Failed to click on Continue button", e);
			return false;
		}
	}

	@Step("Click Continue Button on Billing Address Page and navigate to Payment Page.")
	public PaymentDetailsPage_Public clickContinuePayButton() {
		try {
			getElement(billingAddressContinueButton).click();
			return getInstance(PaymentDetailsPage_Public.class);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
			// TODO: handle exception
		}
	}

	@Step("Scroll to View Organisation field on the page.")
	public void scrollToCompanyField() {
		try {
			ReusableMethods.scrollIntoView(getElement(companyTextbox), driver);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Scroll to View Postal code field on the page.")
	public void scrollToPostalCodeField() {
		try {
			ReusableMethods.scrollIntoView(getElement(postalCodeTextbox), driver);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Enter Billing Address Details.")
	public boolean addbillingPageDetails(String test) {
		boolean value=false;
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),
					test);
			setFirstName(dataMap.get("First Name"));
			setMiddleName(dataMap.get("Middle Name"));
			setLastName(dataMap.get("Last Name").concat(String.valueOf(System.currentTimeMillis())));
			setStreetAddressValue(dataMap.get("Add1").concat(String.valueOf(System.currentTimeMillis())), dataMap.get("Add2"), dataMap.get("Add3"));
			setCityValue(dataMap.get("City"));
			scrollToPostalCodeField();
			setPostalCodeValue(dataMap.get("Postal Code"));
			setPhoneNumber(dataMap.get("Telephone"));
			setCountryValue(dataMap.get("Country"));
			setStateValueDropdown(dataMap.get("State"));
			Assert.assertFalse(getElement(emailTextbox).isEnabled(), "Email Text Box under Billing Address Should not be Enabled");
			clickContinueButton();
			value=true;
		}catch (Exception e) {
			e.getStackTrace();
			PublicAdminCommons.reportFailAssert("Unable to Add Billing Address",e);
		}
		return value;
	}
		@Step("Enter Billing Address Details.")
		public boolean enterBillingAddressDetails(String filename,String JsonPrimeElement) {
			try {
				jsonFileReader=new JsonFileReader();
				setFirstName(jsonFileReader.getJsonString(filename,JsonPrimeElement,"firstName"));
				setMiddleName(jsonFileReader.getJsonString(filename,JsonPrimeElement,"middleName"));
				setLastName(jsonFileReader.getJsonString(filename,JsonPrimeElement,"lastName"));
				setStreetAddress1Value(jsonFileReader.getJsonString(filename,JsonPrimeElement,"addressLine1"));
				setCityValue(jsonFileReader.getJsonString(filename,JsonPrimeElement,"city"));
				scrollToPostalCodeField();
				setPostalCodeValue(jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"));
				setPhoneNumber(jsonFileReader.getJsonString(filename,JsonPrimeElement,"phone"));
				setCountryValue(jsonFileReader.getJsonString(filename,JsonPrimeElement,"country"));
				setStateValueDropdown(jsonFileReader.getJsonString(filename,JsonPrimeElement,"state"));
				Assert.assertFalse(getElement(emailTextbox).isEnabled(),"Email Text Box under Billing Address Should not be Enabled");
				clickContinueButton();
				PublicCommon.waitForSec(10);
				return true;
			}catch (Exception e) {
			e.getStackTrace();
			PublicAdminCommons.reportFailAssert("Unable to Add Billing Address",e);
			return false;
		}
	}

	@Step("Enter Billing Address Details.")
	public boolean addbillingPageDetail(String test) {
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),
					test);
			setFirstName(dataMap.get("First Name"));
			setMiddleName(dataMap.get("Middle Name"));
			setLastName(dataMap.get("Last Name"));
//			setOrganisationValue(dataMap.get("Company"));
			setStreetAddressValue(dataMap.get("Add1"), dataMap.get("Add2"), dataMap.get("Add3"));
			setCityValue(dataMap.get("City"));
			scrollToPostalCodeField();
			setPostalCodeValue(dataMap.get("Postal Code"));
			setPhoneNumber(dataMap.get("Telephone"));
			setCountryValue(dataMap.get("Country"));
//			if (getstateDropdown().getAttribute("class").contains("field _required")) {
//				setStateValueDropdown(dataMap.get("State"));
//			} else {
//				setStateValue(dataMap.get("State"));
//			}
			setStateValueDropdown(dataMap.get("State"));
			// clickContinueButton();
			return true;
		}

		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean checkSanctionCountryErrorMsgIsVisible() {
		try {
			return getElement(countrySanctionedErrorMessage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/*
	 * 
	 * click on X icon on error message
	 */

	public boolean clickOnX_Icon() {
		try {
			waitForElementPresent(countrySanctionedMessageCloseButton);
			PublicCommon.JSClick(getElement(countrySanctionedMessageCloseButton), driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			Assert.fail("could not click on close button", e);
			return false;
		}
	}

	public By getContinueBtn() {
		return ContinueBtn;
	}

	public void SelectCubaCountryFromDropdown(String sheetName, String WebdataSheetName){
		try{
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			selectValue("Country", countryDropdown, dataMapBilling.get("country"), "Select Country from Drop down");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter billing address details", e);
		}
	}


	@Step("Entering Billing Information")
	public void enterBillingAddress(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			PublicCommon.waitForSec(15);
			enterText("First Name", firstNameTextbox, dataMapBilling.get("firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", middleNameTextbox, dataMapBilling.get("middleName"), "Enter Middle Name in TextBox");
			enterText("Last Name", lastNameTextbox, dataMapBilling.get("lastName"), "Enter Last Name in TextBox");

			enterText("Street Address in Line 1", billingAddress1Textbox, dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");

			enterText("City", cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(postCodeLabel), driver);
			enterText("Postal Code", postalCodeTextbox, dataMapBilling.get("postalCode"), "Enter Postal Code in TextBox");
			selectValue("Country", countryDropdown, dataMapBilling.get("country"), "Select Country from Drop down");
			selectValue("State", stateDropdown, dataMapBilling.get("state"), "Select State from Drop down");
			enterText("Phone", phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(2);
			clickONMethod("Continue Button ", billingAddressContinueButton, "Continue button should be clickable");
			clickModelContinueButton();
			PublicCommon.waitForSec(5);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	@Step("Click Continue Address Verification Button on Billing Address Page.")
	public boolean clickModelContinueButton() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getContinueBtn()),10);
			if(getElement(getContinueBtn()).isDisplayed()) {
				getElement(getContinueBtn()).click();
			}

			return true;
		} catch (Exception e) {
			e.getStackTrace();
			Assert.fail("Failed to click on Address Validation Model Continue button", e);
			return false;
		}
	}
	@Step("Enter {elementName} :'{keys}' in TextBox.")
	public void enterText(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clearTxtFieldsendKeys(driver, locator, keys), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Enter data in Text box", e);
		}
	}

	@Step("Select {elementName}: '{keys}'in DropDown")
	public void selectValue(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.selectValueInDropdown(getElement(locator), keys), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select value from dropdown.", e);
		}
	}

	@Step("Click on {elementName}")
	private void clickONMethod(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	public Boolean isElementDisplayed(WebElement Element)
	{
		Boolean Value=false;
		try{
			if(Element.isDisplayed())
				Value=true;
			else
				Value=false;
		} catch (Exception e) {
			Value=false;
		}
		return Value;
	}

	public String getConfirmAddressValidation() {
		try{
			PublicCommon.waitForSec(5);
			return PublicCommon.getText(driver,confirmAddressValidation);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public String getWrongAddressValidation() {
		try{
			PublicCommon.waitForSec(3);
			return PublicCommon.getText(driver,wrongAddressValidation);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public By getEnteredAddressRadioBtn() {
		return AddressEnteredRadio;
	}


	public By getModelBoxTitleMagento() {
		return useSelAddressTitleMagento;
	}


	public By getUseSelectedAddressBTN() {
		return useSelectedAddressBTN;
	}


	public By getModelBoxTitle() {
		return useSelAddressTitle;
	}




}
