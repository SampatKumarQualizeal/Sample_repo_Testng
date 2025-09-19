package pages.ui;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ScreenshotUtil;

public class APIWebstoreHomePage extends BasePage {

	public APIWebstoreHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By apiOrgTab = By.xpath("//a[text()='Aplorg']");
	public By aboutTab = By.xpath("//ul[contains(@class,'custom-top-links')]//a[text()='About']");
	private By membershipTab = By.xpath("//ul[contains(@class,'custom-top-links')]//a[text()='Membership']");
	public By contactTab = By.xpath("//ul[contains(@class,'custom-top-links')]//a[text()='Contact']");
	public By homeTab = By.xpath("//div[@id='navbarNavDropdown']/ul//li/a[contains(text(),'Home')]");
	public By latestTab = By.xpath("//div[@id='navbarNavDropdown']/ul//li/a[contains(text(),'Latest')]");
	public By mostsPopulartTab = By.xpath("//div[@id='navbarNavDropdown']/ul//li/a[contains(text(),'Most Popular')]");
	public By subscriptionTabs = By.xpath("//div[@id='navbarNavDropdown']/ul//li/a[contains(text(),'Subscriptions')]");
	public By searchDocumentField = By.xpath("//div[contains(@class,'right-navbar')]//input");
	public By cartLink = By
			.xpath("//div[contains(@class,'header container')]//div[@class='custom-cart-block text-nowrap']/a");
	public By mobile_CartLink = By
			.xpath("//div[contains(@class,'right-navbar navbar')]//div[@class='custom-cart-block']/a");
	public By searchBtn = By.xpath("//div[contains(@class,'right-navbar')]//input/..//button[@title='Search']");
	public By ApiLogo = By.xpath("//img[contains(@src,'ASTM/api/en_US/images/logo/logo.svg')]");
	public By UpdatedApiLogo = By.xpath("//a[@class='store-logo']//img");

