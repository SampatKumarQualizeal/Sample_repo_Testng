package pages.ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ScreenshotUtil;
import io.qameta.allure.Step;

public class MagentoLoginAndVerifyDashboardPage extends BasePage{
	ProductPage_PublicAdmin adminProductPages = new ProductPage_PublicAdmin(driver);
	public MagentoLoginAndVerifyDashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static By SignInViaOKTAButton = By.xpath("//*[@id='sign-in-via-okta-form']/fieldset/div/div/button");
	public static By userName = By.id("userName");
	public static By password = By.id("encPass");
	public static By signInButton = By.xpath("//button[@type='submit' and contains(., 'Sign In')]");
	public static By catalogButton = By.xpath("//*[@id='menu-magento-catalog-catalog']");
	public static By productLink = By.linkText("Products");
	
	@Step("Login to Magento and enter valid credentials")
	public void login(String userAccount, String userPwd) {
		try {
			PublicCommon.waitForSec(6);
			MembershipBecomeMemberPage newMembership = getInstance(MembershipBecomeMemberPage.class);
			Assert.assertTrue(adminProductPages.clickPageElement(SignInViaOKTAButton), "unable to click on Sign in via OKTA button");
			newMembership.handleOneTrustCookie();
			Assert.assertTrue(adminProductPages.enterTestData(userName, userAccount), "unable to locate element for user name");
			Assert.assertTrue(adminProductPages.enterTestData(password, userPwd), "unable to locate element for password");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(adminProductPages.clickPageElement(signInButton), "unable to click on Sign in submit button");
			driver.navigate().refresh();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}
	
	public void verifyLandingPage() {
		try {
			PublicCommon.waitForSec(10);
			Assert.assertTrue(adminProductPages.clickPageElement(catalogButton), "unable to click on Catalog button");
			Assert.assertTrue(adminProductPages.clickPageElement(productLink), "unable to click on Product Linkn");
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}

	}
	
	

}
