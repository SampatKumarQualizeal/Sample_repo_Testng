package pages.ui;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class LoginPage_PublicAdmin extends BasePage {

	public LoginPage_PublicAdmin(WebDriver driver) {
		super(driver);
	}

//	private By loginTextField = By.cssSelector("#username");
	private final By loginTextField = By.cssSelector("#userName");
//	private By passwordTextField = By.cssSelector("#login");
	private final By passwordTextField = By.cssSelector("#encPass");
//	private By loginButton = By.cssSelector("button.action-login");
	private final By loginButton = By.cssSelector("button[type='submit']");
	private final By logo = By.cssSelector("img.logo-img");
	private final By welcomeLabel = By.xpath("//span[contains(text(),'Welcome, please sign in')]");
	private final By signInViaOktaButton = By.cssSelector("form[action*='sso'] button.action-login");
	private final By acceptAllCookieButton =By.id("onetrust-accept-btn-handler");
	private final By rejectAllCookieButton =By.id("onetrust-reject-all-handler");

	// Following selectors are for public website
	private final By signInButtonPublic = By.xpath("//span[contains(text(),'SIGN IN')]");
	private final By notifcationCloseButton = By.cssSelector("aside.modal-popup.modal-system-messages._show button.action-close");
	public final By signOutSuccessMessage = By.xpath("//div[contains(text(),'You have logged out.')]");
	private final By accessErrorMessage = By.xpath("//div[contains(text(),'Access Denied.')]");
	private final By wrongCredentialsErrorMessage = By.cssSelector("div.alert");
	private final By accountDisabledErrorMessage = By.xpath("//div[contains(text(),'Your account is temporarily disabled.')]");
	private By forgotPassword = By.xpath("//a[text()='Forgot Password?']");
	private By forgotPasswordUserName = By.xpath("//input[@id='userName']");
	public By alertMessage = By.xpath("//div[@class='login-form']//following::div[@role='alert']");

	public By accountNameDrpDwn = By.xpath("//div[@class='admin-user admin__action-dropdown-wrap']");
	public By signinByOctoBtn = By.xpath("//span[text()='Sign in via OKTA']");
	public By signoutBtn = By.linkText("Sign Out");


	public void clickForgotPassword() {
		getElement(forgotPassword).click();
	}

	public void enterForgotPasswordUserName(String usernametoreset) {
		getElement(forgotPasswordUserName).sendKeys(usernametoreset);
	}
	/**
	 * @return RejectAllButton
	 */
	public By getRejectAllCookieButton() {
		return rejectAllCookieButton;
	}
	/**
	 * @return RejectAllButton
	 */
	public By getAcceptAllCookieButton() {
		return acceptAllCookieButton;
	}
	/**
	* @return accountDisabledErrorMessage
	*/
	public By getAccountDisabledErrorMessage(){
	    return accountDisabledErrorMessage;
	}

	/**
	* @return wrongCredentialsErrorMessage
	*/
	public By getWrongCredentialsErrorMessage(){
	    return wrongCredentialsErrorMessage;
	}

	/**
	* @return accessErrorMessage
	*/
	public By getAccessErrorMessage(){
	    return accessErrorMessage;
	}

	/**
	* @return signOutSuccessMessage
	*/
	public By getSignOutSuccessMessage(){
	    return signOutSuccessMessage;
	}

	/**
	 * @return the signInButtonPublic
	 */
	public By getSignInButtonPublic() {
		return signInButtonPublic;
	}

	/**
	 * @return the loginTextField
	 */
	public By getLoginTextField() {
		return loginTextField;
	}

	/**
	 * @return the passwordTextField
	 */
	public By getPasswordTextField() {
		return passwordTextField;
	}

	/**
	 * @return the logo
	 */
	public By getLogo() {
		return logo;
	}

	/**
	 * @return the welcomeLabel
	 */
	public By getWelcomeLabel() {
		return welcomeLabel;
	}

	/**
	 * @return the signInViaOktaButton
	 */
	public By getSignInViaOktaButton() {
		return signInViaOktaButton;
	}

	/**
	 * @return the loginButton
	 */
	public By getLoginButton() {
		return loginButton;
	}

	/**
	 * Enters text in login text field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInLoginTextField(String value) {
		try {
			PublicAdminCommons.clearTxtFieldsendKeys(driver, loginTextField, value);
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enter password in password field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInPasswordTextField(String value) {
		try {
			PublicAdminCommons.clearTxtFieldsendKeys(driver, passwordTextField, value);
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Clicks on login button
	 * 
	 * @return
	 */
	public boolean clickLoginButton() {
		try {
			PublicAdminCommons.clickonWebElement(driver, loginButton);
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	@Step("Logout of Magento Admin")
	public boolean doAdminLogout() {

		try {
			ReusableMethods.scrollIntoView(getElement(accountNameDrpDwn), driver);
			getElement(accountNameDrpDwn).click();
			getElement(signoutBtn).click();
			getElement(signinByOctoBtn).isDisplayed();
			PublicCommon.waitForSec(15);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Switch to Magento and logout")
	public void SwitchToMagentoValidateandLogout(){
		Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver, 0),"Unable to switch to other tab");
		doAdminLogout();
	}

	/**
	 * Login into admin panel
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean loginIntoAdminPanel(String username, String password) {
		try {
			PublicAdminCommons.waitForSec(3000);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(signInViaOktaButton));
			PublicCommon.JSClick(getElementNew(signInViaOktaButton),driver);
			clickAcceptAllButton();
			enterTextInLoginTextField(username);
			enterTextInPasswordTextField(password);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(loginButton));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickLoginButton();
			//PublicCommon.waitForSec(10);
			String expectedPageTitle = "Dashboard / Magento Admin";
			String actualPageTitle = getPageTitle();
			PublicCommon.waitForSec(5);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE).perform();
			return actualPageTitle.equals(expectedPageTitle);
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Login into admin panel as ISS Agent
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean issAgentLogin(String username, String password) {
		try {
			PublicAdminCommons.waitForSec(3000);
			getElementNew(signInViaOktaButton).click();
		/*	if (ConfigReader.getValue("Cookie").equalsIgnoreCase("Accept")) {
				clickAcceptAllButton();
			}
			else
			{
				clickRejectAllButton();
			}*/

			clickRejectAllButton();

			enterTextInLoginTextField(username);
			enterTextInPasswordTextField(password);
			clickLoginButton();
			String expectedPageTitle = "Orders / Operations / Sales / Magento Admin";
			String actualPageTitle = getPageTitle();
			PublicCommon.waitForSec(5);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE).perform();
			return actualPageTitle.equals(expectedPageTitle);
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Login into admin panel
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean loginIntoAdminPanelWithAssertingDashboard(String username, String password) {
		try {
			PublicAdminCommons.waitForSec(3000);
			enterTextInLoginTextField(username);
			enterTextInPasswordTextField(password);
			clickLoginButton();
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * clicks on sign in via okta button
	 * @return
	 */
	public boolean clickSignInViaOktaButton(){
		try {
			PublicAdminCommons.waitForSec(3000);
			getElementNew(signInViaOktaButton).click();
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Login into admin panel
	 *
	 * @param username
	 * @param password
	 * @return Boolean Value
	 */
	public boolean loginIntoAdminPanelWithoutClickingSignInViaOktaButton(String username, String password) {
		try {
			PublicAdminCommons.waitForSec(3000);
			enterTextInLoginTextField(username);
			enterTextInPasswordTextField(password);
			clickLoginButton();
			String expectedPageTitle = "Dashboard / Magento Admin";
			String actualPageTitle = getPageTitle();
			return actualPageTitle.equals(expectedPageTitle);
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Clicks on Reject All button
	 *
	 * @return
	 */
	@Step("Click on Reject All Button")
	private boolean clickRejectAllButton() {
		try {
			PublicAdminCommons.clickonWebElement(driver, getRejectAllCookieButton());
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Clicks on Reject All button
	 *
	 * @return
	 */
	@Step("Click on Reject All Button")
	private boolean clickAcceptAllButton() {
		try {
			PublicAdminCommons.clickonWebElement(driver, getAcceptAllCookieButton());
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}


	@Step("Login to Magento Admin and enter valid credentials")
	public void adminLogin(String username, String password) {
		try {
			driver.get(ConfigReader.getValue("BASE_URL_PUB_ADMIN_ASTM"));
			driver.manage().deleteAllCookies();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			assertTrue((loginIntoAdminPanel(username,password)), "Login was not successful.");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Admin was not able to login.", e);
		}
	}







}
