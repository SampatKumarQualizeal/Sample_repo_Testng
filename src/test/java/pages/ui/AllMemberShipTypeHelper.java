package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AllMemberShipTypeHelper extends BasePage {

    public AllMemberShipTypeHelper(WebDriver driver) {
        super(driver);
    }

    ASTMCartPage_Public cartPage = getInstance(ASTMCartPage_Public.class);
    MenuNavigationPage_PublicAdmin adminMenuNavigation = getInstance(MenuNavigationPage_PublicAdmin.class);
    OrderConfirmPage_Integration orderConfirmationPage = getInstance(OrderConfirmPage_Integration.class);
    CustomerLogin_Public loginPage = getInstance(CustomerLogin_Public.class);
    PaymentOptionsPage_Public paymentOptionsPage = getInstance(PaymentOptionsPage_Public.class);
    ProductPage_PublicAdmin adminProductPages = getInstance(ProductPage_PublicAdmin.class);
    PTPTermsPage_Public PtpTermsPage = getInstance(PTPTermsPage_Public.class);
    TPTProductPageCommon_Public productPage = getInstance(TPTProductPageCommon_Public.class);
    TPTCorrosionPage tptCorrosionPage = getInstance(TPTCorrosionPage.class);
    CommonPage_Public commonPage = getInstance(CommonPage_Public.class);
    JournalsProductPage_Public journalsProductPage = getInstance(JournalsProductPage_Public.class);
    MembershipTypesPage_Public membershipTypesPage = getInstance(MembershipTypesPage_Public.class);
    PTPComboProductPage ptpComboProduct = getInstance(PTPComboProductPage.class);
    PTPProductPageCommon_Public ptpProductPage = getInstance(PTPProductPageCommon_Public.class);
    SelectAnAccountPage_Public selectAccountPage = getInstance(SelectAnAccountPage_Public.class);
    CreateAccountPage_Public createAcntPage = getInstance(CreateAccountPage_Public.class);
    MemberStudentPage_Public memberStudentPage = getInstance(MemberStudentPage_Public.class);
    BillingAddressPage_Public billingAddressPage = getInstance(BillingAddressPage_Public.class);
    MyAccountPage_Public myAccountPage = getInstance(MyAccountPage_Public.class);
    PaymentDetailsPage_Public paymentDetails = getInstance(PaymentDetailsPage_Public.class);
    MembershipBecomeMemberPage becomeMember = getInstance(MembershipBecomeMemberPage.class);
    MC2Pages_Membership mcs2Application = getInstance(MC2Pages_Membership.class);
    Mcs2Application_Page membershipData = getInstance(Mcs2Application_Page.class);
    LoginPage_PublicAdmin loginAdmin = getInstance(LoginPage_PublicAdmin.class);
    MembershipBecomeMemberPage newMembership = getInstance(MembershipBecomeMemberPage.class);

    static String productPriceWithoutDiscount;
    static Integer productPrice;
    static String discountedAmount;
    static int discountAmount;
    HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"), "Vertex");

    @Step(" Check EBS Order Status for Order Purchased and confirmation :{ebsOrderStatus}")
    public void checkEBSOrderStatus(String ebsOrderStatus) {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if (!ebsOrderStatus.equals("Success")) {
                WaitStatementUtils.explicitWaitForVisibility(driver,
                        adminMenuNavigation.getElement(adminMenuNavigation.orderTotals));
                ReusableMethods.scrollIntoView(adminMenuNavigation.getElement(adminMenuNavigation.orderTotals), driver);
                ScreenshotUtil.takeScreenshotForAllure(driver);
                Assert.fail("EBS status is Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Step("Get order number")
    public String getOrderNumber() {
        try {
            ReusableMethods.scrollIntoView(getElement(orderConfirmationPage.orderConfirmationPage_orderNumber), driver);
            return getElement(orderConfirmationPage.orderConfirmationPage_orderNumber).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    @Step("Admin search for order by '{orderId}' as order ID")
    public void adminSearchForOrdersByOrderId(String userAccount, String userPwd, String orderId) {
        try {
            driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM") + "/admin");
            adminMenuNavigation.clickOnSigninViaOctaBtn();
            loginPage.compassLogin(userAccount, userPwd);
            Thread.sleep(10000);
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    adminMenuNavigation.getElement(adminMenuNavigation.salesMenuNavigationButton));
            clickONMethod("Sales Menu Option", adminMenuNavigation.salesMenuNavigationButton,
                    "Failed to click on Sale menu option ");
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    adminMenuNavigation.getElement(adminMenuNavigation.orderMenuNavigationButton));
            clickONMethod("Order Menu Option", adminMenuNavigation.orderMenuNavigationButton,
                    "Failed to click on Order menu option ");
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders));
            if (adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders).isDisplayed()) {
                PublicCommon.JSClick(adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders), driver);
            }
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    adminMenuNavigation.getElement(adminMenuNavigation.filterButton));
            PublicCommon.JSClick(adminMenuNavigation.getElement(adminMenuNavigation.filterButton), driver);
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    adminMenuNavigation.getElement(adminMenuNavigation.orderIdTextFieldOrders));
            adminMenuNavigation.getElement(adminMenuNavigation.orderIdTextFieldOrders).sendKeys(orderId);
            PublicCommon.waitForSec(3);
            clickOnMethod("Apply Filters", ProductPage_PublicAdmin.applyFilterButton,
                    "Failed to click  on apply filters");
            Assert.assertTrue(adminProductPages.handleSpinnerIconOnMagento(driver, adminProductPages.spinnerIcon),
                    "unable to click on Filter button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Select Payment Method : {paymentMethod} and Enter PO Number: {poNumber}")
    public void paymentMethodAndPONumber(String paymentMethod, String poNumber) {
        try {
            // paymentOptionsPage.paywithEFT(poNumber);
            // paymentOptionsPage.selectPaymentMethodAndEnterPONumber(paymentMethod,
            // poNumber)
            assertTrue(paymentOptionsPage.selectPaymentMethodAndEnterPONumber(paymentMethod, poNumber),
                    "Payment Method should be Selected");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Select Payment Method", e);
        }
    }

    @Step("Veirfy Members are not eligible for 10% discount")
    public void verifyProductNotEligibleforDiscount(List<WebElement> element) {

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertTrue(element.size() == 0);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Step("Veirfy Members are  eligible for 10% discount")
    public void verifyProductEligibleforDiscount(List<WebElement> element) {

        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            assertTrue(element.size() != 0);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Step("Click on New Participant Button.")
    private void navigationToTermsPage() {
        try {

            assertTrue(cartPage.clickNewParticipantButton(), "New Participant Button should be clickable");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Failed to Click on New Patient Button.", e);
        }
    }

    @Step(" Click on Accept Terms Button")
    public void clickOnAcceptTermsButton() {

        try {
            assertTrue(PtpTermsPage.clickAcceptTermsButton(), "Click Accept button.");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Accept TnC - Exception.", e);
        }
    }

    @Step("User navigation after clicking on \"Submit Order\" button on \"Payment\" page")
    public void verifyHeaderTextOnOrderConfirmationPage() {
        try {
            // verifyVisibility("Order Confirmation header", orderPage.head,
            // assertionMessage);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (PublicCommon.isWebElementDisplayed(driver, orderConfirmationPage.memberDiscount)) {
                String discount = getElement(orderConfirmationPage.memberDiscount).getText().replace("-$", "")
                        .replace(",", "");
                Assert.assertTrue(discount.contains(discountedAmount));
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.getStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Failed to verify Order Confirmation Page header", e);
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Step("Add product type '{productType}'in cart and checkout")
    public void checkOut(String productType, String productUrl) {
        try {

            switch (productType) {
                case "Standard":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    clickOnMethod("Add To Cart button", productPage.addToCartButton);
                    clickOnMethod("Shopping Cart link", productPage.shoppingCart);
                    String price = getElement(By.xpath("//strong[text()='Subtotal:']/../span/span")).getText()
                            .replace("$", "").replace(",", "");

                    if (Float.valueOf(price) <= 2000) {
                        quantityUpdate(((int) (2000 / Float.valueOf(price)) + 1));
                    }
                    String subTotal = null;
                    // Get subtotal
                    if (IntegrationCommon.isWebElementDisplayed(driver, cartPage.membershipDiscount)) {
                        subTotal = getElement(cartPage.subTotalPrice).getText().replace("$", "").replace(",", "");
                        discountedAmount = String.valueOf(discountForProduct(10, Math.round(Float.valueOf(subTotal))));
                        String discount = getElement(cartPage.discountPrice).getText().replace("-$", "").replace(",", "");
                        Assert.assertTrue(discount.contains(discountedAmount));

                    }
                    /*
                     * else subTotal = getElement(cartPage.subTotalPrice1).getText().replace("$",
                     * "").replace(",", "");
                     */// get discount value and verify discount
                    // driver.navigate().refresh();
                    assertTrue(cartPage.clickOnCheckoutButton(), "Failed to click on Checkout button.");
                    break;

                case "TPT":

                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    Assert.assertTrue(tptCorrosionPage.addAttendeeDetails("name", "middle", "last", "9876543210",
                            "aaa@gmail.com", "1"), "Failed to add attendee details");
                    clickOnMethod("Addtocart", tptCorrosionPage.addToCartButton, "Failed to click on add to cart button");
                    if (PublicCommon.isWebElementDisplayed(driver, tptCorrosionPage.chooseAccountPopup)) {
                        clickONMethod("Select Personal account", tptCorrosionPage.choosePersonalBtn,
                                "Failed to click on Personal account");
                        clickONMethod("Click Submit button", tptCorrosionPage.chooseAccountSubmitBtn,
                                "Failed to click on Submit Button");
                    }
                    PublicCommon.waitForSec(8);
                    clickOnMethod("Cart button", commonPage.cartLink);
                    driver.navigate().refresh();
                    deleteTPTProduct();
                    assertTrue(!PublicCommon.isWebElementDisplayed(driver, cartPage.memberDiscount));
                    clickOnMethod("Check out button", cartPage.checkoutButton, "Failed to click on check out button");

                    break;

                case "Journals":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    clickOnMethod("Subscription Tab", journalsProductPage.subscriptionTab);
                    ReusableMethods.scrollIntoView(getElement(journalsProductPage.subscriptionAddToCartBtn), driver);
                    clickOnMethod("Add to cart button", journalsProductPage.subscriptionAddToCartBtn, "add to cart button could not be clicked");
                    productPriceWithoutDiscount = getElement(journalsProductPage.onlinePrice).getText().split(":")[1].trim();
                    System.out.println("The product price without discount is" + productPriceWithoutDiscount);
                    String pr = convertThePrice(productPriceWithoutDiscount);

                    productPrice = Integer.parseInt(pr);
                    System.out.println(productPrice);
                    discountAmount = discountForProduct(10, productPrice);
                    clickOnMethod("Add To Cart button", journalsProductPage.subscriptionAddToCartBtn);
                    PublicCommon.waitForSec(2);
                    clickOnMethod("Cart button", commonPage.cartLink);
                    // clickOnMethod("Shopping Cart link", journalsProductPage.shoppingCartLink);

                    break;
                case "MEM-Student":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    StudentMemberCheckout();
                    break;

                case "MEM-Organisational":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    // Verify Organisational membership with no free volume.
                    nonMemberOrganisationalMembersipWithNoFreeVolume();
                    driver.navigate().refresh();
                    assertTrue(!PublicCommon.isWebElementDisplayed(driver, cartPage.memberDiscount));
                    assertTrue(cartPage.clickOnCheckoutButton(), "Failed to click on Checkout button.");
                    break;

                case "MEM-Informational":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    newMembership.handleOneTrustCookie();
                    clickOnMethod("Become Informational Member button", membershipTypesPage.becomeInformationalMemberBtn);
                    break;

                case "MEM-Participating":
                    navigateToMembershipPage();
                    // Fill information details
                    String emailID = "testaccount" + System.currentTimeMillis() + "@mailinator.com";
                    fillNewMembershipDetails("US_Address", emailID);
                    driver.navigate().refresh();
                    assertTrue(!PublicCommon.isWebElementDisplayed(driver, cartPage.memberDiscount));
                    clickONMethod("Checkout Button", cartPage.checkoutButton, "Failed to click on checkout button");
                    break;

                case "BOS":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    clickOnMethod("Add To Cart button", productPage.addToCartButton);
                    clickOnMethod("Shopping Cart link", productPage.shoppingCartLink);
                    cartPage.setAllProductsQty("2");
                    break;
                case "PTP":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);

                    PublicCommon.selectValueInDropdownbyIndex(
                            ptpComboProduct.getElement(ptpComboProduct.scheduleNameDropDwn), 1);

                    assertTrue(ptpProductPage.clickRegisterForProgramButton(), "Click Register For Program button.");
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    WaitStatementUtils.waitForElementToBeClickable(driver,ptpComboProduct.getElement(ptpComboProduct.shoppingCartLink));
                    clickOnMethod("Cart button", commonPage.cartLink);
                    driver.navigate().refresh();
                    if (!cartPage.getElement(cartPage.checkoutButton).isEnabled()) {
                        // Select different account and create PTP account
                        clickOnMethod("Select different account link", cartPage.selectADifferentAccountLink);
                        clickOnMethod("", selectAccountPage.createAnAccountBtn);
                        PublicCommon.waitForSec(2);
                        enterText("Organization name", createAcntPage.orgNamePTPAccount, "ASTM",
                                "Unable to enter organization name");
                        clickOnMethod("Create account button", createAcntPage.createAnAccountButton);
                        PublicCommon.waitForSec(3);
                        clickOnMethod("Cart button", commonPage.cartLink);
                    }
                    assertTrue(!PublicCommon.isWebElementDisplayed(driver, cartPage.memberDiscount));
                    assertTrue(cartPage.clickOnCheckoutButton(), "Failed to click on Checkout button.");
                    clickOnAcceptTermsButton();
                    break;
                case "Train":
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    clickOnMethod("Add To Cart button", productPage.addToCartButton);
                    WaitStatementUtils.waitForElementToBeClickable(driver,ptpComboProduct.getElement(ptpComboProduct.shoppingCartLink));
                    clickOnMethod("Cart button", commonPage.cartLink);
                    driver.navigate().refresh();
                    assertTrue(cartPage.clickOnCheckoutButton(), "Failed to click on Checkout button.");
                    break;
                default:
                    navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);
                    clickOnMethod("Add To Cart button", productPage.addToCartButton);
                    WaitStatementUtils.waitForElementToBeClickable(driver,productPage.getElement(productPage.shoppingCartLink));
                    clickOnMethod("Shopping Cart link", productPage.shoppingCartLink);
                    assertTrue(cartPage.clickOnCheckoutButton(), "Failed to click on Checkout button.");
                    break;
            }

            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click on Checkout button", e);
        }
    }

    @Step("Converting price to numeric value")
    public String convertThePrice(String price) {
        if (price.equalsIgnoreCase("Free")) {
            price = "0";
            return price;
        } else
            return price;
    }


    @Step("Create organisational account using select different account link from shopping cart page.")
    public void createDifferentAccount() {
        if (!cartPage.getElement(cartPage.checkoutButton).isEnabled()) {
            // Select different account and create PTP account
            clickOnMethod("Select different account link", cartPage.selectADifferentAccountLink);
            clickOnMethod("", selectAccountPage.createAnAccountBtn);
            PublicCommon.waitForSec(2);
            enterText("Organization name", createAcntPage.orgNamePTPAccount, "ASTM",
                    "Unable to enter organization name");
            clickOnMethod("Create account button", createAcntPage.createAnAccountButton);
            PublicCommon.waitForSec(3);
            clickOnMethod("Cart button", commonPage.cartLink);
        }
    }


    @Step("Get discounted price for product")
    public int discountForProduct(int discount, int productPrice) {
        return (productPrice * discount) / 100;

    }

    @Step("Checkout Student Membership product")
    public void StudentMemberCheckout() {
        try {
            clickOnMethod("Become Student Member", membershipTypesPage.studentMemberButton);
            verifyElementIsVisible("'Become a Student Member' page header", memberStudentPage.getPageHeader(), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickOnMethod("Online Application", memberStudentPage.onlineApplicationLink);
            assertTrue(PublicCommon.verifyContentOnPage("Memebr Page Url", driver.getCurrentUrl(),
                    dataMap.get("Memebrship url")), "Memeber Page Url is not correct");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            enterStudentInfoStep1();
            enterCollegeInformationStep2();
            enterEducationalDegreeStep3();
            clickOnMethod("Submit Application ", memberStudentPage.submitApplication);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to find element", e);
        }
    }

    @Step("Enter {0} :'{1}' in TextBox.")
    public void setText(String text, String value, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(value);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Step("Enter {0}:'{1}' in TextBox.")
    public void setDropdownOption(String text, String value, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            PublicCommon.JSClick(element, driver);
            PublicCommon.selectValueInDropdown(element, value);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Step("Entering Student Information")
    public void enterStudentInfoStep1() {
        try {
            HashMap<String, String> dataMapBilling = ExcelDataConfig
                    .getMapData(ConfigReader.getValue("IntegrationExcelPath"), "BillingAddress");
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    memberStudentPage.getElement(memberStudentPage.firstName), 20);
            enterText("First Name", memberStudentPage.firstName, dataMapBilling.get("firstName"),
                    "Enter First Name in TextBox");
            enterText("Last Name", memberStudentPage.lastName, dataMapBilling.get("lastName"),
                    "Enter Last Name in TextBox");
            enterText("Street Address in Line 1", memberStudentPage.address, dataMapBilling.get("addressLine1"),
                    "Enter Street Address in Line 1 in TextBox");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            enterText("City", memberStudentPage.city, dataMapBilling.get("city"), "Enter City in TextBox");
            ReusableMethods.scrollIntoView(memberStudentPage.getElement(memberStudentPage.zipcode), driver);
            enterText("Postal Code", memberStudentPage.zipcode, dataMapBilling.get("postalCode"),
                    "Enter Postal Code in TextBox");
            selectValue("Country", memberStudentPage.country, dataMapBilling.get("country"),
                    "Select Country from Drop down");
            enterText("Phone", memberStudentPage.phoneNumber, dataMapBilling.get("phone"), "Enter phone in TextBox");
            String email = "testaccount" + System.currentTimeMillis() + "@newuser.com";
            enterText("Phone", memberStudentPage.email, email, "Enter phone in TextBox");
            clickONMethod("Continue Button ", memberStudentPage.nextBtn, "Continue button should be clickable");
        } catch (IOException e) {
            e.printStackTrace();
            log.info(e);
            PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
        } finally {
            try {
                ScreenshotUtil.takeScreenshotForAllure(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Step("Entering College Information")
    public void enterCollegeInformationStep2() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    memberStudentPage.getElement(memberStudentPage.universityName), 20);
            enterText("First Name", memberStudentPage.universityName, dataMap.get("universityName"),
                    "Enter First Name in TextBox");
            enterText("Street Address in Line 1", memberStudentPage.universityAddress, dataMap.get("universityAddress"),
                    "Enter Street Address in Line 1 in TextBox");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            enterText("City", memberStudentPage.universityCity, dataMap.get("universityCity"), "Enter City in TextBox");
            ReusableMethods.scrollIntoView(memberStudentPage.getElement(memberStudentPage.universityZipCode), driver);
            enterText("Postal Code", memberStudentPage.universityZipCode, dataMap.get("universityZipCode"),
                    "Enter Postal Code in TextBox");
            selectValue("Country", memberStudentPage.universityCountry, dataMap.get("universityCountry"),
                    "Select Country from Drop down");
            clickONMethod("Continue Button ", memberStudentPage.nextBtn, "Continue button should be clickable");
        } catch (IOException e) {
            e.printStackTrace();
            log.info(e);
            PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
        } finally {
            try {
                ScreenshotUtil.takeScreenshotForAllure(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Step("Entering Educational Degree Information")
    public void enterEducationalDegreeStep3() {
        try {
            Thread.sleep(7000);
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    memberStudentPage.getElement(memberStudentPage.graduationYear), 20);
            selectValue("Graduation year", memberStudentPage.graduationYear, dataMap.get("graduationYear"),
                    "Select Graduation year from Drop down");
            selectValue("Graduation month", memberStudentPage.graduationMonth, dataMap.get("graduationMonth"),
                    "Select Graduation month from Drop down");

            selectValue("Graduation month", memberStudentPage.degreeSought, dataMap.get("CollgeDegree"),
                    "Select Degree Soughtfrom Drop down");

            clickONMethod("Continue Button ", memberStudentPage.nextBtn, "Continue button should be clickable");
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
            PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
        } finally {
            try {
                ScreenshotUtil.takeScreenshotForAllure(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Step("Enter {elementName} :'{keys}' in TextBox.")
    public void enterText(String elementName, By locator, String keys, String assertionMessage) {
        try {
            assertTrue(IntegrationCommon.clearTxtFieldsendKeys(driver, locator, keys), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
            PublicCommon.reportFailAssert("Failed to Enter data in Text box", e);
        }
    }

    @Step("Verify \"{0}\" on \"{1}\" page. ")
    public void verifyList(String message, String productHeader, int expectedCount, List<String> actualList,
                           List<String> expectedList) {
        try {
            assertEquals(actualList.size(), expectedCount,
                    "Total count of " + message + " doesn't match for " + productHeader);
            int size = expectedList.size();
            for (int i = 0; i < size; i++) {
                assertTrue(actualList.get(i).endsWith(expectedList.get(i)),
                        message + " mismatch at index " + (i + 1) + " for " + productHeader);
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify list: ", e);
        }

    }

    @Step("Verify Title of {0} page. ")
    public void verifyTitle(String page, String expectedTitle) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.titleContains(expectedTitle));
            Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title doesn't match the expected title.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify ASTM Product url: ", e);
        }
    }

    @Step("Validating element: {0} is Visible")
    public void verifyElementIsVisible(String elementName, WebElement element, WebDriver driver) {
        WaitStatementUtils.explicitWaitForVisibility(driver, element);
        assertTrue(element.isDisplayed(), elementName + " is not visible.");
    }

    @Step("Validate the details of issue.")
    private void validateIssuesDetails() {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Exception.", e);
        }
    }

    @Step("Select {elementName}: '{keys}'in DropDown")
    public void selectValue(String elementName, By locator, String keys, String assertionMessage) {
        try {
            assertTrue(IntegrationCommon.selectValueInDropdown(billingAddressPage.getElement(locator), keys),
                    assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
            PublicCommon.reportFailAssert("Failed to Select value from dropdown.", e);
        }
    }

    @Step("Navigate to the product page.")
    public void navigate(String url) {
        try {
            driver.get(url);
            PublicCommon.waitForSec(5);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify ASTM Product url: ", e);
        }

    }

    @Step("Navigate to Login Page and Log-in with valid credentials.")
    public void login(String username, String password) {
        try {
            clickOnMethod("Sign-in button", commonPage.signInLink);
            assertTrue(loginPage.clickSignInButton(), "Click on Sign-in button");
            if (ConfigReader.getValue("BASE_URL_PUB_ASTM").contains("stage"))
                assertTrue(loginPage.compassLogin(username, password), "Login Failed");
            else
                assertTrue(loginPage.compassLogin(username, password));
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify ASTM Product url: ", e);
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

    @Step("Navigate to Cart Page and Clear cart.")
    public void clearCartTable() {
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver ,getElement(commonPage.cartLink),10);
            clickOnMethod("Cart button", commonPage.cartLink);
            try {
                selectAccountPage.getSelect().get(0).click();
                clickOnMethod("Cart button", commonPage.cartLink);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(cartPage.clearCart(), "Clear cart failed");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify ASTM Product url: ", e);
        }
    }

    @Step("Verify {0}")
    public void verifyText(String message, String actualText, String expectedText) {
        try {
            Assert.assertEquals(actualText, expectedText, "Text doesn't match the expected text.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify: " + message, e);
        }

    }

    @Step("Click on {elementName}")
    private void clickOnMethod(String elementName, By locator, String assertionMessage) {
        try {
            // ReusableMethods.scrollIntoView(driver.findElement(locator), driver);
            assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("Click on {0}")
    public void clickOnMethod(String message, By element) {
        try {
            driver.findElement(element).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Exception.", e);
        }
    }


    @Step("Click on Add to cart button.")
    private void clickOnAddToCartButton() {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            int buttonCount = journalsProductPage.getAddToCartButtonLinkElements().size();
            if (buttonCount > 10)
                buttonCount = 10;
            // click on all Add to Cart buttons
            for (int i = 0; i < buttonCount; i++) {
                journalsProductPage.getAddToCartButtonLinkElements().get(i).click();
                assertTrue(cartPage.checkYourShoppingCartHeaderIsPresent(), "Cart Page header is not visible");
                compareInt("Product count on cart page", cartPage.getProductNameList().size(), i + 1);
                ScreenshotUtil.takeScreenshotForAllure(driver);
                if (i < buttonCount - 1)
                    driver.navigate().back();
                else
                    assertTrue(cartPage.clearCart(), "Clear cart Table");
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Exception.", e);
        }
    }

    @Step("Fill credit card details and Click on Submit button")
    public void enterCreditCardDetailsAndSubmit() {
        try {
            PublicCommon.waitForSec(2);
            if (PublicCommon.isWebElementDisplayed(driver, paymentDetails.selectPaymentHeader)) {
                paymentOptionsPage.paywithCreditCard();
                assertTrue(
                        paymentDetails.fillCreditCardDetails(dataMap.get("creditCard"), dataMap.get("securityCode"),
                                dataMap.get("expiryMonth"), dataMap.get("expiryYear")),
                        "Fill Credit card details and click on submit button");
            } else {

                try {
                    paymentDetails.fillCreditCardDetails(dataMap.get("creditCard"), dataMap.get("securityCode"),
                            dataMap.get("expiryMonth"), dataMap.get("expiryYear"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                IntegrationCommon.clickonWebElement(driver, paymentDetails.submitButton);
                //getElement(paymentDetails.submitButton).click();
                Thread.sleep(10000);
                boolean value = getElement(paymentDetails.thankYouMsg).isDisplayed();
            }
            /*
             * if(PublicCommon.isWebElementDisplayed(driver,
             * paymentDetails.memberDiscountPrice)) { String discount =
             * getElement(paymentDetails.memberDiscountPrice).getText().replace("-$",
             * "").replace(",", ""); Assert.assertTrue(discount.contains(discountedAmount));
             * }
             */

        } catch (Exception ex) {
            ex.printStackTrace();
            log.info(ex.toString());
            PublicCommon.reportFailAssert("Failed to enter credit card details to Payment Page", ex);
        }
    }

    @Step("Fill credit card details and Click on Submit button")
    public void enterCreditCardDetailsAndSubmit(String eligibility) {
        try {
            if (PublicCommon.isWebElementDisplayed(driver, paymentDetails.selectPaymentHeader)) {
                paymentOptionsPage.paywithCreditCard();
            }
            if (eligibility.equalsIgnoreCase("yes")) {
                String discount = getElement(paymentDetails.memberDiscountPrice).getText().replace("-$", "")
                        .replace(",", "");
                Assert.assertTrue(discount.contains(discountedAmount));
            } else {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                Assert.assertTrue(!PublicCommon.isWebElementDisplayed(driver, paymentDetails.memberDiscountPrice));
            }
            assertTrue(
                    paymentDetails.fillCreditCardDetails(dataMap.get("creditCard"), dataMap.get("securityCode"),
                            dataMap.get("expiryMonth"), dataMap.get("expiryYear")),
                    "Fill Credit card details and click on submit button");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.info(ex.toString());
            PublicCommon.reportFailAssert("Failed to enter credit card details to Payment Page", ex);
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }


    @Step("Quantity is increased to 2")
    public void quantityUpdate(Integer i) {

        try {
            enterText("Update Qunatity", cartPage.quanityOnCartPage, String.valueOf(i), "Failed to update quantity");
            clickONMethod("Update Quantity", cartPage.updateQtyBtn, "Failed to click on update quantity link");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Thread.sleep(3000);
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to update quantity to 2", e);
            e.printStackTrace();
        }
    }

    @Step("Verify {0}")
    private void compareInt(String message, int actual, int expected) {
        try {
            assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Exception.", e);
        }
    }

    @Step("Click on {elementName}")
    public void clickONMethod(String elementName, By locator, String assertionMessage) {
        try {
            ReusableMethods.scrollIntoView(driver.findElement(locator), driver);
            assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("On Membership page fill out the information for volume")
    public void fillInformationStep3WithNoFreeVolume() {
        try {
            Thread.sleep(5000);
            Assert.assertTrue(becomeMember.selectYourVolumeWithNoVolume(), "Information is not filled");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
        }

    }


    @Step("Validate that non member user is able to see membership with no free volume on the magento cart page.")
    public void nonMemberOrganisationalMembersipWithNoFreeVolume() {
        try {

            clickONMethod("Become a Organisational  Member button", membershipTypesPage.becomeOrganizationalMemberBtn,
                    "Click on 'Become a Organisational Member' button failed.");
            // Fill information of member
            String emailID = "testaccount" + System.currentTimeMillis() + "@mailinator.com";
            fillPersonalAndOrganisationalInformation("US_Address", emailID);
            fillComitteeInformationforMembership();
            fillVolumeDetails();
            clickONMethod("Submit button", becomeMember.submitBtn, "Failed to click on Submit button");
            clickONMethod("Confirm button", becomeMember.affilationPopupYesBtn, "Failed to click on confirm");
            PublicCommon.waitForSec(2);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
        }
    }

    @Step("Validate that non member user is able to see membership with no free volume on the magento cart page.")
    public void nonMemberOrganisationalMembersipWithNoFreeVolume(String emailID) {
        try {

            clickONMethod("Become a Organisational  Member button", membershipTypesPage.becomeOrganizationalMemberBtn,
                    "Click on 'Become a Organisational Member' button failed.");
            // Fill information of member
            fillPersonalAndOrganisationalInformation("US_Address", emailID);
            fillComitteeInformationforMembership();
            fillVolumeDetails();
            clickONMethod("Submit button", becomeMember.submitBtn, "Failed to click on Submit button");
            clickONMethod("Confirm button", becomeMember.affilationPopupYesBtn, "Failed to click on confirm");
            PublicCommon.waitForSec(2);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
        }
    }

    @Step("Open MCS2 and Change membership type to '{memberType}'")
    public void changeMembershipTypeFromMCS2(String environment, String memberType, String email, String mcs2UserName,
                                             String mcs2Pwd) {
        try {
            driver.get(mcs2Application.mc2LoginURL(environment));
            mcs2Application.signInToMC2(mcs2UserName, mcs2Pwd);
            PublicCommon.waitForSec(5);
            membershipData.changeMembershipType(email, memberType);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to change membership type");
        } finally {
            membershipData.signOut();
            PublicCommon.waitForSec(3);
        }
    }

    @Step("Change membership status to")
    public void changeMembershipStatusFromMCS2(String environment, String memberStatus, String paidStatus, String accountReason, String email,
                                               String mcs2UserName, String mcs2Pwd) {
        try {
            driver.get(mcs2Application.mc2LoginURL(environment));
            mcs2Application.signInToMC2(mcs2UserName, mcs2Pwd);
            PublicCommon.waitForSec(5);
            membershipData.changeAccountStatusFromMCS2(email, memberStatus, paidStatus,accountReason);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to change membership status");
        } finally {
            membershipData.signOut();
            PublicCommon.waitForSec(3);
        }
    }

    @Step("On Membership page fill out the information about your self ")
    public void fillPersonalAndOrganisationalInformation(String sheetName, String email) {
        try {
            assertTrue(becomeMember.enterPersonalDetailsofMembership(sheetName, email));
            assertTrue(becomeMember.enterOrganisationalDetailsofMembership(sheetName));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            becomeMember.clickOnNextBtn();

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
        }
    }

    @Step("On Membership page fill out the information of committee ")
    public void fillComitteeInformationforMembership() {
        try {
            ReusableMethods.scrollIntoView(becomeMember.getChooseCommittee(), driver);
            WaitStatementUtils.explicitWaitForVisibility(driver, becomeMember.getElement(becomeMember.chooseCommittee));
            Assert.assertTrue(becomeMember.isChooseComitteeBtnDisplayed(), "Choose button is not displayed");
            Assert.assertTrue(becomeMember.selectCommitteeFromList(0), " is not displayed");
            PublicCommon.selectValueInDropdown(becomeMember.getElement(becomeMember.describeOrganisationDropdown),
                    "Manufacturer of product/service");
            becomeMember.getElement(becomeMember.organisationDscription).sendKeys("ASTM");
            assertTrue(becomeMember.clickOnNextBtn());
            Assert.assertTrue(becomeMember.stepsPageHeaderIsVisible(), "Information not filled successfully");
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
            Assert.assertTrue(becomeMember.selectYourVolumeWithNoVolume(), "Information is not filled");

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
        }

    }

    @Step("Verify EBS status with '{order_number}'")
    public void verifyEBSStatus(String userAccount, String userPwd, String order_number) {
        try {
            adminSearchForOrdersByOrderId(userAccount, userPwd, order_number.substring(13));
            WaitStatementUtils.waitForElementToBeClickable(driver, adminMenuNavigation.getViewBtn(), 5);
            adminMenuNavigation.getElement(adminMenuNavigation.viewBtn).click();
            String ebsOrderStatus = adminMenuNavigation.getEBSOrderStatus();
            checkEBSOrderStatus(ebsOrderStatus);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to verify EBS status");
        } finally {
           // loginAdmin.doAdminLogout();
        }
    }

    @Step(" Create a  new account")
    public void createNewAccount(String email, String password) {

        try {
            navigateToMembershipPage();
            // Fill information details
            fillNewMembershipDetails("US_Address", email);
            clickONMethod("Checkout Button", cartPage.checkoutButton, "Failed to click on checkout button");
            assertTrue(loginPage.clickCreateAnAccountButton());
            verifyCreateAnAccountPage(password);
            enterCreditCardDetailsAndSubmit();
            verifyHeaderTextOnOrderConfirmationPage();
            signOut();

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Accept TnC - Exception.", e);
        }
    }

    @Step(" Create a  new account")
    public void createNonMemberNewAccount(String email, String password) {

        try {
            driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM") + "customer/account/create/");

            // Fill information details
            enterDetailsInCreateAnAccountPage(password, email);
            navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM")
                    + "products-services/standards-and-publications/smart-and-sustainable-manufacturing-systems.html");
            clickOnMethod("Subscription Tab", journalsProductPage.subscriptionTab);
            ReusableMethods.scrollIntoView(getElement(journalsProductPage.subscriptionAddToCartBtn), driver);
            clickOnMethod("Add To Cart button", journalsProductPage.subscriptionAddToCartBtn);
            clickOnMethod("Shopping Cart link", productPage.shoppingCart);
            assertTrue(cartPage.clickOnCheckoutButton(), "Failed to click on Checkout button.");
            enterBillingAddressWithoutCompanyName("US_Address");
            enterCreditCardDetailsAndSubmit();
            signOut();

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Accept TnC - Exception.", e);
        }
    }

    @Step("Entering Billing Information")
    public void enterBillingAddressWithoutCompanyName(String sheetName) {
        try {
            HashMap<String, String> dataMapBilling = ExcelDataConfig
                    .getMapData(ConfigReader.getValue("WebDataExcelPath"), sheetName);

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
            enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
                    dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
            ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
            enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
                    "Enter Postal Code in TextBox");
            selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
                    "Select Country from Drop down");
            selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
                    "Select State from Drop down");
            enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
            // Select the Shipping Address
            // assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select
            // Shipping Option");
            clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
                    "Continue button should be clickable");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
        }
    }

    @Step("Navigate to Membership page")
    public void navigateToMembershipPage() {
        try {
            driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM") + "get-involved/membership/membership-types.html");
            // Click on Become a Participating Member button
            WaitStatementUtils.waitForElementToBeClickable(driver,
                    membershipTypesPage.getElement(membershipTypesPage.becomeParticipatingMemberBtn));
            clickONMethod("Become a Participating  Member button", membershipTypesPage.becomeParticipatingMemberBtn,
                    "Failed to click on 'Become a Participating Member' button .");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to navigate to membership page");
        }
    }

    @Step("Fill out details for new Organisational membership")
    public void fillNewMembershipDetails(String canadaOfficeaddress, String emailID) {
        try {
            fillPersonalAndOrganisationalInformation(canadaOfficeaddress, emailID);
            fillComitteeInformationforMembership();
            fillInformationStep3WithNoFreeVolume();
            clickONMethod("Submit Button", becomeMember.submitBtn, "Failed to click on submit button");

            try {
                clickONMethod("Continue Button", becomeMember.continueBtn,
                        "Failed to click on continue button");
            } catch (Exception e) {
                e.printStackTrace();
            }

            PublicCommon.waitForSec(2);
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to fill membership details");
        }
    }

    @Step("Validate the Organizational field and checkbox are disabled and values are prepopulated on Create an account")
    public void verifyCreateAnAccountPage(String password) {
        try {
            assertTrue(createAcntPage.getFieldValues("additional_organization").getAttribute("value").contains("ASTM"));
            // assertTrue(!createAccountPage.getCommpanyAffilationCheckbox().isEnabled());
            createAcntPage.enterPassword(password);
            createAcntPage.confirmPassword(password);
            assertTrue(createAcntPage.clickCreateAccount());
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to verify create account page");
        }

    }

    @Step("Enter Details In Create An Account Page")
    public void enterDetailsInCreateAnAccountPage(String password, String email) {
        try {
            enterText("First name", createAcntPage.firstNameTextbox, "First Name", "Failed to enter first name");
            enterText("Last name", createAcntPage.lastNameTextbox, "Last Name", "Failed to enter Last name");
            createAcntPage.enterAdditionalOrganisationName("ASTM");
            enterText("Email", createAcntPage.emailAddressTextbox, email, "Failed to enter email");
            createAcntPage.enterPassword(password);
            createAcntPage.confirmPassword(password);
            assertTrue(createAcntPage.clickCreateAccount());
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to Enter Details In Create An Account Page");
        }

    }

    public void deleteTPTProduct() {
        try {
            int size = cartPage.getElements(cartPage.deleteOption).size();
            if (size > 1) {
                cartPage.getElements(cartPage.deleteOption).get(1).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to remove extra product");
        }
    }

    @Step("Verify member type is Participating")
    public void verifyMembershipTypeFromMCS2(String environment, String memberType, String email) {
        try {
            driver.get(mcs2Application.mc2LoginURL(environment));
            mcs2Application.signInToMC2("ygupta@astm.org", "6icG=F})");
            PublicCommon.waitForSec(5);
            membershipData.verifyMembershipType(email, memberType);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            membershipData.signOut();
            PublicCommon.waitForSec(3);
        }
    }

    @Step(" Create a  new account")
    public void createNewOrganizationalAccount(String email, String password) {

        try {
            driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM") + "get-involved/membership/membership-types.html");
            // Verify Organisational membership with no free volume.
            nonMemberOrganisationalMembersipWithNoFreeVolume(email);
            clickONMethod("Checkout Button", cartPage.checkoutButton, "Failed to click on checkout button");
            assertTrue(loginPage.clickCreateAnAccountButton());
            verifyCreateAnAccountPage(password);
            enterCreditCardDetailsAndSubmit();
            verifyHeaderTextOnOrderConfirmationPage();
            signOut();

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Accept TnC - Exception.", e);
        }
    }

    @Step("Open MCS2 and Change membership status to '{memberType}'")
    public void changeMembershipStatusFromMCS2(String environment, String memberStatus, String email,
                                               String mcs2UserName, String mcs2Pwd) {
        try {
            driver.get(mcs2Application.mc2LoginURL(environment));
            mcs2Application.signInToMC2(mcs2UserName, mcs2Pwd);
            PublicCommon.waitForSec(2);
            membershipData.changeMembershipStatus(email, memberStatus);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to change membership type");
        } finally {
            membershipData.signOut();
            PublicCommon.waitForSec(3);
        }
    }

    public String getPrice(String membershipType) {
        String text = getElementNew(membershipTypesPage.getPriceForMembershipProduct(membershipType)).getText()
                .split("\\:")[1].replace(" ", "");
        return text;
    }

    @Step("On Membership page fill out the information about your self ")
    public void fillPersonalInformationWithoutForOrgAssociatedMember(String sheetName, String email) {
        try {
            assertTrue(becomeMember.enterPersonalDetailsofMembership(sheetName, email));
            becomeMember.clickOnNextBtn();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickONMethod("No button ", becomeMember.affilationPopupNoBtn, "Failed  to click");
            clickONMethod("Confirm button", becomeMember.affilationPopupYesBtn, "Failed to click on confirm");
            PublicCommon.waitForSec(2);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
        }
    }

    @Step("User navigation after clicking on 'Submit Order' button on 'Payment page'")
    public void verifyTextOnOrderConfirmationPage() {
        try {
            PublicCommon.verifyVisibility("Order Confirmation header", orderConfirmationPage.thankYouMsg, driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.getStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Failed to verify Order Confirmation Page header", e);
        }
    }

    @Step("Enter password '{password}' and create an account")
    public void createAnAccount(String password) {
        try {
            createAcntPage.enterPassword(password);
            createAcntPage.confirmPassword(password);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertTrue(createAcntPage.clickCreateAccount());
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to verify create account page");
        }

    }

    @Step("Check order number generated for purchase")
    public void checkOrderNumber() {
        try {
            ReusableMethods.scrollIntoView(getElement(orderConfirmationPage.orderConfirmationPage_orderNumber), driver);
            String orderNumber = orderConfirmationPage.getOrderNumber();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertNotNull(orderNumber, "Issue with order creation.");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void createPTPAccountFromSelectAccountPage(String productUrl) {
        try {
            navigate(ConfigReader.getValue("BASE_URL_PUB_ASTM") + productUrl);

            PublicCommon.selectValueInDropdownbyIndex(
                    ptpComboProduct.getElement(ptpComboProduct.scheduleNameDropDwn), 1);

            assertTrue(ptpProductPage.clickRegisterForProgramButton(), "Click Register For Program button.");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickOnMethod("Cart button", commonPage.cartLink);
            driver.navigate().refresh();
            if (!cartPage.getElement(cartPage.checkoutButton).isEnabled()) {
                // Select different account and create PTP account
                clickOnMethod("Select different account link", cartPage.selectADifferentAccountLink);
                clickOnMethod("", selectAccountPage.createAnAccountBtn);
                PublicCommon.waitForSec(2);
                enterText("Organization name", createAcntPage.orgNamePTPAccount, "ASTM_PTP",
                        "Unable to enter organization name");
                clickOnMethod("Create account button", createAcntPage.createAnAccountButton);
                PublicCommon.waitForSec(3);
                clickOnMethod("Cart button", commonPage.cartLink);
            }
        } catch (IOException e) {
            e.printStackTrace();
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to create account");
        }
    }

    @Step("Validate the name, Organizational field and checkbox are disabled and values are prepopulated on Create an account")
    public void verifyCreateAnAccountPage() {
        try {
            assertTrue(
                    createAcntPage.getFieldValues("additional_organization").getAttribute("value").contains("ASTM"));
//			assertTrue(!createAccountPage.getCommpanyAffilationCheckbox().isEnabled());

            createAcntPage.enterPassword("Test123456");
            createAcntPage.confirmPassword("Test123456");
            assertTrue(createAcntPage.clickCreateAccount());
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to verify create account page");
        }

    }
}

