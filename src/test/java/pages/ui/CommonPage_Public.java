package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.astm.commonFunctions.PublicAdminCommons.scrollToOffSet;
import static com.astm.commonFunctions.PublicAdminCommons.getElementText;
import static com.astm.commonFunctions.PublicAdminCommons.switchToTabByIndex;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CommonPage_Public extends BasePage {
	Map<String ,String> orderInfoMap=null;
	Map<String ,String> orderHistoryDetailsMap=null;
	MembershipBecomeMemberPage newMembershipPage;
	AllCustomerPage_PublicAdmin AllCustomerPage;
	PublicSearchPage searchPage;
	AccountCreationPage_PublicAdmin AccountCreationPage;
	AccountDropDownMenuPage_RAP accountdropdown;
	StandardProductPage_Public standardProductPage;
	BillingAddressPage_Public BillingAddressPage;
	PaymentDetailsPage_Public paymentDetails;
	MenuNavigationPage_PublicAdmin adminMenuNavigation;
	CustomerLogin_Public loginPage;
	MyAccountPage_Public accountpage;
	MembershipPage_Public membershipPage;
	OrderInformationPage_PublicAdmin orderInformation;
	private CreateNewOrderPage_PublicAdmin CreateOrderPage;
	BillingAddressPage_Public billingAddressPagePublic;
	HomePage_Public homePagePublic;
	JsonFileReader jsonFileReader;
	Actions action;
	public CommonPage_Public(WebDriver driver) {
		super(driver);
		orderInfoMap=new LinkedHashMap<>();
		orderHistoryDetailsMap=new LinkedHashMap<>();
		newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
		AllCustomerPage = getInstance(AllCustomerPage_PublicAdmin.class);
		searchPage = getInstance(PublicSearchPage.class);
		accountdropdown = getInstance(AccountDropDownMenuPage_RAP.class);
		AccountCreationPage = getInstance(AccountCreationPage_PublicAdmin.class);
		standardProductPage=getInstance(StandardProductPage_Public.class);
		BillingAddressPage=getInstance(BillingAddressPage_Public.class);
		paymentDetails=getInstance(PaymentDetailsPage_Public.class);
		adminMenuNavigation=getInstance(MenuNavigationPage_PublicAdmin.class);
		loginPage=getInstance(CustomerLogin_Public.class);
		accountpage=getInstance(MyAccountPage_Public.class);
		membershipPage=getInstance(MembershipPage_Public.class);
		orderInformation=getInstance(OrderInformationPage_PublicAdmin.class);
		CreateOrderPage =getInstance(CreateNewOrderPage_PublicAdmin.class);
		billingAddressPagePublic=getInstance(BillingAddressPage_Public.class);
		homePagePublic = new HomePage_Public(driver);
		AllCustomerPage=getInstance(AllCustomerPage_PublicAdmin.class);
		jsonFileReader = new JsonFileReader();
		action = new Actions(driver);
	}
	private By breadcrumbsSections = By.xpath("//*[@class='breadcrumbs']//ul//li");
	public By journalsMouseHoverLink=By.xpath("(//a[contains(text(),'Journals')])");
	public By stpLinkInSideNav=By.xpath("//a[@class='nav-link child ']/span[text()='Symposia Papers & STPs']");
	public By manualsLinkInSideNav=By.xpath("//a[@class='nav-link child ']/span[text()='Manuals, Monographs, & Data Series']");
	public By storeLogo=By.xpath("//a[@aria-label='store logo']/img");
	public By MemupdatecompleteComment=By.xpath("//div[text()='Membership Manual Committee Updates are complete.']");
    public By ebsNumber = By.xpath("//th[text()='EBS Order Number']//following-sibling::td");
	public By mcsButton = By.xpath("//button[contains(text(),'Go To MCS')]");
	private By accountButtonStatus = By.xpath("//*[@class='navbar-nav']//*[contains(@class,'fa-user-circle')]/../span");// returns
	private By languageLink = By
			.xpath("//div[@class='astm-dropdown dropdown nav item']//*[contains(text(),'Languages')]");
	public By contactLink = By.linkText("Contact");
	public By cartLink = By.xpath("//span[text()='Cart']");
	public By policiesLink = By.linkText("Policies");
	public By emailSubscriptionSettingsLink = By.xpath("//ul//a[contains(text(),'Email Subscription')]");
	public By privacyPolicyLink = By.linkText("Privacy Policy");

	// public By signInLink = By.xpath("//button[@type='button'][contains(.,'SignIn')]");
	public By getInvolved1 = By.xpath("(//a[@id='getinvolvedDropdownMenuLink'])[1]");
	public By anniversary = By.xpath("(//a[text()='125th Anniversary'])[1]");
	public By ConsumerParticipation = By.xpath("(//a[text()='Consumer Participation'])[1]");
	public By ConsumerParticipation_dropdownValues = By.xpath("(//a[text()='Consumer Participation'])[1]//following-sibling::ul//li//a");

	public By anniversary_dropdownValues = By.xpath("(//a[text()='125th Anniversary'])[1]//following-sibling::ul//li//a");
	public By dropdownValues(int value){
		return By.xpath("((//a[text()='Consumer Participation'])[1]//following-sibling::ul//li//a)["+value+"]");
	}
	public By personalcerification = By.xpath("(//h4[contains(text(),'Personnel Certification')])[1]");
	public By learnmoreunderpersonalcerification = By.xpath("//section[@class='content-body astm-type-body--lead border-top']/a[@href='https://credentialing.training.astm.org/']");
	public By SignInLink = By.xpath("//div[contains(@class,'user-menu-options-dropdown')]");

	public By signInLink = By.xpath("//span[contains(text(),'SIGN IN') or contains(text(),'Sign In')]");
	public By signInDropDown = By.xpath(
			"//div[@class='astm-dropdown dropdown user-menu-options-dropdown']//span[contains(text(),'Sign In')]");
	public By signInLinkUnderDropDown = By.xpath("//a[contains(text(),'Sign In')]");
	public By signInButton = By.xpath("(//span[contains(text(),'Sign In')])[1]");
	public By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");
	public By continueButton = By.xpath("//button[@id='save_and_continue']");
	public By addContinue = By.xpath("//span[text()='Continue']");
	public By saveButton = By.xpath("//div[@class='page-actions floating-header']/button[@id='save']");
	public By AddAttributePageSaveBtn = By.xpath("//button[@id='save-button']");
	public By ProductPurchaseBtn = By.xpath("(//button[@class=\"action tocart primary\"])[1]/span");
	public By saveCustomerButton = By.xpath("//div[@class='page-actions-buttons']/button[@id='save']");
	public By saveCustomerBTN=By.cssSelector("#save");
	public By saveAndContinueEdit = By.xpath("//span[text()='Save and Continue Edit']");
	public By checkboxdropdown = By.xpath("//button[@class='action-multicheck-toggle']");
	public By AddressValidationHeader = By.xpath("//header[@class='modal-header']/h1[contains(text(),'Address Validation')]");
	public By AddressValContinueBtn = By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']/span[text()='Continue']");
	private By ebsOrderStatus = By.cssSelector("span#ebs_order_status");
	private By MAEOrderStatus = By.cssSelector("span#mae_status");
	private By OrderType = By.cssSelector("div > div.admin__page-section-item-content > table > tbody > tr:nth-child(5) > td");
	public By selectAllcheckbox = By.xpath("(//span[contains(text(),'Select All')])[1]");
	public By addnewaddress = By.xpath("//button[@class='add-new-address-button action-basic']");
	public By loginLink = By.partialLinkText("Login");
	public By myASTMLink = By.xpath("//div[contains(@class,'right-navbar')]//button");
	public By addproductSKU = By.xpath("//span[text()='Add Products By SKU']");
	public By SKUnumberTextbox = By.xpath("//td[@class='col-sku']/input[@name='sku']");
	public By QuantityTextbox = By.xpath("//div[@class='input-box']/input[@id='sku_qty_0']");
	public By contact = By.xpath("//select[@id='order-billing_address_customer_contact_id']");

	public By serpFirstDoc = By.xpath("(//h4[contains(@class,'searchComponent_title')]/a)[1]");
	public By closepopup_firsttime = By.xpath("//i[@id='custom-close-overlay']");
	public By addProductBtn = By.xpath("//button[@id='add_products']/span");
	public By addskunumber = By.xpath("//td[@class=' col-sku']/input[@name='sku']");
	public By AddAnotherBtn = By.xpath("//div[@class='input-box']/input[@id='sku_qty_0']/../../../td[3]//button[@title='Add another']");
	public By AddToOrderBtn = By.xpath("//div[@id='order-additional_area']/div/div/button[@title='Add to Order']");
	public By startDate1 = By.xpath("(//input[@data-datetime='start-date']/../button)[1]");
	public By startDateInput = By.xpath("//input[@data-datetime='start-date']");
	public By publishDateInput = By.xpath("//input[@data-datetime='publish-date']");
	public By publishDateInput2 = By.xpath("(//input[@data-datetime='publish-date'])[2]");
	public By startDateInput2 = By.xpath("(//input[@data-datetime='start-date'])[2]");
	public By startDate2 = By.xpath("(//input[@data-datetime='start-date']/../button)[2]");
	public By GoToday = By.xpath("//button[text()='Go Today']");
	public By closebtn = By.cssSelector("#ui-datepicker-div > div.ui-datepicker-buttonpane.ui-widget-content > button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all");
	public By publishDate1 = By.xpath("(//input[@data-datetime='publish-date']/../button)[1]");
	public By publishDate2 = By.xpath("(//input[@data-datetime='publish-date']/../button)[2]");
	public By checkBox = By.xpath("//input[@class='checkbox admin__control-checkbox']");
	public By searchgridBtn = By.xpath("(//div[@class='admin__filter-actions']/button[@class='action-default scalable action-secondary'])[2]");
	public By addqty = By.xpath("//input[@id='sku_qty_0']");
	public By addtoOrderbutton = By.xpath("//button[@data-ui-id='widget-button-10']");
	public By AddressDescriptionLabel = By.xpath("(//label[@class='label admin__field-label']/span[text()='Address Description'])[1]");
	public By contactBillingAddress = By.xpath("//select[@name='order[billing_address][customer_contact_id]']");
	public By ContactBillingAddressValidation = By.cssSelector("#order-billing_address_customer_contact_id");
	public By contactShippingAddress = By.xpath("//select[@name='order[shipping_address][customer_contact_id]']");
	public By ContactShippingAddressValidation = By.cssSelector("#order-shipping_address_customer_contact_id");

	public By AddressInformationLabel = By.xpath("//span[text()='Address Information']");
	public By StreetAddressLabel = By.xpath("(//span[text()='Street Address'])[1]");
	public By selectContactBillingAddress = By.xpath("//select[@name='order[billing_address][customer_contact_id]']/option");
	public By selectContactShippingAddress = By.xpath("//select[@name='order[shipping_address][customer_contact_id]']/option");

	public By majorpromocode = By.xpath("//select[@name='order[promo_code_major]']");
	public By minorpromocode = By.xpath("//select[@name='order[promo_code_minor]']");
	public By orderchannel = By.xpath("//select[@name='order[sales_channel]']");
	public By submitorderButton = By.xpath("//button[@id='submit_order_top_button']");
	public By SubmitOrderBottom = By.xpath("//div[@class='order-totals-actions']//button[@title='Submit Order']");
	public By SubmitorderPopupOkBtn = By.xpath("//button[@class='action-primary action-accept']");
	public By addSelectedProduct = By.xpath("//button[@title='Add Selected Product(s) to Order']");
	public By eMailAddress = By.xpath("//input[@name='customer[email]']");
	public By CommunicationEmail = By.xpath("//input[@name='customer[communication_email]']");
	public By OrganizationName = By.xpath("//input[@name='customer[organization_name]']");

	public By searchButton = By.xpath("(//button[@title='Search'])[2]");
	public By publicSearchButton = By.xpath("(//button[@aria-label='Search'])[2]");
	public By selectsearchedcustomer = By.xpath("(//tbody)[1]");
	public By enterEmail = By.xpath("//input[@name='email']");
	public By enterCommunicationEmail = By.xpath("//input[@name='communication_email']");
	public By firstName = By.xpath("//input[@name='customer[firstname]']");
	public By lastName = By.xpath("//input[@name='customer[lastname]']");
	public By phoneNumber = By.xpath("//input[@name='customer[phone_number]']");
	public By phonenumber = By.xpath("//div[@class='admin__field-control']/input[@name='telephone']");
	public By zipcode = By.xpath("//div[@class='admin__field-control']/input[@name='postcode']");
	public By streetaddress = By.xpath("//div[@class='admin__field-control']/input[@name='street[0]']");
	public By country = By.xpath("//div[@class='admin__field-control']/select[@name='country_id']");
	public By state = By.xpath("//div[@class='admin__field-control']/select[@name='region_id']");
	public By city = By.xpath("//div[@class='admin__field-control']/input[@name='city']");
	public By onlineSubscriptions = By.xpath("//a[text()='Online Subscriptions']");
	public By astmLogo = By.xpath("//a[@class='navbar-brand']//img");
	public By TelephoneNo = By.xpath("//div[@class='admin__field-control']/input[@name='customer[phone_number]']");
	public By SaveCustomer = By.xpath("//button[@id='save']");
	public By apiLogo = By.cssSelector("*[src*='images/logo/logo.png']");
	private By searchCombobox = By.xpath("(//input[contains(@placeholder,'Search topic')])[2]");
	public By EnvironmentalProductDeclarations = By.xpath("//div[@class='mst-search__index-title']//a[contains(text(),'Environmental Product Declarations')]");
	public By searchIcon = By.xpath("(//header//i[@class='fa fa-search'])[3]");
	public By informationTab = By.xpath("//div[@class='webm']//a[@href='https://qa.astm.org/catalogsearch/result/index/?index=8&q=%22Vinyl+Composition+Tile%22']");
	public By searchASTM = By.xpath("(//div[@class='mst-search__index-title']//span[contains(text(),'What is ASTM')])[1]");
	public By searchhowtogetinvolved = By.xpath("(//div[@class='mst-search__index-title']//span[contains(text(),'How to Get involved')])[1]");
	public By searchASTMinsightSQC = By.xpath("(//div[@class='mst-search__index-title']//span[contains(text(),'ASTM insight SQC')])[1]");
	public By searchMarketintelligence = By.xpath("(//div[@class='mst-search__index-title']//span[contains(text(),'Market Intelligence')])[1]");
	public By footerSearchIcon = By.xpath("//div[@class='control p-0 col-md-12 d-flex']//i[@class='fa fa-search']");
	public By searchResults = By.cssSelector(".webm li:nth-child(1) .product-item-link");
	public By searchResultsCMSInfo=By.xpath("//div[@class='web']//div[@class='mst-search__index mst-search__index-magento-cms-page']");
	public By searchResultsPAndS=By.xpath("//div[@class='webm']//ol[@class='products list items product-items']");
	public By footerReadingRoom=By.xpath("//div[@class='footer-content bg-primary']//a[text()='Reading Room']");
	public By requestDemo1 = By.xpath("(//*[@class='btn-contact btn astm-btn btn-primary mb-2'])[1]");
	public By requestDemo2 = By.xpath("(//*[@class='btn-contact btn astm-btn btn-primary mb-2'])[2]");
	public By joinNow = By.xpath("//a[contains(text(),'Join Now')]");
	public By standardbycategory= By.xpath("//*[contains(text(),'Browse Standards by Category')]");
	private By headerSearchDropdown = By.cssSelector("header[class*='page-header'] .header-search");
	public By copydesignation(int no) { return By.xpath("//div[@class='astm-type-body--lead']/p["+no+"]"); }
	public By nocommitteeaffiliation = By.xpath("//button[contains(text(),'No Committee Affiliation')]");
	public By transportablemoisturelimitofcoal = By.xpath("(//a[@href='https://qa.astm.org/ptptmlc2022.html'])[2]");
	public By productsAndServices = By.xpath("//a[contains(text(),'Products & Services')]");
	public By productsAndServicesNavigation = By.xpath("(//*[@id='productsDropdownMenuLink'])[1]");// By.xpath("(//*[@id='navbarDropdownMenuLink'])[1]");
	public By productsAndServicesNavigationMobile = By
			.xpath("//*[@id='navbarNavDropdown']//*[@id='productsDropdownMenuLink']"); // (//*[@id='navbarDropdownMenuLink'])[5]
	public By marketintelligence = By.xpath("(//ul[@class='col-md-6 col-12']//a[contains(text(),'Market Intelligence')])[1]");
	public By petrolumreferencematerial = By.xpath("(//a[@href='https://qa.astm.org/products-services/petroleum-reference-materials.html'])[1]");
	public By wohlersreport = By.xpath("(//ul[@class='col-md-6 col-12']//a[contains(text(),'Wohlers Report')])[1]");
	public By wohlerassociatelink = By.xpath("//a[text()='wohlersassociates.com/2022report']");
	public By marketintelligenceHeader = By.xpath("//h2[contains(text(),'Market Intelligence')]");
	public By wohlersreportHeader = By.xpath("//h2[(text()='Wohlers Report')]");
	public By petroleumreferencematerialVideo = By.xpath("//div[@class='landing-header mw-730 card']");
	public By petroleumreferencematerialfooterheading = By.xpath("//h4[contains(text(),'Request your samples and start improving your processes and equipment today.')]");
	public By petroleumreferencematerialfootercontactUs = By.xpath("//h4[@class='astm-type-heading--h4 mb-3 pt-2']/following::a[@href='mailto:refmat@astm.org']");
	public By unlimitedaccessnowavailable = By.xpath("//h5[(text()='Unlimited Access Now Available')]");
	public By learnmoreaboutASTMrefmats = By.xpath("//a[@href='http://astmrefmat.training.astm.org/#/']");
	public By marketintelligenceotherheadings = By.xpath("//div[@class='border-bottom pb-3 mb-3']");
	public By contactUsundermarketintelligence = By.xpath("//div[@class='mb-2 pt-2']//a[@class='btn-contact btn astm-btn btn-primary mb-2']");
	public By contactUsunderwohlerreport = By.xpath("//div[@class='border-bottom mb-3']//a[@class='btn-contact btn astm-btn btn-primary mb-4']");
	public By learnmoreaboutwohlersbutton = By.xpath("//*[contains(text(),'Learn more about Wohlers')]");
	public By learnmoreaboutwohlersimage = By.xpath("//img[@class='mb-3']");
	public By membershipHeader = By.xpath("//h4[text()='Membership']");
	public By participatingHeader = By.xpath("//h1[text()='Thank you for your interest in membership.']");
	public By standardsAndPublicationsOptions = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Standards & Publications')]");

	public By standardsAndSolutions = By.xpath("//button[contains(text(),'Standards & Solutions')]");
	public By signOutMenu= By.xpath("//span[@data-testid='usernameBtn']");
	public By signOutLink= By.xpath("//button[text()='Sign Out']");

	public By LaboratoryServicesOptions = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Laboratory Services')]");
	public By BookfStandardsOptions = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Book of Standards')]");
	public By fontenotmaillink = By.xpath("//a[@href='mailto:afontenot@astm.org']");
	public By phoneNoUnderdvisoryservices = By.xpath("//div[@class='mb-2 pt-2']/span[contains(text(),'877-909-2786')]");
	public By phoneNoUndercontactustodayforallyourAMconsultingneeds = By.xpath("//div[@class='mb-1']/span[contains(text(),'877-909-2786')]");
	public By ptpmailLink = By.xpath("//a[@href='mailto:ptp@astm.org']");
	public By PTPShippingPolicy = By.xpath("//*[text()='ASTM PTP Shipping Policy:']");
	public By fontenotphonenumber = By.xpath("//a[@href='tel:+16108329748']");
	public By standardsProducts = By.xpath("(//a[@class='dropdown-item'][contains(text(),'Standards Products')])[1]");
	public By technicalReports=By.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Technical Reports']");
	public By wohlerimage = By.xpath("//img[@src='https://qa.astm.org/media/wysiwyg/wohlers-report.png']");
	private By bookOfStandardsOptions = By.xpath(
			"//nav[contains(@class,'astm-navbar')]//li[@class='dropdown-submenu']/preceding-sibling::li/a[contains(text(),'Book of Standards')]");
	private By annualBookOfStandards = By.xpath("//a[contains(text(), 'Annual Book of Standards')]");
	private By readingRoomOptions = By.xpath(
			"//nav[contains(@class,'astm-navbar')]//li[@class='dropdown-submenu']/preceding-sibling::li/a[contains(text(),'Reading Room')]");
	public By readingRoomInSAndP=By.xpath("//nav[contains(@class,'astm-navbar')]//ul[@class='dropdown-menu show']//a[text()='Reading Room']");
	private By trackerServicesOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Tracker Services')]");
	private By catalogsOptions = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Catalogs')]");

	public By standardsAndPublicationsOptionsOnMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Standards & Publications')]");
	private By bookOfStandardsOptionsOnMobile = By.xpath(
			"//nav[contains(@class,'main-nav-mobile')]//li[@class='dropdown-submenu']/preceding-sibling::li/a[contains(text(),'Book of Standards')]");
	private By readingRoomOptionsOnMobile = By.xpath(
			"//nav[contains(@class,'main-nav-mobile')]//li[@class='dropdown-submenu']/preceding-sibling::li/a[contains(text(),'Reading Room')]");
	private By trackerServicesOptionsOnMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Tracker Services')]");
	public By catalogsOptionsOnMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Catalogs')]");
	public By specbuilderOption = By.xpath("//nav[contains(@class,'astm-navbar')]//*[text()='SpecBuilder']");
	public By specBuilderOptionMobile = By.xpath("//nav[contains(@class,'main-nav-mobile')]//*[text()='SpecBuilder']");
	public By ASTMCompassOption = By.xpath("//nav[contains(@class,'astm-navbar')]//*[contains(text(),'ASTM Compass')]");
	public By ASTMCompassOptionMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//*[text()='ASTM Compass�']");
	public By integratedServicesOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//*[text()='Integrated Services']");
	public By integratedServicesOptionsMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//*[text()='Integrated Services']");
	public By digitalLibraryOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Digital Library')]");
	public By digitalLibraryOptionsOnMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Digital Library')]");
	private By enterpriseSolutionsOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Enterprise Solutions')]");
	public By customPlatforms=By.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Custom Platforms']");
	public By enterpriseSolutionsOptionsMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Enterprise Solutions')]");
	public By proficiencyTestingOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Proficiency Testing')]");
	public By crosscookie = By.className("onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon");
	public By accepttermsbutton = By.xpath("//div[@class='actions mt-4 d-flex']/a[@href='https://qa.astm.org/customer/account/create/']");
	public By confirmaddresswindow = By.xpath("//h1[@id='modal-title-16']");

	public By useselectedaddress = By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']");
	public By trainingCoursesOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Training Courses ')]");
	public By memberAndOfficerTraining=By.xpath("//nav[contains(@class,'astm-navbar')]//*[text()='Member and Officer Training']");
	public By PEContinuiningEducation=By.xpath("//nav[contains(@class,'astm-navbar')]//*[text()='PE Continuing Education']");
	public By internationalTraning=By.xpath("//nav[contains(@class,'astm-navbar')]//*[text()='International Training']");
	public By allTraningCourses=By.xpath("//nav[contains(@class,'astm-navbar')]//*[contains(text(),'All Training')]");
	public By trainingCoursesOptionsMob = By
			.xpath("//nav[contains(@class,'main-nav-mobil')]//a[contains(text(),'Training Courses ')]");
	public By AlltrainingCoursesOptionsMob = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'All Training Courses')]");
	public By whatisASTM = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'What is ASTM')]");
	public By howtogetinvolved = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'How to Get Involved')]");
	public By trainingandresources = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Training and Resources')]");
	public By ASTMinsightSQC = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'ASTM Insight SQC')]");
	public By StandardProduct = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Standards Products')]");
	private By certificationOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Certification')]");
	private By cementNConcreteReferenceLabOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Cement & Concrete Reference Lab')]");
	private By ccrlOptionMobile = By.xpath(
			"//*[@id='navbarNavDropdown']//a[@class='dropdown-item' and contains(text(),'Cement & Concrete Reference Lab')]");

	private By ccrlLogo = By.xpath("//*[@src='Images/ASTM_Logo_White.png']");

	private By standardsAndPublicationsCategoriesList = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Standards & Publications')]/..//li/a");
	private By standardsAndPublicationsCategoriesListMobile = By.xpath(
			"//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Standards & Publications')]/following-sibling::ul//li//a");
	private By enterpriseSolutionsList = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Enterprise Solutions')]/..//li/a");
	private By enterpriseSolutionsListForMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Enterprise Solutions')]/..//li/a");
	private By trainingCoursesList = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Training Courses ')]/..//li/a");

	public By getInvolvedNavigation = By
			.xpath("(//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Get Involved')])[1]");
	public By newsANDeventsoption = By.xpath("//a[@class='nav-link child ']//span[text()='News and Events']");
	public By getConsumerParticipation = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Consumer Participation')]");
	public By meetingsAndSymposia=By.xpath("//div[@class='dropdown-menu nav-submenu-with-bg m-0 row get-involved show']//a[text()='Meetings & Symposia']");
	public By futureCommitteePDFLink = By.xpath("//a[contains(text(),'Future Committee Week Locations (PDF)')]");
	public By HeaderMeetingsSymposia = By.xpath("//h1");
	public By getMeetingsAndSymposiaLink = By.xpath("//a[text()='Meetings & Symposia']");
	public By getGetInvolvedLink = By.xpath("//a[text()='Get Involved']");
	public By technicalCommitteesOption = By.xpath("//a[contains(text(),'Technical Committees')]");
	public By viewAllEvents = By.xpath("//a[text()='View All Events']");
	public By getInvolvedNavigationMobile = By.xpath("(//*[@id='navbarDropdownMenuLink'])[6]");

	public By technicalCommitteesOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Technical Committees')]");
	public By initiatenewstandards = By.xpath("//*[@href='/get-involved/technical-committees/new-standards-development.html']");
	public By membershipOptions = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Membership')]");
	public By initiationofnewactivity = By.xpath("//*[contains(text(),'Initiation of New Activity')]");
	private By meetingsNSymposiaOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Meetings & Symposia')]");
	public By studentsNProfessorsOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Students & Professors')]");
	public By studentsOptionsMob = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'For Students')]");
	public By publishWithASTMOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Publish With ASTM')]");
	public By publishWithASTMOptionsMobile = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Publish With ASTM')]");
	public By membershipTypes = By.xpath("//span[contains(text(),'Membership Types')]");
	public By membership = By.xpath("//h1[text()='Membership']");
	public By membershipContent = By.xpath("//p[contains(text(),'Membership with ASTM')]");
	private By studentsNProfessorsList = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Students & Professors ')]/..//li/a");
	private By aboutNavigation = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'About')]");
	public By dEAndI = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(), 'Diversity, Equity, & Inclusion')]");
	public By governance=By.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Governance']");
	public By uopStandard = By.xpath("//a[text()='UOP Standards']");
	private By overviewOptions = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Overview ')]");
	public By corporateCitizenship=By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Corporate')]");
	public By whitePapers=By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'White Papers')]");
	public By factSheet=By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Fact Sheet')]");
	public By detailedOverview=By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Detailed Overview')]");
	public By overviewUnderOverview=By.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Overview']");
	private By faqsOptions = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'FAQs')]");
	private By leadershipTeamOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Leadership Team')]");
	private By governanceOptions = By
			.xpath("(//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Governance')])[1]");
	private By historyOptions = By.xpath("(//nav[contains(@class,'astm-navbar')]//a[contains(text(),'History ')])[1]");
	// private By globalCooperationOptions =
	// By.xpath("(//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Global
	// Cooperation')])[1]");
	private By globalCooperationOptions = By.xpath("//a[text()='Global Cooperation ']");

	public By presidentColumnOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'s Column')]");
	private By overviewList = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Overview ')]/..//li/a");
	private By governanceList = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Governance')]/..//li/a");
	private By historyList = By.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'History ')]/..//li/a");
	private By globalCooperationList = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Global Cooperation ' )]/..//li/a");
	private By newsNavigation = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[@id='newsDropdownMenuLink' and contains(text(),'News')]");
	private By standardizationNewsOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Standardization News')]");
	private By magazinesNNewslettersOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'Magazines & Newsletters')]");
	private By newsReleasesOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'News Releases')]");
	private By ASTMNewsOptions = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[contains(text(),'ASTM in the News')]");
	private By symposiaPapersAndSTPs = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Symposia Papers & STPs']");
	public By manualsMonogramsAndData = By
			.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Manuals, Monographs, & Data Series']");

	// Member Promo Section
	private By memberPromoSection = By.xpath("//*[@id='info-membership']");
	private By memberPromoStatGlobalASTMStandards = By.xpath(
			"//*[@id='info-membership']//*[@class='row']//span[contains(@class, 'stat-title') and contains(text(), 'Global ASTM Standards')]/preceding-sibling::span[@class='stat-number']");
	private By memberPromoStatPartnerCountries = By.xpath(
			"//*[@id='info-membership']//*[@class='row']//span[contains(@class, 'stat-title') and contains(text(), 'Partner Countries')]/preceding-sibling::span[@class='stat-number']");
	private By memberPromoStatVolunteerMembers = By.xpath(
			"//*[@id='info-membership']//*[@class='row']//span[contains(@class, 'stat-title') and contains(text(), 'Volunteer Members')]/preceding-sibling::span[@class='stat-number']");
	private By memberPromoHeader = By.xpath("//*[@id='info-membership']//*[@class='astm-type-heading--h2']");
	private By memberPromoButtonLink = By.xpath("//*[@id='info-membership']//*[@class='row']//a");
	private By memberPromoButtonText = By.xpath("//*[@id='info-membership']//*[@class='row']//a//button");
