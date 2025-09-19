package testobjects.prerequisitegenerator;

import base.utils.RandomStringUtils;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.PublicAdminCommons;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ui.*;
import testobjects.Contact_PublicAdmin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContactCreation_PublicAdmin {

    private WebDriver driver;
    ContactsPage_PublicAdmin ContactsPage;
    AddUpdateContact_PublicAdmin AddContactsPage;
    CustomerViewPage_PublicAdmin CustomerViewPage;
    CommonWebActions_PublicAdmin CommonActions;
    AccountCreationPage_PublicAdmin AccountCreationPage;

    public ContactCreation_PublicAdmin(WebDriver driver, Page page) {
        this.driver = driver;
        ContactsPage = page.getInstance(ContactsPage_PublicAdmin.class);
        AddContactsPage = page.getInstance(AddUpdateContact_PublicAdmin.class);
        CustomerViewPage = page.getInstance(CustomerViewPage_PublicAdmin.class);
        CommonActions = new CommonWebActions_PublicAdmin(driver, page);
        AccountCreationPage = page.getInstance(AccountCreationPage_PublicAdmin.class);
    }

    @Step("Admin creates a TPT Learner contact")
    public Contact_PublicAdmin createsTptLearnerContact() {
        try {
            Contact_PublicAdmin contactCreated = Contact_PublicAdmin.createTptLearnerContactWithSampleTestData();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, ContactsPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Add Contact Button", ContactsPage.getAddContactButton(),
                    "Admin is unable to click on Add Contact Button");
            clickOnMethod("TPT Leaner Toggle Button", AddContactsPage.getTptLearnerToggleButton(),
                    "Admin is unable to click on TPT Leaner Toggle Button");
            clickOnMethod("Bill To Toggle Button", AddContactsPage.getBillTooggleButton(),
                    "Admin is unable to click on Bill To Toggle Button");
            clickOnMethod("Ship To Toggle Button", AddContactsPage.getShipToToggleButton(),
                    "Admin is unable to click on Ship To Toggle Button");
            clickOnMethod("Deliver To Toggle Button", AddContactsPage.getDelieverToToggleButton(),
                    "Admin is unable to click on Deliver To Toggle Button");
            enterTextInTextField("First Name Text Field", AddContactsPage.getFirstNameTextField(),
                    contactCreated.getFirstName(), false, "Admin is unable to add text in first name text field");
            enterTextInTextField("Last Text Field", AddContactsPage.getLastNameTextField(),
                    contactCreated.getLastName(), false, "Admin is unable to add text in last name text field");
            enterTextInTextField("Email Field", AddContactsPage.getEmailTextField(), contactCreated.getEmail(), true,
                    "Admin is unable to add text in Email text field");
            clickOnMethod("Save Button", AddContactsPage.getSaveButton(), "Admin is unable to click on Save Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddContactsPage.getSaveButton()),
                    "Add Address Page did not disappear after click save button");
            waitForLoadingScreenToAppearAndDisappear(ContactsPage.getSpinnerIcon());
            List<String> emailsList = PublicAdminCommons.getTextOfWebElements(driver, ContactsPage.getEmailColumn());
            Assert.assertTrue(emailsList.contains(contactCreated.getEmail()), "Admin is unable to save the contact");
            return contactCreated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Admin creates a TPT Learner contact")
    public Map<String,String> createsTptLearnerContactwithStandED() {
        try {
            Contact_PublicAdmin contactCreated = Contact_PublicAdmin.createTptLearnerContactWithSampleTestData();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, ContactsPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Add Contact Button", ContactsPage.getAddContactButton(),
                    "Admin is unable to click on Add Contact Button");
            clickOnMethod("TPT Leaner Toggle Button", AddContactsPage.getTptLearnerToggleButton(),
                    "Admin is unable to click on TPT Leaner Toggle Button");
            clickOnMethod("Bill To Toggle Button", AddContactsPage.getBillTooggleButton(),
                    "Admin is unable to click on Bill To Toggle Button");
            clickOnMethod("Ship To Toggle Button", AddContactsPage.getShipToToggleButton(),
                    "Admin is unable to click on Ship To Toggle Button");
            clickOnMethod("Deliver To Toggle Button", AddContactsPage.getDelieverToToggleButton(),
                    "Admin is unable to click on Deliver To Toggle Button");
            enterTextInTextField("First Name Text Field", AddContactsPage.getFirstNameTextField(),
                    contactCreated.getFirstName(), false, "Admin is unable to add text in first name text field");
            enterTextInTextField("Last Text Field", AddContactsPage.getLastNameTextField(),
                    contactCreated.getLastName(), false, "Admin is unable to add text in last name text field");
            enterTextInTextField("Email Field", AddContactsPage.getEmailTextField(), contactCreated.getEmail(), true,
                    "Admin is unable to add text in Email text field");

            Map<String,String> learnerDetailsList=new LinkedHashMap<String,String>();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            learnerDetailsList.put("firstName",contactCreated.getFirstName());
            learnerDetailsList.put("lastName",contactCreated.getLastName());
            learnerDetailsList.put("learnerEmail",contactCreated.getEmail());
            learnerDetailsList.put("learnerContact",contactCreated.getPhoneNumber());
            learnerDetailsList.put("startDate",AddContactsPage.getElement(AddContactsPage.getStartDateField()).getAttribute("value"));
            Assert.assertTrue(AddContactsPage.getElement(AddContactsPage.getEndDateField()).getAttribute("value").equals(""));

            clickOnMethod("Save Button", AddContactsPage.getSaveButton(), "Admin is unable to click on Save Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddContactsPage.getSaveButton()),
                    "Add Address Page did not disappear after click save button");
            waitForLoadingScreenToAppearAndDisappear(ContactsPage.getSpinnerIcon());

            List<String> emailsList = PublicAdminCommons.getTextOfWebElements(driver, ContactsPage.getEmailColumn());
            Assert.assertTrue(emailsList.contains(contactCreated.getEmail()), "Admin is unable to save the contact");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return learnerDetailsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @Step("Admin creates a Bill/Ship/Deliver contact without email")
    public Contact_PublicAdmin createBillShipDeliverContactWithoutEmail() {
        try {
            Contact_PublicAdmin contactCreated = new Contact_PublicAdmin();
            contactCreated.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
            contactCreated.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
            contactCreated.setBillTo(true);
            contactCreated.setShipTo(true);
            contactCreated.setDelieverTo(true);
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, ContactsPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Add Contact Button", ContactsPage.getAddContactButton(),
                    "Admin is unable to click on Add Contact Button");
            clickOnMethod("Bill To Toggle Button", AddContactsPage.getBillTooggleButton(),
                    "Admin is unable to click on Bill To Toggle Button");
            clickOnMethod("Ship To Toggle Button", AddContactsPage.getShipToToggleButton(),
                    "Admin is unable to click on Ship To Toggle Button");
            clickOnMethod("Deliver To Toggle Button", AddContactsPage.getDelieverToToggleButton(),
                    "Admin is unable to click on Deliver To Toggle Button");
            enterTextInTextField("First Name Text Field", AddContactsPage.getFirstNameTextField(),
                    contactCreated.getFirstName(), false, "Admin is unable to add text in first name text field");
            enterTextInTextField("Last Text Field", AddContactsPage.getLastNameTextField(),
                    contactCreated.getLastName(), false, "Admin is unable to add text in last name text field");
            clickOnMethod("Save Button", AddContactsPage.getSaveButton(), "Admin is unable to click on Save Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddContactsPage.getSaveButton()),
                    "Add Address Page did not disappear after click save button");
            waitForLoadingScreenToAppearAndDisappear(ContactsPage.getSpinnerIcon());
            List<String> firstNameList = PublicAdminCommons.getTextOfWebElements(driver, ContactsPage.getFirstName());
            Assert.assertTrue(firstNameList.contains(contactCreated.getFirstName()), "Admin is unable to save the contact");
            return contactCreated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Admin creates a Bill/Ship/Deliver contact with email")
    public Contact_PublicAdmin createBillShipDeliverContactWithEmail() {
        try {
            Contact_PublicAdmin contactCreated = Contact_PublicAdmin.createRequiredBillShipDeliverToContactWithSampleTestData();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, ContactsPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Add Contact Button", ContactsPage.getAddContactButton(),
                    "Admin is unable to click on Add Contact Button");
            clickOnMethod("Bill To Toggle Button", AddContactsPage.getBillTooggleButton(),
                    "Admin is unable to click on Bill To Toggle Button");
            clickOnMethod("Ship To Toggle Button", AddContactsPage.getShipToToggleButton(),
                    "Admin is unable to click on Ship To Toggle Button");
            clickOnMethod("Deliver To Toggle Button", AddContactsPage.getDelieverToToggleButton(),
                    "Admin is unable to click on Deliver To Toggle Button");
            enterTextInTextField("First Name Text Field", AddContactsPage.getFirstNameTextField(),
                    contactCreated.getFirstName(), false, "Admin is unable to add text in first name text field");
            enterTextInTextField("Last Text Field", AddContactsPage.getLastNameTextField(),
                    contactCreated.getLastName(), false, "Admin is unable to add text in last name text field");
            enterTextInTextField("Email Field", AddContactsPage.getEmailTextField(), contactCreated.getEmail(), true,
                    "Admin is unable to add text in Email text field");
            clickOnMethod("Save Button", AddContactsPage.getSaveButton(), "Admin is unable to click on Save Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddContactsPage.getSaveButton()),
                    "Add Address Page did not disappear after click save button");
            //waitForLoadingScreenToAppearAndDisappear(ContactsPage.getSpinnerIcon());
            String email = ContactsPage.getListOfDetailsPresentUnderColumnByName("Email");
            Assert.assertTrue(email.contains(contactCreated.getEmail()), "Admin is unable to save the contact");
            return contactCreated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Admin creates a new contact")
    public Contact_PublicAdmin createContactByObject(Contact_PublicAdmin contactCreated) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, ContactsPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Add Contact Button", ContactsPage.getAddContactButton(),
                    "Admin is unable to click on Add Contact Button");
            if (contactCreated.getTptLearner() == true)
                clickOnMethod("TPT Learner Toggle Button", AddContactsPage.getTptLearnerToggleButton(),
                        "Admin is unable to click on TPT Learner Toggle Button");
            if (contactCreated.getBillTo() == true)
                clickOnMethod("Bill To Toggle Button", AddContactsPage.getBillTooggleButton(),
                        "Admin is unable to click on Bill To Toggle Button");
            if (contactCreated.getShipTo() == true)
                clickOnMethod("Ship To Toggle Button", AddContactsPage.getShipToToggleButton(),
                        "Admin is unable to click on Ship To Toggle Button");
            if (contactCreated.getDelieverTo() == true)
                clickOnMethod("Deliver To Toggle Button", AddContactsPage.getDelieverToToggleButton(),
                        "Admin is unable to click on Deliver To Toggle Button");
            enterTextInTextField("First Name Text Field", AddContactsPage.getFirstNameTextField(),
                    contactCreated.getFirstName(), false, "Admin is unable to add text in first name text field");
            enterTextInTextField("Last Text Field", AddContactsPage.getLastNameTextField(),
                    contactCreated.getLastName(), false, "Admin is unable to add text in last name text field");
            if (contactCreated.getEmail() != null)
                enterTextInTextField("Email Field", AddContactsPage.getEmailTextField(), contactCreated.getEmail(), true,
                        "Admin is unable to add text in Email text field");
            // TODO Add code for remaining fields as per requirement
            clickOnMethod("Save Button", AddContactsPage.getSaveButton(), "Admin is unable to click on Save Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddContactsPage.getSaveButton()),
                    "Add Address Page did not disappear after click save button");
            waitForLoadingScreenToAppearAndDisappear(ContactsPage.getSpinnerIcon());
            List<String> firstNameList = PublicAdminCommons.getTextOfWebElements(driver, ContactsPage.getFirstName());
            Assert.assertTrue(firstNameList.contains(contactCreated.getFirstName()), "Admin is unable to save the contact");
            return contactCreated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Click Contacts Tab")
    public void clickContactsTab(){
        // Click on Contacts Tab
        CommonActions.clickOnMethod("Contacts Tab", CustomerViewPage.getContactsButton(),
                "Unable to click on 'Contacts Tab'");
    }

    @Step("Admin creates a new contact")
    public Contact_PublicAdmin createContactByObjectFromCustomerViewPage(Contact_PublicAdmin contactCreated) {
        try {
            // Click on Contacts Tab
            CommonActions.clickOnMethod("Contacts Tab", CustomerViewPage.getContactsButton(),
                                "Unable to click on 'Contacts Tab'");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, ContactsPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            clickOnMethod("Add Contact Button", ContactsPage.getAddContactButton(),
                    "Admin is unable to click on Add Contact Button");
            if (contactCreated.getTptLearner())
                clickOnMethod("TPT Learner Toggle Button", AddContactsPage.getTptLearnerToggleButton(),
                        "Admin is unable to click on TPT Learner Toggle Button");
            if (contactCreated.getBillTo())
                clickOnMethod("Bill To Toggle Button", AddContactsPage.getBillTooggleButton(),
                        "Admin is unable to click on Bill To Toggle Button");
            if (contactCreated.getShipTo())
                clickOnMethod("Ship To Toggle Button", AddContactsPage.getShipToToggleButton(),
                        "Admin is unable to click on Ship To Toggle Button");
            if (contactCreated.getDelieverTo())
                clickOnMethod("Deliver To Toggle Button", AddContactsPage.getDelieverToToggleButton(),
                        "Admin is unable to click on Deliver To Toggle Button");
            enterTextInTextField("First Name Text Field", AddContactsPage.getFirstNameTextField(),
                    contactCreated.getFirstName(), false, "Admin is unable to add text in first name text field");
            enterTextInTextField("Last Text Field", AddContactsPage.getLastNameTextField(),
                    contactCreated.getLastName(), false, "Admin is unable to add text in last name text field");
            if (contactCreated.getEmail() != null)
                enterTextInTextField("Email Field", AddContactsPage.getEmailTextField(), contactCreated.getEmail(), true,
                        "Admin is unable to add text in Email text field");
            // TODO Add code for remaining fields as per requirement
            clickOnMethod("Save Button", AddContactsPage.getSaveButton(), "Admin is unable to click on Save Button");
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddContactsPage.getSaveButton()),
                    "Add Address Page did not disappear after click save button");
            waitForLoadingScreenToAppearAndDisappear(ContactsPage.getSpinnerIcon());
            List<String> firstNameList = PublicAdminCommons.getTextOfWebElements(driver, ContactsPage.getFirstName());
            Assert.assertTrue(firstNameList.contains(contactCreated.getFirstName()), "Admin is unable to save the contact");
            return contactCreated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Admin/ISS Agent a new contact")
    public Contact_PublicAdmin createContactByObjectOnCreationPage(Contact_PublicAdmin contactCreated) {
        try {
            if (contactCreated.getTptLearner())
                clickOnMethod("TPT Learner Toggle Button", AddContactsPage.getTptLearnerToggleButton(),
                        "Admin/ISS Agent is unable to click on TPT Learner Toggle Button");
            if (contactCreated.getBillTo())
                clickOnMethod("Bill To Toggle Button", AddContactsPage.getBillTooggleButton(),
                        "Admin/ISS Agent is unable to click on Bill To Toggle Button");
            if (contactCreated.getShipTo())
                clickOnMethod("Ship To Toggle Button", AddContactsPage.getShipToToggleButton(),
                        "Admin/ISS Agent is unable to click on Ship To Toggle Button");
            if (contactCreated.getDelieverTo())
                clickOnMethod("Deliver To Toggle Button", AddContactsPage.getDelieverToToggleButton(),
                        "Admin/ISS Agent is unable to click on Deliver To Toggle Button");
            enterTextInTextField("First Name Text Field", AddContactsPage.getFirstNameTextField(),
                    contactCreated.getFirstName(), false,
                    "Admin/ISS Agent is unable to add text in first name text field");
            if (contactCreated.getMiddleName() != null)
                enterTextInTextField("Middle Name Text Field", AddContactsPage.getMiddleNamTextField(),
                        contactCreated.getMiddleName(), false,
                        "Admin/ISS Agent is unable to add text in Middle name text field");
            enterTextInTextField("Last Text Field", AddContactsPage.getLastNameTextField(),
                    contactCreated.getLastName(), false,
                    "Admin/ISS Agent is unable to add text in last name text field");
            if (contactCreated.getEmail() != null)
                enterTextInTextField("Email Field", AddContactsPage.getEmailTextField(), contactCreated.getEmail(), true,
                        "Admin/ISS Agent is unable to add text in Email text field");
            if (contactCreated.getJobTitle() != null)
                enterTextInTextField("Job Title Field", AddContactsPage.getJobTitleTextField(),
                        contactCreated.getJobTitle(), false,
                        "Admin/ISS Agent is unable to add text in Job text field");
            if (contactCreated.getPhoneNumber() != null)
                enterTextInTextField("Phone Number Field", AddContactsPage.getPhoneTextField(),
                        contactCreated.getPhoneNumber(), false,
                        "Admin/ISS Agent is unable to add text in Phone Number text field");
            if (contactCreated.getStartDate() != null) {
                clickOnMethod("Start Date Calender Icon", AddContactsPage.getStartDateCalenderIcon(),
                                    "ISS Agent is unable to click on 'Start Date Calender Icon'");
                assertTrueWithStep(AddContactsPage.pickDateFromCalender(contactCreated.getStartDate()),
                        "Admin/ISS Agent select start date using calender",
                        "Unable to pick start date");
            }
            if (contactCreated.getEndDate() != null) {
                clickOnMethod("End Date Calender Icon", AddContactsPage.getEndDateCalenderIcon(),
                        "ISS Agent is unable to click on 'End Date Calender Icon'");
                assertTrueWithStep(AddContactsPage.pickDateFromCalender(contactCreated.getEndDate()),
                        "Admin/ISS Agent select end date using calender",
                        "Unable to pick end date");
            }
            clickOnMethod("Save Button", AddContactsPage.getSaveButton(), "Admin/ISS Agent is unable to click on Save Button");
            /*Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AddContactsPage.getSaveButton()),
                    "Add Address Page did not disappear after click save button");*/
            waitForLoadingScreenToAppearAndDisappear(ContactsPage.getSpinnerIcon());
            List<String> firstNames = ContactsPage.getDetailsPresentUnderColumn("First Name");
            Assert.assertTrue(firstNames.contains(contactCreated.getFirstName()),
                    "Admin/ISS Agent is unable to save the contact");
            return contactCreated;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to create contact", e);
            return null;
        }
    }

    @Step("[{testCaseId}] Verify contact is added to the contact grid")
    public void verifyContactObjectsOnGird(String testCaseId, Contact_PublicAdmin objectOne, Contact_PublicAdmin objectTwo) {
        try {
            Assert.assertEquals(objectOne.getEmail(), objectTwo.getEmail(),"Email mismatch");
            Assert.assertEquals(objectOne.isActive(), objectTwo.isActive(),"Active toggle mismatch");
            Assert.assertEquals(objectOne.isBillTo(), objectTwo.isBillTo(),"Bill To toggle mismatch");
            Assert.assertEquals(objectOne.isShipTo(), objectTwo.isShipTo(),"Ship To toggle mismatch");
            Assert.assertEquals(objectOne.isDelieverTo(), objectTwo.isDelieverTo(),"Deliver To toggle mismatch");
            Assert.assertEquals(objectOne.getTptLearner(), objectTwo.getTptLearner(),"TPT Learner toggle mismatch");
            Assert.assertEquals(objectOne.getFirstName(), objectTwo.getFirstName(),"First Name mismatch");
            Assert.assertEquals(objectOne.getLastName(), objectTwo.getLastName(),"Last Name mismatch");
            Assert.assertEquals(objectOne.getMiddleName(), objectTwo.getMiddleName(),"Middle Name mismatch");
            Assert.assertEquals(objectOne.getJobTitle(), objectTwo.getJobTitle(),"Job Title mismatch");
            Assert.assertEquals(objectOne.getPhoneNumber(), objectTwo.getPhoneNumber(),"Phone Number mismatch");
            // Not comparing dats as those are not present on the contact grid
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("["+testCaseId+"] Unable to verify if contact is added to the contact grid", e);
        }
    }

    @Step("[{testCaseId}] Verify contact details are updated on the contact grid")
    public void verifyUpdatedContactObjectsOnGird(String testCaseId, Contact_PublicAdmin objectOne, Contact_PublicAdmin objectTwo) {
        try {
            Assert.assertEquals(objectOne.getEmail(), objectTwo.getEmail(),"Email mismatch after updating contact details");
            Assert.assertEquals(objectOne.isActive(), objectTwo.isActive(),"Active toggle mismatch after updating contact details");
            Assert.assertEquals(objectOne.isBillTo(), objectTwo.isBillTo(),"Bill To toggle mismatch after updating contact details");
            Assert.assertEquals(objectOne.isShipTo(), objectTwo.isShipTo(),"Ship To toggle mismatch after updating contact details");
            Assert.assertEquals(objectOne.isDelieverTo(), objectTwo.isDelieverTo(),"Deliver To toggle mismatch after updating contact details");
            Assert.assertEquals(objectOne.getTptLearner(), objectTwo.getTptLearner(),"TPT Learner toggle mismatch after updating contact details");
            Assert.assertEquals(objectOne.getFirstName(), objectTwo.getFirstName(),"First Name mismatch after updating contact details");
            Assert.assertEquals(objectOne.getLastName(), objectTwo.getLastName(),"Last Name mismatch after updating contact details");
            Assert.assertEquals(objectOne.getMiddleName(), objectTwo.getMiddleName(),"Middle Name mismatch after updating contact details");
            Assert.assertEquals(objectOne.getJobTitle(), objectTwo.getJobTitle(),"Job Title mismatch after updating contact details");
            Assert.assertEquals(objectOne.getPhoneNumber(), objectTwo.getPhoneNumber(),"Phone Number mismatch after updating contact details");
            // Not comparing dats as those are not present on the contact grid
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("["+testCaseId+"] Unable to verify if contact is added to the contact grid", e);
        }
    }

    @Step("[{testCaseId}] Verify contact details on EBS")
    public void verifyContactDetailsEbsApi(String testCaseId, Contact_PublicAdmin objectOne, JSONObject jsonObject) {
        try {
            JSONObject contactObject = null;
            if(jsonObject.getJSONObject("OutputParameters").getJSONObject("X_CONTACT_TAB")
                    .getJSONObject("X_CONTACT_TAB_ITEM").getJSONObject("CONTACT_DETAILS").get("CONTACT_DETAILS_ITEM") instanceof JSONArray){
                int numberOfContacts = jsonObject.getJSONObject("OutputParameters").getJSONObject("X_CONTACT_TAB")
                        .getJSONObject("X_CONTACT_TAB_ITEM").getJSONObject("CONTACT_DETAILS").getJSONArray("CONTACT_DETAILS_ITEM").length();
                contactObject = jsonObject.getJSONObject("OutputParameters").getJSONObject("X_CONTACT_TAB")
                        .getJSONObject("X_CONTACT_TAB_ITEM").getJSONObject("CONTACT_DETAILS")
                        .getJSONArray("CONTACT_DETAILS_ITEM").getJSONObject(numberOfContacts - 1);
            } else {
                contactObject = jsonObject.getJSONObject("OutputParameters").getJSONObject("X_CONTACT_TAB")
                        .getJSONObject("X_CONTACT_TAB_ITEM").getJSONObject("CONTACT_DETAILS")
                        .getJSONObject("CONTACT_DETAILS_ITEM");
            }
            Assert.assertNotNull(contactObject, "Unable to get contact details using EBS APIs");
            Assert.assertEquals(objectOne.getEmail(), contactObject.getJSONObject("COMMUNICATION").getJSONArray("COMMUNICATION_ITEM")
                            .getJSONObject(0).getString("VALUE"),"Email mismatch between magento and EBS");
            Assert.assertEquals("Y", contactObject.getJSONObject("COMMUNICATION").getJSONArray("COMMUNICATION_ITEM")
                    .getJSONObject(0).getString("PRIMARY_FLAG"),"Primary flag is not set for email");
            Assert.assertEquals(objectOne.getFirstName(), contactObject.getString("FIRST_NAME"),
                    "First Name mismatch between magento and EBS");
            Assert.assertEquals(objectOne.getLastName(), contactObject.getString("LAST_NAME"),
                    "Last Name mismatch between magento and EBS");
            if (objectOne.getMiddleName() != null)
                Assert.assertEquals(objectOne.getMiddleName(), contactObject.getString("MIDDLE_NAME"),
                        "Middle Name mismatch between magento and EBS");
            if (objectOne.getPhoneNumber() != null) {
                Assert.assertEquals(objectOne.getPhoneNumber(), contactObject.getJSONObject("COMMUNICATION")
                                .getJSONArray("COMMUNICATION_ITEM").getJSONObject(1).getString("VALUE"),
                        "Phone Number mismatch between magento and EBS");
                Assert.assertEquals("Y", contactObject.getJSONObject("COMMUNICATION").getJSONArray("COMMUNICATION_ITEM")
                        .getJSONObject(1).getString("PRIMARY_FLAG"),"Primary flag is not set for phone number");
            }
            Assert.assertEquals(PublicAdminCommons.getCurrentDateWithFormat("MM-dd-yyyy"), contactObject.getString("START_DATE"),
                    "Start date is not set to current date");
            Assert.assertEquals("12-31-4712", contactObject.getString("END_DATE"),
                    "End date is not null");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("["+testCaseId+"] Unable to verify if contact is added to the contact grid", e);
        }
    }

    @Step("Admin clicks on '{elementName}'")
    private void clickOnMethod(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.clickWebElement(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("Admin enters '{value}' in '{elementName}'")
    private void enterTextInTextField(String elementName, By locator, String value, boolean clear,
                                      String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.enterTextInTextField(driver, locator, value, clear), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
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

    @Step("{stepDef}")
    public void assertTrueWithStep(boolean result, String stepDef, String assertionMessage) {
        try {
            Assert.assertTrue(result,
                    assertionMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(assertionMessage, e);
        }
    }
}
