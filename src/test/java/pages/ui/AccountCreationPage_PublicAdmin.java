package pages.ui;

import java.util.List;

import base.utils.WaitStatementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicAdminCommons;

public class AccountCreationPage_PublicAdmin extends BasePage {

	public AccountCreationPage_PublicAdmin(WebDriver driver)
	{
		super(driver);
	}

	private By organizationName = By.cssSelector("input[name='customer[organization_name]']");
	private By emailField = By.cssSelector("input[name='customer[email]']");
	private By accountDescription = By.cssSelector("textarea[name='customer[account_description]']");
	private By accountTypeDropDown = By.cssSelector("select[name='customer[account_type]']");
	private By customerTypeDropDown = By.cssSelector("select[name='customer[customer_type]']");
	private By referenceTextField = By.cssSelector("input[name='customer[reference]']");
	private By classificationDropDown = By.cssSelector("select[name='customer[classification]']");
	private By referralCodeDropDown = By.cssSelector("select[name='customer[referral_code]']");
	private By oosnMailingDropDown = By.cssSelector("select[name='customer[opt_out_of_sn_mailings]']");
	private By specialAccountPreferenceDropDown = By
			.cssSelector("select[name='customer[special_account_preferences]']");
	private By arInvoiceTypeDropDown = By.cssSelector("select[name='customer[ar_invoice_type]']");
	private By newCustomerLabel = By.cssSelector("h1.page-title");
	private By continueButton = By.cssSelector("button#save_and_continue");
	private By firstNamField = By.cssSelector("input[name='customer[firstname]']");
	private By lastNameField = By.cssSelector("input[name='customer[lastname]']");
	private By middleNameField = By.cssSelector("input[name='customer[middlename]']");
	private By marketPreferenceDropDown = By.cssSelector("select[name='customer[marketing_preference]']");
	private By areaOfInterestFirstDropDown = By.cssSelector("select[name='customer[area_of_interest_1]']");
	private By areaOfInterestSecondDropDown = By.cssSelector("select[name='customer[area_of_interest_2]']");
	private By areaOfInterestThirdDropDown = By.cssSelector("select[name='customer[area_of_interest_3]']");
	private By profileClassDropDown = By.cssSelector("select[name='customer[profile_class]']");
	private By namePrefixDropDown = By.cssSelector("select[name='customer[prefix]']");
	private By fieldNamesList = By.cssSelector(".admin__field-label span");
	private By errorMessage = By.cssSelector("div[data-ui-id='messages-message-error']");
	private By emailInvalidFormatErrorMessage = By.xpath("//label[contains(text(),'Please enter a valid email address (Ex: johndoe@domain.com).')]");
	private By genderDropDown = By.cssSelector("select[name='customer[gender]']");
	private By phoneNumberTextField = By.cssSelector("input[name='customer[phone_number]']");
	private By groupDropDown = By.cssSelector("select[name='customer[group_id]']");
	private By associateToWebsiteDropDown = By.cssSelector("select[name='customer[website_id]']");
	private By welcomeEmailFrom = By.cssSelector("select[name='customer[sendemail_store_id]']");
	private By paymentTermDisabledField = By.cssSelector("select[name='customer[payment_term]']");
	private By creditHoldToggleButton = By.cssSelector("input[name='customer[credit_hold]'] + label");
	private By creditHoldInputTag = By.cssSelector("input[name='customer[credit_hold]']");
	private By communicationEmailField = By.cssSelector("input[name='customer[communication_email]']");
	private By communicationEmailErrorMessage = By.cssSelector("input[name='customer[communication_email]'] + label.admin__field-error");
	private By orgNameFieldRequiredErrorMessage = By.cssSelector("input[name='customer[organization_name]'] + label.admin__field-error");
	private By sendActivationEmailToggleButton = By.xpath("//*[@class='admin__field'][18]/div[2]/div/label");
	
	public By getSendActivationEmailToggleButton(){
		return sendActivationEmailToggleButton;
	}
	/**
	* @return orgNameFieldRequiredErrorMessage
	*/
	public By getOrgNameFieldRequiredErrorMessage(){
	    return orgNameFieldRequiredErrorMessage;
	}

	/**
	* @return communicationEmailErrorMessage
	*/
	public By getCommunicationEmailErrorMessage(){
	    return communicationEmailErrorMessage;
	}

