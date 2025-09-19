package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testobjects.Order_PublicAdmin;
import testobjects.Product_PublicAdmin;
import testobjects.prerequisitegenerator.OrderCreation_PublicAdmin;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderInformationPage_PublicAdmin extends BasePage {

    public OrderInformationPage_PublicAdmin(WebDriver driver) {
        super(driver);
    }

    AllCustomerPage_PublicAdmin AllCustomerPage;
    MenuNavigationPage_PublicAdmin adminMenuNavigation;
    CreateNewOrderPage_PublicAdmin CreateOrderPage = getInstance(CreateNewOrderPage_PublicAdmin.class);
    public String RecoveryPointValue_MAE = "CREATE-MAE-ENTITLEMENT";
    public String RecoveryPointValue_EBS = "CREATE-EBS-ORDER";
    public String RecoveryPointValue_EBSbusiness = "CREATE-EBS-ORDER-SUCCESS-EVENT";

    private By orderCreationSuccessMessage = By.cssSelector("div[data-ui-id='messages-message-success']");
    private By ebsOrderNumber = By.cssSelector("table.order-information-table tbody tr:nth-of-type(2) td");


    private By ebsOrderEventStatus = By.cssSelector("table.order-information-table tbody tr:nth-of-type(4) td");
    private By contactUnderBillingAddress = By.cssSelector(".order-billing-address div:last-child");
    private By orderHeaderCreateNewOrderPgae = By.id("order-header");
    private By contactUnderShippingAddress = By.cssSelector(".order-shipping-address div:last-child");
    private By contactUnderFrieghtForwardAddress = By.cssSelector(".order-freight-forward-address div:last-child");
    private By shippingMethodLabel = By
            .cssSelector("div.order-shipping-method .admin__page-section-item-content div:nth-of-type(1)");
    public By shippingMethod=By.cssSelector("div.order-shipping-method .admin__page-section-item-content strong");
    private By shippingAccountNumberLabel = By
            .cssSelector("div.order-shipping-method .admin__page-section-item-content div:nth-of-type(2)");
    private By customerOrOrganizationNameOnAccountInformation = By.xpath("//th[contains(text(),'Customer Name')]//parent::tr//span|//th[contains(text(),'Organization Name')]//parent::tr//span");
    private By shippingAndHandlingChargesLabel = By.xpath("//td[contains(text(),'Shipping & Handling')]/../td[2]/span/span");
    private By subTotalLabel = By.cssSelector(".order-subtotal-table  tbody .col-0 span span");
    private By contactUnderProductList = By.cssSelector(".edit-order-table > tbody > tr:last-child");
    private By orderType = By.cssSelector(".order-information-table tbody tr:nth-of-type(5) td");
    private By customerPoNumber = By.cssSelector("div.order-po-number-value");
    //    private By ebsOrderStatus = By.cssSelector(".order-information-table tbody tr:nth-of-type(3) td");
//    private By ebsOrderStatus = By.cssSelector(".order-information-table tbody tr:nth-of-type(3) td");
    private By ebsOrderStatus = By.cssSelector("span#ebs_order_status");
    private By reorderButton = By.cssSelector("button#order_reorder");
    private By purchagedFrom = By.cssSelector("table.order-information-table tbody tr:nth-of-type(8) td");
    private By startDateUnderProduct = By.cssSelector("div[id*='compass_start_date']");
    private By publishDateUnderProduct = By.cssSelector("div[id*='compass_publish_date']");
    private By subscriptionTypeUnderProduct = By.cssSelector("div[id*='compass_subscription_type']");
    private By astmStandardShippingInformation = By
            .cssSelector(".order-shipping-method .admin__page-section-item-content");
    private By errorMessage = By.cssSelector("div.message-error");
    private By orderNumber = By.cssSelector("h1.page-title");
    private By orderDate = By.cssSelector(".order-information-table tr:nth-of-type(6) td");
    //    private By orderDate = By.cssSelector(".order-information-table tr:nth-of-type(6) td");
    private By ccTerminalPaymentMethod = By
            .cssSelector(".order-payment-additional table tr:nth-of-type(1) td:last-child");
    private By ccTerminalReceiptMethod = By
            .cssSelector(".order-payment-additional table tr:nth-of-type(2) td:last-child");
    private By ccTerminalIdentifyNumber = By
            .cssSelector(".order-payment-additional table tr:nth-of-type(3) td:last-child");
    private By ccTerminalAmount = By.cssSelector(".order-payment-additional table tr:nth-of-type(4) td:last-child");

    public By orderTotalSectionMainHeader() {
        return By.xpath("//span[@class='title' and text()='Order Total']");
    }

    public By orderTotalsSectionHeader() {
        return By.xpath("//span[@class='title' and text()='Order Totals']");
    }

    public By memDiscOrderTotalsSection() {
        return By.cssSelector("tr:nth-child(2) > td:nth-child(2) > span");
    }

    private By grandTotalExclTax = By.cssSelector(".order-subtotal-table tbody .col-6 span");
    private By grandTotalInclTax = By.cssSelector(".order-subtotal-table tbody .col-8 span");

    private By GrandTotalStu= By.xpath("//Strong[text()='Grand Total']/ancestor::tr/td[2]");
    private By totalPaidStu= By.xpath("//Strong[text()='Total Paid']/ancestor::tr/td[2]");
    private By totalRefundedStu= By.xpath("//Strong[text()='Total Refunded']/ancestor::tr/td[2]");
    private By totalDueStu= By.xpath("//Strong[text()='Total Due']/ancestor::tr/td[2]");
    public By getTotalTax() {
        return totalTax;
    }

    public By addressInfoSectionHeader = By.xpath("//section[contains(@class,'order-addresses')]//span[text()='Address Information']");

    public By getTotalTax1() {
        return totalTax1;
    }

    private By totalTax = By.xpath("//tr[@class='summary-total']/td/span[@class='price']");
    private By totalTax1 = By.xpath("//div[@class='summary-collapse']/following::td/span[@class='price']");
    private By billingAddress = By.cssSelector(".order-billing-address address");
    private By shippingAddress = By.cssSelector(".order-shipping-address address");
    private By freightForwardAddress = By.cssSelector(".order-freight-forward-address address");
    private By majorPromoCodeLabel = By.cssSelector("#order-promo-codes .order-promo-code-wrapper:nth-of-type(2) .order-promo-code-value");
    private By minorPromoCodeLabel = By.cssSelector("#order-promo-codes .order-promo-code-wrapper:nth-of-type(3) .order-promo-code-value");
    private By orderChannelLabel = By.cssSelector("#order-promo-codes .order-promo-code-wrapper:nth-of-type(4) .order-promo-code-value");
    private By orderComments = By.cssSelector(".note-list-comment");
    private By productNamesInItemOrderedList = By.cssSelector(".product-title");
    private By skuNumbersInItemOrderedList = By.cssSelector(".product-sku-block");
    public By IncomeMsgClose = By.xpath("//h1[contains(text(),'Incoming Message')]//following-sibling::button");
    private By originalPrice = By.cssSelector("tbody .col-price-original span");
    private By ItemStatus = By.cssSelector("tbody .col-status");
    private By productPricesListUnderItemOrderedTable = By.cssSelector("tbody .col-price .price-excl-tax span");
    private By productRowSubtotalUnderItemOrderedTable = By.cssSelector("tbody .col-subtotal .price-excl-tax span");

    public By getBookDealerDiscountAmt() {
        return BookDealerDiscountAmt;
    }

    private By BookDealerDiscountAmt = By.cssSelector("tbody .col-book-dealer-discount span");

    public By getMemberDiscount() {
        return MemberDiscount;
    }

    private By MemberDiscount = By.cssSelector("td.col-member-discount span");
    public By paymentDetails = By.cssSelector(".order-payment-method-title");
    public By paymentMethod =By.xpath("(//td[text()='Payment Method']/parent::tr/td)[2]");
    public By receiptMethod =By.xpath("(//td[text()='Receipt Method']/parent::tr/td)[2]");
    private By shippingTableRateDetails = By.cssSelector("div.order-shipping-method .admin__page-section-item-content");
    public By goToMcsLink = By.cssSelector("button#add_mcs_comment");
    private By quantityProduct = By.xpath("//th[contains(text(),'Ordered')]//following-sibling::td");
    private By rowTotal = By.cssSelector("td.col-total span");
    private By mcsComment = By.cssSelector(".note-list li.note-list-item:nth-of-type(1) .note-list-comment");
    private By mcsCommentXpath = By.xpath("(//div[contains(text(),'MCS Committee Application')])[1]");
    private By mcsUpdateLinkColumnHeader = By.xpath("//th[contains(text(),'MCS Committee Update')]");
    private By creditHoldPopupMessage = By.xpath("//div[contains(text(),'This account is on credit hold and you cannot place an order for the account at this time.')]");
    private By creditHoldOkMessage = By.cssSelector("aside.modal-popup:nth-child(2) button:nth-child(1)");
    private By resubmitButton = By.cssSelector("button#order_resubmit");
    private By consortiaFlag = By.cssSelector("table.order-information-table tbody tr:nth-of-type(6) td");
    private By consortiaColumn = By.xpath("(//div[contains(text(),'Consortia')])[1]");
    private By orderPushedToEbsComment = By.xpath("//div[@class='order_comments']//div[contains(text(),'The order was pushed to EBS')]");
    public By AddLearnersBtn = By.xpath("//button[contains(text(),'Add Learners')]");
    public By FirstName = By.xpath("//table[@class='data-table data-grid']//following::td/input[contains(@name,'firstname')]");
    public By LastName = By.xpath("//table[@class='data-table data-grid']//following::td/input[contains(@name,'lastname')]");
    public By Email = By.xpath("//input[@type='email']");
    public By Phone = By.xpath("//table[@class='data-table data-grid']//following::td/input[contains(@name,'phone')]");
    public By Submit = By.xpath("//span[text()='Import CSV']/../following::button[1]");
    public By Refresh = By.xpath("//span[text()='Refresh']");
    public By CloseBtn = By.xpath("(//button[@class='action-close'])[2]");

    public By getSelectorEbsOrderSuccessMessage(String orderNumber) {
        return By.xpath("//div[@class='order_comments']//div[contains(text(),'EBS order update request received: {\"ebsOrderNumber\":\"" + orderNumber + "\",\"ebsOrderStatus\":\"Success\"}')]");
    }

    public By OrderContact = By.xpath("(//div[@class='admin__page-section-item-content'])[3]");
    public By OrderContact1 = By.xpath("(//div[@class='admin__page-section-item-content'])[4]");
    private By notifyByEmailCheckbox = By.cssSelector("label[for='history_notify']");
    private By commentTextArea = By.cssSelector("#history_comment");
    private By submitCommentButton = By.cssSelector("button[title='Submit Comment']");
    private By spinnerIcon = By.cssSelector("div.popup-loading");
    private By invoiceButton = By.cssSelector("button#order_invoice");
    private By invoiceCreatedMessage = By.xpath("//div[contains(text(),'The invoice has been created.')]");

    public By getTransactionGridTab() {
        return transactionGridTab;
    }

    public String getTransactionGridTabData_RequestPayload() {
        WebElement ele=driver.findElement(By.xpath("(//div[text()='webapi_rest']/parent::td/following-sibling::td[1])[1]"));
        return ele.getText();
   }

    public String getTransactionGridTabData_ResponsePayload() {
        WebElement ele=driver.findElement(By.xpath("(//div[text()='webapi_rest']/parent::td/following-sibling::td[2])[1]"));
        return ele.getText();
    }


    private By transactionGridTab = By.cssSelector("a#sales_order_view_tabs_order_payloads");


    public By getCommentHistoryTab() {
        return commentHistoryTab;
    }

    private By commentHistoryTab = By.cssSelector("a#sales_order_view_tabs_order_history");
    private By invoiceTab = By.cssSelector("a#sales_order_view_tabs_order_invoices");
    private By creditMemoButton = By.cssSelector("button#order_creditmemo");

    public By orderPaymentCardType() {
        return By.xpath("//th[text()='Credit Card Type:']/following-sibling::td");
    }

    public By orderPaymentCCnumber() {
        return By.xpath("//th[text()='Credit Card Number:']/following-sibling::td");
    }

    private By creditMemoTab = By.cssSelector("a#sales_order_view_tabs_order_creditmemos");
    private By shipButton = By.cssSelector("button#order_ship");
    private By shipmentTab = By.cssSelector("a#sales_order_view_tabs_order_shipments");
    private By shipmentCreateSuccessMessage = By.xpath("//div[contains(text(),'The shipment has been created.')]");
    private By okButtonOnPopup = By.cssSelector("button.action-accept");
    private By creditMemoSuccessMessage = By.xpath("//div[contains(text(),'You created the credit memo.')]");
    private By sendEmailButton = By.cssSelector("button#send_notification");
    private By emailLabel = By.cssSelector("table.order-account-information-table tbody tr:nth-of-type(2) td");

    public By getEmailValUnderAccInfoSection() {
        return emailValUnderAccInfoSection;
    }

    private By emailValUnderAccInfoSection = By.xpath("//a[contains(@href,'mailto')]");
    private By notifyByEmailCheckboxInputTag = By.cssSelector("input#history_notify");
    private By nonRoyalProductRemoveInfoMessage = By.xpath("//div[contains(text(), 'All non-Royalty product(s) have been removed from the order and order') and contains(text(), 'All non-Royalty product(s) have been removed from the order and order')]");
    private By orderTotalLabels = By.cssSelector(".order-subtotal-table tbody tr td.label");
    private By orderTotalPrice = By.cssSelector(".order-subtotal-table tbody tr td.label + td");
    private By orderTotalFootLabels = By.cssSelector(".order-subtotal-table tfoot tr td.label");
    private By orderTotalFootPrice = By.cssSelector(".order-subtotal-table tfoot tr td.label + td");
    private By taxUnderItemOrderedTable = By.cssSelector("tbody .col-tax-amount span");
    private By membershipDiscountsUnderItemOrderedTable = By.cssSelector("tbody .col-member-discount span");
    //    private By orderStatusLabel = By.cssSelector(".order-information-table tbody tr:nth-of-type(5) td");
    private By orderStatusLabel = By.cssSelector(".order-information-table tbody tr:nth-of-type(7) td");
    private By orderStatusDropDown = By.cssSelector("select#history_status");
    private By payloadTab = By.cssSelector("a#sales_order_view_tabs_order_payloads");
    private By recoveryPointDropDown = By.cssSelector("select#recovery_point");
    private By resubmitButtonOnPopup = By.xpath("(//span[contains(text(),'Re-Submit')])[2]");
    private By cancelButtonOnPopup = By.cssSelector("button.action-dismiss");
    private By selectRecoveryPointLabel = By.xpath("//span[contains(text(),'Select starting point for order resubmit.')]");
    private By maeOrderStatus = By.cssSelector("span#mae_status");
    private By backButton = By.cssSelector("button#back");
    private By membershipNoticeLabel = By.cssSelector("div[data-ui-id='messages-message-notice']");
    private By ebsSkuLabelUnderItemOrderedTable = By.cssSelector("div[id*='ebs_sku'] span");
    private By MagentoOrdernum = By.xpath("//h1[@class='page-title']");
    private By EBSOrderNumber = By.xpath("//th[text()='EBS Order Number']/../td");
    private By EBSOrderSKUFromOrderPage = By.xpath("//table[contains(@class,'order-table')]/tbody/tr/td/div[contains(@id,'ebs_sku')]/span");
    public By NoPaymentMethodlabel = By.xpath("//div[@id='order-billing_method']/div[2]//label");
    private By searchTextField = By.cssSelector("input[placeholder='Search by keyword']");


    private By StandardServicePrice = By.xpath("//strong[contains(text(),'Standard Service')]/following-sibling::span");
    public By CustomerName = By.xpath("//tbody/tr[1]/th[contains(text(),'Customer Name')]/../td/a");
    public By ItemsOrdered = By.xpath("//span[text()='Items Ordered']");
    public By OrderedSKU = By.xpath("//div[@class='product-sku-block']");
    public By AccountInfoCustName = By.xpath("//h1[@class='page-title']");
    public By createReorderHeader = By.xpath("//h1[contains(text(),'Create New Order')]");


    public By getOrderHeaderCreateNewOrderPgae() {
        return orderHeaderCreateNewOrderPgae;
    }

    public By getCustomerOrOrganizationNameOnAccountInformation() {
        return customerOrOrganizationNameOnAccountInformation;
    }

    public By getProductNamesInItemOrderedList() {
        return productNamesInItemOrderedList;
    }

    public List<String> getProductNamesInItemOrderedListInString() {
        List<WebElement> list1=getElementsNew(productNamesInItemOrderedList);
        List<String> productNamesInItemOrderedList1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            productNamesInItemOrderedList1.add(ele.getText());
        }
        return productNamesInItemOrderedList1;
    }

    public By getSkuNumbersInItemOrderedList() {
        return skuNumbersInItemOrderedList;
    }

    public List<String> getSkuNumbersInItemOrderedListInString() {
        List<WebElement> list1=getElementsNew(skuNumbersInItemOrderedList);
        List<String> skuNumbersInItemOrderedList1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            skuNumbersInItemOrderedList1.add(ele.getText().substring(5));
        }
        return skuNumbersInItemOrderedList1;
    }

    public By getOriginalPrice() {
        return originalPrice;
    }

    public List<String> getOriginalPriceInString() {
        List<WebElement> list1=getElementsNew(originalPrice);
        List<String> originalPrice1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            originalPrice1.add(ele.getText());
        }
        return originalPrice1;
    }

    public List<String> getItemStatusInString() {
        List<WebElement> list1=getElementsNew(ItemStatus);
        List<String> ItemStatus1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            ItemStatus1.add(ele.getText().trim());
        }
        return ItemStatus1;
    }

    public By getProductPricesListUnderItemOrderedTable() {
        return productPricesListUnderItemOrderedTable;
    }

    public List<String> getProductPricesListUnderItemOrderedTableInString() {
        List<WebElement> list1=getElementsNew(productPricesListUnderItemOrderedTable);
        List<String> productPricesListUnderItemOrderedTable1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            productPricesListUnderItemOrderedTable1.add(ele.getText());
        }
        return productPricesListUnderItemOrderedTable1;
    }

    public List<WebElement> getProductPricesUnderItemOrderedTable() {
        return driver.findElements(productPricesListUnderItemOrderedTable);
    }

    public By getProductRowSubtotalUnderItemOrderedTable() {
        return productRowSubtotalUnderItemOrderedTable;
    }

    public List<String> getProductRowSubtotalUnderItemOrderedTableInString() {
        List<WebElement> list1=getElementsNew(productRowSubtotalUnderItemOrderedTable);
        List<String> productRowSubtotalUnderItemOrderedTable1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            productRowSubtotalUnderItemOrderedTable1.add(ele.getText());
        }
        return productRowSubtotalUnderItemOrderedTable1;
    }

    public String getBilledOrderContact() {
        WebElement ele = driver.findElement(By.xpath("(//div[@class='admin__page-section-item-content'])[3]"));
        return ele.getText().replaceAll("Contact:", "");
    }

    public String getShippedOrderContact() {
        WebElement ele = driver.findElement(By.xpath("(//div[@class='admin__page-section-item-content'])[4]"));
        return ele.getText().replaceAll("Contact:", "");
    }


    public By getSendEmailButton() {
        return sendEmailButton;
    }

    public By getOrderTotalLabels() {
        return orderTotalLabels;
    }

    public By getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public By getOrderTotalFootLabels() {
        return orderTotalFootLabels;
    }

    public By getOrderTotalFootPrice() {
        return orderTotalFootPrice;
    }

    /**
     * @return ebsSkuLabelUnderItemOrderedTable
     */
    public By getEbsSkuLabelUnderItemOrderedTable() {
        return ebsSkuLabelUnderItemOrderedTable;
    }

    /**
     * @return membershipNoticeLabel
     */
    public By getMembershipNoticeLabel() {
        return membershipNoticeLabel;
    }

    /**
     * @return backButton
     */
    public By getBackButton() {
        return backButton;
    }

    /**
     * @return maeOrderStatus
     */
    public By getMaeOrderStatus() {
        return maeOrderStatus;
    }

    /**
     * @return selectRecoveryPointLabel
     */
    public By getSelectRecoveryPointLabel() {
        return selectRecoveryPointLabel;
    }

    /**
     * @return cancelButtonOnPopup
     */
    public By getCancelButtonOnPopup() {
        return cancelButtonOnPopup;
    }

    /**
     * @return resubmitButtonOnPopup
     */
    public By getResubmitButtonOnPopup() {
        return resubmitButtonOnPopup;
    }

    /**
     * @return recoveryPointDropDown
     */
    public By getRecoveryPointDropDown() {
        return recoveryPointDropDown;
    }

    /**
     * @return payloadTab
     */
    public By getPayloadTab() {
        return payloadTab;
    }

    /**
     * @return orderStatusDropDown
     */
    public By getOrderStatusDropDown() {
        return orderStatusDropDown;
    }

    /**
     * @return orderStatusLabel
     */
    public By getOrderStatusLabel() {
        return orderStatusLabel;
    }

    /**
     * @return membershipDiscountsUnderItemOrderedTable
     */
    public By getMembershipDiscountsUnderItemOrderedTable() {
        return membershipDiscountsUnderItemOrderedTable;
    }

    /**
     * @return taxUnderItemOrderedTable
     */
    public By getTaxUnderItemOrderedTable() {
        return taxUnderItemOrderedTable;
    }

    public List<String> getTaxUnderItemOrderedTableInString() {
        List<WebElement> list1=getElementsNew(taxUnderItemOrderedTable);
        List<String> taxUnderItemOrderedTable1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            taxUnderItemOrderedTable1.add(ele.getText());
        }
        return taxUnderItemOrderedTable1;
    }

    /**
     * @return nonRoyalProductRemoveInfoMessage
     */
    public By getNonRoyalProductRemoveInfoMessage() {
        return nonRoyalProductRemoveInfoMessage;
    }

    /**
     * @return notifyByEmailCheckboxInputTag
     */
    public By getNotifyByEmailCheckboxInputTag() {
        return notifyByEmailCheckboxInputTag;
    }

    /**
     * @return emailLabel
     */
    public By getEmailLabel() {
        return emailLabel;
    }

    /**
     * @return sendEmailButton
     */
    public By getsendEmailButton() {
        return sendEmailButton;
    }


    /**
     * @return creditMemoSuccessMessage
     */
    public By getCreditMemoSuccessMessage() {
        return creditMemoSuccessMessage;
    }

    /**
     * @return okButtonOnPopup
     */
    public By getOkButtonOnPopup() {
        return okButtonOnPopup;
    }

    /**
     * @return shipmentCreateSuccessMessage
     */
    public By getShipmentCreateSuccessMessage() {
        return shipmentCreateSuccessMessage;
    }

    /**
     * @return shipmentTab
     */
    public By getShipmentTab() {
        return shipmentTab;
    }

    /**
     * @return shipButton
     */
    public By getShipButton() {
        return shipButton;
    }

    /**
     * @return creditMemoTab
     */
    public By getCreditMemoTab() {
        return creditMemoTab;
    }

    /**
     * @return creditMemoButton
     */
    public By getCreditMemoButton() {
        return creditMemoButton;
    }

    /**
     * @return invoiceTab
     */
    public By getInvoiceTab() {
        return invoiceTab;
    }

    /**
     * @return invoiceCreatedMessage
     */
    public By getInvoiceCreatedMessage() {
        return invoiceCreatedMessage;
    }

    /**
     * @return Customer Name from Account Information Section
     */
    public String getCustomerName() {
        return getElement(customerOrOrganizationNameOnAccountInformation).getText();
    }

    public By ActInformationOrganizationName() {
        return customerOrOrganizationNameOnAccountInformation;
    }

    /**
     * @return invoiceButton
     */
    public By getInvoiceButton() {
        return invoiceButton;
    }

    /**
     * @return spinnerIcon
     */
    public By getSpinnerIcon() {
        return spinnerIcon;
    }

    /**
     * @return submitCommentButton
     */
    public By getSubmitCommentButton() {
        return submitCommentButton;
    }

    /**
     * @return commentTextArea
     */
    public By getCommentTextArea() {
        return commentTextArea;
    }

    /**
     * @return notifyByEmailCheckbox
     */
    public By getNotifyByEmailCheckbox() {
        return notifyByEmailCheckbox;
    }

    /**
     * @return orderPushedToEbsComment
     */
    public By getOrderPushedToEbsComment() {
        return orderPushedToEbsComment;
    }

    /**
     * @return consortiaColumn
     */
    public By getConsortiaColumn() {
        return consortiaColumn;
    }

    /**
     * @return consortiaFlag
     */
    public By getConsortiaFlag() {
        return consortiaFlag;
    }

    /**
     * @return resubmitButton
     */
    public By getResubmitButton() {
        return resubmitButton;
    }

    /**
     * @return creditHoldOkMessage
     */
    public By getCreditHoldOkMessage() {
        return creditHoldOkMessage;
    }

    /**
     * @return creditHoldPopupMessage
     */
    public By getCreditHoldPopupMessage() {
        return creditHoldPopupMessage;
    }

    /**
     * @return orderComments
     */
    public By getOrderComments() {
        return orderComments;
    }

    /**
     * @return mcsUpdateLinkColumnHeader
     */
    public By getMcsUpdateLinkColumnHeader() {
        return mcsUpdateLinkColumnHeader;
    }

    /**
     * @return mcsCommentXpath
     */
    public By getMcsCommentXpath() {
        return mcsCommentXpath;
    }

    /**
     * @return mcsComment
     */
    public By getMcsComment() {
        return mcsComment;
    }

    /**
     * @param mcsComment
     */
    public void setMcsComment(By mcsComment) {
        this.mcsComment = mcsComment;
    }

    /**
     * @return rowTotal
     */
    public By getRowTotal() {
        return rowTotal;
    }

    /**
     * @return order Header
     */
    public By orderHeader() {
        return orderHeaderCreateNewOrderPgae;
    }

    /**
     * @return quantityProduct
     */
    public By getQuantityProduct() {
        return quantityProduct;
    }

    public List<String> getQuantityProductInString() {
        List<WebElement> list1=getElementsNew(quantityProduct);
        List<String> quantityProduct1=new ArrayList<String>();
        for(WebElement ele:list1)
        {
            quantityProduct1.add(ele.getText());
        }
        return quantityProduct1;
    }

    /**
     * @return goToMcsLink
     */
    public By getGoToMcsLink() {
        return goToMcsLink;
    }

    /**
     * @return shippingTableRateDetails
     */
    public By getShippingTableRateDetails() {
        return shippingTableRateDetails;
    }

    /**
     * @return paymentDetails
     */
    public By getPaymentDetails() {
        return paymentDetails;
    }
    public By getPaymentMethod() {
        return paymentMethod;
    }
    public By getReceiptMethod() {
        return receiptMethod;
    }

    /**
     * @return orderChannelLabel
     */
    public By getOrderChannelLabel() {
        return orderChannelLabel;
    }

    /**
     * @return minorPromoCodeLabel
     */
    public By getMinorPromoCodeLabel() {
        return minorPromoCodeLabel;
    }

    /**
     * @return majorPromoCodeLabel
     */
    public By getMajorPromoCodeLabel() {
        return majorPromoCodeLabel;
    }

    /**
     * @return the billingAddress
     */
    public By getBillingAddress() {
        return billingAddress;
    }

    /**
     * @return the shippingAddress
     */
    public By getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @return the freightForwardAddress
     */
    public By getFreightForwardAddress() {
        return freightForwardAddress;
    }

    /**
     * @return the grandTotalExclTax
     */
    public By getGrandTotalExclTax() {
        return grandTotalExclTax;
    }

    public By getGrandTotalStu() {
        return GrandTotalStu;
    }

    public By gettotalPaidStu() {
        return totalPaidStu;
    }

    public By gettotalRefundedStu() {
        return totalRefundedStu;
    }

    public By gettotalDueStu() {
        return totalDueStu;
    }



    /**
     * @return the grandTotalInclTax
     */
    public By getGrandTotalInclTax() {
        return grandTotalInclTax;
    }


    /**
     * @return the subTotalLabel
     */
    public By getSubTotalLabel() {
        return subTotalLabel;
    }

    /**
     * @return the ccTerminalPaymentMethod
     */
    public By getCcTerminalPaymentMethod() {
        return ccTerminalPaymentMethod;
    }

    /**
     * @return the ccTerminalReceiptMethod
     */
    public By getCcTerminalReceiptMethod() {
        return ccTerminalReceiptMethod;
    }

    /**
     * @return the ccTerminalIdentifyNumber
     */
    public By getCcTerminalIdentifyNumber() {
        return ccTerminalIdentifyNumber;
    }

    /**
     * @return the ccTerminalAmount
     */
    public By getCcTerminalAmount() {
        return ccTerminalAmount;
    }

    /**
     * @return the orderNumber
     */
    public By getOrderNumber() {
        return orderNumber;
    }

    /**
     * @return the orderDate
     */
    public By getOrderDate() {
        return orderDate;
    }

    /**
     * @return the errorMessage
     */
    public By getErrorMessage() {
        return errorMessage;
    }

    /**
     * @return the astmStandardShippingInformation
     */
    public By getAstmStandardShippingInformation() {
        return astmStandardShippingInformation;
    }

    /**
     * @return the startDateUnderProduct
     */
    public By getStartDateUnderProduct() {
        return startDateUnderProduct;
    }

    /**
     * @return the publishDateUnderProduct
     */
    public By getPublishDateUnderProduct() {
        return publishDateUnderProduct;
    }

    /**
     * @return the subscriptionTypeUnderProduct
     */
    public By getSubscriptionTypeUnderProduct() {
        return subscriptionTypeUnderProduct;
    }

    /**
     * @return the purchagedFrom
     */
    public By getPurchagedFrom() {
        return purchagedFrom;
    }

    /**
     * @return the reorderButton
     */
    public By getReorderButton() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return reorderButton;
    }

    /**
     * @return the ebsOrderStatus
     */
    public By getEbsOrderStatus() {
        return ebsOrderStatus;
    }

    /**
     * @return the customerPoNumber
     */
    public By getCustomerPoNumber() {
        return customerPoNumber;
    }

    /**
     * @return the orderType
     */
    public By getOrderType() {
        return orderType;
    }

    /**
     * @return the contactUnderProductList
     */
    public By getContactUnderProductList() {
        return contactUnderProductList;
    }

    /**
     * @return the shippingAndHandlingChargesLabel
     */
    public By getShippingAndHandlingChargesLabel() {
        return shippingAndHandlingChargesLabel;
    }

    /**
     * @return the shippingMethodLabel
     */
    public By getShippingMethodLabel() {
        return shippingMethodLabel;
    }

    /**
     * @return the shippingAccountNumberLabel
     */
    public By getShippingAccountNumberLabel() {
        return shippingAccountNumberLabel;
    }

    /**
     * @return the contactUnderBillingAddress
     */
    public By getContactUnderBillingAddress() {
        return contactUnderBillingAddress;
    }

    /**
     * @return the contactUnderShippingAddress
     */
    public By getContactUnderShippingAddress() {
        return contactUnderShippingAddress;
    }

    /**
     * @return the contactUnderFrieghtForwardAddress
     */
    public By getContactUnderFrieghtForwardAddress() {
        return contactUnderFrieghtForwardAddress;
    }

    /**
     * @return the ebsOrderNumber
     */
    public By getEbsOrderNumber() {
        return ebsOrderNumber;
    }

    public By getEbsOrderEventStatus() {
        return ebsOrderEventStatus;
    }


    /**
     * @return getOrderCreationSuccessMessage
     */
    public By getOrderCreationSuccessMessage() {
        return orderCreationSuccessMessage;
    }

    public String getMaeUser(int index) {

        return getElement(By.xpath("(//*[text()='Mae User']/following::tbody[1]/tr/td[6]/span)[" + index + "]")).getText();

    }

    public String getMaeEnrollment(int index) {

        return getElement(By.xpath("(//*[text()='Mae Enrollment']/following::tbody[1]/tr/td[7]/span)[" + index + "]")).getText();

    }

    public String getEmailActivation(int index) {

        return getElement(By.xpath("(//*[text()='Email Activation']/following::tbody[1]/tr/td[8]/span)[" + index + "]")).getText();

    }

    public String getSabaUser(int index) {

        return getElement(By.xpath("(//*[text()='Saba User']/following::tbody[1]/tr/td[9]/span)[" + index + "]")).getText();

    }

    public String getSabaEnrollment(int index) {

        return getElement(By.xpath("(//*[text()='Saba Enrollment']/following::tbody[1]/tr/td[10]/span)[" + index + "]")).getText();

    }

    public String getAccountInfoCustomerName() {
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AccountInfoCustName), 10);
        return getElement(AccountInfoCustName).getText();
    }

    /**
     * This method refresh page and check if order is failed, stuck in sent or order is success
     * This method is added to reduce no of time page is refreshed to check order status
     *
     * @return true if order is failure or success, false if order is stuck on sent
     */
    public boolean handleRefreshOfPage() {
        try {
            String status = "";
            for (int i = 0; i <= 20; i++) {
                PublicCommon.waitForSec(10);
                driver.navigate().refresh();
                PublicCommon.waitForSec(5);
                status = getElementNew(ebsOrderStatus).getText();
                if (status.contains("ERROR") || status.equals("Success")) {
                    log.info("Order Comments for order number " + getElementNew(orderNumber).getText()
                            + ": " + PublicAdminCommons.getTextOfWebElements(driver, orderComments));
                    return true;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void handleRefreshOfPagenooftimes(int num) {
        try {
            for (int i = 1; i <= num; i++) {
                PublicCommon.waitForSec(10);
                driver.navigate().refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        public List<Product_PublicAdmin> getProductDetails() {
        try {
            List<Product_PublicAdmin> productObjects = new ArrayList<Product_PublicAdmin>();
            List<WebElement> productNames = getElementsNew(productNamesInItemOrderedList);
            List<WebElement> productSkus = getElementsNew(getSkuNumbersInItemOrderedList());
            List<WebElement> productPrices = getElementsNew(getProductPricesListUnderItemOrderedTable());
            List<WebElement> productRowSubtotals = getElementsNew(productRowSubtotalUnderItemOrderedTable);
            List<WebElement> startDates = getElementsNew(startDateUnderProduct);
            List<WebElement> publishDates = getElementsNew(publishDateUnderProduct);
            List<WebElement> subscriptionTypes = getElementsNew(subscriptionTypeUnderProduct);
            List<WebElement> productQuantities = getElementsNew(quantityProduct);
            List<WebElement> rowTotalPrice = getElementsNew(rowTotal);
            List<WebElement> taxAmounts = getElementsNew(taxUnderItemOrderedTable);
            List<WebElement> membershipDiscounts = getElementsNew(membershipDiscountsUnderItemOrderedTable);
            for (WebElement productName : productNames) {
                int index = productNames.indexOf(productName);
                Product_PublicAdmin product = new Product_PublicAdmin(productName.getText(),
                        productSkus.get(index).getText());
                product.setPrice(productPrices.get(index).getText());
                product.setRowSubTotal(productRowSubtotals.get(index).getText());
                product.setStartDate(startDates.get(index).getText().trim()
                        .replace("Start Date: ", ""));
                product.setPublishDate(publishDates.get(index).getText().trim()
                        .replace("Publish Date: ", ""));
                product.setSubscriptionType(subscriptionTypes.get(index).getText().trim()
                        .replace("Subscription Type: ", ""));
                product.setQuantity(productQuantities.get(index).getText());
                product.setTotalPriceWithTax(rowTotalPrice.get(index).getText());
                product.setTax(taxAmounts.get(index).getText());
                product.setMembershipDiscount(membershipDiscounts.get(index).getText());
                productObjects.add(product);
            }
            return productObjects;
        } catch (Exception e) {
            log.info(e);
            e.printStackTrace();
            return null;
        }
    }

    @Step("Get Magento Order Number")
    public String getMagentoOrderNumber() {
        try {
            WaitStatementUtils.explicitWait(driver,getElement(MagentoOrdernum));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return getElement(MagentoOrdernum).getText().split("#")[1].trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Get Magento Order Account Info")
    public String getMagentoOrderAccountInfo(int index) {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return driver.findElement(By.xpath("//table[contains(@class,'order-account-information')]/tbody/tr["+index+"]/td/a")).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Get Magento Order Number")
    public String getMagentoEBSOrderNumber() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(EBSOrderNumber));
            return getElement(EBSOrderNumber).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Get Magento Order EBS SKU code")
    public String getMagentoOrderEBSSKUCode() {
        try {
            ReusableMethods.scrollIntoView(getElement(EBSOrderSKUFromOrderPage),driver);
            return getElement(EBSOrderSKUFromOrderPage).getText().split(":")[1].trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product_PublicAdmin> getProductDetailsReplaceExtraChar() {
        try {
            List<Product_PublicAdmin> productObjects = new ArrayList<Product_PublicAdmin>();
            List<WebElement> productNames = getElementsNew(productNamesInItemOrderedList);
            List<WebElement> productSkus = getElementsNew(getSkuNumbersInItemOrderedList());
            List<WebElement> productPrices = getElementsNew(getProductPricesListUnderItemOrderedTable());
            List<WebElement> productRowSubtotals = getElementsNew(productRowSubtotalUnderItemOrderedTable);
            List<WebElement> startDates = getElementsNew(startDateUnderProduct);
            List<WebElement> publishDates = getElementsNew(publishDateUnderProduct);
            List<WebElement> subscriptionTypes = getElementsNew(subscriptionTypeUnderProduct);
            List<WebElement> productQuantities = getElementsNew(quantityProduct);
            List<WebElement> rowTotalPrice = getElementsNew(rowTotal);
            List<WebElement> taxAmounts = getElementsNew(taxUnderItemOrderedTable);
            List<WebElement> membershipDiscounts = getElementsNew(membershipDiscountsUnderItemOrderedTable);
            for (WebElement productName : productNames) {
                int index = productNames.indexOf(productName);
                Product_PublicAdmin product = new Product_PublicAdmin(productName.getText(),
                        productSkus.get(index).getText());
                product.setPrice(productPrices.get(index).getText().replace("$", "").replace("-", "").replace(",", ""));
                product.setRowSubTotal(productRowSubtotals.get(index).getText().replace("$", "").replace("-", "").replace(",", ""));
                product.setStartDate(startDates.get(index).getText().trim()
                        .replace("Start Date: ", ""));
                product.setPublishDate(publishDates.get(index).getText().trim()
                        .replace("Publish Date: ", ""));
                product.setSubscriptionType(subscriptionTypes.get(index).getText().trim()
                        .replace("Subscription Type: ", ""));
                product.setQuantity(productQuantities.get(index).getText());
                product.setTotalPriceWithTax(rowTotalPrice.get(index).getText().replace("$", "").replace("-", "").replace(",", ""));
                product.setTax(taxAmounts.get(index).getText().replace("$", "").replace("-", "").replace(",", ""));
                product.setMembershipDiscount(membershipDiscounts.get(index).getText().replace("$", "").replace("-", "").replace(",", ""));
                productObjects.add(product);
            }
            return productObjects;
        } catch (Exception e) {
            log.info(e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets mcs comment
     */
    public String getMcsCommentFromPage() {
        try {
            String comment = getElementNew(mcsComment).getText();
            return comment;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Gets order total hashmap
     */
    public HashMap<String, String> getOrderTotalsHashMap() {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> labels = PublicAdminCommons.getTextOfWebElements(driver, orderTotalLabels);
            List<String> prices = PublicAdminCommons.getTextOfWebElements(driver, getOrderTotalPrice());
            for (String label : labels)
                orderTotals.put(label.trim(), prices.get(labels.indexOf(label)));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getOrderNumberAdmin() {
        try {
            ReusableMethods.scrollIntoView(getElement(orderNumber), driver);
            return getElement(orderNumber).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets order total hashmap
     */
    public HashMap<String, String> getOrderTotalsHashMapWithReplacedCharacters() {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> labels = PublicAdminCommons.getTextOfWebElements(driver, orderTotalLabels);
            List<String> prices = PublicAdminCommons.getTextOfWebElements(driver, getOrderTotalPrice());
            for (String label : labels)
                orderTotals.put(label.trim(), prices.get(labels.indexOf(label)).replace("$", "").replace("-", "").replace(",", ""));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets order total hashmap
     */
    public HashMap<String, String> getOrderTotalsFootHashMapWithReplacedCharacters() {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> labels = PublicAdminCommons.getTextOfWebElements(driver, orderTotalFootLabels);
            List<String> prices = PublicAdminCommons.getTextOfWebElements(driver, orderTotalFootPrice);
            for (String label : labels)
                orderTotals.put(label.trim(), prices.get(labels.indexOf(label)).replace("$", "").replace("-", "").replace(",", ""));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public By getStandardServicePrice() {
        return StandardServicePrice;
    }

    public String CustomerNameField() {
        return getElement(CustomerName).getText();
    }

    public void clickCustomerName() {
        getElement(CustomerName).click();
    }

    @Step("Navigate to Orders Page and search created order")
    public void navigateToOrdersPageInAdmin(String OrderNo) {
        try {
            adminMenuNavigation= getInstance(MenuNavigationPage_PublicAdmin.class);
            AllCustomerPage = getInstance(AllCustomerPage_PublicAdmin.class);

            adminMenuNavigation.waitForLoadingScreenToDisappear();
            PublicCommon.waitForSec(3);
            adminMenuNavigation.navigatesToOrdersTab();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            PublicCommon.waitForSec(3);
            WaitStatementUtils.waitForElementToBeClickable(driver,
                    getElement(adminMenuNavigation.clearAllButtonOrders), 10);
            if (getElement(adminMenuNavigation.clearAllButtonOrders).isDisplayed()) {
                PublicCommon.JSClick(getElement(adminMenuNavigation.clearAllButtonOrders), driver);
            }
            AllCustomerPage.enterTextInSearchTextField(OrderNo);
            WaitStatementUtils.waitForElementStaleness(driver, getElement(AllCustomerPage.getSearchButton()), 10);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AllCustomerPage.getSearchButton()), 10);
            getElementNew(searchTextField).sendKeys(Keys.ENTER);
            clickOnMethod("Unable to Click on Search Button", getElement(AllCustomerPage.getSearchButton()));
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getInstance(CommonPage_Public.class).ViewBtn), 10);
            getInstance(CommonPage_Public.class).ViewBtn().click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("admin/sales/order/view/order_id"));
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to navigate to Orders Page and Search Order .", e);
        }
    }

    @Step("Navigate to Orders Page and search created order")
    public void navigateToAllCustomersPageInAdmin(String Email) {
        try {
            adminMenuNavigation= getInstance(MenuNavigationPage_PublicAdmin.class);
            AllCustomerPage = getInstance(AllCustomerPage_PublicAdmin.class);

            adminMenuNavigation.waitForLoadingScreenToDisappear();
            adminMenuNavigation.navigatesToAllCustomerTab();
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            WaitStatementUtils.explicitWaitForVisibility(driver,
                    getElement(adminMenuNavigation.clearAllButtonOrders), 10);
            if (getElement(adminMenuNavigation.clearAllButtonOrders).isDisplayed()) {
                PublicCommon.JSClick(getElement(adminMenuNavigation.clearAllButtonOrders), driver);
            }
            AllCustomerPage.enterTextInSearchTextField(Email);
            WaitStatementUtils.waitForElementStaleness(driver, getElement(AllCustomerPage.getSearchButton()), 10);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(AllCustomerPage.getSearchButton()), 10);
            getElementNew(searchTextField).sendKeys(Keys.ENTER);
            clickOnMethod("Unable to Click on Search Button", getElement(AllCustomerPage.getSearchButton()));
            Assert.assertTrue(
                    PublicAdminCommons.waitElementToDisappearFromScreen(driver, AllCustomerPage.getSpinnerIcon()),
                    "Unable to handle loading screen");
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ProductPage_PublicAdmin.totalrow), 10);
            getElement(ProductPage_PublicAdmin.totalrow).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("admin/customer/index"));
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to navigate to Orders Page and Search Order .", e);
        }
    }

    @Step("Verify payment, shipping and additional details,Promo Codes and Items Ordered")
    public void verifyallDetailesInformationPage(int Price, String Major, String Minor, String Product, String PaymentType) {
        try {
            PublicAdminCommons.scrollToElement(driver, getPaymentDetails());
            String PaymentTypeOrderView = getElement(getPaymentDetails()).getText();
            Assert.assertEquals(PaymentTypeOrderView, PaymentType,
                    "Both payment method not matched");
            /*String ShippingTableRates = getElement(getAstmStandardShippingInformation()).getText();
            Assert.assertEquals(ShippingTableRates, "Shipping Table Rates - Standard Service $0.00",
                    "Shipping & Handling Information not matched");*/
            PublicAdminCommons.scrollToElement(driver, getMajorPromoCodeLabel());
            String MajorPromoCode = getElement(getMajorPromoCodeLabel()).getText();
            Assert.assertEquals(MajorPromoCode, Major, "Major Promo Code not matched");
            String MinorPromoCode = getElement(getMinorPromoCodeLabel()).getText();
            Assert.assertEquals(MinorPromoCode, Minor, "Minor Promo Code not matched");
            String OrderChannel = getElement(getOrderChannelLabel()).getText();
            Assert.assertEquals(OrderChannel, OrderChannel, "Order Channel not matched");
            PublicAdminCommons.scrollToElement(driver, getSkuNumbersInItemOrderedList());
            ScreenshotUtil.takeScreenshotForAllure(driver);
            String ProductSKU = getElement(getSkuNumbersInItemOrderedList()).getText();
            Assert.assertEquals(ProductSKU, "SKU: " + Product, "Products are not matched");
            String StaratDate = getElement(getStartDateUnderProduct()).getText();
            Assert.assertEquals(StaratDate, "Start Date: " + PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy"),
                    "Start Date not matched");
            Assert.assertEquals(getElement(getPublishDateUnderProduct()).getText(), "Publish Date: " + PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy"),
                    "Publish Date not matched");
            Assert.assertEquals(getElement(getProductPricesListUnderItemOrderedTable()).getText(), "$" + Price + ".00",
                    "Price not matched");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("unable to select payment, shipping and additional details", e);
        }
    }

    public void resubmitOrder(String RecoveryPointValue) {
        WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getResubmitButton()), 5);
        if (getElements(getResubmitButton()).size() > 0) {
            clickonmethod("Resubmit Button", getResubmitButton(), "Failed to click on Resubmit button on Order information page");
            WaitStatementUtils.waitForElementStaleness(driver, getElement(getRecoveryPointDropDown()));
            Select recoveryPoint = new Select(getElement(getRecoveryPointDropDown()));
            recoveryPoint.selectByValue(RecoveryPointValue);
            WaitStatementUtils.waitForElementStaleness(driver, getElement(getOkButtonOnPopup()));
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getOkButtonOnPopup()));
            clickonmethod("Ok Button", getOkButtonOnPopup(), "Failed to click on OK button on Re-Submit pop-up");
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getResubmitButtonOnPopup()));
            clickonmethod("Re-Submit Button on Pop-up", getResubmitButtonOnPopup(), "Failed to click on OK button on Re-Submit pop-up");
        }
    }

    public void resubmitOrder() {
        WaitStatementUtils.waitForElementToBeClickable(driver, getElement(getResubmitButton()), 5);
        if (getElements(getResubmitButton()).size() > 0) {
            clickonmethod("Resubmit Button", getResubmitButton(), "Failed to click on Resubmit button on Order information page");
            WaitStatementUtils.waitForElementStaleness(driver, getElement(getRecoveryPointDropDown()));
            clickonmethod("Re-Submit Button on Pop-up", getResubmitButtonOnPopup(), "Failed to click on OK button on Re-Submit pop-up");
        }
    }


    @Step("Click on Go to MCS2 after verfying EBS order status & Login to MCS2")
    public void CheckEBSstatusOnOrderViewScreen() {
        try {
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            driver.navigate().refresh();
            Assert.assertTrue(PublicAdminCommons.getTextOfElement(driver, getEbsOrderStatus())
                    .equals("Success"), " EBS order status is not success");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to click in Go to MCS2", e);
        }
    }

    @Step("Verify EBS order number is generated")
    public void verifyEbsOrderNumberIsGeneratedWithDynamicRefresh() {
        try {
            PublicCommon.waitForSec(45);
            Assert.assertTrue(handleRefreshOfPage(), "Unable to refresh page");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, getEbsOrderStatus(), "Success");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, getMaeOrderStatus()), "success", " MAE order status is not success");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, getOrderType()), "REGULAR ORDER", "OrderType is not same");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, getEbsOrderNumber());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to verify if EBS order number is generated", e);
        }
    }

    @Step("verify admin can add '{learner}'")
    public String verifyAdminCanAddLearners(String MaeUserstatus, String MaeEnrollmentStatus, String EmailStatus, String SabaUserStatus, String SabaEStatus) {
        String email = null;
        try {
            PublicAdminCommons.scrollToElement(driver, AddLearnersBtn);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicCommon.JSClick(getElement(AddLearnersBtn), driver);
            List<WebElement> FirstNames = getElementsNew(FirstName);
            List<WebElement> LastNames = getElementsNew(LastName);
            List<WebElement> Emails = getElementsNew(Email);
            List<WebElement> PhoneNumbers = getElementsNew(Phone);
            List<String> learners = PublicAdminCommons.getTextOfWebElements(driver, By.xpath("//tr[contains(@id,'learner-data-row')]"));
            for (String learner : learners) {
                String FirstName = "TestAuto" + RandomStringUtils.getRandomString(2);
                String lastName = "TestAuto" + RandomStringUtils.getRandomString(2);
                email = "Testlearner" + RandomStringUtils.getRandomString(6) + "@yopmail.com";
                String phone = RandomStringUtils.getRandomNumbers(10);
                FirstNames.get(learners.indexOf(learner)).sendKeys(FirstName);
                LastNames.get(learners.indexOf(learner)).sendKeys(lastName);
                Emails.get(learners.indexOf(learner)).sendKeys(email);
                PhoneNumbers.get(learners.indexOf(learner)).sendKeys(phone);
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(Submit).click();
            for (int i = 1; i <= learners.size(); i++) {
                for (int j = 0; j <= 5; j++) {
                    PublicCommon.waitForSec(30);
                    getElement(Refresh).click();
                    waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    if (getMaeUser(i).equals(MaeUserstatus)
                            && getMaeEnrollment(i).equals(MaeEnrollmentStatus)
                            && getEmailActivation(i).equals(EmailStatus)
                            && getSabaUser(i).equals(SabaUserStatus)
                            && getSabaEnrollment(i).equals(SabaEStatus)) {
                        break;
                    }
                }
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(CloseBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to verify admin can add '{learner}'", e);
        }
        return email;
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

    @Step("INT-2576: Verify Customer Name")
    public void getCustomerNameInOrderInformationPage() {
        try {
            String CustomerName = CustomerNameField();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            clickCustomerName();
            Assert.assertTrue(PublicAdminCommons.switchToTabByIndex(driver, 1), "Unable to switch to other tab");
            PublicCommon.waitForSec(10);
            String AccountInfoCustomerName = getAccountInfoCustomerName();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertEquals(CustomerName, AccountInfoCustomerName);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to get Customer Name details", e);
        }
    }

    @Step("Get Items Ordered")
    public void getItemsOrdered(String SKU) {
        try {
            ReusableMethods.scrollIntoView(getElement(ItemsOrdered), driver);
            String SKUordered = getElement(OrderedSKU).getText().split(":")[1].trim();
            Assert.assertEquals(SKUordered, SKU);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to get Items Ordereds", e);
        }
    }

    public void IncomeMessageModelHeader() {
        try {
            if (IntegrationCommon.isElementdisplayed(driver, getElement(IncomeMsgClose))) {
                WaitStatementUtils.waitForElementStaleness(driver, getElement(IncomeMsgClose));
                IntegrationCommon.clickonWebElement(driver, IncomeMsgClose);
                Assert.assertFalse(getElement(IncomeMsgClose).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if a sku number is present in item ordered list
     *
     * @param skuNumberToValidate
     * @return boolean
     */
    public boolean isSkuNumberIsPresentInItemOrderedList(String skuNumberToValidate) {
        try {
            List<String> listOfAllSkuNumbersUnderItemOrderedList = PublicAdminCommons.getTextOfWebElements(driver,
                    skuNumbersInItemOrderedList);
            for (String skuNumber : listOfAllSkuNumbersUnderItemOrderedList) {
                if (skuNumber.contains(skuNumberToValidate)) {
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

    @Step("Verify selected Address is appearing Post Order")
    public boolean validateAddressPriorPostOrder(String priorAddress, String postOrderAddress) {
        try {
            String postOrderAddressModified = postOrderAddress.split("\n")[0] + ", " +
                    postOrderAddress.split("\n")[1] + ", " +
                    postOrderAddress.split("\n")[2].split(",")[0] +","+
                    postOrderAddress.split("\n")[2].split(",")[1] +
                    postOrderAddress.split("\n")[2].split(",")[2] +","+
                    postOrderAddress.split("\n")[3].trim();
            if (postOrderAddressModified.trim().equals(postOrderAddressModified))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }


    }

    @Step("Verify selected Address is appearing in EBS")
    public boolean validateAddressPriorPostOrderinEBS(String priorAddress, String EBSAddress) {
        try {
            JsonFileReader jsonFileReader = new JsonFileReader();

            String city=priorAddress.split(",")[3].split(" ")[1].trim().toUpperCase();
            String citySuggestedName= jsonFileReader.getJsonString("SuggestedUSCities", "SuggestedUSCities", city);

            String country=priorAddress.split(",")[4].replaceAll(" ","").trim().toUpperCase();
            String countrySuggestedName= jsonFileReader.getJsonString("SuggestedCountries", "SuggestedCountries", country);

            String modifiedpriorAddress=priorAddress.split(",")[1]+","+priorAddress.split(",")[2].trim()+" "+citySuggestedName+" "+priorAddress.split(",")[3].split(" ")[2]+","+countrySuggestedName;

            if (modifiedpriorAddress.trim().equals(EBSAddress))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }


    }
    @Step("Verify subTotal matched pre and post Order ")
    public boolean validateSubtotalPriorPostOrder(String priorSubtotal, String postSubtotal) {
        try {
            if (priorSubtotal.equals(postSubtotal))
                return true;
            else if(Double.parseDouble(priorSubtotal)==Double.parseDouble(postSubtotal))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Shipping Handling Charges matched pre and post Order ")
    public boolean validateShippingHadlingChargesPriorPostOrder(String priorSHCharges, String postSHCharges) {
        try {
            if (priorSHCharges.equals(postSHCharges))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Total tax matched pre and post Order ")
    public boolean validateTotalTaxPriorPostOrder(String priortotalTax, String posttotalTax) {
        try {
            if (priortotalTax.equals(posttotalTax))
                return true;
            else if(Double.parseDouble(priortotalTax)==Double.parseDouble(posttotalTax))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }


    @Step("Verify Grand Total Including tax matched pre and post Order ")
    public boolean  validateGrandTotalIncludingTaxPriorPostOrder(String priorGDwithTax, String postGDwithTax) {
        try {
            if (priorGDwithTax.equals(postGDwithTax))
                return true;
            else if(Double.parseDouble(priorGDwithTax)==Double.parseDouble(postGDwithTax))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }
    @Step("Verify Grand Total Excluding tax matched pre and post Order")
    public boolean validateGrandTotalExcludingTaxPriorPostOrder(String priorGDwithoutTax, String postGDwithoutTax) {
        try {
            if (priorGDwithoutTax.equals(postGDwithoutTax))
                return true;
            else if(Double.parseDouble(priorGDwithoutTax)==Double.parseDouble(postGDwithoutTax))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }



    @Step("Verify Line Item Status matched with API Post Order")
    public boolean validateLineItemStatusPostOrder(String actualLineItemStatus,String expectedLineItemStatus) {
        try {
            if (actualLineItemStatus.equals(expectedLineItemStatus))
                return true;
           else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Contract Duration API Post Order")
    public boolean validateOrderContractDurationPostOrder(String contractStartDate,String contractEndDate) {
        try {
            String startDateString=convertDate_mdy_to_dmy(contractStartDate);
            String endDateString=convertDate_mdy_to_dmy(contractEndDate);

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
            Date startDate = format.parse(startDateString);
            Date endDate = format.parse(endDateString);

            long differenceInMilliseconds = endDate.getTime() - startDate.getTime();

            long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMilliseconds);

            System.out.println("Difference in days: " + differenceInDays);

            if (differenceInDays == 365)
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public String convertDate_mdy_to_dmy(String inputDate)
    {
        String outputFormat = "dd-MM-yy";
        try
        {
            SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yy");
            SimpleDateFormat outputFormatter = new SimpleDateFormat(outputFormat);

            Date date = inputFormat.parse(inputDate);
            String outputDate = outputFormatter.format(date);

            System.out.println("Converted date: " + outputDate);
            return outputDate;
        } catch (Exception e) {
            System.out.println("Error parsing the date: " + e.getMessage());
            return null;
        }
    }


    @Step("Verify Payment Type matched pre and post Order")
    public boolean validatePaymentTypePriorPostOrder(String priorPaymentType, String postPaymentType) {
        try {
            if (priorPaymentType.equals(postPaymentType))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Shipping Method matched pre and post Order")
    public boolean validateShippingMethodPriorPostOrder(String priorShippingMethod, String postShippingMethod) {
        try {
           if (postShippingMethod.contains(priorShippingMethod))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Shipping Charges matched pre and post Order")
    public boolean validateShippingChargesPriorPostOrder(String priorShippingCharges, String postShippingCharges) {
        try {
            if (postShippingCharges.contains(priorShippingCharges))
                return true;
            else if(Double.parseDouble(postShippingCharges)==Double.parseDouble(priorShippingCharges))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Promo Codes matched pre and post Order")
    public boolean validatePromoCodesPriorPostOrder(String priorMajorPromo, String postMajorPromo,String priorMinorPromo, String postMinorPromo,String priorOrderChannel, String postOrderChannel) {
        try {
            if (priorMajorPromo.equals(postMajorPromo) && priorMinorPromo.equals(postMinorPromo) && priorOrderChannel.equals(postOrderChannel))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Learner Contact Mail matched pre and post Order")
    public boolean validateLearnerContactMailPriorPostOrder(String priorContactMail, String postContactMail) {
        try {
            if (priorContactMail.equals(postContactMail))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Learner Contact First Name matched pre and post Order")
    public boolean validateLearnerFirstNamePriorPostOrder(String priorFirstName, String postFirstName) {
        try {
            if (priorFirstName.equals(postFirstName))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Learner Contact Last Name matched pre and post Order")
    public boolean validateLearnerLastNamePriorPostOrder(String priorLastName, String postLastName) {
        try {
            if (priorLastName.equals(postLastName))
                return true;
            else
                return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Verify Learner Contact Start Date matched pre and post Order")
    public boolean validateLearnerStartDatePriorPostOrder(String priorStartDate, String postStartDate) {
        boolean value=false;
        try {
            String priorStartDate_parts[] = priorStartDate.split("/");
            if(priorStartDate_parts[0].length()==1)
                priorStartDate_parts[0] = "0" + priorStartDate_parts[0];
            if(priorStartDate_parts[1].length()==1)
                priorStartDate_parts[1] = "0" + priorStartDate_parts[1];
            String modPriorStartdate=priorStartDate_parts[0] +"-"+ priorStartDate_parts[1]+"-"+priorStartDate.split("/")[2];
            if (modPriorStartdate.equals(postStartDate))
                 value=true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
        }
        return value;
    }

    @Step("Verify selected Billing and Shipping Learner contacts displayed on Order Information page")
    public void verifySelctedContactsDisplayedOnOrderInformationPage(String BillingSelectedContact,String ShippingSelectedContact) {
        try {
            System.out.println(BillingSelectedContact);
            System.out.println(getElement(OrderContact).getText());
            System.out.println(ShippingSelectedContact);
            System.out.println(getElement(OrderContact1).getText());
            Assert.assertTrue(getElement(OrderContact).getText().contains(BillingSelectedContact));
            Assert.assertTrue(getElement(OrderContact1).getText().contains(ShippingSelectedContact));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(
                    "[PUB-5243] Admin is unable to verify contact information on order view page.", e);
        }
    }

    @Step("Verify Contract/Subscription Start date and End Date with EBS")
    public boolean verifyContarctStartingandEndingDates(String ItemDescription) {
            boolean value=false;
        try {
            int year = LocalDate.now().getYear();
            LocalDate startDate = LocalDate.of(year, 1, 1);
            LocalDate endDate = LocalDate.of(year, 12, 31);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

            String startDateString = startDate.format(formatter);
            String endDateString = endDate.format(formatter);

            String ItemStartDate_EBS=ItemDescription.split("Start:")[1].substring(1,9);
            String ItemEndDate_EBS=ItemDescription.split("End:")[1].substring(1,9);

            if(startDateString.equals(ItemStartDate_EBS)&&endDateString.equals(ItemEndDate_EBS))
            {
                value=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert(
                    "Admin is unable to verify contract start date and end date from EBS", e);

        }
        return value;
    }

}
