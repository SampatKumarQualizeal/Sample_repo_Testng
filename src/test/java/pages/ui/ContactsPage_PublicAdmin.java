package pages.ui;

import com.astm.commonFunctions.PublicAdminCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testobjects.Contact_PublicAdmin;

import java.util.ArrayList;
import java.util.List;

public class ContactsPage_PublicAdmin extends BasePage {

    public ContactsPage_PublicAdmin(WebDriver driver) {
        super(driver);
    }

    private By addContactButton = By.cssSelector("button[data-index='add_contact']");
    private By spinnerIcon = By.cssSelector("div[data-component*='customer_contact_listing'] div.spinner");
    private By emailColumn = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(5)");
    private By editButton = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(12) a");
    private By firstName = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(2)");
    private By middleName = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(3)");
    private By lastName = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(4)");
    private By email = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(6)");
    private By phoneNumber = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(5)");
    private By jobTitle = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(7)");
    private By billTo = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(9)");
    private By shipTo = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(10)");
    private By delieverTo = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(11)");
    private By tptLearner = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(8)");
    private By active = By.cssSelector(
            "div[data-bind*='customer_contact_listing'] table.data-grid tbody tr.data-row td:nth-child(1)");
    private By columns = By.cssSelector("div[data-bind*='customer_contact_listing'] table.data-grid thead th");
    private By columnNames = By.cssSelector("#modal-content-21 table[data-role='grid'] >thead tr th");


    private By getSelectorCellsUnderColumnByIndex(int index) {
        return By.cssSelector("div[data-bind*='customer_contact_listing'] " +
                "table.data-grid tbody tr.data-row td:nth-of-type(" + index + ")");
    }

    private By getColumnDetailsByIndex(String index) {
        return By.cssSelector("#modal-content-21 table[data-role='grid']  tr.data-row td:nth-of-type(" + index + ")");
    }


