package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class MyAccountPage_Public extends BasePage {

	public MyAccountPage_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	OrderConfirmPage_Integration orderPage;
	CustomerLogin_Public customerLoginPage;

	static final String myAccount = "My Account";
	public By myAccountUserDetails=By.xpath("//p[@class='mb-2']");
	public By pageHeader = By.xpath("//*[@class='astm-type-heading--h3 mt-0']");
	public By pageHeaderText = By.xpath("//h3[text()='My Account']");
	public By signOutBtn = By.xpath("//a[contains(text(),'Sign Out')]");
	public By MyCommitteeSignoutDropdown = By.xpath("//button[contains(text(),'Sign Out')]");
	public By myAccountBtn = By.xpath("//a[contains(text(),'My Account')]");
	public By eLearningLinkLeftNav = By.xpath("//a[@class='nav-link elearning-link']");
	public By signOutBtnLeftNav = By.xpath("//a[@class='btn astm-btn astm-btn--small btn-primary ml-3 d-flex align-items-center mt-1' and contains(text(),'Sign Out')]");
	public By MyAccountLeftNav = By.xpath("//a[contains(text(),'MyAccount')]");
	public By MyDigitalDocBtnLeftNav = By.xpath("//a[@class='nav-link ' and contains(text(),'My Digital Documents')]");

	public By closeBtn = By.xpath("//button[@class='btn astm-btn btn-secondary' and contains(text(),'Close')]");
	public By compassDropdown = By.xpath("//div[contains(@class,'dropdown-menu')]/a[contains(text(),'Compass')]");
	public By myDigitalDocumentsDropdown = By.xpath("//div[contains(@class,'dropdown-menu')]/a[contains(text(),'My Digital Documents')]");
	public By documentTitleFormat = By.xpath("//div[@id='additional-heading0']//following-sibling::div/div/ul/li/p/a[1]");
	public By OkBtn = By.xpath("//button[text()='OK']");
	public By CompassModalHeader = By.xpath("//div[@id='exampleModalLabel']");
	public By errorMsgText= By.xpath("//div[@class='modal-body astm-type-body--lead my-0' and contains(text(),'You currently do not have access to any training programs. Browse all')]//a");
	public By eLearningLinkMyAccount = By.xpath("//a[@class='dropdown-item elearning-link']");
	public By renewMembershipButton = By.xpath("//*[contains(text(),'Renew Membership')]");
	public By reinstateMembershipButton = By.xpath("//*[contains(text(),'Reinstate Membership')]");
	public By yesBtnONCnfrmtnPopup = By.xpath("//button[@class='astm-btn astm-btn--secondary btn btn-secondary' and text()='Yes']");
	public By noBtnONCnfrmtnPopup = By.xpath("//button[@class='astm-btn astm-btn--light btn btn-light' and text()='No']");

	// public By renewMembershipButton = By.xpath("//*[text()='Renew Membership']");
	public By linkCompass = By.xpath("//a[text()='Compass']");
	private By activeNavLinkMyAccount = By.xpath("//*[@id='block-collapsible-nav']//a[@class='nav-link active']");
	public By compassLeftNavLink = By.linkText("Compass");
	public By compassPageHeader = By.xpath("//h3[text()='Your Subscription UOP']");
	public By myDigitalDocumentsLeftNavLink = By.linkText("My Digital Documents");
	public By ordersLeftNavLink = By.linkText("Orders");//span[contains(text(),'You have placed no orders.')]
	public By orderNotDisplayed = By.xpath("//span[contains(text(),'You have placed no orders.')]");
	//related to orders
	public By veiwOrderLink = By.xpath("//a[@class='action view']//span");
	public  By EBSSKU =By.xpath("//div[@class='order-history-item-sku']//span");
	
	private By navLinksMyAccount = By.xpath("//*[contains(@class,'astm-nav-tabs--filters')]/a");

	// private By profileLink = By.linkText("Profile"); //Remove This
	private By profileLink = By.xpath("//a[text()='Profile']");

	private By contactInfoChildLink = By.linkText("Contact Info");
	private By loginPasswordChildLink = By.linkText("Login/Password");

	private By orderLink = By.linkText("Orders");
	public By orderLink1 = By.xpath("//a[contains(text(),'Orders')]");
	public By specBuilderLink = By.linkText("SpecBuilder");
	private By subscriptionLink = By.linkText("Subscriptions");
	public By compassLink = By.linkText("Compass");
	private By contactInfoSection = By.xpath("//*[@class='col-md-9 order-2 mx-auto']");
	private By loginPasswordSection = By.xpath("//*[@class='col-md-9 mx-auto']");

	private By leftSideAccountDetails = By.xpath("//*[@class='border-top mt-4 pt-4']");
	public By astmButton = By.xpath("//div[contains(@class,'right-navbar')]//button");

	private By currentPwdLabel = By.xpath("//*[@for='current-password']");
	private By currentPassword = By.id("current-password");

	private By newPwdLabel = By.xpath("//*[@for='password']");
	private By newPassword = By.id("password");

	private By confirmPwdLabel = By.xpath("//*[@for='password-confirmation']");
	private By confirmPassword = By.id("password-confirmation");

	private By savePassword = By.xpath("//button[@title='Save Password']");
	private By successMsgChangedPwd = By.xpath("//*[@data-ui-id='message-success']");

	private By compassLandingPageHeader = By
			.xpath("//*[@class='astm-type-heading--h1 account-sub-title' and contains(text(), 'Select an Account')]");
	private By specBuilderLandingPageHeader = By
			.xpath("//*[@class='astm-type-heading--h1 account-sub-title' and contains(text(), 'Select an Account')]");
	private By compassLandingWelcomeBackHeader = By.xpath("//span[text()='Welcome Back, ']");
	public By crossIcon = By.xpath("//button[@class='close']//span");
	public By loginHeader = By.xpath("//h3[text()='Login']");
	public By mailFromAccountPage = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/p[3]");
	public By spinner = By.cssSelector(".spinner-border");
	
	public WebElement getMailFromAccountPage() {
		return getElement(mailFromAccountPage);
	}

	public By cartMembershipType = By.className("product-item-name");
	public By eLearningLinkMyAccount1 = By.xpath("//a[text()='eLearning']");

	public By getcompassDropdown()
	{
		return compassDropdown;
	}

	public By getmyDigitalDocumentsDropdown(){
		return myDigitalDocumentsDropdown;
	}
	public boolean compassLandingPage() {
		boolean presence = false;
		try {
			PublicCommon.waitForSec(10);

			if (getElements(compassLandingPageHeader).size() > 0) {
				presence = true;
			} else {
				presence = getElements(compassLandingWelcomeBackHeader).size() > 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return presence;
	}


	public boolean specBuilderLandingPage() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(specBuilderLandingPageHeader), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean pwdChangedSuccessIsDisplayed() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(successMsgChangedPwd), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String pwdChangedSuccessText() {
		try {
			return getElement(successMsgChangedPwd).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void sendKeys(String key, By locator) {
		try {
			// getElement(locator).clear();
			getElement(locator).sendKeys(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean clickOnSavePassword() {
		try {
			getElement(savePassword).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean enterCurrentPwd(String pwd) {
		try {
			getElement(currentPassword).click();
			sendKeys(pwd, currentPassword);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean enterNewPwd(String pwd) {
		try {
			getElement(newPassword).click();
			sendKeys(pwd, newPassword);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean confirmNewPwd(String pwd) {
		try {
			getElement(confirmPassword).click();
			sendKeys(pwd, confirmPassword);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean changeUserPassword(String current, String newPwd) {
		try {
			enterCurrentPwd(current);
			 PublicCommon.waitForSec(2); //sync time for firefox
			enterNewPwd(newPwd);
			 PublicCommon.waitForSec(2);
			System.out.println("new: " + newPwd);
			confirmNewPwd(newPwd);
			 PublicCommon.waitForSec(2);
			System.out.println("new: " + newPwd);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnSavePassword();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean currentPwdSectionIsDisplayed() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(currentPwdLabel), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean newPwdSectionIsDisplayed() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(currentPwdLabel), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean confirmPwdSectionIsDisplayed() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(currentPwdLabel), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickSpeBuilderLink() {
		try {
			getElement(specBuilderLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickCompassLink() {
		try {
			getElement(compassLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickOrderLink() {
		try {
			getElement(orderLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String leftSideAccountDetails() {
		try {
			return getElement(leftSideAccountDetails).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String contactInfoSection() {
		try {
			return getElement(contactInfoSection).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String loginPasswordSection() {
		try {
			return getElement(loginPasswordSection).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean clickContactInfotNavigationLink() {
		try {
			getElement(contactInfoChildLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickLoginPasswordNavigationLink() {
		try {
			getElement(loginPasswordChildLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String activeLeftNavigationLink() {
		try {
			return getElement(activeNavLinkMyAccount).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean leftProfileLink() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(profileLink));
			getElement(profileLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickActiveLeftNavigationLink() {
		try {
			getElement(activeNavLinkMyAccount).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<WebElement> leftNavigationLink() {
		try {
			return getElements(navLinksMyAccount);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}

	public boolean pageHeaderIsVisible() {
		try {
			ReusableMethods.scrollIntoView(getElement(pageHeaderText), driver);
			boolean header = PublicCommon.isVisibleInViewport(getElement(pageHeaderText), driver)
					&& getElement(pageHeaderText).getText().equals(myAccount);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return header;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Step("Signout of Member Application")
	public boolean clickSignOutButton() {
		try {

			getElement(signOutBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean MyCommitteeclickSignOutButton() {
		try {

			getElement(MyCommitteeSignoutDropdown).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



	public boolean clickSignOutBtn() {
		try {
			getElement(signOutBtnLeftNav).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickMyAccountBtn() {
		try {
			getElement(myAccountBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickElearningBtnOnLeftNavigation() {
		try {
			PublicCommon.JSClick(getElement(eLearningLinkLeftNav), driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean signOut() {
		ReusableMethods.scrollIntoView(getElement(astmButton), driver);
		getElement(astmButton).click();
		clickSignOutButton();
		if (getPageTitle().equals("Customer Login"))
			return true;
		else
			return false;

	}

	public boolean clickSignOutButtonOnLeftNavigation() {
		try {
			PublicCommon.JSClick(getElement(signOutBtnLeftNav), driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Get Account Number")
	public String getUserAccountNumber(){
		String AccountNumber = "";
		try {
			orderPage = getInstance(OrderConfirmPage_Integration.class);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(orderPage.signinDropdown));
			IntegrationCommon.clickonWebElement(driver, orderPage.signinDropdown);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(orderPage.MyAccountTab));
			IntegrationCommon.clickonWebElement(driver, orderPage.MyAccountTab);
			AccountNumber = orderPage.checkAccountNumberOnAccountNumber();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify details on Order confirmation Page", e);
		}
		return AccountNumber;
	}

	@Step("verify Digital Document Format")
	public void verifyDigitalDocumentFormat(){
		try{
			customerLoginPage=getInstance(CustomerLogin_Public.class);
			PublicCommon.waitForSec(5);
			assertTrue(customerLoginPage.navigateToLoginOrRegistrationPage(driver, "MyAccount"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("My Digital Documents link", MyDigitalDocBtnLeftNav, "Failed to click");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.getTitle().equals("My Digital Documents");
			PublicAdminCommons.scrollToElement(driver,documentTitleFormat);
			getElement(documentTitleFormat).getText().contains(".pdf");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Digital Document Format", e);
		}
	}

	@Step("Click on {elementName}")
	public void clickONMethod(String elementName, By locator, String assertionMessage) {
		try {
			ReusableMethods.scrollIntoView(driver.findElement(locator), driver);
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}


}
