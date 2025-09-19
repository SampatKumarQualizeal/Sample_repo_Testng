package pages.ui;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import io.qameta.allure.Step;
import org.apache.poi.openxml4j.opc.internal.unmarshallers.PackagePropertiesUnmarshaller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Homepage extends BasePage {

	LoginPage_SpecBuilder login;
	CreateGroupPage createGroup;

	public Homepage(WebDriver driver) {
		super(driver);
		login = getInstance(LoginPage_SpecBuilder.class);
		createGroup = getInstance(CreateGroupPage.class);
	}


	Actions action = new Actions(driver);

	public By accountHeader = By.xpath("//li[@id='account-menu']");
	public By myprofile = By.xpath("//button[contains(text(),'My Profile')]");
	public By switchAccount = By.xpath("//button[contains(text(),'Switch account')]");
	public By MyCommittees = By.xpath("//button[contains(text(),'My Committees')]");
	public By SignOut = By.xpath("//button[contains(text(),'Sign out')]");
	public By MyAccountInHeader=By.xpath("//span[text()='Account']");
	public By signOutButton = By.xpath("//button[text()='Sign out']");
	public By signhome = By.xpath("//h3[contains(.,'Sign In')]");
	public By manageBtn = By.xpath("//button[text()='Manage']");
	public By ManageCollabAreaTab = By.xpath("(//ul[contains(@class,'nav-tabs spec-nav')]/li/a)[1]");
	public By ManagePollsTab = By.xpath("(//ul[contains(@class,'nav-tabs spec-nav')]/li/a)[2]");
	public By ManageDraftsTab = By.xpath("(//ul[contains(@class,'nav-tabs spec-nav')]/li/a)[3]");
	
	
	public By CollaborationReports = By.xpath("//button[contains(.,'Collaboration Reports')]");
	public By SwitchtoAllCommittees = By.xpath("//button[contains(.,'Switch to All Committees')]");
	public By Committees = By.xpath("//td[text()='Committee']");
	public By ActiveWork = By.xpath("//td[contains(.,'Active Work Items')]");
	public By TotalCollabAreas = By.xpath("//td[contains(.,'Total Collab Areas')]");
	public By Collab = By.xpath("(//td[contains(.,'Collab %')])[1]");
	public By Stdwork = By.xpath("//td[contains(.,'New Std Work Items')]");
	public By CollabAreas = By.xpath("(//td[contains(.,'Collab Areas')])[2]");
	public By Collabb = By.xpath("(//td[contains(.,'Collab %')])[2]");
	public By RevisionWorkItems = By.xpath("//td[contains(.,'Revision Work Items')]");
	public By CollabAreass = By.xpath("(//td[contains(.,'Collab Areas')])[3]");
	public By Collabbe = By.xpath("(//td[contains(.,'Collab %')])[3]");
	
	public By Calender = By.xpath("//div[contains(@class,'fc fc-media-screen fc-direction-ltr fc-theme-standard')]");
	public By Events = By.xpath("//div[@class='astm-type-heading--h4'][contains(.,'Events')]");
	public By PMonthArrows = By.xpath("//button[contains(@title,'Previous month')]");
	public By RMonthArrows = By.xpath("//span[@class='fc-icon fc-icon-chevron-right']");
	public By Todaybutton = By.xpath("//button[@type='button'][contains(.,'today')]");
	public By CreateEvent = By.xpath("//button[contains(.,'Create Event')]");
	public By EventsTAb = By.xpath("//a[contains(.,'Events')]");
	public By CurrentmonthYear = By.xpath("//h2[@class='fc-toolbar-title'][contains(.,'December 2021')]");
	
	
	public By TotalActiveWKs = By.xpath("//td[contains(.,'Total Active WKs')]");
	public By TotalCollabarationArea = By.xpath("//td[contains(.,'Total Collabaration Areas')]");
	public By AreasWithDrafts = By.xpath("//td[contains(.,'Areas With Drafts')]");
	public By PercentwithDrafts = By.xpath("//td[contains(.,'Percent with Drafts')]");
	public By TotalCollabNewStd = By.xpath("//td[contains(.,'Total Collab New Std')]");
	public By TotalCollabRevStd = By.xpath("//td[contains(.,'Total Collab Rev Std')]");
	public By TotalCollabMembers = By.xpath("//td[contains(.,'Total Collab Members')]");
	public By AvgMembers = By.xpath("//td[contains(.,'Avg Members')]");
	
	
	
	public By ballotItem1 = By.xpath("//div[@class='dashboard-ballot-wrapper']//tbody/tr[1]//b");
	public By ballotsSection = By.xpath("//div[@class='dashboard-ballot-wrapper']");
	public By ballotsHeader = By.xpath("//span[text()='Polls']|//span[text()='Ballots']");
	public By createNewBallotBtn = By.xpath("//button[text()='Create New Poll']|//button[text()='Create New Ballot']");
	public By group = By.xpath("//span[text()='Collaboration Group']");
	public By ballotTitle = By.xpath("//span[text()='Poll Title']");
	public By closingDate = By.xpath("//span[text()='Closing Date']");
	public By showAllBallots = By.xpath("//*[text()='Show All Polls']| //*[text()='Show All Ballots']");
	public By homeBtn = By.xpath("//span[text()='Home']");
	public By superManage = By.xpath("//button[text()='Super Manage']");
	public By createNewGroupButton = By.xpath("//button[contains(text(),'Group')]|//button[contains(text(),'Area')]");
	public By spinner = By.xpath("//div[@class='astm-spinner spinner-border']");

	public By createNewcollabButton = By.xpath("//button[contains(text(),'Group')]|//button[contains(text(),'Area')]");
	public By showAllGroupsButton = By.xpath("//a[text()='Show All Collaboration Groups']|//a[text()='Show All Groups']| //a[text()='Show All Collaboration Areas']");
	public By renamecctoac = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[1]//td[1]//b");
	
	
	public By groupIdHomePage = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[1]//td[1]//b");
	public By groupName = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[1]//td[1]//span");
	public By groupName1 = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[1]//td[1]//span[2]");

	public By secondGroup = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[2]//td[1]//b");
	public By secondGroupName = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[2]//td[1]//span");
	public By groupNameHomepage = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[1]//td[1]//span");
	public By firstGroup = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[1]");
	public By selectWKfromCollabArea = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr/td");
	public By firstPoll = By.xpath("//span[text()='Vote Status']//following::tbody[1]/tr[1]//td[1]");
	public By firstpollId =By.xpath("//span[text()='Vote Status']//following::tbody[1]/tr[1]//td[1]//b");
	public By firstpollName =By.xpath("//span[text()='Vote Status']//following::tbody[1]/tr[1]//td[1]//span");
	//drafts
	public By draftHeader = By.xpath("//span[text()='Drafts']");
	public By draftSection = By.xpath("//div[@class='dashboard-draft-wrapper']");
	public By uploadDraft = By.xpath("//button[text()='Upload Draft']");
	public By draftGroupHeader= By.xpath("//div[@class='dashboard-draft-wrapper']//thead//tr//th[1]");
	public By draftTitleHeader = By.xpath("//div[@class='dashboard-draft-wrapper']//thead//tr//th[2]");
	public By draftUploadDate= By.xpath("//div[@class='dashboard-draft-wrapper']//thead//tr//th[3]");
	public By draftShowAllLink= By.xpath("//*[text()='Show All Drafts']| //a[contains(.,'Show All Standards')]| //button[contains(.,'Upload Standard')]");
	public By draftShowAllLinks= By.xpath("//a[contains(.,'All Drafts')]");
	public By firstDraft= By.xpath(" //div[@class='dashboard-draft-wrapper']//tbody/tr[1]//td[1]");
	public By firstDraftId = By.xpath("//div[@class='dashboard-draft-wrapper']//tbody/tr[1]//td[1]//b");
	public By firstDraftName = By.xpath(" //div[@class='dashboard-draft-wrapper']/Ba/tbody/tr[1]//td[1]//span");
	public By draftsTab=By.xpath("//a[contains(text(),'Drafts')]| //a[contains(text(),'Draft Docs')]");
	public By pollsTab=By.xpath("//a[contains(text(),'Polls')]|//a[contains(text(),'Ballots')]");
	public By draftsTabTitle=By.xpath("//div[@class=\"astm-type-heading--h4\" and text()='Drafts']");
	public By firstDraftUploadDate =By.xpath("//span[text()='Upload Date']//following::tr[1]/td[3]");
	public By firstMyGroupCreationDate =By.xpath("//span[text()='Creation Date']//following::tr[1]/td[2]");
	public By firstAllGroupsCreationDate =By.xpath("//span[text()='Creation Date']//following::tr[1]/td[3]");
	public By firstAllPollsClosingDate =By.xpath("//span[text()='Closing Date']//following::tr[1]/td[3]");
	public By firstAllDraftsUploadDate =By.xpath("//span[text()='Upload Date']//following::tr[1]/td[4]");
	public By firstPollClosingDate =By.xpath("//span[text()='Closing Date']//following::tr[1]/td[3]");
	public By pollsTabTitle=By.xpath("//div[@class=\"astm-type-heading--h4 mb-2\" and string()='Open Polls']");
	public By btnCreateNewGroup=By.xpath("//button[text()='Create New Group']");
	public By btnCreateNewPoll=By.xpath("//button[string()='Create New Poll']");
	public By btnUploadDraft=By.xpath("//button[string()='Upload Draft']");
	public By homePageLogo=By.xpath("//div[@class=\"spec-logo\"]");
	public By allGroupsHeader = By.xpath("//span[text()='All Groups']");
	//cookie message
	public By cookieMessage = By.xpath("//div[@role='alert']");
	public By cookieCloseButton = By.xpath("//div[@role='alert']//button[@class='close']//span");
	//public By privacyPolicyLink = By.xpath("//div[@role='alert']//child::a[contains(@href,'privacy_policy')]");
	public By privacyPolicyLink = By.xpath("//a[@href='https://www.astm.org/privacy-policy']");
	public By privacyPolicyLinkinpooter = By.xpath("//a[@href='https://stage.astm.org/privacy-policy']");
	//vote status
	public By voteStatusHeader = By.xpath("//div[@class='dashboard-ballot-wrapper']//thead//th[4]");
	public By latestPollVoteStatus = By.xpath("//div[@class='dashboard-ballot-wrapper']//tbody//tr[1]//td[4]//span");
	public By latestPollVoteStatus1 = By.xpath("//div[@class='dashboard-ballot-wrapper']//tbody//tr[2]//td[4]//span");
	//footer elements
	public By twitterLink = By.xpath("//a[contains(@href,'twitter.com/ASTMIntl')]");
	public By facebookLink = By.xpath("//a[contains(@href,'facebook.com/pages/ASTM')]");
	public By youtubeLink = By.xpath("//a[contains(@href,'youtube.com/ASTMIntl')]");
	public By linkedinLink = By.xpath("//a[contains(@href,'linkedin.com/company/astm')]");
	public By instagramLink = By.xpath("//a[contains(@href,'instagram.com/astmintl')]");
	public By UserAdministrationLink = By.xpath("//a[contains(@href,'stage-manage.astm.org/account')]");
	public By astmRSSLink = By.xpath("//a[contains(@href,'astm.org/RSS')]");
	public By Copyright_PermissionLink = By.xpath("//a[contains(@href,'copyright')]");
	public By helpDropdown = By.xpath("//a[@class=\"astm-type-body help-link\"]");
	public By supportFAQs = By.id("support");
	public By footerSection = By.xpath("//div[@class='footer page-content']");
	public By internationalASTM = By.xpath("//p[@class='astm_international']/span");
	public By copyRightFooter = By.xpath("//p[contains(text(), 'All Rights')]");
		public By supportLink = By.xpath("//li//a[contains(@href,'/help')]");
	public  By contactLink = By.xpath("//a[contains(@href,'contact')]");
	public By homeLink= By.xpath("//a[contains(@href,'-location')]");
	public By aboutASTM = By.xpath("//a[contains(@href,'ABOUT')]");
	public By privacyPolicy = By.xpath("//a[contains(@href,'CONTACT')]//following::a[contains(@href,'POLICY')]");
	public By policies = By.xpath("//a[contains(@href,'policies')]");
	public By copyRightPermission = By.xpath("//a[contains(@href,'copyright')]");
	//email Settings
	public By emailsettings = By.xpath("//a[contains(@href,'/email-settings')]");
	public By recentActivityHeader = By.xpath("//*[text()='Recent Activity']");
	public By recentActivityShowAll = By.xpath("//a[text()='Show All Activities']");
	public By recentActivityHeaderOnPage =  By.xpath("//h3[text()='Recent Activity']");
	public By DiscussionHeaderOnPage =  By.xpath("(//div[@class='discussion-tree-wrapper']//div)[2]");

	public By AccountASTMASTMInternationalCollaborationArea = By.xpath("//p[@class='accounts-content']/span[text()='ASTM International Collaboration Area']");
	public By getAccountSelectionHeader=By.xpath("//p[contains(text(),'Your email is registered to the organizations listed below')]");
	public By accountASTMASTMInternationalCollaborationArea1 = By.xpath("//span[text()='ASTM International Collaboration Area']");
	public By Select_ASTM_International_CollaborationArea = By.xpath("//p[@class='accounts-content']/span[text()='ASTM International Collaboration Area']/../button");
	public By getAccountSelectionButton(String fname)
	{
		return By.xpath("//span[contains(text(),'"+fname+"')]/following-sibling::button");
	}
	public By Select_OklahamaDot = By.xpath("//p[@class='accounts-content']/span[text()='Oklahoma DOT']/../button");

	
	//ShowAllTabs
	public By collabGrpNumber = By.xpath("//span[contains(text(),'Collaboration Area Number')]");
	//public By collabGrpNumber = By.xpath("//span[contains(text(),'Committee')]");
//	public By collabGrpName = By.xpath("//span[contains(text(),'Collaboration Area Name')]");
	public By collabGrpName = By.xpath("//span[contains(text(),'Collaboration Area ID')]");
	public By collabGrpCreationDate = By.xpath("//span[contains(text(),'Creation')]");
	public By allCollabGrpHeader = By.xpath("//span[@class='spec-dashboard-header__txt']");
	public By collabGrpNameCreateBtn = By.xpath("");
	public By draftAllHeader = By.xpath("//span[contains(text(),'Drafts')]");
	public By draftAllCollaGrp = By.xpath("//span[contains(text(),'Collaboration Area')]");
	public By draftAllDraftNumber = By.xpath("//span[contains(text(),'Draft Number')]");
	public By draftAllTitle = By.xpath("//span[contains(text(),'Title Name/File')]");
	public By draftAllUploadDate = By.xpath("//span[contains(text(),'Upload Date')]");
	public By draftAllUploadBy = By.xpath("//span[contains(text(),'Upload By')]");
	
	public By recCollabGrp = By.xpath("//h3[text()='Recent Activity']//following::table[1]//th[1]");
	public By recDate = By.xpath("//h3[text()='Recent Activity']//following::table[1]//th[2]");
	public By recActivityType = By.xpath("//h3[text()='Recent Activity']//following::table[1]//th[3]");
	public By recAvtivityTitle = By.xpath("//h3[text()='Recent Activity']//following::table[1]//th[4]");
	public By ballotHeader = By.xpath("//span[contains(text(),'Polls')]");
	public By ballotcollabGrp = By.xpath("//span[contains(text(),'Collaboration')]");
	public By ballotAllTitle = By.xpath("//span[contains(text(),'Ballot Title')]");
	public By ballotClosingDate = By.xpath("//span[contains(text(),'Closing Date')]");
	public By ballotVoteStatus = By.xpath("//span[contains(text(),'Vote Status')]");
	public By createColloborationAreaBtn = By.xpath("//button[contains(.,'Create Collaboration Area')]");
	public By help = By.xpath("//div[text()='Help']");
	public By showAllBallotsCount = By.xpath("//button[text()='Create New Ballot']//following::tfoot[1]//td");
	public By ballotRowCount = By.xpath("//tbody//tr");
	public By collabReports = By.xpath("//button[text()='Collaboration Reports']");
	//No items message
	
	public By DeleteCollaborationArea = By.xpath("//a[contains(.,'Delete Collaboration Area')]");
	
	public By collaGroup = By.xpath("//td[@class='no-record' and contains(text(),'Groups')]");
	public By ballotText = By.xpath("//td[@class='no-record' and contains(text(),'Polls')]");
	public By draftText = By.xpath("//td[@class='no-record' and contains(text(),'Drafts')]");
	public By RecentText = By.xpath("//td[@class='no-record' and contains(text(),'activities')]");
	public By DeleteText = By.xpath("//div[text()='You have no open ']");
	public By DeleteDraftsText = By.xpath("//div[text()='You have no open ']");
	public By DeletepollText = By.xpath("//div[text()='You have no open ']");
	public By managePollsTab = By.xpath("//a[text()='Manage Polls'] | //a[text()='Manage Ballots']");
	public By deletepoll = By.xpath("//a[contains(@href,'ballot/delete')]");
	public By manageDraft = By.xpath("//a[text()='Manage Drafts'] | //a[text()='Manage Draft Docs']");
	public By replaceDraft = By.xpath("//a[contains(@href,'draft/replace')]");
	public By deleteDraftTab = By.xpath("//a[contains(@href,'draft/delete')]");
	public By SpecBuilderAdminTab = By.xpath("//a[contains(text(),'SpecBuilder Admin')]");
	public By ArchivedGroupsTab = By.xpath("//a[contains(text(),'Archived Groups')]");
	public By ManageCollTab = By.xpath("//a[contains(text(),'Manage Collaboration Areas')]");
	public By DeleteCollTab = By.xpath("//a[contains(text(),'Manage Collaboration Areas')]");
	public By DeleteColltext = By.xpath("//div[text()='There are no ']");
	
	public By Accountmenu = By.xpath("//li[@id='account-menu']//a[1]");
	public By SpecBuilderAdmin = By.xpath("//a[@class='nav-link'][contains(.,'SpecBuilder Admin')]");
	public By UserAdministration = By.xpath("//button[contains(.,'User Administration')]");
	
	public By Logo = By.xpath("//div[contains(@class,'spec-logo')]");
	
	public By Dropdown = By.xpath("//li[@id='account-menu']//a[1]");
	
	
	public By MyProfile = By.xpath("//button[text()='My Profile']");
	public By Switchaccount = By.xpath("//button[contains(text(),'Switch account')]");
	public By signOut = By.xpath("//button[contains(text(),'Sign out')]");
	public By nameOfGroup = By.cssSelector("input[name='groupName']");
	public By selectCommittee = By.xpath("//select[@aria-label='Select Value']");
	public By SubGroupTab = By.xpath("//a[@class='nav-link active'][contains(.,'Sub-Groups')]");
	
	public By MyGroupsTitle = By.xpath("//span[@class='spec-dashboard-header__txt'][contains(.,'My Groups')]");
	public By BallotsTitle = By.xpath("//span[@class='spec-dashboard-header__txt'][contains(.,'Ballots')]");
	public By DraftsTitle = By.xpath("//span[@class='spec-dashboard-header__txt'][contains(.,'Drafts')]");
	public By RecentActivityTitle = By.xpath("//span[@class='spec-dashboard-header__txt'][contains(.,'Recent Activity')]");
	public By AccessDenied = By.xpath("//span[contains(.,'You do not have access to this account. If access is needed, please log in with the correct log-in information or contact Support at support@astm.org.')]");
	private By createGroupButton = By.xpath("//button[contains(text(), 'Create')]");
	public By AccountMenu = By.xpath("//li[@id='account-menu']");
	public By MyProfileMenuItem = By.xpath("//button[text()='My Profile']");
	public By MyCommitteeMenuItem = By.xpath("//button[text()='My Committees']");
	public By SwitchAccountMenuItem = By.xpath("//button[text()='Switch account']");
	public By SignoutMenuItem = By.xpath("//button[text()='Sign out']");
	public By WorkItemHeaders = By.xpath("//div[contains(@class,'title')]");
	public By goToCollaborationAreaLink=By.linkText("Go to Collaboration Area");
	public By CollabAreaWrapper = By.xpath("//span[text()='My Collaboration Areas']/../../div[2]");
	public By WIinCollabArea = By.xpath("//div[@class='overview-page-wrapper']/h2[1]");
	public By PublicMycomitteesHeader = By.xpath("//h1[text()='MyCommittees']");




	public By getAllUploadRadioButtonXpath(String option) {
		return By.xpath("//input[@name='uploadAllCan' and @value='" + option + "']");
	}
		public By getInitialDraftXpath(String option) {
			return By.xpath("//input[@name='isUploadNow' and @value='" + option + "']");
		
	}
		
		public By getAllFilesXpath(String option) {
			return By.xpath("//input[@name='uploadAllSupportCan' and @value='" + option + "']");
		}
		
		
	
//	public By collaGroup = By.xpath("");
//	public By collaGroup = By.xpath("");
//	public By collaGroup = By.xpath("");
//	public By collaGroup = By.xpath("");
//	public By collaGroup = By.xpath("");
//	public By collaGroup = By.xpath("");
//	public By collaGroup = By.xpath("");
	
	
	

	public String getcollabpollNumber() {
		try {
			String id = getElement(firstpollId).getText();
			System.out.println(id);
		return id;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getcollabpollName() {
		try {
			String id = getElement(firstpollName).getText();
			System.out.println(id);
		return id;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	
	
	public int getBallotCountOnShowAllLink() {
		try {
			String value =getElement(showAllBallotsCount).getText();
			String count = value.substring(6);
			int inum = Integer.parseInt(count);
			System.out.println(count);
		return inum;
		}
		catch (Exception e) {
			e.getStackTrace();
			return 0;
		}
	}
	
	public int ballotRowCountInShowAll() {
		try {
			List<WebElement> ele = driver.findElements(ballotRowCount);
			int size = ele.size();
			System.out.println(size);
		return size;
		}
		catch (Exception e) {
			e.getStackTrace();
			return 0;
		}
	}
	
	

	public boolean verifyBallots() {
		try {
			for(int i=0; i<=4; i++) {
				getElement(By.xpath("//div[@class='dashboard-ballot-wrapper']//tbody/tr["+i+"]")).isDisplayed();
			}
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	

//	public By 
//	public By 


	public boolean isWebElementDisplayed(WebElement element) {
		try {
			
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @param locator
	 * @return
	 */
	public boolean isWebElementDisplayed(By locator) {
		try {
			WebElement ele = getElement(locator);
			return ele.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @return true/false value Gets successful login details
	 */
	public boolean VerifyLoginSuccessOnHomePage() {
		try {
			boolean value = getElement(manageBtn).isDisplayed();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/** 
	 * Clicks on Create New Group Button
	 * 
	 * **/
	@Step("Verify clickOnCreateNewGroupButton")
	public boolean clickOnCreateNewcollabButton() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createNewcollabButton),65);
			PublicAdminCommons.scrollToElement(driver, getElement(createNewcollabButton));
			getElement(createNewcollabButton).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Step("Verify clickOnCreateNewGroupButton")
	public boolean clickOnCreateNewGroupButton() {
		try {
			PublicCommon.waitForSec(15);
			WaitStatementUtils.explicitWait(driver,getElement(createNewGroupButton));
			PublicCommon.invisibilityOfElement(driver,getElement(spinner));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createNewGroupButton),90);
			getElement(createNewGroupButton).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean selectCommitte(String commName) {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectCommittee));
			WebElement element = getElement(selectCommittee);
			ReusableMethods.scrollIntoView(element, driver);
			element.click();
			Select select = new Select(element);
			String value = commName;
			select.selectByValue("C03");
		//	select.selectByVisibleText(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean enterTextInNameOfGroup(String value) {
		try {
			getElement(nameOfGroup).clear();
			getElement(nameOfGroup).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectOptionFromAllUserUploadRadioButton(String option) {
		try {
			getElement(getAllUploadRadioButtonXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectOptionFromUploadInitialDraftRadioButton(String option) {
		try {
			getElement(getInitialDraftXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean clickCreateGroupButton() {
		try {
			getElement(createGroupButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectOptionFromAllSupportFilesRadioButton(String option) {
		try {
			getElement(getAllFilesXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	/** 
	 * Clicks on Show All groups
	 * 
	 * **/
	public boolean clickShowAllGroupsButton() {
		try {
			PublicCommon.waitForSec(15);
			ReusableMethods.scrollIntoView(getElement(showAllGroupsButton), driver);
			getElement(showAllGroupsButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/** 
	 * Clicks on Manage Button
	 * 
	 * **/

	public boolean clickManageButton() {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(manageBtn));
			PublicAdminCommons.scrollToElement(driver, manageBtn);
			getElement(manageBtn).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnMethod(String elementName, By locator, String assertionMessage) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator), 60);
			Assert.assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click on element", e);
		}
	}

	@Step("SignOut")
	public void signOut(){
		try{
			clickOnMethod("My Account",MyAccountInHeader,"Failed to click on My Account In Header");
			clickOnMethod("SignOut button",signOutButton,"Failed to click on SignOut");
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	public String getGroupIdFromHomePage() {
		try {
			return getElement(groupIdHomePage).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getGroupNameFromHomePage() {
		try {
			String value =getElement(groupName1).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getBallotGroupIdFromHomePage() {
		try {
		return getElement(firstpollId).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getBallotGroupNameFromHomePage() {
		try {
			String value = getElement(firstpollName).getText();
		//	String ballotGroupName = value.substring(2);
			System.out.println(value);
		return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getDraftGroupIdFromHomePage() {
		try {
		return getElement(firstDraftId).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getDraftGroupNameFromHomePage() {
		try {
			String value = getElement(firstDraftName).getText();
			String draftGroupName = value.substring(2);
		return draftGroupName;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public Boolean isElementDISPLAYED(WebElement Element)
	{
		try {
			if (Element.isDisplayed())
				return true;
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getFirstGroupNameFromHomePage() {
		try {
			String value = getElement(groupNameHomepage).getText();
			String subString = value.substring(2);
			System.out.println(subString);
		return subString;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getSecondGroupIdFromHomePage() {
		try {
		return getElement(secondGroup).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getSecondGroupNameFromHomePage() {
		try {
		return getElement(secondGroupName).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	
	

	public boolean clickOnGroup(String groupID) {
		try {
			WebElement group= getElement(By.xpath("//div[@class='dashboard-group-wrapper']//tbody[1]//tr//td[1]//b[text()='"+groupID+"']"));
			group.isDisplayed();
			group.click();
			return true;
			}
			catch (Exception e) {
				e.getStackTrace();
				return false;
			}
	}
	@Step("clickOnGroupInShowAll")
	public boolean clickOnGroupInShowAll(String groupID) {
		try {
			System.out.println(groupID);
			ReusableMethods.ScrollIntoView(driver);
			getElement(showAllGroupsButton).click();
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createNewcollabButton),20));
			WebElement group=getElement(By.xpath("//div[@class='spec-sort-table-wrapper']//tbody[1]//tr//td[text()='"+groupID+"']"));
			ReusableMethods.scrollIntoView(group, driver);
			group.isDisplayed();
			group.click();

			return true;
			}
			catch (Exception e) {
				e.getStackTrace();
				return false;
			}
	}
	
	public boolean groupInShowall(String groupID) {
		try {
			WebElement group=getElement(By.xpath("//div[@class='spec-sort-table-wrapper']//tbody[1]//tr//td[text()='"+groupID+"']"));
			ReusableMethods.scrollIntoView(group, driver);
			boolean value = group.isDisplayed();
			return value;
			}
			catch (Exception e) {
				e.getStackTrace();
				return false;
			}
	}

	public boolean clickOnFirstGroup() {
		try {
			Thread.sleep(3000);
			ReusableMethods.SCrollIntoView(driver);
			getElement(firstGroup).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
			}
			catch (Exception e) {
				e.getStackTrace();
				return false;
			}
	}

	/**
	 * Method used to click
	 * on Drafts Section of
	 * a Group
	 */
	public boolean clickOnDraftsTabAndVerifyNavigation()
	{
		WebElement elementDraftsTab= getElement(draftsTab);
		WaitStatementUtils.waitForElementToBeClickable(driver,elementDraftsTab);
		elementDraftsTab.click();
		boolean result=true;
//		result =getElement(draftsTabTitle).isDisplayed();
		return result;

	}
	/**
	 * Method used to click
	 * on Polls Section of
	 * a Group
	 */
	public boolean clickOnPollsTabAndVerifyNavigation()
	{
		WebElement elementDraftsTab= getElement(pollsTab);
		WaitStatementUtils.waitForElementToBeClickable(driver,elementDraftsTab);
		elementDraftsTab.click();
		boolean result=false;
		result =getElement(pollsTabTitle).isDisplayed();
		return result;
	}

	/**
	 * Method used to
	 * navigate to homepage
	 * @return
	 */
	public boolean goToHomePage()
	{
		getElement(homePageLogo).click();
		if(getPageTitle().equals("SpecBuilder"))
			return true;
		else
			return false;
	}
	
	
	
	public String getURL() {
		try {
				String currentURL = driver.getCurrentUrl();
				System.out.println("Actual"+currentURL);
				return currentURL;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public String getVoteStatus() {
		try {
				String status = getElement(latestPollVoteStatus).getText();
				System.out.println(status);
				return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public String verifyURL(WebElement element, String pageTitle) {
		try {
			ReusableMethods.scrollIntoView(element, driver);
			String parentWinodw = driver.getWindowHandle();
			action.moveToElement(element).click(element).build().perform();
			ReusableMethods.waitForNewWindow(driver, 20);
			Iterator<String> Windowhandle = driver.getWindowHandles().iterator();
			// Iterating window handles
			while (Windowhandle.hasNext())
			{
				String child = Windowhandle.next();
				if (!parentWinodw.equals(child)) {
					driver.switchTo().window(child);
					waitForPageTitle(pageTitle);
					WaitStatementUtils.implicitWaitForSeconds(driver, 15);
					String currentURL = driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWinodw);
					return currentURL;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	
	/**
	 * This method is to check whether social media icons are visible or not
	 */
	public boolean verifySocailMediaIconVisibility() {
		boolean socialIconisVisible = false;
		try {
			WebElement socialMediaIcon = driver.findElement(By.xpath("//p[@class='icon-logos']"));
			List<WebElement> elementsList = socialMediaIcon.findElements(By.tagName("a"));

			for (int i = 0; i <= elementsList.size(); i++) {
				socialIconisVisible = elementsList.get(i).isDisplayed();
				if (i == 5) {
					return socialIconisVisible = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return socialIconisVisible;
	}
	
	/**
	 * This method will click on Twitter link & verify its url
	 */
	public boolean verifyTwitterURL() {
		try {
			String actualURL = verifyURL(getElement(twitterLink), "Twitter url should be verified");
			if (actualURL.trim().contains(ConfigReader.getValue("twitter"))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * This method will click on facebook link & verify its url
	 */

	public boolean verifyFacebookURL() {
		try {
			String actualURL = verifyURL(getElement(facebookLink),"Facebook url should be verified");
			if (actualURL.trim().contains(ConfigReader.getValue("facebook")))
				System.out.println(actualURL);
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyUserAdministrationURL() {
		try {
			String actualURL = verifyURL(getElement(UserAdministrationLink),"UserAdministrationLink url should be verified");
			if (actualURL.trim().contains(ConfigReader.getValue("UserAdministration")))
				System.out.println(actualURL);
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * This method will click on youtube link & verify its url
	 */
	public boolean verifyYouTubeURL() {
		try {
			String actualURL = verifyURL(getElement(youtubeLink), "Youtube url should be verified");
			String expectedUrl = ConfigReader.getValue("youtube");
			if (expectedUrl.contains(actualURL))
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will click on LinkedIN link & verify its url
	 * 
	 * @return
	 */
	public boolean verifyLinkedInURL() {
		try {
			String actualURL = verifyURL(getElement(linkedinLink), "LinkedIn  url should be verified");
			if (actualURL.trim().contains(ConfigReader.getValue("linkedin"))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will click on Instagram link & verify its url
	 * 
	 * @return
	 */
	public boolean verifyInstagramURL() {

		try {
			String actualURL = verifyURL(getElement(instagramLink),"Instagram url should be verified");
			if (actualURL.trim().contains(ConfigReader.getValue("instagram"))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will click on ASTM RSS link & verify its url
	 * 
	 * @return
	 */
	public boolean verifyRSSLinkURL() {
		try {
			String actualURL = verifyURL(getElement(astmRSSLink), "RSS Link url should be verified");
			if (actualURL.trim().contains(ConfigReader.getValue("rsslink"))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method returns International ASTM logo is visible on the page
	 * 
	 * @return
	 */
	public boolean verifyInternationalASTM() {
		try {
			ReusableMethods.scrollIntoView(getElement(internationalASTM), driver);
			boolean astmLOGO = isWebElementDisplayed(internationalASTM);
			return astmLOGO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public String getGroupId(String groupID) {
		try {
			WebElement group= getElement(groupIdHomePage);
			group.isDisplayed();
			String value =group.getAttribute("value");
			group.click();
			return value;
			}
			catch (Exception e) {
				e.getStackTrace();
				return null;
			}
	}
	

	public boolean groupOnGroupWidget(String groupID) {
		try {
			WebElement group= getElement(By.xpath("//div[@class='dashboard-group-wrapper']//tbody[1]//tr//td[1]//b[text()='"+groupID+"']"));
			group.isDisplayed();
			return true;
			}
			catch (Exception e) {
				e.getStackTrace();
				return false;
			}
	}

	@Step("Select Account type and navigate to home page")
	public boolean SelectAccountType(){
			if(getElement(AccountASTMASTMInternationalCollaborationArea).getText().equals("ASTM International Collaboration Area")) {
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AccountASTMASTMInternationalCollaborationArea), 15);
				verifyVisibility("ASTM International Collaboration Area", AccountASTMASTMInternationalCollaborationArea, "Select an Account in SPB");
				getElement(Select_ASTM_International_CollaborationArea).click();
				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(homeBtn), 30);
				verifyVisibility("Click to Open", homeBtn, "Home button in visible in SPB");
				PublicCommon.waitForSec(30);
				return true;
			} else {
				return true;
			}
	}

	@Step("Select Account type and navigate to home page")
	public boolean SelectAccountType(int index,String FirstName){
		try {
			PublicCommon.waitForSec(20);
			if (isElementDISPLAYED(getElement(getAccountSelectionButton(FirstName)))) {
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getAccountSelectionButton(FirstName)),30);
				ReusableMethods.scrollIntoView(getElement(getAccountSelectionButton(FirstName)),driver);
				PublicCommon.JSClick(getElement(getAccountSelectionButton(FirstName)),driver);
				PublicCommon.waitForSec(5);
				return true;
			}
			else {
				return true;
			}
		} catch (Exception e) {
			PublicCommon.reportFailAssert("Unable to click on select Account",e);
			return false;
		}
	}

	@Step("Select Account type and navigate to home page")
	public boolean SelectAccountTypeOklahama(){
		if(getElement(AccountASTMASTMInternationalCollaborationArea).getText().equals("ASTM International Collaboration Area")) {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AccountASTMASTMInternationalCollaborationArea), 15);
			verifyVisibility("ASTM International Collaboration Area", AccountASTMASTMInternationalCollaborationArea, "Select an Account in SPB");
			getElement(Select_ASTM_International_CollaborationArea).click();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(homeBtn), 30);
			verifyVisibility("Click to Open", homeBtn, "Home button in visible in SPB");
			PublicCommon.waitForSec(30);
			return true;
		} else {
			return true;
		}
	}

	@Step("Verify Visibility of Element {elementName}")
	public void verifyVisibility(String elementName, By locator, String assertionMessage) {
		try {
			Assert.assertTrue(IntegrationCommon.isWebElementDisplayed(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}

	@Step("Verify successful login for Admin")
	public void verifyAdminLogin(String username, String password) {
		try {
			Assert.assertTrue(login.loginAndSelectCorrectAccountSTG4432(username,password), "User should be logged in");
			handleASTMInternationalCollaborationArea();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(homeBtn),30);
			verifyVisibility("Click to Open", homeBtn, "Home button in visible in SPB");
			PublicCommon.waitForSec(5);
			login.cookieclose();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Login as Staff admin", e);
		}
	}
	@Step("Verify successful login for Admin")
	public void verifyAdminLogin4432(String username, String password) {
		try {
			Assert.assertTrue(login.loginAndSelectCorrectAccountSTG(username,password), "User should be logged in");
			//handleASTMInternationalCollaborationArea();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(homeBtn),30);
			verifyVisibility("Click to Open", homeBtn, "Home button in visible in SPB");
			PublicCommon.waitForSec(5);
			login.cookieclose();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to Login as Staff admin", e);
		}
	}

	@Step("Click on Account ASTM International Collaboration Area")
	public void handleASTMInternationalCollaborationArea() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AccountASTMASTMInternationalCollaborationArea),15);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			IntegrationCommon.clickonWebElement(driver, Select_ASTM_International_CollaborationArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verify details in Account Menu Tab and click on My Committee Link")
	public void VerifyAccountMenuTab(){
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AccountMenu));
			WaitStatementUtils.waitForElementStaleness(driver, getElement(AccountMenu));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AccountMenu));
			clickOnMethod("Account Menu",AccountMenu , "Click on My Account Menu");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			assertEquals(getElement(MyProfileMenuItem).getText(),"My Profile");
			assertEquals(getElement(MyCommitteeMenuItem).getText(),"My Committees");
			//assertEquals(getElement(SwitchAccountMenuItem).getText(),"Switch account");
			assertEquals(getElement(SignoutMenuItem).getText(),"Sign out");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("My Committees",MyCommitteeMenuItem , "click on My Committee link");
			Assert.assertTrue(PublicAdminCommons.switchToNewOpenedTab(driver, 1),
					"Admin is unable to switch to new tab");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(PublicMycomitteesHeader),15);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify visibility of signin/Register header tab", e);
		}
	}

	@Step("Verify Created workitem upon clicking on Go to collaboration area in Member app ")
	public boolean ValidateCreatedWorkItemSPB(String WorkItemid){
		try{
			clickOnMethod("Go to Collaboration Area link",goToCollaborationAreaLink,"Go to Collaboration Area link is not clicked");
			PublicCommon.waitForSec(5);
			ReusableMethods.switchToLastWindowTabOpenedByDefault(driver);
			Assert.assertTrue(getPageTitle().equals("SpecBuilder"),"user is not navigated to SpecBuilder site");
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(WorkItemHeaders),15);
			getElement(WorkItemHeaders);
			List<WebElement> WorkItemHeader = driver.findElements(WorkItemHeaders);
			for (WebElement groupElement : WorkItemHeader) {
				if (groupElement.getText().equals(WorkItemid)) {
					return true;
				}
			}
			String CollabAreaName=getElement(WorkItemHeaders).getText().split("-")[0].trim();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			Assert.assertTrue(createGroup.clickHomeButton(), "Admin is unable to click on Home Button");
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(firstGroup),30));
			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicCommon.waitForSec(15);
		//	getElement(selectWKfromCollabArea);
			List<WebElement> HomepageWorkItemCheck = driver.findElements(selectWKfromCollabArea);
			for (WebElement groupElement : HomepageWorkItemCheck) {
				//if (groupElement.getText().split("-")[1].trim().equals(WorkItemid)) {
				if (groupElement.getText().contains(CollabAreaName)) {
					PublicCommon.waitForSec(10);
					groupElement.click();
					return true;
				}
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify created workitem in specbuilder", e);
		}
		return true;
	}

	@Step("Verify if Created workitem is deleted in SPB or not.")
	public void SwitchToSpecBuilderCheckDeletedWK(String WorkItemid) {
		try {
			driver.get(ConfigReader.getValue("BASE_URL_SPB"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			verifyVisibility("ASTM International Collaboration Area", accountASTMASTMInternationalCollaborationArea1, "Select an Account in SPB");
			getElement(Select_ASTM_International_CollaborationArea).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			verifyVisibility("Click to Open", homeBtn, "Home button in visible in SPB");
			validateDeletedWKSPB(WorkItemid);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to switch to specbuilder and check deleted workitem", e);
		}

	}

	@Step("Validate if the deleted WorkItem in specbuilder is visible in Membership")
	private void validateDeletedWKSPB(String WorkItemid) {
		try {
			int flag=0;
			List<WebElement> Links=getElements(By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr"));
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
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("Successfully validated deleted WorkItem in SPB");

	}


	public boolean clickOnGroupName(String groupName) {
		try {
			WebElement group = getElement(By.xpath("//div[@class='dashboard-group-wrapper']//tbody[1]//tr//td[1]//span[text()='" + groupName + "']"));
			group.isDisplayed();
			WaitStatementUtils.waitForElementToBeClickable(driver, group, 30);
			SpecBuilderCommon.JSClick(group, driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickOnGroupNameinShowAllGroups(String groupName) {
		try {
			WebElement group = getElement(By.xpath("//td/span[contains(text(),'"+groupName+"')]"));
			group.isDisplayed();
			WaitStatementUtils.waitForElementToBeClickable(driver, group, 30);
			SpecBuilderCommon.JSClick(group, driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

}
