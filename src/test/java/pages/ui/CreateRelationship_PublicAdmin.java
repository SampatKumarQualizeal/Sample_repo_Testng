package pages.ui;

import base.utils.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.astm.commonFunctions.PublicAdminCommons;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.*;

public class CreateRelationship_PublicAdmin extends BasePage {

	public CreateRelationship_PublicAdmin(WebDriver driver) {
		super(driver);
	}

	private By customerIdColumnHeader = By
			.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) thead th:nth-of-type(2)");
	private By customerTypeColumnHeader = By
			.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) thead th:nth-of-type(3)");
	private By ebsAccountNumberColumnHeader = By
			.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) thead th:nth-of-type(4)");
	private By nameColumnHeader = By
			.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) thead th:nth-of-type(5)");
	private By orgNameColumnHeader = By
			.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) thead th:nth-of-type(6)");
	private By emailColumnHeader = By
			.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) thead th:nth-of-type(7)");
	private By cutomerTypeColumn = By.cssSelector(
			"div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) tbody tr td:nth-of-type(3)");
	private By startDateField = By.cssSelector("input[name='start_date']");
	private By endDateField = By.cssSelector("input[name='end_date']");
	private By cancelButton = By.cssSelector("button#cancel");
	private By saveButton = By.cssSelector(".floating-header #save");

	public By getEmailByIndex(int index) {
		return By.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) tbody tr:nth-of-type("
				+ index + ") td:nth-of-type(7)");
	}
	
	private By tabbleSpinnerIcon = By.cssSelector("div[data-bind*='create_relationship_listing'] .spinner");
	private By SpinnerIcon = By.cssSelector(".customer-index-edit .loading-mask");

	private By errorMessage = By.cssSelector("div[data-bind*='customer_relationship_create_form'] div.message-error");
	private By filterButton = By.cssSelector(
			"div[data-bind*='create_relationship_listing'] .admin__data-grid-header:nth-of-type(2) button[data-action='grid-filter-expand']");
	private By emailFilterTextField = By.cssSelector(
			"div[data-bind*='create_relationship_listing'] .admin__data-grid-header:nth-of-type(2) input[name='email']");
	private By applyFilterButton = By.cssSelector(
			"div[data-bind*='create_relationship_listing'] .admin__data-grid-header:nth-of-type(2) button[data-action='grid-filter-apply']");
	private By cleanFilterButton = By.cssSelector("div[data-bind*='create_relationship_listing'] .admin__data-grid-header:nth-of-type(2) button.action-clear");
	private By noRecordFoundErrorMessage = By.cssSelector("div[data-bind*='create_relationship_listing'] tr.data-grid-tr-no-data");
	private By crossButton = By.cssSelector("aside.customer_form_areas_relationship_relationship_customer_relationship_create_modal._show button[data-role='closeBtn']");
	private By columnHeaders = By.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) thead tr th span");
	private By fromLastOrderDateColumn = By.cssSelector("aside.customer_form_areas_relationship_relationship_customer_relationship_create_modal._show input[name='last_order_date[from]']");
	private By toLastOrderDateColumn = By.cssSelector("aside.customer_form_areas_relationship_relationship_customer_relationship_create_modal._show input[name='last_order_date[to]']");
	private By calenderIconForFromDate = By.cssSelector("aside.customer_form_areas_relationship_relationship_customer_relationship_create_modal._show input[name='last_order_date[from]'] + button");
	private By calenderIconForToDate = By.cssSelector("aside.customer_form_areas_relationship_relationship_customer_relationship_create_modal._show input[name='last_order_date[to]'] + button");
	private By monthDropDown = By.cssSelector("select[data-handler='selectMonth']");
	private By yearDropDown = By.cssSelector("select[data-handler='selectYear']");
	private By activeDateLabel = By.cssSelector("td[data-handler='selectDay'] a");
	private By lastOrderDateColumn = By.xpath("//table[@data-role='grid']//span[contains(text(),'Last Order Date')]");
	private By ofPageLabel = By.cssSelector("input[id=\"2\"] + label");
	private By pageNumberTextField = By.cssSelector("input[id=\"2\"]");
	private By noOfOrdersColumn = By.xpath("//table[@data-role='grid']//span[contains(text(),'Number Of Orders')]");
	private By addressFilterField = By.cssSelector("input[name='billing_full']");
	private By addressColumn = By.xpath("//table[@data-role='grid']//span[contains(text(),'Address')]");
	private By columnsSettingButton = By.xpath("(//span[contains(text(),'Columns')])[2]");
	private By lastOrderDateCheckbox = By.xpath("(//label[@title='Last Order Date'])[1]");
	private By lastOrderDateInputTag = By.xpath("(//label[@title='Last Order Date']/preceding-sibling::input)[1]");
	private By noOfOrderCheckbox = By.xpath("(//label[@title='Number Of Orders'])[1]");
	private By noOfOrderInputTag = By.xpath("(//label[@title='Number Of Orders']/preceding-sibling::input)[1]");
	private By addressCheckbox = By.xpath("(//label[@title='Address'])[1]");
	private By addressInputTag = By.xpath("(//label[@title='Address']/preceding-sibling::input)[1]");
	private By noOfOrderColumn = By.xpath("//table[@data-role='grid']//span[contains(text(),'Number Of Orders')]");
	private By ebsAccountNumberTextField = By.cssSelector("input[name='ebs_account_number']");
	private By customerTypeDropDown = By.cssSelector("select[name='customer_type']");

	/**
	 * @return Gets the value of ebsAccountNumberTextField and returns ebsAccountNumberTextField
	 */
	public By getEbsAccountNumberTextField() {
		return ebsAccountNumberTextField;
	}

	/**
	 * Returns selector for getting cell selector
	 *
	 * @param indexForColumn
	 * @return
	 */
	public By getColumnRowSelectorUnderTableAnchorLink(int indexForColumn) {
		return By.cssSelector("div[class*='customer_relationship_create_form_customer_relationship'] div[data-role='grid-wrapper'] " +
				"table tbody tr td:nth-of-type(" + indexForColumn +") a");
	}

	/**
	 * @return noOfOrderColumn
	 */
	public By getNoOfOrderColumn(){
		return noOfOrderColumn;
	}

	/**
	 * @return addressInputTag
	 */
	public By getAddressInputTag(){
		return addressInputTag;
	}

	/**
	 * @return addressCheckbox
	 */
	public By getAddressCheckbox(){
		return addressCheckbox;
	}

	/**
	 * @return noOfOrderInputTag
	 */
	public By getNoOfOrderInputTag(){
		return noOfOrderInputTag;
	}

	/**
	 * @return noOfOrderCheckbox
	 */
	public By getNoOfOrderCheckbox(){
		return noOfOrderCheckbox;
	}

	/**
	 * @return lastOrderDateInputTag
	 */
	public By getLastOrderDateInputTag(){
		return lastOrderDateInputTag;
	}

	/**
	 * @return lastOrderDateCheckbox
	 */
	public By getLastOrderDateCheckbox(){
		return lastOrderDateCheckbox;
	}

	/**
	 * @return columnsSettingButton
	 */
	public By getColumnsSettingButton(){
		return columnsSettingButton;
	}

	/**
	 * @return addressColumn
	 */
	public By getAddressColumn(){
		return addressColumn;
	}

	/**
	* @return addressFilterField
	*/
	public By getAddressFilterField(){
	    return addressFilterField;
	}

	/**
	 * @return lastOrderDateColumn
	 */
	public By getlastOrderDateColumn(){
		return lastOrderDateColumn;
	}

	/**
	 * @return activeDateLabel
	 */
	public By getActiveDateLabel(){
		return activeDateLabel;
	}

	/**
	 * @return yearDropDown
	 */
	public By getYearDropDown(){
		return yearDropDown;
	}

	/**
	 * @return monthDropDown
	 */
	public By getMonthDropDown(){
		return monthDropDown;
	}


	/**
	 * @return calenderIconForToDate
	 */
	public By getCalenderIconForToDate(){
		return calenderIconForToDate;
	}

	/**
	 * @return calenderIconForFromDate
	 */
	public By getCalenderIconForFromDate(){
		return calenderIconForFromDate;
	}

	/**
	 * @return toLastOrderDateColumn
	 */
	public By getToLastOrderDateColumn(){
		return toLastOrderDateColumn;
	}

	/**
	 * @return fromLastOrderDateColumn
	 */
	public By getFromLastOrderDateColumn(){
		return fromLastOrderDateColumn;
	}
	/**
	 * @return columnHeaders
	 */
	public By getColumnHeaders() {
		return columnHeaders;
	}

	/**
	* @return crossButton
	*/
	public By getCrossButton(){
	    return crossButton;
	}

	/**
	 * @return the tabbleSpinnerIcon
	 */
	public By getTabbleSpinnerIcon() {
		return tabbleSpinnerIcon;
	}

	/**
	 * @return the filterButton
	 */
	public By getFilterButton() {
		return filterButton;
	}

	/**
	 * @return the emailFilterTextField
	 */
	public By getEmailFilterTextField() {
		return emailFilterTextField;
	}

	/**
	 * @return the applyFilterButton
	 */
	public By getApplyFilterButton() {
		return applyFilterButton;
	}

	/**
	 * @return the cleanFilterButton
	 */
	public By getCleanFilterButton() {
		return cleanFilterButton;
	}

	/**
	 * @return the noRecordFoundErrorMessage
	 */
	public By getNoRecordFoundErrorMessage() {
		return noRecordFoundErrorMessage;
	}

	/**
	 * @return the errorMessage
	 */
	public By getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return the spinnerIcon
	 */
	public By getSpinnerIcon() {
		return SpinnerIcon;
	}

	/**
	 * @return the saveButton
	 */
	public By getSaveButton() {
		return saveButton;
	}

	/**
	 * @return the cancelButton
	 */
	public By getCancelButton() {
		return cancelButton;
	}

	/**
	 * Returns selector for select button
	 * 
	 * @param index
	 * @return
	 */
	public By getSelectButtonByIndex(int index) {
		return By.cssSelector("div[data-bind*='create_relationship_listing'] > div:nth-of-type(4) tbody tr:nth-of-type("
				+ index + ") td:nth-of-type(1) button");
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
	 * @return the customerIdColumnHeader
	 */
	public By getCustomerIdColumnHeader() {
		return customerIdColumnHeader;
	}

	/**
	 * @return the customerTypeColumnHeader
	 */
	public By getCustomerTypeColumnHeader() {
		return customerTypeColumnHeader;
	}

	/**
	 * @return the ebsAccountNumberColumnHeader
	 */
	public By getEbsAccountNumberColumnHeader() {
		return ebsAccountNumberColumnHeader;
	}

	/**
	 * @return the nameColumnHeader
	 */
	public By getNameColumnHeader() {
		return nameColumnHeader;
	}

	/**
	 * @return the orgNameColumnHeader
	 */
	public By getOrgNameColumnHeader() {
		return orgNameColumnHeader;
	}

	/**
	 * @return the emailColumnHeader
	 */
	public By getEmailColumnHeader() {
		return emailColumnHeader;
	}

	/**
	 * @return the cutomerTypeColumn
	 */
	public By getCutomerTypeColumn() {
		return cutomerTypeColumn;
	}

	/**
	 * Returns selector for getting cell selector
	 *
	 * @param indexForColumn
	 * @return
	 */
	public By getColumnRowSelectorUnderTable(int indexForColumn) {
		return By.cssSelector("div[data-bind*='create_relationship_listing'] > div[data-role='grid-wrapper'] " +
				"table tbody tr td:nth-of-type(" + indexForColumn +")");
	}
	
	/**
	 * Apply filter by email to the search results 
	 * 
	 * 
	 * @param email
	 * @return
	 */
	public boolean applyEmailFilter(String email) {
		try {
			PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			if(PublicAdminCommons.isWebElementPresentOnPage(driver, cleanFilterButton)) {
				getElementNew(cleanFilterButton).click();
				PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			}
			getElementNew(filterButton).click();
			getElementNew(emailFilterTextField).sendKeys(email);
			getElementNew(applyFilterButton).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			log.info(e);
			return false;
		}
	}
	
	/**
	 * Clear all applied filters
	 * 
	 * 
	 * @return
	 */
	public boolean clearAllFilters() {
		try {
			PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			if(PublicAdminCommons.isWebElementPresentOnPage(driver, cleanFilterButton)) {
				PublicAdminCommons.loaderClick(driver, cleanFilterButton);
				PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			log.info(e);
			return false;
		}
	}

	/**
	 * Pick date from calender
	 * Example : 3 Jan 2021
	 *
	 * @param date
	 * @return
	 */
	public boolean pickDateFromCalender(String date){
		try {
			String[] dateArray = date.split(" ");
			PublicAdminCommons.selectValueInDropdown(getElementNew(yearDropDown), dateArray[2]);
			PublicAdminCommons.selectValueInDropdown(getElementNew(monthDropDown), dateArray[1]);
			List<String> dates = PublicAdminCommons.getTextOfWebElements(driver, activeDateLabel);
			List<WebElement> datesElement = getElementsNew(activeDateLabel);
			int index = dates.indexOf(dateArray[0]);
			datesElement.get(index).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			return false;
		}
	}

	/**
	 * Sort By ascending dates
	 *
	 * @return
	 */
	public boolean sortByCustomerSinceByAscendingOrder(){
		try {
			List<String> dates_elements = getListOfDetailsPresentUnderColumnByName("Last Order Date");
			if (dates_elements.size() == 0){
				return false;
			}
			SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy h:mm:ss aa");
			List<Date> dates = new ArrayList<>();
			for (String date : dates_elements){
				Date dateObject = format.parse(date);
				dates.add(dateObject);
			}
			if (dates.size() == 0){
				return false;
			}
			if (!isDateListAscending(dates)) {
				getElementNew(lastOrderDateColumn).click();
				PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			}else {
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
	public boolean sortByCustomerSinceByDescendingOrder(){
		try {
			for(int i=0;i<5;i++){
				List<String> dates_elements = getListOfDetailsPresentUnderColumnByName("Last Order Date");
				if (dates_elements.size() == 0){
					return false;
				}
				SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy h:mm:ss aa");
				List<Date> dates = new ArrayList<>();
				for (String date : dates_elements){
					Date dateObject = format.parse(date);
					dates.add(dateObject);
				}
				if (dates.size() == 0){
					return false;
				}
				boolean checkIfDate = isDateListDescending(dates);
				if (!checkIfDate) {
					getElementNew(lastOrderDateColumn).click();
					PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
				}
				if (checkIfDate){
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

	public List<String> getListOfDetailsPresentUnderColumnByName(String columnName){
		try {
			List<String> columnHeadersElementList = PublicAdminCommons.getTextOfWebElementsWithExceptionWithoutWait(driver, columnHeaders);
			int lastOrderIndex = columnHeadersElementList.indexOf(columnName);
			return PublicAdminCommons.getTextOfWebElements(driver,
					getColumnRowSelectorUnderTable(lastOrderIndex+1));
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Go to the last page of search results
	 *
	 * @return
	 */
	public boolean goToLastPageOfResults(){
		try {
			String pageNumber = PublicAdminCommons.getTextForElementWithSelectorShowingMultipleResult(driver,ofPageLabel)
					.replace("of ", "");
			WebElement pageNumberTextFieldElement = PublicAdminCommons.getElementWithSelectorShowingMultipleResult(driver, pageNumberTextField);
			if (pageNumber.equals(""))
				return false;
			if(pageNumber.equals("1"))
				return true;
			pageNumberTextFieldElement.clear();
			pageNumberTextFieldElement.sendKeys(pageNumber);
			pageNumberTextFieldElement.sendKeys(Keys.ENTER);
			PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Sort By ascending dates
	 *
	 * @return
	 */
	public boolean sortByNoOfOrdersByDescendingOrder(){
		try {
			for(int i=0;i<5;i++) {
				List<String> noOfOrdersElements = getListOfDetailsPresentUnderColumnByName("Number Of Orders");
				if (noOfOrdersElements.size() == 0) {
					return false;
				}
				boolean checkIfOrderInProperFormat = isDataListDescending(noOfOrdersElements);
				if (!checkIfOrderInProperFormat) {
					getElementNew(noOfOrdersColumn).click();
					PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
				} if(checkIfOrderInProperFormat) {
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

	public boolean isDataListDescending(List<String> dataList) {
		List<Integer> updatedList = new ArrayList<>();
		for (String data : dataList){
			updatedList.add(Integer.parseInt(data));
		}
		Iterator<Integer> iter = updatedList.iterator();
		Integer current, previous = iter.next();
		while (iter.hasNext()) {
			current = iter.next();
			if (previous.compareTo(current) < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public boolean verifyAddressHasSpecifiedKeyword(String addressKeyword) {
		try {
			List<String> addressList = getListOfDetailsPresentUnderColumnByName("Address");
			if(addressKeyword.length() == 0)
				return false;
			for (String addressElement : addressList){
				if (!addressElement.contains(addressKeyword)){
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			log.info(e);
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Apply filter for date
	 *
	 * @return
	 */
	public boolean applyFilterUsingOrderDateForLastDays(){
		try {
			getElementNew(filterButton).click();
			String currentDate = PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy");
			String yesterdayDate = PublicAdminCommons.getYesterdayDate("MM/dd/yyyy");
			getElementNew(fromLastOrderDateColumn).sendKeys(yesterdayDate);
			getElementNew(toLastOrderDateColumn).sendKeys(currentDate);
			getElementNew(applyFilterButton).click();
			PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			return false;
		}
	}

	/**
	 * Get me the account with valid values for last order date, no of orders, address
	 *
	 * @return
	 */
	public HashMap<String, Object> getTheAccountWithOrderDataNoOfOrdersAddress() {
		try {
			PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			HashMap<String, Object> details = new HashMap<>();
			List<String> columnHeadersElementList = PublicAdminCommons.getTextOfWebElementsWithExceptionWithoutWait(driver, columnHeaders);
			int lastOrderIndex = columnHeadersElementList.indexOf("Last Order Date");
			int numberOfOrdersIndex = columnHeadersElementList.indexOf("Number Of Orders");
			int addressIndex = columnHeadersElementList.indexOf("Address");
			int ebsAccountNumberIndex = columnHeadersElementList.indexOf("EBS Account Number");
			int rows = getElementsNew(cutomerTypeColumn).size();
			for (int i = 0; i < rows; i++) {
				String lastOrders = getElementsNew(getColumnRowSelectorUnderTable(lastOrderIndex+1)).get(i).getText();
				String numberOfOrders = getElementsNew(getColumnRowSelectorUnderTable(numberOfOrdersIndex+1)).get(i).getText();
				String address = getElementsNew(getColumnRowSelectorUnderTable(addressIndex+1)).get(i).getText();
				String ebsAccountNumber = getElementsNew(getColumnRowSelectorUnderTable(ebsAccountNumberIndex+1)).get(i).getText();
				if(!lastOrders.equals("") && !numberOfOrders.equals("") && !address.equals("")){
					details.put("rowIndex", i);
					details.put("lastOrders", lastOrders);
					details.put("numberOfOrders", numberOfOrders);
					details.put("address", address);
					details.put("ebsAccountNumber", ebsAccountNumber);
					return details;
				}
			}
			return details;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			return null;
		}
	}

	/**
	 * Click on name or org name by index
	 *
	 * @return
	 */
	public boolean clickOnNameOrOrgNameByIndex(int index) {
		try {
			List<String> columnHeadersElementList = PublicAdminCommons.getTextOfWebElementsWithExceptionWithoutWait(driver, columnHeaders);
			int nameColumnHeader = columnHeadersElementList.indexOf("Name");
			int orgNameColumnHeader = columnHeadersElementList.indexOf("Organization Name");
			String name = getElementsNew(getColumnRowSelectorUnderTable(nameColumnHeader+1)).get(index).getText();
			String orgName = getElementsNew(getColumnRowSelectorUnderTable(orgNameColumnHeader+1)).get(index).getText();
			if (!name.equals("") && !name.equals("- -")) {
				getElementsNew(getColumnRowSelectorUnderTableAnchorLink(nameColumnHeader+1)).get(index).click();
				return true;
			}
			if (!orgName.equals("")) {
				getElementsNew(getColumnRowSelectorUnderTableAnchorLink(orgNameColumnHeader+1)).get(index).click();
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			return false;
		}
	}

	/**
	 * Get me the account with valid values for last order date, no of orders, address
	 *
	 * @return
	 */
	public HashMap<String, Object> getTheAccountWithAddressAndNoOrderCountAndOrderDate() {
		try {
			PublicAdminCommons.handleSpinnerIconOnMagento(driver, tabbleSpinnerIcon);
			HashMap<String, Object> details = new HashMap<>();
			List<String> columnHeadersElementList = PublicAdminCommons.getTextOfWebElementsWithExceptionWithoutWait(driver, columnHeaders);
			int lastOrderIndex = columnHeadersElementList.indexOf("Last Order Date");
			int numberOfOrdersIndex = columnHeadersElementList.indexOf("Number Of Orders");
			int addressIndex = columnHeadersElementList.indexOf("Address");
			int ebsAccountNumberIndex = columnHeadersElementList.indexOf("EBS Account Number");
			int rows = getElementsNew(cutomerTypeColumn).size();
			for (int i = 0; i < rows; i++) {
				String lastOrders = getElementsNew(getColumnRowSelectorUnderTable(lastOrderIndex+1)).get(i).getText();
				String numberOfOrders = getElementsNew(getColumnRowSelectorUnderTable(numberOfOrdersIndex+1)).get(i).getText();
				String address = getElementsNew(getColumnRowSelectorUnderTable(addressIndex+1)).get(i).getText();
				String ebsAccountNumber = getElementsNew(getColumnRowSelectorUnderTable(ebsAccountNumberIndex+1)).get(i).getText();
				if(!address.equals("") && numberOfOrders.equals("0")){
					details.put("rowIndex", i);
					details.put("lastOrders", lastOrders);
					details.put("numberOfOrders", numberOfOrders);
					details.put("address", address);
					details.put("ebsAccountNumber", ebsAccountNumber);
					return details;
				}
			}
			return details;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			return null;
		}
	}
}
