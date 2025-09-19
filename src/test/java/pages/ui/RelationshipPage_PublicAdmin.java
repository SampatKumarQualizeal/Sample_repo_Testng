package pages.ui;

import com.astm.commonFunctions.PublicAdminCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class RelationshipPage_PublicAdmin extends BasePage {

	public RelationshipPage_PublicAdmin(WebDriver driver) {
		super(driver);
	}

	private By spinnerIcon = By.cssSelector("div[data-component*='customer_relationship_listing'] div.spinner");
	private By columnHeaderRelationship = By.xpath("//table//span[contains(text(), 'Relationship Type')]");
	private By columnHeaderName = By.xpath("//table//span[contains(text(), 'Name')]");
	private By columnHeaderEmail = By.xpath("//table//span[contains(text(), 'Email')]");
	private By columnHeaderActive = By.xpath("//table//span[contains(text(), 'Active')]");
	private By columnHeaderStartDate = By.xpath("//table//span[contains(text(), 'Start Date')]");
	private By columnHeaderEndDate = By.xpath("//table//span[contains(text(), 'End Date')]");
	private By columnHeaderAction = By.xpath("//table//span[contains(text(), 'Action')]");
	private By addNewRelationshipButton = By.cssSelector("button.add-new-relationship-button");
	private By editButton = By.cssSelector("div[data-bind*='customer_relationship_listing'] a.action-menu-item");
	private By emailColumn = By
			.cssSelector("div[data-bind*='customer_relationship_listing'] table tbody tr.data-row td:nth-of-type(3)>div");
	private By addNewCorporateRelationshipButton = By.cssSelector("button.add-corporate-billing-relationship-button");
	private By relationTypeColumn = By
			.cssSelector("div[data-bind*='customer_relationship_listing'] table tbody tr.data-row td:nth-of-type(1)");
	private By nameColumn = By
			.cssSelector("div[data-bind*='customer_relationship_listing'] table tbody tr.data-row td:nth-of-type(2)");
	private By activeColumn = By
			.cssSelector("div[data-bind*='customer_relationship_listing'] table tbody tr.data-row td:nth-of-type(4)");
	private By startDateColumn = By
			.cssSelector("div[data-bind*='customer_relationship_listing'] table tbody tr.data-row td:nth-of-type(5)");
	private By endDateColumn = By
			.cssSelector("div[data-bind*='customer_relationship_listing'] table tbody tr.data-row td:nth-of-type(6)");

	private By nameWithAnchorLink = By.cssSelector("div[data-bind*='customer_relationship_listing'] table tbody tr.data-row td:nth-of-type(2) a");
	private By columnNamesInTable = By.cssSelector("table[data-role='grid'] > thead .data-grid-cell-content");

	private By getColumnDetailsByIndex(String index) {
		return By.cssSelector("tr.data-row td:nth-of-type(" + index + ")");
	}

	/**
	* @return nameWithAnchorLink
	*/
	public By getNameWithAnchorLink(){
	    return nameWithAnchorLink;
	}

	/**
	 * @return Gets the value of relationTypeColumn and returns relationTypeColumn
	 */
	public By getRelationTypeColumn() {
		return relationTypeColumn;
	}

	/**
	 * @return addNewCorporateRelationshipButton
	 */
	public By getAddNewCorporateRelationshipButton() {
		return addNewCorporateRelationshipButton;
	}

	/**
	 * @return the editButton
	 */
	public By getEditButton() {
		return editButton;
	}

	/**
	 * @return the emailColumn
	 */
	public By getEmailColumn() {
		return emailColumn;
	}

	/**
	 * @return the columnHeaderRelationship
	 */
	public By getColumnHeaderRelationship() {
		return columnHeaderRelationship;
	}

	/**
	 * @return the columnHeaderName
	 */
	public By getColumnHeaderName() {
		return columnHeaderName;
	}

	/**
	 * @return the columnHeaderEmail
	 */
	public By getColumnHeaderEmail() {
		return columnHeaderEmail;
	}

	/**
	 * @return the columnHeaderActive
	 */
	public By getColumnHeaderActive() {
		return columnHeaderActive;
	}

	/**
	 * @return the columnHeaderStartDate
	 */
	public By getColumnHeaderStartDate() {
		return columnHeaderStartDate;
	}

	/**
	 * @return the columnHeaderEndDate
	 */
	public By getColumnHeaderEndDate() {
		return columnHeaderEndDate;
	}

	/**
	 * @return the columnHeaderAction
	 */
	public By getColumnHeaderAction() {
		return columnHeaderAction;
	}

	/**
	 * @return the addNewRelationshipButton
	 */
	public By getAddNewRelationshipButton() {
		return addNewRelationshipButton;
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
	 * 
	 * @param index
	 * @return
	 */

	public boolean clickOnEditButtonByIndex(int index) {
		try {
			List<WebElement> editButtons = getElementsNew(editButton);
			editButtons.get(index).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	 * Returns hashmap with details of relationship
	 *
	 * @param email
	 * @return
	 */
	public HashMap<String, Object> getRelationDetailsByEmail(String email){
		try{
			HashMap<String, Object> detailsMap = new HashMap<String, Object>();
			List<WebElement> rows = getElementsNew(emailColumn);
			for(WebElement row : rows){
				if (row.getText().equals(email)){
					int index = rows.indexOf(row);
					detailsMap.put("email", email);
					detailsMap.put("relationType", getListOfDetailsPresentUnderColumnByName("Relationship Type").get(index));
					detailsMap.put("name", getListOfDetailsPresentUnderColumnByName("Name").get(index));
					detailsMap.put("active", returnTrueIfYesAndFalseIfNo(getListOfDetailsPresentUnderColumnByName("Active").get(index)));
					detailsMap.put("startDate",getListOfDetailsPresentUnderColumnByName("Start Date").get(index));
					detailsMap.put("endDate", getListOfDetailsPresentUnderColumnByName("End Date").get(index));
					return detailsMap;
				}
			}
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Clicks on edit button by index
	 *
	 *
	 * @return
	 */

	public boolean clickOnEditButtonForLastRelationship() {
		try {
			List<WebElement> editButtons = getElementsNew(editButton);
			editButtons.get(editButtons.size() - 1).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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
					getColumnDetailsByIndex(String.valueOf(index + 1)));
			return detailsUnderColumn;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return null;
		}
	}
}
