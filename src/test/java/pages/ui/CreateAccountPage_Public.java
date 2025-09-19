package pages.ui;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.astm.commonFunctions.PublicCommon;

import base.utils.RandomStringUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

public class CreateAccountPage_Public extends BasePage {

	public CreateAccountPage_Public(WebDriver driver) {
		super(driver);
	}

	public static String membershipApplicationNewEmail = null;

	private By createNewCustomerAccountHeader = By.cssSelector(".page-title span");
	private By personalInformationTitle = By.xpath("//span[text()='Personal Information']");

	public By createAnOrganizationalAccountHeader = By.xpath("//h3[text()='Create an Organizational Account']");
	public By createAccountBtn = By.xpath("//span[text()='Create Account']");
	public By cancelBtn = By.xpath("//span[text()='Cancel']");
	public By textOnCreateAcntPage = By
			.xpath("//p[text()='Your orders will be placed under this organizational account']");

	public By createAccountHeader = By.xpath("//*[@class='page-title astm-type-heading--h1 ']/span");
	public By accountPageHeader = By.xpath("//*[@class='astm-type-heading--h1']");
	public By activatonAccountHeader = By.xpath("//h2[text()='Account Activation']");
	public By firstNameTextbox = By.id("firstname");

	//public By firstNameTextbox1 = By.xpath("//input[@id='firstname']");
	public By firstNameTextbox1 = By.xpath("//input[@id='firstname' and @type='text']");


	public By middleNameTextbox = By.id("middlename");
	public By middleNameTextbox1 = By.xpath("//input[@id='middlename']");

	public By lastNameTextbox = By.id("lastname");
	public By lastNameTextbox1 = By.xpath("//input[@id='lastname']");

	public By universityTextbox = By.xpath("//input[@id='university' and @readonly]");

	public By emailAddressTextbox = By.id("email_address");
	public By emailAddressTextbox1 = By.xpath("//input[@id='email_address']");

	private By passwordTextbox = By.id("password");

	// private By organisationTextbox =
	// By.id("additional_organization");//By.name("organization_name");
	public By organisationTextbox = By.xpath("//input[@id='organization_name']|//input[@id='additional_organization']");
	private By additionalOrganisationTextbox = By.xpath("//input[@id='additional_organization']");
	private By passwordConfirmationTextbox = By.id("password-confirmation");
	public By createAnAccountButton = By.cssSelector("button[title='Create Account']");// By.xpath("//button[@title='Create
	public By cancelAnAccountBuuton = By.xpath("//*[text()='Cancel']");
	public By cancelAnAccountLink = By.xpath("//span[text()='Cancel']/parent::a");

	public By specCreateAccountBtn = By.cssSelector("button[type='submit']");
	public By cancelAlertDesc1=By.xpath("//p[@class='astm-type-body--lead']");
    public By cancelAlertDesc2 = By.xpath("//p[@class='astm-type-body--lead']");

	public By createAnAccountButtonAPI = By.xpath("//*[@class='block-new-customer']//*[text()='Create an Account']");
	public By cancelAlertHeader = By.xpath("//*[text()='Are you sure you want to cancel?']");
	public By cancelAlertYesButton = By.xpath("//*[text()='Yes'][@class='btn astm-btn astm-btn--small btn-secondary']");
	public By cancelAlertNevermindButton = By
			.xpath("//*[text()='Nevermind'][@class='btn astm-btn astm-btn--small btn-light']");
	public By cancelAlertDescription = By.xpath("//p[@class='astm-type-body--lead']");
	public By accountActivationHeader = By.xpath("//h2[text()='Account Activation']");
	public By astmLogoRegistrationRequired = By.xpath("//img[@alt='astm']");
	public By registrationRequiredMessageHeader = By.xpath("//*[contains(text(),'Your Access Requires Registration')]");
	public By registrationRequiredMessage = By.xpath("//p[@class='sc-fubCfw irPtrP astm-type-body--lead']");
	public By contactUsLink = By.linkText("contact us");

//	public By createAnAccountButton = By.cssSelector("button[class*='submit'] span");

