package tests;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import base.utils.RandomStringUtils;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class E2EJourneyForChangeOfEmploymentOfParticipateUser_INT_4854 extends BaseTest {
    static final String jiraTestID = "INT-4854";
    String environment = null;
    String userAccount = null;
    String userPwd = null;
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
    ManageCommitteesPage_Public manageCommitteesPage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        yomailSession = driver;
        environment = PublicCommon.environmentSelector();
        driver.get(ConfigReader.getValue("BASE_URL_MEM_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("E2E journey for Change of employment of a participate user")
    @Test(description = jiraTestID
            + ": E2E journey for Change of employment of a participate user", groups = {""})
    public void E2EJourneyForChangeOfEmploymentOfParticipateUser() {
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
            manageCommitteesPage = page.getInstance(ManageCommitteesPage_Public.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            String NewOrganizationName="AutomationOrg".concat(RandomStringUtils.getRandomString(3));
            loginPage.NewLoginPublic2(jsonFileReader.getJsonString("StageUser"),jsonFileReader.getJsonString("StagePassword"));
            myCommitteeWorkItem.NavigateToMyCommittee();
            String accountNumber=manageCommitteesPage.checkAccountNumberOnMyCommitte();
            changeOfEmploymentPage.verifyNavigationToChangeOfEmployment();
            changeOfEmploymentPage.selectFirstRadioButton(NewOrganizationName);
            changeOfEmploymentPage.navigateToYOPmailAndVerifyChanges(jsonFileReader.getJsonString("Email"),NewOrganizationName,accountNumber);
            changeOfEmploymentPage.selectSecondRadioButton(NewOrganizationName);
            changeOfEmploymentPage.navigateToYOPmailAndVerifyChanges(jsonFileReader.getJsonString("Email"),NewOrganizationName,accountNumber);
            PublicAdminCommons.switchToTabByIndex(driver,0);
            PublicCommon.openNewTabAndSwitch(driver);
            userAccount=jsonFileReader.getJsonString("CredentialsMap","MCS2IA", "StageUser");
            userPwd=jsonFileReader.getJsonString("CredentialsMap","MCS2IA", "StagePassword");
            membershipHelper.mc2ApplicationLogin(membershipData, driver, "stage", userAccount, userPwd);
            membershipData.searchMemberInIAApplication(accountNumber);
            membershipData.GetAudiLogDetails();
            PublicAdminCommons.scrollToElement(driver,membershipData.getAuditLogMessageByindex(2));
            verifyAuditLogChangeOfEmplomentMessage();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to E2E journey for Change of employment of a participate user", e);
        }
        System.out.println("Successfully E2E journey for Change of employment of a participate user");
    }
    @Step("verify audit log change of employment message")
    public void verifyAuditLogChangeOfEmplomentMessage() {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            String todayDate=PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy");
            String auditLogDate=page.getElement(membershipData.ChangeOfEmplomentAuditLogMsgDate).getText().substring(0,10);
            Assert.assertEquals(todayDate,auditLogDate,"Both the auditlog dates are not matching");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Exception in verify audit log change of employment message", e);
        }
    }
}
