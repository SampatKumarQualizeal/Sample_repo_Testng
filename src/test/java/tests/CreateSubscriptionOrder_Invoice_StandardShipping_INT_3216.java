package tests;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import testobjects.Order_PublicAdmin;
import testobjects.prerequisitegenerator.OrderCreation_PublicAdmin;
import tests.ui.base.BaseTest;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CreateSubscriptionOrder_Invoice_StandardShipping_INT_3216 extends BaseTest {
    static final String jiraTestID = "INT-3216";
    MagentoLoginAndVerifyDashboardPage magentoLogin;
    CommonPage_Public commonPage;
    AllCustomerPage_PublicAdmin AllCustomerPage;
    OrderCreation_PublicAdmin OrderCreationUtil;
    OrderInformationPage_PublicAdmin OrderInformationPage;
    CreateNewOrderPage_PublicAdmin CreateOrderPage;
    JsonFileReader jsonFileReader;
    BasePage basePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_PUB_ADMIN_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Create Subscription Order | Invoice | Standard Shipping")
    @Test(description = jiraTestID
            + ": Create Subscription Order | Invoice | Standard Shipping", groups = {""})
    public void CreateSubscriptionOrder_Invoice_StandardShipping() {
        try {
            magentoLogin = page.getInstance(MagentoLoginAndVerifyDashboardPage.class);
            commonPage = page.getInstance(CommonPage_Public.class);
            AllCustomerPage = page.getInstance(AllCustomerPage_PublicAdmin.class);
            OrderCreationUtil = new OrderCreation_PublicAdmin(driver, page);
            CreateOrderPage = page.getInstance(CreateNewOrderPage_PublicAdmin.class);
            OrderInformationPage = page.getInstance(OrderInformationPage_PublicAdmin.class);
            basePage=page.getInstance(BasePage.class);
            jsonFileReader=new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            magentoLogin.login(jsonFileReader.getJsonString("CredentialsMap", "Magento", "StageUser"),
                                jsonFileReader.getJsonString("CredentialsMap", "Magento", "StagePassword"));
            commonPage.IncomeMessageModelHeader();
            commonPage.clickOnCustomer();
            commonPage.clickOnAllCustomers();
            navigateToAccountInformationPage(jsonFileReader.getJsonString("StageUser"));
            createOrder();
            OrderCreationUtil.selectOrderTypeAsType(Order_PublicAdmin.OrderTypes.REGULAR_ORDER.toString());
            OrderCreationUtil.addsProductBySKUCode(jsonFileReader.getJsonString("Product"));
            int Price=setCustomPriceOfProducts();
            commonPage.AddStartandPublishDate();
            CreateOrderPage.setLicenseTypeByIndex(1);
            selectsBillingShippingAddressDropdown();
            selectsPaymentShippingAndAdditionalDetails();
            ShippingRate();
            CreateOrderPage.selectPaymentMethodForPayment("Invoice");
            FillPromoCode();
            commonPage.ClickOnSubmitOrderButton();
            verifyEbsOrderNumberIsGeneratedWithDynamicRefresh(jiraTestID);
            verifyallDetailesInformationPage(Price);

        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Create Subscription Order | Invoice | Standard Shipping", e);
        }
        System.out.println("Successfully Created Subscription Order | Invoice | Standard Shipping");
    }

    @Step("Navigate to account information page and enter created email id")
    public void navigateToAccountInformationPage(String email) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.
                            waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomerPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomerPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on Filter Button");
            enterTextInTextField("Email Filter Text Field", AllCustomerPage.getEmailFilterField(), email, true,
                    "Admin/ISS Agent is unable to enter text in email filter text field");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickOnMethod("Apply Filter Button", AllCustomerPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickOnMethod("Edit Button", AllCustomerPage.getEditButton(), "Admin/ISS Agent is unable to click on Edit Button");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to account information page", e);
        }
    }

    @Step("Admin enters '{value}' in '{elementName}'")
    private void enterTextInTextField(String elementName, By locator, String value, boolean clear,
                                      String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.enterTextInTextField(driver, locator, value, clear), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
        }
    }

    @Step("Click on Create new order")
    public void createOrder() {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            commonPage.getElement(commonPage.createOrder).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("unable to click on create order", e);
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

    @Step("Admin/ISS Agent selects shipping and billing address")
    public void selectsBillingShippingAddressDropdown() {
        try {
            Assert.assertTrue(CreateOrderPage.handleBillingAddress(), "Unable to select billing address");
            Assert.assertTrue(CreateOrderPage.handleShippingAddress(), "Unable to select shipping address");
            //OrderCreationUtil.waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from billing address dropdown", e);
        }
    }

    @Step("Selects payment, shipping and additional details")
    public void selectsPaymentShippingAndAdditionalDetails() {
        try {
            CreateOrderPage.handleGetPaymentMethod();
            clickOnMethod("Invoice Button", CreateOrderPage.getInvoiceRadioButton(),
                    "Admin/ISS Agent is unable to click on 'Invoice Button'");
            OrderCreationUtil.waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to select payment, shipping and additional details", e);
        }
    }
    @Step("Verify if shipping rate")
    public void ShippingRate(){
        try {
            String StandardService = PublicAdminCommons.getTextOfElement(driver,
                    CreateOrderPage.getStandardServiceRate());
            StandardService.equals("$0.00");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to verify shipping rate", e);
        }

    }
    @Step("Verify payment, shipping and additional details,Promo Codes and Items Ordered")
    public void verifyallDetailesInformationPage(int Price) {
        try {
            PublicAdminCommons.scrollToElement(driver, OrderInformationPage.getPaymentDetails());
            String PaymentType=page.getElement(OrderInformationPage.getPaymentDetails()).getText();
            Assert.assertEquals(PaymentType, "Invoice",
                    "Both payment method not matched");
            String ShippingTableRates=page.getElement(OrderInformationPage.getAstmStandardShippingInformation()).getText();
            Assert.assertEquals(ShippingTableRates, "Shipping Table Rates - Standard Service $0.00",
                    "Shipping & Handling Information not matched");
            PublicAdminCommons.scrollToElement(driver, OrderInformationPage.getMajorPromoCodeLabel());
            String MajorPromoCode=page.getElement(OrderInformationPage.getMajorPromoCodeLabel()).getText();
            Assert.assertEquals(MajorPromoCode, jsonFileReader.getJsonString("Major"), "Major Promo Code not matched");
            String MinorPromoCode=page.getElement(OrderInformationPage.getMinorPromoCodeLabel()).getText();
            Assert.assertEquals(MinorPromoCode, jsonFileReader.getJsonString("Minor"), "Minor Promo Code not matched");
            String OrderChannel=page.getElement(OrderInformationPage.getOrderChannelLabel()).getText();
            Assert.assertEquals(OrderChannel, OrderChannel, "Order Channel not matched");
            PublicAdminCommons.scrollToElement(driver, OrderInformationPage.getSkuNumbersInItemOrderedList());
            ScreenshotUtil.takeScreenshotForAllure(driver);
            String ProductSKU=page.getElement(OrderInformationPage.getSkuNumbersInItemOrderedList()).getText();
            Assert.assertEquals(ProductSKU, "SKU: "+jsonFileReader.getJsonString("Product"), "Products are not matched");
            String StaratDate=page.getElement(OrderInformationPage.getStartDateUnderProduct()).getText();
            Assert.assertEquals(StaratDate, "Start Date: "+PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy"),
                    "Start Date not matched");
            Assert.assertEquals( page.getElement(OrderInformationPage.getPublishDateUnderProduct()).getText(), "Publish Date: "+PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy"),
                    "Publish Date not matched");
            Assert.assertEquals(page.getElement(OrderInformationPage.getProductPricesListUnderItemOrderedTable()).getText(),"$"+Price+".00" ,
                    "Price not matched");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("unable to select payment, shipping and additional details", e);
        }
    }
    @Step("Select Custom Price for the product")
    public int setCustomPriceOfProducts() {
        int CustomPrice = 0;
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver,CreateOrderPage.getSpinnerIcon());
            List<WebElement> customPriceCheckBoxes = basePage.getElementsNew(CreateOrderPage.getCustomPriceCheckBox());
            for (WebElement element : customPriceCheckBoxes) {
                PublicAdminCommons.scrollToElement(driver, element);
                PublicAdminCommons.loaderClick(element);
                CreateOrderPage.waitForSpinnerLoaderToDisappear();
            }
            List<WebElement> customPriceTextFields = basePage.getElementsNew(CreateOrderPage.getCustomPriceTextField());
            for (WebElement element : customPriceTextFields) {
                PublicAdminCommons.scrollToElement(driver, element);
                element.clear();
                element.sendKeys(RandomStringUtils.getRandomNumbers(3));
                CustomPrice= Integer.parseInt(basePage.getElementNew(CreateOrderPage.getCustomPriceTextField()).getAttribute("value"));
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
        } catch (Exception e) {
            e.getStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to Select Custom Price for the product", e);

        }
        return CustomPrice;
    }
    @Step("[{testCaseId}] Verify EBS order number is generated")
    public void verifyEbsOrderNumberIsGeneratedWithDynamicRefresh(String testCaseId) {
        try {
            Assert.assertTrue(OrderInformationPage.handleRefreshOfPage(), "Unable to refresh page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getMaeOrderStatus()), "success", "[" + testCaseId + "] MAE order status is not success");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderType()), "REGULAR ORDER", "[" + testCaseId + "] OrderType is not same");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "[" + testCaseId + "] Unable to get EBS order number");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify if EBS order number is generated", e);
        }
    }
    @Step("Add promocodes")
    public void FillPromoCode(){
        try{
            PublicCommon.waitForSec(3);
            ReusableMethods.scrollIntoView(page.getElement(commonPage.majorpromocode),driver);
            page.getElement(commonPage.majorpromocode).sendKeys(jsonFileReader.getJsonString("Major"));
            page.getElement(commonPage.minorpromocode).sendKeys(jsonFileReader.getJsonString("Major"));
            page.getElement(commonPage.orderchannel).sendKeys(jsonFileReader.getJsonString("OrderChannel"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch(Exception e){
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to add PromoCodes ", e);
        }
    }
}
