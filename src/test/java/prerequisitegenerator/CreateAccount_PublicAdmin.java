package testobjects.prerequisitegenerator;

import base.utils.RandomStringUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ui.*;
import testobjects.Account_PublicAdmin;
import testobjects.Address_PublicAdmin;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CreateAccount_PublicAdmin {

    private WebDriver driver;
    AddressPage_PublicAdmin AddressPage;
    CustomerViewPage_PublicAdmin CustomerViewPage;
    AddUpdateAddressPage_PublicAdmin AddAddressPage;
    AccountCreationPage_PublicAdmin AccountCreationPage;
    AllCustomerPage_PublicAdmin AllCustomersPage;
    AccountInformationEdit_PublicAdmin AccountInformationEdit;
    MyAccountPage_Public myAccountPage_public;
    MembershipRenewalPage_Public renewalPage;
    BillingAddressPage_Public billingAddressPage;
    String randomEmail = null;

    public CreateAccount_PublicAdmin(WebDriver driver, Page page) {
        this.driver = driver;
        AddressPage = page.getInstance(AddressPage_PublicAdmin.class);
        CustomerViewPage = page.getInstance(CustomerViewPage_PublicAdmin.class);
        AddAddressPage = page.getInstance(AddUpdateAddressPage_PublicAdmin.class);
        AccountCreationPage = page.getInstance(AccountCreationPage_PublicAdmin.class);
        AllCustomersPage = page.getInstance(AllCustomerPage_PublicAdmin.class);
        AccountInformationEdit = page.getInstance(AccountInformationEdit_PublicAdmin.class);
        myAccountPage_public = page.getInstance(MyAccountPage_Public.class);
        renewalPage = page.getInstance(MembershipRenewalPage_Public.class);
        billingAddressPage=page.getInstance(BillingAddressPage_Public.class);
    }

    @Step("Admin creates an person account")
    public String createPersonAccount() {
        try {
            Account_PublicAdmin accountCreated = new Account_PublicAdmin("Person");
            selectValueFromDropDown("Customer Type Drop Down", AccountCreationPage.getCustomerTypeDropDown(),
                    accountCreated.getCustomerType(), "Admin is unable to select customer type");
            enterTextInTextField("First Name Text Field", AccountCreationPage.getFirstNamField(),
                    accountCreated.getFirstName(), true, "Admin is unable to enter first name");
            enterTextInTextField("Last Name Text Field", AccountCreationPage.getLastNameField(),
                    accountCreated.getLastName(), true, "Admin is unable to enter last name");
            enterTextInTextField("Email Text Field", AccountCreationPage.getEmailField(),
                    accountCreated.getEmail(), true, "Admin is unable to enter email");
            enterTextInTextField("Phone Number Text Field", AccountCreationPage.getPhoneNumberTextField(),
                    accountCreated.getPhoneNumber(), true, "Admin is unable to enter phone number");
            clickOnMethod("Contine Button", AccountCreationPage.getContinueButton(),
                    "Admin is unable to click on continue button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            waitForLoadingScreenToAppearAndDisappear(AddressPage.getSpinnerIcon());
            clickOnMethod("Add New Address Button", AddressPage.getAddNewAddressButton(),
                    "Admin is unable to click Add New Address Button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            enterTextInTextField("Street Address Text Field", AddAddressPage.getStreetAddressTextField(),
                    accountCreated.getAddress().getStreetAddress(), true,
                    "Admin is unable to add text in Street Address text field");
            enterTextInTextField("City Text Field", AddAddressPage.getCityTextField(),
                    accountCreated.getAddress().getCity(), true, "Admin is unable to add text in City text field");
            enterTextInTextField("Zip Code Text Field", AddAddressPage.getZipCodeTextField(),
                    accountCreated.getAddress().getZipCode(), true,
                    "Admin is unable to add text in Zip Code text field");
            enterTextInTextField("Phone Number Text Field", AddAddressPage.getPhoneNumberTextField(),
                    accountCreated.getAddress().getPhoneNumber(), true,
                    "Admin is unable to add text in phone number text field");
            selectValueFromDropDown("Country Drop Down", AddAddressPage.getCountryDropDown(),
                    accountCreated.getAddress().getCountry(), "Admin is unable to select value from Country drop down");
            selectValueFromDropDown("State/Province Drop Down", AddAddressPage.getProvinceDropDown(),
                    accountCreated.getAddress().getProvince(),
                    "Admin is unable to select value from State/Province drop down");
            clickOnMethod("Save Button", AddAddressPage.getSaveButton(), "Admin is unable to click on Save Button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            renewalPage.AddressValidationHeader();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddAddressPage.getSaveButton()),
                    "Admin is unable to save address");
            clickOnMethod("Save and Edit Customer Button", AddressPage.getSaveAndEditCustomer(),
                    "Admin is unable to click on Save and Edit Customer Button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, AllCustomersPage.getLoadingIcon()),
                    "Admin is unable to save customer");
            PublicCommon.waitForSec(10);
            clickOnMethod("Save Customer Button", AddressPage.getSaveCustomerButton(),
                    "Admin is unable to click on Save Customer Button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, AllCustomersPage.getLoadingIcon()),
                    "Admin is unable to save customer");
            PublicCommon.waitForSec(20);
            return accountCreated.getEmail();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create account", e);
            return null;
        }
    }
    @Step("Admin creates an Organization account")
    public String createOrganizationAccount() {
        try {
            Account_PublicAdmin accountCreated = new Account_PublicAdmin("Organization");
            selectValueFromDropDown("Customer Type Drop Down", AccountCreationPage.getCustomerTypeDropDown(),
                    accountCreated.getCustomerType(), "Admin is unable to select customer type");
            enterTextInTextField("Organization Name Text Field", AccountCreationPage.getOrganizationName(),
                    accountCreated.getOrganizationName(), true, "Admin is unable to enter organization name");
            enterTextInTextField("Communication Email Text Field", AccountCreationPage.getCommunicationEmailField(),
                    accountCreated.getCommunicationEmail(), true,
                    "Admin is unable to enter communication email");
            enterTextInTextField("Phone Number Text Field", AccountCreationPage.getPhoneNumberTextField(),
                    RandomStringUtils.getRandomNumbers(10), true, "Admin is unable to enter phone number");
            clickOnMethod("Contine Button", AccountCreationPage.getContinueButton(),
                    "Admin is unable to click on continue button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            waitForLoadingScreenToAppearAndDisappear(AddressPage.getSpinnerIcon());
            PublicCommon.waitForSec(5);
            clickOnMethod("Add New Address Button", AddressPage.getAddNewAddressButton(),
                    "Admin is unable to click Add New Address Button");
            enterTextInTextField("Street Address Text Field", AddAddressPage.getStreetAddressTextField(),
                    accountCreated.getAddress().getStreetAddress(), true,
                    "Admin is unable to add text in Street Address text field");
            enterTextInTextField("City Text Field", AddAddressPage.getCityTextField(),
                    accountCreated.getAddress().getCity(), true, "Admin is unable to add text in City text field");
            enterTextInTextField("Zip Code Text Field", AddAddressPage.getZipCodeTextField(),
                    accountCreated.getAddress().getZipCode(), true,
                    "Admin is unable to add text in Zip Code text field");
            enterTextInTextField("Phone Number Text Field", AddAddressPage.getPhoneNumberTextField(),
                    accountCreated.getAddress().getPhoneNumber(), true,
                    "Admin is unable to add text in phone number text field");
            selectValueFromDropDown("Country Drop Down", AddAddressPage.getCountryDropDown(),
                    accountCreated.getAddress().getCountry(), "Admin is unable to select value from Country drop down");
            selectValueFromDropDown("State/Province Drop Down", AddAddressPage.getProvinceDropDown(),
                    accountCreated.getAddress().getProvince(),
                    "Admin is unable to select value from State/Province drop down");
            clickOnMethod("Save Button", AddAddressPage.getSaveButton(), "Admin is unable to click on Save Button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            renewalPage.AddressValidationHeader();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddAddressPage.getSaveButton()),
                    "Admin is unable to save address");
            clickOnMethod("Save Customer Button", AddressPage.getSaveCustomerButton(),
                    "Admin is unable to click on Save Customer Button");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, AllCustomersPage.getLoadingIcon()),
                    "Admin is unable to save customer");
            return accountCreated.getCommunicationEmail();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create account", e);
            return null;
        }
    }
    @Step("Admin creates an account")
    public Account_PublicAdmin createAccountByObject(Account_PublicAdmin accountCreated) {
        try {
            /*if (accountCreated.getWelcomeMailFromWebSite() != null) {
                selectValueFromDropDown("Welcome Mail From Drop Down", AccountCreationPage.getWelcomeEmailFrom(),
                        accountCreated.getWelcomeMailFromWebSite(),
                        "Admin is unable to select from 'Welcome Mail From Drop Down'");
            }*/

            if (accountCreated.getWebsite() != null) {
                PublicAdminCommons.waitForSec(10000);
                selectValueFromDropDown("Website Drop Down", AccountCreationPage.getAssociateToWebsiteDropDown(),
                        accountCreated.getWebsite(), "Admin is unable to select website");
            }
            selectValueFromDropDown("Customer Type Drop Down", AccountCreationPage.getCustomerTypeDropDown(),
                    accountCreated.getCustomerType(), "Admin is unable to select customer type");
            if (accountCreated.getCustomerType().equals("Person")) {
                enterTextInTextField("First Name Text Field", AccountCreationPage.getFirstNamField(),
                        accountCreated.getFirstName(), true, "Admin is unable to enter first name");
                enterTextInTextField("Last Name Text Field", AccountCreationPage.getLastNameField(),
                        accountCreated.getLastName(), true, "Admin is unable to enter last name");
            } else {
                enterTextInTextField("Organization Name Text Field", AccountCreationPage.getOrganizationName(),
                        accountCreated.getOrganizationName(), true, "Admin is unable to enter organization name");
            }

            if (accountCreated.getCustomerType().equals("Person")) {
                randomEmail = "testaccount" + System.currentTimeMillis() + "@yopmail.com";
                enterTextInTextField("Email Text Field", AccountCreationPage.getEmailField(), randomEmail,
                        true, "Admin is unable to enter email");
            	// enterTextInTextField("Email Text Field", AccountCreationPage.getEmailField(), accountCreated.getEmail(),
                   //     true, "Admin is unable to enter email");
            } else {
                enterTextInTextField("Communication Email Text Field", AccountCreationPage.getCommunicationEmailField(),
                        accountCreated.getCommunicationEmail(), true,
                        "Admin is unable to enter communication email");
            }
            enterTextInTextField("Phone Number Text Field", AccountCreationPage.getPhoneNumberTextField(),
                    RandomStringUtils.getRandomNumbers(10), true, "Admin is unable to enter phone number");
            if (accountCreated.isCreditHold()) {
                Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, AccountCreationPage.getCreditHoldToggleButton(),
                        AccountCreationPage.getCreditHoldInputTag(), true));
                addStep("Admin/ISS agent set credit as 'Yes' for customer");
            }
            
            // clickOnMethod("View Button", AccountCreationPage.getSendActivationEmailToggleButton() , "Admin is unable to click on View Button");
			
        
            if (accountCreated.getSpecialHandling() != null) {
                selectValueFromDropDown("Special Handling Drop Down", AccountCreationPage.getSpecialAccountPreferenceDropDown(),
                        accountCreated.getSpecialHandling(), "ISS Agent/Admin is unable to select option " +
                                "from 'Special Handling Drop Down'");
            }
            if (accountCreated.getReferralCode() != null) {
                selectValueFromDropDown("Referral Code Drop Down", AccountCreationPage.getReferralCodeDropDown(),
                        accountCreated.getReferralCode(), "Admin is unable to select Referral Code");
            }
            if (accountCreated.getArInvoiceType() != null)
                selectValueFromDropDown("Ar Invoice Type Drop Down", AccountCreationPage.getArInvoiceTypeDropDown(),
                        accountCreated.getArInvoiceType(), "Admin is unable to select Ar Invoice Type");
            clickOnMethod("Continue Button", AccountCreationPage.getContinueButton(),
                    "Admin is unable to click on continue button");
            waitForLoadingScreenToAppearAndDisappear(AddressPage.getSpinnerIcon());
            clickOnMethod("Add New Address Button", AddressPage.getAddNewAddressButton(),
                    "Admin is unable to click Add New Address Button");
            if (accountCreated.getCustomerType().equals("Person")) {
                accountCreated.getAddress().setFirstName(accountCreated.getFirstName());
                accountCreated.getAddress().setLastName(accountCreated.getLastName());
            } else {
                accountCreated.getAddress().setFirstName("-");
                accountCreated.getAddress().setLastName("-");
            }
            /*clickOnMethod("Default Billing Address Toggle Button", AddAddressPage.getDefaultBilingAddressCheckbox(),
                    "Admin is unable to click on Default Billing Address Toggle Button");
            clickOnMethod("Default Shipping Address Toggle Button", AddAddressPage.getDefaultShippingAddressCheckbox(),
                    "Admin is unable to click on Default shipping Address Toggle Button");
            clickOnMethod("Default Frieght Forward Address Toggle Button",
                    AddAddressPage.getDefaultFreightForwardCheckbox(),
                    "Admin is unable to click on Default Frieght Forward Address Toggle Button");*/
            enterTextInTextField("Street Address Text Field", AddAddressPage.getStreetAddressTextField(),
                    accountCreated.getAddress().getStreetAddress(), true,
                    "Admin is unable to add text in  First Street Address text field");

            if (accountCreated.getAddress().getStreetAddress2() != null)
                enterTextInTextField("Second Street Address Text Field", AddAddressPage.getStreetAddressSecondTextField(),
                        accountCreated.getAddress().getStreetAddress2(), true,
                        "Admin is unable to add text in Second Street Address text field");

            if (accountCreated.getAddress().getStreetAddress3() != null)
                enterTextInTextField("Third Street Address Text Field", AddAddressPage.getStreetAddressThirdTextField(),
                        accountCreated.getAddress().getStreetAddress3(), true,
                        "Admin is unable to add text in Third Street Address text field");

            if (accountCreated.getAddress().getStreetAddress4() != null)
                enterTextInTextField("Fourth Street Address Text Field", AddAddressPage.getStreetAddressFourthTextField(),
                        accountCreated.getAddress().getStreetAddress4(), true,
                        "Admin is unable to add text in Fourth Street Address text field");

            if (accountCreated.getAddress().getVatNumber() != null)
                enterTextInTextField("VAT Number Text Field", AddAddressPage.getVatNumberTextField(),
                        accountCreated.getAddress().getVatNumber(), true,
                        "Admin is unable to add text in VAT text field");

            if (accountCreated.getAddress().getFaxNumber() != null)
                enterTextInTextField("FAX Text Field", AddAddressPage.getFaxTextField(),
                        accountCreated.getAddress().getFaxNumber(), true,
                        "Admin is unable to add text in FAX text field");

            if (accountCreated.getAddress().getAddressDescription() != null)
                enterTextInTextField("Address Description Text Field", AddAddressPage.getAddressDescription(),
                        accountCreated.getAddress().getAddressDescription(), true,
                        "Admin is unable to add text in Address Description text field");

            if (accountCreated.getAddress().getCompany() != null)
                enterTextInTextField("Company Text Field", AddAddressPage.getCompanyName(),
                        accountCreated.getAddress().getCompany(), true,
                        "Admin is unable to add text in Company text field");

            if (accountCreated.getAddress().getNameSuffix() != null)
                if(myAccountPage_public.getElement(AddAddressPage.getNameSuffixTextField()).isDisplayed()) {
                    enterTextInTextField("Name Suffix Text Field", AddAddressPage.getNameSuffixTextField(),
                            accountCreated.getAddress().getNameSuffix(), true,
                            "Admin is unable to add text in Name Suffix text field");
                }

            /*if (accountCreated.getAddress().getMiddleName() != null)
                enterTextInTextField("Name Suffix Text Field", AddAddressPage.getMiddleNameTextField(),
                        accountCreated.getAddress().getMiddleName(), true,
                        "Admin is unable to add text in Name Suffix text field");*/

            enterTextInTextField("City Text Field", AddAddressPage.getCityTextField(),
                    accountCreated.getAddress().getCity(), true, "Admin is unable to add text in City text field");
            enterTextInTextField("Zip Code Text Field", AddAddressPage.getZipCodeTextField(),
                    accountCreated.getAddress().getZipCode(), true,
                    "Admin is unable to add text in Zip Code text field");
            enterTextInTextField("Phone Number Text Field", AddAddressPage.getPhoneNumberTextField(),
                    accountCreated.getAddress().getPhoneNumber(), true,
                    "Admin is unable to add text in phone number text field");
            selectValueFromDropDown("Country Drop Down", AddAddressPage.getCountryDropDown(),
                    accountCreated.getAddress().getCountry(), "Admin is unable to select value from Country drop down");
            selectValueFromDropDown("State/Province Drop Down", AddAddressPage.getProvinceDropDown(),
                    accountCreated.getAddress().getProvince(),
                    "Admin is unable to select value from State/Province drop down");
            clickOnMethod("Save Button", AddAddressPage.getSaveButton(), "Admin is unable to click on Save Button");
            if(billingAddressPage.isElementDisplayed(billingAddressPage.getElement(billingAddressPage.AddmodelBoxText)))
            {
                if(((billingAddressPage.getElement(billingAddressPage.getModelBoxTitleMagento()).getText().equals("Address Validation"))))
                {
                    clickONMethod("Address Validation Continue Button", billingAddressPage.getContinueBtn(),
                            "Address Validation Continue Button should be clickable");
                }
            }
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddAddressPage.getSaveButton()),
                    "Admin is unable to save address");
            PublicAdminCommons.waitForSec(1500);
            clickOnMethod("Save and Edit Customer Button", AddressPage.getSaveAndEditCustomer(),
                    "Admin is unable to click on Save and Edit Customer Button");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, AllCustomersPage.getLoadingIcon()),
                    "Admin is unable to save customer");
            PublicCommon.waitForSec(10);
            WaitStatementUtils.waitForElementToBeClickable(driver, CustomerViewPage.getElement(CustomerViewPage.getAccountInformationButton()),10);
            clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                        "Admin is unable to click on Account Information Tab");
            String email = PublicAdminCommons.getValueOfAttributeForElement(driver, AccountInformationEdit.getEmailField(), "value");
            Assert.assertNotEquals(email, "", "Email field value is null");
            accountCreated.setEmail(email);
            String ebsAccountNumber = AccountInformationEdit.getEbsNumberFieldValue();
            Assert.assertNotEquals(ebsAccountNumber, "", "EBS Account number field value is null");
            accountCreated.setEbsAccountNumber(ebsAccountNumber);
            return accountCreated;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create account", e);
            return null;
        }
    }
    
    @Step("Admin creates an account")
    public Account_PublicAdmin createAccountByObject1(Account_PublicAdmin accountCreated) {
        try {
            /*if (accountCreated.getWelcomeMailFromWebSite() != null) {
                selectValueFromDropDown("Welcome Mail From Drop Down", AccountCreationPage.getWelcomeEmailFrom(),
                        accountCreated.getWelcomeMailFromWebSite(),
                        "Admin is unable to select from 'Welcome Mail From Drop Down'");
            }*/

            if (accountCreated.getWebsite() != null) {
                PublicAdminCommons.waitForSec(10000);
                selectValueFromDropDown("Website Drop Down", AccountCreationPage.getAssociateToWebsiteDropDown(),
                        accountCreated.getWebsite(), "Admin is unable to select website");
            }
            selectValueFromDropDown("Customer Type Drop Down", AccountCreationPage.getCustomerTypeDropDown(),
                    accountCreated.getCustomerType(), "Admin is unable to select customer type");
            if (accountCreated.getCustomerType().equals("Person")) {
                enterTextInTextField("First Name Text Field", AccountCreationPage.getFirstNamField(),
                        accountCreated.getFirstName(), true, "Admin is unable to enter first name");
                enterTextInTextField("Last Name Text Field", AccountCreationPage.getLastNameField(),
                        accountCreated.getLastName(), true, "Admin is unable to enter last name");
            } else {
                enterTextInTextField("Organization Name Text Field", AccountCreationPage.getOrganizationName(),
                        accountCreated.getOrganizationName(), true, "Admin is unable to enter organization name");
            }

            if (accountCreated.getCustomerType().equals("Person")) {
                randomEmail = "testaccount" + System.currentTimeMillis() + "@yopmail.com";
                enterTextInTextField("Email Text Field", AccountCreationPage.getEmailField(), randomEmail,
                        true, "Admin is unable to enter email");
            	// enterTextInTextField("Email Text Field", AccountCreationPage.getEmailField(), accountCreated.getEmail(),
                   //     true, "Admin is unable to enter email");
            } else {
                enterTextInTextField("Communication Email Text Field", AccountCreationPage.getCommunicationEmailField(),
                        accountCreated.getCommunicationEmail(), true,
                        "Admin is unable to enter communication email");
            }
            enterTextInTextField("Phone Number Text Field", AccountCreationPage.getPhoneNumberTextField(),
                    RandomStringUtils.getRandomNumbers(10), true, "Admin is unable to enter phone number");
            
            selectValueFromDropDown("Classification Drop Down", AccountCreationPage.getClassificationDropDown(),
                    "BOOK DEALER LEVEL 1", "Admin is unable to select customer type");
            
            
            if (accountCreated.isCreditHold()) {
                Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, AccountCreationPage.getCreditHoldToggleButton(),
                        AccountCreationPage.getCreditHoldInputTag(), true));
                addStep("Admin/ISS agent set credit as 'Yes' for customer");
            }
            
            // clickOnMethod("View Button", AccountCreationPage.getSendActivationEmailToggleButton() , "Admin is unable to click on View Button");
			
        
            if (accountCreated.getSpecialHandling() != null) {
                selectValueFromDropDown("Special Handling Drop Down", AccountCreationPage.getSpecialAccountPreferenceDropDown(),
                        accountCreated.getSpecialHandling(), "ISS Agent/Admin is unable to select option " +
                                "from 'Special Handling Drop Down'");
            }
            if (accountCreated.getReferralCode() != null) {
                selectValueFromDropDown("Referral Code Drop Down", AccountCreationPage.getReferralCodeDropDown(),
                        accountCreated.getReferralCode(), "Admin is unable to select Referral Code");
            }
            if (accountCreated.getArInvoiceType() != null)
                selectValueFromDropDown("Ar Invoice Type Drop Down", AccountCreationPage.getArInvoiceTypeDropDown(),
                        accountCreated.getArInvoiceType(), "Admin is unable to select Ar Invoice Type");
            clickOnMethod("Continue Button", AccountCreationPage.getContinueButton(),
                    "Admin is unable to click on continue button");
            waitForLoadingScreenToAppearAndDisappear(AddressPage.getSpinnerIcon());
            clickOnMethod("Add New Address Button", AddressPage.getAddNewAddressButton(),
                    "Admin is unable to click Add New Address Button");
            if (accountCreated.getCustomerType().equals("Person")) {
                accountCreated.getAddress().setFirstName(accountCreated.getFirstName());
                accountCreated.getAddress().setLastName(accountCreated.getLastName());
            } else {
                accountCreated.getAddress().setFirstName("-");
                accountCreated.getAddress().setLastName("-");
            }
            /*clickOnMethod("Default Billing Address Toggle Button", AddAddressPage.getDefaultBilingAddressCheckbox(),
                    "Admin is unable to click on Default Billing Address Toggle Button");
            clickOnMethod("Default Shipping Address Toggle Button", AddAddressPage.getDefaultShippingAddressCheckbox(),
                    "Admin is unable to click on Default shipping Address Toggle Button");
            clickOnMethod("Default Frieght Forward Address Toggle Button",
                    AddAddressPage.getDefaultFreightForwardCheckbox(),
                    "Admin is unable to click on Default Frieght Forward Address Toggle Button");*/
            enterTextInTextField("Street Address Text Field", AddAddressPage.getStreetAddressTextField(),
                    accountCreated.getAddress().getStreetAddress(), true,
                    "Admin is unable to add text in  First Street Address text field");

            if (accountCreated.getAddress().getStreetAddress2() != null)
                enterTextInTextField("Second Street Address Text Field", AddAddressPage.getStreetAddressSecondTextField(),
                        accountCreated.getAddress().getStreetAddress2(), true,
                        "Admin is unable to add text in Second Street Address text field");

            if (accountCreated.getAddress().getStreetAddress3() != null)
                enterTextInTextField("Third Street Address Text Field", AddAddressPage.getStreetAddressThirdTextField(),
                        accountCreated.getAddress().getStreetAddress3(), true,
                        "Admin is unable to add text in Third Street Address text field");

            if (accountCreated.getAddress().getStreetAddress4() != null)
                enterTextInTextField("Fourth Street Address Text Field", AddAddressPage.getStreetAddressFourthTextField(),
                        accountCreated.getAddress().getStreetAddress4(), true,
                        "Admin is unable to add text in Fourth Street Address text field");

            if (accountCreated.getAddress().getVatNumber() != null)
                enterTextInTextField("VAT Number Text Field", AddAddressPage.getVatNumberTextField(),
                        accountCreated.getAddress().getVatNumber(), true,
                        "Admin is unable to add text in VAT text field");

            if (accountCreated.getAddress().getFaxNumber() != null)
                enterTextInTextField("FAX Text Field", AddAddressPage.getFaxTextField(),
                        accountCreated.getAddress().getFaxNumber(), true,
                        "Admin is unable to add text in FAX text field");

            if (accountCreated.getAddress().getAddressDescription() != null)
                enterTextInTextField("Address Description Text Field", AddAddressPage.getAddressDescription(),
                        accountCreated.getAddress().getAddressDescription(), true,
                        "Admin is unable to add text in Address Description text field");

            if (accountCreated.getAddress().getCompany() != null)
                enterTextInTextField("Company Text Field", AddAddressPage.getCompanyName(),
                        accountCreated.getAddress().getCompany(), true,
                        "Admin is unable to add text in Company text field");

            if (accountCreated.getAddress().getNameSuffix() != null)
                enterTextInTextField("Name Suffix Text Field", AddAddressPage.getNameSuffixTextField(),
                        accountCreated.getAddress().getNameSuffix(), true,
                        "Admin is unable to add text in Name Suffix text field");

            /*if (accountCreated.getAddress().getMiddleName() != null)
                enterTextInTextField("Name Suffix Text Field", AddAddressPage.getMiddleNameTextField(),
                        accountCreated.getAddress().getMiddleName(), true,
                        "Admin is unable to add text in Name Suffix text field");*/

            enterTextInTextField("City Text Field", AddAddressPage.getCityTextField(),
                    accountCreated.getAddress().getCity(), true, "Admin is unable to add text in City text field");
            enterTextInTextField("Zip Code Text Field", AddAddressPage.getZipCodeTextField(),
                    accountCreated.getAddress().getZipCode(), true,
                    "Admin is unable to add text in Zip Code text field");
            enterTextInTextField("Phone Number Text Field", AddAddressPage.getPhoneNumberTextField(),
                    accountCreated.getAddress().getPhoneNumber(), true,
                    "Admin is unable to add text in phone number text field");
            selectValueFromDropDown("Country Drop Down", AddAddressPage.getCountryDropDown(),
                    accountCreated.getAddress().getCountry(), "Admin is unable to select value from Country drop down");
            selectValueFromDropDown("State/Province Drop Down", AddAddressPage.getProvinceDropDown(),
                    accountCreated.getAddress().getProvince(),
                    "Admin is unable to select value from State/Province drop down");
            clickOnMethod("Save Button", AddAddressPage.getSaveButton(), "Admin is unable to click on Save Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddAddressPage.getSaveButton()),
                    "Admin is unable to save address");
            PublicAdminCommons.waitForSec(1500);
            clickOnMethod("Save and Edit Customer Button", AddressPage.getSaveAndEditCustomer(),
                    "Admin is unable to click on Save and Edit Customer Button");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, AllCustomersPage.getLoadingIcon()),
                    "Admin is unable to save customer");
            if (accountCreated.getCustomerType().equals("Organization")) {
                clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                        "Admin is unable to click on Account Information Tab");
                String email = PublicAdminCommons.getValueOfAttributeForElement(driver, AccountInformationEdit.getEmailField(), "value");
                Assert.assertNotEquals(email, "", "Email field value is null");
                accountCreated.setEmail(email);
                String ebsAccountNumber = AccountInformationEdit.getEbsNumberFieldValue();
                Assert.assertNotEquals(ebsAccountNumber, "", "EBS Account number field value is null");
                accountCreated.setEbsAccountNumber(ebsAccountNumber);
            }
            return accountCreated;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create account", e);
            return null;
        }
    }


    @Step("{stepDef}")
    public void addStep(String stepDef) {
        Assert.assertTrue(true);
    }

    @Step("Admin adds address to the account")
    public Address_PublicAdmin adminAddsAddressToAccountByObject(Address_PublicAdmin addressObject) {
        try {
            /*clickOnMethod("Default Billing Address Toggle Button", AddAddressPage.getDefaultBilingAddressCheckbox(),
                    "Admin is unable to click on Default Billing Address Toggle Button");
            clickOnMethod("Default Shipping Address Toggle Button", AddAddressPage.getDefaultShippingAddressCheckbox(),
                    "Admin is unable to click on Default shipping Address Toggle Button");
            clickOnMethod("Default Frieght Forward Address Toggle Button",
                    AddAddressPage.getDefaultFreightForwardCheckbox(),
                    "Admin is unable to click on Default Freight Forward Address Toggle Button");*/
            enterTextInTextField("Street Address Text Field", AddAddressPage.getStreetAddressTextField(),
                    addressObject.getStreetAddress(), true,
                    "Admin is unable to add text in Street Address text field");
            enterTextInTextField("City Text Field", AddAddressPage.getCityTextField(),
                    addressObject.getCity(), true, "Admin is unable to add text in City text field");
            enterTextInTextField("Zip Code Text Field", AddAddressPage.getZipCodeTextField(),
                    addressObject.getZipCode(), true,
                    "Admin is unable to add text in Zip Code text field");
            enterTextInTextField("Phone Number Text Field", AddAddressPage.getPhoneNumberTextField(),
                    addressObject.getPhoneNumber(), true,
                    "Admin is unable to add text in phone number text field");
            selectValueFromDropDown("Country Drop Down", AddAddressPage.getCountryDropDown(),
                    addressObject.getCountry(), "Admin is unable to select value from Country drop down");
            if (addressObject.getProvince() != null)
                selectValueFromDropDown("State/Province Drop Down", AddAddressPage.getProvinceDropDown(),
                        addressObject.getProvince(),
                        "Admin is unable to select value from State/Province drop down");
            if (addressObject.getStreetAddress2() != null)
                enterTextInTextField("Second Street Address Text Field", AddAddressPage.getStreetAddressSecondTextField(),
                        addressObject.getStreetAddress2(), true,
                        "Admin is unable to add text in Second Street Address text field");

            if (addressObject.getStreetAddress3() != null)
                enterTextInTextField("Third Street Address Text Field", AddAddressPage.getStreetAddressThirdTextField(),
                        addressObject.getStreetAddress3(), true,
                        "Admin is unable to add text in Third Street Address text field");

            if (addressObject.getStreetAddress4() != null)
                enterTextInTextField("Fourth Street Address Text Field", AddAddressPage.getStreetAddressFourthTextField(),
                        addressObject.getStreetAddress4(), true,
                        "Admin is unable to add text in Fourth Street Address text field");

            if (addressObject.getVatNumber() != null)
                enterTextInTextField("VAT Number Text Field", AddAddressPage.getVatNumberTextField(),
                        addressObject.getVatNumber(), true,
                        "Admin is unable to add text in VAT text field");

            if (addressObject.getFaxNumber() != null)
                enterTextInTextField("FAX Text Field", AddAddressPage.getFaxTextField(),
                        addressObject.getFaxNumber(), true,
                        "Admin is unable to add text in FAX text field");

            if (addressObject.getAddressDescription() != null)
                enterTextInTextField("Address Description Text Field", AddAddressPage.getAddressDescription(),
                        addressObject.getAddressDescription(), true,
                        "Admin is unable to add text in Address Description text field");

            if (addressObject.getCompany() != null)
                enterTextInTextField("Company Text Field", AddAddressPage.getCompanyName(),
                        addressObject.getCompany(), true,
                        "Admin is unable to add text in Company text field");

            if (addressObject.getNameSuffix() != null)
                enterTextInTextField("Name Suffix Text Field", AddAddressPage.getNameSuffixTextField(),
                        addressObject.getNameSuffix(), true,
                        "Admin is unable to add text in Name Suffix text field");

             /*if (addressObject.getMiddleName() != null)
                enterTextInTextField("Name Suffix Text Field", AddAddressPage.getMiddleNameTextField(),
                        addressObject.getMiddleName(), true,
                        "Admin is unable to add text in Name Suffix text field");*/
            clickOnMethod("Save Button", AddAddressPage.getSaveButton(), "Admin is unable to click on Save Button");
            PublicAdminCommons.waitForSec(5000);
            if(billingAddressPage.isElementDisplayed(billingAddressPage.getElement(billingAddressPage.AddmodelBoxText)))
            {
                if(((billingAddressPage.getElement(billingAddressPage.getModelBoxTitleMagento()).getText().equals("Address Validation"))))
                {
                    clickONMethod("Address Validation Continue Button", billingAddressPage.getContinueBtn(),
                            "Address Validation Continue Button should be clickable");
                }
            }
            PublicCommon.waitForSec(10);
            return addressObject;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to save address", e);
            return null;
        }
    }

    @Step("Admin adds account information")
    public Account_PublicAdmin adminAddsAccountInformationByObject(Account_PublicAdmin accountCreated) {
        try {
            if (accountCreated.getWebsite() != null) {
                selectValueFromDropDown("Website Drop Down", AccountCreationPage.getAssociateToWebsiteDropDown(),
                        accountCreated.getWebsite(), "Admin is unable to select website");
            }
            /*if (accountCreated.getWelcomeMailFromWebSite() != null) {
                selectValueFromDropDown("Welcome Mail From Drop Down", AccountCreationPage.getWelcomeEmailFrom(),
                        accountCreated.getWelcomeMailFromWebSite(),
                        "Admin is unable to select from 'Welcome Mail From Drop Down'");
            }*/
            selectValueFromDropDown("Customer Type Drop Down", AccountCreationPage.getCustomerTypeDropDown(),
                    accountCreated.getCustomerType(), "Admin is unable to select customer type");
            if (accountCreated.getCustomerType().equals("Person")) {
                enterTextInTextField("First Name Text Field", AccountCreationPage.getFirstNamField(),
                        accountCreated.getFirstName(), true, "Admin is unable to enter first name");
                enterTextInTextField("Last Name Text Field", AccountCreationPage.getLastNameField(),
                        accountCreated.getLastName(), true, "Admin is unable to enter last name");
            } else {
                enterTextInTextField("Organization Name Text Field", AccountCreationPage.getOrganizationName(),
                        accountCreated.getOrganizationName(), true, "Admin is unable to enter organization name");
            }
            if (accountCreated.getCustomerType().equals("Person")) {
                enterTextInTextField("Email Text Field", AccountCreationPage.getEmailField(), accountCreated.getEmail(),
                        true, "Admin is unable to enter email");
            } else {
                enterTextInTextField("Communication Email Text Field", AccountCreationPage.getCommunicationEmailField(),
                        accountCreated.getCommunicationEmail(), true,
                        "Admin is unable to enter communication email");
            }
            enterTextInTextField("Phone Number Text Field", AccountCreationPage.getPhoneNumberTextField(),
                    RandomStringUtils.getRandomNumbers(10), true, "Admin is unable to enter phone number");
            if (accountCreated.getReferralCode() != null) {
                selectValueFromDropDown("Referral Code Drop Down", AccountCreationPage.getReferralCodeDropDown(),
                        accountCreated.getReferralCode(), "Admin is unable to select Referral Code");
            }
            if (accountCreated.getArInvoiceType() != null)
                selectValueFromDropDown("Ar Invoice Type Drop Down", AccountCreationPage.getArInvoiceTypeDropDown(),
                        accountCreated.getArInvoiceType(), "Admin is unable to select Ar Invoice Type");
            clickOnMethod("Continue Button", AccountCreationPage.getContinueButton(),
                    "Admin is unable to click on continue button");
            waitForLoadingScreenToAppearAndDisappear(AddressPage.getSpinnerIcon());
            return accountCreated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Step("Admin adds account information")
    public Account_PublicAdmin createB2BUser(Account_PublicAdmin accountCreated) {
        try {

            enterTextInTextField("First Name Text Field", AccountCreationPage.getFirstNamField(),
                    accountCreated.getFirstName(), true, "Admin is unable to enter first name");
            enterTextInTextField("Last Name Text Field", AccountCreationPage.getLastNameField(),
                    accountCreated.getLastName(), true, "Admin is unable to enter last name");
            enterTextInTextField("Email Text Field", AccountCreationPage.getEmailField(), accountCreated.getEmail(),
                    true, "Admin is unable to enter email");
            enterTextInTextField("Phone Number Text Field", AccountCreationPage.getPhoneNumberTextField(), accountCreated.getPhoneNumber(), true, "Unable to enter Phone Number");
            clickOnMethod("Continue Button", AccountCreationPage.getContinueButton(), "Admin is unable to click on continue button");
            waitForLoadingScreenToAppearAndDisappear(AddressPage.getSpinnerIcon());
            return accountCreated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Admin/ISS Agent create account with multiple address")
    public Account_PublicAdmin createAccountForMultipleAddress(Account_PublicAdmin accountObject) {
        try {
            adminAddsAccountInformationByObject(accountObject);
            clickOnMethod("Add Address Button", AddressPage.getAddNewAddressButton(),
                    "Admin/ISS Agent is unable to click on 'Add Address Button'");
            adminAddsAddressToAccountByObject(accountObject.getAddress());
            clickOnMethod("Add Address Button", AddressPage.getAddNewAddressButton(),
                    "Admin/ISS Agent is unable to click on 'Add Address Button'");
            adminAddsAddressToAccountByObject(accountObject.getAdditionalAddress());
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddAddressPage.getSaveButton()),
                    "Admin is unable to save address");
            PublicAdminCommons.waitForSec(1500);
            clickOnMethod("Save and Edit Customer Button", AddressPage.getSaveAndEditCustomer(),
                    "Admin is unable to click on Save and Edit Customer Button");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, AllCustomersPage.getLoadingIcon()),
                    "Admin is unable to save customer");
            PublicAdminCommons.waitForSec(1500);
            if (accountObject.getCustomerType().equals("Organization")) {
                WaitStatementUtils.waitForElementToBeClickable(driver,AddressPage.getElement(CustomerViewPage.getAccountInformationButton()),20);
                clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                        "Admin is unable to click on Account Information Tab");
                String email = PublicAdminCommons.getValueOfAttributeForElement(driver, AccountInformationEdit.getEmailField(), "value");
                String eBsAccountNumber = PublicAdminCommons.getValueOfAttributeForElement(driver, AccountInformationEdit.getEbsAccountNumber(), "value");
                Assert.assertNotEquals(email, "", "Email field value is null");
                accountObject.setEmail(email);
                accountObject.setEbsAccountNumber(eBsAccountNumber);
            }
            return accountObject;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create account", e);
            return null;
        }
    }

    @Step("Admin gets information regarding the account")
    public Account_PublicAdmin getTheAccountInformation(String accountType, String email) {
        try {
            Account_PublicAdmin accountObject = new Account_PublicAdmin();
            issAddEmailFilter(email);
            waitForLoadingScreenToAppearAndDisappear(CustomerViewPage.getSpinnerIcon());
            clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                    "Admin is unable to click on 'Account Information Tab'");
            accountObject.setCustomerType(accountType);
            if (accountType.equals("Person")) {
                accountObject.setFirstName(PublicAdminCommons.getValueForAttributeForElement(driver,
                        AccountInformationEdit.getFirstNamField()));
                accountObject.setLastName(PublicAdminCommons.getValueForAttributeForElement(driver,
                        AccountInformationEdit.getLastNameField()));
                accountObject.setEmail(PublicAdminCommons.getValueForAttributeForElement(driver,
                        AccountInformationEdit.getEmailField()));
            } else {
                accountObject.setOrganizationName(PublicAdminCommons.getValueForAttributeForElement(driver,
                        AccountInformationEdit.getOrganizationTextField()));
                accountObject.setEmail(PublicAdminCommons.getValueForAttributeForElement(driver,
                        AccountInformationEdit.getEmailField()));
                accountObject.setCommunicationEmail(PublicAdminCommons.getValueForAttributeForElement(driver,
                        AccountInformationEdit.getCommunicationEmailTextField()));
            }
            accountObject.setPhoneNumber(PublicAdminCommons.getValueForAttributeForElement(driver,
                    AccountInformationEdit.getPhoneNumberTextField()));
            accountObject.setEbsAccountNumber(PublicAdminCommons.getValueForAttributeForElement(driver,
                    AccountInformationEdit.getEbsAccountNumber()));
            clickOnMethod("Address Tab", CustomerViewPage.getAddressButton(),
                    "ISS Agent is unable to click on 'Address Tab'");
            waitForLoadingScreenToAppearAndDisappear(AddressPage.getSpinnerIcon());
            Assert.assertTrue(AddressPage.clickOnEditButtonByIndex(0),
                    "Admin is unable to click on edit button");
            Address_PublicAdmin addressObject = new Address_PublicAdmin();
            addressObject.setFirstName(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getFirstNamField()));
            addressObject.setLastName(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getLastNameField()));
