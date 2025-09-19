package Tests;

import base.utils.*;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class VerifyE2EJourneyOfChangedEmployment_INT_4811 extends BaseTest {

    static final String jiraTestID = "INT-4811";
    String environment = null;
    MC2Pages_Membership membershipData;
    CustomerLogin_Public loginPage;
    CommonPage_Public commonPage;
    MyCommitteesWorkItemRegister myCommitteeWorkItem;
    ChangeOfEmploymentPage changeOfEmploymentPage;
    WebDriver yomailSession;
    YopMail yopMailPage;
    MembershipBecomeMemberPage newMembershipPage;
    MC2PortalCommonHelper_Public membershipHelper;
    BasePage basePage;
    JsonFileReader jsonFileReader;

    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        yomailSession = driver;
        environment = PublicCommon.environmentSelector();
        jsonFileReader=new JsonFileReader();
        jsonFileReader.setJiraID(jiraTestID);
        driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify E2E journey of- Changed employment /my organization has merged with/been acquired by another organization.")
    @Test(description = jiraTestID
            + ": Verify E2E journey of- Changed employment /my organization has merged with/been acquired by another organization.", groups = {""})
    public void VerifyE2EJourneyOfChangedEmployment() {
        try {
            loginPage = page.getInstance(CustomerLogin_Public.class);
            commonPage = page.getInstance(CommonPage_Public.class);
            myCommitteeWorkItem = page.getInstance(MyCommitteesWorkItemRegister.class);
            changeOfEmploymentPage = page.getInstance(ChangeOfEmploymentPage.class);
            yopMailPage = page.getInstance(YopMail.class);
            newMembershipPage = page.getInstance(MembershipBecomeMemberPage.class);
            membershipHelper = page.getInstance(MC2PortalCommonHelper_Public.class);
            basePage = page.getInstance(BasePage.class);
            membershipData = page.getInstance(MC2Pages_Membership.class);

            loginPage.loginToMemberapp(jsonFileReader.getJsonString("UserName"), jsonFileReader.getJsonString("Password"));
            myCommitteeWorkItem.navigateToMyCommitteesFromProfileDropDown();
            verifyNavigationToChangeOfEmployment();
            selectFirstRadioButton();
            navigateToYOPmailAndVerifyChanges(jsonFileReader.getJsonString("Email"),jsonFileReader.getJsonString("NewOrganizationName"));
            selectSecondRadioButton();
            navigateToYOPmailAndVerifyChanges(jsonFileReader.getJsonString("Email"),jsonFileReader.getJsonString("NewOrganizationName"));
            Thread.sleep(2000);
            PublicAdminCommons.switchToTabByIndex(driver,0);
            PublicCommon.openNewTabAndSwitch(driver);
            membershipHelper.mc2ApplicationLogin(membershipData, driver, "stage", jsonFileReader.getJsonString("CredentialsMap", "MCS2IA", "StageUser") , jsonFileReader.getJsonString("CredentialsMap", "MCS2IA", "StagePassword"));
            searchMemberInIAApplication();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify E2E journey of- Changed employment /my organization has merged with/been acquired by another organization.", e);
        }
        System.out.println("Successfully Verified E2E journey of- Changed employment /my organization has merged with/been acquired by another organization.");
    }
    @Step("Verify navigate to my committees")
    public void navigateToMyCommittees() {
        try {
            PublicCommon.waitForSec(5);
            PublicCommon.JSClick(page.getElement(loginPage.PublicSigninbtn1), driver);
            commonPage.getElement(myCommitteeWorkItem.MyCommittees).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertEquals(commonPage.getElement(myCommitteeWorkItem.MyCommitteeHeader).getText(),
                    "MyCommittees");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to navigate to my committees", e);
        }
    }
    @Step("Validate navigation to Change Of Employment")
    public void verifyNavigationToChangeOfEmployment() {
        try {
            newMembershipPage.handleOneTrustCookie();
            commonPage.getElement(changeOfEmploymentPage.ChangeOfEmployment).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertEquals(commonPage.getElement(changeOfEmploymentPage.ChangeOfEmploymentHeader).getText(), "Change Of Employment");
            commonPage.getElement(changeOfEmploymentPage.editBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to navigate Change Of Employment", e);
        }
    }
    @Step("Select First radio button")
    public void selectFirstRadioButton() {
        try {
            PublicCommon.JSClick(page.getElement(changeOfEmploymentPage.firstRadioBtn), driver);
            commonPage.getElement(changeOfEmploymentPage.continueBtn).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertEquals(commonPage.getElement(changeOfEmploymentPage.cooperativeAgreementHeader).getText(),
                    "Cooperative Agreement Representative");
            commonPage.getElement(changeOfEmploymentPage.appropriateOption).click();
            commonPage.getElement(changeOfEmploymentPage.newOrganizationName).sendKeys(jsonFileReader.getJsonString("NewOrganizationName"));
            changeOfEmploymentPage.getSelectOrganizationAddress(jsonFileReader.getJsonString("OrganizationAddress"));
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            changeOfEmploymentPage.getselectCountry(jsonFileReader.getJsonString("Country"));
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            changeOfEmploymentPage.getSelectCity(jsonFileReader.getJsonString("City"));
            changeOfEmploymentPage.getselectState(jsonFileReader.getJsonString("State"));
            changeOfEmploymentPage.getSelectZipCode(jsonFileReader.getJsonString("ZipCode"));
            commonPage.getElement(changeOfEmploymentPage.nextBtn).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            commonPage.getElement(changeOfEmploymentPage.YesBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertEquals(commonPage.getElement(changeOfEmploymentPage.ReviewYourCommittee).getText(),
                    "Review Your Committee(s)");
            PublicCommon.selectValueInDropdownbyIndex(page.getElement(changeOfEmploymentPage.selectCategories),7);
            commonPage.getElement(changeOfEmploymentPage.textFiled).sendKeys("Test");
            commonPage.getElement(changeOfEmploymentPage.nextBtn).click();
            PublicAdminCommons.scrollToElement(driver, changeOfEmploymentPage.submitBtn);
            commonPage.getElement(changeOfEmploymentPage.submitBtn).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            assertEquals(commonPage.getElement(changeOfEmploymentPage.thankYouMsg).getText(),
                    "Thank You!");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Select First radio button", e);
        }
    }
    @Step("Navigate to Yop mail and open Inbox.")
    public void navigateToYOPmailAndVerifyChanges(String email,String newOrganizationName) {
        try {
            assertTrue(yopMailPage.openInbox(email, driver));
            yomailSession.switchTo().frame(yopMailPage.mailBodyFrame);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if(PublicCommon.isWebElementDisplayed(driver,changeOfEmploymentPage.changeofEmploymentHeader)){
                assertEquals(changeOfEmploymentPage.getChangeofEmploymentHeader(),
                        "Change of Employment form submitted");
                PublicAdminCommons.scrollToElement(driver, changeOfEmploymentPage.newOrganizationNameFromMail);
                String newOrganizationName1=changeOfEmploymentPage.getnewOrganizationNameFromMail();
                assertTrue(newOrganizationName1.contains(newOrganizationName),"Both New Organization Names are not same");
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            else {
                assertEquals(changeOfEmploymentPage.getChangeCompanyNameHeader(),
                        "Request to change the Company Name (Misspelling or Change in CompanyName)");
                PublicAdminCommons.scrollToElement(driver, changeOfEmploymentPage.newOrganizationNameFromMail1);
                String newOrganizationName1=changeOfEmploymentPage.getnewOrganizationNameFromMail1();
                assertTrue(newOrganizationName1.contains(newOrganizationName),"Both New Organization Names are not same");
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            PublicAdminCommons.closeTab(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Navigate to Yop mail and open Inbox.", e);
        }
    }
    @Step("Select Second radio button")
    public void selectSecondRadioButton() {
        try {
            PublicAdminCommons.switchToTabByIndex(driver,0);
            commonPage.getElement(changeOfEmploymentPage.goToMYASTM).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            verifyNavigationToChangeOfEmployment();
            PublicCommon.JSClick(page.getElement(changeOfEmploymentPage.secondRadioBtn), driver);
            commonPage.getElement(changeOfEmploymentPage.correctedOrganizationField).clear();
            commonPage.getElement(changeOfEmploymentPage.correctedOrganizationField).sendKeys(jsonFileReader.getJsonString("NewOrganizationName"));
            commonPage.getElement(changeOfEmploymentPage.submitBtn).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            PublicCommon.isWebElementDisplayed(driver,changeOfEmploymentPage.confirmationPopUp);
            commonPage.getElement(changeOfEmploymentPage.okButton).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Select Second radio button", e);
        }
    }
    @Step("search Member in search box")
    public void searchMemberInIAApplication() {
        try {
            Thread.sleep(5000);
            WaitStatementUtils.waitForElementToBeClickable(driver, basePage.getElement(membershipData.searchBox), 5);
            basePage.getElement(membershipData.searchBox).sendKeys(jsonFileReader.getJsonString("UserName"));
            basePage.getElement(membershipData.searchButton).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            membershipData.getSelectNum(jsonFileReader.getJsonString("Account"));
            membershipData.GetAudiLogDetails();
            ReusableMethods.scrollIntoView(page.getElement(membershipData.advancedSearchButton),driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver,membershipData.checkAuditLogMessage(PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy"))));
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Exception in search member in search box", e);
        }
    }

}
