package pages.ui;

import base.utils.ReusableMethods;
import com.astm.commonFunctions.PublicAdminCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountInformationEdit_PublicAdmin extends BasePage {

	public AccountInformationEdit_PublicAdmin(WebDriver driver) {
		super(driver);
	}

	private By emailField = By.cssSelector("input[name='customer[email]']");
	private By saveButton = By.cssSelector("button#save");
	private By emailFieldRequiredError = By
			.xpath("//input[@name='customer[email]']/following::label[contains(text(),'This is a required field.')]");
	private By firstNamField = By.cssSelector("input[name='customer[firstname]']");
	private By lastNameField = By.cssSelector("input[name='customer[lastname]']");
	private By middleNameField = By.cssSelector("input[name='customer[middlename]']");
	private By referralCodeDropDown = By.cssSelector("select[name='customer[referral_code]']");
	private By oktaStatusDisabledField = By.cssSelector("input[name='customer[okta_status]']");
	private By oktaUuidDisabledField = By.cssSelector("input[name='customer[okta_uuid]']");
	private By maeStatusDisabledField = By.cssSelector("input[name='customer[mae_status]']");
	private By maeAccountIdDisabledField = By.cssSelector("input[name='customer[mae_account_id]']");
	private By maeUserIdDisabledField = By.cssSelector("input[name='customer[mae_user_id]']");
	private By maeAccountUserIdDisabledField = By.cssSelector("input[name='customer[mae_account_user_id]']");
	private By firstNameRequiredErrorMessageLabel = By.cssSelector("input[name='customer[firstname]'] + label.admin__field-error");
	private By lastNameRequiredErrorMessageLabel = By.cssSelector("input[name='customer[lastname]'] + label.admin__field-error");
	private By phoneNumberTextField = By.cssSelector("input[name='customer[phone_number]']");
	private By ebsAccountNumber = By.cssSelector("input[name='customer[ebs_account_number]']");
	private By ebsStatusTextField = By.cssSelector("input[name='customer[ebs_status]']");
	private By accountNameHeading = By.cssSelector("h1.page-title");
	private By arInvoiceTypeDropDown = By.cssSelector("select[name='customer[ar_invoice_type]']");
	private By saveAndContinueEdit = By.cssSelector("button#save_and_continue");
	private By createB2BUser = By.cssSelector("button#create_b2b_user");
	private By emailInvalidFormatErrorMessage = By.xpath("//label[contains(text(),'Please enter a valid email address (Ex: johndoe@domain.com).')]");
	private By classificationDropDown = By.cssSelector("select[name='customer[classification]']");
	private By paymentTermDisabledField = By.cssSelector("select[name='customer[payment_term]']");
	private By profileClassDropDown = By.cssSelector("select[name='customer[profile_class]']");
	private By organizationTextField = By.cssSelector("input[name='customer[organization_name]']");
	private By creditHoldToggleButton = By.cssSelector("input[name='customer[credit_hold]'] + label");
	private By creditHoldInputTag = By.cssSelector("input[name='customer[credit_hold]']");
	private By associateToWebsiteDropDown = By.cssSelector("select[name='customer[website_id]']");
	private By customerTypeDropDown = By.cssSelector("select[name='customer[customer_type]']");
	private By communicationEmailTextField = By.cssSelector("input[name='customer[communication_email]']");
	private By welcomeEmailFromWebSiteDropDown = By.cssSelector("select[name='customer[sendemail_store_id]']");
	private By ebsPartyIdDisabledTextField = By.cssSelector("input[name='customer[ebs_party_id]']");
	private By orgNameFieldRequiredErrorMessage = By.cssSelector("input[name='customer[organization_name]'] + label.admin__field-error");

	/**
	 * @return orgNameFieldRequiredErrorMessage
	 */
	public By getOrgNameFieldRequiredErrorMessage(){
		return orgNameFieldRequiredErrorMessage;
	}

	/**
	 * @return the Create B2B User Button
	 */
	public By getCreateB2BUser() {
		return createB2BUser;
	}

	/**
	* @return ebsPartyIdDisabledTextField
	*/
	public By getEbsPartyIdDisabledTextField(){
	    return ebsPartyIdDisabledTextField;
	}

	/**
	* @return welcomeEmailFromWebSiteDropDown
	*/
	public By getWelcomeEmailFromWebSiteDropDown(){
	    return welcomeEmailFromWebSiteDropDown;
	}

	/**
	* @return communicationEmailTextField
	*/
	public By getCommunicationEmailTextField(){
	    return communicationEmailTextField;
	}

	/**
	 * @return the customerTypeDropDown
	 */
	public By getCustomerTypeDropDown() {
		return customerTypeDropDown;
	}

	/**
	 * @return the associateToWebsiteDropDown
	 */
	public By getAssociateToWebsiteDropDown() {
		return associateToWebsiteDropDown;
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
	* @return organizationTextField
	*/
	public By getOrganizationTextField(){
	    return organizationTextField;
	}

	/**
	* @return profileClassDropDown
	*/
	public By getProfileClassDropDown(){
	    return profileClassDropDown;
	}

	/**
	 * @return paymentTermDisabledField
	 */
	public By getPaymentTermDisabledField(){
		return paymentTermDisabledField;
	}
	
	/**
	* @return classificationDropDown
	*/
	public By getClassificationDropDown(){
	    return classificationDropDown;
	}
	
	/**
	 * @return emailInvalidFormatErrorMessage
	 */
	public By getEmailInvalidFormatErrorMessage() {
		return emailInvalidFormatErrorMessage;
	}

	/**
	 * @return the saveAndContinueEdit
	 */
	public By getSaveAndContinueEdit() {
		return saveAndContinueEdit;
	}

	/**
	 * @return the arInvoiceTypeDropDown
	 */
	public By getArInvoiceTypeDropDown() {
		return arInvoiceTypeDropDown;
	}

	/**
	 * @return the ebsStatusTextField
	 */
	public By getEbsStatusTextField() {
		return ebsStatusTextField;
	}

	/**
	 * @return the accountNameHeading
	 */
	public By getAccountNameHeading() {
		return accountNameHeading;
	}

	/**
	 * @return the ebsAccountNumber
	 */
	public By getEbsAccountNumber() {
		return ebsAccountNumber;
	}

	/**
	 * @return the phoneNumberTextField
	 */
	public By getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	/**
	 * @return the oktaStatusDisabledField
	 */
	public By getOktaStatusDisabledField() {
		return oktaStatusDisabledField;
	}

	/**
	 * @return the oktaUuidDisabledField
	 */
	public By getOktaUuidDisabledField() {
		return oktaUuidDisabledField;
	}

	/**
	 * @return the maeStatusDisabledField
	 */
	public By getMaeStatusDisabledField() {
		return maeStatusDisabledField;
	}

	/**
	 * @return the maeAccountIdDisabledField
	 */
	public String getMaeAccountIdDisabledField() {
		ReusableMethods.scrollIntoView(getElement(maeAccountIdDisabledField),driver);
		String value = getElementNew(maeAccountIdDisabledField).getAttribute("value");
		log.info(value);
		return value;
	}

	/**
	 * @return the maeUserIdDisabledField
	 */
	public By getMaeUserIdDisabledField() {
		return maeUserIdDisabledField;
	}

	/**
	 * @return the maeAccountUserIdDisabledField
	 */
	public By getMaeAccountUserIdDisabledField() {
		return maeAccountUserIdDisabledField;
	}

	/**
	 * @return the firstNameRequiredErrorMessageLabel
	 */
	public By getFirstNameRequiredErrorMessageLabel() {
		return firstNameRequiredErrorMessageLabel;
	}

	/**
	 * @return the lastNameRequiredErrorMessageLabel
	 */
	public By getLastNameRequiredErrorMessageLabel() {
		return lastNameRequiredErrorMessageLabel;
	}

	/**
	 * @return the emailField
	 */
	public By getEmailField() {
		return emailField;
	}

	/**
	 * @return the saveButton
	 */
	public By getSaveButton() {
		return saveButton;
	}

	/**
	 * @return the emailFieldRequiredError
	 */
	public By getEmailFieldRequiredError() {
		return emailFieldRequiredError;
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
	 * @return the referralCodeDropDown
	 */
	public By getReferralCodeDropDown() {
		return referralCodeDropDown;
	}

	/**
	 * Enters email in email text field
	 * 
	 **/
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
	 * Clicks on Save Customer Button
	 * 
	 *
	 */
	public boolean clickSaveButton() {
		try {
			PublicAdminCommons.clickonWebElement(driver, saveButton);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Checks if Required field error message is present
	 * 
	 * 
	 */
	public boolean isEmailRequiredErrorMessageIsPresent() {
		try {
			return getElementNew(emailFieldRequiredError).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			log.info("ee", e);
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
			WebElement element = getElementNew(firstNamField);
			element.clear();
			element.sendKeys(value);
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
			WebElement element = getElementNew(lastNameField);
			element.clear();
			element.sendKeys(value);
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
			WebElement element = getElementNew(middleNameField);
			element.clear();
			element.sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	/**
	 * In this method we will get value other then already selected value
	 * 
	 * @return
	 */
	public String getDifferentOptionInReferralCodeDropDown() {
		try {
			List<String> dropDownValues = PublicAdminCommons.getAllDropDownValues(driver, referralCodeDropDown);
			String selectValueInDropDown = PublicAdminCommons.getSelectedValueFromDropDown(driver, referralCodeDropDown);
			String valueToSelect = PublicAdminCommons.getMeElementFromListExcept(dropDownValues, selectValueInDropDown);
			return valueToSelect;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the value of disabled OKTA status field
	 * 
	 * @return
	 */
	public String getOktaStatusFieldValue() {
		try {
			String value = getElementNew(oktaStatusDisabledField).getAttribute("value");
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the value of disabled OKTA UUI field
	 * 
	 * @return
	 */
	public String getOktaUuidFieldValue() {
		try {
			String value = getElementNew(oktaUuidDisabledField).getAttribute("value");
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns the value of disabled MAE status field
	 * 
	 * @return
	 */
	public String getMaeStatusFieldValue() {
		try {
			String value = getElementNew(maeStatusDisabledField).getAttribute("value");
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the value of disabled MAE User ID field
	 * 
	 * @return
	 */
	public String getMaeUserIDFieldValue() {
		try {
			String value = getElementNew(maeUserIdDisabledField).getAttribute("value");
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns the value of disabled MAE Account ID field
	 * 
	 * @return
	 */
	public String getAccountIdFieldValue() {
		try {
			String value = getElementNew(maeAccountIdDisabledField).getAttribute("value");
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns the value of disabled MAE Account User ID field
	 * 
	 * @return
	 */
	public String getMaeAccountUserIdFieldValue() {
		try {
			String value = getElementNew(maeAccountUserIdDisabledField).getAttribute("value");
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns the value of disabled EBS status field
	 * 
	 * @return
	 */
	public String getEbsStatusFieldValue() {
		try {
			String value = getElementNew(ebsStatusTextField).getAttribute("value");
			log.info(value);
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the value of disabled EBS account number field
	 * 
	 * @return
	 */
	public String getEbsNumberFieldValue() {
		try {
			ReusableMethods.scrollIntoView(getElement(ebsAccountNumber),driver);
			String value = getElementNew(ebsAccountNumber).getAttribute("value");
			log.info(value);
			return value;
		}
		catch(Exception e) {
			log.info(e);
			e.printStackTrace();
			return "";
		}
	}

}
