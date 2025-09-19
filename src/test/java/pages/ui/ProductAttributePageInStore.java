package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ScreenshotUtil;

public class ProductAttributePageInStore extends BasePage{
	ProductPage_PublicAdmin adminProductPages = new ProductPage_PublicAdmin(driver);
	public ProductAttributePageInStore(WebDriver driver) {
		super(driver);
	}
	
	public static By attributeCodeInput = By.xpath("//input[@name='attribute_code']");
	public static By selectSearchAttribute = By.xpath("//*[@id='attributeGrid_table']/tbody[tr][1]");
	public static By storeButton = By.xpath("//*[@id='menu-magento-backend-stores']");
	public static By productLinkUnderAttributes = By.linkText("Product");
	public static By std_item_type_Values = By.xpath("//*[@id='manage-options-panel']/table/tbody/tr[1]/td[3]/input");
	
	public void verifyStoreLandingPage() {
		try {
			PublicCommon.waitForSec(6);
			Assert.assertTrue(adminProductPages.clickPageElement(storeButton), "unable to click on Catalog button");
			Assert.assertTrue(adminProductPages.clickPageElement(productLinkUnderAttributes), "unable to click on Product Linkn");
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}

	}
	
	
}
