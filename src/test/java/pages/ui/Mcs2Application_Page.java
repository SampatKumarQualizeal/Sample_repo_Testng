package pages.ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.*;
import io.qameta.allure.Allure;

import base.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;

import io.qameta.allure.Step;


public class Mcs2Application_Page extends BasePage {

	public Mcs2Application_Page(WebDriver driver) {
		super(driver);
	}
	/*INT-5318 START*/

	public Page page=new BasePage(driver);
	Homepage homepage = page.getInstance(Homepage.class);;

	public By documentsLink=By.linkText("Documents");
	public By headerTitle=By.xpath("//div[@class='headingTitle clearfix']/h2");
	public By menu_links=By.xpath("//div[@class='menuWrapper']/ul/li/a");
	/*INT-5318 END*/
	public By accountActivationPage = By.xpath("//h2[text()='Account Activation']");
	public By closeCookie = By.xpath("//div[@id='onetrust-close-btn-container']/button[contains(@class,'onetrust-close-btn')]");
	private By spinner = By.className("ui massive text loader");
	public By mcs2Uid = By.xpath("//input[@type='email']");
	public By mcs2Next = By.xpath("//input[@type='submit']");
	public By mcs2Passsword = By.xpath("//input[@type='password']");
	public By mcs2Submit = By.xpath("//input[@type='submit']");
	public By mcs2SeachBox = By.xpath("//div[@class='ui input searchInput']/input");
	public By mcs2Header = By.xpath("//h2[text()='Members']");
	public By mcs2PageLoader = By.xpath("//div[@class='ui massive text loader']");
	public By mcs2SearchButton = By.xpath("//i[@class='search icon']");
	public By mcs2LoaderAfterSearchingForAccount = By.xpath("//div[@class='ui small text loader small-loader']");

	public By mcs2AccountAfterSearch = By.className("column--MemberDetail_AccountNumber");
	public By accountstatus = By
			.xpath("//div[@class='memberRelatedInfo']//span[text()='Account Status']/following-sibling::span");
	public By accountStatusActive = By.xpath("//div[@class='bannerMember']//span[text()='Active']");
	public By accountStatusHisotrical = By.xpath("//div[@class='bannerMember']//span[text()='Historical']");
	public By mcs2EditMemberAccountDetails = By
			.xpath("//h5[text()='Member Account Status Details']//i[@class='pencil icon']");
	public By membershipTypeEditButton = By.xpath("//h5[text()='Membership Type']//i[@class='pencil icon']");
	private By memtype = By.xpath("//h5[text()='Membership Type']");
	public By membertypeDropDown = By.xpath("//div[@name='MemberTypeId']");
	public By Organization = By.xpath("//input[@id='RepOrgName']");
	public By moucontactdropdown=By.id("MOUContactCodeId");
	public By mouContactCodeDropdown=By.xpath("//*[@id='MOUContactCodeId']//div[@name='Entitled to Discount']");
	public By reasonUpdateMembership = By.xpath("//textarea[@placeholder='Please enter reason for update']");
	public By editAccountStatusDropdown = By.xpath("//div[@name='McsStatusMasterId']");
	public By editAcountStatusText = By.xpath("//div[@name='McsStatusMasterId']");
	public By setHistoricalAccountType = By.xpath("//div[@name='McsStatusMasterId']//span[text()='Historical']");
	public By setActiveAccountType = By.xpath("//div[@name='McsStatusMasterId']//span[text()='Active']");
	public By setHistoricalReason = By.xpath("//div[@name='HistoricalReasonId']");
	public By setHistoricalReasonError = By.xpath("//div[@name='HistoricalReasonId']//span[text()='ERROR']");
	public By setPaidStatusDropDown = By.xpath("//div[@name='PaidStatus']");
	public By setPaidStatusNotPaid = By.xpath("//div[@name='PaidStatus']//span[text()='Not Paid']");
	public By paidStatus = By.xpath("//span[text()='Paid Status']//following-sibling::span");
	public By updateMemberAccountDetails = By
			.xpath("//h5[text()='Member Account Status Details']//button[@title='Update']");
	public By reasonText = By.xpath("//div[@class='field']/textarea");
	//public By signOutDropdown = By.xpath("//span[@data-testid='usernameBtn']");
	public By signOutDropdownButton = By.xpath("//div[@class='profileOptionMenu dropdown']");
	public By signOutDropdown = By.xpath("//div[@class='astm-dropdown dropdown user-menu-options-dropdown']");
	// - //div[@class='astm-dropdown dropdown user-menu-options-dropdown']
	public By signOutMCS2Div=By.xpath("//div[@class='ui dropdown']");

	public By signOutMCS2Link=By.xpath("//span[text()='Sign Out']");
	public By myAccount = By.xpath("//a[contains(@href,'account') and @class='dropdown-item'][1]");
	public By signOutLink = By.xpath("//button[text()='Sign Out']");
	public By signOut = By.xpath("//a[text()='Sign Out']");
	public By sucessNote = By.xpath("//p[text()='Record updated successfully.']");
	public By successNoteClose = By.xpath("//div[@class='top-message']/div/i");
	private By memberHeaderText = By.xpath("//h2[text()='Members']");
	public By accountNumberOnAccount = By.xpath("//span[@class='memberAccount']");
	public By membershipType = By.xpath("//h5[text()='Membership Type']/..//span[@class='labelValue']");
	public By ModelcontentMessage = By.xpath("//div[@class='content']");
	public By AddMemberToCommitteeBtn = By.xpath("(//button[@class='ui secondary button'])[1]");
	public By PersonalDetailsTab = By.xpath("//a[text()='Personal Details']");
	public By AddMemberHeader = By.xpath("//div[@class='header']");
	public By Header = By.xpath("//div[@class='header']");
	public By ConfirmPopUp = By.xpath("//div[@class = 'content']");
	public By SelectActiveRadioBtn = By.xpath("(//div[@class='ui radio checkbox'])[2]");
	public By ConfirmPopupOkBtn = By.xpath("//button[text()='Ok']");
	public By PrimaryActivity = By.xpath("//label[@for='primaryActivityOfMember']");
	public By DropdownPrimaryActivity = By.xpath("//div[@id='primaryActivityOfMember']");
	public By selectActivity = By.xpath("//div[@class='visible menu transition']/div[2]");
	public By describeProductsTextBox = By.xpath("//textarea[@id='describeProducts']");

	public By CommitteeDesignation = By.xpath("//div[@class='ui fluid multiple search selection dropdown']/i");
	public By selectCommittefromList = By.xpath("//div[@class='visible menu transition']/div[2]");
	public By ReasonForUpdateTextArea = By.xpath("//textarea[@id='UpdateReason']");
	public By SaveBtn = By.xpath("//button[@type='submit']");
	public By OkBtn = By.xpath("//button[@class='ui secondary button']");
	public By emailOnAccount = By
			.xpath("//div[@class='memberRelatedInfo']//span[text()='Email']/following-sibling::span");
	private By memberManagmentDropDown = By.xpath("//a[text()='Member Management']");
	private By orgMemberDropDown = By.xpath("//a[text()='Organizational Accounts']");
	public By saveMembershipType = By.xpath("//h5[text()='Membership Type']//button[@title='Update']");
	public By saveMembershipStatus=By.xpath("//h5[text()='Member Account Status Details']//button[@title='Update']");
	private By auditLogs = By.xpath("//a[text()='Audit Log']");
	private By autoRenewal = By.xpath("//div[@setlabeltitleprop='Auto Renewal']//input");
	private By renewalReasonTextBox = By
			.xpath("//h5[text()='ASTM General Information']//following::textarea[@type='text']");
	private By autoRenewalCheckbox = By.xpath("//input[@name='Auto Renewal']");
	private By astmGeneralInfoEdit = By.xpath("//h5[text()='ASTM General Information']//i[@class='pencil icon']");
	private By astmGeneralInfoUpdate = By.xpath("//h5[text()='ASTM General Information']//button[@title='Update']");
	public By feeGroupDropdown = By.xpath("//div[@id='FeeGroupId']");
	public By selectAnyFeeGroup = By.xpath("//div[@id='FeeGroupId']//div[3]");
	// 1426
	private By workItem = By.xpath("//a[contains(text(),'Work Item')]");
	private By WorkItemPageHeader = By.xpath("//h2[contains(text(),'Work Item Admin Tool')]");
	private By viewEditWorkItemTextField = By
			.xpath("//h4[contains(text(),'View/Edit Work Item')]/../form/div/div/div/input");
	private By viewEditFindButton = By.xpath("//button[@data-testid='viewEditFindButton']");
	private By workItemDetailsHeader = By.xpath("//h5");
	public By returnToAdminScreen = By.xpath("//button[contains(text(),'Return to Admin Screen' )]");
	public By auditLogViewButton = By.xpath("//h5[contains(text(),'Audit Log')]//following-sibling::div/button");
	public By approveAsAffiliate=By.xpath("//label[text()='Approved as Affiliate']");
	public By updateBtn=By.xpath("//button[text()='Update']");
	public By memberAccountStatusEditButton=By.xpath("//h5[text()='Member Account Status Details']/a/i");
	public By orgAccountStatusEditButton = By.xpath("//h5[contains(text(), 'Status Details')]/ a/ i");
	public By accountStatusDropdown=By.xpath("//div[@id='McsStatusMasterId']/i");
	public By accountStatusReason = By.xpath("//div[@data-testid='false']");
	public By accountStatusReasonOK = By.xpath("//button[@class='ui primary button mr10']");
	public By accountReasonDropdown=By.xpath("//div[@id='HistoricalReasonId']/i");

	public By selectActive=By.xpath("//div[@id='McsStatusMasterId']/i/following-sibling::div/div/span[text()='Active']");
	public By paidStatusDropdown=By.xpath("//div[@id='PaidStatus']/i");
	public By notPaidStatus=By.xpath("//div[@id='PaidStatus']/i/following-sibling::div/div/span[text()='Not Paid']");

