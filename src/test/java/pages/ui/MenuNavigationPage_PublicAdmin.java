package pages.ui;

import base.utils.ConfigReader;
import base.utils.ExcelDataConfig;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class MenuNavigationPage_PublicAdmin extends BasePage {

	public MenuNavigationPage_PublicAdmin(WebDriver driver) {
		super(driver);
	}
	private By spinnerIcon = By.cssSelector("div[data-component*='customer_address_listing'] div.spinner");
	public By customerMainButton = By.cssSelector("#nav .item-customer");
	public By allcustomerButton = By.cssSelector(".submenu .item-customer-manage");
	public By ebsAcntNoTextField = By.cssSelector("input[name='ebs_account_number']");
	public By maeAcntNoTextField = By.name("mae_account_id");
	public By storesMainButton = By.cssSelector("#menu-magento-backend-stores");
	private By configurationsButton = By.cssSelector(".submenu .item-system-config");
	private By ArchieveButton = By.xpath("//a/span[text()='Archive']");
	private By salesButton = By.xpath("//div[@data-role='title']//strong[text()='Sales']");
	public By systemButton = By.cssSelector("#menu-magento-backend-system");
	private By checkout_salesButton = By.xpath("//span[contains(text(),'Checkout')]");

	public By saveButton = By.xpath("//div[@class='page-actions-buttons']//button[@id='save']");
	public By systemvaluecheckbox = By.cssSelector("#checkout_sanctioned_countries_countries_inherit");
	public By countrySanctionDropdown = By.cssSelector("#checkout_sanctioned_countries_countries");
	public By alert = By.cssSelector("#modal-content-4");
	public By alertCloseBtn = By.cssSelector(".modal-popup button.action-close");
	public By expandedElement = By.cssSelector("ul[aria-hidden='false']");
	public By warehouseSetting = By.xpath("//*[text()='Warehouse settings']");
	public By restrictedMode = By.xpath("//*[text()='Restricted Mode']");
	public By warehouseCode = By.xpath("//td[starts-with(@class,' col-warehouse_code')]");
	public By warehouseAddressStreetRows = By.xpath("//td[starts-with(@class,' col-address_street')]");
	public By warehouseCityRows = By.xpath("//td[starts-with(@class,' col-city')]");
	public By warehouseStateRows = By.xpath("//td[starts-with(@class,' col-state')]");
	public By warehouseZipRows = By.xpath("//td[starts-with(@class,' col-zip')]");
	public By accountInfoOrganisation=By.xpath("//th[contains(text(),'Organization Name')]/../td/a/span");
	public By ebsRelationship=By.xpath("//a[@id='tab_relationship']/span[text()='EBS Relationships']");
	public By corporateBillingTableHeader = By.xpath("//a[@class='admin__page-nav-link']//span[text()='Customer View']");
	public By corporateBillingOrgName=By.xpath("(//tr/td/div[@class='data-grid-cell-content'])[2]");
	public By corporateBillingOrgName1=By.xpath("(//tr/td/div[@class='data-grid-cell-content'])[10]");
	public By tableWarehouse = By.id("warehouse_code_grid_table");
	public By scopeLabel = By.xpath("//span[text()='Scope:']");
	public By signinByOctoBtn = By.xpath("//span[text()='Sign in via OKTA']");
	public By salesMenuNavigationButton = By.id("menu-magento-sales-sales");
	public By reportMenuNavigationButton = By.id("menu-magento-reports-report");
	public By orderMenuNavigationButton = By.xpath("//li[@data-ui-id='menu-magento-sales-sales-order']");
	public By trainingReportMenuNavigationButton = By.xpath("//li[@data-ui-id='menu-alpine-trainingreport-report-salesroot-training']");
	public By EBSsku = By.xpath("//span[contains(text(),'EBS SKU:')]");
	public By filterButton = By.xpath("//button[contains(text(),'Filters')]");
	public By clearAllButtonOrders = By.cssSelector(".admin__data-grid-header button.action-clear");
	public By orderIdTextFieldOrders = By.cssSelector("input[name='increment_id']");
	public By customerEmailTextFieldCustomer = By.cssSelector("input[name='email']");
	public By customerCommunicationEmailTextFieldCustomer = By.cssSelector("input[name='communication_email']");
	public By customertypeTextboxCustomer = By.cssSelector("select[name='customer_type']");
	public By referalCode = By.xpath("(//td/div[@class='data-grid-cell-content'])[18]");
	public By CreatedByLabel=By.xpath("//span[text()='Created By']");
	public By applyFilterButtonOrders = By.xpath("//span[contains(text(),'Apply Filters')]");
	public By EBSOrderNumber = By.xpath("(//td/div[@class='data-grid-cell-content'])[11]");
	public By searchTextbox = By.xpath("//div[@class='data-grid-search-control-wrap']/input");
	public By searchButton = By.xpath("//div[@class='data-grid-search-control-wrap']/button");
	
	//Customer info
	public By addNewCustomerButton = By.xpath("//span[text()='Add New Customer']");
	public By selectCustomerType = By.cssSelector("select[name='customer[customer_type]']");
	public By customerFirstName = By.cssSelector("input[name='customer[firstname]']");
	public By customerLastName = By.cssSelector("input[name='customer[lastname]']");
	public By customerEmailcomunication = By.cssSelector("input[name='customer[communication_email]']");
	public By orgName= By.cssSelector("input[name='customer[organization_name]']");
	public By customerPhoneNo = By.cssSelector("input[name='customer[phone_number]']");
	public By CustomerContinueBtn = By.xpath("//span[text()='Continue']");
	public By addNewAddressBtn = By.xpath("//span[text()='Add New Address']");
	
	public By custmrstreetAddress = By.cssSelector("input[name='street[0]']");
	public By custmrCity = By.cssSelector("div[class='admin__field _required'] input[name='city']");
	public By custmrCountry = By.cssSelector("div[class='admin__field-control'] select[name='country_id']");
	public By custmrState = By.cssSelector("div[class='admin__field _required'] select[name='region_id']");
	public By custmrZipCode = By.cssSelector("div[class='admin__field _required'] input[name='postcode']");
	public By custmrPhone = By.cssSelector("div[class='admin__field _required'] input[name='telephone']");
	//public By saveBtn = By.xpath("//div[@class='page-actions floating-header']//button[@id='save']");
	public By saveBtn = By.xpath("(//button[@id='save'])[2]");
	public By SaveCustomerBtn = By.xpath("(//span[@class='ui-button-text'])[2]");
	
	public By pimDropDown = By.xpath("//div[@class='admin__page-nav-title title _collapsible']/strong[text()='PIM']");
	public By productTypeSetting = By.xpath("//ul[@class='admin__page-nav-items items']/li//span[text()='Product Types Settings']/..");
	public By informationalDescription = By.xpath("//body[@data-id='pim_products_membership_informational_description']/div/div");
	//input[@class='admin__control-text']
	public By  magentoOrderTextField= By.xpath("//input[@class='admin__control-text']");
    public By  createReportButton= By.xpath("//span[text()='Create Report']");
    public By  selectOption= By.xpath("//tr[@class='data-row _odd-row'][2]/td[8]/div/ul/li[1]/a");
    public By  downloadOption= By.xpath("//tr[@class='data-row'][1]/td[8]/div/button");
	public By skuNumberFromOrderViewScreen=By.xpath("//div[contains(@class,'product-sku-block')]");
	public By catalogButton = By.xpath("//*[@id='menu-magento-catalog-catalog']");
	public By referralCodeView = By.xpath("(//span[contains(text(),'Referral Code')])[3]");
	public By productLink = By.linkText("Products");
	public By signOut =By.xpath("(//ul[@class='admin__action-dropdown-menu'])/li[3]");
	public By rowSelector=By.xpath("//button[@class='selectmenu-toggle _active']");
	public By rowmax=By.xpath("//button[text()='200']");

	
	public By fetchEmail =By.xpath("//table[@class='admin__table-secondary order-account-information-table']/tbody/tr[2]/td/a");

	public String getFetchEmail() {
		return getElement(fetchEmail).getText();
	}
	public WebElement getProductEditButtonElmentString(String fieldText) {
		return getElement(By.xpath("//tr/td/div[text()='"+fieldText+"']/../following-sibling::td/a"));
	}

	public WebElement getRowByValue(String fieldText) {
		return getElement(By.xpath("//tr/td[contains(text(),'"+fieldText+"')]"));
	}
	
	public WebElement getSearchTextbox() {
		return getElement(searchTextbox);
	}

	//tr/td[contains(text(),'d4771-19.html')]
	
	public WebElement getProductPriceElement(String fieldText) {
		return getElement(By.xpath("//tr/td/div[text()='"+fieldText+"']/../following-sibling::td[1]"));
	}
	
	public By getProductSkuElement(String fieldText) {
		return By.xpath("//tr/td/div[text()='"+fieldText+"']/..");
	}
	public By getProductSkuElementContains(String fieldText) {
		return By.xpath("//tr/td/div[contains(text(),'"+fieldText+"')]/..");
	}
	/**
	 * @return the spinnerIcon
	 */
	public By getSpinnerIcon() {
		return spinnerIcon;
	}

	@Step("Waiting for loading screen to appear then disappear")
	public void waitForLoadingScreenToDisappear() {
		try {
			Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, getSpinnerIcon()),
					"Loading screen did not disappear.");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Loading screen did not disappear.", e);
		}
	}


	@Step("Enter City:'{0}' in TextBox.")
	public void setCityValue(String city) 
	{
		try {
			getElement(custmrCity).clear();
			getElement(custmrCity).sendKeys(city);	
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter State:'{0}' in TextBox.")
	public void setStateValue(String state) 
	{
		try {
			getElement(custmrState).clear();
			getElement(custmrState).sendKeys(state);
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter Country:'{0}' in TextBox.")
	public void setCountryValue(String country) 
	{
		try {
			getElement(custmrCountry).click();
			PublicCommon.selectValueInDropdown(getElement(custmrCountry), country);
			getElement(custmrCountry).click();
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter State:'{0}' in TextBox.")
	public void setStateValueDropdown(String state) 
	{
		try {
			getElement(custmrState).click();
			PublicCommon.selectValueInDropdown(getElement(custmrState), state);
			getElement(custmrState).click();
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@Step("Enter Postal Code:'{0}' in TextBox.")
	public void setPostalCodeValue(String postalCode) 
	{
		try {
			getElement(custmrZipCode).clear();
			getElement(custmrZipCode).sendKeys(postalCode);		
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}

	@Step("Enter Postal Code:'{0}' in TextBox.")
	public void setPhoneNoValue(String phone) 
	{
		try {
			getElement(custmrPhone).clear();
			getElement(custmrPhone).sendKeys(phone);		
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	@Step("Enter Street Address in TextBox.")
	public void setStreetAddressValue(String streetAddress1,String streetAddress2,String streetAddress3) 
	{
		try {
			getElement(custmrstreetAddress).clear();
			getElement(custmrstreetAddress).sendKeys(streetAddress1);
//			getElement(shippingAddress2Textbox).clear();
//			getElement(shippingAddress2Textbox).sendKeys(streetAddress2);
//			getElement(shippingAddress3Textbox).clear();
//			getElement(shippingAddress3Textbox).sendKeys(streetAddress3);
			
		}
		catch (Exception e) {
			e.getStackTrace();
		}	
	}
	public WebElement getstateDropdown() {
		return getElement(custmrState);
	}
	public WebElement getAddNewAdd() {
		return getElement(addNewAddressBtn);
	}
	public WebElement getCountryDropdown() {
		return getElement(custmrCountry);
	}
	public WebElement getSaveBtn() {
		return getElement(saveButton);
	}
	
	@Step("Enter Address Page Details.")
	public void addPageDetails(String test) {
		try {
			HashMap<String, String> dataMap = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"),test);
			setStreetAddressValue(dataMap.get("Add1"), dataMap.get("Add2"), dataMap.get("Add3"));
			setCityValue(dataMap.get("City"));
			scrollToPostalCodeField();
			setPostalCodeValue(dataMap.get("Postal Code"));
			setPhoneNoValue(dataMap.get("Phone No"));
			setCountryValue(dataMap.get("Country"));
			if (getstateDropdown().getAttribute("class").contains("field _required")) {
				setStateValueDropdown(dataMap.get("State"));
			} else {
				setStateValue(dataMap.get("State"));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public String fillB2CAccountInformation(String randomEmail) {
		try {
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerFirstname), "Test", driver);
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerLastname), "Data", driver);
			
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerEmail), randomEmail, driver);
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerPhoneNumber), "9879879879", driver);
			IntegrationCommon.clickonWebElement(driver, customerContinueButton);
			return randomEmail;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
    
	@Step("Scroll to View Postal code field on the page.")
	public void scrollToPostalCodeField() 
	{
		try {
			ReusableMethods.scrollIntoView(getElement(custmrZipCode), driver);
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}	
	}
	
	
	public By EBSOrderStatus = By.xpath("//td//span[@id='ebs_order_status']");
	public By selectPaymentTerm = By.cssSelector("select[name='customer[payment_term]']");
	
	public By viewBtn = By.xpath("//a[text()='View']");
	public By orderTotals = By.xpath("//span[text()='Order Totals']");
	private By APIClient = By.xpath("//div[@data-role='title']//strong[text()='API Client']");
	public By editLink = By.xpath("//a[text()='Edit']");
	public By contactsTab = By.id("tab_contact");
	public By addressTab = By.id("tab_address");
	public By accounInfoTab = By.xpath("//a[@class='admin__page-nav-link']//span[text()='Account Information']");
	public By contactsDetials = By.xpath("//tr[@class='data-row']//td");
	public By visibiltyAttributeFromTable=By.xpath("//tbody/tr/td[11]/div");
	public By ebsAccountNumber = By.xpath("//span[text()='EBS Account Number']");
	public By ebsAccountNumberValue = By.xpath("//div[@class='admin__field _disabled'][12]/div[2]/input");

	public By addressesTab=By.xpath("//span[text()='Addresses']");
	public By addressDetails=By.xpath("//div[@class='address_details']");

	public By customerName = By.xpath("//td//a[contains(@href,'customer')]//span");
	public By salesMainButton = By.cssSelector("nav.admin__menu .item-sales > a");
	public By ordersButton = By.cssSelector(".submenu .item-sales-order a");
	
	public By customerDetails = By.xpath("//td/div[@class='data-grid-cell-content']");
	public By accountInfo_emailField = By.xpath("//div[@data-index='email']//input");
	public By accountInfo_communicationEmail = By.xpath("//div[@data-index='communication_email']//input");
	public By customerInfo_orgNameField = By.xpath("//input[@name='organization_name']");
	public By customInfo_defaultBillingAddress = By.xpath("//strong[text()='Default Billing Address']/..");
	
	public By customInfo_defaultBillingAddressDetails = By.xpath("//*[contains(@class,'address-information billing-address')]//*[@class='address_details']");
	public By customInfo_defaultShippingAddressDetails = By.xpath("//*[contains(@class,'address-information shipping-address')]//*[@class='address_details']");
	public By customInfo_defaultFrieghtForwarderAddressDetails = By.xpath("//*[contains(@class,'address-information freight-forward-address')]//*[@class='address_details']");
	public By accountInfo_additionalOrganisation=By.xpath("//*[text()='Additional Organization']/../../following-sibling::div/input");
	
	@Step("Entering First Name for Sign Up.")
	public void enterFirstName(String firstName) {
		try {
			getElement(customerFirstName).sendKeys(firstName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Step("Entering Last Name for Sign Up.")
	public void enterLastName(String lastName) {
		try {
			 getElement(customerLastName).sendKeys(lastName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Step("Entering Email Address for Sign Up.")
	public void enterEmailAddress(String emailAddress) {
		try {
			getElement(customerEmail).sendKeys(emailAddress);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Step("Entering Email Address for Sign Up.")
	public void enterPhoneNo(String phoneNo) {
		try {
			getElement(customerPhoneNo).sendKeys(phoneNo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public WebElement getEbsAccountNumberValue() {
		return getElement(ebsAccountNumberValue);
	}
	
	public String getEbsAccountNumberGetText() {
		 WebElement element = driver.findElement(ebsAccountNumberValue);
         String value = element.getAttribute("value");
         return value;
		// return getElement(ebsAccountNumberValue).getText();
	}

	@Step("Add New Customer - New Registration")
	public void addNewCustomer(String firstName, String lastName,  String phoneNo) {
		try {
			enterFirstName(firstName);
			enterLastName(lastName);
		//	enterEmailAddress(emailAddress);
			enterPhoneNo(phoneNo);
			//confirmPassword(password);
			clickContinueBtn();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Step("Click on Continue btn")
	public boolean clickContinueBtn() {
		try {

			ReusableMethods.scrollIntoView(getElement(customerContinueButton), driver);
			waitForElementPresent(customerContinueButton);
			getElement(customerContinueButton).click();
			// PublicCommon.JSClick(getElement(customerContinueButton), driver);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public WebElement getApplyFilterButton() {
		return getElement(applyFilterButtonOrders);
	}
	public WebElement getViewBtn() {
		return getElement(viewBtn);
	}
	
	public WebElement getPaymentTerm() {
		return getElement(selectPaymentTerm);
	}
	
	public WebElement getCustomerType() {
		return getElement(selectCustomerType);
	}
	public WebElement getaccountInfo_additionalOrganisation() {
		return getElement(accountInfo_additionalOrganisation);
	}
	public WebElement getCustomInfo_defaultBillingAddressDetails() {
		return getElement(customInfo_defaultBillingAddressDetails);
	}
	public WebElement getCustomInfo_defaultShippingAddressDetails() {
		return getElement(customInfo_defaultShippingAddressDetails);
	}
	public WebElement getCustomInfo_defaultFrieghtForwarderAddressDetails() {
		return getElement(customInfo_defaultFrieghtForwarderAddressDetails);
	}
	public WebElement getcustomertypeTextboxCustomer() {
		return getElement(customertypeTextboxCustomer);
	}

	public WebElement getcustomerInfo_orgNameField() {
		return getElement(customerInfo_orgNameField);
	}

	public WebElement getDefaultBillingAddress() {
		return getElement(customInfo_defaultBillingAddress);
	}

	public By getAccountInfoTab() {
		return accounInfoTab;
	}

	public WebElement getAccountInfo_communicationEmailField() {
		return getElement(accountInfo_communicationEmail);
	}

	public WebElement getAccountInfo_emailField() {
		return getElement(accountInfo_emailField);
	}

	public List<WebElement> getCustomerDetails() {
		return getElements(customerDetails);
	}

	public WebElement getebsAcntnoclickEdit(String ebsaccountNumber) {
		return getElement(By.xpath("//*[text()='"+ebsaccountNumber+"']/../following-sibling::td/a[text()='Edit']"));
	}
	public WebElement getCreditholdAlertCloseBtn() {
		return getElement(creditholdAlertCloseBtn);
	}
	public By orderDetials = By.xpath("(//td/div[@class='data-grid-cell-content'])");
	public By orderAndAccntInfo_orgName = By.xpath("//th[contains(text(),'Organization')]/../td");
    public By accountInfo_EBSStatus=By.xpath("//*[text()='EBS Status']/ancestor::div[@class='admin__field-label']/following-sibling::div/input");
    
    public By createB2BUserButton =By.id("create_b2b_user");
    public By creditholdAlertCloseBtn =By.xpath("//*[contains(text(),'Credit Hold')]/following-sibling::button");
 
    //Account information page
    public By customerFirstname =By.name("customer[firstname]");
    public By customerLastname =By.name("customer[lastname]");
    public By customerEmail =By.name("customer[email]");
    public By customerPhoneNumber =By.name("customer[phone_number]");
    public By customerContinueButton =By.id("save_and_continue");
	
    
    public String fillB2BAccountInformation() {
		try {
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerFirstname), "Test", driver);
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerLastname), "Data", driver);
			String email = "testaccount" + System.currentTimeMillis() + "@mailinator.com";
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerEmail), email, driver);
			PublicCommon.clearTextFieldsendKeysWithScroll(getElement(customerPhoneNumber), "9879879879", driver);
			IntegrationCommon.clickonWebElement(driver, customerContinueButton);
			return email;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
    
   
    
    public List<WebElement> getContactDetails() {
		return getElements(contactsDetials);
	}

	public List<WebElement> getOrderDetails() {
		return getElements(orderDetials);
	}

	public By getOrderTotals() {
		return orderTotals;
	}

	public WebElement getOrderAndAccntInfo_orgName() {
		return getElement(orderAndAccntInfo_orgName);
	}
	
	public WebElement getCustomerName_orgName() {
		return getElement(customerName);
	}

	public void setOrderTotals(By orderTotals) {
		this.orderTotals = orderTotals;
	}

	public String getReferalCode() {
		return getElement(referalCode).getText();

	}

	public String getEBSOrderNumber() {
		return getElement(EBSOrderNumber).getText();
	}
	
	public String getEBSOrderStatus() {
		return getElement(EBSOrderStatus).getText();
	}

	public List<WebElement> getWarehouseCode() {
		return getElements(warehouseCode);
	}

	public List<WebElement> getWarehouseAddress() {
		return getElements(warehouseAddressStreetRows);
	}

	public List<WebElement> getWarehouseCity() {
		return getElements(warehouseCityRows);
	}

	public List<WebElement> getWarehouseState() {
		return getElements(warehouseStateRows);
	}

	public List<WebElement> getWarehouseZip() {
		return getElements(warehouseZipRows);
	}

	public boolean clickOnSalesMenubtn() {
		try {
			getElement(salesMenuNavigationButton);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public By getFilterButton() {
		return filterButton;
	}

	public void setFilterButton(By filterButton) {
		this.filterButton = filterButton;
	}

	public By getClearAllButtonOrders() {
		return clearAllButtonOrders;
	}

	public void setClearAllButtonOrders(By clearAllButtonOrders) {
		this.clearAllButtonOrders = clearAllButtonOrders;
	}

	public By getOrderIdTextFieldOrders() {
		return orderIdTextFieldOrders;
	}

	public void setOrderIdTextFieldOrders(By orderIdTextFieldOrders) {
		this.orderIdTextFieldOrders = orderIdTextFieldOrders;
	}

	public void setEBSAcntNoTextField(By ebsAcntNoTextField) {
		this.ebsAcntNoTextField = ebsAcntNoTextField;
	}
	
	public By getApplyFilterButtonOrders() {
		return applyFilterButtonOrders;
	}

	public By getSalesMenuNavigationButton() {
		return salesMenuNavigationButton;
	}

	public By getOrderMenuNavigationButton() {
		return orderMenuNavigationButton;
	}

	public boolean getOrderMenuNavigationBtn() {
		try {
			getElement(orderMenuNavigationButton);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickCustomerMainButton() {
		try {
			ReusableMethods.scrollIntoView(getElement(customerMainButton), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(customerMainButton),10);
			(new Actions(driver)).moveToElement(getElement(customerMainButton)).click().build().perform();
			//getElement(customerMainButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickAllcustomerButton() {
		try {
			ReusableMethods.scrollIntoView(getElement(allcustomerButton), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(allcustomerButton),10);
			getElement(allcustomerButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickOnSigninViaOctaBtn() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(signinByOctoBtn),10);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(signinByOctoBtn),10);
			PublicCommon.JSClick(getElement(signinByOctoBtn), driver);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickStoresMainButton() {
		try {
			WebElement store = getElement(storesMainButton);
			ReusableMethods.scrollIntoView(store, driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, store);
			store.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickSystemMainButton() {
		try {
			WebElement system = getElement(systemButton);
			ReusableMethods.scrollIntoView(system, driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, system);
			system.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}



	public boolean clickConfigurationsButton() {
		try {
			getElement(configurationsButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickArchieveButton() {
		try {
			getElement(ArchieveButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickSalesbutton() {
		try {
			ReusableMethods.scrollIntoView(getElement(APIClient), driver);
			getElement(salesButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickCheckoutbutton() {
		try {
			getElement(checkout_salesButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickOnSaveConfiguration() {
		try {
			getElement(saveButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	public boolean clickOnSystemValuecheckbox() {
		try {
			if (getElement(systemvaluecheckbox).isDisplayed()) {
				Thread.sleep(3000);
				getElement(systemvaluecheckbox).click();
			} else {
				driver.findElement(By.xpath("//a[text()='Sanctioned Countries']")).click();
				Thread.sleep(3000);
				getElement(systemvaluecheckbox).click();
			}
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	/**
	 * Method used to close Public Admin alert
	 */
	public void closeAlertButtonOnPubliAdminPage() {
		try {
			getElement(alertCloseBtn).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public boolean clickOnWarehouseSetting() {
		try {
			ReusableMethods.scrollIntoView(getElement(restrictedMode), driver);
			getElement(warehouseSetting).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean getMagentoErroForEBS() {

		getElement(viewBtn).click();
		WaitStatementUtils.explicitWaitForVisibility(driver, getElement(orderTotals));
		ReusableMethods.scrollIntoView(getElement(orderTotals), driver);
		return true;
	}
	
	@Step("Admin/ISS Agent navigates to Orders Page")
	public void navigatesToOrdersTab() {
		try {
			Assert.assertTrue(clickSalesMainButton(), "Admin/ISS Agent is unable to click on Store tab");
			Assert.assertTrue(clickOrdersButton(),
					"Admin/ISS Agent is unable to click on Orders button.");
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigates to Orders Page.", e);
		}
	}
	/**
	 * Click orders button
	 * 
	 * @return
	 */
	public boolean clickOrdersButton() {
		try {
			PublicAdminCommons.waitForSec(1000);
			return PublicAdminCommons.clickWebElement(driver, ordersButton);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	/**
	 * Click sales main button
	 * 
	 * @return
	 */
	public boolean clickSalesMainButton() {
		try {
			return PublicAdminCommons.clickWebElement(driver, salesMainButton);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	@Step("Admin/ISS Agent navigates to All Customer Page")
	public void navigatesToAllCustomerTab() {
		try {
			PublicCommon.waitForSec(10);
			Assert.assertTrue(clickCustomerMainButton(), "Admin/ISS Agent is unable to click on customer tab");
			Assert.assertTrue(clickAllcustomerButton(),
					"Admin/ISS Agent is unable to click on All Customers button.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to navigates to All Customer Page.", e);
		}
	}

	public Boolean isElementDisplayed(WebElement Element)
	{
		Boolean Value=false;
		try{
			if(Element.isDisplayed())
				Value=true;
			else
				Value=false;
		} catch (Exception e) {
			Value=false;
		}
		return Value;
	}

	@Step("Navigate to Transaction Grid Archive page on Admin page")
	public void navigateToTransactionGridArchivePage() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.scrollToOffSet(driver,"0","700");
			ReusableMethods.scrollIntoView(getElement(systemButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(systemButton),20);
			assertTrue(clickSystemMainButton(), "Click System button.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ArchieveButton),15);
			assertTrue(clickArchieveButton(), "Click archive button.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception Occured");
		}

	}

	public By getTransactionGridDate() {
		return transactionGridDate;
	}

	private By transactionGridDate=By.xpath("(//span[@class='data-grid-cell-content'])[2]");
	public By FirstAPIZip=By.xpath("(//a[contains(@href,'.zip')])[1]");


}
