
package pages.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

public class BookOfStandardsPage_Public extends BasePage {

	
	public BookOfStandardsPage_Public(WebDriver driver) {
		super(driver);		
		} 
	
	public By annualBookOfASTMStandardsHeader = By.xpath("//*[text()='Annual Book of ASTM Standards']");
	
	private By BOSBookImage = By.cssSelector("img[src*='BOS_Book']");
	private By BOSLaptopImage = By.cssSelector("img[src*='OS_BOS']");
	public By BOSTabletImage = By.cssSelector("img[src*='BOS_tablet']");
	
	private By bookOfStandardsSectionHeader = By.xpath("//h2[text()='Book of Standards Section']");
	private By bookOfStandardsSectionsList = By.xpath("//h2[text()='Book of Standards Section']/following-sibling::div//li/a");
	
	private By browseBySectionHeader = By.xpath("//h2[text()='Browse By']");
	
	private By BOSStandardsByCategoryImage = By.cssSelector("img[src*='bos-standards-by-category']");
	private By standardsByCategoryText = By.xpath("//h3[text()='Standards by Category']");
	private By standardsByCategoryDescription = By.xpath("//h3[text()='Standards by Category']/following-sibling::p");
	private By browseByCategoryButton = By.xpath("//h3[text()='Standards by Category']/..//a");
		
	private By BOSCompilationsImage = By.cssSelector("img[src*='bos-compilations']");
	public By compilationsText = By.xpath("//h3[text()='Compilations']");
	private By compilationsDescription = By.xpath("//h3[text()='Compilations']/following-sibling::p");
	private By browseCompilationsButton = By.xpath("//h3[text()='Compilations']/..//a");
	
	
	private By ASTMCompassImage = By.cssSelector("img[src*='bos-compass']");
	public By ASTMCompassText = By.xpath("//h3[text()='ASTM Compass®']");
	private By ASTMCompassDescription = By.xpath("//h3[text()='ASTM Compass®']/following-sibling::p");
	private By learnMoreAboutCompassButton = By.xpath("//h3[text()='ASTM Compass®']/../a");
	
	private By productAlertsHeader = By.cssSelector("#bos-productalert h3");
	private By productAlertsDescription = By.cssSelector("#bos-productalert p");
	private By signupForProductAlertsButton = By.xpath("//a[contains(text(),'Sign up for Product Alerts')]");
	public By chooseSection = By.xpath("//a[contains(text(),'Section 4 - Construction')]");
	public By BuildingSealsAndSealants = By.xpath("//a[contains(text(),'ASTM Volume 04.07: Building Seals And Sealants; Fi')]");
	public By Building1 = By.xpath("//tbody/tr[1]/td[4]/form[1]/button[1]/span[1]");
	
	private By scrollDownArrowToBrowseBySection = By.cssSelector("a[href='#bos-browseby']");
	private By scrollDownArrowToProductAlertsSection = By.cssSelector("a[href='#bos-productalert']");
	private By volumesList = By.cssSelector("*[class='volumes-list mt-3'] a");
	
	public List<WebElement> getVolumesList() { return
			  getElements(volumesList); }
	
	public List<WebElement> getBookOfStandardsSectionsList() { return
			  getElements(bookOfStandardsSectionsList); }
		
	public WebElement getAnnualBookOfASTMStandardsHeader() 
	{	return getElement(annualBookOfASTMStandardsHeader);
		}
	
	public WebElement getBOSSection(String productName) 
	{	return getElement(By.xpath("//*[@class='standards-bos landing-page']//a[text()='"+productName+"']"));
		}
	
	public WebElement getBOSVolume(String productName) 
	{	return getElement(By.xpath("//a[contains(text(),'"+productName+"')]"));
		}
	
