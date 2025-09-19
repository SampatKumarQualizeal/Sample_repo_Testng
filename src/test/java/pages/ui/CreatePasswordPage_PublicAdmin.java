package pages.ui;

import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;

import base.utils.ScreenshotUtil;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static pages.ui.MAEIntegrationPage.switchToWindowByTitle;

public class CreatePasswordPage_PublicAdmin extends BasePage {


	public CreatePasswordPage_PublicAdmin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By emailSearchBoxOnHomePage = By.xpath("//div[@class='tooltip click']/input");
	private By activateMemberAccount = By.xpath("//*[contains(text(),'Activate')]");
	public By activateuserProfileLink = By.xpath("//*[text()='Activate Member Account']");
	private By AstmAdmin = By.xpath("//span[text()='ASTM Admin']");
	public By doNotReplyMsg = By.xpath("//button//div[text()='Welcome to ASTM']");
	public By todayLabel = By.xpath("//div[@class='mday']");
	public By doNotreplyMsg_Body = By.xpath("//body[contains(@class,'bodymail')]//div[text()='Welcome to ASTM International']");
	public By ASTMInternational = By.xpath("//span[text()='ASTM International']/parent::div");
	public By ASTMAdminMail = By.xpath("//span[text()='ASTM Admin']/parent::div");
	public By ASTMManualOrderWelcomeMail = By.xpath("//span[text()='do-not-reply@stage.astm.org']/parent::div[@class='lmfd']");
	public By ASTMadminMsg = By.xpath("//td[contains(text(),'Thank you for joining ASTM')]");
	public By stuResourcesLabel = By.xpath("//b[text()='STUDENT MEMBER RESOURCES:']");
	public By ASTMInternationalOrderNumber = By.xpath("//h1/span");
	public By ProductLineItems=By.xpath("//table[2]/tbody/tr");
	// private By activateMemberAccount = By.xpath("//tr[5]/td/a");
	private By password = By.xpath("//fieldset/div[@class='field password required']/div/input");
	private final By acceptAllCookieButton = By.id("onetrust-accept-btn-handler");
	private By passwordConfirmation = By.xpath("//div[@class='field confirmation required']/div/input");
	private By CreatePasswordButton = By.xpath("//button/span[text()='Create Password']");
	private By heading = By.xpath("//h1[text()='Membership']");
	private By membershipHeading = By.xpath("//h2[text()='Membership']");
	private By enter = By.xpath("//i[@class='material-icons-outlined f36']");
	private By orderConfirmationMessage = By.xpath("//div[text()='Your Astm.org order confirmation']");
	private By findASTMAdminemial = By.xpath("//div[@class='lmfd']/span[text()='ASTM Admin']");
	private By ASTMOrderemail = By.xpath("//div[@class='lmfd']/span[text()='ASTM International']");
	public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public By MyASTMLink=By.xpath("//a[contains(text(),'MyASTM')]");




