package pages.ui;

import base.utils.ReusableMethods;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.List;

public class IronAndSteelProductsPage_Public extends BasePage {

	
	public IronAndSteelProductsPage_Public(WebDriver driver) {
		super(driver);		
		} 
	
	
	private By ironAndSteelProductsHeader = By.className("page-title");
	private By willShipAsPublishedText = By.xpath("//*[text()='Published: Will ship as published.']");
	
	private By volumesList = By.cssSelector("div[class*='volumes-list'] a");
	
	private By productTable = By.id("super-product-table");
	
	private By formatHeader = By.cssSelector("div[class='table-wrapper section'] th[class='col item']");
	public By mobileformatHeader = By.cssSelector("div[class='table-wrapper section'] td[data-th='Format']");
	private By formatColumnFirstValue = By.cssSelector("tr[class='product product-virtual'] td[class='col item']");
	private By formatColumnSecondValue = By.cssSelector("tr[class='product product-simple']:nth-child(2) .product-item-name");
	private By formatColumnThirdValue = By.cssSelector("tr[class='product product-simple']:nth-child(3) .product-item-name");

	private By publishDateHeader = By.cssSelector("div[class='table-wrapper section'] th[class='col pub-date']");
	public By mobilepublishDateHeader = By.cssSelector("div[class='table-wrapper section'] td[data-th='Publish Date']");
	private By publishDateSecondValue = By.cssSelector("tr[class='product product-simple']:nth-child(2) td[class='col pub-date']");
	private By publishDateThirdValue = By.cssSelector("tr[class='product product-simple']:nth-child(3) td[class='col pub-date']");
	
	private By priceHeader = By.cssSelector("div[class='table-wrapper section'] th[class='col price']");
	public By mobilepriceHeader = By.cssSelector("div[class='table-wrapper section'] td[data-th='Price']");
	private By priceColumnFirstValue = By.cssSelector("tr[class='product product-virtual'] td[class='col price']");
	private By priceColumnSecondValue = By.cssSelector("tr[class='product product-simple']:nth-child(2) td[class='col price']");
	private By priceColumnThirdValue = By.cssSelector("tr[class='product product-simple']:nth-child(3) td[class='col price']");
	
	
	public By contactSalesButton = By.xpath("//span[text()='Contact Sales']/..");
	private By addToCartButtonFirst = By.xpath("(//i[contains(@class,'fa-shopping-cart')])[1]");
	private By addToCartButtonSecond = By.xpath("(//i[contains(@class,'fa-shopping-cart')])[2]");
	private By addToCartButton2017= By.xpath("//td[contains(text(),'2019')]//following::span[text()=' Add to Cart']");
	
	private By ASTMLicenseAgreementLink = By.linkText("ASTM License Agreement");
	private By tableContentsList = By.xpath("//table[@class='table data section contents']//td");
	
	private By addToCardSuccessMessage = By.cssSelector("*[class='prepare-message astm-alert-text']");
	
	private By licenseAgreementLabel = By.id("licenseAgreementLabel");
	
	private By shoppingCartLink = By.linkText("shopping cart");
	private By errorMessage = By.xpath("//div[text()='Invalid Form Key. Please refresh the page.']");
	
	
	
	public List<WebElement> getVolumesListElements() { return
			  getElements(volumesList); }
		
	public List<WebElement> getTableContentsListElements() { return
			  getElements(tableContentsList); }
	
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
		
	public WebElement getASTMLicenseAgreementLink() 
	{	return getElement(ASTMLicenseAgreementLink);
		}
	
	public WebElement getErrorMessage() 
	{	return getElement(errorMessage);
		}
	
	public WebElement getAddToCardSuccessMessageWebelement() 
	{	return getElement(addToCardSuccessMessage);
		}
	
	public WebElement getShoppingCartLinkWebelement() 
	{	try{
		//WaitStatementUtils.waitForElementStaleness(driver, getElement(shoppingCartLink));
		return getElement(shoppingCartLink);
	}catch (StaleElementReferenceException e) {
		getShoppingCartLinkWebelement();
		return getElement(shoppingCartLink);
	}
		}
	
	@Step("Check Error message's Visibility.")
	public boolean checkErrorMessageIsVisible() 
	{
		try {
			return getElement(errorMessage).isDisplayed();
		}
		catch (NoSuchElementException e ) {
			return false;
		}	
		catch (NullPointerException e ) {
			return false;
		}	
	}
	
	
//	@Step("Check List of Volumes.")
//	public Boolean verifyBOSSectionList(List<String> expectedList) {
//
//		try {
//			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getBookOfStandardsSectionsList(), driver);
//			System.out.println(actualList);
//			return actualList.equals(expectedList);
//		} catch (Exception e) {
//			e.getStackTrace();
//			return false;
//		}
//	}

