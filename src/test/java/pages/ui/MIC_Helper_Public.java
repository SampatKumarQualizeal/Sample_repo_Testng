package pages.ui;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.astm.commonFunctions.PublicAdminCommons;
import com.db.util.MSSQLDBUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import com.db.util.PosgresDBUtil;
import com.db.util.QueryUtil;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;
import org.testng.util.Strings;

import static org.testng.Assert.*;

public class MIC_Helper_Public extends BasePage {

	public MIC_Helper_Public(WebDriver driver) {
		super(driver);
	}
	Dashboard_PublicAdmin DashboardPage = getInstance(Dashboard_PublicAdmin.class);
	LoginPage_PublicAdmin LoginPage = getInstance(LoginPage_PublicAdmin.class);
	ProductPage_PublicAdmin adminProductPages = getInstance(ProductPage_PublicAdmin.class);
	BookOfStandardsPage_Public bos_pagePublic = getInstance(BookOfStandardsPage_Public.class);
	MenuNavigationPage_PublicAdmin adminMenuNavigation = getInstance(MenuNavigationPage_PublicAdmin.class);
	CustomerViewPage_PublicAdmin customerViewPage = getInstance(CustomerViewPage_PublicAdmin.class);
	StandardProductPage_Public standardPage = getInstance(StandardProductPage_Public.class);
	ASTMCartPage_Public ASTMCartPage = getInstance(ASTMCartPage_Public.class);
	CreateAccountPage_Public creatAccount = getInstance(CreateAccountPage_Public.class);
	BillingAddressPage_Public billingAddressPage = getInstance(BillingAddressPage_Public.class);
	PaymentDetailsPage_Public paymentDetails = getInstance(PaymentDetailsPage_Public.class);
	ASTMCartPage_Public astmCart = getInstance(ASTMCartPage_Public.class);
	StandardProductPage_Public standardProductPage = getInstance(StandardProductPage_Public.class);
	MembershipBecomeMemberPage becomeMember = getInstance(MembershipBecomeMemberPage.class);
	ProductPage_PublicAdmin productPageAdmin = getInstance(ProductPage_PublicAdmin.class);
	CommonPage_Public commonPage = getInstance(CommonPage_Public.class);
	SelectAnAccountPage_Public accountPage = getInstance(SelectAnAccountPage_Public.class);
	MembershipBecomeMemberPage newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
	OrdersPage_PublicAdmin orderPage_PublicAdmin = getInstance(OrdersPage_PublicAdmin.class);
	CustomerLogin_Public loginPage = getInstance(CustomerLogin_Public.class);
	MyAccountPage_Public myAccountPage = getInstance(MyAccountPage_Public.class);
	JournalsProductPage_Public journalsProductPage = getInstance(JournalsProductPage_Public.class);
	PaymentOptionsPage_Public paymentOptionsPage = getInstance(PaymentOptionsPage_Public.class);
	APIWebstoreHomePage apiWebstoreHomepage = getInstance(APIWebstoreHomePage.class);
	JournalsPage_Public journalsPage = getInstance(JournalsPage_Public.class);
	OrderConfirmPage_Integration orderConfirmPage_integration = getInstance(OrderConfirmPage_Integration.class);
	APIStoreProductPage_Public productPage1 = getInstance(APIStoreProductPage_Public.class);
	PDPProductPage pdpPage = getInstance(PDPProductPage.class);
	SpecbuilderIntegrationPage specPage = getInstance(SpecbuilderIntegrationPage.class);
	ProductAttributePageInStore attributeStore = getInstance(ProductAttributePageInStore.class);
	CreateNewOrderPage_PublicAdmin CreateOrderPage = getInstance(CreateNewOrderPage_PublicAdmin.class);
	PaymentDetailsPage_Public paymentPage=getInstance(PaymentDetailsPage_Public.class);
	MyAccountPage_Public myAccountPage_public=getInstance(MyAccountPage_Public.class);
	PTPProductPageCommon_Public ptpProductPageCommon_public=getInstance(PTPProductPageCommon_Public.class);
	BulkOrder_Page bulkOrder=getInstance(BulkOrder_Page.class);
	AllCustomerPage_PublicAdmin allCustomerAdmin = getInstance(AllCustomerPage_PublicAdmin.class);
	ASTMProficiencyTestingPage_Public ptpPage = getInstance(ASTMProficiencyTestingPage_Public.class);
	ContactSalesForcePage_Public contactSalesForcePage=getInstance(ContactSalesForcePage_Public.class);
	OrderInformationPage_PublicAdmin OrderInformationPage = getInstance(OrderInformationPage_PublicAdmin.class);

	HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"), "Vertex");


	@Step("Admin/ISS Agent logout of account from Magento Admin side")
	public void adminAgentLogoutOfAccount() {
		try {
			clickOnMethod("Profile DropDown", DashboardPage.getProfileDropDown(),
					"Admin/ISS Agent is unable to click on 'Profile DropDown'");
			clickOnMethod("Logout Button", DashboardPage.getSignoutButton(),
					"Admin/ISS Agent is unable to click on 'Logout Button'");
			verifyElementIsDisplayedOnPage("Sign out Success Message", LoginPage.getSignOutSuccessMessage());
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to logout", e);
		}
	}
	@Step("Verify '{elementName}' is  displayed on page")
	public void verifyElementIsDisplayedOnPage(String elementName, By locator) {
		try {
			Assert.assertTrue(PublicAdminCommons.isWebElementDisplayed(driver, locator),
					elementName + " is not displayed on the page");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert(elementName + " is not displayed on the page", e);
		}
	}
	@Step("Open searched product and verify product page is displayed")
	public void ClickOndropdowmAndSelectPDP(String page) {
		try {
			clickOnMethod("Searched Product", standardProductPage.dropdown, "Unable to find dropdown");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(standardProductPage.dropdown).sendKeys(page)
			;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select", e);
		}
	}

	@Step(" Navigate to Magento Login page and login with valid credentials")
	public void login(String username, String password) {
		try {
			PublicCommon.waitForSec(3);
			clickOnMethod("Sign in via OKTA Button", ProductPage_PublicAdmin.SignInViaOKTAButton,
					"unable to click on Sign in via OKTA button");
			enterText("UserName", ProductPage_PublicAdmin.userName, username, "unable to enter user name");
			enterText("Password", ProductPage_PublicAdmin.password, password, "unable to locate element for password");
			try {
				clickOnMethod("Close one trust cookie message", newMembershipPage.getElementNew(newMembershipPage.cookieRejectBtn));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickOnMethod("Sign in button", ProductPage_PublicAdmin.signInButton,
					"unable to click on Sign in submit button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Navigate to Magento Login page and login with valid credentials", e);
		}
	}

	@Step("Navigate to product page through catalogue ")
	public void verifyLandingPage() {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Catalog button", ProductPage_PublicAdmin.catalogButton, "unable to click on Catalog button");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(ProductPage_PublicAdmin.productLink));
			clickOnMethod("Product Link", ProductPage_PublicAdmin.productLink, "unable to click on Product Link");
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed Navigate to product page through catalogue ", e);
		}
	}
	
	
	
	@Step("Navigate to URL rewrite through marketting ")
	public void navigateToURLRewrite() {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Marketing button", ProductPage_PublicAdmin.marketingButton, "unable to click on Marketting button");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(ProductPage_PublicAdmin.urlRewrites));
			clickOnMethod("Urk Rewrite Link", ProductPage_PublicAdmin.urlRewrites, "unable to click on URL Rewrite Link");
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed Navigate to to URL rewrite through marketting ", e);
		}
	}
	@Step("Enter request path and target path ")
	public void enterRequestPathAndTargetPath(String requestPath,String targetPath ) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(ProductPage_PublicAdmin.requestPathInput));
			enterText("Request Path InputField", ProductPage_PublicAdmin.requestPathInput,requestPath, "unable to enter text in Request Path");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(ProductPage_PublicAdmin.targetPathInput));
			enterText("Target Path InputField", ProductPage_PublicAdmin.targetPathInput,targetPath, "unable to enter text in Target Path");
			driver.findElement(ProductPage_PublicAdmin.targetPathInput).sendKeys(Keys.ENTER);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to enter request path and target path ", e);
		}
	}

	@Step("Search for the product {productName}")
	public void searchProduct(String productName) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			enterText("Product search input field", ProductPage_PublicAdmin.searchProductInput, productName,
					"unable to locate product search input field");
			driver.findElement(ProductPage_PublicAdmin.searchProductInput).sendKeys(Keys.ENTER);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}

	@Step("Search for the product by SKU: {productName}")
	public void searchProductByTypeAndStoreView(String productName, String storeView) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectProductType),
					productName);

			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectStoreView),
					storeView);
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}
	
	

	@Step("Search for the product by CGA Store view and SKU: {productName}")
	public void searchProductBySkuAndCGAStoreView(String productName, String storeView) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			enterText("SKU", ProductPage_PublicAdmin.productSKUTextfield, productName, "Failed to enter value in SKU");

			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectStoreView),
					storeView);
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}
	
	

	@Step("Search for the product by SKU: {productName}, type, attributeSet")
	public void searchProductByTypeAndAttributeSetAndSKU(String productType, String attributeSet, String sku) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectProductType),
					productType);
			enterText("Product search input field", ProductPage_PublicAdmin.skuFilter, sku,
					"unable to locate product search input field");
			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectAttributeSet),
					attributeSet);
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(adminMenuNavigation.editLink));
			if (getElements(adminMenuNavigation.editLink).size() > 1) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.JSClick(adminMenuNavigation.getProductEditButtonElmentString(sku), driver);
			} else {
				ReusableMethods.scrollIntoView(getElement(adminMenuNavigation.editLink), driver);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.JSClick(getElement(adminMenuNavigation.editLink), driver);
			}
			expandClosedSections();
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}

	@Step("Search for the product by SKU: {productName}, type, attributeSet")
	public void searchProductByTypeAndSKU(String productType,String sku) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectProductType),
					productType);
			enterText("Product search input field", ProductPage_PublicAdmin.skuFilter, sku,
					"unable to locate product search input field");
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(adminMenuNavigation.editLink));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}

	
	public String verifyAssetStatus() {
		String assetStatus = adminProductPages.getElement(ProductAttribute_PublicAdmin.AssetStatusAttribute).getAttribute("value");
		return assetStatus;
	}

	@Step("Get Product Count")
	public int getProductCount() {
		try {
			PublicCommon.waitForSec(7);
			String productCountWithText = adminProductPages.getElement(ProductPage_PublicAdmin.productCount).getText();
			int exactTotalProductCount = Integer.parseInt(productCountWithText.replaceAll("[^0-9]", ""));
			return exactTotalProductCount;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Get  product count", e);
		}
		return -1;
	}

	@Step("Search for the product by SKU: {StockCode}")
	public void searchProductBySku(String stockCode) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			PublicCommon.waitForSec(3);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			WaitStatementUtils.waitForElementToBeClickable(driver,adminProductPages.getElement(ProductPage_PublicAdmin.filterButton));
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			enterText("SKU", ProductPage_PublicAdmin.productSKUTextfield, stockCode, "Failed to enter value in SKU");
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}
	public List<Map<String, Object>> resultsMCSDBQuery(String query, String environment) {
		List<Map<String, Object>> dbResultList = new ArrayList<Map<String, Object>>();
		MSSQLDBUtil mssqldbConnection = new MSSQLDBUtil();
		Connection connection = null;
		try {
			connection = mssqldbConnection.connectMSSQLDB(environment);
			Assert.assertNotNull(connection, "Connection to MSSQLDB could not be established. Please ensure AWS VPN is connected!");
			QueryUtil util = new QueryUtil();
			ResultSet result = util.executeQuery(connection, query);
			dbResultList = util.convertMulitpleDBResultToHashMap(result);
			closeDBConnection(connection);
			return dbResultList;

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get data from database by query", e);
		}
		return dbResultList;

	}

	@Step("Search for the order by orderID: {orderID}")
    public void searchOrderByOrderID(String orderID){
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.salesMenuNavigationButton));
			clickOnMethod("Sales Menu Option", adminMenuNavigation.salesMenuNavigationButton,
					"Failed to click on Sale menu option ");
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.orderMenuNavigationButton));
			clickOnMethod("Order Menu Option", adminMenuNavigation.orderMenuNavigationButton,
					"Failed to click on Order menu option ");
			PublicCommon.waitForSec(5);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			PublicCommon.waitForSec(3);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			WaitStatementUtils.waitForElementToBeClickable(driver,adminProductPages.getElement(ProductPage_PublicAdmin.filterButton));
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			enterText("SKU", ProductPage_PublicAdmin.orderIDTextField, orderID, "Failed to enter value in SKU");
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the order", e);
		}
	}

	public void verifyProductavailabailityInMagento(String expectedResultXpath, String actualResult) {
		try {
			searchProductBySku(actualResult);
			By locator = By.xpath(expectedResultXpath);
			String expectedResult = PublicCommon.getText(driver, locator);
			Assert.assertTrue(expectedResult.equalsIgnoreCase(actualResult), "SKU is not available");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}

	}

	public void verifyProductTypeAndAttributeSet(String sku, String expectedProudctType, String expectedAttributeSet) {
		try {
			searchProductBySku(sku);
			String actualProductTtype = PublicCommon.getText(driver, adminProductPages.simpleProductType);
			String actualAttributeSet = PublicCommon.getText(driver, adminProductPages.attributeSet);
			Assert.assertTrue(actualProductTtype.equalsIgnoreCase(expectedProudctType) && actualAttributeSet.equalsIgnoreCase(expectedAttributeSet), "Product type and attribute set are not verified");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}

	}


	@Step("Search for the product by SKU: {productName}")
	public void searchProductByTypeAndPublicListingAndDisableOrder(String productName, String publicListing,
																   String disableOrder) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectProductType),
					productName);
			PublicCommon.selectValueInDropdown(
					adminProductPages.getElement(ProductPage_PublicAdmin.publicListingInFilter), publicListing);
			/*PublicCommon.selectValueInDropdown(
					adminProductPages.getElement(ProductPage_PublicAdmin.disableOrderInFilter), disableOrder);*/
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			WebElement table = getElement(ProductPage_PublicAdmin.productTable);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println(rows.size());
			Assert.assertTrue(rows.size() < 3, "There is public listing having product");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}

	@Step("Enter {elementName} :'{keys}' in TextBox.")
	public void enterText(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clearTxtFieldsendKeys(driver, locator, keys), assertionMessage);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Enter data in Text box", e);
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

	@Step("verify public listing attribute")
	public void verifyPublicListingAttributeAvailableOrNot() {
		try {
			if (PublicCommon.isWebElementDisplayed(driver, ProductAttribute_PublicAdmin.publicListingAttribute) == false) {
				Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, ProductAttribute_PublicAdmin.publicListingAttribute) == false, "public listing is avaliable");
			} else {
				Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, ProductAttribute_PublicAdmin.publicListingAttribute) == true, "public listing is avaliable");
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify public listing attribute.", e);
		}
	}

	@Step("verify sku attribute and contract item type")
	public void verifySKUWithProductItemFinancialAndContractItemTypeCode(List<Map<String, Object>> dbResultList) {
		try {
			String skuFromMagento = adminProductPages.getElement(ProductAttribute_PublicAdmin.productSKUAttribute).getAttribute("value");
			Assert.assertTrue(skuFromMagento.equalsIgnoreCase(dbResultList.get(0).get("ProductSKU").toString()), "SKU is not matched");
			String contractItemType = adminProductPages.getElement(ProductAttribute_PublicAdmin.contractItemtypeAttribute).getAttribute("value");
			Assert.assertTrue(contractItemType.equalsIgnoreCase("SUBSCRIPTION"), "Contract item type code is not matched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify SKU and contract item type code.", e);
		}

	}

	@Step("Inventory item id and marketing codes")
	public void verifyInventoryIDAndMarketingCodes(List<Map<String, Object>> dbResultList) {
		try {
			String inventoryID = adminProductPages.getElement(ProductAttribute_PublicAdmin.inventoryIDAttribute).getAttribute("value");
			Assert.assertTrue(dbResultList.get(0).get("ExternalSystemID").toString().equalsIgnoreCase(inventoryID), "Inventory id not matched");
			String marketingCodes = adminProductPages.getElement(ProductAttribute_PublicAdmin.marketingCodesAttribute).getAttribute("value");
			Assert.assertTrue(marketingCodes.endsWith(""), "marketing id is not blank");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify inventoryID and marketing codes.", e);
		}
	}

	public String verifyInventoryItemStatusCode() {
		try {
			String inventoryItemStatusCode = adminProductPages.getElement(ProductAttribute_PublicAdmin.inventoryitemStatusCodeAttribute).getAttribute("value");
			return inventoryItemStatusCode;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify inventoryID and marketing codes.", e);
			return "";
		}
	}

	public void verifycategoryConcatsegsAttribute(String pimValue) {
		try {
			String magentoValue = adminProductPages.getElement(ProductAttribute_PublicAdmin.categoryConcatAttributeValue).getAttribute("value");
			Assert.assertTrue(pimValue.equalsIgnoreCase(magentoValue), "Category concatsegs value not matched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to category concat segs", e);
		}

	}

	@Step("Click on {elementName}")
	public void clickOnMethod(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	@Step("Verify Visibility of Element {elementName}")
	public void verifyVisibility(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.isWebElementDisplayed(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}
	@Step("Verify Visibility of Element {elementName}")
	public void verifyNotVisibile(String elementName, By locator, String assertionMessage) {
		try {
			assertFalse(IntegrationCommon.isWebElementDisplayed(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}

	public String verifyAssetIDAttribute() {
		try {
			String actualValue = adminProductPages.getElement(PDPProductPage.assetIDValue).getAttribute("value");
			return actualValue;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
		return "";

	}

	public String verifyAssetTypeAttribute() {
		try {
			String actualValue = adminProductPages.getElement(PDPProductPage.assetTypeValue).getAttribute("value");
			return actualValue;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
		return "";
	}

	@Step("Get data from database using query")
	public List<Map<String, Object>> resultForDBQuery(String query, String environment) {
		List<Map<String, Object>> dbResultList = new ArrayList<Map<String, Object>>();
		PosgresDBUtil dbConnection = new PosgresDBUtil();
		Connection connection = null;
		try {
			connection = dbConnection.connect(environment);
			Assert.assertNotNull(connection, "Connection is not established to PostgreSQL DB. Please ensure VPN1 is connected.");
			QueryUtil util = new QueryUtil();
			ResultSet result = util.executeQuery(connection, query);
			dbResultList = util.convertMulitpleDBResultToHashMap(result);
			closeDBConnection(connection);
			return dbResultList;

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get data from database by query", e);
		}
		return dbResultList;

	}

	public void searchAttributeInStore(String value) {
		try {
			enterText("attribute name", ProductAttributePageInStore.attributeCodeInput, value,
					"Failed to enter value in attribute code");
			productPageAdmin.submitWithKeysMethod(ProductAttributePageInStore.attributeCodeInput);
			clickOnMethod("attribute in attributeCode", ProductAttributePageInStore.selectSearchAttribute,
					"Unable to click on Product attribute code.");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify element", e);
		}
	}

	@Step("Verify delivery method code and ID with DB")
	public void getDeliveryMethodIDAndCodeAndVerify(String deliveryMethodID, String deliveryMethodCode) {
		try {

			WebElement table = getElement(ProductPage_PublicAdmin.productTable);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			if (rows.size() > 1) {
				clickOnMethod("Select first row of table", ProductPage_PublicAdmin.selectSearchedProduct,
						"unable to click on searched select product");
			}
			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.deliveryMethodID), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("ASTM Attributes", ProductPage_PublicAdmin.astmAttributes,
					"Unable to expand ASTM attributes.");
			String deliveryMethodMagentoID = getElement(ProductPage_PublicAdmin.deliveryMethodID).getAttribute("value");
			String deliveryMethodCodeMagento = getElement(ProductPage_PublicAdmin.deliveryMethodCode)
					.getAttribute("value");
			validateText("Delivery Method ID", deliveryMethodMagentoID, deliveryMethodID,
					"Failed to verify deliverymethodID");
			validateText("Delivery Method Code", deliveryMethodCodeMagento, deliveryMethodCode,
					"Failed to verify deliverymethodCode");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify delivery method code and ID with DB", e);
		}
	}
	@Step("Verify delivery plateform code")
	public void getDeliveryPlateformCodeAndVerify(String deliveryPlateformCode) {
		try {

			WebElement table = getElement(ProductPage_PublicAdmin.productTable);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			if (rows.size() > 1) {
				clickOnMethod("Select first row of table", ProductPage_PublicAdmin.selectSearchedProduct,
						"unable to click on searched select product");
			}
			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.deliveryMethodID), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("ASTM Attributes", ProductPage_PublicAdmin.astmAttributes,
					"Unable to expand ASTM attributes.");
			String deliveryPlateformCodeMagento = getElement(ProductPage_PublicAdmin.deliveryPlatformCode)
					.getAttribute("value");
			validateText("Delivery Plateform Code", deliveryPlateformCodeMagento, deliveryPlateformCode,
					"Failed to verify deliveryPlateformCode");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify delivery palteform code", e);
		}
	}
	@Step("Verify delivery method ID with DB")
	public void getDeliveryMethodIDAndVerify(String deliveryMethodID) {
		try {
			String deliveryMethodMagentoID = getTextAreaAttributeFromMagento("pim_delivery_method_id");
			validateText("Delivery Method ID", deliveryMethodMagentoID, deliveryMethodID,
					"Failed to verify deliverymethodID");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify delivery method ID with DB", e);
		}
	}

	@Step("Moved To Product Attributes")
	public void moveToProductAttributes() {
		try {

			WebElement table = getElement(ProductPage_PublicAdmin.productTable);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			if (rows.size() > 1) {
				clickOnMethod("Select first row of table", ProductPage_PublicAdmin.selectSearchedProduct,
						"unable to click on searched select product");
			}
			expandClosedSections();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed Moved To Product Attributes", e);
		}
	}

	@Step("Moved To Product Attributes")
	public void moveToProductBySKU(By skuName) {
		try {

			WebElement table = getElement(ProductPage_PublicAdmin.productTable);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			if (rows.size() > 1) {
				clickOnMethod("Select first row of table", skuName, "unable to click on searched select product");
			}
			expandClosedSections();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed Moved To Product Attributes", e);
		}
	}

	public void verifyVisibilityProductAndPublicListing(String publicListingValue, String visibilityValue) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver,
					adminProductPages.spinnerIconAfterProductSearch), "unable to click on Filter button");
			Assert.assertTrue(PublicCommon
					.getFirstSelectedValueInDropdown(
							adminProductPages.getElement(ProductAttribute_PublicAdmin.productVisibility))
					.getText().equalsIgnoreCase(visibilityValue), "Product visibility is not matched");
			WebElement publicListingFromMagento = adminProductPages
					.getElement(ProductAttribute_PublicAdmin.publicListingAttribute);
			Assert.assertTrue(publicListingFromMagento.getAttribute("value").equalsIgnoreCase(publicListingValue),
					"public listing order not YES");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed product visibility and product listing", e);
		}
	}

	public void verifyProductVisibilityAttribute(String expectedValue) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver,
					adminProductPages.spinnerIconAfterProductSearch), "unable to click on Filter button");
			Assert.assertTrue(PublicCommon
					.getFirstSelectedValueInDropdown(
							adminProductPages.getElement(ProductAttribute_PublicAdmin.productVisibility))
					.getText().equalsIgnoreCase(expectedValue), "Product visibility is not matched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify product visibility attribute", e);
		}

	}

	public void verifyProductClassificationValue(String expectedValue) {
		try {
			String actualValue = adminProductPages.getElement(ProductAttribute_PublicAdmin.productClassificationValue).getAttribute("value");
			Assert.assertTrue(expectedValue.contains(actualValue), "Product classification is not matched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify product classification attribute", e);
		}

	}

	public void verifyLastUpdatedvalue() {
		try {
			String actualValue = adminProductPages.getElement(ProductAttribute_PublicAdmin.lastUpdatedAttributeValue).getAttribute("value");
			Assert.assertTrue(actualValue.isEmpty(), "Last updated field is not blank");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify last updated attribute", e);
		}

	}

	public void verifyPublicListingAndDisableOrder(String publicListingValue, String disableOrderValue) {
		try {
			WebElement publicListing = adminProductPages
					.getElement(ProductAttribute_PublicAdmin.publicListingAttribute);
			Assert.assertTrue(publicListing.getAttribute("value").equalsIgnoreCase(publicListingValue),
					"public listing invalid");
			WebElement disableOrder = adminProductPages
					.getElement(ProductAttribute_PublicAdmin.disablePublicOrderAttribute);
			Assert.assertTrue(disableOrder.getAttribute("value").equalsIgnoreCase(disableOrderValue),
					"disable order invlaid");
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed public listing  and disable order", e);
		}

	}

	@Step("Verify store code 'Main Website' check box is selected.")
	public void verifyStoreCodeMainWebsiteIsSelected() {
		try {

			WebElement table = getElement(ProductPage_PublicAdmin.productTable);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			if (rows.size() > 1) {
				clickOnMethod("Select first row of table", ProductPage_PublicAdmin.selectSearchedProduct,
						"unable to click on searched select product");
			}
			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productWebsiteSection), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,
					getElement(ProductPage_PublicAdmin.productWebsiteSection), 15);
			clickOnMethod("Product In Website", ProductPage_PublicAdmin.productWebsiteSection,
					"Unable to click on Product In Website.");
			Assert.assertTrue(getElement(ProductPage_PublicAdmin.checkBox_MainWesite).isSelected());
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify main wesite checkbox is selected", e);
		}
	}

	@Step("Verify delivery method ID with DB")
	public void getDeliveryMethodIDFromProductTableAndVerify(String deliveryMethodID) {
		try {
			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.deliveryMethodID_ProductTable), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String deliveryMethodMagentoID = getElement(ProductPage_PublicAdmin.deliveryMethodID_ProductTable).getText()
					.trim();
			System.out.println("Product table DMI: " + deliveryMethodMagentoID);
			validateText("Delivery Method ID", deliveryMethodMagentoID, deliveryMethodID,
					"Failed to verify deliverymethodID");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify delivery method ID with DB", e);
		}
	}

	@Step("Verifying the: {successText}")
	public void validateText(String successText, String actualText, String expectedText, String assertionMessage) {
		try {
			String validation = successText;
			if (Strings.isNullOrEmpty(actualText) || actualText.isEmpty() || actualText.equalsIgnoreCase("null")
					|| actualText == null || actualText.length() == 0)
				actualText = "";
			if (Strings.isNullOrEmpty(expectedText) || expectedText.isEmpty() || expectedText.equalsIgnoreCase("null")
					|| expectedText == null || expectedText.length() == 0)
				expectedText = "";
			System.out.println(actualText);
			System.out.println(expectedText);
			boolean result = IntegrationCommon.verifyElementTextOnPage(validation, actualText, expectedText);
			assertTrue(result, assertionMessage);
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception ex) {
			ex.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Text", ex);
		}
	}

	@Step("Database connection closed")
	public void closeDBConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to closedDatabase connection ", e);
		}
	}

	@Step("Search a product and get the count of no. of row  ")
	public int searchProductByProductTypeGetCount(String value, String productType) throws InterruptedException {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			enterText("Delivery method id", ProductPage_PublicAdmin.deliveryMethodIdTextfield, value,
					"Failed to enter value in delivery method id");
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String productCountWithText = adminProductPages.getElement(ProductPage_PublicAdmin.productCount).getText();
			String exactTotalProductCount = productCountWithText.replaceAll("[^0-9]", "");
			return Integer.parseInt(exactTotalProductCount);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to search a product and get the count", e);
		}
		return 0;
	}

	@Step("Search a product by product type: {productType} and get the count of records  ")
	public int searchProductByProductTypeAndGetCount(String productType) throws InterruptedException {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String productCountWithText = adminProductPages.getElement(ProductPage_PublicAdmin.productCount).getText();
			String exactTotalProductCount = productCountWithText.replaceAll("[^0-9]", "");
			return Integer.parseInt(exactTotalProductCount);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to search a product and get the count", e);
		}
		return 0;
	}

	public String searchProductWithEBS_SKU(String productType) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			PublicCommon.waitForSec(2);
			resetTheColumnSection();
			PublicCommon.selectCheckbox(driver, ProductPage_PublicAdmin.ebsSKUCheckbox);
			//select EBS_SKU from column section
			PublicCommon.waitForSec(3);
			clickOnMethod("close column section", ProductPage_PublicAdmin.columnButton,
					"Failed to close column section");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");

			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectStoreView),
					"storeView");
			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectproductType),
					productType);
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			PublicCommon.clickonWebElement(driver, adminProductPages.getElement(ProductPage_PublicAdmin.sortEBS_SKU));
//		clickOnMethod("EBS_SKU sort", ProductPage_PublicAdmin.sortEBS_SKU,
//				"Failed to sort EBS_SKU");
			String firstEBS_SKU = PublicCommon.getText(driver, adminProductPages.getProductEditButtonElmentString(productType));
			return firstEBS_SKU;