	/**
	* @return communicationEmailField
	*/
	public By getCommunicationEmailField(){
	    return communicationEmailField;
	}

	/**
	 * @return creditHoldInputTag
	 */
	public By getCreditHoldInputTag(){
		return creditHoldInputTag;
	}

	/**
	 * @return creditHoldToggleButton
	 */
	public By getCreditHoldToggleButton(){
		return creditHoldToggleButton;
	}
	
	/**
	* @return paymentTermDisabledField
	*/
	public By getPaymentTermDisabledField(){
	    return paymentTermDisabledField;
	}
	
	/**
	 * @return the welcomeEmailFrom
	 */
	public By getWelcomeEmailFrom() {
		return welcomeEmailFrom;
	}

	/**
	 * @return the groupDropDown
	 */
	public By getGroupDropDown() {
		return groupDropDown;
	}

	/**
	 * @return the associateToWebsiteDropDown
	 */
	public By getAssociateToWebsiteDropDown() {
		return associateToWebsiteDropDown;
	}

	/**
	 * @return the organizationName
	 */
	public By getOrganizationName() {
		return organizationName;
	}

	/**
	 * @return the emailField
	 */
	public By getEmailField() {
		return emailField;
	}

	/**
	 * @return the accountDescription
	 */
	public By getAccountDescription() {
		return accountDescription;
	}

	/**
	 * @return the accountTypeDropDown
	 */
	public By getAccountTypeDropDown() {
		return accountTypeDropDown;
	}

	/**
	 * @return the customerTypeDropDown
	 */
	public By getCustomerTypeDropDown() {
		return customerTypeDropDown;
	}

	/**
	 * @return the referenceTextField
	 */
	public By getReferenceTextField() {
		return referenceTextField;
	}

	/**
	 * @return the oosnMailingDropDown
	 */
	public By getOosnMailingDropDown() {
		return oosnMailingDropDown;
	}

	/**
	 * @return the specialAccountPreferenceDropDown
	 */
	public By getSpecialAccountPreferenceDropDown() {
		return specialAccountPreferenceDropDown;
	}

	/**
	 * @return the arInvoiceTypeDropDown
	 */
	public By getArInvoiceTypeDropDown() {
		return arInvoiceTypeDropDown;
	}

	/**
	 * @return the newCustomerLabel
	 */
	public By getNewCustomerLabel() {
		return newCustomerLabel;
	}

	/**
	 * @return the continueButton
	 */
	public By getContinueButton() {
		return continueButton;
	}

	/**
	 * @return the firstNamField
	 */
	public By getFirstNamField() {
		return firstNamField;
	}

	/**
	 * @return the lastNameField
	 */
	public By getLastNameField() {
		return lastNameField;
	}

	/**
	 * @return the middleNameField
	 */
	public By getMiddleNameField() {
		return middleNameField;
	}

	/**
	 * @return the marketPreferenceDropDown
	 */
	public By getMarketPreferenceDropDown() {
		return marketPreferenceDropDown;
	}

	/**
	 * @return the namePrefixDropDown
	 */
	public By getNamePrefixDropDown() {
		return namePrefixDropDown;
	}

	/**
	 * @return the fieldNamesList
	 */
	public By getFieldNamesList() {
		return fieldNamesList;
	}

	/**
	 * @return the errorMessage
	 */
	public By getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return the emailInvalidFormatErrorMessage
	 */
	public By getEmailInvalidFormatErrorMessage() {
		return emailInvalidFormatErrorMessage;
	}

	/**
	 * @return the genderDropDown
	 */
	public By getGenderDropDown() {
		return genderDropDown;
	}

	/**
	 * @return the phoneNumberTextField
	 */
	public By getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	/**
	 * Returns Referral code drop down selector
	 * 
	 * @return
	 */
	public By getReferralCodeDropDown() {
		return referralCodeDropDown;
	}

	/**
	 * Returns Market Pref Drop dowm selector
	 * 
	 * @return
	 */
	public By getMarketPrefDropDown() {
		return marketPreferenceDropDown;
	}

	/**
	 * Returns Classification Drop Down selector
	 * 
	 * @return
	 */
	public By getClassificationDropDown() {
		return classificationDropDown;
	}

