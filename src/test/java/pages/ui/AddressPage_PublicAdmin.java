package pages.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicAdminCommons;

import base.utils.WaitStatementUtils;
import testobjects.Address_PublicAdmin;

public class AddressPage_PublicAdmin extends BasePage {

	static Logger log = Logger.getLogger(AddressPage_PublicAdmin.class.getName());

	public AddressPage_PublicAdmin(WebDriver driver) {
		super(driver);
	}

	private By accountInformationButton = By.cssSelector(".admin__page-nav-items li:nth-of-type(2)");
	private By spinnerIcon = By.cssSelector("div[data-component*='customer_address_listing'] div.spinner");
	private By addNewAddressButton = By.cssSelector("button.add-new-address-button");
	private By saveAndEditCustomer = By.cssSelector("button[title='Save and Continue Edit']");
	private By saveCustomerButton = By.cssSelector("button[title='Save Customer']");
	private By addressTabActive = By.cssSelector("li._active #tab_address");
	private By addressTab = By.cssSelector("#tab_address");
	private By defaultBillingAddress = By.cssSelector(".customer-default-billing-address-content .address_details");
	private By defaultShippingAddress = By.cssSelector(".customer-default-shipping-address-content .address_details");
	private By defaultFrieghtForwardAddress = By
			.cssSelector(".customer-default-freight-forward-address-content .address_details");
	private By saveAndContinueEdit = By.cssSelector("button#save_and_continue");
	private By selectButton = By.cssSelector("tr button.action-select");
	private By setAsDefaultBillingOption = By.cssSelector("ul.action-menu._active li:nth-of-type(2)");
	private By setAsDefaultShippingOption = By.cssSelector("ul.action-menu._active li:nth-of-type(3)");
	private By setAsDefaultFreightForwardOption = By.cssSelector("ul.action-menu._active li:nth-of-type(4)");
	private By OkAlertButton = By.cssSelector("button.action-primary.action-accept");
	private By loadingIcon = By.cssSelector("loading-mask");
	private By editButtonUnderTable = By.cssSelector("ul.action-menu._active li:nth-of-type(1) a");
	private By createOrderButton = By.cssSelector("button[title='Create Order']");
	private By newEditButtonUnderTable = By.cssSelector("a.action-menu-item");
	private By editButtonUnderDefaultBillingAddress = By.cssSelector("button.edit-default-billing-address-button");
	private By editButtonUnderDefaultShippingAddress = By.cssSelector("button.edit-default-shipping-address-button");
	private By editButtonUnderDefaultFreightForwardAddress = By.cssSelector("button.edit-default-freight-forward-address-button");
	private By columnNamesInTable = By.cssSelector("table[data-role='grid'] > thead .data-grid-cell-content");
	private By getColumnDetailsByIndex(String index){
		return By.cssSelector("tr.data-row td:nth-of-type("+index+")");
	}

	/**
	 * @return editButtonUnderDefaultFreightForwardAddress
	 */
	public By getEditButtonUnderDefaultFreightForwardAddress(){
		return editButtonUnderDefaultFreightForwardAddress;
	}

	/**
	* @return editButtonUnderDefaultShippingAddress
	*/
	public By getEditButtonUnderDefaultShippingAddress(){
	    return editButtonUnderDefaultShippingAddress;
	}

	/**
	 * @return editButtonUnderDefaultBillingAddress
	 */
	public By getEditButtonUnderDefaultBillingAddress(){
		return editButtonUnderDefaultBillingAddress;
	}

	/**
	* @return newEditButtonUnderTable
	*/
	public By getNewEditButtonUnderTable(){
	    return newEditButtonUnderTable;
	}

	/**
	 * @return the createOrderButton
	 */
	public By getCreateOrderButton() {
		return createOrderButton;
	}

	/**
	 * @return the editButtonUnderTable
	 */
	public By getEditButtonUnderTable() {
		return editButtonUnderTable;
	}

	/**
	 * @return the loadingIcon
	 */
	public By getLoadingIcon() {
		return loadingIcon;
	}

	/**
	 * @return the okAlertButton
	 */
	public By getOkAlertButton() {
		return OkAlertButton;
	}

	/**
	 * @return the selectButton
	 */
	public By getSelectButton() {
		return selectButton;
	}

	/**
	 * @return the setAsDefaultBillingOption
	 */
	public By getSetAsDefaultBillingOption() {
		return setAsDefaultBillingOption;
	}

	/**
	 * @return the setAsDefaultShippingOption
	 */
	public By getSetAsDefaultShippingOption() {
		return setAsDefaultShippingOption;
	}

	/**
	 * @return the setAsDefaultFreightForwardOption
	 */
	public By getSetAsDefaultFreightForwardOption() {
		return setAsDefaultFreightForwardOption;
	}

	/**
	 * @return the saveAndContinueEdit
	 */
	public By getSaveAndContinueEdit() {
		return saveAndContinueEdit;
	}

	/**
	 * @return the defaultBillingAddress
	 */
	public By getDefaultBillingAddress() {
		return defaultBillingAddress;
	}

	/**
	 * @return the defaultShippingAddress
	 */
	public By getDefaultShippingAddress() {
		return defaultShippingAddress;
	}