	public By emailAddressError = By.id("email_address-error");
	public By firstNameError = By.id("firstname-error");
	public By lastNameError = By.id("lastname-error");
	public By passwordError = By.id("password-error");
	public By passwordConfirmationError = By.id("password-confirmation-error");
	public By organisationError = By.id("additional_organization-error");
	public By cartLinkAfterLogin = By.xpath("//a[contains(text(), 'Cart')]");

	public By labelList = By.xpath("//*[@id='form-validate']//label/span");
	public By label = By.xpath("(//*[@id='form-validate']//label/span)[2]");
	public By companyCheckboxEnable = By.id("company_affiliation");
	public By companyAffiliationCheckbox = By
			.xpath("//*[@id='form-validate']//*[text()='I do not have a company affiliation']");
	public By signUpNewsLetterCheckbox = By.xpath("//*[@id='form-validate']//*[text()='Sign Up for Newsletter']");

	public By firstNameField = By.xpath("//*[@id='form-validate']//*[text()='First Name']");
	public By middleNameField = By.xpath("//*[@id='form-validate']//*[text()='Middle Name']");
	public By lastNameField = By.xpath("//*[@id='form-validate']//*[text()='Last Name']");
	public By organisationField = By.xpath("//*[@id='form-validate']//*[contains(text(),'Organization')]");
	public By emailAddressField = By.xpath("//*[@id='form-validate']//*[text()='Email']");
	public By passwordField = By.xpath("//*[@id='form-validate']//*[text()='Password']");
	public By passwordConfirmationField = By.xpath("//*[@id='form-validate']//*[text()='Confirm Password']");

	public By errorMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	public By signinLinkOnMessage = By.cssSelector(".messages a");

	public By requiredFieldNameList = By
			.xpath("//*[@id='form-validate']//*[contains(@data-validate,'required')]/../preceding-sibling::label");
	public By fieldErrorMessageFieldNameList = By
			.xpath("//*[text()='This is a required field.']/../preceding-sibling::label");
	public By departmentNDivisionDropdown = By.id("department_division");
	public By businessLineDropdown = By.id("business_line");
	public By officeLocationDropdown = By.id("office_location");

	public By registrationFields = By
			.xpath("//*[@id='form-validate']//label[@for!='email_address']/following-sibling::div//input");

	public By firstNameTextbox_ipStepup = By.id("firstName");
	public By middleNameTextbox_ipStepup = By.id("middlname");
	public By lastNameTextbox_ipStepup = By.id("lastName");
	public By universityTextbox_ipStepup = By.xpath("//input[@id='university' and @readonly]");
	public By emailAddressTextbox_ipStepup = By.id("email"); // By.id("email_address");
	private By passwordConfirmationTextbox_ipStepup = By.id("confirmPassword");
	public By createAccount_ipStepup = By.xpath("//button[text()='Create Account']");
	public By accountActivationBtn = By.xpath("//button[text()='Activate Account']");
	public By orgNamePTPAccount = By.xpath("//input[@id='organization_name']");
	public By myAccountLabel=By.xpath("//h3[text()='My Account']");

	public WebElement getFirstNameTextboxElement() {
		return getElement(firstNameTextbox1);
	}
	public WebElement getFirstNameTextboxElement1() {
		return getElement(firstNameTextbox1);
	}
	public WebElement getMiddleNameTextFieldElement1() {
		return getElement(middleNameTextbox1);
	}
	public WebElement getLastNameTextbox() {
		return getElement(lastNameTextbox1);
	}
	public WebElement getpasswordConfirmationTextbox(){
		return getElement(passwordConfirmationTextbox);
	}
	public WebElement getEmailTextbox() {
		return getElement(emailAddressTextbox1);
	}

	public WebElement getMiddleNameTextFieldElement() {
		return getElement(middleNameField);
	}

	public WebElement getEmailTextboxInAccountPageElement() {
		return getElement(emailAddressField);
	}

	public WebElement getEmailTextboxLastNameInAccountPageElement() {
		return getElement(lastNameField);
	}

	public WebElement getDepartmentNDivisionDropdown() {
		return getElement(departmentNDivisionDropdown);
	}

	public WebElement getCommpanyAffilationCheckbox() {
		return getElement(companyCheckboxEnable);
	}

	public WebElement getCreateAccountHeader() {
		return getElement(createAccountHeader);
	}