    public String getListOfDetailsPresentUnderColumnByName(String columnName) {
        String columnValue;
        try {
            List<WebElement> columnElements = getElementsNew(columnNames);
            int index = 0;
            for (WebElement column : columnElements) {
                if (column.getText().equals(columnName)) {
                    index = columnElements.indexOf(column);
                }
            }
            return PublicAdminCommons.getTextOfWebElements(driver,
                    getColumnDetailsByIndex(String.valueOf(index+1))).get(0);
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * @return columns
     */
    public By getColumns() {
        return columns;
    }

    /**
     * @return the editButton
     */
    public By getEditButton() {
        return editButton;
    }

    /**
     * @return the firstName
     */
    public By getFirstName() {
        return firstName;
    }

    /**
     * @return the middleName
     */
    public By getMiddleName() {
        return middleName;
    }

    /**
     * @return the lastName
     */
    public By getLastName() {
        return lastName;
    }

    /**
     * @return the email
     */
    public By getEmail() {
        return email;
    }

    /**
     * @return the phoneNumber
     */
    public By getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the jobTitle
     */
    public By getJobTitle() {
        return jobTitle;
    }

    /**
     * @return the billTo
     */
    public By getBillTo() {
        return billTo;
    }

    /**
     * @return the shipTo
     */
    public By getShipTo() {
        return shipTo;
    }

    /**
     * @return the delieverTo
     */
    public By getDelieverTo() {
        return delieverTo;
    }

    /**
     * @return the tptLearner
     */
    public By getTptLearner() {
        return tptLearner;
    }

    /**
     * @return the emailColumn
     */
    public By getEmailColumn() {
        return emailColumn;
    }

    /**
     * @return the addContactButton
     */
    public By getAddContactButton() {
        return addContactButton;
    }

    /**
     * @return the spinnerIcon
     */
    public By getSpinnerIcon() {
        return spinnerIcon;
    }

    /**
     * Clicks on edit button by index
     *
     * @param index
     * @return
     */
    public boolean clickEditButtonByIndex(int index) {
        try {
            List<WebElement> editButtonList = getElementsNew(editButton);
            editButtonList.get(index).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }

    /**
     * This method creates the contact objects and adds the value for
     * bill,ship,deliever and tpt learner New information can be added using the
     * setter methods
     *
     * @param index
     * @return
     */
    public Contact_PublicAdmin getTheContactDetailsByIndex(int index) {
        try {
            Contact_PublicAdmin contact = new Contact_PublicAdmin();
            contact.setBillTo(returnTrueIfYesAndFalseIfNo(getElementsNew(billTo).get(index).getText()));
            contact.setShipTo(returnTrueIfYesAndFalseIfNo(getElementsNew(shipTo).get(index).getText()));
            contact.setDelieverTo(returnTrueIfYesAndFalseIfNo(getElementsNew(delieverTo).get(index).getText()));
            contact.setTptLearner(returnTrueIfYesAndFalseIfNo(getElementsNew(tptLearner).get(index).getText()));
            contact.setActive(returnTrueIfYesAndFalseIfNo(getElementsNew(active).get(index).getText()));
            contact.setEmail(getElementsNew(email).get(index).getText());
            return contact;
        } catch (Exception e) {
            log.info("Unable to create contacts objects" + e);
            return null;
        }
    }

    public boolean returnTrueIfYesAndFalseIfNo(String condition) {
        if (condition.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method search for TPT learner contact in list and return contact object
     *
     * @return contact_object
     */
    public Contact_PublicAdmin getTheTPTLearnerContactFromList() {
        try {
            List<WebElement> contacts = getElementsNew(emailColumn);
            for (WebElement contact : contacts) {
                Contact_PublicAdmin contact_object = getTheContactDetailsByIndex(contacts.indexOf(contact));
                if (contact_object.getTptLearner() == true && !(contact_object.getEmail().isEmpty()))
                    return contact_object;
            }
            return null;
        } catch (Exception e) {
            log.info("Unable to create list of contact objects" + e);
            return null;
        }
    }

    /**
     * This method returns the list of TPT learner contact in list
     *
     * @return contact_object
     */
    public List<Object> getAllTPTLearnerContactFromList() {
        try {
            List<Object> contactsObjects = new ArrayList<Object>();
            List<WebElement> contacts = getElementsNew(emailColumn);
            for (WebElement contact : contacts) {
                int index = contacts.indexOf(contact);
                Contact_PublicAdmin contact_object = new Contact_PublicAdmin();
                contact_object
                        .setTptLearner(returnTrueIfYesAndFalseIfNo(getElementsNew(tptLearner).get(index).getText()));
                if (getElementsNew(email).get(index).getText().equals(""))
                    contact_object.setEmail(null);
                else
                    contact_object.setEmail(getElementsNew(email).get(index).getText());
                contact_object.setFirstName(getElementsNew(firstName).get(index).getText());
                contact_object.setLastName(getElementsNew(lastName).get(index).getText());
                if (contact_object.getTptLearner() == true)
                    contactsObjects.add(contact_object);
            }
            log.info("Contacts Size: " + contactsObjects.size());
            return contactsObjects;
        } catch (Exception e) {
            log.info("Unable to create contacts objects" + e);
            return null;
        }
    }

    public Contact_PublicAdmin getContactDetailsFromListByEmail(String email) {
        try {
            List<String> emailsList = PublicAdminCommons.getTextOfWebElements(driver, emailColumn);
            int index = emailsList.indexOf(email);
            Contact_PublicAdmin contact = getTheContactDetailsByIndex(index);
            return contact;
        } catch (Exception e) {
            log.info("Unable to create contacts object" + e);
            return null;
        }
    }

    public List<String> getDetailsPresentUnderColumn(String column) {
        try {
            List<String> columnNames = PublicAdminCommons.getTextOfWebElements(driver, columns);
            int indexForTheColumn = columnNames.indexOf(column);
			return PublicAdminCommons.getTextOfWebElements(driver, getSelectorCellsUnderColumnByIndex(indexForTheColumn+1));
        } catch (Exception e) {
            return null;
        }
    }

    public String getDetailsPresentUnderColumn(String column, int indexOfRow) {
        try {
            List<String> columnNames = PublicAdminCommons.getTextOfWebElements(driver, columns);
            int indexForTheColumn = columnNames.indexOf(column);
            List<String> columnDetailsList = PublicAdminCommons.getTextOfWebElements(driver,
                    getSelectorCellsUnderColumnByIndex(indexForTheColumn+1));
            return columnDetailsList.get(indexOfRow);
        } catch (Exception e) {
            return null;
        }
    }

    public Contact_PublicAdmin getContactObjectByEmail(String email){
        try {
            Contact_PublicAdmin contact = new Contact_PublicAdmin();
            List<String> emails = getDetailsPresentUnderColumn("Email");
            int rowIndex = emails.indexOf(email);
            contact.setBillTo(returnTrueIfYesAndFalseIfNo(getDetailsPresentUnderColumn("Bill To", rowIndex)));
            contact.setShipTo(returnTrueIfYesAndFalseIfNo(getDetailsPresentUnderColumn("Ship To", rowIndex)));
            contact.setDelieverTo(returnTrueIfYesAndFalseIfNo(getDetailsPresentUnderColumn("Deliver To", rowIndex)));
            contact.setTptLearner(returnTrueIfYesAndFalseIfNo(getDetailsPresentUnderColumn("TPT Learner", rowIndex)));
            contact.setActive(returnTrueIfYesAndFalseIfNo(getDetailsPresentUnderColumn("Active", rowIndex)));
            contact.setFirstName(getDetailsPresentUnderColumn("First Name", rowIndex));
            String middleName = getDetailsPresentUnderColumn("Middle Name", rowIndex);
            if(!middleName.equals(""))
                contact.setMiddleName(middleName);
            contact.setLastName(getDetailsPresentUnderColumn("Last Name", rowIndex));
            contact.setEmail(getDetailsPresentUnderColumn("Email", rowIndex));
            String phone = getDetailsPresentUnderColumn("Phone", rowIndex);
            String jobTitle = getDetailsPresentUnderColumn("Job Title", rowIndex);
            if(!phone.equals(""))
                contact.setPhoneNumber(phone);
            if(!jobTitle.equals(""))
                contact.setJobTitle(jobTitle);
            return contact;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Clicks on edit button by providing first name
     *
     * @param firstName
     * @return
     */
    public boolean clickEditButtonByFirstName(String firstName) {
        try {
            List<String> fNames = getDetailsPresentUnderColumn("First Name");
            int index = fNames.indexOf(firstName);
            List<WebElement> editButtonList = getElementsNew(editButton);
            editButtonList.get(index).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }

}
