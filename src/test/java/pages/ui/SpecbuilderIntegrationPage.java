package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SpecbuilderIntegrationPage extends BasePage {

	/**
	 * Parameterized constructor
	 *
	 * @param driver
	 */
	public SpecbuilderIntegrationPage(WebDriver driver) {
		super(driver);
	}
	AdminAreaPage adminAreaPage;

	public By selectAnAccountHeader = By.xpath("//*[text()='Select an Account']");
	public By ChooseBallotClosingDate = By.xpath("//input[@id='rdp-form-control-closingDate']");
	public By createButton = By.xpath("//button[contains(text(),'Create New Group')]");
	public By selectButtonOwensCorning = By.xpath("//*[text()='Select']");//By.xpath("//*[text()='Owens Corning']/following-sibling::button[text()='Select']");
	public By owensCorningHeader = By.xpath("//*[@class='banner-wrapper']//*[text()='Owens Corning']");
	public By committeeGroupRadioButton=By.xpath("//input[@value='Committee Group']");
	public By createNewGroupButton = By.xpath("//button[text()='Create New Collaboration Area']|//button[text()='Create New Group']");
	public By createNewGroupHeader = By.xpath("//*[contains(text(),'Create New')]");
	public By selectCommittteDropdown=By.xpath("//select[@aria-label='Select Value']");
	public By groupNameTextbox = By.name("groupName");

	public By deleteGroup = By.xpath("//a[text()='Delete Group']");
	public By deleteCollaborationArea = By.xpath("//a[text()='Delete Collaboration Area']");
	public String myGroupsLatestGroup = "//tr//td[contains(.,'GroupName')]";
	public By memberLinkForGroup= By.linkText("Members");
	public By memberTabTable = By.xpath("//*[@class='spec-member-table-wrapper']");
	public By groupAdministratorDropdown = By.xpath("//label[starts-with(text(),'Collaboration Area')]//following-sibling::div//select |//label[starts-with(text(),'Group')]//following-sibling::div//select");
	public By groupDescriptionTextbox = By.cssSelector("*[name='description'][class='form-control']");
	public By additionalMembersTxtbox = By.name("additionalMembers");
	public By uploadDraftsNoRadioBtn = By.xpath("//*[text()='No, just Collaboration Area Administrator']/preceding-sibling::input[@name='uploadAllCan']|//*[text()='No, just Group Administrator']/preceding-sibling::input[@name='uploadAllCan']");
	public By uploadOptionsSectionHeader = By.xpath("//*[text()='Upload Options']");
	public By createGroupButton = By.xpath("//button[contains(text(),'Create')]");//On Create New Group page
	public By additionalMembersHeader = By.xpath("//*[text()='Additional Members:']");
	public By uploadSupportNo = By.xpath("//input[@name='uploadAllSupportCan' and @value='No']");
	public By accountLink = By.linkText("Account");
	public By buttonSignOut = By.xpath("//button[contains(.,'Sign out')]");
	public By tokenexpiredHeader = By.xpath("//*[contains(text(), 'Token Expired')]");
	public String memberEmail = "//*[@class='spec-member-table-wrapper']//td[contains(text(), 'MemberEmail')]";
	public By cookieCloseButton= By.xpath("//div[@class='alert freeze-msg astm-alert ']//button");
	public By MemberasTab = By.xpath("//a[text()='Members']");
	public By AddorRemoveMembersBtn = By.xpath("//a[text()='Add/Remove Members']");

	public By addMemberArrow = By.xpath("//button[@aria-label='Add member']");
	public By removeMemberArrow = By.xpath("//button[@aria-label='Remove Member']");
	public By selectMember = By.xpath("(//div[@class='select-wrapper'])[1]//option[1]");
	public By disSelectMember = By.xpath("(//div[@class='select-wrapper'])[2]//option[1]");

	public By manage = By.xpath("//button[text()='Manage']");
	public By selectGroup_editGroup = By.xpath("//select[@title='Select Group to Edit']");
	public By selectGroup_replaceDraft = By.xpath("//select[@title='Select a Group']");
	public By selectSubGroup_replaceDraft = By.xpath("//select[@title='Select Draft']");
	public By uploadDrafts = By.xpath("//button[text()='Upload Draft']");

	public By editGropu = By.xpath("//a[text()='Edit Group']");
	public By ManageEmailsBallotReminder = By.xpath("//div[text()='Ballot Reminder']");
	public By specBuilderAdmin = By.xpath("//a[text()='SpecBuilder Admin']");
	public By archivedGroups = By.xpath("//a[text()='Archived Groups']");
	public By restoreGroup = By.xpath("//div[text()='Restore ']//following-sibling::div//select[@title='Select Group']");
	public By deleteArchiveGroup = By.xpath("//div[text()='Delete Archived ']//following-sibling::div//select[@title='Select Group']");
	public By delete = By.xpath("//button[text()='Delete']");
	public By delete_ModalFooter = By.xpath("//div[@class='modal-footer']//button[text()='Delete']");
	public By restoreGroupButton = By.xpath("//button[text()='Restore ']");

	Homepage homepage;

	public By parentGroup(String name){
		return By.xpath("//option[contains(text(),'"+name+"')]");
	}
	public By parentGroupSelection = By.xpath("//select[@title='Select Group']");

	public By userAdminisrator = By.xpath("//a[text()='User Administration']");
	public By commentsSection = By.xpath("//div[text()='Comments:']");
	public By voteSection = By.xpath("//div[@class='radio-group']");
	public By affirmativeRadio = By.xpath("//label[text()='Affirmative']//parent::div//input");
	public By nagativeRadio = By.xpath("//label[text()='Negative w/ Comment']//parent::div//input");
	public By abstainRadio = By.xpath("//label[text()='Abstain']//parent::div//input");
	public By selectAll = By.xpath("//a[@class='select-all']");
	public By selectAllRightArrow = By.xpath("//button[@class='fas fa-caret-circle-right arrow-item']");
	public By selectAllLeftArrow = By.xpath("//button[@class='fas fa-caret-circle-left arrow-item']");

	public By editCollaborationArea = By.xpath("//a[text()='Edit Collaboration Area']");
    public By SPBLoadingIcon=By.xpath("//div[@class='astm-spinner spinner-border']");

	public boolean displayTokenExpiredPage() {
		return PublicCommon.isVisibleInViewport(getElement(tokenexpiredHeader), driver);
	}

	public WebElement getSelectAnAccountHeader() {
		return getElement(selectAnAccountHeader);
	}

	public WebElement getUploadOptionsSectionHeader() {
		return getElement(uploadOptionsSectionHeader);
	}
	public WebElement getCreateNewGroupHeader() {
		return getElement(createNewGroupHeader);
	}
	public WebElement getAdditionalMembersHeader() {
		return getElement(additionalMembersHeader);
	}

	public WebElement getMemberLinkForGroup() {
		return getElement(memberLinkForGroup);
	}

	public WebElement getMemberTabTable() {
		return getElement(memberTabTable);
	}

	public By getDropDownElement(String fieldText){
		return By.xpath("//select[@aria-label='Select Value']/option[@title= '"+fieldText+"']");
	}
	public By home = By.xpath("//span[text()='Home']");
	public By CalendarEvents = By.xpath("//a[text()='Calendar Events']");
	public By group = By.xpath("//a[text()='Group']");
	public By ballot = By.xpath("//a[text()='Ballots']");
	public By openBallot = By.xpath("//a[text()='Open Ballot(s)']");
	public By voteSelection = By.xpath("//td[2]//select[@class='form-control form-control-sm']");
	public By role_reportSection = By.xpath("//table[@class='table astm-table table-striped table-striped--with-header rd-voter-table']//td[2]");
	public By recentActivitiesWidgetCount = By.xpath("//span[text()='Recent Activity']//parent::div//following-sibling::div//tbody//tr");
	public By firstGroup = By.xpath("//span[text()='My Groups']//parent::div//following-sibling::div//tbody//tr[1]");
	public By history = By.xpath("//a[text()='History']");
	public By ShowAllCollaborationAreas = By.xpath("//a[text()='Show All Collaboration Areas']");
	public By groupHistory = By.xpath("//h3[text()=' History']");
	public By ballots = By.xpath("//a[text()='Ballots']");
	public By ballotReports = By.xpath("//a[text()='Ballot Reports']");
	public By noBallotReportsFound = By.xpath("//div[text()='There are no reports at this time.']");
	public By viewReport = By.xpath("//a[text()='View Report'][1]");
	public By viewReport_openBallot = By.xpath("//span[text()='View Report']");
	public By csv = By.xpath("//span[text()='Export CSV']");
	public By xlsx = By.xpath("//span[text()='Export XLSX']");
	public By ballotTitle = By.xpath("//table[@class='table astm-table table-striped table-striped--with-header']//td[2]//span");
	public By VoteComment = By.xpath("//textarea[@placeholder='Write your message here']");
	public By saveVote = By.xpath("//button[text()='Save Vote']");
	public By votingNote = By.xpath("//table[@class='table astm-table table-striped table-striped--with-header rd-voter-table']//tr[1]//td[5]");
	public By externalGroupId = By.xpath("//input[@name='externalSystemID']");
	public By maxCount_externalGroupId  = By.xpath("//small[text()='Max 50 characters (']");
	public By groupEmailDisplayName  = By.xpath("//input[@name='groupEmailDisplayName']");
	public By saveGroup = By.xpath("//button[text()='Save ']");
	public By manageDrafts = By.xpath("//a[text()='Manage Drafts']");
	public By replaceDrafts = By.xpath("//a[text()='Replace Drafts']");
	public By remaining_externalGroupId(int value){
		return By.xpath("//small[text()='"+value+"']");
	}
	public By newCollaborationArea =  By.xpath("//button[text()='Create New Collaboration Area']");
	public By NewCollaborationArea =  By.xpath("//a[text()='New Collaboration Area']");
	public By committeeGroupRadioBtn = By.xpath("//input[@value='Committee Group']");
	public By selectCommittee = By.xpath("//div[@class='form-group']//select[@class='form-control']");
	public By uploadDrafts_Yes = By.xpath("//input[@name='uploadAllCan' and @value='Yes']");
	public By uploadSupport_Yes  = By.xpath("//input[@name='uploadAllSupportCan' and @value='Yes']");
	public By createCollaborationArea = By.xpath("//button[text()='Collaboration Area']");
	public By collaborationAreaTitle = By.xpath("//input[@name='groupName']");
	public By additionalMembersEmail = By.xpath("//textarea[@name='additionalMembers']");
	public By collaborationAdministrator = By.xpath("//select[@title='Select Collaboration Area Administrator']");
	public By initialDraft_No = By.xpath("//input[@name='isUploadNow' and @value='No']");
	public By initialDraft_Yes = By.xpath("//input[@name='isUploadNow' and @value='Yes']");

	public By collaborationAreaNo = By.xpath("//div[@class='group-switcher-wrapper']//following-sibling::div[contains(@class,'title')]");
	public By currentCollabArea=By.xpath("//select[@aria-label='Switch Group']");
	public By collaborationArea_Tab = By.xpath("//a[text()='Collaboration Area']");
	public By scheduleOnlineMeeting = By.xpath("//a[text()='Schedule Online Meeting']");
	public By exportCSV = By.xpath("//span[text()='Export CSV']");
	public By exportXLSX = By.xpath("//span[text()='Export XLSX']");
	public By selectButton_PlasticsPipeInstitute = By.xpath("//span[text()='Plastics Pipe Institute']/parent::p/button");
	public By manageButton = By.xpath("//button[text()='Manage']");
	public By UserReports = By.xpath("//a[text()='User Reports']");
	public By AllUsersRadio = By.xpath("//label[text()='All Users for Account']");
	public By MembersRadio = By.xpath("//label[text()='Members by Group']");
	public By BallotRadio = By.xpath("//label[text()='Ballot Vote Activity Report']");
	public By RegisteredUserReport = By.xpath("//span[text()='Registered User Report']");
	public By ApplicationCode = By.xpath("(//div[text()='All'])[@data-automation-context='Application Code']");
	public By FooterHome = By.xpath("//li[@data-testid='test_home']");
	public By PoweredByQuickStart = By.xpath("//span[text()='Powered by QuickSight']");
	public By RoleAll = By.xpath("//div[@data-automation-context='Role' and text()='All']");
	public By UserNameAll = By.xpath("//div[@data-automation-context='User Name' and text()='All']");
	public By BallotVoteElement = By.xpath("//span[text()='Ballot Vote Activity Report']");
	public By iframeBallotReport = By.xpath("//iframe[@class='quicksight-embedding-iframe']");
	public By SearchValue = By.xpath("//input[@placeholder='Search value']");
	public By SearchSearch = By.xpath("//span[text()='Search']");
	public By SelectAll = By.xpath("//li[@data-automation-id='dropdown_select_all_search_result_entry']");
	public By CloseX = By.xpath("(//span[@class='MuiIconButton-label-130])[8]");
	public By OfficialVoter = By.xpath("//li[@data-automation-context='Official Voter']");
	public By AbelsTerry = By.xpath("//li[@data-automation-context='Abels, Terry']");
	public By AdhocTest = By.xpath("//li[@data-automation-context='Adhoc Testing']");
	public By Active = By.xpath("//li[@data-automation-context='Active']");
	public By StartDate = By.xpath("(//input[@data-automation-id='date_picker_0'])[1]");
	public By EndDate = By.xpath("(//input[@data-automation-id='date_picker_0'])[2]");
	public By GroupNameAll = By.xpath("//div[@data-automation-context='Group Name' and text()='All']");
	public By GroupStatusAll = By.xpath("//div[@data-automation-context='Group Status' and text()='All']");
	public By ShowSelectedResults = By.xpath("//span/p[text()='Show selected']");
	public By manageBallotsTab = By.xpath("//a[@class='nav-link' and text()='Manage Ballots']");
	public By manageBallots_AllVoteReports = By.xpath("//a[@href='/admins/ballot/vote-reports']");
	public By homeButton = By.cssSelector(".home-nav-menu a");
	public By ReturnToOpenBallots = By.xpath("//button[contains(text(),'Return to Open ')]");
	public By ManageEmails = By.xpath("//a[text()='Manage Emails']");
	public By ManageEmailsNewBallot = By.xpath("//div[text()='New Ballot']");
	public By SelectBallotsGroup = By.xpath("(//select[@class='form-control'])[2]");
	public By IsThisRecirculation_No = By.xpath("//input[@data-testid='recirculation-unchecked']");
	public By IsThisRecirculation_Yes = By.xpath("//input[@data-testid='recirculation-checked']");
	public By SelectballottoRecirculateDropdown = By.xpath("//div[@data-testid='recirulation-title']/following::div/descendant::select");
	public By SelectballottoRecirculateDropdownOptions = By.xpath("//div[@data-testid='recirulation-title']/following::div/descendant::select/option");
	public By SelectBallotToRecirculate = By.xpath("//select[@title='Select a Ballot']");
	public By SelectBallotToRecirculateNote = By.xpath("//small[text()='Note: A ballot must be closed to recirculate']");
	public By CreateNewBallot = By.xpath("//button[text()='Create New Ballot']");
	public By LeavePage = By.xpath("//button[@class='btn astm-btn btn-secondary' and text()='Leave']");
	public By isThisARecirculation = By.xpath("//div[@class='astm-type-heading--h6' and text()='Is this a recirculation?']");
	public By isThisARecirculation_No_radio = By.xpath("//div[text()='Is this a recirculation?']//following-sibling::div//label[text()='No']//preceding-sibling::input");
	public By isThisARecirculation_Yes_radio = By.xpath("//div[text()='Is this a recirculation?']//following-sibling::div//label[text()='Yes']//preceding-sibling::input");
	public By homePage_ShowAllGroups = By.xpath("//a[@class='spec-link' and text()='Show All Groups']");
	public String allGroups_GroupName_var = "//td[@class='astm-table-td']//span[text()='[GROUPNAME]']";
	public By CloseTitlePopUp = By.xpath("//button[text()='Close']");
	public By PopUpTitle = By.xpath("(//span[@class='text-sizing'])[1]");
	public By VoteLink = By.xpath("(//span[@class='text-sizing'])[2]");
	public By fOpenDate = By.xpath("(//span[@class='text-sizing'])[2]");
	public By fCloseDate = By.xpath("(//span[@class='text-sizing'])[3]");
	public By fCEventsGroupName = By.xpath("(//span[@class='text-sizing'])[4]");
	public By OpenDate = By.xpath("(//span[@class='text-sizing'])[3]");
	public By CloseDate = By.xpath("(//span[@class='text-sizing'])[4]");
	public By CEventsGroupName = By.xpath("(//span[@class='text-sizing'])[5]");
	public By edit_draftComment = By.xpath("//span[text()='Edit']");
	public By editComment = By.xpath("//div[@class='discussion-edit-wrapper']//textarea");
	public By save = By.xpath("//button[text()='Save']");
	public By manageBallots = By.xpath("//a[text()='Manage Ballots']");
	public By editBallotDetails = By.xpath("//a[text()='Edit Ballot Details']");
	public By polls = By.xpath("//a[text()='Polls']");
	public By editPoll = By.xpath("//a[text()='Edit Poll Details']");
	public By selectPoll = By.xpath("//select[@title='Select Poll']");
	public By selectGroup_editBallots = By.xpath("//select[@title='Select a Group']");
	public By selectSubGroup_editBallots = By.xpath("//select[@title='Select Ballot']");
	public By saveChanges = By.xpath("//button[text()='Save Changes']");
	public By discussions = By.xpath("//a[text()='Discussions']");
	public By comment_discussions = By.xpath("//div[@class='discussion-edit-wrapper']//textarea");
	//public By files = By.xpath("//a[text()='Files']");
	public By editFileIcon = By.xpath("//table[@class='table astm-table']//td[6]//span[1]");
	public By deleteFileIcon = By.xpath("//table[@class='table astm-table']//td[6]//span[2]");
	public By fileName = By.xpath("//label[text()='File Description']//following::input");
	public By saveChanges_editFile = By.xpath("//button[text()=' Save Changes ']");
	public By deleteDiscussion = By.xpath("//span[text()='Delete']");
	public By deleteDraftIcon = By.xpath("//span[@class='far fa-trash-alt hand-icon']");
	public By closePopUp = By.xpath("//button[@class='close']");
	public By userBallotViewReportAlert= By.xpath("//div[contains(@class,'alert-danger')]");
	public By userBallotViewReportAlertMsg= By.xpath("//div[contains(@class,'alert-danger')]/div");





	public By getAllGroups_GroupName(String GroupName){
		return By.xpath(allGroups_GroupName_var.replace("[GROUPNAME]", GroupName));
	}
	// for getting all members list in select all
	List<WebElement> listoflist = driver.findElements(By.xpath("(//div[@class='select-wrapper'])[2]//option"));
	public List<WebElement> getMembersList(){
		 return getElements(By.xpath("(//div[@class='select-wrapper'])[2]//option"));
	}
	public By groupPage_BallotsTab = By.xpath("//a[@class='nav-link' and text()='Ballots']");
	public String collaborationId = null;




@Step("Verify the group admin able to edit the collaboration area and Add/remove members in existing collaboration area")
	public void addOrRemoveMembers() {
	try {
		PublicCommon.waitForSec(10);
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AddorRemoveMembersBtn),90);
		PublicAdminCommons.scrollToElement(driver, getElement(AddorRemoveMembersBtn));
		getElement(AddorRemoveMembersBtn).click();
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(addMemberArrow),90);
		PublicAdminCommons.scrollToElement(driver, getElement(selectMember));
		getElement(selectMember).click();
		getElement(addMemberArrow).click();
		ScreenshotUtil.takeScreenshotForAllure(driver);
		getElement(disSelectMember).click();
		getElement(removeMemberArrow).click();
		ScreenshotUtil.takeScreenshotForAllure(driver);
		getElement(addMemberArrow).click();
	} catch (Exception e) {
		e.printStackTrace();
		SpecBuilderCommon.reportFailAssert("Failed to Add/remove members", e);
	}
}
	@Step("Click on Member Tab")
	public void memberTab(){
		try{
			getElement(MemberasTab).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click member Tab", e);
		}

	}

	@Step("Click on View Report Link")
	public void clickOnViewReport_pollName(String pollName){
		try{
			WebElement ele=driver.findElement(By.xpath("//div[@title='"+pollName+"']/ancestor::td/following-sibling::td/a"));
			ReusableMethods.scrollIntoView(ele,driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,ele,30);
			ele.click();

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click on View Report", e);
		}

	}
	@Step("Click on Home button")
	public void HomeButton(){
		try{
			PublicCommon.waitForSec(20);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(home));
			PublicAdminCommons.scrollToElement(driver, home);
			getElement(home).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click Home Button", e);
		}

	}

	@Step("Click on Home button")
	public void CalendarEventsLink(){
		try{
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(CalendarEvents));
			PublicAdminCommons.scrollToElement(driver, CalendarEvents);
			getElement(CalendarEvents).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click CalendarEvents Link", e);
		}

	}



	public void clickOnViewReport_OpenBallot(String ballotName)
	{
		try {
			WebElement ele=driver.findElement(By.xpath("//span[text()='"+ballotName+"']/ancestor::tr/td[6]/span"));
			WaitStatementUtils.waitForElementToBeClickable(driver,ele,30);
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click on View Report Open Ballots Tab ", e);

		}


	}

	public WebElement CalendarTile(String value){
		return getElement(By.xpath("//span[text()='Starting Ballot "+value+"']"));
	}

	public WebElement FutureCalendarTile(String value){
		return getElement(By.xpath("//span[text()='Ballot "+value+" ending']"));
	}

	public By CalendarEventsDate(String value){
		return By.xpath("//td[@data-date='"+value+"']//a[contains(text(),'more')]");
	}

	public WebElement StartingBallotName(String value){
		return getElement(By.xpath("(//div[text()='Starting Ballot "+value+"'])[2]"));
	}

	public WebElement StartingFutureBallotName(String value){
		return getElement(By.xpath("(//div[text()='Ballot "+value+" ending'])[2]"));
	}

	public WebElement OneEventInDate(String value){
		return getElement(By.xpath("(//td[@data-date='"+value+"']//a[@tabindex='0'])[1]"));
	}

	@Step("Access Open And Closed Events")
	public void AccessOpenAndClosedEvents(String groupName, String EditBallotName, String IssueDate, String ClosingDate){
		try{
			PublicCommon.waitForSec(10);
			String cDate = PublicAdminCommons.getCurrentDateWithFormat("YYYY-MM-dd");
			if(PublicAdminCommons.isWebElementDisplayed(driver, CalendarEventsDate(IssueDate))){
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(CalendarEventsDate(IssueDate)));
				PublicAdminCommons.scrollToElement(driver, CalendarEventsDate(IssueDate));
				getElement(CalendarEventsDate(IssueDate)).click();
				PublicCommon.waitForSec(5);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.waitForElementToBeClickable(driver, StartingBallotName(EditBallotName));
				PublicAdminCommons.scrollToElement(driver, StartingBallotName(EditBallotName));
				String BallotN = StartingBallotName(EditBallotName).getText();
				// Verifying prefix Before Open Ballot and Open the ballot
				Assert.assertTrue((BallotN).contains("Starting Ballot"),"Starting Ballot Prefix is not there");
				StartingBallotName(EditBallotName).click();
				PublicCommon.waitForSec(5);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				// verify popup name and close
				WaitStatementUtils.waitForElementToBeClickable(driver, CalendarTile(EditBallotName));
				PublicAdminCommons.scrollToElement(driver, CalendarTile(EditBallotName));

				// Verify prefix
				String BallotNa = CalendarTile(EditBallotName).getText();
				Assert.assertTrue((BallotNa).contains("Starting Ballot"),"Starting Ballot Prefix is not there");

				if(Objects.equals(IssueDate, cDate)){

					// Verify Vote Link Exist
					if(PublicAdminCommons.isWebElementDisplayed(driver, VoteLink)){
						getElement(VoteLink).click();
						PublicCommon.waitForSec(30);
						ScreenshotUtil.takeScreenshotForAllure(driver);
						PublicAdminCommons.scrollToElement(driver, getElement(saveVote));
						getElement(saveVote).click();
						PublicCommon.waitForSec(35);
						ScreenshotUtil.takeScreenshotForAllure(driver);
						PublicAdminCommons.scrollToElement(driver, VerifyVoteStatus(EditBallotName));
						String voteStatus = VerifyVoteStatus(EditBallotName).getText();
						if(voteStatus == "Voted");
						CalendarEventsLink();
						WaitStatementUtils.waitForElementToBeClickable(driver, getElement(CalendarEventsDate(IssueDate)));
						PublicAdminCommons.scrollToElement(driver, CalendarEventsDate(IssueDate));
						getElement(CalendarEventsDate(IssueDate)).click();
						PublicCommon.waitForSec(5);
						ScreenshotUtil.takeScreenshotForAllure(driver);
						WaitStatementUtils.waitForElementToBeClickable(driver, StartingBallotName(EditBallotName));
						PublicAdminCommons.scrollToElement(driver, StartingBallotName(EditBallotName));
						String BallotNam = StartingBallotName(EditBallotName).getText();
						// Verifying prefix Before Open Ballot and Open the ballot
						Assert.assertTrue((BallotNam).contains("Starting Ballot"),"Starting Ballot Prefix is not there");
						StartingBallotName(EditBallotName).click();
						PublicCommon.waitForSec(5);
						ScreenshotUtil.takeScreenshotForAllure(driver);
					}

					// Verify Open Date
					String oDate = getElement(OpenDate).getText();
					Assert.assertTrue((oDate).contains(IssueDate),"Open Date is not there in title");

					// Verify Closing Date
					String closeDate = getElement(CloseDate).getText();
					Assert.assertTrue((closeDate).contains(ClosingDate),"Closing Date is not there in title");

					// Verify Group Name
					String gName = getElement(CEventsGroupName).getText();
					Assert.assertTrue((gName).contains(groupName),"GroupName is not there in title");
					ScreenshotUtil.takeScreenshotForAllure(driver);
					PublicAdminCommons.scrollToElement(driver, getElement(CloseTitlePopUp));
					getElement(CloseTitlePopUp).click();
					ScreenshotUtil.takeScreenshotForAllure(driver);
				}
				else {

					// Verify Open Date
					String oDate = getElement(fOpenDate).getText();
					Assert.assertTrue((oDate).contains(IssueDate),"Open Date is not there in title");

					// Verify Closing Date
					String closeDate = getElement(fCloseDate).getText();
					Assert.assertTrue((closeDate).contains(ClosingDate),"Closing Date is not there in title");

					// Verify Group Name
					String gName = getElement(fCEventsGroupName).getText();
					Assert.assertTrue((gName).contains(groupName),"GroupName is not there in title");
					ScreenshotUtil.takeScreenshotForAllure(driver);
					PublicAdminCommons.scrollToElement(driver, getElement(CloseTitlePopUp));
					getElement(CloseTitlePopUp).click();
					ScreenshotUtil.takeScreenshotForAllure(driver);
				}

			}
			else {
				WaitStatementUtils.waitForElementToBeClickable(driver, OneEventInDate(IssueDate));
				PublicAdminCommons.scrollToElement(driver, OneEventInDate(IssueDate));
				OneEventInDate(IssueDate).click();
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.waitForSec(15);
				// Verify prefix
				String PopTitle = getElement(PopUpTitle).getText();
				Assert.assertTrue((PopTitle).contains("Starting Ballot"),"Starting Ballot is not there in title");

				// Verify Open Date
				String oDate = getElement(OpenDate).getText();
				Assert.assertTrue((oDate).contains(IssueDate),"Open Date is not there in title");

				// Verify Closing Date
				String closeDate = getElement(CloseDate).getText();
				Assert.assertTrue((closeDate).contains(ClosingDate),"Closed Date is not there in title");

				// Verify Group Name
				String gName = getElement(CEventsGroupName).getText();
				Assert.assertTrue((gName).contains(groupName),"Group Name is not there in title");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicAdminCommons.scrollToElement(driver, getElement(CloseTitlePopUp));
				getElement(CloseTitlePopUp).click();
				ScreenshotUtil.takeScreenshotForAllure(driver);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to validate current date CalendarEvents", e);
		}
	}

	@Step("Access Open And Closed Events")
	public void AccessOpenAndClosedFutureEvents(String groupName, String EditBallotName, String IssueDate, String ClosingDate){
		try{
			PublicCommon.waitForSec(10);
			String cDate = PublicAdminCommons.getCurrentDateWithFormat("YYYY-MM-dd");
			if(PublicAdminCommons.isWebElementDisplayed(driver, CalendarEventsDate(ClosingDate))){
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(CalendarEventsDate(ClosingDate)));
				PublicAdminCommons.scrollToElement(driver, CalendarEventsDate(ClosingDate));
				getElement(CalendarEventsDate(ClosingDate)).click();
				PublicCommon.waitForSec(5);
				ScreenshotUtil.takeScreenshotForAllure(driver);

				WaitStatementUtils.waitForElementToBeClickable(driver, StartingFutureBallotName(EditBallotName));
				PublicAdminCommons.scrollToElement(driver, StartingFutureBallotName(EditBallotName));
				String BallotN = StartingFutureBallotName(EditBallotName).getText();
				// Verifying prefix Before Open Ballot and Open the ballot
				Assert.assertTrue((BallotN).contains("ending"),"suffix 'ending' is not there");
				StartingFutureBallotName(EditBallotName).click();
				PublicCommon.waitForSec(5);
				ScreenshotUtil.takeScreenshotForAllure(driver);

				// verify popup name and close
				WaitStatementUtils.waitForElementToBeClickable(driver, FutureCalendarTile(EditBallotName));
				PublicAdminCommons.scrollToElement(driver, FutureCalendarTile(EditBallotName));

				// Verify prefix
				String BallotNa = FutureCalendarTile(EditBallotName).getText();
				Assert.assertTrue((BallotNa).contains("ending"),"suffix ending is not there");

					// Verify Open Date
					String oDate = getElement(fOpenDate).getText();
					Assert.assertTrue((oDate).contains(IssueDate),"Open Date is not there in title");

					// Verify Closing Date
					String closeDate = getElement(fCloseDate).getText();
					Assert.assertTrue((closeDate).contains(ClosingDate),"Closing Date is not there in title");

					// Verify Group Name
					String gName = getElement(fCEventsGroupName).getText();
					Assert.assertTrue((gName).contains(groupName),"GroupName is not there in title");
					ScreenshotUtil.takeScreenshotForAllure(driver);
					PublicAdminCommons.scrollToElement(driver, getElement(CloseTitlePopUp));
					getElement(CloseTitlePopUp).click();
					ScreenshotUtil.takeScreenshotForAllure(driver);


			}
			else {
				WaitStatementUtils.waitForElementToBeClickable(driver, OneEventInDate(ClosingDate));
				PublicAdminCommons.scrollToElement(driver, OneEventInDate(ClosingDate));
				OneEventInDate(ClosingDate).click();
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.waitForSec(15);
				// Verify prefix
				String PopTitle = getElement(PopUpTitle).getText();
				Assert.assertTrue((PopTitle).contains("Ballot"),"Ballot is not there in title");

				// Verify Open Date
				String oDate = getElement(OpenDate).getText();
				Assert.assertTrue((oDate).contains(IssueDate),"Open Date is not there in title");

				// Verify Closing Date
				String closeDate = getElement(CloseDate).getText();
				Assert.assertTrue((closeDate).contains(ClosingDate),"Closed Date is not there in title");

				// Verify Group Name
				String gName = getElement(CEventsGroupName).getText();
				Assert.assertTrue((gName).contains(groupName),"Group Name is not there in title");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicAdminCommons.scrollToElement(driver, getElement(CloseTitlePopUp));
				getElement(CloseTitlePopUp).click();
				ScreenshotUtil.takeScreenshotForAllure(driver);

			}

		}
		catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to validate future date CalendarEvents", e);
		}
	}

        @Step("Click on Group Tab")
		public void groupTab(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(group));
			getElement(group).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click Group Tab", e);
		}

	}
	@Step("Click on ballot Tab")
	public void ballotTab(){
		try{
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ballot));
			PublicAdminCommons.scrollToElement(driver, getElement(ballot));
			getElement(ballot).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click ballot Tab", e);
		}

	}
	@Step("Click on open ballot Tab")
	public void openBallotTab(){
		try{
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(openBallot));
			getElement(openBallot).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click openBallot Tab", e);
		}

	}
	@Step("Verify vote column dropdown for the newly added vote role as Pending under members page and vote report page")
	public void VerifyVoteRole(String role){
		try{
			groupTab();
			memberTab();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			//Assert.assertTrue(voteStatus.equals(role),"Vote status should not matched");
			VerifyVoteRoleInVoteReportPage(role);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify vote role as Pending under members page and vote report page", e);
		}
	}

	@Step("Change the vote role under members page and verify in vote report page")
	public void changeTheVoteRole(String role){
		try{
			groupTab();
			memberTab();
			PublicCommon.selectValueInDropdown(getElement(voteSelection),role);
			driver.switchTo().alert().accept();
			VerifyVoteRoleInVoteReportPage(role);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify vote role as Pending under members page and vote report page", e);
		}
	}
	@Step("Click on poll Title")
	public void clickOnPollTitle(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ballotTitle));
             getElement(ballotTitle).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on poll title", e);
		}
	}

	@Step("Verify Group Admin should be able to access History tab")
	public void verifyHistoryTab(){
		try{
			PublicCommon.waitForSec(30);
			ReusableMethods.scrollIntoView(getElement(collaborationArea_Tab),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(collaborationArea_Tab),45);
			getElement(collaborationArea_Tab).click();
			ClickOnHistory();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Group Admin should be able to access History tab", e);
		}
	}
	@Step("Verify Schedule Online Meeting sub-tab/link should be available under the Collaboration Area tab ")
	public void scheduleMeetingTab(){
		try{
			PublicCommon.waitForSec(30);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(home),90);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(collaborationArea_Tab),90);
			PublicAdminCommons.scrollToElement(driver, collaborationArea_Tab);
			getElement(collaborationArea_Tab).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(scheduleOnlineMeeting),90);
			Assert.assertTrue(getElement(scheduleOnlineMeeting).isDisplayed(),"Schedule online meeting subTab avilable");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed Verify Schedule Online Meeting sub-tab/link should be available under the Collaboration Area tab", e);
		}
	}


	public WebElement getExportCSV(){
		return getElement(exportCSV);
	}
	public WebElement getExportXLSX(){
		return getElement(exportXLSX);
	}
	@Step("Verify user is able to see the previous vote answer under the Voting Note column on Vote report page")
	public void VerifyVotingNoteColumn(){
		try{
			PublicCommon.waitForSec(10);
			if(PublicCommon.isWebElementDisplayed(driver, affirmativeRadio)){
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(affirmativeRadio), 60);
				PublicAdminCommons.scrollToElement(driver, getElement(affirmativeRadio));
				PublicCommon.JSClick(getElement(affirmativeRadio),driver);
			}
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(saveVote),60);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveVote),60);
			ReusableMethods.scrollIntoView(getElement(saveVote),driver);
			getElement(saveVote).click();
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ballotTitle),90);
			PublicAdminCommons.scrollToElement(driver, getElement(ballotTitle));
			getElement(ballotTitle).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(VoteComment));
			PublicAdminCommons.scrollToElement(driver, getElement(VoteComment));
            getElement(VoteComment).sendKeys("Vote_Comment");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveVote),40);
			ReusableMethods.scrollIntoView(getElement(saveVote), driver);
			getElement(saveVote).click();
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(viewReport_openBallot),40);
			WaitStatementUtils.explicitWait(driver,getElement(viewReport_openBallot));
			getElement(viewReport_openBallot).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to user is able to see the previous vote answer under the ‘Voting Note’ column on Vote report page", e);
		}
	}



