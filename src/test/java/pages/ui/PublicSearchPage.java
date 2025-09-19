package pages.ui;

import java.util.ArrayList;
import java.util.List;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.astm.commonFunctions.PublicCommon;

import io.qameta.allure.Step;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class PublicSearchPage extends BasePage {
	CommonPage_Public commonPagePublic;
	StandardProductPage_Public standardProductPagePublic;
	BillingAddressPage_Public billingAddressPage;
	MembershipBecomeMemberPage newMembershipPage;



	public PublicSearchPage(WebDriver driver) {
		super(driver);
	}
	public String ACTIVE_BADGE = "Active";
	public String STANDARD_BADGE = "Standard";
	public String WITHDRAWN_BADGE = "Withdrawn";
	public String BADGE_COLOR_GREEN = "rgba(56, 108, 56, 1)";
	public String BADGE_COLOR_BLUE = "rgba(0, 93, 164, 1)";
	public String BADGE_COLOR_RED = "rgba(149, 49, 41, 1)";

	public By searchBox = By.xpath("(//input[contains(@placeholder,'Search')])[2]");

	public By productsAndServicesTabOther = By.cssSelector(".webm #products");
	public By informationTabOther = By.cssSelector(".webm #information");

	public By PandSTAB = By.xpath("//a[contains(text(),'Products and Services')]");
	
	public By productsAndServicesTab = By.xpath("//a[text()='Products and Services']");
	public By informationTab = By.xpath("//span[text()='Information']");
	public By contentBody=By.xpath("(//p[contains(@class,'searchComponent_paragraph')]/mark)[1]");
	public By didYouPopUpCloseBtn = By.cssSelector("#information");

	public By infoTabActive = By.xpath("//span[text()='Information']/parent::a");
	public By searchedPageTitle = By.xpath("//h2[@data-testid='title']");

	public By searchError = By.cssSelector(".message.notice");

	public By infoIcon = By.xpath("//i[@id='custom-popover-desktop']");
	public By infoClose = By.xpath("//a//i[@id='custom-close']");
	public By toolTipFirstTimeSearch = By.xpath("//div[@class='popover fade bs-popover-right show custom-overlay']");
	public By toolTipFirstTimeSearchMobile=By.xpath("//div[@class='popover fade bs-popover-left show custom-overlay-mobile']");
	public By firstTimeSearchCLoseInfo = By.xpath("//div[@class='popover fade bs-popover-right show custom-overlay']//i[@id='custom-close-overlay']");
	public By firstTimeToolTipCloseInfoMobile=By.xpath("//div[@class='mobilem']//i[@id='custom-close-overlay']");
	public By informationPopup = By.xpath("//div[@role='tooltip'][not(contains(@class,'custom-overlay'))]");
	public By informationPopupHeader = By
			.xpath("//div[@role='tooltip'][not(contains(@class,'custom-overlay'))]//h3[@class='popover-header']");
	public By informationPopupDesc = By
			.xpath("//div[@role='tooltip'][not(contains(@class,'custom-overlay'))]//div[@class='media-body']/p");

	public By productsAndServicesTabMobile = By.cssSelector(".mobilem #information");
	public By informationTabMobile = By.cssSelector(".mobilem #products");
	public By activeProductsAndServicesDefault = By
			.xpath("//div[@class='webm']//a[@class='active' and @id='information' and contains(text(),'Products')]");
	public By activeInformationDefault = By.xpath(
			"//div[@class='webm']//a[@id='information' and @class='active' and contains(text(), 'Information')]");
	public By textNotDisplayed = By.cssSelector(".message");
	
	//	public By paginationInProducts = By.xpath("//div[@class='pages']//ul[@class='items pages-items']");
	public By paginationInProducts = By.xpath("//ul[@class='items pages-items astm-pagination pagination']");
	public By paginationDiffResultsProd=By.xpath("//ul[@class='items pages-items astm-pagination pagination']//li[3]");
	public By paginationNextProd=By.xpath("//ul[@class='items pages-items astm-pagination pagination']//a[@title='Next']");
	public By paginationPreviousProd=By.xpath("//ul[@class='items pages-items astm-pagination pagination']//a[@title='Previous']");
	public By paginationNumberProd=By.xpath("//ul[@class='items pages-items astm-pagination pagination']//li[3]//span[2]");
	public By paginationEllipsisOneProd=By.xpath("//ul[@class='items pages-items astm-pagination pagination']//li[2]");
	public By paginationPageOneProd=By.xpath("//ul[@class='items pages-items astm-pagination pagination']//li[2]");	

	public By allSearchResultLinks = By
			.xpath("//div[@class='row']//following-sibling::strong/div//span");

	public By paginationInInfo = By.xpath("//div[@class='web']//div[2]//ul");
	public By paginationDiffResults=By.xpath("//div[@class='web']//div[2]//ul//li[3]");
	public By paginationNumber=By.xpath("//div[@class='web']//div[2]//ul//li[3]//span[2]");
	public By paginationEllipsisOne=By.xpath("//div[@class='web']//div[2]//ul//li[2]");
	public By paginationEllipsisTwo=By.xpath("//div[@class='web']//div[2]//ul//li[6]");
	public By paginationPageOne=By.xpath("//div[@class='web']//div[2]//ul//li[2]");
	public By paginationNext=By.xpath("//div[@class='web']//div[2]//ul//a[@title='Next']");
	public By paginationPrevious=By.xpath("//div[@class='web']//div[2]//ul//a[@title='Previous']");
	
	public By refinementTab = By.xpath("//div[@class='view']");
	public By resultsNumber = By.xpath("//b[contains(text(),'Results')]");

	public By sKUSearchResult=By.xpath("//div[@class='webm']//a[@class='product-item-link']");
	public By quickAddOne=By.xpath("//div[@class='webm']//li[@class='item product product-item mst-search__index'][1]//span[contains(text(),'Quick Add')]");

	public By versionDD=By.xpath("//div[contains(@class,'versions-dropdown')]/button");
	public By LanguageDD=By.xpath("//select[@data-value='Language']");
	public By FormatDD=By.xpath("//select[@data-value='Format']");
	public By selectFormatDropdown = By.xpath("(//div[contains(@class,'dropdown-menu quick-add-menu')])[3]/span/span");
	public By quickAddModalFormatComponents=By.xpath("//div[contains(@class,'show')]//span[text()='Format']//parent::label/following-sibling::div//div/div/span");

	public By addToCartButton = By.xpath("//*[contains(text(),'Add to Cart')]");
	public By QuickAddToCart = By.xpath("(//span[text()='Add to Cart'])[1]");
	public By PandSSearchTitle = By.xpath("(//h4[contains(@class,'searchComponent_title')]/a)[1]");
	public By InfoSearchTitle = By.xpath("(//h4[contains(@class,'searchComponent_title')]/a)[1]");
	public By shoppingCartLink = By.linkText("shopping cart");
	public By SelectFormatdd = By.className("dropdown-menu quick-add-menu");
	public By HardcopySelect = By.xpath("(//div[contains(@class,'dropdown-menu quick-add-menu')])[3]/span/span[text()='Hard Copy']");
	public By PDFselect = By.xpath("(//div[contains(@class,'dropdown-menu quick-add-menu')])[3]/span/span[text()='PDF']");
	public By StandardsRedlineBundle = By.xpath("(//div[contains(@class,'dropdown-menu quick-add-menu')])[3]/span/span[text()='Online - Standard + Redline Bundle']");

	public By ShoppingCartMessage = By.xpath("//div[@class='prepare-message astm-alert-text']");
	public By MessageError = By.xpath("//div[contains(text(),'Only 1 PTP program is allowed')]");
	public By cartLink(){
		return By.xpath("//span[@class='cart-title' and text()='Cart']");
	}
	public By ShowLimiter = By.cssSelector(".limiter button");
	public By SortBy = By.cssSelector(".search-sortyby button");
	public String ShowDropdownOptions_var = "//a[@data-value='[DATA_VALUE]']/span";
	public String SortByDroptionOptions_var = "//a[@data-value='[DATA_VALUE]']/span";
	public String ResultsBadge_var = "//div[contains(@class,'custom-control-inline')]/button[text()='[BADGE_TEXT]']";
	public By ResultBadge_Standard = By.cssSelector(".standard");
	public By ResultBadge_Active = By.xpath("//button[contains(@class,'active-0') and text()='Active']");
	public By ResultBadge_Withdrawn = By.xpath("//button[contains(@class,'active-0') and text()='Withdrawn']");
	public By ActiveProductOnSearchPage = By.xpath("//h4[contains(@class,'searchComponent_title')]/a");
	public void clickPAndS() {
		getElement(productsAndServicesTab).click();
	}

	@Step("Validating search tool tip presence when the user searches for the first time")
	public boolean verifyToolTipFirstTimeSearchMobile() {
		return getElements(toolTipFirstTimeSearchMobile).size()==1;
	}
	
	public void clickFirstTimeToolTipCloseInfoMobile() {
		getElement(firstTimeToolTipCloseInfoMobile).click();
	}
	
	public void clickPaginationDiffResultsProd() {
		getElement(paginationDiffResultsProd).click();
		//wait.until(ExpectedConditions.elementToBeClickable(productsAndServicesTabOther));
	}
	
	public boolean verifyPaginationDiffResultsProd() {
		return getElements(paginationDiffResultsProd).size()==1;
	}
	
	public boolean verifyPaginationPageOne() {
		return getElements(paginationPageOne).size()==1;
	}
	
	public boolean verifyPaginationPageOneProd() {
		return getElements(paginationPageOneProd).size()==1;
	}
	
	public boolean verifyPaginationEllipsisOneandTwo() {
		return getElement(paginationEllipsisOne).getAttribute("class").contains("disabled");
	}
	
	public boolean verifyPaginationEllipsisOneandTwoProd() {
		return getElement(paginationEllipsisOneProd).getAttribute("class").contains("disabled");
	}
	
	public boolean verifyAnySKUSearch(String expectedText) {
		return getElement(sKUSearchResult).getText().contains(expectedText);
	}
	
	public String getSKUResult() {
		return getElement(sKUSearchResult).getText();
	}
	
	public boolean paginationValidation() {
		return getElements(paginationInInfo).size() == 1;
	}
	
	
	public boolean verifyRefinementTab() {
		return getElements(refinementTab).size() == 1;
	}

	public boolean paginationInPAndS() {
		return getElements(paginationInProducts).size() == 1;
	}

	public boolean paginationInInfoValidation() {
		return getElements(paginationInInfo).size() == 1;
	}
	
	public void clickPaginationNext() {
		PublicCommon.waitForSec(3);
		getElement(paginationNext).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(paginationNumber,"2"));
	}
	
	public void clickPaginationNextProd() {
		PublicCommon.waitForSec(3);
		getElement(paginationNextProd).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(paginationNumberProd,"2"));
	}
	
	public void clickPaginationPrevious() {
		getElement(paginationPrevious).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(paginationNumber,"3"));
	}
	
	public void clickPaginationPreviousProd() {
		getElement(paginationPreviousProd).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(paginationNumberProd,"3"));
	}
	
	public void clickPaginationDiffResults() {
		getElement(paginationDiffResults).click();
		wait.until(ExpectedConditions.elementToBeClickable(informationTabOther));
	}
	
	public boolean verifyPaginationDiffResults() {
		return getElements(paginationDiffResults).size()==1;
	}
	
	public String getPaginationNumber() {
		return getElement(paginationNumber).getText();
	}
	
	public String getPaginationNumberProd() {
		return getElement(paginationNumberProd).getText();
	}

	public void clickPAndSOther() {
		getElement(productsAndServicesTabOther).click();
	}

	public int getResultsCountInRefinement() {
		String totalText = getElement(resultsNumber).getText();
		totalText = totalText.split(" ")[0];
		return Integer.parseInt(totalText);
	}

	public int getResultsCountFromPAndS() {
		String totalText = getElement(activeProductsAndServicesDefault).getText();
		totalText = totalText.split("\\(")[1].replace(")", "");
		return Integer.parseInt(totalText);
	}
	
	public int getResultsCountFromInfo() {
		String totalText = getElement(activeInformationDefault).getText();
		totalText = totalText.split("\\(")[1].replace(")", "").trim();
		return Integer.parseInt(totalText);
	}

	public boolean verifySearchTextNotDisplayed(String expectedText) {
		return getElement(textNotDisplayed).getText().contains(expectedText);
	}

	public void clickInfoTab() {
		PublicCommon.waitForSec(3);
		if(getElements(activeProductsAndServicesDefault).size()==1)
		getElement(informationTab).click();
		waitForElementPresent(activeInformationDefault);
	}

	public void clickPandS() {
		PublicCommon.waitForSec(3);
		//if(getElements(informationTab).size()==1)
			getElement(PandSTAB).click();
		waitForElementPresent(PandSTAB);
	}

	public void clickInfo() {
		getElement(informationTab).click();
		waitForElementPresent(activeInformationDefault);
	}
	
	public void clickInformation() {
		getElement(productsAndServicesTab).click();
	}

	public String searchResultTitle = ".webm li:nth-child(%s) .product-item-link";

	public boolean verifyInformation() {
		return getElements(activeInformationDefault).size() == 1;
	}

	@Step("Verify Tooltip is Displayed on Information Tab on Search results page")
	public boolean verifyToolTipPresence() {
		return getElement(toolTipFirstTimeSearch).isDisplayed();
	}

	public void clickfirstTimeSearchCLoseInfo() {
		if (getElements(firstTimeSearchCLoseInfo).size() == 1)
			getElement(firstTimeSearchCLoseInfo).click();
	}

	public String verifyText(By locator){
		return getElement(locator).getText();
	}
	
	public void firstTimeSearchCLoseInfo() {
		WaitStatementUtils.waitForElementStaleness(driver, getElement(firstTimeSearchCLoseInfo));
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(firstTimeSearchCLoseInfo),5);
		getElement(firstTimeSearchCLoseInfo).click();
	}

	public boolean verifyPAndSDefault() {
		return getElements(activeProductsAndServicesDefault).size() == 1;
	}

	public boolean verifyProductsAndServices() {
		return getElements(productsAndServicesTab).size() == 1;
	}

	public boolean verifyInformationTab() {
		return getElements(informationTab).size() == 1;
	}

	public void QuickAddButton() {
		PublicCommon.waitForSec(5);
		waitForElementPresent(quickAddOne);
	}



	
	public boolean verifyProductsAndServicesMobile() {
		return getElements(productsAndServicesTabMobile).size() == 1;
	}

	public boolean verifyInformationTabMobile() {
		return getElements(informationTabMobile).size() == 1;
	}

	public boolean verifyInfoIcon() {
		return getElements(infoIcon).size() == 1;
	}

	public void closeInfo() {
		if (getElements(infoClose).size() == 1)
			getElement(infoClose).click();
	}

	public void clickInfoIcon() {
		waitForElementPresent(infoIcon);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		getElement(infoIcon).click();
	}

	public String getNumberOfProductsFromInformationTab() {
		return getElement(productsAndServicesTab).getText();
	}

	public String getInfoPopupHeaderText() {
		return getElement(informationPopupHeader).getText();
	}

	public String getInfoPopupDescText() {
		return getElement(informationPopupDesc).getText();
	}

	public String getSearchResultTitle(int index) {
		return getElement(By.cssSelector(String.format(searchResultTitle, index))).getText();
	}

	public boolean verifySearchError() {
		return driver.findElements(searchError).size() == 1;
	}

	public boolean verifyInformationPopupDisplayed() {
		return driver.findElements(informationPopup).size() == 1;
		// return getElement(informationPopup).isDisplayed();
	}

	public void verifyUrl(String message, String expectedurl, String expectedText) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.urlContains(expectedText));
			verifyUrl(message, driver.getCurrentUrl(), expectedText);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("", e);
		}
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Step("Verify the presence of given search term in Search results")
	public boolean verifySearchTextInAllLinksFirstPage(String text) {
		ArrayList<WebElement> elements = (ArrayList<WebElement>) getElements(allSearchResultLinks);
		boolean textPresent = false;

		for (WebElement webElement : elements) {
			if (webElement.getText().contains(text)) {
				textPresent = true;
			} else {
				textPresent = false;
				break;
			}
		}
		return textPresent;
	}

	@Step("Get dropdown options list {optionText}")
	public List<String> getFormatDropDownOptionList() {
		List<String> optionText = new ArrayList<String>();
		try {
			Select select = new Select(getElementNew(selectFormatDropdown));
			PublicCommon.waitForSec(3);
			List<WebElement> allOptions = select.getOptions();
			for (WebElement el : allOptions) {
				optionText.add(el.getText());
				System.out.println(el.getText());
				System.out.println(optionText.size());
			}
			return optionText;
		} catch (Exception e) {
			e.printStackTrace();
			return optionText;
		}

	}
	public List<WebElement> getFormatDropdownElements() {
		return getElements(FormatDD);
	}
	@Step("Get dropdown options list {optionText}")
	public List<String> getFormatddlist() {
		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getFormatDropdownElements(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Select {elementName}: '{keys}'in DropDown")
	public void selectValue(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.selectValueInDropdown(getElement(locator), keys), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select value from dropdown.", e);
		}
	}

	public String PandSgetsearchTitle() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getElement(PandSSearchTitle).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Verify Information Tab search title")
	public String InfogetsearchTitle(String expectedSearchTerm) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
		    if(getElement(infoTabActive).getAttribute("class").contains("active")) {
				PublicCommon.waitForSec(20);
				getElement(InfoSearchTitle).getText().equals(expectedSearchTerm);
			} else {
				getElement(informationTab).click();
				PublicCommon.waitForSec(20);
				getElement(InfoSearchTitle).getText().equals(expectedSearchTerm);
			}

		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		return expectedSearchTerm;
	}

	@Step("Verify if Product is added to cart")
	public String clickOnShoppingCartLink(){
		String ProgramName = null;
		try{
			assertTrue(verifyText(ShoppingCartMessage).contains("You added "+ProgramName+" to your"));
			clickOnMethod("Shopping cart Link", getElement(shoppingCartLink));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to add product to cart", e);
		}
		return ProgramName;
	}

	public WebElement getShowLimiter(){ return getElement(ShowLimiter);	}
	public  WebElement getSortBy() { return getElement(SortBy);	}

	public WebElement getShowDropDownOptions(String DataValue){
		return getElement(By.xpath(ShowDropdownOptions_var.replace("[DATA_VALUE]", DataValue)));
	}

	public WebElement getSortByDropDownOptions(String DataValue){
		return getElement(By.xpath(SortByDroptionOptions_var.replace("[DATA_VALUE]", DataValue)));
	}

	public WebElement getBadge(String BadgeText){
		return getElement(By.xpath(ResultsBadge_var.replace("[BADGE_TEXT]", BadgeText)));
	}
	@Step("verify Visibility of Show and Sort By dropdowns in Search results page in Products and Services tab")
	public void verifyShowAndSortByDropdowns(){
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getShowLimiter());
			WaitStatementUtils.waitForElementToBeClickable(driver, getShowLimiter());
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(getElements(ShowLimiter).size() == 1, "Assert Failed: Show dropdown not found");

			WaitStatementUtils.waitForElementStaleness(driver, getSortBy());
			WaitStatementUtils.waitForElementToBeClickable(driver, getSortBy());
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(getElements(SortBy).size() == 1, "Assert Failed: Sort By dropdown not found");

		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Show And Sort By Dropdowns in Search results page in Products and Services tab", e);
		}
	}

	@Step("Click on Show Dropdown in Search results page in Products and Services tab ")
	public void clickShowDropdown(){
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getShowLimiter());
			WaitStatementUtils.waitForElementToBeClickable(driver, getShowLimiter());
			clickonmethod("Show dropdown", ShowLimiter, "failed to click on Show Limiter Dropdown");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementStaleness(driver, getShowDropDownOptions("10"));
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception occurred while clicking on Show Dropdown", e);
		}
	}

	@Step("verify Show Dropdown Options in Search results page in Products and Services tab")
	public void verifyShowDropdownOptions(){
	try {
		WaitStatementUtils.waitForElementStaleness(driver, getShowDropDownOptions("10"));
		WaitStatementUtils.explicitWaitForVisibility(driver, getShowDropDownOptions("10"));
		ScreenshotUtil.takeScreenshotForAllure(driver);
		Assert.assertTrue(getShowDropDownOptions("10").getText().equals("10 results per page"), "Failed to validate '10 results per page' option");
		Assert.assertTrue(getShowDropDownOptions("20").getText().equals("20 results per page"), "Failed to validate '20 results per page' option");
		Assert.assertTrue(getShowDropDownOptions("30").getText().equals("30 results per page"), "Failed to validate '30 results per page' option");
		}
	catch (Exception e){
		e.printStackTrace();
		PublicCommon.reportFailAssert("Failed to Verify Show Dropdown Options in Search results page in Products and Services tab", e);
		}
	}

	@Step("click on Sort By Dropdown in Search results page")
	public void clickSortByDropdown(){
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getSortBy());
			WaitStatementUtils.waitForElementToBeClickable(driver, getSortBy());
			clickonmethod("Sort By Dropdown", SortBy, "Failed to click on Sort By Dropdown");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementStaleness(driver, getSortByDropDownOptions("relevance"));
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception occurred while clicking on Sort By Dropdown", e);
		}
	}

	@Step("Verify visibility of Sort By Dropdown options")
	public void verifySortByDropdownOptions(){
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getSortByDropDownOptions("relevance"));
			WaitStatementUtils.explicitWaitForVisibility(driver, getShowDropDownOptions("relevance"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(getShowDropDownOptions("relevance").getText().equals("Relevance"), "Failed to validate 'Relevance' in Sort By dropdown options");
			Assert.assertTrue(getShowDropDownOptions("name").getText().equals("Title"), "Failed to validate 'Title' in Sort By dropdown options");
			Assert.assertTrue(getShowDropDownOptions("sku").getText().equals("Designation"), "Failed to validate 'Designation' in Sort By dropdown options");
			Assert.assertTrue(getShowDropDownOptions("last_updated").getText().equals("Date"), "Failed to validate 'Date' in Sort By dropdown options");
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Sort By Dropdown Options in Search results page in Products and Services tab", e);
		}
	}

	@Step("Verify Search results count on Products and Services tab")
	public void verifySearchResultCount_ProductsServicesTab(){
		try {
			int refinementResultsCount_ProductsServicesTab = getResultsCountInRefinement();
			int countOntab_ProductsServicesTab = getResultsCountFromPAndS();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertEquals(refinementResultsCount_ProductsServicesTab, countOntab_ProductsServicesTab, "Search results count on refinement does not match with count on Products and Services tab");
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Search reults count on Products and Services tab", e);
		}
	}

	@Step("Verify result badge color")
	public void verifyResultsBadgeColor(String BadgeText, String Color){
	try {
		WaitStatementUtils.waitForElementStaleness(driver, getBadge(BadgeText));
		ScreenshotUtil.takeScreenshotForAllure(driver);
		Assert.assertEquals(getBadge(BadgeText).getCssValue("background-color"),Color, BadgeText + " Badge color is not " + Color);
	}
	catch (Exception e){
		e.printStackTrace();
		PublicCommon.reportFailAssert("Failed to Validate the color for " + BadgeText + "Badge", e);
		}
	}

	@Step("Click on First Active Product Link In The Search Results")
	public void clickOnFirstActiveProductInSearchResults(){
		try {
			commonPagePublic = getInstance(CommonPage_Public.class);
			standardProductPagePublic= getInstance(StandardProductPage_Public.class);
			billingAddressPage=getInstance(BillingAddressPage_Public.class);

			WaitStatementUtils.waitForElementStaleness(driver, getElement(ActiveProductOnSearchPage));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ActiveProductOnSearchPage));
			PublicAdminCommons.clickElementByJavaScript(driver,ActiveProductOnSearchPage);
			clickonmethod("Active Product Link On Search Page", ActiveProductOnSearchPage, "Failed to click on Active Product Link On Search Page");
			if(billingAddressPage.isElementDisplayed(getElement(standardProductPagePublic.StayOnPageBtn))) {
				clickOnMethod("Stay on Page Button", getElement(standardProductPagePublic.StayOnPageBtn));
			}
			WaitStatementUtils.waitForElementStaleness(driver, commonPagePublic.AddToCart());
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(commonPagePublic.AddToCart(), driver);
			Assert.assertTrue(commonPagePublic.AddToCart().isDisplayed(), "Failed to click on First Active Product Link In The Search Results");
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click First Active Product Link In The Search Results", e);
		}
	}

	@Step("To validate that the 'Products' and 'Information' pages should be visible to the user related to its search terms when the user lands on the SERP page")
	public void validatePSandInfoTabs() {
		try {
			PublicCommon.waitForSec(10);
			//clickOnMethod("Did you know pop up close button", searchPage.didYouPopUpCloseBtn, "Failed to close pop up");
			Assert.assertTrue(verifyProductsAndServices(),"The products and Services tab is not getting displayed");
			Assert.assertTrue(verifyInformationTab(), "The Information tab is not getting displayed");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Products and Information tabs are not visible after successful search", e);
		}
	}

	@Step("Verifies that the user should see a dropdown for the product versions when the 'Quick Add'  modal is open")
	public void validateVersionDD() {
		try {
			assertTrue(PublicCommon.isWebElementDisplayed(driver, versionDD));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("The version drop down is not getting displayed in the Modal", e);
		}
	}

	@Step("Verifies that the user should see a dropdown for the language selection when the 'Quick Add' modal is open")
	public void validateLanguageDD() {
		try {
			assertTrue(PublicCommon.isWebElementDisplayed(driver, LanguageDD));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("The language drop down is not getting displayed in the modal", e);
		}
	}

	@Step("User should see a dropdown for the format when the modal 'Quick Add' is opened")
	public void validateModalFormat() {
		try {
			assertTrue(PublicCommon.isWebElementDisplayed(driver, FormatDD));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("The format drop down is not getting displayed in the modal", e);
		}
	}

	@Step("Verify Verion, Language and Format dropdown for the product versions when the 'Quick Add'  modal is open")
	public void VerifyVerisonLanguageFormatdd(){
		try{
			validateVersionDD();
			validateLanguageDD();
			validateModalFormat();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to verify Verion, Language and Format dropdown visibility", e);
		}
	}


	@Step("Click on First Doc")
	public void clickOnFirstDOC(String FormatType){
		try{
			billingAddressPage = getInstance(BillingAddressPage_Public.class);
			standardProductPagePublic=getInstance(StandardProductPage_Public.class);
			newMembershipPage =getInstance(MembershipBecomeMemberPage.class);
			commonPagePublic=getInstance(CommonPage_Public.class);

			WaitStatementUtils.waitForElementStaleness(driver, getElement(ActiveProductOnSearchPage));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ActiveProductOnSearchPage));
			PublicAdminCommons.clickElementByJavaScript(driver,ActiveProductOnSearchPage);
			if(billingAddressPage.isElementDisplayed(getElement(standardProductPagePublic.StayOnPageBtn))) {
				clickOnMethod("Stay on Page Button", getElement(standardProductPagePublic.StayOnPageBtn));
			}
			newMembershipPage.handleOneTrustCookie();
			PublicCommon.waitForSec(5);
			clickOnMethod("Select format dd", getElement(FormatDD));
			List<String> FormatdropdownValue = getFormatddlist();
			System.out.println("formatdropdownValue: "+FormatdropdownValue);
			Select sel=new Select(getElement(FormatDD));
			if(FormatType == "Hard Copy") {
				//assertTrue(FormatdropdownValue.contains("Hard Copy"), "Hard copy value present in format dropdown");
				sel.selectByVisibleText("Hard Copy");
			} else if (FormatType == "PDF") {
				//assertTrue(FormatdropdownValue.contains("PDF"), "Hard copy value present in format dropdown");
				sel.selectByVisibleText("PDF");
			} else if (FormatType == "Online - Standard + Redline Bundle") {
				//assertTrue(FormatdropdownValue.contains("Online - Standard + Redline Bundle"), "Hard copy value present in format dropdown");
				sel.selectByVisibleText("Online - Standard + Redline Bundle");
			}
			WaitStatementUtils.waitForElementStaleness(driver, commonPagePublic.AddToCart());
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Click and Open First Doc", e);
		}
	}

	public String getSearchFieldValue(){
		String value = "";
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getElement(searchBox));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			value = getElement(searchBox).getAttribute("value");
			return value;
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get the input value of Search Field", e);
		}
		return value;
	}

	public List<WebElement> getLocator(By locator){
		return getElements(locator);
	}

}