	public void checkMailInYopmailandCreatePassword(String emailID) {
		try {
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.findElement(enter).click();
			Thread.sleep(5000);
			findAccountActivationEmail("ASTM Admin");
			driver.switchTo().frame("ifinbox");
			WaitStatementUtils.waitForElementStaleness(driver, getElement(AstmAdmin));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AstmAdmin));
			driver.findElement(AstmAdmin).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			driver.findElement(activateMemberAccount).click();
			Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver, 2), "Unable to switch to other tab");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			handleOneTrustCookie();
			driver.findElement(password).sendKeys("Testing@123");
			handleOneTrustCookie();
			driver.findElement(passwordConfirmation).sendKeys("Testing@123");
			handleOneTrustCookie();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.findElement(CreatePasswordButton).click();
			Thread.sleep(5000);
			handleOneTrustCookie();
			assertEquals(driver.findElement(membershipHeading).getText(), "Membership");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to click on Activation email ", e);
		}
	}


	private boolean findAccountActivationEmail(String Sender) {
		Boolean value = false;
		try {
			driver.switchTo().frame("ifinbox");
			List<WebElement> Links = getElements(By.xpath("//body[@class='bodyinbox yscrollbar']/div/div/button/div"));
			for (WebElement link : Links) {
				if (link.getText().equalsIgnoreCase(Sender)) {
					break;
				}
				driver.switchTo().defaultContent();
			}
			value = true;
		} catch (Exception e) {
			e.printStackTrace();
			value = false;
		}
		return value;
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

	@Step("Verify Order Number in ASTM Admin Mail")
	public void VerifyASTMAdminMail() {
		Assert.assertTrue(getElement(ASTMadminMsg).getText().contains("Thank you for joining ASTM"));
		Assert.assertTrue(PublicAdminCommons.isElementDisplayed(getElement(stuResourcesLabel)));
	}


	@Step("Verify Order Number in ASTM Admin Mail")
	public void VerifyASTMAdminMailforDiffMemberships(String Membership) {
		if (Membership.equals("INFORMATIONAL")) {
			Assert.assertTrue(getElement(ASTMadminMsg).getText().contains("Informational Member"));
		} else if (Membership.equals("STUDENT")) {
			Assert.assertTrue(getElement(ASTMadminMsg).getText().contains("Thank you for joining ASTM"));
			Assert.assertTrue(PublicAdminCommons.isElementDisplayed(getElement(stuResourcesLabel)));
		} else if (Membership.equals("PARTICIPATIONAL")) {
			Assert.assertTrue(getElement(ASTMadminMsg).getText().contains("Thank you for joining ASTM International as Participating Member."));
		}  else if (Membership.equals("ORGANIZATIONAL")) {
			Assert.assertTrue(getElement(ASTMadminMsg).getText().contains("Thank you for joining ASTM International as Organizational Member."));
		}
		else {
			Assert.assertTrue(getElement(doNotreplyMsg_Body).getText().contains("Welcome to ASTM"));
		}
	}


	@Step("Verify Order Number in ASTM International Mail")
	public void VerifyASTMInternationalMail(String OrderNumber){
		getElement(ASTMInternationalOrderNumber).getText().contains(OrderNumber);
	}

	@Step("Verify Product Line Items in ASTM International Mail")
	public void VerifyProductLineItemsASTMInternationalMail(String Count){
		getElement(ProductLineItems).getSize().equals(Count);
	}
	
	
	public void checkMailInYopmail(String emailID) {
		try {
			PublicCommon.waitForSec(15);
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.findElement(enter).click();
			Thread.sleep(2000);
			driver.switchTo().frame("ifinbox");
			driver.findElement(AstmAdmin).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			VerifyASTMAdminMail();
			driver.findElement(AstmAdmin).click();
			driver.findElement(activateMemberAccount).click();

	} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to signout with account ", e);
		}
	}

	@Step("Validate Email in Yopmail")
	public void ValidateEmail(String emailID,String orderNumber,String membership) {
		try {
			PublicCommon.waitForSec(60);
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			Thread.sleep(2000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().frame("ifinbox");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(todayLabel),30);
			getElement(ASTMAdminMail).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			VerifyASTMAdminMailforDiffMemberships(membership);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifinbox");
			driver.findElement(ASTMInternational).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			VerifyASTMInternationalMail(orderNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Validate Email received ", e);
		}
	}

	@Step("Validate Email in Yopmail")
	public void ValidateEmaiForMembershipManualOrderl(String emailID,String orderNumber,String membership) {
		try {
			PublicCommon.waitForSec(20);
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).clear();
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			Thread.sleep(2000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifinbox");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(todayLabel),30);
			getElement(ASTMAdminMail).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			VerifyASTMAdminMailforDiffMemberships(membership);
			driver.switchTo().defaultContent();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			driver.switchTo().frame("ifinbox");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(todayLabel),30);
			driver.findElement(ASTMInternational).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			VerifyASTMInternationalMail(orderNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Validate Email received ", e);
		}
	}

	@Step("Validate Email in Yopmail")
	public void activateUserProfile(String emailID,String pwd) {
		try {
			PublicCommon.waitForSec(20);
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			Thread.sleep(2000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().frame("ifinbox");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(todayLabel),30);
			getElement(ASTMManualOrderWelcomeMail).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			getElement(activateMemberAccount).isDisplayed();
			getElement(activateMemberAccount).click();
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(password),15);
			Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver, 2), "Unable to switch to other tab");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			handleOneTrustCookie();
			driver.findElement(password).sendKeys(pwd);
			driver.findElement(passwordConfirmation).sendKeys(pwd);
			driver.findElement(CreatePasswordButton).click();
			PublicCommon.waitForSec(5);
			driver.close();
			Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver,1), "Unable to switch to other tab");
			driver.switchTo().defaultContent();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
			driver.close();
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Validate Email received ", e);
		}
	}

	@Step("Search Email ID")
	public void SearchEmailId(String emailID,String orderNumber){
		try{
			PublicCommon.waitForSec(15);
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).clear();
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().frame("ifinbox");
			driver.findElement(ASTMInternational).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			VerifyASTMInternationalMail(orderNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to search email id ", e);
		}

	}

	@Step("Search Email ID")
	public void SearchEmailIdwithProductLineItems(String emailID,String orderNumber){
		try{
			PublicCommon.waitForSec(15);
			driver.get("https://www.yopmail.com/");
			Thread.sleep(2000);
			driver.findElement(emailSearchBoxOnHomePage).clear();
			driver.findElement(emailSearchBoxOnHomePage).sendKeys(emailID);
			driver.findElement(enter).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.switchTo().frame("ifinbox");
			driver.findElement(ASTMInternational).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			VerifyASTMInternationalMail(orderNumber);
			VerifyProductLineItemsASTMInternationalMail("2");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to search email id ", e);
		}

	}


	public void handleOneTrustCookie() {
		try {
			IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Create password after clicking on Activate Member account in email")
	public void CreatePasswordAfterActivation(){
		try{
			switchToWindowByTitle(driver,"Create New Customer Account");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			handleOneTrustCookie();
			driver.findElement(password).sendKeys("Testing@123");
			handleOneTrustCookie();
			driver.findElement(passwordConfirmation).sendKeys("Testing@123");
			handleOneTrustCookie();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.findElement(CreatePasswordButton).click();
			Thread.sleep(5000);
			handleOneTrustCookie();
			assertEquals(driver.findElement(membershipHeading).getText(),"Membership");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Create Password", e);
		}
	}

}