@Step("Verify user should be able to delete any attached files")
public void deleteFile(){
	try{
		getElement(deleteFileIcon).click();
        driver.switchTo().alert().accept();

	}catch (Exception e) {
		e.printStackTrace();
		SpecBuilderCommon.reportFailAssert("Failed to Verify user should be able to delete any attached files ", e);
	}

}
	@Step("Verify user should be able to delete any Discussions")
	public void deleteDiscussions(){
		try{
			clickOnDiscussions();
			getElement(deleteDiscussion).click();
			driver.switchTo().alert().accept();

		}catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify user should be able to delete any attached files ", e);
		}
	}
	public By draftTile = By.xpath("//div[text()='Drafts']//following::table//td[2]");
    public By deleteDraft = By.xpath("//button[text()='Delete']");
	public By deleteDrafts = By.xpath("//a[text()='Delete Drafts']");
	public By deleteBalletsTab = By.xpath("//a[text()='Manage Ballots']");
	public By deleteBallet = By.xpath("//a[text()='Delete Ballot']");
	public By clickOnOpen = By.xpath("//div[@class='placeholder'][1]");
	public By selectBallotToEdit = By.xpath("//select[@title='Select Ballot']");
	public By clickBallotToEdit = By.xpath("//select[contains(@title,'Quality of Leather')]");
	public By ballotsTab = By.xpath("//a[text()='Ballots']");


	@Step("Verify user should be able to click on Drafts")
	public void clickOnDrafts(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(drafts),60);
			PublicAdminCommons.scrollToElement(driver, getElement(drafts));
			getElement(drafts).click();


		}catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify user should be able to delete any attached files ", e);
		}
	}

	@Step("Verify user should be able to delete any Drafts and Comments")
	public void deleteDraftsAndComments(){
		try{
			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(drafts),60);
			PublicAdminCommons.scrollToElement(driver, getElement(drafts));
			getElement(drafts).click();
			PublicCommon.waitForSec(15);
			PublicAdminCommons.scrollToElement(driver, getElement(draftTile));
			getElement(draftTile).click();
			PublicCommon.waitForSec(15);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(deleteDraftIcon),60);
			PublicAdminCommons.scrollToElement(driver, getElement(deleteDraftIcon));
			getElement(deleteDraftIcon).click();
			PublicCommon.waitForSec(10);
			driver.switchTo().alert().accept();
			ScreenshotUtil.takeScreenshotForAllure(driver);

		}catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify user should be able to delete drafts and comments", e);
		}
	}


	@Step("Create new draft in new Current Group")
	public String createDraft(){
		String draftName=null;
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(drafts),60);
			PublicAdminCommons.scrollToElement(driver, getElement(drafts));
			getElement(drafts).click();
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(UploadDraftS),60);
			PublicAdminCommons.scrollToElement(driver, getElement(UploadDraftS));
			getElement(UploadDraftS).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(NewDraftName),60);
			PublicAdminCommons.scrollToElement(driver, getElement(NewDraftName));
			getElement(UploadDraftS).click();
			draftName="TestDraft"+RandomStringUtils.getRandomString(4);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(NewDraftName),60);
			PublicAdminCommons.scrollToElement(driver, getElement(NewDraftName));
			getElement(NewDraftName).sendKeys(draftName);
			closePopUp();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(clickOnOpen),60);
			PublicAdminCommons.scrollToElement(driver, getElement(clickOnOpen));
			getElement(clickOnOpen).click();
			PublicCommon.waitForSec(5);
			adminAreaPage.fileUpload();

		}catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify user should be able to delete any attached files ", e);
		}
        return draftName;
    }


	@Step("Create new Ballots in new Current Group")
	public List<String> CreateNewBallotUsingExistGroup(){
		ArrayList<String> values = new ArrayList<>();
		String groupName = null;
		String EditedBallotName = null;
		String clDate = null;
		String fDate = null;


		try{
			PublicCommon.waitForSec(30);
			closePopUp();

			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(manageButton));
			PublicAdminCommons.scrollToElement(driver, getElement(manageButton));
			getElement(manageButton).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(manageBallotsTab));
			PublicAdminCommons.scrollToElement(driver, getElement(manageBallotsTab));
			getElement(manageBallotsTab).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicCommon.waitForSec(15);
			PublicAdminCommons.scrollToElement(driver, getElement(SelectBallotsGroup));
			PublicAdminCommons.selectValueFromDropdownByIndex(driver, SelectBallotsGroup, 4);
			// get group name index 0
			groupName = getElement(SelectBallotsGroup).getAttribute("title");
			values.add(groupName);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// New Ballet Name Edit
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(NewBalletName),30);
			PublicAdminCommons.scrollToElement(driver, getElement(NewBalletName));
			getElement(NewBalletName).click();
			// get group name index 1
			EditedBallotName = ("BallotName " + RandomStringUtils.getRandomString(3));
			values.add(EditedBallotName);
			getElement(NewBalletName).clear();
			getElement(NewBalletName).sendKeys(EditedBallotName);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Choose Ballot Closing Date
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(NewBalletDate),30);
			PublicAdminCommons.scrollToElement(driver, getElement(NewBalletDate));
			// get group name index 2 Note: dDays is mandatory to give always +1 of fDate, if clDate is 2 fDate is 3

			clDate = PublicAdminCommons.getCurrentDateWithFormat("YYYY-MM-dd");
			values.add(clDate);  // index 2

			String cloDate = PublicAdminCommons.getExpectedDate("MM/dd/YYYY",2);		// for application input

			fDate = PublicAdminCommons.getExpectedDate("YYYY-MM-dd",3);
			values.add(fDate);	// index 3

			getElement(NewBalletDate).click();
			getElement(NewBalletDate).clear();
			getElement(NewBalletDate).sendKeys(cloDate);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Enter Percentages Affirmative
			PublicAdminCommons.scrollToElement(driver, getElement(No_DoNotSendReminder));
			enterPercentagesAffirmative();

			// Select No Do Not Send Reminder(s)
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(No_DoNotSendReminder),30);
			PublicAdminCommons.scrollToElement(driver, getElement(No_DoNotSendReminder));
			getElement(No_DoNotSendReminder).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Enter Ballot#1 Name BallotItemName
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(BallotItemName),30);
			PublicAdminCommons.scrollToElement(driver, getElement(BallotItemName));
			getElement(BallotItemName).click();
			String BallotItem = ("BallotItem " + RandomStringUtils.getRandomString(4));
			getElement(BallotItemName).clear();
			getElement(BallotItemName).sendKeys(BallotItem);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Verify Select Ballot Item #1 Choices is Disabled
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(UploadFiles),30);
			PublicAdminCommons.scrollToElement(driver, getElement(UploadFiles));
			if(!getElement(UploadFiles).isEnabled()){
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}

			// Upload file
			//adminAreaPage.fileUpload();

			// Click on Review Ballot
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(balletReview),30);
			PublicAdminCommons.scrollToElement(driver, getElement(balletReview));
			getElement(balletReview).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Click on Submit Ballot
			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(submitDraft),30);
			PublicAdminCommons.scrollToElement(driver, getElement(submitDraft));
			getElement(submitDraft).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);


		}catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify user should be able to delete any attached files ", e);
		}
		return values;
	}


	public By SetCustomDate = By.xpath("//label[text()='Set Custom Date']");
	public By EnterIssueDate = By.xpath("//input[@id='rdp-form-control-issueDate']");
	@Step("Create new Ballots in new Current Group")
	public List<String> CreateNewBallotWithFutureDateUsingExistGroup(){
		ArrayList<String> values = new ArrayList<>();
		String groupName = null;	// index 0
		String EditedBallotName = null; // index 1
		String customDate = null; // index 2
		String fDate = null;	 // index 3

		try{

			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(home));
			PublicAdminCommons.scrollToElement(driver, getElement(home));
			getElement(home).click();
			PublicCommon.waitForSec(30);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(manageButton));
			PublicAdminCommons.scrollToElement(driver, getElement(manageButton));
			getElement(manageButton).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(manageBallotsTab));
			PublicAdminCommons.scrollToElement(driver, getElement(manageBallotsTab));
			getElement(manageBallotsTab).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicCommon.waitForSec(15);
			PublicAdminCommons.scrollToElement(driver, getElement(SelectBallotsGroup));
			PublicAdminCommons.selectValueFromDropdownByIndex(driver, SelectBallotsGroup, 4);
			// get group name index 0
			groupName = getElement(SelectBallotsGroup).getAttribute("title");
			values.add(groupName);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// New Ballet Name Edit
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(NewBalletName),30);
			PublicAdminCommons.scrollToElement(driver, getElement(NewBalletName));
			getElement(NewBalletName).click();
			// get group name index 1
			EditedBallotName = ("BallotName " + RandomStringUtils.getRandomString(3));
			values.add(EditedBallotName);
			getElement(NewBalletName).clear();
			getElement(NewBalletName).sendKeys(EditedBallotName);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Set Custom Date
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(SetCustomDate),30);
			PublicAdminCommons.scrollToElement(driver, getElement(SetCustomDate));
			getElement(SetCustomDate).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Enter Custom Date index 2
			customDate = PublicAdminCommons.getExpectedDate("YYYY-MM-dd",+1);
			values.add(customDate);
			String issueDate = PublicAdminCommons.getExpectedDate("MM/dd/YYYY",+1);
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(EnterIssueDate),30);
			PublicAdminCommons.scrollToElement(driver, getElement(EnterIssueDate));
			getElement(EnterIssueDate).click();
			getElement(EnterIssueDate).clear();
			getElement(EnterIssueDate).sendKeys(issueDate);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Choose Ballot Closing Date index 3
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(NewBalletDate),30);
			PublicAdminCommons.scrollToElement(driver, getElement(NewBalletDate));
			// get group name index 2 Note: dDays is mandatory to give always +1 of fDate, if eDate is 2 fDate is 3
			String eDate = PublicAdminCommons.getExpectedDate("MM/dd/YYYY",2);
			fDate = PublicAdminCommons.getExpectedDate("YYYY-MM-dd",3);
			values.add(fDate);
			getElement(NewBalletDate).click();
			getElement(NewBalletDate).clear();
			getElement(NewBalletDate).sendKeys(eDate);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Enter Percentages Affirmative
			PublicAdminCommons.scrollToElement(driver, getElement(No_DoNotSendReminder));
			enterPercentagesAffirmative();

			// Select No Do Not Send Reminder(s)
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(No_DoNotSendReminder),30);
			PublicAdminCommons.scrollToElement(driver, getElement(No_DoNotSendReminder));
			getElement(No_DoNotSendReminder).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Enter Ballot#1 Name BallotItemName
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(BallotItemName),30);
			PublicAdminCommons.scrollToElement(driver, getElement(BallotItemName));
			getElement(BallotItemName).click();
			String BallotItem = ("BallotItem " + RandomStringUtils.getRandomString(4));
			getElement(BallotItemName).clear();
			getElement(BallotItemName).sendKeys(BallotItem);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Verify Select Ballot Item #1 Choices is Disabled
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(UploadFiles),30);
			PublicAdminCommons.scrollToElement(driver, getElement(UploadFiles));
			if(!getElement(UploadFiles).isEnabled()){
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}

			// Upload file
			//adminAreaPage.fileUpload();

			// Click on Review Ballot
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(balletReview),30);
			PublicAdminCommons.scrollToElement(driver, getElement(balletReview));
			getElement(balletReview).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Click on Submit Ballot
			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(submitDraft),30);
			PublicAdminCommons.scrollToElement(driver, getElement(submitDraft));
			getElement(submitDraft).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);


		}catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify user should be able to delete any attached files ", e);
		}
		return values;
	}


	@Step("Click on DeleteDrafts")
	public void clickOnDeleteDrafts(){
		PublicCommon.waitForSec(10);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(deleteDrafts));
		getElement(deleteDrafts).click();
	}
	@Step("Click on DeleteBalletsTab")
	public void clickOnDeleteBalletsTab(){
		PublicCommon.waitForSec(10);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(deleteBalletsTab),90);
		PublicAdminCommons.scrollToElement(driver, getElement(deleteBalletsTab));
		getElement(deleteBalletsTab).click();
	}
	@Step("Click on DeleteBallet")
	public void clickOnDeleteBallet(){
		PublicCommon.waitForSec(10);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(deleteBallet),90);
		PublicAdminCommons.scrollToElement(driver, getElement(deleteBallet));
		getElement(deleteBallet).click();
	}



	@Step("Click on Discussions")
	public void clickOnDiscussions(){
		PublicCommon.waitForSec(10);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(discussions));
		PublicAdminCommons.scrollToElement(driver, getElement(discussions));
		getElement(discussions).click();
	}
	@Step("Click on Files")
	public void clickOnFiles(){
		PublicCommon.waitForSec(5);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(files));
		PublicAdminCommons.scrollToElement(driver, getElement(files));
		PublicCommon.waitForSec(5);
		getElement(files).click();
	}
	@Step("Edit the File Name")
	public void editFileName(){
		PublicCommon.waitForSec(5);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(editFileIcon));
		PublicAdminCommons.scrollToElement(driver, getElement(editFileIcon));
		getElement(editFileIcon).click();
		getElement(fileName).clear();
		getElement(fileName).sendKeys("Sample.txt_edited");
		getElement(saveChanges_editFile).click();

	}
	@Step("Click on save")
	public void save(){
		/*if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(closePopUp),20))
		{
			getElement(closePopUp).click();
		}*/
		PublicAdminCommons.scrollToElement(driver, save);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(save));
		getElement(save).click();
	}

	@Step("Click on popup")
	public void closePopUp(){
		if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(closePopUp),60))
		{
			getElement(closePopUp).click();
		}
	}
	@Step("Click on manage Ballots")
	public void clickOnManageBallots() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(manageBallots), 30);
			getElement(manageBallots).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Click on Manage Ballots Tab", e);
		}
	}
	@Step("Click on Edit Ballot Details")
	public void clickOnEditBallots(){
		PublicCommon.waitForSec(10);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(editBallotDetails));
		PublicAdminCommons.scrollToElement(driver, getElement(editBallotDetails));
		getElement(editBallotDetails).click();
	}

	@Step("Select Ballot to Edit")
	public void selectBallotEdit() throws IOException {
		PublicCommon.waitForSec(10);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectBallotToEdit));
		PublicAdminCommons.scrollToElement(driver, getElement(selectBallotToEdit));
		/*getElement(selectBallotToEdit).click();
		getElement(clickBallotToEdit).click();*/
		PublicCommon.selectValueInDropdownbyIndex(getElement(selectBallotToEdit),1);
		ScreenshotUtil.takeScreenshotForAllure(driver);
	}
	@Step("Click on Edit")
	public void clickOnEdit_draftComment(){
		PublicCommon.waitForSec(5);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(edit_draftComment));
		getElement(edit_draftComment).click();
	}
	@Step("Edit the comment with new comment")
	public void Edit_draftComment(){
		PublicCommon.waitForSec(5);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(editComment));
		getElement(editComment).clear();
		getElement(editComment).sendKeys("Sample Draft comment Edited");
	}

	public By drafts = By.xpath("//a[text()='Drafts']");
	public By UploadDraftS = By.xpath("//a[text()='Upload Draft']");
	public By NewDraftName = By.xpath("//input[@class='form-control form-control']");
	public By NewBalletName = By.xpath("//input[@data-testid='ballot-inputField']");
	public By NewBalletDesc = By.xpath("//textarea[@class='form-control form-control']");
	public By NewBalletDate = By.xpath("//input[@id='rdp-form-control-closingDate']");
	public By percentagesAffirmative = By.xpath("//div[contains(text(),'Percentage')]//input");
	//div[contains(text(),'Percentages Affirmative')]//input
	public By UploadFiles = By.xpath("//button[contains(text(),'Upload File(s)')]");
	public By BallotItemChoiceOne = By.xpath("//input[@value='Affirmative']");
	public By balletReview = By.xpath("//button[@data-testid='review-check']");
	public By ballets = By.xpath("//a[text()='Ballots']");
	public By ShowAllBallots = By.xpath("//a[text()='Show All Ballots']");
	public By newBallet = By.xpath("//a[text()='New Ballot']");
	public By No_DoNotSendReminder = By.xpath("//label[text()='No: Do Not Send Reminder(s)']");
	public By Yes_SendReminder = By.xpath("//label[text()='Yes: Send Reminder(s)']");
	public By Reminder1 = By.xpath("//label[text()='Reminder 1:']/../input");
	public By Reminder2 = By.xpath("//label[text()='Reminder 2:']/../input");
	public By Reminder3 = By.xpath("//label[text()='Reminder 3:']/../input");
	public By BallotItemName = By.xpath("//input[@data-testid='Poll-Name']");
	public By discussion = By.xpath("//a[text()='Discussions']");
	public By files = By.xpath("//a[text()='Files']");
	public By reviewDraft = By.xpath("//button[contains(text(),'Review Submission')]");
	public By submitDraft = By.xpath("//button[contains(text(),'Submit ')]");
	public By ExistBallotNameLink = By.xpath("//li[@class='breadcrumb-item astm-type-body--lead rd-header-row']");
	public By EditedBallotNameLink = By.xpath("//li[@class='breadcrumb-item']");
	public By ReturnToAllBallots = By.xpath("//a[text()='Return to All Ballots']"); ////a[contains(text(),'All Ballots')]
	public By Recirc = By.xpath("//div[@class='display badge astm-badge bg-secondary']");
	public By VoteManagement = By.xpath("//a[contains(text(),'Vote Management')]");


	@Step("Verify that Super Admin is able to edit group, drafts, polls, discussions and files")
	public void VerifyEditGroup(AdminAreaPage admin){
		try{
			PublicCommon.waitForSec(10);
			PublicAdminCommons.scrollToElement(driver, getElement(collaborationArea_Tab));
			getElement(collaborationArea_Tab).click();
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,SPBLoadingIcon);
			ClickOnMember();
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,SPBLoadingIcon);
			PublicAdminCommons.waitForSec(10);
			addOrRemoveMembers();
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(drafts),45);
			getElement(drafts).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(replaceDrafts),45);
			clickOnReplaceDrafts();
			PublicCommon.selectValueInDropdownbyIndex(getElement(selectSubGroup_replaceDraft),1);
			admin.fileUpload();
			ReusableMethods.ScrollIntoView(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewDraft),45));
			getElement(reviewDraft).click();
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitDraft),45));
			getElement(submitDraft).click();
			clickOnEdit_draftComment();
			Edit_draftComment();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			save();
			clickOnPolls();
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,SPBLoadingIcon);
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(editPoll),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(editPoll),20);
			getElement(editPoll).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.selectValueInDropdownbyIndex(getElement(selectPoll),1);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveChanges));
			getElement(saveChanges).click();
			PublicCommon.waitForSec(10);

			clickOnDiscussions();
			clickOnEdit_draftComment();
			getElement(comment_discussions).clear();
			getElement(comment_discussions).sendKeys("Comment added_AfterEdit");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			save();

			clickOnFiles();
			editFileName();
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify that Super Admin is able to edit group, drafts, polls, discussions and files", e);
		}
	}

	@Step("Verify that Super Admin is able to edit group, drafts, polls, discussions and files")
	public void EditGroup(AdminAreaPage admin){
		try{
			// Edit Draft
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(drafts));
			PublicAdminCommons.scrollToElement(driver, getElement(drafts));
			getElement(drafts).click();
			clickOnReplaceDrafts();
			PublicCommon.selectValueInDropdownbyIndex(getElement(selectSubGroup_replaceDraft),1);
			admin.fileUpload();
			ReusableMethods.ScrollIntoView(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewDraft),20));
			getElement(reviewDraft).click();
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitDraft),20));
			getElement(submitDraft).click();
			clickOnEdit_draftComment();
			Edit_draftComment();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			save();

			// Edit Ballot
			ballotTab();
			clickOnEditBallots();
			selectBallotEdit();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveChanges));
			PublicAdminCommons.scrollToElement(driver, getElement(saveChanges));
			getElement(saveChanges).click();
			PublicCommon.waitForSec(1);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Edit Discussion
			clickOnDiscussions();
			clickOnEdit_draftComment();
			getElement(comment_discussions).clear();
			getElement(comment_discussions).sendKeys("Comment added_AfterEdit");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			save();
			ScreenshotUtil.takeScreenshotForAllure(driver);

			// Edit Files
			clickOnFiles();
			editFileName();
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify that Super Admin is able to edit group, drafts, polls, discussions and files", e);
		}
	}

	@Step("click on Submit Ballot")
	public void submitBallot(){
		try {
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(submitDraft),30);
			PublicAdminCommons.scrollIntoView(driver, getElement(submitDraft));
			getElement(submitDraft).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		}catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Validate Submit ballot", e);
		}
	}


	@Step("click on review Ballot")
	public void reviewBallot(){
		try {
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(balletReview),30);
			PublicAdminCommons.scrollIntoView(driver, getElement(balletReview));
			getElement(balletReview).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Validate Review ballot", e);
		}
	}

	@Step("Click On polls")
	public void clickOnPolls(){
		try{
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(polls));
			PublicAdminCommons.scrollToElement(driver, getElement(polls));
           	getElement(polls).click();
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Click polls tab", e);
		}
	}



	@Step("Verify vote and comment option when the vote role is : {role}")
	public void VerifyVoteAndComment(String role){
		try{
			openBallotTab();
			getElement(ballotTitle).click();
			switch(role) {
				case "Pending":
					Assert.assertTrue(getElement(commentsSection).isDisplayed() && getElements(voteSection).size()==0,"Vote option is Available for"+role);
					break;
				case "Official Voter":
					Assert.assertTrue(getElement(commentsSection).isDisplayed() && getElement(voteSection).isDisplayed(),"Vote and Comment options is not Available for: "+role);
					break;
				case "Non-Official Voter":
					Assert.assertTrue(getElement(commentsSection).isDisplayed() && getElement(voteSection).isDisplayed(),"Vote and Comment options is not Available for:"+role);
					break;
				case "Observer":
					Assert.assertTrue(getElement(commentsSection).isDisplayed() && getElements(voteSection).size()==0,"Vote option is Available for: "+role );
					break;
				case "Non-voter":
					Assert.assertTrue(getElements(commentsSection).size()==0 &&  getElements(voteSection).size()==0,"Both vote and Comment options is Available for:"+role);
					break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Verify vote and comment option for: "+role, e);
		}
	}
	@Step("Verify vote role as {role} under role column in vote report page")
	public void VerifyVoteRoleInVoteReportPage(String role){
		try{
			ballotTab();
			openBallotTab();
			getElement(viewReport_openBallot).click();
			String roleStatus = getElement(role_reportSection).getText();
			Assert.assertTrue(roleStatus.equals(role),"Role status should not matched");
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify vote role in vote report page", e);
		}
	}

	public By deleteIcon(String value){
		return By.xpath("//span[text()='"+value+"']//ancestor::tr//button");
	}
	public WebElement RecircLinkInHomeBallotTable(String value){
		return getElement(By.xpath("//div[text()='"+value+"']/../span"));
	}

	public WebElement ShowAllBallotTable(String value){
		return getElement(By.xpath("//td[text()='"+value+"']"));
	}

	public WebElement RecircLinkInHomeBallotTableClick(String value){
		//return By.xpath("//span[text()='"+value+"']//ancestor::tr//button");
		getElement(By.xpath("//div[text()='"+value+"']/../span")).click();
		return null;
	}
	//div[@title='Groupfux Edited']/..//span
	public By RecircInReturnToAllBallots(String value){
		return By.xpath("//div[@title='"+value+"']/..//span");
	}

	public WebElement ViewReportLinkInHomeBallotTableClick(String value){
		getElement(By.xpath("//span[text()='"+value+"']/parent::td/following-sibling::td/span[text()='View Report']")).click();
		return null;
	}

	public WebElement VerifyVoteStatus(String value){
		getElement(By.xpath("(//span[text()='"+value+"']/parent::td/following-sibling::td/span[text()='View Report']/parent::td/following-sibling::td/span)[1]")).click();
		return null;
	}


	public WebElement RecircTextInBallotReports(String value){
		return getElement(By.xpath("//span[text()='"+value+"']/../div"));
	}

	public List<WebElement> getDeleteDrafts(){
		return  getElements(By.xpath("//button[text()='Delete']"));
	}

	public By deleteRowIcon(String value){
		return By.xpath("//span[text()='"+value+"']");
	}
    public By yes = By.xpath("//button[text()='Yes']");
	public By ok = By.xpath("//button[text()='OK']");
	@Step("Verify user is able to delete the group")
	public void DeleteTheGroup(String group){
		try{
			ClickOnManage();
			ClickOnDeleteGroupTab();
			clickOnMethod("Click on Delete Icon",getElement(deleteIcon(group)));
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(yes));
			clickOnMethod("Click on Delete Icon",getElement(yes));
			//WaitStatementUtils.explicitWaitForVisibility(driver,getElement(ok));
			//PublicCommon.JSClick(getElement(ok),driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Delete the group", e);
		}
	}
	@Step("Verify user is able to delete the Collaboration area")
	public void DeleteCollaborationArea(String group){
		try{
			ClickOnManage();
			ClickOnDeleteCollaborationAreaTab();
			clickOnMethod("Click on Delete Icon",getElement(deleteIcon(group)));
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(yes));
			PublicCommon.JSClick(getElement(yes),driver);
			//clickOnMethod("Click on Delete Icon",getElement(yes));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(15);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Delete the Collaboration area", e);
		}
	}

	@Step("Verify user is able to restore deleted group")
	public void reStoreTheGroup(String group){
		try{
			PublicCommon.waitForSec(10);
			ClickOnSpecBuilderAdmin();
			ClickOnArchivedGroups();
			PublicCommon.waitForSec(5);
			PublicCommon.selectValueInDropdown(getElement(restoreGroup),group);
			clickOnMethod("Click on restoreGroup",getElement(restoreGroupButton));
			PublicCommon.waitForSec(10);
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Delete the group", e);
		}
	}
	public By showAllGroups = By.xpath("//a[text()='Show All Groups']");
	public By hierarchicalGroup(String value){
		return By.xpath("//span[text()='"+value+"']//ancestor::tr//i");
	}
	public By groupsUnderAllGroups(String value){
		return By.xpath("//span[text()='"+value+"']");
	}


	@Step("Verify user is able to delete the group with sub group")
	public void DeleteGroup(String group){
		try{
			PublicAdminCommons.scrollToElement(driver, deleteRowIcon(group));
			clickOnMethod("Click on Delete Row",getElement(deleteRowIcon(group)));
			//getElement(yes).click();
			//getElement(ok).click();
			ClickOnManage();
			ClickOnDeleteGroupTab();
			clickOnMethod("Click on Delete Icon",getElement(deleteIcon(group)));
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(yes));
			clickOnMethod("Click on Delete Icon",getElement(yes));

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Delete the group", e);
		}
	}


	@Step("Verify user is able to delete any archived group.")
	public void deleteArchivedGroup(){
		try{
			HomeButton();
			ClickOnManage();
			ClickOnSpecBuilderAdmin();
			ClickOnArchivedGroups();
			PublicCommon.selectValueInDropdownbyIndex(getElement(deleteArchiveGroup),1);
			getElement(delete).click();
			getElement(delete_ModalFooter).click();
			PublicCommon.waitForSec(10);
			//PublicAdminCommons.waitElementToDisappearFromScreen(driver,getElement(delete_ModalFooter));
			String successMsg = driver.switchTo().alert().getText();
			Assert.assertTrue(successMsg.contains("The Group has been removed successfully."),"Successfully deleted the group");
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify the archived group is able to delete", e);
		}
	}

	@Step("Verify  ")
	public void verifyGroupUnderAllGroups_hierarchy(String group){
		try{
			HomeButton();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(showAllGroups));
			PublicAdminCommons.scrollToElement(driver, showAllGroups);
			closePopUp();
			getElement(showAllGroups).click();
			//ReusableMethods.scrollIntoView(getElement(hierarchicalGroup(group)), driver);
			//Assert.assertTrue(getElement(hierarchicalGroup(group)).isDisplayed(),"Not able to View the group under all groups section");

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify the group is available in groups section", e);
		}
	}
	@Step("Verify group is available in all Groups section after restoring the groups ")
	public void verifyGroupUnderAllGroups(String group){
		try{
			HomeButton();
			// Close the bottom blue color popup
			closePopUp();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(showAllGroups));
			PublicAdminCommons.scrollToElement(driver, showAllGroups);
			getElement(showAllGroups).click();
			ReusableMethods.scrollIntoView(getElement(groupsUnderAllGroups(group)), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(getElement(groupsUnderAllGroups(group)).isDisplayed(),"Not able to View the group sub-group hierarchy");

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify the group sub-group hierarchy", e);
		}
	}

	@Step("Verify user is able to view most current five activities in Recent activity widget")
	public void RecentActivitiesWidget(){
		try{
			PublicCommon.waitForSec(20);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(firstGroup),30);
			int recentActivitiesCount = getElements(recentActivitiesWidgetCount).size();
			Assert.assertTrue(recentActivitiesCount==5,"Recent activities count is mismatched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click Home Button", e);
		}

	}
	public By help = By.xpath("//div[text()='Help']");
	public By contactUs = By.xpath("//div[text()='Contact Us']");
	@Step("Verify the user should be redirected to the Help and Support page while click on help button")
	public void verifyHelpFunctionality(){
		try{
			WaitStatementUtils.waitForElementStaleness(driver,getElement(help),40);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(help),110);
			getElement(help).click();
			/*WaitStatementUtils.explicitWaitForVisibility(driver,getElement(contactUs));
			Assert.assertTrue(getElement(contactUs).isDisplayed(),"Navigate to ContactUs page");*/
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(home).click();
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify the user should be redirected to the Help and Support page", e);
		}

	}

	@Step("Verify the user should be redirected to the Help and Support page while click on help button")
	public void clickShowAllCollaborationAreas(){
		try{
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,SPBLoadingIcon);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ShowAllCollaborationAreas),110);
			PublicAdminCommons.scrollToElement(driver, getElement(ShowAllCollaborationAreas));
			getElement(ShowAllCollaborationAreas).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify the user should be redirected to the Help and Support page", e);
		}

	}


	@Step("Verify user is able to view Group Activity Tables for Group on History page")
	public void GroupActivityTableOnHistoryPage(){
		try{
			clickOnMethod("Click on first group",getElement(firstGroup));
			PublicCommon.waitForSec(20);
			groupTab();
			clickOnMethod("Click on History Tab",getElement(history));
			PublicCommon.waitForSec(20);
			Assert.assertTrue(getElement(groupHistory).isDisplayed(),"Not able to see the group history under history tab");

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to see the group history under history tab", e);
		}
	}

	@Step("Verify User Administration sub-menu available in the SpecBuilder Admin tab under Manage area")
	public void UserAdministrationSubMenu(){
		try{
			ClickOnManage();
			PublicCommon.waitForSec(30);
			ClickOnSpecBuilderAdmin();
			Assert.assertTrue(getElement(userAdminisrator).isDisplayed(),"Not able to see the User Administration Sub-Menu under SpecBuilder Admin Tab");
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to see the group history under history tab", e);
		}
	}
	public By member = By.xpath("//a[text()='Members']");
	public By groupMembers = By.xpath("//h3[text()=' Members']");
	@Step("Click on Member Tab")
	public void ClickOnMember(){
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(member),20);
		clickOnMethod("Click on Member Tab",getElement(member));
	}
	@Step("Click on History Tab")
	public void ClickOnHistory(){
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(history),40);
		clickOnMethod("Click on History Tab",getElement(history));
	}
	@Step("Click on Ballots Tab")
	public void ClickOnBallots(){
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ballots));
		clickOnMethod("Click on ballots Tab",getElement(ballots));
	}
	@Step("Click on ballotReports Tab")
		public void ClickOnBallotReports(){
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ballotReports));
		clickOnMethod("Click on ballot reportsTab",getElement(ballotReports));
		PublicCommon.waitForSec(10);
	}
	@Step("Verify User can Access Member and history pages")
	public void memberAndHistoryPages(){
		try{
			PublicCommon.waitForSec(10);
			clickOnMethod("Click on first group",getElement(firstGroup));
			PublicCommon.waitForSec(10);
			ClickOnHistory();
			PublicCommon.waitForSec(10);
			Assert.assertTrue(getElement(groupHistory).isDisplayed(),"Not able to see the group history under history tab");
			ClickOnMember();
			PublicCommon.waitForSec(10);
			Assert.assertTrue(getElement(groupMembers).isDisplayed(),"Not able to Navigate to members Tab");
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Navigate MEMBER and history tabs", e);
		}
	}
	@Step("Verify User able to see Export .CSV/.xlsx File under Ballot Reports")
	public void ballotReports(){
		try{
			ClickOnBallots();
			ClickOnBallotReports();

			if(getElements(noBallotReportsFound).size()==0){
				getElement(viewReport).click();
               Assert.assertTrue(getElement(csv).isDisplayed() &&getElement(xlsx).isDisplayed(),"Not Able to See the .CSV and .xlsx Export option");
			}
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Export csv and xlsx files under ballot reports", e);
		}
	}

	@Step("Click on manage Button")
	public void ClickOnManage(){
		try {
			PublicCommon.waitForSec(5);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(manage));
			PublicAdminCommons.scrollToElement(driver, manage);
			clickOnMethod("Click On manage Button", getElement(manage));
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to click on Manage Button",e);
		}
	}
	@Step("Click on Delete Group")
	public void ClickOnDeleteGroupTab(){
		PublicCommon.waitForSec(5);
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(deleteGroup));
		PublicAdminCommons.scrollToElement(driver, deleteGroup);
		clickOnMethod("Click On Delete Group",getElement(deleteGroup));
		PublicCommon.waitForSec(5);
	}
	@Step("Click on Delete Collaboration area")
	public void ClickOnDeleteCollaborationAreaTab(){
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(deleteCollaborationArea));
		PublicAdminCommons.scrollToElement(driver, deleteCollaborationArea);
		PublicCommon.JSClick(getElement(deleteCollaborationArea),driver);
		PublicCommon.waitForSec(15);
	}
	@Step("Click on edit Group")
	public void ClickOnEditGroup(){
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(editGropu));
		PublicAdminCommons.scrollToElement(driver, editGropu);
		clickOnMethod("Click On manage Button",getElement(editGropu));
	}
		@Step("Select the Group from Select Group to Edit drop down")
	public void selectTheGroup_EditGroup(String name) throws IOException {
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectGroup_editGroup),60);
		PublicAdminCommons.scrollToElement(driver, selectGroup_editGroup);
		PublicCommon.selectValueInDropdown(getElement(selectGroup_editGroup), name);
		ScreenshotUtil.takeScreenshotForAllure(driver);
	}

	@Step("To Validate External Group ID filed")
	public void externalGroupIdErrorValidation() throws IOException {
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(maxCount_externalGroupId),90);
		PublicAdminCommons.scrollToElement(driver, getElement(maxCount_externalGroupId));
		//Assert.assertTrue(getElement(maxCount_externalGroupId).isDisplayed() && getElement(remaining_externalGroupId(50)).isDisplayed(),"Maximum 50 characters not allowed");
		getElement(externalGroupId).clear();
		String errValidation = "Error_Valid@Mail= " + RandomStringUtils.getRandomString(4);
		getElement(externalGroupId).sendKeys(errValidation);
		//Assert.assertTrue(getElement(maxCount_externalGroupId).isDisplayed() && getElement(remaining_externalGroupId(35)).isDisplayed(),"Maximum and remaining characters are mismatched");
		ScreenshotUtil.takeScreenshotForAllure(driver);
	}

	@Step("To Validate External Group ID filed")
	public void externalGroupIdValidation() throws IOException {
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(maxCount_externalGroupId),90);
		PublicAdminCommons.scrollToElement(driver, getElement(maxCount_externalGroupId));
		//Assert.assertTrue(getElement(maxCount_externalGroupId).isDisplayed() && getElement(remaining_externalGroupId(50)).isDisplayed(),"Maximum 50 characters not allowed");
		getElement(externalGroupId).clear();
		String ExternalGroupID = "External-GroupID_" + RandomStringUtils.getRandomString(4);
		getElement(externalGroupId).sendKeys(ExternalGroupID);
		//Assert.assertTrue(getElement(maxCount_externalGroupId).isDisplayed() && getElement(remaining_externalGroupId(35)).isDisplayed(),"Maximum and remaining characters are mismatched");
		ScreenshotUtil.takeScreenshotForAllure(driver);
	}


	@Step("To Verify Group Email Display Name filed")
	public String VerifyGroupEmailDisplayName(String displayName) throws IOException {
		PublicCommon.waitForSec(5);
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(groupEmailDisplayName));
		PublicAdminCommons.scrollToElement(driver, getElement(groupEmailDisplayName));
		ReusableMethods.scrollIntoView(getElement(groupEmailDisplayName),driver);
		getElement(groupEmailDisplayName).click();
		getElement(groupEmailDisplayName).clear();
		getElement(groupEmailDisplayName).click();
		getElement(groupEmailDisplayName).clear();
		getElement(groupEmailDisplayName).sendKeys(displayName);
		ScreenshotUtil.takeScreenshotForAllure(driver);
		return displayName;
	}

	@Step("To Verify Group Email3 Display Name filed")
	public boolean VerifyGroupEmailDisplayName3() throws IOException {
		PublicCommon.waitForSec(5);
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(groupEmailDisplayName));
		PublicAdminCommons.scrollToElement(driver, getElement(groupEmailDisplayName));
		getElement(groupEmailDisplayName).click();
		getElement(groupEmailDisplayName).clear();
		getElement(groupEmailDisplayName).click();
		getElement(groupEmailDisplayName).clear();
		ScreenshotUtil.takeScreenshotForAllure(driver);
		return true;
	}

	@Step("Click on Save Group")
	public void clickOnSaveGroup() throws IOException {
		getElement(saveGroup).click();
		ScreenshotUtil.takeScreenshotForAllure(driver);
		PublicCommon.waitForSec(10);
	}
	@Step("Click on Manage drafts tab")
	public void clickOnManageDrafts(){
		getElement(manageDrafts).click();
	}
	@Step("Click on Replace drafts tab")
	public void clickOnReplaceDrafts(){
		PublicCommon.waitForSec(10);
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(replaceDrafts));
		PublicAdminCommons.scrollToElement(driver, replaceDrafts);
		getElement(replaceDrafts).click();

	}
	@Step("Click on SpecBuilder Admin Button")
	public void ClickOnSpecBuilderAdmin(){
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(specBuilderAdmin));
		PublicAdminCommons.scrollToElement(driver, specBuilderAdmin);
		clickOnMethod("Click On manage Button",getElement(specBuilderAdmin));
		PublicCommon.waitForSec(5);
	}
	@Step("Click on Archived Groups")
	public void ClickOnArchivedGroups(){
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(archivedGroups));
		PublicCommon.JSClick(getElement(archivedGroups),driver);
		PublicCommon.waitForSec(5);
	}
