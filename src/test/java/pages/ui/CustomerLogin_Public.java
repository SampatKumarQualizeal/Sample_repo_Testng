package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomerLogin_Public extends BasePage {
	OrderConfirmPage_Integration orderPage;
	MyAccountPage_Public myAccountPage_Public = null;
	LoginPage_PublicAdmin Loginpage;
	MembershipBecomeMemberPage memberPage;

LoginPage_Subscription loginPage_subscription;

	public CustomerLogin_Public(WebDriver driver) {
		super(driver);
		myAccountPage_Public = getInstance(MyAccountPage_Public.class);
		orderPage = getInstance(OrderConfirmPage_Integration.class);
		Loginpage=getInstance(LoginPage_PublicAdmin.class);
		memberPage=getInstance(MembershipBecomeMemberPage.class);
        loginPage_subscription=getInstance(LoginPage_Subscription.class);
		// TODO Auto-generated constructor stub
	}
	private By emailField = By.id("email");
	public By alertMessage = By.xpath("//div[@class='login-form']//following::div[@role='alert']");
	// private By passwordField = By.id("pass");
	private By passwordField = By.name("login[password]");
	private By signInButton = By.xpath("//button[@class='action login primary' and @id='send2']");

    private By newSignInButton = By.linkText("Sign In");
    public By userNameTxt = By.id("userName");
    public By userNameTxt1 = By.xpath("//input[@id='userName']");
    public By passwordTxt = By.id("encPass");
    public By passwordTxt1 = By.xpath("//input[@id='encPass']");
    public By newSignInButton2 = By.xpath("//button[text()='Sign In']");
    public By loggedInMyASTMButton = By.xpath("//span[contains(.,'My ASTM')]"); // text()

    // Central Login Page sign in button - DONOT CHANGEn without checking
    private By signIn = By.xpath("//a[contains(text(),'Sign In')]"); // Central Login/Registration Page Sign in button

    private By uname = By.id("userName");
    private By userPassword = By.id("password");
    private By login = By.xpath("// button[@type='submit' and text()='Sign In']");// By.xpath("//button[@class='btn
    // btn-warning']"); //
    // button[@type='submit' and
    // text()='Sign In']

    // New Centralized Login Elements - New elements changed as a part of PUB-1092

    public By centralLoginHeader = By.cssSelector("*[class*='customer-account-login page'] .page-title");
    public By signInCustomerLoginPage = By
            .xpath("//span[text()='Customer Login']//following::a[contains(text(),'Sign In')]");
    private By btnhomePageSignIn = By.xpath("//a[contains(text(), 'SIGN IN')]");

    // Central Login Page sign in button - DONOT CHANGEn without checking
    public By btnSignInRegisteredCustomerPage = By
            .xpath("//*[@name='websso-login-button' and contains(text(), 'Sign In')]");
    //public By btnSignIn = By.xpath("//a[contains(text(), 'Sign In') and @name ='websso-login-button']");
    public By btnSignIn = By.xpath("//a[contains(text(), 'Sign In')]");
    public By MAEbtn = By.xpath("//input[@data-testid='MAE-button']");
    public By btnSignIn2 = By.xpath("(//a[contains(text(), 'Sign In')])[2]");

    public By registeredCustomerHeading = By
            .xpath("//*[@class='astm-type-heading--h4' and contains(text(), 'Registered Customers')]");
    private By registeredCustomerText = By.xpath(
            "//*[@class='astm-type-heading--h4' and contains(text(), 'Registered Customers')]/following-sibling::p");
    // public By btnCreateAnAccount = By.xpath("//*[@class='btn astm-btn
    // btn-secondary w-100' and contains(., 'Create an Account')]");

    // public By btnCreateAnAccount =
    // By.xpath("//h4[@id='block-new-customer-heading']//following::a[1] |
    // //a[text()='Create Account']");
    public By BtnCreateAnAccount = By.xpath("//h4[text()='New Customers']/..//a");
    public By pageBtnCreateAnAccount = By.xpath("//*[@class='block-new-customer']//span[text()='Create an Account']");

    public By btnCreateAnAccount = By
            .xpath("//h4[@id='block-new-customer-heading']//following::a[1] | //a[contains(text(),'Create Account')]");

    public By createNewAccountButton = By.xpath("//div[@class='block-new-customer']//div//a");
    private By newcustomerHeading = By
            .xpath("//*[@id='block-new-customer-heading' and contains(text(), 'New Customers')]");
    private By newCustomerText = By.xpath(
            "//*[@id='block-new-customer-heading' and contains(text(), 'New Customers')]/following-sibling::*/p");

    // Compass Login page specific elements
    public By compassLoginPageLogo = By.xpath("//*[@class='logo']//img[contains(@src, 'logo.png')]");
    public By astmLogo = By.cssSelector("img[src*='images/astm'].astm-logo");
    public By apiLogo = By.cssSelector("img[src*='/resources/images/api.svg'].astm-logo");
    public By apiLogoHomepage = By.cssSelector("img[src*='images/logo/logo.png']");
    private By compassUserName = By.id("userName");

    public By getCompassPassword() {
        return compassPassword;
    }

    public void setCompassPassword(By compassPassword) {
        this.compassPassword = compassPassword;
    }

    public By getCompassUserName() {
        return compassUserName;
    }

    private By compassPassword = By.id("encPass");
    private By compassSignInButton = By.xpath("//button[@type='submit' and contains(text(), 'Sign In')]");// By.xpath("//button[text()='SIGN
    private By activateAccount = By.xpath("//button[text()='Activate Account']");

    public By getCompassSignInButton() {
        return compassSignInButton;
    }

    public By forgotPassword = By.linkText("Forgot Password?");

    public By incorrectUsernamePass = By.cssSelector(".login-form .astm-alert-text");
    public By homePageSigninBtn = By.xpath("//button[@data-toggle='collapse']//span[contains(text(), 'Sign In')]");
    public By pageAlerts = By.cssSelector("*[data-ui-id='message-success'] div");

    // microsoft Login
    public By microsoftEmail = By.name("loginfmt");
    public By microsoftEmailNextBtn = By.cssSelector("*[type='submit'][value='Next']");
    public By microsoftPwd = By.name("passwd");
    public By microsoftSigninBtn = By.cssSelector("*[type='submit'][value='Sign in']");
    public By staySigninNoBtn = By.cssSelector("*[type='button'][value='No']");

    // Login new flow locators
    public By MembersingoutBTN = By.xpath("//a[contains(text(),'Sign Out')]");
    public By MembershipsingoutBTN = By.xpath("//button[contains(text(),'Sign Out')]");


    public By MembersingoutBTNMyAccountPage = By.xpath("(//a[@href='https://stage-store.astm.org/customer/logout/'])[1]");
    public By compassBtn = By.xpath("//a[contains(text(),'Compass')]");
    public By OrdersTab = By.xpath("//a[text()='Orders']");
    public By Myaccount_Ordertab = By.xpath("//div[contains(@class,'content')]/div/a[text()='Orders']");
    public By Myaccount_Membershiptab = By.xpath("//div[contains(@class,'content')]/div/a[text()='Membership']");
    public By Myaccount_OrdCompasstab = By.xpath("//div[contains(@class,'content')]/div/a[text()='Compass']");
    public By CompassLoginIssueMsg=By.xpath("//div[text()='There is an issue with your account and we were unable to log you in. Please contact customer service for assistance.']");
    public By ViewDetialsBtn = By.xpath("//span[text()='View Details']");
    public By ViewDetialsBtn1 = By.xpath("(//span[text()='View Details'])[1]");
    public By ViewDetailsBtn2=By.xpath("(//span[text()='View Details'])[2]");

    public By signinDropdown = By.xpath("// button[contains(@class,'headersignin')]");// this works for
    public By signinDropdown_Membership=By.cssSelector("#dropdown-menu-align-right");
    // Signin and
    public By signInDropDownText = By.xpath("//*[contains(@class,'headerSign')]/button");

    public By PublicSigninbtn1 = By.xpath("//button[contains(@class,'headersignin')]/descendant::span");
    public By PublicSigninbtn2 = By.xpath("//button[contains(text(),'Sign In')]");
    public By PublicAfterSignin = By.xpath("//span[text()='test']");
    public By signInOrRegister = By.xpath("(//span[text()='Sign In/Register']/parent::div[contains(@class,'user-sign-in')])[1]");

    public By MyCommitteeSigninDropdown = By.xpath("//div[@class='profileOptionMenu dropdown']/button");
    // MyASTM both
    public By signinOptionInDropdown = By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[4]/div/div/div[2]/ul/li[2]/div/button");
    public By createAccountOptionInDropdown = By
            .xpath("//*[contains(text(),'Create Account')]");
    public By myAccountOptionInDropdown = By.xpath("//*[@class='dropdown-item' and contains(text(),'My Account')]");
    public By signinPageHeader = By.xpath("//*[@class='login-form']//h3[text()='Sign In']");
    public By createAnAccountPageHeader = By
            .xpath("//*[text()='Create an Account' and @data-ui-id='page-title-wrapper']");

    public By BtnSignInRegisteredCustomerPage = By.name("websso-login-button");
    public By agreeAndContinue = By.xpath("//button[text()='Agree and Continue']");

    public By SigninRegister = By.xpath("//ul//span[contains(text(), 'Sign In/Register')]");
    public By signInOrRegisterNew=By.xpath("(//div[contains(@class,'user-sign-in')])[2]");
    public By aenorRegressionSelectBtn = By.xpath("(//button[text()='Select'])[1]");
    public By navMenuLink = By.xpath("//span[text()='Menu']");
    public By signInBtn = By.xpath("(//button[@type='button'])[6]");
    public By compassLink = By.xpath("//a[text()='Compass']");
    public By organisationDropdown = By.xpath("//select[@id='organizations']");

    public By editBtn = By.xpath("//button[text()='Edit']");
    public By additionalProductsHeader=By.xpath("//h4[text()='Additional Products']");
    public By additionalOrganisationTextField = By.xpath("//input[@id='additionalOrganization']");
    public By docPdfLinkUnderAdditionalProducts=By.xpath("//li[@class='my-add-2']//a[1]");
    public By cancelBtn = By.xpath("//button[text()='Cancel']");
    public By currentPwdTxtField = By.xpath("//input[@id='oldPassword']");
    public By newPwdTxtField = By.xpath("//input[@id='newPassword']");

    public By confirmPwdTxtField = By.xpath("//input[@id='confirmPassword']");

    public By savePwdBtn = By.xpath("//button[text()='Save Password']");
    public By Compassusername = By.xpath("(//div[text()='SUB82 Aenor82'])[4]");

    public By compassApiUsername = By.xpath("(//div[text()='PresubFN PresubLN'])[4]");
    public By documentLink = By.xpath("//span[text()='Data Sheets for Welded Tanks for Oil Storage']");

    public By customCollectionLink = By.xpath("//a[text()='Custom Collection']");

    public By myAccountLink = By.xpath("(//span[text()='My Account'])[2]");

    public By firstName = By.xpath("//div[text()='First Name: ']/parent::div//div[2]");

    public By middleName = By.xpath("//div[text()='Middle Name: ']");

    public By lastName = By.xpath("//div[text()='Last Name: ']");
    public By createAccountBtn = By.xpath("//a[contains(text(),'Create Account')]");
    public By firstNameTxtField = By.xpath("//input[@id='firstname']");

    public By lastNme = By.xpath("//input[@id='lastname']");

    public By emailTxtField = By.xpath("//input[@id='email_address']");

    public By pwdTextField = By.xpath("//input[@id='password']");

    public By cnfrmPwdTxtField = By.xpath("//input[@id='password-confirmation']");

    public By crteAccountBtn = By.xpath("//span[text()='Create Account']");

    public By productServiceLink = By.xpath("//a[@id='productsDropdownMenuLink'][1]");

    public By standardsPublicationOption = By.xpath("(//div[@aria-labelledby='productsDropdownMenuLink'])[1]//a[contains(text(),'Standards & Publications')]");
    public By standardProduct = By.xpath("(//div[@aria-labelledby='productsDropdownMenuLink'])[1]//a[contains(text(),'Standards Products')]");

    public By standardsByCategory = By.xpath("//a[text()='Standards by Category']");

    public By adhesiveStandards = By.xpath("(//p[@class='ml-2']//a[contains(text(),'Adhesive Standards')])[1]");

    public By product = By.xpath("//a[text()='  D5363-16 Standard Specification for Anaerobic Single-Component Adhesives (AN) '] ");

    public By addToCardBtn = By.xpath("//span[text()='Add to Cart']");
    public By signInDropDown = By.xpath(
            "//div[@class='astm-dropdown dropdown user-menu-options-dropdown']//span[contains(text(),'Sign In')]");
    private By licenseHeader = By.xpath("//div[contains(@class,'modal-title')]");

    public By cartLink = By.xpath("//span[text()='Cart']");
    public By checkOutBtn = By.xpath("//span[text()='Checkout']");
    public By billingFirstNameTxtField = By.xpath("(//input[@name='firstname'])[1]");

    public By billingLastName = By.xpath("(//input[@name='lastname'])[1]");
    public By streetAddressTxtField = By.xpath("(//input[@name='street[0]'])[1]");

    public By countryDropdown = By.xpath("//select[@id='AJPR18J']");

    public By india = By.xpath("(//option[text()='India'])[1]");

    public WebElement getCustomerLoginPageHeader() {
        return getElement(centralLoginHeader);
    }

    public By LCAmodal = By.xpath("//div[@class='agreement-dialog-container']/div[@class='modal-content']");
    public By Agree = By.xpath("//button[@class='btn astm-btn btn-secondary astm-type-body--lead']");
    public By ASTMLogo = By.xpath("//div[@class='flex-align-items-center']/a");
    public By SignOut = By.xpath("//*[contains(text(),'Sign Out')]");
    public By SignOutLeftMenu = By.xpath("(//*[contains(text(),'Sign Out')])[2]");
    public By MyAccount = By.xpath("//a[contains(text(),'MyAccount')]");
    public By Tracker = By.xpath("//a[contains(@href,'stage-tracker.astm.org')]");
    public By MyDigitalDocuments = By.linkText("My Digital Documents");
    public By MyDigitalDocumentsHeader = By.xpath("//h3[text()='My Digital Documents']");
    public By DocumentTitle = By.xpath("//div[@id='documents-list']//td[2]");
    public By DocumentTitleHeader = By.xpath("//th[text()='Document Title']");
    public By dowloadDocument = By.xpath("//i[@class='far fa-arrow-to-bottom']");

    public By customersIcon = By.xpath("(//span[contains(text(),'Customers')])[1]");
    public By allCustomers = By.xpath("//span[contains(text(),'All Customers')]");

    public By addNewCustomerBtn = By.xpath("//span[contains(text(),'Add New Customer')]");

    public By addFirstNameTxtField = By.xpath("//input[contains(@name,'customer[firstname]')]");

    public By addLastNameTxtField = By.xpath("//input[contains(@name,'customer[lastname]')]");

    public By addMailAddress = By.xpath("//input[contains(@name,'customer[email]')]");

    public By mobileNumberTxtField = By.xpath("//input[contains(@name,'customer[phone_number]')]");

    public By addNewAddressBtn = By.xpath("//span[contains(text(),'Add New Address')]");

    public By streetAddressTextField = By.xpath("//input[contains(@name,'street[0]')]");
    public By trackerLogo = By.xpath("//*[@class='astm-header-logo']");
    public By cssLogo = By.xpath("(//*[contains(@href,'css')])[2]");
    public By trackerMenu = By.xpath("//*[@class='list-unstyled']");

    public WebElement doSignout() {
        return getElement(SignOut);
    }

    public WebElement getSigninDropdown() {
        return getElement(signinDropdown);
    }

    public WebElement getAlertMessage() {
        return getElement(alertMessage);
    }

    public WebElement getSuccessMessage() {
        return getElement(alertMessage);
    }

    public WebElement getAstmLogo() {
        return getElement(astmLogo);
    }

    public By searchBox = By.xpath("//input[@id='search_input_header']");
    public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    public void clickOnDocument(String documentTitle) {
        driver.findElement(By.xpath("//a[text()='" + documentTitle + "']")).click();
    }

    public By getDocument(String documentTitle) {
        return By.xpath("//a[text()='" + documentTitle + "']");
    }

    public boolean registeredCustomerHeader() {
        try {
            return getElement(registeredCustomerHeading).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String registeredCustomerText() {
        try {
            return getElement(registeredCustomerText).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAlertsText() {
        try {
            return getElement(pageAlerts).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean pageHeaderIsVisible() {
        try {
            return getElement(centralLoginHeader).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean newCustomerHeaderIsVisible() {
        try {
            return getElement(newcustomerHeading).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String newCustomerText() {
        try {
            return getElement(newCustomerText).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean navigateToLoginOrRegistrationPage(WebDriver driver, String page) {
        try {
            if (page.equalsIgnoreCase("login")) {
                WaitStatementUtils.waitForElementToBeClickable(driver, getElement(signinDropdown));
                IntegrationCommon.clickonWebElement(driver, signinDropdown);
                WaitStatementUtils.waitForElementToBeClickable(driver, getElement(signinOptionInDropdown));
                IntegrationCommon.clickonWebElement(driver, signinOptionInDropdown);
                return getElement(signinPageHeader).isDisplayed();
            } else if (page.equalsIgnoreCase("MyAccount")) {
                WaitStatementUtils.waitForElementToBeClickable(driver,getElement(signinDropdown),10);
                IntegrationCommon.clickonWebElement(driver, signinDropdown);
                WaitStatementUtils.waitForElementToBeClickable(driver,getElement(myAccountOptionInDropdown),20);
                IntegrationCommon.clickonWebElement(driver, myAccountOptionInDropdown);
                return myAccountPage_Public.pageHeaderIsVisible();
            } else {
                IntegrationCommon.clickonWebElement(driver, signinDropdown);
                IntegrationCommon.clickonWebElement(driver, createAccountOptionInDropdown);
                return getElement(createAnAccountPageHeader).isDisplayed();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public WebElement getAgree() {
        return getElement(Agree);
    }

    public By getlicenseHeader() {
        return licenseHeader;
    }

    public WebElement getLCAmodal() {
        return getElement(LCAmodal);
    }


    public void oneTrustCookieSelectRejectBtn() {
        if (checkElementPresent(cookieRejectBtn)) {
            getElement(cookieRejectBtn).click();
            log.info("Clicked on OneTrust cookie accept button");
        }
    }


    public void agreeAndContinueSelectAcceptBtn() {
        if (checkElementPresent(agreeAndContinue)) {
            ReusableMethods.scrollIntoView(getElement(agreeAndContinue),driver);
            PublicCommon.waitForSec(2);
            getElement(agreeAndContinue).click();
            log.info("Clicked on agree & continue");
        }
    }

    public void selectSignInRegisterButtonIfVisible() {
        if (checkElementPresent(SigninRegister)) {
            getElement(SigninRegister).click();
            //log.info("Clicked on agree & continue");
        }
    }

    @Step("Click on ASTM License agreement Popup")
    public void compassSelectAgreeandContinue() throws IOException {
        PublicCommon.waitForSec(5);
        memberPage.handleOneTrustCookie();
        WaitStatementUtils.waitForLoaderToBeInvisible(driver);
        agreeAndContinueSelectAcceptBtn();
    }


    public void selectAgreeAndContinueandSignin() throws IOException {
        agreeAndContinueSelectAcceptBtn();
        PublicCommon.waitForSec(5);
        selectSignInRegisterButtonIfVisible();
    }

    public boolean compassLogin(String username, String password) {

        try {
            waitForElementPresent(cookieRejectBtn);
            try {
                clickOnMethod("Close one trust cookie message", getElementNew(cookieRejectBtn));
            } catch (Exception e) {
                e.printStackTrace();
            }
            PublicCommon.clearTextFieldsendKeys(getElement(compassUserName), username);
            PublicCommon.clearTextFieldsendKeys(getElement(compassPassword), password);

            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(compassSignInButton), 3000);
            PublicCommon.waitForSec(10);
            getElement(compassSignInButton).click();
            Assert.assertTrue(getElement(getlicenseHeader()).getText().equals("ASTM License Agreement"));
            selectAgreeAndContinueandSignin();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getHeaderText() {
        try {
            return getElement(centralLoginHeader).getText();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean clickHomePageSignInLink() {
        try {
            getElement(btnhomePageSignIn).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickSignInButton() {
        try {
            PublicCommon.JSClick(getElement(btnSignIn), driver);
            // getElement(btnSignIn).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickMAEApplication() {
        try {
            PublicCommon.JSClick(getElement(MAEbtn), driver);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean clickCreateAnAccountButton() {
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(btnCreateAnAccount));
            //PublicCommon.JSClick(getElement(btnCreateAnAccount), driver);
            getElement(btnCreateAnAccount).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickCreateAnAccountButtonOnCreateAccountPage() {
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(createNewAccountButton));
            PublicCommon.JSClick(getElement(createNewAccountButton), driver);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginWithRightCreds(String username, String encryptedPassword) {
        try {
            EncryptionUtil encryptionUtil = new EncryptionUtil();

            // encryptedPassword = encryptionUtil.encrypt(encryptedPassword);
            System.out.println("Encrypted::::" + encryptionUtil.decrypt(encryptedPassword));

            PublicCommon.clearTextFieldsendKeys(getElement(compassUserName), username);
            PublicCommon.clearTextFieldsendKeys(getElement(compassPassword), encryptedPassword);

            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(compassSignInButton), 3000);
            getElement(compassSignInButton).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /*
     * Login Function to Handle login through centralized login page. Prerequisite:
     * User has already landed on the Centralized login page.
     */
    @Step("Login with Existing Customer.")
    public boolean doLogin(String userEmail, String encryptedPassword) {
        try {

            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(btnSignIn), 3000);
            clickSignInButton();
            PublicCommon.waitForSec(3);

            compassLogin(userEmail, encryptedPassword);

            /*
             * Old Implementation EncryptionUtil encryptionUtil = new EncryptionUtil();
             * getElement(emailField).sendKeys(userEmail);
             * getElement(passwordField).sendKeys(encryptionUtil.decrypt(encryptedPassword))
             * ; getElement(signInButton).click();
             */

            //WaitStatementUtils.explicitWaitForVisibility(driver, getElement(loggedInMyASTMButton), 3000);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            PublicCommon.reportFailAssert("Exception while Logging in.", ex);
            return false;
        }
    }

    @Step("Login with Existing Customer.")
    public boolean doLogin1(String userEmail, String encryptedPassword) {
        try {

            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(btnSignIn2), 3000);
            clickSignInButton();
            compassLogin(userEmail, encryptedPassword);

            /*
             * Old Implementation EncryptionUtil encryptionUtil = new EncryptionUtil();
             * getElement(emailField).sendKeys(userEmail);
             * getElement(passwordField).sendKeys(encryptionUtil.decrypt(encryptedPassword))
             * ; getElement(signInButton).click();
             */

            //WaitStatementUtils.explicitWaitForVisibility(driver, getElement(loggedInMyASTMButton), 3000);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            PublicCommon.reportFailAssert("Exception while Logging in.", ex);
            return false;
        }
    }

    public boolean newLoginFlow(String userEmail, String password) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            boolean signBtnPresence = getElements(signInCustomerLoginPage).size() > 0;
            PublicCommon.waitForSec(2);

            if (signBtnPresence) {
                getElement(signInCustomerLoginPage).click();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            } else {
                PublicCommon.JSClick(getElement(signIn), driver);
            }
            PublicCommon.JSClick(getElement(signIn), driver);
            // getElement(signIn).click();
            try {
                clickOnMethod("Close one trust cookie message", getElementNew(cookieRejectBtn));
            } catch (Exception e) {
                e.printStackTrace();
            }
            getElement(uname).sendKeys(userEmail);
            getElement(userPassword).sendKeys(password);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(login).click();
            return VerifyLoginSuccess();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean doLoginPublic(String userEmail, String password) {

        getElement(emailField).sendKeys(userEmail);
        getElement(passwordField).sendKeys(password);
        getElement(signInButton).click();
        if (VerifyLoginSuccess() == true) {
            try {
                ScreenshotUtil.takeScreenshotForAllure(driver);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean VerifyLoginSuccess() {
        try {
//			new WebDriverWait(driver, 30)	.until(ExpectedConditions.invisibilityOfElementLocated(signInDropDown));
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public boolean NewLoginPublic(String userEmail, String password) {

        try {
            getElement(newSignInButton).click();
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(newSignInButton2));
            try {
                clickOnMethod("Close one trust cookie message", getElementNew(cookieRejectBtn));
            } catch (Exception e) {
                e.printStackTrace();
            }
            getElement(userNameTxt).sendKeys(userEmail);
            getElement(passwordTxt).sendKeys(password);
            getElement(newSignInButton2).click();
            if (VerifyLoginSuccess() == true) {
                ScreenshotUtil.takeScreenshotForAllure(driver);
                return true;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

	@Step("Enter valid credentials in Public site and click on SignIn")
	public boolean NewLoginPublic2(String userEmail, String password) {
		try {
            PublicCommon.waitForSec(15);
            memberPage.handleOneTrustCookie();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(newSignInButton2),30);
            getElement(userNameTxt1).sendKeys(userEmail);
            getElement(passwordTxt1).sendKeys(password);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(newSignInButton2).click();
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to member", e);
			return false;
		}

    }

    @Step("Enter valid credentials in Public site and click on SignIn")
    public boolean NewLoginPublic_2(String userEmail, String password) {
        try {
            PublicCommon.waitForSec(5);
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(newSignInButton2),30);
            getElement(userNameTxt1).sendKeys(userEmail);
            getElement(passwordTxt1).sendKeys(password);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(newSignInButton2).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to login to member", e);
            return false;
        }

    }
    @Step("Login into the Membership  site.")
    public void loginToMember(String email, String password) {
        try {
            PublicCommon.JSClick(getElement(PublicSigninbtn1), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(PublicSigninbtn2),30);
            IntegrationCommon.clickonWebElement(driver, PublicSigninbtn2);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertTrue(NewLoginPublic2(email, password));
            PublicCommon.waitForSec(15);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to login to member", e);
        }
    }

    @Step("get Membership Type from public")
    public void getMembershipType() {
        try {
            PublicCommon.openNewTabAndSwitch(driver);
            driver.get("https://stage-member.astm.org/MyASTM/MembershipInfo/Card");
            PublicCommon.waitForSec(20);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicAdminCommons.closeNewTabAndSwitchToOriginalTab(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to login to member", e);
        }
    }

    public boolean loginMicrosoftAccount(String userEmail, String password) {

        try {

            getElement(microsoftEmail).sendKeys(userEmail);
            getElement(microsoftEmailNextBtn).click();
            getElement(microsoftPwd).sendKeys(password);
            getElement(microsoftSigninBtn).click();
            getElement(staySigninNoBtn).click();
            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Step("Login into the Membership  site.")
    public void loginToMemberapp(String email, String password) {
        try {
            driver.get(ConfigReader.getValue("BASE_URL_PUB"));
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(PublicSigninbtn1),30);
            PublicCommon.JSClick(getElement(PublicSigninbtn1), driver);
            PublicCommon.waitForSec(5);
            IntegrationCommon.clickonWebElement(driver, PublicSigninbtn2);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertTrue(NewLoginPublic2(email, password));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to login to member", e);
        }
    }


    public void dragAndDrop(By drag, By drop) {

        WebElement dragEle = getElement(drag);
        WebElement dropEle = getElement(drop);
        Actions action = new Actions(driver);
        action.dragAndDrop(dropEle, dragEle).build().perform();
    }

    @Step("Validate Membership page order details")
    public void VerifyOrderNumberCreatedInMagento(String MagentoOrderNum) {
        try {
            driver.get(ConfigReader.getValue("BASE_URL_PUB_ACCOUNT"));
            driver.navigate().refresh();
            PublicCommon.waitForSec(15);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            IntegrationCommon.clickonWebElement(driver, signInDropDownText);
            PublicCommon.waitForSec(5);
            IntegrationCommon.clickonWebElement(driver, orderPage.MyAccountTab);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(Myaccount_Ordertab), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            IntegrationCommon.clickonWebElement(driver, Myaccount_Ordertab);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ViewDetialsBtn), 15);
            IntegrationCommon.clickonWebElement(driver, ViewDetialsBtn);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            String MemorderNumber = orderPage.getOrderNumber_OrderDetailspage();
            assertEquals(MemorderNumber, MagentoOrderNum);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to login to member", e);
        }
    }

    public void ClickSignIn_From_SignInDropDown_PublicPage(){
        PublicCommon.JSClick(getElement(PublicSigninbtn1), driver);
        clickonWebElement(PublicSigninbtn2, "Unable to click PublicSigninbtn2");
    }

    @Step("Click on Compass from My Account dropdown")
    public void ClickOnCompassFromMyAccount() {
        try {
            IntegrationCommon.clickonWebElement(driver, signInDropDownText);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(compassBtn), 3);
            IntegrationCommon.clickonWebElement(driver, compassBtn);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click on Compass Button", e);
        }
    }


}
