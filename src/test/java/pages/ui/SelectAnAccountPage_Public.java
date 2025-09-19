package pages.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectAnAccountPage_Public extends BasePage {

	public SelectAnAccountPage_Public(WebDriver driver) {
		super(driver);
	}

	public By pageheader = By.xpath("//h3[text()='Select an Account']");
	public By popupText = By.xpath("//*[contains(text(),'By switching accounts, all items in your cart will be removed. You will need to add them back to your cart after switching.')]");
	public By popupSwitchAccountButton = By.xpath("//*[@class='modal-content']//a[contains(text(),'Switch Account')]");
	public By popupCancelButton = By.xpath("//*[@class='modal-content']//a[contains(text(),'Cancel')]");
    public By accountNoEBS = By.xpath("//span[@class='card-text-additional astm-type-body' and contains(text(),\"Account Number #\")]");
	public By selecttext = By.xpath("//a[@class='btn astm-btn btn-secondary account-select-button']");
	public By selectAccount = By.xpath("//button[@class='btn astm-btn btn-secondary']");
	public By messageText = By.xpath(" //p[contains(text(),'If you would like to add a new business account, please')]");
	public By contactUsLink = By.xpath("//a[text()='contact us.']");
	public By indicatorAccount = By.xpath("//span[text()='Last Login']//following-sibling::span[@class='card-text-additional astm-type-body' and contains(text(),'Account Number #')]");
    public By lastLoginAccountSelectBtn=By.xpath("//span[text()='Last Login']/../..//a");
	public By createAnAccountBtn = By.xpath("//a[@class='btn astm-btn btn-secondary' and contains(text(),'Create an Account')]");
	public By textForOrgAcnt = By.xpath("//p[contains(text(),'Please contact ASTM Support at 1-877-909-2786 to add a new organizational account.')]");
	public By disableAcntSelectbtn = By.xpath("//a[@class='btn astm-btn btn-light account-select-button']");
	public By closeBtn = By.xpath("//a[contains(text(),'Close')]");
	public By textOnSelectAnAcntPopupForB2B = By.xpath("//p[contains(text(),'This is an organizational account for PTP orders, please select an existing non PTP organizational account or create a new organizational account.')]");
	public By errorTextForPTPSelctAcnt = By.xpath("//p[contains(text(),'This is not a PTP organizational account, please select an existing PTP organizational account or create a new PTP organizational account.')]");
	public By errorTextForDiableB2BAcnt = By.xpath("//p[contains(text(),'This is an organizational account for PTP orders, please select an existing non PTP organizational account or create a new organizational account.')]");
	public By errorTextForDisablePTPAcnt = By.xpath("//p[contains(text(),'This is an organizational account for PTP orders, please select an existing non PTP organizational account or create a new organizational account.')]");
	public By createAccountBtn  =By.partialLinkText("Create an Account");
	public By createAnAccountBtn1=By.xpath("//a[contains(@href,'create') and contains(text(),'Create an Account')]");
	public By organisationNameField = By.id("organization_name");
	public By switchAccountpopupButton =By.xpath("getPopupSwitchAccountButton");
	public By swichAccountButton=By.xpath("//a[contains(text(),'Switch Account')]");
	public By swichAccountButton1=By.xpath("//a[contains(text(),'select a different account')]");
	public By accountType = By.xpath("//span[@class='card-text-additional astm-type-body']");
	public By lastLoginBadge = By.xpath("//span[@class='badge astm-badge astm-badge-light ml-3']");

	public List<WebElement> getDisableSelect() {
		return driver.findElements(disableAcntSelectbtn);
	}
	public By getAccountLocator(String account) {
		return By.xpath("//*[text()='"+account+"']//ancestor::div[contains(@class,'astm-card')]//a");
	}
	public By getAccountLocator1(String account) {
		return By.xpath("(//*[text()='"+account+"']//ancestor::div[contains(@class,'astm-card')]//a)[2]");
	}

	public By getAccountLocatorSpecPage(String account) {
		return By.xpath("//*[text()='"+account+"']//ancestor::div[contains(@class,'astm-card')]//button");
	}
	public List<WebElement> getSelect() {
		return driver.findElements(selecttext);
	}
	public List<WebElement> getSelectAccount() {
		return driver.findElements(selectAccount);
	}
	public WebElement getIlastLoginAccountSelectBtn() {
		return driver.findElement(lastLoginAccountSelectBtn);
	}
	public WebElement getIndicatorAccount() {
		return driver.findElement(indicatorAccount);
	}
	public List<WebElement> getEBSAccountno() {
		return driver.findElements(accountNoEBS);
	}
	
	public WebElement getaccountType(String accountNumber) {
		return getElement(By.xpath("//span[@class='card-text-additional astm-type-body' and contains(text(),'Account Number #"+accountNumber+"')]"));
	}
	
	public WebElement getactiveAccount() {
		return getElement(By.xpath("//span[text()='Last Login']//following-sibling::span"));
	}
	
	public WebElement getContactUs() {
		return getElement(contactUsLink);
	}

	public WebElement getSelectAnAccountHeader() {
		return getElement(pageheader);
	}

}
