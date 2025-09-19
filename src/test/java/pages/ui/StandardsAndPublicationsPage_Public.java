package pages.ui;

import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import org.testng.Assert;

public class StandardsAndPublicationsPage_Public extends BasePage{

	PublicSearchPage publicSearchPage;
	
	public StandardsAndPublicationsPage_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By searhBox = By.xpath("//*[@id='search-box__standards']//input");
	private By searchBoxPlaceHolderTerm = By.xpath("//*[@id='search-box__standards']//*[@class='form-inline']//input[contains(@placeholder, 'Search term')]");
	private By searchBoxGoButton = By.xpath("//form[@id='search-box__standards']//span[text()='Go']");

	public By getCovid19Btn() {
		return covid19Btn;
	}

	private  By covid19Btn = By.xpath("//div[@role=\"tablist\"]//span[text()='COVID 19']/..");
	/**
	 * 
	 * @return- boolean: Presence of expected elements on landing to the Standards and Publications page
	 */
	@Step("Landed on the Standards And Publications Page.")
	public boolean validateLandingPageOnNavigation () {
		boolean landingPage = false;
		try {
			landingPage = this.getElement(searhBox).isDisplayed(); //&& this.getElement(searchBoxGoButton).isDisplayed()); 
			return landingPage;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}
	
	@Step("Get 'Standards And Publications' page url.")
	public String getStandardsAndPublicationsPageUrl() 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains("/standards-and-publications"));
			
			return driver.getCurrentUrl();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	/**
	 * 
	 * @return
	 */
	@Step("Presence of 'Go' Button and Search Place Holder Text on Page.")
	public boolean validateSearchSectionOnPage () {
		boolean landingPage = false;
		try {
			landingPage = (this.getElement(searchBoxPlaceHolderTerm).isDisplayed() && this.getElement(searchBoxGoButton).isDisplayed()); 
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return landingPage;
	}

	@Step("Search for {SearchTopic} in Standards And Publications Page")
	public void searchTopicOnStandardsAndPublicationsPage(String SearchTopic){
		try {
			publicSearchPage = getInstance(PublicSearchPage.class);

			WaitStatementUtils.waitForElementStaleness(driver, getElement(searhBox));
			clickonmethod("Search Box", searhBox, "failed to click on Search Box");
			IntegrationCommon.clearTxtFieldsendKeys(driver, searhBox, SearchTopic);
			Assert.assertTrue(getElement(searhBox).getAttribute("value").equals(SearchTopic));
			WaitStatementUtils.waitForElementStaleness(driver, getElement(searchBoxGoButton));
			clickonmethod("Search Box Go Button", searchBoxGoButton, "failed to click on Search Box Go Button");
			new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("catalogsearch/result"));
			WaitStatementUtils.waitForElementStaleness(driver, getElement(publicSearchPage.refinementTab));
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(publicSearchPage.refinementTab));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(publicSearchPage.verifyRefinementTab(), "Refinement Tab not visible");
		}
		catch ( Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to search for '" + SearchTopic + "' in Standards And Publications page", e);
		}
	}
}
