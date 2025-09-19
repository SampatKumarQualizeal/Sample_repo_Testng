package pages.ui;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.utils.RandomStringUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class AdminAreaPage extends BasePage{

	public AdminAreaPage(WebDriver driver) {
		super(driver);
	}

	PollsDetailsPage poll;

	Homepage home=new Homepage(driver);
	SpecBuilderCommon spbCommon=new SpecBuilderCommon(driver);




	public By manageGroups = By.xpath("//div[@class='top-nav-display']//li[1]//a[contains(text(),'Group')] | //div[@class='top-nav-display']//li[2]");
	public By NewColabArea = By.xpath("(//table[@class='table astm-table table-striped--with-header']//tr)[2]");
	public By newGroup = By.xpath("//a[contains(@href,'group/create')]");
	public By Drafts = By.xpath("//a[text()='Drafts']");
	public By cloneGroup = By.xpath("//a[contains(@href,'group/clone')]");
	public By editGroup = By.xpath("//a[contains(@href,'group/edit-list')]");
	public By StaffeditGroup = By.xpath("//a[contains(text(),'Edit Staff Collaboration Area')]");
	public By deleteGroup = By.xpath("//a[contains(@href,'group/delete-list')]");
	public By userReports = By.xpath("//a[contains(@href,'group/reports')]");
	public By createNewGroupHeader = By.xpath("//div[contains(text(),'Create New ')]");
	public By editGroupHeader = By.xpath("//div[@class='astm-type-heading--h2' and contains(text(),'Edit ')]");
	public By deleteGroupHeader = By.xpath("//div[@class='astm-type-heading--h2' and contains(text(),'Select ')]");
	public By selectGroup = By.xpath("//label//following::select");
	public By StaffselectGroup = By.xpath("//select[contains(@title,'Select Staff Collaboration Area Administrator')]");
	public By groupName = By.name("groupName");
	public By memberSelector = By.xpath("//p[contains(text(),'Members')]//following::select[1]");
	public By addedMembersSelect = By.xpath("//p[contains(text(),'Members')]//following::select[2]");
	private By addToGroupArrowButton = By.xpath("//span[@class='fas fa-caret-circle-right']");
	private By removeFromGroupArrowButton = By.xpath("//span[@class='fas fa-caret-circle-left']");
	public By saveBtn = By.xpath("//button[@class='btn btn-sm btn-warning'][contains(.,'Save Group')]");
	public By savebtn = By.xpath("//button[@class='btn astm-btn--small astm-btn btn-primary'][contains(.,'Save')]");
	public By editSaveBtn = By.xpath("//div[@class='group-form-wrapper']//following::button[contains(text(),'Save ')]");
	public By searchMemberBox = By.xpath("//input[@name='searchMember']");
	public By selectAllBtn = By.xpath("//a[text()='Select All']");
	public By secondAdminSelect = By.xpath("//label[contains(text(),'Second ')]//following::select[1]");
	public By addDescription = By.xpath("//label[contains(text(),'Add ')]//following::textarea");
	public By parentGroupSelect = By.xpath("//label[contains(text(),'Parent ')]//following::select[1]");
	public By updateMsg = By.xpath("//div[text()=' Collaboration Group created/updated successfully']");
	public By groupNameCharacterErrorMsg= By.xpath("//div[contains(text(),'name is less than or equal to 50.')]");
	public By descCharacterErrorMsg = By.xpath("//div[contains(text(),'description is less than or equal to 255.')]");
	public By editGroupheader=By.className("astm-type-heading--h2");
	public By fileSuccessUpload = By.xpath("//span[text()='Sample.txt']");
	public By fileUploadSuccessForFiles = By.xpath("//*[text()='Sample.txt']");
	public By createGroupSuccess = By.xpath("//div[@role='alert' and contains(text(),'successfully')]");
	//create ballot
	public By managePolls = By.xpath("//a[text()='Manage Polls'] | //a[text()='Manage Ballots']");
	public By newPoll = By.xpath("//a[contains(@href,'ballot/create')]");
	public By editPollDetails = By.xpath("//a[contains(@href,'ballot/edit-list')]");
	public By deletepoll = By.xpath("//a[contains(@href,'ballot/delete')]");
	public By allVoteReport = By.xpath("//a[contains(@href,'ballot/vote-reports')]");
	public By createPollHeader = By.xpath("//div[contains(text(),'Create New ')]");
	public By editPollDetailsHeader = By.xpath("//div[contains(text(),'Edit ')]");
	public By pollName = By.xpath("//input[@placeholder='Insert Poll Name Here']");
	public By BallotName = By.xpath("//input[@placeholder='Insert Ballot Name Here']");
	public By pollSelectGroup = By.xpath("//div[@class='ballot-create-page-wrapper']//div[3]//child::select");
	public By pollSelectValue = By.xpath("//option[@title='103 - Groupxvk']");
	public By pollDescription = By.xpath("//div[@class='editor-input']");
	public By pollDescription_FirstParagraph = By.xpath("//div[@class='editor-input']/p/span");
	public By pollDescription_EmptyData = By.cssSelector(".editor-placeholder");



	public By BallotDescription = By.xpath("//div[@class='editor-input']");
	public By pollNameTwo = By.xpath("//div[@class='ballot-item']//div[@class='row'][1]//child::input");
	public By pollItemName2 = By.xpath("(//div[@class='ballot-item']//div[@class='row'][1]//child::input)[2]");
	public By removeBallotItemButton=By.xpath("//button[contains(text(),'Remove')]");

	public By PollChoicesWrapper = By.xpath("//div[@class='ballot-item']//div[@class='row']/div/div/div/div[@class='form-group astm-textinput-wrapper']");
	public By AddAdditonalChoicesBtn = By.xpath("//a[text()='Add Additional Choices']");
	public By Ballotitem = By.xpath("//div[@class='ballot-item']//div[@class='row'][1]//child::input");
	public By pollIssueDate = By.xpath("//label[text()='Open Immediately']");
	public By pollSetCustomDate = By.xpath("//label[text()='Set Custom Date']");
	public By pollSetCustomDateRadioBtn=By.xpath("//label[text()='Set Custom Date']//preceding-sibling::input");
	public By pollOpenDate =By.xpath("//label[text()='Set Custom Date']//following::div[2]//child::input[1]");
	public By clickToUpload = By.xpath("//div[text()='Click to Open']");
	public By emailNo = By.xpath("//label[contains(text(),'No: Do Not')]");
	public By emailYes = By.xpath("//label[contains(text(),'Yes: ')]");
	public By pollItemChoice = By.xpath("//div[@class='ballot-item']//div[@class='row'][2]//child::input[@type='text']");
	public By pollItemChoice1 = By.xpath("//div[@class='ballot-item']//div[@class='row'][3]//child::input[@type='text']");
	public By requireComment = By.xpath("//div[@class='ballot-item']//div[@class='row'][2]//following-sibling::label[contains(text(),'Require Comment')][1]");
	public By countAsVote = By.xpath("//div[@class='ballot-item']//div[@class='row'][2]//following-sibling::label[contains(text(),'Count as Vote')][1]");
	public By pollDate = By.xpath("//input[@id='rdp-form-control-4']");
	public By pollCloseDate = By.xpath("//div[text()=' Closing Date']//following::div[1]//child::input[1]");
	public By getPollCurrentText=By.xpath("//div[@class='rdp-header text-center']/div[2]");
	public By getPollCurrentNext=By.xpath("//div[@class='rdp-header text-center']/div[3]");
	public By percentagesAffirmative=By.xpath("//input[@placeholder='Percentage']");
	public By reviewPollBtn = By.xpath("//button[@aria-label='Review']");
	public By cookieCloseButton = By.xpath("//div[@role='alert']//button[@class='close']//span");
	public By submitPollBtn = By.xpath("//button[text()='Submit ']");

	public By saveTemplateNo=By.xpath("(//div[contains(text(),'Do you want to save the format of this ')]/following::div/descendant::input)[1]");

	public By saveTemplateYes=By.xpath("(//div[contains(text(),'Do you want to save the format of this ')]/following::div/descendant::input)[2]");
	public By TemplateName=By.xpath("//div[text()='Template Name']/following::div/descendant::input");
	public By TemplateDescription=By.xpath("(//div[@class='editor-input'])[2]");


	public By leavePopUp = By.xpath("//div[@class='modal-content']//child::div[contains(text(),'Are you')]");
	public By changesSavedMsg = By.xpath("//div[@class='modal-content']//child::div[contains(text(),'Changes you�ve')]");
	public By cancelButton = By.xpath("//div[@class='modal-content']//child::button[text()='Cancel']");
	public By leaveButton = By.xpath("//div[@class='modal-content']//child::button[text()='Leave']");
	public By reviewOpeningDate =By.className("ut-br-issue-date");
	public By reviewClosingDate =By.className("ut-br-closing-date");
	public By toastNotification=By.className("Toastify__toast-body");
	//Drafts
	public By manageDraft = By.xpath("//a[text()='Manage Drafts'] | //a[text()='Manage Draft Docs']");
	
	
	
	public By uploadDraftTab = By.xpath("//a[contains(@href,'draft/upload')]");
	public By deleteDraftTab = By.xpath("//a[contains(@href,'draft/delete')]");
	public By replaceDraft = By.xpath("//a[contains(@href,'draft/replace')]");
	public By SelectGroup = By.xpath("//select[contains(@title,'Select a Group')]");
	public By SelectGroupDraft = By.xpath("(//select[contains(@aria-label,'Select Value')])[1]");
	public By uploadDraftHeader = By.xpath("//div[contains(text(),'Upload New ')]");
	public By deleteDraftHeader = By.xpath("//div[contains(text(),'Delete ')]");
	public By newDraftName = By.xpath("//input[@class='form-control form-control']");
	public By selectGroupForDraft = By.xpath("//div[@class='draft-create-form-wrapper']//div[@class='row'][2]//select");
	public By setADraftFeedbackHeader = By.xpath("//div[text()='Set a ']");
	public By setADraftFeedBackYes = By.xpath("//input[@type='radio' and @value='Yes']");
	public By setADraftFeedBackNo = By.xpath("//input[@type='radio' and @value='No']");
	public By setADraftFeedBackTextBox = By.xpath("//div[@class='row'][3]//input[@type='text']");
	public By setADraftFeedBackInfoCircle = By.xpath("//i[@class='far fa-info-circle']");
	public By setADraftFeedBackInfo = By.xpath("//div[@class='astm-info-wrapper']//div");
	public By uploadAttachmentDraft = By.xpath("//div[text()='Upload Attachment']");
	public By uploadDraftClickToOpen = By.xpath("//div[text()='Click to Open']");
	public By UplaodDraftBtn=By.xpath("//button[contains(text(),'Upload')]");
	public By uploadAttachmenttext =By.xpath("//div[contains(text(),'The formatting requirements for ')]");
	public By reviewDraft = By.xpath("//button[contains(text(),'Review Submission')]");
	public By submitDraft = By.xpath("//button[contains(text(),'Submit ')]");
	public By Feedback = By.xpath("//input[contains(@value,'Yes')]");
	
	public By singleFile = By.xpath("//li[contains(text(),'Only a single ')]");

	public By backDraft = By.xpath("//button[contains(text(),'Back')]");
	public By createdDrafts = By.xpath("//div[@class='astm-type-heading--h5']");
	public By draftsList = By.xpath("//div[@class='astm-type-heading--h5']//following::select");
	public By deleteDraftTitle = By.xpath("//div[contains(text(),'Delete ')]");
	public By draftText = By.xpath("//div[contains(text(),'Select the')]");
	public By deleteDrafts = By.xpath("//div/div[2]/div[2]/div[2]//button[contains(text(),'Delete')]");
	public By deleteDraft = By.xpath("(//button[@class='btn astm-btn--small astm-btn btn-outline-danger'][contains(.,'Delete')])[1]");
	public By draftHeader = By.xpath("//div[text()='Upload New ']");
	public By draftReviewHeader = By.xpath("//div[@class='astm-type-heading--h4' and contains(text(),'Draft')]");
	public By draftReviewText = By.xpath("//div[contains(text(),'Your file is ready to ')]");
	public By draftTitle = By.xpath("//div[@class='detail']//div[2]//b[contains(text(),'Draft')]");
	public By draftColaborationGroup = By.xpath("//div[@class='detail']//div[3]//b[contains(text(),'Draft')]");
	public By AttachedItem = By.xpath("//b[contains(text(),'Attached Item: ')]");
	public By draftTitleValue = By.xpath("//div[@class='detail']//div[2]//b[contains(text(),'Draft')]//following::span[1]");
	public By draftColaborationGroupValue = By.xpath("//div[@class='detail']//div[3]//b[contains(text(),'Draft')]//following::span[1]");
	public By AttachedItemValue = By.xpath("//b[contains(text(),'Attached Item: ')]//following::span[1]");
	public By feedback = By.xpath("//b[text()='Feedback Deadline: ']");
	public By feedbackValue = By.xpath("//b[text()='Feedback Deadline: ']//following::span");
	public By getDraftNumber = By.xpath("//div[@class='astm-type-heading--h5']");
	public By draftFeedBackDate =By.xpath("//input[starts-with(@id,'rdp-form-control')]");
	//replace
	public By replaceDraftHeader = By.xpath("//a[contains(text(),'Replace Draft')]");
	public By replaceSelectGroup = By.xpath("//div[string()='Replace Draft']//following::select");
	public By draftToEditHeader = By.xpath("//select[@title='Select Draft']");
	public By replaceDraftSelect = By.xpath("//div[string()='Select Draft to Edit']//following::select");
	public By replaceDocFormatText = By.xpath("//div[contains(text(),'The formatting')]");
	public By replaceDragAndDropText = By.xpath("//div[contains(text(),'Drag and drop ')]");
	public By replaceReviewSubmission = By.xpath("//button[text()='Review Submission']");
	public By uploadfileInput =By.xpath("//input[@type='file']");
	public By replaceTitleText = By.xpath("//input[@type='text']");
	public By editedDraftTitle = By.xpath("//div[@class='draft-display-page-wrapper']//div[2]//div[@class='astm-type-heading--h4'][1]");
	public By uploadFilesButton = By.xpath("//button[text()='Upload ']");

	public By uploadFilesButtonNotDisabled = By.xpath("//div[@class='astm-file-btn-area']/button[not(@disabled)]");
	public By FileUploadConfirmation = By.xpath("//button[@Class=\"btn astm-btn btn-light\"]");
	public By progressBar = By.xpath("//div[@class='progress astm-progress the-progress']");
	public By twoFiveUploads=By.xpath("//div[@class='modal-body']/div");
	public By closeButton = By.xpath("//button[text()='Close']");
	public By exeMessage = By.xpath("//div[contains(text(),'Only files with the following ')]");
	//
	//public By groupNameHeader = By.xpath("//label[contains(text(),'Name of')]");
	public By groupNameHeader = By.xpath("//label[contains(text(),'Select Committee')]");
	public By ScheduleOnlineMeeting = By.xpath("//a[contains(text(),'Schedule Online Meeting')]");
	public By Overview = By.xpath("//a[contains(text(),'Overview')]");
	public By Members = By.xpath("//a[contains(text(),'Members')]");
	public By History = By.xpath("//a[contains(text(),'History')]");
	
	
	public By primaryAdminSelectHeader = By.xpath("div[contains(text(),'Note:')]//preceding::label[contains(text(),'Collaboration Area')]");
	//
	//public By primaryAdminSelectHeader = By.xpath("//select[@aria-label='Select Value']//preceding::label[contains(text(),'Collaboration Group')]");
	public By primaryAdminLabel = By.xpath("//label[contains(text(),'Collaboration Group')]//following::select[@aria-label='Select Value'][1]//option[@value='0']");
	public By secondaryAdminSelectHeader = By.xpath("//select[@aria-label='Select Value']//preceding::label[contains(text(),'Second')]");
	public By secondaryAdminSelectLabel	 = By.xpath("//label[contains(text(),'Second')]//following::select[@aria-label='Select Value'][1]//option[@value='0']");
	public By parentAdminSelectHeader = By.xpath("//select[@aria-label='Select Value']//preceding::label[contains(text(),'Parent')]");
	public By parentAdminSelectLabel = By.xpath("//label[contains(text(),'Parent')]//following::select[@aria-label='Select Value'][1]//option[@value='0']");
	//public By descriptionHeader = By.xpath("//label[contains(text(),'Add')]");
	public By descriptionHeader = By.xpath("//label[contains(string(),'Administrative Collaboration Area Title')]");
	public By addMemberHeader = By.xpath("//div[@id='find-member']");
	public By findMember = By.xpath("//label[contains(text(),'Find a')]");
	public By findMemberLabel = By.xpath("//input[@name='searchMember']");
	public By additonalMember = By.xpath("//div[contains(text(),'Additional')]");
	public By enterCommaText = By.xpath("//div[contains(text(),'Enter comma')]");
	public By managerEmailHeader = By.xpath("//div[contains(text(),'Manage Email')]");
	public By theseSettingsText = By.xpath("//div[contains(text(),'These settings')]");
	public By uploadOptionsHeader = By.xpath("//div[contains(text(),'Upload')]");
	//EditGroupText
	public By editGrpHeader = By.xpath("//a[contains(text(),'Edit Collaboration Area')]");
	public By StaffeditGrpHeader = By.xpath("//a[contains(text(),'Edit Staff Collaboration Area')]");
	public By editSelectGrpHeader = By.xpath("//label[contains(text(),'Select')]");
	public By selectLabel = By.xpath("//select[@aria-label='select group']//option[@value='0']");
	public By additionalGrpAdmin = By.xpath("//label[contains(text(),'Additional')]");
	public By selectAdditionalGrpAdmin = By.xpath("//label[contains(text(),'Additional')]//following::select[@aria-label='Select Value'][1]//option[@value='0']");
	public By editGrpObjective = By.xpath("//label[contains(text(),'Edit')]");
	public By editGrpText = By.xpath("//label[contains(text(),'Edit')]//following::textarea[contains(text(),'Sample')]");
	public By editGrpMembers = By.xpath("//div[@id='find-member'] ");
	public By findMemText = By.xpath("//label[contains(text(),'Find')]");
	public By techBoldText = By.xpath("//div[@class='bold-text'] ");
	public By addNonCommitteeHeader = By.xpath("//div[contains(text(),'Add Non')]");
	public By enterCommaTextData = By.xpath("//div[contains(text(),'Enter')]");
	public By quickSaveBtn = By.xpath("//button[@aria-label='Quick Save']");
	public By manageEmailHeader = By.xpath("//div[contains(text(),'Manage Email')]");
	public By theseSettingText = By.xpath("//div[contains(text(),'These settings')]");
	public By newCollaHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Colla')]");
	public By newCollabLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Colla')]//following::label[1]");
	public By editCollabHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'Edit Colla')]");
	public By editCollabLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'Edit Colla')]//following::label[1]");
	public By newBallotHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Ballot')]");
	public By newBallotLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Ballot')]//following::label[1]");
	public By votingHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'Voting Re')]");
	public By votingReminderLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'Voting Re')]//following::label[1]");
	public By newDiscussionHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Dis')]");
	public By newDiscussionsLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Dis')]//following::label[1]");
	public By discussionReplyHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'Discussion ')]");
	public By disReplyLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'Discussion ')]//following::label[1]");
	public By newDraftHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Draft')]");
	public By newDraftLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'New Draft')]//following::label[1]");
	public By newFileHeader = By.xpath("//div[@class='email-setting-label' and contains(string(),'New File')]");
	public By newFileLabel = By.xpath("//div[@class='email-setting-label' and contains(string(),'New File')]//following::label[1]");
	public By allUserDraft = By.xpath("//label[contains(string(),'All users can upload Draft')]");
	public By allDraftLabel = By.xpath("//input[@name='uploadAllCan' and @value='No']//following::label[1]");
	public By allUserSupport = By.xpath("//label[contains(string(),'All users can upload support')]");
	public By allSupportLabel = By.xpath("//input[@name='uploadAllSupportCan' and @value='No']//following::label[1]");
	//Drafts
	public By selectGrpHeaderForDraft = By.xpath("//div[contains(text(),'Select a')]");
	public By selectGrpLabelForDraft = By.xpath("//div[contains(text(),'Select a')]//following::select//option[@value='0']");
	public By selectReplaceDraftHeader = By.xpath("//div[contains(text(),'Select')]");
	public By selectGrpReplaceDraftLabel = By.xpath("//div[@class='astm-type-heading--h5'][contains(.,'Select Collaboration Area')]");
	public By deleteDraftHeaderText = By.xpath("//div[@class='astm-type-heading--h4' and contains(text(),'Delete')]");
	public By SubGroupTab = By.xpath("//a[@class='nav-link'][contains(.,'Sub-Groups')]");
	
	public By OverViewTab = By.xpath("//a[@class='nav-link active'][contains(.,'Overview')]");
	public By MembersTab = By.xpath("//a[@class='nav-link'][contains(.,'Members')]");
	public By HistoryTab = By.xpath("//a[@class='nav-link'][contains(.,'History')]");
	public By EditGroupTab = By.xpath("//a[@class='nav-link'][contains(.,'Edit Group')]");
	public By deletePollHeaderText = By.xpath("//div[@class='astm-type-heading--h4'][contains(.,'Delete Ballots')]");
	public By deleteDraftLabel = By.xpath("//div[@class='astm-type-heading--h4' and contains(text(),'Delete')]//following::div[contains(text(),'Select')]");
	//
	public By retturnToFilesButton = By.xpath("//button[text()='Return to Files & Folders']");
	public By workItemName = By.xpath("//div[@class='astm-type-heading--h1' and contains(text(),'Edit')]//following::div[1]//div[@class='mb-2']");
	public By selectCommittee = By.xpath("//select[@aria-label='Select Value']");
	public By maxFileUploadErrorMessage = By.xpath("//div[@class='modal-content']//div[@class='modal-body']//child::div");
	public By voteChoice=By.xpath("(//div[contains(text(),'Note: User must select')]/parent::div/following-sibling::div/descendant::select)[1]");
	public By voteChoice2=By.xpath("(//div[contains(text(),'Note: User must select')]/parent::div/following-sibling::div/descendant::select)[2]");
	public By voteChoice3=By.xpath("(//div[contains(text(),'Note: User must select')]/parent::div/following-sibling::div/descendant::select)[3]");

	public By BallotItem1voteChoice=By.xpath("((//div[contains(text(),'Note: User must select')])[2]/parent::div/following-sibling::div/descendant::select)[1]");
	public By BallotItem1voteChoice2=By.xpath("((//div[contains(text(),'Note: User must select')])[2]/parent::div/following-sibling::div/descendant::select)[2]");
	public By BallotItem1voteChoice3=By.xpath("((//div[contains(text(),'Note: User must select')])[2]/parent::div/following-sibling::div/descendant::select)[3]");
	public By VoteChoiceBanner=By.xpath("//div[@class='text-danger special-msg']");
	public By AffirmativeInput=By.xpath("//input[@value='Affirmative']");
	public By NegativeInput=By.xpath("//input[contains(@value,'Negative')]");
	public By AbstainInput=By.xpath("//input[@value='Abstain']");
	public By percentageAffirmativeRequired = By.xpath("//div[contains(text(),'Percentage Affirmative Required for Items to Pass:  ##%')]//input");
	public By percentageReturnedRequired = By.xpath("(//input[@placeholder='Percentage'])[2]");
	public By addAdditionalBallotItemBtn = By.xpath("//button[contains(text(),'Add Additional')]");

	public By spbLoader=By.xpath("//div[@class='astm-spinner spinner-border']");
	public By creteBallotfromTemplateSection=By.xpath("//div[contains(text(),'Templates cannot be used to create Recirculation')]/../div/..");

	public By bltRecircualtionYesRadio=By.xpath("(//div[contains(text(),'Is this a recirculation?')]/following-sibling::div/descendant::input[@value='false'])[2]");
	public By bltRecirwithTempWarningDialog=By.xpath("//div[@class='modal-content']");
	public By bltRecirwithTempWarningDialogCloseBtn=By.xpath("(//button[@class='close'])[2]");

	public By bltRecirwithTempWarningMsg1=By.xpath("//h5[@class='modal-title']/div");
	public By bltRecirwithTempWarningMsg2=By.xpath("//div[@class='modal-body']/div");
	public By bltRecirwithTempWarningCancelBtn=By.xpath("//button[contains(text(),'Cancel')]");
	public By bltRecirwithTempWarningContinueBtn=By.xpath("//button[contains(text(),'Continue')]");


	public By createBallotfromTemplateNoRadio=By.xpath("//div[contains(text(),'Templates cannot be used to create Recirculation')]/following-sibling::div/descendant::input[@value='yes']");


	public By createBallotfromTemplateYesRadio=By.xpath("//div[contains(text(),'Templates cannot be used to create Recirculation')]/following-sibling::div/descendant::input[@value='no']");
	public By selectTemplateDD=By.xpath("//div[text()='Select Template']/following-sibling::div/descendant::select");
	public By saveVote = By.xpath("//button[text()='Save Vote']");
	public By AffVote=By.xpath("//div[@class='radio-group']/div[1]/input");
	public By reminder1=By.xpath("//label[text()='Reminder 1:']/following::input[1]");
	public By reminder2=By.xpath("//label[text()='Reminder 1:']/following::input[2]");
	public By reminder3=By.xpath("//label[text()='Reminder 1:']/following::input[3]");
	public By RTEDD=By.xpath("//i[@class='chevron-down']");
	public By RTEUndo=By.xpath("//i[@class='format undo']");
	public By RTERedo=By.xpath("//i[@class='format redo']");
	public By RTEFormatBold=By.xpath("//i[@class='format bold']/parent::button");
	public By RTEFormatItalic=By.xpath("//i[@class='format italic']/parent::button");
	public By RTEFormatUndeline=By.xpath("//i[@class='format underline']/parent::button");
	public By RTEFormatStrikeThrough=By.xpath("//i[@class='format strikethrough']/parent::button");
	public By RTEFormatLink=By.xpath("//i[@class='format link']/parent::button");
	public By linkEdit=By.xpath("//div[@class='link-edit']");
	public By linkInput=By.xpath("//input[@class='link-input']");
	public By ballotName_ReviewPage=By.xpath("//div[@class='ballot-review-wrapper']/div[3]/span");
	public By groupName_ReviewPage=By.xpath("//div[@class='ballot-review-wrapper']/div[5]/span");
	public By descriptionLabel_ReviewPage=By.xpath("//div[@class='ballot-review-wrapper']/div[6]/b");
	public By RTENormalText=By.xpath("(//span[text()='Description1']/parent::p)[2]");
	public By RTEHeading1=By.xpath("(//span[text()='Description2']/parent::h1)[2]");
	public By RTEHeading2=By.xpath("(//span[text()='Description3']/parent::h2)[2]");
	public By RTEUnorderedList=By.xpath("(//span[text()='Description4']/parent::li/parent::ul)[2]");
	public By RTEOrderedList=By.xpath("(//span[text()='Description5']/parent::li/parent::ol)[2]");
	public By RTEBold=By.xpath("(//Strong[text()='Description6'])[2]");
	public By RTEItalic=By.xpath("(//em[text()='Description7'])[2]");
	public By RTEUnderLine=By.xpath("(//span[text()='Description8'])[2]");
	public By RTEStriketThrough=By.xpath("(//span[text()='Description9'])[2]");
	public By RTELink=By.xpath("(//span[text()='Description10']/parent::a)[2]");
	public By RTENormalText2=By.xpath("(//span[text()='Description11']/parent::p)[2]");
	public By RTENormalText3=By.xpath("(//span[text()='Description12']/parent::p)[2]");
	public By RTEEditedBold2=By.xpath("(//Strong[text()='Description11']/parent::p)[2]");
	public By RTEEditedItalic2=By.xpath("(//em[text()='Description12'])[2]");

	public By pollName_AfterBallotSubmission=By.xpath("//div[@class='top-layout']/../div");
	public By NormalText_AfterBallotSubmission=By.xpath("//span[text()='Description1']/parent::p");
	public By Heading1_AfterBallotSubmission=By.xpath("//span[text()='Description2']/parent::h1");
	public By Heading2_AfterBallotSubmission=By.xpath("//span[text()='Description3']/parent::h2");
	public By UnorderedList_AfterBallotSubmission=By.xpath("//span[text()='Description4']/parent::li/parent::ul");
	public By OrderedList_AfterBallotSubmission=By.xpath("//span[text()='Description5']/parent::li/parent::ol");
	public By Bold_AfterBallotSubmission=By.xpath("//Strong[text()='Description6']");
	public By Italic_AfterBallotSubmission=By.xpath("//em[text()='Description7']");
	public By UnderLine_AfterBallotSubmission=By.xpath("//span[text()='Description8']");
	public By StriketThrough_AfterBallotSubmission=By.xpath("//span[text()='Description9']");
	public By Link_AfterBallotSubmission=By.xpath("//span[text()='Description10']/parent::a");
	public By NormalText2_AfterBallotSubmission=By.xpath("//span[text()='Description11']/parent::p");
	public By NormalText3_AfterBallotSubmission=By.xpath("//span[text()='Description12']/parent::p");

	public By PercentageAffTextBallotReviewPage=By.xpath("//b[contains(text(),'Percentage Affirmative Required for Items to Pass:')]/parent::div/span");
	public By PercentageReturnedBallotReviewPage=By.xpath("//b[contains(.,'Ballot Percent Returned Required')]/parent::div/span");

	public By PercentageAffTextBallotReviewPage_BallotReports=By.xpath("//b[contains(text(),'Percentage Affirmative Required for Items to Pass:')]/parent::div");
	public By PercentageReturnedBallotReviewPage_BallotReports=By.xpath("//b[contains(.,'Ballot Percent Returned Required')]/parent::div");
	public By BallotReviewPageBackButton=By.xpath("//button[contains(text(),'Back')]");
	public By ballotName_ViewReport=By.cssSelector(".shift-text");
	public By ballotDescriptionLabel_ViewReport=By.xpath("//div[@class='rd-header']/div[2]/b");
	public By normalText_ViewReport=By.xpath("//div[@class='editor-inner']/descendant::p[1]/span");
	public By headingText1_ViewReport=By.xpath("//h1/span");
	public By headingText2_ViewReport=By.xpath("//h1/following-sibling::h2/span");
	public By unOrderedList_ViewReport=By.xpath("//ul[@class='editor-list-ul']/li/span");
	public By orderedList_ViewReport=By.xpath("//ol[@class='editor-list-ol']/li/span");
	public By strongText_ViewReport=By.xpath("//strong");
	public By italicText_viewReport=By.xpath("//em");
	public By undelineText_viewReport=By.cssSelector(".editor-text-underline");
	public By strikeThrogh_viewReport=By.cssSelector(".editor-text-strikethrough");
	public By linkText_viewReport=By.xpath("//a[@class='editor-link ltr']/span");
	public By editedBoldText_ViewReport=By.xpath("(//strong)[2]");
	public By editedItalicText_ViewReport=By.xpath("(//span[@class='editor-text-underline'])[2]");





















	public String getMaxFileUploadError() {
		try {
			String value = getElement(maxFileUploadErrorMessage).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public boolean selectCommitte(String commName) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectCommittee));
			WebElement element = getElement(selectCommittee);
			element.click();
			Select select = new Select(element);
			String value = commName;
			select.selectByVisibleText(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	public boolean groupUnderParentGroupDropdown(String id, String name) {
		try {
			WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Parent ')]//following::select[1]//option[text()='"+id+" - "+name+"']"));
			return element.isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public void clickOnRichTextEditorDDOptions(int i) {
		try {
			WebElement element = driver.findElement(By.xpath("//div[@class='dropdown']/button["+i+"]"));
			WaitStatementUtils.waitForElementToBeClickable(driver,element,30);
			element.click();
		}
		catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Unable to click on Dropdown Options",e);
		}
	}
	
	public By getNotificationStatus(String name) {
		return By.xpath("//input[@name='"+ name+"' and @checked]");
	}
	
	public void selectGroup() {
		getElement(selectGroup).click();
		
	}
	
	public boolean subGroupTab() {
		try {
			getElement(SubGroupTab).isDisplayed();
		//	Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	public boolean OverViewTab() {
		try {
			getElement(OverViewTab).isDisplayed();
		//	Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	public boolean MembersTab() {
		try {
			getElement(MembersTab).isDisplayed();
		//	Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	public boolean HistoryTab() {
		try {
			getElement(HistoryTab).isDisplayed();
		//	Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	public boolean EditGroupTab() {
		try {
			getElement(EditGroupTab).isDisplayed();
		//	Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public String getGroupName() {
		try {
		String value = getElement(groupName).getAttribute("value");
		return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	
	
	public String getTextValue(By locator) {
		try {
			String value = getElement(locator).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getTextValue1(By locator) {
		try {
			String value = getElement(locator).getAttribute("value");
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public boolean groupUnderList(String id, String name) {
		try {
		//	WebElement element = driver.findElement(By.xpath("//select//option[@value='"+id+"']"));
			String value = driver.findElement(By.xpath("//select//option[text()='"+id+" - "+name+"']")).getAttribute("value");
			WebElement element = driver.findElement(By.xpath("//select//option[@value='"+value+"']"));
			return element.isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectGroupUnderList() {
		try {
		//	WebElement element = driver.findElement(By.xpath("//select//option[@value='"+id+"']"));
			WebElement element = driver.findElement(By.xpath("//select[@aria-label='Select Value']"));
			element.click();
			Thread.sleep(3000);
			Select select = new Select(element);
//			String value= id+" - "+name;
//			select.selectByVisibleText(value);
			select.selectByIndex(2);
			 return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	@Step("Click on Drafts Tab")
	public void clickOnDraft() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(Drafts),60);
			ReusableMethods.scrollIntoView(getElement(Drafts),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(Drafts),45);
			getElement(Drafts).click();
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Click on Drafts Tab", e);
		}
	}
	public String selectWorkItemAndGetName() {
		try {
			WebElement element = driver.findElement(By.xpath("//select[@aria-label='select group']"));
	//		element.click();
	//		Thread.sleep(3000);
			Select select = new Select(element);
			select.selectByVisibleText("C03 - Chemical-Resistant Nonmetallic Materials (Disbanded 11/2020)");
			String name =getElement(workItemName).getText();
			System.out.println("Name is      ======================================================"+name);
			return name;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	public boolean parentGroupUnderList(String id, String name) {
		try {
		//	WebElement element = driver.findElement(By.xpath("//select//option[@value='"+id+"']"));
			WebElement element = driver.findElement(By.xpath("//select//option[text()='"+id+" - "+name+"']"));
			return element.isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects first person in list to add in the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public boolean selectGroupInListOfGroups(int index) {
		try {
			WebElement element = getElement(selectGroup);
			Select select = new Select(element);
			select.selectByIndex(index);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects first person in list to add in the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public String selectFirstPersonInListToAddToGroup() {
		try {
			Thread.sleep(2000); //need to remove this
			wait.until(ExpectedConditions.visibilityOf(getElement(memberSelector)));
			WebElement element = getElement(memberSelector);
			Select select = new Select(element);
			select.selectByIndex(0);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println("To be Added name: " +value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	/**
	 * Selects first person in list to remove from the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public String selectFirstPersonInListToRemoveFromGroup() {
		try {
			wait.until(ExpectedConditions.visibilityOf(getElement(addedMembersSelect)));
			WebElement element = getElement(addedMembersSelect);
			Select select = new Select(element);
			select.selectByIndex(0);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println(value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String clickOnRemovingMember() {
		try {
			Thread.sleep(4000); //need to remove this
			ReusableMethods.scrollIntoView(getElement(addedMembersSelect), driver);
			wait.until(ExpectedConditions.visibilityOf(getElement(addedMembersSelect)));
			WebElement element = getElement(addedMembersSelect);
			Select select = new Select(element);
			select.selectByIndex(0);
			WebElement text = select.getFirstSelectedOption();	
			String getValue = text.getAttribute("value");
			System.out.println(getValue);
			WebElement member = driver.findElement(By.xpath("//p[contains(text(),'Members')]//following::select[2]//option[@value=" + getValue + "]"));
			member.click();
			String mem = member.getText();
			System.out.println("Removing member: "+mem);
			return mem;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	/**
	 * Click Add to Group Left button
	 * 
	 * @return
	 */
	public boolean clickAddToGroupArrowButton() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(addToGroupArrowButton));
			getElement(addToGroupArrowButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	public boolean selectMember(String value) {
		try {
			Thread.sleep(2000); //need to remove this
			getElement(searchMemberBox).sendKeys(value);
			getElement(selectAllBtn).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean enterDraftName(String value) {
		try {
			getElement(newDraftName).clear();
			getElement(newDraftName).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean editDraftName(String value) {
		try {
			getElement(replaceTitleText).clear();
			getElement(replaceTitleText).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectGroupToDraft(String id, String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectGroupForDraft));
			WebElement element = getElement(selectGroupForDraft);
			element.click();
			Select select = new Select(element);
			String value= id+" - "+name;
			select.selectByVisibleText(value);
		//	select.selectByValue(id);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectGroupToCreateDraft(String id) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectGroupForDraft));
			WebElement element = getElement(selectGroupForDraft);
			element.click();
			Select select = new Select(element);
			select.selectByValue(id);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public String selectGroupToDraftAndGetValue(String id, String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectGroupForDraft));
			WebElement element = getElement(selectGroupForDraft);
			element.click();
			Select select = new Select(element);
			String comboName = id+" - "+name;
			select.selectByVisibleText(comboName);
			//select.selectByValue(id);
			WebElement text = select.getFirstSelectedOption();	
			String getText= text.getText();
			String getValue = text.getAttribute("value");
			//return "#"+getValue+" - "+getValue+" - "+getText;
			return "#"+getText;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public boolean setDateYesterday() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate today = LocalDate.now();
			LocalDate past = today.minusDays(1);
			String date = dtf.format(past);
			getElement(setADraftFeedBackYes).click();
			getElement(setADraftFeedBackTextBox).clear();
			getElement(setADraftFeedBackTextBox).sendKeys(date);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public String setDateTomorrow() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate today = LocalDate.now();
			LocalDate past = today.plusDays(1);
			String date = dtf.format(past);
			getElement(setADraftFeedBackYes).click();
			getElement(setADraftFeedBackTextBox).clear();
			getElement(setADraftFeedBackTextBox).sendKeys(date);
			return date;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getTodayDate() {
		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String date = dateObj.format(formatter);
		log.info("Todate:"+date);
		return date;
	}

	public String getTommorrowDate() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate today = LocalDate.now();
			LocalDate past = today.plusDays(1);
			String date = dtf.format(past);
			if(Integer.parseInt(date.split("/")[1])<10)
			{
				return date.split("/")[1].substring(1);
			}
			else
			return date.split("/")[1];
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public void setDateTomorrowForpolls(String Date) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(pollCloseDate),30);
			getElement(pollCloseDate).click();
			Thread.sleep(2000);
			WebElement ele=driver.findElement(By.xpath("//td[text()='"+Date+"']"));
			ele.click();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void enterPercentagesAffirmative () {
		try {
			if(getElement(percentagesAffirmative).isDisplayed()) {
				ReusableMethods.scrollIntoView(getElement(percentagesAffirmative), driver);
				getElement(percentagesAffirmative).clear();
				getElement(percentagesAffirmative).sendKeys(RandomStringUtils.getRandomNumbers(1));
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public String setOpenDateWeekForpolls() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate today = LocalDate.now();
			LocalDate past = today.plusDays(7);
			String date = dtf.format(past);
			getElement(pollOpenDate).click();
			getElement(pollOpenDate).clear();
			getElement(pollOpenDate).sendKeys(date);
			return date;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String setDateWeekForpolls() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate today = LocalDate.now();
			LocalDate past = today.plusDays(7);
			String date = dtf.format(past);
			getElement(pollCloseDate).click();
			getElement(pollCloseDate).clear();
			getElement(pollCloseDate).sendKeys(date);
			return date;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * Set the Date in MM/dd/yyyy format
	 * @param locator
	 * @param currentDateHowManyPlusDays
	 * @return True/false
	 */
	public boolean setDateForpolls(By locator, int currentDateHowManyPlusDays) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate today = LocalDate.now();
			LocalDate newDate = today.plusDays(currentDateHowManyPlusDays);
			String date = dtf.format(newDate);
		    WebElement ele=	getElement(locator);
			//ele.click();
			ele.clear();
			ele.sendKeys(date);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	/**
	 * Click Add to Group Right button
	 * 
	 * @return
	 */
	public boolean clickRemoveFromGroupArrowButton() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(removeFromGroupArrowButton));
			getElement(removeFromGroupArrowButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Click create group button
	 * 
	 * @return
	 */
	public boolean clickEditGroupButton() {
		try {
			getElement(editGroup).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}


	public boolean selectOptionFromListOfGroupsDropDown(String value, String name) {
		try {
			Thread.sleep(5000); //need to remove this
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectGroup));
			WebElement element = getElement(selectGroup);
			element.click();
			Select select = new Select(element);
			String display = value+" - "+name;
			System.out.println(display);
			select.selectByVisibleText(display);
			//select.selectByValue(value);
			Thread.sleep(10000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
/**
 * Select the Group to Edit By its Index value	
 * @param indexValue
 * @return
 */
	public boolean selectOptionFromListOfGroupsDropDown(int indexValue) {
		try {
			Thread.sleep(5000); //need to remove this
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectGroup));
			WebElement element = getElement(selectGroup);
			Select select = new Select(element);
			select.selectByIndex(indexValue);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * Click Save button
	 * 
	 * @return
	 */
	public boolean clickSaveButton() {
		try {
			ReusableMethods.scrollIntoView(getElement(savebtn), driver);
			getElement(savebtn).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	public String getNameToCompare() {
		try {
			Thread.sleep(2000); //need to remove this
			ReusableMethods.scrollIntoView(getElement(addedMembersSelect), driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(addedMembersSelect));
			WebElement element = getElement(addedMembersSelect);
			Select select = new Select(element);
			List<WebElement> count = select.getOptions();
			int size = count.size();
			select.selectByIndex(size-1);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println("Added name: "+value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	

	public String getRemovedNameToCompare() {
		try {
			Thread.sleep(2000); //need to remove this
			wait.until(ExpectedConditions.visibilityOfElementLocated(memberSelector));
			ReusableMethods.scrollIntoView(getElement(memberSelector), driver);
			WebElement element = getElement(memberSelector);
			Select select = new Select(element);
			List<WebElement> count = select.getOptions();
			int size = count.size();
			select.selectByIndex(size-1);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println("removed name: "+value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}


	public String editGroupName() {
		try {
			ReusableMethods.scrollIntoView(getElement(groupName), driver);
			getElement(groupName).clear();
			getElement(groupName).sendKeys("Test"+ RandomStringUtils.getRandomString(5));
			String value = getElement(groupName).getAttribute("value");
			System.out.println(value);
			return value;
			}
			catch (Exception e) {
				e.getStackTrace();
				return null;
			}
	}
	

	public String editSecondGroupAdmin() {
		try {
			Thread.sleep(3000); //need to remove
			ReusableMethods.scrollIntoView(getElement(secondAdminSelect), driver);
			wait.until(ExpectedConditions.visibilityOf(getElement(secondAdminSelect)));
			WebElement element = getElement(secondAdminSelect);
			Select select = new Select(element);
			select.selectByIndex(2);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println(value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	

	public String editDescriptionOfGroup() {
		try {
			ReusableMethods.scrollIntoView(getElement(addDescription), driver);
			getElement(addDescription).clear();
			getElement(addDescription).sendKeys("This is updated description");
			String value = getElement(addDescription).getAttribute("value");
			return value;
			}
			catch (Exception e) {
				e.getStackTrace();
				return null;
			}
	}
	

	public String addParentGroup(String secondGroupId, String secondGrpName) {
		try {
			Thread.sleep(3000); //need to remove
			ReusableMethods.scrollIntoView(getElement(parentGroupSelect), driver);
			wait.until(ExpectedConditions.visibilityOf(getElement(parentGroupSelect)));
			WebElement element = getElement(parentGroupSelect);
			Select select = new Select(element);
			String comboName  = secondGroupId+" - "+secondGrpName;
			select.selectByVisibleText(comboName);
			//select.selectByValue(secondGroupId);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println(value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public boolean notifications(String name) throws InterruptedException {
		Thread.sleep(3000); //need to remove
	//	ReusableMethods.scrollIntoView(getElement(parentGroupSelect), driver);
		String value = getElement(getNotificationStatus(name)).getAttribute("value");
		String yesValue = "Yes";
		if(value==yesValue) {
			getElement(By.xpath("//input[@name='"+name+"' and @value='No']")).click();
		}
		else
			getElement(By.xpath("//input[@name='"+name+"' and @value='Yes']")).click();
		return true;
	}
	

	public boolean updateSuccessMsg() {
		try {
			getElement(updateMsg).isDisplayed();
			return true;
			}
			catch (Exception e) {
				e.getStackTrace();
				return false;
			}
	}
	
	

	public String getGroupNameErrorMessage() {
		try {
			String value = getElement(groupNameCharacterErrorMsg).getText();
			getElement(groupNameCharacterErrorMsg).isDisplayed();
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	

	public boolean validateRequiredFieldErrorPopup() {
		try {
			String message = driver.switchTo().alert().getText();
			System.out.println(message);
			if(message.contains("name is less than or equal to 50.")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	public String getDescriptionErrorMessage() {
		try {
			String value = getElement(descCharacterErrorMsg).getText();
			getElement(descCharacterErrorMsg).isDisplayed();
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	

	
	@Step("enterPollName")
	public boolean enterPollName(String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pollName));
			getElement(pollName).sendKeys(name);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("enterPollName")
	public boolean enterBallotName(String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(BallotName));
			getElement(BallotName).sendKeys(name);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	@Step("enterPollNamemax255charts")
	public boolean enterPollNames(String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pollName));
			getElement(pollName).sendKeys(name);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	public boolean selectGroupAdminToPoll() {
		try {
			ReusableMethods.scrollIntoView(getElement(pollSelectGroup), driver);
			WebElement element = getElement(pollSelectGroup);
			Select select = new Select(element);
			select.selectByIndex(4);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectGroupAdminToPolls() {
		try {
			ReusableMethods.scrollIntoView(getElement(pollSelectGroup), driver);
			WebElement element = getElement(pollSelectGroup);
			Select select = new Select(element);
			select.selectByIndex(4);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	public boolean selectGroupAdminToPoll(String id, String name) {
		try {
			
			
			ReusableMethods.scrollIntoView(getElement(pollSelectGroup), driver);
			WebElement element = getElement(pollSelectGroup);
			Select select = new Select(element);
			element.click();
//			WebElement elemen = getElement(pollSelectValue);
//			elemen.click();
//		    select.selectByValue(id);
			String value = id+" - "+name;
			System.out.println(value);
			select.selectByVisibleText(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	public boolean enterPollDescription(String desc) {
		try {
			getElement(pollDescription).sendKeys(desc);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean enterBallotDescription(String desc) {
		try {
			getElement(BallotDescription).sendKeys(desc);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	public boolean enterPollItemName(String item) {
		try {
			getElement(pollNameTwo).sendKeys(item);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean enterPollItemName2(String item) {
		try {
			getElement(pollItemName2).sendKeys(item);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean CheckPollChoices(){
		try{
			getElement(PollChoicesWrapper);
			List<WebElement> groupElements = driver.findElements(PollChoicesWrapper);
			Assert.assertTrue(groupElements.size()==5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(getElement(AddAdditonalChoicesBtn).getText().equals("Add Additional Choices")){
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AddAdditonalChoicesBtn),5);
				getElement(AddAdditonalChoicesBtn).click();
				List<WebElement> groupElements1 = driver.findElements(PollChoicesWrapper);
				Assert.assertTrue(groupElements1.size()==10);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return true;
	}

	public boolean selectGroupAdminToPoll(String name) {
		try {
			ReusableMethods.scrollIntoView(getElement(pollSelectGroup), driver);
			WebElement element = getElement(pollSelectGroup);
			Select select = new Select(element);
			element.click();
			//String value = id+" - "+name;
			System.out.println(name);
			select.selectByVisibleText(name);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}


	public boolean enterPollItemChoiceSection() {
		try {
			getElement(pollItemChoice).clear();
			getElement(pollItemChoice).sendKeys("Affirmative");
			getElement(pollItemChoice1).clear();
			getElement(pollItemChoice1).sendKeys("Affirmative");
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean fileUpload() {
		try {
			ReusableMethods.scrollIntoView(getElement(uploadFilesButton),driver);
			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Sample.txt");
			getElement(progressBar).isDisplayed();
			ReusableMethods.scrollIntoView(getElement(uploadFilesButton),driver);
			if(checkElementPresent(uploadFilesButtonNotDisabled)) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadFilesButton),70);
				PublicCommon.JSClick(getElement(uploadFilesButton),driver);
			}
			Thread.sleep(8000);
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
			}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("failed to upload File",e);
			return false;
		}
	}

	public boolean multiplefileUpload_26() {
		try {
			Assert.assertFalse(getElement(uploadFilesButton).isEnabled(),"Upload Files Button Should not be Disabled Initially");
			String concatenatedtwosixFilesPath=System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample1.txt"+"\n"+
										 	System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample2.txt"+"\n"+
										  	System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample3.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample4.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample5.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample6.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample7.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample8.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample9.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample10.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample11.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample12.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample13.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample14.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample15.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample16.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample17.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample18.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample19.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample20.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample21.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample22.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample23.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample24.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample25.txt"+"\n"+
											System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample26.txt";
			getElement(uploadfileInput).sendKeys(concatenatedtwosixFilesPath);
			PublicCommon.waitForSec(10);
			Assert.assertTrue(getElement(twoFiveUploads).isDisplayed(),"A maximum of 25 files can be uploaded at the same time message should be displayed");
			Assert.assertTrue(getElement(twoFiveUploads).getText().equals("A maximum of 25 files can be uploaded at the same time."),"A maximum of 25 files can be uploaded at the same time message should be matched");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(closeButton).click();
			PublicCommon.waitForSec(2);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean multiplefileUpload_25() {
		try {
			Assert.assertFalse(getElement(uploadFilesButton).isEnabled(),"Upload Files Button Should not be Disabled Initially");
			String concatenatedtwoFiveFilesPath=
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample1.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample2.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample3.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample4.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample5.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample6.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample7.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample8.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample9.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample10.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample11.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample12.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample13.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample14.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample15.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample16.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample17.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample18.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample19.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample20.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample21.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample22.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample23.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample24.txt"+"\n"+
					System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Multiple_Files\\Sample25.txt";
			getElement(uploadfileInput).sendKeys(concatenatedtwoFiveFilesPath);
			PublicCommon.waitForSec(10);
			getElement(progressBar).isDisplayed();
			ReusableMethods.scrollIntoView(getElement(uploadFilesButton),driver);
			if(checkElementPresent(uploadFilesButtonNotDisabled)) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadFilesButton),70);
				PublicCommon.JSClick(getElement(uploadFilesButton),driver);
			}
			Thread.sleep(8000);
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(2);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean fileUpload_Draft() {
		try {
			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Sample.docx");
			getElement(progressBar).isDisplayed();
			ReusableMethods.ScrollIntoViewDrop(driver);
			//WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadFilesButton),70);
			if(checkElementPresent(uploadFilesButtonNotDisabled)) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(uploadFilesButton).click();
			}
			Thread.sleep(8000);
			//PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(8000);
			PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean fileUploadMembership(int i) {
		try {
				WebElement uploadfileInputxls=driver.findElement(By.xpath("//input[@type='file']"));
				ReusableMethods.scrollIntoView(uploadfileInputxls,driver);
				uploadfileInputxls.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\testResource\\Sample.xlsx");
				WebElement uploadFilesButtonxls=driver.findElement(By.xpath("//button[text()='Upload']"));
				uploadFilesButtonxls.click();
				WebElement removeCommentAtt=driver.findElement(By.xpath("(//button[contains(text(),'Remove')])["+i+"]"));
				return true;
	}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean fileUploadDifferentFile() {
		try {

			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\SampleDoc.txt");
			getElement(progressBar).isDisplayed();
			ReusableMethods.ScrollIntoViewDrop(driver);
			//WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uploadFilesButton),70);
			if(checkElementPresent(uploadFilesButtonNotDisabled)) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(uploadFilesButton).click();
			}
			Thread.sleep(8000);
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fileUploadWithInvalidFile() {
		try {
			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\WebDrivers\\chromedriver.exe");
			return true;
			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fileUploadFirstFile() {
		try {
			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Sample.txt");
			return true;
			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fileUploadSecondFile() {
		try {
			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\SampleDoc.txt");
			return true;
			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fileUploadThirdFile() {
		try {
			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testResource\\Sample1.txt");
			return true;
			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fileUploadSuccessForPoll() {
		try {
				fileUpload();
				if(getElement(fileSuccessUpload).isDisplayed())
					return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean fileUploadSuccessForFilesAndFolder() {
		try {
			WebElement element = driver.findElement(By.xpath("//button[text()='Return to Files & Folders']"));
			ReusableMethods.ScrollIntoViewsu(driver);
				fileUpload();
				 //Assert.assertTrue(validateRequiredFieldErrorPopup("uploaded"), "Files uploaded successfully");
				if(element.isDisplayed()) {
					Thread.sleep(2000);

					ReusableMethods.scrollIntoView(element, driver);
					//public By retturnToFilesButton = By.xpath("//button[text()='Return to Files & Folders']");
					getElement(retturnToFilesButton).click();
					Thread.sleep(3000);
					return true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean fileUploadSuccessForMultipleFiles_26() {
		try {
			WebElement element = driver.findElement(By.xpath("//button[text()='Return to Files & Folders']"));
			ReusableMethods.ScrollIntoViewsu(driver);
			multiplefileUpload_26();
			if(element.isDisplayed()) {
				Thread.sleep(2000);

				ReusableMethods.scrollIntoView(element, driver);
				//public By retturnToFilesButton = By.xpath("//button[text()='Return to Files & Folders']");
				getElement(retturnToFilesButton).click();
				Thread.sleep(3000);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean fileUploadSuccessForMultipleFiles_25() {
		try {
			WebElement element = driver.findElement(By.xpath("//button[text()='Return to Files & Folders']"));
			ReusableMethods.ScrollIntoViewsu(driver);
			multiplefileUpload_25();
			if(element.isDisplayed()) {
				Thread.sleep(2000);

				ReusableMethods.scrollIntoView(element, driver);
				//public By retturnToFilesButton = By.xpath("//button[text()='Return to Files & Folders']");
				getElement(retturnToFilesButton).click();
				Thread.sleep(3000);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean enterPercentageAffirmative(String item) {
		try {
			getElement(percentageAffirmativeRequired).sendKeys(item);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean enterPercentageReturned(String item) {
		try {
			getElement(percentageReturnedRequired).sendKeys(item);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean enterReminders(String Reminder1,String Reminder2,String Reminder3) {
		try {
			int i=0;
			ArrayList list=new ArrayList();
			list.add(Reminder1);list.add(Reminder2); list.add(Reminder3);
			for(i=1;i<=3;i++)
			{
				WebElement ele=driver.findElement(By.xpath("//label[text()='Reminder 1:']/following::input["+i+"]"));
				ele.clear();
				ele.sendKeys(list.get(i-1).toString());
			}
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	/**
	 * @param stringToValidate
	 * @return
	 */
	public boolean validateRequiredFieldErrorPopup(String stringToValidate) {
		boolean flag = false;
		try {
			
			Thread.sleep(6000); //need to remove this
			String message = driver.switchTo().alert().getText();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			if (message.contains(stringToValidate))
			{flag = true;
			
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return flag;
	}
	
	public void fileUploadForExe(By locator) throws Exception {
		try {
			getElement(locator).click();
			Thread.sleep(3000);
			StringSelection filetocopy = new StringSelection(System.getProperty("user.dir")+"\\src\\main\\resources\\WebDrivers\\chromedriver.exe");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filetocopy, null);
			Thread.sleep(1000);
			Robot re = new Robot();
			re.keyPress(KeyEvent.VK_CONTROL);
			re.keyPress(KeyEvent.VK_V);
			re.keyRelease(KeyEvent.VK_V);
			re.keyRelease(KeyEvent.VK_CONTROL);
			re.keyPress(KeyEvent.VK_ENTER);
			re.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public boolean fileUploadForExe() {
		try {
			getElement(uploadfileInput).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\WebDrivers\\chromedriver.exe");
			return true;
			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateAddedMembersNameIsPresent(String member) {
		try {
		getElement(addedMembersSelect);
		List<WebElement> groupElements = driver.findElements(addedMembersSelect);
		for(WebElement groupElement : groupElements) {
			if(groupElement.getText().equals(member)) 
				return true;
			}
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
		
}
	
	public boolean validateRemovedMembersNameIsPresent(String member) {
	try {
		getElement(memberSelector);
		List<WebElement> groupElements = driver.findElements(memberSelector);
		for(WebElement groupElement : groupElements) {
			if(groupElement.getText().equals(member)) 
				return true;
		}
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
}


	public boolean validateRequiredFieldDelete() {
		try {
			driver.switchTo().alert().accept();
				return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	
	public String getDraftNumber() {
		try {
		String value = getElement(getDraftNumber).getText();
		return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	

	public boolean selectDraftToEditDraft() {
		try {
			WebElement element = getElement(replaceDraftSelect);
			Select select = new Select(element);
			select.selectByIndex(1);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	  @Step("Finding elementeditgroup on Page")
	public boolean selectGroupToEditDraft(String id, String name) {
		try {
			WebElement element = getElement(replaceSelectGroup);
			Select select = new Select(element);

			//select.selectByVisibleText(id);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			select.selectByValue(id);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	public boolean selectDraftToEditDraft(String id) {
		try {
			WebElement element = getElement(replaceDraftSelect);
			Select select = new Select(element);
			select.selectByValue(id);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickOnSetCustomDate() {
		try {
			getElement(pollSetCustomDateRadioBtn).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	
	public void createNewBallotWithOutClickingReview(String name, String desc, String itemName) {
		try {
			Thread.sleep(2000);
			enterPollName(name);
			enterPollDescription(desc);
			selectGroupAdminToPoll();
			//setDateTomorrowForpolls();
			enterPollItemName(itemName);
			fileUpload();
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Step("Admin creates new ballot")
	public boolean createNewBallot(String grpName, String name, String desc, String itemName, String id) {
		try {
			Thread.sleep(2000);
			enterPollName(name);
			enterPollDescription(desc);
			selectGroupAdminToPoll(id,grpName);
			//setDateTomorrowForpolls();
			enterPollItemName(itemName);
			fileUpload();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.ScrollIntoViews(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewPollBtn),20));
			getElement(reviewPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitPollBtn),30));
			getElement(submitPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
//			WebElement alert=getElement(toastNotification);
//			WaitStatementUtils.explicitWaitForVisibility(driver,alert);
//			if(getElement(poll.successMsg).isDisplayed())
//			return true;
//			else 
//				return false;
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}
	
	public boolean createNewBallotWithCustomDate(String id,String grpName, String name, String desc, String itemName) {
		try {
			Thread.sleep(2000);
			enterPollNames(name);
			Thread.sleep(2000);
			selectGroupAdminToPolls();
			Thread.sleep(2000);
			enterPollDescription(desc);
			//setDateTomorrowForpolls();
			enterPollItemName(itemName);
			fileUpload();
			ReusableMethods.ScrollIntoView(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewPollBtn),150)) {
				getElement(reviewPollBtn).click();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitPollBtn),60)) {
				ReusableMethods.ScrollIntoView(driver);
				getElement(submitPollBtn).isDisplayed();
				getElement(submitPollBtn).click();
			}
//			WebElement alert=getElement(toastNotification);
//			WaitStatementUtils.explicitWaitForVisibility(driver,alert);
//			if(getElement(poll.successMsg).isDisplayed())
//				return true;
//				else 
//					return false;
			return true;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean createNewBallotWithChoiceSection(String id,String grpName, String name, String desc, String itemName) {
		try {
			Thread.sleep(2000);
			enterPollName(name);
			Thread.sleep(1000);
			selectGroupAdminToPoll(id,grpName);
			Thread.sleep(1000);
			enterPollDescription(desc);
			//setDateTomorrowForpolls();
			enterPollItemName(itemName);
			enterPollItemChoiceSection();
			ReusableMethods.ScrollIntoView(driver);
			fileUpload();
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewPollBtn),20));
			getElement(reviewPollBtn).click();
			//if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitPollBtn),30));
			//ReusableMethods.ScrollIntoView(driver);
			//getElement(submitPollBtn).isDisplayed();
			//getElement(submitPollBtn).click();
//			WebElement alert=getElement(toastNotification);
//			WaitStatementUtils.explicitWaitForVisibility(driver,alert);
//			if(getElement(poll.successMsg).isDisplayed())
//				return true;
//				else 
//					return false;
			return true;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean CreateNewBallotWithCustomDate(String id,String grpName, String name, String desc, String itemName) {
		try {
			Thread.sleep(2000);
			enterPollName(name);
			Thread.sleep(1000);
			selectGroupAdminToPoll(id,grpName);
			Thread.sleep(1000);
			enterPollDescription(desc);
			//setDateTomorrowForpolls();
			enterPollItemName(itemName);
			ReusableMethods.ScrollIntoView(driver);
			
			return true;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}



	public boolean createDraft(String draftName) {
		try {
			PublicCommon.waitForSec(7);
			//getElement(Drafts).click();
			enterDraftName(draftName);
			PublicCommon.waitForSec(7);
			// needs to be removed when switched to QA data
			fileUpload();
			ReusableMethods.ScrollIntoView(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewDraft),20));
			getElement(reviewDraft).click();
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitDraft),20));
			getElement(submitDraft).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean createDraftWithDoc(String draftName) {
		try {
			PublicCommon.waitForSec(7);
			//getElement(Drafts).click();
			enterDraftName(draftName);
			PublicCommon.waitForSec(7);
			// needs to be removed when switched to QA data
			fileUpload_Draft();
			ReusableMethods.ScrollIntoView(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewDraft),20));
			getElement(reviewDraft).click();
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitDraft),20));
			getElement(submitDraft).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public String getLeavingMsg() {
		try {
		String value = getElement(leavePopUp).getText();
		return value;
		}
		catch (Exception e) {
			
			e.getStackTrace();
			return null;
		}
	}
	
	public String getSaveChangesText() {
		try {
		String value = getElement(changesSavedMsg).getText();
		return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public boolean selectVoteChoice() {
		try {
			Assert.assertTrue(getElement(VoteChoiceBanner).isDisplayed(),"Vote Choices Banner Should Be Displayed");
			Assert.assertTrue(getElement(AffirmativeInput).isDisplayed(),"Affirmative Input Should Be Enabled");
			Assert.assertTrue(getElement(NegativeInput).isDisplayed(),"Negative Input Should Be Enabled");
			Assert.assertTrue(getElement(AbstainInput).isDisplayed(),"Abstain Input Should Be Enabled");
			spbCommon.SelectValueDropDownByIndex(getElement(voteChoice),1);
			spbCommon.SelectValueDropDownByIndex(getElement(voteChoice2),2);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}



	public boolean selectVoteChoice3() {
		try {
			Assert.assertTrue(getElement(VoteChoiceBanner).isDisplayed(),"Vote Choices Banner Should Be Displayed");
			Assert.assertTrue(getElement(AffirmativeInput).isDisplayed(),"Affirmative Input Should Be Enabled");
			Assert.assertTrue(getElement(NegativeInput).isDisplayed(),"Negative Input Should Be Enabled");
			Assert.assertTrue(getElement(AbstainInput).isDisplayed(),"Abstain Input Should Be Enabled");
			spbCommon.SelectValueDropDownByIndex(getElement(voteChoice),1);
			spbCommon.SelectValueDropDownByIndex(getElement(voteChoice2),2);
			spbCommon.SelectValueDropDownByIndex(getElement(voteChoice3),1);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean selectAdditionalBallotItemVoteChoice3() {
		try {
			spbCommon.SelectValueDropDownByIndex(getElement(BallotItem1voteChoice),1);
			spbCommon.SelectValueDropDownByIndex(getElement(BallotItem1voteChoice2),2);
			spbCommon.SelectValueDropDownByIndex(getElement(BallotItem1voteChoice3),1);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Admin creates new ballot")
	public boolean createNewBallot(String grpName, String name, String desc, String itemName,String PerAff, String PerReturn) {
		try {
			enterPollDescription(desc);
			selectGroupAdminToPoll(grpName);
			enterBallotName(name);
			PublicCommon.waitForSec(5);
			String Date=getTommorrowDate();
			ReusableMethods.scrollIntoView(getElement(pollCloseDate),driver);
			setDateTomorrowForpolls(Date);
			try {
				enterPercentageAffirmative(PerAff);
				enterPercentageReturned(PerReturn);
			}catch(Exception e) {
				e.getStackTrace();
			}
			enterPollItemName(itemName);
			selectVoteChoice();
			fileUpload();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.ScrollIntoViews(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewPollBtn),20));
			getElement(reviewPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.waitForSec(5);
			PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			ReusableMethods.scrollIntoView(getElement(submitPollBtn),driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitPollBtn),30));
			getElement(submitPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Uanble to Create Ballot with Given Details",e);
			}
		return false;
	}


	@Step("Admin creates new ballot")
	public boolean createNewBallotWithTemplate(String grpName, String name, String desc, String itemName,String itemName2,String template,String templateName,String PerAff, String PerReturn,String Reminder1,String Reminder2,String Reminder3,String AdditionalItemReq) {
		try {
			Thread.sleep(2000);
			enterPollDescription(desc);
			selectGroupAdminToPoll(grpName);
			enterBallotName(name);
			PublicCommon.waitForSec(5);
			String Date=getTommorrowDate();
			ReusableMethods.scrollIntoView(getElement(pollCloseDate),driver);
			setDateTomorrowForpolls(Date);
			try {
				enterPercentageAffirmative(PerAff);
				enterPercentageReturned(PerReturn);
				enterReminders(Reminder1,Reminder2,Reminder3);
			}catch(Exception e) {
				e.getStackTrace();
			}
			enterPollItemName(itemName);
			selectVoteChoice();
			fileUpload();
			if(AdditionalItemReq.equals("Yes"))
			{
			getElement(addAdditionalBallotItemBtn).click();
			enterPollItemName2(itemName2);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.ScrollIntoViews(driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewPollBtn),20));
			getElement(reviewPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.waitForSec(5);
			PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			verifyVisibility("Save Template No radio",saveTemplateNo,"Save Templte as No radio Button Should be visible");
			Assert.assertTrue(getElement(saveTemplateNo).isSelected(),"Save Template as No should be selected By default");
			verifyVisibility("Save Template Yes radio",saveTemplateYes,"Save Templte as Yes radio Button Should be visible");
			if(template.equals("Yes"))
			{
				ReusableMethods.scrollIntoView(getElement(saveTemplateYes),driver);
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveTemplateYes),30);
				getElement(saveTemplateYes).click();
				getElement(TemplateName).sendKeys(templateName);
				getElement(TemplateDescription).sendKeys("Test Template Description");
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			ReusableMethods.scrollIntoView(getElement(submitPollBtn),driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitPollBtn),30));
			getElement(submitPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Uanble to Create Ballot as a Template",e);

		}
		return false;
	}

	@Step("Admin creates new ballot")
	public boolean createNewBallotFromTemplate(String name, String desc, String itemName,String itemName2,String template,String templateName,String PerAff, String PerReturn,String Reminder1,String Reminder2,String Reminder3,String AdditionalItemReq) {
		try {
			Thread.sleep(2000);
			//User should be able to see new section 'Create Ballot from Template?'
			verifyVisibility("Crete Ballot from Template Section",creteBallotfromTemplateSection,"Crete Ballot from Template Section should be visible");
			ScreenshotUtil.takeScreenshotForAllure(driver);

			//User should be able to see the default selection to 'No' and Select template feature should not be available.
			Assert.assertTrue(getElement(createBallotfromTemplateNoRadio).isSelected(),"By Default Selct Template No Radio should be Selcted");

			//User should be able to see list of saved templates in the Select template dropdown.
			PublicCommon.JSClick(getElement(createBallotfromTemplateYesRadio),driver);
			verifyVisibility("Select Template DD",selectTemplateDD,"Select Template Dropdown Should be Visible");
			List<String> selecTemplateDDValues=PublicCommon.getAllValuesInDropdown(getElement(selectTemplateDD),driver);
			Assert.assertFalse(selecTemplateDDValues.size()<2,"selectTemplate Dropdown should contain atleast one Value for Template");

			//User should be able to change and details from the new template selection will populate over the details of the previous template but any manually entered details shall remain:
			getElement(selectTemplateDD).click();
			PublicCommon.selectValueInDropdownbyIndex(getElement(selectTemplateDD),2);
			PublicCommon.waitForSec(10);
			PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			enterPollDescription("Manual Entered Poll Description");
			ScreenshotUtil.takeScreenshotForAllure(driver);

			//User should not be able to see create ballot from template in recirculation ballot page.
			//User should get error message as:
			//Template cannot be used to create Recirculation Ballots
			//User will lose all previously entered data and will receive a pop-up warning: "If you change to a Recirculation Ballot, you will lose all previously entered data"
			//with options to "Continue" or "Cancel".
			getElement(selectTemplateDD).click();
			PublicCommon.selectValueInDropdownbyIndex(getElement(selectTemplateDD),1);
			PublicCommon.waitForSec(5);
			PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicCommon.JSClick(getElement(bltRecircualtionYesRadio),driver);
			verifyVisibility("Ballot Recirculation with Template Warning Dialog",bltRecirwithTempWarningDialog,"Ballot Recirculation with Template Warning Dialog should be Visible");
			Assert.assertTrue(verifyText("Ballot Recirculation with Template Warning Message",getElement(bltRecirwithTempWarningMsg1).getText(),"Template cannot be used to create Recirculation Ballots"));
			validateText("Ballot Recirculation with Template Warning Message 2",getElement(bltRecirwithTempWarningMsg2).getText(),"If you change to a Recirculation Ballot, you will lose all previously entered data.","Ballot Recirculation with Template Warning Message 2 should Match");
			verifyVisibility("Ballot Recirculation with Template Warning Dialog Cancel Button",bltRecirwithTempWarningCancelBtn,"Ballot Recirculation with Template Warning Dialog Cancel Button should be Visible");
			verifyVisibility("Ballot Recirculation with Template Warning Dialog Continue",bltRecirwithTempWarningContinueBtn,"Ballot Recirculation with Template Warning Dialog Continue Button should be Visible");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getElement(bltRecirwithTempWarningDialogCloseBtn),driver);

			//User should be able to see the details of template are populated and editable in those fields.
			//Verify when user selects a template from dropdown then following fields are populated with template data and editable
			Assert.assertTrue(getElement(pollNameTwo).isEnabled(),"Poll name Input should be Enabled");
			validateText("Poll Name Input",getElement(pollNameTwo).getText(),"","Poll name Input should be Null");

			Assert.assertTrue(getElement(pollDescription).isEnabled(),"Poll name Input should be Enabled");
			validateText("Poll Description Input",getElement(pollDescription).getText(),"Manual Entered Poll Description","Poll name Input should not be Modified after Changing new Template");
			ScreenshotUtil.takeScreenshotForAllure(driver);

			ReusableMethods.scrollIntoView(getElement(percentageAffirmativeRequired),driver);
			Assert.assertTrue(getElement(percentageAffirmativeRequired).isEnabled(),"Affirmative % Input should be Enabled");
			validateText("Affirmative % Input",getElement(percentageAffirmativeRequired).getAttribute("value"),PerAff,"Affirmative % Input should be equal to Template details");

			Assert.assertTrue(getElement(percentageReturnedRequired).isEnabled(),"Ballot % Returned Input should be Enabled");
			validateText("Ballot % Returned Input",getElement(percentageReturnedRequired).getAttribute("value"),PerReturn,"Ballot % Returned Input should be equal to Template details");

			Assert.assertTrue(getElement(pollCloseDate).isEnabled(),"Poll Closing Date Input should be Enabled");
			validateText("Poll Closing Date Input",getElement(pollCloseDate).getAttribute("value"),getTodayDate().replaceAll("-","/"),"Poll Closing Date Input should be equal to Today date");

			Assert.assertTrue(getElement(reminder1).isEnabled(),"Reminder 1 Input should be Enabled");
			validateText("Reminder 1 Input",getElement(reminder1).getAttribute("value"),Reminder1,"Reminder 1 Input should be equal to Template Details");

			Assert.assertTrue(getElement(reminder2).isEnabled(),"Reminder 2 Input should be Enabled");
			validateText("Reminder 2 Input",getElement(reminder2).getAttribute("value"),Reminder2,"Reminder 2 Input should be equal to Template Details");

			Assert.assertTrue(getElement(reminder3).isEnabled(),"Reminder 3 Input should be Enabled");
			validateText("Reminder 3 Input",getElement(reminder3).getAttribute("value"),Reminder3,"Reminder 3 Input should be equal to Template Details");

			ReusableMethods.scrollIntoView(getElement(voteChoice),driver);
			validateText("Ballot Item Choices Dropdown 1 Value",PublicCommon.getFirstSelectedValueInDropdown(getElement(voteChoice)).getText(),"Count towards Fail","Ballot Item Choices Dropdown 1 Value should Match with SelectedTemplate");
			validateText("Ballot Item Choices Dropdown 2 Value",PublicCommon.getFirstSelectedValueInDropdown(getElement(voteChoice2)).getText(),"Count towards Pass","Ballot Item Choices Dropdown 2 Value should Match with SelectedTemplate");

			//User should be able to get only Ballot Item 1 and it’s choices, other Ballot Items will be excluded from the template save.
			Assert.assertFalse(PublicAdminCommons.isElementDisplayed(getElement(pollItemName2)),"Poll Item #2 Should Not Be Visible");
			Assert.assertFalse(PublicAdminCommons.isElementDisplayed(getElement(removeBallotItemButton)),"Remove Ballot Item Button Should Not Be Visible");

			//User should be able to submit the ballot successfully.
			ReusableMethods.scrollIntoView(getElement(BallotName),driver);
			enterBallotName(name);
			String Date=getTommorrowDate();
			ReusableMethods.scrollIntoView(getElement(pollCloseDate),driver);
			setDateTomorrowForpolls(Date);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			ReusableMethods.scrollIntoView(getElement(reviewPollBtn),driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(reviewPollBtn),20));
			getElement(reviewPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.waitForSec(5);
			PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			ReusableMethods.scrollIntoView(getElement(submitPollBtn),driver);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitPollBtn),30));
			getElement(submitPollBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AffVote),30);
			PublicCommon.JSClick(getElement(AffVote),driver);
			PublicCommon.waitForSec(5);
			clickonmethod("Save Vote Button",saveVote,"Save Vote Button Should be clicked");
			PublicAdminCommons.waitForSec(60);

			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Uanbel to Create Ballot From Template",e);
		}
		return false;
	}

	@Step("Verify {0}")
	public boolean verifyText(String message, String actualText, String expectedText) {
		try {
			return actualText.contains(expectedText);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify: " + message, e);
			return false;
		}

	}

	@Step("Verifying the: {value}")
	public void validateText(String value,String actualText, String expectedText,String assertionMessage) {
		try {
			String validation = value;
			boolean result = IntegrationCommon.verifyElementTextOnPage(validation, actualText, expectedText);
			assertTrue(result,assertionMessage);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}


