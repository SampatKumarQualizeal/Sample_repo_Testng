package pages.ui;

import base.utils.ReusableMethods;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class OrdersPage_PublicAdmin extends BasePage {

    public OrdersPage_PublicAdmin(WebDriver driver) {
        super(driver);
    }

    private By addNewOrderButton = By.cssSelector("button[title='Create New Order']");
    private By filterButton = By.xpath("//button[contains(text(),'Filters')]");
    private By emailFilterField = By.cssSelector("input[name='email']");
    private By applyFilterButton = By.xpath("//span[contains(text(),'Apply Filters')]");
    private By clearAllButton = By.cssSelector(".admin__data-grid-header button.action-clear");
    //private By spinnerIcon = By.xpath("(//div[@class='admin__data-grid-outer-wrap'])[2]//following::div[@class='spinner']");
    private By spinnerIcon = By.cssSelector("div[data-component='sales_order_grid.sales_order_grid.sales_order_columns'] .spinner");
    private By customerPoFilterField = By.cssSelector("input[name='po']");
    private By customerPoColumn = By.cssSelector("tr.data-row td:nth-of-type(10)");
    private By idFilterField = By.cssSelector("input[name='increment_id']");
    private By mcsCommitteeUpdateColumn = By.cssSelector("tr.data-row td:nth-of-type(12)");
    private By viewOrderButton = By.cssSelector("a.action-menu-item");
    private By orderIdFilterField = By.cssSelector("input[name='increment_id']");
    private By fromPurchaseDate = By.cssSelector("input[name='created_at[from]']");
    private By toPurchaseDate = By.cssSelector("input[name='created_at[to]']");
    private By emailColumn = By.cssSelector("tbody td[data-column='email']");
    private By statusDropdown = By.cssSelector("[name='status']");
    private By createBy = By.cssSelector("[name='admin_username']");
    private By columnNamesInTable = By.cssSelector("table[data-role='grid'] > thead .data-grid-cell-content");

    private By getColumnDetailsByIndex(String index) {
        return By.cssSelector("tr.data-row td:nth-of-type(" + index + ")");
    }

    private By goToArchiveButton = By.cssSelector("button#go_to_archive");
    private By columnsButton = By.cssSelector("div.admin__data-grid-actions-wrap:nth-child(1) button span[data-bind*='Columns']");
    private By ebsOrderStatusCheckboxLabel = By.xpath("(//label[@title='EBS Order Status'])[1]");
    private By ebsOrderStatusCheckboxInput = By.xpath("(//label[@title='EBS Order Status']/preceding-sibling::input)[1]");
    private By ebsOrderStatusFilterDropDown = By.cssSelector("select[name='ebs_order_status']");
    private By customerTypeField = By.cssSelector("[name='customer_type']");
    private By ebsStatus = By.cssSelector("[name='ebs_order_status']");
    private By storeView = By.cssSelector("[name='store_id']");
    private By ebsOrderSortByDescend = By.xpath("//span[text()='EBS Order Number']/parent::th[contains(@class,'descend')]");
    private By ebsOrderSortByAscend = By.xpath("(//span[text()='EBS Order Number']/parent::th[contains(@class,'ascend')])[1]");
    private By ebsOrderNumberColumn = By.xpath("//span[text()='EBS Order Number']/parent::th");
    private By idColumn = By.xpath("//span[text()='ID']/parent::th");
    private By idSortByDescend = By.xpath("//span[text()='ID']/parent::th[contains(@class,'descend')]");
    private By orderViewButton = By.xpath("//tr[1]/td/a[text()='View']");

    /**
     * @return ebsOrderStatusFilterDropDown
     */
    public By getEbsOrderStatusFilterDropDown() {
        return ebsOrderStatusFilterDropDown;
    }

    /**
     * @return columnNamesInTable
     */
    public By getColumnNamesInTable() {
        return columnNamesInTable;
    }

    /**
     * @return statusDropdown
     */
    public By getStatusDropdown() {
        return statusDropdown;
    }


    /**
     * @return ebsOrderStatusCheckboxInput
     */
    public By getEbsOrderStatusCheckboxInput() {
        return ebsOrderStatusCheckboxInput;
    }

    /**
     * @return ebsOrderStatusCheckboxLabel
     */
    public By getEbsOrderStatusCheckboxLabel() {
        return ebsOrderStatusCheckboxLabel;
    }

    /**
     * @return columnsButton
     */
    public By getColumnsButton() {
        return columnsButton;
    }

    /**
     * @return goToArchiveButton
     */
    public By getGoToArchiveButton() {
        return goToArchiveButton;
    }

    /**
     * @return orderIdFilterField
     */
    public By getOrderIdFilterField() {
        return orderIdFilterField;
    }

    /**
     * @return viewOrderButton
     */
    public By getviewOrderButton() {
        return viewOrderButton;
    }

    /**
     * @return mcsCommitteeUpdateColumn
     */
    public By getMcsCommitteeUpdateColumn() {
        return mcsCommitteeUpdateColumn;
    }

    /**
     * @return idFilterField
     */
    public By getIdFilterField() {
        return idFilterField;
    }

    /**
     * @return the customerPoColumn
     */
    public By getCustomerPoColumn() {
        return customerPoColumn;
    }

    /**
     * @return the customerPoFilterField
     */
    public By getCustomerPoFilterField() {
        return customerPoFilterField;
    }

    /**
     * @return the spinnerIcon
     */
    public By getSpinnerIcon() {
        return spinnerIcon;
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
     * @return emailColumn
     */
    public By getEmailColumn() {
        return emailColumn;
    }

    /**
     * @return the applyFilterButton
     */
    public By getApplyFilterButton() {
        return applyFilterButton;
    }

    /**
     * @return the clearAllButton
     */
    public By getClearAllButton() {
        return clearAllButton;
    }

    /**
     * @return the addNewOrderButton
     */
    public By getAddNewOrderButton() {
        return addNewOrderButton;
    }

    public By getOrderViewButton() {
        return orderViewButton;
    }

    /**
     * Clicks on Add New Order Button
     *
     * @return
     */
    public boolean clickAddNewOrderButton() {
        try {
            getElementNew(addNewOrderButton).click();
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Remove the already applied filters
     */
    public void clearFilters() {
        try {
            WebElement elm = new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(clearAllButton));
            elm.click();
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
        }
    }

    public boolean applyFilterForMagentoOrderId(String orderId) {
        try {
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
            getElementNew(filterButton).click();
            clearFilters();
            getElementNew(orderIdFilterField).sendKeys(orderId.replace("#", ""));
            getElementNew(applyFilterButton).click();
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean applyFilterForCreatedBy(String filterValue) {
        try {
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
            getElementNew(filterButton).click();
            clearFilters();
            getElementNew(createBy).sendKeys(filterValue);
            getElementNew(applyFilterButton).click();
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }


    public boolean applyFilterForPurchaseDate(String startDate, String endDate) {
        try {
            getElementNew(filterButton).click();
            clearFilters();
            getElementNew(fromPurchaseDate).sendKeys(startDate.replace("#", ""));
            getElementNew(toPurchaseDate).sendKeys(endDate.replace("#", ""));
            getElementNew(applyFilterButton).click();
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean applyPurchaseDate(String startDate, String endDate) {
        try {
            PublicAdminCommons.clearTextField(driver, fromPurchaseDate);
            PublicAdminCommons.clearTextField(driver, toPurchaseDate);
            getElementNew(fromPurchaseDate).sendKeys(startDate.replace("#", ""));
            getElementNew(toPurchaseDate).sendKeys(endDate.replace("#", ""));
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
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
                    getColumnDetailsByIndex(String.valueOf(index + 2)));
            return detailsUnderColumn.get(0);
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return "";
        }
    }

    public boolean applyFilters(String customerType, String EBS_Status, String store, String startDate, String endDate) {
        try {
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
            getElementNew(filterButton).click();
            clearFilters();
            applyPurchaseDate(startDate, endDate);
            selectStore(store);
            selectCustomerType(customerType);
            selectEBS_Status(EBS_Status);
            getElementNew(applyFilterButton).click();
            PublicAdminCommons.waitElementToDisappearFromScreen(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public void selectCustomerType(String customerType) {
        try {
            WebElement element = getElementNew(customerTypeField);
            Select select = new Select(element);
            select.selectByVisibleText(customerType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void selectEBS_Status(String EBS_Status) {
        try {
            WebElement element = getElementNew(ebsStatus);
            Select select = new Select(element);
            select.selectByVisibleText(EBS_Status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectStore(String store) {
        try {
            WebElement element = getElementNew(storeView);
            Select select = new Select(element);
            select.selectByVisibleText(store);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortEBSOrderByAscending() {
        for (int i=0; i<=2; i++){
            WebElement element = null;
            try {
                element = driver.findElement(ebsOrderSortByAscend);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                PublicCommon.JSClick(getElement(ebsOrderNumberColumn), driver);
            }
        }
    }

    public void sortID_ColumnByDescending() {
        for (int i = 0; i < 2; i++) {
            if (!PublicAdminCommons.isWebElementPresentOnPage(driver, idSortByDescend)) {
                PublicCommon.JSClick(getElement(idColumn), driver);
            } else {
                break;
            }
        }
    }

}