	/**
	 * @return the defaultFrieghtForwardAddress
	 */
	public By getDefaultFrieghtForwardAddress() {
		return defaultFrieghtForwardAddress;
	}

	/**
	 * @return the log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * @return the accountInformationButton
	 */
	public By getAccountInformationButton() {
		return accountInformationButton;
	}

	/**
	 * @return the spinnerIcon
	 */
	public By getSpinnerIcon() {
		return spinnerIcon;
	}

	/**
	 * @return the addNewAddressButton
	 */
	public By getAddNewAddressButton() {
		return addNewAddressButton;
	}

	/**
	 * @return the saveAndEditCustomer
	 */
	public By getSaveAndEditCustomer() {
		return saveAndEditCustomer;
	}

	/**
	 * @return the saveCustomerButton
	 */
	public By getSaveCustomerButton() {
		return saveCustomerButton;
	}

	/**
	 * @return the addressTabActive
	 */
	public By getAddressTabActive() {
		return addressTabActive;
	}

	/**
	 * @return the addressTab
	 */
	public By getAddressTab() {
		return addressTab;
	}

	/**
	 * Clicks account information button
	 * 
	 * @return
	 */
	public boolean clickAccountInformationButton() {
		try {
			getElementNew(accountInformationButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			log.info("Button", e);
			return false;
		}
	}

	/**
	 * Clicks on add address button
	 * 
	 * @return
	 */
	public boolean clickAddNewAddressButton() {
		try {
			waitForSpinnerLoaderToDisappear();
			getElementNew(addNewAddressButton).click();
			return true;
		} catch (Exception e) {
			log.info("Element", e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Clicks on save and edit customer button
	 * 
	 * @return
	 */
	public boolean clickSaveAndEditCustomerButton() {
		try {
			waitForSpinnerLoaderToDisappear();
			WaitStatementUtils.waitForElementToBeClickable(driver, getElementNew(saveAndEditCustomer));
			getElementNew(saveAndEditCustomer).click();
			return true;
		} catch (Exception e) {
			log.info("Element", e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Waits for spinner to disappear
	 * 
	 */
	public void waitForSpinnerLoaderToDisappear() {
		PublicAdminCommons.waitForElementToDisappear(driver, getElementWithoutWait(spinnerIcon));
	}

	/**
	 * Clicks on save customer button
	 * 
	 * @return
	 */
	public boolean clickSaveCustomerButton() {
		try {
			waitForSpinnerLoaderToDisappear();
			getElementNew(saveCustomerButton).click();
			return true;
		} catch (Exception e) {
			log.info("Element", e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Clicks on select button by index present in table
	 * 
	 * @param index
	 * @return
	 */
	public boolean clickOnSelectButtonByIndex(int index) {
		try {
			List<WebElement> selectButtons = getElementsNew(selectButton);
			PublicAdminCommons.scrollToElement(driver, selectButtons.get(index));
			PublicAdminCommons.waitForSec(1000);
			selectButtons.get(index).click();
			return true;
		} catch (Exception e) {
			log.info("Element", e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Clicks on edit button by index present in table
	 *
	 * @param index
	 * @return
	 */
	public boolean clickOnEditButtonByIndex(int index) {
		try {
			List<WebElement> editButton = getElementsNew(newEditButtonUnderTable);
			PublicAdminCommons.scrollToElement(driver, editButton.get(index));
			PublicAdminCommons.waitForSec(1000);
			editButton.get(index).click();
			return true;
		} catch (Exception e) {
			log.info("Element", e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 *
	 * Get single column value by name.
	 *
	 * @param columnName
	 * @return
	 */
	public String getValuePresentUnderColumnByName(String columnName, int indexToGet){
		try {
			List<WebElement> columnElements = getElementsNew(columnNamesInTable);
			int index = 0;
			for(WebElement column : columnElements){
				if(column.getText().equals(columnName)){
					index = columnElements.indexOf(column);
				}
			}
			List<String> detailsUnderColumn = PublicAdminCommons.getTextOfWebElements(driver,
					getColumnDetailsByIndex(String.valueOf(index+2)));
			return detailsUnderColumn.get(indexToGet);
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return "";
		}
	}

	public boolean checkIfNewAddressIsPresentUnderGridByIndex(Address_PublicAdmin addressObject, int indexToCheck) {
		try {
			String streetAddress = getValuePresentUnderColumnByName("Street Address", indexToCheck);
			String city = getValuePresentUnderColumnByName("City", indexToCheck);
			String country = getValuePresentUnderColumnByName("Country", indexToCheck);
			String state = getValuePresentUnderColumnByName("State", indexToCheck);
			String zipCode = getValuePresentUnderColumnByName("Zip/Postal Code", indexToCheck);
			String phone = getValuePresentUnderColumnByName("Phone", indexToCheck);
			if (!streetAddress.equals(addressObject.getStreetAddress()))
				return false;
			if (!city.equals(addressObject.getCity()))
				return false;
			if (!zipCode.equals(addressObject.getZipCode()))
				return false;
			if (!phone.equals(addressObject.getPhoneNumber()))
				return false;
			if (!country.equals(addressObject.getCountry()))
				return false;
			if(addressObject.getProvince() != null) {
				if (!state.equals(addressObject.getProvince()))
					return false;
			}
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}
}
