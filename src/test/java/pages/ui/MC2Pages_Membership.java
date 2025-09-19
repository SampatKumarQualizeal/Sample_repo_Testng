package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.DocContentReader;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import com.google.gson.JsonObject;
import io.qameta.allure.Step;
import org.jboss.aerogear.security.otp.Totp;
import org.jboss.aerogear.security.otp.api.Clock;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class MC2Pages_Membership extends BasePage {
	/*INT-4665 START*/
	private By primaryActivitySelectedDrpdwnValue=By.cssSelector("div#PrimaryActivityId >div:nth-of-type(1)");
	private By primaryActivityFieldValue=By.xpath("//span[contains(text(),'Primary Activity')]//following-sibling::span[@class='labelValue']");
	private By recordUpdatedSuccMsg=By.xpath("//p[contains(text(),'updated successfully')]");
	public By memberCommitteeInfoDetailsPage_backBtn=By.xpath("//div[contains(@class ,'headingTitle')]/parent::div/preceding-sibling::a");
	private String auditLogsTableData_var="//table[contains(@class,'auditLogtable')]/tbody/tr[1]/td[@class='[column]']";
	public By getauditLogsTableData_var(String columnDataToGet) {
		return By.xpath(auditLogsTableData_var.replace("[column]",columnDataToGet));
	}
	/*INT-4665 END*/
	/*INT-4961 START*/
	public By personalDetailsTabAcNoLabel=By.xpath("//span[@class='memberAccount']/em");
	public By auditLogLinkModifiedByTxt=By.xpath("//table[contains(@class,'auditLogtable')]//td[@class='reason']/following-sibling::td");
	public By auditLogLinkReasonTxt=By.xpath("//table[contains(@class,'auditLogtable')]//td[@class='reason']");
	public By orderHistoryItemNameTxt=By.xpath("//table[@class='customTable memHisTable']/tbody/tr[1]/td[2]");
	public By orderHistoryDescriptionTxt=By.xpath("//table[@class='customTable memHisTable']/tbody/tr[1]/td[3]");
	public By auditLogLink=By.linkText("AUDIT LOG");
	public By accNoTxt=By.xpath("//span[text()='Account Number']/following-sibling::span");
	public By memAccStatusDetailsPaidDateTxt=By.xpath("//span[@class='labelTitle' and text()='Paid Date']/following-sibling::span");
	/*INT-4961 END*/
	public List<String> expectedTxtListUponUpdatingMemCommitteeInfo=null;
	/*INT-4964 : Start*/
	private By reportsLink=By.xpath("//a[contains(text(),'Reports')]");

	private By membershipReportsLink=By.xpath("//a[text()='Membership Reports']");

	private By membershipInvoiceContinueBtn=By.xpath("//h4[text()='Membership Invoice or Receipt']/following-sibling::div/button");
	private By accountNumInmMemInvoiceReceiptPage=By.xpath("//input[@id='accountNumber']");
	private By getDataBtn=By.xpath("//button[@data-testid='getDataClick']");
	private By generateInvoiceBtn=By.xpath("//button[@data-testid='btnGenerateInvoice']");

	private By templateImg=By.id("imgUrl");

	private By acNoInDownloadedTemplate=By.xpath("(//div[@id='card-items']/span)[1]");
	public List<String> prepopulatedDataForGivenAcc=new LinkedList<>();
	//private By dataValuesPopulatedToInvoiceTemplateInIA=By.cssSelector("div#left-section>div:nth-of-type(1),div#address,div.card-item-member-name,div#card-items>span,div#left-section>div:nth-of-type(3)");
	private By dataValuesFromGetData=By.xpath("//div[contains(@class,'fluid input')]/input");

	public By orderHistoryLink=By.xpath("//a[text()='Order History']");
	private By orgAccountStatus = By.xpath("//label[text() ='Let account status of Under Armour Inc remain Active']");
	public By workItemFullList = By.xpath("//a[@title = 'View']/../div/h6[text () = 'Work Items Full List']");
	public By workItemFullListButton = By.xpath("//a[@href='/membership-participation/technical-committees/work-items-full-list']");

	/*INT-4964 : End*/
	Mcs2Application_Page MCS2Application;
	Homepage home;
	JsonFileReader jsonFileReader;
	String committeeName="";
	public MC2Pages_Membership(WebDriver driver) {
		super(driver);
		MCS2Application = getInstance(Mcs2Application_Page.class);
		home = getInstance(Homepage.class);
		// TODO Auto-generated constructor stub
	}

	private String mc2URL = "https://environment-ia.astm.org";
	private final String stage = "stage";
	private final String qa = "qa";
	private final String dev = "dev";
	private int waitTime = 55;
	public final String activeAccountStatus = "Active";
	public final String historicalAccountStatus = "Historical";
	public final String notPaidStatus = "Not Paid";
	public final String PaidStatus = "Paid";

	public final String ErrorMsg = "The quote does not exist for that unique id.";

	private By usernameField = By.id("i0116");  //input[@id='i0116']
	private By submitButton = By.id("idSIButton9");

	private By ASTMCallBtn = By.xpath("//div[@class='table-cell text-left content']");
	private By RemindIn14daysCheckBoxSignIn = By.xpath("//input[@id='idChkBx_SAOTCC_TD']");
	private By passwordField = By.id("i0118");
	public By staySigninNoBtn = By.cssSelector("*[type='button'][value='No']");
	public By member= By.xpath("//a[text()='Member']");

	private By UseAnotherAccount = By.xpath("//div[@id='otherTile']/div");
	private By userIcon = By.xpath("//i[@class='user icon']");
	public By memberManagement = By.xpath("//a[contains(text(), 'Member Management')]");
	private By memberOption = By.xpath("//a[contains(text(), 'Members')]");
	public By organizationOption = By.xpath("//a[contains(text(), 'Organizations')]");
	public By representativetype = By.xpath("(//span[text()='Representative'])[1]");
	public By representativeMember = By.xpath("//span[@class='titleLabel']/following::a[@class='ellip']");

	public By accountStatus1= By.xpath("//*[@class='titleLabel' and contains(text(), 'Account Status')]/following-sibling::span[@class='titleInfo']");
	public By ASTMGeneralInfEditBtn= By.xpath("//h5[text()='ASTM General Information']/a");
	public By representativeField= By.xpath("//label[@class='label' and contains(text(),'Representative')]/..//input[@id = 'OrgRepName']");
	public By reasonForUpdateField= By.xpath("//label[text()='Reason for update']/following::textarea");
	public By updateBtn= By.xpath("//h5[text()='ASTM General Information']/ul/li/button[@class='updateBtn']/i");
	public By popupMsg= By.xpath("//div[@class='ui tiny modal transition visible active confirm-box']/div[1]");
	public By popupMsgOption= By.xpath("//div[@class='ui tiny modal transition visible active confirm-box']//button[text()='Yes']");
	public By representativetypeOutMsg= By.xpath("(//table[@class='customTable auditLogtable type2']/tbody/tr[1]//strong[text()='REPRESENTATIVE OUT'])[1]");

	private By admin = By.xpath("(//a[contains(., 'Admin')])[2]");
	private By membershipRenewal = By.xpath("//a[contains(text(), 'Membership Renewal')]");

	public By searchBox = By.xpath("//div[@class='ui input searchInput']//input");
	private By advancedSearchDropdown = By
			.xpath("//div[@class='ui input searchInput']//following-sibling::i[@class='dropdown icon openAdvSearch']");
	private By emailSearchBox = By.xpath("//input[@name='Email']");

	public By searchButton = By.xpath("//button[@class='ui button primary']");
	private By WorkItem = By.xpath("//a[text()='Work Item']");

	private By FindBtn = By.xpath("(//div[@class='wiActions']/button)[1]");
	public By EnterWorkItemID = By.xpath("(//input[@id='WorkItemNumber'])[1]");
	public By WorkItemCard_ViewEdit = By.xpath("//section[@class='workItemCard']/div/h4[text()='View/Edit Work Item']");
	public By WorkItemCard_Restore_wk_Item = By.xpath("//section[@class='workItemCard']/div/h4[text()='Restore Work Item']");
	public By LinkText_Deleted_wk = By.xpath("//a[@class='linkTxt']");
	public By EnterWKinDelwk = By.xpath("//input[@id='workItemNumber']");
	public By AutologWI_input = By.cssSelector("#workItemNumber");
	public By searchBtn = By.xpath("//button[text()='Search']");
	public By AutoLogWI_WINumber = By.xpath("//a[contains(@href,'/work-item-admin/details/')]");
	public By checkDeletedWK = By.xpath("//tbody/tr/td[1]/a");
	public By DeletedWkHeader = By.xpath("//h5[text()='Deleted Work Items']");
	public By DeletedBY=By.xpath("//input[@class='search']");
	public By atesterOption=By.xpath("//div/span[text()='atester']");
	public By WorkItemCard_ViewBallotItems = By.xpath("//section[@class='workItemCard']/h5[text()='View Ballot Items']");
	public By WorkItemCard_PrereleaseTargerDateReports = By.xpath("//section[@class='workItemCard']/div/h4[text()='Pre-Release Target Date Reports']");
	public By WK_TargetDaysReport_90days = By.xpath("(//div[@class='ui checked checkbox']/label)[1]");
	public By WK_TargetDaysReport_120days = By.xpath("(//div[@class='ui checked checkbox']/label)[2]");
	public By Generate_Btn = By.xpath("//button[text()='Generate']");
	public By AccountNo = By.xpath("//div[@class='labelTitle']/strong[text()='Account Number']//parent::div/parent::div/div[2]");
	public By OrderNo = By.xpath("//div[@class='labelTitle']/strong[text()='Order Number']//parent::div/parent::div/div[2]");

	private By AuditWorkItemCheck = By.xpath("//h5");
	public By advancedSearchButton = By.xpath("//button[contains(text(), 'Search')]");
	public By MemberTypeDescription = By.xpath("(//td[@class='description']/p/strong[text()='Member Type']/..)[1]");
	private By advancedSearchResetButton = By.xpath("//button[contains(text(), 'Reset')]");

	private By rowItems = By.xpath("//table[@id='customGrid']//tbody//tr");
	private By accountData = By.xpath("//table[@id='customGrid']//tbody//tr[1]//td[1]");
	private By accountLink = By.xpath("//table[@id='customGrid']//tbody//tr[1]//td[1]//a");
	public By PersonalDetailsTabActNo = By.xpath("//span[text()='Account Number']/../span[2]");
	public By PersonalDetailsTab = By.xpath("//a[text()='Personal Details']");
	public By MemberCommitteeInfoTab = By.xpath("//a[text()='Member Committee Information']");
	public By CommitteeIcon = By.xpath("(//table[@class='customTable memComInfoTable']/thead/tr/th[text()='Committee Designation']/../../../tbody/tr/td/a)[1]");
	public By MemberTitle = By.xpath("//div[@class='active title']/div/div/a");
	public By ClassificationInfoHeader = By.xpath("//h5[text()='Classification Information']");
	public By EditIcon = By.xpath("//h5[text()='Classification Information']/a/i");
	public By PAdropdown = By.xpath("//div[@id='PrimaryActivityId']/i");
	public By PrimaryActivitySelect = By.xpath("//div[@id='PrimaryActivityId']/div/div");
	public By SelectedPrimaryActivity = By.xpath("//div[@id='PrimaryActivityId']/div[@class='divider text']");
	public By Description = By.xpath("//textarea[@id='Description']");
	public By GovtInterests = By.xpath("//textarea[@id='GovernmentInterest']");
	public By AcademiaInterests = By.xpath("//textarea[@id='AcademiaInterest']");
	public By ConsumerInterests = By.xpath("//textarea[@id='ConsumerInterest']");
	public By ProductSold = By.xpath("//textarea[@id='ProductSold']");
	public By ClassificationReasonForUpdate = By.xpath("//textarea[@id='ReasonForUpdate']");
	public By ContentPopUp = By.xpath("//div[contains(text(),'This action will remove')]");
	public By UpdateBtn = By.xpath("//h5[text()='Classification Information']/ul/li/button[@class='updateBtn']");
	public By updatedSuccessfullMsg = By.xpath("//p[text()='Record updated successfully.']");
	public By CommittepageGrid = By.xpath("//table[@id='customGrid']/tbody[1]/tr/td/a");
	public By y05Committee = By.xpath("(//table[@id='customGrid']/tbody[1]/tr/td/a)[1]");

	public By CommitteDetailsPageCommittee = By.xpath("//div[@class='bannerCommittee']/div/div/span");
	private By emailData = By.xpath("//table[@id='customGrid']//tbody//tr[1]//td[4]");
	private By membershipType = By.xpath("//table[@id='customGrid']//tbody//tr[1]//td[6]");
	public By membershipTypeHeader = By.xpath("//h5[text()='Membership Type']");
	private By membershipDropDown = By.xpath("//div[@class='ui selection dropdown']");
	public By CommitteeDesignation1 = By.xpath("//div[text()='Search by Committee Designation']/../input");
	public By AddMemberToACommitteeBtn = By.xpath("//button[text()='Add Member to a Committee']");
	public By accountStatus = By.xpath(
			"//*[@class='labelTitle' and contains(text(), 'Account Status')]/following-sibling::*[@class='labelValue viewModeData']");
	// *[@class='titleLabel' and contains(text(),'Account
	// Status')]/following-sibling::*[@class='titleInfo']
	private By paidStatus = By.xpath(
			"//*[@class='labelTitle' and contains(text(), 'Paid Status')]/following-sibling::*[@class='labelValue viewModeData']");
	
	private By memberAccountStatus=By.xpath("//*[@class='labelTitle' and contains(text(), 'Account Status')]/following-sibling::*[@class='labelValue viewModeData']");

	private By renewalOption = By.xpath("//*[@setlabeltitleprop='Auto Renewal']");
	private By autoRenewalUnchecked = By
			.xpath("//*[@setlabeltitleprop='Auto Renewal' and @class='ui disabled checkbox']");
	private By autoRenewalChecked1 = By
			.xpath("//*[@setlabeltitleprop='Auto Renewal' and @class='ui checked checkbox']");
	private By autoRenewalChecked = By
			.xpath("//*[@setlabeltitleprop='Auto Renewal' and @class='ui checked disabled checkbox']");
	public By editMemberAccountStatusHeader = By.xpath("//h5[text()='Member Account Status Details']");
	public By editMemberAccountStatusDetails = By.xpath("//h5[text()='Member Account Status Details']/a");
	private By membershipTypEditLink = By.xpath("//h5[text()='Membership Type']/a/i");
	private By editMemberAccountStatusDetails2 = By.xpath("(//*[@class='editBtn'])[3]");
	public By updateReason = By.xpath("//textarea");
	private By updateReason2 = By.xpath("//textarea[@id='UpdateReason']");
	public By accountStatusDropDownField = By.xpath("//*[@name='McsStatusMasterId']");
	private By historicalReasonDropDownField = By.xpath("//*[@name='HistoricalReasonId']");
	private By chengedPositionHReason = By.xpath("//*[@class='text' and contains(text(), 'CHANGED POSITION')]");
	private By paidStatusDropdownField = By.xpath("//*[@name='PaidStatus']");
	private By DeceaseHReason = By.xpath("//*[@class='text' and contains(text(), 'DECEASE')]");
	private By RepresentativeOutReason = By.xpath("//div[@id='HistoricalReasonId']//span[text()='REPRESENTATIVE OUT']");
	public By activeStatus = By.xpath("//*[@class='text' and contains(text(), 'Active')]");
	public By ContentPopup = By.xpath("//div[@class='content']");
	public By PrimaryYesBtn = By.xpath("//button[@class='ui primary button']");
	public By AccountActiveWithRep = By.xpath("//input[@value='UpdateOrgWithAnotherRep']/../label");
	public By AccountActiveWithOutRep = By.xpath("//input[@value='UpdateOnlyOrg']");
	public By Header = By.xpath("//div[@class='header']");
	public By OrganizationName = By.xpath("//input[@id='Organization']");
	public By SelectOrg = By.xpath("//div[@class='result']");
	public By AssignBtn = By.xpath("//button[text()='Assign']");


	private By notPaidAccountStatus = By.xpath("//*[@class='text' and contains(text(), 'Not Paid')]");
	public By saveStatusUpdate = By.xpath("//button[@class='updateBtn']");
	private By saveStatusUpdate2 = By.xpath("//button[@class='updateBtn']");
	private By historicalStatus = By.xpath("//*[@class='text' and contains(text(), 'Historical')]");
	public By mcs2_address = By.xpath("//span[text()='Address']/following-sibling::span");
	public By mcs2_address1 = By.xpath("(//span[text()='Address']/following-sibling::span)[1]");
	public By mcs2_accountNo = By.xpath("//span[text()='Account Number']//following-sibling::span");
	public By mcs2_firstName = By.xpath("//span[text()='First Name']/following-sibling::span");
	public By mcs2_LastName = By.xpath("//span[text()='Last Name']/following-sibling::span");
	public By mcs2_PhoneNo = By.xpath("//span[text()='Phone']/following-sibling::span");
	public By headerMembershipType = By.xpath("//h5[contains(text(),'Membership Type')]");
	public By DeleteBtn = By.xpath("//button[@title='Delete']");
	public By UpdateTitle = By.xpath("//textarea[@id='Title']");

	public By SaveBtn = By.xpath("//button[@title='Save']");
	public By ContentConfirmAfterSave = By.xpath("//div[contains(@class,'confirm-box')]/div[@class='content']");
	public By RetunToAdminScreen = By.xpath("//button[text()='Return to Admin Screen']");
	public By ReasonForDelete = By.xpath("//textarea[@id='DeleteReason']");
	public By ConfirmBtn = By.xpath("//button[text()='Confirm']");
	public  By RestoreBtn = By.xpath("//button[text()='Restore']");
	public By HeaderRestoreWK = By.xpath("//div[@class='header']");
	public By RestoreConfirmBtn = By.xpath("//button[@data-testid='RestoreConfirm']");
	public By OTPtextbox = By.xpath("//input[@id='idTxtBx_SAOTCC_OTC']");
	public By VerifyBtn = By.xpath("//input[@id='idSubmit_SAOTCC_Continue']");
	public By CommitteeManagement = By.xpath("//a[text()='Committee']");
	public By CommitteeRosterTab = By.xpath("//a[text()='Committee Roster']");
	public By AddMemberToCommitteeBtn = By.xpath("//button[text()='Add Member to Committee']");
	public By searchMember = By.name("searchMember");
	public By NoresultFound = By.xpath("//div[text()='No results found.']");
	public By resultVisible = By.xpath("//div[@class='message empty']/div");

	public By closeBtn = By.xpath("//i[@class='close']");
	public By VoteYesRedioBtn = By.xpath("//label[text()='Yes']");
	public By ConsumerAdvisoryGroupNo = By.xpath("//input[@name='consumerAdvocacyGroupBelongundefined']/../label[text()='No']");
	public By primaryActivityOfMemberField = By.name("primaryActivityOfMember");
	public By natureOfInterestField = By.xpath("//textarea[contains(@id,'natureOfInterest')]");
	public By UpdateReasonField = By.id("UpdateReason");
	public By saveBtn = By.xpath("//button[text()='Save']");
	public By AddMemberToCommittee = By.xpath("(//button[@class='ui secondary button'])[1]");

	public By CommitteeDesignation = By.xpath("//table[@id='customGrid']/tbody[1]/tr/td/a");
	public By CommitteeDesignationA11 = By.xpath("(//table[@id='customGrid']/tbody[1]/tr/td/a)[1]");
	public By detailsAction = By.xpath("//div[@class='comDetailsAction']/i");
	public By InActiveCommitteeBtn = By.xpath("//div[@class='userGrroupname']/ul/li/button[text()='Inactivate Committee']");
	public By ReActivateCommitteeBtn = By.xpath("//div[@class='userGrroupname']/ul/li/button[text()='Reactivate Committee']");
	public By ReactivateCommitteeWithMmembers = By.xpath("(//div[@class='ui radio checkbox'])[2]");
	public By TextAreaReasonForUpdate = By.xpath("//textarea[@id='reasonForUpdate']");
	public By ReactivateBtn = By.xpath("//button[text()='Reactivate']");
	public By Breadcrumb = By.xpath("//div[@class='ui breadcrumb']/span/a");



	public By InactiveReason = By.xpath("//label[@for='InactiveReason']/../div/div[@id='InactiveReason']");
	public By Discharged = By.xpath("//span[text()='DISCHARGED']");
	public By ReasonForUpdate = By.xpath("//label[@for='reasonForUpdate']/../div/textarea[@id='reasonForUpdate']");
	public By InActivateSaveBtn = By.xpath("//button[@type='submit']");
	public By YesBtn = By.xpath("//button[text()='Yes']");
	public By InActiveStatus = By.xpath("//table[@id='customGrid']/tbody[1]/tr/td/a/../../td/p[text()='Inactive']");
	public By auditLogsTab = By.xpath("//a[text()='Audit Log']");
	public By aorderHistoryTab = By.xpath("//a[text()='Order History']");
	public By prsonalDetailsTab=By.xpath("//a[text()='Personal Details']");
	public By UseAnotherAct = By.xpath("//div[@id='otherTileText']");


	public By mcs2_Usertype=By.xpath("//div[@class='memberRole']/span");
	public By mcs2_Organizationname =By.xpath("//span[text()='Organization']/parent::div/descendant::span[2]/a[contains(@class,'ellip')] | (//a[contains(@class,'ellip')])[1]");
	public By committee=By.xpath("//a[contains(text(),'Committee')]");
	public By TotalStandardsCount=By.xpath("//span[text()='Total Standards']/../span[1]");
	public By Overview=By.xpath("//span[text()='Overview']/../span[2]");
	public By CommitteeScope=By.xpath("//span[text()='Committee Scope']/../span[2]");
	public By joinDate=By.xpath("//span[text()='Join Date']/following::span[@class='titleInfo'][1]");
	public By selectThirdOrgFromList=By.xpath("//table[@id='customGrid']/tbody/tr[3]/td/a");
	public By selectSecondOrgFromList=By.xpath("//table[@id='customGrid']/tbody/tr[2]/td/a");
	public By selectFirstOrgFromList=By.xpath("//table[@id='customGrid']/tbody/tr[1]/td/a");
	public By OrganizationDetailes=By.xpath(" //div[@data-testid='membershipTypeInfo']//div/span[text()='Organization']/../span/a");
	public By auditLogMsgDECEASE=By.xpath("//div[@class='tableWrapper']//following::strong[text()='DECEASE']");
	public By reinstateDeceasedPopup=By.xpath("//div[contains(text(),'The Member you are trying to reinstate is deceased')]");
	public By activeRepresentativeAssociatedPopup=By.xpath("//div[contains(text(),'already an active representative associated')]");

	public By confirmPopup=By.xpath("//div[text()='Confirm']");
	public By accountStatusRadioBtn=By.xpath("//label[contains(text(),'Let account status')]");
	public By okBtn=By.xpath("//button[text()='Ok']");

	public By notSelectedColors = By.xpath("//div[@class='column relative']//span[@class='colorDV']");
	public By memberUpdatedSuccessfullyMsg = By.xpath("//p[text()='Member Classification updated successfully.']");

	public By applicableToAllCommitteesCheckBox = By.xpath("//input[@name='Applicable to all Committees']");


	public By myCommitteLink = By.xpath("//div[@id='v-pills-tab-indented']//a[contains(text(),'MyCommittees')]");

	public By rosterMaintenanceLink = By.xpath("//a[contains(text(),'Roster Maintenance ')]");

	public By cookiesReject = By.xpath("//button[text()='Reject All']");

	public By classificationDropDown = By.xpath("//button[text()='More']");

	public By committeDesignation = By.xpath("//a[text()='Member Committee Information']");

	public By astmCommitteeUatTestEditBtn = By.xpath("ASTM Committee - UAT Test");

	public By officerTitleSearchDropDown = By.xpath("//input[@type='text']/..//div[text()='Select']");

	public By committeeOfficersLst = By.xpath("//a[@data-testid='linkedOfficer']");

	public By reasonForUpdateTxtField = By.xpath("//textarea[@id='UpdateReason']");

	public By officerTitleUpdateBtn = By.xpath("//button[text()='Link']");

	public By ballotsAndWorkItem = By.xpath("//button[text()='Ballots & Work Items']");

	public By submitOrEdit = By.xpath("//a[text()='Submit/Edit']");

	public By registerAWorkItemRadioBtn = By.xpath("//div[@class='astm-custom-radio custom-control custom-radio']/..//input[@id='workItem1']");

	public By continueBtn = By.xpath("//button[text()='Continue']");

	public By proposedNewASTMStandardsRadioBtn = By.xpath("//input[@id='IsNewStandard0']");

	public By mainCommitteDropDown = By.xpath("//select[@id='MainCommitteeId']");

	public By subCommitteDropDown = By.xpath("//select[@id='SubCommitteeId']");

	public By maincommitte = By.xpath("//option[text()='A05 - Metallic-Coated Iron and Steel Products']");

	public By subCommitte = By.xpath("//option[text()='A05.07 - Methods of Testing']");

	public By imSubmittingOriginalMaterialsRadioBtn = By.xpath("//input[@id='copyright1']");

	public By agreeBtn = By.xpath("//button[text()='Agree']");

	public By acceptAllCookies = By.xpath("//button[text()='Accept All Cookies']");

	public By drpMonth = By.xpath("//select[@id='TargetDateMonth']");

	public By targetDateMonth = By.xpath("//select[@id='TargetDateMonth']");

	public By targetDateYear = By.xpath("//select[@id='TargetDateYear']");

	public By IsAuthorizedWorkItemRadioBtn = By.xpath("//label[text()='Yes']/..//input[@id='IsAuthorizedWorkItem0']");

	public By IsPatentedRadioBtn = By.xpath("//label[text()='Yes']/..//input[@id='IsPatented0']");

	public By typeOfStanadardDropdown = By.xpath("//select[@id='StandardTypeId']");

	public By titleTxtField = By.xpath("//textarea[@id='Title']");

	public By proposedScopeTxtField = By.xpath("//textarea[@id='Scope']");

	public By keyWordTxtField = By.xpath("//input[@id='Keywords']");

	public By rationaleTxtField = By.xpath("//textarea[@id='Rationale']");

	public By IsOnlineCollaborationRadioBtn = By.xpath("//input[@id='IsOnlineCollaboration0']");

	public By submitBtn  = By.xpath("//button[text()='Submit']");

	public By returnTomyCommitteLink = By.xpath("(//a[contains(text(),'MyCommittees')])[3]");

	public By myCollaborationAreasLink = By.xpath("//button[text()='MyCollaboration Areas']");

	public By listOfWorkItems = By.xpath("//a[@class='astm-link twoLiner']");

	public By committeTab = By.xpath("//a[text()='Committee']");
	public By committeDesignationLink = By.xpath("//a[text()='A01']");

	public By comiitteeRoasterTab = By.xpath("//a[text()='Committee Roster']");

	public By selectOfficerOnlyCheckBox = By.xpath("//label[text()='Show Officers Only']");

	public By updateBtnInIA = By.xpath("//a[@data-testid='updateBtn']");

	public By page2 = By.xpath("//a[text()='2']");

	public By accountNumberInIA = By.xpath("//a[text()='2449451']");

	public By officerTitleInIA = By.xpath("//a[text()='TestAutomation123']");

	public By reasonForUpdateTextField = By.xpath("//textarea[@id='UpdateReason']");

	public By rosterReportCheckBox = By.xpath("(//input[@name='All'])[2]");

	public By linkBtn = By.xpath("//button[text()='Link']");

	public By OfficerDropDown = By.xpath("//a[text()='TestAutomation123']/ancestor::tr//div[@role='combobox']");

	public By selectOfficer = By.xpath("//a[text()='TestAutomation123']/ancestor::tr//input[@type='text']");

	public By showOfficerTitleRadioBtn = By.xpath("//label[contains(text(),'Show Officers Only')]");

	public By updateBtnIA = By.xpath("//a[contains(@data-testid,'updateBtn')]");

	public By updateButton = By.xpath("//button[contains(text(),'Update')]");

	public By committeDetailsLst = By.xpath("//a[contains(@class,'column--MemberDetail_AccountNumber')]");

	public By officerTitlesList  = By.xpath("//a[contains(@data-testid,'linkedOfficer')]");

	public By accountNumbers  = By.xpath("//a[contains(@class,'column--MemberDetail_AccountNumber')]");

	public By nextPageBtn = By.xpath("(//a[contains(@type,'nextItem')])[2]");

	public By nextPageDropDown = By.xpath("(//div[@name='itemsPerPage'])[2]");

	public By AccountNumberDropdown = By.xpath("//i[@class='dropdown icon'])[7]");

	public By AccountNumberDropdwonValue = By.xpath("//span[text()='100']");

	public By pageNumbersINIA = By.xpath("(//span[text()='100'])[2]");

	public By officerCloseBtn = By.xpath("(//a[text()='test, Nav ']/..//i)[1]");

	public By rostercloseBtn  = By.xpath("//i[text()='✖']");

	public By myOutstandingBallotsLink = By.xpath("//button[text()='MyOutstanding Ballots ']");

	public By rejectAllCookiesBtn = By.xpath("(//button[text()='Reject All'])[2]");
	public By ballotLink = By.xpath("//a[text()='A01 (23-89)']");

	public By ballotsAndWorkItemLink = By.xpath("//button[text()='Ballots & Work Items']");

	public By submitOrEditLink = By.xpath("//a[text()='Submit/Edit']");

	public By rosterMaintananceLink = By.xpath("//a[text()='Roster Maintenance ']");

	public By userNameDropDown = By.xpath("//span[@data-testid='usernameBtn']");

	public By myCommitteeLinkInDropDown = By.xpath("//a[text()='MyCommittees']");

	public By memberShipInfoLink = By.xpath("//a[text()='Membership Info']");
	public By myCommitteesLink = By.xpath("//a[text()='My Committees']");

	public By printMemberShipCardLink = By.xpath("//a[text()='Print Membership Card']");

	public By printMembershipCertificateLink = By.xpath("//a[text()='Print Member Certificate']");

	public By meetingMinutesAndAgendasLink = By.xpath("//button[text()='Meetings, Minutes & Agendas']");

	public By AgendasMinutesClosingReportstrackerLink = By.xpath("//a[text()='Agendas/Minutes/Closing Reports tracker']");

	public By createMyScheduleLink = By.xpath("//a[text()='Create MySchedule']");

	public By createMyMeetingMaterialsLink = By.xpath("//a[text()='Create MyMeeting Materials']");

	public By alertMsg = By.xpath("//div[@class='fade astm-alert bg-warning--light alert alert-warning alert-dismissible show']");

	public By nxtPageButton = By.xpath("//a[contains(@type,'nextItem')]");

	public By committeeOfficersBtn = By.xpath("//button[text()=' Committee Officers']");

	public By stepForwardBtn = By.xpath("//i[contains(@class,'step forward  right disabled icon')]");

	public By removeOfficer = By.xpath("//a[contains(text(),'test, Nav ')]/..//i[@class='delete icon']");

	public By saveBtnIa = By.xpath("//button[contains(text(),'Save')]");

	public By reasonForUpdateTxtFieldIa = By.xpath("//textarea[contains(@id,'UpdateReason')]");

	public By selectOfficerDropDown = By.xpath("//a[text()='\"+officerTitle+\"']/ancestor::tr//input[@type='text']");

	public By selectOfficerTxtField = By.xpath("//a[text()='\"+officerTitle+\"']/ancestor::tr//div[@role='combobox']");

	public By navigateToNextPage = By.xpath("//a[text()='2']");

	public By MCS2_TopMenu_WorkItem = By.xpath("//a[contains(@href,'work-item') and text()='Work Item']");
	public By AuditLogViewButton = By.cssSelector("button[data-testid='AuditLogBtn']");
	public By MCS2_WI_Title = By.cssSelector("#Title");
	public  By AccountStatus = By.xpath("//span[text()='Account Status']//following-sibling::span[text()='Active']");
	public By AssociateRepAccountInput = By.cssSelector("#Representative");
	public By AssociateRepFirstReuslt = By.cssSelector(".results .result:first-of-type");
	public By GridTableAccountColumn = By.cssSelector(".column--MemberDetail_AccountNumber");
	public By GridTableOrgName = By.cssSelector("column--MemberDetail_FacilityName");
	public String GridTableStatusColumn = "//a[contains(@href,'[ORG_ID]')]//following::p[@class='column--MemberDetail_StatusName']";
	public By WorkItem_TechnicalContact = By.cssSelector("#TechnicalContactId div");
	public By listOfClassification = By.xpath("//div[@class='SummaryTable']/..//tr");

	public By listOfClassificationInIA = By.xpath("//div[@class='visible menu transition']/..//div");
	public By ChangeOfEmplomentAuditLogMsgDate = By.xpath("(//td[text()='Member has requested to update the Organization Name'])[1]/../td[1]");

	public By roasterMaintainanceSummaryPage_moreLink=By.xpath("//button[text()='More']");
	public By WorkItemAdmin_WItitle = By.cssSelector(".mt20");
	public By addNewBallot_BT=By.xpath("//span[contains(text(),'Add new ballot')]/parent::button");
	public By memberAccoun1t_IA=By.xpath("(//a[@class='column--MemberDetail_AccountNumber'])[1]");
	public By organizationsHeader_IA=By.xpath("//h2[text()='Organizations']");
	public By feeGroupHeader_IA=By.xpath("//h2[text()='Fee Group']");
	public By committeesHeader_IA=By.xpath("//h2[text()='Committees']");
	public By renewalTasksHeader_IA=By.xpath("//h2[text()='Renewal Tasks']");
	public By workItemAdminHeader_IA=By.xpath("//h2[text()='Work Item Admin Tool']");
	public By ballotAdminHeader_IA=By.xpath("//h2[text()='Ballot Admin']");
	public By renewalReportsHeader_IA=By.xpath("//h2[text()='Renewal Reports']");

	public By dashBoard_DMS=By.xpath("//span[text()='Dashboard']");
	public By dashBoard_RNE=By.xpath("//div[text()='Dashboard']");
	public By searchIcon_IA=By.xpath("//i[@class='search icon']");
	public By firstCOFee_Link=By.xpath("//td/a");
	public By firstDwnldButton_RR=By.xpath("(//button)[2]");
	public By addTask_RenTasks=By.xpath("//i[@class='plus icon']/parent::button");
	public By WIAdmin_Find=By.xpath("(//button)[2]");
	public By ballotAdmin_View=By.xpath("(//button)[2]");

	public By homeLink_RNE=By.xpath("//a[text()='Home']");
	public By memManagement_RE=By.xpath("//a[text()='Membership Management']");
	public By logoutPickAnAccount=By.xpath("//div[text()='Pick an account']");
	public By LogoutPage=By.id("login_workload_logo_text");
	public By userManagement_RNE=By.xpath("//p[text()='User Management']");
	public By membershipManagement_RNE=By.xpath("//p[text()='Membership Management']");
	public By committeeManagement_RNE=By.xpath("//p[text()='Committee Management']");
	public By ballotRuleManagement_RNE=By.xpath("//p[text()='Ballot Rule Management']");
	public By searchInput_RNE=By.xpath("//input");
	public By usetType_adminRne=By.xpath("//td[text()='Admin']");
	public By committeeManagement_RE=By.xpath("//a[text()='Committee Management']");
	public By ballotRuleManagement_RE=By.xpath("//a[text()='Ballot Rule Management']");
	public By userManagement_RE=By.xpath("//a[text()='User Management']");
	public By manageMembershipTypes=By.xpath("//li[@class='active']");
	public By process_RE=By.xpath("//a[text()='Ballot Close Process']");
	public By errorMesssage_RNE=By.xpath("//span[text()='The page you are looking for does not exist.']");




	public By getGridTableStatusColumn(String AccountNumber){
		return By.xpath(GridTableStatusColumn.replace("[ORG_ID]", AccountNumber));
	}

	public By getMembershipType(String membershiptype) {

		return By.xpath("//span[contains(text(), '" + membershiptype + "')]");
	}

	public By getCommitteeName(String Committee) {

		return By.xpath("(//a[contains(@href,'"+Committee+"')])[1]");
	}
	public String getJoinDate() {

		return getElement(joinDate).getText();
	}
	public WebElement getheaderMembershipType() {

		return getElement(headerMembershipType);
	}

	public WebElement getMcs2_FirstName() {

		return getElement(mcs2_firstName);
	}

	public WebElement getMcs2_LastName() {

		return getElement(mcs2_LastName);
	}

	public WebElement getmcs2_PhoneNo() {

		return getElement(mcs2_PhoneNo);
	}
	public WebElement getmcs2_Usertype() {

		return getElement(mcs2_Usertype);
	}
	public WebElement getmcs2_Organizationname() {

		return getElement(mcs2_Organizationname);
	}
	public String getrepresentativetype() {

		return getElement(representativetype).getText();
	}
	public String getSelectNum(String Number) {

		driver.findElement(By.xpath("//a[text()='"+Number+"']")).click();
		return Number;
	}
	public By getVisibleAccountNum(String Number) {

		return By.xpath("//a[text()='"+Number+"']");

	}
	public String getAccountStatus() {
		return getElement(accountStatus1).getText();

	}
	public By getCommitteeDropped(String committe) {

		return By.xpath("(//td[text()='Committee Dropped']/../td[2]//strong[text()='"+committe+"'])[1]");
	}
	public By getCommitteeJoined(String committe) {

		return By.xpath("(//td[text()='Committee Joined']/../td[2]//strong[text()='"+committe+"'])[1]");
	}
	public WebElement getReasonForUpdate(){
		return getElement(ClassificationReasonForUpdate);
	}
	public WebElement getGovtInterests(){
		return getElement(GovtInterests);
	}

	public WebElement getAcademiaInterests(){
		return getElement(AcademiaInterests);
	}

	public WebElement getConsumerInterests(){
		return getElement(ConsumerInterests);
	}

	public WebElement getProductSold(){
		return getElement(ProductSold);
	}

	public String getTotalStandardsCount(){
		return getElement(TotalStandardsCount).getText();
	}
	public String getOverviewFromIA(){
		return getElement(Overview).getText();
	}
	public String getCommitteeScopeIA(){
		return getElement(CommitteeScope).getText();
	}
	public By getPostalCode(String Number) {
		return By.xpath("//p[text()='"+Number+"']");
	}

	public WebElement getMcs2_Address() {

		return getElement(mcs2_address);
	}
	public String getOrganizationDetailes() {
		return getElement(OrganizationDetailes).getText();

	}
	public By getAuditLogMessageByindex(int Index) {
		return By.xpath("//table[@class='customTable auditLogtable type2']//tbody/tr["+Index+"]");
	}
	public By checkAuditLogMessage(String date) {
		return By.xpath("(//table[@class='customTable auditLogtable type2']//td[contains(text(),'"+date+"') or @class='Change of Employment (Web)'])[1]");
	}
	public By getAuditLogDescriptionBycolindex(int Index,int colIndex){
		return By.xpath("//table[@class='customTable auditLogtable type2']//tbody/tr["+Index+"]/td["+colIndex+"]");
	}
	public By getOrderHistoryBycolindex(int Index,int colIndex){
		return By.xpath("//table[@class='customTable memHisTable']//tbody/tr["+Index+"]/td["+colIndex+"]");
	}


	public int getAuditLogHsitory(){
		List<WebElement> AuditLogSize= driver.findElement(By.xpath("//tbody/tr"));
		return AuditLogSize.size();
	}
	private By adminPageRenewalButton = By.xpath(
			"//div[@class='display-inline-block floatLeft' and contains(.,'Start Renewal on Web for the Year 2022')]/preceding-sibling::div//button[@class='ui primary button']");
	public By getSelectcommittee(String committee) {
		return By.xpath("//div[@title='"+committee+"']");
	}
	public boolean updateAccountStatusToActive() {
		try {
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(editMemberAccountStatusDetails),10);
			ReusableMethods.scrollIntoView(getElement(editMemberAccountStatusDetails), driver);
			getElement(editMemberAccountStatusDetails).click();
			sendKeys("automated test", updateReason);

			getElement(accountStatusDropDownField).click();
			getElement(activeStatus).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(saveStatusUpdate).click();
			PublicCommon.waitForSec(waitTime);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateAccountStatusToHistorical() {
		try {
			ReusableMethods.scrollIntoView(getElement(editMemberAccountStatusDetails), driver);
			getElement(editMemberAccountStatusDetails).click();
			sendKeys("automated test", updateReason);

			getElement(accountStatusDropDownField).click();
			getElement(historicalStatus).click();
			if(PublicCommon.isWebElementDisplayed(driver,confirmPopup))
			{
				getElement(accountStatusRadioBtn).click();
				getElement(okBtn).click();
			}
			getElement(historicalReasonDropDownField).click();
			getElement(chengedPositionHReason).click();
			getElement(paidStatusDropdownField).click();
			getElement(notPaidAccountStatus).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(saveStatusUpdate).click();
			PublicCommon.waitForSec(waitTime);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateAccountStatusToHistoricalWithResonDecease() {
		try {
			ReusableMethods.scrollIntoView(getElement(editMemberAccountStatusDetails), driver);
			getElement(editMemberAccountStatusDetails).click();
			sendKeys("automated test", updateReason);
			getElement(accountStatusDropDownField).click();
			getElement(historicalStatus).click();
			getElement(orgAccountStatus).click();
			getElement(okBtn).click();
			getElement(historicalReasonDropDownField).click();
			getElement(DeceaseHReason).click();
			getElement(paidStatusDropdownField).click();
			getElement(notPaidAccountStatus).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(saveStatusUpdate).click();
			PublicCommon.waitForSec(5);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateAccountStatusToHistoricalWithReason_RepresentativeOut() {
		try {
			ReusableMethods.scrollIntoView(getElement(editMemberAccountStatusDetails), driver);
			WaitStatementUtils.waitForElementStaleness(driver, getElement(editMemberAccountStatusDetails));
			getElement(editMemberAccountStatusDetails).click();

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(updateReason));
			WaitStatementUtils.waitForElementStaleness(driver, getElement(updateReason));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(updateReason));
			sendKeys("automated test", updateReason);

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(accountStatusDropDownField));
			getElement(accountStatusDropDownField).click();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(historicalStatus));
			getElement(historicalStatus).click();
			if(PublicCommon.isWebElementDisplayed(driver,confirmPopup))
			{
				getElement(accountStatusRadioBtn).click();
				getElement(okBtn).click();
			}

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(historicalReasonDropDownField));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(historicalReasonDropDownField));
			getElement(historicalReasonDropDownField).click();

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(RepresentativeOutReason));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(RepresentativeOutReason));
			getElement(RepresentativeOutReason).click();

			ScreenshotUtil.takeScreenshotForAllure(driver);

			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(saveStatusUpdate));
			getElement(saveStatusUpdate).click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateAccountPaidStatusToNotPaid() {
		try {
			//driver.findElement(By.xpath("//h5[contains(text(),'ASTM General Information')]/a/i")).click();
			ReusableMethods.scrollIntoView(getElement(renewalOption), driver);
			getElement(editMemberAccountStatusDetails).click();
			sendKeys("automated test", updateReason);
			getElement(paidStatusDropdownField).click();
			getElement(notPaidAccountStatus).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(saveStatusUpdate).click(); PublicCommon.waitForSec(waitTime);
			if (driver.findElements(notPaidAccountStatus).size() > 0)
				return true;
			if (driver.findElements(paidStatus).size() > 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		/*
		 * try { getElement(editMemberAccountStatusDetails).click();
		 * sendKeys("automated test", updateReason);
		 * 
		 * getElement(paidStatusDropdownField).click();
		 * getElement(notPaidAccountStatus).click();
		 * ScreenshotUtil.takeScreenshotForAllure(driver);
		 * getElement(saveStatusUpdate).click(); PublicCommon.waitForSec(waitTime);
		 * 
		 * return true; } catch (Exception e) { e.printStackTrace(); return false; }
		 */
	}

	public void updateAccountRepresentativeWhenAccountActive(){
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getElement(ASTMGeneralInfEditBtn));
			ReusableMethods.scrollIntoView(getElement(ASTMGeneralInfEditBtn), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ASTMGeneralInfEditBtn));
			clickOnMethod("Unable to click ASTM General Information edit button", getElement(ASTMGeneralInfEditBtn));
			ScreenshotUtil.takeScreenshotForAllure(driver);

			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(representativeField));
			getElement(representativeField).click();
			getElement(representativeField).sendKeys("test");

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AssociateRepFirstReuslt));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AssociateRepFirstReuslt));
			getElement(AssociateRepFirstReuslt).click();

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(YesBtn));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(YesBtn));
			getElement(YesBtn).click();

			getElement(reasonForUpdateField).sendKeys("Automation Test");

			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveStatusUpdate));
			getElement(saveStatusUpdate).click();

			ReusableMethods.scrollIntoView(getElement(representativeMember), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(representativeMember));
			Assert.assertTrue(getElement(representativeMember).isDisplayed());

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public boolean userIconDisplay() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(userIcon));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean renewalButtonIsDisabled() {
		try {
			return !(getElement(adminPageRenewalButton).isEnabled());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean renewalButtonIsEnabled() {
		try {
			return getElement(adminPageRenewalButton).isEnabled();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String memberAccountStatus() {
		try {
			// Thread.sleep(5000);
			ReusableMethods.scrollIntoView(getElement(accountStatus), driver);
			return getElement(accountStatus).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String memberPaidStatus() {
		try {
			ReusableMethods.scrollIntoView(getElement(paidStatus), driver);
			return getElement(paidStatus).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String memberaccountStatus() {
		try {
			ReusableMethods.scrollIntoView(getElement(memberAccountStatus), driver);
			return getElement(memberAccountStatus).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Condition true refers to auto renewal set to true, so data not usable for
	// membership renewal tests
	public boolean memberAutoRenewalStatus() {
		try {
			driver.findElement(By.xpath("//h5[contains(text(),'ASTM General Information')]/a/i")).click();
			//ReusableMethods.scrollIntoView(getElement(renewalOption), driver);
			if (driver.findElements(autoRenewalChecked).size() > 0)
				return true;
			if (driver.findElements(autoRenewalUnchecked).size() > 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	public boolean memberAutoRenewalStatusa() {
		try {
			//driver.findElement(By.xpath("//h5[contains(text(),'ASTM General Information')]/a/i")).click();
			ReusableMethods.scrollIntoView(getElement(renewalOption), driver);
			if (driver.findElements(autoRenewalChecked1).size() > 0)
				return true;
			if (driver.findElements(autoRenewalUnchecked).size() > 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public boolean memberAutoRenewalStatus2() {
		try{

       driver.findElement(By.xpath("//h5[contains(text(),'ASTM General Information')]/a/i")).click();
		if (!(driver.findElement(((autoRenewalChecked))).isSelected())) {
				driver.findElement((autoRenewalChecked)).click();
				sendKeys("automated test", updateReason2);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(saveStatusUpdate2).click();
				PublicCommon.waitForSec(waitTime);
				
         if (driver.findElements(autoRenewalUnchecked).size() > 0)
					return false;

				else
					return true;
			} }catch (Exception e) {
				e.printStackTrace();
				return true;
			}
			return false;
		}
	

	public boolean memberAccountSearch(String account) {
		try {
			getElement(searchBox).click();
			sendKeys(account, searchBox);
			getElement(searchButton).click();
			int rows = driver.findElements(rowItems).size();
			System.out.println("Rows retrieved on search: " + rows);
			return (rows > 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean memberEmailSearch(String email) {
		try {
			getElement(searchBox).sendKeys(email);
			clickAdvancedSearchDropdown();

			getElement(emailSearchBox).click();
			sendKeys(email, emailSearchBox);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(advancedSearchButton).click();

			int rows = driver.findElements(rowItems).size();
			System.out.println("Rows retrieved on search: " + rows);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			return (rows > 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/**
 * Enter email to MCS2 application to filter account
 * @param email
 * @return
 */
	public boolean enterIntoSearchBox(String email) {
		try {
			PublicCommon.waitForSec(20);
			getElement(searchBox).sendKeys(email);
			PublicCommon.waitForSec(15);
			getElement(searchButton).click();
			PublicCommon.waitForSec(15);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public Boolean DeleteWK(){
		getElement(DeleteBtn).click();


		return true;

	}

	public boolean clickWorkItemandSearchWithWorkItemID() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(WorkItem),10);
			getElement(WorkItem).click();
			return true;

			} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickFindBtn() {
		try {
			getElement(FindBtn).click();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public WebElement workItemSearchField() {
		return getElement(EnterWorkItemID);
	}
	public WebElement reasonForDelete(){
		return getElement(ReasonForDelete);
	}

	public String AuditWorkItemVerification(){
		String AuditWorkItemSplit = getElement(AuditWorkItemCheck).getText();
		AuditWorkItemSplit = AuditWorkItemSplit.split("WK")[1];
		return AuditWorkItemSplit;
	}

	public boolean enterIntoSearchBox1(String email)
	{
		boolean flag=false;
		try {
			getElement(searchBox).sendKeys(email);
			PublicCommon.waitForSec(5);
//			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(emailData), 60);
			for (int i = 0; i < 5; i++)
			{
				PublicCommon.waitForSec(5);
				getElement(searchButton).click();
				PublicCommon.waitForSec(5);
				  	if(PublicCommon.isWebElementDisplayed(driver,accountLink))
					{
						flag=true;
						break;
					}

			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return flag;
		} catch (Exception e)
		{
			e.printStackTrace();
			return flag;

		}
	}


	@Step("Click on Membership Account Link")
	public boolean clickMembershipAccountLink() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(accountLink),5);
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(accountLink).click();
			PublicCommon.waitForSec(3);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Click on Membership Account Link")
	public boolean clickAuditLogLink() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(auditLogsTab),5);
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(auditLogsTab).click();
			PublicCommon.waitForSec(3);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Validate Personal Details Tab")
	public String ValidatePersonalDetailsTab(){
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getElement(PersonalDetailsTabActNo).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getMembershipAccountText() {
		try {
			return getElement(accountLink).getText();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean clickAdvancedSearchDropdown() {
		try {
			getElement(advancedSearchDropdown).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateMemberAccount(String account) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			System.out.println("Actual: " + getElement(accountData).getText() + "Expected: " + account);
			return getElement(accountData).getText().equals(account);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Validate Member email")
	public boolean validateMemberEmail(String email) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			getElement(emailData).getText().equals(email);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to validate Member Email", e);
			return false;
		}
	}

	public boolean validateMembershipType(String type) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			System.out.println("Actual: " + getElement(membershipType).getText() + "Expected: " + type);
			return getElement(membershipType).getText().equalsIgnoreCase(type);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String mc2LoginURL(String env) {
		try {

			String url = null;

			if (env.equals("STG") || env.equals("stage"))
				url = mc2URL.replace("environment", stage);
			else if (env.equals("DEV"))
				url = mc2URL.replace("environment", dev);
			else
				url = mc2URL.replace("environment", qa);

			System.out.println("MC2 Login URL: " + url);
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String MCS2SigninOTP(){
		try {
		/*	HashMap<String, String> userSec = PublicCommon.getCredentialData(ConfigReader.getValue("ProductMatrixSheet"),
					PublicCommon.CredentialsMap, "MCS2");
			String userSecret = userSec.get("StageSecret");

			jsonFileReader = new JsonFileReader();*/
			jsonFileReader = new JsonFileReader();
			JsonObject jsonObject=jsonFileReader.readJsonData("CredentialsMap","MCS1");
			String userSecret  = jsonObject.get("StageSecret").toString().replace('"',' ').trim();

			//String userSecret = jsonFileReader.getJsonString("CredentialsMap", "MSC2IA", "stageSecret");
			Clock clock = new Clock();
			final int DELAY_WINDOW = 1;

			Totp Totp = new Totp(userSecret, clock);
			String OTP = Totp.now();
			return OTP;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}
	public String MCS2SigninOTPForTCOAdminRole(){
		try {
			jsonFileReader = new JsonFileReader();
			JsonObject jsonObject=jsonFileReader.readJsonData("CredentialsMap","ChimeraTCOAdminAccount");
			String userSecret  = jsonObject.get("StageSecret").toString().replace('"',' ').trim();
			Clock clock = new Clock();
			final int DELAY_WINDOW = 1;

			Totp Totp = new Totp(userSecret, clock);
			String OTP = Totp.now();
			return OTP;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}

	@Step("Login to Microsoft and enter valid credentials")
	public void AzureLogin(String user, String password) {
		try {
			Thread.sleep(3000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(usernameField));
			sendKeys(user, usernameField);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(submitButton).click();
			PublicCommon.waitForSec(5);
			sendKeys(password, passwordField);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(submitButton).click();
			PublicCommon.waitForSec(4);
			getElement(staySigninNoBtn).click();
			Thread.sleep(3000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public By getUseAnotherAccount() {
		return UseAnotherAccount;
	}

	public void navigateToMemberOptionInMemberManagement() {
		try {
			getElement(memberManagement).click();
			// Thread.sleep(3000);
			getElement(memberOption).click();
			// Thread.sleep(10000);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMembershipRenewalOptionInAdmin() {
		try {
			ReusableMethods.scrollIntoView(getElement(admin), driver);
			getElement(admin).click();

			Thread.sleep(3000);
			getElement(membershipRenewal).click();
			// Thread.sleep(10000);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeys(String key, By locator) {
		try {
			getElement(locator).click();
			getElement(locator).clear();
			getElement(locator).sendKeys(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean clickCreateAccount() {
		try {

			// ReusableMethods.scrollIntoView(getElement(createAnAccountButton), driver);
			// waitForElementPresent(createAnAccountButton);
			// PublicCommon.JSClick(getElement(createAnAccountButton), driver);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}


	public List<WebElement> selectMembershipTypeStaus(String membershiptype) {

		return getElements(getMembershipType(membershiptype));
	}

	public boolean changeMembershipAccounttype(String membershiptype) {
		try {
			Thread.sleep(5000);
			ReusableMethods.scrollIntoView(getElement(membershipTypEditLink), driver);
			// ReusableMethods.scrollIntoView(getElement(headerMembershipType), driver);
			// getElement(membershipTypEditLink).click();
			PublicCommon.JSClick(getElement(membershipTypEditLink), driver);
			// getElement(membershipTypEditLink).click();
			getElement(membershipDropDown).click();
			selectMembershipTypeStaus(membershiptype).get(1).click();
			sendKeys("automated test", updateReason);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(saveStatusUpdate).click();
			PublicCommon.waitForSec(waitTime);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateAccountStatusToActiveIfMemberTypeIsRepresentative(String OrganizationID) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(editMemberAccountStatusDetails), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(editMemberAccountStatusDetails).click();
			sendKeys("automated test", updateReason);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(accountStatusDropDownField).click();
			//getElement(historicalStatus).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(activeStatus).click();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ContentPopup), 10);
			getElement(PrimaryYesBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(Header), 10);
			getElement(OrganizationName).sendKeys(OrganizationID);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(SelectOrg).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(AssignBtn).click();
			sendKeys("automated test", updateReason);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(saveStatusUpdate).click();
			PublicCommon.waitForSec(10);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Step("unable to upadee status to active")
	public void updateAccountStatusToActiveIfAccountStatusIsHistorical_WithRepresentative() {
		try {

				ReusableMethods.scrollIntoView(getElement(editMemberAccountStatusDetails), driver);
				getElement(editMemberAccountStatusDetails).click();

				getElement(accountStatusDropDownField).click();

				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(activeStatus));
				getElement(activeStatus).click();

				//WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AccountActiveWithRep), 10);
				//WaitStatementUtils.waitForElementStaleness(driver, getElement(AccountActiveWithRep), 10);
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AccountActiveWithRep), 10);
				getElement(AccountActiveWithRep).click();

				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(okBtn));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(okBtn));
				getElement(okBtn).click();

				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AssociateRepAccountInput));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AssociateRepAccountInput));
				getElement(AssociateRepAccountInput).sendKeys("test ");

				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AssociateRepFirstReuslt));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AssociateRepFirstReuslt));
				getElement(AssociateRepFirstReuslt).click();

				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(YesBtn));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(YesBtn));
				getElement(YesBtn).click();

				sendKeys("Automated Test", updateReason);

				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveStatusUpdate));
				getElement(saveStatusUpdate).click();

				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AccountStatus));
				Assert.assertTrue(getElement(AccountStatus).isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("unable to upadee status to active", e);
		}
	}

	@Step("Enter committee details")
	public void EnterCommitteeDetails(String MainCommittee){
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(CommitteeManagement), 10);
			getElement(CommitteeManagement).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(searchBox), 5);
			getElement(searchBox).sendKeys(MainCommittee);
			getElement(searchButton).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Enter Committee Details", e);
		}
	}

	public void SelectCommitteeRoster(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(CommitteeRosterTab),15);
			getElement(CommitteeRosterTab).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select Committee Roster", e);
		}
	}

	public void AddMemberToCommittee(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AddMemberToCommittee),10);
			getElement(AddMemberToCommittee).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Add Member To Committee", e);
		}
	}

	public List<WebElement> ListOfCommitteeDesignation() {
		return getElements(CommitteeDesignation);
	}

	public List<WebElement> listOfStatus(){
		return getElements(InActiveStatus);
	}

	public void GetAudiLogDetails(){
		ReusableMethods.scrollIntoView(getElement(auditLogsTab),driver);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		//getElement(auditLogsTab).click();
		WaitStatementUtils.waitForElementStaleness(driver, getElement(auditLogsTab));
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(auditLogsTab));
		PublicCommon.JSClick(getElement(auditLogsTab), driver);
	}

	public void clickOnPersonalDetailstab(){
		ReusableMethods.scrollIntoView(getElement(prsonalDetailsTab),driver);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(prsonalDetailsTab));
		PublicCommon.JSClick(getElement(prsonalDetailsTab), driver);
	}

	public void clickOnOrderHistorytab(){
		ReusableMethods.scrollIntoView(getElement(aorderHistoryTab),driver);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(aorderHistoryTab));
		PublicCommon.JSClick(getElement(aorderHistoryTab), driver);
	}

	public List<String> getOrderHistoryItemnames(){
		try {
			List<WebElement> itemsList = driver.findElements(By.xpath("//table[@class='customTable memHisTable']/tbody/tr/td[2]"));
			List<String> itemsListString = new ArrayList<String>();
			for (WebElement ele : itemsList) {
				itemsListString.add(ele.getText());
			}
			return  itemsListString;
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Unable to Fetch MCS2 Order Hsitory Products",e);
			return null;
		}
	}






	public void UseAnotherAccount(){
		getElement(UseAnotherAct).getSize();
	}

	@Step("Validate Use Another account tile")
	public void UseAnotherAccountTile(String username, String password) throws IOException {
		try {
			if (driver.findElements(usernameField).size() > 0) {
				signInToMC2(username, password);
			} else{
				ScreenshotUtil.takeScreenshotForAllure(driver);
				if (driver.findElements(UseAnotherAct).size() > 0) {
					WaitStatementUtils.waitForElementToBeClickable(driver, getElement(UseAnotherAct), 30);
					PublicCommon.waitForSec(5);
					getElement(UseAnotherAct).click();
					PublicCommon.waitForSec(5);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					MCS2signIn(username, password);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to get use another account title", e);

		}
	}

	@Step("Signin to MCS2 Internal Admin")
	public void signInToMC2(String user, String password) {
		try {
			EncryptionUtil encryptionUtil = new EncryptionUtil();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(usernameField));
			sendKeys(user, usernameField);
			getElement(submitButton).click();
			PublicCommon.waitForSec(2);
			getElement(passwordField).click();
			//sendKeys(password, passwordField);
			sendKeys(encryptionUtil.decrypt(password), passwordField);
			getElement(submitButton).click();
			PublicCommon.waitForSec(10);

			String OTP = MCS2SigninOTP();

			getElement(OTPtextbox).sendKeys(OTP);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(RemindIn14daysCheckBoxSignIn).click();

			getElement(VerifyBtn).click();
			Thread.sleep(5000);

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(userIcon), 20);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to sign in to MCS2", e);
		}
	}

	@Step("Sign in to {Application} }")
	public void signInToApplication(String user, String password,String Application) {
		try {
			EncryptionUtil encryptionUtil = new EncryptionUtil();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(usernameField));
			sendKeys(user, usernameField);
			getElement(submitButton).click();
			PublicCommon.waitForSec(2);
			getElement(passwordField).click();
			//sendKeys(password, passwordField);
			sendKeys(encryptionUtil.decrypt(password), passwordField);
			getElement(submitButton).click();
			PublicCommon.waitForSec(10);

			String OTP = MCS2SigninOTP();

			getElement(OTPtextbox).sendKeys(OTP);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(RemindIn14daysCheckBoxSignIn).click();

			getElement(VerifyBtn).click();
			Thread.sleep(5000);

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(userIcon), 20);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to sign in to MCS2", e);
		}
	}

	@Step("Signin to MCS2 Internal Admin")
	public void signInToMC2TC0Admin(String user, String password) {
		try {
			EncryptionUtil encryptionUtil=new EncryptionUtil();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(usernameField));
			sendKeys(user, usernameField);
			getElement(submitButton).click();
			PublicCommon.waitForSec(2);
			sendKeys(encryptionUtil.decrypt(password), passwordField);
			getElement(submitButton).click();
			PublicCommon.waitForSec(5);

			String OTP = MCS2SigninOTPForTCOAdminRole();

			getElement(OTPtextbox).sendKeys(OTP);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(RemindIn14daysCheckBoxSignIn).click();

			getElement(VerifyBtn).click();
			Thread.sleep(3000);

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(userIcon), 20);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to sign in to MCS2", e);
		}
	}

	public void MCS2signIn(String user, String password){
		try{
			EncryptionUtil encryptionUtil=new EncryptionUtil();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(usernameField));
			getElement(usernameField).sendKeys(user);
			getElement(submitButton).click();
			PublicCommon.waitForSec(20);
			sendKeys(encryptionUtil.decrypt(password), passwordField);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(submitButton),30);
			getElement(submitButton).click();
			PublicCommon.waitForSec(15);
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to sign in to MCS2", e);
		}
	}

	@Step("Validate Member Committee Info Tab details")
	public void GetMemberCommitteeInfoTab() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MemberCommitteeInfoTab), 5);
			getElement(MemberCommitteeInfoTab).getText().equals("Member Committee Information");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(MemberCommitteeInfoTab).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Get Member Committee InfoTab details", e);
		}
	}

	@Step("Verify Select Committee '{committee}' Designation details")
	public void SelectCommitteeDesignation(String committee){
		try{
			committeeName=committee;
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(CommitteeIcon),10);
			getElement(CommitteeIcon).getText().equals(committee);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(CommitteeIcon).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(MemberTitle),10);
			getElement(MemberTitle).getText().equals(committee);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Select Committee Designation", e);
		}
	}

	public List<WebElement> selectPrimaryActivity() {
		return getElements(PrimaryActivitySelect);
	}

	public String getSelectedPrimaryActivity(){
		return getElement(SelectedPrimaryActivity).getText();
	}

	@Step("Verify search for User whose Classification information to be updated.")
	public void UpdateClassificationInformation(String classificationInfoHeaderTxt,String textToSendKeys,String reasonForUpdate){
		try{
			expectedTxtListUponUpdatingMemCommitteeInfo=new LinkedList<>(Arrays.asList(committeeName,textToSendKeys,reasonForUpdate));

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ClassificationInfoHeader),10);
			getElement(ClassificationInfoHeader).getText().equals(classificationInfoHeaderTxt);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			expectedTxtListUponUpdatingMemCommitteeInfo.add(1,getElement(primaryActivityFieldValue).getText());
			getElement(EditIcon).click();
			PublicCommon.waitForSec(5);
			getElement(PAdropdown).click();
			List<WebElement> PrimaryActivity = selectPrimaryActivity();
			Random rand = new Random();
			int index = rand.nextInt(PrimaryActivity.size());
			selectPrimaryActivity().get(index).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			AlertPopup();
			PublicCommon.waitForSec(5);
			expectedTxtListUponUpdatingMemCommitteeInfo.add(2,getElement(primaryActivitySelectedDrpdwnValue).getText());
			System.out.println("expectedTxtListUponUpdatingMemCommitteeInfo:"+expectedTxtListUponUpdatingMemCommitteeInfo);
			updateMandatoryFieldsAfterPrimaryActivityUpdate(textToSendKeys,reasonForUpdate);
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Update Classification Information", e);
		}
	}

	public void updateDetails(String textToSendKeys,String reasonForUpdateTxt){
		try{
			getElement(Description).sendKeys(textToSendKeys);
			getElement(ClassificationReasonForUpdate).sendKeys(reasonForUpdateTxt);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Update Mandatory details", e);
		}
	}

	public boolean AlertPopup(){
			if (getElement(ContentPopUp).getText().contains("This action will remove")) {
				getElement(YesBtn).click();
			} else {
				return true;
			}
		return true;
	}

	@Step("Update Mandatory details after selecting Primary Activity")
	public void updateMandatoryFieldsAfterPrimaryActivityUpdate(String textToSendKeys,String reasonForUpdateTxt){
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);

			if (getSelectedPrimaryActivity().equals("Manufacturer of product/service")) {
				updateDetails(textToSendKeys,reasonForUpdateTxt);
			} else if (getSelectedPrimaryActivity().equals("Sales/distributor of material/product/service")) {
				updateDetails(textToSendKeys,reasonForUpdateTxt);
			} else if (getSelectedPrimaryActivity().equals("User/purchaser of product/service")) {
				updateDetails(textToSendKeys,reasonForUpdateTxt);
			} else if (getSelectedPrimaryActivity().equals("Testing of product/service")) {
				updateDetails(textToSendKeys,reasonForUpdateTxt);
			} else if (getSelectedPrimaryActivity().equals("Government Agency")) {
				getGovtInterests().sendKeys(textToSendKeys);
				getReasonForUpdate().sendKeys(reasonForUpdateTxt);
			} else if (getSelectedPrimaryActivity().equals("Academia")) {
				getAcademiaInterests().sendKeys(textToSendKeys);
				getReasonForUpdate().sendKeys(reasonForUpdateTxt);
			} else if (getSelectedPrimaryActivity().equals("Consumer")) {
				getConsumerInterests().sendKeys(textToSendKeys);
				getReasonForUpdate().sendKeys(reasonForUpdateTxt);
			} else if (getSelectedPrimaryActivity().equals("Consultant")) {
				getProductSold().sendKeys(textToSendKeys);
				getReasonForUpdate().sendKeys(reasonForUpdateTxt);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Select Committee Designation", e);
		}
		getElement(UpdateBtn).click();
		Assert.assertTrue(WaitStatementUtils.explicitWaitForVisibility(driver,getElement(recordUpdatedSuccMsg),5),"Failed to see updation success message");
		PublicCommon.waitForSec(5);
	}
	public List<String> getListOfWorkItems() {
		List<WebElement> options = getElements(listOfWorkItems);
		List<String> workItemsID = new ArrayList<String>();
		for (WebElement option : options) {
			workItemsID.add(option.getText());
		}
		return workItemsID;
	}

	@Step("Select Committee from grid")
	public void selectCommitteefromList(String MainCommittee) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			/*List<WebElement> CommitteeInSearchResult = getElementsNew(CommittepageGrid);
			for (WebElement skuElement : CommitteeInSearchResult) {
				if (skuElement.getText().trim().equals(MainCommittee)) {*/
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(y05Committee),10);
					getElement(y05Committee).click();
					//PublicAdminCommons.loaderClick(getElementsNew(CommittepageGrid).get(CommitteeInSearchResult.indexOf(skuElement)));
					/*PublicCommon.waitForSec(8);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					WaitStatementUtils.explicitWaitForVisibility(driver,getElement(CommitteDetailsPageCommittee),10);
					getElement(CommitteDetailsPageCommittee).getText().equals(MainCommittee);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					break;
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getSelectAccount(String accountNum) {
		if (driver.findElements(By.xpath("//div[@accountnumber='"+accountNum+"']")).size()!=0) {
			driver.findElement(By.xpath("//div[@accountnumber='" + accountNum + "']")).click();
			return true;
		}else{
			return false;
		}
	}

	public void getPrimaryActivityOfMember(String ActivityOfMember) {
		if (driver.findElements(By.xpath("//div[@activityname='"+ActivityOfMember+"']")).size() !=0){
			driver.findElement(By.xpath("//div[@activityname='"+ActivityOfMember+"']")).click();
		}else{
			driver.findElement(By.xpath("//div[@activityname='Other']")).click();
		}
	}

	@Step("Add members to the committee")
	public void addMembersToCommittee(List<String> accountsList) {
		try {
			for(String account : accountsList) {
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AddMemberToCommitteeBtn),10);
				getElement(AddMemberToCommitteeBtn).click();
				//PublicCommon.waitForSec(5);
				waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
				getElement(searchMember).sendKeys(account);
				PublicCommon.waitForSec(2);
				/*if(home.isElementDISPLAYED(getElement(resultVisible))) {
					getElement(closeBtn).click();
					continue;
				}*/
				if(getSelectAccount(account)==false) {
					getElement(closeBtn).click();
					continue;
				}
				else {
					ScreenshotUtil.takeScreenshotForAllure(driver);
					//getSelectAccount(account);
					getElement(VoteYesRedioBtn).click();
					ReusableMethods.scrollIntoView(getElement(primaryActivityOfMemberField),driver);
					getElement(primaryActivityOfMemberField).click();
					getPrimaryActivityOfMember("Consumer");
					IntegrationCommon.clickonWebElement(driver, ConsumerAdvisoryGroupNo);
					getElement(natureOfInterestField).sendKeys("Test");
					getElement(UpdateReasonField).sendKeys("Test");
					getElement(saveBtn).click();
					waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					//PublicCommon.waitForSec(15);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert(" unable to Add members to the committee", e);
		}
	}

	@Step("Admin/ISS Agent waits for loading screen to disappear")
	public void waitForLoadingScreenToDisappear(By locator) {
		try {
			Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, locator),
					"Loading screen did not disapeear.");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Loading screen did not disapeear.", e);
		}
	}

	@Step("Validate Membership Type in Audit log Tab")
	public void ValidateMembershipTypeInAuditLog(String MemberType) {
		try {
			GetAudiLogDetails();
			ReusableMethods.scrollIntoView(getElement(advancedSearchButton), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(MemberTypeDescription).getText().split("from")[1].split("to")[1].trim().equals(MemberType);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			a.sendKeys(Keys.PAGE_UP).build().perform();
			a.sendKeys(Keys.PAGE_UP).build().perform();
			a.sendKeys(Keys.PAGE_UP).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Loading screen did not disapeear.", e);
		}
	}
	public void MCS2IA_editWorkItem (String WorkItem, String EditedWorkItem){
			try {

				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MCS2_TopMenu_WorkItem), 5);
				getElement(MCS2_TopMenu_WorkItem).click();

				WaitStatementUtils.waitForElementStaleness(driver, workItemSearchField());
				workItemSearchField().sendKeys(WorkItem);
				Thread.sleep(2000);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				clickFindBtn();
				Thread.sleep(2000);
				ScreenshotUtil.takeScreenshotForAllure(driver);

				WaitStatementUtils.waitForElementStaleness(driver, getElement(MCS2_WI_Title));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MCS2_WI_Title));

				PublicCommon.clearTextFieldsendKeys(getElement(MCS2_WI_Title), EditedWorkItem);

				ScreenshotUtil.takeScreenshotForAllure(driver);
				//ReusableMethods.scrollIntoView(getElement(SaveBtn), driver);

				PublicAdminCommons.scrollToTopOfPage(driver);
				PublicCommon.JSClick(getElement(saveBtn), driver);
				Thread.sleep(2000);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(ConfirmBtn));
				PublicCommon.JSClick(getElement(ConfirmBtn), driver);
				Thread.sleep(5000);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} catch (Exception e) {
				e.printStackTrace();
				PublicAdminCommons.reportFailAssert("Failed to edit work Item in MCS2 IA.", e);
			}
		}

		@Step("Get updated Work Item Title from IA")
		public String getUpdatedWorkItemTitle(String WorkItem){
			try {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.waitForElementStaleness(driver, getElement(MCS2_TopMenu_WorkItem));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MCS2_TopMenu_WorkItem));
				getElement(MCS2_TopMenu_WorkItem).click();

				WaitStatementUtils.waitForElementStaleness(driver, workItemSearchField());
				workItemSearchField().sendKeys(WorkItem);

				clickFindBtn();
				ScreenshotUtil.takeScreenshotForAllure(driver);

				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.waitForElementStaleness(driver, getElement(MCS2_WI_Title));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MCS2_WI_Title));
				Thread.sleep(10000);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			} catch (Exception e) {
				e.printStackTrace();
				PublicAdminCommons.reportFailAssert("Failed to get WI title value from IA.", e);
			}
			return getElement(MCS2_WI_Title).getText();
		}
	@Step("search Member in search box")
	public void searchMemberInIAApplication(String AccountNumber) {
		try {
			Thread.sleep(5000);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(searchBox), 10);
			getElement(searchBox).sendKeys(AccountNumber);
			getElement(searchButton).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			getSelectNum(AccountNumber);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception in search member in search box", e);
		}
	}
	public List<WebElement> getListOfClassificationName()
	{
		List<WebElement> ClassificationNameLst= getElements(listOfClassification);
		return ClassificationNameLst;

	}
	public List<WebElement> getListOfClassificationNameInIA()
	{
		List<WebElement> ClassificationNameLst= getElements(listOfClassificationInIA);
		return ClassificationNameLst;

	}
	/*INT - 4964 : Start*/
	@Step("In IA, navigate to Membership reports page and then to Invoice Template")
	public void navigateToInvoiceTemplateTabFromMemReportsPageInIA(String accountNum,String downloadedFileInRNE){
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(reportsLink), 2);
			Actions action = new Actions(driver);
			action.moveToElement(getElement(reportsLink)).click(getElement(membershipReportsLink)).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(continueBtn), 2);
			clickonmethod("Continue",continueBtn,"Clicked on Continue Button for InVoice!!!");
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(accountNumInmMemInvoiceReceiptPage),5);
			sendKeys(accountNum,accountNumInmMemInvoiceReceiptPage);
			clickonmethod("Get Data",getDataBtn,"Clicked on Get Data Button for InVoice!!!");
			PublicCommon.waitForSec(5);
			setMapWithPrepopulatedFieldsDataForInvoiceTemplate(accountNum);
			ReusableMethods.scrollIntoView(getElement(generateInvoiceBtn),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("Generate Invoice",generateInvoiceBtn,"Clicked on Generate Invoice Button for InVoice!!!");
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to see member template for provided account number", e);
		}
	}

	public void setMapWithPrepopulatedFieldsDataForInvoiceTemplate(String accNo) throws Exception {
		List<WebElement> dataList=getElements(dataValuesFromGetData);
		String txt="";
		prepopulatedDataForGivenAcc.add(accNo);
		for(int i=3;i<dataList.size();i++){
			txt=dataList.get(i).getAttribute("value");
			log.info("-----dataList text:----"+txt);
			if(!txt.equals("")&&!txt.equals(null)) {
				prepopulatedDataForGivenAcc.add(txt);
			}
		}
	}
	/*INT - 4964 : End*/

	}
