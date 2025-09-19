package testobjects.prerequisitegenerator;

import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.EbsManualVerificationFileWriter;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicAdminLogin;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ui.*;

import java.util.concurrent.TimeUnit;

public class CommonWebActions_PublicAdmin {

    private WebDriver driver;
    ContactsPage_PublicAdmin ContactsPage;
    AddUpdateContact_PublicAdmin AddContactsPage;
    LoginPage_PublicAdmin LoginPage;
    AllCustomerPage_PublicAdmin AllCustomerPage;
    CustomerViewPage_PublicAdmin CustomerViewPage;
    MenuNavigationPage_PublicAdmin MenuNavigationPage;
    HomePage_Public HomePagePublic;
    Dashboard_PublicAdmin DashboardPage;
    MyAccountPage_Public MyAccountPublicPage;
    ContactsPage_PublicAdmin ContactListPage;
    OrdersPage_PublicAdmin OrdersPage;
    UserSelectionUnderOrderPage_PublicAdmin UserSelectionPage;
    AccountInformationEdit_PublicAdmin AccountInformationEdit;
    MAEIntegrationPage MaePage;
    ASTMCartPage_Public astmCartPage;

    public CommonWebActions_PublicAdmin(WebDriver driver, Page page) {
        this.driver = driver;
        ContactsPage = page.getInstance(ContactsPage_PublicAdmin.class);
        AddContactsPage = page.getInstance(AddUpdateContact_PublicAdmin.class);
        LoginPage = page.getInstance(LoginPage_PublicAdmin.class);
        AllCustomerPage = page.getInstance(AllCustomerPage_PublicAdmin.class);
        CustomerViewPage = page.getInstance(CustomerViewPage_PublicAdmin.class);
        MenuNavigationPage = page.getInstance(MenuNavigationPage_PublicAdmin.class);
        HomePagePublic = page.getInstance(HomePage_Public.class);
        DashboardPage = page.getInstance(Dashboard_PublicAdmin.class);
        MyAccountPublicPage = page.getInstance(MyAccountPage_Public.class);
        ContactListPage = page.getInstance(ContactsPage_PublicAdmin.class);
        OrdersPage = page.getInstance(OrdersPage_PublicAdmin.class);
        UserSelectionPage = page.getInstance(UserSelectionUnderOrderPage_PublicAdmin.class);
        AccountInformationEdit = page.getInstance(AccountInformationEdit_PublicAdmin.class);
        MaePage = page.getInstance(MAEIntegrationPage.class);
        astmCartPage = page.getInstance(ASTMCartPage_Public.class);
    }

    @Step("Navigate to order creation screen for customer")
    public void navigateToOrderCreationScreenForCustomer(String email) {
        try {
            MenuNavigationPage.navigatesToOrdersTab();
            clickOnMethod("Create New Order Button", OrdersPage.getAddNewOrderButton(),
                    "Unable to click on 'Create New Order Button'");
            enterTextInTextField("Email Text Field", UserSelectionPage.getEmailSearchField(), email,
                    true, "Unable to enter text in 'Email Text Field'");
            PublicAdminCommons.waitForSec(5000);
            clickOnMethod("Search Button", UserSelectionPage.getSearchButton(),
                    "Unable to click on 'Search Button'");
            waitForLoadingScreenToDisappear(UserSelectionPage.getSpinnerIcon());
            clickOnMethod("First Search Result", UserSelectionPage.getFirstNameFromSearchResults(),
                    "Unable to click on first search result");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to navigate to order creation screen for customer", e);
        }
    }

