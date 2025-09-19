package pages.ui;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.IntegrationCommon;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import javassist.runtime.Desc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.astm.commonFunctions.PublicCommon;
import org.testng.Assert;

import static com.astm.commonFunctions.PublicAdminCommons.switchToTabByIndex;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class YopMail extends BasePage {
	MembershipBecomeMemberPage newMembershipPage;
	SpecbuilderIntegrationPage specBuilderintegrationPage;
	//public WebDriver driver;
	private WebDriverWait wait;

	private By myDigitalDocumentsLink=By.xpath("//a[text()='My Digital Documents.']");
	private By emailSubjectRight=By.xpath("//div[@class='ellipsis nw b f18']");
	private By enterEmailTextField = By.cssSelector("input#login");
	private By checkInboxButton = By.cssSelector("#refreshbut > button > i");

	private By checkInboxButton1 = By.cssSelector("input.sbut");
	private By checkInboxButtonnew = By.xpath("//button[@class='md']");
	private By emailSubjectLeft = By.cssSelector("span.lms");
	public By emailDisplayNames = By.xpath("//div[@class='mctn']");
	public By activateuserProfileLink = By.xpath("//*[text()='Activate Member Account']");
	public By OrderIDHeader = By.xpath("//h1");
	public By ActiveUserProfileBtn = By.xpath("//a[text()='Activate User Profile']");
	private By emailContent=By.xpath("//div[@id='mail']/descendant::table/tbody/tr[5]/td");
	private By OrderNumber=By.xpath("//h1/span");
	public By showPicturesLink=By.xpath("//span[contains(text(),'Show pictures')]/parent::button");
	public By astmLogo=By.xpath("//img[contains(@src,'email_log.png')]");
	public By activationMail = By.xpath("//*[@class='lmf' and contains(.,'do-not-reply')]");
	private By findASTMAdminemial = By.xpath("//div[@class='lmfd']/span[text()='ASTM Admin']");
	public By findASTMsupportEmail = By.xpath("(//div[@class='lmfd']/span[text()='ASTM Support'])[1]");
	public By AAEmailCommitteCheck = By.xpath("//tr/td[contains(text(),'To the Administrative Assistant')]");
	public By DocLinkInEmail = By.cssSelector("#mail > div > table > tbody > tr:nth-child(8) > td > a");
	public By SuccessMsg = By.xpath("(//h2)[1]");
	private By ASTMOrderemail = By.xpath("//div[@class='lmfd']/span[text()='ASTM International']");
	public By doNotReplyEmail = By.xpath("//div[@class='lmfd']/span[text()='do-not-reply@stage.astm.org']");
	public String mailHeaderFrame = "ifinbox";
	public String mailBodyFrame = "ifmail";
	public String frameId = "ifinbox";
	public By emailSearchBoxOnHomePage = By.xpath("//div[@class='tooltip click']/input");
	private By enter = By.xpath("//i[@class='material-icons-outlined f36']");
	public By ASTMInternational = By.xpath("//span[text()='ASTM International']");
	public By Okta = By.xpath("(//span[text()='Okta']/..)[1]");
	public By ASTMInternationalOrderNumber = By.xpath("//h1/span");
	private By shippingAndHandling = By.xpath("//th[contains(text(),'Shipping & Handling')]//following-sibling::td//span");
	public By activateYourAccountLink= By.xpath("//a[text()='Activate Your Account']");
	public By activateMemberLink = By.xpath("//span[text()='Activate Member Account']");
	public By activateUserProfile = By.xpath("//a[text()='Activate User Profile']");

	public By collaborationreaLink = By.xpath("//a[text()='Collaboration Area']");
	public By password = By.xpath("//input[@id='password']");
	public By confirmPassword = By.xpath("//input[@id='password-confirmation']");
	public By createButton = By.xpath("//button[@title='Create Password']");
	public By fromEmail=By.xpath("//span[text()='ASTM International <comserv@stage.astm.org>']");
	public By fName = By.xpath("//input[@id='firstName']");
	public By lName = By.xpath("//input[@id='lastName']");
	public By cnfPassword = By.xpath("//input[@id='confirmPassword']");
	public By activeAccount = By.xpath("//button[text()='Activate Account']");
	public By signOutDropDown = By.xpath("//button[@id='dropdown-menu-align-right']");
	public By signOUtButton  = By.xpath("//button[text()='Sign Out']");
	public By welcomeMailBody = By.xpath("//div[contains(text(),'ASTM International Collaboration Area Invitation')]");
	public By welcomeToASTMInternational = By.xpath("//div[contains(text(),'Welcome to ASTM')]");
	public By welcomeToASTM = By.xpath("//div[contains(text(),'Welcome to ASTM')]");
	public By welcomeTo = By.xpath("(//div[contains(text(),'Welcome to')])[1]");
	public By documentSharedWithYou = By.xpath("(//div[@id='mail']//a)[1]");
	public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	LoginPage_SpecBuilder LoginPageSpec;
	public By findASTMAdminAndClassification = By.xpath("//div[contains(text(),'Classification')]/../div[@class='lmfd']");
	public By mailDate = By.xpath("//span[@class='ellipsis']");
	public By classificationAndVoteHdr = By.xpath("//*[text()='Classification and official vote status updated']");
	public By classificationAndVoteChangeMsg = By.xpath("//td[contains(text(),'As a result')]");
	public By doNotReplyMsg = By.xpath("//button//div[text()='Welcome to ASTM']");
	public By doNotreplyMsg_Body = By.xpath("//body[contains(@class,'bodymail')]//div[text()='Welcome to ASTM']");
	public By ASTMadminMsg = By.xpath("//p[contains(text(),'Thank you for your order! Below is confirmation of your membership order.')]");
	public By mailHdr= By.xpath("//div[contains(@class,'ellipsi')]");
	public By mailFrom= By.xpath("//span[@class='ellipsis b']");

	public By CollabId=By.xpath("//div[@id='mail']/descendant::p[3]");
	public By mailFromDisplay5157 = By.xpath("//span[text()='Display-5157']");
	public By previousMailFromDisplay5157 = By.xpath("(//span[text()='Display-5157'])[2]");

	public YopMail(WebDriver driver) {
		super(driver);
		newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
		this.wait = new WebDriverWait(driver, 20);
	}
	public WebElement getemailContent()
	{
		return getElement(emailContent);
	}
	/*public WebElement getEmailBallotNameEditedLink(String value){
		return getElement(By.xpath("//a[text()='"+value+"']"));
	}*/
	public WebElement getEmailBallotNameEditedLink(String value){
		return getElement(By.xpath("//a[text()='"+value+"']"));
	}

	public boolean openInbox(String email) {
		try {
			//PublicCommon.openNewTabAndSwitch(driver);
			PublicCommon.openUrl(driver, "http://www.yopmail.com/en/");
			PublicCommon.waitForSec(2);
			waitForVisible(enterEmailTextField);
			PublicCommon.waitForSec(10);
			driver.findElement(enterEmailTextField).sendKeys(email);
			driver.findElement(checkInboxButton).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean openInbox(String email, WebDriver driver) {
		try {
			PublicCommon.openNewTabAndSwitch(driver);
			PublicCommon.openUrl(driver, "http://www.yopmail.com/en/");
			waitForVisible(enterEmailTextField);
			driver.findElement(enterEmailTextField).sendKeys(email);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.findElement(checkInboxButtonnew).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getSubjectLineOfMailByIndex(int index) {
		String display=null;
		try {
			PublicCommon.switchToIframe(driver, frameId);
			//List<String> getSubjectLines = PublicCommon.getTextOfWebElements(driver, emailSubjectLeft); //emailDisplayNames
			List<String> getSubjectLines = PublicCommon.getTextOfWebElements(driver, emailDisplayNames);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			display = getSubjectLines.get(index);
			System.out.println(display);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return display;
    }

	@Step("Validate ASTM Admin email")
	public void findAccountActivationEmail() {
		try {
			String ASTMAdmin = ASTMadminMail();
			boolean isASTMAdminmailfound = ASTMAdmin.equals(ASTMOrderemail);

			if (!isASTMAdminmailfound) {
				getElement(findASTMAdminemial).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to find ASTM Admin email ", e);
		}
	}
	public By expectedText = By.xpath("//td[contains(text(),'meeting material')]");
	@Step("Verify the email received to the user post meeting materials submission.")
	public void verifyYopMail() {
		try {

			driver.switchTo().frame(mailBodyFrame);
			String text = getElement(expectedText).getText();
			Assert.assertTrue(text.contains("You requested meeting materials for October 2023 Committee Week - UAT May, however there are no meeting materials to download for the selected committees. If you feel this is an error, please contact your Administrative Assistant or Staff Manager."));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify the email received to the user post meeting materials submission.", e);
		}
	}
	@Step("Verify PDF Content In Yopmail.")
	public void VerifyPDFContentInYopmail(){
		try {

			driver.switchTo().frame(mailBodyFrame);
			String text = getElement(expectedText).getText();
			Assert.assertTrue(text.contains("You requested meeting materials for October 2023 Committee Week - UAT May, however there are no meeting materials to download for the selected committees. If you feel this is an error, please contact your Administrative Assistant or Staff Manager."));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify the email received to the user post meeting materials submission.", e);
		}
	}


	public String ASTMintMail() {
		try {
			ReusableMethods.scrollIntoView(getElement(ASTMOrderemail), driver);
			return getElement(ASTMOrderemail).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String ASTMadminMail() {
		try {
			ReusableMethods.scrollIntoView(getElement(findASTMAdminemial), driver);
			return getElement(findASTMAdminemial).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String ASTMsupportMail() {
		try {
			ReusableMethods.scrollIntoView(getElement(findASTMsupportEmail), driver);
			return getElement(findASTMsupportEmail).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Step("Validate ASTM International email")
	public void findOrderEmail() {
		try {
			 getElement(ASTMOrderemail).click();
			}
		 catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to find ASTM Admin email ", e);
		}
	}

	@Step("Validate ASTM International email")
	public void findActivationEmail() {
		try {
			getElement(doNotReplyEmail).click();
		}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to find ASTM Admin email ", e);
		}
	}



	private void waitForVisible(By locator) {
		wait.pollingEvery(Duration.ofMillis(500)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public By getOrderNumber() {
		return OrderNumber;
	}

	@Step("Validate Order Confirmation Email")
	public void SearchEmailConfirmationAfterPurchase(String emailID,String OrderNumber){
		try{
			driver.get("https://www.yopmail.com/");
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().frame("ifinbox");
			driver.findElement(ASTMInternational).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			getElement(ASTMInternationalOrderNumber).getText().contains(OrderNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to search Order Confirmation email ", e);
		}

	}

	@Step("Fetch the Shipping Charge From Mail")
	public String getShippingCharge() {
		String value = null;
		try {
			driver.switchTo().frame(mailBodyFrame);
			value = getElement(shippingAndHandling).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Fetch the Shipping Charge ", e);
		}
		return value;
	}

	public void findASTMsupport() {
		try {
			String ASTMsupport = ASTMsupportMail();
			boolean isASTMAdminmailfound = ASTMsupport.equals(ASTMOrderemail);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (!isASTMAdminmailfound) {
				getElement(findASTMsupportEmail).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to find ASTM Admin email ", e);
		}
	}

	@Step("Validate Document Uploaded in email")
	public void ValidateDocumentUploaded(){
		try{
			getElement(DocLinkInEmail).click();
			Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver, 2),"Unable to switch to other tab");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(SuccessMsg).getText().equals("Your download will begin in a moment.");
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Validate Document Uploaded", e);
		}
	}

	@Step("Activate Member Account")
	public void ActivateMemberAccount(String Password,int tab) {
		try {
			PublicCommon.switchToIframe(driver, frameId);
			getElement(welcomeToASTMInternational).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(mailBodyFrame);
			PublicCommon.waitForSec(40);
			if(WaitStatementUtils.waitForElementToBeClickable(driver, getElement(activateMemberLink)))
			{
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(activateMemberLink));
				getElement(activateMemberLink).click();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver, getElement(activateUserProfile)))
			{
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(activateUserProfile));
				getElement(activateUserProfile).click();
			}

			PublicCommon.waitForSec(30);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tab));
			PublicCommon.waitForSec(30);
			IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			newMembershipPage.handleOneTrustCookie();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToElement(driver, password);
			getElement(password).click();
			//PublicAdminCommons.enterTextInTextField(driver, password, Password, clear);
			getElement(password).sendKeys(Password);
			//IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
			PublicAdminCommons.scrollToElement(driver, confirmPassword);
			getElement(confirmPassword).sendKeys(Password);
			PublicAdminCommons.scrollToElement(driver, createButton);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(createButton).click();
			PublicCommon.waitForSec(50);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Activate Member Account", e);
		}
	}

	@Step("Activate Member Account")
	public void ActivateUserProfile(String Password,int tab) {
		try {
			PublicCommon.switchToIframe(driver, frameId);
			getElement(welcomeToASTM).click();
			PublicCommon.waitForSec(5);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(mailBodyFrame);
			if(getElements(activateMemberLink).size()!=0){
				getElement(activateMemberLink).click();
			}
			if(getElements(activateUserProfile).size()!=0){
				getElement(activateUserProfile).click();
			}
			switchToTabByIndex(driver,tab);
			PublicAdminCommons.waitForSec(10);
			getElement(password).sendKeys(Password);
			if(getElements(confirmPassword).size()>0)
				getElement(confirmPassword).sendKeys(Password);
			if(getElements(cnfPassword).size()>0)
				getElement(cnfPassword).sendKeys(Password);
			if(getElements(createButton).size()>0)
				getElement(createButton).click();
			if(getElements(activeAccount).size()>0)
				getElement(activeAccount).click();
			PublicCommon.waitForSec(10);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Activate User Profile", e);
		}
	}
	@Step("Verify the fields present on Activate Account page ")
	public void AccountActivation(String id,String Password,int tab) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.switchToIframe(driver, frameId);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(welcomeMailBody),10);
			getElement(welcomeToASTMInternational).click();
			PublicCommon.waitForSec(5);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(mailBodyFrame);
			getElement(CollabId).getText().contains(id);

			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.switchToIframe(driver, frameId);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(welcomeMailBody),10);
			getElement(welcomeToASTMInternational).click();
			PublicCommon.waitForSec(5);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(mailBodyFrame);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(activateYourAccountLink),10);
			getElement(activateYourAccountLink).click();
			switchToTabByIndex(driver,tab);
			verifyAccountActivationForm(Password);
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Activate your Account", e);
		}
	}
	public By errorMessageForDeleteCollaboration = By.xpath("//div[contains(text(),'has been deleted.')]");

	public By CollaborationOpen = By.xpath("//a[text()='ASTM International Collaboration Area SpecBuilder']");
	public By spinner = By.xpath("//div[@class='astm-spinner spinner-border']");

	@Step("Verify User should not be able to access deleted collaboration area from the Link  received")
	public void verifyDeletedCollaborationLink(int tab,String id) {
		try {
			specBuilderintegrationPage = getInstance(SpecbuilderIntegrationPage.class);

			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.switchToIframe(driver, frameId);
			getElement(welcomeMailBody).click();
			PublicCommon.waitForSec(5);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(mailBodyFrame);
			getElement(CollaborationOpen).click();
			switchToTabByIndex(driver,tab);
			driver.navigate().refresh();
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,specBuilderintegrationPage.SPBLoadingIcon);
			PublicCommon.waitForSec(1);
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,specBuilderintegrationPage.SPBLoadingIcon);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.navigate().refresh();
			String errorMsgText=getElement(errorMessageForDeleteCollaboration).getText();
			Allure.addAttachment("Collaboration Area Delete Message",errorMsgText);
			Assert.assertTrue(errorMsgText.contains(id));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Activate your Account", e);
		}
	}
	public By useName_Spec = By.xpath("//input[@id='userName']");
	public By password_Spec = By.xpath("//input[@id='encPass']");
	public By signIn_Spec = By.xpath("//button[text()='Sign In']");
	public By Select_ASTM_International_CollaborationArea = By.xpath("//p[@class='accounts-content']/span[text()='ASTM International Collaboration Area']/../button");
	public By newCollaborationArea = By.xpath("//button[text()='Create New Collaboration Area']");
	@Step("Verify the Activation account navigate to Spec builder and Able to login with new credentials ")
	public void verifySpecBuilderLogin_withNewCredentials(String Password,String email) {
		try {
			getElement(useName_Spec).sendKeys(email);
			getElement(password_Spec).sendKeys(Password);
			getElement(signIn_Spec).click();
           PublicCommon.waitForSec(10);
			getElement(Select_ASTM_International_CollaborationArea).click();
		   Assert.assertTrue(getElement(newCollaborationArea).isDisplayed(),"Failed to Navigate Spec builder for Activated Account ");

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Verify the Activation account navigate to Spec builder and Able to login with new credentials", e);
		}
	}

	@Step("Activation Account form filling and Verification")
	public void verifyAccountActivationForm(String Password){
		try{
		Assert.assertTrue(getElement(fName).isDisplayed(),"First name field not displayed with mandatory mark");
		ScreenshotUtil.takeScreenshotForAllure(driver);
		getElement(fName).sendKeys("F_Name");
		Assert.assertTrue(getElement(lName).isDisplayed(),"Last name field not displayed with mandatory mark");
		getElement(lName).sendKeys("L_Name");
		Assert.assertTrue(getElement(password).isDisplayed(),"Password field not displayed with mandatory mark");
		getElement(password).sendKeys(Password);
		Assert.assertTrue(getElement(cnfPassword).isDisplayed(),"cnfPassword field not displayed with mandatory mark");
		getElement(cnfPassword).sendKeys(Password);
		newMembershipPage.handleOneTrustCookie();
		getElement(activeAccount).click();
		PublicCommon.waitForSec(10);
		ScreenshotUtil.takeScreenshotForAllure(driver);
		driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Activation Account form Failed Verify", e);
		}
	}

    public By manage = By.xpath("//button[text()='Manage']");


	@Step("Verify Email Validations for Collaboration link")
	public void collaborateNonMemberAccount() {
		try {
			driver.switchTo().frame(mailBodyFrame);
			getElement(collaborationreaLink).click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to AVerify Email Validations for Collaboration link", e);
		}
	}

	@Step("Verify Collaboration link Should navigates to SpecBuilder page after Active activation")
	public void clickOnCollaborationAreaAndNavigatesToSpecBuilder() {
		try {
			collaborateNonMemberAccount();
			PublicCommon.waitForSec(20);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(2));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(manage));
			Assert.assertTrue(getElement(manage).isDisplayed(),"SpecBuilder page opened");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Verify Collaboration link Should navigates to SpecBuilder page after Active activation", e);
		}
	}



	@Step("Click on Activation link")
	public void clickONActivationLink() {
		try {
			driver.switchTo().frame(mailBodyFrame);
			getElement(activateYourAccountLink).click();
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Activate Member Account", e);
		}
	}

	public void signOutFromMemApp(){
		getElement(signOutDropDown).click();
		getElement(signOUtButton).click();
	}
	@Step("Check mail on Yopmail")
	public void checkLatestMail(String emailID) {
		try {
			driver.get("https://www.yopmail.com/");
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(30);
			driver.switchTo().frame("ifinbox");
			driver.findElement(Okta).click();
			driver.switchTo().defaultContent();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}


	@Step("Verify OrderConfirmation, Welcome, ActivationEmail")
	public void ValidateOrderConfirmation_Welcome_ActivationEmails(String emailID) {
		try {
			assertTrue(openInbox(emailID));
			driver.switchTo().frame("ifinbox");
			findAccountActivationEmail();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			getElement(activateuserProfileLink).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifinbox");
			findOrderEmail();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			getElement(OrderIDHeader).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifinbox");
			findActivationEmail();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			getElement(ActiveUserProfileBtn).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify OrderConfirmation, Welcome, ActivationEmails", e);
		}
	}

	@Step("Verify Order Number in ASTM Admin Mail")
	public void VerifyASTMAdminMail(){
		if(getElements(ASTMadminMsg).size() > 0 ){
			Assert.assertTrue(getElement(ASTMadminMsg).getText().contains("Thank you for your order!"));
		}
	}

	@Step("Validate Order Number in Order Confimation Mail recieved to Yopmail")
	public void ValidateOrderNumberinYopmail(String emailID,String orderNumber) {
		try {
			PublicCommon.waitForSec(15);
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			Thread.sleep(2000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().frame("ifmail");
			VerifyASTMAdminMail();
			VerifyASTMInternationalMail(orderNumber);
			driver.switchTo().defaultContent();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Validate Email received ", e);
		}
	}

	@Step("Verify Order Number in ASTM International Mail")
	public void 	VerifyASTMInternationalMail(String OrderNumber){
		getElement(ASTMInternationalOrderNumber).getText().contains(OrderNumber);
	}

	@Step("Activate your ASTM Membership Access by clicking on Activate Member account")
	public void ActivateMemberAccount(){
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifinbox");
			findAccountActivationEmail();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			getElement(activateuserProfileLink).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(activateuserProfileLink).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Activate User profile", e);
		}
	}
	@Step("Check Order Confirmation mail on Yopmail for Order : '{magentoOrderNumber}'")
	public void clickOnMyDigitalDocumentLinkInYopMailForOrderPlaced(String emailID,String magentoOrderNumber) {
		try {
			driver.get("https://www.yopmail.com/");
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().frame("ifinbox");
			findOrderEmail();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (getElement(OrderIDHeader).isDisplayed() && getElement(OrderIDHeader).getText().contains(magentoOrderNumber))
				getElement(myDigitalDocumentsLink).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Step("Validate 'DMS - PDF conversion failed' mail content in Yopmail")
	public void validateDMSToPDFConversionFailMailContentInYopMail(String userRole,String emailID,List<String> docCategory,String fileName,String uploadedBy) {
		try {
			PublicAdminCommons.openNewTabAndSwitch(driver);
			driver.get("https://www.yopmail.com/");
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String mailToSelectSubjectInLeft="";
			String astmInternationalMailHeaderTxtInLeft="";
			driver.switchTo().frame("ifinbox");
			if(getElements(ASTMInternational).size()>0) {
				mailToSelectSubjectInLeft=getElement(emailSubjectLeft).getText();
				astmInternationalMailHeaderTxtInLeft=getElement(ASTMInternational).getText();
				getElement(ASTMInternational).click();
			}
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			Assert.assertTrue(getElement(emailSubjectRight).getText().equals(mailToSelectSubjectInLeft), "Mail Subject doesn't match in YopMail");
			Assert.assertTrue(getElement(fromEmail).isDisplayed(),"From subject mail sender doesn't match");
			String emailContent=getemailContent().getText();
			getElement(showPicturesLink).click();
			PublicCommon.waitForSec(2);
			Assert.assertTrue(getElements(astmLogo).size()>0,"Failed to display ASTM Logo in Yopmail");

			if(userRole.equals("Admin")){

			}else if(userRole.equals("TCO Admin")) {

				//Assert.assertTrue(getElement());

			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verifying the: {successText}")
	public void validateText(String successText, String actualText, String expectedText, String assertionMessage) {
		try {
			String validation = successText;
			boolean result = IntegrationCommon.verifyElementTextOnPage(validation, actualText, expectedText);
			assertTrue(result, assertionMessage);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Text", ex);
		}
	}

	@Step("Validate {0}")
	public void verifyText(String textToValidate, String actualText, String expectedText) {
		try {
			assertTrue(actualText.contains(expectedText), textToValidate + " didn't match.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement getMailContent(int i)
	{
		return driver.findElement(By.xpath("//div[@id='mail']/descendant::p["+i+"]"));
	}

	@Step("Validate Email Confirmation for Email {email},and Group Name {groupName}, with Description {Description}")
	public void validateYOPMailMessageBody_5157(String latest,String email, String DisplayName,String groupName,String Description,String name){
		try{
			PublicCommon.openNewTabAndSwitch(driver);
			PublicCommon.openUrl(driver, "http://www.yopmail.com/en/");
			PublicCommon.waitForSec(2);
			waitForVisible(enterEmailTextField);
			PublicCommon.waitForSec(10);
			driver.findElement(enterEmailTextField).clear();
			driver.findElement(enterEmailTextField).sendKeys(email);
			driver.findElement(checkInboxButton).click();
			PublicCommon.waitForSec(30);
			ScreenshotUtil.takeScreenshotForAllure(driver);


				if(latest.equals("true")) {
					driver.switchTo().frame("ifinbox");
					driver.findElement(mailFromDisplay5157).click();
					Thread.sleep(2000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");

					if (Description.equals("test")) {
						verifyText("Mail From should contain Display Name", getElement(mailFrom).getText(), DisplayName);
						validateText("Mail Content Group Name", getMailContent(2).getText().split(":")[1].trim(), groupName, "Mail Content Group Name should not contains any thing else than Group Name");
						//verifyText("Mail Content Admin User Name should Match with Admin User Name", getMailContent(3).getText(), name);
						validateText("Mail Content Description", getMailContent(6).getText().split(":")[1].trim(), Description, "Mail Content Description should Match with Default Description");
						ScreenshotUtil.takeScreenshotForAllure(driver);
					} else {
						verifyText("Mail From should contain Display Name", getElement(mailFrom).getText(), DisplayName);
						validateText("Mail Content Group Name", getMailContent(2).getText().split(":")[1].trim(), groupName, "Mail Content Group Name should not contains any thing else than Group Name");
						verifyText("Mail Content Admin User Name should Match with Admin User Name", getMailContent(3).getText(), name);
						validateText("Mail Content Description", getMailContent(4).getText(), Description, "Mail Content Description should Match with Default Description");
						ScreenshotUtil.takeScreenshotForAllure(driver);
					}
				}
				else {
					driver.switchTo().frame("ifinbox");
					driver.findElement(previousMailFromDisplay5157).click();
					Thread.sleep(2000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");

					verifyText("Mail From should contain Display Name", getElement(mailFrom).getText(), DisplayName);
					validateText("Mail Content Group Name", getMailContent(2).getText().split(":")[1].trim(), groupName, "Mail Content Group Name should not contains any thing else than Group Name");
					verifyText("Mail Content Admin User Name should Match with Admin User Name", getMailContent(3).getText(), name);
					validateText("Mail Content Description", getMailContent(4).getText(), Description, "Mail Content Description should Match with Default Description");
					ScreenshotUtil.takeScreenshotForAllure(driver);
				}



			PublicCommon.closeNewTabAndSwitchToOriginalTab(driver);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to search Order Confirmation email ", e);
		}

	}

}