	@Step("Click 'Scroll Down Arrow' that heads to BrowseBy Section .")
	public void clickScrollDownArrowToBrowseBySection() 
	{
		try {
			 getElement(scrollDownArrowToBrowseBySection).click();
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	@Step("Click 'Scroll Down Arrow' that heads to Product Alerts Section .")
	public void clickScrollDownArrowToProductAlertsSection() 
	{
		try {
			 getElement(scrollDownArrowToProductAlertsSection).click();
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	
	@Step("Check BOS sections' list.")
	public Boolean verifyBOSSectionList(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getBookOfStandardsSectionsList(), driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
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
	
	@Step("Scroll to View 'Annual Book of ASTM Standards' Header on the page.")
	public void scrollToAnnualBookOfASTMStandardsHeader() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(annualBookOfASTMStandardsHeader), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	@Step("Scroll to View 'Books Of Standards' Header on the page.")
	public void scrollToBooksOfStandardsHeader() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(bookOfStandardsSectionHeader), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	@Step("Scroll to View 'Browse By' Header on the page.")
	public void scrollToBrowseByHeader() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(browseBySectionHeader), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	@Step("Scroll to View 'Product Alerts' Header on the page.")
	public void scrollToProductAlertsHeader() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(productAlertsHeader), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	
		
	
	@Step("Get 'Annual Book of ASTM Standards' Header text.")
	public String getAnnualBookOfASTMStandardsHeaderText() 
	{
		try {
			return getElement(annualBookOfASTMStandardsHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Books Of Standards' Header text.")
	public String getBooksOfStandardsHeaderText() 
	{
		try {
			return getElement(bookOfStandardsSectionHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Browse By' Header text.")
	public String getBrowseByHeaderText() 
	{
		try {
			return getElement(browseBySectionHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Product Alerts' Header text.")
	public String getProductAlertsHeaderText() 
	{
		try {
			return getElement(productAlertsHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Check 'BOS Book' Image is visible.")
	public boolean verifyBOSBookImageIsVisible() 
	{
		try {
			return getElement(BOSBookImage).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	@Step("Check 'BOS Laptop' Image is visible.")
	public boolean verifyBOSLaptopImageIsVisible() 
	{
		try {
			return getElement(BOSLaptopImage).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	@Step("Check 'BOS Tablet' Image is visible.")
	public boolean verifyBOSTabletImageIsVisible() 
	{
		try {
			return getElement(BOSTabletImage).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	@Step("Check 'BOS Standards By Category' Image is visible in 'Browse By' section.")
	public boolean verifyBOSStandardsByCategoryImageIsVisible() 
	{
		try {
			return getElement(BOSStandardsByCategoryImage).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	@Step("Check 'BOS Compilations' Image is visible in 'Browse By' section.")
	public boolean verifyBOSCompilationsImageIsVisible() 
	{
		try {
			return getElement(BOSCompilationsImage).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	@Step("Check 'ASTM Compass' Image is visible in 'Browse By' section.")
	public boolean verifyASTMCompassImageIsVisible() 
	{
		try {
			return getElement(ASTMCompassImage).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Standards By Category' text in 'Browse By' section.")
	public String getStandardsByCategoryText() 
	{
		try {
			return getElement(standardsByCategoryText).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Compilations' text in 'Browse By' section.")
	public String getCompilationsText() 
	{
		try {
			return getElement(compilationsText).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'ASTM Compass' text in 'Browse By' section..")
	public String getASTMCompassText() 
	{
		try {
			return getElement(ASTMCompassText).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Check 'Standards By Category' Description text.")
	public boolean verifyStandardsByCategoryDescriptionText(String expectedDescription) 
	{
		try {
			return getElement(standardsByCategoryDescription).getText().equals(expectedDescription);
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	@Step("Check 'Compilations' Description text.")
	public boolean verifyCompilationsDescriptionText(String expectedDescription) 
	{
		try {
			return getElement(compilationsDescription).getText().equals(expectedDescription);
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
	@Step("Check 'ASTM Compass' Description text.")
	public boolean verifyASTMCompassDescriptionText(String expectedDescription) 
	{
		try {
			return getElement(ASTMCompassDescription).getText().equals(expectedDescription);
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
		
	@Step("Get 'Product Alerts' Description text.")
	public String getProductAlertsDescriptionText() 
	{
		try {
			return getElement(productAlertsDescription).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Check 'Browse By Category'  button is clickable and get text on button.")
	public String getBrowseByCategoryButtonText() 
	{
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(browseByCategoryButton));
			return getElement(browseByCategoryButton).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Check 'Browse Compilations'  button is clickable and get text on button.")
	public String getBrowseCompilationsButtonText() 
	{
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(browseCompilationsButton));
			return getElement(browseCompilationsButton).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Check 'Signup For Product Alerts'  button is clickable and get text on button.")
	public String getSignupForProductAlertsButtonText() 
	{
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(signupForProductAlertsButton));
			return getElement(signupForProductAlertsButton).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	
	@Step("Get 'Learn more about Compass'  button is clickable and get text on button.")
	public String getASTMProductLearnButtonText() 
	{
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(learnMoreAboutCompassButton));
			return getElement(learnMoreAboutCompassButton).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
}
