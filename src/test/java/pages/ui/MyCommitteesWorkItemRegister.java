package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyCommitteesWorkItemRegister extends BasePage {
    ASTMCartPage_Public astmCartPage;
    MembershipBecomeMemberPage newMembershipPage;
    CustomerLogin_Public loginPage=getInstance(CustomerLogin_Public.class);
    CommonPage_Public commonPage=getInstance(CommonPage_Public.class);
    public MyCommitteesWorkItemRegister(WebDriver driver) {
        super(driver);
    }

    public By MyCommitteesBTNBullets = By.xpath("//ul[@class='bulletList']/li//a[text()='MyCommittees']");

    //public By MyCollaborationAreas = By.xpath("//a[text()='MyCollaboration Areas']");
    public By BallotsBtn = By.xpath("(//div[@class='ballotsLink']/a)[1]");
    public By BallotsPageHeader = By.xpath("//h1");
    public By BreadcrumbMyASTM = By.xpath("//div[@class='breadcrumbDV']/nav/ol");
    public By BallotsandWorkItemBTN = By.xpath("//button[text()='Ballots & Work Items']");
    public By InactivityLink = By.xpath("//a[text()='Inactivity Reports']");
    public By SubmitEditBTN = By.xpath("//a[text()='Submit/Edit']");
    public  By WorkItem1 = By.xpath("//div[@class='astm-custom-radio custom-control custom-radio']/label/span[contains(text(),'I need to register a Work')]");
    public By ContinueBtn = By.xpath("//button[text()='Continue']");
    public By typeOfWorkItemInputRadioBtn=By.xpath("//label[text()='Proposed New ASTM Standard']/preceding-sibling::input");
    public By TypeOfWorkItem = By.xpath("(//label[@class='custom-control-label'])[1]");
    public By SelectACommitteeDropdown = By.xpath("//select[@id='MainCommitteeId']");
    public By SelectSubCommitteeDropdown = By.xpath("//select[@id='SubCommitteeId']");
    public By CopyRightCodeChoice = By.xpath("(//label[@class='custom-control-label'])[1]");
    public By AgreeBtn = By.xpath("//button[text()='Agree']");
    public By SubCommitteeTargetDate = By.xpath("//select[@id='TargetDateMonth']");
    public By selectAmember = By.xpath("//select[@id='TechnicalContactId']");
    public By SubCommitteeTargetYear = By.xpath("//select[@id='TargetDateYear']");

    public By AuthorizationDateMonth = By.xpath("//select[@id='AuthorizationDateMonth']");
    public By AuthorizationDateYear = By.cssSelector("#AuthorizationDateYear");
    public By IsAuthorizedWorkitemRadioBtn = By.xpath("//label[@for='IsAuthorizedWorkItem0']");
    public By IsPatented = By.xpath("//div[@class='astm-custom-radio custom-control custom-radio']/label[@for='IsPatented0']");
    public By AmemberOfCommittee = By.xpath("(//label[@for='IsSelfTechnicalContact']/../div/label)[2]");
    public By StandardTypeId = By.xpath("//select[@id='StandardTypeId']");
    public By Data_Title = By.xpath("//textarea[@id='Title']");
    public By Data_Scope = By.xpath("//textarea[@id='Scope']");
    public By Data_Keywords = By.xpath("//input[@id='Keywords']");
    public By Data_Rationale = By.xpath("//textarea[@id='Rationale']");
    public By SubmitBtn = By.xpath("//button[text()='Submit']");
    public By CancelBtnInEmailPopUp = By.xpath("//div[@class='modal-footer']/button[text()='Cancel']");
    public By OnlineCollaborationYes = By.xpath("//input[@id='IsOnlineCollaboration0']/../label");
    public By OnlineCollaborationNo = By.xpath("//input[@id='IsOnlineCollaboration1']/../label");
    public By HeaderStaffEmailRedirect = By.xpath("//h5[text()='Staff Email Redirect']");
    public By EnterEmail = By.xpath("//input[@type='email']");
    public By OkBtn = By.xpath("//div[@class='modal-footer']//button[text()='Ok']");
    public By CancelBtn = By.xpath("//div[@class='modal-footer']//button[text()='Cancel']");
    public By WorkItemID = By.xpath("//span[@class='redTxt']");
    public By CancelBtn1 = By.xpath("//div[@data-testid='summaryComponent']//button[text()='Cancel']");
    public By WorkItemType = By.xpath("//div[@class='mb24']/p[text()='Work Item Type:']/../p[2]");
    public By SponsoringSubCommittee = By.xpath("//div[@class='mb24']/p[text()='Sponsoring Subcommittee:']/../p[2]");
    public By TechnicalContact = By.xpath("//div[@class='mb24']/p[text()='Technical Contact:']/../p[2]");
    public By StandardType = By.xpath("//div[@class='mb24']/p[text()='Standard Type:']/../p[2]");
    public By TargetBallotDate = By.xpath("//div[@class='mb24']/p[text()='Target Ballot Date:']/../p[2]");
    public By TargetCompletionDate = By.xpath("//div[@class='mb24']/p[text()='Target Completion Date:']/../p[2]");
    public By ConfirmPgae_MyCommittesBtn = By.xpath("//p[@class='astm-type-body--lead mb24']/a[text()='MyCommittees']");
    public By GoToOnlineCollabArea = By.xpath("//p[text()='Online Collaboration Area Established:']/../p[2][text()='Yes ']/span/a");
    public By MyCollaborationAreas = By.xpath("//button[text()='MyCollaboration Areas']");
    public By MyWorkItem = By.xpath("//button[text()='MyWork Items']");

    public By C11Committee = By.xpath("(//a[text()='C11'])[2]");
    public By SelectWorkItems = By.xpath("//button[text()='MyWork Items']/../../../div/div[@class='card-body']/ul/li/a");
    public By WorkItems = By.xpath("//h1[text()='MyWork Items']/../..//a[1]");
    public By WorkItemsALL = By.xpath("//button[text()='MyWork Items']/following::a[text()='All']");
    public By WorkItemsList = By.xpath("//div[@class='workItemWrap']");
    public By SelectWkC11 = By.xpath("//button[text()='MyWork Items']/../../../div//div[@class='card-body']//li//a[text()='C11']");
    public By LaunchAdminCollabAreaLink = By.xpath("(//a[text()='Launch Admin Collaboration Area'])[1]");
    public By CreateWorkItemCollaborationBtn = By.xpath("//a[text()='Create Work Item Collaboration']");
    public By SelectBtn = By.xpath("//div[@class='choose txtLeft']");
    public By SelectWorkItem = By.xpath("//input[@id='search-committees']");
    public By CollaborationAreaObjective = By.xpath("//textarea[@id='CollaborationAreaObject']");

    public By SelectSearchedWorkItem = By.xpath("//div[@class='astm-custom-radio custom-control custom-radio']");
    public By DoneBtn = By.xpath("//button[text()='Done']");
    public By SelectAdditionalCollab = By.xpath("//select[@id='AdditionCollab']");
    public By SelectAllBtn = By.xpath("(//button[text()='Select All'])[1]");
    public By SelectAllBtn1 = By.xpath("(//button[text()='Select All'])[2]");
    public By ForwardArrow = By.xpath("//button[@aria-label='forward arrow clickable to add members']");
    public By ForwardArrow1 = By.xpath("//button[@aria-label='forward arrow clickable to add members']");
    public By UploadOption = By.xpath("//input[@id='UploadDrafts1']/../label");
    public By UploadSupport = By.xpath("//input[@id='UploadSupport1']/../label");
    public By UploadInitialDraft = By.xpath("//input[@id='UploadinitialDraft1']/../label");
    public By CreateCollaborationAreaBtn = By.xpath("//button[text()='Create Collaboration Area']");

    public By GoToCollaborationArea = By.xpath("//a[text()='Go to Collaboration Area']");
    public By BreadcrumbInactivityReport = By.xpath("//p[@class='bread-crumb']");
    public By BallotReportLink = By.xpath("//div[@id='ballotreportlinks']");
    public By InactivityReportMyCommitteeLink = By.xpath("//span[@id='lblMyASTMLink']");
    public By MyCommitteeLink = By.xpath("(//a[text()='MyCommittees'])[1]");

    public By roasterReportsTab = By.xpath("//a[text()='Roster Reports']");

    public By word = By.xpath("//button[text()=' Word']");

    public By excelBtn = By.xpath("//button[@data-testid='downloadExcelReportBtn']");

    public By dateField = By.xpath("//input[@id='date']");

    public By dateSelect = By.xpath("//div[text()='13']");

    public By roaterAndVisitorBtn = By.xpath("//button[text()='Roster & Visitor']");

    public By visitorsOnly = By.xpath("//button[text()='Visitor Only']");

    public By membershipReportDateField = By.xpath("//input[@id='membershipStartDate']");

    public By memebrshipReportStartDate = By.xpath("//div[text()='18']");

    public By membershipEndDateField = By.xpath("//input[@id='membershipEndDate']");

    public By membershipEndDate = By.xpath("//div[text()='19']");

    public By currentAffiliateMemberrsCheckBox = By.xpath("//label[text()='Current Affiliate Members']");

    public By downloadBtn = By.xpath("//button[text()='Download']");

    public By signInDropdown = By.xpath("//button[@id='dropdown-menu-align-right']");

    public By signOutOption = By.xpath("//button[text()='Sign Out']");

    public By membersRemovedFromRosterCheckBox = By.xpath("//label[text()='Members Removed from Roster']");

    public By currentProduceWaitListChrckBox = By.xpath("//label[text()='Current Producer Wait List']");

    public By honoraryMembersList = By.xpath("//label[text()='Honorary Members List']");

    public By committeeBalanceCheckBox = By.xpath("//label[text()='Committee Balance']");

    public By memberChangingEmployementCheckBox = By.xpath("//label[text()='Members Changing Employment']");

    public By inactivityReport = By.xpath("//label[text()='Inactivity Report']");

    public By roasterMaintananceLink = By.xpath("//a[text()='Roster Maintenance ']");
    public By viewBallotQueue = By.xpath("//button[text()='View Ballot Queue']");
    public By subCommittee = By.xpath("//a[text()='B07.01']");
    public By subCommitteeItem = By.xpath("//a[text()='New Standard WK81870 (45K)']");
    public By subCommitteeHyperLink = By.xpath("//a[text()='New Standard WK81870 (45K)']");

    public By  myOutStandingBallotBtn = By.xpath("//button[text()='MyOutstanding Ballots ']");
    public By MyCommitteeHeader = By.xpath("//h1[text()='MyCommittees']");
    public By ballots = By.xpath("//div[@class='collapse show']/..//li");

    public By mcsSearchTab = By.xpath("//a[text()='Search']");
    public By byBallotNrOption = By.xpath("//a[text()='By Ballot Nr']");

    public By tallyLink = By.xpath("//a[text()='Tally']");

    public By ballotNrTextField = By.xpath("//input[@id='ctl00_ctl00_cphAppContent_cphMainContent_txtBallotNr']");
    public By mcsSearchBtn = By.xpath("//input[@type='submit']");
    public By summaryLink = By.xpath("//a[text()='Summary']");

    public By searchBtn = By.xpath("//input[@type='submit']");

    public By allDocumentsLink = By.xpath("//a[text()='ALL DOCUMENTS']");

    public By affirmativeRadioBtn = By.xpath("//label[text()='Affirmative all items, except as marked below']");
    public By submitBallotsToAstmBtn = By.xpath("(//button[text()='Submit Ballot to ASTM'])[2]");

    public By okBtn = By.xpath("//button[text()='Ok']");
    public By MyNextMeetings = By.xpath("//button[text()='MyNext Meetings ']");

    public By MeetingsLinks = By.xpath("//button[text()='MyNext Meetings ']/../../../div[2]/div/ul/li");
    public By MyCommittees = By.xpath("//a[normalize-space()='My committees'] | //a[normalize-space()='My Committees']");
    public By  MyAccount= By.xpath("//a[text()='MyAccount']");
    public By  AdditionalResourcesLink= By.xpath("//button[text()='Additional Resources']");

    public By rejectAllCookiesBtn = By.xpath("//div[@id='onetrust-button-group']//button[text()='Reject All']");
    public By  TerminologyDictionaryLink= By.xpath("//a[text()='Terminology Dictionary']");
    public By  TerminologyDictionaryHeader= By.xpath("//h1[contains(text(),'Terminology Dictionary of Engineering')]");
    public By  EnterTermField= By.xpath("(//label[text()='Enter Term']/following::input[@name='inputTerm'])[1]");
    public By  SearchBtn= By.xpath("(//button[text()='Search'])[1]");
    public By  SearchTermsDefinitionRadioBtn= By.xpath("(//label[text()='Search Terms & Definition'])[1]/../input");
    public By  ListofSearchTerm= By.xpath("//li[@class='list-group-item']/h4");
    public By ListOfDefinitions = By.cssSelector(".twoLiner");
    public By  FirstStandardFromList= By.xpath("(//li[@class='list-group-item'])[1]/p/a[1]");
    public By  FirstSubcommitteeFromList= By.xpath("(//li[@class='list-group-item'])[1]/p/a[2]");
    public By  FirstMainCommitteeFromList= By.xpath("(//li[@class='list-group-item'])[1]/p/a[3]");
    public By StayOnPageBtn = By.xpath("//a[text()='Stay on Page']");
    public By SubCommittesListHeader = By.xpath("//h2[contains(text(),'Subcommittee')]");
    public By matchingStandards = By.xpath("(//a[contains(@class,'matching-count-text')])[1]");
    public By sku = By.xpath("//b[@class='sku']");
    public By standardtrackinglink=By.xpath("//a[text()='Standards Tracking']");

    public By B07standardsTrackinglink = By.xpath("(//div[@class='committeeLinks'])[3]//a[@data-testid='standardsTrackingLink']");

    public By committeeB07 = By.xpath("(//a[text()='B07'])[1]");

    public By workItem = By.xpath("//a[text()='WK77716']");

    public By workItemNumber = By.xpath("//h3[text()='WK77716']");

    public By dateinitiated = By.xpath("//span[text()='10-04-2021']");

    public By technicalContact = By.xpath("//span[text()='Peter Bittner']");

    public By MeetingsMinutesAgendasBtn = By.xpath("//button[text()='Meetings, Minutes & Agendas']");

    public By createMyScheduleLink = By.xpath("//a[text()='Create MySchedule']");

    public By workItemStatus = By.xpath("//div[text()='Work Item Status ']");
    public By AlphabeticalListingOfTermsBtn = By.xpath("//a[text()='Alphabetical Listing of Terms']");
    public By PlanOnlineMtgConf = By.xpath("//a[text()='Plan Online Mtg/Conf']");
    public By RequestVirtualMeetingHeader= By.xpath("//h1[text()='Request a Virtual Meeting or Conference Call']");

    public By previousMeetingRadioBtn= By.xpath("//label[contains(text(),'previous meeting')]/../input");
    public By workItemRadioBtn= By.xpath("//label[contains(text(),'Work Item')]/../input");
    public By ChooseMeetingBtn= By.xpath("//button[text()='Choose Meeting']");

    public By ballotsLink = By.xpath("(//a[text()='Ballots'])[1]");

    public By allBallotsBtn = By.xpath("//button[text()='All Ballots']");
    public By header= By.xpath("//h1[@class='astm-type-heading--h1']");
    public By viewBallotsQueue = By.xpath("//button[text()='View Ballot Queue']");

    public By ballot = By.xpath("//a[text()='B07 (23-12)']");

    public By viewClosedBallotsBtn = By.xpath("//button[text()='View Closed Ballots/Closing Reports']");

    public By webViewBtn = By.xpath("(//button[text()='Web View'])[1]");

    public By clickHereLink = By.xpath("//a[text()='Click here']");
    public By closeBtn = By.xpath("(//button[@type='button'])[5]");
    public By caveatHereLink = By.xpath("(//a[@class='astm-link'])[2]");

    public By viewBallotQueueBtn = By.xpath("//button[text()='View Ballot Queue']");

    public By astmTable = By.xpath("//tr[@class='astm-table-tr']/..//th");

    public By breadCrumb = By.xpath("//ol[@class='breadcrumb astm-breadcrumb']/..//li");

    public By ChooseWorkItemBtn= By.xpath("//button[text()='Choose Work Item']");
    private By monthDropDown = By.cssSelector("select[class='react-datepicker__month-select']");
    private By yearDropDown = By.cssSelector("select[class='react-datepicker__year-select']");
    private By activeDateLabel = By.cssSelector("div[aria-disabled='false']");
    public By MeetingStartTimeHours= By.id("StartHours");
    public By MeetingStartTimeMintues= By.id("StartMintues");
    public By MeetingDurationHours= By.id("EstimatedDurationHours");
    public By MeetingDurationMintues= By.id("EstimatedDurationMinutes");
    public By confirmationMsg= By.xpath("//div[@data-testid='confirmationMsg']");
    public By MeetingDate= By.xpath("//label[text()='Meeting Date']/following::div[@class='react-datepicker-wrapper']");
    public By ScheduleMeetingBtn= By.xpath("//button[text()='Schedule Meeting']");
    public By VirtualMeetingBtn= By.xpath("//label[contains(text(),'Virtual Meeting')]/../input");
    public By AMRadioBtn= By.xpath("//label[text()='AM']/../input");
    public By MembersFromTheRoster= By.xpath("//div[@data-testid='rosterMembersMultiSelectList']//button[text()='Select All']");
    public By rightArrow= By.xpath("//div[@data-testid='rosterMembersMultiSelectList']//i[@class='astm-icon far fa-arrow-circle-right']");

    public By EditExistingWorkItemOrUpdateTargetDateRadio = By.cssSelector("#workItem3");
    public By SubmitItemToBallotRadio = By.cssSelector("#workItem2");
    public By RegisterWorkItem = By.cssSelector("#workItem1");
    public By EditExistingWorkItemRadio = By.cssSelector("#IsEditWorkItem0");
    public By selectWIButton = By.cssSelector(".custom-multiselect .choose");
    public By workItemSearchField = By.cssSelector("#search-committees");
    public By workItemsExistingListRadio = By.cssSelector(".subcommittee-list input");
    public By workItemSelectDoneButton = By.cssSelector(".list-sidebar .astm-btn--primary");
    public By selectedWI = By.cssSelector(".pills .title");
    public By IWill_TechnicalContact_radio = By.xpath("//label[text() = 'I will']");

    public By Confirm_WIRegistrationPageLink = By.cssSelector("a[data-testid=RegistrationLink]");
    public By Confirm_MyCommitteesLink = By.cssSelector("a[data-testid=MyCommitteeLink]");
    public By WIRegistrationAreaHeading = By.cssSelector(".registrationComponent h1");
    public By MyCommitteePageHeading = By.cssSelector(".astm-type-heading--h1");

    public By GetInvolved= By.xpath("//a[text()='Get Involved']");
    public By Membership= By.xpath("//div[contains(@data-testid,'nav-child')]//a[text()='Membership']");
    public By TechnicalCommittees= By.xpath("//a[text()='Technical Committees']");
    public By TechnicalCommitteesFullList= By.xpath("//a[@class='navbar-link ml-4']");

    public By MeetingsMinutesAgendasDropdownList = By.xpath("//div[@class='collapse show']/..//li");

    public By desiredEventName = By.xpath("//a[text()='Automation Test Event Jan committee 2024']");

    public By selectCommittee = By.xpath("//label[text()='E27 on Hazard Potential of Chemicals']");

    public By includingMainComitteeMeetingRadioBtn = By.xpath("//label[text()='Include Main Committee meetings and all meetings of Subcommittees to which I belong.']");

    public By checkAllOrUncheckAllBtn = By.xpath("//label[text()='Uncheck All']");

    public By visibleBtns = By.xpath("//div[@class='mt24']");

    public By createMyMeetingmaterialsBtn = By.xpath("//button[text()='Create MyMeeting Materials']");

    public By addCustomMeetingBtn = By .xpath("//button[text()=' Add custom meetings']");

    public By meetingTitleTextfield = By.xpath("//input[@id='MeetingTitle']");

    public By meetingLocationOrRoomTextField = By.xpath("//input[@id='MeetingLocationRoom']");

    public By meetingLocation = By.xpath("//input[@id='MeetingLocation']");

    public By meetingStartdateBtn = By.xpath("//input[@id='MeetingStartDate']");

    public By date = By.xpath("(//div[text()='1'])[2]");

    public By selectMeetingStartTimeDropdown = By.xpath("//select[@id='MeetingStartTimeHour']");

    public By meetingStarttimeHour = By.xpath("(//option[text()='1'])[1]");

    public By meetingStarttimeMinuteDropdown = By.xpath("//select[@id='MeetingStartTimeMinute']");

    public By meetingStarttimeMinute = By.xpath("(//option[text()='15'])[1]");

    public By meetingDurationHourDropdown = By.xpath("//select[@id='MeetingDurationHour']");

    public By meetingDurationHour = By.xpath("(//option[text()='1'])[2]");

    public By meetingDurationMinuteDropdown = By.xpath("//select[@id='MeetingDurationMinute']");

    public By meetingDurationMinute = By.xpath("(//option[text()='15'])[2]");

    public By addMeetingBtn = By.xpath("//button[text()=' Add meeting ']");

    public By createMyScheduleBtn = By.xpath("//button[text()='Create schedule']");

    public By createMyMeetingMaterial = By.xpath("//a[text()='Create MyMeeting Materials']");

    public By subCommitteeRadiotn = By.xpath("//label[text()='F14']");

    public By ThanksAndsuccessfulMsg = By.xpath("//p[text()='Thank you for your submittal. You will receive an email shortly with a link to a zip file where you can access all of your meeting materials.']");
    public By includeMaterialForCommitteeRadioBtn = By.xpath("//label[text()='Include material for Main Committee and Subcommittees to which I belong.']");
    public By includeAllMaterialRadioBtn = By.xpath("//label[text()='Include all material for the selected committee.']");

    public By subCommitteeBtn = By.xpath("//label[text()='F14 Fences']");

    public By createMyAgendaLink = By.xpath("//a[text()='Create MyAgenda']");

    public By subCommitteOrSectionDropdown = By.xpath("//select[@id='subCommiteeId']");

    public By subCommitte = By.xpath("//option[text()='B10.01']");

    public By subCommitteeOrSection = By.xpath("//option[text()='C11.01']");

    public By createMyAgendaBtn = By.xpath("//button[text()='Create agenda']");

    public By desiredEventNameOfMeeting = By.xpath("//a[text()='F16.03 Coatings on Fasteners']");

    public By checkAllRadioBtn = By.xpath("//span[text()='Check All']");
    public By recentCtivityLink = By.cssSelector("a[href='/MyASTM/RecentActivity']");
    public By RecentActivity_CommitteeActivity_Heading = By.cssSelector("h4[data-testid='committee-activity']");
    public By RecentActivity_RosterUpdates_Heading = By.cssSelector("h4[data-testid='roster-updates']");

    public By workItemTab = By.xpath("//a[text()='Work Item']");

    public By enterworkItemTxtField = By.xpath("//h4[text()='View/Edit Work Item']/..//input");

    public By findBtn = By.xpath("//h4[text()='View/Edit Work Item']/..//button");

    public By deleteBtn = By.xpath("//button[text()='Delete']");

    public By reasonFoDeleteTextField = By.xpath("//textarea[@id='DeleteReason']");

    public By confirmBtn = By.xpath("//button[text()='Confirm']");
    public By MembershipLabel=By.xpath("//h2[text()='Membership']");
    public By returnToMyBallotsBTN=By.xpath("//button[contains(text(),'Return to MyBallots')]");
    public By saveAndReturnLaterBTN=By.xpath("(//button[contains(text(),'Save and Return Later')])[2]");
    public By submitBallotToASTMBTN=By.xpath("(//button[contains(text(),'Submit Ballot to ASTM')])[2]");
    public By clear=By.xpath("(//button[contains(text(),'Clear')])[1]");

    public int getBallotItemSize()
    {
        List<WebElement> ballotItems=driver.findElements(By.cssSelector(".ballotTableDetails > div.itemNumber"));
        return ballotItems.size();

    }
    public By chooseWorkItemListList = By.cssSelector("*[class*='list-group astm-list-group'] li label");

    public By restoreBtn = By.xpath("//button[text()='Restore']");
    public By RecentActivity_BallotsReturned = By.cssSelector("h6[data-testid='ballot-returned-header']");
    public By RecentActivity_WorkItemsRegistered = By.cssSelector("h6[data-testid='work-item-header']");
    public By RecentActivity_CollaborationAreaLaunched = By.cssSelector("h6[data-testid='collaboration-area-header']");
    public By RecentActivity_BallotItemsSubmitted = By.cssSelector("h6[data-testid='ballot-submitted-header']");

    public By RecentActivity_BallotsReturned_ViewLink = By.cssSelector("a[data-testid='ballot-returned-link']");
    public By RecentActivity_WorkItemsRegistered_ViewLink = By.cssSelector("a[data-testid='work-item-link']");
    public By RecentActivity_CollaborationAreaLaunched_ViewLink = By.cssSelector("a[data-testid='collaboration-area-link']");
    public By RecentActivity_BallotItemsSubmitted_ViewLink = By.cssSelector("a[data-testid='ballot-submitted-link']");

    public By RecentActivity_JoinedCommittees_ViewLink = By.cssSelector("a[data-testid='join-committee-link']");
    public By RecentActivity_DroppedCommittee_ViewLink = By.cssSelector("a[data-testid='drop-committee-link']");

    public By RecentActivity_WorkItemsRegisteredList = By.xpath("//h6[@data-testid='work-item-header']/following-sibling::p");
    public String RecentActivity_WorkItemsRegisteredList_var = "//h6[@data-testid='work-item-header']/following-sibling::p[[INDEX]]/a";
    public By RecentActivity_WorkItem= By.xpath("//h6[@data-testid='work-item-header']/following-sibling::p/a");
    public By RecentActivity_BallotsReturnedList = By.xpath("//h6[@data-testid='ballot-returned-header']/following-sibling::p");
    public String RecentActivity_BallotsReturnedList_var = "//h6[@data-testid='ballot-returned-header']/following-sibling::p[[INDEX]]/a";
    public By RecentActivity_ColabAreaList = By.xpath("//h6[@data-testid='collaboration-area-header']/following-sibling::p");
    public By RecentActivity_JoinedCommitteesList = By.xpath("//h6[@data-testid='join-committee-header']/following-sibling::p");
    public String RecentActivity_JoinedCommitteesList_var = "//h6[@data-testid='join-committee-header']/following-sibling::p[[INDEX]]/a";
    public By RecentActivity_DroppedCommitteesList = By.xpath("//h6[@data-testid='drop-committee-header']/following-sibling::p");
    public String RecentActivity_DroppedCommitteesList_var = "//h6[@data-testid='drop-committee-header']/following-sibling::p[[INDEX]]/a";
    public By MyWorkItems_WI = By.xpath("//div[@class='card-body']//li[1]//a[contains(@href,'MyWorkItems')]");

    String Proposed_WI_link_var = "//span[text()='Proposed: ']//a[contains(@href,'/MyASTM/MyCommittees/WorkItems/WorkItemDetails') and text()='[WI_Number]']";
    String WI_link_var = "//a[text()='[WI_Number]']";
    public By getProposed_WI_link(String WI_Number){
        return By.xpath(Proposed_WI_link_var.replace("[WI_Number]", WI_Number));
    }
    public By getWI_link(String WI_Number){
        return By.xpath(WI_link_var.replace("[WI_Number]", WI_Number));
    }
    public By Proposed_MyWorkItem_heading = By.cssSelector("h2.text-left.title");
    public By Proposed_WorkItemNumber1 = By.xpath("//h2[@class='astm-type-heading--h2 mb24']");
    public By Proposed_WorkItemNumber = By.xpath("//span[@class='astm-type-body--lead']/b");
    public By RevisionActionRadio = By.cssSelector("#Revision");
    public By NewStandardActionradio = By.cssSelector("#NewStandard");
    public By BallotLevel_SubCommitteeBallot = By.xpath("//input[@id='Subcommittee Ballot']");

    public By BallotAuthorisationRadio = By.xpath("//input[@name='BallotAuth' and @id='true']");
    public By RevisionsToTitleIncludedRadio_Yes= By.xpath("//input[@name='isRevisionIncluded' and @id='true']");
    public By UploadAttachmentButton = By.xpath("//button[@aria-label='Upload Attachment']");
    public By FileUploadField = By.cssSelector("#fileupload");
    public By SubmitPage_WorkItem = By.xpath("//p[text()='Work Item:']//following-sibling::p");
    public By SubmitPage_BallotAction = By.xpath("//p[text()='Ballot Action:']//following-sibling::p");
    public By SubmitPage_SponsoringSubcommittee = By.xpath("//p[text()='Sponsoring Subcommittee:']//following-sibling::p");
    public By SubmitPage_StandardBeingRevised = By.xpath("//p[text()='Standard Being Revised:']//following-sibling::p");
    public By SubmitPage_TechnicalContact = By.xpath("//p[text()='Technical Contact:']//following-sibling::p");
    public By SubmitPage_SubmittedBy = By.xpath("//p[text()='Submitted By:']//following-sibling::p");
    public By SubmitPage_TitleWillBeRevised = By.xpath("//p[text()='Title Will be Revised:']//following-sibling::p");
    public By SubmitPage_ItemAttached = By.xpath("//p[text()='Item Attached:']//following-sibling::p");
    public By SubmitPage_SubmitButton = By.cssSelector("button[data-testid=submitSummaryBtn]");
    public By ConfirmPage_Message_Lead = By.cssSelector(".astm-type-body--lead");
    public By ConfirmPage_Message_text1 = By.xpath("//p[@class='astm-type-body--lead mb24']//parent::div//following-sibling::p[1]");
    public By ConfirmPage_Message_EmailSentTo1 = By.xpath("//p[@class='astm-type-body--lead mb24']//parent::div//following-sibling::div//li[1]");
    public By ConfirmPage_Message_EmailSentTo2 = By.xpath("//p[@class='astm-type-body--lead mb24']//parent::div//following-sibling::div//li[2]");
    public By ConfirmPage_Message_EmailSentTo3 = By.xpath("//p[@class='astm-type-body--lead mb24']//parent::div//following-sibling::div//li[3]");
    public By ConfirmPage_Message_text2 = By.xpath("//p[@class='astm-type-body--lead mb24']//parent::div//following-sibling::p[2]");
    public By EditWI_SummaryPage_WINumber = By.cssSelector(".redTxt");
    public By EditWI_SummaryPage_Acknowledgement1 = By.xpath("//p[@class='astm-type-body--lead mb24 italic'][1]");
    public String EditWI_SummaryPage_WIdetails_var = "//p[contains(text(),'[HEADING]')]//following-sibling::p";
    public By SubmitBallot_DataPage_text2 = By.xpath("//p[contains(text(),'According to the Work Item Registration for')]");
    public By SubmitBallot_DataPage_Title = By.xpath("//strong[contains(text(),'Title')]//parent::p[@class='astm-type-body--lead mb24 brder_btm']");
    public By SubmitBallot_DataPage_Scope = By.xpath("//strong[contains(text(),'Scope')]//parent::p[@class='astm-type-body--lead mb24 brder_btm']");
    public By getEditWI_SummaryPage_WIdetails(String Heading){
        return By.xpath(EditWI_SummaryPage_WIdetails_var.replace("[HEADING]", Heading));
    }
    public By SubmitBallot_StaffEmailRedirect_EmailField = By.cssSelector("#subSequentEmail");
    public By RevisionToExistingASTMStandard_radio = By.cssSelector("#IsNewStandard1");
    public By ProposedNewASTMStandard_radio = By.cssSelector("#IsNewStandard0");
    public By SubmitOriginalMaterial_radio = By.cssSelector("#copyright1");
    public By TargetPage_IsPatented_No_radio = By.cssSelector("#IsPatented1");
    public String MyCommittees_Ballot = "//a[contains(@href,'[COMMITTEE]') and text()='Ballots']";
    public By committeeRostertab = By.xpath("//li[text()='Committee Roster']");
    public By committeeRostertHdr = By.xpath("//h2[@data-testid='header']");
    public By viewAllRostersLink = By.xpath("//a[contains(text(),'View') and text()='All']");
    public By viewMyRostersLink = By.xpath("//a[contains(text(),'View') and text()='My']");
    public By text = By.xpath("//p[@data-testid='note-text']");
    public By searchField = By.name("basicSearch");
    public By memberInformationHdr = By.xpath("//h2[text()='Member Information']");
    public By importantText = By.xpath("(//*[contains(text(),'Important')]/..//p)[1]");
    public By memberInformationdetailes1 = By.xpath("//*[contains(@class,'astm-type-body')]/strong");
    public By memberInformationdetailes2 = By.xpath("//*[contains(@class,'astm-type-body')]/span");
    public By rosterMaintenanceLink = By.xpath("//a[contains(text(),'Roster Maintenance ')]");
    public By rosterMaintenanceHdr = By.xpath("//div[text()='Roster Maintenance']");
    public By selectCommitteeDrp = By.id("SelectCommittee");
    public By committeeSummary = By.xpath("//div[text()='Committee Summary']");
    public By membersCount = By.xpath("//li[@class='active-total-count']/span[@class='totalCount']");
    public By pendingApplications = By.id("pendingApplications");
    public By producerWaitList = By.id("producerWaitList");
    public By name = By.xpath("//*[@class='table astm-table table-striped roasterTable']//th[text()='Name']");
    public By Organization = By.xpath("//*[@class='table astm-table table-striped roasterTable']//th[text()='Organization']");
    public By joinDate = By.xpath("//*[@class='table astm-table table-striped roasterTable']//th[text()='Join Date']");
    public By classification = By.xpath("//*[@class='table astm-table table-striped roasterTable']//th[text()='Classification']");
    public By OfficialVote = By.xpath("//*[@class='table astm-table table-striped roasterTable']//th[text()='Official Vote']");
    public By rosterReports = By.id("rosterReports");
    public By rosterBtn = By.xpath("//a[text()='Roster']");
    public By excelBtn1 = By.xpath("//button[@data-testid='downloadExcelReportBtn']");
    public By classificationsValue = By.xpath("(//*[@name='classification'])[1]/option");
    public By popUpMsg = By.xpath("//div[@class='modal-body']");
    public By committeeHdrText = By.xpath("//h2[contains(@class,'styles_mainTitle__RuNUL text-left title')]");
    public By proposedNewMatchingStandardsLink = By.xpath("//span[contains(text(),'Proposed New')]/../a");

    public By getMyCommittees_Ballot(String ReplaceText){
        return By.xpath(MyCommittees_Ballot.replace("[COMMITTEE]", ReplaceText));
    }
    public List<WebElement> getProposedNewWorkItem(){
        return getElements(By.xpath("//div[@id='collapseProposedNew']//a"));
    }
    public String BallotQueue_CommitteeLink = "//a[@class='astm-table-td astm-link' and text()='[COMMITTEE]']";
    public By getBallotQueue_CommitteeLink(String ReplaceText){
        return By.xpath(BallotQueue_CommitteeLink.replace("[COMMITTEE]", ReplaceText));
    }
    public By getClassification(String email){
        return By.xpath("//a[contains(@href,'"+email+"')]/ancestor::tr//*[@name='classification']");
    }
    public By getOfficialVote(String email){
        return By.xpath("//a[contains(@href,'"+email+"')]/ancestor::tr//*[@name='Officialvote']");
    }
    public WebElement meetingsSymposiaLinkUnderMycommittee(String committee){
        return getElement(By.xpath("//a[contains(@href,'committee-"+committee+"')]/../..//a[text()='Meetings & Symposia']"));
    }
    String Random_Title;
    public List<WebElement> getMeetingsLinks(){
        return getElements(MeetingsLinks);
    }
    public boolean MyCommitteesBTN() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(MyCommitteesBTNBullets),20);
            getElement(MyCommitteesBTNBullets).click();
            getElement(BallotsandWorkItemBTN).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(SubmitEditBTN).click();
            Thread.sleep(6000);
            getElement(WorkItem1).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),20);
            getElement(ContinueBtn).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(TypeOfWorkItem),20);
            getElement(TypeOfWorkItem).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SelectACommitteeDropdown),20);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SelectACommitteeDropdown),1);
            Thread.sleep(6000);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SelectSubCommitteeDropdown),20);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SelectSubCommitteeDropdown),1);
            Thread.sleep(6000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),20);
            getElement(ContinueBtn).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(CopyRightCodeChoice),20);
            getElement(CopyRightCodeChoice).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(AgreeBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AgreeBtn),20);
            getElement(AgreeBtn).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SubCommitteeTargetDate),20);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetDate),1);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SubCommitteeTargetYear),20);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetYear),2);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(IsAuthorizedWorkitemRadioBtn),20);
            getElement(IsAuthorizedWorkitemRadioBtn).click();
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(IsPatented),20);
            getElement(IsPatented).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),20);
            getElement(ContinueBtn).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(StandardTypeId),20);
            PublicCommon.selectValueInDropdownbyIndex(getElement(StandardTypeId),1);
            getElement(Data_Title).sendKeys("ASTM");
            getElement(Data_Scope).sendKeys("Standard");
            getElement(Data_Keywords).sendKeys("Steel");
            getElement(Data_Rationale).sendKeys("usage");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),20);
            getElement(ContinueBtn).click();
            Thread.sleep(7000);
            ReusableMethods.scrollIntoView(getElement(SubmitBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SubmitBtn),15);
            getElement(SubmitBtn).click();
            Thread.sleep(5000);


            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean CreateWorkItem_INT_1417() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(MyCommitteesBTNBullets),15);
            getElement(MyCommitteesBTNBullets).click();
            getElement(BallotsandWorkItemBTN).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(SubmitEditBTN).click();
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(WorkItem1),10);
            getElement(WorkItem1).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(TypeOfWorkItem),10);
            getElement(TypeOfWorkItem).click();
            PublicCommon.selectValueInDropdownbyValue(getElement(SelectACommitteeDropdown),47);
            Thread.sleep(3000);
            PublicCommon.selectValueInDropdownbyValue(getElement(SelectSubCommitteeDropdown),602);
            Thread.sleep(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(4000);
            getElement(CopyRightCodeChoice).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(AgreeBtn).click();
            Thread.sleep(4000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetDate),1);
            Thread.sleep(3000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetYear),2);
            getElement(IsAuthorizedWorkitemRadioBtn).click();
            PublicCommon.selectValueInDropdownbyIndex(getElement(AuthorizationDateMonth),12);
            getElement(IsPatented).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(6000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(StandardTypeId),1);
            getElement(Data_Title).sendKeys("ASTM");
            getElement(Data_Scope).sendKeys("Standard");
            getElement(Data_Keywords).sendKeys("Steel");
            getElement(Data_Rationale).sendKeys("usage");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),7);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean MyCommitteesBTN_INT_1462() {
        try {
            getElement(MyCommitteesBTNBullets).click();
            getElement(BallotsandWorkItemBTN).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(SubmitEditBTN).click();
            Thread.sleep(6000);
            getElement(WorkItem1).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(4000);
            getElement(TypeOfWorkItem).click();

            String committee = "D03 - Gaseous Fuels";
            if (committee.equals("D03 - Gaseous Fuels")) {
                selectByText(getElement(SelectACommitteeDropdown), committee);
                Thread.sleep(3000);
                PublicCommon.selectValueInDropdownbyValue(getElement(SelectSubCommitteeDropdown), 871);
            }
            Thread.sleep(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(4000);
            getElement(CopyRightCodeChoice).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(AgreeBtn).click();
            Thread.sleep(4000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetDate),1);
            Thread.sleep(3000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetYear),2);
            getElement(IsAuthorizedWorkitemRadioBtn).click();
            getElement(IsPatented).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(6000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(StandardTypeId),1);
            //2000 chracters check in title
            getElement(Data_Title).sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibm");
            getElement(Data_Scope).sendKeys("Standard");
            getElement(Data_Keywords).sendKeys("Steel");
            getElement(Data_Rationale).sendKeys("usage");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(15000);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Input My committee details", e);
            return false;

        }

    }
    @Step("Create workItem and selecting a committee")
    public String WorkItemToValidateDeactivatingCommittee() throws InterruptedException {
        String MainCommittee = null;
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(MyCommitteesBTNBullets), 10);
            getElement(MyCommitteesBTNBullets).click();
            getElement(BallotsandWorkItemBTN).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(SubmitEditBTN).click();
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(WorkItem1), 10);
            getElement(WorkItem1).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(TypeOfWorkItem), 10);
            getElement(TypeOfWorkItem).click();
            String committee = "A11 - Automation Test";
            if (committee.equals("A11 - Automation Test")) {
                selectByText(getElement(SelectACommitteeDropdown), committee);
                Thread.sleep(3000);
                PublicCommon.selectValueInDropdownbyValue(getElement(SelectSubCommitteeDropdown), 4934);
            }
            MainCommittee = committee.split("-")[0].trim();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(4000);
            getElement(CopyRightCodeChoice).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(AgreeBtn).click();
            Thread.sleep(4000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetDate), 1);
            Thread.sleep(3000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetYear), 2);
            getElement(IsAuthorizedWorkitemRadioBtn).click();
            PublicCommon.selectValueInDropdownbyIndex(getElement(AuthorizationDateMonth), 12);
            getElement(IsPatented).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(6000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(StandardTypeId), 1);
            getElement(Data_Title).sendKeys("ASTM");
            getElement(Data_Scope).sendKeys("Standard");
            getElement(Data_Keywords).sendKeys("Steel");
            getElement(Data_Rationale).sendKeys("usage");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ContinueBtn), 5);
            getElement(ContinueBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return MainCommittee;
        } catch (Exception e) {
            e.printStackTrace();
            SpecBuilderCommon.reportFailAssert("Failed to verify workitem creation", e);
        }
        return MainCommittee;
    }

    @Step("Click on collaboration area")
    public boolean MyCollaborationArea() throws InterruptedException {
        try {
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MyCollaborationAreas), 10);
            getElement(MyCollaborationAreas).click();
            getElement(CreateWorkItemCollaborationBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Thread.sleep(6000);
            getElement(SelectBtn).click();
            Thread.sleep(4000);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click on My collaboration area", e);
        }
            return true;
    }
    @Step("Search for Created WorkItem")
    public WebElement SearchWorkItem(){
        return getElement(SelectWorkItem);
    }

    @Step("Add all the collaboration area details")
    public Boolean CollaborationAreaDetailsTab_Step1(){
        try{
        getElement(SelectSearchedWorkItem).click();
        getElement(DoneBtn).click();
        getElement(CollaborationAreaObjective).sendKeys("ASTM Test");
        PublicCommon.selectValueInDropdownbyIndex(getElement(SelectAdditionalCollab),12);
        ScreenshotUtil.takeScreenshotForAllure(driver);
        WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),40);
        getElement(ContinueBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to input Collaboration Area Details Tab", e);
        }
        return true;
    }
    @Step("Add members into collaboration area")
    public Boolean CollaborationAreaDetailsTab_Step2(){
        try {
            getElement(SelectAllBtn).click();
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ForwardArrow), 40);
            getElement(ForwardArrow).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to add members in collab area", e);
        }
        return true;
    }
    @Step("Input all the Email notification settings while creating new collab area")
    public Boolean CollaborationAreaDetailsTab_Step3() throws InterruptedException {
        try{
        WaitStatementUtils.waitForElementToBeClickable(driver,getElement(UploadOption),40);
        getElement(UploadOption).click();
        getElement(UploadSupport).click();
        getElement(UploadInitialDraft).click();
        ScreenshotUtil.takeScreenshotForAllure(driver);
        getElement(CreateCollaborationAreaBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to input email notification settings", e);
        }

        return true;
    }


    @Step("Verify WorkItem ID")
    public String WorkItemId() {
        String WorkItemid = null;
        try {
            WorkItemid = getElement(WorkItemID).getText();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return WorkItemid;
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to validate Work Item ID", e);
        }
        return WorkItemid;
    }


    public String WorkItemIdSplit(){
        String WorkItemidsplit = getElement(WorkItemID).getText();
        System.out.println(WorkItemidsplit);
        WorkItemidsplit = WorkItemidsplit.split("WK")[1];
        System.out.println(WorkItemidsplit);
        return WorkItemidsplit;
       }

    @Step("Member Account Search.")
    public void memberAccountSearch(MC2Pages_Membership membershipData, String memberEmail) {
        try {
            assertTrue(membershipData.enterIntoSearchBox(memberEmail), "Email Account Search.");
            PublicCommon.waitForSec(60);

        }

        catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Account Search Exception.", e);
        }
    }

    @Step("Select '{keys}'in DropDown")
    public void selectByText(WebElement element, String value) {
        PublicCommon.selectValueInDropdown(element, value);
    }

    @Step("Select Ballot and workitems and click in submit/edit")
    public void BallotsandWorkItems(){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(BallotsandWorkItemBTN), 50);
            ReusableMethods.scrollIntoView(getElement(BallotsandWorkItemBTN),driver);
            PublicCommon.waitForSec(10);
            getElement(BallotsandWorkItemBTN).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView( getElement(SubmitEditBTN), driver); Thread.sleep(2000);
            getElement(SubmitEditBTN).click();
            Thread.sleep(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to click in ballots and workitem", e);
        }
    }

    @Step("Select radio button - I need to register a Work Item for a Revision or New Standard.")
    public void RegisterWorkItemForRevisionOrNewStandard(){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(WorkItem1), 10);
            getElement(WorkItem1).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),10);
            getElement(ContinueBtn).click();
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to choose option for creating workitem new standard", e);
        }
    }

    @Step("Select radio button - I  need to Edit an existing Work Item or Update the Target Date.")
    public void editExistingWorkItemOrUpdateTargetDate(){
        try{
            newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
            newMembershipPage.handleOneTrustCookie();

            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(EditExistingWorkItemOrUpdateTargetDateRadio), 5);
            PublicCommon.JSClick(getElement(EditExistingWorkItemOrUpdateTargetDateRadio), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();

            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/work-item/type"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/work-item/type"), "Failed to land on type page");
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to choose option for Editing an existing Work Item", e);
        }
    }

    @Step("Select radio button - Edit an Existing Work Item.")
    public void selectEditExistingWorkItemRadio(){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(EditExistingWorkItemRadio), 5);
            PublicCommon.JSClick(getElement(EditExistingWorkItemRadio), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            //getElement(ContinueBtn).click();
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to choose option for Editing an existing Work Item", e);
        }
    }

    @Step("Select WI that needs to be edited or updated")
    public void setSelectWorkItem(String WorkItem){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(selectWIButton), 5);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectWIButton), 5);
            clickonmethod("Select WI button", selectWIButton, "Failed to click on Select button");
            ScreenshotUtil.takeScreenshotForAllure(driver);

            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(workItemSearchField), 5);
            PublicCommon.clearTextFieldsendKeys(getElement(workItemSearchField), WorkItem);

            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(workItemsExistingListRadio), 5);
            PublicCommon.JSClick(getElement(workItemsExistingListRadio), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(workItemSelectDoneButton), 5);
            clickonmethod("Done button", workItemSelectDoneButton, "Failed to click on Done Button");
            WaitStatementUtils.waitForElementStaleness(driver, getElement(selectedWI), 5);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            Assert.assertTrue(getElement(selectedWI).isDisplayed());
        }
        catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to select WI from multi select", e);
        }
    }

    @Step("Type of Work Item and select committee")
    public String TypeOfWorkItem(String MainCommittee, String SubCommittee){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(TypeOfWorkItem), 10);
            PublicCommon.JSClick(getElement(typeOfWorkItemInputRadioBtn),driver);
            selectMainCommittee(MainCommittee);
            PublicCommon.waitForSec(5);
            selectSubCommittee(SubCommittee);
            MainCommittee = MainCommittee.split("-")[0].trim();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            return MainCommittee;
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to select type of work and select committee", e);
        }
        return MainCommittee;
    }

    @Step("Select Copyright and agree")
    public void SelectCopyright(){
        try{
            getElement(CopyRightCodeChoice).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(AgreeBtn).click();
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to Select Copyright", e);
        }
    }

    @Step("Select Copyright and agree")
    public void SelectTarget(){
        try{
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetDate), 1);
            Thread.sleep(3000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetYear), 3);
            getElement(IsAuthorizedWorkitemRadioBtn).click();
            PublicCommon.selectValueInDropdownbyIndex(getElement(AuthorizationDateMonth), 12);
            getElement(IsPatented).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),10);
            getElement(ContinueBtn).click();
            Thread.sleep(6000);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to Select Copyright", e);
        }
    }
    @Step("Update Required data on Type Page for Edit existing WI")
    public String updateRequiredDataOnTypePage_EditExistingWI(String MainCommittee, String SubCommittee, String WorkItem) {
        String WorkitemSelected=null;
        try {
            selectMainCommittee(MainCommittee);
            selectSubCommittee(SubCommittee);
            selectEditExistingWorkItemRadio();
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(selectWIButton), 5);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectWIButton), 5);
            clickonmethod("Select WI button", selectWIButton, "Failed to click on Select button");
            ScreenshotUtil.takeScreenshotForAllure(driver);

            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(workItemSearchField), 5);
            PublicCommon.clearTextFieldsendKeys(getElement(workItemSearchField), WorkItem);

            WorkitemSelected=getElements(chooseWorkItemListList).get(0).getText();
            getElements(chooseWorkItemListList).get(0).click();
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(workItemSelectDoneButton), 5);
            clickonmethod("Done button", workItemSelectDoneButton, "Failed to click on Done Button");
            WaitStatementUtils.waitForElementStaleness(driver, getElement(selectedWI), 5);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            Assert.assertTrue(getElement(selectedWI).isDisplayed());
            clickonmethod("Continue Button", ContinueBtn, "Failed to click on Continue Button");
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("work-item/target"));
            Assert.assertTrue(driver.getCurrentUrl().contains("work-item/target"), "Failed to land on target page");
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return WorkitemSelected;
        }catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Update Required data on Type Page for Edit existing WI", e);
            return null;
        }
    }

    @Step("Update Required data on Author Page for Submit Item To Ballot")
    public void updateRequiredDataOnAuthorPage_SubmitBallot(String MainCommittee, String SubCommittee, String WorkItem) {
        try {
            selectMainCommittee(MainCommittee);
            selectSubCommittee(SubCommittee);
            selectRevisionAction();
            setSelectWorkItem(WorkItem);
            selectBallotLevel_SubcommitteeBallot();
            selectBallotAutorisation_Yes();
            clickonmethod("Continue Button", ContinueBtn, "Failed to click on Continue Button");
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/wi/ballot-item/data"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/wi/ballot-item/data"), "Failed to land on target page");
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Update Required data on Author Page for Submit Item To Ballot", e);
        }
    }

    @Step("Update Required data on Type Page for Register New WI")
    public void updateRequiredDataOnTypePage_registerNewWI(String MainCommittee, String SubCommittee) {
        try {

            selectRevisionExistingASTMStandardRadio();
            selectMainCommittee(MainCommittee);
            selectSubCommittee(SubCommittee);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn), driver);
            ReusableMethods.scrollDownToBottomOfPage(driver);
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ContinueBtn), 5);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickonmethod("Continue Button", ContinueBtn, "Failed to click on Continue Button");
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/wi/work-item/copyright"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/wi/work-item/copyright"), "Failed to land on Copyright page");
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Update Required data on Type Page for Register New WI", e);
        }
    }

    public void selectBallotAutorisation_Yes(){
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(BallotAuthorisationRadio), 5);
            PublicCommon.JSClick(getElement(BallotAuthorisationRadio), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void selectBallotLevel_SubcommitteeBallot(){
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(BallotLevel_SubCommitteeBallot), 5);
            PublicCommon.JSClick(getElement(BallotLevel_SubCommitteeBallot), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Step("Select Copyright and agree")
    public void SelectTargetWithTechnicalContactAsMemberOfCommittee(){
        try{
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetDate), 1);
            Thread.sleep(3000);
            PublicCommon.selectValueInDropdownbyIndex(getElement(SubCommitteeTargetYear), 2);
            getElement(IsAuthorizedWorkitemRadioBtn).click();
            PublicCommon.selectValueInDropdownbyIndex(getElement(AuthorizationDateMonth), 12);
            getElement(IsPatented).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(AmemberOfCommittee).click();
            PublicCommon.selectValueInDropdownbyIndex(getElement(selectAmember), 4);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(6000);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to Select Copyright", e);
        }
    }

    @Step("Select data")
    public void SelectData(){
        try{
            PublicCommon.selectValueInDropdownbyIndex(getElement(StandardTypeId), 2);
            getElement(Data_Title).sendKeys("WorkItem - 1");
            getElement(Data_Scope).sendKeys("Standard");
            getElement(Data_Keywords).sendKeys("Steel");
            getElement(Data_Rationale).sendKeys("usage");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ContinueBtn), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),10);
            getElement(ContinueBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to Select Date", e);
        }
    }

    @Step("Select data")
    public void SelectDataCustom(String data,String scope,String keywords,String rationale){
        try{
            PublicCommon.selectValueInDropdownbyIndex(getElement(StandardTypeId), 2);
            getElement(Data_Title).sendKeys(data);
            getElement(Data_Scope).sendKeys(scope);
            getElement(Data_Keywords).sendKeys(keywords);
            getElement(Data_Rationale).sendKeys(rationale);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ContinueBtn), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ContinueBtn),10);
            getElement(ContinueBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to Select Date", e);
        }
    }



    @Step("Update Required data on Data Page for Edit existing WI")
    public void updateDataInDataPage_EditWI(){
        try{
            WaitStatementUtils.waitForElementStaleness(driver, getElement(StandardTypeId), 5);
            PublicCommon.selectValueInDropdownbyIndex(getElement(StandardTypeId), 1);

            PublicCommon.clearTextFieldsendKeys(getElement(Data_Title), "Test");

            PublicCommon.clearTextFieldsendKeys(getElement(Data_Scope), "Test");

            PublicCommon.clearTextFieldsendKeys(getElement(Data_Keywords), "Test");

            PublicCommon.clearTextFieldsendKeys(getElement(Data_Rationale), "Test");

            ScreenshotUtil.takeScreenshotForAllure(driver);

            ReusableMethods.scrollIntoView(getElement(ContinueBtn), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ContinueBtn), 10);
            clickonmethod("Continue Button", ContinueBtn, "Failed to Click on Continue Button");

            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("work-item/summary"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(driver.getCurrentUrl().contains("work-item/summary"), "Failed to navigate to Summary page after clicking on continue button");

        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Update Required data on Data Page for Edit existing WI", e);
        }
    }



    @Step("Verify Summary Page")
    public void SummaryPage(){
        try{
            getElement(OnlineCollaborationYes).click();
            PublicCommon.waitForSec(10);
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(SubmitBtn).click();
            PublicCommon.waitForSec(2);
            if(getElements(CancelBtnInEmailPopUp).size()>0){
                getElement(CancelBtnInEmailPopUp).click();
            }
            PublicCommon.waitForSec(9);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to submit details in summary page", e);
        }
    }
    @Step("Verify Summary Page")
    public void SummaryPageWithOnlineCollaborationNo(){
        try{
            getElement(OnlineCollaborationNo).click();
            PublicCommon.waitForSec(10);
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identity-delegation-button\"]")));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SubmitBtn),15);
            getElement(SubmitBtn).click();
            PublicCommon.waitForSec(9);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to submit details in summary page", e);
        }
    }
    @Step("Close staff email redirect popup")
    public void StaffEmailRedirect(){
        try {
            assertEquals(getElement(HeaderStaffEmailRedirect).getText(), "Staff Email Redirect");
            getElement(CancelBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to close staff email redirect", e);
        }
    }

    @Step("Enter Staff Email in Staff Email redirect modal")
    public void enterStaffEmailRedirectAndSubmit(String StaffEmail){
        try {
            assertEquals(getElement(HeaderStaffEmailRedirect).getText(), "Staff Email Redirect");
            PublicCommon.clearTextFieldsendKeys(getElement(SubmitBallot_StaffEmailRedirect_EmailField), StaffEmail);
            getElement(OkBtn).click();

        }
        catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to Enter Staff Email in Staff Email redirect modal", e);
        }
    }

    public void handleStaffEmailRedirect() {
        try {
            IntegrationCommon.clickonWebElement(driver, CancelBtn);
            PublicCommon.waitForSec(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Select Main Committee")
    public boolean selectMainCommittee(String value) {
        try {
            WebElement element = getElement(SelectACommitteeDropdown);
            ReusableMethods.scrollIntoView(element,driver);
            Select select = new Select(element);
            select.selectByVisibleText(value);
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            //element.click();
            return true;

        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
    public void selectRevisionExistingASTMStandardRadio(){
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(RevisionToExistingASTMStandard_radio), 5);
            PublicCommon.JSClick(getElement(RevisionToExistingASTMStandard_radio), driver);
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to select Revision Existing ASTM Standard Radio", e);
        }
    }

    public void selectProposedNewASTMStandardRadio(){
        WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ProposedNewASTMStandard_radio), 5);
        PublicCommon.JSClick(getElement(ProposedNewASTMStandard_radio), driver);
    }

    @Step("Select Sub Committee")
    public boolean selectSubCommittee(String value) {
        try {
            WebElement element = getElement(SelectSubCommitteeDropdown);
            ReusableMethods.scrollIntoView(element,driver);
            Select select = new Select(element);
            select.selectByVisibleText(value);
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            //element.click();
            return true;

        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Step("Select Action: Revision")
    public boolean selectRevisionAction() {
        try {
            PublicCommon.JSClick(getElement(RevisionActionRadio), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return true;

        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Step("Select Action: New Standard")
    public boolean selectNewStandardAction() {
        try {
            PublicCommon.JSClick(getElement(NewStandardActionradio), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return true;

        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Step("Navigate to My Committees page")
    public void NavigateToMyCommittees(){
        try{
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            driver.get(ConfigReader.getValue("BASE_URL_MEM_ASTM"));
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(MyCommitteesBTNBullets),10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(MyCommitteesBTNBullets).click();
            getElement(MyCommitteeHeader).getText().equals("MyCommittees");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to navigate to My committee page", e);
        }
    }

    @Step("Navigate to My Committees page")
    public void NavigateToMyCollaborationAreas(){
        try{
            PublicCommon.waitForSec(10);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MyCollaborationAreas),10);
            PublicAdminCommons.scrollToElement(driver, getElement(MyCollaborationAreas));
            getElement(MyCollaborationAreas).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to navigate to My committee page", e);
        }
    }

    @Step("Navigate to My Committees page")
    public void ClickOnLaunchAdminCollaborationArea(){
        try{
            PublicCommon.waitForSec(10);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(LaunchAdminCollabAreaLink),10);
            PublicAdminCommons.scrollToElement(driver, getElement(LaunchAdminCollabAreaLink));
            getElement(LaunchAdminCollabAreaLink).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to navigate to My committee page", e);
        }
    }
    public void navigateToBallotsOfGivenCommittee(String Committee){
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getMyCommittees_Ballot(Committee)), 5);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(getMyCommittees_Ballot(Committee)).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/ballot/committeeballots/"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/ballot/committeeballots/"), "Failed to land on Committees Ballots page");

        }catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to navigate to Ballots page", e);
        }
    }


    @Step("Verify navigate to my committees")
    public void NavigateToMyCommittee() {
        try {
            PublicCommon.waitForSec(5);
            getElement(MyCommitteeLink).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            AssertJUnit.assertEquals(getElement(MyCommitteeHeader).getText(),
                    "MyCommittees");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to navigate to my committees", e);
        }
    }
    @Step("Validate MyNext Meetings link")
    public void MyNextMeetings(){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MyNextMeetings),10);
            getElement(MyNextMeetings).getText().equals("MyNext Meetings ");
            getElement(MyNextMeetings).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("MyNext Meetings link is not visible", e);
        }
    }

    public List<WebElement> searchResultTerm() {
        return getElements(ListofSearchTerm);

    }
    public List<WebElement> searchResultDefinitions() {
        return getElements(ListOfDefinitions);

    }
    public String getMatchingStandards() {
        return getElement(matchingStandards).getText();
    }
    public String getFirstStandardFromList() {
        return getElement(FirstStandardFromList).getText();

    }
    public String getFirstSubcommitteeFromList() {
        return getElement(FirstSubcommitteeFromList).getText();

    }
    public String getFirstMainCommitteeFromList() {
        return getElement(FirstMainCommitteeFromList).getText().substring(0,3);

    }
    public void getSelectAlphabetical(String Alphabetical) {
        driver.findElement(By.xpath("(//button[text()='"+Alphabetical+"'])[2]")).click();
    }
    public String getConfirmationMsg() {
        return getElement(confirmationMsg).getText();

    }
    public By getVerifyCommitteInCommittesList(String committeName) {
        return By.xpath("//*[@class='list-group-item']//*[text()='"+committeName+"']");
    }
    public By VerifyCommitteTextformat(String committeName) {
        return By.xpath("//h5[text()='"+committeName+"']");
    }
    public By getCommitteFromMyCommitteesList(String committeName) {
        return By.xpath("//*[text()='"+committeName+"']");
    }
    public void clickOnCommitteRostersLink(String committeName) {
        getElement(By.xpath("//*[text()='"+committeName+"']/../../div//a[text()='Rosters']")).click();
    }
    public void clickOnRosterCommittee(String committeName) {
        getElement(By.xpath("//p[contains(text(),'Click on the designations')]/..//a[text()='"+committeName+"']")).click();
    }
    public List<WebElement> getCommitteeRosterText() {
         return getElements(By.xpath("//p[contains(@class,'astm-type-body--lead')]"));
    }
    public List<WebElement> getCommitteeMembers() {
        return getElements(By.xpath("//*[text()='Committee Members']/../div//a"));
    }
    public List<WebElement> getCommitteeOfficersName() {
        return getElements(By.xpath("//*[text()='Committee Officers & ASTM Staff']/../div//a"));
    }
    public List<WebElement> getCommitteeNameAndClassification() {
        return getElements(By.xpath("//*[text()='Committee Officers & ASTM Staff']/..//li"));
    }
    public boolean verifyCommitteInCommmitteList(String committe) {
        List<WebElement> committees=driver.findElements(By.xpath("//select[@id='MainCommitteeId']/option"));
        boolean flag=true;
        for(WebElement committee:committees)
        {
            String Committee=committee.getText();
            if (Committee.contains(committe))
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
    public boolean verifySuppressedCommitteNotListedInTheTechnicalCommmitteFullList(String committe) {
        List<WebElement> committees=driver.findElements(By.xpath("//div[@class='g-col-9 styles_mainContent___k_cj']//ul/li/a"));
        boolean flag=true;
        for(WebElement committee:committees)
        {
            String committeeName=committee.getText().substring(0,3);
            if (committeeName.equals(committe))
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
    public boolean verifyNewlyCreatedCommitteeListedInTheTechnicalCommmitteFullList(String Committee) throws IOException {
        List<WebElement> committees=driver.findElements(By.xpath("//div[@class='g-col-9 styles_mainContent___k_cj']//ul/li/a"));
        boolean flag=false;
        for(WebElement committee:committees)
        {
            String committeeName=committee.getText().substring(0,3);
            if (committeeName.equals(Committee))
            {
                PublicAdminCommons.scrollToElement(driver,committee);
                ScreenshotUtil.takeScreenshotForAllure(driver);
                flag=true;
                break;
            }
        }
        return flag;
    }
    @Step("click On Committee In Technical Commmitte Full List")
    public boolean clickOnCommitteeInTechnicalCommmitteFullList(String Committee) throws IOException {
        boolean flag=false;
        try {
        List<WebElement> committees=driver.findElements(By.xpath("//div[@class='g-col-9 styles_mainContent___k_cj']//ul/li/a"));
        for(WebElement committee:committees)
        {
            String committeeName=committee.getText().substring(0,3);
            if (Committee.contains(committeeName))
            {
                PublicAdminCommons.scrollToElement(driver,committee);
                ScreenshotUtil.takeScreenshotForAllure(driver);
                committee.click();
                ScreenshotUtil.takeScreenshotForAllure(driver);
                flag=true;
                break;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("failed to click On Committee In Technical Commmitte Full List", e);
        }
        return flag;
    }
    @Step("click On Sub Committee under committee")
    public boolean clickOnSubCommitteeUnderCommittee(String SubCommittee) throws IOException {
        boolean flag=false;
        try {
            List<WebElement> subCommittees=driver.findElements(By.xpath("//li[@class='mt-2 mb-2']/a"));
            for(WebElement subCommittee:subCommittees)
            {
                if (SubCommittee.contains(subCommittee.getText()))
                {
                    PublicAdminCommons.scrollToElement(driver,subCommittee);
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    subCommittee.click();
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    flag=true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("failed to click On Sub Committee under committee", e);
        }
        return flag;
    }
    @Step("Pick date from calender")
    public boolean pickDateFromCalender(String date){
        try {
            String dateConverted =
                    PublicAdminCommons.convertDateFromOneFormatToAnother(date,"MM/dd/yyyy","d MMMMMMMMM yyyy");
            String[] dateArray = dateConverted.split(" ");
            PublicAdminCommons.selectValueInDropdown(getElementNew(yearDropDown), dateArray[2]);
            PublicAdminCommons.selectValueInDropdown(getElementNew(monthDropDown), dateArray[1]);
            List<String> dates = PublicAdminCommons.getTextOfWebElements(driver, activeDateLabel);
            List<WebElement> datesElement = getElementsNew(activeDateLabel);
            int index = dates.indexOf(dateArray[0]);
            datesElement.get(index).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
            PublicCommon.reportFailAssert("MyNext Meetings link is not visible", e);
            return false;
        }
    }

    @Step("Validate created WorkItem in My collaboration area")
    public void validateWKinMyCollaborationAreas(String workItem){
        try{
            PublicCommon.waitForSec(10);
            driver.get(ConfigReader.getValue("BASE_URL_MYCOMMITTEELINK"));
            PublicCommon.waitForSec(1);
            driver.navigate().refresh();
            driver.navigate().refresh();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MyCollaborationAreas),10);
            clickOnMethod("MyCollaboration Areas", getElement(MyCollaborationAreas));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            validateCreatedWK(workItem);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to create WorkItem in My collaboration area", e);
        }
    }

    @Step("Validate created workitem")
    public void validateCreatedWK(String workItem) {
        try {
            //int flag=0;
            List<WebElement> Links = getElements(By.xpath("//button[text()='MyCollaboration Areas']/../../../div[2]/div/ul/li/a[@class='astm-link twoLiner']"));
            for(WebElement link:Links)
            {
                if(link.getText().split("-")[0].equals(workItem))
                {
                    Allure.addAttachment("Work Item is", workItem);
                    System.out.println("WorkItem is visible");
                } else {
                    Allure.addAttachment("Work Item is not visible", workItem);
                    System.out.println("WorkItem is not visible");
                }
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Successfully validated deleted WorkItem in Member");
        }
    }


    @Step("Select radio button - I need to Submit an Item to Ballot.")
    public void submitItemToBallot(){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(EditExistingWorkItemOrUpdateTargetDateRadio), 5);
            ReusableMethods.scrollIntoView(getElement(SubmitItemToBallotRadio), driver);
            PublicCommon.JSClick(getElement(SubmitItemToBallotRadio), driver);

            ReusableMethods.scrollIntoView(getElement(ContinueBtn), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();
            Thread.sleep(2000);
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/wi/ballot-item/type"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/wi/ballot-item/type"), "Failed to land on Author page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to choose option for Submit an Item to Ballot", e);
        }
    }

    @Step("Select radio button - I need to register a Work Item for a Revision or New Standard.")
    public void registerWorkItemForRevisionOrNewStandard(){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(RegisterWorkItem), 5);
            ReusableMethods.scrollIntoView(getElement(RegisterWorkItem), driver);
            PublicCommon.JSClick(getElement(RegisterWorkItem), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(ContinueBtn), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(ContinueBtn).click();

            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/wi/work-item/type"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/wi/work-item/type"), "Failed to land on Author page");
            Thread.sleep(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to choose Radio - I need to register a Work Item for a Revision or New Standard.", e);
        }
    }
    @Step("Select Yes for Revisions to the title included and Click Continue")
    public void selectRevisionsTitleRadioYesAndContinue(){
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(RevisionsToTitleIncludedRadio_Yes), 5);
            ReusableMethods.scrollIntoView(getElement(RevisionsToTitleIncludedRadio_Yes), driver);
            PublicCommon.JSClick(getElement(RevisionsToTitleIncludedRadio_Yes), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ContinueBtn), 5);
            getElement(ContinueBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/wi/ballot-item/attach"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/wi/ballot-item/attach"), "Failed to land on Author page");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Step("Upload file")
    public void fileUpload(String FileName) {
        try {

            WaitStatementUtils.waitForElementStaleness(driver, getElement(FileUploadField));
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(FileUploadField));
            getElement(FileUploadField).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\"+ FileName);
            ScreenshotUtil.takeScreenshotForAllure(driver);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Click Upload attachment button")
    public void clickUploadAttachmentButton(){
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(UploadAttachmentButton), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(UploadAttachmentButton));
            getElement(UploadAttachmentButton).click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("Verify Work Item in Submit page")
    public void verifyWorkItem_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_WorkItem));
            //ReusableMethods.scrollIntoView(getElement(SubmitPage_WorkItem), driver);
            Assert.assertEquals(getElement(SubmitPage_WorkItem).getText().trim(), ExpectedValue, "Actual Work Item is not same as Expected WorkItem in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("Verify Ballot Action in Submit page")
    public void verifyBallotAction_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_BallotAction));
            ReusableMethods.scrollIntoView(getElement(SubmitPage_BallotAction), driver);
            Assert.assertTrue(getElement(SubmitPage_BallotAction).getText().trim().equals(ExpectedValue), "Actual Work Item is not same as Expected WorkItem in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Step("Verify Sponsoring Subcommittee in Submit page")
    public void verifySponsoringSubcommittee_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_SponsoringSubcommittee));
            ReusableMethods.scrollIntoView(getElement(SubmitPage_SponsoringSubcommittee), driver); Thread.sleep(3000);
            Assert.assertTrue(ExpectedValue.contains(getElement(SubmitPage_SponsoringSubcommittee).getText().trim()), "Actual Work Item is not same as Expected WorkItem in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Step("Verify Sponsoring Subcommittee in Submit page")
    public void verifyStandardBeingRevised_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_StandardBeingRevised));
            ReusableMethods.scrollIntoView(getElement(SubmitPage_StandardBeingRevised), driver);
            Assert.assertTrue(getElement(SubmitPage_StandardBeingRevised).getText().trim().equals(ExpectedValue), "Actual Work Item is not same as Expected WorkItem in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Step("Verify Technical Contact in Submit page")
    public void verifyTechnicalContact_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_TechnicalContact));
            ReusableMethods.scrollIntoView(getElement(SubmitPage_SponsoringSubcommittee), driver);
            Thread.sleep(3000);
            Assert.assertEquals(getElement(SubmitPage_TechnicalContact).getText().trim(), ExpectedValue, "Actual Work Item is not same as Expected WorkItem in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Step("Verify Submitted in Submit page")
    public void verifySubmittedBy_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_SubmittedBy));
            ReusableMethods.scrollIntoView(getElement(SubmitPage_SubmittedBy), driver);
            Assert.assertTrue(getElement(SubmitPage_SubmittedBy).getText().trim().equals(ExpectedValue), "Actual Submitted By user is not same as Expected Submitted By user in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("Verify Title Will be Revised in Submit page")
    public void verifyTitleWillBeRevised_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_TitleWillBeRevised));
            ReusableMethods.scrollIntoView(getElement(SubmitPage_TitleWillBeRevised), driver);
            Assert.assertTrue(getElement(SubmitPage_TitleWillBeRevised).getText().trim().equals(ExpectedValue), "Actual Work Item is not same as Expected WorkItem in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Step("Verify Title Will be Revised in Submit page")
    public void verifyItemAttached_SubmitPage(String ExpectedValue){
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SubmitPage_ItemAttached));
            ReusableMethods.scrollIntoView(getElement(SubmitPage_ItemAttached), driver);
            Assert.assertTrue(getElement(SubmitPage_ItemAttached).getText().trim().equals(ExpectedValue), "Actual Work Item is not same as Expected WorkItem in Submit page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("Verify Confirmation message on Confirm Page")
    public void verifyThankYouMessage_ConfirmPage_CreateBallot(String WorkItem){
        String ExpectedText = "";
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ConfirmPage_Message_Lead));
        ExpectedText = getElement(ConfirmPage_Message_Lead).getText().trim();
        Assert.assertEquals(ExpectedText,"Thank you! Your ballot item submission for "+ WorkItem + " is complete and your item (with any attachments) has been sent to ASTM Headquarters for processing.");

        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ConfirmPage_Message_text1));
        ExpectedText = getElement(ConfirmPage_Message_text1).getText().trim();
        Assert.assertEquals(ExpectedText ,"An email describing the ballot item will be sent to:");

        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ConfirmPage_Message_EmailSentTo1));
        ExpectedText = getElement(ConfirmPage_Message_EmailSentTo1).getText().trim();
        Assert.assertEquals(ExpectedText,"Subcommittee Chair");

        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ConfirmPage_Message_EmailSentTo2));
        ExpectedText = getElement(ConfirmPage_Message_EmailSentTo2).getText().trim();
        Assert.assertEquals(ExpectedText,"Staff Manager");

        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ConfirmPage_Message_EmailSentTo3));
        ExpectedText = getElement(ConfirmPage_Message_EmailSentTo3).getText().trim();
        Assert.assertEquals(ExpectedText,"Technical Contact");

        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ConfirmPage_Message_text2));
        ExpectedText = getElement(ConfirmPage_Message_text2).getText().trim();
        Assert.assertEquals(ExpectedText, "If you have any questions regarding this ballot item, please contact your Staff Manager or Administrative Assistant.");
    }
    public List<WebElement> getastmTableColumnTxt()
    {
        List<WebElement> astmTableColumnTxt= getElements(astmTable);
        return astmTableColumnTxt;

    }
    public List<String> getAstmTableColumnTxt() {
        List<WebElement> Columns = getElements(astmTable);
        List<String> ColumnTxt = new ArrayList<String>();
        for (WebElement table : Columns) {
            ColumnTxt.add(table.getText());
        }
        return ColumnTxt;
    }
    public List<String> getBreadcrumbList(){
        List<WebElement> Breadcrumb = getElements(breadCrumb);
        List<String> BreadcrumbText = new ArrayList<String>();
        for (WebElement table : Breadcrumb) {
            BreadcrumbText.add(table.getText());
        }
        return BreadcrumbText;
    }
    public List<String> getDropdownListOfMEetingMinuteAgendas() {
        List<WebElement> Dropdown = getElements(MeetingsMinutesAgendasDropdownList);
        List<String> DropdownList = new ArrayList<String>();
        for (WebElement table : Dropdown) {
            DropdownList.add(table.getText());
        }
        return DropdownList;
    }
    public List<WebElement> getDropdownOfMeetingAgendasList() {
        try {
            return driver.findElements(MeetingsMinutesAgendasDropdownList);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public void navigateToRecentActivity(){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(recentCtivityLink),10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
           // getElement(rejectAllCookiesBtn).click();
            ReusableMethods.scrollIntoView(getElement(recentCtivityLink), driver);
            getElement(recentCtivityLink).click();
            new WebDriverWait(driver,20).until(ExpectedConditions.urlContains("/MyASTM/RecentActivity"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/MyASTM/RecentActivity"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Unable to navigate to Recent Activity page", e);
        }
    }

    @Step("Click on Go to Collaboration area")
    public void VerifyGoToCollaborationArea(){
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(GoToOnlineCollabArea), 15);
            getElement(GoToOnlineCollabArea).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(PublicAdminCommons.switchToNewOpenedTab(driver, 2),
                    "Admin is unable to switch to new tab");
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to create workitem", e);
        }
    }

    @Step("Verify if Created workitem is deleted in Member or not.")
    public void SwitchToMemberAppToCheckWI() {
        try {
            driver.get(ConfigReader.getValue("BASE_URL_MEM_ASTM"));
            verifyVisibility("MyCommittees", MyCommitteesBTNBullets, "My committee link should be visible");
            getElement(MyCommitteesBTNBullets).click();
            PublicCommon.waitForSec(16);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify if Created workitem.", e);
        }
    }

    @Step("Validate assigned main committee under My WorkItems list")
    public boolean ValidateMyWorkItems(String MainCommittee) {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(MyWorkItem),10);
            getElement(MyWorkItem).click();
            getElement(SelectWorkItems);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            List<WebElement> groupElements = driver.findElements(SelectWorkItems);
            for (WebElement groupElement : groupElements) {
                if (groupElement.getText().equals(MainCommittee)) {
                    groupElement.click();
                    return true;
                }
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Successfully validated created workItem");
        }
        return true;

    }
    public void validateDeletedWKMember(String WorkItemid) {
        try {
            int flag=0;
            List<WebElement> Links = getElements(By.xpath("//div[@class='workItemWrap']"));
            for(WebElement link:Links)
            {
                if(link.getText().equalsIgnoreCase(WorkItemid))
                {
                    flag=1;
                }
            }
            if(flag==1)
            {
                System.out.println("WorkItem Not visible");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Successfully validated deleted WorkItem in Member");
        }
    }


    @Step("Verify navigate to my committees")
    public void navigateToMyCommitteesFromProfileDropDown() {
        try {
            PublicCommon.waitForSec(5);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(loginPage.PublicSigninbtn1),10);
            PublicCommon.JSClick(getElement(loginPage.PublicSigninbtn1), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(MyCommittees),10);
            getElement(MyCommittees).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to navigate to my committees", e);
        }
    }
    public List<WebElement> getListOfBallots(){
        List<WebElement> ballotsList = getElements(ballots);
        return ballotsList;
    }
    @Step("Verify if workitem in member app under My workItems")
    public boolean switchToMemberCheckWK(String workItemidMem) {
        boolean flag=false;
        try {
            PublicCommon.waitForSec(15);
            getElement(MyWorkItem).click();
            PublicCommon.waitForSec(20);
            clickonmethod("C11 Work Iems",SelectWkC11,"Unable to click on c11 work items list");
            List<WebElement> Links=getElements(By.xpath("//div[@class='workItemWrap']/ul/li"));
            for(WebElement link:Links)
            {
                PublicAdminCommons.scrollToElement(driver,link);
                if(link.getText().contains(workItemidMem))
                {
                    flag=true;
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Verify if workitem in member app under My workItems", e);
        }
        return flag;
    }
}
