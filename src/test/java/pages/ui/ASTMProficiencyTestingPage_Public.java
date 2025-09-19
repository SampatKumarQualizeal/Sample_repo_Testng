package pages.ui;

import java.util.List;

import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicCommon;
import org.apache.kafka.common.protocol.types.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertTrue;

public class ASTMProficiencyTestingPage_Public extends BasePage{

	public ASTMProficiencyTestingPage_Public(WebDriver driver) {
		super(driver);
	}

	HomePage_Public homepage=getInstance(HomePage_Public.class);
	PTPProductPageCommon_Public ptpcommon=getInstance(PTPProductPageCommon_Public.class);
	BillingAddressPage_Public billingAddressPage=getInstance(BillingAddressPage_Public.class);





	public By ptpProductLinks = By.cssSelector("#ptp-products a");
	public By accreditedSymbolImage = By.cssSelector("*[src*='/images/A2LA_accredited_symbol.jpg']");
	public By learnMoreLink = By.xpath("//*[contains(@src,'/images/A2LA_accredited_symbol.jpg')]/parent::div//a");
	public By fullListSection = By.xpath("//button[contains(text(),'Full List')]");
	public By noCommitteeAffiliation = By.xpath("//button[contains(text(),'No Committee Affiliation')]");

	public By productCostOnProductPage = By.cssSelector(".tpt_product_info_price");
	public By EarlyBirdOfferText=By.xpath("//span[text()='Secure Your Spot and Your Savings with Early Bird Pricing!']");

	public By committeeLink(String committeeName) {
		return By.xpath("//*[contains(text(),'"+committeeName+"')]");
	}

	public String clickOnPTPLink(String CommitteName,int index)
	{
		String productName=null;
		try {
			WebElement Ptp = driver.findElement(By.xpath("(//button[contains(text(),'"+CommitteName+"')]/parent::h2/parent::div/following-sibling::div/descendant::ul/li/a[contains(@href,'2024')])[2]"));
			ReusableMethods.scrollIntoView(Ptp, driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, Ptp, 10);
			productName=Ptp.getText();
			Ptp.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productName;
	}

	public By committeeLink2(String committeeName) {
		return By.xpath("(//*[contains(text(),'"+committeeName+"')])[2]");
	}
	
	public By productLink(String committeeName, String productName) {
		return By.xpath("//*[contains(text(),'"+committeeName+"')]//ancestor::*//*[@class='collapse show']//a[contains(@href,'2025') and contains(text(),'"+productName+"')]");
	}
	
	public List<WebElement> getPTPProductLinks() {
		return getElements(ptpProductLinks);
	}

	public By getPtpProductLinkBySectionAndProductName(String sectionName, String productName){
		return By.xpath("//button[contains(text(),'"+sectionName+"')]/ancestor::div[@class='card astm-card']//a[contains(text(),'"+productName+"')]");
	}

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

	
	
	
	
}