//            addressObject.setMiddleName(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getMiddleNameTextField()));
            addressObject.setStreetAddress(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getStreetAddressTextField()));
            addressObject.setStreetAddress2(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getStreetAddressSecondTextField()));
            addressObject.setStreetAddress3(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getStreetAddressThirdTextField()));
            addressObject.setStreetAddress4(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getStreetAddressFourthTextField()));
            addressObject.setCity(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getCityTextField()));
            addressObject.setCountry(PublicAdminCommons.getSelectedValueForDropDown(driver, AddAddressPage.getCountryDropDown()));
            addressObject.setProvince(PublicAdminCommons.getSelectedValueForDropDown(driver, AddAddressPage.getProvinceDropDown()));
            addressObject.setZipCode(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getZipCodeTextField()));
            addressObject.setPhoneNumber(PublicAdminCommons.getValueForAttributeForElement(driver, AddAddressPage.getPhoneNumberTextField()));
            clickOnMethod("Close Button", AddAddressPage.getCloseButton(),
                    "Admin is unable to click on Close button");
            accountObject.setAddress(addressObject);
            return accountObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Admin/ISS Agent add '{query}' as email filter and click edit button")
    public void issAddEmailFilter(String query) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomersPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomersPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on filter button");
            enterTextInTextField("Email Filter Text Field", AllCustomersPage.getEmailFilterField(), query, true,
                    "Admin/ISS Agent is unable to enter text in email text field");
            clickOnMethod("Apply Filter Button", AllCustomersPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Edit Button", AllCustomersPage.getEditButton(),
                    "Admin/ISS Agent is unable to click on 'Edit Button'");
            Assert.assertTrue(PublicAdminCommons.isWebElementDisplayed(driver, CustomerViewPage.getCreateOrderButton()),
                    "Create Order Button is not present on page if credit hold is set as Create Order Button");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add email filter", e);
        }
    }

    @Step("Admin/ISS Agent add '{query}' as EBS Account number filter")
    public void issAddEbsFilterWithoutEdit(String query) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomersPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomersPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on filter button");
            enterTextInTextField("EBS Account Number Filter Text Field", AllCustomersPage.getEbsAccountNumberFilterField(), query, true,
                    "Admin/ISS Agent is unable to enter text in email text field");
            clickOnMethod("Apply Filter Button", AllCustomersPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add filter", e);
        }
    }

    @Step("Admin/ISS Agent add '{query}' as email filter")
    public void issAddEmailFilterWithoutEdit(String query) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomersPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomersPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on filter button");
            enterTextInTextField("Email Filter Text Field", AllCustomersPage.getEmailFilterField(), query, true,
                    "Admin/ISS Agent is unable to enter text in email text field");
            clickOnMethod("Apply Filter Button", AllCustomersPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add email filter", e);
        }
    }

    @Step("Admin/ISS Agent add '{query}' as communication email filter")
    public void issAddCommunicationEmailFilterWithoutEdit(String query) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomersPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomersPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on filter button");
            enterTextInTextField("Communication Email Filter Text Field", AllCustomersPage.getCommunicationEmailFilterField(), query, true,
                    "Admin/ISS Agent is unable to enter text in Communication email text field");
            clickOnMethod("Apply Filter Button", AllCustomersPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add Communication email filter", e);
        }
    }
    
    @Step("createContactForTPT")
    public void createTPTContact() {
        try {
        	
        	ReusableMethods.scrollIntoView(myAccountPage_public.getElement(CustomerViewPage.getContactsButton()),driver);
    		clickOnMethod("Contact Button",CustomerViewPage.getContactsButton(),
                    "Unable to click on Contact button");
    		clickOnMethod("Add new Contact",CustomerViewPage.addNewContact,
                    "Unable to click on Add new Contact");
    		Thread.sleep(6000);
    		clickOnMethod("TPT Learner",CustomerViewPage.TPTLearner,
                    "Unable to click on TPT Learner");
    		driver.findElement(CustomerViewPage.firstNameTextbox).sendKeys("Test");
    		driver.findElement(CustomerViewPage.lastNameTextbox).sendKeys("User");
    		
    		ReusableMethods.scrollIntoView(myAccountPage_public.getElement(CustomerViewPage.saveButton),driver);
    		clickOnMethod("Apply Filter Button",CustomerViewPage.saveButton,
                    "Admin/ISS Agent is unable to click on apply filter button");
    		
			
            
            
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add Communication email filter", e);
        }
    }
    @Step("create Contact For TPT Learner")
    public Map<String,String> createTPTContact2() {
        Map<String,String> learnerContactMap=new HashMap<String,String>();
        try {
            ReusableMethods.scrollIntoView(myAccountPage_public.getElement(CustomerViewPage.getContactsButton()),driver);
            clickOnMethod("Contact Button",CustomerViewPage.getContactsButton(),
                    "Unable to click on Contact button");
            clickOnMethod("Add new Contact",CustomerViewPage.addNewContact,
                    "Unable to click on Add new Contact");
            Thread.sleep(6000);
            Assert.assertTrue(CustomerViewPage.getElement(CustomerViewPage.activeInputTag).getAttribute("value").equals("1"),"Active Toggle by default should not be set to NO");
            Assert.assertFalse(CustomerViewPage.getElement(CustomerViewPage.activeInputTag).isEnabled(),"Active Toggle by default should not be enabled");
            clickOnMethod("TPT Learner",CustomerViewPage.TPTLearner,
                    "Unable to click on TPT Learner");
            clickOnMethod("Bill To",CustomerViewPage.billTo,
                    "Unable to click on TPT Learner");
            clickOnMethod("Ship To",CustomerViewPage.shipTo,
                    "Unable to click on TPT Learner");
            String Fname="Test"+ MCS2Pages_Committee.getRandomString(3).toLowerCase();
            String Lname="User"+ MCS2Pages_Committee.getRandomString(3).toLowerCase();
            String Mname="A";

            driver.findElement(CustomerViewPage.firstNameTextbox).sendKeys(Fname);
            driver.findElement(CustomerViewPage.middlwNameTextbox).sendKeys(Mname);
            driver.findElement(CustomerViewPage.lastNameTextbox).sendKeys(Lname);
            String email = "testaccount" + System.currentTimeMillis() + "@yopmail.com";
            System.out.println("TPT Email:"+ email);
            driver.findElement(CustomerViewPage.emailTextbox).sendKeys(email);

            ZoneId z = ZoneId.of( "America/New_York" );
            LocalDateTime today = LocalDateTime.now( z );
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

            formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String sDate = today.format(formatter);

            formatter = DateTimeFormatter.ofPattern("MM-d-yyyy");
            String sDatebeforeten = today.format(formatter);

            String eDate="";
            System.out.println(eDate);

            Assert.assertTrue(CustomerViewPage.getElement(CustomerViewPage.getStartDateField()).getAttribute("value").replaceAll("/","-").equals(sDatebeforeten));
            Assert.assertTrue(CustomerViewPage.getElement(CustomerViewPage.getEndDateField()).getAttribute("value").equals(eDate));

            learnerContactMap.put("firstName",Fname);
            learnerContactMap.put("middleName",Mname);
            learnerContactMap.put("lastName",Lname);
            learnerContactMap.put("email",email);
            learnerContactMap.put("startDate",sDate);
            learnerContactMap.put("endDate",eDate);

           ReusableMethods.scrollIntoView(CustomerViewPage.getElement(CustomerViewPage.saveButton),driver);
            clickOnMethod("Save Button",CustomerViewPage.saveButton,
                    "Admin/ISS Agent is unable to click on Save button");
            Thread.sleep(5000);
       } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add Communication email filter", e);
        }
        return learnerContactMap;
    }

    @Step("createContactForTPT")
    public String createTPTContact1() {
        String email=null;
        try {
            ReusableMethods.scrollIntoView(myAccountPage_public.getElement(CustomerViewPage.getContactsButton()),driver);
            clickOnMethod("Contact Button",CustomerViewPage.getContactsButton(),
                    "Unable to click on Contact button");
            clickOnMethod("Add new Contact",CustomerViewPage.addNewContact,
                    "Unable to click on Add new Contact");
            Thread.sleep(6000);
            clickOnMethod("TPT Learner",CustomerViewPage.TPTLearner,
                    "Unable to click on TPT Learner");
            clickOnMethod("Bill To",CustomerViewPage.billTo,
                    "Unable to click on TPT Learner");
            clickOnMethod("Ship To",CustomerViewPage.shipTo,
                    "Unable to click on TPT Learner");
            driver.findElement(CustomerViewPage.firstNameTextbox).sendKeys("Test");
            driver.findElement(CustomerViewPage.lastNameTextbox).sendKeys("User");
            email = "testaccount" + System.currentTimeMillis() + "@yopmail.com";
            System.out.println("TPT Email:"+ email);
           driver.findElement(CustomerViewPage.emailTextbox).sendKeys(email);

            ReusableMethods.scrollIntoView(myAccountPage_public.getElement(CustomerViewPage.saveButton),driver);
            clickOnMethod("Save Button",CustomerViewPage.saveButton,
                    "Admin/ISS Agent is unable to click on Save button");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add Communication email filter", e);
        }
        return email;
    }


    @Step("Admin/ISS Agent add '{query}' as keyword filter")
    public void issAddKeywordFilterWithoutEdit(String query) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            AllCustomersPage.clearFilters();
            clickOnMethod("Filter Button", AllCustomersPage.getFilterButton(),
                    "Admin/ISS Agent is unable to click on filter button");
            enterTextInTextField("Keyword Filter Text Field", AllCustomersPage.getSearchTextField(), query, true,
                    "Admin/ISS Agent is unable to enter text in email text field");
            clickOnMethod("Apply Filter Button", AllCustomersPage.getApplyFilterButton(),
                    "Admin/ISS Agent is unable to click on apply filter button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomersPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add email filter", e);
        }
    }

    @Step("Admin gets the EBS account number")
    public void adminGetsEbsAccountNumber(Account_PublicAdmin accountCreated) {
        try {
            clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                    "Admin is unable to click on Account Information Tab");
            String ebsAccountNumber = AccountInformationEdit.getEbsNumberFieldValue();
            Assert.assertNotEquals(ebsAccountNumber, "", "EBS Account number field value is null");
            Allure.addAttachment("EBS account Number: ", ebsAccountNumber);
            accountCreated.setEbsAccountNumber(ebsAccountNumber);
            if (accountCreated.getCustomerType().equals("Organization")) {
                clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                        "Admin is unable to click on Account Information Tab");
                String email = PublicAdminCommons.getValueOfAttributeForElement(driver, AccountInformationEdit.getEmailField(), "value");
                Assert.assertNotEquals(email, "", "Email field value is null");
                accountCreated.setEmail(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to get EBS Account number", e);
        }
    }

    @Step("Admin gets the EBS account number")
    public void adminGetsEbsAccountNumberOnAccountInfoPage(Account_PublicAdmin accountCreated) {
        try {
            String ebsAccountNumber = AccountInformationEdit.getEbsNumberFieldValue();
            Assert.assertNotEquals(ebsAccountNumber, "", "EBS Account number field value is null");
            Allure.addAttachment("EBS account Number: ", ebsAccountNumber);
            accountCreated.setEbsAccountNumber(ebsAccountNumber);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to get EBS Account number", e);
        }
    }

    @Step("Admin gets the email for order account")
    public void adminGetsEmailForOrgAccount(Account_PublicAdmin accountCreated) {
        try {
            if (accountCreated.getCustomerType().equals("Organization")) {
                clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                        "Admin is unable to click on Account Information Tab");
                String email = PublicAdminCommons.getValueOfAttributeForElement(driver, AccountInformationEdit.getEmailField(), "value");
                Assert.assertNotEquals(email, "", "Email field value is null");
                accountCreated.setEmail(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to get EBS Account number", e);
        }
    }

    @Step("Admin gets the EBS/MAE/OKTA details for person account")
    public void getEbsOktaMaeDetailsForPersonAccount(Account_PublicAdmin accountCreated) {
        try {
            clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                    "Admin is unable to click on Account Information Tab");
            String ebsAccountNumber = AccountInformationEdit.getEbsNumberFieldValue();
            Assert.assertNotEquals(ebsAccountNumber, "", "EBS Account number field value is null");
            accountCreated.setEbsAccountNumber(ebsAccountNumber);

            String oktaUuid = AccountInformationEdit.getOktaUuidFieldValue();
            Assert.assertNotEquals(oktaUuid, "", "OKTA UUID field value is null");
            accountCreated.setOktaUUID(oktaUuid);

            String maeAccountId = AccountInformationEdit.getAccountIdFieldValue();
            Assert.assertNotEquals(maeAccountId, "", "MAE Account ID field value is null");
            accountCreated.setMaeAccountId(maeAccountId);

            String maeUserId = AccountInformationEdit.getMaeUserIDFieldValue();
            Assert.assertNotEquals(maeUserId, "", "MAE User ID field value is null");
            accountCreated.setMaeUserId(maeUserId);

            String maeAccountUserId = AccountInformationEdit.getMaeAccountUserIdFieldValue();
            Assert.assertNotEquals(maeAccountUserId, "", "MAE Account User ID field value is null");
            accountCreated.setMaeAccountUserId(maeAccountUserId);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to get EBS Account number", e);
        }
    }

    @Step("Admin gets the EBS/MAE details for organization account")
    public void getEbsMaeDetailsForOrgAccount(Account_PublicAdmin accountCreated) {
        try {
            clickOnMethod("Account Information Tab", CustomerViewPage.getAccountInformationButton(),
                    "Admin is unable to click on Account Information Tab");
            String ebsAccountNumber = AccountInformationEdit.getEbsNumberFieldValue();
            Assert.assertNotEquals(ebsAccountNumber, "", "EBS Account number field value is null");
            accountCreated.setEbsAccountNumber(ebsAccountNumber);

            String maeAccountId = AccountInformationEdit.getAccountIdFieldValue();
            Assert.assertNotEquals(maeAccountId, "", "MAE Account ID field value is null");
            accountCreated.setMaeAccountId(maeAccountId);

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to get EBS Account number", e);
        }
    }

    @Step("[{testCaseId}] Verify account created has valid value present for EBS, OKTA and MAE")
    public void verifyAccountCreatedHasValidValuePresentForEbsOktaAndMae(String testCaseId, Account_PublicAdmin accountObject) {
        try {
            if (accountObject.getCustomerType().equals(Account_PublicAdmin.AccountType.PERSON.toString())) {
                Assert.assertEquals(AccountInformationEdit.getOktaStatusFieldValue(), "success",
                        "[" + testCaseId + "] OKTA status is not success for person account");
                Assert.assertNotEquals(AccountInformationEdit.getOktaUuidFieldValue(), "",
                        "[" + testCaseId + "] OKTA UUID field value is not populated");
                Assert.assertEquals(AccountInformationEdit.getMaeStatusFieldValue(), "success",
                        "[" + testCaseId + "] MAE status is not success for person account");
                Assert.assertNotEquals(AccountInformationEdit.getMaeUserIDFieldValue(), "",
                        "[" + testCaseId + "] MAE User ID field value is not populated");
                Assert.assertNotEquals(AccountInformationEdit.getMaeAccountUserIdFieldValue(), "",
                        "[" + testCaseId + "] MAE Account User ID field value is not populated");
            } else {
                Assert.assertEquals(AccountInformationEdit.getOktaStatusFieldValue(), "",
                        "[" + testCaseId + "] OKTA status is populated for organization account");
                Assert.assertEquals(AccountInformationEdit.getOktaUuidFieldValue(), "",
                        "[" + testCaseId + "] OKTA UUID field value is populated for organization account");
                Assert.assertEquals(AccountInformationEdit.getMaeUserIDFieldValue(), "",
                        "[" + testCaseId + "] MAE User ID field value is populated for organization account");
                Assert.assertEquals(AccountInformationEdit.getMaeAccountUserIdFieldValue(), "",
                        "[" + testCaseId + "] MAE Account User ID field value is populated for organization account");
            }
            Assert.assertEquals(AccountInformationEdit.getEbsStatusFieldValue(), "success",
                    "[" + testCaseId + "] EBS status is not success for " + accountObject.getCustomerType() + " account");
            Assert.assertNotEquals(AccountInformationEdit.getEbsNumberFieldValue(), "",
                    "[" + testCaseId + "] EBS Account Number field value is not populated");
            Assert.assertNotEquals(PublicAdminCommons.getValueForAttributeForElement(driver,
                    AccountInformationEdit.getEbsPartyIdDisabledTextField()), "",
                    "[" + testCaseId + "] EBS Account Number field value is not populated");
            Assert.assertNotEquals(AccountInformationEdit.getAccountIdFieldValue(), "",
                    "[" + testCaseId + "] MAE Account ID field value is not populated for " + accountObject.getCustomerType() + " account");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify if account created has valid value present for EBS, OKTA and MAE", e);
        }
    }

    @Step("[{testCaseId}] Verify 3PC tenant account created has valid value present for EBS and MAE")
    public void verifyAccountCreatedHasValidValuePresentForEbsAndMaeFor3Pc(String testCaseId, Account_PublicAdmin accountObject) {
        try {
            Assert.assertEquals(AccountInformationEdit.getMaeStatusFieldValue(), "success",
                    "[" + testCaseId + "] MAE status is not success for person account");
            Assert.assertEquals(AccountInformationEdit.getEbsStatusFieldValue(), "success",
                    "[" + testCaseId + "] EBS status is not success for " + accountObject.getCustomerType() + " account");
            Assert.assertNotEquals(AccountInformationEdit.getEbsNumberFieldValue(), "",
                    "[" + testCaseId + "] EBS Account Number field value is not populated");
            Assert.assertNotEquals(PublicAdminCommons.getValueForAttributeForElement(driver,
                    AccountInformationEdit.getEbsPartyIdDisabledTextField()), "",
                    "[" + testCaseId + "] EBS Account Number field value is not populated");
            Assert.assertNotEquals(AccountInformationEdit.getAccountIdFieldValue(), "",
                    "[" + testCaseId + "] MAE Account ID field value is not populated for " + accountObject.getCustomerType() + " account");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify if account created has valid value present for EBS and MAE", e);
        }
    }

    @Step("Admin clicks on '{elementName}'")
    private void clickOnMethod(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.loaderClick(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("Admin clicks on '{elementName}'")
    private void clickOnMethodWithoutWait(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.clickWebElementWithoutWait(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("Admin enters '{value}' in '{elementName}'")
    private void enterTextInTextField(String elementName, By locator, String value, boolean clear,
                                      String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.enterTextInTextField(driver, locator, value, clear), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
        }
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

    @Step("Admin waits for loading screen to disappear")
    private void waitForLoadingScreenToDisappear(By locator) {
        try {
            Assert.assertTrue(PublicAdminCommons.waitElementToDisappearFromScreen(driver, locator),
                    "Loading screen did not disapeear.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Loading screen did not disapeear.", e);
        }
    }

    @Step("Admin waits for loading screen to first appear and disappear")
    private void waitForLoadingScreenToAppearAndDisappear(By locator) {
        try {
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, locator),
                    "Loading screen did not disapeear.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Loading screen did not disapeear.", e);
        }
    }

    @Step("Click on {elementName}")
    private void clickONMethod(String elementName, By locator, String assertionMessage) {
        try {
            assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Click on element", e);
        }
    }
}