	public By accountNumber = By.xpath("//strong[text()='Account Number']//parent::div//following-sibling::div");
	public By yesRadioButton = By.xpath("//label[text()='Yes']");
	public By yesButton = By.xpath("//button[text()='Yes']");
	public By Comments_YesradioButton = By.xpath("//textarea[@id='exceptionComment']");
	public By submitButton  = By.xpath("//button[text()='Submit']");
	public By reviewSubmit  = By.xpath("//button[text()='Review Again']//following::button");

	public By myCollaborationLink = By.xpath("//button[text()='MyCollaboration Areas']");
	public By myComitiesButton = By.xpath("//a[text()='MyCommittees']");
	public By firstAccount_AC = By.xpath("(//div[@class='card-body']//a[@class='astm-link twoLiner'])[1]");
	public By editCollaborationArea = By.xpath("//a[text()='Edit Collaboration Area']");
	public By CollaborationIdsCount = By.xpath("//div[@class='card-body']//ul//a[@class='astm-link twoLiner' and contains(text(),'AC')]");
	public By spin1 = By.xpath("//div[@class='astm-spinner spinner-border']");
	public By scheduleMeeting = By.xpath("//a[text()='Schedule Online Meeting']");
	public By spin2 = By.xpath("//div[@class='spinner-border']");

	public By clearForm = By.xpath("//button[text()='Clear Form']");
	public By previousMeetingRadio = By.xpath("//input[@id='PrepopulateMeeting']");
	public By chooseMeeting = By.xpath("//button[text()='Choose Meeting']");
	public By firstMeeting = By.xpath("(//span[contains(text(),'Meeting to')])[1]");
	public By done = By.xpath("//button[text()='Done']");
	public By continueButton = By.xpath("//button[text()='Continue']");

	public By meetingStartDateCalender = By.xpath("//input[@id='MeetingStartDate']");
	public By TodayDatePick = By.xpath("(//div[@class='react-datepicker__week']//div[@aria-disabled='false'])[1]");
	public By scheduleMeetingBtn = By.xpath("//button[text()='Schedule Meeting']");
	public By startTime = By.xpath("//select[@id='StartHours']");
	public By startMin = By.xpath("//select[@id='StartMintues']");
	public By durationHour = By.xpath("//select[@id='EstimatedDurationHours']");
	public By durationMinute = By.xpath("//select[@id='EstimatedDurationMinutes']");
	public By amRadioButton = By.xpath("//input[@id='am_TimeFormat']");

	public By successMsg = By.xpath("//div[@data-testid='confirmationMsg']//p");
	public By launchAdminCollabArea = By.xpath("//button[text()='MyCollaboration Areas']//ancestor::h2//parent::div//following-sibling::div//a[text()='Launch Admin Collaboration Area']");
	public By committeeGroupRadioBtn = By.xpath("//input[@value='Committee Group']");
	public By selectCommittee = By.xpath("//div[@class='form-group']//select[@class='form-control']");
	public By uploadDrafts_Yes = By.xpath("//input[@name='uploadAllCan' and @value='Yes']");
	public By uploadDrafts_True = By.xpath("//input[@name='UploadDrafts' and @value='true']");
	public By uploadSupport_Yes  = By.xpath("//input[@name='uploadAllSupportCan' and @value='Yes']");
	public By uploadSupport_True = By.xpath("//input[@name='UploadSupport' and @value='true']");

	public By initialDraft = By.xpath("//input[@name='isUploadNow' and @value='Yes']");
	public By initialDraft_True = By.xpath("//input[@name='UploadinitialDraft' and @value='true']");
	public By createCollaborationArea = By.xpath("//button[text()='Collaboration Area']");
	public By CreateCollaborationArea = By.xpath("//button[text()='Create Collaboration Area']");
	public By collaborationAreaTitle = By.xpath("//input[@name='groupName']");
	public By collaborationAdministrator = By.xpath("//select[@title='Select Collaboration Area Administrator']");
	public By collaborationAreaNo = By.xpath("//div[@class='group-switcher-wrapper']//following-sibling::div[contains(@class,'title')]");
	public By workItemCollaboration = By.xpath("//a[text()='Create Work Item Collaboration']");
	public By select = By.xpath("//div[text()='Select']");
	public By createdCollabAreaPage = By.xpath("//span[text()='Collaboration Area']");
	public By firstWorkItemSelection = By.xpath("(//li[@class='list-group-item']//div[contains(@class,'astm-custom-radio')]//input)[1]");
    public By nonMemberEmailId = By.xpath("//textarea[@id='AddNonMember']");
	public By textBox_AccountNumber = By.xpath("//input[@id='manualOrgAccountNumber']");
	public By historical_errorMsg = By.xpath("//p[text()='Please enter the active organization account number.']");
	public By inCorrectAccountN0_errorMsg = By.xpath("//p[text()='The account number does not exist in the system. You can add the Organization details manually.']");
	public By currentAccountNo_errorMsg = By.xpath("//p[text()='Please choose a different organization as the member is already associated with the entered organization account number']");
	public By CorrectAccountNo = By.xpath("//label[text()='Organization Name']");
	public By SelectDropdown = By.xpath("//div[@class='ui compact selection dropdown']");
	public By SelectMember = By.xpath("//span[text()='Members']");

	public By membersDropdown = By.xpath("//div[@class='ui compact selection dropdown']");
	public By committees = By.xpath("//span[text()='Committees']");
	public By searchBar = By.xpath("//input[@title='Search Committee by Designation, Title']");
	public By searchIcon = By.xpath("//button[@class='ui button primary']");
	public String committeeNumber = "// a[@class='column--CommitteeDetail_CommitteeDesignation' and text() = '%s']";
	public By threeDots = By.xpath("//i[@class='ellipsis vertical icon txtRight pointer']");
	public By reactivate = By.xpath("//button[text()='Reactivate Committee']");
	public By reactivateCommitteeWithMembers_radiobtn = By.xpath("//label[text()='Reactivate Committee with members']");
	public By reasonForUpdate =  By.xpath("//textarea[@id='reasonForUpdate']");
	public By reactivateButton = By.xpath("//button[text()='Reactivate']");
	public By reactivateSuccessfull = By.xpath("//p[text()='Committee reactivated successfully.']");
	public By committeeStatus = By.xpath("(//label[text()='Status']/following-sibling::span)[1]");


		public By workItemSelection(int i) {
		String xp = "(//li[@class='list-group-item']//div[contains(@class,'astm-custom-radio')]//input)["+i+"]";
		return By.xpath(xp);
	}
	public By collaborationExactId(int i) {
		String xp = "(//div[@class='card-body']//ul//a[@class='astm-link twoLiner' and contains(text(),'AC')])["+i+"]";
		return By.xpath(xp);
	}
   public String collaborationId = null;
	public By setAccountStatus(String status) {
		String xp = "//div[@id='McsStatusMasterId']/i/following-sibling::div/div/span[text()='Active']".replace("Active",status);
		return By.xpath(xp);

	}
	public By getSpinnerIcon() {
		return spinner;
	}
	public By setPaidStatus(String status) {
		String xp = "//div[@id='PaidStatus']/i/following-sibling::div/div/span[text()='Not Paid']".replace("Not Paid",status);
		return By.xpath(xp);

	}

	public By setReason(String reason) {

		String xp = "//div[@id='HistoricalReasonId']/i/following-sibling::div/div/span[text()='BUDGET']".replace("BUDGET",reason);
		return By.xpath(xp);

	}

	public By memberShipTypeLocator(String memberType) {
		String xp = "//div[@name='MemberTypeId']//span[text()='" + memberType.toUpperCase() + "']";
		return By.xpath(xp);

	}

