package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;

import com.astm.commonFunctions.SpecBuilderCommon;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MAEIntegrationPage extends BasePage {

	/**
	 * Parameterized constructor
	 * 
	 * @param driver
	 */
	public MAEIntegrationPage(WebDriver driver) {
		super(driver);
	}
	public By selectASTMAccountName = By.xpath("//span[text()='ASTM']//following-sibling::input");
    public By userManagementDraftTab = By.xpath("//span[text()='User Management (Draft)']");
    public By viewEditButton = By.xpath("//td[@class='row-actions']//span[2]");
    public By b2bOrgAdminCheckbox = By.xpath("//div[text()='B2B Org Admin']//input");
	private By compassUserName = By.id("userName");
    private By compassPassword = By.id("password");
	private By compassSignInButton = By.xpath("//button[@type='submit' and contains(text(), 'Sign In')]");
	private By viewDraftTenantsBtn=By.xpath("//button[text()='View Draft Tenants']");
	private By ViewDraftTenantsHeading  =By.xpath("//h3[text()='View Draft Tenants']") ;

	private By ViewDraftTenantsTable  =By.xpath("//table[@id='draft-tenants-list']") ;

	public By selectAnAccountHeader = By.xpath("//*[text()='Select an Account']");
	public By tenantStatusUnderManageTenants(String tenantName){
		return By.xpath("//td[@class='max_text' and text()='"+tenantName+"']/following-sibling::td/span[contains(@class,'badge')]");
	}
	public By tenantStatusUnderManageTenants1(String tenantName){
		return By.xpath("//td[@class=' ' and text()='"+tenantName+"']/following-sibling::td/span[contains(@class,'badge')]");
	}
	public By Signoutdropdown= By.xpath("//div[@class='user-nav-menu']/li/a[2]/span");
	public By SignoutBtn=By.xpath("//a[@class='dropdown-item logout-btn']");
	public By createButton = By.xpath("//button[contains(text(),'Create New Group')]");
	public By selectButtonASTM = By.xpath("//*[text()='ASTM']//following-sibling::input");
	public By selectTypes = By.xpath("//select[@id='types']");
	public By searchfield = By.xpath("//div[contains(@class,'search-content')]//input");
	public By srchIcon=By.xpath("//button[@class='search-button']");

	public By searchIcon = By.xpath("//button[contains(@class,'search-button')]");
	public By addUser =By.xpath("//button[contains(@class,'add-user')]");
	public By compassUserCheckbox = By.xpath("//div[text()='Compass User']/input");
	public By compassUserAdministratorCheckbox = By.xpath("//div[text()='Compass User Administrator']/input");
	public By compassUserAdministratorCheckbox_Checked = By.xpath("//div[text()='Compass User Administrator']//input[@checked]");

	public By userAdminCheckbox = By.xpath("//div[text()='User Admin']/input");
	public By userAdminCheckbox_Checked = By.xpath("//div[text()='User Admin']/input[@checked]");

	public By accountList = By.xpath("//table[@id='datatable']//tbody//tr");
	public By accountList1 = By.xpath("//table[@id='datatable']//tbody//tr[1]/td[2]");


	public By userMangementRole = By.xpath("//span[text()='User Management']");
	public By AccessManagement = By.xpath("//span[text()='Access Management']");
	public By AccountAdministration = By.xpath("//span[text()='Account Administration']");
	public By AccountAcronymUpdate = By.xpath("//div[@class='form-group']/input[@data-testid='acroynm-selecter']");
	public By specbuilderTab = By.xpath("//span[text()='SpecBuilder']");
	public By SpecBuilderEntitlementsLabel = By.xpath("//div[@id='spec-builder-account']/h3");
	public By CompanyLOGOredirectURLtext = By.xpath("//div[text()='Company Logo Redirect URL']/../input");
	public By ReportTab = By.xpath("//span[text()='Reports']");
	public By UsageReport = By.xpath("//span[text()='Usage Report']");
	public By UserReport = By.xpath("//span[text()='User Reports']");
	public By SubscriptionUsage = By.xpath("//span[text()='Subscription Usage']");
	public By JWTTestLoginToggleBtn = By.xpath("(//h4[@id='jwtTestLogin']/following-sibling::div/span)[1]");
	public By AuthVerificationLabel = By.cssSelector("div.tab_content > div > div:nth-child(3) > span");
	public By AuthVerificationToggle = By.cssSelector("div.tab_content > div > div:nth-child(3) > svg");
	public By JWTLabel = By.xpath("(//h4[@id='jwtEnabled']/following-sibling::div/span)[1]");
	public By JWTToggle = By.xpath("(//h4[@id='jwtEnabled']/following-sibling::div/i)[1]");
	public By userNamePasswordLoginLabel = By.xpath("//span[text()='UserName & Password Login']/../div/label");
	public By userNamePasswordLoginToggle = By.xpath("//span[text()='UserName & Password Login']/following-sibling::div/i");
	public By compassPointLabel = By.xpath("//span[text()='Compass Points']/../div/label");
	public By compassPointToggle = By.cssSelector("div:nth-child(4) > ul > li:nth-child(4) > div > svg");
	public By compassPointToggle1 = By.xpath("//span[text()='Compass Points']/following-sibling::div/i");
	public By groupsPointLabel = By.xpath("//span[text()='Groups']/../div/label");
	public By groupsPointToggle = By.xpath("//span[text()='Groups']/following-sibling::div/i");

	public By IpaccessCheckbox = By.cssSelector("#ipEnabled");
	public By AppletAccess = By.cssSelector("#appletEnabled");
	public By AllowAnonymousOrgAuth = By.cssSelector("#anonymousOrgAuthEnabled");
	public By EnforceIPAppletWhitelisting = By.cssSelector("#enforceWhiteListing");
	public By CompassTab = By.xpath("//span[text()='Compass']");
	public By JWTloginBTN = By.xpath("//button[text()='JWT Login']");
	public By JWTloginheader = By.xpath("//h5[text()='JWT Login']");
	public By loginBtn = By.xpath("//button[text()='Login']");
	public By AccountUserStatus = By.xpath("//table[contains(@class,'table dataTable')]/thead/tr/th[text()='Account User Status']/../../../tbody/tr/td[@title='Active']/span");
	public By OKTAactivationStatus = By.xpath("//table[contains(@class,'table dataTable')]/thead/tr/th[text()='OKTA Activation Status']/../../../tbody/tr/td[@title='ACTIVE']/span");
	public By OKTAactivationStatus_Staged = By.xpath("//table[contains(@class,'table dataTable')]/thead/tr/th[text()='OKTA Activation Status']/../../../tbody/tr/td[@title='STAGED']/span");
	public By addUserButton = By.xpath("//*[contains(text(),'Add User')]");
	
	public By emailField = By.xpath("//label[text()='Email']//following-sibling::input");
	public By firstName = By.xpath("//label[text()='First Name']//following-sibling::input");
	public By lastName = By.xpath("//label[text()='Last Name']//following-sibling::input");

//	public By saveBtn = By.xpath("//button[text()='Save']");

	public By saveBtn = By.xpath("//*[text()='Save']");

	public By dropdownButton = By.cssSelector("*[class*='indicatorContainer']");
	public By userAdministarionTab=By.xpath("//span[text()='User Administration']");
	public By accountDetailsTab=By.xpath("//span[text()='Account Details']");
	public By ebsAccountNumber=By.xpath("//span[text()='Account Number:']/../span[@class='astm-type-heading--h6 ml-1 text_color']");
	private By EBSOrderNoEntry=By.xpath("//input[@id='form-control-ebs']");
	public By organizationName=By.xpath("//span[text()='Name:']/../span[@class='astm-type-heading--h5 ml-1 text_color']");
	public By userManagementTab=By.xpath("//span[text()='User Management']");
	public By userManagementTab1=By.xpath("//span[text()='User Management']/parent::p");
	public By editBtn = By.xpath("//span[contains(@id,'edit')]");
	public By MAEuserIDvalue = By.xpath("//label[text()='MAE User ID']/following-sibling::input");

	public By specbuilderRole = By
			.xpath("//label[text()='SpecBuilder Role']/..//div[contains(@class,'ValueContainer')]");
	public By compassRole = By.xpath("//*[text()='Compass User']//.//input");
	public By selectSpecbuilderRole = By.xpath("//*[text()='Specbuilder User']/.//input");
	public By selectCompassRole = By.xpath("//*[text()='Compass User']//.//input");
	public By selectExternalSpecbuilderRole = By.xpath("//*[text()='Specbuilder External User']/.//input");
	public By status = By.xpath("//span[text()='Active']");
	public By close = By.xpath("(//span[text()='�'])[2]");
	private By ModelcloseBtn=By.xpath("//button[contains(text(),'Close')]");
	public By accountUserStatus = By.xpath("//th[text()='Account User Status']");
	public By oKTAActivationStatus = By.xpath("//th[text()='OKTA Activation Status']");
	public By ProductEntLink=By.xpath("//p[@class='tab astm-type-heading--h6']/span[contains(text(),'Product')]");
	public By AccessExpiresList = By.xpath("//th[text()='Access Expires']/../../../tbody/tr/td[@class='text-danger']");
	private By searchIcon1=By.xpath("//button[contains(@class,'search-btn')]");
	public By detailsIcon = By.xpath("//span[@class='action-icon'][1]");
	private By ASTMSelectBtn=By.xpath("//span[contains(text(),'ASTM')]/following-sibling::input");
	private By APISelectBtn = By.xpath("//span[contains(text(),'API')]/following-sibling::input");
	public By AWWASelectBtn = By.xpath("//span[contains(text(),'AWWA')]/following-sibling::input");

	private By DetailsIconModelContent=By.xpath("//div[@class='modal-content']/div/div");
	private By Roles=By.xpath("//input[@type='checkbox']");
	private By RolesText=By.xpath("//input[@type='checkbox']/parent::div");
	private By OKTAStatus=By.xpath("(//span[@class='badge bg-success'])[3]");
	private By searchboxUser=By.xpath("(//input[@name='search'])[2]");
	private  By seachBTN=By.xpath("(//input[@name='search'])[2]/following-sibling::button");
	public By astmLogo = By.cssSelector("img[src*='images/astm'].astm-logo");
	public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public By ViewUser = By.xpath("//h5[text()='View User']/../button/span");
	public By AppletAccessLabel = By.xpath("//h6[@id='toggler_appletAccess']");
	public By BuildRemoteLogin = By.xpath("//button[text()='Build Remote Login']");
	public By DownloadFile = By.xpath("//button[text()=' Download File']");
	public By MAEbtn = By.xpath("//input[@data-testid='MAE-button']");
	public By TIMSbtn = By.xpath("//input[@data-testid='TIMS-button']");
	public By manageTenantsHeader = By.xpath("//h3[text()='Manage Tenants']");
	public By tenantName = By.xpath("//table[@id='tenants-list']/../table/tbody/tr[1]/td[1]");
	public String TRow = "//td[text()='[TName]']/parent::tr";
	public By TenantInTenantdetailsPage = By.xpath("//div[@class='content-wrapper']/div/div/div/p[text()='Tenant:']/following-sibling::p");
	public By StockCodeForm = By.id("form-control-stock");
	public By SearchBtn = By.xpath("//button[contains(@class,'search-btn')]");
	public By stockCodeTable = By.xpath("//td[@class='sku_code']/div");
	public By GracePeriodDDN = By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[3]");
	public By getlistofGracePeriod = By.xpath("//div[@class=' css-11unzgr']/div");
	public By SaveBtn = By.xpath("//input[@value='Save']");
	public By AddAuditNoteLabel = By.xpath("//h5[text()='Add Audit Note']");
	public By textAreaNote = By.xpath("//textarea[@id='note-textarea']");
	public By AddNoteAndContinue = By.xpath("//button[text()='Add Note & Continue']");
	public By AuditTab = By.xpath("//span[text()='Audit']");
	public By VerifyAuditHistory = By.xpath("//div[@id='AuditDataIndex-0']/div[2]");
	public By RecentHistoryLabel = By.xpath("//h3[text()='Recent History']");
	public By userNameTxt = By.id("userName");
	public By passwordTxt = By.id("encPass");
	public By newSignInButton2 = By.xpath("//button[text()='Sign In']");
	public By CGAselectBtn = By.xpath("//span[contains(text(),'CGA')]/following-sibling::input");
	public By IESselectBtn = By.xpath("//span[contains(text(),'IES')]/following-sibling::input");
	public By IOPselectBtn = By.xpath("//span[contains(text(),'IOP1')]/following-sibling::input");
	public By CHECKselectBtn = By.xpath("//span[contains(text(),'CHECK')]/following-sibling::input");
	public By AENORselectBtn = By.xpath("//span[contains(text(),'AENOR')]/following-sibling::input");
	public By MenuBar = By.xpath("//span[@class='label label-menu']");
	public By SubscriptionUsageSummary = By.xpath("//a[text()='Subscription Usage Summary']");
	public By subscriptionsSettingTab=By.xpath("//span[text()='Subscription Settings']");
	public By publishersSubTab=By.xpath("//span[text()='Publishers']");
	public By lCASubTab=By.xpath("//span[text()='LCA']");
	public By assetsSubTab=By.xpath("(//span[text()='Assets'])[2]");
	public By publishersTablePagination=By.xpath("//div[@id='publisher-list_paginate']");
	public By nextBtn=By.xpath("//a[text()='Next']");
	public By publisherShowDD=By.xpath("//label[text()='Show ']/select");
	public By publishersTablePaginationTIMS=By.xpath("//ul[contains(@class,'pagination')]");
	public By publisherShowDDTIMS=By.xpath("//select[@id='page-size-select']");

	public By closeBtn = By.xpath("//h5[text()='View User']/../button/span");
	public By BulkUploadTab = By.xpath("//span[text()='Bulk Upload']");
	public By BulkUploadBtn = By.xpath("//button[text()='Bulk Upload']");
	public By BulkUploadPopUpHdr = By.xpath("//h5[text()='Bulk Upload']");
	public By chooseFile= By.name("bulk_file_upload");
	public By UploadFileBtn= By.xpath("//button[text()='Upload File']");
	public By successMessage= By.xpath("//span[contains(text(),'You will recieve an email once all users')]");
	public By errorMessage= By.xpath("//span[contains(text(),'Invalid file format')]");
	public By AddTenant = By.xpath("//button[text()='Add Tenant']");
	public By TenantDetailsHdr = By.xpath("//*[text()='Tenant Details']");
	public By General = By.xpath("//h5[text()='General']");
	public By TenantName= By.name("tenantName");
	public By TenantCode= By.name("tenantCode");
	public By supportEmail= By.name("support-email");
	public By supportWebPageUrl= By.name("supportWebPageUrl");
	public By TenantPhoneNo= By.xpath("//input[@class='form-control tenantPhoneNo']");
	public By TenantAddress= By.name("displayAddress");
	public By NextBtn = By.xpath("//button[contains(text(),'Next')]");
	public By ExitBtn = By.xpath("//button[text()=' Exit']");
	public By PreviousBtn = By.xpath("//button[text()=' Previous']");
	public By TenantNameErrorMsg1 = By.xpath("//p[text()='Tenant Name can only contain Alphabets, Numbers and Spaces']");
	public By TenantNameErrorMsg2 = By.xpath("//p[text()='Tenant Name must be at most 40 characters']");
	public By TenantCodeErrorMsg1 = By.xpath("//p[text()='Tenant Code can only contain alphabets and numbers.']");
	public By TenantCodeErrorMsg2 = By.xpath("//p[text()='Tenant Code must be at most 50 characters']");
	public By SupportEmailErrorMsg1 = By.xpath("//p[text()='Invalid email address']");
	public By SupportEmailErrorMsg2 = By.xpath("//p[text()='Support Email must be at most 320 characters']");
	public By SupportWebPageURLErrorMsg1 = By.xpath("//p[text()='Support Web Page URL must be a valid URL']");
	public By SupportWebPageURLErrorMsg2 = By.xpath("//p[text()='Support Web Page URL must be at most 255 characters']");
	public By SupportTenantAddressErrorMsg1 = By.xpath("//p[contains(text(),'Tenant Address can only contain alphabets, numbers, space')]");
	public By SupportTenantAddressErrorMsg2 = By.xpath("//p[text()='Tenant Address must be at most 255 characters']");
	public By AttentionPopup = By.xpath("//div[contains(text(),'Unsaved Progress will be lost')]");
	public By YesBtn = By.xpath("//button[text()='Yes']");
	public By NoBtn = By.xpath("//button[text()='No']");
	public By ListOfTenantName = By.xpath("//table[@id='draft-tenants-list']/tbody/tr/td[2]");
	public By ShowDropDown= By.name("draft-tenants-list_length");
	public By pageNumList= By.xpath("//span/a[contains(@class,'paginate')]");
	public By Home = By.xpath("//span[text()='Home']");
	public By Domain = By.xpath("//h5[text()='Domain']");
	public By RootDomain= By.name("domain");
	public By compassDomain= By.name("compassDomain");
	public By MAEDomain= By.name("maeDomain");
	public By centralLoginDomain= By.name("centralLoginDomain");
	public By OktaDomain= By.name("oktaDomain");
	public By RootDomainErrorMsg1 = By.xpath("//p[text()='Invalid root domain']");
	public By RootDomainErrorMsg2 = By.xpath("//p[text()='Root Domain must be at most 32 characters']");
	public By CompassDomainErrorMsg1 = By.xpath("//p[text()='Invalid compass domain']");
	public By CompassDomainErrorMsg2 = By.xpath("//p[text()='Compass Domain must be at most 32 characters']");
	public By MAEDomainErrorMsg1 = By.xpath("//p[text()='Invalid mae domain']");
	public By MAEDomainErrorMsg2 = By.xpath("//p[text()='Mae Domain must be at most 32 characters']");
	public By CentralLoginDomainErrorMsg1 = By.xpath("//p[text()='Invalid central login domain']");
	public By CentralLoginDomainErrorMsg2 = By.xpath("//p[text()='Central Login Domain must be at most 32 characters']");
	public By OktaDomainErrorMsg1 = By.xpath("//p[text()='Invalid okta domain']");
	public By OktaDomainErrorMsg2 = By.xpath("//p[text()='Okta Domain must be at most 32 characters']");
	public By NextPage = By.xpath("//a[text()='Next']");
	public By compassApplicationName= By.name("compassApplicationName");
	public By defaultLanguageForCompass= By.name("defaultLanguageForCompass");
	public By useDefaultUserMessages= By.name("useDefaultUserMessages");
	public By wistiaProjectID= By.name("wistiaProjectID");
	public By compassGroupEmailSenderName= By.name("compassGroupEmailSenderName");
	public By compassGroupSenderEmail= By.name("compassGroupSenderEmail");
	public By compassAppNameErrorMsg1 = By.xpath("//p[text()='Invalid compass application name']");
	public By compassAppNameErrorMsg2 = By.xpath("//p[text()='Compass Application Name must be at most 50 characters']");
	public By wistiaProjectIDErrorMsg1 = By.xpath("//p[text()='Invalid wistia project id']");
	public By wistiaProjectIDErrorMsg2 = By.xpath("//p[text()='Wistia Project ID must be at most 150 characters']");
	public By EmailSenderNameErrorMsg1 = By.xpath("//p[text()='Invalid compass group email sender name']");
	public By EmailSenderNameErrorMsg2 = By.xpath("//p[text()='Compass Group Email Sender Name must be at most 30 characters']");
	public By EmailSenderEmailErrorMsg1 = By.xpath("//p[text()='Invalid email address']");
	public By EmailSenderEmailErrorMsg2 = By.xpath("//p[text()='Compass Group Sender Email must be at most 320 characters']");
	public By dataRightsManagement = By.xpath("//span[text()='Data Rights Management']/../div/label");
	public By dataRightsManagementToggle = By.xpath("//span[text()='Data Rights Management']/following-sibling::div/i");
	public By exportAllCSVbtn = By.xpath("//button[@data-testid='export-btn']");

	public By ECommerceOrderNo=By.xpath("//button[@data-testid='export-btn']");
	public By MAESelectDropdown = By.cssSelector(".header-nav .select-search-select");
	public By CustomerAccount_Organization = By.xpath("//tr[@class='back_tr'][2]");
	public By AddAuditNoteModal_SkipButton = By.cssSelector(".skip-and-continue-btn");
	public By AlertRibbon = By.cssSelector(".app-notification .astm-alert-text");
	public By alertText_accountLocked = By.xpath("//div[@class='astm-alert-text')]");
	public By logo = By.xpath("//a[@class='user-logo']");
	public By logo1 = By.xpath("//img[@class='navbar-brand-logo']");
	public By switchTenant = By.xpath("//a[text()='Switch Tenant']");
	public By accessDeniedMsg = By.xpath("//p[contains(text(),'Access Denied')]");
	@Step("Enter valid credentials")
	public boolean NewLoginPublic2(String userEmail, String password) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(newSignInButton2), 10);
			getElement(userNameTxt).clear();
			getElement(userNameTxt).sendKeys(userEmail);
			getElement(passwordTxt).clear();
			getElement(passwordTxt).sendKeys(password);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			handleOneTrustCookie();
			getElement(newSignInButton2).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

		public WebElement getaccountUserStatus() {
			return getElement(accountUserStatus);
	}
	public int getPublishersCount()
	{
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='publisher-list']/tbody/tr/td"));
		return list.size();
	}


	public int getPageCount()
	{
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'pagination')]/li[@class='page-item']"));
		return list.size()-1;
	}

	public By getPageLink(int index)
	{
		By Element=By.xpath("(//ul[contains(@class,'pagination')]/li[@class='page-item'])["+index+"]");
		return Element;
	}

	public int getPageCount1()
	{
		List<WebElement> list=driver.findElements(By.xpath("//li[@class='page-item']/button[contains(@value,'')]"));
		return list.size();
	}



	public WebElement getAstmLogo() {
		return getElement(astmLogo);
	}

	public void handleOneTrustCookie() {
		try {
			if(getElement(cookieRejectBtn).isDisplayed()) {
				IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement getTextOnWebElementInMail(String elementName, By locator, WebDriver driver) {

		//driver.switchTo().frame("html_msg_body");
		ReusableMethods.scrollIntoView(getElement(locator), driver);
		return getElement(locator);

	}
	public WebElement getSelectAnAccountHeader() {
		return getElement(selectAnAccountHeader);
	}

	public WebElement getCreateButton() {
		return getElement(createButton);
	}

	public WebElement getSelectButtonASTM() {
		return getElement(selectButtonASTM);
	}


	public WebElement getSearchfield() {
		return getElement(searchfield);
	}

	public WebElement getSearchIcon() {
		return getElement(searchIcon);
	}

	public WebElement getBuildRemoteLogin(){
		return getElement(BuildRemoteLogin);
	}

	public WebElement getDownloadFile(){
		return getElement(DownloadFile);
	}


	public WebElement getSrchIcon() {
		return getElement(srchIcon);
	}


	public WebElement getUserMangementRole() {
		return getElement(userMangementRole);
	}

	public String getAccountUserStatus(){
		return getElement(AccountUserStatus).getText();
	}

	public String getOKTAactivationStatus(){
		return getElement(OKTAactivationStatus).getText();
	}

	public String getOKTAactivationStatus_Staged(){
		return getElement(OKTAactivationStatus_Staged).getText();
	}
	public WebElement getAddUser() {
		return getElement(addUserButton);
	}
	
	public List<WebElement> getAccountList() {
		return getElements(accountList);
	}

	public By getProductEntLink() {
		return ProductEntLink;
	}

	public By getEBSOrderNoEntry() {
		return EBSOrderNoEntry;
	}

	public By getSearchIcon1() {
		return searchIcon1;
	}

	public By getDetailsIcon() {
		return detailsIcon;
	}

	public By getASTMSelectBtn() {
		return ASTMSelectBtn;
	}

	public List<WebElement> getDetailsIconModelContent() {
		return driver.findElements(DetailsIconModelContent);
	}

	public List<WebElement> getRoles()
	{
		return driver.findElements(Roles);
	}
	public List<WebElement> getRolesText()
	{
		return driver.findElements(RolesText);
	}
	public List<WebElement> getFirstBulkUploadDetails()
	{
		return driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
	}
	public By verifyBulkUploadDetaails(String user)
	{
		return By.xpath("//table/tbody/tr[1]/td[text()='"+user+"']");
	}
	public By getHeaderName(String Header) {
		return By.xpath("//h5[contains(text(),'"+Header+"')]");
	}
	public List<WebElement> getPublisherCodeList() {
		return driver.findElements(By.xpath("//*[@id='publisher-list']//tr/td"));
	}
	public void clickOnTenantNameDots(String TenantName) {
		By TenantLocation=By.xpath("//td[text()='"+TenantName+"']//following-sibling::td[@class='row-actions']//a[@href='#']");
		PublicAdminCommons.scrollToElement(driver,TenantLocation);
		WaitStatementUtils.waitForElementStaleness(driver,getElement(TenantLocation),10);
		getElement(TenantLocation).click();
	}
	public void clickOnTenantNameResume(String TenantName) {
		By TenantNameTarget=By.xpath("//td[text()='"+TenantName+"']//following-sibling::td[@class='row-actions']//a[text()='Resume']");
		PublicCommon.JSClick(getElement(TenantNameTarget),driver);
	}

	public boolean registerUserDetails(String email, By Role) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(addUser), 10);
			PublicCommon.JSClick( getElement(addUser), driver);
			PublicCommon.waitForSec(3);
			PublicCommon.clearTextFieldsendKeys(getElement(emailField), email);

			PublicCommon.selectCheckbox(driver, compassUserCheckbox);
			/*WaitStatementUtils.waitForElementToBeClickable(driver, getElement(Role));
			PublicCommon.JSClick(getElement(Role), driver);*/
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(lastName));
			Thread.sleep(2000);
			getElement(lastName).sendKeys("Data");
			getElement(firstName).sendKeys("Test");
			ScreenshotUtil.takeFullPageScreenshot();
			getElement(lastName).sendKeys("Data");
			getElement(firstName).sendKeys("Test");
			IntegrationCommon.clickonWebElement(driver, saveBtn);
			try {
				getElement(firstName).sendKeys("test");
				getElement(lastName).sendKeys("Data");
				IntegrationCommon.clickonWebElement(driver, saveBtn);
			} catch (Exception e) {
				// TODO: handle exception
			}
			/*
			 * try { getElement(lastName).sendKeys("Data");
			 * PublicCommon.JSClick(getElement(Role), driver);
			 * IntegrationCommon.clickonWebElement(driver, saveBtn); } catch (Exception e) {
			 * // TODO: handle exception }
			 */
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Select compass user checkbox")
	public void selectCheckBoxCompassUser(){
		try{
			PublicCommon.selectCheckbox(driver, compassUserCheckbox);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Select compass User Administrator checkbox")
	public void selectCheckBoxcompassUserAdministrator(){
		try {
			if(getElements(compassUserAdministratorCheckbox_Checked).size()==0) {
				PublicCommon.selectCheckbox(driver, compassUserAdministratorCheckbox);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Select user Admin Checkbox checkbox")
	public void selectCheckBoxuserAdmin(){
		try {
			if(getElements(userAdminCheckbox_Checked).size()==0) {
				PublicCommon.selectCheckbox(driver, userAdminCheckbox);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Un-Select compass User Administrator checkbox")
	public void UnselectCheckBoxCompassUserAdministrator(){
		try {
			if(getElements(compassUserAdministratorCheckbox_Checked).size()!=0) {
				PublicCommon.selectCheckbox(driver, compassUserAdministratorCheckbox);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Un-Select user Admin Checkbox checkbox")
	public void UnSelectCheckBoxUserAdmin(){
		try {
			if(getElements(userAdminCheckbox_Checked).size()!=0) {
				PublicCommon.selectCheckbox(driver, userAdminCheckbox);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Click on Save Button")
	public void Save(){
		try{
			IntegrationCommon.clickonWebElement(driver, saveBtn);
			WaitStatementUtils.implicitWaitForSeconds(driver,10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Step("Register User details with Role")
	public boolean registerUserDetailswithRole(String email) {   //Role Name as String
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(addUser), 10);
			PublicCommon.JSClick( getElement(addUser), driver);
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.clearTextFieldsendKeys(getElement(emailField), email);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(lastName));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(firstName).sendKeys("Test");
			getElement(lastName).sendKeys("Data");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}






	public boolean registerUserDetailsWithbothRoles(String email) {
		try {
			PublicCommon.clearTextFieldsendKeys(getElement(emailField), email);
			// set the text
			Thread.sleep(5000);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectCompassRole));
			PublicCommon.JSClick(getElement(selectCompassRole), driver);
			Thread.sleep(3000);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectExternalSpecbuilderRole));
			getElement(selectExternalSpecbuilderRole).click();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(lastName));
			PublicCommon.clearTextFieldsendKeys(getElement(lastName), "Data");
			PublicCommon.clearTextFieldsendKeys(getElement(firstName), "Test");
			ScreenshotUtil.takeFullPageScreenshot();
			IntegrationCommon.clickonWebElement(driver, saveBtn);
			try {
				getElement(firstName).sendKeys("test");
				getElement(lastName).sendKeys("Data");
				IntegrationCommon.clickonWebElement(driver, saveBtn);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean registerUserDetailsWithNoRoles(String email) {
		try {
			PublicCommon.clearTextFieldsendKeys(getElement(emailField), email);
			// set the text
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(firstName));
			getElement(firstName).sendKeys("Test");
			// PublicCommon.clearTextFieldsendKeys(getElement(firstName), "Test");
			Thread.sleep(3000);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(lastName));
			PublicCommon.clearTextFieldsendKeys(getElement(lastName), "Data");
			ScreenshotUtil.takeFullPageScreenshot();
			IntegrationCommon.clickonWebElement(driver, saveBtn);
			try {
				getElement(firstName).sendKeys("Test");
				IntegrationCommon.clickonWebElement(driver, saveBtn);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean registerUserDetailsWithNoRoles(String email,String firstname,String lastname) {
		try {
			PublicCommon.clearTextFieldsendKeys(getElement(emailField), email);
			// set the text
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(firstName));
			getElement(firstName).sendKeys(firstname);
			// PublicCommon.clearTextFieldsendKeys(getElement(firstName), "Test");
			Thread.sleep(3000);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(lastName));
			PublicCommon.clearTextFieldsendKeys(getElement(lastName), lastname);
			ScreenshotUtil.takeFullPageScreenshot();
			IntegrationCommon.clickonWebElement(driver, saveBtn);
			try {
				getElement(firstName).sendKeys(firstname);
				IntegrationCommon.clickonWebElement(driver, saveBtn);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public WebElement getSelectTypes() {
		return getElement(selectTypes);
	}
//
	@Step("Search The Account in Mae and Open")
	public void searchAndOpenAccount(String ebsNumber,String input) {
		try {
			PublicCommon.selectValueInDropdown(getSelectTypes(), input);
			enterTextInTextField("Account Id",searchfield,ebsNumber,"Unable to Send the value in MAE");
			WaitStatementUtils.waitForElementToBeClickable(driver,getSearchIcon(),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getSearchIcon(), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getAccountList().get(0));
			WaitStatementUtils.waitForElementToBeClickable(driver,getAccountList().get(0),10);
			PublicCommon.waitForSec(5);
			clickOnMethod("Account", getAccountList().get(0),"Unable to click on Searched Account");
			PublicAdminCommons.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Failed to search MAE Account ID.");
		}

	}

	@Step("Search Account Number in Mae and Open")
    public void searchAndOpenAccountNumber(String ebsNumber) {
        try {
			PublicCommon.selectValueInDropdown(getSelectTypes(), "MAE Account ID");
            enterTextInTextField("Account Id",searchfield,ebsNumber,"Unable to Send EBS Account Number in MAE");
			WaitStatementUtils.waitForElementToBeClickable(driver,getSearchIcon(),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getSearchIcon(), driver);
			PublicCommon.waitForSec(5);
            WaitStatementUtils.explicitWaitForVisibility(driver, getAccountList().get(0));
			WaitStatementUtils.waitForElementToBeClickable(driver,getAccountList().get(0),10);
            clickOnMethod("Account", getAccountList().get(0),"Unable to click on Searched Account");
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            PublicCommon.exceptionHandlingBlock(e, log, "Failed to search MAE Account ID.");
        }

    }

	public void selectSearchContent(String dropdownValue,String searchhereText){
		try{
			PublicCommon.selectValueInDropdown(getSelectTypes(), dropdownValue);
			enterTextInTextField("Text",searchfield,searchhereText,"Unable to Send EBS Account Number in MAE");
			WaitStatementUtils.waitForElementToBeClickable(driver,getSearchIcon(),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getSearchIcon(), driver);
			PublicCommon.waitForSec(10);
			WaitStatementUtils.explicitWaitForVisibility(driver, getAccountList().get(1));
			WaitStatementUtils.waitForElementToBeClickable(driver,getAccountList().get(0),10);
			clickOnMethod("Account", getAccountList().get(0),"Unable to click on Searched Account");
			PublicAdminCommons.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Failed to search the required content in search field");
		}
	}
	 @Step("Enters {value} in {elementName}")
	    public void enterTextInTextField(String elementName, By locator, String value,String assertionMessage) {
	        try {
	            Assert.assertTrue(PublicAdminCommons.scrollElementToMiddleOfPage(driver, locator),
	                    "Scroll to " + elementName);
	            Assert.assertTrue(PublicAdminCommons.enterTextInTextField(driver, locator, value, true), assertionMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
	        }
	    }
	 
	 @Step("Clicks on {elementName}")
	    public void clickOnMethod(String elementName, WebElement element, String assertionMessage) {
	        try {
	           Assert.assertTrue(PublicAdminCommons.clickElement(element), assertionMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
	        }
	    }

    @Step("Admin selects '{value}' from '{elementName}'")
    public void selectValueFromDropDown(String elementName, By locator, String value, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, locator, value), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to select option from drop down", e);
        }
    }
    @Step("Login into MAE Account")
    public boolean maeLogin(String username, String password) {
        try {
            Assert.assertTrue(PublicAdminCommons.clearTxtFieldsendKeys(driver, compassUserName, username), "Unable to Send UserName");
            Assert.assertTrue(PublicAdminCommons.clearTxtFieldsendKeys(driver, compassPassword, password), "Unable to Send Password");
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(compassSignInButton), 60);
            PublicCommon.waitForSec(5);
           PublicAdminCommons.clickonWebElement(driver, compassSignInButton);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


	public By getModelcloseBtn() {
		return ModelcloseBtn;
	}

	public By getOKTAStatus() {
		return OKTAStatus;
	}

	public By getSeachBTN() {
		return seachBTN;
	}

	public By getSearchboxUser() {
		return searchboxUser;
	}
	public By getViewDraftTenantsBtn() {
		return viewDraftTenantsBtn;
	}
	public void closeUserview() {
		try {
			IntegrationCommon.clickonWebElement(driver, ViewUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getSignoutdropdown()
	{
		PublicCommon.JSClick(getElement(Signoutdropdown), driver);
		//getElement(Signoutdropdown).click();
	}

	public void clickSignoutBtn()
	{
		getElement(SignoutBtn).click();
	}

	@Step("Login to MAE and click on MAE Entitlement")
	public void MAElogin(String email, String password){
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ConfigReader.setValue("BASE_URL_MAE", "https://stage-manage.astm.org/");
			driver.get(ConfigReader.getValue("BASE_URL_MAE"));
//			WaitStatementUtils.explicitWaitForVisibility(driver, getAstmLogo(),10);
			handleOneTrustCookie();
			NewLoginPublic2(email, password);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MAEbtn),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Managment of Accounts & Entitlements (MAE) ",getElement(MAEbtn));
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicAdminCommons.reportFailAssert("Unable to Login to MAE",e);
			System.out.println("Unable to Login to MAE");
		}
	}

	@Step("Validate MAE Entitlement")
	public void validateTenantDesignationAPI_MAE(String MAEAcc){
		try{
			selectAPITenanat();
			SearchMaeAccountID(MAEAcc);
			validateECommerceId("API");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Login to MAE");
		}
	}

	@Step("Validate MAE Entitlement")
	public void validateTenantDesignationAWWA_MAE(String MAEAcc){
		try{
			selectAWWATenanat();
			SearchMaeAccountID(MAEAcc);
			validateECommerceId("AWWA");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Login to MAE");
		}
	}

	@Step("Validate MAE Entitlement")
	public void validateTenantDesignationAENOR_MAE(String MAEAcc){
		try{
			selectAENORTenanat();
			SearchMaeAccountID(MAEAcc);
			validateECommerceId("AENOR");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Login to MAE");
		}
	}



	@Step("Validate MAE Entitlement")
	public void validateTenantDesignationCGA_MAE(String MAEAcc){
		try{
			selectCGATenanat();
			SearchMaeAccountID(MAEAcc);
			validateECommerceId("CGA");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Login to MAE");
		}
	}

	@Step("Validate MAE Entitlement")
	public void validateTenantDesignationIES_MAE(String MAEAcc){
		try{
			selectIESTenanat();
			SearchMaeAccountID(MAEAcc);
			validateECommerceId("IES");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Login to MAE");
		}
	}

	@Step("Validate MAE Entitlement")
	public void validateTenantDesignationASTM_MAE(String MAEAcc){
		try{
			selectASTMTenanat();
			SearchMaeAccountID(MAEAcc);
			validateECommerceId("ASTM");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Login to MAE");
		}
	}

	@Step("Validate ECommerce Id")
	public void validateECommerceId(String Tenant){
		try{
			ValidateProductEntitlementTab();
			String ECommerceOrderNum=getElement(ECommerceOrderNo).getText();
			if(Tenant.equals("ASTM")) {
				Allure.addAttachment("ECommerce Id", ECommerceOrderNum.substring(0,2));
				Assert.assertTrue(ECommerceOrderNum.substring(0, 2).equals("00"), "Aenor prefix not matched");
			}
			else if(Tenant.equals("API")) {
				Allure.addAttachment("ECommerce Id", ECommerceOrderNum.substring(0,1));
				Assert.assertTrue(ECommerceOrderNum.substring(0, 1).equals("7"), "Aenor prefix not matched");
			}
			else if(Tenant.equals("AWWA")) {
				Allure.addAttachment("ECommerce Id", ECommerceOrderNum.substring(0, 2));
				Assert.assertTrue(ECommerceOrderNum.substring(0, 2).equals("23"), "Aenor prefix not matched");
			}
			else if(Tenant.equals("AENOR")) {
				Allure.addAttachment("ECommerce Id", ECommerceOrderNum.substring(0, 2));
				Assert.assertTrue(ECommerceOrderNum.substring(0, 2).equals("20"), "Aenor prefix not matched");
			}
			else if(Tenant.equals("CGA")) {
				Allure.addAttachment("ECommerce Id", ECommerceOrderNum.substring(0, 2));
				Assert.assertTrue(ECommerceOrderNum.substring(0, 2).equals("13"), "Aenor prefix not matched");
			}
			else if(Tenant.equals("IES")) {
				Allure.addAttachment("ECommerce Id", ECommerceOrderNum.substring(0, 2));
				Assert.assertTrue(ECommerceOrderNum.substring(0, 2).equals("17"), "Aenor prefix not matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Login to MAE");
		}
	}

	@Step("Login to MAE")
	public void LoginMAE(String email, String password){
		try{
			ConfigReader.setValue("BASE_URL_MAE", "https://stage-manage.astm.org/");
			driver.get(ConfigReader.getValue("BASE_URL_MAE"));
			//WaitStatementUtils.explicitWaitForVisibility(driver, getAstmLogo(),5);
			handleOneTrustCookie();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			NewLoginPublic2(email, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Uanble to Login to MAE and select TIMS Entitlement");
		}
	}



	@Step("Click on TIMS Entitlement")
	public void selectTIMSentitlement(){
		try{
			WaitStatementUtils.waitForElementStaleness(driver,getElement(TIMSbtn));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(TIMSbtn),10);
			clickOnMethod("Tenant Information Management System (TIMS)",getElement(TIMSbtn));
			PublicCommon.waitForSec(15);
			driver.getTitle().equals("TIMS UI");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(manageTenantsHeader));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Uanble to select TIMS Entitlement");
		}
	}

	@Step("Validate List of Tenants in Tabular format")
	public void validateListOfTenants(){
		try{
			List<String> expectedResult = new ArrayList<String>();
			expectedResult.add("Name");
			expectedResult.add("Tenant Code");
			expectedResult.add("Tenant Status");
			expectedResult.add("CreatedBy");
			expectedResult.add("ModifiedBy");

			List<String> actualResult = new ArrayList<String>();
			//WebElement table = driver.findElement(By.xpath("//div[@class='content-wrapper']/div/div/div/p[1]"));
			List<WebElement> table = driver.findElements(By.xpath("//table[@id='tenants-list']/thead/tr/th"));

			for (int j=0; j<table.size(); j++){
				actualResult.add(table.get(j).getText());
			}

			for(int i=0;i<expectedResult.size();i++) {
				if(actualResult.get(i).split(":")[0].trim().contains(expectedResult.get(i))) {
					System.out.println("Search function verified");
				}else {
					System.out.println("Search function verification failed"+actualResult.get(i));
				}
				Allure.addAttachment("List of Tenants", String.valueOf(actualResult));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to validate Headers in Tenant Details Page");
		}
	}

	@Step("Validate List of Tenants in Tabular format")
	public void VerifyDraftWLTenantsRecords(){
		try{
			PublicAdminCommons.scrollToElement(driver,viewDraftTenantsBtn);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(viewDraftTenantsBtn),10);
			verifyVisibility("View Draft Tenants Button",viewDraftTenantsBtn,"View Draft Tenants Button should be visible");
			ReusableMethods.scrollIntoView(getElement(viewDraftTenantsBtn),driver);
			clickOnMethod("View Draft Tenants Button",getElement(viewDraftTenantsBtn),"View Draft Tenants Button should be clickable");
			wait.until(ExpectedConditions.urlToBe("https://stage-tims.astm.org/view/draft-tenants"));
			Assert.assertTrue(driver.getCurrentUrl().contains("view/draft-tenants"));
			verifyVisibility("View Draft Tenants Heading",ViewDraftTenantsHeading,"View Draft Tenants Heading should be visible");
			verifyVisibility("View Draft Tenants Table",ViewDraftTenantsTable,"View Draft Tenants Table should be visible");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to validate Headers in Tenant Details Page");
		}
	}




	@Step("Select Tenant and Validate Details")
	public void selectTenantAndValidate(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(tenantName));
			String TenantName = getElement(tenantName).getText();
			clickOnMethod("Select Tenant in Tabular column",getElement(tenantName));
			WaitStatementUtils.waitForElementStaleness(driver,getElement(TenantInTenantdetailsPage));
			getElement(TenantInTenantdetailsPage).getText().equals(TenantName);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to select Tenant and Validate Details");
		}
	}

	@Step("Select Tenant and Validate Subscription Tab and Publishers Sub-Tab and Publishers Existance")
	public void selectTenantAndValidateSubscriptionTab(String TenantName){
		try{
			int i=1;
			By tenantRow=By.xpath(TRow.replace("[TName]",TenantName));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(tenantRow),5);
			clickOnMethod("Select Tenant in Tabular column",getElement(tenantRow));
			WaitStatementUtils.waitForElementStaleness(driver,getElement(TenantInTenantdetailsPage));
			ReusableMethods.scrollIntoView(getElement(TenantInTenantdetailsPage),driver);
			getElement(TenantInTenantdetailsPage).getText().equals(TenantName);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			verifyVisibility("Subscriptions Setting Tab",subscriptionsSettingTab,"Subscriptions setting tab should be visible");
			verifyVisibility("Publishers Sub_Tab",publishersSubTab,"Publishers Sub_Tab should be visible");
			verifyVisibility("Publishers Table Pagination",publishersTablePaginationTIMS,"Publishers Table Pagination should be visible");
			while(i<getPageCount())
			{
				Assert.assertTrue(getPublishersCount()>=1 && getPublishersCount()<=10,"Publishers Count is Not between 1 to 10");
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getPageLink(i+1)), 5);
				clickOnMethod("Next Page Link Button", getElement(getPageLink(i+1)));
				PublicCommon.waitForSec(2);
				i++;
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getPageLink(1)), 5);
			clickOnMethod("Next Page Link Button", getElement(getPageLink(1)));
			//Validating Show Dropdown
			PublicAdminCommons.selectValueFromDropdownByIndex(driver,publisherShowDDTIMS,1);
			Assert.assertTrue(getPublishersCount()<21 ,"Show Dropdown Not Working");
			PublicAdminCommons.scrollToOffSet(driver, "0", "200");
			ScreenshotUtil.takeScreenshotForAllure(driver);

			/*PublicAdminCommons.selectValueFromDropdownByIndex(driver,publisherShowDD,2);
			Assert.assertTrue(getPublishersCount()==50 ,"Show Dropdown Not Working");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToOffSet(driver, "0", "400");
			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicAdminCommons.selectValueFromDropdownByIndex(driver,publisherShowDD,3);
			Assert.assertTrue(getPublishersCount()==100 ,"Show Dropdown Not Working");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToOffSet(driver, "0", "600");
			ScreenshotUtil.takeScreenshotForAllure(driver);*/
			driver.navigate().back();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(viewDraftTenantsBtn),10);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to select Tenant and Validate Details");
		}
	}

	@Step("Validate Headers in Tenant Details Page")
	public void validateHeadersInTenantDetailsPage(){
		try{
			List<String> expectedResult = new ArrayList<String>();
			expectedResult.add("Tenant");
			expectedResult.add("Code");
			expectedResult.add("Domain");
			expectedResult.add("Tenant Status");
			expectedResult.add("Created By");
			expectedResult.add("Modified By");

			List<String> actualResult = new ArrayList<String>();
			//WebElement table = driver.findElement(By.xpath("//div[@class='content-wrapper']/div/div/div/p[1]"));
			List<WebElement> table = driver.findElements(By.xpath("//div[@class='content-wrapper']/div/div/div/p[1]"));

			for (int j=0; j<table.size(); j++){
				actualResult.add(table.get(j).getText());
			}

			for(int i=0;i<expectedResult.size();i++) {
				if(actualResult.get(i).split(":")[0].trim().contains(expectedResult.get(i))) {
					System.out.println("Search function verified");
				}else {
					System.out.println("Search function verification failed"+actualResult.get(i));
				}
				Allure.addAttachment("Headers In Tenant Details Page", String.valueOf(actualResult));
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to validate Headers in Tenant Details Page");
		}
	}

	@Step("Select IES tenant")
	public void selectIESTenanat(){
		try{
			ReusableMethods.scrollIntoView(getElement(IOPselectBtn), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(IESselectBtn), 5);
			ReusableMethods.scrollIntoView(getElement(IESselectBtn), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(IESselectBtn), 5);
			CommonPage_Public.JSClick(getElement(IESselectBtn),driver);
		} catch (Exception e) {
			System.out.println("Unable to select Tenant");
		}
	}

	@Step("Select AWWA tenant")
	public void selectAWWATenanat(){
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AWWASelectBtn));
			ReusableMethods.scrollIntoView(getElement(AWWASelectBtn), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			CommonPage_Public.JSClick(getElement(AWWASelectBtn),driver);
		} catch (Exception e) {
			System.out.println("Unable to select Tenant");
		}
	}

	@Step("Select API tenant")
	public void selectAPITenanat(){
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(APISelectBtn));
			PublicAdminCommons.scrollToElement(driver,getElement(APISelectBtn));
			PublicCommon.waitForSec(2);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			CommonPage_Public.JSClick(getElement(APISelectBtn),driver);
		} catch (Exception e) {
			System.out.println("Unable to select Tenant");
		}
	}

	@Step("Select ASTM tenant")
	public void selectASTMTenanat(){
		try{
			PublicAdminCommons.scrollToElement(driver,getElement(ASTMSelectBtn));
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("ASTM Tenant Link", getElement(ASTMSelectBtn), "Unable to Click on ASTM Tenant Link");
		} catch (Exception e) {
			System.out.println("Unable to select Tenant");
		}
	}


	@Step("Select CGA tenant")
	public void selectCGATenanat(){
		try{
			ReusableMethods.scrollIntoView(getElement(CHECKselectBtn), driver);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(CGAselectBtn), 5);
			ReusableMethods.scrollIntoView(getElement(CGAselectBtn), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			CommonPage_Public.JSClick(getElement(CGAselectBtn),driver);
		} catch (Exception e) {
			System.out.println("Unable to select Tenant");
		}
	}

	@Step("Select AENOR tenant")
	public void selectAENORTenanat(){
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AENORselectBtn));
			ReusableMethods.scrollIntoView(getElement(AENORselectBtn), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			CommonPage_Public.JSClick(getElement(AENORselectBtn),driver);
		} catch (Exception e) {
			System.out.println("Unable to select Tenant");
		}
	}

	@Step("Click on Menu Bar option")
	public void MenuBarLink(){
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(MenuBar),10);
			clickOnMethod("Menu bar", getElement(MenuBar), "Unable to click on Menu Bar option");
		} catch (Exception e) {
			System.out.println("Unable to click on Menu Bar option");
		}
	}

	@Step("Click on Subscription Usage Summary link from left navigation menu bar")
	public void subscriptionUsageSummaryLink(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SubscriptionUsageSummary),5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Subscription Usage Summary link", getElement(SubscriptionUsageSummary), "Unable to Click on Subscription Usage Summary link from left navigation menu bar");
		} catch (Exception e) {
			System.out.println("Unable to Click on Subscription Usage Summary link from left navigation menu bar");
		}
	}

	@Step("Search the MAE Account ID")
	public void SearchMaeAccountID(String MAEAccountID) throws IOException {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			searchAndOpenAccountNumber(MAEAccountID);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			System.out.println("Unable to search MAE Account Id");
		}
	}
	@Step("Search API tenant account Account ID")
	public void SearchAPITenantAccountID(String inputValue,String MAEAccountID) throws IOException {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			searchAndOpenAccount(MAEAccountID,inputValue);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			System.out.println("Unable to search API tenant account Account ID");
		}
	}


	@Step("Click on Add user in User Management Tab")
	public void AddUserInUserManagementTab(String email){
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(userManagementTab),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("User Management Tab", getElement(userManagementTab), "Unable to Click on MAE User Management tab");
			String role="Compass User";
			registerUserDetailswithRole(email);
		} catch (Exception e) {
			System.out.println("Unable to Add user");
		}
	}

	@Step("Validate OKTA status")
	public void validateOKTAstatus(String email){
		try{
			System.out.println(driver.getTitle());
			driver.navigate().refresh();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(userManagementTab),10);
			clickOnMethod("User Management Tab", getElement(userManagementTab), "Unable to Click on MAE User Management tab");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getSeachBTN()),10);
			getElement(getSearchboxUser()).sendKeys(email);
			getElement(getSeachBTN()).click();
			Assert.assertTrue(getElement(getOKTAStatus()).getText().equals("ACTIVE"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			System.out.println("Unable to Add user");
		}
	}

	@Step("Get MAE User ID from User Management Tab")
	public String getMAEuserID() {
		String MAEuserID = null;
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(editBtn), 10);
			getElement(editBtn).click();
			WaitStatementUtils.waitForElementStaleness(driver, getElement(MAEuserIDvalue));
			MAEuserID = getElement(MAEuserIDvalue).getAttribute("value");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(closeBtn).click();
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			System.out.println("Unable to get MAE user ID");
		}
		return MAEuserID;
	}

	@Step("Signout of MAE")
	public void SignoutMAE(){
		try{
			//Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver, 0),"Unable to switch to other tab");
			getSignoutdropdown();
			clickSignoutBtn();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to add user under user management tab", e);
		}
	}

	public static String switchToWindowByTitle(WebDriver driver, String windowTitle) {
		Set<String> handles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (windowTitle.equalsIgnoreCase(driver.getTitle())) {
				break;
			}
		}
		return currentHandle;
	}

	@Step("Click in Access Management tab")
	public void ClickAccessManagementTab() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(AccessManagement),5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AccessManagement),10);
			clickOnMethod("Access Management Tab", getElement(AccessManagement));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on AccessManagementTab", e);
		}
	}

	@Step("Click in Account Administration tab")
	public void ClickAccountAdministrationTab() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AccountAdministration),10);
			clickOnMethod("Account Administration Tab", getElement(AccountAdministration));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on Account Administration Tab", e);
		}
	}

	@Step("Edit Account Acronym in Account Attributes")
	public void editAccountAcronym(String AccountAcronymNote){
		try{
			PublicCommon.waitForSec(5);
			PublicCommon.clearTextFieldsendKeys(getElement(AccountAcronymUpdate), AccountAcronymNote);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Edit Account Acronym in Account Attributes", e);
		}
	}

	@Step("Edit Account Acronym in Account Attributes")
	public void VerifySpecbuilderTab(String CompanyLogoURLnOTE){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(specbuilderTab),5);
			getElement(specbuilderTab).click();
			verifyVisibility("Specbuilder tab", SpecBuilderEntitlementsLabel,"SpecBuilder Entitlements Label iss not visible");
			PublicCommon.clearTextFieldsendKeys(getElement(CompanyLOGOredirectURLtext), CompanyLogoURLnOTE);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Edit Account Acronym in Account Attributes", e);
		}
	}

	@Step("Check If JWT Test Login is enabled")
	public void ValidateJWTToken() {
		try{
			PublicAdminCommons.scrollToElement(driver, JWTTestLoginToggleBtn);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			//Assert.assertEquals(getElement(JWTTestLoginEnable).getAttribute("data-icon"),"toggle-on");
			Assert.assertEquals(getElement(JWTTestLoginToggleBtn).getText(),"Enabled");
			verifyVisibility("JWT Login", JWTloginBTN,"JWT Login");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to validate JWT token enabled", e);
		}
	}

	@Step("Check JWT Token")
	public String VerifyJWTToken() {
		String Token = null;
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (getElement(JWTLabel).getText().equals("Disabled")) {
				//PublicCommon.JSClick( getElement(AuthVerificationToggle), driver);
				getElement(JWTToggle).click();
				return Token = "\"Y\"";
			} else if (getElement(JWTLabel).getText().equals("Enabled")) {
				//PublicCommon.JSClick( getElement(AuthVerificationToggle), driver);
				getElement(JWTToggle).click();
				return Token = "\"N\"";
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to validate JWT token enabled", e);
		}
		return Token;
	}

	@Step("Click on Compass Tab")
	public void VerifyCompassTab(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(CompassTab),5);
			getElement(CompassTab).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to validate JWT token enabled", e);
		}
	}

	@Step("Verify Compass Points check under Compass Tab")
	public String CompassPointsCheck() {
		String Auth = null;
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToElement(driver,getElement(compassPointLabel));
			if(getElement(compassPointLabel).getText().equals("Disabled")){
			//	getElement(compassPointToggle).click();
				getElement(compassPointToggle1).click();
					return Auth = "Enabled";
			} else if (getElement(compassPointLabel).getText().equals("Enabled")) {
				//getElement(compassPointToggle).click();
				getElement(compassPointToggle1).click();
					return Auth = "Disabled";
				}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to validate Compass Points check under Compass Tab", e);
		}
		return Auth;
	}

	@Step("Verify Groups check under Compass Tab")
	public String groupsCheck() {
		String Auth = null;
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(getElement(groupsPointLabel).getText().equals("Disabled")){
				ReusableMethods.SCrollIntoView(driver);
				PublicCommon.waitForSec(5);
				getElement(groupsPointToggle).click();
				PublicCommon.waitForSec(2);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return Auth = "Enabled";
			} else if (getElement(groupsPointLabel).getText().equals("Enabled")) {
				ReusableMethods.ScrollIntoView(driver);
				PublicCommon.waitForSec(5);
				getElement(groupsPointToggle).click();
				PublicCommon.waitForSec(2);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return Auth = "Disabled";
			}
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to validate Groups check under Compass Tab", e);
		}
		return Auth;
	}

	@Step("Verify Username and Password Login check under Compass Tab")
	public String userNameAndPasswordLoginCheck() {
		String Auth = null;
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(getElement(userNamePasswordLoginLabel).getText().equals("Disabled")){
				PublicAdminCommons.scrollToElement(driver,userNamePasswordLoginLabel);
				PublicCommon.waitForSec(5);
				getElement(userNamePasswordLoginToggle).click();
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(IpaccessCheckbox),5);
				getElement(IpaccessCheckbox).click();
				getElement(AllowAnonymousOrgAuth).click();
				return Auth = "true";
			} else if (getElement(userNamePasswordLoginLabel).getText().equals("Enabled")) {
				PublicAdminCommons.scrollToElement(driver,userNamePasswordLoginLabel);
				PublicCommon.waitForSec(5);
				getElement(userNamePasswordLoginToggle).click();
				return Auth = "false";
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to validate Username and Password Login check under Compass Tab", e);
		}
		return Auth;
	}


	@Step("Click on Save Button")
	public void SaveBtn(){
		try{
			getElement(SaveBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Save", e);
		}
	}

	@Step("Save and add audit Note")
	public void SaveAndAddAuditNote(String Note){
		try{
			getElement(SaveBtn).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(AddAuditNoteLabel),15);
			getElement(textAreaNote).sendKeys(Note);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(AddNoteAndContinue),3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(AddNoteAndContinue).click();
			PublicCommon.waitForSec(7);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Save and add audit Note", e);
		}
	}

	@Step("Verify Audit tab history")
	public void AuditTab(String Note){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AuditTab),10);
			getElement(AuditTab).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(RecentHistoryLabel),5);
			getElement(VerifyAuditHistory).getText().contains(Note);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify Audit tab history", e);
		}
	}

	@Step("Verify Audit tab history")
	public void verifyAuditLogs(String content){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AuditTab),10);
			getElement(AuditTab).click();
			Assert.assertTrue(getElement(RecentHistoryLabel).isDisplayed(),"Recent History Label Not found");
			List<WebElement> list=driver.findElements(By.xpath("//div[@class='audit-container']/descendant::p"));
			Assert.assertFalse(list.isEmpty(),"Audit Logs List is Empty");

		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify Audit tab history", e);
		}
	}

	@Step("Click on JWT Login button and click on Login")
	public void ClickonJWTlogin() {
		try{
			clickOnMethod("JWT Login button Enabled",getElement(JWTloginBTN));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(JWTloginheader),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			verifyVisibility("JWT Login Header", JWTloginheader,"Verify header JWT login");
			clickOnMethod("click on Login button",getElement(loginBtn));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on JWT login button", e);
		}
	}

	@Step("Verify Visibility of Element {elementName}")
	public void verifyVisibility(String elementName, By locator, String assertionMessage) {
		try {
			Assert.assertTrue(IntegrationCommon.isWebElementDisplayed(driver, locator), assertionMessage);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}

	@Step("Enter Account number on the page")
	public void enterAccountNumber(String accountNumber) {
		try {
			PublicCommon.selectValueInDropdown(getSelectTypes(), "Account Number");
			PublicCommon.waitForSec(3);
			getSearchfield().sendKeys(accountNumber);
			PublicCommon.JSClick(getSearchIcon(), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to search account number", e);
		}
	}

	@Step("Select the Account")
	public void SelectAccount(){
		try{
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(accountList1),60);
			clickonMethod("Account", getElement(accountList1));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on Account", e);
		}
	}

	@Step("Verify if Account and Okta activation status is \"ACTIVE\" ")
	public void UserManagementAccountStatus(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(userMangementRole),120);
			PublicCommon.waitForSec(30);
			clickonMethod("User Management Tab", getUserMangementRole());
			PublicCommon.waitForSec(10);
			assertEquals(getAccountUserStatus(),"ACTIVE");
			assertEquals(getOKTAactivationStatus(),"ACTIVE");
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify User Management - Account user status", e);
		}
	}

	@Step("Verify if Account and Okta activation status is \"ACTIVE\" ")
	public void UserManagementAccountStatus_New(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(userMangementRole),120);
			PublicCommon.waitForSec(30);
			clickonMethod("User Management Tab", getUserMangementRole());
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(AccountUserStatus),driver);
			assertEquals(getAccountUserStatus(),"ACTIVE");
			//assertEquals(getOKTAactivationStatus_Staged(),"STAGED");
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify User Management - Account user status", e);
		}
	}
   public By searchField_userManagement = By.xpath("//input[@placeholder='Search']");
	public By search_userManagement = By.xpath("//input[@placeholder='Search']//following-sibling::button");
	public By tableCount = By.xpath("//div[@class='table_container']//tbody//tr");
	public By edit_userManagement = By.xpath("//div[@class='table_container']//tbody//td[10]//span[2]");
	public By userEdit = By.xpath("//button[@data-testid='user-edit']");
	@Step("Verify whether the compass user administrator under viewer and User admin under Administration Role is able to Check/uncheck")
	public void compassAdministratorUserAdmin_Enabled(boolean CompassAdministrator,boolean userAdmin,String mail){
		try{
			PublicCommon.waitForSec(5);
			clickonMethod("User Management Tab", getUserMangementRole());
			PublicCommon.waitForSec(5);
            ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(searchField_userManagement).sendKeys(mail);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(search_userManagement));
			ReusableMethods.scrollIntoView(getElement(search_userManagement), driver);
			getElement(search_userManagement).click();
			PublicCommon.waitForSec(15);
			Assert.assertTrue(getElements(tableCount).size()==1,"Search field is not Working");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			getElement(edit_userManagement).click();
			getElement(userEdit).click();
			if(CompassAdministrator){
				selectCheckBoxcompassUserAdministrator();
			}else{
				UnselectCheckBoxCompassUserAdministrator();
			}
			if(userAdmin){
				selectCheckBoxuserAdmin();
			}else{
               UnSelectCheckBoxUserAdmin();
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Save();
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify whether the compass user administrator under viewer and User admin under Administration Role is able to Check/uncheck", e);
		}
	}

	@Step("Click on Product Entittlement")
	public void ValidateProductEntitlementTab(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ProductEntLink),10);
			clickOnMethod("Product Entitlement Link", getElement(ProductEntLink), "Unable to Click on Product Entitlement Link");
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Product Entitlement", e);
		}
	}

	@Step("Validate Stock code")
	public String verifyStockcode_Graceperiodcheck(String stockcode) {
		String GracePeriod = null;
		try {
			getElement(StockCodeForm).sendKeys(stockcode);
			getElement(SearchBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(GracePeriodDDN).click();
			List<WebElement> ListGracePeriod = getgraceperiodList();
			Random rand = new Random();
			int list = rand.nextInt(ListGracePeriod.size());
			GracePeriod = ListGracePeriod.get(list).getText();
			ListGracePeriod.get(list).click();
			System.out.println(GracePeriod);
			getElement(SaveBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return GracePeriod;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to validate stock code and Grace period", e);
		}
		return GracePeriod;
	}

	@Step("Validate Stock code")
	public void verifyStockcode(String stockcode) {
		try {
			getElement(StockCodeForm).sendKeys(stockcode);
			getElement(SearchBtn).click();
			PublicCommon.waitForSec(20);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(stockCodeTable),30);
			PublicAdminCommons.scrollToOffSet(driver,"0","650");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(stockCodeTable).getText().trim().equals(stockcode);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToOffSet(driver,"0","-500");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to validate stock code", e);
		}
	}

	public List<WebElement> getgraceperiodList() {
		return driver.findElements(getlistofGracePeriod);
	}

	@Step("Click on {element}")
	private void clickonMethod(String message, WebElement element) {
		try {
			ReusableMethods.scrollIntoView(element, driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.clickonWebElement(driver, element);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Exception.", e);
		}
	}

	@Step("Click in Report Tab")
	public void ClickReportTab() {
		try {
			verifyVisibility("Report Tab", ReportTab,"Report Tab is visible");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ReportTab),10);
			clickOnMethod("Report Tab", getElement(ReportTab));
			PublicCommon.waitForSec(20);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on Report Tab", e);
		}
	}

	@Step("Verify Subscription Usage Report")
	public void VerifySubscriptionUsageReport(){
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(UsageReport),15);
			verifyVisibility("Usage Report", UsageReport,"Report Tab is visible");
			verifyVisibility("User Report", UserReport,"Report Tab is visible");
			PublicCommon.waitForSec(25);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Actions a1 = new Actions(driver);
			a1.sendKeys(Keys.PAGE_DOWN).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			a1.sendKeys(Keys.PAGE_DOWN).build().perform();
			a1.sendKeys(Keys.PAGE_DOWN).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Click on User report",getElement(UserReport));
			PublicCommon.waitForSec(20);
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify Subscription Usage report", e);
		}

	}

	@Step("Verify that for AENOR Tenant user is able to view \'Subscription Usage Summary\' Link")
	public void VerifyAENORtenantForSubscriptionUsageSummary(){
		try{
			selectAENORTenanat();
			MenuBarLink();
			subscriptionUsageSummaryLink();
			SubscriptionUsageSummaryPage();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify that for AENOR Tenant user is able to view \'Subscription Usage Summary\' Link", e);
		}
	}

	@Step("Verify that for API Tenant user is able to view \'Subscription Usage Summary\' Link")
	public void VerifyAPItenantForSubscriptionUsageSummary(){
		try{
			ConfigReader.setValue("BASE_URL_MAE", "https://stage-manage.astm.org/");
			driver.get(ConfigReader.getValue("BASE_URL_MAE"));
			selectAPITenanat();
			MenuBarLink();
			subscriptionUsageSummaryLink();
			SubscriptionUsageSummaryPage();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify that for API Tenant user is able to view \'Subscription Usage Summary\' Link", e);
		}
	}

	@Step("Verify that for AWWA Tenant user is able to view \'Subscription Usage Summary\' Link")
	public void VerifyAWWAtenantForSubscriptionUsageSummary(){
		try{
			ConfigReader.setValue("BASE_URL_MAE", "https://stage-manage.astm.org/");
			driver.get(ConfigReader.getValue("BASE_URL_MAE"));
			selectAWWATenanat();
			MenuBarLink();
			subscriptionUsageSummaryLink();
			SubscriptionUsageSummaryPage();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify that for AWWA Tenant user is able to view \'Subscription Usage Summary\' Link", e);
		}
	}

	@Step("Verify that for CGA Tenant user is able to view \'Subscription Usage Summary\' Link")
	public void VerifyCGAtenantForSubscriptionUsageSummary(){
		try{
			ConfigReader.setValue("BASE_URL_MAE", "https://stage-manage.astm.org/");
			driver.get(ConfigReader.getValue("BASE_URL_MAE"));
			selectCGATenanat();
			MenuBarLink();
			subscriptionUsageSummaryLink();
			SubscriptionUsageSummaryPage();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify that for CGA Tenant user is able to view \'Subscription Usage Summary\' Link", e);
		}
	}

	@Step("Verify that for IES Tenant user is able to view \'Subscription Usage Summary\' Link")
	public void VerifyIEStenantForSubscriptionUsageSummary(){
		try{
			ConfigReader.setValue("BASE_URL_MAE", "https://stage-manage.astm.org/");
			driver.get(ConfigReader.getValue("BASE_URL_MAE"));
			selectIESTenanat();
			MenuBarLink();
			subscriptionUsageSummaryLink();
			SubscriptionUsageSummaryPage();
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify that for IES Tenant user is able to view \'Subscription Usage Summary\' Link", e);
		}
	}


	@Step("Verify User is able to click on Menu option with Subscription Usage Summary Link and view summary details")
	public void SubscriptionUsageSummaryPage(){
		try{
			PublicCommon.waitForSec(20);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Actions a1 = new Actions(driver);
			a1.sendKeys(Keys.PAGE_DOWN).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			a1.sendKeys(Keys.PAGE_DOWN).build().perform();
			a1.sendKeys(Keys.PAGE_DOWN).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Verify Subscription Usage report", e);
		}
	}
	@Step("Click in Bulk Upload tab")
	public void ClickBulkUploadTab() {
		try {
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(BulkUploadTab),10);
			clickOnMethod("Bulk Upload Tab", getElement(BulkUploadTab));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on Bulk Upload Tab", e);
		}
	}
	@Step("Click in User Management tab")
	public void ClickUserManagementTab() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(userManagementTab),10);
			clickOnMethod("User Management Tab", getElement(userManagementTab));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to click on User Management Tab", e);
		}
	}
	@Step("Verify Data Rights Management under Compass Tab")
	public void dataRightsManagement(String toggleOption,String notes) {
		try{
			//By default it is Enabled you are making Disabled
			/**************************/
			PublicAdminCommons.scrollToElement(driver,dataRightsManagement);
			PublicCommon.waitForSec(3);
			if(getElement(dataRightsManagement).getText().equalsIgnoreCase("Enabled")){
				getElement(dataRightsManagementToggle).click();
				PublicAdminCommons.scrollToElement(driver,SaveBtn);
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SaveBtn),10);
				SaveAndAddAuditNote(notes);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			/***************************/
			if(!getElement(dataRightsManagement).getText().equalsIgnoreCase(toggleOption)) {
				getElement(dataRightsManagementToggle).click();
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToElement(driver,SaveBtn);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(SaveBtn),10);
			SaveAndAddAuditNote(notes);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getSignoutdropdown();
			clickSignoutBtn();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Data Rights Management check under Compass Tab", e);
		}
	}
	@Step("Verify visibility of Export All CSV button")
	public void verifyExportAllCSVButtonVisibility(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(exportAllCSVbtn),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to verify Export all CSV Button", e);
		}
	}

	@Step("Validate Downloaded CSV file")
	public void validateDownloadedCSVfile() {
		try{
			String filename = "Users.csv";
			String downloadFolderPath = System.getProperty("user.dir") + "\\src\\main\\resources\\testResource\\downloads";
			clickOnMethod("Export All CSV", getElement(exportAllCSVbtn), "Clicked on MAE User Management tab");
			PublicCommon.waitForSec(5);
			ReusableMethods.fileDownloadUsingWindowsSaveAsPopup(downloadFolderPath+"\\" + filename);
			PublicCommon.waitForSec(10);
			String email = "compasstestact01@yopmail.com";
			if(PublicCommon.isFileDownloadedFound(downloadFolderPath,filename,email))
			{
				System.out.println("File Download Verified");
			}
		} catch (Exception e) {
			e.printStackTrace();
			IntegrationCommon.reportFailAssert("Failed to Validate downloaded file", e);
		}
	}

	public void setMAESelectDropdown(String Option){
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MAESelectDropdown));
		PublicCommon.selectValueInDropdown(getElement(MAESelectDropdown), Option);

	}

	@Step("Get my current IP Address")
	public String getIP() {
		String Ip="null";
		try {
			driver.get("https://whatismyipaddress.com/");
			WaitStatementUtils.waitForNumberOfElementsToBe(driver, "#ipv4", 1, 5);
			if(driver.findElements(By.xpath("//span[@id='ipv4']//a")).size() == 0){
				PublicAdminCommons.refreshPageTimes(driver,2);
				WaitStatementUtils.waitForNumberOfElementsToBe(driver, "#ipv4", 1, 20);
			}
			Ip = driver.findElement(By.xpath("//span[@id='ipv4']//a")).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get Ip Address", e);
		}
		return Ip;
	}
	@Step("Enter Account number on the page")
	public void SearchAccountNumber(String accountNumber) {
		try {
			enterAccountNumber(accountNumber); //AccountNumber
			PublicCommon.waitForSec(5);
			WaitStatementUtils.explicitWaitForVisibility(driver,getAccountList().get(0));
			clickonMethod("Account",getAccountList().get(0));
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception.");
		}
	}
	@Step("Switch tenant in MAE page")
	public void SwitchTenant() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(switchTenant));
			clickonMethod("Switch Teanat",getElement(switchTenant));
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception.");
		}
	}
}
