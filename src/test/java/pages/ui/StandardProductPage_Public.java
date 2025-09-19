package pages.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandardProductPage_Public extends BasePage {

	public StandardProductPage_Public(WebDriver driver) {
		super(driver);
	}

	private By documentTitle = By.xpath("//*[@class='mt-1']");
	private By astmInfo = By.xpath("//*[@class='astm-compass-info']");
	private By astmInfoIcon = By.xpath("//*[@class='astm-compass-info']//i");

	private By gotostmCompassButton = By.xpath("//a[contains(text(),'Go to ASTM Compass�')]");
	public By activeDocIcon = By
			.xpath("//*[contains(@class,'align-items-center')]//*[@class='badge asset-status astm-badge bg-success mr-1']");
	private By standardDocIcon = By
			.xpath("//*[@class='d-flex align-items-center']//*[@class='badge astm-badge bg-secondary']");
	public By activeVersionNumber = By.xpath("//button[@class='btn astm-btn astm-link dropdown-toggle']/a");

	private By documentDesignation = By.xpath("//*[@class='astm-type-body--lead title-text-bold']");

	private By docDesignationInfo = By.xpath("//*[@class='far fa-info-circle']");

	private By lastUpdatedOn = By.xpath("//*[@class='ml-4']");
	public By otherVersionsDropdown = By.xpath("//button[@class='btn astm-btn astm-link dropdown-toggle']");

	private By otherVersionOptions = By.xpath("//*[@class='dropdown-menu show']//*[@class='dropdown-item pl-3']");

	// private By addToCartButton = By.xpath("//button[@title='Add to Cart']");
	private By formatError = By.id("attribute688-error");

	private By shippingAndHandlingLink = By.xpath("//a[@data-target='#shipping_handling']");
	public By searchInput = By.xpath("(//input[contains(@placeholder,'Search')])[2]");
	public By details = By.xpath("//*[text()='Details']/..");// By.xpath("//*[text()='Details']/following-sibling::div");
	public By publicationType = By.xpath("//span[@class='badge astm-badge bg-secondary mr-1']");
	public By publicationDate = By.xpath("//span[@class='ml-3 mr-1']");
	public By publicationStatus = By.xpath("//span[@class='badge astm-badge bg-success mr-1']");
	public By publicationSuccessStatus = By.xpath("//span[@class='badge astm-badge bg-success mr-1']");

	public By latestUpdate = By.xpath("//*[contains(text(),'Last Updated:')]");

	public By Coden = By.xpath("//div[@class='mt-2']//span[@class='astm-type-body--lead']");
	public By License = By.xpath("//a[@data-target='#astm_license_agreement']");
	public By Volume = By.xpath("//div[@class='mt-4']//span[contains(@class,'astm-type-body--lead')]/b");
	public By Tooltip = By.xpath("//*[@data-toggle='tooltip']");
	public By price = By.xpath("//span[@class='price']");
	public By compassButton = By.xpath("//*[contains(text(),'Go to ASTM Compass')]");
	public By relatedLinks = By.xpath("//*[text()='Related']/following-sibling::a");
	public  By completeSectionLink=By.xpath("//a[text()='Complete Set - All sections and volumes']");
	public  By plasticsLink=By.xpath("//a[text()='Section 8 - Plastics']");
	public By productHeader1 = By.xpath("//h2/span");
	public By productDetails=By.xpath("//h6[text()='Details']/../div");

	public By header = By.cssSelector(".astm-type-heading--h3 b");
	public By breadCrumbText = By.cssSelector(".breadcrumbs li");
	public By breadCrumbLinks = By.cssSelector(".breadcrumbs a");
	public By selectFormatDropdown = By.cssSelector("select[data-custom-placeholder='Select Format']");
	public By addToCartButton = By.xpath("//*[contains(text(),'Add to Cart')]");
	public By shoppingCartLink = By.linkText("shopping cart");
	public By cartLink = By.xpath("//*[@class='counter-number']");
	public By checkoutButton = By.xpath("//span[text()='Checkout']");
	public By shippingNHandlingLink = By.linkText("Shipping & Handling");
	public By licenseAgreementLink = By.linkText("ASTM License Agreement");
	public By selectLanguageDropdown = By.cssSelector("select[data-custom-placeholder='Select Language']");
	public By formatErrorMsg = By.xpath("//*[text()='Please select a format']");
	public By languageErrorMsg = By.xpath("//*[text()='Please select a language']");
	public By authorsName = By.xpath("//*[text()='Editor(s):']/..");
	public By relatedInfo = By.xpath("//*[text()='Related']/..");
	public By productHeader=By.xpath("//h1/span");
	public By productList=By.xpath("//*[@id='super-product-table']//span[@class='product-item-name']");
	public By cartEmpty=By.xpath("//span[@class='counter qty empty']");

	public By shippingNHandlingModal = By.id("shippingHandlingLabel");
	public By shippingNHandlingModalCloseButton = By
			.xpath("//*[@id='shippingHandlingLabel']/following-sibling::button[@class='close']");
	public By licenseAgreementModal = By.id("licenseAgreementLabel");
	public By licenseAgreementModalCloseButton = By
			.xpath("//*[@id='licenseAgreementLabel']/following-sibling::button[@class='close']");
	public  By cartCounterNumber=By.xpath("//span[@class='counter-number']");

	private String standardsLink = "//h3[text()='Standards by Category']//following-sibling::div//a[text()='[STANDARDLINKTEXT]']";
	public By getViewPDFButtonOfParticlarPDF(String value)
	{
		String path="//a[text()='"+value+"']/../following-sibling::div/button[text()='View PDF']";
		return By.xpath(path);
	}
	public By alertMsg = By.cssSelector("*[role='alert'] div[class='ml-4']");
	public By IHSStandardsStoreLink = By.linkText("IHS Standards Store");
	public By contactIHSButton = By.linkText("Contact IHS");
	public By publicationDesignation = By.cssSelector("*[class*='astm-type-body--lead'] b");
	public By replacedByDetails = By.xpath("//*[contains(text(),'Replaced By')]");
	public By activeVersionText = By.xpath("//span[@class='badge astm-badge bg-success ml-2']/..");

	public By popCloseButton = By.xpath("(//a/i[@class='astm-icon astm-icon--black far fa-times'])[2]");
	public By searchedProduct = By.xpath("(//h4[contains(@class,'searchComponent')]/a)[1]");
	public By searchedProduct1 = By.xpath("(//*[@class='search-title']/a)[2]");
	public By dropdown = By.className("super-attribute-select");
	public By didYouPopUpCloseBtn = By.xpath("//div[@class='popover fade bs-popover-right show custom-overlay']/a/i");
	public By addToCart = By.xpath("(//button[@title='Add to Cart'])[1]");
	public By cartLink1=By.xpath("//span[@class='cart-title' and text()='Cart']");
	public By infoToolTip = By.xpath("//div[@class='popover fade bs-popover-right show custom-overlay']");
	public By infoToolTipCloseBtn = By.xpath("//div[@class='popover fade bs-popover-right show custom-overlay']/a");
	public By updateBadge = By.xpath("//div[@class='d-flex flex-wrap align-items-center']/span[@class='ml-3 mr-1']");
	public By becomeOrganuizationalMemberButton = By.xpath("//a[text()='Become an Organizational Member']");
	public By productPageTitle = By.xpath("//span[@data-ui-id='page-title-wrapper']");
	public By noProductFoundInfo=By.xpath("//a[@id='information' and contains(text(),'Products and Services (0)')]");

	public By versionDropdown=By.xpath("//div[@class='astm-dropdown dropdown versions versions-dropdown']");
	public By formatDropdown=By.xpath("//span[text()='Format']/../following-sibling::div/select");
	public By languageDropdown=By.xpath("//span[text()='Language']/../following-sibling::div/select");
	public By versionNames=By.xpath("//span[@class='dropdown-item pl-3']/a");
	public By defaultVersionName=By.xpath("//div[@class='astm-dropdown dropdown versions versions-dropdown']/button/a");
	public By getDefaultVersionBadge = By.xpath("//div[@class='astm-dropdown dropdown versions versions-dropdown']/button/a/span");
	public By productDescriptioPDPPage = By.cssSelector("div.astm-type-body--lead.border-top>div");
	public  By productDescription=By.xpath("//div[@class='astm-type-body--lead border-top mt-3 pt-3']/div/p");
	public By productHeaderDescription=By.xpath("//h3/b");
	public By productAbstractDescription=By.xpath("//h1[text()='Abstract']/../div");
	public By detailField=By.xpath("//h6[contains(text(),'Details')]");
	public By astmLiceneseAgreementLink=By.xpath("//a[contains(text(),'ASTM License Agreement')]");
	public By shareField=By.xpath("//h6[contains(text(),'Share')]");
	public By relatedField=By.xpath("//h6[contains(text(),'Related')]");
	public By tabHeader = By.xpath("//div[contains(@class,'active')]/h1");
	public By productClassificationBadge = By.xpath("//span[contains(@class,'badge astm-badge bg-secondary')]");
	public By publishedYearBadge = By.xpath("//span[contains(@class,'ml-3 pl-3 border-left')]");
	public By productStatusBadge = By.xpath("//span[contains(@class,'bg-success') or contains(@class,'bg-danger') or contains(@class,'bg-light')]");
	public By versionDropdownDefaultText=By.xpath("//button[@class='btn astm-btn astm-link dropdown-toggle']/a");
	public By formatDropdownDefaultText=By.xpath("//select[@data-msg-required='Please select a format']");
	public By languageDropdownDefaultText=By.xpath("//select[@data-msg-required='Please select a language']");
	public By productAndServiceInformation=By.xpath("//a[@id='information']");

	public By productPageDOI = By.xpath("//*[contains(text(),'DOI')]/..");
	public By goToCompassLink=By.xpath("//a[contains(text(),'Go to ASTM Compass')]");
	public By freeChapterLink = By.xpath("//span[text()='Free']/../a");
	public By overviewLink=By.xpath("//div[@class='mb-2']/a[contains(text(),'Overview')]");
	public By assetStatus = By.xpath("//span[contains(@class,'badge asset-status')]");
	public By adjunctButton = By.xpath("//div[contains(@class,'container-md')]//a[text()='Adjuncts']");
	public By ITemsWithStndrdNRedlineProduct = By.xpath("//a[contains(text(),'Standard Specification for  Carbon and Low-Alloy Steel Forgings, Requiring Notch Toughness   Testing for Piping Components')]");
	public By adjunctAndRefRadiographsLink = By.xpath("//div[contains(@class,'astm-nav-tabs')]//a/span[text()='Adjuncts and Reference Radiographs']");
	public By tableContentLinks=By.xpath("//div[@class='mb-2']/a");
	public By productDetailCommitteHeader = By.xpath("(//h6[text()='Details']/..//div[@class='astm-type-body mb-2'])[2]/b");
	public By productDetailCommitteeLink = By.xpath("(//h6[text()='Details']/..//div[@class='astm-type-body mb-2'])[2]/a");
	public  By badgeActive = By.xpath("//div[@class='custom-control-inline active-btn']/button[text()='Active']");
	public By StayOnPageBtn=By.xpath("//div[contains(@data-bind,'displayTimer')]/a[contains(text(),'Stay')]");
	public By GotoASTMBtn=By.xpath("//a[contains(@data-bind,'Go to ASTM')]");

	public  By badgeStandard = By.xpath("//div[@class='custom-control-inline stand-btn']/button[text()='Standard']");
	public  By badgeUOP = By.xpath("//div[@class='custom-control-inline stand-btn']/button[text()='UOP']");
	public By linkContactSales = By.xpath("//a[text()='contact sales']");
	public  By badgeActiveCartPage = By.xpath("//div[@class='d-flex flex-wrap align-items-center']/span[text()='Active']");
	public  By badgeStandardCartPage = By.xpath("//div[@class='d-flex flex-wrap align-items-center']/span[text()='Standard']");
	public  By badgeUOPCartPage = By.xpath("//div[@class='d-flex flex-wrap align-items-center']/span[text()='UOP']");
	public By compassRedirectComponent = By.cssSelector("#compass-redirect-component");
	public By stayOnPageButton = By.cssSelector("#compass-redirect-component a");


	public List<WebElement> getITemsWithStndrdNRedlineProduct() {
		return getElements(ITemsWithStndrdNRedlineProduct);
	}

	public By getMembershipPrice(String value)
	{
		return By.xpath("//h4[text()='"+value+"']/../p");
	}

	public By getTabElementByName(String fieldText){
		return By.xpath("//div[@class='tabs-container']//li/a[contains(@id,'"+fieldText+"')]");
	}

	public By getLinkByNameAndFree(String fieldText){
		return By.xpath("//a[contains(text(),'"+fieldText+"')]/../span[text()='Free']");
	}
	public By getLinkByName(String fieldText){
		return By.xpath("//a[contains(text(),'"+fieldText+"')]");
	}

	public By getViewAbstractBtn(String fieldText){
		return By.xpath("//a[text()='"+fieldText+"']/../following-sibling::div[1]/button");
	}
	//a[text()='A Portable Active Photovoltaic Solar Energy System in Treating Wastewaters by Electrocoagulation']/../following-sibling::div[1]//button[@type='submit']
	public By getViewAbstractBtn1(String fieldText){
		return By.xpath("//a[contains(text(),'"+fieldText+"')]/../following-sibling::div[1]/button");
	}

	public By getFormTable(String fieldText){
		return By.xpath("//form[@data-product-sku='"+fieldText+"']/div");
			}
	public  By setxpathByProductName(String value)
	{
		String rt="//form[@data-product-sku='"+value+"']/div[1]/label/span";
		return By.xpath(rt);

	}
	public By setOption(String value)
	{
		String path="//option[contains(text(),'"+value+"')]";
		return By.xpath(path);
	}
	public By attrubuteValue = By.xpath("//div[@data-index='configurable-matrix']//table/tbody/tr/td[8]");
	public By priceValue = By.xpath("//*[@id='container']//table/tbody/tr/td[4]");
	public By skuVersionList = By.xpath("//div[@data-index='versions']//table/tbody/tr/td[7]");
	public By pageVersionCount= By.xpath("//div[@data-index='versions']//div//select");
	public By selectDifferentAccount=By.xpath("//a[contains(text(),'select a different account')]");

	public By getChildAttributeValueBySKU(String sku){
		return By.xpath("//span[contains(text(),'"+sku+"')]/ancestor::tr/td[8]");
	}

	
	public By productPageTableOfContentLinks = By
			.xpath("//div[@class='sections-links astm-type-body--lead mt-4 pt-4']//a");
	public By ptpPageContent = By.xpath("//div[@class='row py-0 justify-content-between']");
	
	public By productPageTableLinks = By.xpath("//div[@class= 'astm-type-body--lead border-top pt-2']//a");
	public By productPageSKU = By.xpath("//*[@id='maincontent']//div/span/b");
	public By productPageCartBtn = By.xpath("//button[@type='submit']");

	public By setVersionoption(String value) {
		String path = "//span[@class='dropdown-item pl-3']/a[contains(text(),'" + value + "')]";
		return By.xpath(path);
	}

	public By getSearchResultVersion = By.xpath("//div[@class='col']/div[2]/button");

	public By getProductPageTableLink(String fieldText){
		return By.xpath("//a[text()='"+fieldText+"']");
	}

	public By productPageIssueLinks= By.xpath("//div[@role='tabpanel']//ul/li/a");

	public WebElement versionOption(String version, String language) {
		By versionOpt = null;
		if (language.contains("Spanish"))
			versionOpt = By.xpath("//*[contains(text(),'" + version + "')]/following-sibling::a[text()='Spanish']");
		else
			versionOpt = By.xpath(
					"//*[contains(text(),'" + version + "')]");
		return getElement(versionOpt);
	}
	public WebElement getastmLiceneseAgreementLink() {
		return getElement(astmLiceneseAgreementLink);
	}

	public WebElement getActiveVersionDropdownText() {
		return getElement(activeVersionText);
	}


	public WebElement getdetailField() {
		return getElement(detailField);
	}

	public WebElement getShoppingCartLink() {
		return getElement(shoppingCartLink);
	}

	public WebElement getActiveVersionNumberText() {
		return getElement(activeVersionNumber);
	}

	public WebElement getPublicationDesignation() {
		return getElement(publicationDesignation);
	}

	public WebElement getAlertMessage() {
		return getElement(alertMsg);
	}

	public WebElement getRelatedInfo() {
		return getElement(relatedInfo);
	}

	public WebElement getAddToCartButton() {
		return getElement(addToCartButton);
	}

	public WebElement getReplacedBy() {
		return getElement(replacedByDetails);
	}

	public WebElement getPublicationStatus() {
		return getElement(publicationStatus);
	}

	public WebElement getPublicationSuccessStatus() {
		return getElement(publicationSuccessStatus);
	}

	public WebElement getShippingNHandlingModal() {
		return getElement(shippingNHandlingModal);
	}

	public WebElement getLicenseAgreementModal() {
		return getElement(licenseAgreementModal);
	}

	public WebElement getPrice() {
		return getElement(price);
	}

	public WebElement getFormatErrorMsg() {
		return getElement(formatErrorMsg);
	}

	public WebElement getLanguageErrorMsg() {
		return getElement(languageErrorMsg);
	}

	public WebElement getPublicationType() {
		return getElement(publicationType);
	}

	public WebElement getPublicationDate() {
		return getElement(publicationDate);
	}

	public WebElement getCoden() {
		return getElement(Coden);
	}

	public WebElement getAuthorsName() {
		return getElement(authorsName);
	}

	public WebElement getLicense() {
		return getElement(License);
	}

	public WebElement getLatestUpdate() {
		return getElement(latestUpdate);
	}

	public WebElement getVolume() {
		return getElement(Volume);
	}

	public WebElement getTooltip() {
		return getElement(Tooltip);
	}

	public WebElement getCompassButton() {
		return getElement(compassButton);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public WebElement getSelectFormatDropdown() {
		return getElement(selectFormatDropdown);
	}

	public WebElement getShippingNHandlingLink() {
		return getElement(shippingNHandlingLink);
	}

	public WebElement getSelectLanguageDropdown() {
		return getElement(selectLanguageDropdown);
	}

	public WebElement getDetails() {
		return getElement(details);
	}

	public List<WebElement> getBreadCrumbTextElements() {
		return getElements(breadCrumbText);
	}

	public List<WebElement> getBreadCrumbLinksElements() {
		return getElements(breadCrumbLinks);
	}

	public List<WebElement> getDetailsElements() {
		return getElements(details);
	}

	public List<WebElement> getRelatedLinksElements() {
		return getElements(relatedLinks);
	}

	public By getProductPageTableOfContentLinks(String fieldText){
		return By.xpath("//a[contains(text(),'"+fieldText+"')]");
	}

	public By getStandardLink(String StandardLinkText){
		return By.xpath(standardsLink.replace("[STANDARDLINKTEXT]", StandardLinkText));
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

	@Step("Clicked on Add to Cart button")
	public boolean clickAddToCart() {
		try {
			getElement(addToCartButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String formatError() {
		try {
			return getElement(formatError).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String documentTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean goToVersion(String version) {
		try {
			List<WebElement> versionList = versionsListElements();
			boolean selection = false;

			for (int i = 0; i < versionList.size(); i++) {
				if (versionList.get(i).getText().equalsIgnoreCase(version)) {
					versionList.get(i).click();
					selection = true;
					ScreenshotUtil.takeScreenshotForAllure(driver);
					break;
				}
			}
			Thread.sleep(10000);
			return selection;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean versionsDropdownVisibility() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(otherVersionsDropdown), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean otherVersionOptions() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(otherVersionsDropdown), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<String> versionsAvailable() {
		try {
			if (otherVersionOptions()) {
				getElement(otherVersionsDropdown).click();

				List<String> versions = new ArrayList<String>();
				List<WebElement> elements = versionsListElements();

				for (int i = 0; i < elements.size(); i++) {
					versions.add(elements.get(i).getText());
				}

				return versions;
			} else {
				System.out.println("Dropdown didn't open properly.");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<WebElement> versionsListElements() {
		try {
			return driver.findElements(otherVersionOptions);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String documentLastUpdatedOn() {
		try {
			return getElement(lastUpdatedOn).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean astmDocDesignationInfoIcon() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(docDesignationInfo), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean astmActiveIconVisibility() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(activeDocIcon), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean astmStandardIconVisibility() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(standardDocIcon), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean astmInfoSectionVisibility() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(astmInfo), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String astmInfoSectionText() {
		try {
			return getElement(astmInfo).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean astmInfoIconVisibility() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(astmInfoIcon), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean astmInfoSectionButtonVisibility() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(gotostmCompassButton), driver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String astmInfoSectionButtonText() {
		try {
			return getElement(gotostmCompassButton).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String documentDesignation() {
		try {
			return getElement(documentDesignation).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean clickShoppingCartLink() {
		try {
			getElement(shoppingCartLink).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Step("Select {StandardLinkText} in Standards By Category page")
	public void selectStandardsInStandardsByCategory(String StandardLinkText){
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getElement(getStandardLink(StandardLinkText)));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getStandardLink(StandardLinkText)));
			clickonmethod(StandardLinkText, getStandardLink(StandardLinkText), "Failed to click on " + StandardLinkText);
			new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(StandardLinkText));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e){
			e.getStackTrace();
		}
	}

	@Step("Click on Application {Application} in Standards")
	public void clickApplicationsInStandards(String Application){
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getElement(getLinkByName(Application)));
			ReusableMethods.scrollIntoView(getElement(getLinkByName(Application)),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getLinkByName(Application)));
			getElement(getLinkByName(Application)).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e){
			e.getStackTrace();
		}
	}

	@Step("Verify visibility of Compass Redirect Component")
	public boolean verifyCompassRedirectComponent(){
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getElement(compassRedirectComponent).isDisplayed();

		}
		catch (Exception e){
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify visibility of compass redirect component", e);
		return false;
		}
	}

	public void clickStayOnPage_CompassRedirectComponent(){

		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(compassRedirectComponent));
			WaitStatementUtils.waitForElementStaleness(driver, getElement(compassRedirectComponent));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(stayOnPageButton));

			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("Stay On Page", stayOnPageButton, "Failed to click on Stay on page button");

		}
		catch (Exception e){
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to click on Stay on Page button on compass redirect component", e);
		}
	}

}
