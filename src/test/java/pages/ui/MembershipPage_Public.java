package pages.ui;

import java.util.List;

import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MembershipPage_Public extends BasePage{

	public MembershipPage_Public(WebDriver driver) {
		super(driver);
	}

	public By header = By.xpath("//h1[text()='Membership']");
	public By renewMembershipLink = By.linkText("Renew Membership for 2020");
	public By reinstateMembershipLink = By.xpath("//a[contains(text(),'Reinstate Membership for')]");
	public By reinstateMembershipLinkOnMyAccount=By.xpath("//button[text()='Reinstate Membership']");
	public By MemberNotAssociatedWithOrg = By.xpath("//input[@id='isNotAffiliated']/../label");
	public By ModalLabelConfirmationPopup = By.xpath("//h5[@id='exampleModalLabel']");
	public By YesBtnConfirmationPopup = By.xpath("//button[@class='btn astm-btn btn btn-secondary']");
	public By InviteAColleague=By.xpath("//a[contains(text(),'Invite a Colleague to Join')]");
	public By MyCommitteeBullet = By.xpath("//ul[@class='bulletList']/li/a[text()='MyCommittees']");
	public By RosterMaintenanceLink = By.xpath("//div[@class='myTools']/div/div[1]/div/h2/a[text()='Roster Maintenance ']");
	public By MyAccount = By.xpath("//a[text()='MyAccount']");
	public By userOptionsMenu=By.xpath("//button[@aria-controls='user-menu-options']");
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

	public String RosterMaintenanceLink() {
		try {
			return getElement(RosterMaintenanceLink).getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Step("Check Roster Maintenance visibility")
	public void CheckRostermaintenanceVisibility() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(RosterMaintenanceLink),15);
			String RosterLink = RosterMaintenanceLink();
			RosterLink.equals(RosterMaintenanceLink);
			getElement(RosterMaintenanceLink).click();

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to find ASTM Admin email ", e);
		}

	}
	
}
