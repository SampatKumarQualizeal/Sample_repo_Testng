package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class MembershipBecomeMemberPage extends BasePage {

	public MembershipBecomeMemberPage(WebDriver driver) {
		super(driver);
	}
	PTPThirdPartyShippingPage_Public TPShippingPage = getInstance(PTPThirdPartyShippingPage_Public.class);
	Mcs2Application_Page MCS2Application=getInstance(Mcs2Application_Page.class);
	BillingAddressPage_Public billingpage=getInstance(BillingAddressPage_Public.class);
	JsonFileReader jsonFileReader=new JsonFileReader();

	public By memberBenefitDetails_ReviewApplnPage(){
		return By.xpath("//p[text()='Selected free volume title:']//following-sibling::p[@class='astm-type-body--lead']");
	}
	public String volumeSelected="";
	public By organizationActivityDrpdwn=By.xpath("//select[@data-testid='primary-select']/option");
	public By mainCommitteeTitleVal(String mainCommitteeDesignation){
		return By.xpath("//label[text()='"+mainCommitteeDesignation+"']/ancestor::div[@class='flex']/following-sibling::p");
	}
	public By selectedCommitteeVal() {
		return By.xpath("//h4[@data-testid='rc-committee-information-header']/following-sibling::h5");
	}
	public String mainCommitteeDesignationSelected="";
	public String mainCommitteeTitleForSelectedDesignation="";
    public By personalDetailsHeader_reviewApplnPage=By.xpath("//h5[text()='Personal Details']");
	public By representativeDetailsHeader_reviewApplnPage=By.xpath("//h5[text()='Representative Details']");
	public By membershipTypeCostVal=By.xpath("//p[text()='Membership Type/Cost:']/following-sibling::p");
	public By selectCommitteeHeader_reviewApplnPage=By.xpath("//h4[@data-testid='rc-committee-information-header']");
	public By selectYourCommitteeHeader=By.xpath("//h5[text()='Select Your Committee']");
	public By aboutYourOrganizationHeader=By.xpath("//h5[text()='About Your Organization']");
	public By joinAnotherMainCommitteeBtn=By.xpath("//button[text()=' Join Another Main Committee']");
	public By Reinstateheader = By.xpath("//h2[text()='Reinstate your Membership']//following::h3[text()='Organizational Member']");
	// Select your committee
	public By allVolumeComittee = By.id("controlled-tab-example-tab-all");
	public By chooseCommittee = By.xpath("(//div[@class='form-box'][1]/descendant::button)[1]");
	public By chooseCommittee1 = By.xpath("//div[@class='form-box'][2]/descendant::button");
	public By chooseCommitteeList = By.cssSelector("*[class*='list-group astm-list-group'] li label");
	public By chooseCommitteeList1 = By.cssSelector("*[class*='list-group astm-list-group'] li label");
	public By describeOrganisationDropdown = By.xpath("//select[contains(@id,'primaryActivitySelection')]");
	public By ConsumerAdvocacyNoBtn = By.xpath("//label[text()='No']");
	public By ConsumerInterestTextArea = By.xpath("//textarea[contains(@id,'subform_')]");
	public By describeOrganisationDropdown1 = By.xpath("//div[@class='form-box'][2]/descendant::select");

	public By organisationDscription = By.xpath("//*[contains(@id,'organizationDescription')]");
	public By nextBtn = By.xpath("//button[text()='Next']");
	public By previousBtn = By.xpath("//button[text()='Previous']");
	public By cancelBtn = By.xpath("//button[text()='Cancel']");
	public By AddressValidationHeader = By.xpath("//h5");
	public By YesBtn = By.xpath("//button[text()='Yes']");
	public By NoBtn=By.xpath("//button[text()='No']");
	public By confirmationYesBTN = By.xpath("//button[@class='btn astm-btn btn btn-secondary']");
	//button[@class='btn astm-btn btn btn-secondary']/parent::div/button[1]
	public By submitBtn = By.xpath("//button[text()='Submit']");
	public By organisationDscription1 = By.xpath("//div[@class='form-box'][2]/descendant::textarea");
	public By deleteBtnCartPage=By.xpath("(//a/span[contains(text(),'delete')])[1]");

	// Step2 tell me about urself
	public By nameConsultingFirmfield = By.xpath("//input[contains(@name,'ConsultingFirmName')]");
	public By consultantServicesRadiobtn = By.xpath("//ul[contains(@class,'astm-type-body')]//div[@class='Radiobox']");
	public By websiteOfOrganisation = By.xpath("//input[@name='model[0].ConsultingWebsite");
	public By consultingRetained = By.xpath("//label[text()='No']");
	public By bussinessActivityfield = By.xpath("//textarea[@name='model[0].ConsultingBusinessActivity']");
	// Step 3 Select your member benefit
	public By chooseVolumeBtn = By.xpath("//div/button[text()='Choose Volume']");
	public By allVolumesBtn =By.xpath("//span[text()='All Volumes']");
	public By chooseVolumeList = By.xpath("//ul[@class='list-group astm-list-group']//li//p");
	public By chooseVolumeList_Radio = By.xpath("//ul[@class='list-group astm-list-group']//li//p/parent::div");
	public By volumeFormatDigital = By.id("digital");
	public By volumeFormatPrint = By.xpath("//strong[contains(text(),'Print (physical item will be shipped)')]");
	public By agreeRadiobox = By.xpath("//b[text()='I agree,']");
	public By isVolumeRequiredRadiobtn = By.xpath("//b[text()='Not Now,']/..");
	public By noCommittee=By.xpath("//label[contains(text(),'I choose')]/parent::div/input");
	private By SelVolume=By.xpath("//div[@class='steps'][3]/p[2]");
	private By selMembership = By.xpath("//div[@class='application-review astm-application-review']/p[2]");
	public By doneButton = By.xpath("//button[text()='Done']");
	public By stepsHeader = By.xpath("//div[contains(@class,'form-box')]/h4");
	// Step 4 Personal information
	public By info_firstName = By.xpath("//*[@name='firstName']");
	public By info_middleName = By.xpath("//*[@name='middleInitial']");
	public By info_lastName = By.xpath("//*[@name='lastName']");
	public By info_OrganizationName = By.xpath("//input[@name='OrganizationName']");
	public By address1 = By.xpath("//input[@name='address.addressLine1']");
	public By address_1 = By.xpath("//input[@id='company_addressLine1']");
	public By infoCity = By.xpath("//form[@data-testid='memberInfoForm']//*[@id='member_city']");
	public By infoCountry = By.xpath("//form[@data-testid='memberInfoForm']//select[@id='member_countryCode']");
	public By infoState = By.xpath("//select[@id='member_stateCode']");
	public By infoZipCode = By.xpath("//form[@data-testid='memberInfoForm']//input[@name='address.zipCode']");
	public By Phone = By.xpath("//input[@name='phone']");
	public By Email = By.xpath("//input[@name='email']");
	public By EmailError=By.xpath("//div[@data-testid=\"error_email\"]");
	public By EmailNotValidError=By.cssSelector(".admin__field-error");
	public By ExistingMemberError=By.xpath("//span[contains(text(),'An ASTM Membership is already associated with the entered email address. You will be redirected to the membership login in ')]");
	public By ExistingStudentMemberError=By.xpath("//span[contains(text(),'An ASTM Student Membership is already associated with the entered email address. You will be redirected to the membership login in ')]");
	public By MembershipLinkinErrorMsg=By.xpath("//a[contains(text(),'member@astm.org')]");
	public By astmLogo=By.cssSelector(".astm-logo");
	public By SignInHeader=By.xpath("//h3[text()='Sign In']");
	public By notEmployedCheckBox=By.xpath("//label[contains(text(),'I am not employed by an organization')]/../input");



	public By logout = By.xpath("//span[text()='Logout']");
	// Mock login Page
	public By mockAcctNumber = By.id("memberAccountNumber");
	public By mockPwd = By.id("password");
	public By acceptButton = By.xpath("//*[text()='ACCEPT']");
	public By acceptCookieBtn=By.xpath("//button[contains(text(),'Accept')]");
	public By affilationPopup = By.xpath("//p[contains(text(),'Do you have an affiliation')]");
	public By affilationPopupYesBtn = By.xpath("//button[@data-testid='submit-btn']");
	public By affilationPopupNoBtn = By.xpath("//button[@data-testid='cancel-btn']");
	// Organisational Details
	public By orgCity = By.xpath("//form[@data-testid='companyInfoForm']//*[@id='company_city']");
	public By orgState = By.xpath("//form[@data-testid='companyInfoForm']//*[@id='company_stateCode']");
	public By orgCountry = By.xpath("//form[@data-testid='companyInfoForm']//select[@id='company_countryCode']");
	public By orgZipcode = By.xpath("//form[@data-testid='companyInfoForm']//input[@name='address.zipCode']");
	public By orgZipcodeInput = By.id("company_zipCode");

	public By nameOfOrganisation = By.xpath("//label[text()='Organization Name']/..//input[@placeholder]");
	public By nameOfOrganisationInput = By.id("company_name");
	public By organsationAddress = By.xpath("//label[text()='Organization Address Line 1']/..//input[@placeholder]");
	public By organsationAddressInput = By.id("company_addressLine1");

	public By isNotAffiliatedCheckbox = By.id("isNotAffiliated");
	public By isNotAffiliatedPopupYesbtn = By.xpath("//*[@class='fade modal show']//button[text()='Yes']");

    public By checkoutBtn=By.xpath("//span[contains(text(),'Checkout')]");
    public By submitBtn1=By.xpath("//button[text()='Submit']");
    public By continueBtn=By.xpath("//button[contains(text(),'Continue')]");
    public By cookieRejectBtn =By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public By joinAnotherComBtn=By.xpath("//div[@class='form-box txtCenter']/p/following-sibling::button");
	public By deleteButton=By.xpath("//table[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[5]/descendant::a");
	public By membershipDesc=By.xpath("//table[@id=\"shopping-cart-table\"]/tbody[2]/tr[1]/td[1]/descendant::strong");
	private By emptycartMsg=By.xpath("//div[contains(@class,'cart-empty')]/h1/b");
	public By continueShoppingBtn=By.xpath("//div[contains(@class,'cart-empty')]/descendant::a[4]");
	public By searchCommitte=By.xpath("//input[@aria-label='text search box']");
	public By NoMatchingMainCommitteeFound=By.xpath("//p[text()='No matching Main Committee found.']");
	public By orgPriceatcartpage=By.xpath("//span[@class='price']");
	public By productNameatcartpage=By.xpath("//strong[@class='product-item-name']/a");
	public By freeVolume=By.xpath("(//strong[@class='product-item-name'])[2]");
	public By membershipTypeCostHeader_reviewApplnPage=By.xpath("//p[text()='Membership Type/Cost:']");
	public By membershipTypeCostVal_reviewApplnPage=By.xpath("//p[text()='Membership Type/Cost:']/following-sibling::p");
	public By SuggestedaddressMembershipHeader=By.xpath("//h5[@class='modal-title astm-type-heading--h5' and contains(text(),'Confirm Address')]");
	public By SuggestedAddressMembershipMessage=By.xpath("//p[contains(text(),'We have slightly modified')]");
	public By useSelectedAddressBtn=By.xpath("//button[text()='Use selected address']");

	public By AddressValMembershipContinueBtn=By.xpath("//button[@class='btn astm-btn btn btn-secondary' and text()='Yes']");
	public By AddressValMembershipMsg=By.xpath("//div[contains(text(),'We cannot verify')]");
	public By AddressValPartMembershipMsg=By.xpath("//p[contains(text(),'We cannot verify')]");
	public By AddressValPartMembershipSuggestedMsg=By.xpath("//p[contains(text(),'We have slightly modified the address entered')]");
	public By AddressValMembershipHeader=By.xpath("//div[@class='modal-header']/h5[contains(text(),'Error')]");
	public By AddressValpartMembershipHeader=By.xpath("//div[@class='modal-header']/h5[contains(text(),'Address Validation')]");

	public WebElement getIsNotAffiliatedCheckbox() {
		return getElement(isNotAffiliatedCheckbox);
	}
	
	public WebElement getReinstatePageHeader() {
		return getElement(Reinstateheader);
	}
	
	public WebElement getChooseCommittee() {
		return getElement(chooseCommittee);
	}
	public WebElement getChooseCommittee1() {
		return getElement(chooseCommittee1);
	}

	public WebElement getSelVolume()
	{
		return getElement(SelVolume);
	}
	public WebElement getselMembership()
	{
		return getElement(selMembership);
	}

	public String getAffilationPopupText() {
		return getElement(affilationPopup).getText();
	}

	public WebElement affilationPopupYesBtn() {
		return getElement(affilationPopupYesBtn);
	}

	public By getjoinAnotherComBtn(){
		return joinAnotherComBtn;
	}

	public By getemptycartMsg()
	{
		return emptycartMsg;
	}
	public void getOrgAddressFromDropDown(String address)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+address+"')]")).click();
	}
	public boolean enterPersonalDetailsofMembership(String sheetName) {
		try {
			HashMap<String, String> personalDetails = PublicCommon
					.getMapperData(ConfigReader.getValue("WebDataExcelPath"), sheetName);
			System.out.println(personalDetails);
			ReusableMethods.scrollIntoView(getElement(info_firstName),driver);
			enterText("First Name", info_firstName, personalDetails.get("firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", info_middleName, personalDetails.get("middleName"), "Enter First Name in TextBox");
			enterText("Last Name", info_lastName, personalDetails.get("lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", address1, personalDetails.get("addressLine1"),
					"Enter Street Address in Line 1 in TextBox");
			enterText("City", infoCity, personalDetails.get("city"), "Enter City in TextBox");
			enterText("Zip Code", infoZipCode, personalDetails.get("postalCode"), "Enter zip code in TextBox");
			selectValue("Country", infoCountry, personalDetails.get("country"), "Select Country from Drop down");
			selectValue("State", infoState, personalDetails.get("state"), "Enter State in TextBox");
			enterText("Phone", Phone, personalDetails.get("phone"), "Enter phone in TextBox");
			String email = "testaccount" + System.currentTimeMillis() + "@mailinator.com";
			enterText("Email", Email, email, "Enter Email in TextBox");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Personal Details ", e);
			return false;
		}
	}

	public void handleOneTrustCookie() {
		try {
			if(billingpage.isElementDisplayed(getElement(cookieRejectBtn))) {
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(cookieRejectBtn));
				IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean enterPersonalDetailsofMembership(String sheetName,String email) {
		try {
			HashMap<String, String> personalDetails = PublicCommon
					.getMapperData(ConfigReader.getValue("WebDataExcelPath"), sheetName);
			System.out.println(personalDetails);
			PublicAdminCommons.scrollToElement(driver,info_firstName);
			enterText("First Name", info_firstName, personalDetails.get("firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", info_middleName, personalDetails.get("middleName"), "Enter First Name in TextBox");
			enterText("Last Name", info_lastName, personalDetails.get("lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", address1, personalDetails.get("addressLine1"),
					"Enter Street Address in Line 1 in TextBox");
			enterText("City", infoCity, personalDetails.get("city"), "Enter City in TextBox");
			enterText("Zip Code", infoZipCode, personalDetails.get("postalCode"), "Enter zip code in TextBox");
			selectValue("Country", infoCountry, personalDetails.get("country"), "Select Country from Drop down");
			selectValue("State", infoState, personalDetails.get("state"), "Enter State in TextBox");
			enterText("Phone", Phone, personalDetails.get("phone"), "Enter phone in TextBox");
			enterText("Email", Email, email, "Enter Email in TextBox");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Personal Details ", e);
			return false;
		}
	}

	public boolean enterPersonalDetailsofMembership(String filename,String JsonPrimeElement,String email,String Add_Category) {
		try {
			PublicCommon.waitForSec(5);
			PublicAdminCommons.scrollToOffSet(driver,"0","300");
			enterText("First Name", info_firstName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", info_middleName,jsonFileReader.getJsonString(filename,JsonPrimeElement,"middleName"), "Enter First Name in TextBox");
			enterText("Last Name", info_lastName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", address1, jsonFileReader.getJsonString(filename,JsonPrimeElement,"addressLine1"),
					"Enter Street Address in Line 1 in TextBox");
			enterText("City", infoCity, jsonFileReader.getJsonString(filename,JsonPrimeElement,"city"), "Enter City in TextBox");
			enterText("Zip Code", infoZipCode, jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"), "Enter zip code in TextBox");
			selectValue("Country", infoCountry, jsonFileReader.getJsonString(filename,JsonPrimeElement,"country"), "Select Country from Drop down");
			selectValue("State", infoState, jsonFileReader.getJsonString(filename,JsonPrimeElement,"state"), "Enter State in TextBox");
			enterText("Phone", Phone, jsonFileReader.getJsonString(filename,JsonPrimeElement,"phone"), "Enter phone in TextBox");
			enterText("Email", Email, email, "Enter Email in TextBox");
			clickOnNextBtn();
			if(Add_Category.equals("Wrong"))
			{
				Assert.assertTrue(driver.findElements(AddressValMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(AddressValMembershipMsg).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(AddressValMembershipContinueBtn).click();

			} else if (Add_Category.equals("Diverted")) {
				Assert.assertTrue(driver.findElements(SuggestedaddressMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(SuggestedAddressMembershipMessage).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(useSelectedAddressBtn).click();
			}
			else{
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Personal Details ", e);
			return false;
		}
	}

	public boolean enterPersonalDetailsofInfoMembership(String filename,String JsonPrimeElement,String email,String Add_Category) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			PublicAdminCommons.scrollToOffSet(driver,"0","300");
			enterText("First Name", info_firstName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", info_middleName,jsonFileReader.getJsonString(filename,JsonPrimeElement,"middleName"), "Enter First Name in TextBox");
			enterText("Last Name", info_lastName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", address1, jsonFileReader.getJsonString(filename,JsonPrimeElement,"addressLine1"),
					"Enter Street Address in Line 1 in TextBox");
			enterText("City", infoCity, jsonFileReader.getJsonString(filename,JsonPrimeElement,"city"), "Enter City in TextBox");
			enterText("Zip Code", infoZipCode, jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"), "Enter zip code in TextBox");
			selectValue("Country", infoCountry, jsonFileReader.getJsonString(filename,JsonPrimeElement,"country"), "Select Country from Drop down");
			selectValue("State", infoState, jsonFileReader.getJsonString(filename,JsonPrimeElement,"state"), "Enter State in TextBox");
			enterText("Phone", Phone, jsonFileReader.getJsonString(filename,JsonPrimeElement,"phone"), "Enter phone in TextBox");
			enterText("Email", Email, email, "Enter Email in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnNextBtn();
			PublicCommon.waitForSec(10);
			if(Add_Category.equals("Wrong"))
			{
				Assert.assertTrue(driver.findElements(AddressValMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(AddressValMembershipMsg).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(AddressValMembershipContinueBtn).click();

			} else if (Add_Category.equals("Diverted")) {
				Assert.assertTrue(driver.findElements(SuggestedaddressMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(SuggestedAddressMembershipMessage).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(useSelectedAddressBtn).click();
			}
			else{
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			assertTrue(clickOnConfirmationBtn());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Personal Details ", e);
			return false;
		}
	}

	public boolean enterPersonalAndOrganizationalDetailsofInfoMembership(String filename,String JsonPrimeElement,String filename1,String JsonPrimeElement1,String email,String Add_Category,String OrgName) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			PublicAdminCommons.scrollToOffSet(driver,"0","300");
			enterText("First Name", info_firstName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", info_middleName,jsonFileReader.getJsonString(filename,JsonPrimeElement,"middleName"), "Enter First Name in TextBox");
			enterText("Last Name", info_lastName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", address1, jsonFileReader.getJsonString(filename,JsonPrimeElement,"addressLine1"),
					"Enter Street Address in Line 1 in TextBox");
			enterText("City", infoCity, jsonFileReader.getJsonString(filename,JsonPrimeElement,"city"), "Enter City in TextBox");
			enterText("Zip Code", infoZipCode, jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"), "Enter zip code in TextBox");
			selectValue("Country", infoCountry, jsonFileReader.getJsonString(filename,JsonPrimeElement,"country"), "Select Country from Drop down");
			selectValue("State", infoState, jsonFileReader.getJsonString(filename,JsonPrimeElement,"state"), "Enter State in TextBox");
			enterText("Phone", Phone, jsonFileReader.getJsonString(filename,JsonPrimeElement,"phone"), "Enter phone in TextBox");
			enterText("Email", Email, email, "Enter Email in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(nameOfOrganisation), driver);
			String str=getElement(nameOfOrganisationInput).getAttribute("value");
			int size=str.length();
			for(int i=0;i<size;i++)
			{
				getElement(nameOfOrganisation).sendKeys(Keys.BACK_SPACE);
			}
			enterText("Organsation Name", nameOfOrganisation, OrgName+Keys.TAB,"Enter First Name in TextBox");
			Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, MCS2Application.mcs2PageLoader),
					"Loading screen did not disapeear.");
			PublicAdminCommons.waitForSec(2);
			str=getElement(organsationAddressInput).getAttribute("value");
			size=str.length();
			for(int i=0;i<size;i++)
			{
				getElement(organsationAddress).sendKeys(Keys.BACK_SPACE);
			}
			enterText("Organsation Address", organsationAddress, jsonFileReader.getJsonString(filename1,JsonPrimeElement1,"org_addressLine1"),
					"Enter Last Name in TextBox");
			Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, MCS2Application.mcs2PageLoader),
					"Loading screen did not disapeear.");
			enterText("City", orgCity, jsonFileReader.getJsonString(filename1,JsonPrimeElement1,"org_city"), "Enter City in TextBox");
			enterText("Zip Code", orgZipcode, jsonFileReader.getJsonString(filename1,JsonPrimeElement1,"org_postalCode"), "Enter zip code in TextBox");
			selectValue("Country", orgCountry, jsonFileReader.getJsonString(filename1,JsonPrimeElement1,"org_country"), "Select Country from Drop down");
			selectValue("State", orgState, jsonFileReader.getJsonString(filename1,JsonPrimeElement1,"org_state"), "Enter State in TextBox");
			clickOnNextBtn();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(Add_Category.equals("Wrong"))
			{
				Assert.assertTrue(driver.findElements(AddressValpartMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(AddressValPartMembershipMsg).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(YesBtn).click();

			} else if (Add_Category.equals("Diverted")) {
				Assert.assertTrue(driver.findElements(AddressValpartMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(AddressValPartMembershipSuggestedMsg).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(useSelectedAddressBtn).click();
			}
			else{
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Personal Details ", e);
			return false;
		}
	}


	public boolean enterPersonalDetailsofInfoMembershipwithNoOrg(String filename,String JsonPrimeElement,String email,String Add_Category) {
		try {
			if(billingpage.isElementDisplayed(getElement(notEmployedCheckBox)))
			{
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(notEmployedCheckBox),20);
				PublicCommon.JSClick(getElement(notEmployedCheckBox),driver);
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			PublicAdminCommons.scrollToOffSet(driver,"0","300");
			enterText("First Name", info_firstName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", info_middleName,jsonFileReader.getJsonString(filename,JsonPrimeElement,"middleName"), "Enter First Name in TextBox");
			enterText("Last Name", info_lastName, jsonFileReader.getJsonString(filename,JsonPrimeElement,"lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", address1, jsonFileReader.getJsonString(filename,JsonPrimeElement,"addressLine1"),
					"Enter Street Address in Line 1 in TextBox");
			enterText("City", infoCity, jsonFileReader.getJsonString(filename,JsonPrimeElement,"city"), "Enter City in TextBox");
			enterText("Zip Code", infoZipCode, jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"), "Enter zip code in TextBox");
			selectValue("Country", infoCountry, jsonFileReader.getJsonString(filename,JsonPrimeElement,"country"), "Select Country from Drop down");
			selectValue("State", infoState, jsonFileReader.getJsonString(filename,JsonPrimeElement,"state"), "Enter State in TextBox");
			enterText("Phone", Phone, jsonFileReader.getJsonString(filename,JsonPrimeElement,"phone"), "Enter phone in TextBox");
			enterText("Email", Email, email, "Enter Email in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(notEmployedCheckBox), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(notEmployedCheckBox),15);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(notEmployedCheckBox),10);
			PublicCommon.JSClick(getElement(notEmployedCheckBox),driver);
			PublicCommon.waitForSec(4);
			getElement(AddressValMembershipContinueBtn).click();
			PublicCommon.waitForSec(4);
			clickOnNextBtn();
			PublicCommon.waitForSec(4);
			getElement(YesBtn).click();
			/*PublicCommon.waitForSec(10);
			if(Add_Category.equals("Wrong"))
			{
				Assert.assertTrue(driver.findElements(AddressValMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(AddressValMembershipMsg).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(AddressValMembershipContinueBtn).click();

			} else if (Add_Category.equals("Diverted")) {
				Assert.assertTrue(driver.findElements(SuggestedaddressMembershipHeader).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				Assert.assertTrue(driver.findElements(SuggestedAddressMembershipMessage).size() > 0,"Address Validation Pop-up Not Appears for Wrong Address validation");
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(useSelectedAddressBtn).click();
			}
			else{
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			assertTrue(clickOnOrganizationNoBtn());*/
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Personal Details ", e);
			return false;
		}
	}

	@Step("Enter Organization details")
	public boolean enterOrganisationalDetailsofMembershipandVerify(String filename,String JsonPrimeElement,String OrgName) {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(nameOfOrganisation), driver);
			enterText("Organsation Name", nameOfOrganisation, OrgName,
					"Enter First Name in TextBox");
			enterText("Organsation Address", organsationAddress, jsonFileReader.getJsonString(filename,JsonPrimeElement,"org_addressLine1"),
					"Enter Last Name in TextBox");
			enterText("City", orgCity, jsonFileReader.getJsonString(filename,JsonPrimeElement,"org_city"), "Enter City in TextBox");
			enterText("Zip Code", orgZipcode, jsonFileReader.getJsonString(filename,JsonPrimeElement,"org_postalCode"), "Enter zip code in TextBox");
			selectValue("Country", orgCountry, jsonFileReader.getJsonString(filename,JsonPrimeElement,"org_country"), "Select Country from Drop down");
			selectValue("State", orgState, jsonFileReader.getJsonString(filename,JsonPrimeElement,"org_state"), "Enter State in TextBox");
			clickOnNextBtn();
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Organisation Details", e);
			return false;
		}
	}

	@Step("Enter Organization details")
	public boolean enterOrganisationalDetailsofMembership(String sheetName) {
		try {
			HashMap<String, String> orgDetails = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),
					sheetName);
			ReusableMethods.scrollIntoView(getElement(nameOfOrganisation), driver);
			enterText("Organsation Name", nameOfOrganisation, orgDetails.get("companyName")+Keys.TAB,
					"Enter First Name in TextBox");
			PublicCommon.waitForSec(5);
			enterText("Organsation Address", organsationAddress, orgDetails.get("org_addressLine1"),
					"Enter Last Name in TextBox");
			enterText("City", orgCity, orgDetails.get("org_city"), "Enter City in TextBox");
			enterText("Zip Code", orgZipcode, orgDetails.get("org_postalCode"), "Enter zip code in TextBox");
			selectValue("Country", orgCountry, orgDetails.get("org_country"), "Select Country from Drop down");
			selectValue("State", orgState, orgDetails.get("org_state"), "Enter State in TextBox");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Organisation Details", e);
			return false;
		}
	}

	@Step("Enter Organization details")
	public boolean enterOrganisationalDetailsofMembership(String sheetName,String OrgName) {
		try {
			HashMap<String, String> orgDetails = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),
					sheetName);
			ReusableMethods.scrollIntoView(getElement(nameOfOrganisation), driver);
			enterText("Organsation Name", nameOfOrganisation, OrgName+Keys.TAB,
					"Enter First Name in TextBox");
			PublicCommon.waitForSec(5);
			enterText("Organsation Address", organsationAddress, orgDetails.get("org_addressLine1"),
					"Enter Last Name in TextBox");
			enterText("City", orgCity, orgDetails.get("org_city"), "Enter City in TextBox");
			enterText("Zip Code", orgZipcode, orgDetails.get("org_postalCode"), "Enter zip code in TextBox");
			selectValue("Country", orgCountry, orgDetails.get("org_country"), "Select Country from Drop down");
			selectValue("State", orgState, orgDetails.get("org_state"), "Enter State in TextBox");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Organisation Details", e);
			return false;
		}
	}



	public WebElement getMockAcctNumber() {
		return getElement(mockAcctNumber);
	}

	public WebElement getMockPwd() {
		return getElement(mockPwd);
	}

	public WebElement getAcceptButton() {
		return getElement(acceptButton);
	}

	/*
	 * Method to get header for step information
	 */
	public boolean stepsPageHeaderIsVisible() {
		try {
			return getElement(stepsHeader).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Method to verify choose button is displayed
	 */
	public boolean isChooseComitteeBtnDisplayed() {
		try {
			return getElement(chooseCommittee).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isChooseComittee1BtnDisplayed() {
		try {
			return getElement(chooseCommittee1).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Method to select comittee from the list
	 */
	public boolean selectCommitteeFromList(int i) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(chooseCommittee));
			Actions action = new Actions(driver);
			action.moveToElement(getElement(chooseCommittee)).click().build().perform();

			// getElement(chooseCommittee).click();
			mainCommitteeDesignationSelected=getElements(chooseCommitteeList).get(i).getText();
			getElements(chooseCommitteeList).get(i).click();
			mainCommitteeTitleForSelectedDesignation=getElement(mainCommitteeTitleVal(mainCommitteeDesignationSelected)).getText();
			getElement(doneButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean selectCommitteeFromList1(int i) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(chooseCommittee1));
			Actions action = new Actions(driver);
			action.moveToElement(getElement(chooseCommittee1)).click().build().perform();

			// getElement(chooseCommittee).click();
			getElements(chooseCommitteeList1).get(i).click();
			getElement(doneButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Method to click on next button
	 */
	public boolean clickOnNextBtn() {
		try {
			ReusableMethods.scrollIntoView(getElement(nextBtn),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(nextBtn),10);
			getElement(nextBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void AddressValidation(){
		PublicCommon.waitForSec(10);
			if (driver.findElements(AddressValidationHeader).size()>0){
				getElement(YesBtn).click();
			} else {
				return;
			}
	}

	public boolean clickOnConfirmationBtn() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(confirmationYesBTN));
			getElement(confirmationYesBTN).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickOnOrganizationNoBtn() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(NoBtn));
			getElement(NoBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Method to fill information for the step 1
	 */
	public boolean fillTellUsAboutYouselfInfo(int i) {
		try {
			getElement(nameConsultingFirmfield).sendKeys("ASTM");
			getElements(consultantServicesRadiobtn).get(i).click();
			getElement(nameOfOrganisation).sendKeys("ASTM");
			getElement(consultingRetained).click();
			getElement(bussinessActivityfield).sendKeys("Demo");
			clickOnNextBtn();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	/*
	 * Method to fill information for the step 1
	 */
	public boolean fillRepresentativeInfo() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(info_firstName));
			getElement(info_firstName).clear();
			getElement(info_firstName).sendKeys("firstName");
			getElement(info_lastName).clear();
			getElement(info_lastName).sendKeys("lastName");
			getElement(info_OrganizationName).clear();
			getElement(info_OrganizationName).sendKeys("ASTM");
			getElement(address1).clear();
			getElement(address1).sendKeys("address");
			getElement(infoCity).clear();
			getElement(infoCity).sendKeys("CitySA");
			PublicCommon.selectValueInDropdown(getElement(infoCountry), "Georgia");
			getElement(infoZipCode).clear();
			getElement(infoZipCode).sendKeys("12345");
			getElement(Phone).clear();
			getElement(Phone).sendKeys("9879876541");
			getElement(Email).clear();
			getElement(Email).sendKeys("email@user.com");
			clickOnNextBtn();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	/*
	 * Method to click on aggreement radio button
	 */
	public boolean clickOnAgreement() {
		try {

			((JavascriptExecutor) driver).executeScript("document.getElementsByName('check_isAgree')[0].click()");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
	
	public void clickOnSubmitAndContinueBtn() {
		try {

			
		PublicCommon.JSClick(getElement(submitBtn1), driver);
		PublicCommon.JSClick(getElement(continueBtn), driver);
		
		} catch (Exception e) {
			e.printStackTrace();
			

		}
		
	}

	/*
	 * Method to select volume with digital format
	 */
	@Step("Select Volume")
	public boolean selectYourVolumeForDigital(int i) {
		try {
			WaitStatementUtils.waitForElementStaleness(driver, getElement(chooseVolumeBtn),20);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(chooseVolumeBtn),30);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",getElement(chooseVolumeBtn));
			//getElement(chooseVolumeBtn).click();
			PublicCommon.waitForSec(5);
			getElement(allVolumesBtn).click();
			PublicCommon.waitForSec(2);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",getElement(allVolumesBtn));
			PublicCommon.waitForSec(3);
			volumeSelected=getElements(chooseVolumeList).get(i).getText();
			ReusableMethods.scrollIntoView(getElements(chooseVolumeList).get(i-1),driver);
			getElements(chooseVolumeList).get(i).click();
			getElement(doneButton).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnAgreement();
			clickOnNextBtn();
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



	/*
	 * Method to select volume for Reinstatemembrship with digital format 
	 */
	public boolean selectYourVolumeForReinstatemembrship(int i) {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(chooseVolumeBtn));
			getElement(chooseVolumeBtn).click();
			getElement(allVolumesBtn).click();
			getElements(chooseVolumeList).get(i).click();
			getElement(doneButton).click();
			clickOnAgreement();
			clickOnNextBtn();
			getElement(checkoutBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Method to select volume with print format
	 */
	public boolean selectYourVolumeForPrint(int i) {
		try {
			ReusableMethods.scrollIntoView(getElement(chooseVolumeBtn), driver);
			getElement(chooseVolumeBtn).click();
			if (getElement(allVolumeComittee).isDisplayed())
				getElement(allVolumeComittee).click();
			if (getElements(chooseVolumeList).get(i).isDisplayed())
			getElements(chooseVolumeList).get(i).click();
			getElement(doneButton).click();
			getElement(volumeFormatPrint).click();
			clickOnAgreement();
			clickOnNextBtn();
			getElement(submitBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Method to select radio button of no volume
	 */
	public boolean selectYourVolumeWithNoVolume() {
		try {
			ReusableMethods.scrollIntoView(getElement(isVolumeRequiredRadiobtn), driver);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",getElement(isVolumeRequiredRadiobtn));
			//getElement(isVolumeRequiredRadiobtn).click();
			clickOnAgreement();
			clickOnNextBtn();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Method to select volume with digital format
	 */
	public boolean mobileSelectYourVolumeForDigital(int i) {
		try {
			WebElement volumebtn = getElement(chooseVolumeBtn);
			WaitStatementUtils.explicitWaitForVisibility(driver, volumebtn);
			ReusableMethods.scrollIntoView(volumebtn, driver);
			volumebtn.click();
			getElement(allVolumesBtn).click();
			getElements(chooseVolumeList).get(i).click();
			getElement(doneButton).click();
			clickOnAgreement();
			clickOnNextBtn();
			return true;
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

	@Step("Select {elementName}: '{keys}'in DropDown")
	public void selectValue(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.selectValueInDropdown(getElement(locator), keys), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select value from dropdown.", e);
		}
	}

	public boolean fillMemershipInformationDetailsStep1(String sheetName) {
		try {
			assertTrue(enterPersonalDetailsofMembership(sheetName));
			assertTrue(enterOrganisationalDetailsofMembership(sheetName));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to fill step1 information.", e);
			return false;
		}

	}
	public boolean fillMemershipOrganisationalDetails(String sheetName) {
		try {
			assertTrue(enterOrganisationalDetailsofMembership(sheetName));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to fill step1 information.", e);
			return false;
		}

	}

}
