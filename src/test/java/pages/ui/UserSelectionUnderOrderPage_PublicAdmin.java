package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.astm.commonFunctions.PublicAdminCommons;

public class UserSelectionUnderOrderPage_PublicAdmin extends BasePage {

	public UserSelectionUnderOrderPage_PublicAdmin(WebDriver driver) {
		super(driver);
	}

	private By spinnerIcon = By.cssSelector(".popup-loading");
	private By nameSearchField = By.cssSelector("#sales_order_create_customer_grid_filter_name");
	private By searchButton = By.cssSelector("#sales_order_create_customer_grid button[title='Search']");
	private By firstNameFromSearchResults = By.xpath("(//td[@data-column='name'])[2]");
	private By emailSearchField = By.cssSelector("input[name='email']");
	private By idSearchField = By.cssSelector("#sales_order_create_customer_grid_filter_entity_id");
	private By emailColumn = By.cssSelector("tbody td[data-column='email']");
	private By noRecordFoundMessage = By.xpath("//td[contains(text(),\"We couldn't find any records.\")]");
	private By orgNameColumn = By.cssSelector("tbody .col-organization_name");
	private By signedUpPointColumn = By.cssSelector("tbody .col-store_name");
	private By websiteColumn = By.cssSelector("tbody .col-website_name");

	/**
	* @return websiteColumn
	*/
	public By getWebsiteColumn(){
	    return websiteColumn;
	}
	
	/**
	* @return signedUpPointColumn
	*/
	public By getSignedUpPointColumn(){
	    return signedUpPointColumn;
	}
	/**
	* @return orgNameColumn
	*/
	public By getOrgNameColumn(){
	    return orgNameColumn;
	}

	/**
	* @return noRecordFoundMessage
	*/
	public By getNoRecordFoundMessage(){
	    return noRecordFoundMessage;
	}

	/**
	* @return emailColumn
	*/
	public By getEmailColumn(){
	    return emailColumn;
	}

	/**
	 * @return the idSearchField
	 */
	public By getIdSearchField() {
		return idSearchField;
	}

	/**
	 * @return the emailSearchField
	 */
	public By getEmailSearchField() {
		return emailSearchField;
	}

	/**
	 * @return the spinnerIcon
	 */
	public By getSpinnerIcon() {
		return spinnerIcon;
	}

	/**
	 * @return the nameSearchField
	 */
	public By getNameSearchField() {
		return nameSearchField;
	}

	/**
	 * @return the searchButton
	 */
	public By getSearchButton() {
		return searchButton;
	}

	/**
	 * @return the firstNameFromSearchResults
	 */
	public By getFirstNameFromSearchResults() {
		return firstNameFromSearchResults;
	}

	/**
	 * 
	 * Wait for spinner loader to disappear
	 * 
	 */
	public void waitForSpinnerLoaderToDisappear() {
		PublicAdminCommons.waitForElementToDisappear(driver, getElementWithoutWait(spinnerIcon));
	}

	/**
	 * Enter text in name search field
	 * 
	 * 
	 **/
	public boolean enterTextInNameSearchField(String value) {
		try {
			getElementNew(nameSearchField).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Click search button
	 * 
	 * 
	 **/
	public boolean clickSearchButton() {
		try {
			PublicAdminCommons.waitForSec(5000);
			getElementNew(searchButton).click();
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Click first search result from name column
	 * 
	 * 
	 **/
	public boolean clickFirstNameFromSearchResults() {
		try {
			waitForSpinnerLoaderToDisappear();
			getElementNew(firstNameFromSearchResults).click();
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean waitForSearchResultsToBeClickable() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(firstNameFromSearchResults));
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}
}