public By title = By.xpath("//div[contains(@class,'title')]");

public String getTitle(){
		String groupTitle = getElement(title).getText();
	return groupTitle;
}

	@Step("Select Parent Group")
	public void selectParentGroup(String value) {
		try {
			PublicCommon.selectValueInDropdown(getElement(parentGroupSelection),value);

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("not able to select Parent Group", e);
		}
	}
		@Step("Create New Collaboration Area")
	public void createNewCollaborationArea() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(newCollaborationArea).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getElement(committeeGroupRadioBtn), driver);
			PublicCommon.selectValueInDropdownbyIndex(getElement(selectCommittee), 1);
			getElement(collaborationAreaTitle).sendKeys("TextAutomation");
			PublicCommon.selectValueInDropdownbyIndex(getElement(collaborationAdministrator), 1);
			ReusableMethods.scrollIntoView(getElement(initialDraft_No), driver);
			getElement(uploadDrafts_Yes).click();
			getElement(uploadSupport_Yes).click();
			getElement(initialDraft_No).click();
			getElement(createCollaborationArea).click();
			String[] no = getElement(collaborationAreaNo).getText().split("-");
			collaborationId = no[0].replaceAll(" ", "");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Create the collaboration area", e);
		}
	}

	@Step("Create New Collaboration Area")
	public String createNewCollaborationAreaWithExternalEmail(String email,boolean draft,String committe) {
		try {
            PublicCommon.waitForSec(20);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(newCollaborationArea),60);
			getElement(newCollaborationArea).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(committeeGroupRadioBtn),90);
			PublicCommon.JSClick(getElement(committeeGroupRadioBtn), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectCommittee),90);
			PublicAdminCommons.scrollToElement(driver, getElement(selectCommittee));
			PublicCommon.selectValueInDropdown(getElement(selectCommittee), committe);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(collaborationAreaTitle),90);
			PublicAdminCommons.scrollToElement(driver, getElement(collaborationAdministrator));
			String textAutomation = "TextAutomation" + RandomStringUtils.getRandomString(4);
			getElement(collaborationAreaTitle).sendKeys(textAutomation);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.selectValueInDropdownbyValue(getElement(collaborationAdministrator), 44244);
			getElement(additionalMembersEmail).sendKeys(email);
			ReusableMethods.scrollIntoView(getElement(initialDraft_No), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadDrafts_Yes),10);
			getElement(uploadDrafts_Yes).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadSupport_Yes),10);
			getElement(uploadSupport_Yes).click();
			if(draft) {
				getElement(initialDraft_Yes).click();
			}else{
				getElement(initialDraft_No).click();
			}
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createCollaborationArea),10);
			getElement(createCollaborationArea).click();
			Select sel=new Select(getElement(currentCollabArea));
			String[] no = getElement(collaborationAreaNo).getText().split("-");
			collaborationId = no[0].replaceAll(" ", "");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Create the collaboration area", e);
		}
		return collaborationId;
	}

	@Step("Create New Collaboration Area")
	public String createNewCollaborationAreaWithExternalEmailandreturnCollabId(String email,boolean draft,String committe) {
		try {
			PublicCommon.waitForSec(20);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(newCollaborationArea),60);
			getElement(newCollaborationArea).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(committeeGroupRadioBtn),90);
			PublicCommon.JSClick(getElement(committeeGroupRadioBtn), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectCommittee),90);
			PublicAdminCommons.scrollToElement(driver, getElement(selectCommittee));
			PublicCommon.selectValueInDropdown(getElement(selectCommittee), committe);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(collaborationAreaTitle),90);
			PublicAdminCommons.scrollToElement(driver, getElement(collaborationAdministrator));
			//textAutomation = "TextAutomation" + RandomStringUtils.getRandomString(4);
			getElement(collaborationAreaTitle).sendKeys("TextAutomation"+PublicAdminCommons.getCurrentDateWithFormat("ddMMYYYYHHss"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.selectValueInDropdownbyValue(getElement(collaborationAdministrator), 44244);
			getElement(additionalMembersEmail).sendKeys(email);
			ReusableMethods.scrollIntoView(getElement(initialDraft_No), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadDrafts_Yes),10);
			getElement(uploadDrafts_Yes).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadSupport_Yes),10);
			getElement(uploadSupport_Yes).click();
			if(draft) {
				getElement(initialDraft_Yes).click();
			}else{
				getElement(initialDraft_No).click();
			}
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createCollaborationArea),10);
			getElement(createCollaborationArea).click();
			Select sel=new Select(getElement(currentCollabArea));
			String[] currentCollab = sel.getFirstSelectedOption().getText().split("-");
			collaborationId = currentCollab[0].replaceAll(" ", "");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Create the collaboration area", e);
		}
		return collaborationId;
	}

	public void enterPercentagesAffirmative () {
		try {
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(percentagesAffirmative));
			PublicAdminCommons.scrollToElement(driver, getElement(percentagesAffirmative));
			getElement(percentagesAffirmative).click();
			getElement(percentagesAffirmative).clear();
			getElement(percentagesAffirmative).sendKeys(RandomStringUtils.getRandomNumbers(2));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

	LoginPage_SpecBuilder loginspb;



	@Step("Create New Collaboration Area")
	public String createNewCollaborationAreaAndEdit(String email,boolean draft,String committe) {
		try {
			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(newCollaborationArea),40);
			PublicAdminCommons.scrollToElement(driver, getElement(newCollaborationArea));
			getElement(newCollaborationArea).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(committeeGroupRadioBtn),90);
			PublicCommon.JSClick(getElement(committeeGroupRadioBtn), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectCommittee),90);
			PublicAdminCommons.scrollToElement(driver, getElement(selectCommittee));
			PublicCommon.selectValueInDropdown(getElement(selectCommittee), committe);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(collaborationAreaTitle),90);
			PublicAdminCommons.scrollToElement(driver, getElement(collaborationAdministrator));
			//textAutomation = "TextAutomation" + RandomStringUtils.getRandomString(4);
			getElement(collaborationAreaTitle).sendKeys("CollaborationEdit");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.selectValueInDropdownbyValue(getElement(collaborationAdministrator), 44244);
			// Select All
			closePopUp();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectAll),90);
			PublicAdminCommons.scrollToElement(driver, getElement(selectAll));
			getElement(selectAll).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectAllRightArrow),90);
			PublicAdminCommons.scrollToElement(driver, getElement(selectAllRightArrow));
			getElement(selectAllRightArrow).click();
			PublicAdminCommons.scrollToElement(driver, getElement(additionalMembersEmail));
			ScreenshotUtil.takeScreenshotForAllure(driver);

			getElement(additionalMembersEmail).sendKeys(email);
			ReusableMethods.scrollIntoView(getElement(initialDraft_No), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadDrafts_Yes),10);
			getElement(uploadDrafts_Yes).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadSupport_Yes),10);
			getElement(uploadSupport_Yes).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createCollaborationArea),10);
			getElement(createCollaborationArea).click();
			PublicCommon.waitForSec(15);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(editCollaborationArea),90);
			PublicAdminCommons.scrollToElement(driver, getElement(editCollaborationArea));
			getElement(editCollaborationArea).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectAllLeftArrow),90);
			PublicAdminCommons.scrollToElement(driver, getElement(selectAllLeftArrow));

			for (int k=1; k<=10; k++){
				PublicCommon.waitForSec(2);
				getMembersList().get(0).click();
				//listoflist.get(k).click();
				getElement(selectAllLeftArrow).click();
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createCollaborationArea),10);
			PublicAdminCommons.scrollToElement(driver, getElement(createCollaborationArea));
			getElement(createCollaborationArea).click();
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,SPBLoadingIcon);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			// Click on drafts Tab and UploadDraftS
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(drafts),40);
			PublicAdminCommons.scrollToElement(driver, getElement(drafts));
			getElement(drafts).click();
			PublicCommon.waitForSec(15);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(UploadDraftS),90);
			PublicAdminCommons.scrollToElement(driver, getElement(UploadDraftS));
			getElement(UploadDraftS).click();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Create the collaboration area", e);
		}
		return collaborationId;
	}
	public void waitForSpinnerLoaderToDisappear() {
		//PublicAdminCommons.waitForElementToDisappear(driver, getElementWithoutWait(spinnerIcon));
	}

	public int getViewReportsSize()
	{
		List<WebElement> ViewReportLinks=driver.findElements(By.xpath("//span[text()='View Report']"));
		return ViewReportLinks.size();

	}

	public WebElement getViewReport_OpenBallots(int i)
	{
		WebElement ele=driver.findElement(By.xpath("(//span[text()='View Report'])["+i+"]"));
		return ele;
	}

	public void vote(String Vote1,String Vote2,String Vote3)
	{
		int i;
		ArrayList<String> VoteChoices=new ArrayList<String>();
		VoteChoices.add(Vote1);
		VoteChoices.add(Vote2);
		VoteChoices.add(Vote3);
		for(i=1;i<=3;i++)
		{
			String vote=VoteChoices.get(i-1);
			WebElement voteDropdown=driver.findElement(By.xpath("//tr["+i+"]/td[3]/descendant::select"));
			WebElement comment=driver.findElement(By.xpath("//tr["+i+"]/td[4]/descendant::input"));
			if(vote.equals("Affirmative"))
			{
				PublicCommon.selectValueInDropdownbyIndex(voteDropdown,1);
			}
			else if(vote.equals("Negative w/ Comment"))
			{
				PublicCommon.selectValueInDropdownbyIndex(voteDropdown,2);
				comment.sendKeys("Negative Test Comment");
			}
			else
			{
				PublicCommon.selectValueInDropdownbyIndex(voteDropdown,3);
			}
		}

	}

	public WebElement getVoteDropdown(int i)
	{
		WebElement ele=driver.findElement(By.xpath("//tr["+i+"]/td[7]/descendant::select"));
		return ele;
	}

	public WebElement getCommentInput(int i)
	{
		WebElement ele=driver.findElement(By.xpath("//tr["+i+"]/td[8]/descendant::input"));
		return ele;
	}

}
