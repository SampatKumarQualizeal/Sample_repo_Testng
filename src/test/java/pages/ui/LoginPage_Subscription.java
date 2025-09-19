package pages.ui;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Allure;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.astm.commonFunctions.IntegrationCommon;
import base.utils.ConfigReader;
import base.utils.EncryptionUtil;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;
import static org.testng.Assert.assertEquals;


public class LoginPage_Subscription extends BasePage {
	EncryptionUtil encryptionUtil;
	MembershipBecomeMemberPage newMembershipPage;
	CompassAPITenant_Page compassAPITenant = getInstance(CompassAPITenant_Page.class);
	String Token=null;

	HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);


	public LoginPage_Subscription(WebDriver driver) {
		super(driver);
	}

	//page Locators
	String environment;
	public By userName = By.name("username");
	public By licenseAgree = By.xpath("//button[text()='Agree and Continue']");
	public By ipWhitelistAuthPopupCloseBtn=By.xpath("//button[@type='button' and @class='btn-close']");
	public By userNameNew = By.name("userName");
	public By passwordNew = By.name("encPass");
	private By password = By.id("encPass");
	private By header = By.name("header");
	public By loginPageVisibility = By.xpath("//h3[@class='astm-type-heading--h3 font-weight-bolder my-3']");
	private By cancelButton = By.xpath("//button[@class='btn btn-secondary']//*[contains(text(),'Cancel']");
	private By validLogin = By.xpath("//h1[contains(text(),'Welcome Back')]");
	public By loginButton = By.xpath("//button[text()='Sign In']");
	public By LCAmodal = By.xpath("//div[@class='modal-content']//div[@class='modal-header']");
	public By SignInNew = By.xpath("(//span[text()='Sign In/Register'])[2]/parent::div");
	public By signInOrRegister = By.xpath("(//span[text()='Sign In/Register']/parent::div[contains(@class,'user-sign-in')])[2]");
	public By SignInHidden = By.xpath("//div[@aria-hidden='false']//a[@id='account_menu_ipad_login-item']");
	public By inValidLoginMessageHeader = By.xpath("//span[contains(text(),'Username or password is incorrect, please try again')]");
	public By AccountSelect = By.xpath("//h1[contains(text(),'Select an Account')]");
	public By AccountSelectButton = By.xpath("//button[@class='btn astm-btn btn-secondary']");
	public By selectButtonAssociatedToAccName(String selectBtnAssociatedWithAccName){
		return  By.xpath("//span[text()='"+selectBtnAssociatedWithAccName+"']/following-sibling::button[text()='Select']");
	}
	public By Agree = By.xpath("//button[@class='btn astm-btn btn-secondary astm-type-body--lead']");
	public By Cookie = By.id("onetrust-group-container");
	public By AgreeCookie = By.id("onetrust-accept-btn-handler");
	public By RemoveCookie = By.id("onetrust-reject-all-handler");
	public By RegisterLink = By.xpath("//a[contains(@href,'registration')]");
	public By AuthenticationVerification = By.xpath("//h1[@class='astm-type-heading--h2 auth-verified-title']");
	public By clickOnAnySelectButton = By.xpath("//span[text()='Civil Aviation Safety Authority']/following-sibling::button");
	public By verifyRecentPage = By.xpath("//span[@class='astm-type-body--small bold badge1 badge badge-secondary' and text()='Standard']");
	public By JWTToken = By.xpath("//body");
	public By spinner = By.className("spinner-icon spinner-border");
	public By UnexpectedErrorBanner = By.xpath("//h2[text()='An unexpected error has occurred.']");
	public By spinnerLoading=By.className("spinner-border spinner-loading");
	public By usernameFedSSO = By.id("okta-signin-username");
	public By passwordFedSSO = By.id("okta-signin-password");
	public By SignInFedSSO = By.id("okta-signin-submit");
	public By OCLClogo = By.xpath("//img[@src='/public/logo.png']");
	public By ezproxyUser = By.name("user");
	public By ezproxyPassword = By.name("pass");
	public By ezproxyLogin = By.xpath("//input[@type='submit']");
	public By OktaSignUpBtn = By.xpath("//a[@class='registration-link']");
	public By OKTAHeader = By.xpath("//h1/img");
	public By CreateAccountHeader = By.xpath("//h2");
	public By InputEmail = By.xpath("//input[@name='email']");
	public By InputPassword = By.xpath("//input[@name='password']");
	public By RegisterBtn = By.xpath("//input[@type='submit']");
	public By ProfileInformationHeader = By.xpath("//h2[text()='Profile Information']");
	public By InputFirstName = By.xpath("//input[@id='firstName']");
	public By InputLastName = By.xpath("//input[@id='lastName']");
	public By SaveBtn = By.xpath("//button[text()='Save']");
	public By AccessToCompassModelHeader = By.xpath("//h5");
	public By OkBtn = By.xpath("//button[text()='OK']");
	public By RegisterHeaderTab = By.xpath("(//div[contains(@class,'sign-in')])[2]");
	public By Registerlink = By.xpath("//a[text()='Register']");
	public By Academicaccess = By.xpath("//select[@name='academicAccess']");
	public By Reg_Firstname = By.xpath("//input[@id='firstName']");
	public By Reg_Lastname = By.xpath("//input[@id='lastName']");
	public By Reg_Email = By.xpath("//input[@name='email']");
	public By Reg_Password = By.xpath("//input[@id='password']");
	public By Invalid_Reg_Password = By.xpath("//input[@class = contains(@class, 'invalid')]");
	public By Reg_ConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	public By Invalid_Reg_ConfirmPassword = By.xpath("//input[@class = contains(@class, 'invalid')]");
	public By CreateAccountBtn = By.xpath("//button[text()='Create Account']");
	public By Login_Username = By.xpath("//input[@name='userName']");
	public By Login_Password = By.xpath("//input[@name='password']");
	public By Signin = By.xpath("//button[text()='Sign In']");
	public By SuccessMsg = By.xpath("//div[@class='astm-alert-text']");
	public By RegistrationSuccessMsg = By.xpath("//span[contains(text(),'Registration Successful')]");
	public By Compass_Username = By.xpath("//input[@id='userName']");
	public By Compass_Password = By.xpath("//input[@id='encPass']");
	public By Compass_SignIn = By.xpath("//button[text()='Sign In']");
	public By cookieAcceptBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public By agreeAndContinue=By.xpath("//button[text()='Agree and Continue']");
	public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public By CompassLogo = By.xpath("//a[@class='user-logo']");
	public By PublicStandardProductsTitle = By.xpath("//span[@class='astm-type-body--lead title-text-bold']/b");
	public By StayOnPageBtn = By.xpath("//a[text()='Stay on Page']");
	public By CompassProductTitle = By.xpath("//p[contains(@class,'doc-designation')]");
	public By GoToASTMcompassBtn = By.xpath("//a[contains(text(),'Go to ASTM Compass')]");
	public By ASTMLicenseHeader = By.xpath("//div[@id='exampleModalLabel']");
	public By MenuBar = By.xpath("//a[@class='brand-logo']/label/span");
	public By sideBarOptions = By.xpath("//div[@id='sidebar']/div/p/a");
	public By compassPointNameLink = By.xpath("//tr[@class='astm-table-tr']/td/span/a");
	public By compassPointHeader = By.xpath("//h2[text()='My Compass Points']");
	public By docPageCompasspointListLink = By.xpath("//span[text()='Compass Points List']");
	public By ASTMlogo = By.cssSelector("body > div.login-container.login-astm > div > div > img");
	public By rememberMeCheckbox = By.xpath("//input[@id='rememberMe']");
	public By compassApplicationSelect = By.xpath("//input[@value='Compass']/following-sibling::button");
	public By Compass_SignInButton = By.cssSelector("#header-tabs .user-sign-in");
	public By sharedDoc = By.xpath("(//tr[@class='astm-table-tr'])[2]");
	public By emailIcon = By.xpath("//i[@class = \"astm-icon far fa-envelope\"]");
	public By CompassDropdown  = By.xpath("//li[@class='dropdown nav-item'][3]");
	public By DropdownPMPage = By.xpath("//a[@class='d-flex align-items-center text-body dropdown-toggle nav-link']");
	public By MyAccount = By.xpath("(//span[text()='My Account'])[2]");
	public By SinoutPMPage= By.xpath("//button[text()='Sign Out']");
	public By SelectAenorAccount = By.xpath("(//button[contains(text(),'Select')])[1]");
	public By ApiDropdown  = By.xpath("//li[@id='account_menu_ipad']");
	public By UsernameDropDown = By.cssSelector("#account_menu_ipad .header-dropdown .user_name");
	public By DocumentsSharedWithMe = By.xpath("(//span[@class='dropdown-item-link astm-type-body'])[3]");
	public By MySharedDocuments = By.xpath("//tr[@class='astm-table-tr']//th[text()='Document']");
	public By UsernameDropDown_SignOut = By.cssSelector("#account_menu_ipad_logout");
	public By CompassHomePage_SelectButton = By.cssSelector(".accounts-content button");


	public WebElement getSelectAenorAccount(){
		return getElement(SelectAenorAccount);
	}
	public WebElement getCompassDropdown(){
		return getElement(CompassDropdown);
	}
	public WebElement getApiDropdown(){
		return getElement(ApiDropdown);
	}
	public WebElement getMyAccount(){
		return getElement(MyAccount);
	}
	public WebElement getMyDropdownPMPage(){
		return getElement(DropdownPMPage);
	}
	public WebElement getMySinoutPMPage(){
		return getElement(SinoutPMPage);
	}

	public WebElement getAgreeCookie() {
		return getElement(AgreeCookie);
	}

	public WebElement getUserName() {
		return getElement(userName);
	}

	@Step("Get JWT Token")
	public WebElement getJWTToken() {
		return getElement(JWTToken);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getPasswordNew() {
		return getElement(passwordNew);
	}
	public WebElement getRegisterHeaderTab() {
		return getElement(RegisterHeaderTab);
	}


	public WebElement getLoginButton() {
		return getElement(loginButton);
	}


	public WebElement getLCAmodal() {
		return getElement(LCAmodal);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public String GetLoginPageTitle() {
		return getPageTitle();
	}

	public void getLoginPageHeader() {
		getPageHeader(header);
	}

	public WebElement getSignInNew() {
		return getElement(SignInNew);
	}

	public WebElement getSignInHidden() {
		return getElement(SignInHidden);
	}

	public WebElement getUserNameNew() {
		return getElement(userNameNew);
	}

	public WebElement getAccountSelect() {
		return getElement(AccountSelect);
	}

	public List<WebElement> getAccountSelectButton() {
		return driver.findElements(AccountSelectButton);
	}

	public WebElement getAgree() {
		return getElement(Agree);
	}

	public WebElement getusernameFedSSO() {
		return getElement(usernameFedSSO);
	}

	public WebElement getpasswordFedSSO() {
		return getElement(passwordFedSSO);
	}

	public WebElement getSignInFedSSO() {
		return getElement(SignInFedSSO);
	}


	//This flow has been changed after new deployment with new login flow
	@Step("Successfully Logged In application")
	public HomePage_Subscripiton doLoginSubscription(String userName,String password) {
		try {
			encryptionUtil=new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}
		getUserName().sendKeys(userName);
		getPassword().sendKeys(encryptionUtil.decrypt(password));
		getLoginButton().click();
		HomePage_Subscripiton home=getInstance(HomePage_Subscripiton.class);
		if(home.VerifyLoginSuccessOnHomePage()==true) {
			return home;
		} else {
			return null;
		}
	}


	/**
	 * This method checks that on logging in with invalid credentials,
	 * the user is displayed an invalid login advisory
	 *
	 * @return True/False based on presence of advisory
	 */
	//@Step("Validating invalid login advisory")
	public boolean verifyInvalidLoginMessage() {
		boolean isVisible = false;
		try {
			getElement(inValidLoginMessageHeader).isDisplayed();
			isVisible = true;


		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
			isVisible = false;
		}
		return isVisible;
	}

	@Step("Validating valid login")
	public boolean verifyValidLogin() {
		boolean isVisible = true;
		try {
			getElement(validLogin).isDisplayed();
			isVisible = true;
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
			isVisible = false;
		}
		return isVisible;
	}


	@Step("User login in Application")
	public HomePage_Subscripiton doLoginSubscriptionSuccessful(String userName, String password) {
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		getUserName().sendKeys(userName);
		getPassword().sendKeys(encryptionUtil.decrypt(password));
		getLoginButton().click();
		if (verifyValidLogin() == true) {
			return getInstance(HomePage_Subscripiton.class);
		} else {
			return null;
		}
	}

	//@Step("Logging in application with invalid credentials")
	public boolean loginWithInvalidCredentials(String userName, String password) {
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SigninRegisterHeaderTab();

		getUserNameNew().click();
		getUserNameNew().sendKeys(userName);
		getPasswordNew().click();
		getPasswordNew().sendKeys(password);
		getLoginButton().click();

		return verifyInvalidLoginMessage();

	}

	public WebElement OCLClogo(){
		return getElement(OCLClogo);
	}

	@Step("Verify EZProxy Login")
	public void EzproxyLogin(String username, String password) {
		try {
			OCLClogo().isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(ezproxyUser).sendKeys(username);
			getElement(ezproxyPassword).sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(ezproxyLogin).click();
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to login to ezproxy", e);
		}

	}
	public void handleOneTrustCookie() {
		try {
			if(getElements(cookieRejectBtn).size()>0){
				IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Login to EZProxy with valid credentials")
	public HomePage_Subscripiton LoginEzProxy() throws IOException {

		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);

		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}
		return home;

	}

	@Step("Sign in to Compass")
	public void SigninCompass(String Username,String Password){
		try {
			SigninRegisterHeaderTab();
			CompassSignIn(Username,Password);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to Signin compass login", e);
		}
	}

	@Step("Verify Login success on compass Home page")
	public HomePage_Subscripiton CompassLoginSuccessMsg(){
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);

		if (home.VerifyLoginSuccessOnHomePage() == true) {

			return home;

		} else {
			return null;
		}
	}

	@Step("Accept ASTM License Agreement")
	public void compassSelectAgreeandContinue() throws IOException {
		PublicCommon.waitForSec(15);
		WaitStatementUtils.waitForElementStaleness(driver,getElement(cookieAcceptBtn));
		if(WaitStatementUtils.explicitWaitForVisibility(driver, getElement(cookieAcceptBtn), 100))
			waitForElementPresent(cookieAcceptBtn);
		try {
			clickOnMethod("Close one trust cookie message", getElementNew(cookieAcceptBtn));
		}catch(Exception e) {
			e.printStackTrace();
		}
		ScreenshotUtil.takeScreenshotForAllure(driver);
	//	WaitStatementUtils.waitForElementStaleness(driver,getElement(agreeAndContinue));
		ReusableMethods.scrollIntoView(getElement(agreeAndContinue),driver);
		if(WaitStatementUtils.waitForElementToBeClickable(driver, getElement(agreeAndContinue), 100))
		{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(agreeAndContinue).click();
			log.info("Clicked on agree & continue");
		}
	}

	@Step("Verify visibility of signin/Register header tab and click on it")
	public void SigninRegisterHeaderTab() {
		try {
			PublicCommon.waitForSec(5);
			wait.until(ExpectedConditions.visibilityOf(getElement(RegisterHeaderTab)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (getElement(RegisterHeaderTab).isDisplayed()){
			clickOnMethod("Sign In/Register", RegisterHeaderTab, "User should be click on Sign In/Register button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify visibility of signin/Register header tab", e);
		}
	}

	@Step("Login to Compass with valid credentials")
	public void CompassSignIn(String email, String password){
		try{
			CompassLogin(email,password);
			driver.getTitle().equals("compass");
			if(WaitStatementUtils.explicitWaitForVisibility(driver,getElement(spinnerLoading),10))
				WaitStatementUtils.waitForElementStaleness(driver,getElement(spinnerLoading),20);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(CompassLogo),10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(CompassLogo),30);
			clickOnMethod("Compass Logo", CompassLogo, "Click on Compass Logo");
		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to signin Compass", e);
		}
	}

	@Step("Click on Register button in login page")
	public void CompassRegistration(){
		try{
			newMembershipPage.handleOneTrustCookie();
			clickOnMethod("Register", Registerlink, "User should be click on Register link");
			newMembershipPage.handleOneTrustCookie();

		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to register compass subscription", e);
		}
	}

	@Step("Verify if registration to compass is successful")
	public void RegistrationSuccessVerification(){
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(SuccessMsg),15);
			driver.getTitle().equals("ASTM Login");
			assertEquals(getElement(SuccessMsg).getText(),"Registration Successful");
		}catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify successful regisration", e);
		}
	}

	public HomePage_Subscripiton doLoginSubscription2838(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}

		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 90);
		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 90);
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		// home.isWebElementDisplayed(LCAmodal); driver.switchTo().frame("myIframe");
		// ReusableMethods.scrollIntoView(getElement(By.xpath( "//span[text()='Definitions.']")), driver);

		//driver.switchTo().defaultContent();
		WaitStatementUtils.waitForElementToBeClickable(driver, getAgree(), 30);
		getAgree().click();

		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 45);
		getSignInNew().click();

		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(password);
			getLoginButton().click();


		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to login", e);
		}

		try {

			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 20);
			getAccountSelectButton().get(1).click();
		} catch (Exception e) {


		}

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}


	/**
	 * New login flow for all users
	 *
	 * @param userName
	 * @param password
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage_Subscripiton doLoginSubscription_SUB3294(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}


		//WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 2);
		//getSignInNew().click();
		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {

		}
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 20);
			getAccountSelectButton().get(0).click();
		} catch (Exception e) {


		}

		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		//verifyVisbility("Authentication Verification Successful", AuthenticationVerification, "User should be able to see the \"Authentication Verification Successful\"");
		return home;

	}


	/**
	 * New login flow for all users
	 *
	 * @param userName
	 * @param password
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage_Subscripiton doLoginSubscription_SUB2769(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}

		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {

		}


		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 20);
			getAccountSelectButton().get(1).click();
		} catch (Exception e) {


		}


		verifyVisbility("Authentication Verification Successful", AuthenticationVerification, "User should be able to see the \"Authentication Verification Successful\"");
		return home;

	}


	/**
	 * New login flow for all users
	 *
	 * @param userName
	 * @param password
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage_Subscripiton doLoginSubscription_SUB2770(String userName, String password) {

		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}

		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getAgree(), 30);
		getAgree().click();


		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		getSignInNew().click();
		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to login", e);
		}


		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 20);
			getAccountSelectButton().get(1).click();
		} catch (Exception e) {

			e.printStackTrace();

		}


		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}

	}

	/**
	 * New login flow for all users
	 *
	 * @param userName
	 * @param password
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage_Subscripiton verifyNewSignInButton(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
//	  
		home.isWebElementDisplayed(LCAmodal);
		// driver.switchTo().frame("myIframe");
		//ReusableMethods.scrollIntoView(getElement(By.xpath("//span[text()='Definitions.']")), driver);
		//driver.switchTo().defaultContent();
		getAgree().click();

		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		getSignInNew().click();

		return home;
	}

	/**
	 * New login flow for Aenor Tenant
	 *
	 * @param userName
	 * @param password
	 * @return
	 */
	public HomePage_Subscripiton doLoginSubscription_Aenor(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}
		getUserNameNew().sendKeys(userName);
		getPassword().sendKeys(password);
		getLoginButton().click();

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}


	/**
	 * New login flow for API Tenant
	 *
	 * @param userName
	 * @param password
	 * @return
	 */
	public HomePage_Subscripiton doLoginSubscription_API(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 25);
		home.isWebElementDisplayed(LCAmodal);
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		ReusableMethods.scrollIntoView(getAgree(), driver);
		getAgree().click();
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		getSignInNew().click();


		getUserNameNew().sendKeys(userName);
		getPassword().sendKeys(encryptionUtil.decrypt(password));
		getLoginButton().click();

		//getAccountSelectButton().get(1).click();

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}

	/**
	 * This login method contains steps to validate the LCA modal
	 *
	 * @param userName
	 * @param password
	 * @return
	 */

	public HomePage_Subscripiton doLoginSubscription_LCA(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 20);
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		home.isWebElementDisplayed(LCAmodal);
		ReusableMethods.scrollIntoView(getAgree(), driver);
		getAgree().click();
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		getSignInNew().click();


		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to login", e);
		}

		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 45);
			getAccountSelectButton().get(1).click();
		} catch (Exception e) {

		}

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}

	public void checkCookie() {
		WebElement elementCookie = getElement(Cookie);
		try {
			verifyVisbility("Cookie message", elementCookie, "Cookie message should be displayed");
			WaitStatementUtils.waitForVisible(driver, Cookie, 5);
			if (isWebElementDisplayed(getElement(Cookie)))
				rejectCookie();
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify Cookie message", e);
		}
	}

	public void rejectCookie() {
		WebElement elementCookie = getElement(Cookie);
		try {

			verifyVisbility("Cookie message", elementCookie, "Cookie message should be displayed");
			clickonWebElement(RemoveCookie, "Unable to click on Remove Cookie");
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify Cookie message", e);
		}
	}

	/**
	 * This method performs login and contains steps to validate LCA modal for Individual User
	 *
	 * @param userName
	 * @param password
	 * @return
	 */

	public HomePage_Subscripiton doLoginSubscription_LCA_IndividualUser(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}

		loginLCA_IndividualUser();
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		AgreeButtonLCA_IndividualUser();

		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 45);
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 45);
		getSignInNew().click();


		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to select account", e);
		}


		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 45);
			getAccountSelectButton().get(1).click();
		} catch (Exception e) {

		}

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}

	//This method test the presence of LCA modal
	@Step("SUB-1915 : To verify that Individual Subscriber will see a modal with the LCA agreement while accessing Compass ")
	private void loginLCA() {

		try {
			verifyVisbility("LCA modal", LCAmodal, "LCA modal should be displayed");
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to validate LCA modal", e);
		}

	}


	//This method test the presence of LCA modal
	@Step("SUB -1879 : To verify that Individual User will see a modal with the LCA agreement while accessing Compass ")
	private void loginLCA_IndividualUser() {
		WaitStatementUtils.explicitWaitForVisibility(driver, getLCAmodal(), 25);
		verifyVisbility("LCA modal", LCAmodal, "LCA modal should be displayed");
	}


	//This method tests the presence of yes, I agree with the License button and clicks on it
	@Step("SUB-1881 : To verify that Individual Subscriber will see a button \"Yes, I agree with the License\" for the LCA agreement while accessing Compass ")
	private void AgreeButtonLCA() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getAgree(), 25);
		verifyVisbility("Yes,I agree with the License", Agree, "\"Yes, I agree with the License\" should be dispalyed");
		getAgree().click();
	}


	//This method tests the presence of yes, I agree with the License button and clicks on it
	@Step("SUB-1917 : To verify that Individual User will see a button \"Yes, I agree with the License\" for the LCA agreement while accessing Compass  ")
	private void AgreeButtonLCA_IndividualUser() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getAgree(), 25);
		verifyVisbility("Yes,I agree with the License", Agree, "\"Yes, I agree with the License\" should be dispalyed");
		getAgree().click();
	}


	/*
	 * This method checks that the Element is visible
	 */
	@Step("Verify the Visibility of {Element}")
	public void verifyVisbility(String Element, By locator, String message) {
		try {
			Assert.assertTrue(home.isWebElementDisplayed(locator), message);
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify the visibility of element", e);
		}
	}

	/*
	 * This method checks that the Element is visible
	 */
	@Step("Verify the Visibility of {Element}")
	public void verifyVisbility(String elementName, WebElement element, String message) {
		try {
			Assert.assertTrue(home.isWebElementDisplayed(element), message);
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify the visibility of element", e);
		}
	}

	/*
	 * This method checks that the Element is visible
	 */
	@Step("Verify {Element} is not displayed")
	public void verifyElementNotVisible(String Element, By locator, String message) {
		try {
			Assert.assertFalse(home.isWebElementDisplayed(locator), message);
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify the visibility of element", e);
		}
	}


	/**
	 * New login flow for SERP scenarios
	 *
	 * @param userName
	 * @param password
	 * @return
	 */
	public HomePage_Subscripiton doLoginSubscription_SERP(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}

		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}

		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 20);
		home.isWebElementDisplayed(LCAmodal);
		//ReusableMethods.scrollIntoView(getAgree(), driver); 
		getAgree().click();

		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		getSignInNew().click();


		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to select account", e);
		}


		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}


	/**
	 * Login flow for SUB 1254
	 *
	 * @param userName
	 * @param password
	 */
	public HomePage_Subscripiton doLoginSubscription_SUB1254(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}

		home.isWebElementDisplayed(LCAmodal);

		getAgree().click();
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
		getSignInNew().click();

		getUserNameNew().sendKeys(userName);
		getPassword().sendKeys(encryptionUtil.decrypt(password));
		getLoginButton().click();





		/*
		 * try { if(home.VerifyLoginSuccessOnHomePage_SUB_1254()==true) { return home;
		 *
		 * }
		 *
		 * } catch (Exception e) {
		 *
		 * }
		 */
		return null;

	}


	/**
	 * Method is used to Login on Mobile browser (Non WhiteListed IP)
	 *
	 * @param userName
	 * @param password
	 * @return
	 */
	public HomePage_Subscripiton doLoginSubscriptionForMobile(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		try {
			encryptionUtil = new EncryptionUtil();

		} catch (Exception e) {
			e.printStackTrace();
		}
		getUserNameNew().sendKeys(userName);
		getPassword().sendKeys(encryptionUtil.decrypt(password));
		getLoginButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AccountSelect));
		WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelect(), 30);
		getAccountSelectButton().get(0).click();

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}


	public HomePage_Subscripiton verifyHomePageForOrganisationSubscriber() {

		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
//		ReusableMethods.scrollIntoView(getAgree(), driver);
		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 90);
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 90);
		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 90);
		home.isWebElementDisplayed(LCAmodal);

		getAgree().click();

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}


	public HomePage_Subscripiton verifyHomePageForOrganisationSubscriber3981() {

		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
//		ReusableMethods.scrollIntoView(getAgree(), driver);
		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 65);
		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 90);
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		home.isWebElementDisplayed(LCAmodal);

		getAgree().click();

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}


	public HomePage_Subscripiton verifyHomePageForOrganisationSubscriber_LCA() {

		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
		if (ConfigReader.getValue("EzProxy").equals("true")) {
			EzproxyLogin(ConfigReader.getValue("EZproxyUser"), ConfigReader.getValue("EZproxyPassword"));
		}
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}
		loginLCA_OrgUser();
		AgreeButtonLCA_OrgUser();

		if (home.VerifyLoginSuccessOnHomePage() == true) {
			return home;

		} else {
			return null;
		}
	}

	//This method test the presence of LCA modal
	@Step("SUB -1878 : To verify that Organization Subscriber will see a modal with the LCA agreement while accessing Compass ")
	private void loginLCA_OrgUser() {

		verifyVisbility("LCA modal", LCAmodal, "LCA modal should be displayed");
	}


	//This method tests the presence of yes, I agree with the License button and clicks on it
	@Step("SUB-1880 : To verify that Organization Subscriber will see a button \"Yes, I agree with the License\" for the LCA agreement while accessing Compass ")
	private void AgreeButtonLCA_OrgUser() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getAgree(), 20);
		verifyVisbility("Yes,I agree with the License", Agree, "\"Yes, I agree with the License\" should be dispalyed");
		getAgree().click();
	}


	public void doLoginAenorSUB_2957(String userName, String password) {


		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		getSignInNew().click();


		try {
			if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
				checkCookie();
			} else {
				rejectCookie();
			}
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to select account", e);
		}


	}

	public void doLoginAenorSUB_3322(String userName, String password) {
		HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);

		try {
			encryptionUtil = new EncryptionUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();


		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to select account", e);
		}


		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 45);
			getAccountSelectButton().get(1).click();
			if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
				checkCookie();
			} else {
				rejectCookie();
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @return true/false value Gets successful login details
	 */
	@Step("Verify Successful login to Compass")
	public boolean VerifyLoginSuccessJWT() {
		try {
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver, home.getWelcomeMessage(), 25);
			wait.until(ExpectedConditions.visibilityOf(home.getWelcomeMessage()));
			boolean value = home.getWelcomeMessage().isDisplayed();
			if(WaitStatementUtils.explicitWaitForVisibility(driver, getElement(cookieAcceptBtn), 30))
				waitForElementPresent(cookieAcceptBtn);
			try {
				clickOnMethod("Close one trust cookie message", getElementNew(cookieAcceptBtn));
			}catch(Exception e) {
				e.printStackTrace();
			}
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void doLoginFedSSOAnonymous(String userName, String password) {
		try {
			encryptionUtil = new EncryptionUtil();
			getusernameFedSSO().sendKeys(userName);
			getpasswordFedSSO().sendKeys(encryptionUtil.decrypt(password));
			Actions act = new Actions(driver);
			act.moveToElement(getSignInFedSSO()).click().build().perform();
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to login", e);
		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getLCAmodal(), 90);
		if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
			checkCookie();
		} else {
			rejectCookie();
		}


		//WaitStatementUtils.waitForElementToBeClickable(driver, getAgree(), 30);
		getAgree().click();


	}

	public void loginAsIndividualSubscriber(String userName, String password) {
		try {
			encryptionUtil = new EncryptionUtil();
			WaitStatementUtils.waitForElementToBeClickable(driver, getSignInNew(), 30);
			getSignInNew().click();

			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(encryptionUtil.decrypt(password));
			getLoginButton().click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}


	/*
	 * This method clicks on the element
	 */
	@Step("Click on {elementName}")
	public void clickOnMethod(String elementName, By locator, String assertionMessage) {
		try {
			Assert.assertTrue(home.clickonWebElement(locator, assertionMessage));
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on element", e);
		}
	}

	@Step("Check OKTA header and click in Signup Button")
	public void OKTASignUp() {
		try {
			getElement(OKTAHeader).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(OktaSignUpBtn),5);
			getElement(OktaSignUpBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Click in Signup Button", e);
		}
	}
	@Step("Click on Ok button when Access to compass header pop-up shows up")
	public void AccessToCompassHeader(){
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(AccessToCompassModelHeader).isDisplayed();
			getElement(OkBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to submit Access to compass header", e);
		}
	}

	public void CreateAccountHeader() {
		WaitStatementUtils.explicitWaitForVisibility(driver, getElement(CreateAccountHeader), 10);
		getElement(CreateAccountHeader).isDisplayed();
	}

	public void ProfileInformationHeader() {

		WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ProfileInformationHeader), 10);
		getElement(ProfileInformationHeader).isDisplayed();
	}

	public WebElement InputEmailFedSSO() {
		return getElement(InputEmail);
	}

	public WebElement InputPasswordFedSSO() {
		return getElement(InputPassword);
	}

	public WebElement InputFirstName() {

		return getElement(InputFirstName);
	}

	public WebElement InputLastName() {
		return getElement(InputLastName);
	}

	public WebElement RegisterLink() {
		return getElement(RegisterBtn);
	}

	public WebElement SaveBtn() {
		return getElement(SaveBtn);
	}

	@Step("Create account and click on Register Button")
	public void FEdSSORegistration(String email) {
		try {
			CreateAccountHeader();
			PublicCommon.waitForSec(5);
			InputEmailFedSSO().sendKeys(email);
			InputPasswordFedSSO().sendKeys("Test@123456");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			RegisterLink().click();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Input account details while registering", e);
		}

	}

	@Step("Complete Progressive Profiling.")
	public void FEdSSOProfileInformation() {
		try {
			ProfileInformationHeader();
			InputFirstName().sendKeys("Duke");
			InputLastName().sendKeys("Simon");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Input account details while registering", e);
		}

	}

	@Step("Check if user is able to login with created account")
	public void LoginFEdSSOOKTA(String userName, String password) {
		try {
			getusernameFedSSO().sendKeys(userName);
			getpasswordFedSSO().sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Actions act = new Actions(driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			act.moveToElement(getSignInFedSSO()).click().build().perform();
			PublicCommon.waitForSec(15);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to login", e);
		}

	}
	public WebElement getLoginUsername(){
		return getElement(Compass_Username);
	}


	public WebElement getLoginPassword() {
		return getElement(Compass_Password);
	}
	public WebElement getLoginSignin(){
		return getElement(Compass_SignIn);
	}

	public WebElement getFirstname() {
		return getElement(Reg_Firstname);
	}

	public WebElement getLastname() {
		return getElement(Reg_Lastname);
	}

	public WebElement getEmailID() {
		return getElement(Reg_Email);
	}

	public WebElement getReg_Password() {
		return getElement(Reg_Password);
	}

	public WebElement getReg_ConfirmPassword() {
		return getElement(Reg_ConfirmPassword);
	}
	public void CreateAccountBtn(){
		getElement(CreateAccountBtn).click();
	}



	@Step("Input required fields to register for compass application")
	public void RegistrationDetails(String Firstname, String Lastname,String email, String Password){
		try {
			getFirstname().sendKeys(Firstname);
			getLastname().sendKeys(Lastname);
			getEmailID().sendKeys(email);
			getReg_Password().sendKeys(Password);
			getReg_ConfirmPassword().sendKeys(Password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			CreateAccountBtn();
		}  catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to input details for registration", e);
		}

	}
	@Step("Check if user is able to launch Compass url through Whitelisted IP and Accept the license")
	public void CheckASTMLicenseAgreement() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			compassSelectAgreeandContinue();
			PublicCommon.waitForSec(15);
			driver.getTitle().equals("Compass");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Check if user is able to launch Compass url through Whitelisted IP and Accept the licenseP", e);
		}
	}

	public void oneTrustCookieSelectAcceptBtn(){
		if(checkElementPresent(cookieAcceptBtn)){
			getElement(cookieAcceptBtn).click();
			log.info("Clicked on OneTrust cookie accept button");
		}
	}

	public void agreeAndContinueSelectAcceptBtn(){
		if(checkElementPresent(agreeAndContinue)){
			WaitStatementUtils.waitForElementStaleness(driver,getElement(agreeAndContinue),10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(agreeAndContinue),10);
			getElement(agreeAndContinue).click();
			log.info("Clicked on agree & continue");
		}
	}

	public void selectSignInRegisterButtonIfVisible(){
		PublicAdminCommons.scrollToElement(driver,SignInNew);
		PublicCommon.waitForSec(2);
		if(checkElementPresent(SignInNew)){
			WaitStatementUtils.waitForLoaderToBeInvisible(driver);
			PublicCommon.JSClick(getElement(SignInNew),driver);
			log.info("Clicked on SignIN /Register Button only if it is visible");
		}
	}


	@Step("Compass Login")
	public void CompassLogin(String email, String password){
		try{
			if(WaitStatementUtils.explicitWaitForVisibility(driver,getElement(cookieAcceptBtn), 10)) {
				try {
					clickOnMethod("Close one trust cookie message", getElement(cookieAcceptBtn));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);

			if (!WaitStatementUtils.explicitWaitForVisibility(driver, getLoginUsername(), 30)) {
				WebElement agreeAndContinueButton = getElement(agreeAndContinue);
				if (WaitStatementUtils.waitForElementToBeClickable(driver, agreeAndContinueButton, 10)) {
					PublicAdminCommons.scrollToElement(driver,agreeAndContinueButton);
					PublicCommon.waitForSec(2);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					PublicAdminCommons.clickElementByJavaScript(driver, agreeAndContinue);
					log.info("Clicked on agree & continue");
				}
				PublicCommon.waitForSec(5);
				WebElement CompassSignInBtn = getElement(Compass_SignInButton);
				if (WaitStatementUtils.waitForElementToBeClickable(driver, CompassSignInBtn, 10)) {
					PublicAdminCommons.scrollToElement(driver, Compass_SignInButton);
					CompassSignInBtn.click();
					log.info("Clicked Compass SignIn Button");
				}
				WaitStatementUtils.explicitWaitForVisibility(driver, getLoginUsername(), 30);
			}
			getLoginUsername().sendKeys(email);
			getLoginPassword().sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getLoginSignin(),driver);
			getLoginSignin().click();
			PublicCommon.waitForSec(10);
			if (WaitStatementUtils.waitForVisible(driver, UnexpectedErrorBanner,10)){
				ScreenshotUtil.takeFullPageScreenshot();
				driver.navigate().refresh();
			}
			WaitStatementUtils.waitForElementToBeInVisible(driver,spinner,10);
			handleOneTrustCookie();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to Compass", e);
		}
	}


	public WebElement getStandardProductTitle(){
		return getElement(PublicStandardProductsTitle);
	}

	public WebElement getCompassDocTitle(){
		return getElement(CompassProductTitle);
	}
	public WebElement GoToASTMCompassBtn(){ return getElement(GoToASTMcompassBtn); }

	@Step("Get Document title and wait for dynamic redirect to compass")
	public String getPublicDocumentTitle() {
		String PublicDocumentTitle = null;
		try {
			PublicDocumentTitle = getStandardProductTitle().getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicDocumentTitle;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get Document Title", e);
		}
		return PublicDocumentTitle;
	}

	@Step("Wait for dynamic redirect")
	public boolean DynamicWaitforRedirect(){
		try{
			//WaitStatementUtils.explicitWaitForVisibility(driver, getElement(StayOnPageBtn),5);
			PublicCommon.waitForSec(30);
			if (VerifyGoToASTMcompass() == true) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				//GoToASTMCompassBtn().click();
				return true;
			} else if (WaitStatementUtils.explicitWaitForVisibility(driver,getElement(ASTMLicenseHeader),10)) {
				PublicCommon.waitForSec(10);
				driver.getTitle().equals("compass");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to wait in Public document page", e);
		}
		return false;
	}

	public boolean VerifyGoToASTMcompass() {
		try {
			//PublicCommon.waitForSec(15);
			//wait.until(ExpectedConditions.visibilityOf(GoToASTMCompassBtn()));
			//WaitStatementUtils.waitForElementToBeClickable(driver, GoToASTMCompassBtn(), 30);
			if (GoToASTMCompassBtn().isDisplayed()) {
				GoToASTMCompassBtn().click();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	@Step("Get Compass Document title")
	public String getCompassDocumentTitle() {
		String CompassDocumentTitle = null;
		try {
			CompassDocumentTitle = getCompassDocTitle().getText();
			return CompassDocumentTitle;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get compass Document Title", e);
		}
		return CompassDocumentTitle;
	}

	@Step("Close browser")
	public void CloseBrowser(){
		driver.close();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}
		System.out.println(driver.getTitle());
	}

	@Step("Select an account in Compass page")
	public void selectAnAccountCompass(String accountToSelect){
		try{
			if(WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelect(), 30)) {
				new Actions(driver).click(getElement(selectButtonAssociatedToAccName(accountToSelect))).build().perform();
				PublicCommon.waitForSec(2);
//				handleOneTrustCookie();
				WaitStatementUtils.waitForElementToBeInVisible(driver,spinner,30);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to select An Account in Compass", e);
		}
	}

	@Step("Validate Menu bar options if Compass Points link is Enabled/Disabled")
	public void ValidateCompassPointsLink(String CompassPointToggle,String CompassPointsLink){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MenuBar),20);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToElement(driver,MenuBar);
			getElement(MenuBar).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(CompassPointToggle.equals("Enabled")){
				validateMenuBarOptions(CompassPointsLink);
				verifyViewCompassPointOptionOnAccessedPDFapp();
			} else if (CompassPointToggle.equals("Disabled")) {
				validateMenuBarOptions(CompassPointsLink);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Validate Compass Points Link", e);
		}
	}

	@Step("Validate Menu bar options if Groups link is Enabled/Disabled")
	public void ValidateGroupsLink(String CompassPointToggle,String GroupsLink){
		try{
			WaitStatementUtils.waitForElementStaleness(driver, getElement(MenuBar),20);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(MenuBar).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(CompassPointToggle.equals("Enabled")){
				validateMenuBarOptions(GroupsLink);
			} else if (CompassPointToggle.equals("Disabled")) {
				validateMenuBarOptions(GroupsLink);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Validate Groups Link", e);
		}
	}

	@Step("Check for link if it's present")
	public boolean validateMenuBarOptions(String Link) {
		try {
			getElement(sideBarOptions);
			List<WebElement> groupElements = driver.findElements(sideBarOptions);
			for (WebElement groupElement : groupElements) {
				if (groupElement.getText().equals(Link)) {
					Allure.addAttachment("link present", Link);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					driver.findElement(By.xpath("//div[@id='sidebar']/div/p/a[text()='"+Link+"']")).click();
					return true;
				}
			}
				Allure.addAttachment("link not present", Link);
				PublicCommon.waitForSec(10);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Successfully Checked for link if it's present or not");
		}
		return true;
	}

	@Step("Verify view Compass point Option On Accessed PDF app")
	public void verifyViewCompassPointOptionOnAccessedPDFapp(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(compassPointNameLink));
			Assert.assertEquals(getElement(compassPointHeader).getText(),"My Compass Points");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(compassPointNameLink).click();
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(docPageCompasspointListLink));
			ReusableMethods.scrollIntoView(getElement(docPageCompasspointListLink), driver);
			Assert.assertEquals(getElement(docPageCompasspointListLink).getText(),"Compass Points List");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Successfully Checked for Compass points link if it's present or not");
		}
	}

	@Step("Vrify ASTM logo")
	public void verifyAstmLogo(){
		try{
			WaitStatementUtils.waitForElementStaleness(driver,getElement(ASTMlogo));
			getElement(ASTMlogo).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to verify ASTM logo");
		}
	}
	@Step("Sign in to user whose IP is not whitelisted")
	public void signInUserWithNotWhitelistedIP(String email, String password){
		try{
			compassUsernamePassword1(email,password);
			SignInBtn();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to Sign in to user whose IP is not whitelisted");
		}
	}

	@Step("Enter Username and Password for central login")
	public void compassUsernamePassword(String email, String password) {
		try{
			verifyAstmLogo();
			getLoginUsername().sendKeys(email);
			getLoginPassword().sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Successfully Checked for Compass points link if it's present or not",e);
		}
	}
	@Step("Enter Username and Password for central login")
	public void compassUsernamePassword1(String email, String password) {
		try{
			getLoginUsername().sendKeys(email);
			getLoginPassword().sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Successfully Checked for Compass points link if it's present or not",e);
		}
	}

	@Step("Check remember me checkbox")
	public void setRememberMeCheckbox() {
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(rememberMeCheckbox));
			getElement(rememberMeCheckbox).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Successfully Checked Check remember me checkbox",e);
		}
	}

	@Step("Click on Signin Button")
	public void SignInBtn(){
		try{
			ReusableMethods.scrollIntoView(getLoginSignin(),driver);
//			getLoginSignin().click();
			PublicCommon.JSClick(getLoginSignin(),driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on Sign In Button",e);
		}
	}

	@Step("Select compass application")
	public void selectCompassApplication(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(compassApplicationSelect));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(getElement(compassApplicationSelect).isDisplayed()){
				getElement(compassApplicationSelect).click();
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Validate Compass Points Link", e);
		}
	}

	@Step("Verify remember me checkbox ")
	public void verifyRememberMeCheckbox(String checkbox){
		try{
			PublicCommon.waitForSec(15);
			selectSignInRegisterButtonIfVisible();
			verifyAstmLogo();
			getElement(rememberMeCheckbox).getAttribute("checked").equals(checkbox);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Validate Compass Points Link", e);
		}
	}

	@Step("Clear cookies and refresh to check remember me checkbox")
	public void deletecCookies(){
		try {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			verifyAstmLogo();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}  catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to delete cookies and verify rememberme Checkbox", e);
		}
	}

	public void doLoginSubscriptionNew_INT682(String userName,String password) {
		try {
			clickOnMethod("Reject Cookie",cookieRejectBtn,"Reject All cookie clicked");
			PublicCommon.waitForSec(10);
			if(WaitStatementUtils.explicitWaitForVisibility(driver, getElement(agreeAndContinue), 5000)) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				//ReusableMethods.scrollIntoView(getElement(agreeAndContinue),driver);
				if(WaitStatementUtils.waitForElementToBeClickable(driver, getElement(agreeAndContinue), 10000)) {
					getElement(agreeAndContinue).click();
				}
				log.info("Clicked on agree & continue");
			}
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(password);
			getLoginButton().click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountSelectButton().get(0), 20);
			getAccountSelectButton().get(0).click();
		}  catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Unable to login", e);
		}
	}
	@Step("Login to Subscription application")
	public void doLoginSubscriptionNew_ipWhitelisted(String userName,String password) {
		try {
			clickOnMethod("Reject Cookie", cookieRejectBtn, "Failed to click on Reject All cookie");
			PublicCommon.waitForSec(5);
			if (WaitStatementUtils.explicitWaitForVisibility(driver, getElement(agreeAndContinue), 5000)) {
				ReusableMethods.scrollIntoView(getElement(agreeAndContinue),driver);
				PublicCommon.waitForSec(5);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				ReusableMethods.clickOnWE(driver,"Agree & Continue button",agreeAndContinue,"Failed to click Agree & Continue button");
				//getElement(agreeAndContinue).click();
				log.info("Clicked on agree & continue");
			}
			PublicCommon.waitForSec(2);
			ReusableMethods.scrollIntoView(getElement(signInOrRegister),driver);
			/*PublicCommon.waitForSec(5);*/
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",getElement(signInOrRegister));
			getUserNameNew().sendKeys(userName);
			getPassword().sendKeys(password);
			PublicCommon.waitForSec(5);
			getLoginButton().click();
			PublicCommon.waitForSec(5);
			Assert.assertTrue(verifyValidLogin(),"Failed to see Homepage because of Unsuccessful login");
			} catch (Exception e) {
				e.printStackTrace();
				IntegrationCommon.reportFailAssert("Unable to login", e);
			}
		}
		public boolean isWebElementDisplayed (WebElement element){
			try {
				return element.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}
	public void JSClick(WebElement element, WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getRandomNumbers(int inputCharCount) {
		try {
			RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('1', '3').build();
			String randomLetters = generator.generate(inputCharCount);
			return randomLetters;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Step("Verify successful login of compass through Valid JWT Link with Tenant")
	public void verifyCompassLogin_JWTAuth(String JWTredirect) {
		try {
			Token = getJWTToken().getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			log.info(Token);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			System.out.println(Token);
			String Redirect_Url = JWTredirect+Token;
			PublicCommon.waitForSec(10);
			driver.get(Redirect_Url);
			PublicCommon.waitForSec(10);
			Assert.assertTrue(VerifyLoginSuccessJWT(), "User should be able to land on Compass homepage");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify bypass login and access compass ", e);
		}
	}
	@Step("New User Creation & Login")
	public void createNewUser(String email, String password){
		try{
			WaitStatementUtils.waitForElementToBeInVisible(driver, signInOrRegister, 5);
			selectSignInRegisterButtonIfVisible();
			handleOneTrustCookie();
			clickOnMethod("Register", Registerlink, "User should be click on Register link");

			WaitStatementUtils.waitForElementToBeClickable(driver, getFirstname());
			getFirstname().click();
			getFirstname().sendKeys("Test");
			getLastname().click();
			getLastname().sendKeys("User");
			getEmailID().click();
			getEmailID().sendKeys(email);
			getReg_Password().click();
			getReg_Password().sendKeys(password);
			getReg_ConfirmPassword().click();
			getReg_ConfirmPassword().sendKeys(password);

			CreateAccountBtn();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			WaitStatementUtils.explicitWaitForVisibility(driver, getUserNameNew(), 5);
			getUserNameNew().click();
			getUserNameNew().sendKeys(email);
			getPassword().click();
			getPassword().sendKeys(password);
			getElement(Signin).click();

			WaitStatementUtils.explicitWaitForVisibility(driver, getUserNameNew());

		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify user navigates to 'My Groups' page", e);
		}
	}

	@Step("Sign out of compass")
	public void signOutOfCompass(){
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(compassAPITenant.UsernameDropDown),10);
			PublicCommon.JSClick(getElement(compassAPITenant.UsernameDropDown),driver);
			PublicCommon.waitForSec(2);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(compassAPITenant.UsernameDropDown_SignOut));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(compassAPITenant.UsernameDropDown_SignOut).click();
			PublicCommon.waitForSec(2);
		}catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Sign Out of compass", e);
		}
	}

	@Step("Register a new user in Compass with whitelisted IP")
	public void newUserCreation(String email, String password) throws IOException {
		try {
			handleOneTrustCookie();
			clickOnMethod("Register", Registerlink, "User should be click on Register link");

			CreateAccountBtn();
			List<WebElement> invalid = getElements(Invalid_Reg_Password);
			Assert.assertTrue(invalid.size() > 5, "Unable to see the red highlight in the 'Confirm Password' field");

			WaitStatementUtils.waitForElementToBeClickable(driver, getFirstname());
			getFirstname().click();
			getFirstname().sendKeys("Automation_Test");
			getLastname().click();
			getLastname().sendKeys("User");
			getEmailID().click();
			getEmailID().sendKeys(email);

			//Step 16 - Enter the data in password field that doesn't satisfy the required condition
			getReg_Password().click();
			getReg_Password().sendKeys("qz123");
			getReg_ConfirmPassword().click();
			Assert.assertTrue(compassAPITenant.verifyVisibility("Invalid Password", getElement(Invalid_Reg_Password), "Unable to see the red highlight in the 'Password' field"));
			ScreenshotUtil.takeScreenshotForAllure(driver);

			//Step 17 - Enter data in "confirm password" field that doesn’t match the "actual Password" field
			getReg_Password().clear();
			getReg_Password().sendKeys("Qualizeal123");
			getReg_ConfirmPassword().click();
			getReg_ConfirmPassword().sendKeys("Qualiz123");
			CreateAccountBtn();
			Assert.assertTrue(compassAPITenant.verifyVisibility("Invalid Confirm Password", getElement(Invalid_Reg_ConfirmPassword), "Unable to see the red highlight in the 'Confirm Password' field"));
			PublicCommon.waitForSec(2);
			ScreenshotUtil.takeScreenshotForAllure(driver);

//            loginPageSubscription.getReg_Password().clear();
			getReg_Password().sendKeys(Keys.CONTROL + "a");
			getReg_Password().sendKeys(Keys.DELETE);
			getReg_Password().sendKeys(password);
			getReg_ConfirmPassword().clear();
			getReg_ConfirmPassword().sendKeys(password);
			CreateAccountBtn();
			PublicCommon.waitForSec(4);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			WaitStatementUtils.explicitWaitForVisibility(driver, getUserNameNew(), 8);
			getUserNameNew().click();
			getUserNameNew().sendKeys(email);
			getPassword().clear();
			getPassword().sendKeys(password);
			getElement(Signin).click();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ASTMlogo));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to register a new user in Compass with whitelisted IP", e);
		}
	}

	@Step("Register a new user in Compass with whitelisted IP")
	public void newUserRegistration(String email, String password) throws IOException {
		try {
			handleOneTrustCookie();
			PublicCommon.waitForSec(5);

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(agreeAndContinue), 5000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(agreeAndContinue),driver);
			PublicCommon.waitForSec(3);
//            ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.clickOnWE(driver,"Agree & Continue button",agreeAndContinue,"Failed to click Agree & Continue button");
			//getElement(agreeAndContinue).click();
			log.info("Clicked on agree & continue");
			PublicCommon.waitForSec(2);

			ReusableMethods.scrollIntoView(getElement(signInOrRegister),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",getElement(signInOrRegister));

			handleOneTrustCookie();
			ReusableMethods.scrollDownToBottomOfPage(driver);
			Assert.assertTrue(isWebElementDisplayed(getElement(Academicaccess)), "Unable to view Academic Access dropdown in login screen");
			clickOnMethod("Register", Registerlink, "User should be click on Register link");

			WaitStatementUtils.waitForElementToBeClickable(driver, getFirstname());
			getFirstname().click();
			getFirstname().sendKeys("Automation_Test");
			getLastname().click();
			getLastname().sendKeys("User");
			getEmailID().click();
			getEmailID().sendKeys(email);

			//Step 16 - Enter the data in password field that doesn't satisfy the required condition
			getReg_Password().click();
			getReg_Password().sendKeys("qz123");
			getReg_ConfirmPassword().click();
			Assert.assertTrue(compassAPITenant.verifyVisibility("Invalid Password", getElement(Invalid_Reg_Password), "Unable to see the red highlight in the 'Password' field"));
			ScreenshotUtil.takeScreenshotForAllure(driver);

			//Step 17 - Enter data in "confirm password" field that doesn’t match the "actual Password" field
			getReg_Password().clear();
			getReg_Password().sendKeys("Qualizeal123");
			getReg_ConfirmPassword().click();
			getReg_ConfirmPassword().sendKeys("Qualiz123");
			CreateAccountBtn();
			Assert.assertTrue(compassAPITenant.verifyVisibility("Invalid Confirm Password", getElement(Invalid_Reg_ConfirmPassword), "Unable to see the red highlight in the 'Confirm Password' field"));
			PublicCommon.waitForSec(2);
			ScreenshotUtil.takeScreenshotForAllure(driver);

//            loginPageSubscription.getReg_Password().clear();
			getReg_Password().sendKeys(Keys.CONTROL + "a");
			getReg_Password().sendKeys(Keys.DELETE);
			getReg_Password().sendKeys(password);
			getReg_ConfirmPassword().clear();
			getReg_ConfirmPassword().sendKeys(password);
			CreateAccountBtn();
			PublicCommon.waitForSec(4);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			WaitStatementUtils.explicitWaitForVisibility(driver, getUserNameNew(), 8);
			getUserNameNew().click();
			getUserNameNew().sendKeys(email);
			getPassword().clear();
			getPassword().sendKeys(password);
			getElement(Signin).click();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(compassAPITenant.DownloadDocument));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to register a new user in Compass with whitelisted IP", e);
		}
	}

	@Step("Verify user with API tenants able to Login Compass Application")
	public void APISignIn(String email, String password){
		try{
			CompassLoginWithOutCookiesClose(email,password);
			driver.getTitle().equals("compass");

		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to signin Compass", e);
		}
	}

	@Step("Compass Login")
	public void CompassLoginWithOutCookiesClose(String email, String password){
		try{
			// ScreenshotUtil.takeScreenshotForAllure(driver);
			getLoginUsername().sendKeys(email);
			getLoginPassword().sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getLoginSignin(),driver);
			getLoginSignin().click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to Compass", e);
		}
	}

	@Step("Logout of Compass")
	public void logoutOfCompass(){
		try {
			getElement(UsernameDropDown).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(UsernameDropDown_SignOut));
			getElement(UsernameDropDown_SignOut).click();

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(Compass_Username));
			Assert.assertTrue(getElement(Compass_Username).isDisplayed());
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Logout of Compass", e);
		}
	}

	@Step("SignIn to compass")
	public String signInToCompass(String uname, String pwd) {
		String compassLoggedInUname = "";
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(signInOrRegister), 5000);
			PublicCommon.JSClick(getElement(signInOrRegister),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(Compass_Username),10);
			CompassLoginWithOutCookiesClose(uname,pwd);
			if(home.getElements(CompassHomePage_SelectButton).size() > 0) {
				new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(home.getElements(CompassHomePage_SelectButton).get(0))).click();
				PublicCommon.waitForSec(5);
			}
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(UsernameDropDown),10);
			compassLoggedInUname=getElement(UsernameDropDown).getText();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Signin to compass", e);
		}
		return compassLoggedInUname;
	}
}