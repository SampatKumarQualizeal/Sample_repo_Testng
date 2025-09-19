package pages.ui;

import com.astm.commonFunctions.IntegrationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ScreenshotUtil;
import io.qameta.allure.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDropDownMenuPage_RAP extends BasePage {

	public AccountDropDownMenuPage_RAP(WebDriver driver) {
		super(driver);
	}

	// UserSignInOptions Locators

	public By signInDropDown = By.xpath("//i[@class='fas fa-user-circle mr-2']");
	public By signInLinkUnderDropDown = By.xpath("//a[contains(text(), 'Sign In')]");

	public By userName = By.id("userName");
	public By signInPassword = By.id("password");
	public By signIn = By.xpath("//button[text()='Sign In']");

	public By forgotPassword = By.xpath("//a[text()='Forgot Password?']");
	public By forgotPasswordUserName = By.xpath("//input[@id='userName']");
	public By resetViaEmailButton = By.xpath("//button[text()='Reset via Email']");

	public By backToSignInButton = By.xpath("//a[text()='Back to Sign In']]");
	public By accountCreationButton = By.xpath("//a[contains(text(), 'Create Account')]");

	public By firstName = By.id("firstname");
	public By middleName = By.id("middlename");
	public By lastName = By.id("lastname");
	public By organizationName = By.id("additional_organization");
	public By affiliationCheckBox = By.id("company_affiliation");
	public By eMailAddress = By.id("email_address");
	public By accountCreationPassword = By.id("password");
	public By confirmPassword = By.id("password-confirmation");
	public By createAccountButton = By.xpath("//button[@title='Create Account']");
	public By cancelButton = By.xpath("//a[@class='px-3']/span");

	public By useDropDownButton = By.xpath("//div[@class='astm-dropdown dropdown user-menu-options-dropdown']//button");
	public By useDropDownEllipsis=By.cssSelector("[aria-controls='user-menu-options']>span");
	public By SelectUserOne=By.xpath("//div[@class='card astm-card my-3'][1]//a");
	
	public By astmDropDownElements = By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']");
	public By myDigitalDocuments=By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']//a[contains(text(),'My Digital Documents')]");
	public By myDigiDocsInLeftMenu=By.xpath("//a[text()='My Digital Documents']");
	public By myAccountButton = By.xpath("//div//a[contains(text(),'My Account')]");
	public By compassInMyAccount=By.xpath("//a[text()='Compass']");
	public By membershipButton = By.xpath("//li//div//div//a[contains(text(),'Membership')]");
	public By myCommitteesButton = By.xpath("//li//div//div//a[contains(text(),'My Committees')]");
	public By myCollaborationLink = By.xpath("//button[text()='MyCollaboration Areas']");
	public By ordersButton = By.xpath("//li//div//div//a[contains(text(),'Orders')]");
	public By compassButton = By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']//a[contains(text(),'Compass')]");
	public By trackerButton = By.xpath("//li//div//div//a[contains(text(),'Tracker')]");
	public By eLearningButton = By.xpath("//li//div//div//a[contains(text(),'eLearning')]");
	public By specbuilderButton = By
			.xpath("//div[contains(@class,'user-menu-options')]//a[contains(text(),'SpecBuilder')]");
	public By signOutInMyAstmDropDown = By.xpath("//a[@class='dropdown-item' and contains(text(),'Sign Out')]");
	public By SignOutTextUpdate=By.partialLinkText("Sign Out");
	public By signOutSuccessMessage = By.xpath("//div[starts-with(text(), 'Thank you for visiting.')]");
	public By dropDownMenu=By.xpath("//div[@class='dropdown-menu dropdown-menu-right user-menu-options collapse show']");
	public By myCommitteesInLM=By.xpath("//div[@class='nav flex-column astm-nav-tabs astm-nav-tabs--filters nav-pills']//a[text()='My Committees']");

	public By profileButton = By.xpath("//a[text()='Profile']");
	public By contactInfoUnderProfile = By.xpath("//a[text()='Contact Info']");
	public By loginAndPasswordUnderProfile = By.xpath("//a[text()='Login/Password']");

	public By compassFordUser = By.xpath("//div[@id='account-select-container']/div[1]//a");
	public By selectAnUser=By.xpath("//div[@class='account-list']/div[1]//button");
	public By agreeAndContinue=By.xpath("//button[text()='Agree and Continue']");
	public By bCInDD=By.xpath("//ul[@class='breadcrumb astm-breadcrumb d-block px-2']");

	// SignIn button after successfull Log Out of the session
	public By productAddToCart = By
			.xpath("//table[@id='super-product-table']//tr[2]/td[4]//button[@title='Add to Cart']");

	public By studentMembership = By.xpath("//a[contains(text(), 'Become a Student Member')]");
	public By onlineApplication = By.xpath("//a[contains(text(),'online')]");
	public By ordersShortlistMenu=By.xpath("//div[@class='col-md-9 mx-auto']");
	public By compassLogo=By.xpath("//a[@class='user-logo']");
	public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	
	public By trackerInLeftMenu=By.xpath("//a[text()='Tracker']");
	
	public void clickmyDigiDocsInLeftMenu() {
		getElement(myDigiDocsInLeftMenu).click();
	}
	
	public void clickmyDigitalDocuments() {
		getElement(myDigitalDocuments).click();
	}
	
	public void clickmyCommitteesInLM() {
		getElement(myCommitteesInLM).click();
	}
	
	public boolean verifyCompassInMyAccount() {
		return getElements(compassInMyAccount).size()==1;
	}
	public void selectUserOther() {
		if (getElements(selectAnUser).size() == 1)
			getElement(selectAnUser).click();
	}
	
	public void selectAgreeAndContinue() {
		if (getElements(agreeAndContinue).size() == 1)
			getElement(agreeAndContinue).click();
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
	}
	
	public void selectUser() {
		if (getElements(compassFordUser).size() == 1)
			getElement(compassFordUser).click();		
	}

	public void clickForgotPassword() {
		getElement(forgotPassword).click();
	}

	public void enterForgotPasswordUserName(String usernametoreset) {
		getElement(forgotPasswordUserName).sendKeys(usernametoreset);
	}

	public void clickOnResetButton() {
		getElement(resetViaEmailButton).click();
	}

	public void clickProductAddToCart() {
		getElement(productAddToCart).click();
	}

	public By signInAfterLogOut = By.xpath("//a[text()='Sign In']");

	public String gettingText() {
		return getElement(useDropDownEllipsis).getText();
	}
	
	public String gettingTextUseDropDownEllipsis() {
		return getElement(useDropDownEllipsis).getText();
	}
	
	@Step("Entering random Email credential and first name with less than fifteen characters")
	public String getRandomFirstnameLessFifteen() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return "name" + dtf.format(now);
	}
	
	@Step("Entering random Email credential and first name with equal to fifteen characters")
	public String getRandomFirstnameEqualFifteen() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return "names" + dtf.format(now);
	}
	
	@Step("Entering random Email credential and first name with more than fifteen characters")
	public String getRandomFirstnameMoreFifteen() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return "name" + dtf.format(now);
	}
	
	@Step("New User Registration credentails with random first name")
	public void newUserRegistrationRandomFirstName(String middleName, String lastName, String organizationName,
			String password, String confirmPassword) throws InterruptedException {
		enterMiddleName(middleName);
		enterLastName(lastName);
		enterOrganizationName(organizationName);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
	}
	
	@Step("Entering random Email credential")
	public String getRandomEmail() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return "testmail" + dtf.format(now) + "@yopmail.com";
	}
	
	/*
	 * @Step("Entering random firstname credential") public String getFirstName() {
	 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	 * LocalDateTime now = LocalDateTime.now(); return "testmail" + dtf.format(now)
	 * + "@yopmail.com"; }
	 * 
	 * @Step("New User Registration credentails") public void
	 * newUserRegistrationOne(String firstName, String middleName, String lastName,
	 * String organizationName, String password, String confirmPassword) throws
	 * InterruptedException { enterFirstName(firstName);
	 * enterMiddleName(middleName); enterLastName(lastName);
	 * enterOrganizationName(organizationName); enterPassword(password);
	 * enterConfirmPassword(confirmPassword); }
	 */

	@Step("New User Registration credentails")
	public void newUserRegistration(String firstName, String middleName, String lastName, String organizationName,
			String password, String confirmPassword) throws InterruptedException {
		enterFirstName(firstName);
		enterMiddleName(middleName);
		enterLastName(lastName);
		enterOrganizationName(organizationName);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
	}

	@Step("Logging in with valid credentials")
	public boolean performLogin(String userName, String password) {
		try {
			clickSignInButton();
			clickProfileButton();
			PublicCommon.waitForSec(3);
			try {
				IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			userNameToLogin(userName);
			passwordToLogin(password);
			clickOnSignIn();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean enterUserNamePassword(String userName, String password) {
		try {
		userNameToLogin(userName);
		passwordToLogin(password);
		clickOnSignIn();
		PublicCommon.waitForSec(10);
		ScreenshotUtil.takeScreenshotForAllure(driver);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	}

	public String waitForUrl(String url) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains(url));
		return url;
	}

	public boolean verifyMyAstmButton() {
		return getElement(useDropDownButton).isDisplayed();
	}

	public boolean verifyMyAccountButton() {
		return getElement(myAccountButton).isDisplayed();
	}

	public boolean verifyMembershipButton() {
		return getElement(membershipButton).isDisplayed();
	}

	public boolean verifyMyCommittessButton() {
		return getElement(myCommitteesButton).isDisplayed();
	}

	public boolean verifyOrdersButton() {
		return getElement(ordersButton).isDisplayed();
	}

	public boolean verifyCompassButton() {
		return getElements(compassButton).size()==1;
	}

	public boolean verifyTrackerButton() {
		return getElement(trackerButton).isDisplayed();
	}

	public boolean verifyELearningButton() {
		return getElement(eLearningButton).isDisplayed();
	}

	public boolean verifySpecbuilderButton() {
		return getElement(specbuilderButton).isDisplayed();
	}

	public boolean verifySignOutButton() {
		return getElement(signOutInMyAstmDropDown).isDisplayed();
	}

	public void clickUseDropDownButton() {
		PublicCommon.waitForSec(5);
		wait.until(ExpectedConditions.elementToBeClickable(useDropDownButton));
		getElement(useDropDownButton).click();
		waitForElementPresent(dropDownMenu);
	}

	//wait.until(ExpectedConditions.elementToBeClickable(productsAndServicesTabOther));
	
	public void clickMyAccountButton() {
		getElement(myAccountButton).click();
		//wait.until(ExpectedConditions.elementToBeClickable(myCommitteesInLM));
	}

	public void clickMembershipButton() {
		wait.until(ExpectedConditions.elementToBeClickable(membershipButton));
		getElement(membershipButton).click();
	}

	public void clickMyCommittessButton() {
		getElement(myCommitteesButton).click();
		waitForElementPresent(bCInDD);
	}
	public void clickMyMyCollaborationArea() {
		getElement(myCollaborationLink).click();
		waitForElementPresent(bCInDD);
	}

	public void clickOrdersButton() {
		getElement(ordersButton).click();
		waitForElementPresent(ordersShortlistMenu);
	}

	public void clickCompassButton() {
		getElement(compassButton).click();
		PublicCommon.waitForSec(15);
		waitForElementPresent(compassLogo);
	}

	public void clickTrackerButton() {
		wait.until(ExpectedConditions.elementToBeClickable(trackerButton));
		getElement(trackerButton).click();
	}

	public void clickELearningButton() {
		wait.until(ExpectedConditions.elementToBeClickable(eLearningButton));
		getElement(eLearningButton).click();
	}

	public void clickSpecbuilderButton() {
		wait.until(ExpectedConditions.elementToBeClickable(specbuilderButton));
		getElement(specbuilderButton).click();
	}

	public void clickSignInButton() {
		getElement(signInDropDown).click();
	}

	public void clickProfileButton() {
		getElement(signInLinkUnderDropDown).click();
	}

	public void signInLogOut() {
		getElement(signInAfterLogOut).click();
	}

	public void userNameToLogin(String uNToLogin) {
		getElement(userName).sendKeys(uNToLogin);
	}

	public void passwordToLogin(String pwd) {
		getElement(signInPassword).sendKeys(pwd);
	}

	public void clickOnSignIn() {
		getElement(signIn).click();
	}

	public void enterFirstName(String firstName) {
		getElement(this.firstName).sendKeys(firstName);
	}

	public void enterMiddleName(String middleName) {
		getElement(this.middleName).sendKeys(middleName);
	}

	public void enterLastName(String lastName) {
		getElement(this.lastName).sendKeys(lastName);
	}

	public void enterOrganizationName(String organizationName) {
		getElement(this.organizationName).sendKeys(organizationName);
	}

	public void checkOnAffiliation() {
		getElement(affiliationCheckBox).click();
	}

	public void enterEMail(String eMail) {
		getElement(this.eMailAddress).sendKeys(eMail);
	}

	public void enterPassword(String password) {
		getElement(this.accountCreationPassword).sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		getElement(this.confirmPassword).sendKeys(confirmPassword);
	}

	public void clickOnCreateAccountButton() {
		getElement(createAccountButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(useDropDownButton));
	}

	public void clickOnCancelButton() {
		getElement(cancelButton).click();
	}

	public boolean verifySignOutText() {
		try {
			return getElements(signOutInMyAstmDropDown).size() == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void clickOnSignOutInMyAstm() {
		getElement(signOutInMyAstmDropDown).click();
	}

	public boolean verifySignOutSuccessMessage() {
		return getElement(signOutSuccessMessage).isDisplayed();
	}
}
//@Step("Click on {elementName}")
//private void clickOnMethod(String elementName, By locator, String assertionMessage) {
//	try {
//		assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
//	} catch (Exception e) {
//		e.printStackTrace();
//		PublicCommon.reportFailAssert("Failed to Click on element", e);
//	}
//}
