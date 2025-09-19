package pages.ui;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;

public class PDPProductPage extends BasePage{
	public PDPProductPage(WebDriver driver) {
		super(driver);
	}
	ProductPage_PublicAdmin adminProductPages = getInstance(ProductPage_PublicAdmin.class);
	PublicCommon commonMethod=new PublicCommon(driver);
	
	public static By searchProductInputField= By.xpath("//input[@id='search']");
	public static By signInFrontEnd = By.xpath("//*[@class='fas fa-user-circle mr-2']");
	public static By signInLInk = By.linkText("Sign In");
	public static By searchIcon = By.xpath("//*[@id='search_mini_form']/div[2]/div/button");
	public static By logo = By.xpath("//*[@class='navbar-brand']");
	public static By infoPopUp = By.xpath("//*[@id='fvpp-close' or @class='astm-icon astm-icon--black far fa-times']");
	public static By searchedProductLink =By.xpath("//*[@class='product-item-link']");
	public static By moreInfoTab =By.xpath("//*[@id='tab-label-additional-title']");
	public static By searchedProductEBSLink =By.xpath("//table[@id='product-attribute-specs-table']/tbody/tr/td[@data-th='EBS_SKU']");
	public static By ebsLink = By.xpath("//*[@class='mt-4']/span[@class='astm-type-body--lead']/b");
	public static By pubChildProductLink = By.xpath("//*[@id='maincontent']/div[4]/div[2]/div[6]/div[1]/div/ol/li/div/div/strong/div/a");
	public static By pcVhildProdLink = By.xpath("//*[@class='astm-type-body--lead title-text-bold']/b");
	public static By productSKUName = By.xpath("//*[@class='astm-type-body--lead']/b");
	public static By addToCartButton = By.xpath("//button/span[text()=' Add to Cart']");
	public static By contactSalesLink = By.linkText("Contact Sales");
	public static By productNotFoundMessage = By.xpath("//*[@class='astm-type-heading--h2 myt5 mb-3']");
	public static By productCountOnWeb = By.xpath("//*[@class='view']/p/b");
	public static By productAndService = By.xpath("//*[@id='productsDropdownMenuLink']");
	public static By faqButton = By.xpath("//*[text()='FAQ']");
	public static By standardAndPublicationLink = By.xpath("//*[@id=\"main-nav\"]/div/ul/li[1]/div/ul[1]/li[2]/div/a");
	public static By journalsLink = By.xpath("//*[@id=\"main-nav\"]/div/ul/li[1]/div/ul[1]/li[2]/div/ul/li[6]/a");
	public static By acemLink = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[1]/div/section/div[3]/div[1]/div[2]/p[1]/a");
	public static By subscriptionTabUnderACEM = By.xpath("//*[@id='subscription-tab']");
	public static By productBadgeOnPDP = By.xpath("//div[@class='d-flex align-items-center']/span[@class='badge astm-badge bg-secondary']");
	public static By descp = By.xpath("//*[@class='row p-1']");
	public static By assetIDValue = By.xpath("//input[@name='product[asset_id]']");
	public static By pdpID=By.xpath("//div[@class='col-md-8']/div[@class='mt-4']/span");
	public static By assetTypeValue = By.xpath("//input[@name='product[asset_type]']");
	public By productClassificationBadge = By.xpath("//*[@class='badge astm-badge bg-secondary']");
	public static By PTPBadge = By.xpath("//*[@class='custom-control-inline stand-btn']");
	public By productDescription = By.xpath("//div[@class='astm-type-body--lead border-top mt-3 pt-3']/div/p");
	public By participatingPrice = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[1]/div/div[1]/p");
	public By orgnaizationalPrice = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[1]/div/div[2]/p");
	public By informationalPrice = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[1]/div/div[3]/p");
	public By studentMembershipPrice = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[1]/div/div[4]/p");
	public By subscriptionTab  =By.xpath("//*[@id='subscription-tab']");
	public static By institutionalPrice = By.xpath("//*[@id=\"subscription\"]//div[@class='col-md-6'][2]/p[4]");
	public static By individualPrice = By.xpath("//*[@id=\"subscription\"]//div[@class='row mt-4 mb-4']//div[@class='col-md-6'][1]//p[4]");
	public static By lastUpdatedValueAtrWebsite = By.xpath("//*[contains(@class,'ml-3 mr-1 last-updated')]");
	public static By redlineInfoText = By.xpath("//*[@class='redline-info-text']");
	public static By redlinePopup = By.xpath("//*[@id='redline-popup']");
	public static By redlinePopUptext = By.xpath("//*[@class='modal-body-wrapper redline-info-help-content']");
	public static By priceForTPTAtFrontEnd = By.xpath("//*[@class='tpt_product_info_price d-flex mb-3']");
	public static By badgeWithPublishedDate = By.xpath("//*[@class='ml-3 pl-3 border-left']");
	public static By DocumentHeading = By.xpath("//*[contains(@class,'astm-type-heading')]/b");
	public boolean openNewTabAndSwitch(WebDriver driver) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); // switches to new tab
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
            return false;
        }
    }
	
	public void verifyProductSKUAndAddToCart(String expectedResult) {
		try {
			String actualResult=adminProductPages.getElement(PDPProductPage.productSKUName).getText();
			Assert.assertTrue(actualResult.contains(expectedResult), "Product is not matched");
			Assert.assertTrue(adminProductPages.getElement(PDPProductPage.addToCartButton).isDisplayed(), "Add to cart button is displayed");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }
	}
	
	public void verifyProductSKUAndContactSales(String actualResult) {
		try {
			String expectedResult=adminProductPages.getElement(PDPProductPage.productSKUName).getText();
			Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult), "Product is not matched");
			Assert.assertTrue(adminProductPages.getElement(PDPProductPage.contactSalesLink).isDisplayed(), "Contact sales link is not displayed");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }
	}
	
	public void goToJournalsProduct() {
		try {
			ReusableMethods.mouseHover(driver,adminProductPages.getElement(PDPProductPage.productAndService),"");
			ReusableMethods.mouseHover(driver,adminProductPages.getElement(PDPProductPage.standardAndPublicationLink), "");
			ReusableMethods.mouseHoverAndClick(driver,adminProductPages.getElement(PDPProductPage.journalsLink), "");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }	
	}
	
	public List<String> verifPriceForIndividualAndInstitutional() {
		
			PublicCommon.waitForSec(5);
			ReusableMethods.scrollIntoView(adminProductPages.getElement(PDPProductPage.acemLink), driver);
			Assert.assertTrue(adminProductPages.clickPageElement(PDPProductPage.acemLink), "ACEM link not available");
			Assert.assertTrue(adminProductPages.clickPageElement(PDPProductPage.subscriptionTabUnderACEM), "Subscription tab is not available");
			PublicCommon.waitForSec(2);
			String[] institutionalPrice= PublicCommon.getText(driver,PDPProductPage.institutionalPrice).split(":");
			String[] individualPrice= PublicCommon.getText(driver, PDPProductPage.individualPrice).split(":");
			String actualInstitutionalPrice=institutionalPrice[1].replaceAll("\\s", "");
			String actualIndividualPrice=individualPrice[1].replaceAll("\\s", "");
			List<String> priceList = new ArrayList<String>();
			priceList.add(actualIndividualPrice);
			priceList.add(actualInstitutionalPrice);
			return priceList;		
	}
	
	public void verifyProductNotAvailableByURL(String expectedresult) {
		try {
			String actualResult=commonMethod.getText(adminProductPages.getElement(PDPProductPage.productNotFoundMessage));
			Assert.assertTrue(actualResult.equalsIgnoreCase(expectedresult), "Product is available");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }		
	}

	
	public String verifyProductClassificationOnPDPAsBadge() {
		try {
			String productClassificationOnPDP = adminProductPages.getElement(PDPProductPage.PTPBadge).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return productClassificationOnPDP;
		}
		catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }	
		return "Value not found";
	}
	
	public String verifyDescriptionOnPDP() {
		try {
			String description=adminProductPages.getElement(PDPProductPage.descp).getText().replaceAll(" ", "");
			System.out.println(description);
			ScreenshotUtil.takeScreenshotForAllure(driver);			
			return description;
		}
		catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }
		return "";
	}

}