    @Step("Navigate to customer view page for any valid '{accountType}' type account present in customer grid")
    public void clickEditForAccountFromSearchGrid(String accountType) {
        try {
            waitForLoadingScreenToDisappear(AllCustomerPage.getSpinnerIcon());
            AllCustomerPage.clearFilters();
            Assert.assertTrue(AllCustomerPage.sortByCustomerSinceByDescendingOrder(), "Unable to sort customer");
            Assert.assertTrue(AllCustomerPage.clickEditButtonForValidAccount(accountType),
                    "Unable to click edit button for a valid account present in customer grid");
            waitForLoadingScreenToDisappear(CustomerViewPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent is unable to click on edit button for a valid account.", e);
        }
    }

    @Step("Get The ebs account for the customer")
    public String getEbsAccountNumberOfTheCustomer() {
        try {
            clickOnMethod("Account Information Edit Page", CustomerViewPage.getAccountInformationButton(),
                    "Admin/ISS Agent is unable to click on 'Account Information Edit Page'");
            String ebsNumber = PublicAdminCommons.getValueForAttributeForElement(driver, AccountInformationEdit.getEbsAccountNumber());
            Assert.assertNotEquals(ebsNumber, "", "Unable to get EBS account number");
            return ebsNumber;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to click on edit button for a valid account.", e);
            return "";
        }
    }

    @Step("Navigate to customer view page for any valid '{accountType}' type account present in customer grid")
    public void clickEditForAccountFromSearchGridWithExcludedEmail(String accountType, String emailToExclude) {
        try {
            waitForLoadingScreenToDisappear(AllCustomerPage.getSpinnerIcon());
            AllCustomerPage.clearFilters();
            Assert.assertTrue(AllCustomerPage.sortByCustomerSinceByDescendingOrder(), "Unable to sort customer");
            Assert.assertTrue(AllCustomerPage.clickEditButtonForValidAccountExceptEmail(accountType, emailToExclude),
                    "Unable to click edit button for a valid account present in customer grid");
            waitForLoadingScreenToDisappear(CustomerViewPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent is unable to click on edit button for a valid account.", e);
        }
    }

    @Step("Navigate to customer information page for any {customerType} type customer")
    public void navigateToCustomerInformationPageForAnyTypeCustomer(String customerType) {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            clickEditForAccountFromSearchGrid(customerType);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Navigate to customer information page for any {type} type customer", e);
        }
    }

    @Step("Navigate to order creation page for any {customerType} type customer")
    public void navigateToOrderCreationScreenForAnyTypeCustomer(String customerType) {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            clickEditForAccountFromSearchGrid(customerType);
            clickOnMethod("Create New Order Button", CustomerViewPage.getCreateOrderButton(),
                                "Unable to click on 'Create New Order Button'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Navigate to customer information page for any {type} type customer", e);
        }
    }

    @Step("Navigate to contacts page of the customer")
    public void navigateToContactsPageForAnyTypeCustomer() {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            clickEditForAccountFromSearchGrid();
            clickOnMethod("Contacts Tab", CustomerViewPage.getContactsButton(),
                    "ISS Agent/Admin is unable to click on 'Contacts Tab'");
            waitForLoadingScreenToDisappear(ContactListPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Navigate to customer information page for any {type} type customer", e);
        }
    }