	public WebElement getCancelAlertHeader() {
		return getElement(cancelAlertHeader);
	}

	public WebElement getCancelAlertDescription() {
		return getElement(cancelAlertDescription);
	}

	public WebElement getAstmLogoRegistrationRequired() {
		return getElement(astmLogoRegistrationRequired);
	}

	public WebElement getRegistrationRequiredMessageHeader() {
		return getElement(registrationRequiredMessageHeader);
	}

	public WebElement getRegistrationRequiredMessage() {
		return getElement(registrationRequiredMessage);
	}

	public By getFieldNames(String fieldText) {
		return By.xpath("//*[@id='form-validate']//label/span[contains(text(),'" + fieldText + "')]");
	}

	public WebElement getFieldNamesElement(String fieldText) {
		return getElement(getFieldNames(fieldText));
	}

	public By getFields(String fieldText) {
		return By.xpath("//label[contains(text(),'" + fieldText + "')]");
	}
	
	public WebElement getBusinessLineDropdown() {
		return getElement(businessLineDropdown);
	}

	public WebElement getOfficeLocationDropdown() {
		return getElement(officeLocationDropdown);
	}

	public List<WebElement> getFieldErrorMessageFieldNameListElements() {
		return getElements(fieldErrorMessageFieldNameList);
	}

	public List<WebElement> getRequiredFieldNameListElements() {
		return driver.findElements(requiredFieldNameList);
	}

	public List<WebElement> getRegistrationFieldValues() {
		return driver.findElements(registrationFields);
	}

	public List<WebElement> getLabelListElements() {
		return driver.findElements(labelList);
	}

	public WebElement getSignupNewsLetterCheckbox() {
		return getElement(signUpNewsLetterCheckbox);
	}

	public WebElement getorganisationTextbox() {
		return getElement(organisationTextbox);
	}

	public WebElement getSigninLinkOnMessage() {
		return getElement(signinLinkOnMessage);
	}