//		PublicCommon.JSClick(adminProductPages.getProductEditButtonElmentString(productType), driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to move to admin search page", e);
			return "";
		}

	}

	@Step("Move to admin search page")
	public void moveToAdminSearchForCustomerPage() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(adminMenuNavigation.customerMainButton));
			clickOnMethod("Customers Menu Option", adminMenuNavigation.customerMainButton,
					"Failed to click on Customers menu option ");
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(adminMenuNavigation.allcustomerButton));
			clickOnMethod("All Customers Menu Option from customer tab", adminMenuNavigation.allcustomerButton,
					"Failed to click on All Customers menu option ");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			PublicCommon.waitForSec(7);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.clearAllFilterLink),
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to handle loader");
			ScreenshotUtil.takeScreenshotForAllure(driver);
//			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
//			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
//					"unable to click on Filter button");

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to move to admin search page", e);
		}
	}

	@Step("Navigate to Customer information Page")
	public void openCustomerInfo() {
		try {
			Thread.sleep(2000);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(adminMenuNavigation.editLink));
			ReusableMethods.scrollIntoView(getElement(adminMenuNavigation.editLink), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(adminMenuNavigation.editLink));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getElement(adminMenuNavigation.editLink), driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Navigate to Customer information Page", e);

		}
	}

	@Step("Add productBySku {productSKU}")
	public void addProductBySku(String productSKU) {
		try {
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(customerViewPage.getCreateOrderButton()),10);
			clickOnMethod("Create Order button", customerViewPage.getCreateOrderButton(),
					"Unable to click on Create order button");
			PublicCommon.waitForSec(10);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product by SKU button", customerViewPage.addProductSKU,
					"Unable to click on Add product by SKU button");
			ReusableMethods.scrollIntoView(getElement(customerViewPage.addToOrderBtn), driver);

			enterText("Product SKU box", customerViewPage.addSKUNumber, productSKU,
					"Unable to enter Product SKU number");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Product Quantity box", customerViewPage.addproductQty, "1", "Unable to enter product quantity");
			PublicCommon.JSClick(getElement(customerViewPage.addToOrderBtn), driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Create new order", e);

		}
	}

	public void verifyAddProductBySkuErrorMessage(String expectedValue) {
		try {
			String actualValue = adminProductPages.getElement(ProductAttribute_PublicAdmin.errorMessageCreateOrderDisable).getText().trim();
			Assert.assertTrue(expectedValue.equals(actualValue), "Product assigned to another website error message not matched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify product classification attribute", e);
		}

	}
	public void verifyAddProductBySkuErrorMessage1(String expectedValue) {
		try {
			String actualValue = adminProductPages.getElement(ProductAttribute_PublicAdmin.errorMessageCreateOrderDisable1).getText().trim();
			Assert.assertTrue(expectedValue.equals(actualValue), "Product assigned to another website error message not matched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to verify product classification attribute", e);
		}

	}

	@Step("Create new order with product {productSKU}")
	public void createOrder(String productSKU) {
		try {
			clickOnMethod("Create Order button", customerViewPage.getCreateOrderButton(),
					"Unable to click on Create order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product by SKU button", customerViewPage.addProductSKU,
					"Unable to click on Add product by SKU button");
			ReusableMethods.scrollIntoView(getElement(customerViewPage.addToOrderBtn), driver);

			enterText("Product SKU box", customerViewPage.addSKUNumber, productSKU,
					"Unable to enter Product SKU number");
			enterText("Product Quantity box", customerViewPage.addproductQty, "1", "Unable to enter product quantity");
			PublicCommon.JSClick(getElement(customerViewPage.addToOrderBtn), driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (PublicCommon.isWebElementDisplayed(driver, customerViewPage.configureMessage)) {
				addProductConfiguration();
			}
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			/*if(commonPage.getElement(CreateOrderPage.licenseTypeDropDown).isDisplayed()){
				adminSelectLicenseType();
			}*/
			adminAddsStartAndPublishDateForAllProducts();
			ReusableMethods.scrollIntoView(getElement(customerViewPage.additionalInfoHeader), driver);
			PublicCommon.waitForSec(3);
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.majorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.minorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(
					PublicCommon.selectValueInDropdown(getElement(customerViewPage.salesChannelDropdown), "WEB - Web"));
			clickOnMethod("Submit order button", customerViewPage.submitOrderBtn,
					"Unable to Click on submit order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Create new order", e);

		}
	}
	 @Step("Admin/ISS Agent set publish and start date for all products to current date")
	    public void adminAddsStartAndPublishDateForAllProducts() {
	        try {
	            Assert.assertTrue(CreateOrderPage.setPublishStartDateForAllProduct(),"Unable to set publish and start date for products");
	        } catch (Exception e) {
	            e.printStackTrace();
	            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set start and publish date", e);
	        }
	    }
/*	@Step("Admin/ISS Agent select license type")
	public void adminSelectLicenseType() {
		try {
			Assert.assertTrue(CreateOrderPage.selectLicenseType(1),"Unable to set publish and start date for products");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set start and publish date", e);
		}
	}*/
	@Step("Create new order with product {productSKU}")
	public void createOrderWithStartAndPublishDate(String productSKU, String startDate, String publishDate) {
		try {
			clickOnMethod("Create Order button", customerViewPage.getCreateOrderButton(),
					"Unable to click on Create order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product by SKU button", customerViewPage.addProductSKU,
					"Unable to click on Add product by SKU button");
			ReusableMethods.scrollIntoView(getElement(customerViewPage.addToOrderBtn), driver);

			enterText("Product SKU box", customerViewPage.addSKUNumber, productSKU,
					"Unable to enter Product SKU number");
			enterText("Product Quantity box", customerViewPage.addproductQty, "1", "Unable to enter product quantity");
			PublicCommon.JSClick(getElement(customerViewPage.addToOrderBtn), driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (PublicCommon.isWebElementDisplayed(driver, customerViewPage.configureMessage)) {
				addProductConfiguration();
			}
			PublicCommon.waitForSec(5);
			enterText("Start Date", customerViewPage.startDate, startDate,
					"Unable to enter Start Date");
			enterText("Publish Date", customerViewPage.publishDate, publishDate,
					"Unable to enter Publish Date");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(customerViewPage.additionalInfoHeader), driver);
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.majorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.minorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(
					PublicCommon.selectValueInDropdown(getElement(customerViewPage.salesChannelDropdown), "WEB - Web"));
			clickOnMethod("Submit order button", customerViewPage.submitOrderBtn,
					"Unable to Click on submit order button");
			clickOnMethod("Confirmation popup OK button", customerViewPage.submitConfirmOKBtn,
					"Unable to Click on Confirmation popup OK button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Create new order", e);

		}
	}

	
	@Step("Create new order with product {productSKU}")
	public void createOrderWithConfiguration(String productSKU, String configuration) {
		try {
			clickOnMethod("Create Order button", customerViewPage.getCreateOrderButton(),
					"Unable to click on Create order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product by SKU button", customerViewPage.addProductSKU,
					"Unable to click on Add product by SKU button");
			ReusableMethods.scrollIntoView(getElement(customerViewPage.addToOrderBtn), driver);

			enterText("Product SKU box", customerViewPage.addSKUNumber, productSKU,
					"Unable to enter Product SKU number");
			enterText("Product Quantity box", customerViewPage.addproductQty, "1", "Unable to enter product quantity");
			PublicCommon.JSClick(getElement(customerViewPage.addToOrderBtn), driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (PublicCommon.isWebElementDisplayed(driver, customerViewPage.configureMessage)) {
				addProductConfigurationToProduct(configuration);
			}
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(customerViewPage.additionalInfoHeader), driver);
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.majorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.minorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(
					PublicCommon.selectValueInDropdown(getElement(customerViewPage.salesChannelDropdown), "WEB - Web"));
			clickOnMethod("Submit order button", customerViewPage.submitOrderBtn,
					"Unable to Click on submit order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Create new order", e);

		}
	}


	@Step("Verifying EBS status for order placed")
	public void verifyEBSStatus() {
		try {
			Assert.assertTrue(OrderInformationPage.handleRefreshOfPage(), "Admin/ISS Agent is unable to refresh page");
			String ebsStatus = getElementNew(customerViewPage.ebsOrderStatus).getText();
			Assert.assertTrue(ebsStatus.equalsIgnoreCase("Success"), "EBS order not successfull");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to verify EBS status for order placed", e);

		}
	}

	@Step("Move to searched order")
	public void goToOrderDetailsPage(String orderID) {
		By searchedOrderID = By.xpath("//div[contains(@class, 'data-grid-cell-content') and text()=" + orderID.replace("Order Number:", "") + "]");
		getElement(searchedOrderID).click();
	}
	
	@Step("Move to searched product")
	public void goToProductDetailsPage(String expectedAssetStatus, String expectedDOIvalue) {
		WebElement ele2=driver.findElement(ProductPage_PublicAdmin.configurableProduct);
		WaitStatementUtils.waitForElementToBeClickable(driver, ele2, 30);
		PublicCommon.waitForSec(4);
		driver.findElement(ProductPage_PublicAdmin.configurableProduct).click();
		PublicCommon.waitForSec(10);
		WebElement ele3=driver.findElement(ProductPage_PublicAdmin.astmAttributes);
		WaitStatementUtils.waitForElementToBeClickable(driver, ele3, 30);
		ele3.click();
		String assetStatus = getAttributeFromPDPPage("Asset Status");
		System.out.println("Status is "+ assetStatus);
		System.out.println("Status in sheet is "+ expectedAssetStatus);
		verifyAttributevalueMagento("Asset Status", expectedAssetStatus, assetStatus);
		String DOI= getAttributeFromPDPPage("DOI");
		System.out.println("DOI is "+ DOI);
		System.out.println("DOI in sheetis "+ expectedDOIvalue);
		verifyAttributevalueMagento("DOI", expectedDOIvalue, DOI);
	}

	@Step("Reset the column section gear icon")
	public void resetTheColumnSection() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(ProductPage_PublicAdmin.columnButton));
			Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.columnButton),
					"Column button is not clickable");
			Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.resetButtonOfColumn),
					"Reset button is not available");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to verify EBS status for order placed", e);

		}
	}

	public void verifyProductPriceForInstitutionalAndIndividual(String coden, String productType, List<String> priceList) {
		resetTheColumnSection();
		Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.codenCheckbox), "Coden checkbox not available");
		searchProductByProductTypeAndCoden(productType, coden);
		String individualPriceFromMagento = PublicCommon.getText(driver, ProductPage_PublicAdmin.searchedPriceForIndividiual).substring(0, 4);
		System.out.println(priceList.get(0) + ",,,,," + priceList.get(1));
		Assert.assertTrue(individualPriceFromMagento.equalsIgnoreCase(priceList.get(1)), "individual price not same");
	}

	public void addMoreColumns(By locator){
		adminProductPages.clickPageElement(locator);

	}

	@Step("Checked the Public listing an d Disable order check box")
	public void verifyProductLineAndClassificatinOptionUnderFilter() {
		try {
			Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.publicListingCheckbox),
					"Product Line Code checkbox not available");
			/*Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.disablePublicOrderCheckbox),
					"Product Classification checkbox not available");*/
			Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.filterButton),
					"Filter button is not available");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert(
					"Exception in Test MIC-1627 for 'Product Line Code' & 'Product Classification' option in filter section.",
					e);
		}
	}

	public void verifyProductLineCodeAttributeInMagento(String pimValue) {
		PublicCommon.waitForSec(2);
		String magentoValue = adminProductPages.getElement(ProductAttribute_PublicAdmin.productLineUnderASTM).getAttribute("value");
		Assert.assertTrue(pimValue.equalsIgnoreCase(magentoValue), "Product line code is not macthed");
	}

	@Step("Getting order numer")
	public String getOrderNumber() {
		return getElement(customerViewPage.customerPageHeader).getAttribute("data-title");
	}

	public String getDisplayDesignationValue() {
		String displayDesignationvalueFromMagento = adminProductPages.getElement(ProductAttribute_PublicAdmin.displayDesignationAttribute).getAttribute("value");
		return displayDesignationvalueFromMagento;
	}

	public String getOrderDetails() {
		try {
			ReusableMethods.scrollIntoView(getElement(orderConfirmPage_integration.orderConfirmationPage_orderNumber), driver);
			return getElement(orderConfirmPage_integration.orderConfirmationPage_orderNumber).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getWorkflowStatus() {
		try {
			String workflowStatus = adminProductPages.getElement(ProductAttribute_PublicAdmin.workflowStatusAttribute).getAttribute("value");
			return workflowStatus;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String verifyUUIDAttribute() {
		try {
			String uuid = adminProductPages.getElement(ProductAttribute_PublicAdmin.uuidAttribute).getAttribute("value");
			return uuid;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String verifySKU() {
		try {
			String sku = adminProductPages.getElement(ProductAttribute_PublicAdmin.productSKUAttribute).getAttribute("value");
			return sku;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String verifyLanguageCodeAttribute() {
		try {
			String languageCode = adminProductPages.getElement(ProductAttribute_PublicAdmin.languageCodeAttribute).getAttribute("value");
			return languageCode;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String verifyWarehouseCode() {
		try {
			String warehouseCode = PublicCommon.getFirstSelectedValueInDropdown(adminProductPages.getElement(ProductAttribute_PublicAdmin.warehouseCodeAttribute)).getAttribute("value");
			return warehouseCode;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Step("Search a product and get the count of no. of row  ")
	public int searchProductByProductTypeGetCount(String value, String productType, String attributeSet) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");

			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectAttributeSet),
					attributeSet);
			enterText("Delivery method id", ProductPage_PublicAdmin.deliveryMethodIdTextfield, value,
					"Failed to enter value in delivery method id");
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");

			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String productCountWithText = adminProductPages.getElement(ProductPage_PublicAdmin.productCount).getText();
			String exactTotalProductCount = productCountWithText.replaceAll("[^0-9]", "");
			return Integer.parseInt(exactTotalProductCount);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable toSearch a product and get the count of no. of row ", e);
		}
		return 0;
	}

	@Step("Search a product and get the count of no. of row  ")
	public int searchProductByProductTypeAndGetCount(String productType, String attributeSet, String storeView, String status) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");

			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectAttributeSet),
					attributeSet);
			PublicCommon.selectValueInDropdown(adminProductPages.getElement(ProductPage_PublicAdmin.selectStoreView),
					storeView);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectStatus),
					status);

			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");

			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String productCountWithText = adminProductPages.getElement(ProductPage_PublicAdmin.productCount).getText();
			String exactTotalProductCount = productCountWithText.replaceAll("[^0-9]", "");
			return Integer.parseInt(exactTotalProductCount);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable toSearch a product and get the count of no. of row ", e);
		}

		return 0;
	}

	@Step("Navigate to product page and select format")
	public void selectFormat(String ProductURL) {
		try {
			driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM") + ProductURL);
			PublicCommon.waitForSec(5);
			newMembershipPage.handleOneTrustCookie();
			assertTrue(PublicCommon.selectValueInDropdownbyIndex(standardPage.getSelectLanguageDropdown(), 1));
			WaitStatementUtils.waitForElementToBeClickable(driver, standardPage.getSelectFormatDropdown());
			assertTrue(PublicCommon.selectValueInDropdownbyIndex(standardPage.getSelectFormatDropdown(), 1));

			clickOnMethod("Add to cart button", standardPage.addToCartButton, "Couldn't click on Add to Cart button");
			PublicCommon.waitForSec(2);
			WaitStatementUtils.waitForElementToBeClickable(driver,standardPage.getElementNew(standardPage.shoppingCartLink));
			clickOnMethod("Shopping Cart link", standardPage.shoppingCartLink, "Couldn't click on Shopping cart link");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	@Step("Click on add to cart and navigate to shopping cart")
	public void addToCart() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver ,getElement(standardPage.addToCartButton),10);
			clickOnMethod("Add to cart button", standardPage.addToCartButton, "Couldn't click on Add to Cart button");
			PublicCommon.waitForSec(2);
			ReusableMethods.scrollUpToTopOfPage(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver ,getElement(standardPage.cartLink1),10);
			clickOnMethod("Shopping Cart link", standardPage.cartLink1, "Couldn't click on Shopping cart link");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	@Step("Click on Check out button")
	public void checkOut() {
		try {
			PublicCommon.waitForSec(10);
			//ReusableMethods.SCrollIntoView(driver);
			PublicAdminCommons.scrollToElement(driver,ASTMCartPage.checkOutBtnAfterLogin);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",getElement(ASTMCartPage.checkOutBtnAfterLogin));
			//(new Actions(driver)).click(getElement(ASTMCartPage.checkOutBtnAfterLogin)).build().perform();
			//PublicCommon.waitForSec(5);
		//	clickOnMethod("Check Out", ASTMCartPage.checkOutBtnAfterLogin,
		//			"After Registeration Check out Button Should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on Checkout button", e);
		}
	}

	@Step("Navigate to Order page through Sales ")
	public void moveToOrderPage() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.salesMenuNavigationButton));
			clickOnMethod("Sales Menu Option", adminMenuNavigation.salesMenuNavigationButton,
					"Failed to click on Sale menu option ");
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.orderMenuNavigationButton));
			clickOnMethod("Order Menu Option", adminMenuNavigation.orderMenuNavigationButton,
					"Failed to click on Order menu option ");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.clearAllFilterLink),
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed Navigate to Order page through Sales ", e);
		}
	}

	@Step("Open order & Account information page")
	public void openOrderAccountInfoPage() {
		try {
			adminMenuNavigation.getElement(adminMenuNavigation.viewBtn).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.accountInfoOrganisation));

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on view and verify Organisation Name", e);
		}
	}

	@Step("Navigate to 'Billing Address'")
	public void verifyBillingAddressHeaderIsVisible() {
		verifyVisibility("Billign Address", billingAddressPage.billingAddressHeader,
				"Billing Address should be visible");
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Billing Address header is visible", e);
		}
	}

	@Step("Verifying Navigated to payment details page.")
	public void landingOnPamentsPage() {
		assertTrue(paymentDetails.landingOnPaymentDetailsPage(), "Navigate to Payement Page");
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to land on Payments page", e);
		}
	}

	@Step("Configure product in case product is configurable")
	public void addProductConfiguration() {
		try {
			clickOnMethod("Configure button", customerViewPage.configureProductBtn,
					"Unable to click on configure button");
			PublicCommon.selectValueInDropdownbyIndex(getElement(customerViewPage.productConfigureDropdwn), 1);

			PublicCommon.selectValueInDropdownbyIndex(getElement(customerViewPage.languageConfigureDropdwn), 1);

			clickOnMethod("Ok button", customerViewPage.configureOKBtn, "Unable to click on OK button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product to order button", customerViewPage.addProductToOrder,
					"Unable to add product to order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Configure product in case product is configurable", e);
		}
	}

	@Step("Configure product to '{configuration}' in case product is configurable ")
	public void addProductConfigurationToProduct(String configuration) {
		try {
			clickOnMethod("Configure button", customerViewPage.configureProductBtn,
					"Unable to click on configure button");
			PublicCommon.selectValueInDropdown(getElement(customerViewPage.productConfigureDropdwn), configuration);

			PublicCommon.selectValueInDropdownbyIndex(getElement(customerViewPage.languageConfigureDropdwn), 1);

			clickOnMethod("Ok button", customerViewPage.configureOKBtn, "Unable to click on OK button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product to order button", customerViewPage.addProductToOrder,
					"Unable to add product to order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Configure product in case product is configurable", e);
		}
	}

	@Step("Click on create new account and place order")
	public void createNewUserAndPlaceOrder(HashMap<String, String> dataMap) {
		try {
			ReusableMethods.scrollIntoView(ASTMCartPage.getElement(ASTMCartPage.createNewAccount), driver);
			clickOnMethod("Create Account on Create New Account button", ASTMCartPage.createNewAccount,
					"Create Account button should be clickable");
			creatAccount.newUserRegistration();
			verifyBillingAddressHeaderIsVisible();
			billingAddressPage.addbillingPageDetails("Billing Address");

			verifyBillingAddressHeaderIsVisible();
			commonPage.closeCookieMessage();
			paymentDetails.fillCreditCardDetails(dataMap.get("creditCard"), dataMap.get("securityCode"),
					dataMap.get("expiryMonth"), dataMap.get("expiryYear"));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on create new account and place order", e);
		}

	}

	@Step("Click on {0}")
	private void clickOnMethod(String message, By element) {
		try {
			driver.findElement(element).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Exception.", e);
		}
	}

	@Step("Click on create new account and place order")
	public void createNewUserAndPlaceOrder_WithUSAddress(HashMap<String, String> dataMap) {
		try {
			ReusableMethods.scrollIntoView(ASTMCartPage.getElement(ASTMCartPage.createNewAccount), driver);
			clickOnMethod("Create Account on Create New Account button", ASTMCartPage.createNewAccount,
					"Create Account button should be clickable");
			creatAccount.newUserRegistration();
			try {
				if (getElement(ProductPage_PublicAdmin.myAccount).isDisplayed()) {
					clickOnMethod("Cart button", commonPage.cartLink);
					checkOut();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			verifyBillingAddressHeaderIsVisible();
			enterBillingAddress("US_Address");

			// verifyBillingAddressHeaderIsVisible();
			// commonPage.closeCookieMessage();
			paymentDetails.fillCreditCardDetails(dataMap.get("creditCard"), dataMap.get("securityCode"),
					dataMap.get("expiryMonth"), dataMap.get("expiryYear"));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on create new account and place order", e);
		}

	}

	@Step("Entering Billing Information")
	public void enterBillingAddress(String sheetName) {
		try {
			HashMap<String, String> dataMapBilling = PublicCommon
					.getMapperData(ConfigReader.getValue("WebDataExcelPath"), sheetName);
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(billingAddressPage.getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			PublicCommon.waitForSec(7);
			clickOnMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
			WaitStatementUtils.waitForElementStaleness(driver,getElement(billingAddressPage.UseSelectedAddress),10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(billingAddressPage.UseSelectedAddress),10);
			getElement(billingAddressPage.UseSelectedAddress).click();
		} catch (IOException e) {
			e.printStackTrace();
			log.info(e);
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		} finally {
			try {
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Step("Add searched product to cart and checkout")
	public void SearchProductAndAddtoCartAndCheckOut(String productName) {
		try {
			enterText("Search input Box", standardProductPage.searchInput, productName, "fail to enter product name");
			driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
			try {
				if (getElement(accountPage.pageheader).isDisplayed()) {
					if (ConfigReader.getValue("BASE_URL_PUB_ASTM").contains("qa.astm.org")) {
						PublicCommon.JSClick(driver.findElement(accountPage.getAccountLocator("Priyanka Manocha")),
								driver);
					} else if (ConfigReader.getValue("BASE_URL_PUB_ASTM").contains("stage.astm.org")) {
						PublicCommon.JSClick(driver.findElement(commonPage.getAccountLocator("Mark Mitchell")), driver);
					}
					enterText("Search input Box", standardProductPage.searchInput, productName,
							"fail to enter product name");
					driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			ScreenshotUtil.takeScreenshotForAllure(driver);
			// PublicCommon.JSClick();
			clickOnMethod("Did you know pop up close button", standardProductPage.didYouPopUpCloseBtn,
					"Failed to close pop up");
			clickOnMethod("Product searched ", standardProductPage.searchedProduct, "Unable to find product");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Add to cart", By.xpath("(//button[@title='Add to Cart'])[1]"),
					"Unable to click on add to cart");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
			clickOnMethod("Shopping cart Link", standardProductPage.shoppingCartLink,
					"Unable to click on shopping cart link");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Check Out button", standardProductPage.checkoutButton,
					"Unable to click on check out Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Add searched product to cart and checkout", e);
		}
	}

	public String searchProductAndSelectLanguageAndFormatPlaceOrder(String productSKU) {
		searchProductAndOpenProductDetailPage(productSKU);

		selectFormaDropDownValue("Hard Copy");
		PublicCommon.selectValueInDropdown(adminProductPages.getElement(standardProductPage.selectLanguageDropdown), "English (United States)");
		WaitStatementUtils.waitForElementToBeClickable(driver, adminProductPages.getElement(standardProductPage.productPageCartBtn));
		clickOnMethod("", standardProductPage.productPageCartBtn, "Add to cart button not available");
		PublicCommon.waitForSec(15);
		clickOnMethod("Shopping cart Link", standardProductPage.cartLink,
				"Unable to click on shopping cart link");
		clickOnMethod("Check Out button", standardProductPage.checkoutButton,
				"Unable to click on check out Button");
		PublicCommon.waitForSec(5);
		paymentDetails.fillCreditCardDetails(dataMap.get("creditCard"), dataMap.get("securityCode"),
				dataMap.get("expiryMonth"), dataMap.get("expiryYear"));
		PublicCommon.waitForSec(5);
		String orderDetails = getOrderDetails();
		return orderDetails;

	}

	@Step("Add searched product to cart and checkout")
	public void SearchMembershipProductAndAddtoCartAndCheckOut(String productName) {
		try {
			enterText("Search input Box", standardProductPage.searchInput, productName, "fail to enter product name");
			driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
			try {
				if (getElement(accountPage.pageheader).isDisplayed()) {
					if (ConfigReader.getValue("BASE_URL_PUB_ASTM").contains("qa.astm.org")) {
						PublicCommon.JSClick(driver.findElement(accountPage.getAccountLocator("Priyanka Manocha")),
								driver);
					} else if (ConfigReader.getValue("BASE_URL_PUB_ASTM").contains("stage.astm.org")) {
						PublicCommon.JSClick(driver.findElement(commonPage.getAccountLocator("Mark Mitchell")), driver);
					}
					enterText("Search input Box", standardProductPage.searchInput, productName,
							"fail to enter product name");
					driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			ScreenshotUtil.takeScreenshotForAllure(driver);
			// PublicCommon.JSClick();
			clickOnMethod("Did you know pop up close button", standardProductPage.didYouPopUpCloseBtn,
					"Failed to close pop up");
			clickOnMethod("Product searched ", standardProductPage.searchedProduct, "Unable to find product");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Become Organization member Button", standardProductPage.becomeOrganuizationalMemberButton,
					"Unable to click Become Organization member Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			fillNewMembershipDetails("CanadaOffice_Address");
			/*
			 *
			 * clickOnMethod("Shopping cart Link", standardProductPage.shoppingCartLink,
			 * "Unable to click on shopping cart link");
			 * ScreenshotUtil.takeScreenshotForAllure(driver);
			 */
			clickOnMethod("Continue Button", becomeMember.continueBtn, "Failed to click on continue button");
			clickOnMethod("Check Out button", standardProductPage.checkoutButton,
					"Unable to click on check out Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Add  searched Membership product to cart and checkout", e);
		}
	}

	@Step("Comparing the count of record from DB: {DBrecordCount} and web: {webRecordCount}")
	public void verifyProductCountFromWebAndDB(int DBrecordCount, int webRecordCount) {
		try {
			Assert.assertEquals(DBrecordCount, webRecordCount);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to compare web and db record count.", e);
		}
	}

	@Step("Expand all collapsed sections")
	public void expandClosedSections() {
		try {
			PublicCommon.waitForSec(3);
			List<WebElement> sections = getElementsNew(productPageAdmin.sectionDropDown);
			for (WebElement section : sections) {
				ReusableMethods.scrollIntoView(section, driver);
				PublicCommon.JSClick(section, driver);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Expand all collapsed sections", e);
		}
	}

	@Step("Filter product by sku")
	public void searchProductBySKU(String productName) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			enterText("SKU text box", ProductPage_PublicAdmin.skuFilter, productName, "Unable to enter SKU");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Clear filter link", ProductPage_PublicAdmin.applyFilterButton,
					"unable to click on apply filter link");
			// PublicCommon.JSClick(getElement(ProductPage_PublicAdmin.applyFilterButton),
			// driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}

	@Step("Search product by product name and open product detail page")
	public void searchProductAndOpenProductDetailPage(String productName) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Search input Box", standardProductPage.searchInput, productName, "fail to enter product name");
			driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
			PublicCommon.waitForSec(2);
			ScreenshotUtil.takeScreenshotForAllure(driver);
	/*		if (PublicCommon.isWebElementDisplayed(driver, standardProductPage.infoToolTip)) {
				clickOnMethod("ToolTip close button", standardProductPage.infoToolTipCloseBtn,
						"Unable to close tooltip");
			}*/
			clickOnMethod("Searched Product", standardProductPage.searchedProduct, "Unable to find product");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search product by product name and open product detail page", e);
		}
	}
	@Step("Search product by product SKU")
	public void searchProductInASTM(String productSKU) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Search input Box", standardProductPage.searchInput, productSKU, "fail to enter product name");
			driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			commonPage.closeCookieMessage();
			if (PublicCommon.isWebElementDisplayed(driver, standardProductPage.infoToolTip)) {
				clickOnMethod("ToolTip close button", standardProductPage.infoToolTipCloseBtn,
						"Unable to close tooltip");
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search product by product name and open product detail page", e);
		}
	}
	

	@Step("Search product by product name ")
	public void searchProductOnPublic(String productName) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Search input Box", standardProductPage.searchInput, productName, "fail to enter product name");
			driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			commonPage.closeCookieMessage();
			if (PublicCommon.isWebElementDisplayed(driver, standardProductPage.infoToolTip)) {
				clickOnMethod("ToolTip close button", standardProductPage.infoToolTipCloseBtn,
						"Unable to close tooltip");
			}
			//clickOnMethod("Searched Product", standardProductPage.searchedProduct, "Unable to find product");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search product by product name ", e);
		}
	}

	@Step("Search product by product name ")
	public String verifyProductClassificationBadge(String productName) {
		try {
			searchProductOnPublic(productName);
			String productClassificationBadgeFromASTM = PublicCommon.getText(driver, pdpPage.productClassificationBadge);
			//clickOnMethod("Searched Product", standardProductPage.searchedProduct, "Unable to find product");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return productClassificationBadgeFromASTM;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search product by product name ", e);
			return "";
		}
	}

	@Step("Search product by product name ")
	public String verifyProductDescription(String productName) {
		try {
			searchProductAndOpenProductDetailPage(productName);
			String productDescriptionFromASTM = PublicCommon.getText(driver, pdpPage.productDescription);
			//clickOnMethod("Searched Product", standardProductPage.searchedProduct, "Unable to find product");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return productDescriptionFromASTM;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search product by product name ", e);
			return "";
		}
	}


	@Step("Verify Last Updated Label")
	public void verifyLastUpdatedLabel(String expected) {
		try {
			String actualLabel = getElement(standardProductPage.updateBadge).getText().split(":")[0];
			Assert.assertTrue(actualLabel.equalsIgnoreCase(expected));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Last Updated Label", e);
		}
	}

	@Step("Fill out details for new Organisational membership")
	public void fillNewMembershipDetails(String canadaOfficeaddress) {
		try {
			fillPersonalAndOrganisationalInformation(canadaOfficeaddress);
			fillComitteeInformationforMembership();
			fillVolumeDetails();
			clickOnMethod("Submit button", newMembershipPage.submitBtn, "Failed to click on Submit button");

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Failed to fill membership details");
		}
	}

	@Step("On Membership page fill out the information about your self ")
	public void fillPersonalAndOrganisationalInformation(String sheetName) {
		try {
			assertTrue(newMembershipPage.enterPersonalDetailsofMembership(sheetName));
			assertTrue(newMembershipPage.enterOrganisationalDetailsofMembership(sheetName));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			newMembershipPage.clickOnNextBtn();

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
		}
	}

	@Step("On Membership page fill out the information of committee ")
	public void fillComitteeInformationforMembership() {
		try {
			ReusableMethods.scrollIntoView(newMembershipPage.getChooseCommittee(), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver,
					newMembershipPage.getElement(newMembershipPage.chooseCommittee));
			Assert.assertTrue(newMembershipPage.isChooseComitteeBtnDisplayed(), "Choose button is not displayed");
			Assert.assertTrue(newMembershipPage.selectCommitteeFromList(0), " is not displayed");
			PublicCommon.selectValueInDropdown(
					newMembershipPage.getElement(newMembershipPage.describeOrganisationDropdown),
					"Manufacturer of product/service");
			newMembershipPage.getElement(newMembershipPage.organisationDscription).sendKeys("ASTM");
			assertTrue(newMembershipPage.clickOnNextBtn());
			Assert.assertTrue(newMembershipPage.stepsPageHeaderIsVisible(), "Information not filled successfully");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
		}

	}

	@Step("On Membership page fill out the information for volume")
	public void fillVolumeDetails() {
		try {
			Assert.assertTrue(newMembershipPage.selectYourVolumeWithNoVolume(), "Information is not filled");

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
		}

	}

	/*
	 * @Step("On Membership page fill out the information of committee ") public
	 * void fillInformationStep1() { try { Thread.sleep(5000);
	 * WaitStatementUtils.explicitWaitForVisibility(driver,
	 * becomeMember.getElement(becomeMember.chooseCommittee));
	 * Assert.assertTrue(becomeMember.isChooseComitteeBtnDisplayed(),
	 * "Choose button is not displayed");
	 * Assert.assertTrue(becomeMember.selectCommitteeFromList(0),
	 * " is not displayed");
	 * PublicCommon.selectValueInDropdown(becomeMember.getElement(becomeMember.
	 * describeOrganisationDropdown), "Consulting Firm");
	 * assertTrue(becomeMember.clickOnNextBtn());
	 * Assert.assertTrue(becomeMember.stepsPageHeaderIsVisible(),
	 * "Information not filled successfully"); Assert.assertTrue(
	 * becomeMember.getElement(becomeMember.stepsHeader).getText().contains(dataMap.
	 * get("Step2 header"))); ScreenshotUtil.takeScreenshotForAllure(driver); }
	 * catch (Exception e) { e.printStackTrace(); log.info(e.toString());
	 * PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured"); }
	 *
	 * }
	 *
	 * @Step("On Membership page fill out the information about your self ") public
	 * void fillInformationStep2() { try {
	 * System.out.println(dataMap.get("Step2 header"));
	 * Assert.assertTrue(becomeMember.fillTellUsAboutYouselfInfo(0),
	 * "Information is not filled");
	 * Assert.assertTrue(becomeMember.stepsPageHeaderIsVisible(),
	 * "Information not filled successfully");
	 * ScreenshotUtil.takeScreenshotForAllure(driver); } catch (Exception e) {
	 * e.printStackTrace(); log.info(e.toString());
	 * PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured"); } }
	 *
	 * @Step("On Membership page fill out the information of Representative") public
	 * void fillInformationStep3() { try { Thread.sleep(5000);
	 * Assert.assertTrue(becomeMember.fillRepresentativeInfo(), "Info not filled");
	 *
	 * } catch (Exception e) { e.printStackTrace(); log.info(e.toString());
	 * PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured"); }
	 *
	 * }
	 *
	 * @Step("On Membership page fill out the information for volume") public void
	 * fillInformationStep4() { try { Thread.sleep(5000);
	 * Assert.assertTrue(becomeMember.selectYourVolumeForDigital(1),
	 * "Information is not filled"); ScreenshotUtil.takeScreenshotForAllure(driver);
	 * } catch (Exception e) { e.printStackTrace(); log.info(e.toString());
	 * PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured"); }
	 *
	 * }
	 *
	 * @Step("On Membership page fill out the information for volume") public void
	 * fillInformationStep3WithNoFreeVolume() { try { Thread.sleep(5000);
	 * Assert.assertTrue(becomeMember.selectYourVolumeWithNoVolume(),
	 * "Information is not filled"); ScreenshotUtil.takeScreenshotForAllure(driver);
	 * } catch (Exception e) { e.printStackTrace(); log.info(e.toString());
	 * PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured"); } }
	 */

	@Step("Get data from the first result in searched Product table  ")
	public HashMap<String, String> getDataFromProductTable() {
		try {
			HashMap<String, String> tableData = new HashMap<String, String>();
			for (int i = 2; i <= 14; i++) {
				String keyText = productPageAdmin.getTableHeaderValueElement(i).getText();
				tableData.put(keyText, productPageAdmin.getTableAttributeValueElement(i).getText());
			}
			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get Data from Table", e);
			return null;
		}
	}

	@Step("Verify field value '{fieldName}' for Searched product is '{expectedValue}'")
	public void verifyFieldValueForSearchedProduct(String fieldName, String expectedValue) {
		Assert.assertTrue(getDataFromProductTable().get(fieldName).equalsIgnoreCase(expectedValue));
	}

	@Step("Filter customer with emailID '{email}'")
	public void searchCustomerWithEmail(String email) {
		try {
			adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon);
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.clearAllFilterLink),
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			enterText("Email field", orderPage_PublicAdmin.getEmailFilterField(), email,
					"Unable to enter text in email field");
			clickOnMethod("Apply filter button", orderPage_PublicAdmin.getApplyFilterButton(),
					"unable to click on apply filter button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to filter customer with emailID", e);
		}
	}
	@Step("Filter customer with emailID '{email}' and customer type '{customerType}'")
	public void searchCustomerByCustomerTypeAndEmail(String email, String customerType) {
		try {
			adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon);
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				Assert.assertTrue(adminProductPages.clickPageElement(ProductPage_PublicAdmin.clearAllFilterLink),
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			enterText("Email field", orderPage_PublicAdmin.getEmailFilterField(), email,
					"Unable to enter text in email field");
			selectValue("Customer type",allCustomerAdmin.customreTypeDropDown,"Person","Customer type not selected");
			clickOnMethod("Apply filter button", orderPage_PublicAdmin.getApplyFilterButton(),
					"unable to click on apply filter button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to filter customer with emailID", e);
		}
	}
	@Step("Filter product by product type: {productType}")
	public void searchProductByProductType(String productType) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);

			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to filter product by product type", e);
		}
	}

	@Step("Filter product by product type: {productType} and {attributeType}")
	public void searchProductByProductTypeAndAttributeType(String productType, String attributeType) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectAttributeType), attributeType);

			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to filter product by product type and attributeType", e);
		}
	}

	@Step("Filter product by product type   : {productType} And Coden :{coden}  ")
	public void searchProductByProductTypeAndCoden(String productType, String coden) {
		try {
			PublicCommon.waitForSec(10);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");

			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
				Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
						"unable to click on Filter button");

			}

			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			PublicCommon.waitForSec(7);
			if(adminProductPages.getElement(ProductPage_PublicAdmin.codenTextField).isDisplayed()){
				IntegrationCommon.clearTxtFieldsendKeys(driver, ProductPage_PublicAdmin.codenTextField, coden);

			}
			else {
				clickOnMethod("Columns Button",ProductPage_PublicAdmin.ColumnsButton,"Unable to click columns button");
			    clickOnMethod("Coden CheckBox",ProductPage_PublicAdmin.codenCheckbox,"not able to click coden checkbox");
				IntegrationCommon.clearTxtFieldsendKeys(driver, ProductPage_PublicAdmin.codenTextField, coden);
			}
			PublicCommon.waitForSec(1);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			PublicCommon.waitForSec(1);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(ProductPage_PublicAdmin.applyFilterButton));
			PublicCommon.waitForSec(4);
			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to filter product by product type", e);
		}
	}

	@Step("Filter product by product type: {productType} and SKU")
	public void searchProductByProductTypeAndSKU(String productType, String SKU_Number) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			enterText("SKU", ProductPage_PublicAdmin.productSKUTextfield, SKU_Number, "Failed to enter value in SKU");

			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to filter product by product type and SKU", e);
		}
	}

	@Step("Getting EBS numer")
	public String getEBSNumber() {
		return getElementsNew(customerViewPage.ebsDetailTable).get(0).getText();
	}

	@Step("Search Product with SKU '{productSKU}'")
	public void searchProductInHomePage(String productSKU) {
		try {
			enterText("Search input Box", standardProductPage.searchInput, productSKU, "fail to enter product name");
			driver.findElement(standardProductPage.searchInput).sendKeys(Keys.ENTER);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to search Product with SKU", e);
		}
	}

	@Step("Verify product is displayed in search result")
	public void verifyProductDisplayedInASTM(String productSKU, String productName) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			searchProductInHomePage(productSKU);
			if (PublicCommon.isWebElementDisplayed(driver, standardProductPage.infoToolTip)) {
				clickOnMethod("ToolTip close button", standardProductPage.infoToolTipCloseBtn,
						"Unable to close tooltip");
			}
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, standardProductPage.searchedProduct ));
			Assert.assertTrue(getElementNew(standardProductPage.searchedProduct).getText().contains(productName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify product is displayed in search result", e);
		}
	}

	public void verifyProductNotAvailableInASTMWeb(String productSKU) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			searchProductInHomePage(productSKU);
			if (PublicCommon.isWebElementDisplayed(driver, standardProductPage.infoToolTip)) {
				clickOnMethod("ToolTip close button", standardProductPage.infoToolTipCloseBtn,
						"Unable to close tooltip");
			}
			Assert.assertFalse(getElementNew(PDPProductPage.productCountOnWeb).getText().contains("0 Results"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify product is displayed in search result", e);
		}

	}

	@Step("Verify product with SKU '{productSKU}' not displayed in API and CGA webstore")
	public void verifyProductDisplayedInWebStore(String productSKU) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			searchProductInHomePage(productSKU);
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, apiWebstoreHomepage.emptySearchMessage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify product not displayed in API/CGA search result", e);
		}
	}

	@Step("Verify product page is displayed in ASTM")
	public void verifyProductPageOpenedInASTM(String productSKU, String productName) {
		try {
			if (productSKU.contains("PDF")) {
				Assert.assertTrue(getElementNew(standardProductPage.header).getText().equalsIgnoreCase(productName));
			} else {
				Assert.assertTrue(
						getElementNew(standardProductPage.productPageTitle).getText().equalsIgnoreCase(productName));
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify product page is displayed", e);
		}
	}

	@Step("get data of product attributes")
	public HashMap<String, String> getProductAttributesData() {
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.category_concat_segs), driver);
			data.put("categoryconcatsegs",
					getElement(ProductPage_PublicAdmin.category_concat_segs).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.contract_item_type_code), driver);
			data.put("contractitemtypecode",
					getElement(ProductPage_PublicAdmin.contract_item_type_code).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.warehouse_code), driver);
			data.put("warehouseCode",
					getElement(ProductPage_PublicAdmin.warehouse_code).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.inventoryStatusCode), driver);
			data.put("inventoryitemstatuscode",
					getElement(ProductPage_PublicAdmin.inventoryStatusCode).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.inventoryItemId), driver);
			data.put("inventoryitemid",
					getElement(ProductPage_PublicAdmin.inventoryItemId).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.organisationId), driver);
			data.put("organizationid",
					getElement(ProductPage_PublicAdmin.organisationId).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.segment), driver);
			data.put("segment", getElement(ProductPage_PublicAdmin.segment).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.vertex1), driver);
			data.put("vertex1", getElement(ProductPage_PublicAdmin.vertex1).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.ebs_SKU), driver);
			data.put("ProductSKU", getElement(ProductPage_PublicAdmin.ebs_SKU).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.isbnISNN), driver);
			data.put("isbnisnn", getElement(ProductPage_PublicAdmin.isbnISNN).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.markettingCode), driver);
			data.put("marketingcodes",
					getElement(ProductPage_PublicAdmin.markettingCode).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.price), driver);
			data.put("price", getElement(ProductPage_PublicAdmin.price).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.salesAccount), driver);
			data.put("salesaccount",
					getElement(ProductPage_PublicAdmin.salesAccount).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.serveDate), driver);
			data.put("servedate", getElement(ProductPage_PublicAdmin.serveDate).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productSKU), driver);
			data.put("productsku",
					getElement(ProductPage_PublicAdmin.productSKU).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.standardCategoryId), driver);
			data.put("categoryid",
					getElement(ProductPage_PublicAdmin.standardCategoryId).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.urlKey), driver);
			data.put("urlkey", getElement(ProductPage_PublicAdmin.urlKey).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.publishDate), driver);
			data.put("publishdate",
					getElement(ProductPage_PublicAdmin.publishDate).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productName), driver);
			data.put("Name", getElement(ProductPage_PublicAdmin.productName).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.visibility), driver);
			data.put("visibility",
					getElement(ProductPage_PublicAdmin.visibility).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.deliveryMethodCode), driver);
			data.put("DeliveryMethodCode",
					getElement(ProductPage_PublicAdmin.deliveryMethodCode).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.deliveryMethodID), driver);
			data.put("DeliveryMethodID",
					getElement(ProductPage_PublicAdmin.deliveryMethodID).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.deliveryPlatformId), driver);
			data.put("DeliveryPlatformID",
					getElement(ProductPage_PublicAdmin.deliveryPlatformId).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.deliveryPlatformCode), driver);
			data.put("DeliveryPlatformCode",
					getElement(ProductPage_PublicAdmin.deliveryPlatformCode).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productItemId), driver);
			data.put("ProductItemID",
					getElement(ProductPage_PublicAdmin.productItemId).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productItemCode), driver);
			data.put("ProductItemCode",
					getElement(ProductPage_PublicAdmin.productItemCode).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productLineCode), driver);
			data.put("ProductLineCode",
					getElement(ProductPage_PublicAdmin.productLineCode).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.lastUpdated), driver);
			data.put("lastUpdated",
					getElement(ProductPage_PublicAdmin.lastUpdated).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productname), driver);
			data.put("name", getElement(ProductPage_PublicAdmin.productname).getAttribute("value").replace(" ", ""));

			ReusableMethods.scrollIntoView(getElement(ProductPage_PublicAdmin.productClassification), driver);
			data.put("productclassification",
					getElement(ProductPage_PublicAdmin.productClassification).getAttribute("value").replace(" ", ""));

			return data;
		} catch (Exception e) {
			e.printStackTrace();

			PublicCommon.reportFailAssert("Failed to get data of product attributes ", e);
			return null;
		}

	}

	@Step
	public List<String> getListOfAttributes(HashMap<String, String> dataMap) {
		List<String> attributeNames = new ArrayList<>();
		for (Map.Entry<String, String> entry : dataMap.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("Name")) {
				continue;
			} else {
				attributeNames.add(entry.getValue());
			}
		}
		return attributeNames;
	}

	@Step
	public HashMap<String, String> getDataAttributeValues(Object entrySet) {
		try {
			HashMap<String, String> result = new HashMap<String, String>();
			String str = entrySet.toString().replace("{", "").replace("}", "");
			str.replaceAll(" ", "");
			String[] st = str.split(",");
			for (String s : st) {
				String key = s.split(":")[0].replaceAll("[^a-zA-Z0-9-]", "");
				try {
					if (key.equalsIgnoreCase("visibility")) {
						key = s.split(":")[1].replaceAll("[^a-zA-Z0-9]", "");
						String value = s.split(":")[2].replaceAll("[^a-zA-Z0-9-]", "");
						result.put(key, value);
					} else {
						String value = s.split(":")[1].replaceAll("[^a-zA-Z0-9-]", "");
						result.put(key.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""), value);
					}
				} catch (Exception e) {
					result.put(key, null);
				}

			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get data from combined fields", e);
			return null;
		}
	}

	@Step("Get the data from db query result and store in HashMap")
	public HashMap<String, String> getDataFromDBTable(Map<String, Object> actual) {
		HashMap<String, String> data = new HashMap<String, String>();
		for (Map.Entry<String, Object> set : actual.entrySet()) {
			String key = set.getKey();
			try {
				if (set.getValue().toString().contains("{")) {
					data.putAll(getDataAttributeValues(actual.get(key)));
				} else {
					data.put(key.toLowerCase().replaceAll(" ", ""), set.getValue().toString().replaceAll(" ", ""));

				}
			} catch (Exception e) {
				data.put(key.toLowerCase().replaceAll(" ", ""), null);
			}
		}
		return data;
	}

	@Step("Get data for input fields")
	public HashMap<String, String> getInputFieldDataFromProductPage(List<String> keys) {
		try {
			HashMap<String, String> data = new HashMap<String, String>();
			for (String at : keys) {
				String actualText = null;
				actualText = productPageAdmin.getAttributeNamesElement(at).getAttribute("value").replaceAll(" ", "");
				if (at.equalsIgnoreCase("Product Name")) {
					at = "name";
				} else if (at.equalsIgnoreCase("sku")) {
					at = "productsku";
				} else if (at.equalsIgnoreCase("Standards Category Id")) {
					at = "categoryid";
				} else if (at.equalsIgnoreCase("Pim Product Item Code")) {
					at = "productitemcode";
				} else if (at.equalsIgnoreCase("Order Sequence Number")) {
					at = "orderseqno";
				}
				System.out.println("Attribute is " + at + " and value is " + actualText);
				data.put(at.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""), actualText);
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get input field data", e);
			return null;
		}
	}

	@Step("Get data for drop down fields")
	public HashMap<String, String> getDropDownDataFromProductPage(List<String> keys) {
		try {
			HashMap<String, String> data = new HashMap<String, String>();
			for (String at : keys) {
				String actualText = null;
				if (at.equals("Format") || at.equals("Visibility")|| at.equals("Language")) {
					String value = productPageAdmin.getDropDownNamesElement(at).getAttribute("value");
					actualText = productPageAdmin.getFormatDropDownValue(value, at).getText().replaceAll(" ", "");
					if (at.equals("Format"))
						at = "itemtype";
					data.put(at.toLowerCase(), actualText);
				} else if (at.equals("Warehouse Code")) {
					actualText = productPageAdmin.getDropDownNamesElement(at).getAttribute("value").replaceAll(" ", "");
					data.put(at.toLowerCase().replaceAll(" ", ""), actualText);
				}

			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get dropdown field data", e);
			return null;
		}
	}

	@Step("Get data for toggle fields")
	public HashMap<String, String> getTogglesDataFromProductPage(List<String> keys) {
		try {
			HashMap<String, String> data = new HashMap<String, String>();
			for (String at : keys) {
				String actualText = null;
				actualText = productPageAdmin.getToggleNamesElement(at).getAttribute("value").replaceAll(" ", "");
				if (Integer.parseInt(actualText) == 1) {
					actualText = "Y";
				} else {
					actualText = "N";
				}
				data.put(at.toLowerCase().replaceAll(" ", ""), actualText);
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get toggle field data", e);
			return null;
		}
	}

	@Step("Get data for toggle fields")
	public String getIndividualTogglesDataFromProductPage(String value) {
		try {
				String actualText = null;
			ReusableMethods.scrollIntoView(productPageAdmin.getToggleNamesElement(value),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			actualText = productPageAdmin.getToggleNamesElement(value).getAttribute("value").replaceAll(" ", "");
				if (Integer.parseInt(actualText) == 1) {
					actualText = "Y";
				} else {
					actualText = "N";
				}
			return actualText;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get toggle field data", e);
			return null;
		}
	}


	@Step("Get the data from magento fields")
	public HashMap<String, String> getDataFromMagento(List<HashMap<String, String>> dataMap) {
		HashMap<String, String> finalData = new HashMap<String, String>();
		try {
			finalData.putAll(getInputFieldDataFromProductPage(getListOfAttributes(dataMap.get(0))));
			finalData.putAll(getDropDownDataFromProductPage(getListOfAttributes(dataMap.get(1))));
			finalData.putAll(getTogglesDataFromProductPage(getListOfAttributes(dataMap.get(2))));
			String priceValue = productPageAdmin.getElementNew(productPageAdmin.priceFieldProductPage)
					.getAttribute("value").split("\\.")[0];
			finalData.put("price", priceValue);
			finalData.put("description", getDescriptionFieldText());
			return finalData;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get data frommagento fields", e);
			return finalData;
		}
	}

	public boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0 || str.equalsIgnoreCase("null")) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	@Step("Validate Data Mapping for magento and PIM database '{tableName}'")
	public void verifyDataMapping(String tableName, HashMap<String, String> dataDB, HashMap<String, String> dataMagento,
								  List<String> keys) {
		String dbValue = null;
		String magentoValue = null;
		try {
			for (String key : keys) {
				if (key.equalsIgnoreCase("warehousecode")) {
					dbValue = dataDB.get("defaultshippingorg");
					magentoValue = dataMagento.get(key);
				} else if (key.equalsIgnoreCase("description")) {
					dbValue = dataDB.get(key);
					magentoValue = dataMagento.get(key);
					System.out
							.println("Verifying values for " + key + " and values are " + dbValue + " and " + magentoValue);
					Assert.assertTrue(magentoValue.contains(dbValue));
					continue;
				} else if (key.contains("date") && !key.equalsIgnoreCase("releasedate") && !key.equalsIgnoreCase("yeardate")) {
					if (isBlank(dataDB.get(key)) && isBlank(dataMagento.get(key))) {

						dbValue = "blank";
						magentoValue = "blank";
					} else {
						dbValue = dataDB.get(key);
						dbValue = changeDateFormat(dbValue, "yyyy-mm-dd", "mm/dd/yyyy");
						magentoValue = dataMagento.get(key);
						magentoValue = changeDateFormat(magentoValue, "mm/dd/yyyy", "mm/dd/yyyy");
					}
				} else {
					dbValue = dataDB.get(key);
					if (StringUtils.isBlank(dbValue)) {
						dbValue = "blank";
					}
					magentoValue = dataMagento.get(key);
					if (StringUtils.isBlank(magentoValue)) {
						magentoValue = "blank";
					}
				}
				System.out
						.println("Verifying values for " + key + " and values are " + dbValue.replaceAll("[^a-zA-Z0-9-]", "") + " and " + magentoValue.replaceAll("[^a-zA-Z0-9-]", ""));
				Assert.assertTrue(dbValue.replaceAll("[^a-zA-Z0-9-]", "").equalsIgnoreCase(magentoValue.replaceAll("[^a-zA-Z0-9-]", "")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to map data", e);
		}
	}

	@Step("Verify text for field {attributeName}")
	public void verifyText(String attributeName, String expectedText, HashMap<String, String> data) {
		try {
			String actualText = data.get(attributeName);
			System.out.println(
					"Verifying values for " + attributeName + " and values are " + expectedText + " and " + actualText);
			Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify text", e);
		}

	}

	@Step("Verify Field {attributeName} is not blank")
	public void verifyFieldIsBlank(String attributeName, HashMap<String, String> data, String expectedText) {
		String actualText = data.get(attributeName);
		if (StringUtils.isBlank(actualText)) {
			actualText = "Blank";
		} else {
			actualText = "Not Blank";
		}
		Assert.assertTrue(actualText.equals(expectedText));
	}

	@Step("Get Description field text")
	public String getDescriptionFieldText() {
		try {
			ReusableMethods.scrollIntoView(productPageAdmin.getElementNew(productPageAdmin.descripionBtnProductPage),
					driver);
			PublicCommon.JSClick(productPageAdmin.getElementNew(productPageAdmin.descripionBtnProductPage), driver);
			PublicCommon.waitForSec(3);
			return productPageAdmin.getElementNew(productPageAdmin.descriptionText).getText().replaceAll(" ", "");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get description field text", e);
			return null;
		}
	}

	public void verifyDescriptionTextWithPIMDb(String descFromPIM) {
		String descFromMagento = getDescriptionFieldText();
		Assert.assertTrue(descFromMagento.equalsIgnoreCase(descFromMagento), "Description txt is not same");

	}

	@Step("Navigate to Product Details Page")
	public void openProductDetaisPage(String productName) {
		try {
			Thread.sleep(2000);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(adminMenuNavigation.editLink));
			if (getElements(adminMenuNavigation.editLink).size() > 1) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.JSClick(adminMenuNavigation.getProductEditButtonElmentString(productName), driver);
			} else {
				ReusableMethods.scrollIntoView(getElement(adminMenuNavigation.editLink), driver);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.JSClick(getElement(adminMenuNavigation.editLink), driver);
			}
//			expandClosedSections();
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
//			expandClosedSections();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Navigate to Customer information Page", e);

		}
	}

	@Step("Get data from product detail page")
	public String getDataFromProductPage(String key) {
		try {
			String actualText = null;
			if (key.equals("Format") || key.equals("Language") || key.equals("Visibility")) {
				String value = productPageAdmin.getDropDownNamesElement(key).getAttribute("value");
				actualText = productPageAdmin.getFormatDropDownValue(value, key).getText().replaceAll(" ", "");
			} else if (key.equalsIgnoreCase("URL Key")) {
				actualText = productPageAdmin.getElementNew(productPageAdmin.urlKeyFieldProductPage)
						.getAttribute("value").replaceAll(" ", "");
			} else {
				actualText = productPageAdmin.getDropDownNamesElement(key).getAttribute("value").replaceAll(" ", "");
			}

			return actualText;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get dropdown field data", e);
			return null;
		}
	}

	@Step("Get dropdown options list {optionText}")
	public List<String> getFormatDropDownOptionList() {
		List<String> optionText = new ArrayList<String>();
		try {
			Select select = new Select(getElementNew(standardPage.selectFormatDropdown));
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

	@Step("Get dropdown options list")
	public List<String> getLanguageDropDownOptionList() {
		List<String> optionText = new ArrayList<String>();
		try {
			Select select = new Select(getElementNew(standardPage.selectLanguageDropdown));
			List<WebElement> allOptions = select.getOptions();
			for (WebElement el : allOptions) {
				optionText.add(el.getText());
			}
			return optionText;
		} catch (Exception e) {
			e.printStackTrace();
			return optionText;
		}

	}

	@Step("Verify dropdown '{elementName}' contains value '{expecteValue}'")
	public void verifyDropDownText(String elementName, String expecteValue, List<String> options) {
		Assert.assertTrue(options.contains(expecteValue));
	}

	public void selectFormaDropDownValue(String value) {
		PublicCommon.selectValueInDropdown(getElementNew(standardPage.selectFormatDropdown), value);
	}

	public void selectFormaDropDownValueComittee(String value) {
		PublicCommon.selectValueInDropdown(getElementNew(specPage.selectCommittteDropdown), value);
	}

//	public void selectLanguageDropDownValue(String value) {
//		PublicCommon.selectValueInDropdown(getElementNew(standardPage.selectLanguageDropdown), value);
//	}

	@Step("Verify attribute value '{attributeName}' is '{expectedValue}'")
	public void verifyAttributevalueMagento(String attributeName, String expectedValue, String actualValue) {
		try {
			if (StringUtils.isBlank(expectedValue)) {
				expectedValue = "blank";
			}

			if (StringUtils.isBlank(actualValue)) {
				actualValue = "blank";
			}
			Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Validate Data Mapping for magento and PIM database '{tableName}'")
	public void verifyDataMappingWithDB(String tableName, HashMap<String, String> dataDB,
										HashMap<String, String> dataMagento, List<String> keys) {
		String dbValue = null;
		String magentoValue = null;
		try {
			for (String key : keys) {
				key = key.replaceAll(" ", "").toLowerCase();
				dbValue = dataDB.get(key);
				if (StringUtils.isBlank(dbValue)) {
					dbValue = "blank";
				}
				magentoValue = dataMagento.get(key);
				if (StringUtils.isBlank(magentoValue)) {
					magentoValue = "blank";
				}
				System.out
						.println("Verifying values for " + key + " and values are " + dbValue + " and " + magentoValue);
				Assert.assertTrue(dbValue.equalsIgnoreCase(magentoValue));
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to map data", e);
		}
	}

	@Step("Veriy attributes are present in Product details page")
	public void veridyAttributePresentInMagento(HashMap<String, String> data, List<String> keys) {
		for (String key : keys) {
			key = key.replaceAll(" ", "").toLowerCase();
			Assert.assertTrue(data.containsKey(key));
		}

	}

	@Step("Click on {0}")
	public void clickOnMethod(String message, WebElement element) {
		try {
			ReusableMethods.scrollIntoView(element, driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.clickonWebElement(driver, element);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Exception.", e);
		}
	}

	@Step("Getting data from Public Product details page")
	public String getPageContent() {
		ReusableMethods.scrollIntoView(getElementNew(standardPage.ptpPageContent), driver);
		String text = getElementNew(standardPage.ptpPageContent).getText().split("FAQs")[1].replaceAll("/n", "")
				.replaceAll("\n", "");
		return text;
	}

	@Step("Getting Dynamic Description data from Magento")
	public String getDynamicDescriptionContent(String productSKU) {
		String content = "";
		try {
			for (int i = 0; i < 7; i++) {
				openProductDetaisPage(productSKU);
				List<WebElement> headerElement = getElementsNew(ProductPage_PublicAdmin.dynamicTableHeaderProductPage);
				List<WebElement> descriptionElement = getElementsNew(
						ProductPage_PublicAdmin.dynamicTableDescriptionProductPage);
				String header = headerElement.get(i).getAttribute("value");
				content = content.concat(header);
				PublicCommon.JSClick(descriptionElement.get(i), driver);
				PublicCommon.waitForSec(2);
				String description = getElementNew(ProductPage_PublicAdmin.editDescriptionBtn).getText()
						.replaceAll("/n", "").replaceAll("\n", "");
				PublicCommon.waitForSec(5);
				content = content.concat(description);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				driver.navigate().back();
			}
			return content;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return content;
		}
	}

	@Step("Verify product URL matches the URL key '{expectedURL}'")
	public void verifyURL(String expectedURL) {
		Assert.assertTrue(PublicCommon.compareUrl(expectedURL, driver));
	}

	@Step("Select version '{value}' in version dropdown")
	public void selectVersionDropDownValue(String value) {
		try {
			clickOnMethod("Version DropDown", standardProductPage.versionDropdown, "Unable to click Version Dropdown");
			clickOnMethod("Version DropDown option", standardProductPage.setVersionoption(value),
					"Unable to set Version");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Select version.", e);
		}
	}


	@Step("Get dropdown options list {optionText}")
	public List<WebElement> getDropDownOptionList() {
		Select select = new Select(getElementNew(standardPage.selectFormatDropdown));
		PublicCommon.waitForSec(5);
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
		return allOptions;
	}

	@Step("Navigate to product page and verify select format dropdown is displayed")
	public void varifyselectFormatDropdown() {
		try {

			assertTrue(standardPage.getSelectFormatDropdown().isDisplayed(),
					"Select format dropdown is displayed on publication products.");
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	@Step("Get format value from attribute column in configuration table")
	public void getFormatValueFromAttributeColumnAndVerify() {
		try {
			List<String> tablAattrubuteValue = PublicCommon.getTextOfWebElements(driver, standardPage.attrubuteValue);
			assertEquals(tablAattrubuteValue.get(0), "Format: PUBLICATION, Language: en-US",
					"First child product value validated.");
			assertEquals(tablAattrubuteValue.get(1), "Format: ONLINE, Language: en-US",
					"Second child product value validated.");
			System.out.println("tablAattrubuteValue: " + tablAattrubuteValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Get single format value ONLINE from attribute column in configuration table")
	public void getSingleFormatValueONLINEFromAttributeColumnAndVerify() {
		try {
			List<String> tablAattrubuteValue = PublicCommon.getTextOfWebElements(driver, standardPage.attrubuteValue);
			assertEquals(tablAattrubuteValue.get(0), "Format: ONLINE, Language: en-US",
					"First child product value validated.");
			System.out.println("tablAattrubuteValue: " + tablAattrubuteValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Get single format value PUBLICATION from attribute column in configuration table")
	public void getSingleFormatValuePUBLICATIONFromAttributeColumnAndVerify() {
		try {
			List<String> tablAattrubuteValue = PublicCommon.getTextOfWebElements(driver, standardPage.attrubuteValue);
			assertEquals(tablAattrubuteValue.get(0), "Format: PUBLICATION, Language: en-US",
					"First child product value validated.");
			System.out.println("tablAattrubuteValue: " + tablAattrubuteValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Get price value from price column in configuration table")
	public void getPriceValueFromPriceColumnAndVerify() {
		try {
			List<String> tablePriceValue = PublicCommon.getTextOfWebElements(driver, standardPage.priceValue);
			assertEquals(tablePriceValue.get(0), "$123.00", "First child product price validated.");
			assertEquals(tablePriceValue.get(1), "$123.00", "Second child product price validated.");
			System.out.println("tablePriceValue: " + tablePriceValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Get price value from price column in configuration table")
	public List<String> getPriceListFromPriceColumn() {
		List<String> tablePriceValue = null;
		try {
			tablePriceValue = PublicCommon.getTextOfWebElements(driver, standardPage.priceValue);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return tablePriceValue;

	}

	@Step("Get price value from ASTM Web store")
	public String getPriceFromASTMWebStore() {
		String priceFrontEnd = null;
		try {
			priceFrontEnd = standardPage.getElementNew(standardPage.price).getText().replaceAll(" ", "");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return priceFrontEnd;

	}


	@Step("Get format and Language attributes from configuration section in PDP admin")
	public HashMap<String, String> getFormatAndLanguageAttribute() {
		HashMap<String, String> hm = new HashMap<String, String>();
		try {
			List<String> tableAttrubuteValue = PublicCommon.getTextOfWebElements(driver, standardPage.attrubuteValue);
			for (String text : tableAttrubuteValue) {
				String format = text.split(",")[1].replace("Format: ", "");
				String language = text.split(",")[0].replace("Language: ", "").replace(" ", "");
				hm.put("Format", format);
				hm.put("Language", language);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return hm;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get Format and language attributes", e);
			return hm;
		}
	}

	@Step("Get list of AssetID from magento")
	public List<String> getChildAssetIDList() {
		List<String> assets = new ArrayList<String>();
		try {
			String asset = productPageAdmin.getElementNew(productPageAdmin.childAssetsProductPage).getAttribute("value")
					.replaceAll(" ", "");
			String[] str = asset.split(",");
			for (int i = 0; i < str.length; i++) {
				if (str[i].contains("child-asset-id")) {
					String value = str[i].split(":")[1].replaceAll("[^a-zA-z0-9]", "");
					assets.add(value);
				}
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return assets;
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get list of AssetID from magento", e);
			return assets;
		}
	}

	@Step("Open links from table of contents and verify sku")
	public List<String> verifyLinksFromTableOfContents(int number, List<String> sku) {
		List<String> skuPublic = new ArrayList<String>();
		try {
			List<WebElement> links = getElementsNew(standardPage.productPageTableLinks);
			Assert.assertTrue(links.size() == number);
			for (int i = 1; i < links.size(); i++) {

				links = getElementsNew(standardPage.productPageTableLinks);
				ReusableMethods.scrollIntoView(links.get(i), driver);
				if(links.get(i).getText().equalsIgnoreCase("Author Index") || links.get(i).getText().equalsIgnoreCase("Subject Index")||links.get(i).getText().equalsIgnoreCase("Overview")){
					continue;
				}
				clickOnMethod("Click on link", links.get(i));
				Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, standardPage.productPageSKU));
				ScreenshotUtil.takeScreenshotForAllure(driver);
				String actualSku = getElementNew(standardPage.productPageSKU).getText();
				skuPublic.add(actualSku);
				//actualSku = actualSku.split("\\|")[1];
				Assert.assertTrue(sku.contains(actualSku));
				driver.navigate().back();
			}
			return skuPublic;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to open links from table of contents and verify sku", e);
			return skuPublic;
		}
	}

	@Step("Verify Sku is available in magento")
	public void verifySkuAvailability(List<String> sku) {
		try {
			int count = 0;
			for (String str : sku) {
				searchProductBySku(str);
				System.out.println(getElementNew(adminMenuNavigation.getProductSkuElement(str)).getText());
				Assert.assertTrue(
						getElementNew(adminMenuNavigation.getProductSkuElement(str)).getText().equalsIgnoreCase(str));
				count++;
				System.out.println("Verifying for :" + str);
			}
			System.out.println("Number of sku verified: " + count + " and number of sku " + sku.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Sku availability in magento", e);
		}
	}
	@Step("Verify Sku is available in magento")
	public void verifySkuAvailabilityWithContains(List<String> sku) {
		try {
			int count = 0;
			for (String str : sku) {
				searchProductBySku(str);
				System.out.println(getElementNew(adminMenuNavigation.getProductSkuElementContains(str)).getText());
				Assert.assertTrue(
						getElementNew(adminMenuNavigation.getProductSkuElementContains(str)).getText().contains(str));
				count++;
				System.out.println("Verifying for :" + str);
			}
			System.out.println("Number of sku verified: " + count + " and number of sku " + sku.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Sku availability in magento", e);
		}
	}

	@Step("Get version history list from magento PDP page")
	public List<String> getVersionHistoryFromMagento() {
		try {
			PublicCommon.selectValueInDropdown(getElementNew(standardPage.pageVersionCount), "50");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(standardPage.skuVersionList));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.getTextOfWebElements(driver, standardPage.skuVersionList);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get version history list from magento PDP page", e);
			return null;
		}
	}

	@Step("Navigate to My Account Page and Signout.")
	public void signOut() {
		try {
			IntegrationCommon.clickonWebElement(driver, loginPage.signinDropdown);
			assertTrue(myAccountPage.clickSignOutButton(), "Couldn't click on Signout button");

			assertTrue(PublicCommon.isWebElementDisplayed(driver, commonPage.signInLink));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Signout: ", e);
		}
	}

	@Step("Get product price from search Results in magento")
	public String getProductPriceFromSearchResults(String productSku) {
		String text = adminMenuNavigation.getProductPriceElement(productSku).getText();
		return text;
	}

	@Step("Search for the product by SKU: {productName}")
	public void filterProductBySku(String productName) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			enterText("SKU", ProductPage_PublicAdmin.productSKUTextfield, productName, "Failed to enter value in SKU");

			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}

	@Step(" verify Products in Product Table")
	public void verifyElementsinProductTable(int size, String Option1, String Option2) {
		try {

			if (journalsProductPage.getElements(ProductPage_PublicAdmin.productrow).size() == size) {
				Assert.assertTrue(
						PublicCommon.verifyElementIsVisible(Option1 + " product row",
								getElement(ProductPage_PublicAdmin.setSearchAttribute(Option1)), driver),
						Option1 + "is not displayed");
				Assert.assertTrue(
						PublicCommon.verifyElementIsVisible(Option2 + " product row",
								getElement(ProductPage_PublicAdmin.setSearchAttribute(Option2)), driver),
						Option2 + " is not displayed");
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to verify Products in Product Table", e);
		}
	}

	@Step(" Move to specific journal and verify DOI and issues of journal")
	public void moveToSpecificJournalAndVerifyDOIAndIssue(String journalName, String journalSKU) {
		try {
			JournalsPage_Public journalsPage_public = commonPage.navigateToJournals();
			ReusableMethods.scrollIntoView(journalsPage_public.getElement(journalsPage_public.getJournalByName("Advances in Civil Engineering Materials")), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod(journalName, journalsPage_public.getJournalByName(journalName), "Failed to locate " + journalName + "");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("First Look Tab", journalsProductPage.firstLookPapersTab, "Failed to click on First Look Tab");
			ReusableMethods.scrollIntoView(journalsProductPage.getElement(journalsProductPage.DOIIssueLink), driver);
			String doiIssue = journalsProductPage.getElement(journalsProductPage.DOIIssueLink).getText();
			Assert.assertTrue(doiIssue.contains(journalSKU), "Issue name does not  matches");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Issue tab", journalsProductPage.issuesTab, "Failed to click on issue tab");
			if (!(journalsProductPage.getIssuesLinkElements().size() > 0)) {
				Assert.assertTrue(false, "Journal issues not present");
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to Move to specific journal and verify DOI and issues of journal", e);
		}
	}


	@Step("Get Product description from Product details page")
	public String getProductDescriptionASTMPage() {
		String text = null;
		try {
			text = getElementNew(standardProductPage.productDescriptioPDPPage).getText().replace("/n", " ")
					.replace("\n", " ");
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to get Productdescription", e);
			return text;
		}
	}

	@Step("Get Description field text")
	public String getDescriptionFieldTextFromPDPPageMagento() {
		try {
			ReusableMethods.scrollIntoView(productPageAdmin.getElementNew(productPageAdmin.descripionBtnProductPage),
					driver);
			PublicCommon.JSClick(productPageAdmin.getElementNew(productPageAdmin.descripionBtnProductPage), driver);
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			System.out.println(getElementNew(productPageAdmin.descriptionText).getText());
			return productPageAdmin.getElementNew(productPageAdmin.descriptionText).getText();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get description field text", e);
			return null;
		}
	}

	@Step("Get the data from db query result and store in HashMap")
	public String getDescriptionAttributeFromDBTable(Map<String, Object> actual) {
		String value = null;
		for (Map.Entry<String, Object> set : actual.entrySet()) {
			if (set.getKey().equalsIgnoreCase("Data")) {
				value = set.getValue().toString().split("description")[1];
				value = value.split("\",")[0];
				System.out.println(value);
			}

		}
		return value;
	}

	@Step("Get the data from magento fields")
	public HashMap<String, String> getAttributesFromMagento(List<HashMap<String, String>> dataMap) {
		HashMap<String, String> finalData = new HashMap<String, String>();
		try {
			finalData.putAll(getInputFieldDataFromProductPage(getListOfAttributes(dataMap.get(0))));
			finalData.putAll(getDropDownDataFromProductPage(getListOfAttributes(dataMap.get(1))));
			finalData.putAll(getTogglesDataFromProductPage(getListOfAttributes(dataMap.get(2))));
			String priceValue = productPageAdmin.getElementNew(productPageAdmin.priceFieldProductPage)
					.getAttribute("value").split("\\.")[0];
			finalData.put("price", priceValue);
			return finalData;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get data frommagento fields", e);
			return finalData;
		}
	}

	@Step("Get price of product from Magento")
	public String getPrice() {
		try {
			ReusableMethods.scrollIntoView(productPageAdmin.getElementNew(productPageAdmin.priceFieldProductPage), driver);
			String priceValue = productPageAdmin.getElementNew(productPageAdmin.priceFieldProductPage)
					.getAttribute("value").split("\\.")[0];
			return priceValue;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get price of product from Magento", e);
			return null;
		}
	}
	@Step("Get Asset status of product from Magento")
	public String getAssetStatus()
	{
		try {
			ReusableMethods.scrollIntoView(productPageAdmin.getElementNew(productPageAdmin.assetStatus),driver);
			String assetStatus = productPageAdmin.getElementNew(productPageAdmin.assetStatus)
					.getAttribute("value");
			return assetStatus;
			}
		catch (Exception e)
		{
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get price of product from Magento", e);
			return null;
		}
	}
	@Step("Get product_group_codeValue of product from Magento")
	public String getProductGroupCode() {
		try {
			ReusableMethods.scrollIntoView(productPageAdmin.getElementNew(productPageAdmin.product_group_codeFieldProductPage), driver);
			String product_group_codeValue = productPageAdmin.getElementNew(productPageAdmin.product_group_codeFieldProductPage)
					.getAttribute("value");
			return product_group_codeValue;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get product_group_code of product from Magento", e);
			return null;
		}
	}

	@Step("Get sku  of product from Magento config table")
	public String getSKUConfigTable() {
		try {
			ReusableMethods.scrollIntoView(productPageAdmin.getElementNew(productPageAdmin.skuConfigTable), driver);
			String sku = productPageAdmin.getElementNew(productPageAdmin.skuConfigTable).getText().trim();
			return sku;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get product_group_code of product from Magento", e);
			return null;
		}
	}

	@Step("Verify that store code '{storeCode}' is selected in magento")
	public void verifyStoreCode(String storeCode) {
		try {
			if (storeCode.equalsIgnoreCase("ASTM")) {
				storeCode = "Main Website";
			}
			Assert.assertTrue(getElement(ProductPage_PublicAdmin.getCheckBoxStoreCode(storeCode)).isSelected());
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify store code", e);
		}
	}

	@Step("Get attribute '{attribute}' from magento product details page")
	public String getAttributeFromPDPPage(String attribute) {
		try {
			ReusableMethods.scrollIntoView(getElementNew(productPageAdmin.getAttributeName(attribute)), driver);
			String actualText = getElementNew(productPageAdmin.getAttributeName(attribute)).getAttribute("value");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return actualText;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get attribute from magento fields", e);
			return null;
		}
	}

	@Step("Get attribute '{attribute}' from magento product details page")
	public String getAttribute(By locator) {
		try {
			ReusableMethods.scrollIntoView(getElementNew(locator), driver);
			String actualText = getElementNew(locator).getAttribute("href");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return actualText;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get attribute from magento fields", e);
			return null;
		}
	}

	@Step("Get attribute '{attribute}' from magento product details page")
	public String getAttributeOnClick(By locator) {
		try {
			ReusableMethods.scrollIntoView(getElementNew(locator), driver);
			String actualText = getElementNew(locator).getAttribute("onclick");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return actualText;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get attribute from magento fields", e);
			return null;
		}
	}

	@Step("Navigate to configuration page on Admin page")
	public void navigateToConfigurationPage() {
		try {
			assertTrue(adminMenuNavigation.clickStoresMainButton(), "Click Stores button.");
			assertTrue(adminMenuNavigation.clickConfigurationsButton(), "Click configuration button.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
		}

	}

	public String getDescriptionTextFromConfigurationPage() {
		String text = null;
		try {
			ReusableMethods.scrollIntoView(getElementNew(adminMenuNavigation.pimDropDown), driver);
			PublicCommon.JSClick(getElementNew(adminMenuNavigation.pimDropDown), driver);
			PublicCommon.JSClick(getElementNew(adminMenuNavigation.productTypeSetting), driver);
			driver.switchTo().frame("pim_products_membership_informational_description_ifr");
			ReusableMethods.scrollIntoView(getElementNew(adminMenuNavigation.informationalDescription), driver);
			text = getElementNew(adminMenuNavigation.informationalDescription).getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return text;
		} finally {
			driver.switchTo().parentFrame();
		}
	}

	@Step("Get Description field text")
	public String getDescriptionField() {
		try {
			ReusableMethods.scrollIntoView(productPageAdmin.getElementNew(productPageAdmin.descripionBtnProductPage),
					driver);
			PublicCommon.JSClick(productPageAdmin.getElementNew(productPageAdmin.descripionBtnProductPage), driver);
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return productPageAdmin.getElementNew(ProductPage_PublicAdmin.descriptionPagetext).getText().replace("ROW", "");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get description field text", e);
			return null;
		}
	}

	public String changeDateFormat(String date, String type, String typeToConvert) {
		String newDateString = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(type);
			Date d = sdf.parse(date);
			sdf.applyPattern(typeToConvert);
			newDateString = sdf.format(d);
			return newDateString;
		} catch (Exception e) {
			e.printStackTrace();
			return newDateString;
		}
	}

	@Step("Verify '{linkText}' is present in table of content and open the link")
	public void verifyTableOfContentLink(String linkText, int count) {
		try {
			List<WebElement> links = getElementsNew(standardPage.productPageTableLinks);
			Assert.assertTrue(links.size() >= count);
			List<String> linksName = PublicCommon.getListOfTextFromListOfWebelements(links, driver);
			Assert.assertTrue(linksName.contains(linkText));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Product link", standardPage.getProductPageTableLink(linkText));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(standardPage.productPageCartBtn));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.navigate().refresh();
			PublicCommon.waitForSec(2);
			clickOnMethod("Add to cart button", standardPage.productPageCartBtn);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(standardPage.shoppingCartLink));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("shopping cart link", standardPage.shoppingCartLink);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify table of content link ", e);
		}
	}

	@Step("Navigate to Login Page and Log-in with valid credentials.")
	public void loginPublic(String username, String password) {
		try {
			clickOnMethod("Sign-in button", commonPage.signInLink);
			assertTrue(loginPage.clickSignInButton(), "Click on Sign-in button");
			assertTrue(loginPage.compassLogin(username, password), "Login Failed");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login ", e);
		}
	}

	@Step("Entering the Details for New Registeration")
	public void EnterDetailsforRegisteration(String email) {
		try {
			creatAccount.newUserRegistrationWithOrgField("ASTM", email);
			assertNotNull(email, "New User Registeration process should be complete");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter details for registration", e);
		}

	}

	@Step("Create a new account, Enter Details for New Registration and Click on Create Account")
	public void registerNewUser(String email) {
		try {
			ReusableMethods.scrollIntoView(ASTMCartPage.getElement(ASTMCartPage.createNewAccount), driver);
			clickOnMethod("Create Account on Create New Account button", ASTMCartPage.createNewAccount,
					"Create Account button should be clickable");
			EnterDetailsforRegisteration(email);
			// clickONMethod("Create Account on Registration Page",
			// createAccountPage.createAnAccountButton, "After entering details Create
			// account button should be clickable");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to register a new user", e);
		}
	}

	@Step("Select Payment Method : {paymentMethod} and Enter PO Number: {poNumber}")
	public void paymentMethodAndPONumber(String paymentMethod, String poNumber) {
		try {
			assertTrue(paymentOptionsPage.selectPaymentMethodAndEnterPONumber(paymentMethod, poNumber),
					"Payment Method should be Selected");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select Payment Method", e);
		}
	}

	@Step("Open searched product and verify product page is displayed")
	public void openSearchedProductAndVerifyCartButton(String page) {
		try {
			clickOnMethod("Searched Product", standardProductPage.searchedProduct, "Unable to find product");
			Assert.assertTrue(commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon),
					"unable handle spinner icon");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(getPageTitle().equalsIgnoreCase(page));
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, standardPage.productPageCartBtn));
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select searched product", e);
		}
	}

	@Step("MouseHover {0}")
	public void mouseHover(String elementName, WebElement element) {
		try {
			assertTrue(ReusableMethods.mouseHoverWithAction(driver, element, elementName),
					elementName + " mouseHover failed.");

		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
			e.getStackTrace();// TODO: handle exception
		}

	}

	@Step("Navigate to Journals page")
	public void navigateToJournalPage() {

		try {
			PublicCommon.waitForSec(5);
			mouseHover("Products & Services option", commonPage.getProductsAndServicesNavigation());
			mouseHover("Standards And Publications option", commonPage.getStandardsAndPublicationsOptions());
			ScreenshotUtil.takeScreenshotForAllure(driver);
			commonPage.getElement(commonPage.journals).click();
			verifyVisibility("Journals Header", journalsPage.journalsHeader, "Journal header is not displayed");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}

	@Step("Verify about this journal tab is opened and switch to '{tabNametoSwitch}' tab")
	public void verifyAboutTabAndSwitchTab(String tabName, String tabNametoSwitch) {
		try {
			Assert.assertTrue(getElementNew(standardProductPage.tabHeader).getText().equalsIgnoreCase(tabName));
			clickOnMethod("Tab link", standardProductPage.getTabElementByName(tabNametoSwitch));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select tab", e);
		}
	}

	@Step("Verify '{linkText}' is present in issue tab and open the link")
	public void verifyIssueTabLinks(String linkText, int count) {
		try {
			List<WebElement> links = getElementsNew(standardPage.productPageIssueLinks);
			System.out.println(links.size());
			Assert.assertTrue(links.size() >= count);
			List<String> linksName = PublicCommon.getListOfTextFromListOfWebelements(links, driver);
			Assert.assertTrue(linksName.contains(linkText));
			ReusableMethods.scrollIntoView(getElementNew(standardPage.getProductPageTableLink(linkText)), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Product link", standardPage.getProductPageTableLink(linkText));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify table of content link ", e);
		}
	}

	@Step("Verify '{statement}' od annual issue")
	public void verifyStatementProgress(String expectedResult) {
		String progressStatement = PublicCommon.getText(driver, journalsProductPage.progressStament);
		Assert.assertTrue(progressStatement.contains(expectedResult), "Statement progress is not matched");
	}

	@Step("Verify '{published date}' od annual issue")
	public void verifyPublishedDate(String expectedResult) {
		String publishedDate = PublicCommon.getText(driver, journalsProductPage.publishedDate);
		Assert.assertTrue(publishedDate.contains(expectedResult), "published date is not matched");
	}

	@Step("Click on View Abstract button for product '{productName}'")
	public void clickViewAbstractButton(String productName) {
		try {
			ReusableMethods.scrollIntoView(getElementNew(standardProductPage.getViewAbstractBtn(productName)), driver);
			clickOnMethod("Click on view abstract button", standardProductPage.getViewAbstractBtn(productName));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on View Abstract button", e);
		}
	}

	@Step("Click on View PDF button for product '{productName}'")
	public void clickViewPDFButton(String productName) {
		try {
			ReusableMethods.scrollIntoView(getElementNew(standardProductPage.getViewPDFButtonOfParticlarPDF(productName)), driver);
			clickOnMethod("Click on view PDF button", standardProductPage.getViewPDFButtonOfParticlarPDF(productName));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on View PDF button", e);
		}
	}

	@Step("Open Journal '{productName}' page")
	public void openJournalProductPage(String productName) {
		try {
			ReusableMethods.scrollIntoView(getElement(journalsPage.getJournalByName(productName)), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(journalsPage.getJournalByName(productName)),5);
			clickOnMethod("Journal Link", journalsPage.getJournalByName(productName), "Unable to click on Journal link");
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to open journal", e);
		}
	}


	@Step("Navigate to BOS page")
	public void navigateToBOS() {

		try {
			mouseHover("Products & Services option", commonPage.getProductsAndServicesNavigation());
			mouseHover("getBookOfStandardsOptions", commonPage.getBookOfStandardsOptions());
			ScreenshotUtil.takeScreenshotForAllure(driver);
			commonPage.getBookOfStandardsOptions().click();
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}

	@Step("Click on BOS section product link")
	public void clickOnBOSSectionProduct(String productSectionName) {

		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(bos_pagePublic.getBOSSection(productSectionName), driver);
			bos_pagePublic.getBOSSection(productSectionName).click();
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}
	@Step("Click on BOS section product link")
	public void clickOnBOSVolumeProduct(String productVolumeName) {

		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(bos_pagePublic.getBOSVolume(productVolumeName), driver);
			bos_pagePublic.getBOSVolume(productVolumeName).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}
	@Step("Verify \"{0}\" on \"{1}\" page. ")
	public void verifyList(String message,String productHeader,List<String> actualList,List<String> expectedList) {
		try {
			
			System.out.println(actualList);
			System.out.println(expectedList);
			Assert.assertEquals(actualList, expectedList,message+" don't match the expected result.");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify list: ", e);
		}

	}
	@Step("Verify Navigation To Sales Force Page.")
	public void verifyNavigationToSalesForcePage(String contactSalesUrl) {
		try {
			PublicCommon.verifyContentOnPage("Saleforce page url", contactSalesForcePage.getContactSalesPageUrl(), contactSalesUrl);
			assertTrue(PublicCommon.verifyElementIsVisible("Contact Sales force header",contactSalesForcePage.getPageHeaderElement(), driver),"Contact SalesForce header is visible.");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify ASTM Product url: ", e);
		}

	}
	public int getProductListSize(String productName) {
		if (adminMenuNavigation.getProductEditButtonElmentString(productName).isDisplayed()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Step("Click on add to cart button and navigate to shooping cart")
	public void addProductToCartAndGoTocart() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(standardPage.productPageCartBtn));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Add to cart button", standardPage.productPageCartBtn);
			clickOnMethod("shopping cart link", standardPage.shoppingCartLink);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to add product to cart ", e);
		}
	}

	@Step("Create new order with TPT product {productSKU}")
	public void createOrderWithTPT(String productSKU) {
		try {
			clickOnMethod("Create Order button", customerViewPage.getCreateOrderButton(),
					"Unable to click on Create order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product by SKU button", customerViewPage.addProductSKU,
					"Unable to click on Add product by SKU button");
			ReusableMethods.scrollIntoView(getElement(customerViewPage.addToOrderBtn), driver);

			enterText("Product SKU box", customerViewPage.addSKUNumber, productSKU,
					"Unable to enter Product SKU number");
			enterText("Product Quantity box", customerViewPage.addproductQty, "1", "Unable to enter product quantity");
			PublicCommon.JSClick(getElement(customerViewPage.addToOrderBtn), driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			PublicCommon.selectValueInDropdownbyIndex(getElementNew(customerViewPage.contactDropDown), 1);
			PublicCommon.JSClick(getElementNew(customerViewPage.updateItemsButton), driver);
			if (PublicCommon.isWebElementDisplayed(driver, customerViewPage.configureMessage)) {
				addProductConfiguration();
			}
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(customerViewPage.additionalInfoHeader), driver);
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.majorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(PublicCommon.selectValueInDropdown(getElement(customerViewPage.minorPromoCodeDropdown),
					"ASTM - ASTM"));
			Assert.assertTrue(
					PublicCommon.selectValueInDropdown(getElement(customerViewPage.salesChannelDropdown), "WEB - Web"));
			clickOnMethod("Submit order button", customerViewPage.submitOrderBtn,
					"Unable to Click on submit order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Create new order", e);

		}
	}

	@Step("Filter product by : {productType} ,{public_Listing},{visibility}")
	public void searchProductByProductTypeAndVisibility(String productType, String visibility) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectVisibilityType), visibility);


			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to filter product by product type", e);
		}
	}

	@Step("Filter product by product type: {productType} ,{public_Listing},{visibility}")
	public void searchProductByProductTypePublicListingAndVisibility(String productType, String public_Listing, String visibility) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear fliter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear fliter link");
			}
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectproductType), productType);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectPublicListingType), public_Listing);
			IntegrationCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectVisibilityType), visibility);


			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Unable to filter product by product type", e);
		}
	}

	@Step("Get Attribute '{at}' value from DB")
	public String getAttributeValueFromDB(String at, Map<String, Object> actual) {
		String value = actual.toString().split(at)[1].split(",")[0];
		value = value.replaceAll("[^a-zA-Z0-9/.-]", "");
		return value;
	}

	@Step("Get Attribute '{at}' value from Magento Product details page")
	public String getInputAttributeValueFromMagento(String at) {
		return productPageAdmin.getAttributeNamesElement(at).getAttribute("value").replaceAll(" ", "");
	}


	@Step("Get Child assets from DB")
	public String getChildAssetsFromDB(Map<String, Object> actual) {
		System.out.println(actual.toString());
		String value = actual.toString().replaceAll("\"", "").split("child-asset:")[1].split("]")[0];
		value = value.replaceAll("[^a-zA-Z0-9,-:]", "");
		System.out.println(value);
		return value;
	}

	@Step("Get child assets from magento")
	public String getChildAssetsFromMagento() {
		try {
			String text = productPageAdmin.getElementNew(productPageAdmin.childAssetsProductPage).getAttribute("value");
			text = text.replaceAll("[^a-zA-Z0-9,-:]", "");
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Step("Verify Product Classification Label '{expected}' is displayed")
	public void verifyProductClassificationLabel(String expected) {
		try {
			String actualLabel = getElement(standardProductPage.productClassificationBadge).getText();
			Assert.assertTrue(actualLabel.equalsIgnoreCase(expected));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Product Classification Label", e);
		}
	}

	@Step("Verify Publication year Label with text '{expected}' is displayed")
	public void verifyPublishedYear(String expected) {
		try {
			String actualLabel = getElement(standardProductPage.publishedYearBadge).getText();
			Assert.assertTrue(actualLabel.contains(expected));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Product Classification Label", e);
		}
	}

	@Step("Verify Product Status Label")
	public void verifyProductStatusLabel(String expected) {
		try {
			String actualLabel = getElement(standardProductPage.productStatusBadge).getText();
			Assert.assertTrue(actualLabel.contains(expected));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Product Status Label", e);
		}
	}

	@Step("Select format and language dropdown.")
	public void selectProduct(String format, String language) {
		try {
			assertTrue(PublicCommon.selectValueInDropdown(productPage1.getFormatDropdown(), format),
					"Couldn't select format");
			assertTrue(PublicCommon.selectValueInDropdown(productPage1.getLanguageDropdown(), language),
					"Couldn't select language");
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(productPage1.addToCartButton),driver);
			clickOnMethod("Add to cart button", productPage1.addToCartButton, "Couldn't click on ADD to Cart button");

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select format and language dropdown", e);
		}
	}

	@Step("Verify format dropdown option ")
	public void verifyFormatDropDownOption(String option1, String option2) {
		try {
			clickOnMethod("Format DropDown", productPage1.formatDropdown, "Failed to click on Format Dropdown");
			assertTrue(getElement(productPage1.formatDropdown).getText().contains(option1), "Failed to locate " + option1 + "  in format dropdown");
			assertTrue(getElement(productPage1.formatDropdown).getText().contains("Hard Copy"), "Failed to locate " + option2 + " option in format dropdown");
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify format dropdown option", e);
		}
	}

	@Step("Verify format dropdown value ")
	public void verifyFormatValue(String option) {
		try {
			clickOnMethod("Format DropDown", productPage1.formatDropdown, "Failed to click on Format Dropdown");
			assertTrue(getElement(productPage1.formatDropdown).getText().contains(option), "Failed to locate " + option + "  in format dropdown");
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify format dropdown option", e);
		}
	}

	@Step("Get default value for language dropdown")
	public String getDefaultLanguageDropDownOption() {
		try {
			PublicCommon.waitForSec(2);
			Select select = new Select(driver.findElement(By.xpath("//select")));
			WebElement option = select.getFirstSelectedOption();
			String defaultItem = option.getText();
			return defaultItem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Verify language dropdown value is '{actualLanguage}'")
	public void verifyLanguageDropDownValue(String actualLanguage, String expectedLanguage) {
		Assert.assertTrue(actualLanguage.contains(expectedLanguage));
	}

	@Step("Verify language displayed in URL: '{isLanguageExpected}'")
	public void verifyLanguageInURL(String language, boolean isLanguageExpected) {
		try {
			String url = driver.getCurrentUrl();
			boolean isLanguageDisplayed = url.contains(language);
			Assert.assertTrue(isLanguageDisplayed == isLanguageExpected);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify language variable in url", e);
		}
	}

	@Step("Get link and version for searched product in search result page")
	public HashMap<String, String> getSearchedProductLinkAndVersion() {
		HashMap<String, String> hm = new HashMap<>();
		try {
			String version = standardProductPage.getElementNew(standardProductPage.getSearchResultVersion).getText();
			String url = standardProductPage.getElementNew(standardProductPage.searchedProduct).getAttribute("href");
			hm.put("version", version);
			hm.put("url", url);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get version and link", e);
		}
		return hm;
	}

	@Step("Verify link and url are same in PDP page and search result page")
	public void veriyLinkAndVersion(HashMap<String, String> data) {
		try {
			String versiondropDownBadge = standardProductPage.getElementNew(standardProductPage.getDefaultVersionBadge).getText();
			String versionLabel = standardProductPage.getElementNew(standardProductPage.productStatusBadge).getText();
			Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(data.get("url")));
			Assert.assertTrue(data.get("version").equalsIgnoreCase(versionLabel));
			Assert.assertTrue(data.get("version").equalsIgnoreCase(versiondropDownBadge));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify link and version", e);
		}
	}

	@Step("Verify language dropdown has language '{expected}' option")
	public void verifyLanguageDropDownOptions(List<String> actual, List<String> expected) {
		Iterator<String> itr = expected.iterator();
		while (itr.hasNext()) {
			Assert.assertTrue(actual.contains(itr.next()));
		}
	}

	@Step("Search a product in Create order page by sku")
	public void searchProductSkuInCreateOrderPage(String productSKU) {
		try {
			PublicCommon.waitForSec(2);
			clickOnMethod("Create Order button", customerViewPage.getCreateOrderButton(),
					"Unable to click on Create order button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Add product by SKU button", customerViewPage.addProductSKU,
					"Unable to click on Add product by SKU button");
			ReusableMethods.scrollIntoView(getElement(customerViewPage.addToOrderBtn), driver);

			enterText("Product SKU box", customerViewPage.addSKUNumber, productSKU,
					"Unable to enter Product SKU number");
			enterText("Product Quantity box", customerViewPage.addproductQty, "1", "Unable to enter product quantity");
			PublicCommon.JSClick(getElement(customerViewPage.addToOrderBtn), driver);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Add product by SKU button", customerViewPage.addProductBtn,
					"Unable to click on Add product by SKU button");
			enterText("Product SKU box", customerViewPage.skuField, productSKU,
					"Unable to enter Product SKU number");
			driver.findElement(customerViewPage.skuField).sendKeys(Keys.ENTER);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Step("Verify product is not available in Create order page and error message is displayed")
	public void verifyProductNotAvailableInCreateOrderPage() {
		try {
			if (PublicCommon.isWebElementDisplayed(driver, customerViewPage.configureMessage)) {
				ReusableMethods.scrollIntoView(customerViewPage.getElementNew(customerViewPage.configureMessage), driver);
				String text = customerViewPage.getElementNew(customerViewPage.configureMessage).getText().trim();
				Assert.assertTrue(text.equalsIgnoreCase("Product that you are trying to add is not available."));
			} else {
				Assert.fail("Product not available error message fails to display");
			}
			String errorMsg = customerViewPage.getElementNew(customerViewPage.noDataMsge).getText().trim();
			Assert.assertTrue(errorMsg.equalsIgnoreCase("We couldn't find any records."));

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Product is available", e);
		}
	}

	@Step("Get value for attribute '{attributeName}' from magento product details page")
	public String getTextAreaAttributeFromMagento(String attributeName) {
		try {
			return getElementNew(productPageAdmin.getAttributeByName(attributeName)).getAttribute("value");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Verify that View abstract button is not available for free product '{productName}'")
	public void verifyViewAbstractBtnInTOCPage(String productName) {
		ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.getJournalAbstractBtn(productName)), driver);
		Assert.assertFalse(PublicCommon.isWebElementDisplayed(driver, journalsPage.getJournalAbstractBtn(productName)));
	}

	@Step("Verify that add to cart button is not available for free product '{productName}'")
	public void verifyAddToCartBtnInTOCPage(String productName) {
		ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.getJournalAddToCartBtn(productName)), driver);
		Assert.assertFalse(PublicCommon.isWebElementDisplayed(driver, journalsPage.getJournalAddToCartBtn(productName)));

	}

	@Step("Verify that View PDF button is available for free product '{productName}'")
	public void verifyViewPDFBtnInTOCPage(String productName) {
		ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.getJournalPDFBtn(productName)), driver);
		Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, journalsPage.getJournalPDFBtn(productName)));
	}

	@Step("Verify Price for free product '{productName}'")
	public void verifyPrice(String productName, String expected) {
		ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.getJournalPrice(productName)), driver);
		Assert.assertTrue(journalsPage.getElementNew(journalsPage.getJournalPrice(productName)).getText().contains(expected));
	}

	@Step("Verify Price on attribute page")
	public String verifyPriceOnAttributePage(String expected) {
		ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.priceOnAttributePage), driver);
		Assert.assertTrue(journalsPage.getElementNew(journalsPage.priceOnAttributePage).getText().contains(expected));
		return journalsPage.getElementNew(journalsPage.priceOnAttributePage).getText();
	}

	@Step("Verify Price on attribute page")
	public String verifyFreePriceOnAttributePage(String expected) {
		ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.FreePriceOnAttributePage), driver);
		Assert.assertTrue(journalsPage.getElementNew(journalsPage.FreePriceOnAttributePage).getText().contains(expected));
		return journalsPage.getElementNew(journalsPage.FreePriceOnAttributePage).getText();
	}


	@Step("Verify Journal text '{productName}' is displayed as hyperlink ")
	public void verifyJournalNameIsHyperLink(String productName) {
		ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.getJournalByName(productName)), driver);
		String linkUrl = journalsPage.getElementNew(journalsPage.getJournalByName(productName)).getAttribute("href");
		Assert.assertFalse(StringUtils.isBlank(linkUrl));
	}

	/**
	 * Validate navigation and header for specific journal product
	 *
	 * @param page: page name (also same as journal page header)
	 */
	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageMPC(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickMPC(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageSSMS(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickSSMS(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageACEM(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickACEM(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageJOTE(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickJOTE(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageGTJ(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickGTJ(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageJAI(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickJAI(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageJOFS(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickJOFS(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageCCA(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickCCA(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}

	@Step("Validate navigation to Journals Page: {page}")
	public void validateNavigationToJournalsPageJCTR(String page, String header) {
		try {
			Assert.assertTrue(journalsPage.clickJCTR(), "Clicked on link for page: " + page);

			String actualHeader = journalsProductPage.getPageTitle();
			Assert.assertTrue(actualHeader.contains(header), "Header Validation on landing on: " + page + " page. Actual: " + actualHeader + " Expected: " + header);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception", e);
		}
	}


	@Step("Switch to issue tab of journal")
	public void switchToIssueTabOfJournal() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(journalsProductPage.issuesTab));
		journalsProductPage.clickIssueTab();
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("#issues"));
		Assert.assertTrue(driver.getCurrentUrl().contains("#issues"));
	}
	@Step("Switch to subscription tab of journal")
	public void switchToSubscriptionTabOfJournal() {
		Assert.assertTrue(journalsProductPage.clickSubscriptionTab(), "Clicked on Issue tab.");
	}

	@Step("Click on issue link in issue tab page  of journal")
	public void clickIssueLinkOfIssueTab() {
		Assert.assertTrue(journalsProductPage.clickIssueLinkInIssueTab(), "Clicked on Issue tab.");
	}

	@Step("Click on given issue link in issue tab page  of journal")
	public void clickTheGivenIssueLinkOfIssueTab(Boolean click) {
		Assert.assertTrue(click, "Clicked on Issue link in Issue tab.");
	}

	@Step("Validate the 'View Abstract' button of issue link")
	public void verifyViewAbstractBtn() {
		try {
			String articleHeader = journalsProductPage.getElements(journalsProductPage.listingArticles).get(0)
					.getText();
			verifyVisibility("View Abstract button", journalsProductPage.abstractViewBtn,
					"View Abstract button is not visible");
			journalsProductPage.getElements(journalsProductPage.abstractViewBtn).get(0).click();
			Assert.assertTrue(journalsProductPage.getElement(journalsProductPage.articlesHeader).getText()
					.contains(articleHeader), "PUB-3226:View Abstract page is not opened");
			verifyVisibility("Add to cart button on Article page", journalsProductPage.addToCartBtn,
					"Add to Cart is not visible");
			driver.navigate().back();
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}

	}

	@Step("Verify the 'Add to cart' button  of issue link")
	public void verifyAddToCartBtn() {
		try {
			verifyVisibility("Add to cart button on Article page", journalsProductPage.addToCartBtn,
					"Add to Cart is not visible");
			Assert.assertTrue(journalsProductPage.clickAddToCartBtn(), "PUB-3528: Add to cart button is not clicked");
			// assertTrue(driver.getCurrentUrl().contains(dataMap.get("CartPageUrl")));
			driver.navigate().back();
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}

	}

	@Step("Verify {0}")
	public void compareInt(String message, int actual, int expected) {
		try {
			assertEquals(actual, expected);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Exception.", e);
		}
	}

	@Step("Verify format as PDF from issue page")
	public void verifyFormat(String format) {
		List<WebElement> formatElements = journalsProductPage.getFormatIssueLinkElements();

		for (WebElement formatEle : formatElements) {
			Assert.assertEquals(formatEle.getText().trim(), format);
		}
	}

	@Step("Verifying DOI value is '{expected}'")
	public void verifyDOI(String expected) {
		try {
			ReusableMethods.scrollIntoView(standardProductPage.getElementNew(standardProductPage.productPageDOI), driver);
			Assert.assertTrue(standardProductPage.getElementNew(standardProductPage.productPageDOI).getText().contains(expected));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify DOI.", e);
		}
	}

	public String urlDecoder(String url) {
		try {
			String result = java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
			return result;
		} catch (UnsupportedEncodingException e) {
			return null;
			// not going to happen - value came from JDK's own StandardCharsets
		}

	}

	public String base64Decoder(String url) {
		try {
			Base64.Decoder decoder = Base64.getUrlDecoder();
			String dStr = new String(decoder.decode(url));
			return dStr;
		} catch (Exception e) {
			return null;
		}

	}


	@Step("Navigate to url rewrites page through marketing ")
	public void openUrl_RewritesPage() {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Marketing button", URLRewrites_PublicAdmin.marketingButton, "unable to click on Catalog button");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(URLRewrites_PublicAdmin.url_RewritesLink));
			clickOnMethod("URL rewrite Link", URLRewrites_PublicAdmin.url_RewritesLink, "unable to click on Product Link");
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed Navigate to url rewrites page through marketing ", e);
		}
	}

	@Step("Search for the product by request path {requestValue} and target path '{targetValue}'")
	public void searchRequestAndTargetPath(String requestValue, String targetValue) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(URLRewrites_PublicAdmin.resetFilters).isDisplayed()) {
				clickOnMethod("Reset filter link", URLRewrites_PublicAdmin.resetFilters,
						"unable to click on Clear filter link");
			}
			PublicCommon.waitForSec(3);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			enterText("request path", URLRewrites_PublicAdmin.requestPathField, requestValue, "Failed to enter value in Request Path");
			enterText("target path", URLRewrites_PublicAdmin.targetPathField, targetValue, "Failed to enter value in Target Path");

			clickOnMethod("Search button", URLRewrites_PublicAdmin.searchButton,
					"Failed to click  on search button");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}

	@Step("Verify that target path value is '{expectedValue}'")
	public void verifyTargetPathValue(String expectedValue) {
		String actualValue = getElementNew(URLRewrites_PublicAdmin.tableTargetPathData).getText();
		Assert.assertTrue(actualValue.contains(expectedValue));
	}

	@Step("Verify that one record is present for request and target url'")
	public void verifyRecord() {
		String actualValue = getElementNew(URLRewrites_PublicAdmin.tableTargetPathData).getText();
		System.out.println(actualValue);
		Assert.assertTrue(actualValue != null);

	}

	@Step("Move to Configuration And Change Environment And Save it")
	public void movetoConfigurationAndChangeEnvironmentAndSave(String environment) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Main Page Store", ProductPage_PublicAdmin.mainPageStore, "Unable to click on Store");
			WaitStatementUtils.waitForElementToBeClickable(driver, adminProductPages.getElementNew(ProductPage_PublicAdmin.configuration));
			clickOnMethod("Configuration", ProductPage_PublicAdmin.configuration, "Unable to click on Configuration");
			WaitStatementUtils.waitForElementToBeClickable(driver, adminProductPages.getElementNew(ProductPage_PublicAdmin.astmSettings));
			clickOnMethod("Astm Settings", ProductPage_PublicAdmin.astmSettings, "Unable to click on Astm Settings");
			WaitStatementUtils.waitForElementToBeClickable(driver, adminProductPages.getElementNew(ProductPage_PublicAdmin.selectenvironment));
			PublicCommon.selectValueInDropdown(getElement(ProductPage_PublicAdmin.selectenvironment), environment);
			WaitStatementUtils.waitForElementToBeClickable(driver, adminProductPages.getElementNew(ProductPage_PublicAdmin.saveConfig));
			if(PublicCommon.isWebElementDisplayed(driver, ProductPage_PublicAdmin.warningModalHeader)){
				clickOnMethod("Ok button in warning popup", ProductPage_PublicAdmin.warningModalOkButton, "Unable to click on Ok button");
			}
			clickOnMethod("Save Configuration", ProductPage_PublicAdmin.saveConfig, "Unable to click on Save Configuration");
			WaitStatementUtils.waitForElementToBeClickable(driver, adminProductPages.getElementNew(ProductPage_PublicAdmin.successMsg));

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Move to Configuration And Change Environment And Save it", e);
		}
	}


	@Step("Verify multiple paid article hyper links present under table of content")
	public void verifyMultipleArticleHyperlinksUnderTableOfContent() {
		List<WebElement> allLinks = getElements(standardPage.productPageTableLinks);
		Assert.assertTrue(allLinks.size() > 1);
	}

	@Step("Verify free article hyper links present under table of content")
	public void verifyFreeArticleHyperlinksUnderTableOfContent() {
		List<WebElement> allLinks = getElements(standardPage.freeChapterLink);
		Assert.assertTrue(allLinks.size() >= 1);
	}

	public void openProductPageTableOfContentLink(String link) {
		try {
			clickOnMethod("Table of content link", standardPage.getProductPageTableOfContentLinks(link));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Step("Verify Coden")
	public void verifyCoden(String expectedResult, String actualResult) {
		//ReusableMethods.scrollIntoView(getElement(productPageAdmin.Coden), driver);
		Assert.assertTrue(expectedResult.equalsIgnoreCase(actualResult), "Coden is not same");

	}


	@Step("Get value for '{attribute}' for product '{product}' from journal page")
	public String getJournalProductAttribute(String product, String attribute) {
		try {
			String value = journalsPage.getElement(journalsPage.getProductAttributeLocatorByText(product, attribute)).getText();
			value = value.split(":")[1].trim();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Step("Get author names from magento")
	public String getAuthorNameFromMagentoValueFetched(String value) {
		try {
			String authorName = "";
			String temp = value.split("author")[1].replaceAll("[^a-zA-Z0-9:,-]", "");
			String[] authorNames = temp.replaceFirst(":", "").split(",");
			for (String text : authorNames) {
				if (text.contains("fname")) {
					String name = text.split(":")[1];
					authorName = authorName + " " + name;
				}
				if (text.contains("surname")) {
					String name = text.split(":")[1];
					authorName = authorName + " " + name;
				}
			}
			System.out.println(authorName);
			return authorName.trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Step("Open child '{childProductSKU}' product page ")
	public void openChildProduct(String childProductSKU) {
		try {
			ReusableMethods.scrollIntoView(getElementNew(productPageAdmin.getSectionHeader("Current Variations")), driver);
			clickOnMethod("Child product link", productPageAdmin.getChildProductElement(childProductSKU));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPriceForChildProduct(String productSKU) {
		try {
			ReusableMethods.scrollIntoView(getElementNew(productPageAdmin.getSectionHeader("Grouped Products")), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return productPageAdmin.getElementNew(productPageAdmin.getChildProductTableFieldValues(productSKU, "price")).getText().split("\\.")[0].replaceAll("[^a-zA-Z0-9]", "");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Step("Get price value from ASTM Web store")
	public List<String> getPriceListFromASTMWebStore() {
		List<String> priceFrontEnd = new ArrayList<>();
		try {
			List<WebElement> price = standardPage.getElementsNew(standardPage.price);
			for (WebElement el : price) {
				String value = el.getText();
				value = value.split("\\.")[0].replaceAll("[^a-zA-Z0-9]", "");
				priceFrontEnd.add(value);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return priceFrontEnd;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Step("Verifying the: {successText}")
	public void validateList(String successText, List<String> actualList, List<String> expectedList) {
		try {
			for(String value : expectedList)
			{
				assertTrue(actualList.contains(value), "Failed to verify value in the  List "+actualList+" value not found "+value+"");
			}
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception ex) {
			ex.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify value in the  List ", ex);
		}
	}

	@Step("Verify Price on attribute page")
	public void verifyPriceOnJournalProductPage(String expected) {
		if(PublicCommon.isWebElementDisplayed(driver, journalsPage.priceOnAttributePage)){
			ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.priceOnAttributePage), driver);
			Assert.assertTrue(journalsPage.getElementNew(journalsPage.priceOnAttributePage).getText().contains(expected));
		}else{
			ReusableMethods.scrollIntoView(journalsPage.getElementNew(journalsPage.FreePriceOnAttributePage), driver);
			String price = journalsPage.getElementNew(journalsPage.FreePriceOnAttributePage).getText().split(":")[1].trim();
			if(price.equalsIgnoreCase("Free")){
				price = "0";
			}
			Assert.assertTrue(price.equals(expected));
		}

	}

	 @Step("Get price of product from Frontend")
	    public String getPriceFrontEnd()
	    {
	        try {
	            ReusableMethods.scrollIntoView(getElement(standardProductPage.price),driver);
	            ScreenshotUtil.takeScreenshotForAllure(driver);
	           String price=getElement(standardProductPage.price).getText().split("\\$")[1];
	            return price;

	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            PublicCommon.reportFailAssert("Failed to get price of product from Frontend", e);
	            return null;
	        }
	    }
	 
	 @Step("Get status  of standard product from Frontend")
	    public String getStatusOfStandardProductFromFrontEnd()
	    {
	        try {
	            ReusableMethods.scrollIntoView(getElement(standardProductPage.assetStatus),driver);
	            ScreenshotUtil.takeScreenshotForAllure(driver);
	           String status=getElement(standardProductPage.assetStatus).getText();
	            return status;

	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            PublicCommon.reportFailAssert("Failed to get status of standard product from Frontend", e);
	            return null;
	        }
	    }

	@Step("Click on link by name and move to tab and validate value in URland closetab")
	public void clickOnLinkBynameAndMoveTonewlyOpenedTabAndValidateValueAndClose(String linkName,String value) {
		try {
			if(linkName.equalsIgnoreCase("Overview "))
			{
				ReusableMethods.scrollIntoView(journalsPage.getElement(standardPage.overviewLink), driver);
				clickOnMethod(linkName, standardPage.overviewLink, "Failed to click link " + linkName + "");

			}
			else
			{
				ReusableMethods.scrollIntoView(journalsPage.getElement(standardPage.getLinkByName(linkName)), driver);
				clickOnMethod(linkName, standardPage.getLinkByName(linkName), "Failed to click link " + linkName + "");
			}
			PublicAdminCommons.switchToNewOpenedTab(driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			Assert.assertTrue(driver.getCurrentUrl().contains(value));
			//System.out.println(journalsPage.getPageTitle());
			PublicAdminCommons.closeNewTabAndSwitchToOriginalTab(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed Click on link by name and move to tab and validate value in URl and closetab", e);
		}


	}
	@Step("Get Status Of Particular Product From Grouped Product Section")
	public String getStatusOfParticularProductFromGroupedProductSection(String fieldText)
	{
		try {
			ReusableMethods.scrollIntoView(standardPage.getElement(By.xpath("(//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='status']//span)[2]")), driver);
			String status = standardPage.getElement(By.xpath("(//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='status']//span)[2]")).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return status;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get Status Of Particular Product From Grouped Product Section", e);
			return null;
		}
	}
	@Step("Get price Of Particular Product From Grouped Product Section")
	public String getPriceOfParticularProductFromGroupedProductSection(String fieldText)
	{
		try {
			ReusableMethods.scrollIntoView(standardPage.getElement(By.xpath("(//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='price']//span)[2]")), driver);
			String price = standardPage.getElement(By.xpath("(//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='price']//span)[2]")).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return price;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get price Of Particular Product From Grouped Product Section", e);
			return null;
		}
	}

	@Step("Get price Of Particular Product(SKU) From Grouped Product Section")
	public String getPriceFromGroupedProductSection(String fieldText)
	{
		try {
			ReusableMethods.scrollIntoView(standardPage.getElement(By.xpath("//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='price']")), driver);
			String price = standardPage.getElement(By.xpath("//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='price']")).getText().trim();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return price;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get price Of Particular Product From Grouped Product Section", e);
			return null;
		}
	}
	@Step("Get price Of Single Registered User Online")
	public String getPriceOfSingleRegisteredUserOnline()
	{
		try {
			ReusableMethods.scrollIntoView(standardPage.getElement(By.xpath("//*[@id=\"super-product-table\"]/tbody/tr[1]/td[1]/ancestor::tr//td[@data-th='Price']//span")), driver);
			String price = standardPage.getElement(By.xpath("//*[@id=\"super-product-table\"]/tbody/tr[1]/td[1]/ancestor::tr//td[@data-th='Price']//span")).getText().trim();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return price;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get price Of Single Registered User Online", e);
			return null;
		}
	}
	
	
	@Step("Get name Of Particular Product From Grouped Product Section")
	public String getProductNameFromGroupedProductSection(String fieldText)
	{
		try {
			ReusableMethods.scrollIntoView(standardPage.getElement(By.xpath("//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='name']")), driver);
			String productName = standardPage.getElement(By.xpath("//span[text()='" + fieldText + "']/ancestor::tr//td[@data-index='name']")).getText().trim();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return productName;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get productName Of Particular Product From Grouped Product Section", e);
			return null;
		}
	}
	
	public By getLinkByName(String fieldText)
	{
		return By.xpath("//a[contains(text(),'" + fieldText + "')]");
	}
	@Step("Fill credit card details and Click on Submit button")
	public void enterCreditCardDetailsAndSubmit() {
		try {
			assertTrue(
					paymentPage.fillCreditCardDetails(dataMap.get("creditCard"), dataMap.get("securityCode"),
							dataMap.get("expiryMonth"), dataMap.get("expiryYear")),
					"Fill Credit card details and click on submit button");
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info(ex.toString());
			PublicCommon.reportFailAssert("Failed to enter credit card details to Payement Page", ex);
		}
	}
	@Step("Sign out.")
	public void signOutPublic() {
		try {
			ReusableMethods.scrollIntoView(myAccountPage_public.getElement(myAccountPage_public.astmButton), driver);
			clickOnMethod("'MY ASTM' button", myAccountPage_public.astmButton, "Couldn't click on MY ASTM button");
			clickOnMethod("Sign out button", myAccountPage_public.signOutBtn, "Couldn't click on Sign out button");
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to log out ", e);
		}
	}
	@Step("Admin search for order by '{orderId}' as order ID")
	public void adminSearchForOrdersByOrderId(String orderId) {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.salesMenuNavigationButton));
			clickOnMethod("Sales Menu Option", adminMenuNavigation.salesMenuNavigationButton,
					"Failed to click on Sale menu option ");
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.orderMenuNavigationButton));
			clickOnMethod("Order Menu Option", adminMenuNavigation.orderMenuNavigationButton,
					"Failed to click on Order menu option ");
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.filterButton));
			PublicCommon.JSClick(adminMenuNavigation.getElement(adminMenuNavigation.filterButton), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders));
			if (adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders).isDisplayed()) {
				PublicCommon.JSClick(adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders), driver);
			}
			WaitStatementUtils.explicitWaitForVisibility(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.orderIdTextFieldOrders));
			adminMenuNavigation.getElement(adminMenuNavigation.orderIdTextFieldOrders).sendKeys(orderId);
			Thread.sleep(3000);
			clickOnMethod("Apply Filter Button", adminMenuNavigation.applyFilterButtonOrders,
					"Admin is unable to click on Apply Filter Button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Check EBS Order Number for Order Purchased and confirmation :{ebsOrderNumber}")
	public void checkEBSOrderNumber(String ebsOrderNumber) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (ebsOrderNumber.equals("")) {
				adminMenuNavigation.getMagentoErroForEBS();
				ScreenshotUtil.takeScreenshotForAllure(driver);
				Assert.fail("EBS number not generated");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Step("Set number row to be displayed as search result to max")
	public void setNumberRowToBeDisplayedAsSearchResultMax() {
		try {
			 adminMenuNavigation.getElement(adminMenuNavigation.rowSelector).click();
			adminMenuNavigation.getElement(adminMenuNavigation.rowmax).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set number row to be displayed as search result to max ", e);


		}
	}
	@Step("Search for the product by URLKey: {productName}")
	public void searchProductByURLKey(String productName) {
		try {
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			if (adminProductPages.getElement(ProductPage_PublicAdmin.clearAllFilterLink).isDisplayed()) {
				clickOnMethod("Clear filter link", ProductPage_PublicAdmin.clearAllFilterLink,
						"unable to click on Clear filter link");
			}
			PublicCommon.waitForSec(3);
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, ProductPage_PublicAdmin.spinnerIcon),
					"unable to click on Filter button");
			clickOnMethod("Filter button", ProductPage_PublicAdmin.filterButton, "unable to click on filter button");
			enterText("SKU", ProductPage_PublicAdmin.productUrlKeyTextfield, productName, "Failed to enter value in URL Key");

			clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
					"Failed to click  on apply filters");
			Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
					"unable to click on Filter button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Search for the product", e);
		}
	}
	@Step("Get format and Language attributes from configuration section in PDP admin")
	public HashMap<String, String> getFormatAndLanguageAttributeForChildProduct(String sku) {
		HashMap<String, String> hm = new HashMap<String, String>();
		try {
			String tableAttrubuteValue = standardPage.getElementNew(standardPage.getChildAttributeValueBySKU(sku)).getText();
				String format = tableAttrubuteValue.split(",")[1].replace("Format: ", "");
				String language = tableAttrubuteValue.split(",")[0].replace("Language: ", "").replace(" ", "");
				hm.put("Format", format);
				hm.put("Language", language);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return hm;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get Format and language attributes", e);
			return hm;
		}
	}

	@Step("Navigate to Standards & Publications page")
	public void navigateToStandardsPublicationsPage() {

		try {
			mouseHover("Products & Services option", commonPage.getProductsAndServicesNavigation());
			mouseHover("Standards And Publications option", commonPage.getStandardsAndPublicationsOptions());
			clickOnMethod("Standard and Publications", commonPage.getStandardsAndPublicationsOptions());
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}

	@Step("Click on Register For Program Button")
	public void clickOnRegisterForProgramButton() {

		try {
			assertTrue(ptpProductPageCommon_public.clickRegisterForProgramButton(), "Click Register For Program button.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("User Registration - Exception.", e);
		}
	}

	@Step("Validate the Navigation to the Cart Page from PTP product page.")
	public void navigationToCartPage() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ptpProductPageCommon_public.shoppingCartLink));
			PublicCommon.JSClick(getElement(ptpProductPageCommon_public.shoppingCartLink), driver);
			assertTrue(PublicCommon.verifyContentOnPage("Cart Page Url", ASTMCartPage.getCartPageUrl(),
					dataMap.get("CartPageUrl")), "Cart Page Url is not correct");

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Navigation to Cart Page - Exception.", e);
		}
	}

	@Step("Verify product '{productName}' is displayed in bul order page")
	public void verifyProductDisplayedInBulkOrderPage(String productName){
		try {
			List<WebElement> productLinkElementList = bulkOrder.getWebElementsForProductLinks();
			List<String> productList = PublicCommon.getListOfTextFromListOfWebelements(productLinkElementList, driver);
			Assert.assertTrue(productList.contains(productName));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to get product list", e);
		}
	}

	@Step("Get Component field '{name}' values from product details page")
	public List<String> getComponentsFieldDataByName(String name){
		List<WebElement> fieldElement = getElementsNew(productPageAdmin.getAttributeValuesByName(name));
		List<String> dataList = new ArrayList<>();
		String actualValue = null;
		try {
			for (WebElement el: fieldElement){
				actualValue = el.getAttribute("value");
				if(name.equalsIgnoreCase("start_date")||name.equalsIgnoreCase("serve_date")){
					actualValue = changeDateFormat(actualValue, "dd/m/yyyy","dd/mm/yyyy");
				}
				dataList.add(actualValue);
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to get field values", e);
			return dataList;
		}
	}

	@Step("Verify '{fieldName}' values are '{expectedData}'")
	public void verifyComponentFieldValues(String fieldName, List<String> expectedData){
		try {
			List<String> dataList = getComponentsFieldDataByName(fieldName);
			for (String expectedValue: expectedData){
				if(fieldName.equalsIgnoreCase("start_date")||fieldName.equalsIgnoreCase("serve_date")){
					 expectedValue = changeDateFormat(expectedValue, "dd/m/yyyy","dd/mm/yyyy");
				}
				Assert.assertTrue(dataList.contains(expectedValue));
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to verify component field values", e);
		}
	}

	@Step("Navigate to Standards & Publications page")
	public void navigateToStandardsPage() {

		try {
			mouseHover("Products & Services option", commonPage.getProductsAndServicesNavigation());
			mouseHover("Standards And Publications option", commonPage.getStandardsAndPublicationsOptions());
			clickOnMethod("Standard and Publications", commonPage.standardsProducts);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}

	@Step("Click on Register For Multiple Programs Button")
	public void clickOnRegisterForMultipleProgramsButton() {
		try {
			bulkOrder = ptpProductPageCommon_public.clickRegisterForMultipleProgramButton();
			Assert.assertNotNull(bulkOrder,
					"Click Register For Multiple Program button and Navigate to the Bulk Order Page.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Exception During Multiple Program Registration", e);
		}
	}

	@Step("Open No full list section and verify product '{productName}' is present")
	public void openFullListAndVerifyPTPProduct(String productName){
		try {
			clickOnMethod("Full list", ptpPage.fullListSection, "Couldn't click on Full list link");
			ReusableMethods.scrollIntoView(getElementNew(ptpPage.getPtpProductLinkBySectionAndProductName("Full List", productName)), driver);
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, ptpPage.getPtpProductLinkBySectionAndProductName("Full List", productName)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			//clickOnMethod("Transportable Moisture Limit of Coal link", ptpPage.getPtpProductLinkBySectionAndProductName("Full List", productName), "Couldn't click on Transportable Moisture Limit of Coal link");
			clickOnMethod(productName+" link", ptpPage.getPtpProductLinkBySectionAndProductName("Full List", productName), "Couldn't click on Transportable Moisture Limit of Coal link");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to verify product in full list", e);
		}
	}

	@Step("Open No committe affiliation section and verify product '{productName}' is present")
	public void noCommitteeAffiliationAndVerifyPTPProduct(String productName){
		try {
			if(ptpPage.getElement(ptpPage.noCommitteeAffiliation).getAttribute("aria-expanded").equals("true")) {
				clickOnMethod("No Committee Affiliation", ptpPage.noCommitteeAffiliation, "Couldn't click on No Committee Affiliation link");
			}
			ReusableMethods.scrollIntoView(getElementNew(ptpPage.getPtpProductLinkBySectionAndProductName("No Committee Affiliation", productName)), driver);
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver, ptpPage.getPtpProductLinkBySectionAndProductName("No Committee Affiliation", productName)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Transportable Moisture Limit of Coal link", ptpPage.getPtpProductLinkBySectionAndProductName("No Committee Affiliation", productName), "Couldn't click on Transportable Moisture Limit of Coal link");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to verify product in no committee affiliation list", e);
		}
	}

	@Step("Navigate to Member and Officer training page")
	public void navigateToOfficerTrainingPage() {

		try {
			mouseHover("Products & Services option", commonPage.getProductsAndServicesNavigation());
			ReusableMethods.scrollIntoView(getElementNew(commonPage.trainingCoursesOptions), driver);
			mouseHover("Products & Services option", commonPage.getProductsAndServicesNavigation());
			commonPage.mouseHoverTrainingCoursesOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.clickElementByJavaScript(driver, commonPage.memberAndOfficerTraining);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			log.info(e.toString());
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}
}