//	public By journals = By.xpath("(//a[(@class='dropdown-item') and contains(@href,'journals')])[1]");
	public By journals = By.xpath("(//a[contains(@href,'journals')])[1]");
	public By ProficiencyTesting = By.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Proficiency Testing']");
	public By PTPheader = By.xpath("//h2[contains(text(),'Proficiency Testing')]");
	public By BookOfStandarsHeader = By.xpath("//h2[text()='Annual Book of ASTM Standards']");
	public By HeaderCardTitle = By.xpath("//h2[contains(@class,'title')]");
	public By ViewAllBtn = By.xpath("//h4[@class='card-header astm-type-heading--h4']/a");
	public By allStandardsHeader = By.xpath("//h2[contains(@class,'title')]");
	public By SymposiaHeader = By.xpath("//div[contains(@class,'wysiwygContainer')]/h2");
	public By manualsHeader = By.xpath("//div[contains(@class,'wysiwygContainer')]/h2");
	public By STPLink = By.xpath("//div[contains(@class,'wysiwygContainer')]/p[1]/a");
	public By STPLink_5 = By.xpath("//div[contains(@class,'wysiwygContainer')]/p[5]/a");
	public By STPLink_2 = By.xpath("//div[contains(@class,'wysiwygContainer')]/p[2]/a");

	public By ManualLink = By.xpath("//div[@class='all-container']/h1/../../div[2]/p[1]/a");
	public By BOSPrintFormatAddToCart = By.cssSelector("#product_addtocart_form_2868698 > button");
	public By BOSPrintFormatAddToCart_25 = By.cssSelector("#product_addtocart_form_2868698 > button");
	public By BOSOnlineFormatAddToCart = By.cssSelector("#product_addtocart_form_4141216 > button");
	public By AddToCart = By.xpath("//button[@title='Add to Cart']");
	public By addToCartBtn=By.xpath("//button[@title='Add to Cart' and contains(@class,'astm-btn')]");
	public By addToCartSuccessMsg=By.xpath("//div[@class='prepare-message astm-alert-text']");
	public By ProductPageTitle = By.xpath("//span[@class='base']");
	public By RegisterForAprogram = By.xpath("//a[text()='Register for a Program']");
	public By PTPpageHeader =By.xpath("//span[text()='Register For Multiple PTP Programs']");
	public By PTPOptions =By.xpath("//h4[text()='Proficiency Testing Program Options']");

	public By ProductName = By.xpath("//h3[@class='astm-type-heading--h3']/b");
	public By shoppingCartLink = By.linkText("shopping cart");
	public By cartButton=By.xpath("//span[text()='Cart']");
	public By ShoppingCartMessage = By.xpath("//div[@class='prepare-message astm-alert-text']");
	public By PTPprogramPage = By.xpath("//h1/span");
	public By PTPprice = By.xpath("//span[@class='price']");
	public By RegisterProgramBtnInPTPpage = By.xpath("//button[@title='Register for this Program']");
	public By PTPAlertMsg = By.xpath("//div[contains(@class,'alert-text')]");

	public By journalsMob = By.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Journals')]");
	public By ManualsMob = By.xpath(
			"//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Manuals, Monographs, & Data Series')]");
	private By BOSImage = By.xpath("//nav[contains(@class,'astm-navbar')]//img[contains(@src,'bookstore.jpg')]");
	private By NEWSOptionsHeader = By.xpath("//nav[contains(@class,'astm-navbar')]//span[text()='NEWS']");
	private By aboutOptionsHeader = By
			.xpath("//nav[contains(@class,'astm-navbar')]//span[text()='OVERVIEW & KEY FACTS']");
	private By getInvolvedOptionsHeader = By
			.xpath("//nav[contains(@class,'astm-navbar')]//span[text()='MEMBERSHIP & MEETINGS']");
	private By compassImage = By.xpath("//nav[contains(@class,'astm-navbar')]//img[contains(@src,'compass-new-logo')]");
	private By newsImage = By
			.xpath("//nav[contains(@class,'astm-navbar')]//img[contains(@src,'MA21-SN-Cover-sm.jpg')]");
	private By newsDropDownImage = By
			.xpath("//nav[contains(@class,'astm-navbar')]//div[@aria-labelledby='newsDropdownMenuLink']//img");
	private By aboutImage = By.xpath("//nav[contains(@class,'astm-navbar')]//img[contains(@src,'about-nav')]");
	private By getInvolvedImage = By
			.xpath("//nav[contains(@class,'astm-navbar')]//img[contains(@src,'get-involved-nav')]");
	private By allStandardsAndPublications = By
			.xpath("(//a[@class='dropdown-item'][contains(text(),'All Standards and Publications')])[1]");
	public By allStandardsAndPublicationsMob = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//*[contains(text(),'All Standards and Publications')]");
	public By standardsProduct = By.xpath("(//a[@class='dropdown-item'][contains(text(),'Standards Products')])[1]");
	// Industry Sectors
	private By industrySectionOnHomepage = By.xpath("//*[@class='home-choose-industry bg-primary']");
	private By interestedInTextField = By.xpath("//*[@class='home-choose-industry bg-primary']//div[@class='row']/h4");
	private By currentIndustrySelection = By
			.xpath("//*[@class='home-choose-industry bg-primary']//div[@class='row']//*[@class='industry-link']/a");
	public By industrySectorDropDownButton = By
			.xpath("//*[@class='home-choose-industry bg-primary']//*[@class='astm-dropdown dropdown']//button");
	private By industrySectorOptions = By
			.xpath("//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a");

	private By industrySectorChemicalOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'Chemicals')]");
	private By industrySectorBuildingConstructionOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'Building Construction')]");
	private By industrySectorMetalsOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'Metals')]");
	private By industrySectorEnvironmentOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'Environment')]");
	private By industrySectorOilAndGasOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'Oil & Gas')]");
	private By industrySectorEnergyAndUtilitiesOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'Energy & Utilities')]");
	private By industrySectorManufacturingOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'Manufacturing')]");
	private By industrySectorAllIndustriesOption = By.xpath(
			"//*[@class='home-choose-industry bg-primary']//*[@class='dropdown-menu show']/a[contains(text(), 'All Industries')]");

	// Footer Elements
	private By footerSocialIcons = By.xpath("//*[@class='footer-social-icons']//a");
	private By footerSocialIconsTwitter = By
			.xpath("//*[@class='footer-social-icons']//*[contains(@class, 'fab fa-twitter-square')]");
	private By footerSocialIconsFacebook = By
			.xpath("//*[@class='footer-social-icons']//*[contains(@class, 'fab fa-facebook-square')]");
	private By footerSocialIconsYoutube = By
			.xpath("//*[@class='footer-social-icons']//*[contains(@class, 'fab fa-youtube-square')]");
	private By footerSocialIconsLinkedln = By
			.xpath("//*[@class='footer-social-icons']//*[contains(@class, 'fab fa-youtube-square')]");
	private By footerSocialIconsInstagram = By
			.xpath("//*[@class='footer-social-icons']//*[contains(@class, 'fab fa-instagram-square')]");
	private By footerSocialIconsRSSFeed = By
			.xpath("//*[@class='footer-social-icons']//*[contains(@class, 'fas fa-rss-square')]");
	public By catalogButton = By.xpath("//*[@id='menu-magento-catalog-catalog']");
	public By customerButton = By.xpath("//*[@id='menu-magento-customer-customer']");
	public By salesButton = By.xpath("//*[@id='menu-magento-sales-sales']");
	public By contacts = By.xpath("//span[text()='Contacts']");
	public By addNewContact = By.xpath("//span[text()='Add New Contact']");
	public By createneworderButton =By.xpath("//button[@title='Create New Order']");
	public By createOrder = By.xpath("//button[@id='order']");
	public By contentButton = By.xpath("//*[@id='menu-magento-backend-content']");
	public By categoriesLink = By.linkText("Categories");
	public By productLink = By.linkText("Products");
	public By allcustomersLink = By.linkText("All Customers");
	public By ordersLink = By.linkText("Orders");
	public By addnewcustomerButton = By.xpath("//button[@id='add']");
	public By pagesLink = By.linkText("Pages");
	public By ViewBtn = By.xpath("//a[text()='View']");
	public By Adminsearchbykeyword = By.xpath("(//input[@class='admin__control-text data-grid-search-control'])[1]");
	public By Adminsearchicon = By.xpath("(//input[@class='admin__control-text data-grid-search-control']/following::button[@class='action-submit'])[1]");
	public By ClearAllBtn = By.xpath("(//button[text()='Clear all'])[1]");
	public By select = By.xpath("//button[text()='Select']");
	public By edit = By.xpath("//a[text()='Edit']");
	public By editWithPageBuilder = By.xpath("//span[text()='Edit with Page Builder']");//div[text()='You saved the block.']
	public By saveSuccess_Block = By.xpath("//div[text()='You saved the block.']");
	public By blockLink = By.linkText("Blocks");
	public By ASTMattributeCollapisible = By.cssSelector("#container > div > div.entry-edit.form-inline > div:nth-child(7) > div.fieldset-wrapper-title");
	public By AssetType=By.xpath("//span[text()='Asset Type']");
	public static By PublicOrderAttribute = By.xpath("//input[@name='product[disable_public_order]']");
	public By astmAttributes = By.xpath("//div[@class='fieldset-wrapper-title']//span[text()='ASTM Attributes']");
	public By standardfamily = By.xpath("//input[@name='product[standard_family]']");
	public By bundlewithstandard = By.xpath("//input[@name='product[bundle_with_standard]'][@value='1']");
	public By inventoryitemstatuscode = By.xpath("//input[@name='product[inventory_item_status_code]']");
	public By getInvolved = By.id("ext-gen34");
	public By filter = By.xpath("(//div[@class='data-grid-filters-action-wrap'])[1]");
	public By editLink = By.xpath("//a[@class='action-menu-item'][contains(text(),'Edit')]");
	public By PDFchild(String text){ return By.xpath("//tr/td//*[text()='"+text+"-PDF']/../preceding::td//following-sibling::div[@class='admin__field-control']//a");}
	public By productwithpdfversionEnabled(String text){
		return By.xpath("//tr/td//*[text()='"+text+"-PDF']/../following::td/div");
	}
	public By eventName(String eventName){
		return By.xpath("(//p[text()='"+eventName+"'])[1]");
	}
	public By getLocationWithEventName(String eventName){
		return By.xpath("(//p[text()='"+eventName+"'])[1]/..//p[3]");
	}
	public By getLocation(String location){
		return By.xpath("(//p[text()='"+location+"'])[1]");
	}
	public By Applyfilter = By.className("action-secondary");
	public By SKUsearch = By.cssSelector("tbody > tr > td:nth-child(7) > div");
	public By CatalogPageSKU = By.xpath("//input[@name='product[sku]']");
	public By title = By.xpath("//div[@class='admin__form-field-control']//input[@name='title']");
	public By urlkey = By.xpath("//div[@class='admin__form-field-control']//input[@name='identifier']");
	public By skuField = By.xpath("//div[@class='admin__form-field-control']//input[@name='sku']");
	public By typeField = By.xpath("//div[@class='admin__form-field-control']//select[@name='type_id']");
	public By searchHeader = By.xpath("(//*[@class='input-text form-control pr-1'])[1]");
	public By customerparticipation = By.xpath("//img[@class='x-tree-ec-icon x-tree-elbow-end-plus']");
	public By whatisASTMundercustomerparticipation = By.id("extdd-25");
	public By howtogetinvolvedundercustomerparticipation = By.id("extdd-37");
	public By footerLinks = By.xpath("//*[@class='footer-content bg-primary']//*[@class='nav-item']//a");
	private By footerHomeLink = By
			.xpath("//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'Home')]");
	private By footerAboutLink = By
			.xpath("//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'About')]");
	private By footerSiteMapLink = By
			.xpath("//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'Site Map')]");
	private By footerSupportLink = By
			.xpath("//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'Support')]");
	private By footerContactLink = By
			.xpath("//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'Contact')]");
	private By footerPoliciesLink = By
			.xpath("//*[@class='footer-content bg-primary']//*[@class='nav-item']//a[contains(text(), 'Policies')]");
	private By footerPrivacyPolicyLink = By.xpath(
			"//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'Privacy Policy')]");
	private By footerAboutCopyrightPermissionsLink = By.xpath(
			"//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'Copyright/Permissions')]");
	private By footerReadinRoomLink = By.xpath(
			"//*[@class='footer-content bg-primary']//*[@class='navbar-nav']//a[contains(text(), 'Reading Room')]");
	private By footerSearchbar = By.xpath("//*[@class='footer-content bg-primary']//*[@id='search-footer']");
	private By footerSearchDropdown = By.xpath("//*[@id='search_mini_form_footer']//select");
	private By footerCopyright = By.xpath("//*[@class='footer-content bg-primary']//*[@class='copyright']//span");

	public By mobileMenuNavigationExpand = By.cssSelector(".navbar-toggler-btn");

	// Product & Services Child
	public By mobileStandardsProduct = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Standards Products')]");
	public By symposiaMob = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Symposia Papers & STPs')]");
	public By mobileDigitalLibrary = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[contains(text(),'Digital Library')]");
	public By mobileProficiencyTesting = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[text()='Proficiency Testing']");
	public By mobileTrainingCourses = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[text()='Training Courses ']");
	public By mobileCertification = By.xpath("//nav[contains(@class,'main-nav-mobile')]//a[text()='Certification']");
	public By mobileCementConcrete = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[text()='Cement & Concrete Reference Lab']");
	private By mobileTrainingCoursesList = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[contains(text(),'Training ' )]/..//li/a");
	public By mobileBookOfStandard = By
			.xpath("//nav[contains(@class,'main-nav-mobile')]//a[text()='Book of Standards']");

	// Get Involved Tab -Locators for Mobile
	public By mobileGetInvolved = By.xpath("(//*[@id='navbarDropdownMenuLink'])[6]");
	public By mobileTechnicalCommittees = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Technical Committees')]");
	public By mobileMembership = By.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Membership')]");
	public By mobileMeetingAndSymposia = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Meetings & Symposia')]");
	public By mobilePublishwithAstm = By.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Publish With ASTM')]");
	public By mobileStudentAndProfessor = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[text()='Students & Professors ']");
	private By mobileStudentAndProfessorList = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[text()='Students & Professors ']/..//li/a");

	// About Tab -Locators for Mobile
	public By mobileAboutNavigationExpand = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[contains(text(),'About')]");
	public By mobileFAQs = By.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='FAQs')]");
	public By mobileLeaderShipTeam = By.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Leadership Team')]");
	public By mobilePresidentsColumn = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()=\"President's Column\")]");
	public By mobileGloabalCooperation = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Global Cooperation ')]");
	private By mobileGlobalCooperationList = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[contains(text(),'Global Cooperation ' )]/..//li/a");
	public By mobileGovernance = By.xpath("//nav[contains(@class,'nav-mobile')]//a[text()='Governance ']");
	private By mobileGovernanceList = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[contains(text(),'Governance ' )]/..//li/a");
	public By mobileHistory = By.xpath("//nav[contains(@class,'nav-mobile')]//a[text()='History ']");
	private By mobileHistoryList = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[contains(text(),'History ' )]/..//li/a");
	public By mobileOverview = By.xpath("//nav[contains(@class,'nav-mobile')]//a[text()='Overview ']");
	private By mobileOverviewList = By.xpath("//nav[contains(@class,'nav-mobile')]//a[text()='Overview ']/..//li/a");

	// News Tab - Locators for Mobile
	public By mobileNews = By.xpath("(//*[@id='navbarDropdownMenuLink'])[8]");
	public By mobileStandardizationNews = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Standardization News')]");
	public By mobileMagazinesNewsletter = By
			.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='Magazines & Newsletters')]");
	public By mobileNewsReleases = By.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='News Releases')]");
	public By mobileAstmInNews = By.xpath("//nav[contains(@class,'nav-mobile')]//a[(text()='ASTM in the News')]");

	// Header and Footer section
	public By footerSection = By.cssSelector("*[class*='footer-content']");
	public By headerSection = By.cssSelector("*[class='page-header m-0 astm-header']");
	private By breadcrumbs = By.cssSelector("*[class='breadcrumb astm-breadcrumb']");
	private By breadcrumbsLinks = By.xpath("//*[@class='breadcrumbs']//ul//a");
	public By handleCookies = By.id("btn-cookie-allow");
	public By cookieAlert = By.className("astm-alert-text");
	public By OneTrustPolicyText = By.id("onetrust-policy-text");
	public By selectAnApplication = By.xpath("//h3[text()='Select an Application']");
	public By CompassCardTitle = By.xpath("//h3[contains(@class,'card-title mb-0')]/span[text()='Compass']");
	public By WebStoreCardTitle = By.xpath("//h3[contains(@class,'card-title mb-0')]/span[text()='Web Store']");
	public By selectCompassBtn = By.xpath("//h3[contains(@class,'card-title mb-0')]/span[text()='Compass']/../../button");
	public By selectWebStoreBtn = By.xpath("//h3[contains(@class,'card-title mb-0')]/span[text()='Web Store']/../../button");
	public By selectAccountInCompass = By.xpath("//h1[text()='Select an Account']/../p[2]/button");
	public By cookiePrivacyPolicy = By.linkText("privacy policy");
	public By renewMembershipLink = By.xpath("//a[contains(text(),'Renew')]");
	public By technicalLink = By.xpath("//a[contains(text(),'Technical Committees & Resources')]");
	public By technicalCommitteeHeader = By.xpath("//h1[text()='Technical Committees']");
	public By virtualClassroom = By.xpath("//a[contains(text(),'Virtual Classroom')]");
	public By virtualClassroomHeader = By.xpath("//h1[text()='Classroom for Members']");
	public By newMemberLink = By.xpath("//a[contains(text(),'New Member')]");
	public By orderMemberPlaqueLink = By.xpath("//a[contains(text(),'Order a')]");
	public By organizationalMembershipLink = By.xpath("//a[contains(text(),'Organizational Member')]");
	public By inviteColleagueLink = By.xpath("//a[contains(text(),'Invite')]");
	public By membershipTypesBenefits = By.xpath("//a[contains(text(),'Membership Types')]");
	public By membershipFAQSLink = By.xpath("//a[contains(text(),'Membership F')]");
	public By contactMemberServicesLink = By.xpath("//a[contains(text(),'Contact Member')]");
	public By aboutASTMHeader = By.xpath("//h1[text()='About ASTM Membership']");
	public By agreementLicenseText = By.xpath("//*[@class='table data section contents']");
	public By responsibilitiesOfMembershipLink = By.xpath("//a[contains(text(),'Responsibilities of')]");
	public By emergingProfessionalLink = By.xpath("//a[contains(text(),'Emerging')]");
	public By memberResourcesHeader = By.xpath("//h1[text()='Member Resources']");
	public By responsibilitiesOfASTMHeader = By.xpath("//h1[contains(text(),'Responsibilities')]");
	public By membershipLink = By.xpath("//span[text()='Membership']");
	public By joinAdditionalCommitteeLink = By.xpath("//a[contains(text(),'Join Additional Committee')]");
	public By CustomerLoginHeader = By.xpath("//span[text()='Customer Login']");
	public By MembershipApplication = By.xpath("//h2[text()='Membership - Application']");
	public By createAnAccountRenew = By.xpath("//span[text()='Create an Account']");
	public By contactSalesLink = By.xpath("//a[contains(text(),'Contact Sales')]");
	public By contactASTMHeader = By.xpath("//h1[text()='Contact ASTM']");
	public By popclose = By.xpath("//*[@id='custom-close-overlay']");
	public By digitalLibraryOverviewButton = By.xpath("//a[contains(text(),'Digital Library Overview')]");
	public By ASTMLogo = By.xpath("//a[@href='https://stage.astm.org/']//img");
	public By latestText = By.xpath("//span[text()='The Latest']");
	public By cartLinkAPI = By.partialLinkText("Cart");
	public By cartLinkAPIText = By.cssSelector("*[href*='checkout/cart']");
	public By meetingsAndSymposiaLeftMenu=By.xpath("//a[text()='Meetings & Symposia']");
	public By clickOncontinueshoppingBtn = By.xpath("//span[text()='Continue Shopping']");
	public By metalsTestMethods = By.xpath("//a[contains(text(), 'Metals Test Methods and Analytical Procedures')]");
	public By editSearchBoxmobile = By.cssSelector("#search-footer");
	public By goButtonMobile = By.xpath("//div[@class='input-group row m-0 astm-search']//button[@title='Search']");
	public By firstTimeSearchCLoseInfo = By
			.xpath("//div[@class='popover fade bs-popover-right show custom-overlay']//i[@id='custom-close-overlay']");
	public By gCInAbout=By.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Global Cooperation']");

	public By continueShoppingButton = By.xpath("//a[@class='continue primary btn astm-btn btn-primary']");
	
	public By activeProductsAndServicesDefault = By
			.xpath("//div[@class='webm']//a[@class='active' and @id='information' and contains(text(),'Products')]");
	public By activeInformationDefault = By.xpath(
			"//div[@class='webm']//a[@id='information' and @class='active' and contains(text(), 'Information')]");
	public By paginationInInfo = By.xpath("//div[contains(@class,'mst-search')]/div[2]//ul[contains(@class,'pagination')]");
	public By authors=By.xpath("//nav[contains(@class,'astm-navbar')]//a[text()='Authors']");
	public By searchInSAndP=By.xpath("//input[@id='search-standards']");
	public By ViewAll=By.xpath("//a[text()='View All']");
	public By STPLinkOne=By.xpath("//div[@class='category-view']//p[1]/a");
	public By SSMSInJournals=By.xpath("//a[contains(text(),'SSMS')]");
	public By TRLinkOne=By.xpath("//div[@class='astm-type-body--lead']/p[3]/a");
	public By COVIDInLeftMenu=By.xpath("//span[text()='COVID 19']");
	public By linkPersonnelCertification=By.xpath("//a[contains(text(),'Personnel Certification')]");
	public By linkEPD=By.xpath("//a[contains(text(),'Environmental Product')]");
	public By GDPRBanner=By.xpath("//div[@id='onetrust-banner-sdk']");
	public By GDPRRejectAll=By.xpath("//button[@id='onetrust-reject-all-handler']");
	public By GDPRAcceptAll=By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public By GDPRCookieSettings=By.xpath("//button[@id='onetrust-pc-btn-handler']");
	public By AdditionalSettingsHeader=By.xpath("//div[@class='ot-pc-header']");
	public By AdditionalSettingsClose=By.xpath("//button[@id='close-pc-btn-handler']");
	public By OneTrustCookieClose=By.xpath("//div[@id='onetrust-close-btn-container']/button");
	public By CookieAlert=By.xpath("//span[contains(text(),'cookies, including third party cookies')]");
	public By PE_ContinuingEducationLink = By.xpath("//nav[contains(@class,'astm-navbar')]//li//li/a[text()='PE Continuing Education']");
	public By selectPlant = By.id("plant_select");
	public static By spinnerIcon = By.cssSelector("div[data-component*='product_listing'] div.spinner");
	public By certificate = By.className("card-text");
	public By ReadOurFAQButton = By.xpath("//*[contains(text(),'Read Our FAQ')]");
	public By consumerrelatedarticlesHeading = By.xpath("//h4[@class='astm-type-heading--h4 m-0 mb-2 mt-3'][text()='Consumer-Related Articles']");
	public By newsreleasesHeading = By.xpath("//h4[@class='astm-type-heading--h4 m-0 mb-2 mt-3'][text()='News Releases']");
	public By meetingsandeventHeading = By.xpath("//h4[@class='astm-type-heading--h4 m-0 mb-2 mt-3'][text()=' Meetings and Events']");
	public By howtogetinvolvedHeader = By.xpath("//h2[@class='astm-type-heading--h2 m-0 mb-2 mt-3 mt-md-0']");
	public By mediapublicityrequestform = By.xpath("//a[@href='https://qa.astm.org/get-involved/technical-committees/publicity-request.html']");
	public By trainingandresourcesHeader = By.xpath("//h2[@class='astm-type-heading--h2 m-0 mb-2 mt-3 mt-md-0']");
	public By whyshouldijoin = By.xpath("//h5[text()='Why should I join?']");
	public By howtojoin = By.xpath("//h5[text()='How to Join']");
	public By financialassistanceforcustomer = By.xpath("//h5[text()='Financial assistance for Consumers']");
	public By requestfinancialassistanceButton = By.xpath("//a[text()='Request Financial Assistance']");
	public By becomeanastmmemberButton = By.xpath("//a[text()='Become an ASTM Member']");
	public By newmemberorientationandtrainingButton = By.xpath("//a[text()='New Member Orientation & Training']");
	public By accessreadingroomButton = By.xpath("//a[text()='Access Reading Room']");
	public By downloadtheconsumerguidebookButton = By.xpath("//a[@href='https://public-admin-files-qa.s3.us-east-2.amazonaws.com/general/Consumer_Guide.pdf']");
	public By kathiemorganimage = By.xpath("//img[@src='https://qa.astm.org/media/wysiwyg/Kathie-Morgan-2022-1280px.jpg']");
	public By everymemberhasavoice = By.xpath("//h5[text()='Every Member Has a Voice']");
	public By NCATTButton = By.xpath("//*[contains(text(),'Learn More about NCATT')]");
	public By LMAPC = By.xpath("//*[contains(text(),'Learn More About Personnel Certification')]");
	public By infographic = By.xpath("//*[contains(text(),'View Infographic')]");
	public By currentlyActive = By.xpath("//span[contains(text(),'Currently Active')]");
	public By ASTMheader = By.xpath("//h1[contains(text(),'What is ASTM (ID: 2899')]");
	public By selectfield = By.xpath("//div[@class='action-select-wrap']//button[contains(text(),'Select')]");
	public By filterpage = By.xpath("//div[@class='data-grid-cell-content'][contains(text(),'Adjunct to D7611/D7611M Standard Practice for Coding Plastic Manufactured Articles for Resin Identification')]");
	public By editoption = By.xpath("//a[contains(text(),'Edit')]");
	public By editpage = By.className("admin__fieldset-wrapper-content _hide");
	public By verifyhowtogetinvolved = By.xpath("//div[@class='data-grid-cell-content'][text()='How to Get Involved']");
	public By EPD = By.xpath("//*[contains(text(),'EPD for Martin Marietta (EPDs are generated using an enterprise software tool)')]");
	public By CMSpage = By.className("admin__control-select");
	public By classificationDropDown = By.cssSelector("select[name='customer[classification]']");
	private By customerTypeDropDown = By.cssSelector("select[name='customer[customer_type]']");
	public By SignInAdmin = By.className("mr-1");
	public By IncomeMsgHeader = By.xpath("//h1[contains(@id,'modal-title')]");
	public By IncomeMsgClose = By.xpath("//h1[contains(text(),'Incoming Message')]//following-sibling::button");
	public By grandTotalInclTax = By.cssSelector("#grand-total-include-tax > td.admin__total-amount >strong >span");
	public By grandTotalIncTaxAfterSubmit = By.xpath("//strong[text()='Grand Total (Incl.Tax)']/../../td[2]/strong/span");
	public By grandTotalExcTaxAfterSubmit = By.xpath("//strong[text()='Grand Total (Excl.Tax)']/../../td[2]/strong/span");

	public By BookDealerDiscountOrderViewScreen = By.cssSelector("tr.col-1 > td:nth-child(2) > span > span");
	public By MemberDiscountOrderViewScreen = By.cssSelector("tr:nth-child(2) > td:nth-child(2) > span");
	public By shippingAndHandlingAfterSubmit = By.cssSelector("tr.col-4 > td:nth-child(2) > span > span");
	public By totalTaxAfterSubmit = By.cssSelector("tbody > tr.summary-total > td:nth-child(2) > span");
	public By lineItemSubTotal = By.cssSelector("tbody > tr:nth-child(1) > td.col-subtotal > div > span");
	public By lineItemSubDiscount = By.cssSelector("tr:nth-child(1) > td.col-book-dealer-discount > span");
	public By lineItemTax = By.cssSelector("tr:nth-child(1) > td.col-tax-amount > span");
	public By formatProductItem = By.xpath("//*[@id='super-product-table']/tbody/tr/td/span");
	public By AccountInformationTab = By.xpath("//a[@id='tab_customer']");
	public By AccountInfoCustName = By.xpath("//h1[@class='page-title']");
	public By ProductTitle = By.xpath("(//span[@class='astm-type-body--lead']/b)[1]");
	public By AllTrainingsHeader = By.xpath("//*[@class='astm-type-heading--h2 mt-4']");
	public String ProductsMenuOption = "//nav[contains(@class,'astm-navbar')]//a[contains(text(),'[PRODUCTNAME]')]";
	public By continuebutton = By.xpath("//button[contains(text(),'Agree and Continue')]");
	public By okBtn = By.xpath("//button[text()='OK']");
    public By ARInvoiceType = By.xpath("//select[@name='customer[ar_invoice_type]']");
    public By ebsNumber_AccountInfoPage = By.xpath("//input[@name='customer[ebs_account_number]']");

	public By authorizationError = By.xpath("//div[text()='Authorization Error']");
	public By committeLink = By.xpath("//a[text()='Committee']");
	public By meetingsLink = By.xpath("//a[text()='Meetings']");
	public By  addMeetingsequenceLink = By.xpath("//button[text()='Add Meeting Sequence']");                                                         //button[text()='Add Meeting Sequence']

	public By addMeetingSeqMonthDropDown = By.xpath("//div[@name='Month']");
	public static By collectionAttribute= By.xpath("//input[@name='product[collection]']");
	public By meetingTypeDropDown = By.xpath("//div[@name='MeetingType']");
	public By htmlCode = By.xpath("//div[@class='placeholder-html-code']");
	public By settings = By.xpath("//ul[@class='pagebuilder-options-links']//li[3]");
	public By htmlCodeInsert = By.xpath("//textarea");
	public By fullScreen = By.xpath("//i[@title='Close Full Screen']");

	public By saveBtn = By.xpath("//button[text()='Save']");
	public By WI_FullList_link = By.xpath("//a[contains(@href,'work-items-full-list')]");
	public By WI_FullList_linkHdr= By.xpath("//h2[contains(text(),'Work Items- Full List')]");
	public By cookieRejectAll = By.xpath("//button[text()='Cookies Settings']//following-sibling::button[text()='Reject All']");
	public String WI_FullList_RequiredWI = "//li[@class='mb-3']/a[contains(text(),'[WI_NUMBER]')]";
	private By sendActivationEmailToggleInput = By.xpath("//input[@name='customer[send_membership_activation_email]']");
	//public By AddressValidationHeader = By.xpath("//header[@class='modal-header']/h1[contains(text(),'Address Validation')]");
	//public By AddressValContinueBtn = By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']/span[text()='Continue']");
	public By HazardousWarningText = By.xpath("//span[contains(text(),'One or more of the products in your cart contains a hazardous material')]");

	private By useSelectedAddressBTN=By.xpath("//span[contains(text(),'Use Selected Address')]/parent::button");
	public By AddmodelBoxText=By.xpath("//div[contains(text(),'We can not')]");
	private By useSelAddressTitleMagento=By.xpath("(//h1[@class='modal-title'])[4]");
	private By AddressEnteredRadio=By.xpath("//input[@id='entered']");
	public By UseSelAddText=By.xpath("//div[contains(text(),'We have slightly modified')]");
	public By confirmAddressValidation = By.xpath("//div[@class='address-modal-description']");
	public By wrongAddressValidation = By.xpath("//div[contains(text(),'Do you want to proceed')]/..");
	private By useSelAddressTitle=By.xpath("//div[contains(text(),'We can not')]/parent::div/parent::div/descendant::h1");
	private By ContinueBtn=By.xpath("//button[contains(@class,'action-accept')]");


	public By getProductsMenuOption(String ProductName){
		return By.xpath(ProductsMenuOption.replace("[PRODUCTNAME]",ProductName ));
	}

	public By bundlewithactiveversion(String Text) {
		return By.xpath("//table/thead/tr/th[@class='data-grid-th _sortable _draggable']/child::span[text()='Asset Status']/following::td/div[text()='Active']/../preceding-sibling::td/div[text()='"+Text+"']");
	}

	public void clickOnAddToCartButton(int i)
	{
		WebElement ele=driver.findElement(By.xpath("(//button[@title='Add to Cart'])["+i+"]"));
		ele.click();
	}

	public By getModelBoxTitle() {
		return useSelAddressTitle;
	}
	public By getContinueBtn() {
		return ContinueBtn;
	}
	public By getWIfromWIFullList(String WI){
		return By.xpath(WI_FullList_RequiredWI.replace("[WI_NUMBER]", WI));
	}
	public By GrandTotalIncTax(){
		return grandTotalInclTax;
	}

	public By GrandTotalExcTaxAfterSubmit(){
		return grandTotalExcTaxAfterSubmit;
	}

	public By GrandTotalIncTaxAfterSubmit(){
		return grandTotalIncTaxAfterSubmit;
	}

	public By ShippingAndHandlingAfterSubmit(){
		return shippingAndHandlingAfterSubmit;
	}

	public By TotalTaxAfterSubmit(){
		return totalTaxAfterSubmit;
	}

	public By lineItemTotalTaxAfterSubmit(){
		return lineItemTax;
	}
	public By lineItemSubTotalAfterSubmit(){
		return lineItemSubTotal;
	}

	public By lineItemSubDiscountAfterSubmit(){
		return lineItemSubDiscount;
	}

	public By BookDealerDiscountInOrderViewScreen(){
		return BookDealerDiscountOrderViewScreen;
	}

	public By MemberDiscountInOrderViewScreen(){
		return MemberDiscountOrderViewScreen;
	}
	public void clicksignIn() {
		getElement(SignInAdmin).click();
	}
	public By getFilterpage(String Name) {
		return By.xpath("(//div[@class='data-grid-cell-content'][text()='"+Name+"'])[1]");
	}
	public By getPageHeading(){
		return By.xpath("//h1[text()='UOP Standards']");
	}
	public By getsubHeadingtitle(){
		return By.xpath("//div[@class='astm-type-body--lead']");
	}
	public By getUOPLinkByLinkText(String linkText) {
		return By.xpath("//a[@href='"+linkText+"']");
	}
	public By getaddressvalidationcontinue() { return By.xpath("//button[@class='btn astm-btn btn-secondary action-accept']");}
	private By getCustomerGridColumnHeader() {
		return By.cssSelector("[data-role='grid-wrapper'] thead .data-grid-cell-content");
	}
	//public String CustomerGridCell = "[data-role='grid-wrapper'] tbody td:nth-of-type([INDEX]) .data-grid-cell-content";
	public String CustomerGridCell = "//div[text()='[EMAIL]']//ancestor::tr//td[[INDEX]]//div";

	public String accountNo = "//div[text()='[EMAIL]']//ancestor::tr//td[[INDEX]]//div";
	private By accountNo(String mail) {
		return By.xpath("//div[text()='"+mail+"']//ancestor::tr//td[13]//div");
	}
	private By item(String text) {
		return By.xpath("//div[text()='"+text+"']");
	}
	private By getEBSSKUsfromOrderPage = By.cssSelector("div[id*='ebs_sku'] span");

	public By accountInformationTab = By.xpath("//span[text()='Account Information' and @data-bind='text: label']");

	public By addCommitteTypeBtn = By.xpath("//button[text()='Add Committee']");

	public By  committeTypeDropDown = By.xpath("//div[@id='CommitteeType']");

	public By getInvolvedOptionsHyperLink = By.xpath("//a[text()='Get Involved']");

	public By membershipOption = By.xpath("//div[@class='menuTitle']/..//a[text()='Membership']");

    public By joinNowExploretheBenefitsofMembershipLink = By.xpath("//a[text()='Join Now - Explore the Benefits of Membership']");

	public By managementMemberShipTypeDetailsMemberShpName = By.xpath("//h4[text()='Organizational Members']");

	public By managementMemberShipTypeDetailsMemberShpFees = By.xpath("//h4[text()='Organizational Members']/parent::div//p");
	public By getManulaLink(int index)
	{
		return By.xpath("//div[contains(@class,'wysiwygContainer')]/descendant::li["+index+"]/a");
	}

	private By committeDesginationLnks = By.xpath("//table[@id='customGrid']//tr//a");

	public By addMeetingSeqcancelBtn = By.xpath("//button[text()='Cancel']");
	public By IssOrderPagechekbox=By.xpath("//tr[@id='row_address_validation_enable_on_order']/descendant::input");
	public By Enablechekbox=By.xpath("//tr[@id='row_address_validation_enable']/descendant::input");
	public By IssOrderPageDropdown=By.xpath("//tr[@id='row_address_validation_enable_on_order']/descendant::select");
	public By saveConfig = By.xpath("//span[contains(text(),'Save Config')]");


	public By contactFirstName = By.xpath("(//input[@name='first_name'])[2]");
	public By contactLastName = By.xpath("(//input[@name='last_name'])[2]");
	public By contactEmail = By.xpath("(//input[@name='email'])[2]");
	public By TPTLearner = By.xpath("//fieldset[@class='admin__fieldset']/div[2]/div/div/label");
	public By billTo = By.xpath("//span[text()='Bill to']//following::div[@class='admin__actions-switch'][1]");
	public By shipTo = By.xpath("//span[text()='Bill to']//following::div[@class='admin__actions-switch'][2]");

	public By cancelButtonOnAlert = By.xpath("//footer[@class='modal-footer']//span[text()='Cancel']");
	private By selectCreditCard=By.xpath("//input[@id='p_method_braintree']");
	private By creditcardNo=By.xpath("//input[@id='credit-card-number']");
	private By expirationMonth=By.xpath("//input[@id='expiration-month']");
	private By expirationYear=By.xpath("//input[@id='expiration-year']");
	private By cvvNumber=By.xpath("//input[@id='cvv']");
	String iframeccnumber="braintree-hosted-field-number";
	String iframeExpMonth="braintree-hosted-field-expirationMonth";
	String iframeExpYear="braintree-hosted-field-expirationYear";
	String iframecvv="braintree-hosted-field-cvv";

	public By studentPayment=By.xpath("//dl[@class='admin__payment-methods control']/descendant::label");
	public By inResidenceTrainingPrograms=By.xpath("(//a[text()='In-Residence Training Programs'])[1]");
	public By onlineTrainingLink=By.xpath("//span[text()='Online Training']");
	public By internationalPartnersLink=By.xpath("//span[text()='International Partners']");
	public By uaeChapterLink=By.xpath("//span[text()='UAE Chapter']");
	public By searchptp=By.xpath("//input[@id='search']");
	public By searchBtnptp=By.xpath("(//button[@type='button'])[3]");
	public By ptpProduct=By.xpath("(//a[@href='https://stage.astm.org/ptpislg2023.html'])[2]");
	public By ptpOil=By.xpath("(//a[@href='https://stage.astm.org/ptpisto2023.html'])[4]");
	public By contact1=By.xpath("(//*[text()='Contact'])[2]");
	public By TechnicalCommitteeFullList=By.xpath("//a[@href='/get-involved/technical-committees/committee-all']");
	public By TechnicalCommitteProduct=By.xpath("//a[@href='https://stage.astm.org/get-involved/technical-committees/committee-a01']");
	public By standardProduct=By.xpath("//a[@href='https://stage.astm.org/get-involved/technical-committees/committee-a01/subcommittee-a01']");
	public By subcommitteStandard=By.xpath("//a[@href='https://stage.astm.org/get-involved/technical-committees/committee-a01/subcommittee-a01/jurisdiction-a0101']");
	public By searchWorkItem=By.xpath("//a[text()=' WK85700 ']");
	public By home=By.xpath("//a[@title='Go to Home Page']");
	public By committeAward=By.xpath("(//div[@class='mst-search__index-title']/a)[1]");
	public By tenantMarketinghdr=By.xpath("(//div[@class='mst-search__index-title']/a)[1]");
	public By technicalCommitteeAwards=By.xpath("https://stage.astm.org/catalogsearch/result/index/?index=8&q=Technical+Committee+Awards+");
	public By otherPublisher=By.xpath("(//a[text()='Other Publishers'])[1]");
	public By downloadCompassEbook=By.xpath("//a[@class=\"btn-contact btn astm-btn btn-primary mt-3\"]");
	public By requestDemo=By.xpath("(//a[text()='Request Demo'])[1]");
	public By ANSIReview=By.xpath("//a[@href='https://stage.astm.org/get-involved/technical-committees/ansi-review']");
	public By workItem=By.xpath("//a[text()='2021/09/17']");
	public By lightSportAircraft=By.xpath("(//*[contains(text(),'Light Sport Aircraft')])[2]");
	public By searchTitle =By.xpath("(//div[@class=\"search-title\"])[1]");
	public By homeNavigation=By.xpath("//a[text()='Home']");
	public By standardsAndNavigation=By.xpath("(//a[@href='https://stage.astm.org/products-services/standards-and-publications.html'])[5]");
	public By standardsProductNavigation=By.xpath("(//a[@href='https://stage.astm.org/products-services/standards-and-publications/standards.html'])[3]");
	public By shippingAndHandling=By.xpath("//a[text()='ASTM License Agreement']");

	public By getTraingLink(String fieldName) {
		return By.xpath("//*[contains(text(),'"+fieldName+"')]");
	}

	public By addressValidationHeader=By.xpath("//div[@data-testid='addressValidationConfirmPopup']/div");
	public By addressValidationDescription=By.xpath("//div[@class='description']/p");
	public By getUseSelectedAddress =By.xpath("//button[@data-testid='btnYes']");
	public By addressValidationWrong=By.xpath("//p[@class='txtCenter']");
	public By addressYesButton = By.xpath("//p[contains(text(),'address')]/..//button[text()='Yes']");



	public void clickOnCancelButtonOnAlertBox(){
		PublicCommon.waitForSec(3);
		getElement(cancelButtonOnAlert).click();
	}
	public void editSandPSearchBox(String entertext){
		PublicCommon.waitForSec(4);
		wait.until(ExpectedConditions.elementToBeClickable(searchInSAndP));
		getElement(searchInSAndP).sendKeys(entertext);
	}
	public boolean waitForVisible(WebDriver driver, By locator, int sec) {
		try {
			new WebDriverWait(driver, sec).until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return false;
		}
	}
	public boolean handleSpinnerIcon(WebDriver driver, By locator) {
		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			boolean found = waitForVisible(driver, locator, 3);
			if (found) {
//					new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(locator));
				new WebDriverWait(driver, 60).pollingEvery(Duration.ofMillis(500))
						.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
				return true;
			}
			return true;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}
	public String getmaxlengthAttributeInSandPSearchBox() {
		return getElement(searchInSAndP).getAttribute("maxlength");
	}
	
	public void pressEnterKeyInPAndS() {
		getElement(searchInSAndP).sendKeys(Keys.ENTER);
		PublicCommon.waitForSec(4);
	}
	
	public void tempSearchIconInPAndS() {
		getElement(searchInSAndP).click();
		PublicCommon.waitForSec(6);
	}

	@Step("Click on Reading room option from Products and Services drop down")
	public void clickReadingRoomInPAndS() {
		try {
			mouseHoverProductsAndServicesOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(readingRoomOptions).click();
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Reading room option from Products and Services drop down", e);
		}
	}
	@Step("Click on EPD link in certificate page")
	public void clickEPDLink() {
		try {
			getElement(linkEPD).click();
			handleSpinnerIcon(driver, spinnerIcon);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBOSVolume() {
		try {
			return getElement(ProductPageTitle).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Step("Click on Personnel Certification link in certificate page")
	public void clickLinkPersonnelCertification() {
		try {
			getElement(linkPersonnelCertification).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Step("Click on Learn More button under Personnel Certification in certificate page")
	public void clickLearnMoreButtonUnderPersonnelCertification() {
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(personalcerification),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(learnmoreunderpersonalcerification).click();
			PublicCommon.waitForSec(3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void clickAuthor() {
		try {
			mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			getElement(authors).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickSAndPInPAndS() {
		try {
			mouseHoverProductsAndServicesOption();
			getElement(standardsAndPublicationsOptions).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickBOS() {
		try {
			mouseHoverProductsAndServicesOption();
			getElement(bookOfStandardsOptions).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void SearchPTPT(){
		try{
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(searchHeader));
			getElement(searchHeader).clear();
			getElement(searchHeader).sendKeys("ptptmlc2022");
			getElement(searchIcon).click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean verifysearchResultsPAndS() {
		return getElements(searchResultsPAndS).size()==1;
	}
	
	public boolean verifysearchResults(By locator) {
		return getElements(locator).size()==1;
	}

	
	public void clickReadingRoomInSAndP() {
		try {
			mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			getElement(readingRoomInSAndP).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickfooterReadingRoom() {
		getElement(footerReadingRoom).click();
	}
	
	@Step("MouseHover 'Standards & Publications' Option")
	public void mouseHoverStandardsAndPublicationsOption() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(productsAndServicesNavigation));
			PublicCommon.waitForSec(3);
			ReusableMethods.mouseHover(driver, getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
			ReusableMethods.mouseHover(driver, getElement(standardsAndPublicationsOptions),
					"hover over StandardsAndPublications Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}
	
	public void clickSAndP() {
		Actions action=new Actions(driver);
		action.moveToElement(getElement(productsAndServicesNavigation)).moveToElement(getElement(standardsAndPublicationsOptions)).click().build().perform();
	}
	
	public void clickStandardsProduct() {
		mouseHoverProductsAndServicesOption();
		Actions action=new Actions(driver);
		action.moveToElement(getElement(standardsAndPublicationsOptions)).moveToElement(getElement(standardsProducts)).click().build().perform();
	}
	
	public void clickManualMonograhs() {
		try {
		mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			getElement(manualsMonogramsAndData).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickTechnicalReports() {
		try {
			mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			getElement(technicalReports).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickJournals() {
		try {
			mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			getElement(journals).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean clickContinueShoppingButton() 
	{
		try {
			getElement(continueShoppingButton).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}


	public boolean verifyGCInAbout() {
		return getElements(gCInAbout).size()==1;

		}	

	
	
	public void clickMeetingsAndSymposia() {
		mouseHoverGetInvolvedNavigationOption();
		getElement(meetingsAndSymposia).click();
	}
	
	public void clickMembershipInGI() {
		mouseHoverGetInvolvedNavigationOption();
		getElement(membershipOptions).click();
	}
	
	public boolean verifyMeetingsAndSymposia() {
		return getElements(meetingsAndSymposia).size()==1;
	}
	
	public void clickGoButtonMobile() {
		getElement(goButtonMobile).click();
	}

	public void editSearchEditBoxmobile(String entertext) {
		getElement(editSearchBoxmobile).sendKeys(entertext);
	}

	public By section3OfBOS = By
			.xpath("//a[contains(text(), 'Section 3 - Metals Test Methods and Analytical Procedures')]");

	public void clickFooterSearchIcon() {
		getElement(footerSearchIcon).click();
		wait.until(ExpectedConditions.elementToBeClickable(searchResults));
	}

	public void searchBoxInFooter() {
		ReusableMethods.scrollIntoView(getElement(footerSearchbar), driver);
	}

	public String getTextFromFooterSearchBox() {
		return getElement(footerSearchbar).getText();
	}

	public String getValueAttributeFromFooterSearchBox() {
		return getElement(footerSearchbar).getAttribute("value");
	}

	public void enterTextFromFooterSearchBox(String textToType) {
		getElement(footerSearchbar).sendKeys(textToType);
	}

	public void clickCartLink() {
		getElement(cartLink).click();
	}

	public void clickSection3() {
		getElement(section3OfBOS).click();
	}

	public void clickMetalsTestMethods() {
		getElement(metalsTestMethods).click();
	}

	public boolean signInDD() {
		return getElement(signInDropDown).isDisplayed();
	}


	public boolean signInButton() {
		return getElement(signInLinkUnderDropDown).isDisplayed();
	}

	public boolean signInButton_Public() {
		return getElement(signInButton).isDisplayed();
	}


	public boolean createAccount() {
		return getElement(createAccountButton).isDisplayed();
	}

	public void clickSignInDD() throws IOException {
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(signInDropDown),30);
		waitForElementPresent(signInDropDown);
		ScreenshotUtil.takeScreenshotForAllure(driver);
		getElement(signInDropDown).click();
	}

	public void clickSignInButton_Public() throws IOException {
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(signInButton),30);
		waitForElementPresent(signInButton);
		ScreenshotUtil.takeScreenshotForAllure(driver);
		getElement(signInButton).click();
	}

	public void clickSignInButtonInDD() {
		getElement(signInLinkUnderDropDown).click();
	}

	public void clickCreateAccount() {
		getElement(createAccountButton).click();
	}

	@Step("Clicking on Email Subscription Settings Link")
	public void clickOnEmailSubscription() {
		getElement(emailSubscriptionSettingsLink).click();
	}

	@Step("CLicking on standardization news link")
	public void clickOnStandardizationNews() {
		// Actions action=new Actions(driver);
		// action.moveToElement(getElement(newsNavigation)).moveToElement(getElement(standardizationNewsOptions)).click().build().perform();
		getElement(standardizationNewsOptions).click();
	}

	@Step("Navigate back")
	public void navigateBack() {
		driver.navigate().back();
		PublicCommon.waitForSec(5);
	}

	public void navigateToUrl(String url) {
		PublicCommon.waitForSec(2);
		driver.get(url);
		wait.until(ExpectedConditions.urlContains(url));
		PublicCommon.waitForSec(4);
	}

	public void tempSearchIcon() {
		getElement(searchIcon).click();
		PublicCommon.waitForSec(6);
		//waitForElementPresent(firstTimeSearchCLoseInfo);
	}

	public void clickSearchIconLessResults() {
		getElement(searchIcon).click();
	}

	public void pressEnterKey() {
		getElement(searchCombobox).sendKeys(Keys.ENTER);
		PublicCommon.waitForSec(4);
	}

	public String getTextInSearchBox() {
		return getElement(searchCombobox).getText();
	}

	@Step("CLicking on news releases link")
	public void clickOnNewsReleases() {
		getElement(newsReleasesOptions).click();
	}

	@Step("Clicking on 'cover image' under news menu")
	public void clickOnCoverImage() {
		getElement(newsDropDownImage).click();
	}

	public WebElement getCartLinkAPIText() {
		return getElement(cartLinkAPIText);
	}

	public WebElement getLogoAPIElement() {
		return getElement(apiLogo);
	}

	public boolean clickCookiePolicyLink() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(cookieAlert));
			getElement(cookiePrivacyPolicy).click();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String cookiePolicyLinkContent() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(cookieAlert));
			return getElement(cookiePrivacyPolicy).getAttribute("href");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Point getCoordinates(By element) {
		Point location = null;
		try {
			location = getElement(element).getLocation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	public String getCookieText() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(cookieAlert));
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getElement(cookieAlert).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean cookieDisplay() {
		try {
			// WaitStatementUtils.explicitWaitForVisibility(driver,
			// getElement(cookieAlert));
			PublicCommon.waitForSec(2);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isVisibleInViewport(getElement(cookieAlert), driver);
		} catch (JavascriptException jse) {
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean closeCookieMessage() {
		try {
			getElement(handleCookies).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public List<WebElement> breadcrumbsLinksWebElementList() {
		try {
			return driver.findElements(breadcrumbsLinks);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String breadcrumbsText() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(breadcrumbs));
			return getElement(breadcrumbs).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public WebElement getFooterSection() {
		ReusableMethods.scrollIntoView(getElement(footerSection), driver);
		return getElement(footerSection);
	}

	public WebElement getAccountButtonStatus() {
		ReusableMethods.scrollIntoView(getElement(accountButtonStatus), driver);
		return getElement(accountButtonStatus);
	}

	public WebElement getHeaderSection() {
		ReusableMethods.scrollIntoView(getElement(headerSection), driver);
		return getElement(headerSection);
	}

	public WebElement getBookOfStandardsOptions() {
		return getElement(bookOfStandardsOptions);
	}

	public WebElement BOSPrintFormatAddToCart(){
		return getElement(BOSPrintFormatAddToCart);
	}

	public WebElement BOSPrintFormatAddToCart_25(){
		return getElement(BOSPrintFormatAddToCart_25);
	}

	public WebElement BOSSingleUserOnlineFormatAddToCart(){
		return getElement(BOSOnlineFormatAddToCart);
	}

	public WebElement getProductTitle(){
		return getElement(ProductTitle);
	}

	public WebElement AddToCart(){
		return getElement(AddToCart);
	}

	public WebElement getMemberPromoSection() {
		return getElement(memberPromoSection);
	}

	public WebElement getMemberPromoHeader() {
		return getElement(memberPromoHeader);
	}

	public WebElement getStatGlobalASTMStandards() {
		return getElement(memberPromoStatGlobalASTMStandards);
	}

	public WebElement getStatPartnerCountries() {
		return getElement(memberPromoStatPartnerCountries);
	}

	public WebElement getStatVolunteerMembers() {
		return getElement(memberPromoStatVolunteerMembers);
	}

	public WebElement getMembershipoptions() {
		return getElement(membershipOptions);
	}

	public WebElement getStandardsProduct() {
		return getElement(standardsProduct);
	}

	public WebElement getInvolvedNavigation() {
		return getElement(getInvolvedNavigation);
	}

	public WebElement getMemberPromoButtonLink() {
		return getElement(memberPromoButtonLink);
	}

	public WebElement getMemberPromoButtonText() {
		return getElement(memberPromoButtonText);
	}

	public List<WebElement> getOverviewList() {
		return getElements(overviewList);
	}

	public List<WebElement> getGovernanceList() {
		return getElements(governanceList);
	}

	public List<WebElement> getHistoryList() {
		return getElements(historyList);
	}

	public List<WebElement> getGlobalCooperationList() {
		return getElements(globalCooperationList);
	}

	public List<WebElement> mobileGetGlobalCooperationList() {
		return getElements(mobileGlobalCooperationList);
	}

	public List<WebElement> mobileGetOvervieweList() {
		return getElements(mobileOverviewList);
	}

	public List<WebElement> mobileGetHomeList() {
		return getElements(mobileHistoryList);
	}

	public List<WebElement> mobileGetGovernanceList() {
		return getElements(mobileGovernanceList);
	}

	public List<WebElement> getStudentsNProfessorsList() {
		return getElements(studentsNProfessorsList);
	}

	public List<WebElement> getStandardsAndPublicationsCategoriesList() {
		return getElements(standardsAndPublicationsCategoriesList);
	}

	public List<WebElement> getStandardsAndPublicationsCategoriesListForMobile() {
		return getElements(standardsAndPublicationsCategoriesListMobile);
	}

	public List<WebElement> getEnterpriseSolutionsList() {
		return getElements(enterpriseSolutionsList);
	}

	public List<WebElement> getEnterpriseSolutionsListForMobile() {
		return getElements(enterpriseSolutionsListForMobile);
	}

	public List<WebElement> getTrainingCoursesList() {
		return getElements(trainingCoursesList);
	}

	public List<WebElement> mobileGetTrainingCoursesList() {
		return getElements(mobileTrainingCoursesList);
	}

	public List<WebElement> mobileStudentProfessorList() {
		return getElements(mobileStudentAndProfessorList);
	}
	/*
	 * public WebElement getDigitalLibraryOptions() { return
	 * getElement(digitalLibraryOptions); }
	 * 
	 * public WebElement getProficiencyTestingOptions() { return
	 * getElement(proficiencyTestingOptions); }
	 * 
	 * public WebElement getCertificationOptions() { return
	 * getElement(certificationOptions); }
	 * 
	 * public WebElement getCementNConcreteReferenceLabOptions() { return
	 * getElement(cementNConcreteReferenceLabOptions); }
	 * 
	 * public WebElement getReadingRoomOptions() { return
	 * getElement(readingRoomOptions); }
	 * 
	 * public WebElement getTrackerServicesOptions() { return
	 * getElement(trackerServicesOptions); }
	 * 
	 * public WebElement getCatalogsOptions() { return getElement(catalogsOptions);
	 * }
	 * 
	 * 
	 * 
	 * 
	 */

	public WebElement getProficiencyTestingOptions() {
		return getElement(proficiencyTestingOptions);
	}

	public List<WebElement> breadcrumbsSectionsWebElementList() {
		try {
			return driver.findElements(breadcrumbsSections);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public WebElement getIntegratedServicesOption() {
		return getElement(integratedServicesOptions);
	}

	public WebElement getSpecbuilderOption() {
		return getElement(specbuilderOption);
	}

	public WebElement getASTMCompassOption() {
		return getElement(ASTMCompassOption);
	}

	public WebElement getProductsAndServicesNavigation() {
		return getElement(productsAndServicesNavigation);
	}

	public WebElement getEnterpriseSolutionsNavigation() {
		return getElement(enterpriseSolutionsOptions);
	}

	public WebElement getCatalogsNavigation() {
		return getElement(catalogsOptions);
	}
	
	public void clickcatalogsOptions() {
		mouseHoverProductsAndServicesOption();
		getElement(catalogsOptions).click();
	}			

	public WebElement getSymposiaPapersAndSTPs() {
		return getElement(symposiaPapersAndSTPs);
	}

	public WebElement getManualsMonogramsAndData() {
		return getElement(manualsMonogramsAndData);
	}

	public WebElement getjournals() {
		return getElement(journals);
	}

	public WebElement getStandardsAndPublicationsOptions() {
		return getElement(standardsAndPublicationsOptions);
	}

	public WebElement getLaboratoryServicesOptions() {
		return getElement(LaboratoryServicesOptions);
	}

	public WebElement getAllTrainingCourses() {
		return getElement(allTraningCourses);
	}

	public void RegisterForAprogramBtn(){
		//return getElement(RegisterForAprogram);
		PublicCommon.waitForSec(10);
		ReusableMethods.scrollIntoView(getElement(RegisterForAprogram),driver);
		(new Actions(driver)).moveToElement(getElement(RegisterForAprogram)).click(getElement(RegisterForAprogram)).build().perform();
		//PublicCommon.JSClick(getElement(RegisterForAprogram),driver);
	}
	public WebElement selectProgram(int index){
		WebElement ele=driver.findElement(By.xpath("(//a[contains(@href,'2025.html')])["+(index+1)+"]"));
		return ele;
	}

	public WebElement selectProgramByIndex(int index){
		return driver.findElement(By.xpath("(//div[@id='committee-13']/descendant::li/a[contains(@href,'2025.html')])["+index+"]"));
	}

	public boolean clickAndExpand(String Cat){
		try {
			WebElement ele=driver.findElement(By.xpath("//button[contains(text(),'Full List')]"));
			WaitStatementUtils.waitForElementToBeClickable(driver,ele,60);
			ReusableMethods.scrollIntoView(ele,driver);
			ele.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public WebElement getProgramName(){
		return getElement(PTPprogramPage);
	}

	public WebElement getProductName(){
		return getElement(ProductName);
	}

	public WebElement RegisterForThisProgram(){
		return getElement(RegisterProgramBtnInPTPpage);
	}

	public String getProductprice(){
		try {
			return getElement(PTPprice).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public WebElement getmemberAndOfficerTrainingOption(){
		return getElement(memberAndOfficerTraining);
	}

	public WebElement getAllStandardsAndPublicationsOptions() {
		return getElement(allStandardsAndPublications);
	}

	public WebElement getHeaderSearchDropdown() {
		return getElement(headerSearchDropdown);
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some error occured while creating element" + locator.toString());
			e.getStackTrace();
		}
		return element;
	}

	public boolean clickSignInButton() {

		try {
			getElement(SignInLink).click();
			// ReusableMethods.moveToElementAndClick(driver, getElement(signInLink));
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public boolean clickMyASTMButton() {

		try {
			getElement(myASTMLink).click();
			// ReusableMethods.moveToElementAndClick(driver, getElement(signInLink));
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}
	public void clickAddProductSKUButton(String Product,String Qty) {
		try {
			PublicCommon.waitForSec(5);
			getElement(addproductSKU).click();
			getElement(SKUnumberTextbox).sendKeys(Product);
			getElement(QuantityTextbox).sendKeys(Qty);
			getElement(AddToOrderBtn).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Click on add product button")
	public void clickAddProductButton() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(addProductBtn), 10);
			getElement(addProductBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	@Step("Add product with SKU code and select the product")
	public void AddProductAndQuantity(String product) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(addskunumber), 10);
			getElement(addskunumber).sendKeys(product);
			PublicCommon.waitForSec(7);
			getElement(searchgridBtn).click();
			PublicCommon.waitForSec(5);
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			PublicCommon.JSClick(getElement(checkBox),driver);
			PublicCommon.waitForSec(7);
			a.sendKeys(Keys.PAGE_UP).build().perform();
			PublicAdminCommons.scrollToElement(driver,addSelectedProduct);
			getElement(addSelectedProduct).click();
			PublicCommon.waitForSec(15);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Add start and publish date")
	public void AddStartandPublishDate(){
		try{
			PublicCommon.waitForSec(15);
			ReusableMethods.scrollIntoView(getElement(addProductBtn),driver);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(startDate1));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(startDate1), 20);
			getElement(startDate1).click();
			PublicCommon.waitForSec(3);
			getElement(GoToday).click();
			getElement(closebtn).click();
			PublicCommon.waitForSec(3);
			getElement(publishDate1).click();
			PublicCommon.waitForSec(3);
			getElement(GoToday).click();
			getElement(closebtn).click();
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Add start and publish date")
	public void AddStartandCustomPublishDate(int years,int months){
		try{
			PublicCommon.waitForSec(15);
			ReusableMethods.scrollIntoView(getElement(addProductBtn),driver);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(startDate1));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(startDate1), 20);
			getElement(startDate1).click();
			PublicCommon.waitForSec(3);
			getElement(GoToday).click();
			getElement(closebtn).click();
			PublicCommon.waitForSec(3);
			String startDate=getElement(startDateInput).getAttribute("value");
			String reqpublishDate= DateFormatValidate.getPostdate(startDate,years,months);
			PublicCommon.waitForSec(3);
			getElement(publishDateInput).sendKeys(reqpublishDate);
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Add start and publish date")
	public void AddStartandCustomPublishDate2(int years,int months){
		try{
			PublicCommon.waitForSec(15);
			ReusableMethods.scrollIntoView(getElement(addProductBtn),driver);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(startDate1));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(startDate1), 20);
			getElement(startDate2).click();
			PublicCommon.waitForSec(3);
			getElement(GoToday).click();
			getElement(closebtn).click();
			PublicCommon.waitForSec(3);
			String startDate2=getElement(startDateInput2).getAttribute("value");
			String reqpublishDate2= DateFormatValidate.getPostdate(startDate2,years,months);
			PublicCommon.waitForSec(3);
			getElement(publishDateInput2).sendKeys(reqpublishDate2);
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}



	public void AddStartandPublishDate2(){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(startDate2), 10);
			getElement(startDate2).click();
			PublicCommon.waitForSec(3);
			getElement(GoToday).click();
			getElement(closebtn).click();
			PublicCommon.waitForSec(3);
			getElement(publishDate2).click();
			PublicCommon.waitForSec(3);
			getElement(GoToday).click();
			PublicCommon.waitForSec(3);
			getElement(closebtn).click();
			PublicCommon.waitForSec(3);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}



	@Step("Add contact Details")
	public void FillContactDetails(String email){
		try{
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(contactBillingAddress),driver);
			getElement(contactBillingAddress).sendKeys(email);
			getElement(contactShippingAddress).sendKeys(email);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step("Add contact Details from the dropdown")
	public void FillContactDetailsfromDropdown(int BillingAddressContact,int ShippingAddressContact){
		try{
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(AddressDescriptionLabel),driver);
			Actions a1 = new Actions(driver);
			a1.sendKeys(Keys.PAGE_UP).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.selectValueInDropdownbyValue(getElement(contactBillingAddress),BillingAddressContact);
			PublicCommon.waitForSec(3);
			PublicCommon.selectValueInDropdownbyValue(getElement(contactShippingAddress),ShippingAddressContact);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	@Step("Add promocodes")
	public void FillPromoCode(){
		try{
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(majorpromocode),driver);
			getElement(majorpromocode).sendKeys("ASTM - ASTM");
			getElement(minorpromocode).sendKeys("ASTM - ASTM");
			getElement(orderchannel).sendKeys("WEB - Web");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
    @Step("Add Contact")
    public void contactAdding(){
        try{
            PublicCommon.selectValueInDropdownbyIndex(getElement(contact),1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
	@Step("Click on submit order")
	public void ClickOnSubmitOrderButton(){
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(submitorderButton),10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.JSClick(getElement(submitorderButton),driver);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("unable to submit order", e);
		}
	}

	@Step("Click on submit order")
	public void submitOrder(){
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(submitorderButton), 10);
			getElement(submitorderButton).click();
		}catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("unable to submit order", e);
		}
	}
	@Step("Submit Order")
	public void submitOrderDoubleclick(){
		try {
			ReusableMethods.SCrollIntoView(driver);
			ReusableMethods.SCrollIntoView(driver);
			ReusableMethods.SCrollIntoView(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(SubmitOrderBottom), 10);
			Actions actions = new Actions(driver);
			actions.doubleClick(getElement(submitorderButton)).perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterEMail(String eMail) {
		getElement(eMailAddress).sendKeys(eMail);
	}

	public void enterEmailforvalidation(String eMail) {
		getElement(eMailAddress).clear();
		getElement(eMailAddress).sendKeys(eMail+Keys.TAB);
	}

	public void UncheckSendingActivationEMail() {
		if(getElement(sendActivationEmailToggleInput).isSelected()) {
			ReusableMethods.scrollIntoView(getElement(getClassificationDropDown()),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(sendActivationEmailToggleInput),15);
			JSClick(getElement(sendActivationEmailToggleInput),driver);
		}
	}

	public void enterCommunicationEmail(String eMail){
		getElement(CommunicationEmail).sendKeys(eMail);
	}

	public void enterOrganization(String Org){
		getElement(OrganizationName).sendKeys(Org);
	}
	public void clickOnContinue() {
		PublicCommon.waitForSec(3);
		getElement(continueButton).click();
	}
	public void clickOnSave() {
		PublicAdminCommons.scrollToElement(driver,saveButton);
		PublicAdminCommons.waitForSec(1);
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(saveButton),5);
		getElement(saveButton).click();

	}

	@Step("Click in Save customer Button")
	public void clickOnSaveCustomerButton() {
		WaitStatementUtils.explicitWaitForVisibility(driver, getElement(saveCustomerButton));
		getElement(saveCustomerButton).click();
		PublicCommon.waitForSec(8);
	}

	@Step("Click in Save customer Button Account Information Page")
	public void clickOnSaveCustomerBTN() {
		WaitStatementUtils.explicitWaitForVisibility(driver, getElement(saveCustomerBTN));
		getElement(saveCustomerBTN).click();
		PublicCommon.waitForSec(8);
	}
	public void clickOnSaveAndContinueEdit() {
		PublicCommon.waitForSec(5);
		WaitStatementUtils.explicitWaitForVisibility(driver, getElement(saveAndContinueEdit));
		getElement(saveAndContinueEdit).click();
		PublicCommon.waitForSec(8);
		handleSpinnerIcon(driver, spinnerIcon);
	}
	public void clickOnAddressCkeckBox() {
		PublicCommon.waitForSec(3);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(checkboxdropdown));
		getElement(checkboxdropdown).click();
		getElement(selectAllcheckbox).click();
	}
	public void clickOnAddNewAddress() {
		WaitStatementUtils.waitForElementStaleness(driver,getElement(addnewaddress), 45);
		getElement(addnewaddress).click();
		PublicCommon.waitForSec(5);
	}
	public void newCustomerRegistration(String firstName, String lastName,
									String phoneNumber) throws InterruptedException {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPhoneNumber(phoneNumber);
	}
	@Step("Enter email address and select the customer")
	public void SearchAndSelectCustomer(String email) throws InterruptedException {
		try {
			PublicCommon.waitForSec(15);
			enterEmail(email);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(searchButton), 15);
			getElement(searchButton).click();
			PublicCommon.waitForSec(25);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectsearchedcustomer), 5);
			getElement(selectsearchedcustomer).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Enter email address and select the customer")
	public void SearchAndSelectCustomerWithCustomerType(String email,String CustomerType) throws InterruptedException {
		PublicCommon.waitForSec(3);

		if(CustomerType == "Organization"){
			PublicCommon.waitForSec(3);
			CommunicationEmail(email);

		} else if (CustomerType == "Person") {
			PublicCommon.waitForSec(3);
			enterEmail(email);
		}

		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(searchButton), 15);
		getElement(searchButton).click();
		WaitStatementUtils.waitForElementStaleness(driver,getElement(selectsearchedcustomer));
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(selectsearchedcustomer));
		getElement(selectsearchedcustomer).click();
	}
	public void AddnewAddress(String streetAddress,String city , String zipcode , String phoneNumber) throws InterruptedException {
		enterStreetAddress(streetAddress);
		enterCity(city);
		enterZipCode(zipcode);
		enterPhonenumber(phoneNumber);
	}

	public void AddnewAddress(String streetAddress, String country,String state,
							  String city , String zipcode , String phoneNumber) throws InterruptedException {
		enterStreetAddress(streetAddress);
		enterCountry(country);
		enterState(state);
		enterCity(city);
		enterZipCode(zipcode);
		enterPhonenumber(phoneNumber);
	}
	public void enterEmail(String email) {
		getElement(this.enterEmail).sendKeys(email);
	}

	public void CommunicationEmail(String email){
		getElement(this.enterCommunicationEmail).sendKeys(email);
	}
	public void enterFirstName(String firstName) {
		getElement(this.firstName).sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		getElement(this.lastName).sendKeys(lastName);
	}
	public void enterPhoneNumber(String phoneNumber) {
		getElement(this.phoneNumber).sendKeys(phoneNumber);
	}
	public void enterPhonenumber(String phoneNumber) {
		getElement(this.phonenumber).sendKeys(phoneNumber);
	}
	public void enterZipCode(String zipcode) {
		getElement(this.zipcode).sendKeys(zipcode);
	}
	public void enterCountry(String country) {
		getElement(this.country).sendKeys(country);
	}
	public void enterState(String state) {
		getElement(this.state).sendKeys(state);
	}
	public void enterCity(String city) {
		getElement(this.city).sendKeys(city);
	}
	public void enterStreetAddress(String streetaddress) {
		getElement(this.streetaddress).sendKeys(streetaddress);
	}

	private By MagentofooterSocialIcons=By.cssSelector(".footer-legal");
	public By systemButton = By.cssSelector("#menu-magento-backend-system");
	public By DashboardButton=By.cssSelector("#menu-magento-backend-dashboard");
	public By reportsButton = By.cssSelector("#menu-magento-reports-report");
	public By configurationLink=By.xpath("//li[contains(@class,'item-search-config')]/a[contains(@href,'system_config')]/span[text()='Configuration']");
	private By expandedElement = By.cssSelector("ul[aria-hidden='false']");
	private By ASTMTab=By.cssSelector("#system_config_tabs .config-nav-block:nth-of-type(1)");
	private By ChkAddValidationTabUnderSASTM = By.xpath("//*[@id='system_config_tabs']/div/ul/li/a/span[contains(text(),'Address Validation')]");
	public By saveAndcontinueButton = By.xpath("//span[text()='Save and Continue Edit']");
	public By createorderButton = By.xpath("//span[text()='Create Order']");
	public By addressDropdown = By.xpath("//select[@id='order-billing_address_customer_address_id']");



	@Step("Verify 'Standards & Publications' Option is visible.")
	public boolean verifyStandardsAndPublicationsOptionsIsVisible() {

		try {
			return getElement(standardsAndPublicationsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}
	public boolean verifyTransportableMoistureLimitOfCoalPageIsDisplayed() {
		try {
			PublicCommon.waitForSec(3);
			String title = driver.getTitle();
			assertEquals(title,"Transportable Moisture Limit of Coal");
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}
	public boolean verifyMailToLinkAndPhoneNumberToCall() {
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(fontenotmaillink));
			ReusableMethods.scrollIntoView(getElement(fontenotmaillink),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Angelique Fontenot phone number",fontenotphonenumber,"Failed to click on Angelique Fontenot phone number");
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.switchToWindowIndex(driver,0);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(fontenotmaillink));
			clickOnMethod("Angelique Fontenot mail link",fontenotmaillink,"Failed to click on Angelique Fontenot mail link");
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}
	public boolean verifyPTPMailToLink(){
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ptpmailLink));
			ReusableMethods.scrollIntoView(getElement(ptpmailLink),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("PTP mail link",ptpmailLink,"Failed to click on PTP mail link");
			PublicCommon.waitForSec(3);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	public boolean verifyPTPShippingTermsPageWithNewVerbiage() {
		try {
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return (getElement(PTPShippingPolicy).isDisplayed());
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify News' header is visible.")
	public boolean verifyNewsOptionsHeaderIsVisible() {
		try {
			return getElement(NEWSOptionsHeader).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify About's header is visible.")
	public boolean verifyAboutOptionsHeaderIsVisible()

	{

		try {
			return getElement(aboutOptionsHeader).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Get Involved header' is visible.")
	public boolean verifyGetInvolvedOptionsHeaderIsVisible() {
		try {
			return getElement(getInvolvedOptionsHeader).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'GetInvolved' image is visible.")
	public boolean verifyGetInvolvedImageIsVisible()

	{

		try {
			return getElement(getInvolvedImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'News' image is visible.")
	public boolean verifyNewsImageIsVisible() {

		try {
			return getElement(newsImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'About' image is visible.")
	public boolean verifyAboutImageIsVisible()

	{
		try {
			return getElement(aboutImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Step("Verify 'BOS' image is visible.")
	public boolean verifyBOSImageIsVisible() {
		try {
			return getElement(BOSImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'Compass' image is visible.")
	public boolean verifyCompassImageIsVisible() {
		try {
			return getElement(compassImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Standardization News' Option is visible.")
	public boolean verifyStandardizationNewsOptionsIsVisible() {
		try {
			return getElement(standardizationNewsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Magazines & Newsletters' is visible.")
	public boolean verifyMagazinesNNewslettersIsVisible() {
		try {
			return getElement(magazinesNNewslettersOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Step("Verify 'ASTM News' is visible.")
	public boolean verifyASTMNewsIsVisible() {
		try {
			return getElement(ASTMNewsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'News Releases' is visible.")
	public boolean verifyNewsReleasesIsVisible() {
		try {
			return getElement(newsReleasesOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Books Of Standards' Option is visible.")
	public boolean verifyBooksOfStandardsOptionsIsVisible() {
		try {
			return getElement(bookOfStandardsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Reading Room' Option is visible.")
	public boolean verifyReadingRoomOptionsIsVisible() {
		try {
			return getElement(readingRoomOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Tracker Services' Option is visible.")
	public boolean verifyTrackerServicesOptionsIsVisible() {
		try {
			return getElement(trackerServicesOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public void clickOnTracker() {
		mouseHoverProductsAndServicesOption();
		getElement(trackerServicesOptions).click();
	}

	@Step("Verify 'Catalogs' Option is visible.")
	public boolean verifyCatalogsOptionsIsVisible() {
		try {

			return getElement(catalogsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'Overview' Option is visible.")
	public boolean verifyOverviewOptionsIsVisible() {
		try {
			return getElement(overviewOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'White Papers' Option is visible.")
	public boolean verifywhitePapers() {
		try {
			return getElement(whitePapers).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'fact Sheet' Option is visible.")
	public boolean verifyfactSheet() {
		try {
			return getElement(factSheet).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'Detailed Overview' Option is visible.")
	public boolean verifyfdetailedOverview() {
		try {
			return getElement(detailedOverview).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'Overview' Option is visible.")
	public boolean verifyoverviewUnderOverview() {
		try {
			return getElement(overviewUnderOverview).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'Customm Platforms' Option is visible.")
	public boolean verifycustomPlatforms() {
		try {
			return getElement(customPlatforms).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'Specbuilder' Option is visible.")
	public boolean verifyspecbuilderOption() {
		try {
			return getElement(specbuilderOption).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'ASTM Compass' Option is visible.")
	public boolean verifyASTMCompassOption() {
		try {
			return getElement(ASTMCompassOption).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}
	
	@Step("Verify 'Integrated Services' Option is visible.")
	public boolean verifyintegratedServicesOptions() {
		try {
			return getElement(integratedServicesOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'Member and Officer Training' Option is visible.")
	public boolean verifymemberAndOfficerTraininng() {
		try {
			return getElement(memberAndOfficerTraining).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'PE Continuining Education' Option is visible.")
	public boolean verifyPEContinuiningEducation() {
		try {
			return getElement(PEContinuiningEducation).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'International Training' Option is visible.")
	public boolean verifyinternationalTraning() {
		try {
			return getElement(internationalTraning).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'All Traning Courses' Option is visible.")
	public boolean verifyallTraningCourses() {
		try {
			return getElement(allTraningCourses).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'Standards Products' Option is visible.")
	public boolean verifystandardsProducts() {
		try {
			return getElement(standardsProducts).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'Manuala, Monograms & Data' Option is visible.")
	public boolean verifymanualsMonogramsAndData() {
		try {
			return getElement(manualsMonogramsAndData).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'Technical Reports' Option is visible.")
	public boolean verifytechnicalReports() {
		try {
			return getElement(technicalReports).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'journals' Option is visible.")
	public boolean verifyjournals() {
		try {
			return getElement(journals).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'authors' Option is visible.")
	public boolean verifyauthors() {
		try {
			return getElement(authors).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}
	}
	
	@Step("Verify 'Corporate Citizenship' Option is visible.")
	public boolean verifycorporateCitizenship() {
		try {
			return getElement(corporateCitizenship).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exceptioncorporateCitizenship
		}

	}

	@Step("Verify 'Technical Committees' Option is visible.")
	public boolean verifyTechnicalCommitteesOptionsIsVisible() {
		try {
			return getElement(technicalCommitteesOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Navigate to Technical Committee page")
	public void clickTechnicalCommitteesOptions() {
		try {
			action.moveToElement(getElement(getInvolvedNavigation)).click(getElement(technicalCommitteesOptions)).build().perform();
			waitForElementPresent(technicalCommitteeHeader);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void clicktechnicalCommitteesOptions() {
		getElement(technicalCommitteesOptions).click();
	}

	@Step("Verify 'Membership' Option is visible.")
	public boolean verifyMembershipOptionsIsVisible() {
		try {
			return getElement(membershipOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'Meetings & Symposia' Option is visible.")
	public boolean verifyMeetingsNSymposiaOptionsIsVisible() {
		try {
			return getElement(meetingsNSymposiaOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'Students & Professors' Option is visible.")
	public boolean verifyStudentsNProfessorsOptionsIsVisible() {
		try {
			return getElement(studentsNProfessorsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'Publish With ASTM' Option is visible.")
	public boolean verifyPublishWithASTMOptionsIsVisible() {
		try {
			return getElement(publishWithASTMOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'FAQs' Option is visible.")
	public boolean verifyFAQsOptionsIsVisible() {
		try {
			return getElement(faqsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Leadership Team' Option is visible.")
	public boolean verifyLeadershipTeamOptionsIsVisible() {
		try {
			return getElement(leadershipTeamOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Governance' Option is visible.")
	public boolean verifyGovernanceOptionsIsVisible() {
		try {
			return getElement(governanceOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'History' Option is visible.")
	public boolean verifyHistoryOptionsIsVisible() {
		try {
			return getElement(historyOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Global Cooperation' Option is visible.")
	public boolean verifyGlobalCooperationOptionsIsVisible() {
		try {
			return getElement(globalCooperationOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'President's Column' Option is visible.")
	public boolean verifyPresidentsColumnOptionsIsVisible() {
		try {
			return getElement(presidentColumnOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Products & Services' is visible.")
	public boolean verifyProductsAndServicesNavigationIsVisible() {
		try {

			return getElement(productsAndServicesNavigation).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("MouseHover 'Standards & Publication' Option")
	public void mouseHoverStandardsAndPublication() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(standardsAndPublicationsOptions));
			ReusableMethods.mouseHover(driver, getElement(standardsAndPublicationsOptions),
					"Standards and Publication - Homepage.");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}
	@Step("MouseHover 'Products & Services' Option")
	public void mouseHoverProductsAndServicesOption() {
		try {
			PublicCommon.waitForSec(3);
			wait.until(ExpectedConditions.elementToBeClickable(productsAndServicesNavigation));
			ReusableMethods.mouseHover(driver, getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}
	}
	@Step("MouseHover 'Products & Services' Option")
	public void mouseHoverMarketIntelligenceOption() {
		try {
			PublicCommon.waitForSec(3);
			wait.until(ExpectedConditions.elementToBeClickable(marketintelligence));
			ReusableMethods.mouseHover(driver, getElement(marketintelligence),
					"Market Intelligence");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}
	}
	@Step("MouseHover 'Petroleum Reference Material' Option")
	public boolean mouseHoverPetroleumReferenceMaterialOption() {
		try {
			PublicCommon.waitForSec(3);
			wait.until(ExpectedConditions.elementToBeClickable(petrolumreferencematerial));
			ReusableMethods.mouseHover(driver, getElement(petrolumreferencematerial),
					"Petroleum Reference Material");
			if(getElement(petrolumreferencematerial).isDisplayed()) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			}
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
			return false;
		}
		return false;
	}
	@Step("Click on Market Intelligence")
	public void clickOnMarketIntelligence(){
		PublicCommon.waitForSec(3);
		getElement(marketintelligence).click();
	}
	@Step("Click on Proficiency Testing")
	public void clickOnProficiencytesting(){
		PublicCommon.waitForSec(3);
		getElement(proficiencyTestingOptions).click();
	}
	@Step("Click on Accept terms button")
	public void clickOnAcceptTerms(){
		PublicCommon.waitForSec(3);
		ReusableMethods.scrollIntoView(getElement(accepttermsbutton),driver);
		getElement(accepttermsbutton).click();
	}
	public void AcceptCookie(){
		PublicCommon.waitForSec(3);
		getElement(GDPRAcceptAll).click();
	}
	public void clickConfirmAddress(){
		PublicCommon.waitForSec(3);
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(confirmaddresswindow));
		getElement(useselectedaddress).click();
	}
	public void ClickOnTransportableMoistureLimitOfCoal(){
		PublicCommon.waitForSec(3);
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(nocommitteeaffiliation));
		ReusableMethods.scrollIntoView(getElement(nocommitteeaffiliation),driver);
		clickOnMethod("No Committee Affiliation",getElement(nocommitteeaffiliation));
		getElement(transportablemoisturelimitofcoal).click();
	}
	public boolean HeadingAndLinkUnderMarketIntelligence(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(marketintelligenceHeader), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(marketintelligenceHeader).isDisplayed();
			ReusableMethods.scrollIntoView(getElement(contactUsundermarketintelligence),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(contactUsundermarketintelligence).click();
			PublicCommon.waitForSec(3);
			String title= driver.getTitle();
			Assert.assertEquals(title,"Contact ASTM - Standards & Publications - Products & Services");
			driver.navigate().back();
			ReusableMethods.scrollIntoView(getElement(learnmoreaboutwohlersbutton),driver);
			getElement(learnmoreaboutwohlersimage).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch(Exception e){
			e.getStackTrace();
			return false;
		}
	}
	public boolean HeadingAndLinkUnderWohlersReport(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(wohlersreportHeader), driver);
			getElement(wohlersreportHeader).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(unlimitedaccessnowavailable), driver);
			getElement(unlimitedaccessnowavailable).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(contactUsunderwohlerreport),driver);
			getElement(contactUsunderwohlerreport).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(wohlerimage),driver);
			getElement(wohlerimage).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch(Exception e){
			e.getStackTrace();
			return false;
		}
	}
	public boolean HeadingAndLinkUnderPetroleumReferenceMaterials(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(petroleumreferencematerialVideo), driver);
			getElement(petroleumreferencematerialVideo).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(learnmoreaboutASTMrefmats), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(learnmoreaboutASTMrefmats).click();
			PublicCommon.waitForSec(5);
			String url = driver.getCurrentUrl();
			assertEquals(url,"http://astmrefmat.training.astm.org/#/");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.navigate().back();
			ReusableMethods.scrollIntoView(getElement(petroleumreferencematerialfooterheading),driver);
			getElement(petroleumreferencematerialfooterheading).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(petroleumreferencematerialfootercontactUs).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch(Exception e){
			e.getStackTrace();
			return false;
		}
	}
	@Step("MouseHover 'Get Involved' Option")
	public void mouseHoverGetInvolvedOption() {
		try {
			PublicCommon.waitForSec(3);
			wait.until(ExpectedConditions.elementToBeClickable(getInvolvedNavigation));
			ReusableMethods.mouseHover(driver, getElement(getInvolvedNavigation),
					"Get Involved - Homepage.");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}
	}
	@Step("MouseHover 'Consumer Participation under Get Involved' Option")
	public void mouseHoverConsumerParticipationOption() {
		try {
			PublicCommon.waitForSec(3);
			wait.until(ExpectedConditions.elementToBeClickable(getConsumerParticipation));
			ReusableMethods.mouseHover(driver, getElement(getConsumerParticipation),
					"Get Involved - Homepage.");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}
	}

	@Step("MouseHover 'Overview' Option")
	public void mouseHoverOverviewOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(overviewOptions), "hover over Overview Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}

	@Step("MouseHover 'Governance' Option")
	public void mouseHoverGovernanceOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(governanceOptions), "hover over Overview Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}

	@Step("MouseHover 'Students & Professors' Option")
	public boolean mouseHoverStudentsAndProfessorsOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(studentsNProfessorsOptions),
					"hover over Students And Professors Options");
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Step("MouseHover 'History' Option")
	public void mouseHoverHistoryOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(historyOptions), "hover over History Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}

	@Step("MouseHover 'Global Cooperation' Option")
	public void mouseHoverGlobalCooperationOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(globalCooperationOptions),
					"hover over Global Cooperation Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}

	

	/**
	 * Method is used to click on StandardsAndPublicationsOptions in Mobile browser
	 */
	public boolean clickStandardsAndPublicationsOptionsMobile() {
		getElement(standardsAndPublicationsOptionsOnMobile).click();
		return true;
	}

	@Step("MouseHover 'Training Courses' Option")
	public void mouseHoverTrainingCoursesOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(trainingCoursesOptions),
					"hover over Training Courses Options");
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Step("Navigate to Training Courses page")
	public boolean clickTrainingCoursesOption() {
		try {
			mouseHoverProductsAndServicesOption();
			getElement(trainingCoursesOptions).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
			return false;
		}
	}

	public boolean navigateToTrainingCoursesPage() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation), "Training Courses");

			ScreenshotUtil.takeScreenshotForAllure(driver);

			clickTrainingCoursesOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
			return false;
		}

	}

	@Step("MouseHover 'News' Navigation Option")
	public void mouseHoverNewsNavigationOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(newsNavigation), "hover over News Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}

	@Step("MouseHover 'About' Navigation Option")
	public void mouseHoverAboutNavigationOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(aboutNavigation), "hover over About Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}
	
//	public void clickGlobalCooperation() {
//		Actions action = new Actions(driver);
//		action.moveToElement(getElement(aboutNavigation)).click(getElement(gCInAbout)).build().perform();
//	}
	
	public void clickGlobalCooperation() {
		getElement(gCInAbout).click();
	}
	
	public void clickGovernance() {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(aboutNavigation)).click(getElement(governance)).build().perform();
	}
	
	public void clickgCInAbout() {
		getElement(gCInAbout).click();
	}
	
	public void clickdEAndI() {
		getElement(dEAndI).click();
	}

	public boolean verifyDEAndI() {
		return getElements(dEAndI).size() == 1;
	}

	@Step("MouseHover 'GetInvolved' Navigation Option")
	public boolean mouseHoverGetInvolvedNavigationOption() {
		try {
			ReusableMethods.mouseHover(driver, getElement(getInvolvedNavigation), "hover over GetInvolved Options");
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Step("MouseHover 'Standards&Publications' Option")
	public void mouseHoverEnterpriseSolutionsOption() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(enterpriseSolutionsOptions));
			ReusableMethods.mouseHover(driver, getElement(enterpriseSolutionsOptions),
					"hover over Enterprise Solutions Options");
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}

	}
	
	@Step("click 'Enterprise Solutions'  Option")
	public void clickEnterpriseSolutionsOption() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(productsAndServicesNavigation)).moveToElement(getElement(enterpriseSolutionsOptions)).click().build().perform();	
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public WebElement getTenantsLink(int index)
	{
		WebElement ele=driver.findElement(By.xpath("(//a[contains(text(),'Learn more')])["+index+"]"));
		return ele;
	}

	/**
	 * Method used to click on Enterprise Solutions Option for Mobile Browser
	 */
	public boolean clickOnEnterpriseSolutionsOptionForMobile() {
		WebElement element = getElement(enterpriseSolutionsOptionsMobile);
		ReusableMethods.scrollIntoView(element, driver);
		element.click();
		return true;
	}

	@Step("Verify Subcategories Under 'Standards & Publications' Option")
	public Boolean verifySubcategoriesUnderStandardsAndPublicationsOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon
					.getListOfTextFromListOfWebelements(getStandardsAndPublicationsCategoriesList(), driver);
			System.out.println(actualList);

			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	/**
	 * "Verify Subcategories Under 'Standards & Publications' Option"
	 * 
	 * @param expectedList
	 * @return
	 */
	public List<String> verifySubcategoriesUnderStandardsAndPublicationsOptionMobile(List<String> expectedList) {

		List<String> actualList = PublicCommon.getListOfTextFromListOfWebelementsForMobile(
				getStandardsAndPublicationsCategoriesListForMobile(), driver);
		System.out.println(actualList);

		return actualList;

	}

	@Step("Verify Subcategories Under 'Overview' Option")
	public Boolean verifySubcategoriesUnderOverviewOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getOverviewList(), driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Verify Subcategories Under 'Governance' Option")
	public Boolean verifySubcategoriesUnderGovernanceOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getGovernanceList(), driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Verify Subcategories Under 'Students & Professors' Option")
	public Boolean verifySubcategoriesUnderStudentsAndProfessorsOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getStudentsNProfessorsList(),
					driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Verify Subcategories Under 'History' Option")
	public Boolean verifySubcategoriesUnderHistoryOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getHistoryList(), driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Verify Subcategories Under 'Global Cooperation' Option")
	public Boolean verifySubcategoriesUnderGlobalCooperationOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getGlobalCooperationList(),
					driver);
			System.out.println("ACtual" + actualList);
			System.out.println(expectedList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Verify Subcategories Under 'Enterprise Solutions' Option")
	public Boolean verifySubcategoriesUnderEnterpriseSolutionsOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getEnterpriseSolutionsList(),
					driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	/**
	 * Method verifies sub categories under Enterprise Solutions Option for Mobile
	 * Browser
	 * 
	 * @return Actual List of sub categories under Enterprise Solutions Option for
	 *         Mobile Browser
	 */
	public List<String> verifySubcategoriesUnderEnterpriseSolutionsOptionForMobile() {
		return PublicCommon.getListOfTextFromListOfWebelementsForMobile(getEnterpriseSolutionsListForMobile(), driver);
	}

	@Step("Verify Subcategories Under 'Training Courses' Option")
	public Boolean verifySubcategoriesUnderTrainingCoursesOption(List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(getTrainingCoursesList(), driver);
			System.out.println("actualList:" + actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Step("Verify 'Get Involve' Link is visible.")
	public boolean verifyInvolveLinkIsVisible() {
		try {
			return getElement(getInvolvedNavigation).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'News' Link is visible.")
	public boolean verifyNewsLinkIsVisible() {
		try {
			return getElement(newsNavigation).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'About' Link is visible.")
	public boolean verifyAboutLinkIsVisible() {
		try {
			return getElement(aboutNavigation).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Language' Link is visible.")
	public boolean verifyLanguageLinkIsVisible() {
		try {
			return getElement(languageLink).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Contact' Link is visible.")
	public boolean verifyContactLinkIsVisible() {
		try {
			return getElement(contactLink).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Cart' Link is visible.")
	public boolean verifyCartLinkIsVisible() {
		try {
			return getElement(cartLink).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Sign-in' button is visible.")
	public boolean verifySignInButtonIsVisible() {
		try {
			return getElement(signInLink).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'My ASTM' button is visible.")
	public boolean verifyMyASTMButtonIsVisible() {
		try {
			return getElement(myASTMLink).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Search' tab is visible.")
	public boolean verifySearchTabIsVisible() {
		try {
			return getElement(searchCombobox).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public void clickSearchBox() {
		getElement(searchCombobox).click();
	}

	public void editSearchBox(String entertext) {
		PublicCommon.waitForSec(4);
		wait.until(ExpectedConditions.elementToBeClickable(searchCombobox));
		getElement(searchCombobox).clear();
		getElement(searchCombobox).sendKeys(entertext);
	}

	public boolean verifySearchBoxAutoComplete() {
		return getElement(searchCombobox).getAttribute("autocomplete").equals("off");
	}

	public boolean verifyTextInSearchBox(String searchText) {
		return getElement(searchCombobox).getText().equals(searchText);

	}

	public String getValueAttributeInSearchBox() {
		return getElement(searchCombobox).getAttribute("value");
	}

	public String getLinkAttribute(By locator) {
		return getElement(locator).getAttribute("href");
	}

	public boolean getValueAttributeInSearchBoxEquals(String searchText) {
		return getElement(searchCombobox).getAttribute("value").equals(searchText);
	}

	public void clickSearchIcon() {
		getElement(searchIcon).click();
		PublicCommon.waitForSec(10);
	}

	public void clickSearch() {
		getElement(searchIcon).click();
	}

	public void clearSearchText() {
		getElement(searchCombobox).clear();
	}

	public void clearFooterTextBoxSearchText() {
		getElement(footerSearchbar).clear();
	}

	@Step("Verify Search bar contains All Options as expected.")
	public boolean verifyOptionsInSearchBar(List<String> expectedList) {
		try {
			clickSearchDropdown();
			List<String> actualList = ReusableMethods.getListOfOptionsValueInDropdown(getHeaderSearchDropdown(),
					driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Step("Clicked on the Header Search Dropdown.")
	public void clickSearchDropdown() {
		getElement(headerSearchDropdown).click();
	}

	public boolean navigateToCementNConcreteReferenceLab() {
		try {
			mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(cementNConcreteReferenceLabOptions),
					"Cement ad Concrete Reference Lab Navigation");
			PublicCommon.waitForSec(3);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public boolean navigateToCementNConcreteReferenceLabMobile() {
		try {
			// mouseHoverProductsAndServicesOption();
			ReusableMethods.scrollIntoView(getElement(ccrlOptionMobile), driver);
			ReusableMethods.mouseHoverAndClick(driver, getElement(ccrlOptionMobile),
					"Cement ad Concrete Reference Lab Navigation");
			PublicCommon.waitForSec(3);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public boolean navigateToManualMonographPage() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
			ReusableMethods.mouseHover(driver, this.getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			ReusableMethods.mouseHoverAndClick(driver, getElement(manualsMonogramsAndData),
					"Couldn't complete Manual Monograph Navigation");
			PublicCommon.waitForSec(3);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public boolean navigateToPTPPage() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");

			ReusableMethods.mouseHoverAndClick(driver, getElement(proficiencyTestingOptions),
					"Couldn't complete Proficiency Testing page");
			PublicCommon.waitForSec(3);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public boolean navigateToSymposiaAndSTPPage() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
			ReusableMethods.mouseHover(driver, this.getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			ReusableMethods.mouseHoverAndClick(driver, getElement(symposiaPapersAndSTPs),
					"Couldn't complete Symposia Papers And STPs page Navigation");
			PublicCommon.waitForSec(3);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}


	public boolean navigateToManualsMonographsSTPPage() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
			ReusableMethods.mouseHover(driver, this.getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			ReusableMethods.mouseHoverAndClick(driver, getElement(manualsMonogramsAndData),
					"Couldn't complete Symposia Papers And STPs page Navigation");
			PublicCommon.waitForSec(3);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Unable to Navigate ManualMonographsPage",e);
			return false;
		}

	}

	@Step("Verify 'Cement & Concrete Reference Lab' Option is visible.")
	public boolean verifysymposiaPapersAndSTPs() {
		try {
			return getElement(symposiaPapersAndSTPs).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}
	
	public boolean logoCementNConcreteReferenceLab() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(ccrlLogo), driver);

		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Cement & Concrete Reference Lab' Option is visible.")
	public boolean verifyCementNConcreteReferenceLabOptionsIsVisible() {
		try {
			return getElement(cementNConcreteReferenceLabOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Certification' Option is visible.")
	public boolean verifyCertificationOptionsIsVisible() {
		try {
			return getElement(certificationOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}
	public void clickOnASTMInsightSQC() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(productsAndServicesNavigation);
			mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(ASTMinsightSQC), "ASTM Insight SQC Option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickOnRequestADemo() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(requestDemo2);
			getElement(requestDemo2).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Step("Click on Content")
	public void clickOnContent(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(contentButton);
			ReusableMethods.mouseHoverAndClick(driver, getElement(contentButton), "Content Option");
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Content", e);
		}
	}
	public void clickOnCatalog(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(catalogButton);
			ReusableMethods.mouseHoverAndClick(driver, getElement(catalogButton), "Catalog Option");
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Content", e);
		}
	}
	@Step("Click on Customer Button")
	public void clickOnCustomer(){
		try {
			PublicCommon.waitForSec(5);
			waitForElementPresent(customerButton);
			ReusableMethods.mouseHoverAndClick(driver, getElement(customerButton), "Customer Option");
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step("Add contact for B2B user")
	public void addingContactForB2BUser(){
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AllCustomerPage.getEditButton()),20);
			PublicCommon.JSClick(getElement(AllCustomerPage.editButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(contacts),5);
			getElement(contacts).click();
			PublicAdminCommons.handleSpinnerIcon(driver, spinnerIcon);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(addNewContact),10);
 			getElement(addNewContact).click();
			PublicAdminCommons.handleSpinnerIcon(driver, spinnerIcon);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(TPTLearner),10);
			getElement(TPTLearner).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(billTo),5);
            getElement(billTo).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(shipTo),5);
            getElement(shipTo).click();
			getElement(contactFirstName).sendKeys("FName");
			getElement(contactLastName).sendKeys("LName");
			getElement(contactEmail).sendKeys("testaccB2BContact" + System.currentTimeMillis() + "@yopmail.com");
			clickOnSave();
			PublicAdminCommons.handleSpinnerIcon(driver, spinnerIcon);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnSaveAndContinueEdit();
			PublicAdminCommons.handleSpinnerIcon(driver, spinnerIcon);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to add tpt leaner contact", e);
		}
	}
	@Step("Click in Sales")
	public void clickOnSales(){
		try {
			PublicAdminCommons.scrollToElement(driver,salesButton);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(salesButton));
			PublicCommon.waitForSec(5);
			waitForElementPresent(salesButton);
			WaitStatementUtils.explicitWait(driver,getElement(salesButton));
			ReusableMethods.mouseHoverAndClick(driver, getElement(salesButton), "Sales Option");
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step("Click on create new Order")
	public void clickOnCreateNewOrderButton(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(createneworderButton);
			ReusableMethods.mouseHoverAndClick(driver, getElement(createneworderButton), "Create New Order Button");
			PublicCommon.waitForSec(15);
			driver.navigate().refresh();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickOnProduct(){
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(productLink));
			clickOnMethod("Product option",getElement(productLink));
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Step("Click on All Customers")
	public void clickOnAllCustomers(){
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(allcustomersLink));
			clickOnMethod("All Customers link",getElement(allcustomersLink));
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step("Click on Create new order")
	public void createOrder() {
		try {
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(createOrder),10);
			getElement(createOrder).click();
			PublicCommon.waitForSec(2);
			driver.navigate().refresh();
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("unable to click on create order", e);
		}
	}
	@Step("Click on Orders")
	public void clickOnOrders(){
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ordersLink));
			clickOnMethod("Product option",getElement(ordersLink));
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Step("Click in Add new Customers button")
	public void clickOnAddNewCustomerButton(){
		try {
			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(addnewcustomerButton));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(addnewcustomerButton));
			clickOnMethod("Add New Customer button",getElement(addnewcustomerButton));
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public void CreateClassification(String email,String CustomerType,String classification,String sheetName,String WebdataSheetName){
		try{
			HashMap<String, String> RegistrationDataMap = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);

			if(CustomerType == "Organization"){
				PublicCommon.waitForSec(3);
				enterOrganization("ASTM");
				System.out.println(email);
				enterCommunicationEmail(email);
				enterPhoneNumber(RegistrationDataMap.get("PhoneNumber"));
				ScreenshotUtil.takeScreenshotForAllure(driver);

			} else if (CustomerType == "Person") {
				PublicCommon.waitForSec(3);
				newCustomerRegistration(RegistrationDataMap.get("FirstName"), RegistrationDataMap.get("LastName"), RegistrationDataMap.get("PhoneNumber"));
				System.out.println(email);
				enterEMail(email);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}

			ChangeClassicfication(classification);
			clickOnContinue();
			PublicCommon.waitForSec(5);
			clickOnAddNewAddress();
			AddnewAddress(RegistrationDataMap.get("StreetAddress"), RegistrationDataMap.get("City"), RegistrationDataMap.get("ZipCode"), RegistrationDataMap.get("PhNo"));
			selectValue("State", state, RegistrationDataMap.get("state"), "Select State from Drop down");
			clickOnSave();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public void CreateARInoiceType(String email,String CustomerType,String sheetName,String WebdataSheetName){
		try{
			HashMap<String, String> RegistrationDataMap = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);

			if(CustomerType == "Organization"){
				PublicCommon.waitForSec(3);
				enterOrganization("ASTM");
				System.out.println(email);
				enterCommunicationEmail(email);
				enterPhoneNumber(RegistrationDataMap.get("PhoneNumber"));
				ScreenshotUtil.takeScreenshotForAllure(driver);

			} else if (CustomerType == "Person") {
				PublicCommon.waitForSec(3);
				newCustomerRegistration(RegistrationDataMap.get("FirstName"), RegistrationDataMap.get("LastName"), RegistrationDataMap.get("PhoneNumber"));
				System.out.println(email);
				enterEMail(email);
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}

			PublicCommon.selectValueInDropdown(	getElement(ARInvoiceType),"BOM");
			clickOnContinue();
			PublicCommon.waitForSec(5);
			clickOnAddNewAddress();
			AddnewAddress(RegistrationDataMap.get("StreetAddress"), RegistrationDataMap.get("City"), RegistrationDataMap.get("ZipCode"), RegistrationDataMap.get("PhNo"));
			selectValue("State", state, RegistrationDataMap.get("state"), "Select State from Drop down");
			clickOnSave();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickOnCategories(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(categoriesLink);
			ReusableMethods.mouseHoverAndClick(driver, getElement(categoriesLink), "Categories link");
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickOnPages(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(pagesLink);
			ReusableMethods.mouseHoverAndClick(driver, getElement(pagesLink), "Pages link");
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Step("Click on Blocks")
	public void clickOnBlocks(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(blockLink);
			ReusableMethods.mouseHoverAndClick(driver, getElement(blockLink), "Blocks link");
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Blocks", e);
		}
	}
	@Step("Search with the required email")
	public void Search(String email){
		try {
			WaitStatementUtils.waitForElementStaleness(driver,getElement(ClearAllBtn));
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ClearAllBtn));
			getElement(ClearAllBtn).click();
			PublicCommon.waitForSec(15);
			waitForElementPresent(Adminsearchbykeyword);
			PublicCommon.waitForSec(5);
			getElement(Adminsearchbykeyword).clear();
			getElement(Adminsearchbykeyword).sendKeys(email);
			PublicCommon.waitForSec(10);
			getElement(Adminsearchicon).click();
			WaitStatementUtils.explicitWait(driver,getElement(accountNo(email)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step("Search with the required item")
	public void Search_Required(String value){
		try {
			WaitStatementUtils.explicitWait(driver,getElement(ClearAllBtn));
			getElement(ClearAllBtn).click();
			PublicCommon.waitForSec(15);
			WaitStatementUtils.explicitWait(driver,getElement(Adminsearchbykeyword));
			getElement(Adminsearchbykeyword).clear();
			getElement(Adminsearchbykeyword).sendKeys(value);
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(Adminsearchicon).click();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Search with the required item", e);

		}
	}
	@Step("Edit the record from Select Dropdown")
	public void editFromSelect(){
		try {
			WaitStatementUtils.explicitWait(driver,getElement(select));
			getElement(select).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(edit).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Edit the record from Select Dropdown", e);

		}
	}
	@Step("Click on Edit with pageBuilder")
	public void clickOnEditPageBuilder(){
		try {
			WaitStatementUtils.explicitWait(driver,getElement(htmlCode));
			ReusableMethods.scrollIntoView(getElement(htmlCode),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(editWithPageBuilder).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Edit with pageBuilder", e);

		}
	}


	@Step("Click on Html code settings and make the changes")
	public void htmlCodeEditor(String data){
		try {
			PublicCommon.waitForSec(5);
			ReusableMethods.mouseHover(driver,getElement(htmlCode),"html code");
			getElement(settings).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(htmlCodeInsert).clear();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToOffSet(driver,"0","-500");
			getElement(htmlCodeInsert).sendKeys(data);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(saveButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveButton),15);
			getElement(saveButton).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(fullScreen),15);
			getElement(fullScreen).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(AddAttributePageSaveBtn));
			getElement(AddAttributePageSaveBtn).click();
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(saveSuccess_Block));
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Html code settings and make the changes", e);

		}
	}
	@Step("verify newly added category visible")
	public void verifyNewlyAddedCategory(){
		try {
			PublicCommon.waitForSec(20);
			PublicAdminCommons.refreshPage(driver);
			PublicCommon.waitForSec(20);
			newMembershipPage.handleOneTrustCookie();
			waitForElementPresent(getInvolved1);
			ReusableMethods.mouseHover(driver, getElement(getInvolved1), "Get Involved option");
			ReusableMethods.mouseHover(driver, getElement(ConsumerParticipation), "Consumer Participation option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			verifyDataAvailability(true);

		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to", e);

		}
	}
	@Step("verify  deleted category not visible")
	public void verifyDeletedCategory(){
		try {
			PublicCommon.waitForSec(20);
			PublicAdminCommons.refreshPage(driver);
			PublicCommon.waitForSec(20);
			PublicAdminCommons.refreshPage(driver);
			newMembershipPage.handleOneTrustCookie();
			waitForElementPresent(getInvolved1);
			ReusableMethods.mouseHover(driver, getElement(getInvolved1), "Get Involved option");
			ReusableMethods.mouseHover(driver, getElement(ConsumerParticipation), "Consumer Participation option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			verifyDataAvailability(false);

		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to", e);

		}
	}
	@Step("verify newly added category visible for particular dropdown")
	public void verifyDataAvailability(boolean Value){
		try {
			 int trueValue = 0;
             int dropDownValues = getElements(ConsumerParticipation_dropdownValues).size();
			 for(int i =1;i<=dropDownValues;i++){
				 if(getElement(dropdownValues(i)).getText().contains("Stage Automation Menu Test")){
					 trueValue++;
				 }
			 }
			 if(Value) {
				 ScreenshotUtil.takeScreenshotForAllure(driver);
				 Assert.assertTrue(trueValue == 1, "Value is not added in dropdown");
				 Allure.addAttachment("Dropdown Added?","Yes Added");
			 }else{
				 ScreenshotUtil.takeScreenshotForAllure(driver);
				 Assert.assertTrue(trueValue == 0, "Value is added in dropdown");
				 Allure.addAttachment("Dropdown Deleted?","Yes Deleted");
			 }
		}
		catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify newly added category visible for particular dropdown", e);

		}
	}

	@Step("Verify events in member app ")
	public void verifyEventsInMemApp(String name){
		try {
			PublicCommon.waitForSec(5);
			homePagePublic.navigateToHomeLink("Membership & Participation","Meetings, Symposia, Workshops",1,1);
			/*WaitStatementUtils.explicitWait(driver,getElement(getGetInvolvedLink));
			getElement(getGetInvolvedLink).click();
			getElement(getMeetingsAndSymposiaLink).click();*/
			PublicCommon.switchTabs(driver,1);
			PublicCommon.waitForSec(5);
			WaitStatementUtils.explicitWait(driver,getElement(viewAllEvents));
			getElement(viewAllEvents).click();
			PublicCommon.waitForSec(5);
			ReusableMethods.scrollIntoView(getElement(eventName(name)),driver);
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver,eventName(name)),"Event name not visible in memeber app");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify events in member app", e);
		}
	}
	@Step("Verify events And location in member app ")
	public void verifyEventsAndLocationInMemApp(String name,String location){
		try {
			PublicCommon.waitForSec(5);
			homePagePublic.navigateToHomeLink("Membership & Participation","Meetings, Symposia, Workshops",1,1);
			/*WaitStatementUtils.explicitWait(driver,getElement(getGetInvolvedLink));
			getElement(getGetInvolvedLink).click();
			getElement(getMeetingsAndSymposiaLink).click();*/
			PublicCommon.switchTabs(driver,1);
			PublicCommon.waitForSec(5);
			WaitStatementUtils.explicitWait(driver,getElement(viewAllEvents));
			getElement(viewAllEvents).click();
			PublicCommon.waitForSec(5);
			ReusableMethods.scrollIntoView(getElement(eventName(name)),driver);
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver,eventName(name)),"Event name not visible in memeber app");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(PublicCommon.isWebElementDisplayed(driver,getLocation(location)),"Location not visible in memeber app");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify events And location in member app", e);
		}
	}





	public WebElement ViewBtn(){
			return getElement(ViewBtn);
	}
	public void clickOngetInvolved(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(getInvolved);
			ReusableMethods.mouseHoverAndClick(driver, getElement(getInvolved), "Get Involved option");
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickOnFilters(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(filter);
			getElement(filter).click();
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Step("Verify ASTM Attributue accordion is expanded or not")
	public void clickOnASTMattributes(){
		try {
			if(getElement(ASTMattributeCollapisible).getAttribute("data-state-collapsible").equals("closed")) {
				ReusableMethods.scrollIntoView(getElement(ASTMattributeCollapisible),driver);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ASTMattributeCollapisible));
				waitForElementPresent(ASTMattributeCollapisible);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				PublicCommon.JSClick(getElement(ASTMattributeCollapisible),driver);
				PublicCommon.waitForSec(3);
				getElement(ASTMattributeCollapisible).getAttribute("data-state-collapsible").equals("open");
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verify Disable Public Order is available")
	public void VerifyDisablePublicOrderRadio(){
		try{
			ReusableMethods.scrollIntoView(getElement(AssetType),driver);
			PublicCommon.waitForSec(10);
			if (getElement(PublicOrderAttribute).isSelected()) ;
			{
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(PublicOrderAttribute), 10);
				PublicCommon.JSClick(getElement(PublicOrderAttribute), driver);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Verify Disable Public Order", e);
		}
	}

	@Step("Verify Enable Public Order is Unavailable")
	public void VerifyEnablePublicOrderRadio() {
		try {
				if (!getElement(PublicOrderAttribute).isSelected())
				{
					WaitStatementUtils.waitForElementToBeClickable(driver, getElement(PublicOrderAttribute), 10);
					PublicCommon.JSClick(getElement(PublicOrderAttribute), driver);
				}
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}catch(Exception e){
				e.printStackTrace();
				PublicCommon.reportFailAssert("Failed to Verify Disable Public Order", e);
			}
		}

	@Step("Click on Save button in Add attributes page")
	public void SaveBtn(){
		try {
			getElement(AddAttributePageSaveBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForLoaderToBeInvisible(driver);
			PublicCommon.waitForSec(5);
		} catch(Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on Save button", e);
		}
	}
	public void clickOnEditLink(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(editLink);
			ReusableMethods.scrollIntoView(getElement(editLink),driver);
			PublicCommon.JSClick(getElement(editLink),driver);
			//getElement(editLink).click();
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickOnPDFChild(String sku){
		try {
			PublicCommon.waitForSec(3);
			//ReusableMethods.scrollIntoView(getElement(PDFchild(sku)),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(PDFchild(sku)));
			getElement(PDFchild(sku)).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void sendKeysToTitle(String key) {
		try {
			getElement(title).clear();
			getElement(title).sendKeys(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void sendKeysToURLkey(String key) {
		try {
			getElement(urlkey).clear();
			getElement(urlkey).sendKeys(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void sendKeysToSKU(String key) {
		try {
			getElement(skuField).clear();
			getElement(skuField).sendKeys(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void sendKeysToType(String key) {
		try {
			getElement(typeField).click();
			getElement(typeField).sendKeys(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void sendKeysTosearch(String key) {
		try {
			PublicCommon.waitForSec(3);
			getElement(searchHeader).clear();
			getElement(searchHeader).sendKeys(key);
			getElement(searchIcon).click();
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnApplyFilters(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(Applyfilter);
			getElement(Applyfilter).click();
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step("Search with the required SKU and click on it")
	public void searchSKU(String properSkuNumber){
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
				List<WebElement> skusInSearchResult = getElementsNew(SKUsearch);
				for (WebElement skuElement : skusInSearchResult) {
					if (skuElement.getText().trim().equals(properSkuNumber)) {
						PublicAdminCommons.loaderClick(getElementsNew(SKUsearch).get(skusInSearchResult.indexOf(skuElement)));
						PublicCommon.waitForSec(15);
						ScreenshotUtil.takeScreenshotForAllure(driver);
						WaitStatementUtils.explicitWaitForVisibility(driver,getElement(CatalogPageSKU),10);
						getElement(CatalogPageSKU).getText().equals(properSkuNumber);
						ScreenshotUtil.takeScreenshotForAllure(driver);
						break;
					}
				}
			} catch(Exception e){
				e.printStackTrace();
		}
	}
	public void clickOnWhatisASTMunderConsumerParticipation(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(customerparticipation);
			getElement(customerparticipation).click();
			PublicCommon.waitForSec(3);
			waitForElementPresent(whatisASTMundercustomerparticipation);
			getElement(whatisASTMundercustomerparticipation).click();
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickOnHowToGetInvolvedUnderConsumerParticipation(){
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(customerparticipation);
			getElement(customerparticipation).click();
			PublicCommon.waitForSec(3);
			waitForElementPresent(howtogetinvolvedundercustomerparticipation);
			getElement(howtogetinvolvedundercustomerparticipation).click();
			PublicCommon.waitForSec(3);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickOnTechnicalCommittees() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(getInvolvedNavigation);
			mouseHoverGetInvolvedOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(technicalCommitteesOptions), "Technical Committees Option");
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickOnInitiateNewStandardsActivity() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(initiatenewstandards);
			ReusableMethods.moveToElementAndClick(driver,getElement(initiatenewstandards));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean verifyActiveUOPstandardsAreListedByDesignationandtitleIsVisible(){
		try{
			PublicCommon.waitForSec(3);
			waitForElementPresent(getPageHeading());
			if(getElement(getPageHeading()).isDisplayed()){
				if(getElement(getsubHeadingtitle()).isDisplayed()) {
					ScreenshotUtil.takeScreenshotForAllure(driver);
					return true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public boolean verifyUOPstandardsIsVisible(){
		try{
			PublicCommon.waitForSec(3);
			waitForElementPresent(uopStandard);
			if(getElement(uopStandard).isDisplayed()){
				ReusableMethods.scrollIntoView(getElement(uopStandard),driver);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public boolean clickOnInitiationOfNewActivityAndVerifyTextNotPresent() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(initiationofnewactivity);
			ReusableMethods.moveToElementAndClick(driver,getElement(initiationofnewactivity));
			PublicCommon.waitForSec(3);
			if(!driver.getPageSource().contains("To suggest a new ASTM standard or standards area and begin the process of information gathering, see http://www.astm.org/ASK_ASTM/index.html.")){
				ScreenshotUtil.takeScreenshotForAllure(driver);
				System.out.println("pass");
				return true;
			}
			else {
				System.out.println("fail");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void clickOnStandardsProducts() {
		try {
			/*waitForElementPresent(productsAndServicesNavigation);
			mouseHoverProductsAndServicesOption();
			waitForElementPresent(standardsAndPublicationsOptions);
			mouseHoverStandardsAndPublication();*/
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.mouseHoverAndClick(driver, getElement(StandardProduct), "Standards Products Option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String copyDesignation(int productNo){
		try{
			PublicCommon.waitForSec(3);
			waitForElementPresent(copydesignation(productNo));
			String text = getElement(copydesignation(productNo)).getText();
			String subtext = text.substring(0,10);
			return subtext;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void clickOnUOPstandard() {
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(uopStandard));
			clickOnMethod("UOP Standard button",getElement(uopStandard));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnStandardsByCategory() {
		try {
			PublicCommon.waitForSec(5);
			ReusableMethods.scrollIntoView(getElement(standardbycategory),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(standardbycategory),10);
		    PublicAdminCommons.clickElementByJavaScript(driver,standardbycategory);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickOnWhatIsASTMOptions() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(getInvolvedNavigation);
			mouseHoverGetInvolvedOption();
			waitForElementPresent(getConsumerParticipation);
			mouseHoverConsumerParticipationOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.mouseHoverAndClick(driver, getElement(whatisASTM), "What is ASTM Option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ClickOnConsumerParticipationOption(){
		try{
			PublicCommon.waitForSec(3);
			waitForElementPresent(getInvolvedNavigation);
			mouseHoverGetInvolvedOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(getConsumerParticipation), "Consumer Participation Option");
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ClickOnNewsAndEvents(){
		try{
			PublicCommon.waitForSec(3);
			getElement(newsANDeventsoption).click();
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickOnHowToGetInvolvedOptions() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(getInvolvedNavigation);
			mouseHoverGetInvolvedOption();
			waitForElementPresent(getConsumerParticipation);
			mouseHoverConsumerParticipationOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.mouseHoverAndClick(driver, getElement(howtogetinvolved), "How to Get Involved Option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickOnTrainingAndResourcesOptions() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(getConsumerParticipation);
			mouseHoverConsumerParticipationOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.mouseHoverAndClick(driver, getElement(trainingandresources), "Training and Resources Option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickcertificationOptions() {
		try {
			PublicCommon.waitForSec(3);
			waitForElementPresent(productsAndServicesNavigation);
			mouseHoverProductsAndServicesOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.mouseHoverAndClick(driver, getElement(certificationOptions), "Certificaion Option");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean IsPageShowCurrentlyActive() {
		try {
//			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(ASTMheader));
//			PublicCommon.isWebElementDisplayed(driver,ASTMheader);
			PublicCommon.isWebElementDisplayed(driver,currentlyActive);
			PublicCommon.isWebElementDisplayed(driver,CMSpage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsPagefilterSuccessfully(String name) {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(getFilterpage(name)));
			PublicCommon.isWebElementDisplayed(driver,getFilterpage(name));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean VerifyStandardFamily(){
		try{
			PublicCommon.waitForSec(3);
			//ReusableMethods.scrollIntoView(getElement(astmAttributes),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(astmAttributes));
			clickOnASTMattributes();
			ReusableMethods.scrollIntoView(getElement(standardfamily),driver);
			PublicCommon.waitForSec(3);
			String text;
			text=getElement(standardfamily).getAttribute("value");
			if(text!=null){
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			}else {
				return false;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean VerifyOnlyPDFversionIsEnabled(String sku){
		try{
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(productwithpdfversionEnabled(sku)));
			if(getElement(productwithpdfversionEnabled(sku)).isDisplayed()){
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			}
			else{
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return false;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean VerifyBundleWithStandardToggle(){
		try{
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(bundlewithstandard));
			if(getElement(bundlewithstandard).isDisplayed()){
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			}else {
				return false;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean VerifyInventoryItemStatusCode(){
		try{
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(astmAttributes));
			PublicCommon.waitForSec(3);
			getElement(astmAttributes).click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(inventoryitemstatuscode));
			ReusableMethods.scrollIntoView(getElement(inventoryitemstatuscode),driver);
			String text = getElement(inventoryitemstatuscode).getAttribute("value");
			System.out.println(text);
			if(text.equals("Active ONL")){
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			}else {
				return false;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean VerifyBundleWithActiveVersion(String no){
		try{
			PublicCommon.waitForSec(3);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(bundlewithactiveversion(no)));
			if(getElement(bundlewithactiveversion(no)).isDisplayed())
			{
				ReusableMethods.scrollIntoView(getElement(bundlewithactiveversion(no)),driver);
				PublicCommon.waitForSec(3);
				ScreenshotUtil.takeScreenshotForAllure(driver);
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickOnASTMinsightSQCAndNavigate(){
		try {
			PublicCommon.waitForSec(3);
			getElement(popclose).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(searchASTMinsightSQC));
			getElement(searchASTMinsightSQC).click();
			PublicCommon.waitForSec(5);
			String title = driver.getTitle();
			Assert.assertEquals(title,"ASTM Insight SQC - Products & Services");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickOnMarketIntelligenceAndNavigate(){
		try {
			PublicCommon.waitForSec(3);
			getElement(popclose).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(searchMarketintelligence));
			getElement(searchMarketintelligence).click();
			PublicCommon.waitForSec(5);
			String title = driver.getTitle();
			Assert.assertEquals(title,"Market Intelligence - Products & Services");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickOnWohlersMarketAndNavigate(){
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(wohlersreport));
			getElement(wohlersreport).click();
			PublicCommon.waitForSec(5);
			String title = driver.getTitle();
			Assert.assertEquals(title,"Wohlers Report - Market Intelligence - Products & Services");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsPhoneNumberUpdated(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(phoneNoUnderdvisoryservices),driver);
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(phoneNoUndercontactustodayforallyourAMconsultingneeds),driver);
			PublicCommon.waitForSec(3);
			if(getElement(phoneNoUnderdvisoryservices).isDisplayed()){
				if(getElement(phoneNoUndercontactustodayforallyourAMconsultingneeds).isDisplayed()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public boolean clickOnPetroleumReferenceMaterialAndNavigate(){
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(petrolumreferencematerial));
			getElement(petrolumreferencematerial).click();
			PublicCommon.waitForSec(5);
			String title = driver.getTitle();
			Assert.assertEquals(title,"Petroleum Reference Materials - Products & Services");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickOnWohlerAssociatelinkAndNavigate(){
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(wohlerassociatelink));
			ReusableMethods.scrollIntoView(getElement(wohlerassociatelink),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(wohlerassociatelink).click();
			PublicCommon.waitForSec(5);
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url,"https://wohlersassociates.com/2022report");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickOnWhatIsASTMAndNavigate(){
		try {
			PublicCommon.waitForSec(3);
			getElement(popclose).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(searchASTM));
			getElement(searchASTM).click();
			PublicCommon.waitForSec(5);
			String title = driver.getTitle();
			Assert.assertEquals(title,"What is ASTM - Consumer Participation - Get Involved");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickOnHowToGetInvolvedAndNavigate(){
		try {
			PublicCommon.waitForSec(3);
			getElement(popclose).click();
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(searchhowtogetinvolved));
			getElement(searchhowtogetinvolved).click();
			PublicCommon.waitForSec(5);
			String title = driver.getTitle();
			Assert.assertEquals(title,"How to Get Involved - Consumer Participation - Get Involved");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsPageShowSearchedResults() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(selectfield));
			getElement(selectfield).click();
			getElement(editoption).click();
			PublicCommon.waitForSec(3);
			PublicCommon.isWebElementDisplayed(driver,editpage);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsSearchedResultsAppear() {
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(selectfield));
			PublicCommon.isWebElementDisplayed(driver, verifyhowtogetinvolved);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean VerifyEPDisVisible() {
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(EPD),driver);
			PublicCommon.isWebElementDisplayed(driver,EPD);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyAbleToupdatePetroleumreferenceMaterials() {
		try {
			PublicCommon.waitForSec(3);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(selectfield));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(selectfield).click();
			getElement(editLink).click();
			PublicCommon.waitForSec(3);
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(currentlyActive));
			ReusableMethods.scrollIntoView(getElement(currentlyActive),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsInfographicVisible() {
		try {
			ReusableMethods.scrollIntoView(getElement(infographic), driver);
			return PublicCommon.isWebElementDisplayed(driver, infographic);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void clickLearnMoreaboutNCATTButton(){
		PublicCommon.waitForSec(3);
		ReusableMethods.moveToElementAndClick(driver,getElement(NCATTButton));
	}
	public void ClickOnReadOurFAQButton(){
		PublicCommon.waitForSec(3);
		ReusableMethods.moveToElementAndClick(driver,getElement(ReadOurFAQButton));
	}
	public boolean IsCertificateOpen() {
		try {
			return PublicCommon.isWebElementDisplayed(driver, certificate);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsStandardByCategoryOpen() {
		try {
			String title = driver.getTitle();
			Assert.assertEquals(title,"Standards By Category - Standards Products - Standards & Publications - Products & Services");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsStandardByCategoryButtoVisible() {
		try {
			ReusableMethods.scrollIntoView(getElement(standardbycategory),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isWebElementDisplayed(driver,standardbycategory);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsTwoRequestDemoButonVisible() {
		try {
			ReusableMethods.scrollIntoView(getElement(requestDemo1),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(requestDemo2),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsSalesforceFormVisible() {
		try {
			String title = driver.getTitle();
			Assert.assertEquals(title,"Contact ASTM - Standards & Publications - Products & Services");
			WaitStatementUtils.implicitWaitForMinutes(driver,4);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsPageInAlphaNumericOrder() {
		try {
			ReusableMethods.scrollIntoView(getElement(standardbycategory),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsWhatIsASTMDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(ReadOurFAQButton),driver);
			return PublicCommon.isWebElementDisplayed(driver, ReadOurFAQButton);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsNavigateToNewsAndEventsPage(){
		try {
			PublicCommon.waitForSec(3);
			String title = driver.getTitle();
			assertEquals(title,"News and Events - Consumer Participation - Get Involved");
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsContentsAndHeadingUnderNewsAndEvents(){
		try {
			ReusableMethods.scrollIntoView(getElement(consumerrelatedarticlesHeading),driver);
			PublicCommon.isWebElementDisplayed(driver, consumerrelatedarticlesHeading);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(newsreleasesHeading),driver);
			PublicCommon.isWebElementDisplayed(driver, newsreleasesHeading);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(meetingsandeventHeading),driver);
			PublicCommon.isWebElementDisplayed(driver, meetingsandeventHeading);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsHowToGetInvolvedHeaderDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(howtogetinvolvedHeader),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isWebElementDisplayed(driver, howtogetinvolvedHeader);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsMediaPublicityRequestFormLinkDisplayed(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(mediapublicityrequestform),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isWebElementDisplayed(driver, mediapublicityrequestform);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ClickOnMediaPublicityRequestFormLinkAndVerifyPage(){
		try {
			getElement(mediapublicityrequestform).click();
			PublicCommon.waitForSec(3);
			String title = driver.getTitle();
			assertEquals(title,"Publicity Request Form - Technical Committees - Get Involved");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsTrainingAndResourcesHeaderDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(trainingandresourcesHeader),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isWebElementDisplayed(driver, trainingandresourcesHeader);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsWhyShouldIJoinDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(whyshouldijoin),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isWebElementDisplayed(driver, whyshouldijoin);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsFinancialAssistanceForCustomerDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(requestfinancialassistanceButton),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.isWebElementDisplayed(driver, financialassistanceforcustomer);
			return PublicCommon.isWebElementDisplayed(driver,requestfinancialassistanceButton);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsNewMemberOrientationAndTrainingDisplayed(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(newmemberorientationandtrainingButton),driver);
			PublicCommon.isWebElementDisplayed(driver,newmemberorientationandtrainingButton);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(newmemberorientationandtrainingButton).click();
			PublicCommon.waitForSec(3);
			String title = driver.getTitle();
			Assert.assertEquals(title,"Classroom for Members - Training Courses - Products & Services");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
			driver.navigate().back();
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsAccessReadingRoomDisplayed(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(accessreadingroomButton),driver);
			PublicCommon.isWebElementDisplayed(driver,accessreadingroomButton);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(accessreadingroomButton).click();
			PublicCommon.waitForSec(3);
			String title = driver.getTitle();
			Assert.assertEquals(title,"Reading Room - Products & Services");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
			driver.navigate().back();
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsDownloadTheConsumerGuideBookDisplayed(){
		try {
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(downloadtheconsumerguidebookButton),driver);
			PublicCommon.isWebElementDisplayed(driver,downloadtheconsumerguidebookButton);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(downloadtheconsumerguidebookButton).click();
			PublicCommon.waitForSec(3);
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url,"https://public-admin-files-qa.s3.us-east-2.amazonaws.com/general/Consumer_Guide.pdf");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(3);
			driver.navigate().back();
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsHowToJoinDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(becomeanastmmemberButton),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.isWebElementDisplayed(driver,howtojoin);
			PublicCommon.isWebElementDisplayed(driver,becomeanastmmemberButton);
			getElement(becomeanastmmemberButton).click();
			PublicCommon.waitForSec(3);
			String title = driver.getTitle();
			Assert.assertEquals(title,"Membership - Get Involved");
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsKathieMorganImageDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(kathiemorganimage),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isWebElementDisplayed(driver, kathiemorganimage);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}


	public boolean IsEveryMemberHasaVoiceDisplayed(){
		try {
			ReusableMethods.scrollIntoView(getElement(everymemberhasavoice),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.isWebElementDisplayed(driver, everymemberhasavoice);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsASTMFaceSheetVisible(){
		try {
			String title = driver.getTitle();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertEquals(title,"ASTM Fact Sheet - Overview - About Us");
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean IsLearnMoreaboutNCATTButtonVisible(){
		try {
			ReusableMethods.scrollIntoView(getElement(NCATTButton),driver);
			return PublicCommon.isWebElementDisplayed(driver, NCATTButton);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean IsLearnMoreaboutPersonnalCertificaton(){
		try {
			ReusableMethods.scrollIntoView(getElement(LMAPC),driver);
			return PublicCommon.isWebElementDisplayed(driver, LMAPC);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Step("Verify 'Training Courses' Option is visible.")
	public boolean verifyTrainingCoursesOptionsIsVisible() {
		try {
			return PublicCommon.isVisibleInViewport(getElement(trainingCoursesOptions), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Proficiency Testing' Option is visible.")
	public boolean verifyProficiencyTestingOptionsIsVisible() {
		try {
			return getElement(proficiencyTestingOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Verify 'Digital Library' Option is visible.")
	public boolean verifyDigitalLibraryOptionsIsVisible() {
		try {
			return getElement(digitalLibraryOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Navigate to the 'Digital Library' Option using the Common Links options.")
	public DigitalLibraryPage_Public navigateToDigitalLibraryOptions() {
		try {
			mouseHoverProductsAndServicesOption();
			ReusableMethods.mouseHoverAndClick(driver, getElement(digitalLibraryOptions), "Digital Library Option");
			// getElement(digitalLibraryOptions).click();
			return getInstance(DigitalLibraryPage_Public.class);
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}

	}

	@Step("Verify 'Enterprise Solutions' Option is visible.")
	public boolean verifyEnterpriseSolutionsOptionsIsVisible() {
		try {
			return getElement(enterpriseSolutionsOptions).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	/**
	 * About: Function navigates to the Standards and Publications Page from the
	 * Public Home Page. Author:
	 * 
	 * @param - None
	 * @return - None
	 */
	@Step("Navigate to the Standards and Publications Page.")
	public StandardsAndPublicationsPage_Public navigateToStandardsAndPublications() {

		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
			ReusableMethods.mouseHoverAndClick(driver, this.getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			return getInstance(StandardsAndPublicationsPage_Public.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	/**
	 * About: Function navigates to Journals Page from the Public Home Page.
	 *
	 */

	@Step("Navigate to Journals Page.")
	public JournalsPage_Public navigateToJournals() {
		try {
			return getInstance(JournalsPage_Public.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Description Scroll to the Member Promo Section on Homepage.
	 * 
	 * @author: Swapnil
	 */
	@Step("Scroll to Member Promo Section on Homepage.")
	public void scrollToMemberPromoSection() {
		ReusableMethods.scrollIntoView(getElement(memberPromoSection), driver);
	}

	@Step("Navigating to 'Book Of Standards' Page")
	public BookOfStandardsPage_Public navigateToBooksOfStandardsPage() {
		try {
			mouseHoverProductsAndServicesOption();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(bookOfStandardsOptions).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getInstance(BookOfStandardsPage_Public.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This Method Navigate to Standard Products Page
	 * 
	 * @return
	 */
	public boolean navigateToStandardProducts() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
			ReusableMethods.mouseHover(driver, this.getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			ReusableMethods.mouseHoverAndClick(driver, this.getElement(standardsProducts),
					"standards Products.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// return null;
		}
		return false;

	}

	public void clickBookOfStandards() {
		getElement(annualBookOfStandards).click();
	}

	/**
	 * About: Function navigates to Standards and publication page from the Public
	 * Home Page.
	 *
	 */

	@Step("Navigate to Standards and Publications Page.")
	public StandardsNPublicationsPage_Public navigateToStandardsNPublications() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation),
					"Products and Services - Homepage.");
			ReusableMethods.mouseHover(driver, this.getElement(standardsAndPublicationsOptions),
					"Standards and Publications option.");
			ReusableMethods.mouseHoverAndClick(driver, this.getElement(allStandardsAndPublications),
					"All Standards and Publications.");
			return getInstance(StandardsNPublicationsPage_Public.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Description Scroll to the Industry Sectors Section.
	 * 
	 * @author: Swapnil
	 */
	@Step("Scroll to the Industry Sectors Section on Homepage.")
	public void scrollToIndustrySectorsSection() {
		ReusableMethods.scrollIntoView(getElement(industrySectionOnHomepage), driver);
	}

	/**
	 * Description Click on Dropdown button for Industry Sectors Section.
	 * 
	 * @author: Swapnil
	 */
	@Step("Click on the Dropdown button for Industry Sectors Section on Homepage.")
	public void clickDropdownForIndustrySectorsSection() {
		getElement(industrySectorDropDownButton).click();
	}

	// currentIndustrySelection
	/**
	 * Description Get current industry selection in the Industry Sectors section.
	 * 
	 * @author: Swapnil
	 */
	@Step("Retrieving current industry selection in the Industry Sectors section")
	public String currentSelectedIndustrySector() {
		return getElement(currentIndustrySelection).getText();
	}

	/**
	 * Description Scroll to the Footer Section on Homepage.
	 * 
	 * @author: Swapnil
	 */
	@Step("Scroll to Member Promo Section on Homepage.")
	public void scrollToFooterSection() {
		ReusableMethods.scrollIntoView(getElement(footerSocialIcons), driver);
	}

	/**
	 * Footer Search Options validation
	 * 
	 * @author Swapnil
	 */
	@Step("Comparing Search Options on footer.")
	public boolean compareSearchOptionsInFooterSearchBar(List<String> expectedList) {
		try {
			getElement(footerSearchDropdown).click();
			List<String> actualList = ReusableMethods.getListOfOptionsValueInDropdown(getElement(footerSearchDropdown),
					driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	/**
	 * 
	 * @return- boolean value representing Search bar presence on Page
	 * @author Swapnil
	 */
	@Step("Looking for Search Bar in the footer Section.")
	public boolean footerSearchBarPresenceOnPage() {
		try {
			System.out.println("Searchbar: " + getElements(footerSearchbar).size());
			return (getElements(footerSearchbar).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Footer Industry Sector Options in dropdown
	 * 
	 * @author Swapnil
	 */
	@Step("Retrieving Industry Sectors in dropdown.")
	public List<String> retrieveIndustrySectorOptionsInDropdwon() {
		try {

			List<WebElement> actualElementList = getElements(industrySectorOptions);
			List<String> actualList = new ArrayList<String>();

			for (int i = 0; i < actualElementList.size(); i++) {
				actualList.add(actualElementList.get(i).getText());
			}

			System.out.println("Actual List of Industries: " + actualList);
			return actualList;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}

	}

	/**
	 * Footer Link Options validation
	 * 
	 * @author Swapnil
	 */
	@Step("Comparing Link Options on footer.")
	public boolean compareLinkOptionsInFooter(List<String> expectedList) {
		try {

			List<WebElement> actualElementList = getElements(footerLinks);
			List<String> actualList = new ArrayList<String>();

			for (int i = 0; i < actualElementList.size(); i++) {
				actualList.add(actualElementList.get(i).getText());
			}

			System.out.println("Actual List: " + actualList);
			System.out.println("Expected List: " + expectedList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	/**
	 * Social Icon Options validation
	 * 
	 * @author Swapnil
	 */
	@Step("Comparing Link Options on footer.")
	public boolean compareSocialIconsInFooter(List<String> expectedList) {
		try {

			boolean listCompareForSocialIcons = true;
			int index = 0;
			List<WebElement> actualElementList = getElements(footerSocialIcons);
			List<String> actualList = new ArrayList<String>();

			for (index = 0; index < actualElementList.size(); index++) {
				actualList.add(actualElementList.get(index).getAttribute("aria-label"));
			}

			System.out.println("Actual List: " + actualList);
			System.out.println("Expected List: " + expectedList);

			for (index = 0; index < expectedList.size(); index++) {
				if (!actualList.get(index).contains(expectedList.get(index)))
					listCompareForSocialIcons = false;
			}

			return listCompareForSocialIcons;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	/**
	 * Retrieving Links for Industry Sectors from dropdown
	 * 
	 * @author Swapnil
	 */
	@Step("Retrieving Links for Industry Sectors from dropdown.")
	public List<String> retrieveIndustrySectorLinks() {
		try {

			int index = 0;
			List<WebElement> actualElementList = getElements(industrySectorOptions);
			List<String> actualList = new ArrayList<String>();

			for (index = 0; index < actualElementList.size(); index++) {
				actualList.add(actualElementList.get(index).getAttribute("href"));
			}

			System.out.println("Actual List: " + actualList);

			return actualList;

		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}

	}

	public boolean expandNavigationMenuOnMobile() {
		try {
			getElement(mobileMenuNavigationExpand).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickProductsAndServicesNavigationOnMobile() {
		try {
			getElement(productsAndServicesNavigationMobile).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Step("Verify 'Standards & Publications' Option is visible on mobile.")
	public boolean verifyStandardsAndPublicationsOptionsIsVisibleOnMobile() {

		try {
			return getElement(standardsAndPublicationsOptionsOnMobile).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Books Of Standards' Option is visible on mobile.")
	public boolean verifyBooksOfStandardsOptionsIsVisibleOnMobile() {
		try {
			return getElement(bookOfStandardsOptionsOnMobile).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Reading Room' Option is visible on mobile.")
	public boolean verifyReadingRoomOptionsIsVisibleOnMobile() {
		try {
			return getElement(readingRoomOptionsOnMobile).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Tracker Services' Option is visible on mobile.")
	public boolean verifyTrackerServicesOptionsIsVisibleOnMobile() {
		try {

			return getElement(trackerServicesOptionsOnMobile).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	@Step("Verify 'Catalogs' Option is visible on mobile.")
	public boolean verifyCatalogsOptionsIsVisibleOnMobile() {
		try {

			return getElement(catalogsOptionsOnMobile).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	/**
	 * Get List of Sub Category
	 * 
	 * @param expectedList
	 * @return
	 */
	public Boolean verifySubcategoriesForMobile(List<WebElement> elementsList, List<String> expectedList) {

		try {
			List<String> actualList = PublicCommon.getListOfTextFromListOfWebelements(elementsList, driver);
			System.out.println(actualList);
			return actualList.equals(expectedList);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickASTMCompassNavigationOnMobile() {
		try {
			getElement(ASTMCompassOptionMobile).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickSpecBuilderNavigationOnMobile() {
		try {
			getElement(specBuilderOptionMobile).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickAllStandardAndPublicationNavigationOnMobile() {
		try {
			getElement(allStandardsAndPublicationsMob).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickJournalsOnMobile() {
		try {
			getElement(journalsMob).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Step("Verify 'Standards & Publications' Option is visible on mobile.")
	public boolean clickStandardsAndPublicationsOptionsIsVisibleOnMobile() {

		try {
			getElement(standardsAndPublicationsOptionsOnMobile).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}

	}

	public boolean clickPoliciesLinkOnFooter() {
		try {
			ReusableMethods.scrollIntoView(getElement(footerSocialIcons), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(footerPoliciesLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickCopyRightPermissionsLinkOnFooter() {
		try {
			ReusableMethods.scrollIntoView(getElement(footerSocialIcons), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(footerAboutCopyrightPermissionsLink).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Click on {elementName}")
	public void clickOnMethod(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	public By getAccountLocator(String account) {
		return By.xpath("//*[text()='" + account + "']//ancestor::div[contains(@class,'astm-card')]//a");
	}

	public By getaccountLocator(String account) {
		return By.xpath("//*[text()='"+account+"']//ancestor::p/input");
	}

	public static void waitForElementToDisappear(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(element));
	}

	@Step("Scroll to Magento Footer.")
	public void scrollToReportsSection() {
		ReusableMethods.scrollIntoView(getElement(reportsButton), driver);
	}


	@Step("Navigate to Professional Engineer Continuing Education Requirements page")
	public void clickPEContinuingEducation() {
		try {
			ReusableMethods.mouseHover(driver, this.getElement(productsAndServicesNavigation), "Training Courses");
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(trainingCoursesOptions));
			ReusableMethods.mouseHover(driver, getElement(trainingCoursesOptions),
					"hover over Training Courses Options");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(PE_ContinuingEducationLink));
			action.moveToElement(getElement(PE_ContinuingEducationLink)).click(getElement(PE_ContinuingEducationLink)).build().perform();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void IncomeMessageModelHeader(){
		try {
			if(IntegrationCommon.isElementdisplayed(driver,getElement(IncomeMsgClose))) {
				WaitStatementUtils.waitForElementStaleness(driver, getElement(IncomeMsgClose));
				IntegrationCommon.clickonWebElement(driver, IncomeMsgClose);
				Assert.assertFalse(getElement(IncomeMsgClose).isDisplayed());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public By getClassificationDropDown() {
		return classificationDropDown;
	}

	public By getCustomerTypeDropDown() {
		return customerTypeDropDown;
	}

	@Step("Check if Account’s classification is changed")
	public void ChangeClassicfication(String classification){
		try{
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getClassificationDropDown()),10);
			selectValueFromDropDown("Classification Drop Down", getClassificationDropDown(), classification, "Admin is unable to select classification");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Unable to change the Classification", e);
		}
	}

	public void AddressValidationHeader(){
		try {
			if(billingAddressPagePublic.isElementDisplayed(getElement(billingAddressPagePublic.AddmodelBoxText)))
			{
				if(((getElement(billingAddressPagePublic.getModelBoxTitle()).getText().equals("Address Validation"))))
				{
					clickONMethod("Address Validation Continue Button", billingAddressPagePublic.getContinueBtn(),
							"Address Validation Continue Button should be clickable");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Unable to Click on Address Validation",e);

		}
	}

	public By getEbsOrderStatus() {
		return ebsOrderStatus;
	}

	public By getMAEOrderStatus() {
		return MAEOrderStatus;
	}

	public By getOrderType(){
		return OrderType;
	}

	@Step("Verify Ebs Order status")
	public String EbsOrderStatus(){
		String EbsNumber = null;
		try{
			for(int i = 0; i <= 20;  i++){
				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(getEbsOrderStatus()));
				if(PublicAdminCommons.getTextOfElement(driver, getEbsOrderStatus())
						.equals("Success")){
					break;
				}
				else{
					PublicCommon.waitForSec(2);
					driver.navigate().refresh();
				}
			}
		     ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(PublicAdminCommons.getTextOfElement(driver, getEbsOrderStatus())
					.equals("Success"), " EBS order status is not success");
			EbsNumber = getElement(ebsNumber).getText();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify EBS Order status", e);
		}
		return EbsNumber;
	}
	@Step("Click on Go To MCS Button")
	public void clickOnMCS(){
		try{
            getElement(mcsButton).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on MCS Button", e);
		}

	}
	@Step("Verify MAE order status")
	public void VerifyMAEOrderStatus(){
		try{
			Assert.assertTrue(PublicAdminCommons.getTextOfElement(driver, getMAEOrderStatus())
					.equals("success"), " MAE order status is not success");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify MAE Order status", e);
		}
	}


	@Step("Verify Order Type")
	public void VerifyOrderTye(){
		try{
			Assert.assertTrue(PublicAdminCommons.getTextOfElement(driver, getOrderType())
					.equals("Success"), " MAE order status is not success");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify MAE Order status", e);
		}
	}



	@Step("Select Customer Type")
	public void CustomerType(String CustomerType){
		try{
			selectValueFromDropDown("Classification Drop Down", getCustomerTypeDropDown(), CustomerType, "Admin is unable to select customer Type");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get customer types", e);
		}
	}


	@Step("Create Account with Classification")
	public String CreateAccountWithClassification(String email,String CustomerType ,String classification,String sheetName, String WebdataSheetName){
		String AccountNumber = "";
		try{
			clickOnCustomer();
			clickOnAllCustomers();
			clickOnAddNewCustomerButton();
			CustomerType(CustomerType);
			CreateClassification(email,CustomerType,classification,sheetName,WebdataSheetName);
			AddressValidationHeader();
			clickOnAddressCkeckBox();
			clickOnSaveCustomerButton();

			AccountNumber = searchCustomerByEmailAndSelect(email, CustomerType);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to create account with Classification", e);
		}
		return AccountNumber;
	}

	public String searchCustomerByEmailAndSelect(String email,String CustomerType){
		String AccountNumber = "";
		try {
			if (!getElement(addnewcustomerButton).isDisplayed()) {
				clickOnCustomer();
				clickOnAllCustomers();
			}
			if(CustomerType == "B2B" || CustomerType.equalsIgnoreCase("organization")) {
				AllCustomerPage.navigateToAccountInformationPageWithCommunicationEmail(email);
				AccountNumber = EBSAccountNumber(email);
				WaitStatementUtils.waitForElementStaleness(driver, getElement(AllCustomerPage.getEditButton()));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AllCustomerPage.getEditButton()));
				clickOnMethod("Edit Button",AllCustomerPage.getEditButton(),"Admin/ISS Agent is unable to click on Edit Button");
			} else if (CustomerType == "B2C" || CustomerType.equalsIgnoreCase("person")) {
				AllCustomerPage.navigateToAccountInformationPageWithEmail(email);
				AccountNumber = EBSAccountNumber(email);
				clickOnMethod("Edit Button",AllCustomerPage.getEditButton(),"Admin/ISS Agent is unable to click on Edit Button");
			}
		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to search and select account", e);
		}
		return AccountNumber;
	}

	@Step("Create Account with Classification")
	public String CreateAccount(String email,String CustomerType ,String classification,String sheetName, String WebdataSheetName){
		String AccountNumber = "";
		try{
			clickOnCustomer();
			clickOnAllCustomers();
			clickOnAddNewCustomerButton();
			CustomerType(CustomerType);
			CreateClassification(email,CustomerType,classification,sheetName,WebdataSheetName);
			AddressValidationHeader();
			clickOnAddressCkeckBox();
			clickOnSaveCustomerButton();
			PublicCommon.waitForSec(5);
			Search(email);
			AccountNumber = EBSAccountNumber(email);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to create account with Classification", e);
		}
		return AccountNumber;
	}

	@Step("Click Create Order in Customer Information Page")
	public void clickCreateOrderFromCustomerInfoPage() {
		try {
			createOrder();
		}catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Initiate Orders with Classification", e);
		}
	}


	@Step("Search for account and click on Edit")
	public Map<String, String> AddClassificationChoosingCustomerType(String email, String CustomerType, String classification) {
		Map<String, String> map = new HashMap<>();
		String ContactEmail = null;
		String EBSAccountNumber_UI = null;
		try {
			clickOnCustomer();
			clickOnAllCustomers();
			if(CustomerType == "B2B") {
				AllCustomerPage.navigateToAccountInformationPageWithCommunicationEmail(email);
				EBSAccountNumber_UI = getEBSAccountNumber(email);
				WaitStatementUtils.waitForElementStaleness(driver, getElement(AllCustomerPage.getEditButton()));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AllCustomerPage.getEditButton()));
				clickOnMethod("Edit Button",AllCustomerPage.getEditButton(),"Admin/ISS Agent is unable to click on Edit Button");
			} else if (CustomerType == "B2C") {
				AllCustomerPage.navigateToAccountInformationPageWithEmail(email);
				EBSAccountNumber_UI = getEBSAccountNumber(email);
				clickOnMethod("Edit Button",AllCustomerPage.getEditButton(),"Admin/ISS Agent is unable to click on Edit Button");
			}
			//Change to required classification and save customer
			AccountInformationTab();
			ChangeClassicfication(classification);
			clickOnSaveCustomerButton();
			clickOnMethod("Edit Button",AllCustomerPage.getEditButton(),"Admin/ISS Agent is unable to click on Edit Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ContactEmail = AllCustomerPage.verifyContactDetails();
			createOrder();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Add Classification Choosing Customer Type", e);
		}
		map.put("ContactEmail", ContactEmail);
		map.put("EBSAccountNumber_UI", EBSAccountNumber_UI);
		return map;
	}

	@Step("Create Account with AR Invoice Type")
	public void CreateAccountWithARInvoiceType(String email,String CustomerType ,String sheetName, String WebdataSheetName){
		try{
			clickOnCustomer();

			clickOnAllCustomers();

			clickOnAddNewCustomerButton();

			CustomerType(CustomerType);

			CreateARInoiceType(email,CustomerType,sheetName,WebdataSheetName);
			AddressValidationHeader();

			clickOnSaveAndContinueEdit();

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to create account with AR Invoice Type", e);
		}
	}

	@Step("Validate AR Invoice Type selected as BOM under Account Information tab and EBS Order Number")
	public String validateARInvioceTypeUnderAccountInfoTab(String email){
		String EBSAccountNumber="";
		try{
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(accountInformationTab));
			getElement(accountInformationTab);
		   String Status = getElement(ARInvoiceType).getText();
			clickOnSaveCustomerButton();
			EBSAccountNumber = getEBSAccountNumber(email);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to create account with AR Invoice Type", e);
		}
		return EBSAccountNumber;
	}

	public String GrandTotalIncTaxBeforeOrderSubmit(){
		PublicAdminCommons.scrollAndTakScreenShot(driver, GrandTotalIncTax());
		return PublicAdminCommons.getTextOfElement(driver, GrandTotalIncTax());
	}

	public String GrandTotalExcTaxAfterOrderSubmit(){
		PublicAdminCommons.scrollAndTakScreenShot(driver, GrandTotalExcTaxAfterSubmit());
		return PublicAdminCommons.getTextOfElement(driver, GrandTotalExcTaxAfterSubmit());
	}

	public String GrandTotalIncTaxAfterOrderSubmit(){
		PublicAdminCommons.scrollAndTakScreenShot(driver, GrandTotalIncTaxAfterSubmit());
		return PublicAdminCommons.getTextOfElement(driver, GrandTotalIncTaxAfterSubmit());
	}

	public String ShippingHandlingAfterOrderSubmit(){
		PublicAdminCommons.scrollAndTakScreenShot(driver, ShippingAndHandlingAfterSubmit());
		return PublicAdminCommons.getTextOfElement(driver, ShippingAndHandlingAfterSubmit());
	}

	public String TotalTaxAfterOrderSubmit(){
		PublicAdminCommons.scrollAndTakScreenShot(driver, TotalTaxAfterSubmit());
		return PublicAdminCommons.getTextOfElement(driver, TotalTaxAfterSubmit());
	}

	public String LineItemSubDiscountAfterOrderSubmit(){
		PublicAdminCommons.scrollToElement(driver,getElementNew(lineItemSubDiscount));
		String SubDiscount = getElement(lineItemSubDiscount).getText().replace(",", "").replace("-", "").replace("$","");
		return SubDiscount;
	}
	public String LineItemSubTotalAfterOrderSubmit(){
		PublicAdminCommons.scrollToElement(driver,getElementNew(lineItemSubTotal));
		String SubTotal = getElement(lineItemSubTotal).getText().replace(",", "").replace("-", "").replace("$","");
		return SubTotal;
	}

	public String returnLineItemSubTotal() {
		try {
			PublicAdminCommons.scrollToElement(driver,getElementNew(lineItemSubDiscount));
			String PriceInStringSubDiscount = getElement(lineItemSubDiscount).getText().replace(",", "").replace("-", "").replace("$","");
			PriceInStringSubDiscount = PriceInStringSubDiscount.replace("$", "");
			double priceInDoubleSubDiscount = Double.parseDouble(PriceInStringSubDiscount);

			PublicAdminCommons.scrollToElement(driver,getElementNew(lineItemSubTotal));
			String PriceInStringSubTotal = getElement(lineItemSubTotal).getText().replace(",", "").replace("-", "").replace("$","");
			PriceInStringSubTotal = PriceInStringSubTotal.replace("$", "");
			double priceInDoubleSubTotal = Double.parseDouble(PriceInStringSubTotal);

			double doubleExtendedPrice = priceInDoubleSubTotal - priceInDoubleSubDiscount;
			String LineItemExtendedPrice = String.format("%.2f", doubleExtendedPrice);
			return LineItemExtendedPrice;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return "";
		}
	}



	public String LineItemTotalTaxAfterOrderSubmit(){
		PublicAdminCommons.scrollAndTakScreenShot(driver, lineItemTotalTaxAfterSubmit());
		return PublicAdminCommons.getTextOfElement(driver, lineItemTotalTaxAfterSubmit());
	}



	@Step("Verify Book dealer discount on order view screen")
	public String BookDealerDiscountOrderViewScreen(){
			PublicAdminCommons.scrollAndTakScreenShot(driver, BookDealerDiscountInOrderViewScreen());
			return PublicAdminCommons.getTextOfElement(driver, BookDealerDiscountInOrderViewScreen()).replace("-", "").replace("$", "").replace(",", "");
	}

	@Step("Verify Member discount on order view screen")
	public String MemberDiscountOrderViewScreen(){
		PublicAdminCommons.scrollAndTakScreenShot(driver, MemberDiscountInOrderViewScreen());
		return PublicAdminCommons.getTextOfElement(driver, MemberDiscountInOrderViewScreen()).replace("-", "").replace("$", "").replace(",", "");
	}

	@Step("Admin selects '{value}' from '{elementName}'")
	private void selectValueFromDropDown(String elementName, By locator, String value, String assertionMessage) {
		try {
			Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
					"Admin is unable to scroll to " + elementName);
			Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, locator, value), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to select option from drop down", e);
		}
	}

	@Step("Select {elementName}: '{keys}'in DropDown")
	public void selectValue(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.selectValueInDropdown(getElement(locator), keys),
					assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			PublicCommon.reportFailAssert("Failed to Select value from dropdown.", e);
		}
	}

	public List<WebElement> getBOSFormatCategoriesList() {
		return getElements(formatProductItem);
	}

	public String BosFormat(String Format){
		try{
			List<String> actualList = PublicCommon
					.getListOfTextFromListOfWebelements(getBOSFormatCategoriesList(), driver);
			System.out.println(actualList);
			return String.valueOf(actualList.equals(Format));
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			PublicCommon.reportFailAssert("Failed to get BOS Format", e);
		}
		return Format;
	}

	public String getAccountInfoCustomerName(){
		WaitStatementUtils.explicitWaitForVisibility(driver,getElement(AccountInfoCustName),10);
		return getElement(AccountInfoCustName).getText();
	}

	public void AccountInformationTab(){
		getElement(AccountInformationTab).click();
	}

	@Step("Verify account's classification updates correctly in Magento on submitting Membership Order")
	public void getClassification(String Toclassification){
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			AccountInformationTab();
			String ClassificationValue = AccountCreationPage.getClassification();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertEquals(ClassificationValue,Toclassification);
			Set<String> handles = driver.getWindowHandles();
			for (String handle : handles) {
				driver.switchTo().window(handle);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			driver.close();
			switchToTabByIndex(driver, 0);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get accounts classification details", e);
		}
	}

	@Step("Check if Account’s classification is NON-MEMBER")
	public void ChangeClassicficationType(String classification){
		try{
			selectValueFromDropDown("Classification Drop Down", AccountCreationPage.getClassificationDropDown(),
					classification, "Admin is unable to select customer type");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(SaveCustomer).click();
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Unable to change the Classification", e);
		}
	}

	@Step("Check if Account’s classification is NON-MEMBER")
	public void ValidateClassification(String classification){
		try{
			//selectValueFromDropDown("Classification Drop Down", AccountCreationPage.getClassificationDropDown(),classification, "Admin is unable to select customer type");
			PublicAdminCommons.scrollToElement(driver,getElement(classificationDropDown));
			AccountCreationPage.getClassificationDropDown().equals(classification);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(10);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Unable to change the Classification", e);
		}
	}

	@Step("To validate that the 'Meetings & Symposia' menu option is present under the Get Involved header menu")

	public void validatingMeetingsAndSymposia() {

		try {

			driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM_NEW"));

			PublicCommon.waitForSec(10);

//			mouseHoverGetInvolvedNavigationOption();

//			ScreenshotUtil.takeScreenshotForAllure(driver);

//			clickOnMethod("Meetings and Symposia", meetingsAndSymposia, "Meetings and Symposia link is not clickable/Not Present");

			homePagePublic.navigateToHomeLink("Membership & Participation","Meetings, Symposia, Workshops",2,5);

			/*clickOnMethod("Future Committee Week Locations (PDF)", futureCommitteePDFLink, "Future Committee Week Locations (PDF) is not clickable/Not Present");

			PublicCommon.waitForSec(10);

			PublicAdminCommons.switchToTabByIndex(driver,1);

			PublicCommon.waitForSec(5);

			ScreenshotUtil.takeScreenshotForAllure(driver);

			PublicAdminCommons.closeNewTabAndSwitchToOriginalTab(driver);*/

			ScreenshotUtil.takeScreenshotForAllure(driver);

		} catch (Exception e) {

			e.printStackTrace();

			PublicCommon.reportFailAssert("When user hovers over 'Get Involved' menu in the header, the 'Meetings and Symposia' is not getting displayed as expected", e);

		}

	}


	@Step("Verify Visibility of Element {elementName}")
	public void verifyVisibility(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.isWebElementDisplayed(driver, locator), assertionMessage);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}

	@Step("Get EBS Account Number")
	public String getEBSAccountNumber(String Email){
		String EBSAccountNumber=null;
		try {
			waitForElementPresent(getCustomerGridColumnHeader());
			List<WebElement> GridElements = getElements(getCustomerGridColumnHeader());
			List<String> GridColumns = new ArrayList<>();

			for (WebElement GridColumn : GridElements) {
				GridColumns.add(GridColumn.getText());
			}
			int i = GridColumns.indexOf("EBS Account Number") + 2;
			By Element = By.xpath(CustomerGridCell.replace("[INDEX]", Integer.toString(i)).replace("[EMAIL]", Email));
			waitForElementPresent(Element);
			WaitStatementUtils.waitForElementStaleness(driver, getElement(Element));
			EBSAccountNumber = getElement(Element).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get User Account Number from UI", e);
		}
		return EBSAccountNumber;
	}
	@Step("Get EBS Account Number")
	public String EBSAccountNumber(String Email){
		String EBSAccountNumber=null;
		try {
			waitForElementPresent(getCustomerGridColumnHeader());
			EBSAccountNumber = getElement(accountNo(Email)).getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get User Account Number from UI", e);
		}
		return EBSAccountNumber;
	}

	/*public void setEBSAccountNumber(){
		this.EBSAccountNumber = getEBSAccountNumber();
	}*/
	public List<String> getEBSSKUS(){
		List<WebElement> EBSSKUs = getElements(getEBSSKUsfromOrderPage);
		List<String> EBSSKUs_UI = new ArrayList<>();
		for(int i = 0; i < EBSSKUs.size(); i++){
			EBSSKUs_UI.add(EBSSKUs.get(i).getText().split(":")[1].trim());
		}
		return EBSSKUs_UI;
	}

	public String verifyText(By locator){
		return getElement(locator).getText();
	}

	@Step("Verify if Product is added to cart")
	public String AddProductToCart() {
		String ProgramName = null;
		try {
			ProgramName = getProductName().getText();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			WaitStatementUtils.waitForElementToBeClickable(driver,AddToCart(),10);
			//AddToCart().click();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(shoppingCartLink),5);
		/*	if(IntegrationCommon.isElementdisplayed(driver,getElement(shoppingCartLink))) {
				assertTrue(verifyText(ShoppingCartMessage).contains("You added " + ProgramName + " to your"));
				ReusableMethods.scrollIntoView(getElement(shoppingCartLink), driver);
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(shoppingCartLink), 5);
				clickOnMethod("Shopping cart Link", getElement(shoppingCartLink));
			}
			else {
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(cartButton), 10);
				clickOnMethod("cart Button", getElement(cartButton));
			}*/
			clickOnMethod("cart Button", getElement(cartButton));
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to add product to cart", e);
		}
		return ProgramName;
	}

	@Step("Add discounted eligible Product to cart")
	public String AddDiscountEligibleProduct(String ProductURL) {
		String ProductTitle = null;
		try {
			newMembershipPage.handleOneTrustCookie();
			driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM") + ProductURL);
			if(BillingAddressPage.isElementDisplayed(getElement(standardProductPage.StayOnPageBtn))) {
				clickOnMethod("Stay on Page Button", standardProductPage.StayOnPageBtn, "Couldn't click on Stay on page button");
			}
			PublicCommon.waitForSec(2);
			ProductTitle = getProductTitle().getText();

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to add Discounted eligible product", e);
		}
		return ProductTitle;
	}

	@Step("Click on {elementName}")
	private void clickONMethod(String elementName, By locator, String assertionMessage) {
		try {
			ReusableMethods.scrollIntoView(driver.findElement(locator), driver);
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}



	@Step("Create New customer with random email and add address")
	public String CreateNewCustomerWithSanctionedCountry(String JsonFileName,String JsonPrimeElement,String ActivationMail) {
		String email = null;
		try {
			PublicCommon.waitForSec(3);
			newCustomerRegistration(jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"FirstName"),
									jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"LastName"),
									 jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"PhoneNumber"));
			email = getRandomEmail(JsonFileName);
			System.out.println(email);
			enterEMail(email);
			if(ActivationMail.equals("No")) {
				UncheckSendingActivationEMail();
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnContinue();
			PublicCommon.waitForSec(5);
			clickOnAddNewAddress();
			AddnewAddress(jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"StreetAddress"),
					jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"City"),
					jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"ZipCode"),
					jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"Phonenumber"));
			selectValue("State", state, jsonFileReader.getJsonString(JsonFileName,JsonPrimeElement,"state"), "Select State from Drop down");
			clickOnSave();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			AddressValidationHeader();
			clickOnAddressCkeckBox();
			clickOnSaveCustomerButton();
			PublicCommon.waitForSec(8);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("The new customer can not be created", e);
		}
		return email;

	}

	@Step("Entering random Email credential")
	public String getRandomEmail(String testId) {
		return "stgintauto" +PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"_"+testId.substring(4)+"@yopmail.com";
	}

	public String getRandomEmailwithNanoSec(){
		return "testmail" + System.currentTimeMillis() + "@yopmail.com";
	}

	@Step("Write email id's in excel")
	public void writeLine(String str){
		try {
			String currentDir = System.getProperty("user.dir");
			FileWriter fw = new FileWriter(currentDir + "\\src\\main\\resources\\ExcelFiles\\EmailIDs.txt", true);
			fw.write(str + "\n");
			fw.close();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	public String OneTrustPolicyText() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(OneTrustPolicyText));
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getElement(OneTrustPolicyText).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Validating that the cookie alert message is visible on the opened page")
	public void cookiePopUpMsg(String CookieMsg) {
		try {
			String msg = OneTrustPolicyText();
			System.out.println("Cookie ASTM Alert Message: " + msg);
			//assertTrue(msg.equals(CookieMsg), "Cookie message content and display");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}

	@Step("Validating visibility of Select an Application and user is able to view COMPASS and WEB STORE options to select")
	public void VerifySelectAnApplicationOption() {
		try {
			verifyVisibility("select An Application",selectAnApplication,"select An Application is visible ");
			getElement(CompassCardTitle).getText().equals("Compass");
			getElement(WebStoreCardTitle).getText().equals("Web Store");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}
	@Step("Select Compass Option")
	public void SelectCompassOption(){
		try{
			getElement(selectCompassBtn).click();
			driver.getTitle().equals("compass");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}

	@Step("Select Webstore Option")
	public void SelectWebStoreOption(){
		try{
			getElement(selectWebStoreBtn).click();
			driver.getTitle().equals("Home Page");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception");
		}
	}

	@Step("Close browser")
	public void CloseBrowser(){
		driver.close();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}
		System.out.println(driver.getTitle());
		driver.close();
	}


	public List<WebElement> commiteeDesignationWebElementList() {
		try {
			return driver.findElements(committeDesginationLnks);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Verify if Contact details are retained after clicking on re-order in order information page")
	public void VerifyContactDetailsRetained(int BillingAdressContactValue,int ShippingAdressContactValue){
		try{
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(AddressDescriptionLabel),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(ContactBillingAddressValidation).getAttribute("value").equals(BillingAdressContactValue);
			PublicCommon.waitForSec(3);
			getElement(ContactShippingAddressValidation).getAttribute("value").equals(ShippingAdressContactValue);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to validate Contact details retained after reordering the product", e);
		}
	}

	@Step("Verify if Contact details are retained after clicking on re-order in order information page")
	public void VerifyContactDetailsRetained(String BillingAdressContactValue,String ShippingAdressContactValue){
		try{
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(AddressDescriptionLabel),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);

			Select selBilling=new Select(getElement(ContactBillingAddressValidation));
			selBilling.getFirstSelectedOption().equals(BillingAdressContactValue);

			Select selShipping=new Select(getElement(ContactBillingAddressValidation));
			selShipping.getFirstSelectedOption().equals(ShippingAdressContactValue);

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to validate Contact details retained after reordering the product", e);
		}
	}

	@Step("Verify if Contact details are retained after clicking on re-order in order information page")
	public void VerifyContactDetailsRetainedforB2C(String email){
		try{
			PublicCommon.waitForSec(3);
			ReusableMethods.scrollIntoView(getElement(CreateOrderPage.getEmailField()),driver);
			Assert.assertTrue(getElement(CreateOrderPage.getEmailField()).getAttribute("value").equals(email));
		} catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to validate B2C Contact details retained after reordering the product", e);
		}
	}

	@Step("Edit Email Address")
	public void EditEmailAddress(){
		try{
			String email = null;
			ReusableMethods.scrollIntoView(getElement(eMailAddress),driver);
			getElement(eMailAddress).clear();
			email = getRandomEmail("Sample");
			System.out.println(email);
			enterEMail(email);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Edit Email Address", e);
		}
	}

	/**
	 * Wait for spinner loader to disappear
	 */
	public void waitForSpinnerLoaderToDisappear() {
		PublicAdminCommons.waitForElementToDisappear(driver, getElementWithoutWait(spinnerIcon));
	}

	public void NavigateToConfigurationPage(String Navigate){
		try {
			if(Navigate.equals("Yes"))
			{
			PublicCommon.waitForSec(5);
			scrollToOffSet(driver,"0","-300");
			ReusableMethods.scrollIntoView(getElement(DashboardButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(DashboardButton),10);
			ReusableMethods.mouseHoverAndClick(driver, getElement(DashboardButton), "Dashboard Button should be Clickable");
			PublicCommon.waitForSec(10);
			}

			scrollToOffSet(driver,"0","400");
			ReusableMethods.scrollIntoView(getElement(systemButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(systemButton),10);
			ReusableMethods.mouseHoverAndClick(driver, getElement(systemButton), "System Option");
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(configurationLink),5);
			clickOnMethod("Configuration Link", configurationLink, "Configuration Link should be Clickable");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step("Navigate to ASTM > Checkout Address Validation")
	public void navigateToCheckoutAddressValidationToAstmTab() {
		try {
			getElementNew(expandedElement); // This line of code waits for page to be completely loaded
			getElementNew(ASTMTab).click();
			//ReusableMethods.scrollIntoView(getElement(apiTabUnderSales),driver);
			getElementNew(ChkAddValidationTabUnderSASTM).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Unable to navigate to Sales > API", e);
		}
	}

	public void clickOnSaveAndContinueEditButton() {
		PublicCommon.waitForSec(3);
		PublicCommon.JSClick(getElement(saveAndcontinueButton),driver);
	}

	public void clickOnCreateOrderButton(){
		PublicCommon.waitForSec(3);
		getElement(createorderButton).click();
		PublicCommon.waitForSec(3);
		driver.navigate().refresh();
		PublicCommon.waitForSec(3);

	}

	public By SelectAddressOption(int no){
		return By.xpath("//select[@id='order-billing_address_customer_address_id']/option["+no+"]");
	}
	public void clickOnAddressDropdownoption(int number){
		PublicCommon.waitForSec(3);
		clickOnAddressDropdown();
		getElement(SelectAddressOption(number)).click();
	}
	public void clickViewAllEvents() throws IOException {
		WaitStatementUtils.waitForElementToBeClickable(driver,getElement(viewAllEvents));
		getElement(viewAllEvents).click();
		ScreenshotUtil.takeScreenshotForAllure(driver);
		PublicCommon.waitForSec(10);
	}
	public void clickOnAddressDropdown(){
		PublicCommon.waitForSec(3);
		getElement(addressDropdown).click();
	}
	@Step("Enter Credit card detailes")
	public void EnterCreditCardDetails() {
		try {
			Assert.assertTrue(setCreditCardDetails(jsonFileReader.getJsonString("CreditCardMap", "CreditCard", "CreditCardNo"),
							jsonFileReader.getJsonString("CreditCardMap", "CreditCard", "ExpiryMonth"),
							jsonFileReader.getJsonString("CreditCardMap", "CreditCard", "ExpiryYear"),
							jsonFileReader.getJsonString("CreditCardMap", "CreditCard", "CVV")),
					"Admin/ISS Agent is unable to set  Credit Card Detials");

		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to Enter Credit card detailes", e);
		}
	}

	@Step("Enter Credit card detailes")
	public void EnterCreditCardDetails2(String CreditcardNo,String ExpiryMonth,String ExpiryYear,String cvv) {
		try {
			Assert.assertTrue(CreateOrderPage.setCreditCardDetails(CreditcardNo, ExpiryMonth,ExpiryYear, cvv),
					"Admin/ISS Agent is unable to set  Credit Card Detials");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to Enter Credit card detailes", e);
		}
	}
	public boolean setCreditCardDetails(String CreditcardNo, String ExpiryMonth,String ExpiryYear, String cvv) {
		try {
			// New functionality added (Select Credit Card Radio Button) in 17-Jan-24
			PublicAdminCommons.scrollToElement(driver, getElement(selectCreditCard));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectCreditCard),20);
			JSClick(getElement(selectCreditCard),driver);
			PublicAdminCommons.handleSpinnerIconOnMagento(driver,CreateOrderPage.getSpinnerIcon());
			PublicAdminCommons.waitForSec(10);
			Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframeccnumber),
					"Unable to switch iframe credit card");
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(creditcardNo),60);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(creditcardNo));
			PublicAdminCommons.scrollToElement(driver, getElement(creditcardNo));
			getElement(creditcardNo).click();
			PublicAdminCommons.enterTextInTextField(driver, creditcardNo,
					CreditcardNo,true);
			PublicAdminCommons.switchToDefaultFrame(driver);
			Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframeExpMonth),
					"Unable to switch iframe Expired Month");
			PublicAdminCommons.scrollToElement(driver, getElement(expirationMonth));
			getElement(expirationMonth).click();
			PublicAdminCommons.enterTextInTextField(driver, expirationMonth,
					ExpiryMonth,true);
			PublicAdminCommons.switchToDefaultFrame(driver);
			Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframeExpYear),
					"Unable to switch iframe Expired Year");
			PublicAdminCommons.scrollToElement(driver, getElement(expirationYear));
			getElement(expirationYear).click();
			PublicAdminCommons.enterTextInTextField(driver, expirationYear,
					ExpiryYear,true);
			PublicAdminCommons.switchToDefaultFrame(driver);
			Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframecvv),
					"Unable to switch iframe CVV");
			PublicAdminCommons.scrollToElement(driver, getElement(cvvNumber));
			getElement(cvvNumber).click();
			PublicAdminCommons.enterTextInTextField(driver, cvvNumber,
					cvv,true);
			PublicAdminCommons.switchToDefaultFrame(driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	@Step("Verify MCS button visibility for order by '{orderId}' in Magento")
	public void verifyForMCSBtnVisibilityInMagento(String userAccount,String userPwd,String orderId){
		try{
			PublicCommon.openNewTabAndSwitch(driver);
			PublicCommon.waitForSec(15);
			driver.manage().deleteAllCookies();
			driver.get(ConfigReader.getValue("BASE_URL_PUB_ADMIN_ASTM"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			adminMenuNavigation.clickOnSigninViaOctaBtn();
			loginPage.compassLogin(userAccount, userPwd);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Thread.sleep(10000);
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.salesMenuNavigationButton));
			clickONMethod("Sales Menu Option", adminMenuNavigation.salesMenuNavigationButton,
					"Failed to click on Sale menu option ");
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.orderMenuNavigationButton));
			clickONMethod("Order Menu Option", adminMenuNavigation.orderMenuNavigationButton,
					"Failed to click on Order menu option ");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders),10);
			if (adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders).isDisplayed()) {
				PublicCommon.JSClick(adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders), driver);
			}
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.searchTextbox),15);
			adminMenuNavigation.getElement(adminMenuNavigation.searchTextbox).sendKeys(orderId + Keys.ENTER);
			Thread.sleep(10000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(adminMenuNavigation.viewBtn),40);
			getElement(adminMenuNavigation.viewBtn).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify MCS button in Magento for order - "+orderId,e);
		}
	}
	@Step("Admin search for order by '{orderId}' as order ID")
	public Map<String ,String> adminSearchForOrdersByOrderId(String userAccount,String userPwd,String orderId) {
		String EBSOrderNum=null;
		try {
			PublicCommon.openNewTabAndSwitch(driver);
			PublicCommon.waitForSec(3);
			driver.manage().deleteAllCookies();
			driver.get(ConfigReader.getValue("BASE_URL_PUB_ADMIN_ASTM"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			adminMenuNavigation.clickOnSigninViaOctaBtn();
			loginPage.compassLogin(userAccount, userPwd);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Thread.sleep(10000);
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.salesMenuNavigationButton));
			clickONMethod("Sales Menu Option", adminMenuNavigation.salesMenuNavigationButton,
					"Failed to click on Sale menu option ");
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.orderMenuNavigationButton));
			clickONMethod("Order Menu Option", adminMenuNavigation.orderMenuNavigationButton,
					"Failed to click on Order menu option ");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders),10);
			if (adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders).isDisplayed()) {
				PublicCommon.JSClick(adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders), driver);
			}
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.searchTextbox),15);
			adminMenuNavigation.getElement(adminMenuNavigation.searchTextbox).sendKeys(orderId + Keys.ENTER);
			Thread.sleep(10000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(adminMenuNavigation.viewBtn),40);
			getElement(adminMenuNavigation.viewBtn).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String orginalPrice=getElement(orderInformation.getOriginalPrice()).getText().substring(1);
			String quantity=getElement(orderInformation.getQuantityProduct()).getText();
			String memberDiscount=getElement(orderInformation.getMemberDiscount()).getText().substring(1);

			orderInfoMap.put("EBSOrderNumber",orderInformation.getMagentoEBSOrderNumber());
			orderInfoMap.put("OriginalPrice",orginalPrice);
			orderInfoMap.put("Qty",quantity);
			orderInfoMap.put("MemberDiscount",memberDiscount);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(orderInformation.ItemsOrdered),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(orderInformation.getOrderTotalLabels()),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoMap;
	}
	@Step("Admin search for account number by '{email}'")
	public Map<String ,String> getOrderHistoryDetailsFromMagento(String userAccount,String userPwd,String orderId,String email) {
		String EBSOrderNum=null;
		try {
			PublicCommon.openNewTabAndSwitch(driver);
			PublicCommon.waitForSec(15);
			driver.manage().deleteAllCookies();
			driver.get(ConfigReader.getValue("BASE_URL_PUB_ADMIN_ASTM"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			adminMenuNavigation.clickOnSigninViaOctaBtn();
			loginPage.compassLogin(userAccount, userPwd);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Thread.sleep(10000);
			adminMenuNavigation.navigatesToAllCustomerTab();
			AllCustomerPage.navigateToAccountInformationPageWithEmail(email);
			orderHistoryDetailsMap.put("EBSAccountNo",AllCustomerPage.getCustomerDetails("EBS Account Number"));
			orderHistoryDetailsMap.put("UserEmailId",AllCustomerPage.getCustomerDetails("Email"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.salesMenuNavigationButton));
			clickONMethod("Sales Menu Option", adminMenuNavigation.salesMenuNavigationButton,
					"Failed to click on Sale menu option ");
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.orderMenuNavigationButton));
			clickONMethod("Order Menu Option", adminMenuNavigation.orderMenuNavigationButton,
					"Failed to click on Order menu option ");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (PublicAdminCommons.isElementDisplayed(adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders))) {
				WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders),10);
				PublicCommon.JSClick(adminMenuNavigation.getElement(adminMenuNavigation.clearAllButtonOrders), driver);
			}
			WaitStatementUtils.waitForElementToBeClickable(driver,
					adminMenuNavigation.getElement(adminMenuNavigation.searchTextbox),15);
			adminMenuNavigation.getElement(adminMenuNavigation.searchTextbox).sendKeys(orderId + Keys.ENTER);
			adminMenuNavigation.getElement(adminMenuNavigation.searchTextbox).sendKeys(Keys.ENTER);
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(adminMenuNavigation.viewBtn),45);
			getElement(adminMenuNavigation.viewBtn).click();
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			orderHistoryDetailsMap.put("MagentoOrderNumber",orderInformation.getMagentoOrderNumber());
			orderHistoryDetailsMap.put("EBSOrderNumber",orderInformation.getMagentoEBSOrderNumber());
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(orderInformation.paymentDetails),driver);
			PublicCommon.waitForSec(2);
			orderHistoryDetailsMap.put("PaymentCreditCardType",getElement(orderInformation.orderPaymentCardType()).getText().trim());
			orderHistoryDetailsMap.put("PaymentCreditCardNumber",getElement(orderInformation.orderPaymentCCnumber()).getText().replace("-",""));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(orderInformation.orderTotalSectionMainHeader()),driver);
			orderHistoryDetailsMap.put("GrandTotalInclTax",getElement(orderInformation.getGrandTotalInclTax()).getText());
			orderHistoryDetailsMap.put("TotalTax",getElement(orderInformation.getTotalTax1()).getText());
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderHistoryDetailsMap;
	}


	@Step("Sign out of Public")
	public void signout() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(membershipPage.userOptionsMenu),30);
			getElement(membershipPage.userOptionsMenu).click();
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(accountpage.signOutBtn), 15);
			clickOnMethod("signout Button", accountpage.signOutBtn, "Failed to click on Sign out Button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	public static void JSClick(WebElement element, WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Navigate to Work Items Full List")
	public void clickWorkItemsFullList() {
		try {
			newMembershipPage.handleOneTrustCookie();
			PublicAdminCommons.scrollToElement(driver,WI_FullList_link);
			PublicCommon.waitForSec(5);
			if(PublicCommon.isWebElementDisplayed(driver,newMembershipPage.cookieRejectBtn)){
				newMembershipPage.handleOneTrustCookie();
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(WI_FullList_link).click();
			Assert.assertTrue(WaitStatementUtils.explicitWaitForVisibility(driver,getElement(WI_FullList_linkHdr)),"Work Items- Full List header not visible");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Navigate Work Items Full List", e);
		}
	}
	@Step("Navigate to Technical Committee page")
	public void clickTechnicalCommittees() {
		try {
			WaitStatementUtils.waitForElementStaleness(driver,getElement(getGetInvolvedLink),20);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getGetInvolvedLink),20);
			getElement(getGetInvolvedLink).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(technicalCommitteesOption),10);
			getElement(technicalCommitteesOption).click();
			Assert.assertTrue(WaitStatementUtils.explicitWaitForVisibility(driver,getElement(technicalCommitteeHeader)));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Navigate to Technical Committee page", e);
		}
	}

	@Step("Verifying the: {successText}")
	public void validateList(String successText, List<String> actualList, List<String> expectedList) {
		try {
			for(String value : expectedList)
			{
				assertTrue(actualList.contains(value), "Failed to verify value in the  List "+actualList+" value not found "+value+"");
			}
			ScreenshotUtil.takeFullPageScreenshot();
		} catch (Exception ex) {
			ex.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify value in the  List ", ex);
		}
	}

	@Step("Navigate to Login Page and Log-in with valid credentials.")
	public void loginPublic(String username, String password) {
		try {
			assertTrue(loginPage.clickSignInButton(), "Click on Sign-in button");
			assertTrue(loginPage.compassLogin(username, password), "Login Failed");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to login ", e);
		}
	}


}