	@Step("Get License Agreement Label text.")
	public String getLicenseAgreementHeaderText() 
	{
		try {
			return getElement(licenseAgreementLabel).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	

	@Step("Get 'Add To Cart' success message.")
	public String getAddToCartSuccessMessage() 
	{
		try {
			
			return getElement(addToCardSuccessMessage).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Click Previous Year's Add To Cart Button")
	public void clickPreviousYearAddToCartButton() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(productTable), driver);
			//ReusableMethods.mouseHoverAndClick(driver, getElement(addToCartButtonFirst), "Hover over Add to cart button for previous year");
			 getElement(addToCartButtonFirst).click();
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
//	@Step("Click Current Year's Add To Cart Button")
	public boolean clickCurrentYearAddToCartButton() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(productTable), driver);
			//Product not available on Iron and Steel Page to overcome that we are selecting First Product. Just uncomment the below Line if required.
			//ReusableMethods.mouseHoverAndClickWithAction(driver, getElement(addToCartButtonSecond), "Hover over Add to cart button for current year");
			ReusableMethods.mouseHoverAndClickWithAction(driver, getElement(addToCartButtonSecond), "Hover over Add to cart button for current year");
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		return false;	
	}
	
	public boolean click2017YearAddToCartButton() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(productTable), driver);
			ReusableMethods.mouseHoverAndClickWithAction(driver, getElement(addToCartButton2017), "Hover over Add to cart button for 2017 year");
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		return false;	
	}
	public boolean clickOnFirstAddToCartButton() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(productTable), driver);
			ReusableMethods.mouseHoverAndClickWithAction(driver, getElement(addToCartButtonFirst), "Hover over Add to cart button");
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		return false;	
	}
	
	
	
	//@Step("Click Shopping Cart Link.")
	public boolean clickShoppingCartLink() 
	{
		try {
			 getShoppingCartLinkWebelement().click();
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}	
	}
	
	
	@Step("Click Contact Sales Button")
	public ContactSalesForcePage_Public clickContactSalesButton() 
	{
		try {
			 getElement(contactSalesButton).click();
			 return getInstance(ContactSalesForcePage_Public.class);
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
			// TODO: handle exception
		}	
	}
	
	
	
	@Step("Get List of Volumes.")
	public List<String> getVolumesList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getVolumesListElements(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	@Step("Get List of Table Contents.")
	public List<String> getTableContentsList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getTableContentsListElements(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
//	
	
	
	@Step("Scroll to View 'Published: Will ship as published.' Header on the page.")
	public void scrollToWillShipAsPublishedHeader() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(willShipAsPublishedText), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	@Step("Scroll to View 'Product Table' on the page.")
	public void scrollToProductTable() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(productTable), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	
	
	@Step("Get 'Iron And Steel Products' Header text.")
	public String getIronAndSteelProductsHeaderText() 
	{
		try {
			return getElement(ironAndSteelProductsHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Will Ship As Published' Header text.")
	public String getWillShipAsPublishedHeaderText() 
	{
		try {
			return getElement(willShipAsPublishedText).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Format' Header text in product table.")
	public String getFormatHeaderText() 
	{
		try {
			return getElement(formatHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get Format Column's First Value in product table.")
	public String getFormatColumnFirstValue() 
	{
		try {
			return getElement(formatColumnFirstValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get Format Column's Second Value in product table.")
	public String getFormatColumnSecondValue() 
	{
		try {
			return getElement(formatColumnSecondValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get Format Column's Third Value in product table.")
	public String getFormatColumnThirdValue() 
	{
		try {
			return getElement(formatColumnThirdValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	

	@Step("Get 'Publish Date' Header text in product table.")
	public String getPublishDateHeaderText() 
	{
		try {
			return getElement(publishDateHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	
	@Step("Get Publish Column's Second Value in product table.")
	public String getPublishColumnSecondValue() 
	{
		try {
			return getElement(publishDateSecondValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get Publish Column's Third Value in product table.")
	public String getPublishColumnThirdValue() 
	{
		try {
			return getElement(publishDateThirdValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get 'Price' Header text in product table.")
	public String getPriceHeaderText() 
	{
		try {
			return getElement(priceHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get Price Column's First Value in product table.")
	public String getPriceColumnFirstValue() 
	{
		try {
			return getElement(priceColumnFirstValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get Price Column's Second Value in product table.")
	public String getPriceColumnSecondValue() 
	{
		try {
			return getElement(priceColumnSecondValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Get Price Column's Third Value in product table.")
	public String getPriceColumnThirdValue() 
	{
		try {
			return getElement(priceColumnThirdValue).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	@Step("Check 'Contact Sales' button is present.")
	public boolean checkContactSalesButtonIsPresent() 
	{
		try {
			return getElement(contactSalesButton).isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}	
	}
	
/**
 * Check the Size of the List is Greater Than Zero
 * @param locator
 * @return True/False
 */
	public boolean checkSizeOfListIsGreaterThanZero(By locator) 
	{
		try {
			if(getElements(locator).size()>0) 
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
