package pages.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicCommon;

public class APIStoreProductPage_Public extends BasePage {

	public APIStoreProductPage_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By pageHeader = By.xpath("//*[@class='astm-type-heading--h3']");
	public By shippingHandlingLink = By.xpath("//a[@data-target='#shipping_handling']");
	public By shippingAndHandling_modalPopup_Header = By
			.xpath("//*[@class='modal-title' and @id='shippingHandlingLabel']");
	public By closeButtonShipping = By.xpath("//button[@class='close']//span");

	public By domesticShipping = By.xpath("//*[@class='modal-body']//p[contains(.,'Domestic Shipping')]");
	public By domesticRushOrders = By.xpath("//*[@class='modal-body']//p[contains(.,'Domestic Rush Orders')]");
	public By internationalStandardShipping = By
			.xpath("//*[@class='modal-body']//p[contains(.,'International Standard Shipping')]");
	public By internationalExpeditedShipping = By
			.xpath("//*[@class='modal-body']//p[contains(.,'International Expedited Shipping')]");
	public By requestQuoteLink = By.xpath("//a[text()='Request a Quote']");
	public By pageHeaders = By.xpath("//header[contains(@class,'page-header')]");
	public By footers = By.xpath("//div[contains(@class,'footer-content')]");
	public By licenseAgreementLink = By.xpath("//*[@class='astm_license_agreement']//a[text()='License Agreement']");
	public By licenseAgrement=By.xpath("//p/a[contains(text(),'ASTM License Agreement')]");
	public By licenseAgreementLabel = By.id("licenseAgreementLabel");
	public By licenseAgreementCloseButton = By.cssSelector("#astm_license_agreement .close span");
	public By formatDropdown = By.cssSelector("*[data-custom-placeholder='Select Format']");
	public By languageDropdown = By.cssSelector("*[data-custom-placeholder='Select Language']");
	public By addToCartButton = By.xpath("//*[text()='Add to Cart']");
	public By shoppingCartLink = By.linkText("shopping cart");
	
	public List<WebElement> getLicenseAgreementLabels(){
		return getElements(licenseAgreementLabel);
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
	
	public WebElement getLicenseAgreementLabel() {
		return getElement(licenseAgreementLabel);
	
}
	
	public WebElement getFormatDropdown() {
		return getElement(formatDropdown);
	
}
	public WebElement getLanguageDropdown() {
		return getElement(languageDropdown);
	
}
	public String getElementText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getElementByLocator(By locator) {
		try {
			return getElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
