package pages.ui;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.apache.kafka.common.protocol.types.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.*;
import static pages.ui.MAEIntegrationPage.switchToWindowByTitle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage_Subscripiton extends BasePage {
	public By inputTextFieldOfSearchTxtArea=By.id("search_input_mainpage");
	public By designationSearch = By.xpath("//label[text()='Designation']");
	public By accountNameDropdown=By.xpath("(//div[@class='user_name astm-type-body mobile-hide-style'])[2]/parent::a");
	public By getHomePageMainLinks(String linkTxt){
		return By.xpath("//a[text()='"+linkTxt+"']");
	}
	public By getHomePageMenuSubLinks(String linkText){
		return By.xpath("(//span[text()='"+linkText+"'])[1]");
	}
	private By closeBtnOfAIpopup=By.xpath("//button[@type='button' and @class='close']");
	public By leftMenuSubscriptionsSubLinks=By.xpath("//p[contains(@class,'major-sub-menu')]/a");
	public By semanticSearch_Button=By.xpath("//input[@id='SEMANTICSEARCH_mainpage']");
	public HomePage_Subscripiton(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By publishedDateOfRecentlyAccessedDoc = By.xpath("(//p[contains(@class,'foot-content')])[1]");
	public By recentlyAccessedDoc = By.xpath("//p[@class='line-clamp'][1]");
	public By docRecentlyAddedToFavorites(String docTitle) {
		return	By.xpath("//p[text()='"+docTitle+"']");
	}
	public By publishedDateOfDocRecentlyAddedToFavorites(String docTitle) {
		return	By.xpath("//p[text()='"+docTitle+"']/ancestor::div[@class='card-body']/following-sibling::div/p");
	}
	/*INT_682 start*/
	public By welcomeBackHeaderOnHomePage=By.xpath("//h1[contains(@class,'wlc-title')]");
	/*INT_682 end*/
	Actions action = new Actions(driver);
	public By header = By.xpath("//h2[@class='astm-header1 wlc-title']//span");
	public By recentlyAccessedTab = By.xpath("//span[contains(text(),'Recently Accessed')]//ancestor::p");
	public By welcomeBackHeader = By.xpath("//*[contains(text(),'Welcome Back')]");
	//	public By trackerTab = By.xpath("//a[contains(text(),'Tracker')]//ancestor::p");
	public By trackerTab = By.xpath("//span[contains(text(),'Tracker')]//ancestor::p");
	public By trackerTabActive = By.xpath("//p[contains(@class,'active')]");
	public By favoritesTab1 = By.xpath("//span[contains(text(),'Favorites')]//ancestor::p");
	public By favoritesTab = By.xpath("//span[contains(text(),'Favorites')]//ancestor::p/span");
	public By subscriptionsTab = By.xpath("(//span[contains(text(),'Subscriptions')]//ancestor::p");
	public By subscriptions_Tab = By.xpath("//p[@class='tab astm-type-heading--h6']//span[text()='Subscriptions']");
	public By homePageTabs(String tabName){
		return By.xpath("//p[contains(@class,'astm-type-heading--h6')]//span[text()='"+tabName+"']");
	}
	public By tiles_text = By.xpath("//p[@class='noPaddingMargin astm-type-body--lead bold']");
	private By cardcontent = By.xpath("//*[@class='card-content row']//*[@class='card-adjust card']");
	public By tripTricks = By.xpath("//span[text()='Tips & Tricks']");
	public By deleteIcon = By.xpath("//i[@class='astm-icon far fa-trash-alt pointer-cursor']");
	public By columnNote = By.xpath("//span[@class='astm-type-body--lead' and text()='Note']");
	public By columnDate = By.xpath("//span[@class='astm-type-body--lead' and text()='Date']");
	public By columnDocument = By.xpath("//span[@class='astm-type-body--lead' and text()='Document']");
	public By SeeMoreNotes = By.xpath("//span[@class='astm-link document-column pointer-cursor' and text()='See More']");
	public By SeeLessNotes = By.xpath("//span[@class='astm-link date-column pointer-cursor' and text()='See Less']");
	public By DatesNotes = By.xpath("//td[@class='astm-table-td astm-type-body--lead date-column']");
	public By DocumentsNotes = By.xpath("//td[@class='astm-table-td astm-type-body--lead document-column']//span//a");
//	public By technicalCommittees = By.xpath(
//			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p[contains(text(),'Technical Committees')]");
	public By technicalCommittees = By.xpath(
			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p//a[contains(text(),'Technical Committees')]");
//	public By membership = By.xpath(
//			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p[contains(text(),'Membership')]");
	public By membership = By.xpath(
		"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p//a[contains(text(),'Join as a Member')]");
	private By membershipURL = By.xpath(
			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p[contains(text(),'Membership')]/parent::a");
	public By MYASTM = By.xpath(
			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p[contains(text(),'MyASTM')]");
	public By meetingSymposia = By.xpath(
			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p[contains(text(),'Meetings & Symposia')]");
//	public By publishWithASTM = By.xpath(
//			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p[contains(text(),'Publish with ASTM')]");
	public By publishWithASTM = By.xpath(
			"//span[contains(text(),'ASTM Community')]/parent::p/parent::div//following-sibling::div//p//a[contains(text(),'Publish with ASTM')]");

	public By compassNotes = By.xpath("//h1[contains(text(),'Recently Updated & Recently Accessed')]");
	public By versionComparison = By.xpath("//span[contains(text(),'Compare Version')]");
	public By privacyPolicy = By.xpath("//a[contains(@href,'/POLICY/privacy_policy.html')]");
	public By policies = By.xpath("//a[contains(@href,'/prpolicy.html')]");
	public By privacyPolicyHeader = By.xpath("//h1[text()='PRIVACY POLICY']");
	public By policiesHeader = By.xpath("//h1[text()='ASTM Policies']");
	private By copyRights = By.xpath("//a[contains(@href,'/COPYRIGHT/index.html')]");
	private By copyRightFooter = By.xpath("//p[contains(text(), 'All Rights')]");
	private By internationalASTM = By.xpath("//span[@class='logo']");
	public By myASTMOption = By.xpath("//*[@class='dropdown-menu dropdown-menu-right show']//a[@id='my-astm']");
	public By menu = By.xpath("//span[text()='Menu']//ancestor::a");
	public By backToGroupTiles = By.xpath("//i[@class='astm-icon far fa-chevron-left']//parent::a");
	public By MenuTracker = By.xpath("//a[@class='color-secondary sidebar-link'and text()=\"Tracker\"]");
	public By Groups_Menu = By.xpath("//a[@class=\"color-secondary sidebar-link\" and text()='Groups']");
	public By my_groups = By.xpath("//h1[@class='astm-type-heading--h5 astm-type-heading--h5-bold wlc-title groups-header']//span[text()='My Groups']");
	public By groupCardOnGroupPage = By.xpath("//div[contains(@class,'groups-card card')]");
	public By cardDescription = By.xpath("//p[contains(@class,'card-description')]");
	public By editGroupButton = By.xpath("//div[@class='dropdown']");
	public By editGroupInPopUp = By.xpath("//a[text()='Edit Group']");
	public By editGroupWindowHeader = By.xpath("//div[text()='Edit Group']");
	public By emailGroupMembersInPopUp = By.xpath("//a[text()='Email Group Members']");
	public By sendMeAcopyText = By.xpath("//label[text()='Send me a copy']");
	public By sendEmail = By.xpath("//button[text()='Send Email']");
	public By EmailConfirmation = By.xpath("//div[@class='alert astm-alert app-notification bg-info--light' and text()='Email successfully sent!']");
	public By sendMeACopyCheckBox = By.xpath("//div[@class='astm-custom-checkbox custom-control custom-checkbox']");
	public By deleteGroupInPopUp = By.xpath("//a[text()='Delete Group']");
	public By clickOnRelatedDoc = By.xpath("//span[text()='Related Content']//parent::span//parent::p");
	public By documentsTile = By.xpath("//span[@class='astm-type-body--lead bold card-designation-no prevent-wrapping']");
	public By DescriptionTile = By.xpath("//div[@class='card-body']//p[@class='astm-type-body--lead card-description']");
	public By OwnerTile = By.xpath("//div[@class='footer-container']//p[@class='foot-content astm-type-body']");
	public By membersCount = By.xpath("//div[@class='card-title']//span[@class='astm-type-body members-count']");
	public By documentsCount = By.xpath("//div[@class='card-title']//span[@class='astm-type-body documents-count']");
	public By locateDoc = By.xpath("//a[@class='block-with-text astm-type-body--lead blue-75 content block-with-text']/parent::div/parent::div//div[2]");
	public By clickOnCloseButton = By.xpath("//span[@class='astm-type-body astm-alert-text']//following-sibling::button");
	public By clickOnRelatedContent = By.xpath("//span[text()='Related Content']");
	public By clickOnTitle = By.xpath("//p[@class='astm-type-heading--h3 document-title']");
	public By ASTMlogo = By.xpath("//a[@style='background-image: url(\"../../../../content/logos/astm.svg\");']");
	private By StandardTitle = By.xpath("//span[@class='astm-type-body--lead bold card-designation-no prevent-wrapping']");
	public By paraText = By.xpath("//div[@class='col-md-6 col-lg-4']//div[@class='footer-container']//p");
	public By cookie_close = By.xpath("//i[@class='astm-icon astm-icon--white far fa-times']");
	public By clickOnTitleGroup = By.xpath("//a[@class='astm-link astm-type-heading--h5-bold']");
	public By titleOfGroup = By.xpath("//h1[@class='astm-type-heading--h5 astm-type-heading--h5-bold wlc-title group-detail-header']");
	public By Owner = By.xpath("//div[@class='group-detail-owner']/h1");
	public By members = By.xpath("//div[@class='group-detail-member']//h1");
	public By titleEdit = By.xpath("//div[@class='group-detail-content-heading row']//span[@class='astm-type-body edit']");
	public By membersEdit = By.xpath("//div[@class='group-detail-member']//span[@class='astm-type-body edit']");
	public By DescriptionEdit = By.xpath("//div[@class='group-detail-description']//span[@class='astm-type-body edit']");
	public By DescriptionLocator = By.xpath("//div[@class='group-detail-description']//h1[text()='Description']");
	public By editGroupName = By.id("editGroupDetailModal");
	public By deleteIconNotes = By.xpath("//i[@class='astm-icon far fa-trash-alt pointer-cursor']//parent::td");
	public By deleteIconclick = By.xpath("//i[@class='astm-icon far fa-trash-alt pointer-cursor']");
	public By groupCard1Name = By.xpath("//a[contains(@href,'group-detail')]");
	public By groupMembers = By.xpath("//div[@id='editGroupDetailModal']");
	public By addGroupDocumentModal = By.xpath("//div[@id='editGroupDetailModal'][text()='Add Documents']");
	public By noItemToDipalyLeftColumn_addDocPop = By.xpath("//div[contains(@class,'compass-document-container')]//p[text()='No items to display']");
	public By noItemToDipalyLeftColumn_addMemPop = By.xpath("//div[contains(@class,'form-group astm-checkbox-wrapper empty-item')]//p[text()='No items to display']");
	public By editDescriptionName = By.xpath("//div[text()='Edit Group Description']");
	public By addToDocumentsGroup = By.xpath("//div[@class='edit-group-body modal-body']//p[text()='Add documents to group']");
	public By noNotes = By.xpath("//span[text()='No Notes' and @class='no-notes-title astm-type-heading--h5']");
	public By myGroupHeader = By.xpath("//span[text()='My Groups']");
	public By groupOwnerDescription = By.xpath("//p[@class='foot-content astm-type-body']//..//p");

	public By ASTMlogoForMobile = By.xpath("//img[@class=\"astm-logo\"]");
	public By symposiaLocator = By.xpath("//span[contains(text(),'Symposia')]");
	public By manualLocator = By.xpath("//span[contains(text(),'Manual')]");

	public By ASTMlogoMobile = By.xpath("//a[@class='user-logo']");
	public By APILogo = By.xpath("//a[contains(@style,'api')]");
	public By clickOnLangDropDown = By.xpath("//li[@id='language-menu']");
	public By languageContainer = By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']");
	public By Language = By.xpath("//button[@class='dropdown-item']");
	public By StayOnPageBtn=By.xpath("//div[contains(@data-bind,'displayTimer')]/a[contains(text(),'Stay')]");
	public By DefaultLanguage = By.xpath("//li[@id='language-menu']//a[2]//div");
	public By magnifyingGlass = By.xpath("//button[@id='search_button_mainpage']");
	public By magnifyingGlassSub = By.xpath("//button[@id='search_button_header']");
	public By username = By.xpath("(//a[@class='d-flex align-items-center mobile-hide-style header-dropdown dropdown-toggle nav-link'])[4]");
	//li[@class='dropdown nav-item'][3]/a[2]
	public By Myaccount = By.xpath("(//span[contains(text(),'My Account')])[2]");
	public By accountPage = By.xpath("//div[@class='my-account-info']//span[contains(text(),'Name')]");
	public By accountPageNew = By.xpath("//div[@class='my-4']//div[contains(text(),'First Name: ')]");
	private By recentlyAccessedCardContent = By
			.xpath("//span[contains(text(),'Active')]/ancestor::div[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']");
	private By recentlyAccessedCardContentIES = By
			.xpath("//span[contains(text(),'IES')]/ancestor::div[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']");
	private By recentlyAccessedCardContentAPI = By
			.xpath("//span[contains(text(),'API')]/ancestor::div[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']");
	private By recentlyAccessedASTMStandard = By.xpath("//span[text()='Standard']//ancestor::div[1]/following::div[1]/span//following::a[1]");
	private By recentlyAccessedAPIStandard = By.xpath("//span[contains(text(),'API')]/ancestor::div[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']");

	private By TranslatedCardContent = By.xpath("//span[contains(text(),'Translated')]/ancestor::div[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']");
	private By recentlyAccessedStandard = By.xpath("//*[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']//span[contains(text(),'Standard')]");
	public By OtherVersions = By.xpath("//a[contains(text(),'Other Versions')]");
	private By RecentlyAccessedErrorText = By
			.xpath("//span[contains(text(),'You have no recently updated documents')]");
	public By myAccount = By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']");
	public By CompareVersions = By.xpath("//span[contains(text(),'Compare Versions')]");
	//
	public By recentlyUpdatedTab = By.xpath("//span[contains(text(),'Recently Updated')]//ancestor::p");
	public By publisher = By.xpath("//div[@class='card-content row']/div[1]//label/span[1]");
	public By myAccountHeader = By.xpath("//h1[@class='astm-type-heading--h1 wlc-title my-account-header']");
	public By destinationNo = By.xpath("//div[@class='card-content row']/div[1]//label/span[2]");
	public By document = By.xpath("//div[@class='card-content row']/div[1]/div[1]/div[2]/span");
	public By status = By.xpath("//div[@class='card-content row']/div[1]/div[1]/div[3]");
	public By lastUpdate = By.xpath("//div[@class='card-content row']/div[1]/div[1]/div[4]");
	private By updatedDocuments = By.xpath("//span[contains(text(),'Tracker')]//ancestor::p/b");
	public By searchDropdown = By.xpath("(//select[@id='types'])[2]");
	public By searchDropdownAll = By.xpath("//select[@id='search_dropdown_mainpage']");
	public By searchDropdownAlltext = By.xpath("//option[@value='ALL']");
	public By searchDropdownMySubscription = By.xpath("//select[@class='select-search-select astm-type-body--lead']//option[contains(text(),'My Subscription')]");
	public By searchBox = By.xpath("(//span[@class='span-container']//input)[2]");
	private By searchIcon = By.xpath("//button[@class='search-btn']");
	private By supportLink = By.xpath("//div[@id='app-view-container']//following::a[contains(@href,'video')]");
	private By contactLink = By.xpath("//a[contains(@href,'CONTACT')]");
	public By twitterLink = By.xpath("//a[contains(@href,'twitter.com/ASTMIntl')]");
	public By facebookLink = By.xpath("//a[contains(@href,'facebook.com/pages/ASTM')]");
	public By youtubeLink = By.xpath("//a[contains(@href,'youtube.com/ASTMIntl')]");
	public By linkedinLink = By.xpath("//a[contains(@href,'linkedin.com/company/astm')]");
	public By instagramLink = By.xpath("//a[contains(@href,'instagram.com')]");
	public By astmRSSLink = By.xpath("//a[contains(@href,'astm.org/RSS')]");
	public By Copyright_PermissionLink = By.xpath("//a[contains(@href,'COPYRIGHT')]");
	public By helpDropdown = By.xpath("(//div[text()='Help'])[2]");
	public By helpDropdown1 = By.xpath("(//div[text()='Help'])[2]");
	//div[text()='Help'])[2]
	public By supportFAQs = By.id("support");
	public By training = By.id("training");
	public By recentlyUpdatedCardContent = By.xpath("//span[contains(text(),'A')]/ancestor::div[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']");
	public By UsageReports = By.xpath("//span[text()=' Usage Report']");
	public By LatestUpdate = By.xpath("//span[@class='update-time astm-type-heading--h6 gary-30']");
	public By DocumentHeader = By.xpath("//p[@class='astm-type-heading--h3 document-title']");
	public By Designation = By.xpath("//p[@class='astm-type-heading--h6 astm-type-heading--h6-bold doc-designation']");
	public By DocStatus = By.xpath("//span[@class='astm-type-body--small bold badge2 badge badge-secondary']");
	public By InformationIcon = By.xpath("//i[@class='far fa-info-circle doc-title-notification ipad-hide-style']");
	public By TrackDocument = By.xpath("//span[contains(text(),'Track Document')]");
	public By newTrackedDocToast = By.xpath("//*[contains(text(),'new Tracked Document')]");
	public By UntrackDocument = By.xpath("//span[contains(text(),'Untrack Document')]");
	public By UntrackTrackedDocToast = By.xpath("//*[contains(text(),'Tracked Document is deleted')]");
	public By AddToFavorites = By.xpath("//span[contains(text(),'Add to Favorites')]");
	public By RemoveFavorites = By.xpath("//span[contains(text(),'Remove Favorite')]");
	public By ToggleSwitches = By.xpath("//div[@class='custom-control astm-custom-switch custom-switch']");
	public By Download = By.xpath("//span[contains(text(),'Download')]");
	public By PDF = By.xpath("//span[contains(text(),'PDF')]");
	public By pdfPages = By.xpath("//div[@id='pageWidgetContainer1']");
	public By SearchFilter = By.xpath("//*[@class='select-span-contianer custom-select-class']//child::select");
	public By HTMLActive = By.xpath("//span[contains(text(),'HTML')]//ancestor::p");
	public By HTML = By.xpath("//span[contains(text(),'HTML')]");
	public By ViewAllTracked = By.xpath("//a[@class='astm-link']");
//	public By MenuHome = By.xpath("//p[@class='astm-type-heading--h5 color-secondary major-side-menu']//a[@href='/home/0']");
	public By MenuHome = By.xpath("//p[@class='astm-type-heading--h5 color-secondary major-side-menu']//a[@href='/']");
	public By CustomCollections = By.xpath("//a[@href='/custom-collections']");
	public By SubscriptionUsage = By.xpath("//*[@class=\"color-secondary sidebar-link\" and contains(text(),'Subscription Usage')]");
	public By AENORlogo = By.xpath("//a[@style='background-image: url(\"../../../../content/logos/aenor.svg\");']");
	public By SubscriptionsMenu = By.xpath("//p[@class='astm-type-heading--h5 color-secondary major-side-menu']//span[contains(text(),'Subscriptions')]");
	public By TrackerMenu = By.xpath("//p[@class='astm-type-heading--h5 color-secondary major-side-menu']//a[contains(@href,'trackChanges')]");
	public By FavoritesMenu = By.xpath("//p[@class='astm-type-heading--h5 color-secondary major-side-menu']//a[contains(@href,'favorites')]");
	public By FavoritesHeader = By.xpath("//span[contains(text(),'My Favorites')]");
	public By NotesHeader = By.xpath("//span[contains(text(),'My Notes')]");
	public By notesFilter = By.id("notes_filter1");
	public By clickOnNew = By.xpath("//option[@value='NEW']");
	public By notesDoc = By.xpath("//td[@class='astm-table-td large-column astm-type-body--lead prevent-wrapping']");
	public By clickOnMigrated = By.xpath("//option[@value='MIGRATED']");
	public By noMigratedNotes = By.xpath("//span[@class='no-notes-title astm-type-heading--h5' and text()='No Migrated Notes']");
	public By NotesMenu = By.xpath("//p[@class='astm-type-heading--h5 color-secondary major-side-menu']//a[contains(@href,'notes')]");
	public By CGAlogo = By.xpath("//a[@style='background-image: url(\"../../../../content/logos/cga.svg\");']");
	public By AWWAlogo = By.xpath("//a[@style='background-image: url(\"../../../../content/logos/awwa.svg\");']");
	public By IESlogo = By.xpath("//a[@style='background-image: url(\"../../../../content/logos/ies.svg\");']");
	public By APIlogo = By.xpath("//a[@style='background-image: url(\"../../../../content/logos/api.svg\");']");
	public By PoweredBy = By.xpath("//span[@class='powerby astm-type-body']");
	public By ASTMgraphic = By.xpath("//span[@class='logo']");
	public By ASTMBanner = By.xpath("//div[contains(@style,'astm')]");
	public By copyrightFooter = By.xpath("//p[contains(text(),'Copyright')]");
	public By IESFooter = By.xpath("//p[contains(text(),'Illuminating')]");
	public By IESContact = By.xpath("//a[@href='https://lightinglibrary.ies.org/CUSTOMERS/contact.html']");
	public By IESHome = By.xpath("//a[@href='https://lightinglibrary.ies.org']");
	public By AENORFooter = By.xpath("//p[contains(text(),'AENOR')]");
	public By AENORHome = By.xpath("//a[@href='https://aenormaspremium.aenor.com']");
	public By AENORContact = By.xpath("//a[@href='https://aenormaspremium.aenor.com/CUSTOMERS/contact.html']");
	public By AWWAFooter = By.xpath("//p[contains(text(),'American Water Works Association')]");
	public By AWWAFooterLogo = By.xpath("//div[@class='awwa-logo']");
	public By AWWAHome = By.xpath("//a[@href='https://envoi.awwa.org']");
	public By AWWAContact = By.xpath("//a[@href='https://envoi.awwa.org//CUSTOMERS/contact.html']");
	public By CGAFooter = By.xpath("//p[contains(text(),'George')]");
	public By CGAHome = By.xpath("//a[@href='https://compass.cganet.com']");
	public By CGAContact = By.xpath("//a[@href='https://compass.cganet.com/CUSTOMERS/contact.html']");
	public By APIFooter = By.xpath("//p[contains(text(),'American Petroleum Institute')]");
	public By APIHome = By.xpath("//a[@href='https://www.apicompass.org']");
	public By APIContact = By.xpath("//a[@href='https://www.astm.org/api-wl-contact.html']");
	public By CompareVersionsModal = By.xpath("//*[@class='modal-content']");
	public By CompareModalActive = By.xpath("//span[contains(@class,'active')]");
	public By CompareModalCheckbox = By.xpath("//input[@type='checkbox' and @class='custom-control-input']");
	public By DocumentHeading = By.xpath("//p[@class='astm-type-heading--h6 astm-type-heading--h6-bold doc-designation']");
	public By CompareButton = By.xpath("//button[contains(text(),'Compare')]");
	public By CloseCompareButton = By.xpath("//i[@class='far fa-times']");
	public By closeCompareModal = By.xpath("//button[@class='btn btn-btn astm-btn btn-light model-btn-adjust']");
	public By DownloadRedlinedButton = By.xpath("//a[contains(text(),'Download Redlined PDF')]");
	public By EditOpton = By.xpath("//span[contains(text(),'Edit')]");
	public By maskclass = By.xpath("//div[@class='mask-cover']");
	public By stdTrackerHeader = By.xpath("//h1[contains(text(),'Track Changes with Standards Tracker')]");
	public By searchText = By.xpath("//input[@id='search_input_mainpage']");
	public By searchTextSub = By.xpath("//input[@id='search_input_header']");
	public By serpFirstDocument = By.xpath("(//div[@class='search-result']//a[@class='astm-link'])[1]");
	public By clickOnDocument = By.xpath("//span[@class='astm-type-body--lead bold card-designation-no prevent-wrapping pointer-cursor']");
	public By trackerCardContent = By.xpath("//a[@class='block-with-text astm-type-body--lead blue-75 content block-with-text']");
	public By menuTracker = By.xpath("//div[@id='sidebar']//child::a[text()='Tracker']");
	public By trackerRow = By.xpath("//tr[@class='astm-table-tr']");
	public By trackCheckBox = By.xpath("//div[@class='custom-control astm-custom-switch custom-switch']//input[@type='checkbox']");
	public By WhatStandard = By.xpath("//b[contains(text(),'What')]");
	public By AccountSelect = By.xpath("//h1[contains(text(),'Select an Account')]");
	public By accountSelectPopUp = By.xpath("//div[@class='switch-account-content']");
	public By techSupport_ASTM = By.xpath("//a[contains(@href,'mailto:support@astm.org')]");
	public By techSupport_CGA = By.xpath("//a[contains(@href,'mailto:cga@cganet.com')]");
	public By techSupport_API = By.xpath("//a[contains(@href,'apicompass.support@astm.org')]");
	public By techSupport_AWWA = By.xpath("//a[contains(@href,'envoi@awwa.org')]");
	public By techSupport_IES = By.xpath("//a[contains(@href,'research@ies.org')]");
	public By techSupport_AENOR = By.xpath("//a[contains(@href,'aenormas@aenor.com')]");
	public By subscriptionTab = By.xpath("//div[@class='tab-container ipad-hide-style']//span[text()='Subscriptions']");
	public By AenorBanner = By.xpath("//div[contains(@style,'AENOR')]");
	public By APIBanner = By.xpath("//div[@class='mainpage-search']");
	public By AWWABanner = By.xpath("//div[unsucontains(@style,'AWWA')]");
	public By CGABanner = By.xpath("//div[contains(@style,'CGA')]");
	public By EISBanner = By.xpath("//div[contains(@style,'EIS')]");
	public By accountDropdown = By.xpath("(//a[@class='d-flex align-items-center mobile-hide-style header-dropdown dropdown-toggle nav-link'])[4]");
	public By accountDropdownAPI = By.xpath("(//a[@class='d-flex align-items-center mobile-hide-style header-dropdown dropdown-toggle nav-link'])[3]");
	public By Signout = By.xpath("//a[@id='account_menu_ipad_logout']");
	public By newPageTitle = By.xpath("//h1[@class=\"maintitle\"]");
	public By downloadRedlinedPDF = By.xpath("//a[contains(text(),'Download Redlined PDF')]");
	public By SERPStandardLink = By.xpath("//span[contains(text(),'Active')]//ancestor::div[@class='search-result']//p[@class='astm-type-heading--h5']");
	public By HomepageTabs = By.xpath("//select[@id='tab_filter']//option");
	public By RecentlyTipsAndTricks = By.xpath("//h1[contains(text(),'Recently Updated & Recently Accessed')]");
	public By ViewAllFavorites = By.xpath("//span[contains(text(),'VIEW ALL FAVORITES')]");
	public By ViewAlltTracked = By.xpath("//span[contains(text(),'VIEW ALL TRACKED')]");
	public By NextPage= By.xpath("//ul[@class='astm-pagination pagination']/descendant::a[@class='page-link']");
	public By VersionDisclaimer = By.xpath("//p[contains(text(),'This document is not an ASTM')]");
	public By WTO = By.xpath("//p[@class='astm-type-body--small']");
	public By VideoTutorials = By.xpath("//span[text()='Video Tutorials']");
	public By VideoTutorialsLink = By.xpath("//span[text()='Video Tutorials']");
	public By VideosPageTitle = By.xpath("//h1[contains(@class,'video-tutorials-title')]");
	public By VideoTitle=By.xpath("//div[@class='view-container']/descendant::div[contains(@class,'showborder')]/p[1]");


	public By videos = By.xpath("//iframe[@class='document-iframe']");
	public By WithdrawnLink = By.xpath("//span[text()='Withdrawn']//ancestor::div[@class='search-result']//a[@class='astm-link']");
	public By TrackAdvisory = By.xpath("//div[(text()='This document does not have any Active versions for tracking.')]");
	public By videoContent = By.xpath("//span[text()='Video Content']");
	public By AENORPremiumLogo = By.xpath("//div[@class='aenor-logo']");
	public By DownloadPDF = By.xpath("//span[@class='ipad-hide-style astm-type-body--lead']//span[text()='Download']");
	public By PDFTronView = By.xpath("(//div[@class='ribbons-container']//button[contains(text(),'View')])[1]");
	public By AenorsearchBar = By.xpath("//input[@id=\"search_input_header\"]");
	public By AenorDocumentUNE139802 = By.xpath("(//a[@class='astm-type-body'and text()=\"UNE 139802:2009\"])[2]");
	public By Cancellations = By.xpath("//span[contains(text(),'Cancellations')]");
	public By Equivalents = By.xpath("//span[contains(text(),'Equivalents')]");
	public By EquivalentsModalText= By.xpath("//div[@class='modal-body']/descendant::span[2]");
	public By Download_PDFtab = By.xpath("(//button[@class=\"Button ActionButton\" ])[3]");
	public By awwaDesign = By.xpath("//a[contains(@href,'awwa')]");
	public By CreateGroups = By.xpath("//div[@id=\"editGroupModal\"]");
	public By GroupName = By.xpath("//label[contains(text(),'Group Name')]");
	public By DeleteGroup = By.xpath("//button[text()='Delete Group']");
	public By DeleteNotePopUp = By.xpath("//button[text()='Delete Note']");
	public By DeleteGroupSpan = By.xpath("//span[text()='Delete Group']");
	public By Close = By.xpath("//button[contains(text(),'Close')]");
	public By update = By.xpath("//button[contains(text(),'Update')]");
	public By crossClose = By.xpath("//button[@class='close']");
	public By NavBarClose = By.xpath("//p[@class='sidebar-close astm-type-body']");
	public By Next = By.xpath("//button[contains(text(),'Next')]");
	public By TextunderDescription = By.xpath("//span[@class='astm-type-body description-edit']");
	public By Back = By.xpath("//button[@class=\"btn btn-btn astm-btn btn-outline-secondary model-btn-adjust\"]");
	public By CreateGroupIcon = By.xpath("//button[@class=\"btn btn-btn astm-btn astm-btn--small btn-primary create-group\"]");
	public By GroupNameTextBox = By.name("editGroupName");
	public By GroupDescriptionTextBox = By.name("editGroupDescription");
	public By AddGroupMember = By.xpath("//p[@class='astm-type-body--lead step2']");
	public By SearchBar_AddMember = By.id("search_input_compass_members");
	public By MagnifyingGlass_AddMember = By.xpath("(//*[@class=\"svg-inline--fa fa-search fa-w-16 search-icon\"])[2]");
	public By magnifyingGlass_EditMember = By.xpath("//button[@id='search_button_compass_members']");
	public By magnifyingGlass_Documents = By.xpath("//button[@id='search_button_compass_documents']");
	public By testingMigration = By.xpath("//label[@class=\"custom-control-label\"]//span[contains(text(),'testingMigration')]");
	public By RightArrow_AddMember = By.xpath(" //i[@class=\"astm-icon far fa-arrow-circle-right\"]");
	public By SelectAll_AddMember = By.xpath("//a[@class=\"select-all astm-type-body--lead\"]");
	public By IESQA_AddMember = By.xpath("//label[@class=\"custom-control-label\"]//span[contains(text(),'IES101')]");
	public By AenorSub_AddMember = By.xpath("//label[@class=\"custom-control-label\"]//span[contains(text(),'Aenor101')]");
	public By AWWAQA_AddMember = By.xpath("//label[@class=\"custom-control-label\"and text()=\'QA\']");
	public By rightSideMover = By.xpath("//i[@class='astm-icon far fa-arrow-circle-right']");
	public By leftSideMover = By.xpath("//i[@class='astm-icon far fa-arrow-circle-left']");
	public By groupMemberList = By.xpath("//p[contains(text(),'Group Members')]/../div/div/div/label");
	public By groupMemberDocument = By.xpath("//p[contains(text(),'Group Documents')]/../div/div/div/label");
	public By compassMembersDocument = By.xpath("//p[contains(text(),'Compass Documents')]/../div/div/div/label");
	public By selectAllCompassDocument = By.xpath("//p[contains(text(),'Compass Documents')]/../div/p/a[text()='Select All']");
	public By unselectAllCompassDocument = By.xpath("//p[contains(text(),'Compass Documents')]/../div/p//a[text()='Unselect All']");
	public By unselectAllGroupDocuments = By.xpath("//p[contains(text(),'Group Documents')]/..//a[@class='select-all astm-type-body--lead' and text()='Unselect All']");
	public By selectAllGroupDocuments = By.xpath("//p[contains(text(),'Group Documents')]/..//a[@class='select-all astm-type-body--lead' and text()='Select All']");
	public By comprehensiveList = By.xpath("//p[text()='A comprehensive list of citations to this standard are listed here.']");
	public By firstDocument = By.xpath("//div[@class='row']//div[@class='col-12 col-sm-12 col-lg-12'][2]//span[@class='related-content-item-designation']");
	public By secondDocment = By.xpath("//div[@class='row']//div[@class='col-12 col-sm-12 col-lg-12'][3]//span[@class='related-content-item-designation']");
	public By Threedots_GroupTile = By.xpath("//i[@class=\"astm-icon fas fa-ellipsis-v\"]");
	public By clickOnThreeDots = By.xpath("//i[@class='astm-icon fas fa-ellipsis-v']//parent::a");
	public By Edit_GroupTile = By.xpath("//div[@class='dropdown-menu show']/a[@class='Edit dropdown-item'and text()='Edit Group']");
	public By Edit_groupMembers = By.xpath("//div[@class='dropdown-menu show']/a[@class='Email dropdown-item'and text()='Email Group Members']");
	public By ThreeDots_deleteGroup = By.xpath("//div[@class='dropdown-menu show']/a[@class='Delete dropdown-item'and text()='Delete Group']");
	public By SearchBar_AddDocument = By.xpath("//input[@id='search_input_compass_documents']");
	public By AddButton_AddDocWindow = By.xpath("//button[text()='Add']");
	public By CloseButton_AddDocWindow = By.xpath("//button[text()='Close']");
	public By Create = By.xpath("//button[@class='btn btn-btn astm-btn btn-secondary model-btn-adjust']");
	//	public By CopyrightText=By.xpath("//p[@class='copy_right astm-type-body' and text()='Copyright � 1996 - 2021 ASTM. All Rights Reserved. ASTM International, 100 Barr Harbor Drive, PO Box C700, West Conshohocken, PA, 19428-2959 USA']");
	//2731
	public By subscriptionsTabHomePage=By.xpath("//div[contains(@class,'ipad-hide-style')]//span[text()='Subscriptions']");
	public By subscriptionsTabASTMLink = By.xpath("//p[@class='noPaddingMargin astm-type-body--lead bold' and text()='ASTM']");

	public By clickonIEC = By.xpath("//p[@class='noPaddingMargin astm-type-body--lead bold' and text()='IEC']");
	public By clickonAPItiles = By.xpath("//p[@class='noPaddingMargin astm-type-body--lead bold' and text()='American Petroleum Institute']");
	public By closeButton = By.xpath("//button[text()='Close']");
	public By nextButton = By.xpath("//button[text()='Next']");
	public By updateButton = By.xpath("//button[text()='Update']");
	public By editGroup = By.xpath("../../div/a[text()='Edit Group']");
	public By emailGroupMembers = By.xpath("../../div/a[text()='Email Group Members']");
	public By emailGroupMembersPopup = By.xpath("//div[@id='emailGroupModal' and text()='Email Group Members']");
	public By deleteGroup = By.xpath("../../div/a[text()='Delete Group']");
	public By editGroupHeader = By.xpath("//div[text()='Edit Group']");
	public By editGroupTextBox = By.xpath("//input[@id='edit-group-name']");
	public By textArea = By.xpath("//textarea");
	public By Edit_title_popup = By.xpath("//div[@id='editGroupModal' and text()='Edit Group']");
	public By threeDot = By.xpath("//i[@class='astm-icon fas fa-ellipsis-v']");
	public By updateGroupMembersHeader = By.xpath("//p[text()='(2 of 3) Update group members']");
	public By backButton = By.xpath("//button[text()='Back']");
	public By membersName = By.xpath("//p[contains(text(),'Group Members')]/../div/div/div/label");
	public By updateNameAndDescriptionHeader = By.xpath("//p[text()='(1 of 3) Update name and description']");
	public By searchBar = By.xpath("//p[text()='Compass Members']/../div/div/input");
	public By documentSearchBar = By.xpath("//p[text()='Compass Documents']/../div/div/input");
	public By emptyFieldBox = By.xpath("//div[@class='form-group astm-checkbox-wrapper empty-item']");
	//	public By CopyrightText=By.xpath("//p[@class='copy_right astm-type-body' and text()='Copyright � 1996 - 2021 ASTM. All Rights Reserved. ASTM International, 100 Barr Harbor Drive, PO Box C700, West Conshohocken, PA, 19428-2959 USA']");
	public By CopyrightText = By.xpath("//p[@class='copy_right astm-type-body']");
	public By tilesContainer = By.xpath("//div[@class='card-adjust astm-card astm-card--raised astm-card--link groups-card card']");
	public By groupSuccessUpdated = By.xpath("//div[text()='Group successfully updated!']");
	public By groupAddDocument = By.xpath("//span[@class='add-documents action-button astm-type-heading--h5']");
	public By groupEmailGroup = By.xpath("//span[@class='email-group action-button astm-type-heading--h5']");
	public By groupDeleteGroup = By.xpath("//span[@class='delete-group action-button astm-type-heading--h5']");
	public By emailTitle = By.id("emailGroupModal");
	public By emailSubject = By.xpath("//input[@placeholder='Enter your subject']");
	public By emailMessage = By.xpath("//textarea[@placeholder='Enter your message']");
	public By deletePopUp = By.xpath("//div[@class='astm-type-body--lead']");
	public By emailCheckBox = By.xpath("//label[@class='custom-control-label']");
	public By deleteTitle = By.xpath("//div[@id='deleteGroupModal']");
	public By elementInput = By.xpath("//label[@class='custom-control-label']/span");
	public By updateGroupDocumentsHeader = By.xpath("//p[text()='(3 of 3) Update group documents']");
	public By ShareOption = By.xpath("//a[@class='astm-type-body' and text()='Share']");
	public By moreEmail = By.xpath("//div[@class='more dropdown']//a");
	public By homeGroup = By.xpath("//p[@class='astm-type-heading--h5 color-secondary major-side-menu']//a[text()='Home']");
	public By SearchBar_Modal = By.xpath("(//button[@class='search-btn astm-btn btn-primary' ])[2]");
	public By GeneralDocuement = By.xpath("(//p[@class='astm-type-heading--h5']/a[@class='astm-link'])[1]");
	public By More = By.xpath("//span[@class='ipad-hide-style astm-type-body--lead' ]/span[contains (text(),'More')]");
	public By Magnifyglass_Modal = By.xpath("//button[@class='search-btn astm-btn btn-primary']");
	public By NoMatch = By.xpath("//span[contains(text(),'Type a group name or valid email')]");
	public By IlluminanceTables = By.xpath("//a[@class='color-secondary sidebar-link' and text()='Illuminance Table']");
	public By Elearning = By.xpath("//span[@class='color-secondary sidebar-link' and text()='eLearning']");
	public By NoAccess = By.xpath("//div[@class='astm-type-body modal-body']");
	public By NoAccess_api = By.xpath("//div[@class='astm-type-body--lead modal-body']");
	public By NoAccessElearning = By.xpath("//div[@class='astm-type-body--lead modal-body']");
	public By CloseNoAccess = By.xpath("//button[@class='btn btn-btn astm-btn btn-light model-btn-adjust'and text()='Close']");
	public By supplementalDocuments = By.xpath("//h1[@class='astm-type-heading--h5 astm-type-heading--h5-bold']");
	public By RelatedLinks = By.xpath("//span[@class='related-content-item-designation']");
	public By addGroupMembers = By.xpath("//p[text()='(2 of 3) Add group members']");
	public By addGroupDocuments = By.xpath("//p[text()='(3 of 3) Add group documents']");
	public By content = By.xpath("//div[@class='col-md-6 col-lg-4']//a");
	public By AstmInternational = By.xpath("//span[text()='ASTM International']");
	public By modalEmailAddress = By.xpath("//div[@class='share-search-content share-search-box col-12 col-sm-12 col-md-12 col-lg-12']//input");
	public By magnifyingGlassEmailAddress = By.xpath("//div[@class='share-search-content share-search-box col-12 col-sm-12 col-md-12 col-lg-12']//button");
	public By AddButton_AddDocWindow_small = By.xpath("//button[text()='add']");
	public By groupIcon = By.xpath("//i[@class='fas fa-users share-icon-p']");
	public By characterMessageName = By.xpath("//p[@class='limit-message']/parent::div//label[text()='Group Name']");
	public By characterMessageDescription = By.xpath("//p[@class='limit-message']/parent::div//label[text()='Group Description']");
	public By characterMessageDescriptionEdit = By.xpath("//p[@class='limit-message']");
	public By EmailAddressCheck = By.xpath("//p[@class='selected-group astm-type-body']//span");
	public By seeMore = By.xpath("//span[text()='See More']");
	public By shareEmail = By.xpath("//a[@title='Share']");
	public By confirmationEmail = By.xpath("//span[text()='Share Confirmation Message']");
	public By closeEmail = By.xpath("//button[@class='close']");
	public By WorkItem = By.xpath("//span[contains(text(),'Work Items')]");
	public By Publisher_WorkItem = By.xpath("//h5[@class='astm-type-heading--h5 astm-type-heading--h5-bold work-items-item']");
	public By WorkItemNo = By.xpath("//p[@class='astm-type-body--lead ballot-item-no']");
	public By DateInitiated = By.xpath("//p[@class='astm-type-body--lead work-item-date']");
	public By StatusofWorkItem = By.xpath("//p[@class='astm-type-body--lead ballot-item-status']//span[@class='astm-type-body--small badge']");
	public By TechnicalContact = By.xpath("//p[@class='astm-type-body--lead']");
	public By dropdown = By.xpath("(//a[@class='d-flex align-items-center mobile-hide-style header-dropdown dropdown-toggle nav-link']//div[@class='user_name astm-type-body mobile-hide-style' ])[4]");
	public By docshareme = By.xpath("(//span[contains(text(),'Documents Shared With Me')])[2]");
	public By Mysharedoc = By.xpath("//span[contains(text(),'My Shared Documents')]");
	public By Mydoc = By.xpath("//table[@class='table table-striped astm-table table table-hover']//ancestor::div[@class='shared-standards-content container']//h1");
	public By designation = By.xpath("//span[@class='bold']");
	public By pagination = By.xpath("//ul[@class='astm-pagination pagination']");
	public By nextpagination = By.xpath("//a[@class='page-link hide-mobile' and text()='Next']");
	public By chevron_WI = By.xpath("//span[@class='chevron']//*[@class='svg-inline--fa fa-chevron-down fa-w-14 ']");
	public By TC_MWI = By.xpath("//p[@class='astm-type-body--lead collapse-text']");
	public By PubWI = By.xpath("//h5[@class='astm-type-heading--h5 astm-type-heading--h5-bold work-items-item']//ancestor::div[@class='contentContainer row']//a");
	public By chevronup = By.xpath("//span[@class='chevron']//*[@class='svg-inline--fa fa-chevron-up fa-w-14 ']");
	public By WIModaltitle = By.xpath("//div[@class='modal-title']");
	public By WIModalbody = By.xpath("//div[@class='astm-type-body--lead modal-body']");
	public By Help = By.xpath("(//div[@class='user_name astm-type-body mobile-hide-style' and text()='Help'])[2]");
	public By moreResource = By.xpath("//span[@class='dropdown-item-link astm-type-body' ]//span[text()='More Resources']");
	public By docShareWithMe = By.xpath("//span[text()='Documents Shared With Me']//parent::span[@class='dropdown-item-link astm-type-body']//parent::a[@id='account_menu_ipad_shared-with-me']");
	public By helpDropdownMenuOptions(){
		return By.xpath("//li[@id='help-menu']//a[contains(@class,'dropdown-item')]/span");
	}
	public By UserResourcePage = By.xpath("//h1[@class='astm-type-heading--h5 astm-type-heading--h5-bold user-resources-title' ]");
	public By leftNavigationLink = By.xpath("//div[@class='user-resources-sections']//a");
	public By LTSLink = By.xpath("//div[@id='Library Technology and Services']//div");
	public By LTS = By.xpath("//a[@class='astm-type-body sections-title-color' and text()='Library Technology and Services']");
	public By CaratLTS = By.xpath("//label[@class='pl-0 pointer-cursor astm-type-body--small tree-chevron']");
	public By LTSdetails = By.xpath("//p[@class='astm-type-body--lead option']");
	public By DocumentC = By.xpath("//a[@class='astm-type-body']//span[@class='bold']");
	public By DesignationC = By.xpath("//a[@class='astm-type-body']//span[@class='bold']");
	public By TitleC = By.xpath("//a[@class='astm-type-body']//span[@class='bold']");
	public By DocTable = By.xpath("//tr[@class='astm-table-tr']//th");
	public By firstLast = By.xpath("(//a[@class='astm-type-body'])[2]");
	public By PDFnoNotes = By.xpath("//span[@class='no-notes-content astm-type-body--lead']");
	public By Welcometitle = By.xpath("//h1[@class='astm-type-heading--h5 astm-type-heading--h5-bold wlc-title wlc-title-margin']");
	public By Accountid = By.xpath("(//div[@class='user_name astm-type-body mobile-hide-style'])[8]");
	public By Citation = By.xpath("//a[@class='astm-type-body' and text()='View Citations' ]");
	public By CitationText = By.xpath("//p[text()='B. Ye, W. Ye, F. Zhang, L. Xu, \"A New Device for Measuring the Supercritical CO']");
	public By DocType = By.xpath("//span[@class='astm-type-body--small bold badge1 badge badge-secondary']");
	public By MARCrecords = By.xpath("//p[@class='astm-type-body--lead bold option' and text()='MARC Records']");
	public By clickOnMARCrecords = By.xpath("//p[@class='astm-type-body--lead bold option' and text()='MARC Records']//following-sibling::label");
	public By journalsMARCrecords = By.xpath("//p[@class='astm-type-body--lead' and text()='Journals']");
	public By manualsMARCrecords = By.xpath("//p[@class='astm-type-body--lead' and text()='Manuals']");
	public By stpMARCrecords = By.xpath("//p[@class='astm-type-body--lead' and text()='Selected Technical Papers (STPs)']");
	public By listOfJournals = By.xpath("//p[@class='astm-type-body--lead option']");
	public By clickONjournals = By.xpath("//div[@class='journals']//label");
	public By journalsExpand = By.xpath("//a[@class='astm-type-body--lead section-links-color']//ancestor::ul//parent::div[@class='journals']");
	public By Favorities_Navbar = By.xpath("//a[contains(text(),'Favorites')]");
	//    public By clickDeleteTracker=By.xpath("(//i[@class='astm-icon far fa-trash-alt'])[7]");
	public By clickDeleteTracker = By.xpath("((//table[@class='table table-striped astm-table--responsive astm-table table']//tr)[12]//td)[4]//a");
	public By DeleteIcon = By.xpath("//i[@class='far fa-trash-alt']");
	public By DeleteIcon_Fav = By.xpath("(//i[@class='astm-icon far fa-trash-alt'])[8]");
	public By DeleteIconPopup = By.xpath("//div[@id='exampleModalLabel']");
	public By Delete = By.xpath("//*[contains(text(),'Delete')]");
	public By DeleteIcon_tracker = By.xpath("((//table[@class='table table-striped astm-table--responsive astm-table table']//tr)[12]//td)[4]//a");
	public By DeleteIcon_tracker_aenor = By.xpath("(//i[@class='astm-icon far fa-trash-alt'])[4]");
	public By DeleteIcon_ASTMtracker = By.xpath("(//i[@class='astm-icon far fa-trash-alt'])[11]");
	public By PDFdownloadArrow = By.xpath("//i[@class='far fa-arrow-to-bottom']");
	public By DownloadRedlinedArrow = By.xpath("//i[@class='far fa-arrow-to-bottom']");
	public By DeleteIcon_AWWA_Tracker = By.xpath("(//i[@class='astm-icon far fa-trash-alt'])[11]");
	public By SABADoc = By.xpath("//a[@class='itemname trq-text-primary trq-mb-0 trq-mt-0']");
	public By DownloadOption = By.xpath("//i[@class='far fa-arrow-to-bottom']");
	public By LADownloadOption = By.xpath("(//i[@class='far fa-arrow-to-bottom'])[2]");
	public By LOSDownloadOption = By.xpath("(//i[@class='far fa-arrow-to-bottom'])[3]");
	public By LDLTDownloadOption = By.xpath("(//i[@class='far fa-arrow-to-bottom'])[4]");
	public By ZipDownloadOption = By.xpath("//i[@class='far fa-arrow-to-bottom']");
	public By ZipDownloadOption_api = By.xpath("(//i[@class='far fa-arrow-to-bottom'])[2]");
	public By langDropDownDoc = By.xpath("(//div[@class='dropdown']//a[@class='nav-link update-time astm-type-heading--h6 gary-30 dropdown-toggle'])[1]");
	public By langClick = By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item']");
	public By UserGuideLink = By.xpath("//span[contains(text(),'User Guide')]");
	public By HomeLink = By.xpath("//a[@class='astm-type-body' and text()='Home']");
	public By SupportLink = By.xpath("//a[@class='astm-type-body' and text()='Support']");
	public By CitationIcon = By.xpath("//i[@class='astm-icon fas fa-quote-right']");
	public By ShareIcon = By.xpath("//i[@class='astm-icon far fa-envelope']");
	public By HomeLogo = By.xpath("//a[@class='user-logo']");
	public By ResultTypeDropdown = By.xpath("//label[@class='pl-0 pointer-cursor astm-type-body--small tree-chevron']");
	public By DocumentDropdown = By.xpath("//label[@id='content_type--DigitalLibrary-top']");
	public By Proceeding_ResultType = By.xpath("//div[@class='prevent-wrapping-2line label-span' and text()='Proceeding']");
	public By CategoryLinks = By.xpath("//div[@class='tree-node astm-custom-checkbox custom-control custom-checkbox']");
	public By SecondaryListDropdown_Category = By.xpath("//label[@id='taxo_terminfo_scopeid-APP-00-00-00-00-00-top']");
	public By SecondaryList_Category = By.xpath("//div[@class='collapse show']//div[@class='prevent-wrapping-2line label-span']");
	public By BillBoard = By.xpath("//div[@class='billboard-container']");
	public By Document_Refinment = By.xpath("//div[@class='prevent-wrapping-2line label-span' and text()='Documents']");
	public By Active_Refinment = By.xpath("//div[@class='prevent-wrapping-2line label-span' and text()='Active']");
	public By ActiveDocuments = By.xpath("//span[@class='astm-type-body--small bold badge2 badge badge-secondary' ]");
	public By DocumentDesignation = By.xpath("//span[@class='astm-type-body--lead bold card-designation-no prevent-wrapping pointer-cursor' ]");
	public By CGADocumentDropdown = By.xpath("//label[@id='asset_status--DigitalLibrary-top']");
	public By Withdrawn_Refinment = By.xpath("//div[@class='prevent-wrapping-2line label-span' and text()='Withdrawn']");
	public By WithdrawnDocuments = By.xpath("//span[@class='astm-type-body--small bold badge5 badge badge-secondary']");
	public By CGADocumentRefinment = By.xpath("//div[@class='prevent-wrapping-2line label-span' and text()='Documents']");
	public By documentTypeVideo = By.xpath("//label[@id='DigitalLibrary-top']");
	public By standardVideo = By.xpath("//label[@id='asset_type-Standard-DigitalLibrary-top']");
	public By videosOnSerp = By.xpath("//div[text()='Videos']");
	public By ExplorationAndProduction = By.xpath("//p[text()='Exploration and Production']");
	public By SecondaryList = By.xpath("//div[@class='col-md-6']");
	public By TranslationDropdown = By.xpath("//a[@class='nav-link astm-type-body gary-30 dropdownToggle dropdown-toggle']");
	public By OtherVersionDropdown = By.xpath("nav-link astm-type-body gary-30 dropdownToggle dropdown-toggle");
	public By OtherVersionList = By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item']");
	public By TranslatedStandard = By.xpath("//span[@class='astm-type-body--small bold badge1 badge badge-secondary']");
	public By SwitchAccountInHeader = By.xpath("//span[text()='Switch Account']//parent::a[@id='account_menu_ipad_switch-account']");
	public By selectAccount = By.xpath("//h1[@class='astm-type-heading--h1 account-sub-title' and text()='Select an Account']");
	public By ButtonOnSelectAccountScreen = By.xpath("//button[@class='btn astm-btn btn-secondary']");
	public By WelcomeBackAfteraccountSelection = By.xpath("//h1[@class='astm-type-heading--h5 astm-type-heading--h5-bold wlc-title wlc-title-margin']");
	public By signOut = By.xpath("//span[text()='Sign Out']//parent::a[@id='account_menu_ipad_logout']");
	public By CompareVersionTileMessage = By.xpath("//p[contains(text(),'Easily compare the differences between active and historical standards in PDF format.')]");
	public By CGAAddresse = By.xpath("//p[contains(text(),'Compressed Gas Association, 8484 Westpark Drive, Suite 220, McLean, VA 22102')]");
	public By APIErrorMessage = By.xpath("//h2[contains(text(),'404 - Resource Not Found, please contact support.')]");
	public By listUnderSearchBox = By.xpath("//div[@class='search-suggestion-container']//p[@class='astm-type-body content']//a");
	public By TechnicalReportRefinment = By.xpath("//div[@class='prevent-wrapping-2line label-span' and text()='Technical Report']");
	public By LightingLibraryContentsLink = By.xpath("//a[text()='Lighting Library Contents']");
	public By ReferenceRetriever = By.xpath("//a[@class='color-secondary sidebar-link'and text()='Reference Retriever']");
	public By hpdf = By.xpath("(//span[@class='link'])[5]");
	public By trackerDocuments = By.xpath("//tbody[@class='mobile-hide-style']//tr[@class='astm-table-tr']//td[1]//a[@class='astm-type-body']");
	public By favoritesDocument = By.xpath("//tr[@class='astm-table-tr']//td//a[@class='astm-type-body']");
	public By annotate = By.xpath("//button[@class='ribbon-group' and text()='Annotate']");
	public By annotateActive = By.xpath("//button[@class='ribbon-group active' and text()='Annotate']");
	public By viewNotes = By.xpath("//button[@class='Button ActionButton' and @aria-label='View Notes']");
	public By commentsBox = By.xpath("//button[@class='Button active hide-in-small-mobile']");
	public By notesInDocuments = By.xpath("//div[@class='Note']");
	public By notesPopUp = By.xpath("//div[@class='NotePopup']");
	public By EditInNotes = By.xpath("//div[@class='option' and text()='Edit']");
	public By EditModal = By.xpath("//div[@id='addCommentsModal']");
	public By existingNotes = By.xpath("//span[@class='contents']");
	public By SaveNotesButton = By.xpath("//button[text()='Save']");
	public By textAreaNotesModal = By.xpath("//textarea[@id='comments']");
	public By RIS = By.xpath("//span[@class='download-irs']");
	public By SelectedTechnicalPapers = By.xpath("//p[contains(text(),'Selected Technical Papers')]");
	public By Export_Button = By.xpath("//button[contains(text(),'Export')]");
	public By CitationInfoIcon = By.xpath("//i[@class='astm-icon far fa-info-circle']");
	public By MyAccounts = By.xpath("//a[@id='account_menu_ipad_my-account_profile']");
	public By firstNameLabel_PersonalInfoPage = By.xpath("//div[@class='font-weight-bold form-label' and contains(text(),'First Name')]");
	public By middleNameLabel_PersonalInfoPage = By.xpath("//div[@class='font-weight-bold form-label' and contains(text(),'Middle Name')]");
	public By lastNameLabel_PersonalInfoPage = By.xpath("//div[@class='font-weight-bold form-label' and contains(text(),'Last Name')]");
	public By emailLabel_PersonalInfoPage = By.xpath("//div[@class='font-weight-bold form-label' and contains(text(),'Email')]");
	public By compassEditBtn_PersonalInfoPage = By.xpath("//button[@id='compass-view-edit-btn']");
	public By compassLink_PersonalInfoPage = By.xpath("//a[text()='Compass']");
	public By OrganisationCompass = By.xpath("//select[@class='custom-select astm-custom-select form-control']");
	public By QAOrganisationCompass = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'SUB IES Account QA')]");
	public By OrganisationCompassIES = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'Malcar Northwest')]");
	public By OrganisationCompassSelect = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'CGA Test Account')]");
	public By OrganisationCompassSelectCGA = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'POC Gas and Air')]");
	public By OrganisationCompassSelectAWWA = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'City of Guelph')]");
	public By OrganisationCompassSelectAPI = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'TJ Machine Tool LTD')]");
	public By OrganisationCompassSelectAenor = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'AENOR')]");
	public By ASTMBrand = By.xpath("//img[@class='astm-logo']");
	public By IESBrand = By.xpath("//img[@class='ies-logo']");
	public By APIBrand = By.xpath("//img[@class='api-logo']");
	public By AenorBrand = By.xpath("//img[@class='aenor-logo']");
	public By CGABrand = By.xpath("//img[@class='cga-logo']");
	public By AWWABrand = By.xpath("//img[@class='awwa-logo']");
	public By PersonalInformation = By.xpath("//a[@class='active nav-link' and contains(text(),'Personal Information')]");
	public By OrgCompass = By.xpath("//label[@class='font-weight-bold form-label d-block']");
	public By orgDropdown_compassLink=By.id("organizations");
	public By AccountCompass = By.xpath("//a[@id='compass-tab' and text()='Compass']");
	public By cancelBtn_additionalOrganization = By.xpath("//button[text()='Cancel']");
	public By saveBtn_additionalOrganization = By.xpath("//button[text()='Save']");
	public By accountNumberLabelCompassLink = By.xpath("//div[@class='font-weight-bold form-label' and text()='Account #: ']");
	public By additionalOrgLbl_CompassLink = By.xpath("//div[text()='Additional Organization(s): ']");
	public By additionalOrganisationTextField_CompassLink =By.id("additionalOrganization");
	public By addOrgVal_CompassLink=By.xpath("//div[text()='Additional Organization(s): ']/following-sibling::div");
	public By editLinkUnderCompassLabel = By.xpath("//button[@id='compass-view-edit-btn']");
	public By accountNoValueUnderCompassLink=By.xpath("//div[text()='Account #: ']/following-sibling::div");
	public By passwordLink_ProfilePage=By.id("password-tab");
	public By resetPwdSuccessMsg_ProfilePage=By.xpath("//span[text()='Password Reset Successful']");
	public By resetPwdSuccessMsgCloseBtn_ProfilePage=By.xpath("//button[@type='button' and @class='close']");
	public By footerSectionHomeLink=By.xpath("//ul[@class='contact_us']//a[text()='Home']");
	public By footerSectionContactLink=By.xpath("//ul[@class='contact_us']//a[text()='Contact']");
	public By contactLinkContactPageNotFoundMsg=By.xpath("//h1[text()='Your request cannot be processed']");
	public By contactLinkContactPageNotFoundMsg_APITenant=By.xpath("//h1[text()='The page you requested was not found.']");
	public By footerLinks=By.xpath("//ul[@class='contact_us']//a");
	public By socialMediaLink(String socialMediaLinkName){
		return By.xpath("//i[contains(@id,'footer-"+socialMediaLinkName+"')]");
	}
	public By addressOfAPIFromFooterSection=By.xpath("//p[contains(@class,'copy_right')][1]");
	public By addressOfAENORFromFooterSection=By.xpath("//p[contains(@class,'copy_right')][1]");
	public By copyrightYearWithASTMAddressFromFooterSection=By.xpath("//p[contains(@class,'copy_right')][2]");
	public By copyrightYearWithASTMAddressFromFooterSection_ASTMTenant=By.xpath("//p[contains(@class,'copy_right')]");
	public By closeBtn_invalidPwdErrMsg=By.xpath("//button[@class='close']");
	public By newPasswordInputField_PasswordLink=By.id("newPassword");
	public By confirmPassword_PasswordLink=By.id("confirmPassword");
	public By savePasswordBtn_PasswordLink=By.xpath("//button[@type='submit' and text()='Save Password']");
	public By passwordHeader_UnderPasswordLink=By.xpath("//h2[text()='Password']");
	public By currentPasswordInputField_PasswordLink=By.id("oldPassword");
	public By currentPasswordInvalidErrorMsg_PasswordLink=By.xpath("//img[@alt='error-icon']/following-sibling::span");
	public By StageOrganisationCompass = By.xpath("//select[@class='custom-select astm-custom-select form-control']//option[contains(text(),'Oklahoma DOT')]");
	public By inputCompare = By.xpath("(//input[@class='custom-control-input'])[2]");
	public By MenuSubscription = By.xpath("//span[@class='color-secondary sidebar-link' and contains(text(),'Subscriptions')]");
	public By MenuASTM = By.xpath("//a[@class='sidebar-link color-secondary' and contains(text(),'ASTM')]");
	public By closeNavBar = By.xpath("//p[text()='Close']");
	public By DocumentDetails = By.xpath("//span[@class='astm-type-heading--h6 blue-70 pointer-cursor']");
	public By DocumentDetailsModal = By.xpath("//div[@class='astm-type-body--lead modal-body']");
	public By DocumentDetailsHeading = By.xpath("//span[@class='astm-type-heading--h6']");
	public By DocumentDetailsConferenceName = By.xpath("//span[@class='astm-type-body--lead'and contains(text(),'Conference Name')]");
	public By DocumentDetailsConferenceLocation = By.xpath("//span[@class='astm-type-body--lead'and contains(text(),'Conference Location')]");
	public By DocumentDetailsMeetingDate = By.xpath("//span[@class='astm-type-body--lead'and contains(text(),'Meeting Date')]");
	public By DocumentDetailsSession = By.xpath("//span[@class='astm-type-body--lead'and contains(text(),'Session')]");
	public By DocumentDetailsPrimaryTopic = By.xpath("//span[@class='astm-type-body--lead'and contains(text(),'Primary Topic')]");
	public By DocumentDetailsFundingOrganization = By.xpath("//span[@class='astm-type-body--lead'and contains(text(),'Funding Organization')]");
	public By TechnicalCommittessNavBar = By.xpath("//a[@class='color-secondary sidebar-link' and text()='Technical Committees']");
	public By MembershipNavBar = By.xpath("//a[@class='color-secondary sidebar-link' and text()='Membership']");
	public By MeetingAndSymposiaNavBar = By.xpath("//a[@class='color-secondary sidebar-link' and text()='Meetings & Symposia']");
	public By PublishWithASTMNavBar = By.xpath("//a[@class='color-secondary sidebar-link' and text()='Publish with ASTM']");
	public By cookieCloseButton = By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']");
	public By buttonSelect = By.xpath("//a[@class='btn astm-btn btn-secondary account-select-button']");
	public By agreeAndContinue=By.xpath("//button[text()='Agree and Continue']");
	public By SignInNew = By.xpath("(//span[text()='Sign In/Register'])[2]");
	public By VideoTutorialLink = By.xpath("//span[contains(text(),'Video Tutorials')]");
	public By VideoVisible = By.xpath("//div[@class='w-css-reset']");
	public By userManagementLink = By.xpath("//a[@id='account_menu_ipad_user-management']");
	public By ViewUserVisibility = By.xpath("//h5[@class='modal-title']");
	public By EditUserMAE = By.xpath("//button[@class='btn bg-primary-1' ]");
	public By EditUserMAEVisibility = By.xpath("//h5[@class='modal-title' and text()='Edit User']");
	public By CloseEditUserMAE = By.xpath("//div[@class='modal-content']//button[@class='close']");
	public By AddUserMAE = By.xpath("//button[@class='btn btn-warning add-user']");
	public By AddUserAPI = By.xpath("//button[@class='btn astm-btn btn-primary ml-2 add-user']");
	public By AddUserMAEvisisblity = By.xpath("//h5[@class='modal-title' and text()='Add User']");
	public By TestAutomationGroup = By.xpath("//a[contains(text(),'Test case for automation') ]");
	public By AddDocuments = By.xpath("//span[@class='add-documents action-button astm-type-heading--h5']");
	public By GroupAddDocument = By.xpath("//div[@class='astm-custom-checkbox custom-control custom-checkbox']");
	public By Add = By.xpath("//button[contains(text(),'Add')]");
	public By AddDocumentSearchBar = By.xpath("(//input[@class='search-input astm-type-body--lead'])[2]");
	public By Trash = By.xpath("(//i[@class='astm-icon far fa-trash-alt'])[2]");
	public By IECTestAutomationGroup = By.xpath("//a[contains(text(),'Test case for automation') ]");
	public By RightSideDocument = By.xpath("//label[@class='custom-control-label']");
	public By SSOUsername = By.xpath("//input[@id='UserName']");
	public By SSOPassword = By.xpath("//input[@id='Password']");
	public By SSOSignIN = By.xpath("//input[@class='loginbtn btn btn-primary btn-lg']");
	public By UserGuideLinkEnglish = By.xpath("//a[@id='user_guide_en']");
	public By UserGuideLinkSpanish = By.xpath("//a[@id='user_guide_es_la']");
	public By Contact = By.xpath("//a[@class='astm-type-body' and contains(text(),'Contact')]");
	public By PrivacyPolicyFooter = By.xpath("//a[@class='astm-type-body' and contains(text(),'Privacy Policy')]");
	public By PoliciesFooter = By.xpath("//a[@class='astm-type-body' and contains(text(),'Policies')]");
	public By Copyright_Permissions = By.xpath("//a[@class='astm-type-body' and contains(text(),'Copyright/Permissions')]");
	public By CustomCollectionsHeader = By.xpath("//span[contains(text(),'Custom Collection')]");
	public By customCollectionsLinks = By.xpath("//tr[@class='astm-table-tr']//a[@class='astm-type-body']");
	public By documentStatus = By.xpath("//span[@class='badge-span']/span[@class='astm-type-body--small bold badge2 badge badge-secondary']");
	public By documentDesignation = By.xpath("//p[@class='astm-type-heading--h3 document-title']");
	public By publisherDropdown = By.xpath("//select[@id='custom-collections_filter1']");
	public By WohlersReportRecentlyAccessed = By.xpath("//div[@class='card-body']//p[contains(text(),'Wohlers Report')]");
	public By AddShareEmail = By.xpath("//div[@class='share-search-content share-search-box col-12 col-sm-12 col-md-12 col-lg-12']//input");
	public By SearchEMail = By.xpath("(//button[@class='search-btn astm-btn btn-primary'])[2]");
	public By AddEmail = By.xpath("//button[text()='add']");
	public By ShareEmail = By.xpath("//button[text()='Share']");
	public By TechnicalCommittees = By.xpath("//h1[text()='Technical Committees']");
	public By Membership = By.xpath("//h1[text()='Membership']");
    public By PublishWithMyASTM = By.xpath("//h1[text()='Publish Books and Journals with ASTM']");
	public By pdfText=By.xpath("//div[contains(@class,'tab-container')]/descendant::span[1]");
	public By htmlText=By.xpath("//div[contains(@class,'tab-container')]/descendant::span[4]");
	public By relatedContentText=By.xpath("//div[contains(@class,'tab-container')]/descendant::span[6]");
	public By activeTab=By.xpath("//p[contains(@class,'tab active')]/span/span");
	public By favoritesDocLinks=By.xpath("//table[contains(@class,'table-striped')]/tbody/tr/td[1]/a");
	public By deleteFavConfirm=By.xpath("//button[contains(@class,'btn-danger')]");
	public By TrackedDocLinks=By.xpath("//table[contains(@class,'table-striped')]/tbody/tr/td[1]/a");
	public By VersionDDItems= By.xpath("//div[@class='dropdown show']/div/a");

	public By VersionDDLink = By.xpath("//a[contains(text(),'Versions')]");
	public By MyAccount=By.xpath("//li[@id='account_menu_ipad']/descendant::a[3]");
	public By emailinMyAccountPage=By.xpath("//div[contains(text(),'Email')]/following-sibling::div");
	public By switchAcc=By.xpath("//li[@id='account_menu_ipad']/descendant::a[4]");
	public By switchAccHeading=By.xpath("//h1[contains(text(),'Select an Account')]");
	public By docsShared=By.xpath("//li[@id='account_menu_ipad']/descendant::a[5]");
	public By nodocsharemsg=By.xpath("//div[@class='shared-standards-block']/p");
	public By sharedDocrows=By.xpath("//table[contains(@class,'table-striped')]/tbody/tr");
	public By NavMenuLinks=By.xpath("//div[@class='side show-sidebar']/descendant::a");
	public By journalsBBLink=By.xpath("//div[@class='billboard-container']/descendant::div/div[2]/div[5]");
	public By journalsSTPLink=By.xpath("//div[@class='billboard-container']/descendant::div/div[2]/div[7]");

	public By HeaderLinksDD=By.xpath("//div[@class='document-activity']/span/span");
	public By CitationModelHeader=By.xpath("//h5[@class='modal-title']/p");
	public By Pdfsearch= By.xpath("//button[@data-element='selectToolButton']/following-sibling::div/following-sibling::button[1]");
	private By inputSearch=By.xpath("//div[@class='options']/parent::div/div[1]/input[@tabindex='0']");
	private By searchClose=By.xpath("//button[@class='clearSearch-button']");
	private By searchPdfResult=By.xpath("//span[@class=\"search-value\"]");
	private By HTMLCompateDisclaimer= By.xpath("//div[@class='astm-type-body']/p");
	private By NavMenuTrackerLink=By.xpath("//a[contains(text(),'Tracker')]");
	private By NavMenuSubscriptionsLink=By.xpath("//span[contains(text(),'Subscriptions')]");
	private By NavMenuUNELink=By.xpath("//a[contains(text(),'UNE')]");
	private By UNECheckBox=By.xpath("//input[@id='UNE']");
	private By UnsubscribeBTN=By.xpath("//button[contains(text(),'UNSUBSCRIBE')]");
	private By submitBTN=By.xpath("//button[contains(text(),'SUBMIT')]");

	private By alert=By.xpath("//div[contains(@class,'alert')]");
	public By AccountMenu = By.xpath("//li[@id='account_menu_ipad']");
	public By SwitchAccount = By.id("account_menu_ipad_switch-account");
	public By SelectB2Buser = By.xpath("//span[text()='B2B User']/../button");
	public By UserManagement = By.id("account_menu_ipad_user-management");

	public By MyAccountProfile = By.xpath("//a[contains(@id,'account_menu_ipad_my-account_profile')]/span");
	public By PersonalInformationHeader = By.xpath("//h4[text()='Personal Information']");
	public By EmailInPersonalInfoPage = By.xpath("//div[text()='Email: ']/../div[2]");
	public By LoginAWWAconnectLINK = By.linkText("https://www.awwa.org/envoi/access-v2-staging?return=https://stage-compass.astmawwa.site");
	public By ContactSupportLINK = By.linkText("mailto:envoi@awwa.org");
	public By AWWApageCustomMessage = By.xpath("//div[@class='login-form']/div[2]/p");
	public By IESpageCustomMessage = By.xpath("//div[@class='login-form']/div[2]/p[1]");
	public By LOGOIMG = By.xpath("//img[@class='astm-logo']");
	public By TrackedStandards = By.xpath("//*[text()='Tracked Individual Standards']");
	public By SOP = By.xpath("//a[contains(text(),'SOP')]");
	public By ASTMtile = By.xpath("//p[text()='ASTM']//ancestor::div[@class='my-subscription row']");
	public By SubscriptionsTab_ASTMTile = By.xpath("//div[contains(@class,'astm-card')]//p[text()='ASTM']");
	public By SubscriptionsTab_APITile = By.xpath("//div[contains(@class,'astm-card')]//p[text()='American Petroleum Institute']");
	public By SubscriptionsTab_IESTile = By.xpath("//div[contains(@class,'astm-card')]//p[text()='IES']");
	public By SERP_ShowDropdown = By.cssSelector("#search_filter1");
	public String SERP_Category_CheckBox_var = "//p[contains(@class,'refinement-title') and text()='Category']//following-sibling::li//div[text()='[CATEGORY]']//ancestor::div[@class='tree-item']//input";
	public By getSERP_Category_CheckBox(String Category){
		return By.xpath(SERP_Category_CheckBox_var.replace("[CATEGORY]", Category));
	}
	public String SERP_TechnicalCommitteeCheckbox_var = "//label[@id='committee-top']//ancestor::li//following-sibling::div//div[text()='[TECHNICAL_COMMITTEE]']//preceding::input[1]";
	public By getSERP_TechnicalCommitteeCheckbox(String Technical_Coimmittee){
		return By.xpath(SERP_TechnicalCommitteeCheckbox_var.replace("[TECHNICAL_COMMITTEE]", Technical_Coimmittee));
	}
	public By ClearAll = By.cssSelector(".clearall");
	public By helpDrowpDown = By.cssSelector("#help-menu");
	public By CounterSushi = By.xpath("//div[@class='sections-title-two']//a[text()='COUNTER/SUSHI']");
	public By TermsOfUseLink = By.xpath("//div[@class='downloads-option']//span[text()='Terms of Use']");
	public By LicenseAgreement = By.xpath("//div[@class='downloads-option']//span[text()='License Agreement']");
	public By ListOfStandardsWithLinkResolvers = By.xpath("//div[@class='downloads-option']//span[text()='List of Standards with Link Resolvers']");
	public By ListOfDigitalLibraryTitles = By.xpath("//div[@class='downloads-option']//span[text()='List of Digital Library Titles']");
	public By LibrarytechnologyServicesExpandIcons = By.xpath("//div[@id='Library Technology and Services']//*[local-name()='svg']");
	public By ToolsForAdministratorsLibrarians = By.xpath("//div[@id='Tools for Administrators & Librarians']//a");
	public By toolsForAuthorsHyperlink= By.xpath("//div[@id='Tools for Authors']//a");
	public By ToolsForResearches_ASTMforStudents = By.xpath("//div[@id='Tools for Researchers, Students, & Professors']//a[text()='ASTM for Students']");
	public By ToolsForResearches_ASTMNewsReleases = By.xpath("//div[@id='Tools for Researchers, Students, & Professors']//a[text()='ASTM News Releases']");

	public WebElement getCopyright_Permissions() {
		return getElement(Copyright_Permissions);
	}

	public WebElement getpublisherDropdown() {
		return getElement(publisherDropdown);
	}

	public WebElement getPoliciesFooter() {
		return getElement(PoliciesFooter);
	}

	public WebElement getdocumentDesignation() {
		return getElement(documentDesignation);
	}

	public WebElement getPrivacyPolicyFooter() {
		return getElement(PrivacyPolicyFooter);
	}

	public WebElement getContact() {
		return getElement(Contact);
	}

	public WebElement gethelpDropdown() {
		return getElement(helpDropdown);
	}

	public WebElement getAddShareEmail(){ return getElement(AddShareEmail);}

	public WebElement getUserGuideLinkSpanish() {
		return getElement(UserGuideLinkSpanish);
	}

	public WebElement getSSOSignIN() {
		return getElement(SSOSignIN);
	}

	public WebElement getSSOPassword() {
		return getElement(SSOPassword);
	}

	public WebElement getSSOUsername() {
		return getElement(SSOUsername);
	}

	public WebElement getRightSideDocument() {
		return getElement(RightSideDocument);
	}

	public WebElement getAddDocumentSearchBar() {
		return getElement(AddDocumentSearchBar);
	}

	public WebElement getrightSideMover() {
		return getElement(rightSideMover);
	}

	public WebElement getmagnifyingGlass_Documents() {
		return getElement(magnifyingGlass_Documents);
	}

	public WebElement getAddDocuments() {
		return getElement(AddDocuments);
	}

	public WebElement getTestAutomationGroup() {
		return getElement(TestAutomationGroup);
	}

	public WebElement getViewUserVisibility() {
		return getElement(ViewUserVisibility);
	}

	public WebElement getDocumentStatus() {
		return getElement(documentStatus);
	}

	public WebElement getAddUserMAE() {
		return getElement(AddUserMAE);
	}


	public WebElement getVideoTutorialLink() {
		return getElement(VideoTutorialLink);
	}


	public WebElement getHelp() {
		return getElement(Help);
	}


	public WebElement getDocumentDetails() {
		return getElement(DocumentDetails);
	}

	public WebElement getcookieCloseButton() {
		return getElement(cookieCloseButton);
	}

	public WebElement getHTML() {
		return getElement(HTML);
	}


	public WebElement getMenuASTM() {
		return getElement(MenuASTM);
	}

	public WebElement getinputCompare() {
		return getElement(inputCompare);
	}

	public WebElement getOrganisationCompass() {
		return getElement(OrganisationCompass);
	}

	public WebElement getQAOrganisationCompass() {
		return getElement(QAOrganisationCompass);
	}


	public WebElement getOrganisationCompassSelect() {
		return getElement(OrganisationCompassSelect);
	}

	public WebElement getOrganisationCompassSelectCGA() {
		return getElement(OrganisationCompassSelectCGA);
	}


	public WebElement getOrganisationCompassIES() {
		return getElement(OrganisationCompassIES);
	}


	public WebElement getOrganisationCompassSelectAWWA() {
		return getElement(OrganisationCompassSelectAWWA);
	}

	public WebElement getOrganisationCompassSelectAPI() {
		return getElement(OrganisationCompassSelectAPI);
	}

	public WebElement getOrganisationCompassSelectAENOR() {
		return getElement(OrganisationCompassSelectAenor);
	}


	public WebElement getStageOrganisationCompass() {
		return getElement(StageOrganisationCompass);
	}

	/*public WebElement getFirstMyAccounts() {
		return getElement(FirstMyAccounts);
	}*/

	public WebElement getMyAccounts() {
		return getElement(MyAccounts);
	}

	public WebElement getExport_Button() {
		return getElement(Export_Button);
	}

	public WebElement getCitationInfoIcon() {
		return getElement(CitationInfoIcon);
	}

	public List<WebElement> getnotesInDocuments() {
		return driver.findElements(notesInDocuments);
	}
	public List<WebElement> NavLinks(){return driver.findElements(NavMenuLinks); }


	public List<WebElement> getListexistingNotes() {
		return driver.findElements(existingNotes);
	}

	public List<WebElement> getListCustomCollections() {
		return driver.findElements(customCollectionsLinks);
	}

	public String getStringTextAreaNotesModal() {
		return driver.findElement(textAreaNotesModal).getText();
	}


	public WebElement getAnnotateActive() {
		return getElement(annotateActive);
	}

	public WebElement getTextAreaNotesModal() {
		return getElement(textAreaNotesModal);
	}

	public WebElement getSaveNotesButton() {
		return getElement(SaveNotesButton);
	}

	public WebElement getexistingNotes() {
		return getElement(existingNotes);
	}

	public WebElement getnotesPopUp() {
		return getElement(notesPopUp);
	}

	public WebElement getcommentsBox() {
		return getElement(commentsBox);
	}

	public WebElement getviewNotes() {
		return getElement(viewNotes);
	}


	public WebElement getannotate() {
		return getElement(annotate);
	}

	public List<WebElement> getListfavoritesDocument() {
		return driver.findElements(favoritesDocument);
	}

	public WebElement gethpdf() {
		return getElement(hpdf);
	}


	public WebElement getUserGuideLink() {
		return getElement(UserGuideLink);
	}


	public WebElement getReferenceRetriever() {
		return getElement(ReferenceRetriever);
	}


	public List<WebElement> getListTrackerDocuments() {
		return driver.findElements(trackerDocuments);
	}

	public List<WebElement> getlistUnderSearchBox() {
		return driver.findElements(listUnderSearchBox);
	}
	public List<WebElement> getsharedDocrows()
	{
		return driver.findElements(sharedDocrows);
	}

	public WebElement getLightingLibraryContentsLink() {
		return getElement(LightingLibraryContentsLink);
	}

	public WebElement getUnderSearchBox() {
		return getElement(listUnderSearchBox);
	}

	public WebElement getExplorationAndProduction() {
		return getElement(ExplorationAndProduction);
	}

	public WebElement getCGAAddresse() {
		return getElement(CGAAddresse);
	}


	public WebElement getselectAccount() {
		return getElement(selectAccount);
	}


	public WebElement getOtherVersionDropdown() {
		return getElement(OtherVersionDropdown);
	}

	public WebElement getTranslationDropdown() {
		return getElement(TranslationDropdown);
	}


	public List<WebElement> getOtherVersionList() {

		return driver.findElements(OtherVersionList);
	}


	public WebElement getdocumentTypeVideo() {
		return getElement(documentTypeVideo);
	}

	public WebElement getStandardVideo() {
		return getElement(standardVideo);
	}

	public WebElement getSecondaryListDropdown_Category() {
		return getElement(SecondaryListDropdown_Category);
	}


	public WebElement getActive_Refinment() {
		return getElement(Active_Refinment);
	}


	public WebElement getDocumentDropdown() {
		return getElement(DocumentDropdown);
	}

	public WebElement getResultTypeDropdown() {
		return getElement(ResultTypeDropdown);
	}

	public WebElement getHomeLogo() {
		return getElement(HomeLogo);
	}

	public WebElement getHomeLink() {
		return getElement(HomeLink);
	}

	public WebElement getZipDownloadOption() {
		return getElement(ZipDownloadOption);
	}

	public WebElement getlangClick() {
		return getElement(langClick);
	}

	public WebElement getlangDropDownDoc() {
		return getElement(langDropDownDoc);
	}

	public WebElement getDesignation() {
		return getElement(Designation);
	}


	public WebElement getSABADoc() {
		return getElement(SABADoc);
	}


	public WebElement getDownloadRedlinedArrow() {
		return getElement(DownloadRedlinedArrow);
	}

	public WebElement getPDFdownloadArrow() {
		return getElement(PDFdownloadArrow);
	}


	public WebElement getMARCrecords() {
		return getElement(MARCrecords);
	}

	public List<WebElement> getlistOfJournals() {
		return driver.findElements(listOfJournals);
	}

	public WebElement getclickOnMARCrecords() {
		return getElement(clickOnMARCrecords);
	}

	public By CoverMonth = By.xpath("//p[text()='[Cover]']");

	public WebElement getmagnifyingGlassEmailAddress() {
		return getElement(magnifyingGlassEmailAddress);
	}

	public String getPDFnoNotes() {
		return driver.findElement(PDFnoNotes).getText();
	}

	public WebElement getAstmInternational() {
		return getElement(AstmInternational);
	}

	public WebElement getclickOnLangDropDown() {
		return getElement(clickOnLangDropDown);
	}


	public List<WebElement> getDocumentsNotes() {
		return driver.findElements(DocumentsNotes);
	}

	public WebElement getnotesDoc() {
		return getElement(notesDoc);
	}

	public String getDocStatus() {
		return driver.findElement(DocStatus).getText();
	}

	public List<WebElement> getDatesNotes() {
		return driver.findElements(DatesNotes);
	}

	public WebElement getmodalEmailAddress() {
		return getElement(modalEmailAddress);
	}

	public String getStringEmailAddressCheck() {
		return getElement(EmailAddressCheck).getText();
	}

	public List<WebElement> getStringEmailAddressCheckList() {
		return driver.findElements(EmailAddressCheck);
	}

	public String getStringnotesFilter() {
		return driver.findElement(notesFilter).getText();
	}

	public WebElement getnotesFilter() {
		return getElement(notesFilter);
	}

	public WebElement getbackToGroupTiles() {
		return getElement(backToGroupTiles);
	}

	public WebElement getclickOnTitle() {
		return getElement(clickOnTitle);
	}

	public WebElement getAenorDocumentUNE139802() {
		return getElement(AenorDocumentUNE139802);
	}

	public WebElement getAenorsearchBar() {
		return getElement(AenorsearchBar);
	}

	public String getMembersName() {
		return getElement(membersName).getText();
	}

	public String getMembersCount() {
		return getElement(membersCount).getText();
	}

	public WebElement getgroupAddDocument() {
		return getElement(groupAddDocument);
	}

	public WebElement getAENORPremiumLogo() {
		return getElement(AENORPremiumLogo);
	}

	public WebElement getHeader() {
		return getElement(header);
	}


	public WebElement getRecentlyAccessedTab() {
		return getElement(recentlyAccessedTab);
	}


	public WebElement getMenuTracker() {
		return getElement(MenuTracker);
	}

	public WebElement getCopyrightText() {
		return getElement(CopyrightText);
	}

	public WebElement getSubTab() {
		return getElement(subscriptionTab);
	}

	public WebElement getTrackerTab() {
		return getElement(trackerTab);
	}

	public String getTextunderDescription() {
		return driver.findElement(TextunderDescription).getText();
	}

	public WebElement getfavoritesTab() {
		return getElement(favoritesTab);
	}

	public WebElement getsubscriptionsTab() {
		return getElement(subscriptionsTab);
	}

	public WebElement getsubscriptions_Tab() {
		return getElement(subscriptions_Tab);
	}

	public WebElement getMyASTM() {
		return getElement(myASTMOption);
	}

	public WebElement getcardcontent() {
		return getElement(cardcontent);
	}

	public WebElement getcompassTipsAndTricks() {

		return getElement(tripTricks);

	}

	public WebElement getDownload() {
		return getElement(Download);
	}

	public WebElement getclickOnRelatedContent() {
		return getElement(clickOnRelatedContent);
	}


	public WebElement getMYASTM() {
		return getElement(MYASTM);
	}

	public WebElement getMeeting() {
		return getElement(meetingSymposia);
	}

	public WebElement getCompassNotes() {
		return getElement(compassNotes);
	}

	public WebElement getRecentlyUpdatedTab() {
		return getElement(recentlyUpdatedTab);
	}

	public WebElement getVersionComparison() {
		return getElement(versionComparison);
	}

	public WebElement getWelcomeMessage() {

		return getElement(welcomeBackHeader);
	}

	public WebElement getUsernameDropdown() {
		return getElement(username);
	}

	public WebElement getTechnicalCommittees() {
		return getElement(technicalCommittees);
	}

	public WebElement getOtherVersions() {
		return getElement(OtherVersions);
	}

	public WebElement getMemberShip() {
		return getElement(membership);
	}

	public WebElement getuserdropdown() {
		return getElement(membership);
	}

	public WebElement getPublishWithAstm() {
		return getElement(publishWithASTM);
	}


	public WebElement getNavBarClose() {
		return getElement(NavBarClose);
	}

	public WebElement getmenu() {
		return getElement(menu);
	}

	public WebElement getASTMlogo() {
		return getElement(ASTMlogo);
	}

	public WebElement getMagnifyingGlass() {
		return getElement(magnifyingGlass);
	}

	public WebElement getmagnifyingGlassSub() {
		return getElement(magnifyingGlassSub);
	}

	public String clickOnTitle() {
		return getElement(clickOnTitle).getText();
	}

	public String getdeletePopUp() {
		return getElement(deletePopUp).getText();
	}

	public WebElement gettitleOfGroup() {
		return getElement(titleOfGroup);
	}

	public String getTitleOfGroupString() {
		return getElement(titleOfGroup).getText();
	}

	public WebElement getTitleEdit() {
		return getElement(titleEdit);
	}

	public String comprehensiveList() {
		return getElement(comprehensiveList).getText();
	}

	public String getDeleteTitle() {
		return getElement(deleteTitle).getText();
	}

	public WebElement clickOnRelatedDoc() {
		return getElement(clickOnRelatedDoc);
	}

	public WebElement getclickOnTitleGroup() {
		return getElement(clickOnTitleGroup);
	}

	public String getclickOnTitleGroupString() {
		return getElement(clickOnTitleGroup).getText();
	}

	public String getEmailTitle() {
		return getElement(emailTitle).getText();
	}

	public String getEmailCheckBox() {
		return getElement(emailCheckBox).getText();
	}

	public String getelementInputString() {
		return getElement(elementInput).getText();
	}

	public List<WebElement> getRecentlyUpdatedCardContent() {
		return driver.findElements(recentlyUpdatedCardContent);
	}

	public List<WebElement> getElementInput() {
		return driver.findElements(elementInput);
	}

	public List<WebElement> getTilesContainer() {
		return driver.findElements(tilesContainer);
	}

	public List<WebElement> getCompassMembersDocument() {
		return driver.findElements(compassMembersDocument);
	}

	public List<WebElement> getVideos() {
		return driver.findElements(videos);
	}

	public List<WebElement> getRecentlyAccessedStandard() {
		return driver.findElements(recentlyAccessedStandard);
	}


	public List<WebElement> getCompareModalCheckbox() {
		return driver.findElements(CompareModalCheckbox);
	}

	public List<WebElement> getPDFPages() {
		return driver.findElements(pdfPages);
	}

	public List<WebElement> getToggleSwitches() {
		return driver.findElements(ToggleSwitches);
	}

	public List<WebElement> getGroupMemberDocument() {
		return driver.findElements(groupMemberDocument);
	}

	public WebElement getCopyright_PermissionLink() {
		return getElement(Copyright_PermissionLink);
	}

	public WebElement getPDF() {
		return getElement(PDF);
	}

	public WebElement getSupportLink() {
		return getElement(supportLink);
	}

	public WebElement getContactLink() {
		return getElement(contactLink);
	}

	public WebElement getsupportFAQs() {
		return getElement(supportFAQs);
	}

	// fields
	public WebElement getPublisher() {
		return getElement(publisher);
	}

	public WebElement getDestinationNo() {
		return getElement(destinationNo);
	}

	public WebElement getStandardTitle() {
		return getElement(StandardTitle);
	}

	public WebElement getDocument() {
		return getElement(document);
	}

	public WebElement getLastUpdate() {
		return getElement(lastUpdate);
	}


	public WebElement getstatus() {
		return getElement(status);
	}

	public WebElement getUpdatedDocuments() {
		return getElement(updatedDocuments);
	}

	public WebElement getSearch() {
		return getElement(searchText);
	}

	public WebElement getSearchBox() {
		return getElement(searchTextSub);
	}

	public WebElement TrackDocumentbutton() {
		return getElement(TrackDocument);
	}

	public WebElement getSearchDropDown() {
		return getElement(searchDropdown);
	}

	public WebElement getSearchButton() {
		return getElement(searchIcon);
	}

	public WebElement getSubscriptionUsage() {
		return getElement(SubscriptionUsage);
	}

	public WebElement getCustomCollections() {
		return getElement(CustomCollections);
	}

	public List<WebElement> getRecentlyAccessedCardContent() {
		return driver.findElements(recentlyAccessedCardContent);
	}

	public List<WebElement> getRecentlyAccessedCardContentIES() {
		return driver.findElements(recentlyAccessedCardContentIES);
	}

	public List<WebElement> getRecentlyAccessedCardContentAPI() {
		return driver.findElements(recentlyAccessedCardContentAPI);
	}

	public List<WebElement> gettiles_text() {
		return driver.findElements(tiles_text);
	}
	public List<WebElement> getHeaderLinksDD()
	{
		return driver.findElements(HeaderLinksDD);
	}

	public List<WebElement> getrecentlyAccessedASTMStandard() {
		return driver.findElements(recentlyAccessedASTMStandard);
	}

	public List<WebElement> getrecentlyAccessedAPIStandard() {
		return driver.findElements(recentlyAccessedAPIStandard);
	}

	public List<WebElement> getTranslatedVersion() {
		return driver.findElements(TranslatedCardContent);
	}
	public List<WebElement> getVideoTitles()
	{
		return driver.findElements(VideoTitle);
	}
	public WebElement getRecentlyAccessedErrorText() {
		return getElement(RecentlyAccessedErrorText);
	}

	public WebElement getPrivacyPolicy() {
		return getElement(privacyPolicy);
	}

	public String getsearchDropdownAlltext() {
		return driver.findElement(searchDropdownAlltext).getText();
	}

	public WebElement getPolicies() {
		return getElement(policies);
	}

	// Social Elements
	public WebElement getTwitterLink() {
		return getElement(twitterLink);
	}

	public WebElement getFacebookLink() {
		return getElement(facebookLink);
	}

	public WebElement getYoutubeLink() {
		return getElement(youtubeLink);
	}

	public WebElement getLinkedLink() {
		return getElement(linkedinLink);
	}

	public WebElement getInstagramLink() {
		return getElement(instagramLink);
	}

	public WebElement getRSSLink() {
		return getElement(astmRSSLink);
	}

	public WebElement getHelpDropdown() {
		return getElement(helpDropdown);
	}
	public WebElement getHelpDropdown1() {
		return getElement(helpDropdown1);
	}


	public WebElement getCopyRights() {
		return getElement(copyRights);
	}

	public WebElement getCopyRightsFooter() {
		return getElement(copyRightFooter);
	}

	public WebElement getASTMLogo() {
		return getElement(internationalASTM);
	}


	public WebElement getMyASTMURL() {
		return getElement(myASTMOption);
	}

	public WebElement getUntrackDocument() {
		return getElement(UntrackDocument);
	}

	public WebElement getpdfpages() {
		return getElement(pdfPages);
	}

	public WebElement getHTMLActive() {
		return getElement(HTMLActive);
	}

	public WebElement getDeleteGroup() {
		return getElement(DeleteGroup);
	}

	public WebElement getMenuHome() {
		return getElement(MenuHome);
	}

	public WebElement getPoweredBy() {
		return getElement(PoweredBy);
	}

	public WebElement getCompareVersions() {
		return getElement(CompareVersions);
	}

	public WebElement getCloseCompareButton() {
		return getElement(CloseCompareButton);
	}


	public WebElement getSubscriptionsMenu() {
		return getElement(SubscriptionsMenu);
	}

	public WebElement getCompareButton() {
		return getElement(CompareButton);
	}

	public WebElement getDownloadRedlinedButton() {
		return getElement(DownloadRedlinedButton);
	}

	public WebElement getmaskclass() {
		return getElement(maskclass);
	}

	public WebElement getViewAllTracked() {
		return getElement(ViewAllTracked);
	}

	public String getdocumentsCount() {
		return getElement(documentsCount).getText();
	}

	public WebElement gettrackerTabActive() {
		return getElement(trackerTabActive);
	}

	public List<WebElement> getGroupSuccessUpdated() {
		return driver.findElements(groupSuccessUpdated);
	}

	public List<WebElement> getTrackerRow() {
		return driver.findElements(trackerRow);
	}

	public List<WebElement> getTrackCheckbox() {
		return driver.findElements(trackCheckBox);
	}

	public String getDefaultLanguage() {
		return getElement(DefaultLanguage).getText();
	}

	public List<WebElement> getTrackerTiles() {
		return driver.findElements(trackerCardContent);
	}

	public WebElement getWhatStandard() {
		return getElement(WhatStandard);
	}

	public WebElement getAccountSelect() {
		return getElement(AccountSelect);
	}

	public WebElement getaccountDropdown() {
		return getElement(accountDropdown);
	}

	public WebElement getSignout() {
		return getElement(Signout);
	}

	public WebElement getHomepageTabs() {
		return getElement(HomepageTabs);
	}

	public WebElement getsearchText() {
		return getElement(searchText);
	}

	public WebElement getWithdrawnLink() {
		return getElement(WithdrawnLink);
	}

	public List<WebElement> getrecentlyUpdatedCardContent() {
		return driver.findElements(recentlyUpdatedCardContent);
	}

	public String noNotesText() {
		return driver.findElement(noNotes).getText();
	}

	public WebElement getDescriptionEdit() {
		return getElement(DescriptionEdit);
	}


	public WebElement getFavoritesMenu() {
		return getElement(FavoritesMenu);
	}

	public String getnoMigratedNotes() {
		return driver.findElement(noMigratedNotes).getText();
	}


	public WebElement getdeleteIconNotes() {
		return getElement(deleteIconNotes);
	}

	public WebElement getDeleteIcon() {
		return getElement(DeleteIcon);
	}

	public WebElement getAWWAFooterLogo() {
		return getElement(AWWAFooterLogo);
	}

	public WebElement getDownloadPDF() {
		return getElement(DownloadPDF);
	}

	public WebElement getPDFTronView() {
		return getElement(PDFTronView);
	}

	public WebElement getGroups_Menu() {
		return getElement(Groups_Menu);
	}

	public WebElement getCreateGroups() {
		return getElement(CreateGroups);
	}

	public WebElement getGroupName() {
		return getElement(GroupName);
	}

	public WebElement getNext() {
		return getElement(Next);
	}

	public WebElement getBack() {
		return getElement(Back);
	}


	public WebElement getCreateGroupIcon() {
		return getElement(CreateGroupIcon);
	}


	public WebElement getGroupNameTextBox() {
		return getElement(GroupNameTextBox);
	}

	public WebElement getGroupDescriptionTextBox() {
		return getElement(GroupDescriptionTextBox);
	}


	public WebElement getAddGroupMember() {
		return getElement(AddGroupMember);
	}

	public WebElement getSearchBar_AddMember() {
		return getElement(SearchBar_AddMember);
	}

	public WebElement getMagnifyingGlass_AddMember() {
		return getElement(MagnifyingGlass_AddMember);
	}

	public WebElement getrecentlyAccessedASTMStandardclick() {
		return getElement(recentlyAccessedASTMStandard);
	}

	public WebElement gettestingMigration() {
		return getElement(testingMigration);
	}

	public WebElement getRightArrow_AddMember() {
		return getElement(RightArrow_AddMember);
	}

	public WebElement getSelectAll_AddMember() {
		return getElement(SelectAll_AddMember);
	}

	public WebElement getIESQA_AddMember() {
		return getElement(IESQA_AddMember);
	}

	public WebElement getAenorSub_AddMember() {
		return getElement(AenorSub_AddMember);
	}

	public WebElement getMyaccount() {
		return getElement(Myaccount);
	}

	public WebElement getAWWAQA_AddMember() {
		return getElement(AWWAQA_AddMember);
	}


	public WebElement getDownload_PDFtab() {
		return getElement(Download_PDFtab);
	}


	public WebElement getThreedots_GroupTile() {
		return getElement(Threedots_GroupTile);
	}

	public WebElement getEdit_GroupTile() {
		return getElement(Edit_GroupTile);
	}

	public WebElement getDescriptionTile() {
		return getElement(DescriptionTile);
	}

	public WebElement getClose() {
		return getElement(Close);
	}

	public WebElement getSearchBar_AddDocument() {
		return getElement(SearchBar_AddDocument);
	}

	public WebElement getCreate() {
		return getElement(Create);
	}

	public WebElement getGeneralDocuement() {
		return getElement(GeneralDocuement);
	}

	public WebElement getMore() {
		return getElement(More);
	}

	public WebElement getMagnifyglass_Modal() {
		return getElement(Magnifyglass_Modal);
	}

	public WebElement getNoMatch() {
		return getElement(NoMatch);
	}

	public WebElement getShareOption() {
		return getElement(ShareOption);
	}

	public WebElement getSearchBar_Modal() {
		return getElement(SearchBar_Modal);
	}

	public WebElement getIlluminanceTables() {
		return getElement(IlluminanceTables);
	}

	public WebElement getElearning() {
		return getElement(Elearning);
	}

	public WebElement getNoAccess() {
		return getElement(NoAccess);
	}

	public WebElement getCloseNoAccess() {
		return getElement(CloseNoAccess);
	}

	public List<WebElement> getRelatedLinks() {
		return driver.findElements(RelatedLinks);
	}

	public List<WebElement> getLanguage() {
		return driver.findElements(Language);
	}

	public WebElement getcookie_close() {
		return getElement(cookie_close);
	}

	public WebElement getWorkItem() {
		return getElement(WorkItem);
	}


	public WebElement getWorkItemNo() {
		return getElement(WorkItemNo);
	}

	public WebElement getPublisher_WorkItem() {
		return getElement(Publisher_WorkItem);
	}

	public WebElement getDateInitiated() {
		return getElement(DateInitiated);
	}

	public WebElement getStatusofWorkItem() {
		return getElement(StatusofWorkItem);
	}

	public WebElement getEmailSubject() {
		return getElement(emailSubject);
	}

	public WebElement getEmailMessage() {
		return getElement(emailMessage);
	}

	public WebElement getTechnicalContact() {
		return getElement(TechnicalContact);
	}

	public WebElement getdropdown() {
		return getElement(dropdown);
	}

	public WebElement getdocShareWithMe() {
		return getElement(docShareWithMe);
	}

	public WebElement getdocshareme() {
		return getElement(docshareme);
	}


	public WebElement getMysharedoc() {
		return getElement(Mysharedoc);
	}

	public WebElement getMydoc() {
		return getElement(Mydoc);
	}

	public WebElement getdesignation() {
		return getElement(designation);
	}

	public WebElement getpagination() {
		return getElement(pagination);
	}

	public WebElement getnextpagination() {
		return getElement(nextpagination);
	}

	public WebElement getclickOnDocument() {
		return getElement(clickOnDocument);
	}

	public WebElement getchevron_WI() {
		return getElement(chevron_WI);
	}

	public WebElement getTC_MWI() {
		return getElement(TC_MWI);
	}

	public WebElement getchevronup() {
		return getElement(chevronup);
	}

	public WebElement getWIModaltitle() {
		return getElement(WIModaltitle);
	}


	public WebElement getWIModalbody() {
		return getElement(WIModalbody);
	}

	public WebElement getPubWI() {
		return getElement(PubWI);
	}

	public WebElement getUserResourcePage() {
		return getElement(UserResourcePage);
	}

	public List<WebElement> getLeftNavigationLink() {

		return driver.findElements(leftNavigationLink);
	}

	public List<WebElement> getLTSLink() {

		return driver.findElements(LTSLink);
	}

	public WebElement getLTSdetails() {
		return getElement(LTSdetails);
	}

	public List<WebElement> getDocumentC() {

		return driver.findElements(DocumentC);
	}

	public List<WebElement> getDesignationC() {

		return driver.findElements(DesignationC);
	}

	public List<WebElement> getTitleC() {

		return driver.findElements(TitleC);
	}

	public List<WebElement> getDocTable() {

		return driver.findElements(DocTable);
	}

	public WebElement getfirstLast() {
		return getElement(firstLast);
	}

	public WebElement getVersionDDLink()
	{
		return getElement(VersionDDLink);
	}


	public String getMydoctext() {
		return getElement(Mydoc).getText();
	}

	public List<WebElement> getColumn() {
		return driver.findElements(DocTable);
	}

	public String getWelcometitle() {
		return getElement(Welcometitle).getText();
	}

	public WebElement getAccountid() {
		return getElement(Accountid);
	}

	public String getDocType() {
		return getElement(DocType).getText();
	}
	public List<WebElement> getTrackedstandardTitles() {

		return getElements(By.xpath("//tr/td/a"));
	}
	public List<WebElement> getCategoryLinks() {

		return driver.findElements(CategoryLinks);
	}

	public List<WebElement> getSecondaryList_Category() {

		return driver.findElements(SecondaryList_Category);
	}

	public List<WebElement> getDocumentDesignation() {

		return driver.findElements(DocumentDesignation);
	}

	public List<WebElement> getActiveDocuments() {

		return driver.findElements(ActiveDocuments);
	}

	public List<WebElement> getWithdrawnDocuments() {

		return driver.findElements(WithdrawnDocuments);
	}

	public List<WebElement> getSecondaryList() {

		return driver.findElements(SecondaryList);
	}

	public List<WebElement> activePages() {
		return driver.findElements(NextPage);

	}

	public List<WebElement> getVersionDDItems()
	{
		return driver.findElements(VersionDDItems);
	}
	public List<WebElement> getfavoritesDocLinks()
	{
		return driver.findElements(favoritesDocLinks);
	}

	public List<WebElement>  getTrackedDocLinks()
	{
		return driver.findElements(TrackedDocLinks);
	}
	public By supplementsdropdown(String Doc) {
		return By.xpath("//span[text()='"+Doc+"']/../..//div/a[text()='Supplements']");
	}
	public By mySubscriptionDocument(String index) {
		return By.xpath("(//p[@class='astm-type-heading--h5']/a)["+index+"]");
	}
	/**
	 * This Method is used to Verify the Compass Tips & Tricks Section element
	 * displayed or not
	 *
	 * @return True/False
	 */
	@Step("Verify whether user is able to view a section \"COMPASS TIPS AND TRICKS\"")
	public boolean verifyCompassTipsAndTricks(By locator) {
		try {
			ReusableMethods.scrollIntoView(getcompassTipsAndTricks(), driver);
			boolean comTipsAndTricks = getcompassTipsAndTricks().isDisplayed();
			return comTipsAndTricks;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * @param locator
	 * @return
	 */
	public boolean isWebElementDisplayed(By locator) {
		try {

			WebElement elm = getElement(locator);
			return elm.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * @param element
	 * @return
	 */
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
	public boolean isWebElementEnabled(By locator) {
		try {
			WebElement elm = getElement(locator);
			return elm.isEnabled();
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * This Method is used to Verify Version Comparison element displayed or not
	 *
	 * @return True/False
	 */
	@Step("Verify whether the \"COMPASS TIPS AND TRICKS\" section contains the option \"Version Comparison\"")
	public boolean verifyVersionComparison() {
		try {
			ReusableMethods.scrollIntoView(getVersionComparison(), driver);
			boolean verComp = getVersionComparison().isDisplayed();
			return verComp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to click on Recently accessed Tab & Verify it is active or not
	 *
	 * @return True/False Tab is active or not
	 */

	// @Step("On homepage click on the Recently Accessed tab.")
	public boolean clickonRecentAccessedTab() {

		boolean statusTracker = false;
		try {
			waitforInvisibilityAndElementToClickable(getRecentlyAccessedTab());
			getRecentlyAccessedTab().click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (getRecentlyAccessedTab().getAttribute("class").contains("active")) {
				return statusTracker = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusTracker;

	}

	/**
	 * This method check Recently accessed Tab is visible or not
	 *
	 * @return True/false
	 */
	public boolean verifyRecentAccessesTabVisibility() {

		boolean recentTabStatus = false;
		try {
			if (commonVisiblityMethod(getRecentlyAccessedTab())) {
				return recentTabStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return recentTabStatus;
	}

	/**
	 * This method is to click on Tracker Tab & Verify it is active or not
	 *
	 * @return True/False Tab is active or not
	 */
//	@Step("Click on the Tracker tab.")
	public boolean clickOnTrackerTab() {
		boolean statusTracker = false;
		try {
			waitforInvisibilityAndElementToClickable(getTrackerTab());
			getTrackerTab().click();// clicks on Tracker Tab
			if (getTrackerTab().getAttribute("class").contains("active")) {
				return statusTracker = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusTracker;
	}

	/**
	 * This method check Tracker Tab is visible or not
	 *
	 * @return True/false
	 */
	// @Step("Check that the \"Tracker\" tab option is displayed next to the
	// Recently Accessed tab.")
	public boolean verifyTrackerTabVisibility() {

		boolean trackerStatus = false;
		try {
			if (commonVisiblityMethod(getTrackerTab())) {
				return trackerStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return trackerStatus;
	}

	/**
	 * This method returns Menu option is visible on the page
	 *
	 * @return
	 */
	//@Step("the individual user should be able to view Menu option")
	public boolean verifyMenu() {
		try {
			boolean menuOption = isWebElementDisplayed(menu);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return menuOption;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method verifies if Logo of campass is present or not
	 *
	 * @return
	 */
	@Step("Verify ASTM logo is visible")
	public boolean verifyASTMlogo(By locator) {
		try {
			boolean ASTMlogoStatus = isWebElementDisplayed(ASTMlogo);
			return ASTMlogoStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * This method checks is there are any Recently Updated Documents and clicks on
	 * the 1st document
	 */

	//@Step("Click on the Recently Updated Document")
	public boolean ClickRecentlyUpdatedTiles() {

		WaitStatementUtils.explicitWaitForVisibility(driver, getRecentlyUpdatedTab(), 20);
		ReusableMethods.scrollIntoView(getrecentlyUpdatedCardContent().get(0), driver);

		int size = getrecentlyUpdatedCardContent().size();
		if (size != 0) {

			getrecentlyUpdatedCardContent().get(0).click();
		}

		return true;

	}


	public boolean checkPdfDisplayed() {
		try {
			//	getPDF().click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getPDF(), 30);
			int size = getPDFPages().size();
			if (size != 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks is there are any Recently Updatd Documents and clicks on
	 * the 1st document
	 */
	//@Step("Click on the Recently Updated Document")
	public boolean ClickRecentlyAccessedTiles() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getRecentlyAccessedTab(), 20);
		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();
		if (size != 0) {
			getRecentlyAccessedCardContent().get(0).click();
		}
		return true;
	}

	/**
	 * This method checks is there are any Recently Updatd Documents and clicks on
	 * the 1st document for mobile
	 */
	//@Step("Click on the Recently Updated Document")
	public boolean ClickRecentlyAccessedTilesforMobile() {
		WaitStatementUtils.explicitWaitForVisibility(driver, getRecentlyAccessedTab(), 20);
		int size = getRecentlyAccessedCardContent().size();
		if (size != 0) {
			getRecentlyAccessedCardContent().get(0).click();
		}
		return true;
	}

	/**
	 * This method checks is there are any Recently Updatd Documents and clicks on
	 * the 1st document
	 */
	//@Step("Click on the Recently Updated Document")
	public boolean ClickRecentlyAccessedTilesDynamic() {
		//WaitStatementUtils.explicitWaitForVisibility(driver,getRecentlyAccessedTab(), 20);
		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();
		if (size != 0) {
			for (int i = 0; i <= size; i++)
				getRecentlyAccessedCardContent().get(i).click();
		}
		return true;
	}

	@Step("Verify successful login to Compass Homepage")
	/**
	 * @return true/false value Gets successful login details
	 */
	public boolean VerifyLoginSuccessOnHomePage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(getWelcomeMessage()));
			WaitStatementUtils.waitForElementToBeClickable(driver, getWelcomeMessage(), 30);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			boolean value = getWelcomeMessage().isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * @return true/false value Gets successful login details
	 */
	public boolean VerifyLoginSuccessOnHomePage_SUB_1254() {
		boolean flag = false;
		try {
			flag = getAccountSelect().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * This method verifies if tracker tab is present or not
	 *
	 * @return
	 */
//	@Step("the individual user should be able to view tracker")
	public boolean verifyTrackerTabVisible() {
		try {
			boolean tracker = isWebElementDisplayed(trackerTab);
			return tracker;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method verifies the presence of magnifying glass icon
	 *
	 * @return True/False
	 */
	//@Step("the individual user should be able to view a button with a magnifying glass icon")
	public boolean verifyMagnifyingGlass() {
		try {
			boolean magnifyingGlassStatus = isWebElementDisplayed(magnifyingGlass);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return magnifyingGlassStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean commonVisiblityMethod(WebElement element) {
		WaitStatementUtils.explicitWaitForVisibility(driver, element, 20);
		boolean status = element.isDisplayed();
		return status;
	}

	/**
	 * This method will click on MY Technical Committees Link on HomePage
	 *
	 * @return True/False on URL matched or not
	 */

	public boolean clickOnTechnicalCommittees() {
		try {
			WebElement techincalCommiteeElement = getTechnicalCommittees();
//			String expectedUrl = ConfigReader.getValue("technical_url");
			String expectedUrl = "https://stage-www.astm.org/get-involved/technical-committees.html";
			String navigatedUrl = verifyURL(techincalCommiteeElement, "ASTM International - Technical Committees");
			if (navigatedUrl.trim().equalsIgnoreCase(expectedUrl)) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will click on MemeberShip Link on HomePage
	 *
	 * @return True/False on URL matched or not
	 */

	public boolean clickOnMemberShip() {
		// WaitStatementUtils.waitForElementToBeClickable(driver, getMemberShip());
		ReusableMethods.scrollIntoView(getMemberShip(), driver);
		// String expectedURL=verifyURL(getMemberShip());
//		if (getElement(membershipURL).getAttribute("href")
//				.equalsIgnoreCase(verifyURL(getMemberShip(), "ASTM International - Membership"))) {
//			return true;
//		}
//		return false;
		String expectedUrl = "https://stage-www.astm.org/get-involved/membership.html";
		String navigatedUrl = verifyURL(getMemberShip(), "ASTM International - Technical Committees");
		if (navigatedUrl.trim().equalsIgnoreCase(expectedUrl)) {
			return true;
		}

        return false;
    }

	public void PDFDisplayed() {

		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getPDF(), 20);
			getPDF().click();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method will click on MY ASTM Link on HomePage
	 *
	 * @return True/False on URL matched or not
	 */

	public boolean clickOnMYASTM() {
		try {
			String actualURL = verifyURL(getMYASTM(), "ASTM International - Login");
			if (actualURL.trim().equalsIgnoreCase(ConfigReader.getValue("myastm_url").trim())) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * This method will click on Meeting & Symposia Link on HomePage
	 *
	 * @return True/False on URL matched or not
	 */

	public boolean clickOnMeetingAndSymposia() {

		try {
			if (verifyURL(getMeeting(), "ASTM International - Meetings & Symposia").trim()
					.equalsIgnoreCase(ConfigReader.getValue("meeting_url").trim())) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will click on Public with ASTM Link on HomePage
	 *
	 * @return True/False on URL matched or not
	 */

	public boolean clickOnPublishWithASTM() {

		try {
			if (verifyURL(getPublishWithAstm(), "ASTM International - Publish Books and Journals with ASTM").trim()
					.equalsIgnoreCase("https://stage-www.astm.org/get-involved/publish-with-astm.html")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This Method is Used to getElement attribute value.
	 *
	 * @param element
	 * @param getAttribute
	 * @return
	 */
	public String getAttributeValue(WebElement element, String getAttribute) {
		String expectedURL = element.getAttribute(getAttribute);
		return expectedURL;
	}

	/**
	 * This Method use to verify the Link. User will click on Link and verify it is
	 * redirected to Same link or not
	 *
	 * @param element
	 * @return String which contains URL of the Page.
	 */

	public String verifyURL(WebElement element, String pageTitle) {
		try {
			waitforInvisibilityAndElementToClickable(element);
			ReusableMethods.scrollIntoView(element, driver);
			String parentWinodw = driver.getWindowHandle();
			action.moveToElement(element).click(element).build().perform();
			PublicAdminCommons.waitForSec(10000);
			// WaitStatementUtils.implicitWaitForSeconds(driver,2);
			Iterator<String> Windowhandle = driver.getWindowHandles().iterator();

			// Iterating window handles
			while (Windowhandle.hasNext()) {
				String child = Windowhandle.next();
				if (!parentWinodw.equals(child)) {
					driver.switchTo().window(child);
					waitForPageTitle(pageTitle);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					WaitStatementUtils.implicitWaitForSeconds(driver, 30);
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
	 * This method is to verify if the publisher field is visible on a standard
	 *
	 * @returns boolean value
	 */
	//@Step("the individual user should be able to view publisher field on a standard")
	public boolean VerifyPublisherField(By locator) {
		try {
			boolean value = isWebElementDisplayed(locator);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to verify if the destination number field is visible on a
	 * standard
	 *
	 * @returns boolean value
	 */
//	@Step("the individual user should be able to view Destination number field on a standard")
	public boolean VerifyDestinationNumberField(By locator) {
		try {
			boolean value = isWebElementDisplayed(locator);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to verify if the document field is visible on a standard
	 *
	 * @returns boolean value
	 */
//	@Step("the individual user should be able to view document field on a standard")
	public boolean VerifyDocumentField(By locator) {
		try {
			boolean value = isWebElementDisplayed(locator);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to verify if the last update field is visible on a standard
	 *
	 * @returns boolean value
	 */
//	@Step("the individual user should be able to view last update field on a standard")
	public boolean VerifyLastUpdateField(By locator) {
		try {
			boolean value = isWebElementDisplayed(locator);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to verify if the status field is visible on a standard
	 *
	 * @returns boolean value
	 */
//	@Step("the individual user should be able to view status field on a standard")
	public boolean VerifyStatusField(By locator) {
		try {
			boolean value = isWebElementDisplayed(locator);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This methods checks the count of updates on tracker tab
	 */

	public boolean VerifyCountOfUpdatedDocuments() {
		try {
			getTrackerTab().click();
			boolean value = isWebElementDisplayed(updatedDocuments);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks that the default option in the Search Box is "All"
	 *
	 * @return True/false as per the default value in Search dropdown
	 */
	//@Step("the individual user should be able to view a default option as ALL in the search filter drop down")
	public boolean VerifyDefaultValueInDropDown() {
		try {
			String actual = "All";
			String expected = getSearchDropDown().getText().trim();
			boolean value = actual.equalsIgnoreCase(expected);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to verify if the search box is visible in header
	 *
	 * @returns boolean value
	 */
	//@Step("Check that the user is able to view a search box with static text \"Search by Topic, Title, Author, or A53\" in the header.")
	public boolean VerifySearchTab() {
		try {
			boolean value = isWebElementDisplayed(searchBox);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This Method is used to Check the Error Message
	 *
	 * @return String -Error message
	 */
	@Step("User is able to see Error messsage when there is no recently accessed document on recently accessed tab")
	public String CheckErrorTextOnRecentlyAccessedTab() {
		String Error_text = "";
		int size = getRecentlyAccessedCardContent().size();
		if (size == 0) {
			Error_text = getRecentlyAccessedErrorText().getText();
		}

		return Error_text;
	}

	/**
	 * This method check whether 6 tabs are there or not under Recently Accessed tab
	 *
	 * @return True/false
	 */

	//@Step("Check is recently accessed documents are less than 6")
	public boolean CheckLessThan6RecentlyAccessedDocuments() {
		boolean flag = false;
		try {
			int size = getRecentlyUpdatedCardContent().size();
			if (size <= 6 && size != 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * This method used to check 6 recently accessed document on RecentlyAccessed
	 * tab are visible or not
	 *
	 * @return True /false
	 */
	//@Step("User is able to see last 6 recenetly accesed document on RecentlyAccessed tab")
	public boolean Checklast6RecentlyAccessedDocuments() {
		boolean flag = false;
		WaitStatementUtils.explicitWaitForVisibility(driver, getRecentlyAccessedTab(), 20);
		int size = getRecentlyAccessedCardContent().size();
		if (size != 0) {

			flag = true;
		}

		return flag;
	}

	/**
	 * This method is to verify that "Support" link is Displayed
	 *
	 * @return True/false based on Support link's presence
	 */
//	@Step("Navigate to the footer section in Compass.")
	public boolean supportLinkDisplayed() {

		ReusableMethods.scrollIntoView(getSupportLink(), driver);
		try {
			boolean value = isWebElementDisplayed(supportLink);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to verify that "Support" link is displayed and navigates to
	 * the correct link
	 *
	 * @return True/false based on the link
	 */

	public boolean clickOnSupport() {
		//
		try {
			String actualURL = verifyURL(getSupportLink(), "ASTM Federated Login");

			if (actualURL.equalsIgnoreCase(ConfigReader.getValue("support_url"))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks the visible fields in every standard
	 *
	 * @return
	 */
	//@Step("the compass user should be able to view the required information for each tile")
	public boolean CheckFieldsAreVisibleInTracker() {
		try {
			boolean value = isWebElementDisplayed(trackerTab);
			if (value == true) {
				getTrackerTab().click();
				List<WebElement> elementsList = driver
						.findElements(By.xpath("//*[@class='card-content row']//*[@class='card-adjust card']"));
				int size = elementsList.size();
				if (size <= 6) {
					for (int i = 1; i <= size; i++) {
						WaitStatementUtils.explicitWaitForVisibility(driver,
								driver.findElement(By.xpath("//*[@class='card-content row']/div[" + i + "]")));

						boolean standard = driver.findElement(By.xpath("//*[@class='card-content row']/div[" + i + "]"))
								.isDisplayed();
						if (standard = true) {

							VerifyPublisherField(
									By.xpath("//*[@class='card-content row']/div[" + i + "]//label/span[1]"));
							VerifyDestinationNumberField(
									By.xpath("//*[@class='card-content row']/div[" + i + "]//label/span[2]"));
							VerifyDocumentField(
									By.xpath("//*[@class='card-content row']/div[" + i + "]/div[1]/div[2]/span"));
							VerifyLastUpdateField(
									By.xpath("//*[@class='card-content row']/div[" + i + "]/div[1]/div[3]"));
							VerifyStatusField(
									By.xpath("//*[@class='card-content row']/div[" + i + "]/div[1]/div[1]/div[4]"));
						}
					}
				}
			}
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks the policies link is clicked and the same is navigated to
	 * another window
	 *
	 * @return
	 */

	@Step(" the user is able to see an outbound link to Policies and navigate")
	public boolean CheckPoliciesInFooter() {
		try {
			ReusableMethods.scrollIntoView(getPolicies(), driver);
			if (ConfigReader.getValue("PoliciesURL").trim()
					.equalsIgnoreCase(verifyURL(getPolicies(), "ASTM International - ASTM Policies")))

				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks if the Contact link is displayed
	 *
	 * @return True/False based on presence of "Contact"
	 */
	// @Step("The user should be able to view a Contacts link")
	public boolean contacttLinkDisplayed() {

		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(contactLink), 10);
			boolean value = isWebElementDisplayed(contactLink);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is to verify that "Contact" link is displayed and navigates to
	 * the correct link
	 *
	 * @return True/false based on the link
	 */
	// @Step("Clicks on Contact link in the footer after checking its presence")
	public boolean clickOnContact() {
		//
		String actualURL = verifyURL(getContact(), "Contact Us");

		if (actualURL.trim().equalsIgnoreCase(ConfigReader.getValue("contact_url"))) {
			return true;
		}
		return false;
	}

	// @Step("Clicks on Contact link in the footer after checking its presence")
	public boolean clickOnPrivacyPolicyFooter() {
		//
		String actualURL = verifyURL(getPrivacyPolicyFooter(), "Privacy Policy");

		if (actualURL.trim().equalsIgnoreCase(ConfigReader.getValue("PrivacyPolicyURL"))) {
			return true;
		}
		return false;
	}


	// @Step("Clicks on Contact link in the footer after checking its presence")
	public boolean clickOnPolicyFooter() {
		//
		String actualURL = verifyURL(getPoliciesFooter(), "Policies");

		if (actualURL.trim().equalsIgnoreCase(ConfigReader.getValue("PoliciesURL"))) {
			return true;
		}
		return false;
	}


	/**
	 * This method is to verify that "Copyright/Permissions" link is displayed and
	 * navigates to the correct link
	 *
	 * @return True/false based on the link.
	 */
	//@Step("Clicks on Copyright/Permissions link in the footer after checking its presence") //Delete
	public boolean clickOnCopyright_Permission() {
		try {
			String actualURL = verifyURL(getCopyright_Permissions(),
					"Copyright and Permissions");

			if (actualURL.trim().equalsIgnoreCase(ConfigReader.getValue("CopyRightsURL").trim()))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}


	/**
	 * This method is to check whether social media icons are visible or not
	 *
	 * @return True/False True in one condition if all elements are visible
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
	 *
	 * @return True/false on basis on verification
	 */
	public boolean clickOnTwitter() {
		try {
			String actualURL = verifyURL(getTwitterLink(), "ASTM International (@ASTMIntl) / Twitter");
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
	 *
	 * @return True/false on basis on verification
	 */

	public boolean clickOnFacebook() {
		try {
			String actualURL = verifyURL(getFacebookLink(), "ASTM International - Home | Facebook");
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

	/**
	 * This method will click on youtube link & verify its url
	 *
	 * @return True/false on basis on verification
	 */
	public boolean clickOnYoutube() {
		try {
			String actualURL = verifyURL(getYoutubeLink(), "ASTMIntl - YouTube");
			String expectedUrl = ConfigReader.getValue("youtube");
			if (expectedUrl.contains(actualURL))
			// if(actualURL.trim().contains(ConfigReader.getValue("youtube")))
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
	public boolean clickOnLinkedIn() {
		try {
			String actualURL = verifyURL(getLinkedLink(), "Sign Up | LinkedIn");
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
	public boolean clickOnInstagram() {

		try {
			String actualURL = verifyURL(getInstagramLink(),
					"https://www.instagram.com/accounts/login/");
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
	public boolean clickOnRSSLink() {
		try {
			String actualURL = verifyURL(getRSSLink(), "ASTM International - Available RSS Feeds");
			if (actualURL.trim().contains(ConfigReader.getValue("rsslink"))) {
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
	public boolean clickOnContactFooter() {
		try {
			String actualURL = verifyURL(getRSSLink(), "ASTM International - Available RSS Feeds");
			if (actualURL.trim().contains(ConfigReader.getValue("rsslink"))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * This method checks if the "Help drop-down" is displayed
	 *
	 * @return True/False based on presence of "Help Drop-down"
	 */
//	@Step("The user should be able to view a Help dropdown")
	public boolean helpDropDownIsDisplayed() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(helpDropdown));
			boolean value = isWebElementDisplayed(helpDropdown);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method clicks on user name that is visible on top right
	 *
	 * @return
	 */
	@Step("Click on Dropdown of the Help ")
	public boolean ClickOnHelpDropDown() {
		try {
			boolean uName = isWebElementDisplayed(helpDropdown);
			getHelpDropdown().click();
			return uName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks if the "SupportandFAQs" is displayed
	 *
	 * @return True/False based on presence of "SupportandFAQ"
	 */
	@Step("Check that the user is able to view \"Support and FAQs\" option in the Help drop down.")
	public boolean faqDisplayed() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getHelpDropdown(), 10);
		try {
			ClickOnHelpDropDown();
			boolean value = isWebElementDisplayed(supportFAQs);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks if the "User Training Videos" is displayed
	 *
	 * @return True/False based on presence of "User Training Videos"
	 */
	@Step("Check that the user is able to view \"User Training Videos\" option in the Help drop down.")
	public boolean userTrainingVideosDisplayed() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getHelpDropdown(), 10);
		try {
			ClickOnHelpDropDown();
			boolean value = isWebElementDisplayed(training);
			return value;
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
//	@Step("the individual user should be able to view International ASTM logo")
	public boolean verifyInternationalASTM() {
		try {
			ReusableMethods.scrollIntoView(getASTMLogo(), driver);
			boolean astmLOGO = isWebElementDisplayed(internationalASTM);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return astmLOGO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method returns my astm option is visible on the page
	 *
	 * @return
	 */
	@Step("MYASTM Present on Screen")
	public boolean VerifyMyASTMOption() {
		try {
			boolean myASTM = isWebElementDisplayed(myASTMOption);
			return myASTM;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will click on my astm option in menu and redirected to same
	 *
	 * @return True/False on URL matched or not
	 */
	// @Step("Click on My ASTM under User Name dropdown and Check that the user is
	// redirected to the MyASTM page")
	public boolean VerifyMyASTMPageURL() {

		try {
			waitforInvisibilityAndElementToClickable(getUsernameDropdown());
			getUsernameDropdown().click();
			getMyASTM().click();
			if (ConfigReader.getValue("MYASTMPageURL").trim()
					.equalsIgnoreCase(verifyURL(getMyASTMURL(), "ASTM International - Login"))) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean clickOnMenuIcon() {
		boolean value = false;
		try {
			waitforInvisibilityAndElementToClickable(getmenu());
			value = clickonWebElement(menu, "Unable to click on menu");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public void moveTOElement(WebElement ele) {
		action.moveToElement(ele).build().perform();
	}

	public boolean moveTOElementAndClick(WebElement ele) {
		boolean value = false;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(getmaskclass()), ExpectedConditions.elementToBeClickable(ele)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ele.isDisplayed() == true) {
			action.moveToElement(ele).click().build().perform();
			value = true;
		}

		return value;

	}

	public boolean moveTOElementAndClick_Mobile(WebElement ele) {
		boolean value = false;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(getmaskclass()), ExpectedConditions.elementToBeClickable(ele)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ele.isDisplayed() == true) {
			action.moveToElement(ele).click().build().perform();
			value = true;
		}

		return value;

	}

	public void waitforInvisibilityAndElementToClickable(WebElement element) {
		//new WebDriverWait(driver,10).until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(getmaskclass()),ExpectedConditions.elementToBeClickable(element)));

	}


	//@Step("Click on the Recently Accessed Document")
	public boolean ClickRecentlyAccessedTilesHTML() {


		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();

		boolean result = false;
		for (int i = 0; i < size; i++) {
			getRecentlyAccessedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
			if (isWebElementDisplayed(HTML) == false) {
				getmenu().click();
				getElement(MenuHome).click();
			}

			if (isWebElementDisplayed(HTML) == true) {
				result = true;
				break;
			}


		}
		return result;


	}

	public boolean ClickRecentlyAccessedTilesASTM() {
		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getrecentlyAccessedASTMStandard().size();

		boolean result = false;
		for (int i = 0; i < size; i++) {
			getRecentlyAccessedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 45);
			if (isWebElementDisplayed(OtherVersions) == false) {
				getmenu().click();
				getElement(MenuHome).click();
			}

			if (isWebElementDisplayed(OtherVersions) == true) {
				result = true;
				break;
			}
		}
		return result;
	}

	public boolean ClickRecentlyAccessedTilesAPI() {
		ReusableMethods.scrollIntoView(getrecentlyAccessedAPIStandard().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();

		boolean result = false;
		for (int i = 0; i < size; i++) {
			getrecentlyAccessedAPIStandard().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
			if (isWebElementDisplayed(OtherVersions) == false) {
				getmenu().click();
				getElement(MenuHome).click();
			}

			if (isWebElementDisplayed(OtherVersions) == true) {
				result = true;
				break;
			}
		}
		return result;
	}


	//@Step("Click on the Recently Accessed Document")
	public boolean ClickRecentlyAccessedTilesPDF() {

		WaitStatementUtils.waitForElementToBeClickable(driver, getRecentlyAccessedTab(), 25);
		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();

		boolean result = false;
		for (int i = 0; i <= size; i++) {
			getRecentlyAccessedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
			if (isWebElementDisplayed(OtherVersions) == false) {
				getmenu().click();
				getElement(MenuHome).click();
			}

			if (isWebElementDisplayed(OtherVersions) == true) {

				result = true;
				break;
			}


		}
		return result;


	}

	//@Step("Click on the Recently Accessed Document")
	public boolean ClickRecentlyAccessedTilesPDFAPI() {

		WaitStatementUtils.waitForElementToBeClickable(driver, getRecentlyUpdatedTab(), 25);
		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContentAPI().get(0), driver);
		int size = getRecentlyAccessedCardContentAPI().size();

		boolean result = false;
		for (int i = 0; i <= size; i++) {
			getRecentlyAccessedCardContentAPI().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
			if (isWebElementDisplayed(OtherVersions) == false) {
				getmenu().click();
				getElement(MenuHome).click();
			}

			if (isWebElementDisplayed(OtherVersions) == true) {

				result = true;
				break;
			}


		}
		return result;


	}

	//@Step("Click on the Recently Accessed Document")
	public boolean ClickRecentlyUpdatedTilesPDF() {

		WaitStatementUtils.waitForElementToBeClickable(driver, getRecentlyUpdatedTab(), 25);
		ReusableMethods.scrollIntoView(getRecentlyUpdatedCardContent().get(0), driver);
		int size = getRecentlyUpdatedCardContent().size();

		boolean result = false;
		for (int i = 0; i <= size; i++) {
			getRecentlyUpdatedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
			if (isWebElementDisplayed(OtherVersions) == false) {
				getmenu().click();
				getElement(MenuHome).click();
			}

			if (isWebElementDisplayed(OtherVersions) == true) {
				getPDF().click();
				WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
				result = true;
				break;
			}


		}
		return result;


	}

	//This method checks if the document has PDF versions to compare and naviagtes to the compare page
	public void ClickDownloadRedlineVersion() {

		WaitStatementUtils.waitForElementToBeClickable(driver, getRecentlyAccessedTab(), 30);
		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();

		for (int i = 0; i <= size; i++) {
			getRecentlyAccessedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 40);
			if (isWebElementDisplayed(PDF) == true) {
				//if(isWebElementDisplayed(versionComparison)==true) {
				getCompareVersions().click();
				checkSelectedCheckbox();
				redirectToCompare();
				break;
			}
		}
	}

	//This method checks if the document has PDF versions to compare and navigates to the compare page
	public boolean ClickDownloadRedlineVersion_recentlyUpdated() {
		boolean result = false;
		WaitStatementUtils.waitForElementToBeClickable(driver, getRecentlyUpdatedTab(), 30);
		ReusableMethods.scrollIntoView(getRecentlyUpdatedCardContent().get(0), driver);
		int size = getRecentlyUpdatedCardContent().size();

		for (int i = 0; i <= size; i++) {
			getRecentlyUpdatedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 40);

			if (isWebElementDisplayed(OtherVersions) == false) {
				getmenu().click();
				getElement(MenuHome).click();
			}

			if (isWebElementDisplayed(OtherVersions) == true) {
				getCompareVersions().click();
				checkSelectedCheckbox();
				redirectToCompare();
				result = true;
				break;
			}


		}
		return result;

	}


	//This method clicks on compare button and opens the comparison screen
	public void redirectToCompare() {
		getCompareButton().click();
		verifyVisbility("Close Compare", CloseCompareButton, "Close Comparison button is not displayed");
	}


	@Step("Verify the Visibility of {Element}")
	public void verifyVisbility(String Element, By locator, String message) {
		try {
			Assert.assertTrue(isWebElementDisplayed(locator), message);
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify the visibility of element", e);
		}
	}


	/**
	 * This method will check if HTML is the default active tab
	 *
	 * @return True/False
	 */

	public boolean checkActiveTab() {
		try {

			String expectedClass = "tab active astm-type-heading--h6";
			String actualClass = getHTMLActive().getAttribute("class");
			if (actualClass.trim().equalsIgnoreCase(expectedClass)) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will navigate to Recently Accessed and validate that the correct page is loaded
	 *
	 * @return True/False
	 */
	public boolean ViewHomepage() {
		try {
			boolean flag = false;
			WaitStatementUtils.waitForElementToBeClickable(driver, getASTMlogo(), 20);
			getASTMlogo().click();
			ClickRecentlyAccessedTiles();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 20);
			if (isWebElementDisplayed(HTML) == true) {
				return flag;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}


	public void ClickViewAllTracked() {

		getTrackerTab().click();
		//WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ViewAllTracked), 10);
		getViewAllTracked().click();
	}

	//@Step("Click on the Recently Updated Document")
	public boolean ClickRecentlyUpdatedTilesHTML() {

		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();

		boolean result = false;
		for (int i = 0; i <= size; i++) {
			getRecentlyAccessedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
			if (isWebElementDisplayed(HTML) == true) {
				result = true;
				break;
			}

		}
		return result;


	}


	public boolean checkSelectedCheckbox2() {
		boolean selected = false;
		int selectedCount = 0;
		int notSelectedCount = 0;
		List<String> checkboxResultList = new ArrayList<String>();
		int size = getTrackCheckbox().size();
		for (int i = 0; i <= size; i++) {
			if (getTrackCheckbox().get(i).isSelected())
				checkboxResultList.add("true");
			else
				checkboxResultList.add("false");


			for (String val : checkboxResultList) {
				if (val == "true")
					selectedCount++;


				else
					notSelectedCount++;
			}
		}

		if (selectedCount == 1)
			return true;
		else
			return false;

	}

	/**
	 * Method used to click on Second Check box after opening Compare Versions PopUp
	 *
	 * @return
	 */
	public boolean checkSelectedCheckbox() {
		List<WebElement> checkBoxList = getCompareModalCheckbox();
		String idOfSecondCheckBox = checkBoxList.get(1).getAttribute("id");
		WaitStatementUtils.explicitWaitForVisibility(driver, getCompareButton(), 25);
		try {
			if (driver.findElement(By.id(idOfSecondCheckBox)).isSelected() == false) {
				action.moveToElement(getElement(By.xpath("//label[@for='" + idOfSecondCheckBox + "']"))).click().build().perform();
				WaitStatementUtils.explicitWaitForVisibility(driver, getCompareButton(), 25);
			}
		} catch (Exception e) {


		}


		if (driver.findElement(By.id(idOfSecondCheckBox)).isSelected() == true)
			return true;
		else
			return false;
	}

	/**
	 * Method used to click on Second Check box after opening Compare Versions PopUp
	 *
	 * @return
	 */
	public boolean checkSelectedCheckboxdouble() {
		List<WebElement> checkBoxList = getCompareModalCheckbox();
		String idOfSecondCheckBox = checkBoxList.get(1).getAttribute("id");
		WaitStatementUtils.explicitWaitForVisibility(driver, getCompareButton(), 25);
		try {
			if (driver.findElement(By.id(idOfSecondCheckBox)).isSelected() == false) {
				action.moveToElement(getElement(By.xpath("//label[@for='" + idOfSecondCheckBox + "']"))).click().build().perform();
				String idOfthirdCheckBox = checkBoxList.get(2).getAttribute("id");
				action.moveToElement(getElement(By.xpath("//label[@for='" + idOfthirdCheckBox + "']"))).click().build().perform();
				WaitStatementUtils.explicitWaitForVisibility(driver, getCompareButton(), 25);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (driver.findElement(By.id(idOfSecondCheckBox)).isSelected() == true)
			return true;
		else
			return false;
	}

	public void checkCompareVersions(int index) {
		List<WebElement> checkBoxList = getCompareModalCheckbox();
		String idOfCheckBox = checkBoxList.get(index).getAttribute("id");
		WaitStatementUtils.explicitWaitForVisibility(driver, getCompareButton(), 25);
		try {
			if (driver.findElement(By.id(idOfCheckBox)).isSelected() == false) {
				action.moveToElement(getElement(By.xpath("//label[@for='" + idOfCheckBox + "']"))).click().build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * Method used to check third  Check box after opening Compare Versions PopUp
	 *
	 * @return
	 */
	public boolean checkDisabledCheckbox() {
		List<WebElement> checkBoxList = getCompareModalCheckbox();
		String idOfThirdCheckBox = checkBoxList.get(2).getAttribute("id");
		WebElement checkbox = driver.findElement(By.id(idOfThirdCheckBox));

		if (checkbox.isDisplayed() == true) {

			return driver.findElement(By.id(idOfThirdCheckBox)).isEnabled();
		}


		if (checkbox.isDisplayed() == false) {
			return true;
		}

		return driver.findElement(By.id(idOfThirdCheckBox)).isEnabled();
	}


	public boolean checkActiveTabHomepage() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getTrackerTab(), 45);

			getTrackerTab().click();

			String actualClass = getTrackerTab().getAttribute("class");
			String expectedClass = "tab active astm-type-heading--h6";
			if (actualClass.trim().equalsIgnoreCase(expectedClass)) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;


	}

	public boolean checkTrackToggle(String value) {


		WebElement a = driver.findElement(By.xpath("//tbody[@class='desktop-hide-style']//a[contains(@href," + value + ")]//ancestor::tr[@class='astm-table-tr']//input"));

//	a.click();
		if (a.isSelected())
			return true;
		else
			return false;

	}

	public boolean checkTrackToggleSmoke() {


		WebElement a = driver.findElement(By.xpath("//tbody[@class='mobile-hide-style']//a[@title='Delete']"));
		WaitStatementUtils.waitForElementToBeClickable(driver, a, 60);
		WaitStatementUtils.waitForElementToBeClickable(driver, a, 60);
//	a.click();
		if (a.isDisplayed() == true)
			return true;
		else
			return false;

	}

	public void ToggleTrack(String value) {
		WebElement a = driver.findElement(By.xpath("//tbody[@class='desktop-hide-style']//a[contains(@href," + value + ")]//ancestor::tr[@class='astm-table-tr']//input"));
		String CheckboxID = a.getAttribute("id");
		action.moveToElement(driver.findElement(By.xpath("//div[@class='custom-control astm-custom-switch custom-switch']//input[@id='" + CheckboxID + "']"))).click().build().perform();

	}


	public String docIdentification() {

		String href = getTrackerTiles().get(0).getAttribute("href");
		String trackedDoc = href.substring(href.length() - 6);
		return trackedDoc;
	}

	public boolean defaultValueInDropDown() {

		return isWebElementDisplayed(searchDropdownAll);

	}

	public void verifyAnchorLinkOnText(String text) {
		Boolean elementIsHyperlink = driver.findElements((By.linkText(text))).size() > 0;
		assertFalse(elementIsHyperlink, "Link is there");
	}

	public boolean checkDocuments() {
		//WaitStatementUtils.explicitWaitForVisibility(driver,getRecentlyAccessedTab(), 20);
		ReusableMethods.scrollIntoView(getRecentlyAccessedCardContent().get(0), driver);
		int size = getRecentlyAccessedCardContent().size();

		boolean result = false;
		for (int i = 0; i <= size; i++) {
			getRecentlyAccessedCardContent().get(i).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getDownload(), 25);
			if (isWebElementDisplayed(HTML) == true) {
				checkFavorites();
				checkTracking();
				Assert.assertTrue(isWebElementDisplayed(Download), "\"Download\" is not displayed. ");
				Assert.assertTrue(isWebElementDisplayed(CompareVersions), "\"Download\" is not displayed. ");
				Assert.assertTrue(isWebElementDisplayed(HTML), "\"HTML Tab\" is not displayed");
				Assert.assertTrue(isWebElementDisplayed(PDF), "\"PDF Tab\" is not displayed");
				result = true;
				break;
			}

		}

		return result;
	}

	public void checkFavorites() {

		WaitStatementUtils.waitForElementToBeClickable(driver, getCompareVersions(), 25);

		try {
			if (getElement(RemoveFavorites).isDisplayed() == true) {
				getElement(RemoveFavorites).click();
			}
		} catch (Exception exception) {

		}


		WaitStatementUtils.waitForElementToBeClickable(driver, getCompareVersions(), 25);
		Assert.assertTrue(isWebElementDisplayed(AddToFavorites), "\"Add to Favorites\" is not displayed. ");

	}

	public void checkTracking() {
		try {
			if (getElement(UntrackDocument).isDisplayed() == true) {
				getElement(UntrackDocument).click();
			}
		} catch (Exception exception) {

		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getCompareVersions(), 25);
		Assert.assertTrue(isWebElementDisplayed(TrackDocument), "\"Track Document\" is not displayed");
	}

	public void setupForTracker() {


		try {
			if (getElement(TrackDocument).isDisplayed() == true) {
				getElement(TrackDocument).click();
			}
		} catch (Exception exception) {

		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getCompareVersions(), 25);
		Assert.assertTrue(isWebElementDisplayed(UntrackDocument), "\"Untrack Document\" is not displayed");
	}

	public void setupForFavorites() {


		try {
			if (getElement(AddToFavorites).isDisplayed() == true) {
				getElement(AddToFavorites).click();
			}
		} catch (Exception exception) {

		}
		WaitStatementUtils.waitForElementToBeClickable(driver, getCompareVersions(), 25);
		Assert.assertTrue(isWebElementDisplayed(UntrackDocument), "\"Untrack Document\" is not displayed");
	}

	public boolean getfavorites() {
		String tabName = getHomepageTabs().getText();

		Boolean flag = tabName.contains("Favorites");
		return flag;
	}

	public void ClickTranslatedVersion() {


		ReusableMethods.scrollIntoView(getTranslatedVersion().get(0), driver);
		int size = getTranslatedVersion().size();
		if (size != 0)


			getTranslatedVersion().get(0).click();

	}

	public boolean checkCountofFavorites() {
		boolean flag = false;
		int size = getRecentlyUpdatedCardContent().size();
		if (size <= 6) {
			flag = true;
			return flag;
		}
		return flag;
	}

	public boolean checkCountofVideos() {
		boolean flag = false;
		int size = getVideos().size();
		if (size > 0) {
			flag = true;
			return flag;
		}
		return flag;
	}

	public void ViewNavBarOptions() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getmenu(), 45);
		new Actions(driver).click(getmenu()).build().perform();
	}

	/**
	 * @return true/false value Gets successful login details
	 */
	public boolean VerifyLoginSuccesJWT() {
		try {

			WaitStatementUtils.waitForElementToBeClickable(driver, getWelcomeMessage(), 45);
			wait.until(ExpectedConditions.visibilityOf(getWelcomeMessage()));
			boolean value = getWelcomeMessage().isDisplayed();

			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


	public void selectRelatedContentLink() {
		int size = getRelatedLinks().size();
		if (size > 0) {
			getRelatedLinks().get(0).click();
		}

	}

	/*
	 * This method will search for a document and launch it in the document page
	 */
	@Step("Search for the document with translated versions")
	public void searchDoc(String searchString) {
		try {

			getSearch().sendKeys(searchString);
			WaitStatementUtils.waitForElementToBeClickable(driver, getMagnifyingGlass(), 30);
			getMagnifyingGlass().click();

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(serpFirstDocument));
			getElement(serpFirstDocument).click();

		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to launch document page", e);
		}
	}


	@Step("Verify whether custom collection links are present ")
	public boolean checkCustomCollectionLinks() {
		boolean flag = false;
		try {

			if (getListCustomCollections().size() > 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify custom collection link", e);
		}
		return flag;
	}

	@Step("Verify whether custom collection links navigate to the {docstat} version ")
	public boolean checkCustomCollectionNavigationToDOcumentPage(String docstat) {
		boolean flag = false;
		try {
			getListCustomCollections().get(0).click();
			WaitStatementUtils.explicitWaitForVisibility(driver, getDownload(), 30);
			String status = getDocumentStatus().getText().toString();
			if (status.equalsIgnoreCase(docstat)) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify custom collection link", e);
		}
		return flag;
	}

	@Step("Verify whether the user is able to click on Custom Collections link")
	public String clickOnCustomCollection() {
		String document = getListCustomCollections().get(0).getText().toString();
		try {
			getListCustomCollections().get(0).click();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on custom collection link", e);
		}
		return document;
	}


	@Step("Verify whether custom collection links navigate to the {docstat} version ")
	public boolean checkCustomCollectionDesignation(String docstat, String document) {
		boolean flag = false;
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getDownload(), 30);
			String status = getDocumentStatus().getText().toString();
			String designation = getdocumentDesignation().getText();

			if (status.equalsIgnoreCase(docstat))
				if (document.contains(designation)) {
					flag = true;
				}

		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify custom collection link", e);
		}
		return flag;
	}

	public boolean verifyWohlersReport(String expected) {
		boolean flag = false;
		String actual;
		WebElement fav = driver.findElement(By.xpath("//span[contains(text(),'Book')]/ancestor::div[@class='card-adjust astm-card astm-card--raised astm-card--link astm-card card']//span[(text()='"+expected+"')]"));
		ReusableMethods.scrollIntoView(fav,driver);
		flag = fav.isDisplayed();
		return flag;
	}

	public void verifyViewUser(String user){
		WebElement getUser = driver.findElement(By.xpath("//td[@title='"+user+"']/parent::tr//span[contains(@id,'edit')]"));
		ReusableMethods.scrollIntoView(getUser,driver);
		getUser.click();
	}

	public By getPdfsearch() {
		return Pdfsearch;
	}

	public By getInputSearch() {
		return inputSearch;
	}

	public List<WebElement> getSearchPdfResult() {
		return driver.findElements(searchPdfResult);
	}

	public By getHTMLCompateDisclaimer() {
		return HTMLCompateDisclaimer;
	}

	public By getNavMenuTrackerLink() {
		return NavMenuTrackerLink;
	}

	public By getNavMenuSubscriptionsLink() {
		return NavMenuSubscriptionsLink;
	}

	public By getNavMenuUNELink() {
		return NavMenuUNELink;
	}

	public By getUNECheckBox() {
		return UNECheckBox;
	}

	public By getUnsubscribeBTN() {
		return UnsubscribeBTN;
	}

	public By getAlert() {
		return alert;
	}

	public By getSubmitBTN() {
		return submitBTN;
	}

	public By getSearchClose() {
		return searchClose;
	}


	public WebElement getAccountMenu(){
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AccountMenu),5);
		return getElement(AccountMenu);
	}

	public WebElement getMyAccountProfile(){
		return getElement(MyAccountProfile);
	}

	@Step("Click on Account menu and navigate to Personal Information tab")
	public void MyAccountMenuValidation(){
		try{
			PublicCommon.waitForSec(10);
			/*oneTrustCookieSelectCloseBtn();
			WaitStatementUtils.waitForLoaderToBeInvisible(driver);
			agreeAndContinueSelectAcceptBtn();
			WaitStatementUtils.waitForLoaderToBeInvisible(driver);*/
			getAccountMenu().click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getMyAccountProfile().click();
		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify My Account Menu", e);
		}
	}
	@Step("Switch Compass account to select another Account")
	public void switchAccount(){
		try{
			PublicAdminCommons.waitForSec(5000);
			if(WaitStatementUtils.explicitWaitForVisibility(driver, getAccountSelect(), 10)) {
				//Doing nothing if "Select An Account" screen is displayed. It will be handled in another method.
			}else if (WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AccountMenu), 30)) {
					new Actions(driver).click(getElement(AccountMenu)).build().perform();
					if (WaitStatementUtils.explicitWaitForVisibility(driver, getElement(SwitchAccount), 10)){
						new Actions(driver).click(getElement(SwitchAccount)).build().perform();
					}else{
						//if 'switch account' option is not available in account menu drop-down then
						// click account menu once again to close the account menu drop down
						new Actions(driver).click(getElement(AccountMenu)).build().perform();
					}

				}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify switch account", e);
		}
	}


	@Step("Select B2B Account")
	public void selectOrg(){
		if(WaitStatementUtils.explicitWaitForVisibility(driver, SelectUserwithUserManagement(), 10 )){
			SelectUserwithUserManagement().click();
		}
	}

	@Step("Verify User Management Tab under Account Menu in Compass")
	public void UserManagementSelect(){
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getAccountMenu());
			WaitStatementUtils.waitForElementStaleness(driver, getAccountMenu());
			WaitStatementUtils.waitForElementToBeClickable(driver, getAccountMenu());
			(new Actions(driver)).click(getAccountMenu()).click(getElement(UserManagement)).build().perform();
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to select User Management tab", e);
		}
	}

	public WebElement SelectUserwithUserManagement()
	{
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SelectB2Buser),15);
		return getElement(SelectB2Buser);
	}
	public WebElement UserManagementTab(){
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(UserManagement),10);
		return getElement(UserManagement);
	}

	@Step("Login to AWWA Tenant and verify Title")
	public void LoginAWWAtenant(){
		try{
			driver.get(ConfigReader.getValue("ASTMAWWA_STG"));
			driver.getTitle().equals("AWWA Login");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login AWWA Tenant", e);
		}
	}

	@Step("Login to IES Tenant and verify Title")
	public void LoginIEStenant(){
		try{
			driver.get(ConfigReader.getValue("ASTMIES_STG"));
			driver.getTitle().equals("IES Login");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login IES Tenant", e);
		}
	}

	@Step("Verify Logo and status code")
	public void VerifyLogoAndStatusCode(String url){
		try{
			VerifyLOGOPresent(getElement(LOGOIMG));
			verifyStatusCodeForURL(url);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Logo ", e);
		}
	}

	@Step("Verify custom message and functional links for AWWA Tenant")
	public void VerifyAWWACustomMessageAndFunctionalLinks(String url){
		try{
			VerifyLogoAndStatusCode(url);
			getElement(AWWApageCustomMessage).getText().equals("The document or page you are trying to access requires a current and valid AWWA membership and subscription. Please login with your AWWA account to confirm your access.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify custom message an functional links for AWWA Tenant", e);
		}
	}

	@Step("Verify custom message and functional links for IES Tenant")
	public void VerifyIESCustomMessageAndFunctionalLinks(String url){
		try{
			VerifyLogoAndStatusCode(url);
			getElement(IESpageCustomMessage).getText().equals("Please log into your IES account to access");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify custom message an functional links for IES Tenant", e);
		}
	}


	@Step("Verify Login With Your AWWA Connect Link isDisplayed")
	public void VerifyLoginWithYourAwwaConnectLinkisDisplayed() {
		if (getElement(LoginAWWAconnectLINK).isDisplayed() == true) {
			System.out.println("Yes link is present");
		} else {
			System.out.println("No link is not present");
		}
	}

	@Step("Verify AWWA Connect Link isDisplayed")
	public void VerifyContactSupportLINKisDisplayed() {
		if (getElement(ContactSupportLINK).isDisplayed() == true) {
			System.out.println("Yes link is present");
		} else {
			System.out.println("No link is not present");
		}
	}


	@Step("Verify Logo is Present")
	public void VerifyLOGOPresent(WebElement LOGO) {
		// Javascript executor to check image
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", LOGO);
		//verify if status is true
		if (p) {
			System.out.println("Logo present");
		} else {
			System.out.println("Logo not present");
		}
	}

	@Step("Verify status code for url '{url}'")
	public void verifyStatusCodeForURL(String url){
		int respCode = 0;
		try {
			HttpURLConnection huc = null;

			huc = (HttpURLConnection)(new URL(url).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();
			System.out.println(respCode);
			if(respCode >= 400){
				Assert.fail("Status code for the url is : " + respCode);
			}else{
				System.out.println(url+" is a valid link");
				System.out.println(respCode);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Step("Verify Email in Personal information details in Compass")
	public void VerifyEmailInPersonalInformationDetailsPage(String email){
		try{
			PublicCommon.waitForSec(30);
			switchToWindowByTitle(driver,"ASTM");
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(PersonalInformationHeader),180);
			assertEquals(getElement(PersonalInformationHeader).getText(),"Personal Information");
			getElement(EmailInPersonalInfoPage).getText().equals(email);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify personal information details", e);
		}
	}

	@Step("Click on eLearning link")
	public void clickOnElearningLink(String title){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(Elearning),5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElearning().click();
			PublicCommon.waitForSec(40);
			Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver, 1),"Unable to switch to other tab");
		} catch (Exception e) {
		e.printStackTrace();
		PublicCommon.reportFailAssert("Failed to click on eLearning link", e);
	  }
	}
	@Step("Check the ASTM Tiles are present")
	public void checkAssetType() {
		try {
			WaitStatementUtils.waitForElementStaleness(driver,getElement(menu),15);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(menu),15);
			ViewNavBarOptions();
			clickonmethod("Home",MenuHome,"Home should be clickable");
			verifyVisbility("Welcome Message",welcomeBackHeader, "The system should navigate to the Home page");
			WaitStatementUtils.explicitWaitForVisibility(driver,getSubTab(), 45);
			clickonmethod("Subscription", subscriptionTab, "User should be able to click on Subscription tab");
			ReusableMethods.scrollIntoView(getMagnifyingGlass(), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickonmethod("ASTM", ASTMtile, "User should be able to click on ASTM");
			WaitStatementUtils.waitForElementToBeClickable(driver, getmagnifyingGlassSub(), 40);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify the Asset ", e);
		}
	}
	@Step("Sign Out from compass")
	public void signOutFromCompass() {
		try {
			getUsernameDropdown().click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(Signout),10);
			getElement(Signout).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Sign Out from compass");
		}
	}

	@Step("Click on {elementName}")
	public void clickOnMethod(String elementName,By locator,String assertionMessage)
	{
		try {
			assertTrue(clickonWebElement(locator,assertionMessage));
		} catch (Exception e) {

			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on element", e);
		}
	}
	public void selectASTMPublisherType() {
		try {
			oneTrustCookieSelectCloseBtn();
			if(WaitStatementUtils.explicitWaitForVisibility(driver,getElement(closeBtnOfAIpopup),10))
				ReusableMethods.clickOnWE(driver,"AI ribbon - close button",closeBtnOfAIpopup,"Failed to click on Close button of AI popup");
			PublicCommon.waitForSec(2);
//			ReusableMethods.scrollIntoView(getElement(welcomeBackHeader),driver);
			verifyVisbility("Welcome Message", welcomeBackHeader, "The system should navigate to the Home page");
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(subscriptionTab),20);
			clickOnMethod("Subscription", subscriptionTab, "User failed to click on Subscription tab");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			ReusableMethods.scrollIntoView(getElement(subscriptionTab),driver);
			PublicCommon.waitForSec(2);
			clickOnMethod("ASTM", ASTMtile, "User should be able to click on ASTM");
			WaitStatementUtils.waitForElementToBeClickable(driver, getmagnifyingGlassSub(), 5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(15);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify the ASTM Asset ", e);
		}
	}

	public void oneTrustCookieSelectCloseBtn(){
		if(checkElementPresent(cookieCloseButton)){
			getElement(cookieCloseButton).click();
			log.info("Clicked on OneTrust cookie close button");
		}
	}

	public void agreeAndContinueSelectAcceptBtn(){
		if(checkElementPresent(agreeAndContinue)){
			getElement(agreeAndContinue).click();
			log.info("Clicked on agree & continue");
		}
	}

	public void selectSignInRegisterButtonIfVisible(){
		if(checkElementPresent(SignInNew)){
			WaitStatementUtils.waitForLoaderToBeInvisible(driver);
			getElement(SignInNew).click();
			log.info("Clicked on SignIn / Register button in compass");
		}
	}
}


	


					  
 
 



 
	
	
	
		




	