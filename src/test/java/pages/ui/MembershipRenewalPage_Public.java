package pages.ui;

import java.util.List;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MembershipRenewalPage_Public extends BasePage {

	public MembershipRenewalPage_Public(WebDriver driver) {
		super(driver);
	}

	public By RenewMembershipheader = By.xpath("//a[text()='Renew Membership']");
	public By ReinstateMembership = By.xpath("//button[text()='Reinstate Membership']");

	public By chooseVolumeButton = By.xpath("//*[text()='Choose Volume']");
	public By ImpChangesMsg = By.xpath("//div[@class='modal-header']");
	public By ImpChngesOkBtn = By.xpath("//div[@class='modal-header']/../div/div/button");
	public By product = By.xpath("//*[text()='Cement; Lime; Gypsum']");
	public By allVolumesBtn = By.xpath("//span[text()='All Volumes']");
	public By selectVolume = By.xpath("(//ul[@class='list-group astm-list-group']//li//p)[1]");
	public By doneButton = By.xpath("//*[text()='Done']");
	public By SubmitBtn = By.xpath("//*[text()='Submit']");
	public By ConfirmationPopuptext = By.xpath("//h5[text()='Confirmation']");
	public By ErrorMsgQuoteDoesNotExist = By.xpath("//div[@class='page messages']/div/div/div/div[text()='The quote does not exist for that unique id.']");
	public By AddressValidationHeader = By.xpath("//header[@class='modal-header']/h1[contains(text(),'Address Validation')]");
	public By AddressValContinueBtn = By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']/span[text()='Continue']");
	public By ContinueBtn = By.xpath("//button[text()='Continue']");

	public By agreementCheckbox = By.xpath("//input[@id='check_isAgree']");
	public By noVolumeCheckbox = By.xpath("//b[text()='Not Now,']");
	public By checkoutButton = By.xpath("//*[text()='Checkout']");
	public By paymentInfoHeader = By.xpath("//h4[text()='Payment Information']");
	public By volumeAllBtn = By.xpath("//span[text()='All Volumes']");

	public By schedulebtn = By.xpath("//button[contains(text(),'Schedule')]");

	public By cancelBtn = By.xpath("//button[contains(text(),'Cancel')]");

	public By yesBtn = By.xpath("//button[contains(text(),'Yes')]");
	public By RenewButton=By.xpath("//button[text()='Renew Membership']");




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

	public String ErrorMsgText() {
		try {
			//ReusableMethods.scrollIntoView(getElement(ErrorMsgQuoteDoesNotExist), driver);
			return getElement(ErrorMsgQuoteDoesNotExist).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Step("Verify Renewal Widget Button is able to see in MemberShip Page")
	public void VerifyRenewalWidgetButtonNotAvailability() {
		try {

			Assert.assertFalse(!(PublicAdminCommons.isWebElementDisplayed(driver, ReinstateMembership)),"Renew Membership is Available ");
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("User not able to see the Renewal Widget Button", e);
		}
	}

	@Step("Verify Renewal Widget Button is able to see in MemberShip Page")
	public void VerifyRenewalWidgetButtonAvailability() {
		try {
			PublicCommon.waitForSec(10); //ReinstateMembership
			Assert.assertTrue(PublicAdminCommons.isWebElementDisplayed(driver, RenewMembershipheader), "User not able to see the Renewal Widget Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("User not able to see the Renewal Widget Button", e);
		}
	}



	@Step("Verify Renewal Widget Button is able to see in MemberShip Page")
	public void VerifyReinstateMembershipButtonAvailability() {
		try {
			PublicCommon.waitForSec(10);
			Assert.assertTrue(PublicAdminCommons.isWebElementDisplayed(driver, ReinstateMembership), "User not able to see the Renewal Widget Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("User not able to see the Renewal Widget Button", e);
		}
	}

	@Step("Verify Renewal Widget Button is able to see in MemberShip Page")
	public void VerifyReinstateMembershipButtonNotAvailability() {
		try {
			PublicCommon.waitForSec(10);
			Assert.assertFalse(PublicAdminCommons.isWebElementDisplayed(driver, ReinstateMembership), "User not able to see the Reinstate membership Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);


		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("User not able to see the Renewal Widget Button", e);
		}
	}


	public void AddressValidationHeader(){
		PublicCommon.waitForSec(10);
		if(getElement(AddressValidationHeader).isDisplayed()) {
			getElement(AddressValContinueBtn).click();
		}
	}
}
