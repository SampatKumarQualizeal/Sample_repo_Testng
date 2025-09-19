package Tests;

import base.utils.*;
import com.astm.commonFunctions.*;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MakePurchase_PurchasingPTPproductWithNonPrepaidCountries_INT_755 extends BaseTest {

    static final String jiraTestID = "INT-755";
    Dashboard_PublicAdmin dashboard;
    CommonPage_Public commonpage;
    MenuNavigationPage_PublicAdmin MenuNavigationPage;
    AllCustomerPage_PublicAdmin AllCustomerPage;
    CommonBillingShippingThirdPartyTestHelper_Public commonBillShipThird;
    OrderConfirmPage_Integration orderPage;
    CustomerLogin_Public loginPage;
    LoginPage_PublicAdmin MagentoLoginPage;
    PublicAdminLogin publicAdminLoginDetails;
    OrderInformationPage_PublicAdmin OrderInformationPage;
    MembershipBecomeMemberPage newMembershipPage;
    PublicSearchPage searchPage;
    ASTMCartPage_Public astmCartPage;
    PTPTermsPage_Public PtpTermsPage;
    B2BandB2CDetailsPage_Public B2B_B2C_page;
    BillingAddressPage_Public billingAddressPage;
    PaymentOptionsPage_Public paymentOptionsPage;
    PaymentDetailsPage_Public paymentDetails;
    OrderConfirmPage_Integration orderConfirmationPage;
    CreatePasswordPage_PublicAdmin createPasswordPage;
    MAEIntegrationPage Maepage;
    MagentoLoginAndVerifyDashboardPage magentoLogin;
    SelectAnAccountPage_Public selectAnAccountPage;
    AllMemberShipTypeHelper allmemberShip;
    CreateAccountPage_Public createAcntPage;
    CommonPage_Public commonPage;
    HomePage_Public homepage;
    JsonFileReader jsonFileReader;
    String environment = null;
    String AccountNumber;
    String ProgramName;
    String userAccount = null;
    String userPwd = null;
    String email;

    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        try {
            driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM"));
            environment = PublicCommon.environmentSelector();
            jsonFileReader=new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            if (environment.equals("qa")) {
                //userAccount = credMap1.get("QAUser"); // userAccountQA;
                //userPwd = credMap1.get("QAPassword"); // userPwdQA;
            } else if (environment.equals("stage")) {
                userAccount = jsonFileReader.getJsonString("CredentialsMap", "Magento", "StageUser");
                userPwd = jsonFileReader.getJsonString("CredentialsMap", "Magento", "StagePassword");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to Complete Before Login Test",e);
        }
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Purchasing a PTP product with Non-Prepaid Countries")
    @Test(description = jiraTestID
            + ": Verify Purchasing a PTP product with Non-Prepaid Countries", groups = {""})
    public void VerifyPurchaseOfStandardProducts_Format_Hardcopy() {
        try {
            commonpage = page.getInstance(CommonPage_Public.class);
            searchPage = page.getInstance(PublicSearchPage.class);
            astmCartPage = page.getInstance(ASTMCartPage_Public.class);
            newMembershipPage = page.getInstance(MembershipBecomeMemberPage.class);
            dashboard = page.getInstance(Dashboard_PublicAdmin.class);
            PtpTermsPage = page.getInstance(PTPTermsPage_Public.class);
            B2B_B2C_page = page.getInstance(B2BandB2CDetailsPage_Public.class);
            commonBillShipThird =page.getInstance(CommonBillingShippingThirdPartyTestHelper_Public.class);
            billingAddressPage = page.getInstance(BillingAddressPage_Public.class);
            commonPage = page.getInstance(CommonPage_Public.class);
            paymentOptionsPage = page.getInstance(PaymentOptionsPage_Public.class);
            paymentDetails = page.getInstance(PaymentDetailsPage_Public.class);
            AllCustomerPage = page.getInstance(AllCustomerPage_PublicAdmin.class);
            orderConfirmationPage = page.getInstance(OrderConfirmPage_Integration.class);
            orderPage = page.getInstance(OrderConfirmPage_Integration.class);
            MenuNavigationPage = page.getInstance(MenuNavigationPage_PublicAdmin.class);
            loginPage = page.getInstance(CustomerLogin_Public.class);
            createPasswordPage = page.getInstance(CreatePasswordPage_PublicAdmin.class);
            MagentoLoginPage = page.getInstance(LoginPage_PublicAdmin.class);
            publicAdminLoginDetails = new PublicAdminLogin(environment);
            OrderInformationPage = page.getInstance(OrderInformationPage_PublicAdmin.class);
            Maepage = page.getInstance(MAEIntegrationPage.class);
            magentoLogin = page.getInstance(MagentoLoginAndVerifyDashboardPage.class);
            selectAnAccountPage = page.getInstance(SelectAnAccountPage_Public.class);
            allmemberShip = page.getInstance(AllMemberShipTypeHelper.class);
            createAcntPage = page.getInstance(CreateAccountPage_Public.class);
            homepage=page.getInstance(HomePage_Public.class);


            email = "stgintauto" +PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"_755@yopmail.com";
            VerifyAccountCreation(email);
            verifyNavigationToASTMProficiencyTestingPrograms();
            String ProgramName = VerifyselectPTPprogram();
            String PTPPrice = "$822.00";
            ClickOnRegisterForThisProgram(ProgramName);
            VerifyUpdateQuantityFunctionality(ProgramName);
            RestoreLastRemovedProduct();
            verifyShoppingCart(ProgramName,PTPPrice);
            clickOnAcceptTermsButton();
            verifyBillingAddressHeaderVisible();
            validateWarningMessages();
            commonBillShipThird.enterBillingAddressWithoutCompanyName(jsonFileReader.getJsonString("shipTO"),"AUZ_BillingAddress","WebDataExcelPath");
            if(jsonFileReader.getJsonString("shipTO").equalsIgnoreCase("Different Contact"))
            {
                commonBillShipThird.verifyContactPersonHeaderIsVisible();
                commonBillShipThird.enterShippingContactPerson("INT_755","WebDataExcelPath");
            }
            commonBillShipThird.verifyThirdPartyShippingHeaderIsVisible();
            commonBillShipThird.enterThirdPartyShippingInformation("Both","INT_755","WebDataExcelPath",email);
            paymentMethodAndPONumber(jsonFileReader.getJsonString("paymentMethod"),jsonFileReader.getJsonString("PONumber"));
            verifyTaxOnOrderConfirmationPage(jsonFileReader.getJsonString("Order Tax"), jsonFileReader.getJsonString("Order Confirmation Title"),PTPPrice);
            ValidateSuccessPageDetails(PTPPrice);
            String orderNumber = orderPage.getOrderNumber();
            String AccountNumber = getAccountNumber();
            ValidateEmail(email,orderNumber);

            //Magento Validations
            //Sign-in to admin
            OpenMagento();
            //Enter login credentials
            magentoLogin.login(userAccount, userPwd);
            commonPage.IncomeMessageModelHeader();
            VerifyEBSstatus(orderNumber);

            //OKTA Validation
            getOktaStatus(environment,email);

            //MAE Validations
            ConfigReader.setValue("BASE_URL_MAE", "https://stage-manage.astm.org/");
            LoginMAE();
            enterAccountNumber(AccountNumber);
            ValidateOktaAndAccountStatus();

        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify Purchasing a PTP product with Non-Prepaid Countries", e);
        }
        System.out.println("Successfully Verified Purchasing a PTP product with Non-Prepaid Countries");
    }



    @Step("Validate navigation to {ASTM Proficiency Testing Programs} from homepage")
    public void verifyNavigationToASTMProficiencyTestingPrograms() {
        try {
            PublicCommon.waitForSec(2);
            homepage.navigateToHomeLink("Standards & Solutions","PT Program List",1,1);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertEquals(commonpage.getElement(commonpage.PTPheader).getText(),"ASTM Proficiency Testing Programs (PTP)");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify search of standard products", e);
        }
    }

    @Step("Click on Register for a program button")
    public void VerifyRegisterForAprogram(){
        try{
            assertEquals(commonpage.getElement(commonpage.RegisterForAprogram).getText(),"Register for a Program");
            PublicCommon.waitForSec(5);
            commonpage.RegisterForAprogramBtn();

        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Click on Register for a program button", e);
        }
    }

    @Step("Select any program from list of Multiple PTP Programs")
    public String VerifyselectPTPprogram() {
        try{
            Assert.assertTrue(commonpage.clickAndExpand("Full List"),"Full List should be Clicked");
            String ProgramName = commonpage.selectProgramByIndex(2).getText();
            commonpage.selectProgramByIndex(2).click();
            Assert.assertEquals(commonpage.getElement(commonpage.PTPprogramPage).getText(),ProgramName);
            return ProgramName;
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Select any program from list of Multiple PTP Programs", e);
        }
        return ProgramName;
    }

    @Step("Click on Register For This Program button in PTP page")
    public void ClickOnRegisterForThisProgram(String ProgramName){
        try{
            PublicCommon.waitForSec(5);
            WaitStatementUtils.waitForElementToBeClickable(driver,commonpage.getElement(commonpage.RegisterProgramBtnInPTPpage),30);
            clickOnMethod("Register for this Program", commonpage.RegisterProgramBtnInPTPpage, "Failed to click on Register for this Program");
            assertTrue(searchPage.verifyText(searchPage.ShoppingCartMessage).contains("You added "+ProgramName+" to your"));
            PublicCommon.waitForSec(10);
            clickOnMethod("Register for this Program", commonpage.RegisterProgramBtnInPTPpage, "Failed to click on Register for this Program");
            PublicCommon.waitForSec(10);
            assertTrue(searchPage.verifyText(searchPage.MessageError).contains("Only 1 PTP program is allowed"));
            clickOnMethod("Register for this Program", commonpage.RegisterProgramBtnInPTPpage, "Failed to click on Register for this Program");
            PublicCommon.waitForSec(15);
            clickOnMethod("Shopping cart Link", searchPage.shoppingCartLink, "Couldn't click on Add to Cart button");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click on Register for this Program Button ", e);
        }
    }

    @Step("Verify Update quantity functionality")
    public void VerifyUpdateQuantityFunctionality(String ProgramName){
        try{
            String ProductTitle = astmCartPage.getProductTitle();
            Assert.assertEquals(ProgramName, ProductTitle);
            PublicCommon.waitForSec(5);
            PublicCommon.clearTextFieldsendKeys(astmCartPage.getQuantityTextbox(), "2");
            clickOnMethod("Update Quantity", astmCartPage.UpdateQtyBtn, "Failed to click on update quantity");
            PublicCommon.waitForSec(5);
            assertTrue(astmCartPage.verifyText(astmCartPage.PopUpMsg).contains("Only 1 PTP program is allowed in the cart. To add this product, you must clear your cart"));
            clickOnMethod("Ok Button", astmCartPage.OkBtn, "Failed to click on Footer model Ok Btn");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click on Register for this Program Button ", e);
        }
    }

    @Step("Click on Restore last removed product after verifying update quantity functionality")
    public void RestoreLastRemovedProduct(){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver, astmCartPage.getElement(astmCartPage.RestoreLastRemovedProduct),10);
            clickOnMethod("Restore Last Removed Product", astmCartPage.RestoreLastRemovedProduct, "Failed to click on Footer model Ok Btn");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click on Register for this Program Button ", e);
        }
    }


    @Step("Verify Product title in Cart page")
    public void VerifyProductTitle(){
        try{
            String ProductTitle = astmCartPage.getProductTitle();
            assertEquals(ProgramName,ProductTitle);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click on Register for this Program Button ", e);
        }
    }

    @Step("Verify Shopping cart and click in Checkout Button")
    public void verifyShoppingCart(String ProgramName, String PTPPrice) {
        try{
            String ProductTitle = astmCartPage.getProductTitle();
            Assert.assertEquals(ProgramName, ProductTitle);
            Assert.assertEquals(PTPPrice,astmCartPage.getCartSubTotal());
            if(billingAddressPage.isElementDisplayed(page.getElement(astmCartPage.selectDifferentAccount))) {
                clickOnMethod("Click on Select different Account", astmCartPage.selectDifferentAccount, "Couldn't click on select different Account button");
                ScreenshotUtil.takeScreenshotForAllure(driver);
                WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(astmCartPage.selectDifferentAccount),10);
                clickOnMethod("Create Account Button", selectAnAccountPage.createAnAccountBtn,"Failed to click on Create Account Button");
                PublicCommon.waitForSec(5);
                allmemberShip.enterText("Organization name", createAcntPage.orgNamePTPAccount, "ASTM_PTP",
                        "Unable to enter organization name");
                ScreenshotUtil.takeScreenshotForAllure(driver);
                clickOnMethod("Create account button", createAcntPage.createAnAccountButton,"Failed to click on Create Account Button");
                PublicCommon.waitForSec(3);
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
     /*       if(!page.getElement(astmCartPage.checkoutButton).isDisplayed())
            {
                PublicCommon.waitForSec(3);
                clickonMethod("Cart Button",page.getElement(billingAddressPage.cartButton));
            }*/
            clickOnMethod("Checkout Button", astmCartPage.checkoutButton, "Failed to click on checkout button");
        } catch (Exception e) {
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to click in Checkout Button");
        }
    }

    @Step(" Click on Accept Terms Button")
    public void clickOnAcceptTermsButton() {
        try {
            assertTrue(PtpTermsPage.clickAcceptTermsButton(), "Click Accept button.");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to click on Accept term Button");
        }
    }

    @Step("Create New Account and Fill all Mandatory details")
    public void VerifyAccountCreation(String email){
        try{
            ScreenshotUtil.takeScreenshotForAllure(driver);
            driver.get(ConfigReader.getValue("B2Curl"));
            newMembershipPage.handleOneTrustCookie();
            B2B_B2C_page.CreateB2CAccount(
                    jsonFileReader.getJsonString("Firstname"),
                    jsonFileReader.getJsonString("Lastname"),
                    jsonFileReader.getJsonString("Password"),
                    jsonFileReader.getJsonString("ConfirmPassword"),email);
            newMembershipPage.handleOneTrustCookie();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify creating new Account", e);
        }
    }

    @Step("Validate the Warning Messages for the product." )
    private void validateWarningMessages() {
        try {
            //String actualMessage = billingAddressPage.getHazardousWarningMessage();
            assertTrue(searchPage.verifyText(billingAddressPage.HazardousWarningText).contains("One or more of the products in your cart contains a hazardous material."));
            //Assert.assertEquals(actualMessage,jsonFileReader.getJsonString("WarningMessage"),"Warning Messages do not match.");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
        }
    }

    @Step("Select Payment Method : {paymentMethod} and Enter PO Number: {poNumber}")
    public void paymentMethodAndPONumber(String paymentMethod, String poNumber)
    {
        try {
            PublicCommon.waitForSec(10);
            //paymentOptionsPage.paywithEFT(poNumber);   paymentOptionsPage.selectPaymentMethodAndEnterPONumber(paymentMethod, poNumber)
            assertTrue(paymentOptionsPage.selectPaymentMethodAndEnterPONumber(paymentMethod, poNumber),"Payment Method should be Selected");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Select Payment Method", e);
        }
    }

    @Step("Verify tax on Order Confirmation page.")
    public void verifyTaxOnOrderConfirmationPage(String tax, String expectedTitle,String PTPPrice) {
        try {
            String GrandTotal = paymentDetails.getPTPGrandTotalprice();
            Assert.assertEquals(PTPPrice, GrandTotal);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicAdminCommons.clickElementByJavaScript(driver,paymentDetails.submitButton);
            PublicCommon.waitForSec(15);
            verifyTitle("Order Confirmation", expectedTitle);
            verifyTax(orderConfirmationPage.getShippingAddress().getText(), orderConfirmationPage.checkTaxOnOrderConfirmationPage(), tax);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.getStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify Tax on Order Confirmation page.", e);
        }
    }

    @Step("Validate Order confirmation Email")
    public void ValidateEmail(String emailID,String orderNumber) {
        try {
            PublicCommon.openNewTabAndSwitch(driver);
            createPasswordPage.SearchEmailId(emailID,orderNumber);
            driver.close();
            Set<String> handles = driver.getWindowHandles();
            for (String handle : handles) {
                driver.switchTo().window(handle);
            }
            System.out.println(driver.getTitle());
        } catch (Exception e) {
            e.getStackTrace();
            log.info(e.toString());
            PublicCommon.reportFailAssert("Failed to signout with account ", e);
        }
    }

    @Step("Validate Success page details PoNumber, Payment type and Grand Total")
    public void ValidateSuccessPageDetails(String PTPPrice){
        try{
            assertEquals(orderPage.getElement(orderPage.SuccessPageGrandTotal).getText(),PTPPrice);
            assertEquals(orderPage.getElement(orderPage.SuccessPagePoNumber).getText(),jsonFileReader.getJsonString("PONumber"));
            assertEquals(orderPage.getElement(orderPage.SuccessPagePaymentType).getText(),jsonFileReader.getJsonString("paymentMethod"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.getStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify Tax on Order Confirmation page.", e);
        }
    }

    @Step("Get Account Number and logout of public")
    public String getAccountNumber(){
        try {
            IntegrationCommon.clickonWebElement(driver, orderPage.signinDropdown,"Unable to Click on ");
            PublicCommon.waitForSec(5);
            IntegrationCommon.clickonWebElement(driver, orderPage.MyAccountTab);
            String AccountNumber = orderPage.checkAccountNumberOnAccountNumber();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            IntegrationCommon.clickonWebElement(driver, loginPage.signinDropdown);
            PublicCommon.waitForSec(5);
            IntegrationCommon.clickonWebElement(driver, loginPage.MembersingoutBTN);
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return AccountNumber;
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify details on Order confirmation Page", e);
        }
        return AccountNumber;
    }

    @Step("Open Magento")
    public void OpenMagento(){
        try{
            PublicAdminCommons.waitForSec(10000);
            //openNewTabAndSwitch(driver, 1);
            driver.get(ConfigReader.getValue("BASE_URL_PUB_ADMIN_ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to login Magento", e);
        }
    }

    @Step("Click on Sales and Order Button, Validate EBS Order status is /Success/")
    public void VerifyEBSstatus(String orderNumber){
        try{
            navigateToOrdersPage(orderNumber);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            commonpage.ViewBtn().click();
            driver.navigate().refresh();
            driver.navigate().refresh();
            Assert.assertTrue(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus())
                    .equals("Success"), " EBS order status is not success");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickOnMethod("Profile Dropdown",dashboard.getProfileDropDown(),"Unable to Click on User Profile Dropdown");
            clickOnMethod("SignOut Link",dashboard.getSignoutButton(),"Unable to Click on User SignOut Link");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin was not able to login.", e);
        }
    }

    @Step("Navigate to Orders tab and search with order number")
    public void navigateToOrdersPage(String OrderNo) {
        try {
            OrderNo = OrderNo.replaceAll("Order Number: ","");
            MenuNavigationPage.navigatesToOrdersTab();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomerPage.clearFilters();
            AllCustomerPage.enterTextInSearchTextField(OrderNo);
            WaitStatementUtils.waitForElementToBeClickable(driver, MenuNavigationPage.getElement(AllCustomerPage.getSearchButton()),10);
            clickOnMethod("Search Button",AllCustomerPage.getSearchButton(),"Unable to Click on Search Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to navigate to Orders Page and Search Order .", e);

        }
    }
    public void getOktaStatus(String environment, String email) {
        try {
            String env=environment.toUpperCase();
            OktaAPIs oktaAPIs = new OktaAPIs(env);
            Response response = oktaAPIs.getOktaUserDetailsByEmail(email);
            Assert.assertEquals(response.getStatusCode(), 200,
                    "Admin is unable to get user details");
            String oktaAccountStatus = response.jsonPath().getString("status");
            System.out.println(oktaAccountStatus);
            Assert.assertTrue(oktaAccountStatus.equals("ACTIVE"), " OKTA Account Status is Not Active But Status is : "+oktaAccountStatus);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Step("Login to MAE and search with MAE Account ID")
    public void LoginMAE() throws IOException {
        try {
            Maepage.MAElogin(jsonFileReader.getJsonString("CredentialsMap", "MAEAccount", "StageUser"),
                    jsonFileReader.getJsonString("CredentialsMap", "MAEAccount", "StagePassword"));
            Maepage.selectASTMTenanat();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify details on Order confirmation Page", e);
        }
    }

    @Step("Enter Account Number")
    public void enterAccountNumber(String AccountNumber){
        try{
            Maepage.enterAccountNumber(AccountNumber);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify details on Order confirmation Page", e);
        }
    }
    @Step("Validate Account user status and Okta status in User management")
    public void ValidateOktaAndAccountStatus(){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver, page.getElement(Maepage.accountList1),15);
            clickonMethod("Account", page.getElement(Maepage.accountList1));
            Maepage.UserManagementAccountStatus();
            Maepage.getSignoutdropdown();
            Maepage.clickSignoutBtn();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify Account user status and Okta status in User management", e);
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
    public void clickOnMethod(String elementName, By locator, String assertionMessage) {
        try {
            assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Click on element", e);
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
    @Step("Click on {0}")
    private void clickonMethod(String message, WebElement element) {
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
    @Step("Verify Tax for address: {0} ")
    public void verifyTax(String address, String actualText, String expectedText) {
        try {
            Assert.assertEquals(actualText, expectedText, "Text doesn't match the expected text.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify Tax", e);
        }

    }

    @Step("Navigate to 'Billing Address'")
    public void verifyBillingAddressHeaderVisible() {
        try {
              try {
                WaitStatementUtils.waitForLoaderToBeInvisible(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(!page.getElement(billingAddressPage.billingAddressHeader).isDisplayed())
            {
                WaitStatementUtils.waitForElementToBeClickable(driver, page.getElement(astmCartPage.cartLinkOnHomePage), 30);
                (new Actions(driver)).moveToElement(page.getElement(astmCartPage.cartLinkOnHomePage)).click().build().perform();
                astmCartPage.clickCheckoutButton11();
            }

            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify Billing Address header is visible", e);
        }
    }



}