	public WebElement getFieldValues(String value) {
		System.out.println("//label[@for='" + value + "']/following-sibling::div/input");
		By fieldValues = By.xpath("//label[@for='" + value + "']/following-sibling::div/input");
		return getElement(fieldValues);
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

	public List<String> getLabelList() {
		try {
			String labelT = getElement(label).getText();
			int size = getElements(labelList).size();
			List<String> list = new ArrayList<String>();
			for (int i = 1; i <= size; i++) {
				list.add(getLabelListElements().get(i).getText());
			}
			return list;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getPageUrl() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains("/customer/account/create/"));

			return driver.getCurrentUrl();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public String getErrorMessage(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getTextFieldEntry(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Entering First Name for Sign Up.")
	public void enterFirstName(String firstName) {
		try {
			getElement(firstNameTextbox).sendKeys(firstName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Step("Entering First Name for Sign Up.")
	public void enterFirstName1(String firstName) {
		try {
			getElement(firstNameTextbox1).sendKeys(firstName);
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public String getFirstNameText1() {
		try {
			return getElement(firstNameTextbox1).getAttribute("value");
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

	public String getMiddleNameText1() {
		try {
			return getElement(middleNameTextbox1).getAttribute("value");
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

	public String getLastNameText1() {
		try {
			return getElement(lastNameTextbox1).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getEmailText() {
		try {
			System.out.println("Email Address in Textbox: " + getElement(emailAddressTextbox).getAttribute("value"));
			return getElement(emailAddressTextbox).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getEmailText1() {
		try {
			System.out.println("Email Address in Textbox: " + getElement(emailAddressTextbox1).getAttribute("value"));
			return getElement(emailAddressTextbox1).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getUniversityText() {
		try {
			return getElement(universityTextbox).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Entering Organisation Name for Sign Up.")
	public void enterOrganisationName(String organisationName) {
		try {
			getElement(organisationTextbox).sendKeys(organisationName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterAdditionalOrganisationName(String organisationName) {
		try {
			getElement(additionalOrganisationTextbox).sendKeys(organisationName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Entering Last Name for Sign Up.")
	public void enterLastName(String lastName) {
		try {
			getElement(lastNameTextbox).sendKeys(lastName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Step("Entering Last Name for Sign Up.")
	public void enterLastName1(String lastName) {
		try {
			getElement(lastNameTextbox1).sendKeys(lastName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Entering Middle Name for Sign Up.")
	public void enterMiddleName(String middleName) {
		try {
			getElement(middleNameTextbox).sendKeys(middleName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Entering Email Address for Sign Up.")
	public void enterEmailAddress(String emailAddress) {
		try {
			getElement(emailAddressTextbox).sendKeys(emailAddress);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Entering password for Sign Up.")
	public void enterPassword(String password) {
		try {
			getElement(passwordTextbox).sendKeys(password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Confirming password for Sign Up.")
	public void confirmPassword(String password) {
		try {
			getElement(passwordConfirmationTextbox).sendKeys(password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Click on Create Account to Sign Up.")
	public boolean clickCreateAccount() {
		try {

			ReusableMethods.scrollIntoView(getElement(createAnAccountButton), driver);
			waitForElementPresent(createAnAccountButton);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(createAnAccountButton),10);
			getElement(createAnAccountButton).click();
			// PublicCommon.JSClick(getElement(createAnAccountButton), driver);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Step("Click on Create Account to Sign Up.")
	public boolean clickCreateAccountIpSteup() {
		try {

			ReusableMethods.scrollIntoView(getElement(createAccount_ipStepup), driver);
			waitForElementPresent(createAccount_ipStepup);
			getElement(createAccount_ipStepup).click();
			// PublicCommon.JSClick(getElement(createAnAccountButton), driver);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Step("Click on Account Activation to Sign Up.")
	public boolean clickAccountactivationBtn() {
		try {

			ReusableMethods.scrollIntoView(getElement(accountActivationBtn), driver);
			waitForElementPresent(accountActivationBtn);
			getElement(accountActivationBtn).click();
			// PublicCommon.JSClick(getElement(createAnAccountButton), driver);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Step("Create a new account - New Registration")
	public void newUserRegistration(String firstName, String lastName, String emailAddress, String password) {
		try {
			enterFirstName(firstName);
			enterLastName(lastName);
			enterEmailAddress(emailAddress);
			enterPassword(password);
			confirmPassword(password);
			clickCreateAccount();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Create a new account - New Registration")
	public void newUserRegistration(String firstName, String lastName, String orgName, String emailAddress,
			String password) {
		try {
			enterFirstName(firstName);
			enterLastName(lastName);
			enterOrganisationName(orgName);
			enterEmailAddress(emailAddress);
			enterPassword(password);
			confirmPassword(password);
			clickCreateAccount();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * This method resigters a new account returns registered email
	 */
	@Step("Create a new account - New Registration")
	public String newUserRegistration() {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			// PublicCommon.JSClick(getElement(companyAffiliationCheckbox), driver);
			enterOrganisationName("ASTM");
			String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Create a new account - New Registration")
	public void newUserRegistrationIPSteup(String firstName, String lastName, String password) {
		try {
			// Thread.sleep(15000);
			getElement(firstNameTextbox_ipStepup).sendKeys(firstName);
			getElement(lastNameTextbox_ipStepup).sendKeys(lastName);

			enterPassword(password);
			getElement(passwordConfirmationTextbox_ipStepup).sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickAccountactivationBtn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Create a new account - New Registration")
	public String newUserRegistrationIPStepup(String email) {
		try {
			// Thread.sleep(15000);
			getElement(firstNameTextbox_ipStepup).sendKeys("Test");
			getElement(lastNameTextbox_ipStepup).sendKeys("Data");

			getElement(emailAddressTextbox_ipStepup).sendKeys(email);
			enterPassword("Test123456");
			getElement(passwordConfirmationTextbox_ipStepup).sendKeys("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccountIpSteup();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Create a new account - New Registration")
	public String newUserRegistrationWithOrgField(String orgName) {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			enterOrganisationName(orgName);
			String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Create a new account - New Registration")
	public String newUserRegistrationWithOrgField(String orgName, String email) {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			enterOrganisationName(orgName);
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Step("Create a new account - New Registration")
	public String newUserRegistrationWithOrgField1(String orgName, String email) {
		try {
			// Thread.sleep(15000);
			enterFirstName1("Test");
			enterLastName1("Data");
			enterOrganisationName(orgName);
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	

	/*
	 * This method resigters a new account returns registered email
	 */
	@Step("Create a new account - New Registration")
	public String newUserRegistrationMailinator() {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			enterOrganisationName("ORG");
			String email = "testaccount" + System.currentTimeMillis() + "@mailinator.com";
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Create a new account - New Registration")
	public String newUserRegistrationAPI() {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			enterOrganisationName("API");
			String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/*
	 * This method resigters a new account returns registered email
	 */
	@Step("Create a new account - New Registration")
	public String newUserRegistrationForStudent() {
		try {
			// Thread.sleep(15000);
			// enterFirstName("Test");
			// enterLastName("Data");
			// String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
			// enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return membershipApplicationNewEmail;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/*
	 * This method resigters a new account returns registered email
	 */
	@Step("Create a new account - New Registration")
	public boolean newUserRegistrationCompassFedSSO() {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterMiddleName("Mid");
			enterLastName("Data");
			enterAdditionalOrganisationName("ASTM");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * This method resigters a new account returns registered email
	 */
	@Step("Create a new account - New Registration")
	public boolean newUserRegistrationSpecbuilderFedSSO() {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterMiddleName("Mid");
			enterLastName("Data");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createAccount(String account) {

		try {
			enterFirstName("Test");
			enterLastName("Data");
			String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			switch (account) {
			case "ASTM":
				enterOrganisationName("ASTM");
				break;
			case "AECOM":
				setDropdownOption("CIF", departmentNDivisionDropdown);
				setDropdownOption("Construction Services", businessLineDropdown);
				setDropdownOption("Australia - Adelaide", officeLocationDropdown);
				break;

			case "BV":
				setDropdownOption("CIF", departmentNDivisionDropdown);
				break;

			case "Open Athens":
				setDropdownOption("CIF", departmentNDivisionDropdown);
				break;

			default:
				break;
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public void setDropdownOption(String value, By locator) {
		try {
			WebElement element = getElement(locator);
			PublicCommon.JSClick(element, driver);
			PublicCommon.selectValueInDropdown(element, value);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public String enterRegistrationDetails() {

		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Create a new Account - New Registration (Spec Builder special registration
	 * page and other places)
	 * 
	 * @param email
	 * @return true/false externalUserSession
	 */

	public boolean newUserRegistration(String email) {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			enterOrganisationName("ASTM");
			enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Step("Navigating to Cart after registration")
	public void goToCartAfterRegistration() {
		try {
			getElement(cartLinkAfterLogin).click();
			;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used for Registering User
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param confirmPassword
	 * @return True/false
	 */
	public boolean IntNewUserRegistration(String firstName, String lastName, String password, String confirmPassword) {

		try {
			sendKeysToElement("First Name", firstNameTextbox, firstName);
			sendKeysToElement("Last Name", lastNameTextbox, lastName);
			sendKeysToElement("Org Address", organisationTextbox, "ASTM");
			sendKeysToElement("Email Address", emailAddressTextbox,
					"testaccount" + RandomStringUtils.getRandomString(4) + "@new.com");
			sendKeysToElement("Password", passwordTextbox, password);
			sendKeysToElement("Confirm Password", passwordConfirmationTextbox, confirmPassword);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void sendKeysToElement(String elementName, By locatar, String keys) {
		try {
			WebElement element = getElement(locatar);
			WaitStatementUtils.explicitWaitForVisibility(driver, element);
			element.click();
			element.sendKeys(keys);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method Click on Create an account button
	 * 
	 * @return True/false
	 */
	public boolean IntclickCreateAccount() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(createAnAccountButton));
			ReusableMethods.scrollIntoView(getElement(createAnAccountButton), driver);
			getElement(createAnAccountButton).click();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Step("Create a new account - New Registration")
	public String newUserRegistrationForPublic() {
		try {
			// Thread.sleep(15000);
			enterFirstName("Test");
			enterLastName("Data");
			PublicCommon.JSClick(getElement(companyAffiliationCheckbox), driver);
			String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
			// enterEmailAddress(email);
			enterPassword("Test123456");
			confirmPassword("Test123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickCreateAccount();
			return email;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