	@Step("Enter value in View/Edit Work item and click on find and Verify")
	public void enterValueInEditWorkItemClickFindAndVerify(String value) {
		try {
			verifyVisibility("View Edit WorkItem TextField", viewEditWorkItemTextField,
					"Unable to find View/editWork Item textField");
			enterText("View/Edit Work Item", viewEditWorkItemTextField, value,
					"Failed to enter value in View/Edit Work Item");
			verifyVisibility("View Edit WorkItem Find Button", viewEditFindButton,
					"Unable  to find View Edit WorkItem Find Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("View Edit WorkItem Find Button", viewEditFindButton,
					"Unable to click View Edit WorkItem Find Button");
			waitForPageLoading();
			verifyVisibility("WorkItemDetails BreadCrumb", workItem, "Failed to go to work item details page");
			verifyVisibility("WorkItemDetails Header", workItemDetailsHeader, "Failed to find WorkItemDetails Header");
			// String actualText=driver.findElement(workItemDetailsHeader).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			validateText("Work Item header value", getElement(workItemDetailsHeader).getText().split(" ")[2], value,
					"Header  does not matches");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to move to WorkItem Admin page", e);

		}
	}

	@Step("Click on return on Admin and Verify Audit log")
	public void clickOnReturnClickOnAuditLog(String value) {
		try {
			clickONMethod("Return to Admin Button", returnToAdminScreen, "Failed to return to admin screen");
			waitForPageLoading();
			clickONMethod("Admit Log view Button", auditLogViewButton, "Failed to click on audit");
			waitForPageLoading();
			assertTrue(driver
					.findElement(
							By.xpath("//a[text()='" + value + "']//..//following-sibling::td//strong[text()='Added']"))
					.isDisplayed(), "Does not find work Item no.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to Click on return on Admin and Verify Audit log", e);

		}
	}

	@Step("Click On WorkItem and move Work Item admin page  ")
	public void clickOnWorkItemAndMoveToPage() {
		try {
			waitForPageLoading();
			clickONMethod("Work Item", workItem, "Failed To click on workItem");
			verifyVisibility("Work Item Page Header", WorkItemPageHeader, "Failed to move to WorkItem Admin page");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to move to WorkItem Admin page", e);

		}
	}

	public void waitForPageLoading() {
		try {
			wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2PageLoader)));
		} catch (Exception e) {
			e.printStackTrace();
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

	@Step("Checking for data setup")
	public boolean dataSetupMCS2Applicaiton(String email, String memberType) {
		try {
			assertTrue(loginInMCS2());
			/*
			 * try { WaitStatementUtils.waitForElementToBeClickable(driver,
			 * getElement(mcs2SearchButton));
			 * ScreenshotUtil.takeScreenshotForAllure(driver); driver.navigate().back(); }
			 * catch (Exception e) { e.printStackTrace();
			 * PublicCommon.reportFailAssert("Failed to view element Search Button", e); }
			 */
			enterText("Account Search Box", mcs2SeachBox, email, "Failed to enter account Number");

			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Seached Account", mcs2AccountAfterSearch, "Failed to click on account which is searched");
			wait.until(ExpectedConditions.visibilityOf(getElement(mcs2EditMemberAccountDetails)));
			changeMembershipType(memberType);
			if (getElement(accountstatus).getText().equalsIgnoreCase("Active")) {
				setAccountTypeHistorical();
				signOut();
			} else if (getElement(accountstatus).getText().equalsIgnoreCase("Historical")) {
				signOut();
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to mcs2 application", e);
			return false;
		}
		return true;
	}

	public static boolean isWebElementPresentOnPage(WebDriver driver, By locator) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement elm = driver.findElement(locator);
			return elm.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Enter {elementName} :'{keys}' in TextBox.")
	public void enterText(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clearTxtFieldsendKeys(driver, locator, keys), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Enter data in Text box", e);
		}
	}

	@Step("Click on {elementName}")
	public void clickONMethod(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator, assertionMessage));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	@Step("Verify '{elementName}' is present on page")
	public void verifyElementIsPresentOnPage(String elementName, By locator) {
		try {
			Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, locator),
					"'" + elementName + "' was not present on page.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to validate presence of element", e);
		}
	}

	@Step("Login In mcs2")
	public boolean loginInMCS2() {
		try {
			HashMap<String, String> credd = ExcelDataConfig.getMapData(ConfigReader.getValue("ProductMatrixSheet"),
					"MCS2Application");
			System.out.println(credd);
			driver.get(credd.get("URL"));
			enterText("User ID on mcs2 login page", mcs2Uid, credd.get("StageUserId"), "Failed to enter user ID");
			clickONMethod("Next button after entering userId", mcs2Next, "Failed to click next after entering User ID");
			wait.until(ExpectedConditions.elementToBeClickable(mcs2Submit));
			enterText("Password on mcs2 login page", mcs2Passsword, credd.get("Password"), "Failed to enter password");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("Next button after entering password", mcs2Submit,
					"Failed to click next after entering password");
			if (verifyLoginSuccess() == true) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (IOException e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to validate login in MCS2 application", e);
			return false;
		}
		return true;
	}

	@Step("Verifying the: {successText}")
	public void validateText(String successText, String actualText, String expectedText, String assertionMessage) {
		try {
			String validation = successText;
			boolean result = IntegrationCommon.verifyElementTextOnPage(validation, actualText, expectedText);
			assertTrue(result, assertionMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Text", ex);
		}
	}

	@Step("Verify Login is success")
	public boolean verifyLoginSuccess() {
		try {
			/*
			 * try {
			 * wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2PageLoader))); }
			 * catch (Exception e) { e.printStackTrace(); }
			 */
			verifyElementIsPresentOnPage("Member header", memberHeaderText);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to validate presence of element", e);
			return false;
		}
		return true;

	}
	@Step("SignOut from Application")
	public void signOut_userProfile() {
		try {
			try {
				PublicCommon.waitForSec(10);
				WaitStatementUtils.explicitWait(driver,getElement(signOut));
				clickONMethod("SignOut Dropdown", signOut, "Failed to click on signOut dropdown");
				PublicCommon.waitForSec(10);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to SignOut", e);
		}
	}
	@Step("SignOut from  MCS IA Application")
	public void signOut() {
		try {
			try {
				PublicCommon.waitForSec(10);
				if(PublicAdminCommons.isWebElementDisplayed(driver, signOutDropdown)) {
					clickONMethod("SignOut Dropdown", signOutDropdown, "Failed to click on signOut dropdown");
				}
				if(PublicAdminCommons.isWebElementDisplayed(driver, signOutDropdownButton)) {
					clickONMethod("SignOut Dropdown", signOutDropdownButton, "Failed to click on signOut dropdown");
				}
				clickONMethod("MyAccount Link", myAccount, "Failed to click on MyAccount Link");
				PublicCommon.waitForSec(10);
				PublicAdminCommons.scrollToElement(driver, signOut);
				clickONMethod("SignOut Link", signOut, "Failed to click on Signout Link");
				PublicCommon.waitForSec(10);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to SignOut", e);
		}
	}

	@Step("SignOut from Application")
	public void McssignOut() {
		try {
			PublicCommon.waitForSec(5);
			clickONMethod("SignOut Dropdown", signOutMCS2Div, "Failed to click on signOut dropdown");
			clickONMethod("SignOut Link", signOutMCS2Link, "Failed to click on Signout Link");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to SignOut", e);
		}
	}

	public boolean searchAccount(String email, String memType) {
		try {
			assertTrue(loginInMCS2());
			if (memType.equalsIgnoreCase("Organizational")) {
				ReusableMethods.mouseHover(driver, getElement(memberManagmentDropDown), "Member Management Dropdown");
				ReusableMethods.mouseHoverAndClick(driver, getElement(orgMemberDropDown), "Organizational Accounts");
			}
			wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2PageLoader)));
			enterText("Account Search Box", mcs2SeachBox, email, "Failed to enter account Number");
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Searched Account", mcs2AccountAfterSearch, "Failed to click on account which is searched");
			wait.until(ExpectedConditions.visibilityOf(getElement(accountNumberOnAccount)));
			verifyElementIsPresentOnPage("Account Number on account page", accountNumberOnAccount);
			validateText("Email of account matches", getElement(emailOnAccount).getText().trim(), email,
					"Failed to match email");
			validateText("Membership Type matches", getElement(membershipType).getText().trim(), memType,
					"Failed to match Membership Type");
			validateText("Account type is Active", getElement(accountstatus).getText().trim(), "Active",
					"Failed to verify account tpe as Active");
			validateText("Validating paid status as Paid", getElement(paidStatus).getText().trim(), "Paid",
					"Failed to valdiate Paid status as Paid");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("Audit Logs", auditLogs, "Clicked on Audit Logs");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search for the account", e);
			return false;
		}
		return true;
	}

	public boolean searchemail(String email) {
		try {

			wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2PageLoader)));
			enterText("Account Search Box", mcs2SeachBox, email, "Failed to enter account Number");
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Searched Account", mcs2AccountAfterSearch, "Failed to click on account which is searched");
			wait.until(ExpectedConditions.visibilityOf(getElement(accountNumberOnAccount)));
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search for the account", e);
			return false;
		}
		return true;
	}

	@Step("PreCondition- setUp ema")
	public void abc(String email ){
		searchemail(email);


	}
	@Step("Change membership Type")
	public void changeMembershipType(String memberType) {
		try {
			if (!getElement(membershipType).getText().equalsIgnoreCase(memberType)) {
				if (getElement(accountstatus).getText().equalsIgnoreCase("Active")) {
					ScreenshotUtil.takeScreenshotForAllure(driver);
				} else if (getElement(accountstatus).getText().equalsIgnoreCase("Historical")) {
					setAccountTypeActive();
				}
				setMembershiptype(memberType);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Step("Auto renewal check box Checked()")
	public boolean renewalDataSetup() {
		try {
			WaitStatementUtils.explicitWait(driver,getElement(astmGeneralInfoEdit));
			clickONMethod("Edit ASTM general information", astmGeneralInfoEdit,
					"failed to click on ASTM general information");
			clickONMethod("Auto renewal checkbox", autoRenewal, "Failed to enable click on Auto renewal");
			enterText("Renewal Reason", renewalReasonTextBox, "test", "Failed to enter text");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("Update ASTM general Information", astmGeneralInfoUpdate,
					"Failed to update general information");
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set Account type as Active", e);
			return false;
		}
		return true;
	}

	@Step("Auto renewal check box UnChecked()")
	public boolean unCheckAutorenewalCheckBox() {
		try {
			WaitStatementUtils.explicitWait(driver,getElement(astmGeneralInfoEdit));
			clickONMethod("Edit ASTM general information", astmGeneralInfoEdit,
					"failed to click on ASTM general information");
			clickONMethod("Auto renewal checkbox", autoRenewal, "Failed to enable click on Auto renewal");
			//enterText("Renewal Reason", renewalReasonTextBox, "test", "Failed to enter text");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("Update ASTM general Information", astmGeneralInfoUpdate,
					"Failed to update general information");
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set Account type as Active", e);
			return false;
		}
		return true;
	}


	public void setAccountTypeActive() {
		try {
			ReusableMethods.scrollIntoView(getElement(mcs2EditMemberAccountDetails), driver);
			Actions action = new Actions(driver);
			action.moveToElement(getElement(mcs2EditMemberAccountDetails)).click().build().perform();
			clickONMethod("Account Status Dropdown", editAccountStatusDropdown,
					"Failed to click on account status dropdown");
			clickONMethod("Account type as Active", setActiveAccountType, "Failed to select Active");
			enterText("Reason in detail text box", reasonText, "Test Demo", "Failed to enter text in reason text box");
			System.out.println(getElement(editAcountStatusText).getText());
			clickONMethod("Update button", updateMemberAccountDetails, "Failed to click on update button");
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
			clickONMethod("Close button success note", successNoteClose, "Failed to click on success Note");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set Account type as Active", e);
		}
	}
	public void setAccountTypeInActive() {
		try {
			ReusableMethods.scrollIntoView(getElement(mcs2EditMemberAccountDetails), driver);
			Actions action = new Actions(driver);
			action.moveToElement(getElement(mcs2EditMemberAccountDetails)).click().build().perform();
			clickONMethod("Account Status Dropdown", editAccountStatusDropdown,
					"Failed to click on account status dropdown");
			clickONMethod("Account type as InActive", setActiveAccountType, "Failed to select Active");
			enterText("Reason in detail text box", reasonText, "Test Demo", "Failed to enter text in reason text box");
			System.out.println(getElement(editAcountStatusText).getText());
			clickONMethod("Update button", updateMemberAccountDetails, "Failed to click on update button");
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
			clickONMethod("Close button success note", successNoteClose, "Failed to click on success Note");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set Account type as Active", e);
		}
	}

	public void setAccountTypeHistorical() {
		try {
			PublicCommon.JSClick(getElement(mcs2EditMemberAccountDetails), driver);
			clickONMethod("Account Status Dropdown", editAccountStatusDropdown,
					"Failed to click on account status dropdown");
			clickONMethod("Account type as historical", setHistoricalAccountType, "Failed to select historical");
			clickONMethod("Historical Reason", setHistoricalReason, "Failed to click on reason dropdpwn");
			clickONMethod("Reason as Error", setHistoricalReasonError, "Failed to select on reason as error");
			clickONMethod("Paid status", setPaidStatusDropDown, "Failed to click on paid status dropdown");
			clickONMethod("Not Paid", setPaidStatusNotPaid, "Failed to select Not paid status");
			enterText("Reason in detail text box", reasonText, "Test Demo", "Failed to enter text in reason text box");
			System.out.println(getElement(editAcountStatusText).getText());
			clickONMethod("Update button", updateMemberAccountDetails, "Failed to click on update button");
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
			clickONMethod("Close button success note", successNoteClose, "Failed to click on success Note");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set Account type as Hisotrical", e);
		}
	}

	public void setMembershiptype(String memberType) {
		try {
			if (!getElement(membershipType).getText().equalsIgnoreCase(memberType)) {
				ReusableMethods.scrollIntoView(getElement(memtype), driver);
				PublicCommon.JSClick(getElement(membershipTypeEditButton), driver);
				clickONMethod("Select membership type",membertypeDropDown , "Failed to click on memnership type dropdown");
				clickONMethod("Membership Type", memberShipTypeLocator(memberType), "Failed to click on desired memberShip type from List");
				if(IntegrationCommon.isWebElementDisplayed(driver,approveAsAffiliate))
				{
					clickONMethod("Approve as Affilitae ",approveAsAffiliate , "Failed to click on approve as affiliate");
					clickONMethod("Update Button",updateBtn,"Failed to click on update button");
				}

				if(memberType.equalsIgnoreCase("MOU MEMBER")) {
					clickONMethod("MoU contact Drop Down", moucontactdropdown, "Unable to click on MOU contact dropdown");
					clickONMethod("Select MOU Cobtact Code",mouContactCodeDropdown , "Failed to click on MOU contact code dropdown");
				}

				enterText("Reason for Update",reasonUpdateMembership,"testing", "Failed to enter text in reason");
				clickONMethod("Save Membership type Button", saveMembershipType, "Failed to click on memberhsip Type Button");
				wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
				clickONMethod("Close button success note", successNoteClose, "Failed to click on success Note");
			}

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required Membership type", e);
		}
	}
	//Method to activate historical member to active
	public By enterOrgName = By.xpath("//input[@id='Organization']");
	public By listOfOrgAccounts = By.xpath("//div[@class='results transition visible']/div/div");
	public void updateMemberFromHistoricalToActive(String accountStatus, String paidStatus) {
		try {
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(memberAccountStatusEditButton), driver);
			clickONMethod("Member AccountStatus Edit Button", memberAccountStatusEditButton, "Failed to click on memberAccountStatusEditButton");
			clickONMethod("Account Status Dropdown", accountStatusDropdown, "Failed to click on Account Status Dropdown");
			clickONMethod("Account status", setAccountStatus(accountStatus), "Unable to click on " + accountStatus);
			List<WebElement> elements1 = driver.findElements(yesButton);
			if (!elements1.isEmpty()) {
				clickonmethod("Pop Up", yesButton, "Unable to click yes on pop-up");
				PublicCommon.waitForSec(3);
				enterText("Org name in popup", enterOrgName, "RegOrgCompany", "Failed to enter text");
				PublicCommon.waitForSec(10);
				// Get list of organization accounts from the list
				List<WebElement> elements = driver.findElements(listOfOrgAccounts);
				PublicCommon.waitForSec(5);
				// Randomly select an element from the list and assign it
				Random rand = new Random();
				WebElement randomElement = elements.get(rand.nextInt(elements.size()));
				System.out.println("Selected Element: " + randomElement.getText());
				randomElement.click();
				clickonmethod("Assign button", assignBtnXpath, "Failed to click on assign button on pop-up");
				PublicCommon.waitForSec(10);
				enterText("Reason for Update", reasonUpdateMembership, "testing", "Failed to enter text in reason");
				clickONMethod("Save Membership type Button", saveMembershipStatus, "Failed to click on save membership status Button");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.waitForSec(5);
				ReusableMethods.scrollIntoView(getElement(memberAccountStatusEditButton), driver);
				clickONMethod("Member AccountStatus Edit Button", memberAccountStatusEditButton, "Failed to click on memberAccountStatusEditButton");
				clickONMethod("Paid Status Dropdown", paidStatusDropdown, "Unable to click on paid Status Dropdown");
				clickONMethod("Paid Status", setPaidStatus(paidStatus), "Unable to click on " + paidStatus);
				PublicCommon.waitForSec(5);
				enterText("Reason for Update", reasonUpdateMembership, "testing", "Failed to enter text in reason");
				clickONMethod("Save Membership type Button", saveMembershipStatus, "Failed to click on save membership status Button");
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} else {
				// If the popup is not displayed, just update the status
				PublicCommon.waitForSec(5);
				enterText("Reason for Update", reasonUpdateMembership, "testing", "Failed to enter text in reason");
				clickONMethod("Save Membership type Button", saveMembershipStatus, "Failed to click on save membership status Button");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.waitForSec(5);
				ReusableMethods.scrollIntoView(getElement(memberAccountStatusEditButton), driver);
				clickONMethod("Member AccountStatus Edit Button", memberAccountStatusEditButton, "Failed to click on memberAccountStatusEditButton");
				clickONMethod("Paid Status Dropdown", paidStatusDropdown, "Unable to click on paid Status Dropdown");
				clickONMethod("Paid Status", setPaidStatus(paidStatus), "Unable to click on " + paidStatus);
				PublicCommon.waitForSec(5);
				enterText("Reason for Update", reasonUpdateMembership, "testing", "Failed to enter text in reason");
				clickONMethod("Save Membership type Button", saveMembershipStatus, "Failed to click on save membership status Button");
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required Membership status", e);
		}
	}


	public By selectABtnInConfirmationPopUp = By.xpath("//label[contains(text(), 'Update account status of Organization as well as')]");
	public void updateOrganizationFromHistoricalToActive(String accountStatus) {
		//this method is only for historical organizations accounts which has  representative
		try {
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(orgAccountStatusEditButton), driver);
			clickONMethod("Member AccountStatus Edit Button", orgAccountStatusEditButton, "Failed to click on orgAccountStatusEditButton");
			clickONMethod("Account Status Dropdown", accountStatusDropdown, "Failed to click on Account Status Dropdown");
			clickONMethod("Account status", setAccountStatus(accountStatus), "Unable to click on " + accountStatus);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectABtnInConfirmationPopUp),20);
			clickonmethod("Radio button in confirmation popup",selectABtnInConfirmationPopUp,"Failed to select radio button");
			clickonmethod("Ok button",accountStatusReasonOK,"Failed to click on ok button");
			PublicCommon.waitForSec(5);
			enterText("Reason for Update", reasonUpdateMembership, "testing", "Failed to enter text in reason");
			clickONMethod("Save Membership type Button", saveMembershipStatus, "Failed to click on save membership status Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);

		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required organization status", e);
		}

	}


	public void setAccountStatusMCS2(String accountStatus,String paidStatus, String accountReason) {
		try
			{
				PublicCommon.waitForSec(10);
				ReusableMethods.scrollIntoView(getElement(memberAccountStatusEditButton),driver);
				clickONMethod("Member AccountStatus Edit Button",memberAccountStatusEditButton,"Failed to click on memberAccountStatusEditButton");
				clickONMethod( "Account Status Dropdown", accountStatusDropdown,"Failed to click on  account Status Dropdown");
				clickONMethod("Account status",setAccountStatus(accountStatus),"Unable to click on "+accountStatus+"");

				//Select "Let account status of Croplife America remain Active"
				if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(accountStatusReason),20)){
					WaitStatementUtils.waitForElementToBeClickable(driver, getElement(accountStatusReason));
					PublicAdminCommons.scrollToElement(driver, getElement(accountStatusReason));
					clickONMethod( "Account Reason Status Radio Button", accountStatusReason,"Failed to click on  Account Reason Status Radio Button");
					ScreenshotUtil.takeScreenshotForAllure(driver);
					clickONMethod( "Account Reason Status Radio Button OK", accountStatusReasonOK,"Failed to click on  Account Reason Status Radio Button OK");
				}

				//setReason accountReasonDropdown
				if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(accountReasonDropdown),20)){
					clickONMethod( "Reason Status Dropdown", accountReasonDropdown,"Failed to click on  Reason Status Dropdown");
					clickONMethod("Reason status",setReason(accountReason),"Unable to click on "+accountReason+"");
					ScreenshotUtil.takeScreenshotForAllure(driver);
				}

				clickONMethod("Paid Status Dropdown",paidStatusDropdown,"Unable to click on paid Status Dropdown");
				clickONMethod("Paid Status",setPaidStatus(paidStatus),"Unable to click "+paidStatus+"");
				enterText("Reason for Update",reasonUpdateMembership,"testing", "Failed to enter text in reason");
				clickONMethod("Save Membership type Button", saveMembershipStatus, "Failed to click on save memberhsip status Button");
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}

		 catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required Membership status", e);
		}
	}

	@Step("Checking for data setup")
	public boolean changeMembershipType(String email, String memberType) {
		try {
			enterText("Account Search Box", mcs2SeachBox, email, "Failed to enter account Number");

			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			PublicCommon.waitForSec(3);
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();

			}
			if(!PublicCommon.isWebElementDisplayed(driver, mcs2AccountAfterSearch))
			{
				PublicCommon.waitForSec(30);
				clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			}
			if(!PublicCommon.isWebElementDisplayed(driver, mcs2AccountAfterSearch)) {
				PublicCommon.waitForSec(20);
				clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			}
			clickONMethod("Seached Account", mcs2AccountAfterSearch, "Failed to click on account which is searched");
			wait.until(ExpectedConditions.visibilityOf(getElement(mcs2EditMemberAccountDetails)));
			setMembershiptype(memberType);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to mcs2 application", e);
			return false;
		}
		return true;
	}

	@Step("Checking for data setup")
	public boolean changeAccountStatusFromMCS2(String email, String accountStatus,String paidStatus, String accountReason) {
		// Select member from dropdown
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(SelectDropdown));
		PublicAdminCommons.scrollToElement(driver, getElement(SelectDropdown));
		clickONMethod("Search button", SelectDropdown, "Failed to click on dropdown button");
		clickONMethod("Search button", SelectMember, "Failed to select on member");
		try {
			enterText("Account Search Box", mcs2SeachBox, email, "Failed to enter account Number");

			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();

			}
			if(!PublicCommon.isWebElementDisplayed(driver, mcs2AccountAfterSearch))
			{
				PublicCommon.waitForSec(30);
				clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			}
			if(!PublicCommon.isWebElementDisplayed(driver, mcs2AccountAfterSearch)) {
				PublicCommon.waitForSec(20);
				clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			}
			clickONMethod("Seached Account", mcs2AccountAfterSearch, "Failed to click on account which is searched");
			wait.until(ExpectedConditions.visibilityOf(getElement(mcs2EditMemberAccountDetails)));
			// Set Account Status and Paid Status
			setAccountStatusMCS2(accountStatus,paidStatus,accountReason);
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to mcs2 application", e);
			return false;
		}
		return true;
	}

	@Step("Verify account type is {memberType} in MCS2")
	public void verifyMembershipType(String email, String memberType) {
		try {
			enterText("Account Search Box", mcs2SeachBox, email, "Failed to enter account Number");

			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Seached Account", mcs2AccountAfterSearch, "Failed to click on account which is searched");
			wait.until(ExpectedConditions.visibilityOf(getElement(mcs2EditMemberAccountDetails)));
			Assert.assertTrue(getElement(membershipType).getText().equalsIgnoreCase(memberType));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to mcs2 application", e);
		}

	}

	@Step("Checking for data setup")
	public boolean changeMembershipStatus(String email, String memberStatus) {
		try {
			enterText("Account Search Box", mcs2SeachBox, email, "Failed to enter account Number");

			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			try {
				wait.until(ExpectedConditions.invisibilityOf(getElement(mcs2LoaderAfterSearchingForAccount)));
			} catch (Exception e) {
				e.printStackTrace();

			}
			if(!PublicCommon.isWebElementDisplayed(driver, mcs2AccountAfterSearch))
			{
				PublicCommon.waitForSec(30);
				clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			}
			if(!PublicCommon.isWebElementDisplayed(driver, mcs2AccountAfterSearch)) {
				PublicCommon.waitForSec(20);
				clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			}
			clickONMethod("Seached Account", mcs2AccountAfterSearch, "Failed to click on account which is searched");
			wait.until(ExpectedConditions.visibilityOf(getElement(mcs2EditMemberAccountDetails)));
			if(memberStatus.equalsIgnoreCase("Historical")){
				setAccountTypeHistorical();
			}
			else {
				setAccountTypeActive();
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login to mcs2 application", e);
			return false;
		}
		return true;
	}

	@Step("Set Membership type to Informational")
	public void setMembershiptypeToInformational(String memberType) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(PersonalDetailsTab),5);
			getElement(PersonalDetailsTab).click();
			if (!getElement(membershipType).getText().equalsIgnoreCase(memberType)) {
				ReusableMethods.scrollIntoView(getElement(memtype), driver);
				PublicCommon.JSClick(getElement(membershipTypeEditButton), driver);
				clickONMethod("Select membership type",membertypeDropDown , "Failed to click on membership type dropdown");
				clickONMethod("Membership Type", memberShipTypeLocator(memberType), "Failed to click on desired memberShip type from List");
				PublicCommon.waitForSec(5);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				enterText("Reason for Update",reasonUpdateMembership,"testing", "Failed to enter text in reason");
				PublicAdminCommons.scrollToElement(driver,getElement(saveMembershipType));
				//clickONMethod("Save Membership type Button", saveMembershipType, "Failed to click on membership Type Button");
				PublicCommon.JSClick(getElement(saveMembershipType), driver);
				PublicCommon.waitForSec(5);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required Membership type", e);
		}
	}

	@Step("Remove representative")
	public void RemoveREP(){
			try {
				getElement(SelectActiveRadioBtn).click();
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(ConfirmPopupOkBtn).click();
			} catch (Exception e) {
				e.printStackTrace();
				PublicCommon.reportFailAssert("Failed to remove Representative", e);
			}
	}

	public void setMembershiptypeToParticipating(String memberType) {
		try {
			if (!getElement(membershipType).getText().equalsIgnoreCase(memberType)) {
				ReusableMethods.scrollIntoView(getElement(memtype), driver);
				PublicCommon.JSClick(getElement(membershipTypeEditButton), driver);
				clickONMethod("Select membership type",membertypeDropDown , "Failed to click on memnership type dropdown");
				clickONMethod("Membership Type", memberShipTypeLocator(memberType), "Failed to click on desired memberShip type from List");
				assertEquals(getElement(ModelcontentMessage).getText(),"Please add this member to the committees in order to update the Membership type to Participating.");
				getElement(OkBtn).click();
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AddMemberToCommitteeBtn), 10);
				getElement(AddMemberToCommitteeBtn).click();
				PublicCommon.waitForSec(7);
			}

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required Membership type", e);
		}
	}

	public void AddMemberToCommitteePopUp(){
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(AddMemberHeader),20);
			PublicCommon.waitForSec(7);
			getElement(CommitteeDesignation).click();
			PublicCommon.waitForSec(7);
			getElement(selectCommittefromList).click();
			AddressValidationHeader();
			enterText("Reason for Update",reasonUpdateMembership,"testing", "Failed to enter text in reason");
			clickONMethod("Save Membership type Button", SaveBtn, "Failed to click on memberhsip Type Button");
			PublicCommon.waitForSec(9);

		} catch (Exception e) {
			e.getStackTrace();

		}

	}
	public void AddressValidationHeader(){
		if(getElement(PrimaryActivity).isDisplayed()) {
			getElement(DropdownPrimaryActivity).click();
			PublicCommon.waitForSec(5);
			getElement(selectActivity).click();
			getElement(describeProductsTextBox).sendKeys("Test");

		}
	}
	@Step("Change membership type from Representative to Informational")
	public void setMembershiptypeToFromRepToInformational(String memberType) {
		try {
			if (!getElement(membershipType).getText().equalsIgnoreCase(memberType)) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				ReusableMethods.scrollIntoView(getElement(memtype), driver);
				PublicCommon.JSClick(getElement(membershipTypeEditButton), driver);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(Organization).click();
				getElement(Organization).sendKeys(Keys.CONTROL,"a");
				getElement(Organization).sendKeys(Keys.DELETE);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				clickONMethod("Select membership type",membertypeDropDown , "Failed to click on memnership type dropdown");
				clickONMethod("Membership Type", memberShipTypeLocator(memberType), "Failed to click on desired memberShip type from List");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				RemoveREP();
				enterText("Reason for Update",reasonUpdateMembership,"testing", "Failed to enter text in reason");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicAdminCommons.scrollToElement(driver,saveMembershipType);
				PublicCommon.JSClick(getElement(saveMembershipType),driver);
				//clickONMethod("Save Membership type Button", saveMembershipType, "Failed to click on memberhsip Type Button");
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required Membership type", e);
		}
	}

	@Step("Submit the member order")
	public String SubmitMemberOrder() {
		String orderAccountNo = null;
		try {
            PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementStaleness(driver, getElement(submitButton));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(submitButton));
			orderAccountNo = getElement(accountNumber).getText();
			getElement(yesRadioButton).click();
			getElement(Comments_YesradioButton).sendKeys("Comment");

			getElement(submitButton).click();
			getElement(reviewSubmit).click();
			PublicCommon.waitForSec(10);
          ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to set required Membership type", e);
		}
		return orderAccountNo;
	}
	public By cookieRejectAll = By.xpath("//button[text()='Cookies Settings']//following-sibling::button[text()='Reject All']");

	@Step("Click On my commmittees button")
	public void clickMyCommittessButton() {
		ReusableMethods.scrollIntoView(getElement(myComitiesButton), driver);
		PublicCommon.waitForSec(10);
		WaitStatementUtils.explicitWait(driver, getElement(myComitiesButton));
		getElement(myComitiesButton).click();
	}
	@Step("Click On my Collaboration Area Link")
	public void clickMyMyCollaborationArea() {
		getElement(myCollaborationLink).click();
	}
	@Step("Click On my Collaboration Area Link")
	public void clickOnGroupAccount() {
		WaitStatementUtils.explicitWait(driver, getElement(firstAccount_AC));
		getElement(firstAccount_AC).click();
	}
	@Step("Click On Launch Admin Collaboration Area Link")
	public void clickOnLaunchAdminCollabArea() {
		getElement(launchAdminCollabArea).click();
	}
	@Step("Click On Create work item Collaboration Link")
	public void clickOnCreateWorkItemCollaboration() {
		getElement(workItemCollaboration).click();
	}
	@Step("Select a collaboration area")
	public void collaborationAreaSelection() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickMyCommittessButton();
			WebElement closeCookiebutton = getElement(closeCookie);
			if(closeCookiebutton.isDisplayed()) {
				WaitStatementUtils.waitForElementToBeClickable(driver, closeCookiebutton, 5);
				closeCookiebutton.click();
			}
			clickMyMyCollaborationArea();
			clickOnGroupAccount();
			PublicCommon.switchTabs(driver,1);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(editCollaborationArea));
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver,editCollaborationArea));
			ScreenshotUtil.takeScreenshotForAllure(driver);

		}	catch(Exception e){
				e.printStackTrace();
				PublicCommon.reportFailAssert("Failed to Select CollaborationArea", e);
			}

	}

	@Step("Schedule Online Meeting")
	public void scheduleOnlineMeeting() {
		try {
           /* getElement(editCollaborationArea).click();
			PublicCommon.isWebElementInvisible(driver,spin1);*/
			WaitStatementUtils.waitForElementStaleness(driver,getElement(scheduleMeeting),10);
			Assert.assertTrue(getElement(scheduleMeeting).isDisplayed(),"Not able to see the Schedule online meeting Tab");
			getElement(scheduleMeeting).click();
			PublicCommon.waitForSec(20);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.switchTabs(driver,2);
			PublicCommon.isWebElementInvisible(driver,spin2);

		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Schedule Meeting", e);
		}

	}

	@Step("Meeting information Form Filling")
	public void meetingInfoFilling() {
		try {
			PublicCommon.JSClick(getElement(clearForm),driver);
			PublicCommon.JSClick(getElement(previousMeetingRadio),driver);
			getElement(chooseMeeting).click();
			getElement(firstMeeting).click();
			getElement(done).click();
			WaitStatementUtils.waitForElementStaleness(driver,getElement(continueButton),10);
			PublicCommon.JSClick(getElement(continueButton),driver);
			PublicCommon.waitForSec(20);
			getElement(meetingStartDateCalender).click();
			getElement(TodayDatePick).click();
			PublicCommon.selectValueInDropdownbyIndex(getElement(startTime),2);
			PublicCommon.selectValueInDropdownbyIndex(getElement(startMin),2);
			//PublicCommon.JSClick(getElement(amRadioButton),driver);
			PublicCommon.selectValueInDropdownbyIndex(getElement(durationHour),2);
			PublicCommon.selectValueInDropdownbyIndex(getElement(durationMinute),2);
			PublicCommon.JSClick(getElement(continueButton),driver);
			PublicCommon.JSClick(getElement(scheduleMeetingBtn),driver);
			Assert.assertTrue(WaitStatementUtils.explicitWait(driver,getElement(successMsg)));
			//Assert.assertEquals(getElement(successMsg).getText(),"Thank you! This meeting will be scheduled within 2 business days of receipt. The meeting settings will be saved for your future reference. Return to MyCommittees.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Fill the details", e);
		}

	}
	@Step("Launch Admin collaboration area and Verification of redirect to spec builder page")
	public void launchAdminCollabArea() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickMyCommittessButton();
			getElement(cookieRejectAll).click();
			clickMyMyCollaborationArea();
			clickOnLaunchAdminCollabArea();
			PublicCommon.waitForSec(10);
			PublicCommon.switchTabs(driver,1);
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver,committeeGroupRadioBtn));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Launch the Admin collaboration area/Redirect to spec builder", e);
		}

	}



	@Step("Create Work item Collaboration")
	public void workItemCollaborationCreation(String email) {
		try {
			PublicCommon.waitForSec(10);
			/*WebElement closeCookiebutton = getElement(closeCookie);
			if(closeCookiebutton.isDisplayed()) {
				WaitStatementUtils.waitForElementToBeClickable(driver, closeCookiebutton, 5);
				closeCookiebutton.click();
			}*/
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickMyCommittessButton();
			clickMyMyCollaborationArea();
			clickOnCreateWorkItemCollaboration();
			PublicCommon.waitForSec(5);
			selectWorkItem(email);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Launch the Admin collaboration area/Redirect to spec builder", e);
		}

	}
	@Step("Verify User should redirect to spec builder page of created collaboration area")
	public void verifyRedirectingToCraetedCollabArea() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(createdCollabAreaPage).isDisplayed();
			driver.close();
		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to redirecting spec builder page of created collaboration area", e);
		}

	}
	@Step("Verify User should redirect to create account page with first name, last name and password setting")
	public void verifyAccountActivationPage() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(accountActivationPage).isDisplayed();

		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to redirecting create account page with first name, last name and password setting", e);
		}

	}
	public By unexpectedError = By.xpath("//span[text()='Unexpected error encountered while creating the collaboration area. Please retry.']");
	public By confirmationMsg = By.xpath("//strong[text()='Confirmation']");
	@Step("Select work item and Create Collaboration area")
	public void selectWorkItem(String email) throws IOException {
		try {
			getElement(select).click();
			getElement(firstWorkItemSelection).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(done).click();
			PublicCommon.waitForSec(5);
			getElement(continueButton).click();
			getElement(nonMemberEmailId).sendKeys(email);
			getElement(continueButton).click();
			ReusableMethods.scrollIntoView(getElement(CreateCollaborationArea), driver);

			PublicCommon.JSClick(getElement(uploadDrafts_True), driver);
			PublicCommon.JSClick(getElement(uploadSupport_True), driver);
			PublicCommon.JSClick(getElement(initialDraft_True), driver);
			getElement(CreateCollaborationArea).click();

			if(getElements(confirmationMsg).size()!=0){
				ScreenshotUtil.takeScreenshotForAllure(driver);
				Assert.assertTrue(getElement(confirmationMsg).isDisplayed(),"Confirmation Msg not displayed and not able to create Collaboration area");
			}else{
				for(int i = 2;i<=20;i++) {

					clickMyCommittessButton();
					clickMyMyCollaborationArea();
					clickOnCreateWorkItemCollaboration();
					PublicCommon.waitForSec(5);
					getElement(select).click();
					getElement(workItemSelection(i)).click();
					getElement(done).click();
					PublicCommon.waitForSec(5);
					getElement(continueButton).click();
					getElement(nonMemberEmailId).sendKeys(email);
					getElement(continueButton).click();
					ReusableMethods.scrollIntoView(getElement(CreateCollaborationArea), driver);
					PublicCommon.JSClick(getElement(uploadDrafts_True), driver);
					PublicCommon.JSClick(getElement(uploadSupport_True), driver);
					PublicCommon.JSClick(getElement(initialDraft_True), driver);
					WaitStatementUtils.waitForElementToBeClickable(driver,getElement(CreateCollaborationArea));
					getElement(CreateCollaborationArea).click();
					if(getElements(confirmationMsg).size()!=0){
						ScreenshotUtil.takeScreenshotForAllure(driver);
						Assert.assertTrue(getElement(confirmationMsg).isDisplayed(),"Confirmation Msg not displayed and not able to create Collaboration area");
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.reportFailAssert("Failed to Create the collaboration area", e);
		}
	}

	@Step("Create New Collaboration Area")
	public void createNewCollabArea() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getElement(committeeGroupRadioBtn), driver);
			PublicCommon.selectValueInDropdownbyIndex(getElement(selectCommittee), 1);
			getElement(collaborationAreaTitle).sendKeys("TextAutomation");
			PublicCommon.selectValueInDropdownbyIndex(getElement(collaborationAdministrator), 1);
			ReusableMethods.scrollIntoView(getElement(initialDraft), driver);
			getElement(uploadDrafts_Yes).click();
			getElement(uploadSupport_Yes).click();
			getElement(initialDraft).click();
			getElement(createCollaborationArea).click();
			WaitStatementUtils.explicitWait(driver,getElement(collaborationAreaNo));
			String[] no = getElement(collaborationAreaNo).getText().split("-");
			collaborationId = no[0].replaceAll(" ", "");
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Create the collaboration area", e);
		}
	}
	public By newCollaborationArea = By.xpath("//button[text()='Create New Collaboration Area']");
	@Step("Click on createNewCollaborationArea button")
	public void clickOnNewCollaborationArea(){
		getElement(newCollaborationArea).click();
	}
		@Step("Create New Collaboration Area with additional member")
		public void createNewCollabArea_AdditionalMember() {
			try {
				clickOnNewCollaborationArea();
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.JSClick(getElement(committeeGroupRadioBtn),driver);
				PublicCommon.selectValueInDropdownbyIndex(getElement(selectCommittee),1);
				getElement(collaborationAreaTitle).sendKeys("TextAutomation");
				PublicCommon.selectValueInDropdownbyIndex(getElement(collaborationAdministrator),1);
				ReusableMethods.scrollIntoView(getElement(initialDraft),driver);
				getElement(uploadDrafts_Yes).click();
				getElement(uploadSupport_Yes).click();
				getElement(initialDraft).click();
				getElement(createCollaborationArea).click();
				String[] no = getElement(collaborationAreaNo).getText().split("-");
				collaborationId = no[0].replaceAll(" ","");

			}	catch(Exception e){
				e.printStackTrace();
				PublicCommon.reportFailAssert("Failed to Create the collaboration area", e);
			}

	}

	@Step("Verify Created Collaboration Area under my Collaboration area link")
	public void verifyCreatedCollaborationInMyCollaborationAreaLink() {
		try {
             PublicAdminCommons.refreshPage(driver);
			 PublicCommon.waitForSec(10);
			 clickMyMyCollaborationArea();
             int collaborationIdCount = getElements(CollaborationIdsCount).size();
			 for(int i=1;i<=collaborationIdCount;i++){
				 if(getElement(collaborationExactId(i)).getText().contains(collaborationId)) {
					 PublicAdminCommons.scrollToElement(driver, collaborationExactId(i));
					 PublicCommon.waitForSec(5);
					 ScreenshotUtil.takeScreenshotForAllure(driver);
				 }
			 }
		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify created collaboration area", e);
		}

	}
	public By IdonotHaveTheOrganizationRadioBtn= By.xpath("(//input[@name='accountAssociationType']/../label)[2]");
	public By IHaveTheOrganizationRadioBtn= By.xpath("//label[text()='I have the organization account number']");
	public By getDetailsButton_Disabled = By.xpath("//button[text()='Get Details' and contains(@class,'disabled')]");
	public By getDetailsButton_Enabled = By.xpath("//button[text()='Get Details' and not(contains(@class,'disabled'))]");

	@Step("Verify 'I have the organization account number' radio button")
	public void VerifyIhavetheorganizationaccountnumberRadioButton() {
		try {
			Assert.assertTrue(getElement(IHaveTheOrganizationRadioBtn).isDisplayed(),"I have the organization account number is not available");
			 getElement(IHaveTheOrganizationRadioBtn).click();
			 VerifyGetDetailsButtonDisabled();



		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify 'I have the organization account number' radio button", e);
		}
	}
	@Step("Verify Get Details button Disabled")
	public void VerifyGetDetailsButtonDisabled() {
		try {
			Assert.assertTrue(getElement(getDetailsButton_Disabled).isDisplayed(),"Not able to see the disabled button");
		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed Verify Get Details button Disabled", e);
		}
	}
	@Step("Verify Get Details button Enabled")
	public void VerifyGetDetailsButtonEnabled() {
		try {
			Assert.assertTrue(getElement(getDetailsButton_Enabled).isDisplayed(),"Not able to see the Enabled button");
		}	catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed Verify Get Details button Enabled", e);
		}
	}

	@Step("Adding any of the fee group under fee group section")
	public void feeGroupAdding() {
		try {
			WaitStatementUtils.explicitWait(driver,getElement(astmGeneralInfoEdit));
			clickONMethod("Edit ASTM general information", astmGeneralInfoEdit,
					"failed to click on ASTM general information");
			WaitStatementUtils.explicitWait(driver,getElement(feeGroupDropdown));
			clickONMethod("Click on fee group dropDown", feeGroupDropdown,
					"Failed to Click on fee group dropDown");
			clickONMethod("Click on any one group", selectAnyFeeGroup,
					"Failed to Click on any one group");
			enterText("Renewal Reason", renewalReasonTextBox, "test", "Failed to enter text");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("Update ASTM general Information", astmGeneralInfoUpdate,
					"Failed to update general information");
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Adding any of the fee group under fee group section", e);
		}
	}
	//FeeGroup Creation start
	public By memberDrpDwn = By.xpath("//a[text() = 'Member']");
	public By feeGroup=By.xpath("//a[text() = 'Fee Group']");
	public By addFeeGroupButtonXpath=By.xpath("//button[text()='Add Fee Group']");
    public By feeGroupTitleXpath = By.xpath("//h2[text() ='Add Fee Group']");
    public By titleInputXpath = By.xpath("//input[@id = 'FeeGroupTitle']");
	String feeGroupId = "//td[@class = 'comDesign false']/a";
	public By countrydrpdwnXpath = By.xpath("//div[@class = 'divider default text' and text() = 'Please Select Country']");
	String slctCountryXpath = "//div[@data-testid='Country']//span[text()='%s']";
	public By successMessage = By.xpath("//p[text() = 'Record created successfully.']");
	public By feeGroupPage = By.xpath("//h2[text() = 'Fee Group']");
	String feeGroupNameXpath = "//td[text() = '%s']";
	private String feeGroupTitle;

	public String generateFeeGroupTitle() {
		if (feeGroupTitle == null) { // Generate only if not already created
			feeGroupTitle = "stgintauto" + PublicAdminCommons.getCurrentDateWithFormat("MMddHHmm") + "_6127";
		}
		return feeGroupTitle;
	}

	public void navigateToFeeGroup(){
		try{
			WaitStatementUtils.explicitWait(driver,getElement(memberDrpDwn));
			ReusableMethods.mouseHover(driver,getElement(memberDrpDwn),"memberDrpDwn");
			//navigate to fee group page
			WaitStatementUtils.explicitWait(driver,getElement(feeGroup));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("FeeGroup", feeGroup,
					"failed to navigate to FeeGroup");
			PublicCommon.waitForSec(5);
		}catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("failed to navigate to fee group ", e);
		}
	}

	public void feeGroupCreation() {
		try {
            //click on add fee group
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(addFeeGroupButtonXpath));
			CommonPage_Public.JSClick(getElement(addFeeGroupButtonXpath),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
            //navigation to add fee group page
            isWebElementPresentOnPage(driver,feeGroupTitleXpath);
			//Enter fee group title
			String titleFeeGroup = generateFeeGroupTitle();
			WaitStatementUtils.explicitWait(driver,getElement(titleInputXpath));
			enterText("fee group title",titleInputXpath,feeGroupTitle,"Failed to enter title");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			//Select country
			clickONMethod("Select country", countrydrpdwnXpath, "Failed to click on country dropdown");
			clickonmethod("click on country", By.xpath(String.format(slctCountryXpath, "United States")),"Failed to selectCountry");
			//Save the fee group
			clickonmethod("click on save button",SaveBtn,"Failed to click on save");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			//validate success message
			wait.until(ExpectedConditions.visibilityOf(getElement(successMessage)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			//verify the staff landed on fee group page
			WaitStatementUtils.explicitWait(driver,getElement(feeGroupTitleXpath));
			ReusableMethods.scrollUpToTopOfPage(driver);
			isWebElementPresentOnPage(driver, feeGroupPage);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Creating the fee group Failed ", e);
	}
	}
	public List<WebElement> getFeeGroupId() {
		List<WebElement> list2 = driver.findElements(By.xpath("//table[@class = 'customTable']/tbody/tr/td[1]"));
		return list2;
	}

	public boolean isTableDataSortedAscending(List<WebElement> DataElements) {
		List<String> actualData = new ArrayList<>();
		for (WebElement element : DataElements)
		{
			actualData.add(element.getText().toLowerCase());
		}
		List<String> sortedData = new ArrayList<>(actualData);
		Collections.sort(sortedData);
		// Compare actual data with the sorted list
		int i;
		int flag = 1;
		for (i=0;i<actualData.size();i++){
			if (!actualData.get(i).equals(sortedData.get(i))){
				System.out.println("Match Failed at index"+i);
				System.out.println(actualData.get(i));
				System.out.println(sortedData.get(i));
				Allure.addAttachment("sort validation:","expected is "+actualData.get(i)+", actual is: "+sortedData.get(i));
				flag = 0;
			}
		}
		if (flag==1)
		return true;
		else
			return false;
		}

	public void searchFeeGroup() {

		try {
			PublicAdminCommons.refreshPage(driver);
			PublicCommon.waitForSec(3);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(mcs2SeachBox));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Fee Group Search Box", mcs2SeachBox, feeGroupTitle, "Failed to enter account Number");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("Search button", mcs2SearchButton, "Failed to click on search button");
			isWebElementPresentOnPage(driver,By.xpath(String.format(feeGroupNameXpath, feeGroupTitle)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("fee group Id", By.xpath(feeGroupId),"Failed to click on fee group");
			PublicCommon.waitForSec(3);
			isWebElementPresentOnPage(driver,By.xpath(String.format(feeGroupPageXpath,feeGroupTitle)));
		} catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to search created fee group",e);
		}
	}
	String getFeeGroupId = "// span[@class = 'memberAccount']";
	public  String getFeeGroupUniqueId() {
		String feeGroupIdName = null;
		try {
			String fullText = driver.findElement(By.xpath(getFeeGroupId)).getText();
			// Extract only the required part after ":" using split
			if (fullText.contains(":")) {
				feeGroupIdName = fullText.split(":")[1].trim(); // Splits at ':' and removes spaces
			}
		}catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get fee group Id",e);
		}
		return feeGroupIdName;
	}
	String feeGroupPageXpath ="//span[@class = 'memberName ellip' and text() = '%s']";
	String feeGroupStatus = "//span[@class = 'titleInfo' and text() = '%s']";

	public void validateFeeGroup() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertEquals(driver.findElement(By.xpath(String.format(feeGroupStatus, "Not Paid"))).getText(), "Not Paid", "Paid Status mismatch! Expected: 'Not Paid'");
			Assert.assertEquals(driver.findElement(By.xpath(String.format(feeGroupStatus, "Active"))).getText(), "Active", "Status mismatch! Expected: 'Active'");
		} catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to validate created fee group",e);
		}
	}

	public By editFeeGrpBtnXpath = By.xpath("//section[@class = 'subCommInfo']//i[@class='pencil icon']");
	public By editStatuBtn =By.xpath("//section[@class = 'subCommInfo mt30']//i[@class='pencil icon']");
	String feeGrpAutoRnwlsChkBox = "//label[text() = '%s']";
	public By feeGroupContactPerson = By.xpath("//input[@id ='ContactPersonName']");
	public By feeGroupUpdtBtn = By.xpath("//button[@class='updateBtn']");

	public void editFeeGroup() {
		try {
			clickonmethod("fee group edit button",editFeeGrpBtnXpath,"Failed to click on  edit fee group button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
 			clickonmethod("Auto renewal checkbox",By.xpath(String.format(feeGrpAutoRnwlsChkBox,"Auto Renewal")),"Failed to click on Auto Renewal");
			clickonmethod("Suppress Fee Renewal Emails checkbox",By.xpath(String.format(feeGrpAutoRnwlsChkBox,"Suppress Fee Renewal Emails")),"Failed to click on Suppress Fee Renewal Emails");
			clickonmethod("Suppress Fee Renewal Print checkbox",By.xpath(String.format(feeGrpAutoRnwlsChkBox,"Suppress Fee Renewal Print")),"Failed to click on Suppress Fee Renewal Print");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Contact person name",feeGroupContactPerson,"StageAutomation","Failed to change contact person");
			enterText("Enter Reason",ReasonForUpdateTextArea,"Stgautotest","Failed to enter reason");
			CommonPage_Public.JSClick(getElement(feeGroupUpdtBtn),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			//validate success message
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
		} catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to edit created fee group",e);
		}
	}
	public By navgtToAssociatedMembersTab = By.xpath("//a[text() = 'Associated Members']");
	public By clickOnAssociateMem = By.xpath("//button[text() = 'Associate Member']");
	public By associateMembersPopUp = By.xpath("//div[@class = 'header' and text() = 'Associate Member(s)']");
	public By searchMemberXpath = By.xpath("//input[@placeholder='Search Member by Account Number, Name']");
	public By clickOnMemberXpath = By.xpath("//div[@class = 'result']");
	public By assignBtnXpath = By.xpath("// button[text()='Assign']");
	String validatedAddedMemberXpath = "//a[text()='%s']";

	public void addMemberToFeeGroup(String memberID) {
		try {
			PublicAdminCommons.refreshPage(driver);
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(navgtToAssociatedMembersTab));
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("Associated members tab",navgtToAssociatedMembersTab,"Failed to navigate to associated members tab");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(clickOnAssociateMem));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("Associate Member",clickOnAssociateMem,"Failed to click on associate member button");
			isWebElementPresentOnPage(driver,associateMembersPopUp);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(8);
			enterText("Search Member",searchMemberXpath,memberID,"Failed to Enter MemberId");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(clickOnMemberXpath));
			clickonmethod("Select member",clickOnMemberXpath,"Failed to click on member");
			enterText("Enter Reason",ReasonForUpdateTextArea,"Stgautotest","Failed to enter reason");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("click on Assign",assignBtnXpath,"Failed to click on assign button");
			wait.until(ExpectedConditions.visibilityOf(getElement(successMessage)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(PublicAdminCommons.isElementDisplayed(getElement(By.xpath(String.format(validatedAddedMemberXpath,memberID)))),"Added member is not displayed in the Associate member tab list");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to add member to fee group",e);
		}
	}

	public By FeeGroupAcntStatusXpath = By.xpath("//div[@class='field']//div[text()='Active']");
	String slectFeeGrpAcntStatusXpath = "//span[@class = 'text' and text() = '%s']";

	public void inActivateFeeGroup() {
		try {
			PublicAdminCommons.refreshPage(driver);
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(editStatuBtn));
			clickonmethod("fee group status edit button", editStatuBtn,"Failed to click on fee group edit status button");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(FeeGroupAcntStatusXpath));
			clickonmethod("fee group status edit button", FeeGroupAcntStatusXpath,"Failed to click on fee group edit status button");
			clickonmethod("set status to Inactive",By.xpath(String.format(slectFeeGrpAcntStatusXpath,"Inactive")),"Failed to set status to Inactive");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Enter Reason",ReasonForUpdateTextArea,"Stgautotest","Failed to enter reason");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			CommonPage_Public.JSClick(getElement(feeGroupUpdtBtn),driver);
			isWebElementPresentOnPage(driver,ConfirmPopUp);
			Assert.assertEquals(driver.findElement(ConfirmPopUp).getText(),"Inactivating this Fee Group shall remove the association with 1 Members. Are you sure you want to update the record?");
			clickonmethod("Yes button",yesButton,"Failed to click on yes button");
			//validate success message
			wait.until(ExpectedConditions.visibilityOf(getElement(sucessNote)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertEquals(driver.findElement(By.xpath(String.format(feeGroupStatus, "Not Paid"))).getText(), "Not Paid", "Paid Status mismatch! Expected: 'Not Paid'");
			Assert.assertEquals(driver.findElement(By.xpath(String.format(feeGroupStatus, "Inactive"))).getText(), "Inactive", "Status mismatch! Expected: 'Inactive'");
		} catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to inactive fee group",e);
		}
	}

	public void verifyFeeGroupPaidStatus(String accountStaus, String paymentStatus) {
		try {
			PublicCommon.waitForSec(5);
			Assert.assertEquals(driver.findElement(By.xpath(String.format(feeGroupStatus, paymentStatus))).getText(), paymentStatus, "Paid Status mismatch!");
			Assert.assertEquals(driver.findElement(By.xpath(String.format(feeGroupStatus, accountStaus))).getText(), accountStaus, "Status mismatch!");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to validate fee group status", e);
		}
	}

	public By removeButtonFeeGroupXpath = By.xpath("//button[text() = 'Remove Member from Fee Group']");
	String accntNoCheckBox = "//a[text() = '%s']/parent::td/parent::tr/td[1]/descendant::input";
	public By recordUpdButtonXpath = By.xpath("//button[@title='Update']");
	public By removeMemPopUp = By.xpath("//div[@class='header' and text() = 'Update Reason']");
	public By successNoteOfRmvdMem = By.xpath("// p[text()='Selected member(s) removed successfully.']");

	public void removeMemberFromFeeGroup(String accountNumber) {
		try {
			PublicCommon.waitForSec(3);
			PublicAdminCommons.refreshPage(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(navgtToAssociatedMembersTab));
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("Associated members tab", navgtToAssociatedMembersTab, "Failed to navigate to associated members tab");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(removeButtonFeeGroupXpath));
			clickonmethod("Remove member button", removeButtonFeeGroupXpath, "Failed to click on Remove member button");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(By.xpath(String.format(accntNoCheckBox, accountNumber))));
			CommonPage_Public.JSClick(getElement(By.xpath(String.format(accntNoCheckBox, accountNumber))), driver);
			CommonPage_Public.JSClick(getElement(recordUpdButtonXpath), driver);
			isWebElementPresentOnPage(driver, removeMemPopUp);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			enterText("Enter Reason", ReasonForUpdateTextArea, "Stage automation test", "Failed to enter reason");
			clickonmethod("update button", updateBtn, "Failed to click on update button in popup");
			wait.until(ExpectedConditions.visibilityOf(getElement(successNoteOfRmvdMem)));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to remove member from fee group", e);
		}
	}

	public By memberDropDown = By. xpath("// a[text() = 'Members']");
	public String selectMember = "// a[@class = 'column--MemberDetail_AccountNumber' and text() = '%s']";

	public void navigateToMember(String memberId) {
			try {
				driver.navigate().refresh();
				PublicCommon.waitForSec(5);
				WaitStatementUtils.explicitWait(driver, getElement(memberDrpDwn));
				ReusableMethods.mouseHover(driver, getElement(memberDrpDwn),"Member Drop Down");
				WaitStatementUtils.explicitWait(driver, getElement(memberDropDown));
				ScreenshotUtil.takeScreenshotForAllure(driver);
				clickonmethod("Members",memberDropDown,"Failed to click on MemberDrop Down");
				PublicCommon.waitForSec(5);
				enterText("Member Search Box", mcs2SeachBox, memberId, "Failed to enter account Number");
				clickonmethod("MembersID",mcs2SearchButton,"Failed to Search Members");
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(By.xpath(selectMember)));
				PublicCommon.waitForSec(8);
				PublicCommon.JSClick(getElement(By.xpath(String.format(selectMember, memberId))), driver);
				PublicCommon.waitForSec(8);

			} catch (Exception e) {
				e.printStackTrace();
				PublicCommon.reportFailAssert("Failed to navigate to member", e);
			}
	}
	public By editIconAstmGnrl = By.xpath("//h5[text() = 'ASTM General Information']/a[@class = 'editBtn']");
	public By feeGroupDrpDwn = By.xpath("//div[@class = 'divider text' and text() = 'Search by Fee Group Title']");

	public void clickEditIconASTMGeneralInfo() {
		try {
			PublicCommon.JSClick(getElement(editIconAstmGnrl), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(feeGroupDrpDwn));
			clickonmethod("Fee Group DropDown",feeGroupDrpDwn,"Failed to click on fee group Drop Down");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on ASTM General info edit button", e);
		}
	}
	public List<WebElement> getFeeGroupIdsFromMem() {
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@data-testid= 'FeeGroupId']//div[@role= 'listbox']//span"));
		list1.remove(0);
		return list1;
	}
	//Fee Group creation END

	@Step("Reactivate Committee in IA")
	public void reactivateCommittee(String mainCommittee) {
		try {
			//Converting inactive committee to active
			clickONMethod("Members dropdown", membersDropdown, "Unable to click on dropdown");
			clickONMethod("Committees", committees, "Unable to click on committees");
			enterText("Search bar", searchBar, mainCommittee, "Unable to click on search bar");
			clickONMethod("Search icon", searchIcon, "Unable to click on search icon");
			PublicCommon.waitForSec(5);
			clickonmethod("Committee link",By.xpath(String.format(committeeNumber, mainCommittee)),"failed to click on committee");
			PublicCommon.waitForSec(8);

			String status = getElement(committeeStatus).getText();


			if(status.contains("Inactive")) {

				WaitStatementUtils.waitForLoaderToBeInvisible(driver);
				clickONMethod("Three Dots", threeDots, "Unable to click on 3 dots");

				if (WaitStatementUtils.waitForElementToBeClickable(driver, page.getElement(reactivate))) {
					clickONMethod("Reactivate Committee", reactivate, "Unable to click on reactivate committee");
				}
				if (homepage.isWebElementDisplayed(reactivateCommitteeWithMembers_radiobtn)) {
					clickONMethod("Reactivate Committee with members", reactivateCommitteeWithMembers_radiobtn, "Unable to click on Reactivate Committee with members");
				}
				enterText("Reason for update", reasonForUpdate, "text", "Unable to click on Reason for update");
				clickONMethod("Reactivate Button", reactivateButton, "Unable to click on reactivate button");
				Assert.assertTrue(homepage.isWebElementDisplayed(reactivateSuccessfull));
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.waitForSec(5);
			}

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Reactivate Committee in IA", e);
		}
	}

	public By orgInDropDown = By. xpath("// a[text() = 'Organizations']");

	public void navigateToOrganization(String orgId) {
		try {
			driver.navigate().refresh();
			PublicCommon.waitForSec(5);
			WaitStatementUtils.explicitWait(driver, getElement(memberDrpDwn));
			ReusableMethods.mouseHover(driver, getElement(memberDrpDwn),"Member Drop Down");
			WaitStatementUtils.explicitWait(driver, getElement(orgInDropDown));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("Organizations",orgInDropDown,"Failed to click on organization Drop Down");
			PublicCommon.waitForSec(5);
			enterText("Organization Search Box", mcs2SeachBox, orgId, "Failed to enter org account Number");
			clickonmethod("MembersID",mcs2SearchButton,"Failed to Search organization");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(By.xpath(selectMember)));
			PublicCommon.waitForSec(8);
			PublicCommon.JSClick(getElement(By.xpath(String.format(selectMember, orgId))),driver);
			PublicCommon.waitForSec(10);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to navigate to member", e);
		}
	}
}