package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CustomerViewPage_PublicAdmin extends BasePage {
	CreateRelationship_PublicAdmin CreateRelationshipPage;
	RelationshipPage_PublicAdmin RelationshipListPage;
	MenuNavigationPage_PublicAdmin MenuNavigationPage;
	CommonPage_Public commonPage;

	public CustomerViewPage_PublicAdmin(WebDriver driver) {
		super(driver);
		CreateRelationshipPage = getInstance(CreateRelationship_PublicAdmin.class);
		RelationshipListPage = getInstance(RelationshipPage_PublicAdmin.class);
		MenuNavigationPage = getInstance(MenuNavigationPage_PublicAdmin.class);
		commonPage=getInstance(CommonPage_Public.class);
	}

	private By accountInformationButton = By.cssSelector("#tab_customer");
	private By spinnerIcon = By.cssSelector("div[data-component='customer_form.areas'] div.spinner");
	private By addressButton = By.cssSelector("#tab_address");
	private By contactsButton = By.cssSelector("#tab_contact");
	private By createOrderButton = By.cssSelector("button[title='Create Order']");
	private By relationshipButton = By.cssSelector("#tab_relationship");
	private By addNewRelationshipButton = By.cssSelector("button.add-new-relationship-button");
	private By startDateField = By.cssSelector("input[name='start_date']");
	private By endDateField = By.cssSelector("input[name='end_date']");


	public By getContactID() {
		return contactID;
	}

	public String getcontactID()
	{
		WebElement editButton=driver.findElement(By.xpath("(//a[text()='Edit'])[1]"));
		WaitStatementUtils.waitForElementToBeClickable(driver,editButton,10);
		CommonPage_Public.JSClick(editButton,driver);
		commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
		PublicCommon.waitForSec(10);

		ReusableMethods.scrollIntoView(getElement(getContactID()),driver);
		String contactId=getElement(getContactID()).getAttribute("value");
		return contactId;
	}
	private By contactID=By.cssSelector("input[name='ebs_contact_id']");
	private By accountInformationButtonForIncompleteAccount = By
			.xpath("//div[@class='admin__page-nav']//span[contains(text(),'Account Information')]");
	private By youSaveCustomerSuccessMessage = By.xpath("//div[contains(text(),'You saved the customer.')]");
	private By creditHoldPopupMessage = By.xpath("//div[contains(text(),'This account is on credit hold and you cannot place an order for the account at this time.')]");
	private By creditHoldPopupOkMessage = By.cssSelector("aside.modal-popup:nth-child(2) button:nth-child(1)");
	private By orderTab = By.cssSelector("#tab_orders_content");
	private By pageHeading = By.cssSelector("h1.page-title");
	private By specialHandlingHeadingFromDialogBox=By.xpath("//h1[contains(text(),'Special')]");
	private By accountRequiresMessageFromDialogBox=By.id("special_handling_modal");
	private By okButtonOnSpecialHandlingDialogBox=By.xpath("//h1[contains(text(),'Special')]//following::button[2]");
	private By closeSpecialHandlingDialogBox= By.xpath("//h1[contains(text(),'Special')]//following-sibling::button");
	private By accountCreatedInLabel = By.cssSelector(".admin__table-secondary tbody tr:nth-of-type(5) td:last-child");
	private By customerViewTab = By.cssSelector("a#tab_customer_edit_tab_view_content");
	
	public By addProductSKU= By.xpath("//span[ text()='Add Products By SKU']");
	public By addProductBtn = By.xpath("//span[ text()='Add Products']");
	public By addSKUNumber = By.xpath("//tbody[@id='sku_container']//td[@class='col-sku']//input");
	public By startDate = By.xpath("//*[contains(@name,'compass_start_date')]");
	public By publishDate = By.xpath("//*[contains(@name,'compass_publish_date')]");
	public By addproductQty = By.xpath("//tbody[@id='sku_container']//td[@class='col-qty']//input");
	public By addToOrderBtn = By.xpath("//div[@id='order-additional_area']//button[@title='Add to Order']");
	public By majorPromoCodeDropdown = By.xpath("//select[@id='promo-code-major']");
	public By minorPromoCodeDropdown = By.xpath("//select[@id='promo-code-minor']");
	public By salesChannelDropdown = By.xpath("//select[@id='sales-channel']");
	public By additionalInfoHeader = By.xpath("//div[@class='admin__page-section-title']//strong[text()='Additional Information']");
	public By submitOrderBtn = By.xpath("//button[@id='submit_order_top_button']");
	public By submitConfirmOKBtn = By.xpath("//button[@class='action-primary action-accept']");
	public By ebsDetailTable = By.xpath("//table[@class='admin__table-secondary order-information-table']//tr//td");
	public By ebsOrderStatus = By.xpath("//table//tr/th[contains(text(),'EBS Order Status')]/following-sibling::td/span");
	public By customerPageHeader = By.xpath("//div[@class='page-actions-inner']");
	public By configureMessage = By.xpath("//div[@class='message message-notice']");
	public By configureProductBtn = By.xpath("//button[@title='Configure']");
	public By productConfigureDropdwn= By.xpath("//select[@class='admin__control-select required-entry super-attribute-select']");
	public By languageConfigureDropdwn= By.xpath("(//select[@class='admin__control-select required-entry super-attribute-select'])[2]");

	public By configureOKBtn = By.xpath("//button[@class='action-primary']");
	public By addProductToOrder = By.xpath("//button[@title='Add Products to Order']");
	public By contactDropDown = By.xpath("//td[@class='col-contact']/select");
	public By updateItemsButton = By.xpath("//button[@title='Update Items and Quantities']");
	public By skuField = By.cssSelector("input#sales_order_create_search_grid_filter_sku");
	public By noDataMsge = By.xpath("//tr[@class='data-grid-tr-no-data even']/td");
	
	public By addNewContact = By.xpath("//span[text()='Add New Contact']");
	public By activeInputTag = By.xpath("(//input[@name='is_active'])[1]");

	public By TPTLearner = By.xpath("//fieldset[@class='admin__fieldset']/div[2]/div/div/label");
	public By billTo = By.xpath("//div[@class='admin__field'][2]/div[2]/div/label");
	public By shipTo = By.xpath("//div[@class='admin__field'][3]/div[2]/div/label");
	public By deliverTo = By.xpath("//div[@class='admin__field'][4]/div[2]/div/label/span");
	public By firstNameTxtInput=By.xpath("(//div[@class='admin__field-control']//input[@class='admin__control-text' and @type='text'])[1]");
	public By lastNameTxtInput=By.xpath("(//div[@class='admin__field-control']//input[@class='admin__control-text' and @type='text'])[2]");

	public By firstNameTextbox = By.xpath("//div[@id='modal-content-15']/div/div[1]/div/div[2]/div[2]/div/fieldset/div[6]/div[2]/input");
	public By middlwNameTextbox = By.xpath("//div[@id='modal-content-15']/div/div[1]/div/div[2]/div[2]/div/fieldset/div[7]/div[2]/input");
	public By lastNameTextbox = By.xpath("//div[@id='modal-content-15']/div/div[1]/div/div[2]/div[2]/div/fieldset/div[8]/div[2]/input");
	public By emailTextbox=By.xpath("//div[@id='modal-content-15']/div/div[1]/div/div[2]/div[2]/div/fieldset/div[9]/div[2]/input");
	public By phoneTextbox=By.xpath("//div[@id='modal-content-15']/div/div[1]/div/div[2]/div[2]/div/fieldset/div[10]/div[2]/input");

	public By saveButton = By.xpath("//div[@class='page-actions floating-header']/button[2]");
	public By emailInput=By.xpath("(//input[@name='email'])[2]");
	public By discountPopUp = By.xpath("*//[text()='Automated Discount']");

	public By topDiv=By.xpath("(//div[@class='page-main-actions'])[2]");
	/**
	* @return customerViewTab
	*/
	public By getCustomerViewTab(){
	    return customerViewTab;
	}
	
	/**
	* @return accountCreatedInLabel
	*/
	public By getAccountCreatedInLabel() {
		return accountCreatedInLabel;
	}

	/**
	 * @return getcloseSpecialHandlingDialogBox
	 */
	public By getCloseSpecialHandlingDialogBox(){
		return closeSpecialHandlingDialogBox;
	}


	/**
	 * @return Special Handling Heading
	 */
	public WebElement getSpecialHandlingHeadingFromDialogBox() {
		return getElement(specialHandlingHeadingFromDialogBox);
	}
	/**
	 * @return Account Requires
	 */
	public WebElement getAccountRequiresMessageFromDialogBox() {
		return getElement(accountRequiresMessageFromDialogBox);
	}
	/**
	 * @return Ok Button
	 */
	public By getOkButtonOnSpecialHandlingDialogBox() {
		return okButtonOnSpecialHandlingDialogBox;
	}

	/**
	* @return pageHeading
	*/
	public By getPageHeading(){
	    return pageHeading;
	}

	/**
	* @return orderTab
	*/
	public By getOrderTab(){
	    return orderTab;
	}
	
	/**
	* @return creditHoldPopupOkMessage
	*/
	public By getCreditHoldPopupOkMessage(){
	    return creditHoldPopupOkMessage;
	}
	
	/**
	* @return creditHoldPopupMessage
	*/
	public By getCreditHoldPopupMessage(){
	    return creditHoldPopupMessage;
	}

	/**
	 * @return youSaveCustomerSuccessMessage
	 */
	public By getYouSaveCustomerSuccessMessage() {
		return youSaveCustomerSuccessMessage;
	}

	/**
	 * @return the accountInformationButtonForIncompleteAccount
	 */
	public By getAccountInformationButtonForIncompleteAccount() {
		return accountInformationButtonForIncompleteAccount;
	}

	/**
	 * @return the relationshipButton
	 */
	public By getRelationshipButton() {
		return relationshipButton;
	}

	public By getAddNewRelationshipButton() {
		return addNewRelationshipButton;
	}

	/**
	 * @return the startDateField
	 */
	public By getStartDateField() {
		return startDateField;
	}

	/**
	 * @return the endDateField
	 */
	public By getEndDateField() {
		return endDateField;
	}

	/**
	 * @return the createOrderButton
	 */
	public By getCreateOrderButton() {
		return createOrderButton;
	}

	/**
	 * @return the contactsButton
	 */
	public By getContactsButton() {
		return contactsButton;
	}

	/**
	 * @return the addressButton
	 */
	public By getAddressButton() {
		return addressButton;
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
	 * Clicks on Account Information Tab
	 * 
	 * @return
	 */
	public boolean clickOnAccountInformationTab() {
		try {
			getElementNew(accountInformationButton).click();
			return true;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyCreditHoldPopupMessage(){
		try {
			driver.findElement(creditHoldPopupMessage);
			return true;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean handlePopupMessage() {
		try {
			driver.findElement(creditHoldPopupOkMessage).click();
			return true;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return false;
		}
	}

	@Step("Verify admin is able to click on 'EBS Relationships' tab")
	public void verifyAdminIsAbleToClickOnRelationshipTab() {
		try {
			WaitStatementUtils.waitForElementStaleness(driver,getElement(relationshipButton));
			ReusableMethods.scrollIntoView(getElement(getRelationshipButton()), driver);
			clickOnMethod("Relationships Tab", getElement(relationshipButton));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(
					PublicAdminCommons.waitElementToDisappearFromScreen(driver, getSpinnerIcon()),
					"Unable to handle loading screen");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert(
					"Admin was not able to click on 'Relationships' tab for account", e);
		}
	}

	@Step("Verify admin is able to click 'Add New Relationship' button")
	public void verifyAdminCanClickOnAddNewRelationShipButton() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getAddNewRelationshipButton()),10);
			clickOnMethod("Add New Relationship button", getElement(addNewRelationshipButton));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons
					.reportFailAssert("Admin was not able to click on 'Add New Relationship' button", e);
		}
	}

	@Step("Verify Start and End Date Fields are editable on Add Relationship Page")
	public void verifyStartEndDateFieldsAreEditable() {
		try {
			PublicCommon.waitForSec(15);
			String futureDate = PublicAdminCommons.getDateByAddSubtractingMonth(
					PublicAdminCommons.getCurrentDateWithFormat("MM/d/yyyy"), "MM/d/yyyy", +3);
			enterTextInTextField("Start Date Field", getStartDateField(),
					PublicAdminCommons.getCurrentDateWithFormat("MM/d/yyyy"), true,
					"Start date field is not editable");
			enterTextInTextField("End Date Field", getEndDateField(), futureDate, true,
					"Start date field is not editable for");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons
					.reportFailAssert("Admin is able to unable to enter value in start/end date field", e);
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

	@Step("Verify that admin is able to select Person as Customer Type and verify the same after saving the relationship")
	public void verifyRelationCanBeCreatedForPersonAccount(String B2Caccount) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,MenuNavigationPage.getElement(RelationshipListPage.getAddNewRelationshipButton()),10);
			PublicAdminCommons.scrollToElement(driver,RelationshipListPage.getAddNewRelationshipButton());
			clickOnMethod("Add New Relationship button", RelationshipListPage.getAddNewRelationshipButton(),
					"Admin was not able to click on 'Add New Relationship' button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			verifyStartEndDateFieldsAreEditable();
			applyFilterToAccountSearchUnderCreateRelation(B2Caccount);
			clickOnMethod("First Select Button", CreateRelationshipPage.getSelectButtonByIndex(1),
					"Admin is unable to click on First Select Button from list");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Save Button", CreateRelationshipPage.getSaveButton(),
					"Admin is unable to click on Save Button for");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			waitForLoadingScreenToDisappear(RelationshipListPage.getSpinnerIcon());
			PublicCommon.waitForSec(15);
			Assert.assertTrue(
					PublicAdminCommons.getTextOfWebElements(driver, RelationshipListPage.getEmailColumn())
							.contains(B2Caccount),
					"Relationship for account with email '" + B2Caccount + "' is not saved");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert(
					"Admin is unable to creates a new relationship for B2B account", e);
		}
	}

	@Step("Search for account using '{email}' as filter")
	public void applyFilterToAccountSearchUnderCreateRelation(String email) {
		try {
			Assert.assertTrue(CreateRelationshipPage.applyEmailFilter(email),
					"[PUB-6099] Admin is unable to apply filter for email '" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("[PUB-6099] Admin is unable to apply filer by email", e);
		}
	}

	@Step("Admin clicks on '{elementName}'")
	private void clickOnMethod(String elementName, By locator, String assertionMessage) {
		try {
			Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
					"Admin is unable to scroll to " + elementName);
			Assert.assertTrue(PublicAdminCommons.clickWebElement(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
		}
	}

	@Step("Admin waits for loading screen to disappear")
	private void waitForLoadingScreenToDisappear(By locator) {
		try {
			Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, locator),
					"Loading screen did not disapeear.");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Loading screen did not disapeear.", e);
		}
	}






}
