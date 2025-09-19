package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;

import com.astm.commonFunctions.IntegrationCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicCommon;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class PTPProductPageCommon_Public extends BasePage {

	public PTPProductPageCommon_Public(WebDriver driver) {
		super(driver);		
	}
	ASTMProficiencyTestingPage_Public productPage;
	HomePage_Public homepage=getInstance(HomePage_Public.class);
	PTPComboProductPage ptpComboProduct=getInstance(PTPComboProductPage.class);
	BillingAddressPage_Public billingAddressPage=getInstance(BillingAddressPage_Public.class);
	CommonPage_Public commonPage;
	PublicSearchPage searchPage;

	private By PTPProductHeader = By.className("page-title");//button[contains(text(),'Committee F42 on Additive Manufacturing Technologi')]
	public By registerForProgramButton = By.xpath("//*[text()='Register for this Program']/ancestor::button");
	public By selectedCommittee = By.xpath("//button[contains(text(),'Committee F42 on Additive Manufacturing Technologi')]");
	public By selectedCommitteeLink = By.xpath("(//a[contains(text(),'Additive Manufacturing Powder Metallurgy')])[3]");
	public By scheduleNameDropDwn = By.xpath("//*[text()='Choose a Program Schedule']/..//following-sibling::div/select");
	public By annualFeeText = By.xpath("//div[contains(text(),'2022 Annual Fee: ')]");
	public By checkboxForAdditiveProg = By.xpath("//tbody/tr[5]/th[1]/div[1]/label[1]");
	public By checkboxForPolypropyleneTesting = By.xpath("//tbody/tr[2]/th[1]/div[1]/label");
	public By AdditiveManufacturingText = By.xpath("(//a[contains(text(),'Additive Manufacturing Powder Metallurgy') and '(2022)'])[1]");
	public By PolypropyleneTestingText = By.xpath("(//a[contains(text(),'Polypropylene Testing') and '(2022)'])[1]");
	
	
	public By registerForMultipleProgramsButton = By.xpath("//*[@title='Register for Multiple Programs']");
	public By shoppingCartLink = By.xpath("//a[text()='shopping cart']");
	public By Cart_Header = By.className("cart-title");

	private By productDetails = By.xpath("//*[@class='product-info-main w-100']");

	private By accreditedHeader = By.xpath("//*[@class='accredited-container d-md-flex py-4 mt-4']//*[@class='astm-type-heading--h4']");
	private By accreditedImage = By.xpath("//*[@class='accredited-container d-md-flex py-4 mt-4']//img");
	private By accreditedSectionSection = By.xpath("//div[@class='accredited-container d-md-flex py-4 mt-4']");
	private By interactiveTableOfContent = By.xpath("//*[@class='sections-links astm-type-body--lead mt-4 pt-4']");;
	private By interactiveTableOfContentLinks = By.xpath("//*[@class='sections-links astm-type-body--lead mt-4 pt-4']//a");

	private By contentsHeading = By.xpath("//*[starts-with(@id,'heading')]//*[@class='astm-type-heading--h4']");
	private By contactUsAboutProgram = By.xpath("//a[text()='contact us']");
	
	public By suggestProgram = By.partialLinkText("Suggest a program");
	public By errorMessageMaxLimit = By.xpath("//*[contains(text(),'Only 1 PTP program allowed in the cart') or contains(text(),'Only 1 PTP program is allowed in the cart.')]");
	public By errorMessageConflicts = By.xpath("//*[text()='We are sorry. This product conflicts with a product currently in your cart. To add this product, you must first clear your cart. Please ']");
	public By fullList = By.xpath("//button[contains(text(),'Full List')]");
	public By committeeOnPlastic = By.xpath("//button[contains(text(),'Committee D20 on Plastics')]");
	public By annualFeeScheduleText = By.xpath("//div[3]/div[contains(text(),'2022 Annual Fee:')]");
	public By genericSDS = By.linkText("Generic SDS");
	public By shippingSpecifications = By.linkText("Shipping Specifications");
	public By productsAndServicesNavigation = By.xpath("(//*[@id='productsDropdownMenuLink'])[1]");


	public By getAccreditedSectionSection() {
		return accreditedSectionSection;
	}
	public WebElement getErrorMessageMaxLimit() {
		return getElement(errorMessageMaxLimit);
	}
	
	public WebElement getErrorMessageConflicts() {
		return getElement(errorMessageConflicts);
	}
	public WebElement getSelectedCommittee() {
		return getElement(selectedCommittee);
	}
	public WebElement getSelectedCommitteeLink () {
		return getElement(selectedCommitteeLink);
	}

	public boolean clickOnShoppingCartLink() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(shoppingCartLink));
			PublicCommon.JSClick(getElement(shoppingCartLink), driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public WebElement registerForProgramButton() {
		return getElement(registerForProgramButton);
	}
	
	public boolean clickSuggestAProgramLink() 
	{
		try {
			getElement(suggestProgram).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}	
	}
	

	public boolean contactUsLinkVisibility() {
		try {
			return (getElements(contactUsAboutProgram).size() > 0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean gotoInteractiveTable() {
		try {
			ReusableMethods.scrollIntoView(getElement(interactiveTableOfContent), driver);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public WebElement getshoppingCartLink() {
	return getElement(shoppingCartLink);
		}
	public List<WebElement> getContentHeadings() {

		try {
			return getElements(contentsHeading);

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public List<String> getLinksTextForTableOfContents(){
		try {
			List<String> contentTextList = new ArrayList<String>();
			List<WebElement> linksList = getTableOfContentLinkElements();

			ReusableMethods.scrollIntoView(getElement(interactiveTableOfContent), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			int links = getElements(interactiveTableOfContentLinks).size();

			for(int i=0; i < links; i++) {
				contentTextList.add(linksList.get(i).getText());
			}
			return contentTextList;

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getTableOfContentLinkElements() {

		try {
			return getElements(interactiveTableOfContentLinks);

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public String getAccreditedHeaderText() {
		try {
			return getElement(accreditedHeader).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getAccreditedImageInfo() {
		try {
			return getElement(accreditedImage).getAttribute("src");
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getProductInformation() {
		try {
			return getElement(productDetails).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean shoppingCartLinkShow() {
		try {
			return (getElements(shoppingCartLink).size() > 0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean clickShoppingCartLink() 
	{
		try {
			getElement(shoppingCartLink).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}	
	}

	public boolean clickShoppingCartLink_Header() 
	{
		try {
			getElement(Cart_Header).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	public boolean clickRegisterForProgramButton() 
	{
		try {
			getElement(registerForProgramButton).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;

		}	
	}
	
	public BulkOrder_Page clickRegisterForMultipleProgramButton() 
	{
		try {
			getElement(registerForMultipleProgramsButton).click();
			return getInstance(BulkOrder_Page.class);
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;

		}	
	}

	public String getPTPProductHeader() 
	{
		try {
			return getElement(PTPProductHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
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

	public boolean waitForVisible(WebDriver driver, By shoppingCartLink2, int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Step("Select any program from list of Multiple PTP Programs")
	public void selectPTPprogram(String CommitteName, String productName) {
		try{
			productPage = getInstance(ASTMProficiencyTestingPage_Public.class);
			commonPage = getInstance(CommonPage_Public.class);
			ReusableMethods.scrollIntoView(getElement(productPage.committeeLink(CommitteName)), driver);
			PublicCommon.JSClick(getElement(productPage.committeeLink(CommitteName)), driver);
			PublicCommon.waitForSec(5);
			assertTrue(IntegrationCommon.isWebElementDisplayed(driver, productPage.productLink(CommitteName, productName)), "Failed to display PTP product");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(productPage.productLink(CommitteName, productName)));
			clickonmethod(productName,  productPage.productLink(CommitteName, productName), "Couldn't click on selected product");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(commonPage.RegisterProgramBtnInPTPpage));
			clickonmethod("Register for the Program", commonPage.RegisterProgramBtnInPTPpage, "Couldn't click on Register for the program button");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select any program from list of Multiple PTP Programs", e);
		}
	}

	public void getPTPProduct()
	{
		try {
			commonPage = getInstance(CommonPage_Public.class);
			searchPage = getInstance(PublicSearchPage.class);
			homepage.navigateToHomeLink("Standards & Solutions", "PT Program List",2,4);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertEquals(commonPage.getElement(commonPage.PTPheader).getText(), "ASTM Proficiency Testing Programs (PTP)");
			Assert.assertTrue(commonPage.clickAndExpand("Full List"),"Full List should be Clicked");
			String ProgramName = commonPage.selectProgramByIndex(3).getText();
			commonPage.selectProgramByIndex(3).click();
			Assert.assertEquals(commonPage.getElement(commonPage.PTPprogramPage).getText(),ProgramName);
			PublicCommon.waitForSec(5);
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver,commonPage.getElement(commonPage.RegisterProgramBtnInPTPpage),30);
			clickOnMethod("Register for this Program", commonPage.getElement(commonPage.RegisterProgramBtnInPTPpage));
			assertTrue(searchPage.verifyText(searchPage.ShoppingCartMessage).contains("You added "+ProgramName+" to your"));
			PublicCommon.waitForSec(10);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to select PTP Product ", e);

		}
	}

}