    @Step("Navigate to customer information page for any {customerType} type customer")
    public void navigateToCustomerInformationPageForAnyTypeCustomerExcludeEmail(String customerType, String excludedEmail) {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            clickEditForAccountFromSearchGridWithExcludedEmail(customerType, excludedEmail);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Navigate to customer information page for any {type} type customer", e);
        }
    }

    @Step("Navigate to customer view page for any valid account present in customer grid")
    public void clickEditForAccountFromSearchGrid() {
        try {
            waitForLoadingScreenToDisappear(AllCustomerPage.getSpinnerIcon());
            AllCustomerPage.clearFilters();
            Assert.assertTrue(AllCustomerPage.sortByCustomerSinceByDescendingOrder(), "Unable to sort customer");
            Assert.assertTrue(AllCustomerPage.clickEditButtonForValidAccount(),
                    "Unable to click edit button for a valid account present in customer grid");
            waitForLoadingScreenToDisappear(CustomerViewPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent is unable to click on edit button for a valid account.", e);
        }
    }

    @Step("ISS Agent enters credentials to login into the portal")
    public void issLogin(PublicAdminLogin loginObject) {
        try {
            Assert.assertTrue(LoginPage.issAgentLogin(loginObject.getLoginUsername(),
                    loginObject.getPassword()), "ISS Agent was not able to login.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent was not able to login.", e);
        }
    }

    @Step("ISS Manager enters credentials to login into the portal")
    public void issManagerLogin(PublicAdminLogin loginObject) {
        try {
            Assert.assertTrue(LoginPage.loginIntoAdminPanel(loginObject.getLoginUsername(),
                    loginObject.getPassword()), "ISS Agent was not able to login.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent was not able to login.", e);
        }
    }

    @Step("ISS Agent enters credentials to login into the portal")
    public void publicIssLogin(PublicAdminLogin loginObject) {
        try {
            Assert.assertTrue(LoginPage.loginIntoAdminPanelWithAssertingDashboard(loginObject.getLoginUsername(),
                    loginObject.getPassword()), "ISS Agent was not able to login.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent was not able to login.", e);
        }
    }

    @Step("Admin enters credentials to login into the portal")
    public void adminLogin(PublicAdminLogin loginObject) {
        try {
            Assert.assertTrue(LoginPage.loginIntoAdminPanel(loginObject.getLoginUsername(),
                    loginObject.getPassword()), "ISS Agent was not able to login.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent was not able to login.", e);
        }
    }

    @Step("Navigate to account information edit page of customer")
    public void navigateToAccountInformationEditPageOfCustomerFromAllCustomerPage(String email) {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            navigateToAccountInformationEditPage(email);

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Navigate to account information edit page of customer", e);
        }
    }

    @Step("Navigate to account information page of customer with email '{email}'")
    public void navigateToAccountInformationPagewithCommunicationMail(String email) {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomerPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomerPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on Filter Button");
            enterTextInTextField("Email Filter Text Field", AllCustomerPage.getCommunicationEmailFilterField(), email, true,
                    "Admin/ISS Agent is unable to enter text in email filter text field");
            clickOnMethod("Apply Filter Button", AllCustomerPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            WaitStatementUtils.waitForElementToBeClickable(driver, astmCartPage.getElement(AllCustomerPage.getEditButton()),15);
            astmCartPage.getElement(AllCustomerPage.getEditButton()).click();
            clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                    "Admin/ISS Agent is unable to click on Account Information Tab");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to account information page", e);
        }
    }

    @Step("Navigate to account information edit page of customer with email '{email}'")
    public void navigateToAccountInformationEditPage(String email) {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomerPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomerPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on Filter Button");
            enterTextInTextField("Email Filter Text Field", AllCustomerPage.getEmailFilterField(), email, true,
                    "Admin/ISS Agent is unable to enter text in email filter text field");
            PublicCommon.waitForSec(5);
            clickOnMethod("Apply Filter Button", AllCustomerPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            WaitStatementUtils.waitForElementToBeClickable(driver, astmCartPage.getElement(AllCustomerPage.getEditButton()),15);
            astmCartPage.getElement(AllCustomerPage.getEditButton()).click();
            clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                    "Admin/ISS Agent is unable to click on Account Information Tab");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to account information page", e);
        }
    }

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

	/*
	 * @Step("Admin/ISS Agent/User logout of account from Magento Admin side")
	 * public void adminAgentLogoutOfPublicAccount() { try {
	 * clickOnMethod("Account DropDown", HomePagePublic.getLoggedInMyASTMButton(),
	 * "Admin/ISS Agent/User is unable to click on 'Profile Dropdown'");
	 * clickOnMethod("Sign out Button", HomePagePublic.getSignOutButton(),
	 * "Admin/ISS Agent/User is unable to click on 'Logout Button'");
	 * verifyElementIsDisplayedOnPage("Sign out Success Message",
	 * HomePagePublic.getSessionEndedMessage()); } catch (Exception e) {
	 * e.printStackTrace();
	 * PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to logout",
	 * e); } }
	 */

    @Step("{stepDetails}")
    public void addEbsValidationDetails(String stepDetails) {
        try {
            Assert.assertTrue(true);
            EbsManualVerificationFileWriter.writeManualVerificationStep(stepDetails);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Manual verification failed", e);
        }
    }

	/*
	 * @Step("Navigate product page for customer under ASTM tenant") public void
	 * navigateProductPageForCustomerUnderAstmTenant(String ebsAccountNumber) { try
	 * { clickOnMethod("Select ASTM Account", MaePage.selectASTMAccountName,
	 * "Unable to Select ASTM Account"); selectValueFromDropDown("Account Tye",
	 * MaePage.selectTypes, "Account Number", "Unable to Select Account Number");
	 * enterTextInTextField("Account number", MaePage.searchfield, ebsAccountNumber,
	 * true, "Unable to enter EBS Account Number in Account number for text field");
	 * Assert.assertTrue(PublicAdminCommons.sendSeleniumKeys(driver,
	 * MaePage.searchfield, Keys.ENTER), "Unable to press enter key");
	 * PublicCommon.JSClick(MaePage.getSearchIcon(), driver);
	 * WaitStatementUtils.explicitWaitForVisibility(driver,
	 * MaePage.getAccountList().get(0)); clickOnMethod("Account",
	 * MaePage.accountList, "Unable to click on Searched Account");
	 * clickOnMethod("Products Tab", MaePage.productsTab,
	 * "Unable to click on product tab"); } catch (Exception e) {
	 * e.printStackTrace(); PublicAdminCommons.
	 * reportFailAssert("Navigate product page for customer under ASTM tenant", e);
	 * } }
	 */

    @Step("ISS Agent clicks on {elementName}")
    public void clickOnMethod(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.loaderClick(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("ISS Agent enters {value} in {elementName}")
    public void enterTextInTextField(String elementName, By locator, String value, boolean clear,
                                     String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.enterTextInTextField(driver, locator, value, clear), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
        }
    }

    @Step("ISS Agent clears the {elementName}")
    public void clearTextField(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.clearTextField(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
        }
    }

    @Step("ISS Agent selects {value} from {elementName}")
    public void selectValueFromDropDown(String elementName, By locator, String value, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, locator, value), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to select option from drop down", e);
        }
    }

    @Step("ISS Agent selects value from {elementName}")
    public void selectValueFromDropDownByIndex(String elementName, By locator, int index, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, locator, index), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to select option from drop down", e);
        }
    }

    @Step("ISS Agent waits for loading screen to appear then disappear")
    public void waitForLoadingScreenToDisappear(By locator) {
        try {
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, locator),
                    "Loading screen did not disappear.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Loading screen did not disappear.", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' is not present on page")
    public void verifyElementIsNotPresentOnPage(String elementName, By locator, String testCaseId) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Assert.assertEquals(PublicAdminCommons.getCountOfElement(driver, locator), 0,
                    "[" + testCaseId + "] " + elementName + " is present on the page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is present on the page", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' is not displayed on page")
    public void verifyElementIsNotDisplayedOnPage(String elementName, By locator, String testCaseId) {
        try {
            Assert.assertFalse(PublicAdminCommons.isWebElementDisplayed(driver, locator),
                    "[" + testCaseId + "] " + elementName + " is displayed on the page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is displayed on the page", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' is  displayed on page")
    public void verifyElementIsDisplayedOnPage(String elementName, By locator, String testCaseId) {
        try {
            Assert.assertTrue(PublicAdminCommons.isWebElementDisplayed(driver, locator),
                    "[" + testCaseId + "] " + elementName + " is not displayed on the page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is not displayed on the page", e);
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

    @Step("[{testCaseId}] Verify '{elementName}' is present on page")
    public void verifyElementIsPresentOnPage(String elementName, By locator, String testCaseId) {
        try {
            Assert.assertTrue(PublicAdminCommons.isElementPresentOnPageWithException(driver, locator),
                    "[" + testCaseId + "] " + elementName + " is not present on the page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is not present on the page", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' is clickable")
    public void verifyElementIsClickableByClassMethod(String elementName, By locator, String testCaseId) {
        try {
            Assert.assertFalse(PublicAdminCommons.getValueOfAttributeForElement(driver, locator, "class").contains("disabled"),
                    "[" + testCaseId + "] " + elementName + " is not clickable");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is clickable", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' is not clickable")
    public void verifyElementIsNotClickableByClassMethod(String elementName, By locator, String testCaseId) {
        try {
            Assert.assertTrue(PublicAdminCommons.getValueOfAttributeForElement(driver, locator, "class").contains("disabled"),
                    "[" + testCaseId + "] " + elementName + " is clickable");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is clickable", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' drop down is set to '{value}'")
    public void verifySelectedValueUnderDropdown(String elementName, By locator, String value, String testCaseId) {
        try {
            Assert.assertEquals(PublicAdminCommons.getSelectedValueForDropDown(driver, locator), value,
                    "[" + testCaseId + "] " + value + " is not selected under " + elementName);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + value + " is not selected under " + elementName, e);
        }
    }

    @Step("{stepDef}")
    public void assertEqualWithStep(String actual, String expected, String stepDef, String assertionMessage) {
        try {
            Assert.assertEquals(actual, expected,
                    assertionMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(assertionMessage, e);
        }
    }

    @Step("{stepDef}")
    public void assertEqualObjectWithStep(Object actual, Object expected, String stepDef, String assertionMessage) {
        try {
            Assert.assertEquals(actual, expected,
                    assertionMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(assertionMessage, e);
        }
    }

    @Step("{stepDef}")
    public void assertNotEqualWithStep(String actual, String expected, String stepDef, String assertionMessage) {
        try {
            Assert.assertNotEquals(actual, expected,
                    assertionMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(assertionMessage, e);
        }
    }

    @Step("{stepDef}")
    public void assertNotNullWithStep(String value, String stepDef, String assertionMessage) {
        try {
            Assert.assertNotNull(value, assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(assertionMessage, e);
        }
    }

    @Step("{stepDef}")
    public void assertTrueWithStep(boolean result, String stepDef, String assertionMessage) {
        try {
            Assert.assertTrue(result,
                    assertionMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(assertionMessage, e);
        }
    }

    @Step("{stepDef}")
    public void assertNoNullWithStep(Object objectToCheck, String stepDef, String assertionMessage) {
        try {
            Assert.assertNotNull(objectToCheck,
                    assertionMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(assertionMessage, e);
        }
    }

    @Step("{stepDef}")
    public void manualEbsStep(String stepDef, String attachment) {
        try {
            Assert.assertTrue(true);
            Allure.addAttachment("Ebs Account Details", attachment);
            EbsManualVerificationFileWriter.writeManualVerificationStep(stepDef);
            EbsManualVerificationFileWriter.writeManualVerificationStep(attachment);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Manual verification failed", e);
        }
    }

    @Step("{stepDef}")
    public void manualEbsStep(String stepDef) {
        try {
            Assert.assertTrue(true);
            EbsManualVerificationFileWriter.writeManualVerificationStep(stepDef);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Manual verification failed", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' is disabled")
    public void verifyElementIsDisabled(String elementName, By locator, String testCaseId) {
        try {
            Assert.assertFalse(PublicAdminCommons.isWebElementEnabled(driver, locator),
                    "[" + testCaseId + "] " + elementName + " is not disabled");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is not disabled", e);
        }
    }

    @Step("[{testCaseId}] Verify '{elementName}' is enabled and editable")
    public void verifyElementIsEnabled(String elementName, By locator, String testCaseId) {
        try {
            Assert.assertTrue(PublicAdminCommons.isWebElementEnabled(driver, locator),
                    "[" + testCaseId + "] " + elementName + " is disabled");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] " + elementName + " is disabled", e);
        }
    }

    @Step("Admin/ISS Agent clicks on '{elementName}")
    public void clickOnCheckBoxBasedOnStatus(String elementName, By locator, By locatorInputTag, boolean stateToSet) {
        try {
            Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, locator, locatorInputTag, stateToSet),
                    elementName + " is not present on the page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(elementName + " is not present on the page", e);
        }
    }

    @Step("Navigate to account creation page")
    public void navigateToAccountCreationPage() {
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, LoginPage.getElement(MenuNavigationPage.customerMainButton),2);
            MenuNavigationPage.navigatesToAllCustomerTab();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Add New Customer Button", AllCustomerPage.getAddNewCustomerButton(),
                    "ISS Agent is unable to click on 'Add New Customer Button'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to account information page", e);
        }
    }

}
