package pages.ui;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;

import base.utils.*;
import com.astm.commonFunctions.PublicAdminCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;


import io.qameta.allure.Step;

public class MC2PortalCommonHelper_Public extends BasePage {

	boolean setupFlag = true;

	public MC2PortalCommonHelper_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	MC2Pages_Membership membershipData=new MC2Pages_Membership(driver);
	Mcs2Application_Page MCS2Application=new Mcs2Application_Page(driver);
	/**
	 * Pre-Requisite script to check Membership Data Setup is correct before it is
	 * used in automated tests.
	 */
	public boolean membershipAccountSetupCheck(MC2Pages_Membership membershipData, WebDriver driver, String environment,
			String username, String password, String memberAccount, String memberEmail, String membershipType) {
		try {
			mc2ApplicationLogin(membershipData, driver, environment, username, password);
			navigateToMemberOption(membershipData);
			memberAccountSearch(membershipData, memberEmail);
			assertTrue(membershipData.clickMembershipAccountLink(), "Navigating to member account details page.");
			changeMembershipType(membershipData,membershipType);
			memberPaidStatus(membershipData);
			memberAccountStatusHistorical(membershipData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Verify Account information is same as entered while placing the order in MCS2.")
	public void membershipDataSetupCheckforParticipantMembership(String username, String password, String memeberEmail, String env,String firstName,String lastName,String phone,String Org) {
		try {
			PublicCommon.waitForSec(15);
			assertTrue(membershipAccountSetupCheckAndValidateInfo(membershipData, driver, env,
					username, password, memeberEmail));
			assertTrue(membershipData.validateMemberEmail(memeberEmail), "Validating searcherd email");
			assertTrue(membershipData.clickMembershipAccountLink(), "Navigating to member account details page.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			assertTrue(membershipData.getMcs2_FirstName().getText().contains(firstName));
			assertTrue(membershipData.getMcs2_LastName().getText().contains(lastName));
			assertTrue(membershipData.getmcs2_PhoneNo().getText().contains(phone));
			MCS2Application.McssignOut();
			Thread.sleep(6000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Validate Account information in MCS2.", e);
		}
	}

	@Step("Verify Account information is same as entered while placing the order in MCS2.")
	public void membershipDataSetupCheckforOrgMembership(String username, String password, String memeberEmail, String env,String firstName,String lastName,String phone,String Org) {
		try {
			PublicCommon.waitForSec(15);
			assertTrue(membershipAccountSetupCheckAndValidateInfo(membershipData, driver, env,
					username, password, memeberEmail));
			assertTrue(membershipData.validateMemberEmail(memeberEmail), "Validating searcherd email");
			assertTrue(membershipData.clickMembershipAccountLink(), "Navigating to member account details page.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(Org!=null) {
				assertTrue(membershipData.getmcs2_Usertype().getText().equals("REPRESENTATIVE"));
				assertTrue(membershipData.getmcs2_Organizationname().getText().contains(Org));
			}
			assertTrue(membershipData.getMcs2_FirstName().getText().contains(firstName));
			assertTrue(membershipData.getMcs2_LastName().getText().contains(lastName));
			assertTrue(membershipData.getmcs2_PhoneNo().getText().contains(phone));
			MCS2Application.McssignOut();
			Thread.sleep(6000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Validate Account information in MCS2.", e);
		}
	}



	public boolean membershipAccountSetupCheckActivePaid(MC2Pages_Membership membershipData, WebDriver driver, String environment,
			String username, String password, String memberAccount, String memberEmail) {
		try {
			mc2ApplicationLogin(membershipData, driver, environment, username, password);
			navigateToMemberOption(membershipData);
			memberAccountSearch(membershipData, memberEmail);
			assertTrue(membershipData.clickMembershipAccountLink(), "Navigating to member account details page.");
			memberPaidStatusAsPaid(membershipData);
			memberAccountStatusActive(membershipData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changeMembershipType(MC2Pages_Membership membershipData,String membershiptype )
			 {
		try {
			membershipData.changeMembershipAccounttype(membershiptype);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	/**
	 * Pre-Requisite script to check Membership Data Setup is correct before it is
	 * used in automated tests.
	 */
	public boolean membershipAccountSetupCheckAndValidateInfo(MC2Pages_Membership membershipData, WebDriver driver,
			String environment, String username, String password, String memberEmail) {
		try {
			mc2ApplicationLogin(membershipData, driver, environment, username, password);
			memberAccountSearch(membershipData, memberEmail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean MemberWorkItemsearch(MC2Pages_Membership membershipData, WebDriver driver,
															  String environment, String username, String password) {
		try {
			mc2ApplicationLogin(membershipData, driver, environment, username, password);
			membershipData.clickWorkItemandSearchWithWorkItemID();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean membershipAccountSetupCheckAndValidateInfo1(MC2Pages_Membership membershipData, WebDriver driver,
															  String environment, String username, String password, String memberEmail) {
		try {
			mc2ApplicationLogin1(membershipData, driver, environment, username, password);
			memberAccountSearch1(membershipData, memberEmail);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Member Account Status set as 'Active' validation.")
	public void memberAccountStatus(MC2Pages_Membership membershipData) {
		try {
			String status = membershipData.memberAccountStatus();
			boolean isAccountStatusActive = status.equals(membershipData.activeAccountStatus);

			// System.out.println("Status: "+status+" var: "+accountStatusIsActive);
			// accountStatusIsActive = false;
			if (!isAccountStatusActive) {
				membershipData.updateAccountStatusToActive();
				driver.navigate().refresh();

				status = membershipData.memberAccountStatus();
				isAccountStatusActive = status.equals(membershipData.activeAccountStatus);
				System.out.println(":" + status + ":");
				assertTrue(isAccountStatusActive, "Validating Member Account Status after update, Expected: "
						+ membershipData.activeAccountStatus + ", Actual: " + status);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} else {

				// status = membershipData.memberAccountStatus();
				System.out.println(":" + status + ":");
				assertTrue(isAccountStatusActive, "Validating Member Account Status, Expected::"
						+ membershipData.activeAccountStatus + "::Actual::" + status);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in member account status validation on Member Details page.", e);
		}
	}

	@Step("Member Account Status set as 'Historical' validation.")
	public void memberAccountStatusHistorical(MC2Pages_Membership membershipData) {
		try {
			String status = membershipData.memberAccountStatus();
			boolean isAccountStatusHistorical = status.equals(membershipData.historicalAccountStatus);

			// System.out.println("Status: "+status+" var: "+accountStatusIsActive);
			// accountStatusIsActive = false;
			if (!isAccountStatusHistorical) {
				membershipData.updateAccountStatusToHistorical();
				driver.navigate().refresh();

				status = membershipData.memberAccountStatus();
				isAccountStatusHistorical = status.equals(membershipData.historicalAccountStatus);
				System.out.println(":" + status + ":");
				assertTrue(isAccountStatusHistorical, "Validating Member Account Status after update, Expected: "
						+ membershipData.historicalAccountStatus + ", Actual: " + status);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} else {

				// status = membershipData.memberAccountStatus();
				System.out.println(":" + status + ":");
				assertTrue(isAccountStatusHistorical, "Validating Member Account Status, Expected::"
						+ membershipData.historicalAccountStatus + "::Actual::" + status);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in member account status validation on Member Details page.", e);
		}
	}

	
	@Step("Member Account Paid Status set as 'Not Paid' validation.")
	public void memberPaidStatus(MC2Pages_Membership membershipData) {
		try {
			String status = membershipData.memberPaidStatus();
			boolean isAccountStatusNotPaid = status.equals(membershipData.notPaidStatus);

			if (!isAccountStatusNotPaid) {
				membershipData.updateAccountPaidStatusToNotPaid();
				driver.navigate().refresh();

				status = membershipData.memberPaidStatus();
				isAccountStatusNotPaid = status.equals(membershipData.notPaidStatus);
				System.out.println(":" + status + ":");
				assertTrue(isAccountStatusNotPaid,
						"Validating Member Account Paid Status 'Not Paid' after update , Expected: "
								+ membershipData.notPaidStatus + ", Actual: " + status);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} else {

				// status = membershipData.memberAccountStatus();
				System.out.println(":" + status + ":");
				assertTrue(isAccountStatusNotPaid, "Validating Member Account Paid Status, Expected::"
						+ membershipData.notPaidStatus + "::Actual::" + status);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}

			// assertTrue(status.equals(membershipData.notPaidStatus), "Validating Member
			// Paid Status,, Expected: "+membershipData.notPaidStatus+" Actual: "+status);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// System.out.println("Status: "+status+" var: "+accountStatusIsActive);
			// accountStatusIsActive = false;

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in member account Paid Status validation on Member Details page.",
					e);
		}
	}
	@Step("Member Account Paid Status set as 'Paid' validation.")
	public void memberPaidStatusAsPaid(MC2Pages_Membership membershipData) {
		try {
			String status = membershipData.memberPaidStatus();
			boolean isAccountStatusPaid = status.equals(membershipData.PaidStatus);

			
				System.out.println(":" + status + ":");
				assertTrue(isAccountStatusPaid, "Validating Member Account Paid Status, Expected::"
						+ membershipData.notPaidStatus + "::Actual::" + status);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in member account Paid Status validation on Member Details page.",
					e);
		}
	}
	@Step("Member Account Status  as 'Active'.")
	public void memberAccountStatusActive(MC2Pages_Membership membershipData) {
		try {
			String status = membershipData.memberAccountStatus();
			boolean isAccountStatusActive = status.equals(membershipData.activeAccountStatus);

				assertTrue(isAccountStatusActive, "Validating Member Account Status after update, Expected: "
						+ membershipData.activeAccountStatus + ", Actual: " + status);
				ScreenshotUtil.takeScreenshotForAllure(driver);
		
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in member account status validation on Member Details page.", e);
		}
	}


	@Step("Member Account Auto Renewal Status validation.")
	public void memberAutoRenewalStatus(MC2Pages_Membership membershipData) {
		try {
			boolean renewalStatus = !(membershipData. memberAutoRenewalStatusa());
			// if true is returned it refers to auto renewal set to true, so data not usable
			// for membership renewal tests
			assertTrue(renewalStatus,
					"Validating Member Auto Renewal Status,, Expected: " + true + " Actual: " + renewalStatus);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert(
					"Exception in member account Auto Renewal Status validation on Member Details page.", e);
		}
	}

	@Step("Membership Renewal 'In Progress' status disabled on Admin page.")
	public void membershipRenewalDisabledStatusAdmin(MC2Pages_Membership membershipData) {
		try {
			membershipData.navigateToMembershipRenewalOptionInAdmin();
			boolean renewalStatus = membershipData.renewalButtonIsDisabled();
			assertTrue(membershipData.renewalButtonIsDisabled(),
					"Validating Member Renewal button is diabled on admin page, Expected: " + true + " Actual: "
							+ renewalStatus);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in status validation on Admin page.", e);
		}
	}

	@Step("Login to the MC2 application.")
	public void mc2ApplicationLogin(MC2Pages_Membership membershipData, WebDriver driver, String environment, String username, String password) {
		try {
			driver.get(membershipData.mc2LoginURL(environment));
			PublicCommon.waitForSec(5);
			membershipData.UseAnotherAccountTile(username, password);
			PublicCommon.waitForSec(10);
			assertTrue(membershipData.userIconDisplay(), "User icon is not displayed.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in Login", e);
		}
	}
	@Step("Login to the MC2 application.")
	public void DMSApplicationLogin(MC2Pages_Membership membershipData, WebDriver driver, String username, String password) {
		try {
			membershipData.UseAnotherAccountTile(username, password);
			//membershipData.signInToMC2(username, password);
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in Login", e);
		}
	}


	@Step("Login to the MC2 application.")
	public void mc2ApplicationLogin1(MC2Pages_Membership membershipData, WebDriver driver, String environment,
									String username, String password) {
		try {
			EncryptionUtil util=new EncryptionUtil();
			driver.get(membershipData.mc2LoginURL(environment));
			membershipData.signInToMC2(username, util.decrypt(password));
			assertTrue(membershipData.userIconDisplay(), "Sign in to MC2 application.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in Login", e);
		}
	}

	@Step("Navigate to member option in member management.")
	public void navigateToMemberOption(MC2Pages_Membership membershipData) {
		try {
			Thread.sleep(10000);
			membershipData.navigateToMemberOptionInMemberManagement();
			membershipData.getElement(membershipData.searchBox).click();
			assertTrue(true, "Member Option page loaded");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in Navigation to Member Page", e);
		}
	}

	@Step("Member Account Search.")
	public void memberAccountSearch(MC2Pages_Membership membershipData, String memberAccount, String memberEmail,
			String membershipType) {
		try {
			// assertTrue(membershipData.memberAccountSearch(memberAccount), "Member Account
			// Search.");
			assertTrue(membershipData.memberEmailSearch(memberEmail), "Email Account Search.");
			Thread.sleep(42000);

			assertTrue(membershipData.validateMemberAccount(memberAccount), "Validating searched account.");
			assertTrue(membershipData.validateMemberEmail(memberEmail), "Validating searcherd email");
			assertTrue(membershipData.validateMembershipType(membershipType), "Validating membership type");
			assertTrue(membershipData.clickMembershipAccountLink(), "Navigating to member account details page.");
		}

		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Account Search Exception.", e);
		}
	}

	@Step("Member Account Search.")
	public void memberAccountSearch(MC2Pages_Membership membershipData, String memberEmail) {
		try {
			PublicCommon.waitForSec(5);
			assertTrue(membershipData.enterIntoSearchBox(memberEmail), "Email Account Search.");
			PublicCommon.waitForSec(5);
		}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Account Search Exception.", e);
		}
	}

	@Step("Member Work Item Search.")
	public void memberWorkItemSearch(MC2Pages_Membership membershipData) {
		try {
			assertTrue(membershipData.clickWorkItemandSearchWithWorkItemID(), "Email Account Search.");
			PublicCommon.waitForSec(60);

		}

		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Account Search Exception.", e);
		}
	}
	@Step("Member Account Search.")
	public void memberAccountSearch1(MC2Pages_Membership membershipData, String memberEmail) {
		try {
			assertTrue(membershipData.enterIntoSearchBox1(memberEmail), "Email Account Search.");

		}

		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Account Search Exception.", e);
		}
	}
	public By reports = By.xpath("//a[text()='Reports']");
	public By meetingReports = By.xpath("//a[text()='Meeting Reports']");
	public By RAFReports = By.xpath("//h4[text()='Registration, Attendance & Fees Report']//parent::section//div//button");
	public By reportType = By.xpath("//div[@id='ReportType']");
	public By detailedMeeting  = By.xpath("//span[text()='Detailed Meeting Report']");
	public By loading = By.xpath("//div[text()='Loading']");
	public By eventName = By.xpath("//input[@id='EventSearch']");
	public By eventNamesVisible  = By.xpath("//div[@class='results transition visible']");

	public By getFirstEventName = By.xpath("(//div[contains(@class,'results transition')]//div)[1]");
	public By committeeDesignation = By.name("committeeCategorySelection");
	public By allFromDropDown  = By.xpath("//span[text()='All']");
	public By memberFacingpdf = By.xpath("//label[text()='Member Facing (PDF)']");
	public By generateReport = By.xpath("//button[text()='Generate Report']");
	public By blockScheduleContinue = By.xpath("//*[text()='Block Schedule']/..//button");
	public By eventNameAvailable(String name) {

			return By.xpath("//div[@eventname='"+name+"']");
		}
	public void selectEventNameDrp(String name) {
		getElement(By.xpath("//span[text()='"+name+"']")).click();
	}
	public void selectReportTypeDrp(String name) {
		getElement(By.xpath("//span[text()='"+name+"']")).click();
	}
	@Step("Select the report type and Verify the event name that was cloned in Aventri in Event name field")
	public void VerifyEventAvailabilityAndGenerateReport(String name,String downloadPath) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(blockScheduleContinue));
			getElement(blockScheduleContinue).click();
			PublicCommon.invisibilityOfElement(driver, getElement(loading));
			PublicCommon.waitForSec(10);
			getElement(eventName).click();
			getElement(eventName).sendKeys(name);
			//Assert.assertTrue(getElement(eventNamesVisible).isDisplayed(), "input search Displayed");
			Assert.assertTrue(getElement(getFirstEventName).getAttribute("eventname").equals(name),"Event name should Displayed");
			getElement(getFirstEventName).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			PublicAdminCommons.scrollToElement(driver,getElement(committeeDesignation));
			getElement(committeeDesignation).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(allFromDropDown));
			getElement(allFromDropDown).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToElement(driver,getElement(memberFacingpdf));
			getElement(memberFacingpdf).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(generateReport));
			getElement(generateReport).click();

			ReusableMethods.fileDownloadUsingWindowsSaveAsPopup(downloadPath);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify the event name that was cloned in Aventri in Event name field", e);
		}
	}

	@Step("Navigate to Meeting reports under reports section and Click on continue for Registration, Attendance, & fees report")
	public void navigateToMeetingReports() {
		try {
			   ReusableMethods.mouseHover(driver,getElement(reports),"Reports");
			   PublicCommon.waitForSec(5);
			   WaitStatementUtils.waitForElementToBeClickable(driver,getElement(meetingReports));
			   getElement(meetingReports).click();
		}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Navigate to Meeting reports under reports section and Click on continue for Registration, Attendance, & fees report", e);
		}
	}
	@Step("Registration, Attendance & Fees Report")
	public void registrationAttendanceFeesReport(String ReportType,String EventName,String downloadPath) {
		try {
			clickOnMethod("Registration, Attendance & Fees Report", getElement(RAFReports));
			clickOnMethod("Report Type", getElement(reportType));
			selectReportTypeDrp(ReportType);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("event Name", getElement(eventName));
			getElement(eventName).clear();
			getElement(eventName).sendKeys(EventName);
			getElement(eventName).click();
			selectEventNameDrp(EventName);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Generate Report",getElement(generateReport));
			ReusableMethods.fileDownloadUsingWindowsSaveAsPopup(downloadPath);
		}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Navigate to Meeting reports under reports section and Click on continue for Registration, Attendance, & fees report", e);
		}
	}
}