	public By logoLink = By.xpath("//img[contains(@src,'ASTM/api/en_US/images/logo/logo.svg')]//parent::a");
	public By addToCartList = By.xpath("//span[text()='Add to Cart']");
	public By loginLink = By.xpath("//div[contains(@class,'header container')]//a[contains(text(),'Login')]");
	public By loginLinkOnMobile = By
			.xpath("//div[contains(@class,'right-navbar navbar')]//a[contains(text(),'Login')]");
	public By apiEquipmentHeader = By.xpath("//h5[contains(text(),'API Equipment Specifications')]");
	public By headerLinks = By.xpath("//header[contains(@class,'page-header m-0 astm-header')]//a");
	public By searchFooter = By.cssSelector("#search-footer");
	public By footerLinks = By.xpath("//div[contains(@class,'footer-top')]//a");
	public By copyright = By.xpath("//small[contains(@class,'copyright border')]/span");
	public By pageHeader = By.xpath("//header[contains(@class,'page-header')]");
	public By pageFooter = By.xpath("//div[contains(@class,'footer-top-block ')]");
	public By documentTopicsLinks = By.xpath("//h5[text()='Document Topics']/../ul//li");
	public By latestSectionLinks = By.xpath("//h5[text()='Latest']/..//a[@class='text-primary']");
	public By latestSectionPrice = By.xpath("//h5[text()='Latest']/..//p[contains(text(),'Price')]");
	public By seePurchasingOptions = By.xpath("//h5[text()='Latest']/..//a");
	public By latestSectionHEader = By.xpath("//h5[text()='Latest']");
	public By heroSectionText = By.xpath("//div[contains(@class,'retail-homepage-hero')]//h1");
	public By promoDocumentImg = By.xpath("//div[contains(@class,'bg-dark astm-type-body')]//img");
	public By learnMore = By.xpath("//div[contains(@class,'bg-dark astm-type-body')]//a");
	public By promoHeader = By.xpath("//div[contains(@class,'bg-dark astm-type-body')]//h3");
	public By mostPopularSectionLinks = By.xpath("//h5[text()='Most Popular']/..//a");
	public By mostPopularSectionHeader = By.xpath("//h5[text()='Most Popular']");
	public By latestrSectionHeader = By.xpath("//a[contains(text(),'Latest ')]");
	public By myAccountbtn = By.xpath("//div[contains(@class,'header container')]//a[contains(text(),'My Account')]");
	public By favicon = By.cssSelector("*[type='image/x-icon'][rel='icon']");
	public By linksHeading = By.xpath("//h1[contains(@class,'astm-type-heading')]");
	public By footers = By.xpath("//div[contains(@class,'footer-content')]");
	public By pageHeaders = By.xpath("//header[contains(@class,'page-header')]");
	public By lincenseAgreementFooterLink = By.xpath("//a[text()='License agreement']");
	public By contactFooterLink = By.xpath("//div[contains(@class,'footer-links')]//a[text()='Contact']");
	public By contactUsHeader = By.xpath("//h1[@class='astm-type-heading--h2 my-3' and contains(text(),'Contact Us')]");
	private By uname = By.id("userName");
	private By userPassword = By.id("password");
	private By login = By.xpath("// button[@type='submit' and text()='Sign In']");// By.xpath("//button[@class='btn
																					// btn-warning']"); //
																					// button[@type='submit' and
																					// text()='Sign In']
	public By signIn = By.xpath("//a[text()='Sign In']"); // Central Login/Registration Page Sign in button
	public By contactUsLink = By.xpath("//p//a[contains(text(),'contact us')]");
	public By apiMonogramLink = By.xpath("//a[contains(text(),'API Monogram')]");
	public By qualityRegistrarLink = By.xpath("//a[contains(text(),'Quality Registrar')]");
	public By apiAdvisory9Link = By.xpath("//h5[contains(text(),'API Equipment Specifications')]/..//a[3]");
	public By emptySearchMessage = By.xpath("//div[@class='message notice']");
	public By updatedAPIHeroImage = By
			.xpath("//div[@class='retail-homepage-hero astm-type-body--lead py-5 align-items-center d-flex mb-0']");
	public By latestLinkUpper = By.xpath("//a[contains(text(),'Latest ')]");
	public By mostLinkUpper = By.xpath("//a[contains(text(),'Most Popular')]");
	public By mostLinkArea = By.xpath("//div[@class='container-xl']");
	public By latestLinkArea = By.xpath("//div[@class='w-100']");
	public By APIEquipmentSpecifications =By.xpath("//h5[contains(text(),'API Equipment Specifications')]");
	public By footerLatestSection =By.xpath("//a[@class='nav-link py-2 py-md-1 astm-type-body text-white mb-0 ' and contains(text(),'Latest')]");
	public By footerMostLinkSection =By.xpath("//a[@class='nav-link py-2 py-md-1 astm-type-body text-white mb-0 ' and contains(text(),'Latest')]");
	
	
	public boolean clickCartLink() {
		try {
			getElement(cartLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean verifymostPopularSectionHeader() {
		return getElements(mostPopularSectionHeader).size() == 0;
		
	}
	public WebElement getcontactUsHeader() {
		return getElement(contactUsHeader);
	}

	public WebElement getcontactUsLink() {
		return getElement(contactUsLink);
	}

	public boolean clickMobileCartLink() {
		try {
			getElement(mobile_CartLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public WebElement getapiEquipmentHeader() {

		return getElement(apiEquipmentHeader);
	}

	public List<WebElement> getAddToCartList() {

		return getElements(addToCartList);
	}

	public List<WebElement> getMostPopularSectionLinks() {

		return getElements(mostPopularSectionLinks);
	}

	public List<WebElement> getPurchasingOptions() {

		return getElements(seePurchasingOptions);
	}

	public List<WebElement> getLatestSectionPrice() {

		return getElements(latestSectionPrice);
	}

	public List<WebElement> getLatestSectionLink() {

		return getElements(latestSectionLinks);
	}

	public List<WebElement> getDocumentTypeLinks() {

		return getElements(documentTopicsLinks);
	}

	public String getLogoImageResource() {
		return getElement(logoLink).getAttribute("href");
	}

	public List<WebElement> getFooterLinks() {

		return getElements(footerLinks);
	}

	public List<WebElement> getHeaderLinks() {

		return getElements(headerLinks);
	}

	public boolean getLogoAPIStore() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(ApiLogo), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean newLoginFlow(String userEmail, String password) {
		try {
			getElement(uname).sendKeys(userEmail);
			getElement(userPassword).sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(login).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