	public String getClassification() {
		PublicAdminCommons.scrollToElement(driver,getElement(classificationDropDown));
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(classificationDropDown),10);
		String classificationAfterUpdate = getElement(classificationDropDown).getAttribute("value");
		return classificationAfterUpdate;
	}

	/**
	 * Get profile class drop down selector
	 * 
	 * @return
	 */
	public By getProfileClassDropDown() {
		return profileClassDropDown;
	}

	/**
	 * Get AOI 1 dropdown selector
	 * 
	 * @return
	 */
	public By getAreaOfInterestFirstDropDown() {
		return areaOfInterestFirstDropDown;
	}

	/**
	 * Get AOI 2 dropdown selector
	 * 
	 * @return
	 */
	public By getAreaOfInterestSecondDropDown() {
		return areaOfInterestSecondDropDown;
	}

	/**
	 * Get AOI 3 dropdown selector
	 * 
	 * @return
	 */
	public By getAreaOfInterestThirdDropDown() {
		return areaOfInterestThirdDropDown;
	}

	/**
	 * Enters text in organization text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInOrganizationName(String value) {
		try {
			getElementNew(organizationName).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enters text in email text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInEmailField(String value) {
		try {
			WebElement element = getElementNew(emailField);
			element.clear();
			element.sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enters text in account description text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInAccountDescription(String value) {
		try {
			getElementNew(accountDescription).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from Account Type Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInAccountTypeDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(accountTypeDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enters text in reference text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInReferenceTextField(String value) {
		try {
			getElementNew(referenceTextField).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from Classification Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInClassificationDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(classificationDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from Referral Code Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInReferralCodeDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(referralCodeDropDown), value);
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Returns text from new customer label
	 * 
	 * @return
	 */
	public String getTextOfNewCustomerLabel() {
		try {
			return PublicAdminCommons.getElementText(getElement(newCustomerLabel));
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Clicks on Continue Button
	 * 
	 * @return
	 */
	public boolean clickSaveButton() {
		try {
			PublicAdminCommons.clickonWebElement(driver, continueButton);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enters text in first name text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInFirstNamField(String value) {
		try {
			getElementNew(firstNamField).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enters text in last name text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInLastNameField(String value) {
		try {
			getElementNew(lastNameField).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enters text in middle name text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInMiddleNameField(String value) {
		try {
			getElementNew(middleNameField).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * Selects option from Market Preference Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInMarketPreferenceDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(marketPreferenceDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from AOI 1 Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInAreaOfInterestFirstDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(areaOfInterestFirstDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from AOI 2 Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInAreaOfInterestSecondDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(areaOfInterestSecondDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from AOI 3 Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInAreaOfInterestThirdDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(areaOfInterestThirdDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from Profile Class Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInProfileClassDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(profileClassDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from OOSN Mailing Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInOosnMailingDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(oosnMailingDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from Special Account Pref Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInSpecialAccountPreferenceDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(specialAccountPreferenceDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from AR invoice Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInArInvoiceTypeDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(arInvoiceTypeDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from Customer Type Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInCustomerTypeDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(customerTypeDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects option from Name Prefix Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInNamePrefixDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(namePrefixDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Get the names of all the fields and drop downs
	 * 
	 * @return
	 */
	public List<String> getNameOfAllTheFieldsAndDropDowns() {
		try {
			return PublicAdminCommons.getTextOfWebElements(driver, fieldNamesList);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Get all the drop down values
	 * 
	 * @param dropDown
	 * @return
	 */
	public List<String> getAllDropDownValues(By dropDown) {
		try {
			List<String> values = PublicAdminCommons.getAllDropDownValues(driver, dropDown);
			log.info(values);
			return values;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Gets error message
	 * 
	 * @return
	 */
	public String getErrorMessageOnPage() {
		try {
			return getElementNew(errorMessage).getText();
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return null;
		}
	}
	
	/**
	 * Verifies email is of invalid format
	 * 
	 * @return
	 */
	public boolean isEmailInvalidFormatMessageVisible() {
		try {
			return getElementNew(emailInvalidFormatErrorMessage).isDisplayed();
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects option from Gender Drop Down
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInGenderDropDown(String value) {
		try {
			PublicAdminCommons.selectValueInDropdown(getElement(genderDropDown), value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Enters text in phone text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInPhoneNumberField(String value) {
		try {
			getElementNew(phoneNumberTextField).clear();
			getElementNew(phoneNumberTextField).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

}
