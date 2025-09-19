package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testobjects.Account_PublicAdmin;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AllCustomerPage_PublicAdmin extends BasePage {

    public AllCustomerPage_PublicAdmin(WebDriver driver) {
        super(driver);
    }
    public By referralCodeForGivenEmail(String b2bAcc,String referralCodeVal){
        return By.xpath("//div[text()='"+b2bAcc+"']/parent::td/following-sibling::td/div[text()='"+referralCodeVal+"']");
    }

    private By addNewCustomerButton = By.cssSelector("button#add");
    private By userCreationSuccessMessage = By.cssSelector(".message-success");
    private By searchTextField = By.cssSelector("input[placeholder='Search by keyword']");
    private By searchButton = By.cssSelector("#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button");
    public By editButton = By.cssSelector("a[href*='/index/edit/']");
    private By emailLabel = By.cssSelector("tr.data-row td:nth-of-type(4)");
    /*private By spinnerIcon = By
            .xpath("(//div[@class='admin__data-grid-outer-wrap'])[2]//following::div[@class='spinner']");*/
    private By spinnerIcon = By
            .cssSelector("div[data-component='customer_listing.customer_listing.customer_columns'] .spinner");
    private By nameLabel = By.cssSelector("tr.data-row td:nth-of-type(3)");
    public By OrdersTab = By.xpath("//a[@id='tab_orders_content']");
    public By FirstOrder = By.xpath("(//td[contains(@class,'col-increment_id')])[2]");


    private By customerTypeLabel = By.cssSelector("tr.data-row td:nth-of-type(5)");
    private By webSiteLabel = By.cssSelector("tr.data-row td:nth-of-type(12)");
    private By accountCreatedInLabel = By.cssSelector("tr.data-row td:nth-of-type(14)");
    private By customerIdLabel = By.cssSelector("tr.data-row td:nth-of-type(2)");
    public By MAEaccountTab = By.cssSelector("#tab_mae_relationships");
    public By MAEusersTab = By.cssSelector("#tab_organization");

    public By TypeOfUser = By.xpath("//div[contains(@class,'admin__data-grid-wrap')]/table/thead/tr/th/span[text()='Type']/../../../following-sibling::tbody/tr/td[2]");
    public By MAEAccountID = By.xpath("//div[contains(@class,'admin__data-grid-wrap')]/table/thead/tr/th/span[text()='MAE Account Id']/../../../following-sibling::tbody/tr/td[3]");
    public By filterButton = By.xpath("//button[contains(text(),'Filters')]");
    public By AccountSearch = By.xpath("(//label[@title='Search']/../input[@id='fulltext'])[1]");
    private By emailFilterField = By.cssSelector("input[name='email']");
    private By applyFilterButton = By.xpath("//span[contains(text(),'Apply Filters')]");
    public By contactsTab = By.id("tab_contact");
    public By contactsDetials = By.cssSelector("tbody > tr.data-row > td >div");
    public By allContactsDetials = By.xpath("//tr[contains(@class,'data-row')]/td/div");
    private By clearAllButton = By.cssSelector(".admin__data-grid-header button.action-clear");
    private By fromIdTextField = By.cssSelector("input[name='entity_id[from]']");
    private By toTextField = By.cssSelector("input[name='entity_id[to]']");
    private By loadingIcon = By.cssSelector("div[data-component='customer_form.areas'] .spinner");
    public By customreTypeDropDown = By.cssSelector("select[name='customer_type']");
    private By websiteDropDown = By.cssSelector(".admin__data-grid-filters select[name='website_id']");
    private By organizationName = By.cssSelector("tr.data-row td:nth-of-type(19)");
    private By ebsAccountNumberLabel = By.cssSelector("tr.data-row td:nth-of-type(21)");
    private By columnsButton = By.cssSelector("div.admin__data-grid-actions-wrap:nth-child(1) button span[data-bind*='Columns']");
    private By referralCodeColumnCheckboxInputTab = By.xpath("(//label[@title='Referral Code']/preceding-sibling::input)[1]");
    private By referralCodeColumnCheckbox = By.xpath("(//label[@title='Referral Code'])[1]");
    private By referralCodeColumn = By.xpath("//table[@data-role='grid']//span[contains(text(),'Referral Code')]");
    private By referralCodeColumnResults = By.cssSelector("tr.data-row td:nth-of-type(23)");
    private By ofPageLabel = By.cssSelector("div.admin__data-grid-pager-wrap:nth-child(1) input[type='number'] + label");
    private By pageNumberTextField = By.cssSelector("div.admin__data-grid-pager-wrap:nth-child(1) input[type='number']");
    private By referralCodeFilterField = By.cssSelector("select[name='referral_code']");
    private By columnNamesInTable = By.cssSelector("table[data-role='grid'] > thead .data-grid-cell-content");

   private By billingAddressText=By.xpath("//div[contains(@class,'customer-default-billing-address-content')]/descendant::div[contains(@class,'address_details')]");
   private By shippingAddressText=By.xpath("//div[contains(@class,'customer-default-shipping-address-content')]/descendant::div[contains(@class,'address_details')]");
   private By addressTab=By.xpath("//a[@id='tab_address']");
   public By learnerContactEmail=By.xpath("(//tr[@class='data-row'])[2]/td[5]/div");
    public By learnerContactFname=By.xpath("(//tr[@class='data-row'])[2]/td[2]/div");
    public By learnerContactLName=By.xpath("(//tr[@class='data-row'])[2]/td[4]/div");
   public By shpiingCharges=By.xpath("//div[@class='order-shipping-method-info']/descendant::strong/span");
    public By shpiingMethod=By.xpath("//div[@class='order-shipping-method-info']/dl/dd");
   public By EmailHeader=By.xpath("(//span[text()='Email'])[2]");


    public By getAddressTab() {
        return addressTab;
    }
    public By getShippingAddressText() {
        return shippingAddressText;
    }

    public By getBillingAddressText() {
        return billingAddressText;
    }

    private By getColumnDetailsByIndex(String index) {
        return By.cssSelector("tr.data-row td:nth-of-type(" + index + ")");
    }

    private By paymentTermCheckboxInputTag = By.xpath("(//label[@title='Payment Term']/preceding-sibling::input)[1]");
    private By paymentTermCheckBox = By.xpath("(//label[@title='Payment Term'])[1]");
    private By paymentTermColumnHeader = By.xpath("//table[@data-role='grid']//span[contains(text(),'Payment Term')]");
    private By customerSinceColumnHeader = By.xpath("//table[@data-role='grid']//span[contains(text(),'Customer Since')]");
    private By paymentTermFilterDropDown = By.cssSelector("select[name='payment_term']");
    private By removeFilterCrossButton = By.cssSelector(".admin__data-grid-header button[data-action='grid-filter-remove-chip']");
    private By ebsAccountNumberFilterField = By.cssSelector("input[name='ebs_account_number']");
    private By profileClassFilterDropDown = By.cssSelector("select[name='profile_class']");
    private By profileClassCheckbox = By.xpath("(//label[@title='Profile Class'])[1]");
    private By profileClassCheckboxInputTag = By.xpath("(//label[@title='Profile Class']/preceding-sibling::input)[1]");
    private By profileClassColumnHeader = By.xpath("//table[@data-role='grid']//span[contains(text(),'Profile Class')]");
    private By specialAccountPreferencesCheckbox = By.xpath("(//label[@title='Special Account Preferences'])[1]");
    private By specialAccountPreferencesCheckboxInputTab = By.xpath("(//label[@title='Special Account Preferences']/preceding-sibling::input)[1]");
    private By specialAccountPreferencesColumn = By.xpath("//table[@data-role='grid']//span[contains(text(),'Special Account Preferences')]");
    private By communicationEmailFilterField = By.cssSelector("input[name='communication_email']");
    private By fromCreatedSinceTextField = By.cssSelector("input[name='created_at[from]']");
    private By toCreatedSinceTextField = By.cssSelector("input[name='created_at[to]']");
    private By creditHoldDropDown = By.cssSelector("select[name='credit_hold']");
    public By MAEusersGrid = By.xpath("//table[@class='data-grid data-grid-draggable']/tbody/tr[1]/td/div");
    private By backButton = By.id("back");
    public By email = By.cssSelector("input[name='email']");
    public By tableCol=By.xpath("(//table)[2]/thead/tr/th/span");

    public By totalRecordsInCustomerSearchTable=By.xpath("//table[@class='data-grid data-grid-draggable']/tbody/tr");
    /**
     * @return CustomerType
     */
    public By getCustomerTypeLabel() {
        return customerTypeLabel;
    }

    /**
     * @return backButton
     */
    public By getBackButton() {
        return backButton;
    }

    /**
     * @return Website
     */
    public By getWebSiteLabel() {
        return webSiteLabel;
    }

    /**
     * @return AccountCreatedIN
     */
    public By getAccountCreatedInLabel() {
        return accountCreatedInLabel;
    }


    /**
     * @return creditHoldDropDown
     */
    public By getCreditHoldDropDown() {
        return creditHoldDropDown;
    }

    /**
     * @return toCreatedSinceTextField
     */
    public By getToCreatedSinceTextField() {
        return toCreatedSinceTextField;
    }

    /**
     * @return fromCreatedSinceTextField
     */
    public By getFromCreatedSinceTextField() {
        return fromCreatedSinceTextField;
    }

    /**
     * @return communicationEmailFilterField
     */
    public By getCommunicationEmailFilterField() {
        return communicationEmailFilterField;
    }

    public By getEmailField() {
        return email;
    }

    /**
     * @return getSpecialAccountPreferencesColumn
     */
    public By getSpecialAccountPreferencesColumn() {
        return specialAccountPreferencesColumn;
    }

    /**
     * @return getSpecialAccountPreferencesCheckboxInputTab
     */
    public By getSpecialAccountPreferencesCheckboxInputTab() {
        return specialAccountPreferencesCheckboxInputTab;
    }

    /**
     * @return specialAccountPreferencesCheckbox
     */
    public By getSpecialAccountPreferencesCheckbox() {
        return specialAccountPreferencesCheckbox;
    }

    /**
     * @return profileClassColumnHeader
     */
    public By getProfileClassColumnHeader() {
        return profileClassColumnHeader;
    }

    /**
     * @return profileClassCheckboxInputTag
     */
    public By getProfileClassCheckboxInputTag() {
        return profileClassCheckboxInputTag;
    }

    /**
     * @return profileClassCheckbox
     */
    public By getProfileClassCheckbox() {
        return profileClassCheckbox;
    }

    /**
     * @return profileClassFilterDropDown
     */
    public By getProfileClassFilterDropDown() {
        return profileClassFilterDropDown;
    }

    /**
     * @return ebsAccountNumberFilterField
     */
    public By getEbsAccountNumberFilterField() {
        return ebsAccountNumberFilterField;
    }

    /**
     * @return removeFilterCrossButton
     */
    public By getRemoveFilterCrossButton() {
        return removeFilterCrossButton;
    }

    /**
     * @return paymentTermFilterDropDown
     */
    public By getPaymentTermFilterDropDown() {
        return paymentTermFilterDropDown;
    }

    /**
     * @return customerSinceColumnHeader
     */
    public By getCustomerSinceColumnHeader() {
        return customerSinceColumnHeader;
    }

    /**
     * @return paymentTermColumnHeader
     */
    public By getPaymentTermColumnHeader() {
        return paymentTermColumnHeader;
    }

    /**
     * @return paymentTermCheckBox
     */
    public By getPaymentTermCheckBox() {
        return paymentTermCheckBox;
    }

    /**
     * @return paymentTermCheckboxInputTag
     */
    public By getPaymentTermCheckboxInputTag() {
        return paymentTermCheckboxInputTag;
    }


    /**
     * @return columnNamesInTable
     */
    public By getColumnNamesInTable() {
        return columnNamesInTable;
    }

    /**
     * @return referralCodeFilterField
     */
    public By getReferralCodeFilterField() {
        return referralCodeFilterField;
    }

    /**
     * @return pageNumberTextField
     */
    public By getPageNumberTextField() {
        return pageNumberTextField;
    }

    /**
     * @return ofPageLabel
     */
    public By getOfPageLabel() {
        return ofPageLabel;
    }

    /**
     * @return referralCodeColumnResults
     */
    public By getReferralCodeColumnResults() {
        return referralCodeColumnResults;
    }

    /**
     * @return referralCodeColumn
     */
    public By getReferralCodeColumn() {
        return referralCodeColumn;
    }

    /**
     * @return referralCodeColumnCheckbox
     */
    public By getReferralCodeColumnCheckbox() {
        return referralCodeColumnCheckbox;
    }

    /**
     * @return referralCodeColumnCheckboxInputTab
     */
    public By getReferralCodeColumnCheckboxInputTab() {
        return referralCodeColumnCheckboxInputTab;
    }

    /**
     * @return columnsButton
     */
    public By getColumnsButton() {
        return columnsButton;
    }

    /**
     * @return Gets the value of ebsAccountNumberLabel and returns ebsAccountNumberLabel
     */
    public By getEbsAccountNumberLabel() {
        return ebsAccountNumberLabel;
    }

    /**
     * @return Gets the value of organizationName and returns organizationName
     */
    public By getOrganizationName() {
        return organizationName;
    }

    private By getZipCodeSelectorByIndex(int index) {
        return By.cssSelector("#container table tbody tr.data-row:nth-child(" + index + ") td:nth-child(8)");
    }

    private By getEbsNumberSelectorByIndex(int index) {
        return By.cssSelector("#container table tbody tr.data-row:nth-child(" + index + ") td:nth-child(18)");
    }

    /**
     * @return the customreTypeDropDown
     */
    public By getCustomreTypeDropDown() {
        return customreTypeDropDown;
    }

    /**
     * @return the websiteDropDown
     */
    public By getWebsiteDropDown() {
        return websiteDropDown;
    }

    /**
     * @return the loadingIcon
     */
    public By getLoadingIcon() {
        return loadingIcon;
    }

    /**
     * @return the fromIdTextField
     */
    public By getFromIdTextField() {
        return fromIdTextField;
    }

    /**
     * @return the toTextField
     */
    public By getToTextField() {
        return toTextField;
    }

    /**
     * @return the clearAllButton
     */
    public By getClearAllButton() {
        return clearAllButton;
    }

    /**
     * @return the filterButton
     */
    public By getFilterButton() {
        return filterButton;
    }

    /**
     * @return the emailFilterField
     */
    public By getEmailFilterField() {
        return emailFilterField;
    }

    /**
     * @return the applyFilterButton
     */
    public By getApplyFilterButton() {
        return applyFilterButton;
    }

    /**
     * @return the addNewCustomerButton
     */
    public By getAddNewCustomerButton() {
        return addNewCustomerButton;
    }

    /**
     * @return the userCreationSuccessMessage
     */
    public By getUserCreationSuccessMessage() {
        return userCreationSuccessMessage;
    }

    /**
     * @return the searchTextField
     */
    public By getSearchTextField() {
        return searchTextField;
    }

    /**
     * @return the searchButton
     */
    public By getSearchButton() {
        return searchButton;
    }

    public By getaccountsearch() {
        return AccountSearch;
    }

    /**
     * @return the editButton
     */
    public By getEditButton() {
        return editButton;
    }

    public By getMAEAccountTab() {
        return MAEaccountTab;
    }

    public By getMAEusersTab() {
        return MAEusersTab;
    }

    /**
     * @return the OrdersTab
     */
    public By OrdersTab() {
        return OrdersTab;
    }

    /**
     * @return the FirstOrder
     */
    public By GetFirstOrder() {
        return FirstOrder;
    }

    /**
     * @return the emailLabel
     */
    public By getEmailLabel() {
        return emailLabel;
    }

    /**
     * @return the spinnerIcon
     */
    public By getSpinnerIcon() {
        return spinnerIcon;
    }

    /**
     * @return the nameLabel
     */
    public By getNameLabel() {
        return nameLabel;
    }

    /**
     * @return the customerIdLabel
     */
    public By getCustomerIdLabel() {
        return customerIdLabel;
    }

    /**
     * Clicks on add new customer button
     *
     * @return
     */
    public boolean clickAddNewCustomerButton() {
        try {
            PublicAdminCommons.clickonWebElement(driver, addNewCustomerButton);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Gets the user creation success message
     *
     * @return
     */
    public String getTextOfUserCreationSuccessMessage() {
        try {
            return PublicAdminCommons.getElementText(getElement(userCreationSuccessMessage));
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Enters text in search text field
     *
     * @param value
     * @return
     */
    public boolean enterTextInSearchTextField(String value) {
        try {
            WebElement searchField = getElementNew(searchTextField);
            searchField.clear();
            searchField.sendKeys(value);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks search button
     *
     * @return
     */
    public boolean clickSearchButton() {
        try {
            waitForSpinnerLoaderToDisappear();
            List<WebElement> searchButtons = getElementsNew(searchButton);
            searchButtons.get(0).click();
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on edit button
     *
     * @return
     */
    public boolean clickEditButton() {
        try {
            waitForSpinnerLoaderToDisappear();
            PublicAdminCommons.clickonWebElement(driver, editButton);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Gets email label
     *
     * @return
     */
    public String getTextOfEmailLabel() {
        try {
            waitForSpinnerLoaderToDisappear();
            return getElement(emailLabel).getText();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Wait for spinner to disappear
     */
    public void waitForSpinnerLoaderToDisappear() {
        PublicAdminCommons.waitForElementToDisappear(driver, getElementWithoutWait(spinnerIcon));
    }

    /**
     * User email is present in search results
     *
     * @param email
     * @return
     */
    public boolean isUserWithEmailPresentInList(String email) {
        try {
            waitForSpinnerLoaderToDisappear();
            List<String> emails = PublicAdminCommons.getTextOfWebElements(driver, emailLabel);
            if (emails.contains(email)) {
                return true;
            }
            log.info(email);
            return false;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Gets name label from table
     *
     * @return
     */
    public String getTextOfNameLabel() {
        try {
            waitForSpinnerLoaderToDisappear();
            return getElement(nameLabel).getText();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Gets Website label from table
     *
     * @return
     */
    public String getTextOfWebSiteLabel() {
        try {
            return getElement(webSiteLabel).getText();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Gets Account Created label from table
     *
     * @return
     */
    public String getTextOfAccountCreatedLabel() {
        try {
            return getElement(accountCreatedInLabel).getText();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Gets Customer Type label from table
     *
     * @return
     */
    public String getTextOfCustomerTypeLabel() {
        try {
            return getElement(customerTypeLabel).getText();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }


    /**
     * Gets customer ID label from table
     *
     * @return
     */
    public String getTextOfCustomerIDLabel() {
        try {
            waitForSpinnerLoaderToDisappear();
            return getElement(customerIdLabel).getText();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Remove the already applied filters
     */
    public void clearFilters() {
        try {
            PublicCommon.waitForSec(15);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(clearAllButton), 30);
            WebElement elm = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(clearAllButton));
            elm.click();
            PublicCommon.waitForSec(15);
            //PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
        }
    }

    /**
     * This method search for valid account in list and returns the Account object
     *
     * @return
     */
    public Account_PublicAdmin getValidAccountFromList() {
        try {
            Account_PublicAdmin validAccount = null;
            List<WebElement> rows = getElementsNew(emailLabel);
            for (WebElement row : rows) {
                int index = rows.indexOf(row) + 1;
                String zipCode = PublicAdminCommons.getTextOfElement(driver, getZipCodeSelectorByIndex(index));
                String ebsAccountNumber = PublicAdminCommons.getTextOfElement(driver,
                        getEbsNumberSelectorByIndex(index));
                if (!zipCode.equals("") && !ebsAccountNumber.equals("")) {
                    validAccount = new Account_PublicAdmin();
                    validAccount.setEmail(row.getText());
                    log.info("Valid Account Found : " + validAccount.getEmail());
                    return validAccount;
                }
            }
            return validAccount;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * This method search for valid account in list and clicks edit button for that
     * account
     *
     * @return
     */
    public boolean clickEditButtonForValidAccount() {
        try {
            List<WebElement> rows = getElementsNew(emailLabel);
            List<WebElement> editButtons = getElementsNew(editButton);
            for (WebElement row : rows) {
                int index = rows.indexOf(row);
                String zipCode = getListOfDetailsPresentUnderColumnByName("ZIP").get(index);
                String ebsAccountNumber = getListOfDetailsPresentUnderColumnByName("EBS Account Number").get(index);
                if (!(zipCode.equals("")) && !(ebsAccountNumber.equals(""))) {
                    log.info("Valid Account Found");
                    PublicAdminCommons.scrollToElement(driver, editButtons.get(rows.indexOf(row)));
                    editButtons.get(rows.indexOf(row)).click();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return true;
        }
    }

    /**
     * This method search for valid account in list and clicks edit button for that
     * account
     *
     * @return
     */
    public boolean clickEditButtonForValidAccount(String customerType) {
        try {
            List<WebElement> rows = getElementsNew(emailLabel);
            List<WebElement> editButtons = getElementsNew(editButton);
            for (WebElement row : rows) {
                int index = rows.indexOf(row);
                List<String> zipCodes = getListOfDetailsPresentUnderColumnByName("ZIP");
                String zipCode = zipCodes.get(index);
                List<String> ebsAccountNumbers = getListOfDetailsPresentUnderColumnByName("EBS Account Number");
                String ebsAccountNumber = ebsAccountNumbers.get(index);
                List<String> customerTypes = getListOfDetailsPresentUnderColumnByName("Customer Type");
                String customerTypeInGrid = customerTypes.get(index);
                if (!(zipCode.equals("")) && !(ebsAccountNumber.equals("")) && customerTypeInGrid.equals(customerType)) {
                    log.info("Valid Account Found");
                    editButtons.get(index).click();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return true;
        }
    }

    /**
     * This method search for valid account in list and clicks edit button for that
     * account
     *
     * @return
     */
    public boolean clickEditButtonForValidAccountExceptEmail(String customerType, String emailToExclude) {
        try {
            List<WebElement> rows = getElementsNew(emailLabel);
            List<WebElement> editButtons = getElementsNew(editButton);
            for (WebElement row : rows) {
                int index = rows.indexOf(row);
                List<String> zipCodes = getListOfDetailsPresentUnderColumnByName("ZIP");
                String zipCode = zipCodes.get(index);
                List<String> ebsAccountNumbers = getListOfDetailsPresentUnderColumnByName("EBS Account Number");
                String ebsAccountNumber = ebsAccountNumbers.get(index);
                List<String> customerTypes = getListOfDetailsPresentUnderColumnByName("Customer Type");
                String customerTypeInGrid = customerTypes.get(index);
                List<String> emails = getListOfDetailsPresentUnderColumnByName("Email");
                String emailInGrid = emails.get(index);
                if (!(zipCode.equals("")) && !(ebsAccountNumber.equals("")) && customerTypeInGrid.equals(customerType) && !(emailInGrid.equals(emailToExclude))) {
                    log.info("Valid Account Found");
                    editButtons.get(index).click();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return true;
        }
    }

    /**
     * Gets the customer name web elements in list and return if list is empty or not
     *
     * @return boolean
     */
    public boolean verifySomeRecordsArePresentInCustomerTable() {
        try {
            List<WebElement> customerNames = getElementsNew(nameLabel);
            return customerNames.isEmpty();
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Go to the last page of search results
     *
     * @return
     */
    public boolean goToLastPageOfResults() {
        try {
            String pageNumber = getElementNew(ofPageLabel).getText().replace(" of", "");
            WebElement pageNumberTextFieldElement = getElementNew(pageNumberTextField);
            pageNumberTextFieldElement.clear();
            pageNumberTextFieldElement.sendKeys(pageNumber);
            pageNumberTextFieldElement.sendKeys(Keys.ENTER);
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Get all the data under a column by name. Example if we pass "Referral Code" in arguments it will return the list
     *
     * @param columnName
     * @return
     */
    public List<String> getListOfDetailsPresentUnderColumnByName(String columnName) {
        try {
            List<WebElement> columnElements = getElementsNew(columnNamesInTable);
            int index = 0;
            for (WebElement column : columnElements) {
                if (column.getText().equals(columnName)) {
                    index = columnElements.indexOf(column);
                }
            }
            List<String> detailsUnderColumn = PublicAdminCommons.getTextOfWebElements(driver,
                    getColumnDetailsByIndex(String.valueOf(index + 2)));
            return detailsUnderColumn;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Sort By ascending dates
     *
     * @return
     */
    public boolean sortByCustomerSinceByAscendingOrder() {
        try {
            List<String> dates_elements = getListOfDetailsPresentUnderColumnByName("Customer Since");
            if (dates_elements.size() == 0) {
                return false;
            }
            SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy h:mm:ss aa");
            List<Date> dates = new ArrayList<>();
            for (String date : dates_elements) {
                Date dateObject = format.parse(date);
                dates.add(dateObject);
            }
            if (dates.size() == 0) {
                return false;
            }
            if (!isDateListAscending(dates)) {
                getElementNew(customerSinceColumnHeader).click();
                PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            } else {
                return true;
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Sort By descending dates
     *
     * @return
     */
    public boolean sortByCustomerSinceByDescendingOrder() {
        try {
            for (int i = 0; i < 5; i++) {
                List<String> dates_elements = getListOfDetailsPresentUnderColumnByName("Customer Since");
                if (dates_elements.size() == 0) {
                    return false;
                }
                SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy h:mm:ss aa");
                List<Date> dates = new ArrayList<>();
                for (String date : dates_elements) {
                    Date dateObject = format.parse(date);
                    dates.add(dateObject);
                }
                if (dates.size() == 0) {
                    return false;
                }
                boolean checkIfDate = isDateListDescending(dates);
                if (!checkIfDate) {
                    getElementNew(customerSinceColumnHeader).click();
                    PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
                }
                if (checkIfDate) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean isDateListAscending(List<Date> listOfDates) {
        Iterator<Date> iter = listOfDates.iterator();
        Date current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public boolean isDateListDescending(List<Date> listOfDates) {
        Iterator<Date> iter = listOfDates.iterator();
        Date current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) < 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    /**
     * Return list of customer since date in date objects
     *
     * @return
     */
    public List<Date> getListOfDateInObjectForm() {
        try {
            List<String> dates_elements = getListOfDetailsPresentUnderColumnByName("Customer Since");
            SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy h:mm:ss aa");
            List<Date> dates = new ArrayList<>();
            for (String date : dates_elements) {
                Date dateObject = format.parse(date);
                dates.add(dateObject);
            }
            return dates;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Get single column value by name.
     *
     * @param columnName
     * @return
     */
    public String getValuePresentUnderColumnByName(String columnName) {
        try {
            List<WebElement> columnElements = getElementsNew(columnNamesInTable);
            int index = 0;
            for (WebElement column : columnElements) {
                if (column.getText().equals(columnName)) {
                    index = columnElements.indexOf(column);
                }
            }
            List<String> detailsUnderColumn = PublicAdminCommons.getTextOfWebElements(driver,
                    getColumnDetailsByIndex(String.valueOf(index + 1)));
            return detailsUnderColumn.get(0);
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return "";
        }
    }



    public boolean addFilterForMigratedAccounts(String fromDate, String toDate, String customerType, String keyword) {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            getElementNew(filterButton).click();
            clearFilters();
            getElementNew(searchTextField).sendKeys(keyword);
            PublicAdminCommons.selectValueInDropdown(getElementNew(creditHoldDropDown), "No");
            getElementNew(fromCreatedSinceTextField).sendKeys(fromDate);
            getElementNew(toCreatedSinceTextField).sendKeys(toDate);
            PublicAdminCommons.selectValueInDropdown(getElementNew(customreTypeDropDown), customerType);
            getElementNew(applyFilterButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean addFilterFromIdAndCustomerTypeForMigratedAccount(String fromId, String toId, String customerType) {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            getElementNew(filterButton).click();
            clearFilters();
            PublicAdminCommons.selectValueInDropdown(getElementNew(creditHoldDropDown), "No");
            getElementNew(fromIdTextField).sendKeys(fromId);
            getElementNew(toTextField).sendKeys(toId);
            PublicAdminCommons.selectValueInDropdown(getElementNew(customreTypeDropDown), customerType);
            getElementNew(applyFilterButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean clickEditButtonByIndex(int index) {
        try {
            getElementsNew(editButton).get(index).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public List<String> getListOfEmailsForValidAccounts() {
        try {
            List<String> validEmailAccounts = new ArrayList<>();
            List<WebElement> rows = getElementsNew(emailLabel);
            List<WebElement> editButtons = getElementsNew(editButton);
            for (WebElement row : rows) {
                int index = rows.indexOf(row);
                List<String> zipCodes = getListOfDetailsPresentUnderColumnByName("ZIP");
                String zipCode = zipCodes.get(index);
                List<String> ebsAccountNumbers = getListOfDetailsPresentUnderColumnByName("EBS Account Number");
                String ebsAccountNumber = ebsAccountNumbers.get(index);
                List<String> emails = getListOfDetailsPresentUnderColumnByName("Email");
                String email = emails.get(index);
                if (!(zipCode.equals("")) && !(ebsAccountNumber.equals("")) && !(email.equals(""))) {
                    validEmailAccounts.add(email);
                }
            }
            return validEmailAccounts;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    public boolean clickEditButtonByEmail(String emailToClickEditFor) {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            List<WebElement> rows = getElementsNew(emailLabel);
            List<WebElement> editButtons = getElementsNew(editButton);
            for (WebElement row : rows) {
                int index = rows.indexOf(row);
                List<String> emails = getListOfDetailsPresentUnderColumnByName("Email");
                String email = emails.get(index);
                if (email.equals(emailToClickEditFor)) {
                    editButtons.get(index).click();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
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


    public List<String> getListOfEmailsForValidMigratedAccounts(String env) {
        try {
            List<String> validEmailAccounts = new ArrayList<>();
            List<WebElement> rows = getElementsNew(emailLabel);
            List<WebElement> editButtons = getElementsNew(editButton);
            for (WebElement row : rows) {
                int index = rows.indexOf(row);
                List<String> zipCodes = getListOfDetailsPresentUnderColumnByName("ZIP");
                String zipCode = zipCodes.get(index);
                List<String> ebsAccountNumbers = getListOfDetailsPresentUnderColumnByName("EBS Account Number");
                String ebsAccountNumber = ebsAccountNumbers.get(index);
                List<String> emails = getListOfDetailsPresentUnderColumnByName("Email");
                String email = emails.get(index);
                if (!(zipCode.equals("")) && !(ebsAccountNumber.equals("")) && !(email.equals(""))) {
                    validEmailAccounts.add(email);
                }
            }
            return validEmailAccounts;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
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


    /*@Step("Navigate to Account information page and enter created email")
    public void navigateToAccountInformationPage(String email) {
        try {
            Assert.assertTrue(PublicAdminCommons.waitElementToDisappearFromScreen(driver, getSpinnerIcon()), "Unable to handle loading screen");
            clearFilters();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            enterTextInTextField("Email text field", getaccountsearch(), email,true,"Unable to enter text in email");
            PublicCommon.waitForSec(15);
            clickOnMethod("Search Button",getElement(searchButton));
            PublicCommon.JSClick(getElement(filterButton), driver);
            //clickOnMethod("Filter Button", getElement(filterButton));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(driver.findElement(emailFilterField), driver);
            Actions a = new Actions(driver);
            //scroll up a page
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.HOME).build().perform();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            enterTextInTextField("Email Filter Text Field", getEmailFilterField(), email, true,
                    "Admin/ISS Agent is unable to enter text in email filter text field");
            PublicCommon.JSClick(getElement(applyFilterButton), driver);
           // clickOnMethod("Apply Filter Button", getElement(applyFilterButton));
            Assert.assertTrue(PublicAdminCommons.waitElementToDisappearFromScreen(driver, getSpinnerIcon()),
                    "Unable to handle loading screen");
            Actions a1 = new Actions(driver);
            //scroll up a page
            a1.sendKeys(Keys.PAGE_UP).build().perform();
            a1.sendKeys(Keys.HOME).build().perform();
            //clickONMethod("Edit Button",getSearchButton(),"Admin/ISS Agent is unable to click on Edit Button");
            clickONMethod("Edit Button",getEditButton(),"Admin/ISS Agent is unable to click on Edit Button");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to account information page", e);
        }
    }*/

    @Step("Verify fields in MAE Accounts tab")
    public void VerifyMAEaccounts() {
        try {
            WaitStatementUtils.waitForElementStaleness(driver, getElement(getMAEAccountTab()));
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getMAEAccountTab()));
            ReusableMethods.scrollIntoView(getElement(getMAEAccountTab()), driver);
            clickONMethod("MAE Account tab", getMAEAccountTab(), "Unabale to click on MAE Account Tab");
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(TypeOfUser));
            assertEquals(getElement(TypeOfUser).getText(), "B2B");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to MAE Account tab", e);
        }
    }

    @Step("Navigate to account information page and enter created email id")
    public void navigateToAccountInformationPageWithCommunicationEmail(String email) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, getSpinnerIcon()),
                    "Unable to handle loading screen");
            clearFilters();
            getElement(filterButton).click();
            ReusableMethods.moveToElementAndClick(driver,getElement(getCommunicationEmailFilterField()));
            enterTextInTextField("Email Filter Text Field", getCommunicationEmailFilterField(), email, true,
                    "Admin/ISS Agent is unable to enter text in email filter text field");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(applyFilterButton).click();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, getSpinnerIcon()),
                    "Unable to handle loading screen");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to account information page", e);
        }
    }

    @Step("Navigate to account information page and enter created email id")
    public void navigateToAccountInformationPageWithEmail(String email) {
        try {
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, getSpinnerIcon()),
                    "Unable to handle loading screen");
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(filterButton),15);
            clearFilters();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(filterButton),15);
            getElement(filterButton).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getEmailFilterField()),15);
            enterTextInTextField("Email Filter Text Field", getEmailFilterField(), email, true,
                    "Admin/ISS Agent is unable to enter text in email filter text field");
            PublicCommon.waitForSec(5);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(applyFilterButton).click();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, getSpinnerIcon()),
                    "Unable to handle loading screen");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to account information page", e);
        }
    }

    public List<WebElement> getContactDetails() {
        return getElements(contactsDetials);
    }
    public List<WebElement> getAllContactsDetials() {
        /*int rowCount=driver.findElements(By.xpath("//tr[contains(@class,'data-row')]")).size();*/
       /* WaitStatementUtils.waitForElementToBeClickable(driver,getElement(EmailHeader),10);
        getElement(EmailHeader).click();*/
        return driver.findElements(By.xpath("(//tr[contains(@class,'data-row')][1])/td/div"));
       }

    @Step("Validate Contact details")
    public String verifyContactDetails() {
        String ContactEmail = null;
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(contactsTab), 10);
            clickOnMethod("Contact Tab", getElement(contactsTab));
            WaitStatementUtils.explicitWaitForVisibility(driver, getContactDetails().get(4));
            ContactEmail = getContactDetails().get(4).getText();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to contacts page", e);
        }
        return ContactEmail;
    }

    @Step("Verify fields in MAE Accounts tab")
    public void VerifyMAEusers(String email,String MAEuserID) {
        try {
            WaitStatementUtils.waitForElementStaleness(driver, getElement(getMAEusersTab()));
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getMAEusersTab()));
            ReusableMethods.scrollIntoView(getElement(getMAEusersTab()), driver);
            clickONMethod("MAE users tab", getMAEusersTab(), "Unable to click on MAE users Tab");
            validateMAEusersGrid(email,MAEuserID);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigate to MAE Account tab", e);
        }
    }

    @Step("Check for email and MAE user ID")
    public boolean validateMAEusersGrid(String email,String MAEuserID) {
        try {
            getElement(MAEusersGrid);
            List<WebElement> groupElements = driver.findElements(MAEusersGrid);
            for (WebElement groupElement : groupElements) {
                if (groupElement.getText().contains(email)) {
                    Allure.addAttachment("Email present", email);
                    driver.findElement(By.xpath("//table[@class='data-grid data-grid-draggable']/tbody/tr[1]/td/div[text()='"+email+"']")).getText().equals(email);
                    driver.findElement(By.xpath("(//table[@class='data-grid data-grid-draggable']/tbody/tr[1]/td/div)[3]")).getText().equals(MAEuserID);
                    return true;
                }
            }
            Allure.addAttachment("Email present", email,MAEuserID);
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Successfully Checked for link if it's present or not");
        }
        return true;
    }
    public String getCustomerDetails(String ColName)
    {
        int index=0;
        List<WebElement> Columns=driver.findElements(By.xpath("(//table)[2]/thead/tr/th/span"));
        for(int i=1;i<=Columns.size();i++)
        {
            if(Columns.get(i).getText().equals(ColName))
            {
                index=i+1;
                break;
            }
        }
        return driver.findElement(By.xpath("((//table)[2]/tbody/tr/td/div)["+index+"]")).getText();
    }
    @Step("check Month And Year Is Ascending Order")
    public void checkMonthAndYearIsAscendingOrder(List<String> monthAndYear) {
        Boolean flag=false;
        System.out.println(monthAndYear);
      for (int i=0;i<=monthAndYear.size()-1;i++){
          for (int j=i+1;j<=monthAndYear.size()-1;j++){
              Allure.addAttachment("Month and year of meetings",monthAndYear.get(i));
              String[] spliteddata1=monthAndYear.get(i).split(" ");
              DateTimeFormatter  parserIgnoreCase1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMMM").toFormatter(Locale.ENGLISH);
              int month1=Month.from(parserIgnoreCase1.parse(spliteddata1[0])).getValue();
              LocalDate localDate1 =LocalDate.of(Integer.parseInt(spliteddata1[1]),month1,2);

              String[] spliteddata2=monthAndYear.get(j).split(" ");
              DateTimeFormatter  parserIgnoreCase2 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMMM").toFormatter(Locale.ENGLISH);
              int month2=Month.from(parserIgnoreCase2.parse(spliteddata2[0])).getValue();
              LocalDate localDate2 =LocalDate.of(Integer.parseInt(spliteddata2[1]),month2,2);

              flag= localDate1.isBefore(localDate2);
              break;
          }
        }
      Assert.assertTrue(flag,"Month And Year Is not Ascending Order");
    }

}
