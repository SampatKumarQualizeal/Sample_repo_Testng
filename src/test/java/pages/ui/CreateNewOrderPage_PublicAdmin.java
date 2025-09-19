package pages.ui;

import base.utils.RandomStringUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testobjects.Address_PublicAdmin;
import testobjects.Contact_PublicAdmin;
import testobjects.Product_PublicAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNewOrderPage_PublicAdmin extends BasePage {
    BasePage basePage;

    public CreateNewOrderPage_PublicAdmin(WebDriver driver) {

        super(driver);
        basePage=getInstance(BasePage.class);
    }

    public By orderTotalsSectionHeader(){
        return By.xpath("//fieldset[@id='order-totals']//span[text()='Order Totals']");
    }
    private By PaymentMethod=By.xpath("//span[text()='Payment Method']/parent::div/following-sibling::div/descendant::label");
    public By acceptBtnOnSubmit=By.xpath("//button[contains(@class,'action-accept')]/span[text()='OK']");
    private By creditcardNo=By.xpath("//input[@id='credit-card-number']");
    private By expirationMonth=By.xpath("//input[@id='expiration-month']");
    private By expirationYear=By.xpath("//input[@id='expiration-year']");
    private By cvvNumber=By.xpath("//input[@id='cvv']");
    String iframeccnumber="braintree-hosted-field-number";
    String iframeExpMonth="braintree-hosted-field-expirationMonth";
    String iframeExpYear="braintree-hosted-field-expirationYear";
    String iframecvv="braintree-hosted-field-cvv";
    private By creditcardOption=By.xpath("//input[@id='p_method_braintree']");
    private By addProductBySkuButton = By.xpath("//span[contains(text(),'Add Products By SKU')]");
    private By skuNumberTextField = By.cssSelector("input#sku_0");
    private By quantityTextField = By.cssSelector("input#sku_qty_0");
    private By addToOrderButton = By.cssSelector("div#order-additional_area button[title='Add to Order']");
    public By spinnerIcon = By.cssSelector(".popup-loading");
    public By addProductsButton = By.cssSelector("button#add_products");
    private By searchProductNameTextField = By.cssSelector("#sales_order_create_search_grid_filter_name");
    private By firstSearchResult = By.cssSelector("#sales_order_create_search_grid_table tbody tr:first-child");
    private By productQuantityTextField = By.cssSelector("table#sales_order_create_search_grid_table input[name='qty']");
    private By addSelectedProductsToOrderButton = By.cssSelector("button[title='Add Selected Product(s) to Order']");
    private By invalidSkuErrorMessage = By.cssSelector("#sku_errors_table .message-notice");
    private By wireTrabsferRadioButton = By.cssSelector("input[title='EFT - Wire Transfer']");
    private By getShippingMethodsAndRatesLink = By.xpath("//span[contains(text(),'Get shipping methods and rates')]");
    private By flatRateRadioButton = By.cssSelector("input[name='order[shipping_method]']");
    private By submitOrderButton = By.cssSelector("#submit_order_top_button");
    public By submitOrderBtn(){
        return submitOrderButton;
    }
    private By majorPromoCodeDropDown = By.cssSelector("select#promo-code-major");
    private By minorPromoCodeDropDown = By.cssSelector("select#promo-code-minor");
    private By orderChannelDropDown = By.cssSelector("select#sales-channel");
    private By searchButton = By.cssSelector("#order-search button[title='Search']");
    private By skuFileUpload = By.cssSelector("input#sku_upload");
    public By skuNumbersInItemOrderedList = By.cssSelector("td.col-product div.product-sku-block:nth-of-type(1)");
    private By ebsSkuNumbersInItemOrderedList = By.cssSelector("td.col-product div.product-sku-block:nth-of-type(2)");
    private By priceInItemOrderedList = By.xpath("//td[@class='col-price']/span");
    private By subTotalInItemOrderedList = By.xpath("//td[@class='col-subtotal col-price']/span");
    private By rowTotalInItemOrderedList = By.xpath("//td[@class='col-price col-row-subtotal']/span");
    private By rowSubscriptionTypeList = By.xpath("//td[@class='col-price col-row-subtotal']/span");
    private By productNamesInItemOrderedList = By.cssSelector("table.order-tables tbody span[id*='order_item_']");
    private By firstNameFieldUnderBillingAddress = By.cssSelector("input#order-billing_address_firstname");
    private By lastNameFieldUnderBillingAddress = By.cssSelector("input#order-billing_address_lastname");
    private By cityTextFieldUnderBillingAddress = By.cssSelector("input#order-billing_address_city");
    private By zipCodeTextFieldUnderBillingAddress = By.cssSelector("input#order-billing_address_postcode");
    private By phoneNumberTextFieldUnderBillingAddress = By.cssSelector("input#order-billing_address_telephone");
    private By countryDropDownUnderBillingAddress = By.cssSelector("select#order-billing_address_country_id");
    private By stateDropDownUnderBillingAddress = By.cssSelector("select#order-billing_address_region_id");
    private By firstNameFieldUnderShippingAddress = By.cssSelector("input#order-shipping_address_firstname");
    private By lastNameFieldUnderShippingAddress = By.cssSelector("input#order-shipping_address_lastname");
    private By cityTextFieldUnderShippingAddress = By.cssSelector("input#order-shipping_address_city");
    private By zipCodeTextFieldUnderShippingAddress = By.cssSelector("input#order-shipping_address_postcode");
    private By phoneNumberTextFieldUnderShippingAddress = By.cssSelector("input#order-shipping_address_telephone");
    private By countryDropDownUnderShippingAddress = By.cssSelector("select#order-shipping_address_country_id");
    private By stateDropDownUnderShippingAddress = By.cssSelector("select#order-shipping_address_region_id");
    private By firstNameFieldUnderFreightForwardAddress = By
            .cssSelector("input#order-freight_forward_address_firstname");
    private By lastNameFieldUnderFreightForwardAddress = By.cssSelector("input#order-freight_forward_address_lastname");
    private By cityTextFieldUnderFreightForwardAddress = By.cssSelector("input#order-freight_forward_address_city");
    private By zipCodeTextFieldUnderFreightForwardAddress = By
            .cssSelector("input#order-freight_forward_address_postcode");
    private By phoneNumberTextFieldUnderFreightForwardAddress = By
            .cssSelector("input#order-freight_forward_address_telephone");
    private By countryDropDownUnderFreightForwardAddress = By.cssSelector("select#order-freight_forward_address_country_id");
    private By stateDropDownUnderFreightForwardAddress = By.cssSelector("select#order-freight_forward_address_region_id");
    private By invoiceRadioButton = By.cssSelector("label[for='p_method_astminvoice']");
    private By ccTerminalPaymnetMethod = By.xpath("//input[@title='CC Terminal/Check']/..");
    private By ChangeShippingMethodlink = By.xpath("//span[text()='Click to change shipping method']");
    private By wiretTransferPaymentMethod = By.cssSelector("label[for='p_method_astmeft']");
    private By ccPaymentMethod = By.cssSelector("label[for='p_method_braintree']");
    private By poNumberTextField = By.cssSelector("input#po-number");
    private By poError = By.cssSelector("[id='po-number-error']");
    private By fileCorruptErrorMessage = By.cssSelector("div[data-ui-id='message-message-error']");
    public By orderTypeDropDown = By.cssSelector("select#ebs_order_type");
    private By productActionDropDown = By.cssSelector("select[name*='[action]']");
    private By deliveryMethodCodeDropDown = By.cssSelector("select[name*='[pim_delivery_method_code]']");
    private By deliveryPlatformIdDropDown = By.cssSelector("select[name*='[pim_delivery_platform_id]']");
    public By licenseTypeCodeDropDown = By.cssSelector("select[name*='[compass_license_type]']");
    private By updateItemButton = By.xpath("//button[@title='Update Items and Quantities']");
    private By fromPriceTextField = By.cssSelector("#sales_order_create_search_grid_filter_price_from");
    private By toPriceTextField = By.cssSelector("#sales_order_create_search_grid_filter_price_to");
    private By sortByPriceLabel = By.cssSelector("#sales_order_create_search_grid_table th[data-sort='price']");
    private By priceList = By.cssSelector("#sales_order_create_search_grid_table tbody td.col-price");
    private By billingAddressDropDown = By.cssSelector("select#order-billing_address_customer_address_id");
    private By shippingAddressDropDown = By.cssSelector("select#order-shipping_address_customer_address_id");
    private By sameAsBillingAddressCheckBox = By.cssSelector("input#order-shipping_same_as_billing + label");
    private By sameAsBillingAddressCheckboxInput = By.cssSelector("input#order-shipping_same_as_billing");
    private By specifyFrieghtForwardAddressCheckBox = By.cssSelector("input#specify-freight-forward-address + label");
    private By specifyFrieghtForwardAddressCheckBoxInout = By.cssSelector("input#specify-freight-forward-address");
    private By frieghtForwardAddressDropDown = By
            .cssSelector("select#order-freight_forward_address_customer_address_id");
    private By orderCommentTextArea = By.cssSelector("textarea#order-comment");
    private By groupDropDown = By.cssSelector("select#group_id");
    private By emailField = By.cssSelector("input#email");

    private By streetAddressFirstTextFieldForBillingAddress = By.cssSelector("input#order-billing_address_street0");
    private By streetAddressFirstTextFieldForShippingAddress = By.cssSelector("input#order-shipping_address_street0");
    private By streetAddressFirstTextFieldForFreightForwardAddress = By
            .cssSelector("input#order-freight_forward_address_street0");

    private By streetAddressSecondTextFieldForBillingAddress = By.cssSelector("input#order-billing_address_street1");
    private By streetAddressSecondTextFieldForShippingAddress = By.cssSelector("input#order-shipping_address_street1");
    private By streetAddressSecondTextFieldForFreightForwardAddress = By
            .cssSelector("input#order-freight_forward_address_street1");

    private By streetAddressThirdTextFieldForBillingAddress = By.cssSelector("input#order-billing_address_street2");
    private By streetAddressThirdTextFieldForShippingAddress = By.cssSelector("input#order-shipping_address_street2");
    private By streetAddressThirdTextFieldForFreightForwardAddress = By
            .cssSelector("input#order-freight_forward_address_street2");

    private By streetAddressForthTextFieldForBillingAddress = By.cssSelector("input#order-billing_address_street3");
    private By streetAddressForthTextFieldForShippingAddress = By.cssSelector("input#order-shipping_address_street3");
    private By streetAddressForthTextFieldForFreightForwardAddress = By
            .cssSelector("input#order-freight_forward_address_street3");

    private By companyBillingAddress = By.cssSelector("#order-billing_address_company");
    private By companyShippingAddress = By.cssSelector("#order-shipping_address_company");
    private By companyFreightForwardAddress = By.cssSelector("#order-freight_forward_address_company");

    private By nameSuffixBillingAddress = By.cssSelector("#order-billing_address_suffix");
    private By nameSuffixShippingAddress = By.cssSelector("#order-shipping_address_suffix");
    private By nameSuffixFreightForwardAddress = By.cssSelector("#order-freight_forward_address_suffix");

    private By middleNameBillingAddress = By.cssSelector("#order-billing_address_middlename");
    private By middleNameShippingAddress = By.cssSelector("#order-shipping_address_middlename");
    private By middleNameFreightForwardAddress = By.cssSelector("#order-freight_forward_address_middlename");

    private By vatNumberBillingAddress = By.cssSelector("#order-billing_address_vat_id");
    private By vatNumberShippingAddress = By.cssSelector("#order-shipping_address_vat_id");
    private By vatNumberFreightForwardAddress = By.cssSelector("#order-freight_forward_address_vat_id");

    private By deliveryMethodCodeDropDowns = By.cssSelector("select[name*='[pim_delivery_method_code]']");
    private By deliveryPlatformIdDropDowns = By.cssSelector("select[name*='[pim_delivery_platform_id]']");
    private By licenseTypeCodeDropDowns = By.cssSelector("select[name*='[pim_license_type_code]']");
    private By productItemIdTextFields = By.cssSelector("input[name*='[pim_product_item_id]']");
    private By shippngMethodDropDown = By.cssSelector("select#customer_shipping_account_method");
    private By shippingAccountNumberTextField = By.cssSelector("input#shipping-acct");
    private By selectButton = By.cssSelector(".order-shipping-method button");
    private By customerShipppingAccountRadioButton = By.cssSelector("label[for='s_method_customershippingaccount']");
    private By fixedRadioButton = By.cssSelector("label[for='s_method_flatrate_flatrate']");
    private By freeShippingRadioButton = By.cssSelector("label[for='s_method_freeshipping_freeshipping']");
    private By shippingMethodRequiredMessage = By.cssSelector("label[id='order[has_shipping]-error']");
    private By skuSearchTextField = By.cssSelector("#sales_order_create_search_grid_filter_sku");
    private By contactUnderBillingAddressDropDown = By.cssSelector("#order-billing_address_customer_contact_id");
    private By contactUnderShippingAddressDropDown = By.cssSelector("#order-shipping_address_customer_contact_id");
    private By contactUnderFreightForwardAddressDropDown = By
            .cssSelector("#order-freight_forward_address_customer_contact_id");
    private By addAnotherButton = By.cssSelector("button[data-ui-id=additional-area-sku-add-addbutton]");
    private By skuNumberFieldTwo = By.cssSelector("input#sku_1");
    private By skuProductQuantityTextField = By.cssSelector("input#sku_qty_1");

    public By subTotal = By.cssSelector("table.admin__table-secondary tr:nth-of-type(1) td:last-child span");
    public By shippingAndHandlingCharges = By
            .cssSelector("table.admin__table-secondary tr:nth-of-type(2) td:last-child span");
    public By grandTotalExclTaxes = By
            .cssSelector("table.admin__table-secondary tr:nth-of-type(3) td:last-child span");
    public By TaxOrderTotal=By.cssSelector("table.admin__table-secondary tr:nth-of-type(4) td:last-child span");
    public By grandTotalWithTaxes = By
            .cssSelector("table.admin__table-secondary tr:nth-of-type(6) td:last-child span");

    private By contactTableHeader = By.cssSelector("th.col-contact");
    private By contactRequiredErrorMessage = By
            .cssSelector(".order-tables select[name*='customer_contact_id'] + label.mage-error");
    private By productNameInItemOrderedList = By.cssSelector("table.order-tables td.col-product > span");
    private By productQuantityInItemOrderedList = By.cssSelector("table.order-tables td.col-qty input");
    private By contactDropDownUnderItemOrdered = By.cssSelector(".order-tables select[name*='customer_contact_id']");
    public By contactDropDownUnderBillingAddress = By.xpath("//select[@id='order-billing_address_customer_contact_id']");
    public By contactDropDownUnderShippingAddress = By.xpath("//select[@id='order-shipping_address_customer_contact_id']");
    private By licenseDropDownUnderItemOrdered = By.cssSelector("select[class='admin__control-select required-entry']");
    private By emailOrderConfirmationCheckBox = By.xpath("//*[@id='send_confirmation']");
    private By publishDateColumnHeader = By.cssSelector("th.col-publish-date");
    private By subscriptionTypeColumnHeader = By.cssSelector("th.col-subscription-type");
    private By startDateColumnHeader = By.cssSelector("th.col-start-date");
    public By startDateField = By.cssSelector("input[name*='compass_start_date']");
    public By publishDateField = By.cssSelector("input[name*='compass_publish_date']");
    private By subscriptionTypeDropDown = By.cssSelector("select[name*='compass_subscription_type']");
    private By astmShippingMethods = By.cssSelector("label[for*='s_method_amstrates_amstrates'] ");
    private By astmShippingMethodsRates = By.cssSelector("label[for*='s_method_amstrates_amstrates'] strong");
    //    private By customPriceCheckBox = By.cssSelector("label[for*='item_use_custom_price']");
    private By customPriceCheckBox = By.cssSelector("input[id*='item_use_custom_price_']");
    private By customPriceTextField = By.cssSelector("input[id*='item_custom_price_']");
    private By clickToChangeShippingMethod = By.cssSelector("#order-shipping-method-info a");
    private By fedex2ndDayDeliveryRadioButton = By.cssSelector("label[for='s_method_amstrates_amstrates3']");
    private By dhlIntlStandardRadioButton = By.cssSelector("label[for='s_method_amstrates_amstrates1']");
    private By getCompanyNameUnderBillingAddress = By.cssSelector("#order-billing_address_company");
    private By getCompanyNameUnderShippingAddress = By.cssSelector("#order-shipping_address_company");
    private By getCompanyNameUnderFreightForwardAddress = By.cssSelector("#order-freight_forward_address_company");
    private By fedexOverNightDelivery = By.cssSelector("label[for='s_method_amstrates_amstrates4']");
    private By doubleBookingError = By.xpath("//div[contains(text(),'TPT learner is ')]");
    private By standardService = By.cssSelector("label[for='s_method_amstrates_amstrates8']");
    private By getPaymentMethod = By.xpath("//span[contains(text(), 'Get available payment methods')]");
    private By totalPriceItemOrdered = By.cssSelector(".order-tables tfoot tr td:nth-of-type(5)");
    private By productNameUnderSearch = By.cssSelector("#sales_order_create_search_grid_table tbody .col-name");
    private By skuUnderSearch = By.cssSelector("#sales_order_create_search_grid_table tbody .col-sku");
    private By identiyingNumberRequiredError = By.cssSelector("input#ccterminal_identifying_number + .mage-error");
    private By paymentMethodDropDown = By.cssSelector("select#ccterminal_payment_method");
    public By PaymentandShippingInfoLabel = By.xpath("//span[text()='Payment & Shipping Information']");

    private By receiptMethodDropDown = By.cssSelector("select#ccterminal_receipt_method");
    private By amountTextFieldUnderPayment = By.cssSelector("input#ccterminal_amount");
    private By identifyingNumberTextField = By.cssSelector("input#ccterminal_identifying_number");
    private By contactUnderBillingAddress = By
            .cssSelector(".order-billing-address div.admin__page-section-item-content");
    private By contactUnderShippingAddress = By
            .cssSelector(".order-shipping-address div.admin__page-section-item-content");
    private By contactUnderFreightForwardAddress = By
            .cssSelector(".order-freight-forward-address div.admin__page-section-item-content");
    private By promoCodeErrorMessage = By.cssSelector("select#promo-code-major + label.mage-error");
    private By priceOfProductByIndex = By.cssSelector(".order-tables tbody tr td:nth-of-type(2) .price");
    private By scrollElement = By.cssSelector("a.admin__action-dropdown");
    private By faxUnderBillingAddress = By.cssSelector("input#order-billing_address_fax");
    private By faxUnderShippingAddress = By.cssSelector("input#order-shipping_address_fax");
    private By faxUnderFreighForwardAddress = By.cssSelector("input#order-freight_forward_address_fax");
    private By addressDescriptionUnderBillingAddress = By.cssSelector("#order-billing_address_address_description");
    private By addressDescriptionUnderShippingAddress = By.cssSelector("#order-shipping_address_address_description");
    private By addressDescriptionUnderFreightForwardAddress = By.cssSelector("#order-freight_forward_address_address_description");
    public By OrderTotalBookDealerDiscount = By.xpath("//tr[@class='book_dealer_discount row-totals']//td[@class='admin__total-amount']/span");
    public By OrderTotalMemberDiscount = By.xpath("//tr[@class='member_discount row-totals']//td[@class='admin__total-amount']/span");
    public By  OrderTotalSubscriptionDiscount = By.xpath("//tr[@class='subscription_agency_discount row-totals']//td[@class='admin__total-amount']/span");
    private By subTotalUnderItemOrdered = By.cssSelector("td.col-subtotal.col-price .price");

    public By getDiscountUnderItemOrdered() {
        return discountUnderItemOrdered;
    }
    private By productSKU=By.cssSelector("td.col-product > span");
    private By discountUnderItemOrdered=By.cssSelector("td.col-discount.col-price > span");
    private By BookDealerDiscount = By.cssSelector("td.col-discount.col-book-dealer-discount.col-price .price");
    private By MemberDiscount = By.cssSelector("td.col-discount.col-member-discount.col-price");
    private By SubscriptionAgencyDiscount = By.cssSelector("td.col-discount.col-subscription-agency-discount.col-price .price");
    private By RowTaxAmount = By.cssSelector("td.col-tax-amount.col-price .price");
    private By RowSubtotalAmount = By.cssSelector("td.col-price.col-row-subtotal .price");
    private By QuantityNumber = By.xpath("//td[@class='col-qty']/input");

    private By recordFoundLabel = By.cssSelector("#sales_order_create_search_grid-total-count");
    private By resetFilter = By.cssSelector("#sales_order_create_search_grid button[title='Reset Filter']");
    private By sortBySkuOnSearchPage = By.cssSelector("th[data-sort='sku']");
    private By skuSearchResults = By.cssSelector("#sales_order_create_search_grid_table tbody .col-sku");
    private By skuSearchResultsName = By.cssSelector("#sales_order_create_search_grid_table tbody .col-name");
    private By skuSearchResultsPrice = By.cssSelector("#sales_order_create_search_grid_table tbody .price");
    private By selectProductFromListCheckbox = By.cssSelector("#sales_order_create_search_grid_table tbody .checkbox");
    private By quantityTextFieldsUnderSearchResult = By.cssSelector("#sales_order_create_search_grid_table tbody .col-qty input");
    private By productPricesListUnderItemOrderedTable = By.cssSelector("table.order-tables tbody tr td.col-price:nth-of-type(2) > .price");
    private By productRowSubtotalUnderItemOrderedTable = By.cssSelector("td.col-price.col-row-subtotal span");
    private By pageHeading = By.cssSelector("h1#order-header");
    private By noRecordFoundMessageForAddProducts = By.xpath("//td[contains(text(),\"We couldn't find any records.\")]");
    private By productAssignedToOtherWebsiteErrorMessage = By.xpath("//div[contains(text(),'This product is assigned to another website.')]");
    private By addProductsToOrder = By.cssSelector("button[title='Add Products to Order']");
    private By removeAllButton = By.cssSelector("button[title='Remove All']");
    private By productRequireAttentionWarningMessage = By.xpath("//span[contains(text(),'product(s) require attention.')]");
    private By removeButton = By.cssSelector("button[title='Remove']");
    private By consortiaFlagDropDown = By.cssSelector("select#consortia");
    private By totalSubtotalPrice = By.cssSelector("tfoot td.col-price:nth-of-type(3) .price");
    private By noShippingQuotesAvailableMessage = By.xpath("//span[contains(text(),'Sorry, no quotes are available for this order.')]");
    private By selectedShippingMethodLabel = By.xpath("//*[@id='order-shipping-method-info']/dl/dd");
    private By shippingInformationUnderOrderTotal = By.cssSelector("table.admin__table-secondary tr:nth-of-type(3) td.admin__total-mark");
    private By imexIntlOvernightTracableShippingMethod = By.cssSelector("label[for='s_method_amstrates_amstrates6']");
    private By standardServiceInputTag = By.cssSelector("input#s_method_amstrates_amstrates8");

    private By customerShippingAccount=By.cssSelector("input#s_method_customershippingaccount");
    public By shippingMethodEBSDropdown=By.cssSelector("#customer_shipping_account_method");

    public By getShippingAccount() {
        return shippingAccount;
    }

    private By shippingAccount=By.cssSelector("#shipping-acct");
    private By upsOvernightDeliveryShippingMethod = By.cssSelector("label[for='s_method_amstrates_amstrates11']");
    private By quantityFieldUnderItemOrdered = By.cssSelector("input[name*='[qty]']");
    private By closeSpecialHandlingDialogBox = By.xpath("//h1[contains(text(),'Special')]//following-sibling::button");
    private By fedexStandardGroundButton = By.cssSelector("label[for='s_method_amstrates_amstrates5']");
    private By royaltyErrorMessage = By.xpath("//div[contains(text(),'Royalty products must be ordered independent of other products')]");
    private By orderTotalLabels = By.cssSelector(".admin__table-secondary tbody tr.row-totals .admin__total-mark");
        private By orderTotalPrice = By.cssSelector(".admin__table-secondary tbody tr.row-totals .admin__total-amount span");
    private By membershipDiscountColumnUnderItemOrderedValues = By.cssSelector("td.col-member-discount span");
    //public By contactDropDownUnderBillingAddress = By.xpath("//select[@id='order-billing_address_customer_contact_id']");
    //public By contactDropDownUnderShippingAddress = By.xpath("//select[@id='order-shipping_address_customer_contact_id']");
    private By TPTOneQuantityError=By.xpath("//div[contains(text(),'Please add only one quantity per product.')]");
    private By itemOrderedColumn = By.cssSelector("thead tr.headings th span");
    private By standardServiceRate = By.cssSelector("#order-shipping-method-info > dl > dd > strong > span");
    public By shippingInfo=By.cssSelector("#order-shipping-method-info > dl > dd");
    public By PaymentMethodHeader = By.xpath("(//span[text()='Payment Method'])[1]");
    private By rowsUnderColumnItemOrdered(int index) {
        return By.cssSelector("table.order-tables tbody td:nth-of-type(" + index + ")");
    }

    private By rowsUnderColumnFootItemOrdered(int index) {
        return By.cssSelector("tfoot td:nth-of-type(" + index + ")");
    }

    private By ups2ndDeliveryMethod = By.cssSelector("label[for='s_method_amstrates_amstrates9']");
    private By monthDropDown = By.cssSelector("select[data-handler='selectMonth']");
    private By yearDropDown = By.cssSelector("select[data-handler='selectYear']");
    private By activeDateLabel = By.cssSelector("td[data-handler='selectDay'] a");
    private By goToTodayButton = By.cssSelector("button.ui-datepicker-current");
    private By closeButtonForCalender = By.cssSelector("button.ui-datepicker-close");
    private By startDateCalenderIcon = By.cssSelector("input[name*='[compass_start_date]'] + button");
    private By publishDateCalenderIcon = By.cssSelector("input[name*='[compass_publish_date]'] + button");
    private By updateItemPopTextMessage = By.xpath("//div[contains(text(),\"Changes to product line items have not been saved. Click ‘OK' to accept without updates. Click 'Cancel' and check Updates were made. Then 'Submit’ the order.\")]");
    private By okButton = By.cssSelector("button.action-accept");
    private By crossButton = By.cssSelector("aside._show button.action-close");
    private By cancelButton = By.cssSelector("button.action-dismiss");
    private By ebsSkuFilterField = By.cssSelector("input#sales_order_create_search_grid_filter_ebs_sku");
    private By ebsSkuSearchResults = By.cssSelector("#sales_order_create_search_grid_table tbody .col-ebs_sku");
    private By startDateErrorMessage = By.cssSelector("input[name*='[compass_start_date]'] +button + label.mage-error");
    private By publishDateErrorMessage = By.cssSelector("input[name*='[compass_publish_date]'] +button + label.mage-error");
    private By addProductByEbsSkuButton = By.id("ebs_sku_button");
    private By addAnotherButtonForEbsSku = By.cssSelector("button[data-ui-id='additional-ebs-area-ebs-sku-add-addbutton']");
    private By addToOrderForEbsSkuFunc = By.cssSelector("button[onclick='addByEbsSku.submitEbsSkuForm()']");
    private By productNameSearchResult = By.cssSelector("#sales_order_create_search_grid_table tbody tr:first-child td.col-name");

    public By getOrderItemList() {
        return orderItemList;
    }

    private By orderItemList = By.cssSelector("#order-items_grid>table>tbody>tr");
    public By getDuplicateTPTProductErrorMsge() {
        return duplicateTPTProductErrorMsge;
    }

    private By duplicateTPTProductErrorMsge = By.xpath("//div[@class='message message-error']");

    private By changeShippingMethod = By.xpath("//span[text()='Click to change shipping method']");
    private By standardServicePrice = By.xpath("//label[contains(text(),'Standard Service')]//span");
    private By FEDEX2ndDayDeliveryCheckbox = By.xpath("//label[contains(text(),'FEDEX - 2nd Day Delivery')]");
    private By FEDEX2ndDayDelivery = By.xpath("//label[contains(text(),'FEDEX - 2nd Day Delivery')]//span");
    private By shippingCharge = By.xpath("//tr[@id='shipping-exclude-tax']//td//span");
    private By ShippingTableRate=By.xpath("(//div[contains(@class,'order-shipping-method-info')])/descendant::strong/span");

    private By changeShippingCheckbox(String value) {
        return By.xpath("//label[contains(text(),'"+value+"')]");
          }
    private By changeShippingPrice(String value) {
        return By.xpath("//label[contains(text(),'"+value+"')]//span");
    }

    /**
     * @return productNameSearchResult
     */
    public By getProductNameSearchResult(){
        return productNameSearchResult;
    }

    /**
     * @return productNameSearchResult
     */
    public By getPoError(){
        return poError;
    }

    /**
     * @return addToOrderForEbsSkuFunc
     */
    public By getAddToOrderForEbsSkuFunc(){
        return addToOrderForEbsSkuFunc;
    }

    /**
     * @return addAnotherButtonForEbsSku
     */
    public By getAddAnotherButtonForEbsSku(){
        return addAnotherButtonForEbsSku;
    }

    /**
     * @return addProductByEbsSkuButton
     */
    public By getAddProductByEbsSkuButton(){
        return addProductByEbsSkuButton;
    }


    public By getSpecifyFreightForwardAddressCheckBoxInout() {
        return specifyFrieghtForwardAddressCheckBoxInout;
    }

    /**
     * @return publishDateErrorMessage
     */
    public By getPublishDateErrorMessage(){
        return publishDateErrorMessage;
    }

    /**
     * @return startDateErrorMessage
     */
    public By getStartDateErrorMessage(){
        return startDateErrorMessage;
    }

    public By getSelectorForTptOrderDoubleErrorMessage(String magentoOrderId) {
        return By.xpath("//div[contains(text(),' TPT learner is double booked for same product in " + magentoOrderId + ". ')]");
    }
    public By getStandardServiceRate(){
        return standardServiceRate;
    }

    @Step("Verify shipping rate")
    public void ShippingRate(){
        try {
            String StandardService = PublicAdminCommons.getTextOfElement(driver,getStandardServiceRate());
            StandardService.equals("$0.00");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to verify shipping rate", e);
        }

    }

    public List<String> getProductNamesInItemOrderedList() {
        List<WebElement> list1=getElementsNew(productNamesInItemOrderedList);
        List<String> productNamesInItemOrderedList1=new ArrayList<String>();
        for(WebElement  ele:list1) {
            productNamesInItemOrderedList1.add(ele.getText());
        }
        return productNamesInItemOrderedList1;
    }

    public List<String> getEbsSkuNumbersInItemOrderedList() {
        List<WebElement> list1=getElementsNew(ebsSkuNumbersInItemOrderedList);
        List<String> ebsSkuNumbersInItemOrderedList1=new ArrayList<String>();
        for(WebElement  ele:list1) {
            ebsSkuNumbersInItemOrderedList1.add(ele.getText().substring(4));
        }
        return ebsSkuNumbersInItemOrderedList1;
    }

    public List<String> getPriceInItemOrderedList() {
        List<WebElement> list1=getElementsNew(priceInItemOrderedList);
        List<String> priceInItemOrderedList1=new ArrayList<String>();
        for(WebElement  ele:list1) {
            priceInItemOrderedList1.add(ele.getText());
        }
        return priceInItemOrderedList1;
    }

    public List<String> getSubTotalInItemOrderedList() {
        List<WebElement> list1=getElementsNew(subTotalInItemOrderedList);
        List<String> subTotalInItemOrderedList1=new ArrayList<String>();
        for(WebElement  ele:list1) {
            subTotalInItemOrderedList1.add(ele.getText());
        }
        return subTotalInItemOrderedList1;
    }

    public List<String> getRowTotalInItemOrderedList() {
        List<WebElement> list1=getElementsNew(rowTotalInItemOrderedList);
        List<String> rowTotalInItemOrderedList1=new ArrayList<String>();
        for(WebElement  ele:list1) {
            rowTotalInItemOrderedList1.add(ele.getText());
        }
        return rowTotalInItemOrderedList1;
    }

    public List<String> getTaxAmountInItemOrderedListInString()
    {
        List<WebElement> list1=getElementsNew(RowTaxAmount);
        List<String> RowTaxAmount1=new ArrayList<String>();
        for(WebElement  ele:list1) {
            RowTaxAmount1.add(ele.getText());
        }
        return RowTaxAmount1;

    }

    public By getSubscriptionTypeOrderedList() {
        return rowTotalInItemOrderedList;
    }

    public List<String> getQtyNumbersInItemOrderedList() {
        List<WebElement> qtyListItemsOrdered=driver.findElements(By.xpath("//input[contains(@name,'[qty]')]"));
        List<String> qtyListItemsOrderedValues=new ArrayList<String>();
        for(WebElement qty:qtyListItemsOrdered)
        {
            qtyListItemsOrderedValues.add(qty.getAttribute("value"));
        }
        return qtyListItemsOrderedValues;
    }

    public List<String> SubscriptionTypeInItemOrderedList() {
        List<WebElement> subscriptionTypeListItemsOrdered=driver.findElements(By.xpath("//select[contains(@name,'[compass_subscription_type]')]"));
        List<String> subscriptionTypeListItemsOrderedValues=new ArrayList<String>();
        for(WebElement ItemsOrdered:subscriptionTypeListItemsOrdered)
        {
            Select sel=new Select(ItemsOrdered);
            subscriptionTypeListItemsOrderedValues.add(sel.getFirstSelectedOption().getText());
        }
        return subscriptionTypeListItemsOrderedValues;
    }

    public By getSelectProductFromListCheckbox() {
        return selectProductFromListCheckbox;
    }

    /**
     * @return ebsSkuSearchResults
     */
    public By getEbsSkuSearchResults() {
        return ebsSkuSearchResults;
    }

    /**
     * @return ebsSkuFilterField
     */
    public By getEbsSkuFilterField() {
        return ebsSkuFilterField;
    }

    /**
     * @return sameAsBillingAddressCheckboxInput
     */
    public By getSameAsBillingAddressCheckboxInput() {
        return sameAsBillingAddressCheckboxInput;
    }

    /**
     * @return cancelButton
     */
    public By getCancelButton() {
        return cancelButton;
    }

    /**
     * @return crossButton
     */
    public By getCrossButton() {
        return crossButton;
    }

    /**
     * @return okButton
     */
    public By getOkButton() {
        return okButton;
    }

    /**
     * @return updateItemPopTextMessage
     */
    public By getUpdateItemPopTextMessage() {
        return updateItemPopTextMessage;
    }

    /**
     * @return publishDateCalenderIcon
     */
    public By getPublishDateCalenderIcon() {
        return publishDateCalenderIcon;
    }


    /**
     * @return startDateCalenderIcon
     */
    public By getStartDateCalenderIcon() {
        return startDateCalenderIcon;
    }

    /**
     * @return closeButtonForCalender
     */
    public By getCloseButtonForCalender() {
        return closeButtonForCalender;
    }

    /**
     * @return goToTodayButton
     */
    public By getGoToTodayButton() {
        return goToTodayButton;
    }

    /**
     * @return ups2ndDeliveryMethod
     */
    public By getUps2ndDeliveryMethod() {
        return ups2ndDeliveryMethod;
    }

    public By getSkuSearchResults() {
        return skuSearchResults;
    }

    /**
     * @return itemOrderedColumn
     */
    public By getItemOrderedColumn() {
        return itemOrderedColumn;
    }

    /**
     * @return membershipDiscountColumnUnderItemOrderedValues
     */
    public By getMembershipDiscountColumnUnderItemOrderedValues() {
        return membershipDiscountColumnUnderItemOrderedValues;
    }

    /**
     * @return royaltyErrorMessage
     */
    public By getRoyaltyErrorMessage() {
        return royaltyErrorMessage;
    }

    /**
     * @return fedexStandardGroundButton
     */
    public By getFedexStandardGroundButton() {
        return fedexStandardGroundButton;
    }

    /**
     * @return quantityFieldUnderItemOrdered
     */
    public By getQuantityFieldUnderItemOrdered() {
        return quantityFieldUnderItemOrdered;
    }

    /**
     * @return upsOvernightDeliveryShippingMethod
     */
    public By getupsOvernightDeliveryShippingMethod() {
        return upsOvernightDeliveryShippingMethod;
    }

    /**
     * @return getcloseSpecialHandlingDialogBox
     */
    public By getCloseSpecialHandlingDialogBox() {
        return closeSpecialHandlingDialogBox;
    }

    /**
     * @return standardServiceInputTag
     */
    public By getStandardServiceInputTag() {
        return standardServiceInputTag;
    }


    public By getCustomerShippingAccount() {
        return customerShippingAccount;
    }

    public boolean selectShippingMethodEBSDDbyIndex(int index)
    {
        try {
            Select sel = new Select(getElement(shippingMethodEBSDropdown));
            sel.selectByIndex(1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getRandomAlphaNumericString(int CharCount)
    {
        try {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

            StringBuilder sb = new StringBuilder(CharCount);

            for (int i = 0; i < CharCount; i++) {

                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return imexIntlOvernightTracableShippingMethod
     */
    public By getImexIntlOvernightTracableShippingMethod() {
        return imexIntlOvernightTracableShippingMethod;
    }

    /**
     * @return shippingInformationUnderOrderTotal
     */
    public By getShippingInformationUnderOrderTotal() {
        return shippingInformationUnderOrderTotal;
    }

    /**
     * @return selectedShippingMethodLabel
     */
    public By getSelectedShippingMethodLabel() {
        return selectedShippingMethodLabel;
    }

    /**
     * @return noShippingQuotesAvailableMessage
     */
    public By getNoShippingQuotesAvailableMessage() {
        return noShippingQuotesAvailableMessage;
    }

    /**
     * @return totalSubtotalPrice
     */
    public By getTotalSubtotalPrice() {
        return totalSubtotalPrice;
    }

    /**
     * @return consortiaFlagDropDown
     */
    public By getConsortiaFlagDropDown() {
        return consortiaFlagDropDown;
    }

    /**
     * @return removeButton
     */
    public By getRemoveButton() {
        return removeButton;
    }

    /**
     * @return productRequireAttentionWarningMessage
     */
    public By getProductRequireAttentionWarningMessage() {
        return productRequireAttentionWarningMessage;
    }

    /**
     * @return removeAllButton
     */
    public By getRemoveAllButton() {
        return removeAllButton;
    }

    /**
     * @return addProductsToOrder
     */
    public By getAddProductsToOrder() {
        return addProductsToOrder;
    }

    /**
     * @return productAssignedToOtherWebsiteErrorMessage
     */
    public By getProductAssignedToOtherWebsiteErrorMessage() {
        return productAssignedToOtherWebsiteErrorMessage;
    }

    /**
     * @return noRecordFoundMessageForAddProducts
     */
    public By getNoRecordFoundMessageForAddProducts() {
        return noRecordFoundMessageForAddProducts;
    }

    /**
     * @return pageHeading
     */
    public By getPageHeading() {
        return pageHeading;
    }

    /**
     * @return productRowSubtotalUnderItemOrderedTable
     */
    public By getProductRowSubtotalUnderItemOrderedTable() {
        return productRowSubtotalUnderItemOrderedTable;
    }

    /**
     * @return productPricesListUnderItemOrderedTable
     */
    public By getProductPricesListUnderItemOrderedTable() {
        return productPricesListUnderItemOrderedTable;
    }

    /**
     * @return sortBySkuOnSearchPage
     */
    public By getSortBySkuOnSearchPage() {
        return sortBySkuOnSearchPage;
    }

    /**
     * @return Gets the value of wiretTransferPaymentMethod and returns wiretTransferPaymentMethod
     */
    public By getWiretTransferPaymentMethod() {
        return wiretTransferPaymentMethod;
    }

    /**
     * @return Gets the value of ccPaymentMethod and returns ccPaymentMethod
     */
    public By getCcPaymentMethod() {
        return ccPaymentMethod;
    }

    /**
     * @return Gets the value of subTotalUnderItemOrdered and returns subTotalUnderItemOrdered
     */
    public By getSubTotalUnderItemOrdered() {
        return subTotalUnderItemOrdered;
    }


    /**
     * @return Gets the value of countryDropDownUnderBillingAddress and returns countryDropDownUnderBillingAddress
     */
    public By getCountryDropDownUnderBillingAddress() {
        return countryDropDownUnderBillingAddress;
    }

    /**
     * @return Gets the value of stateDropDownUnderBillingAddress and returns stateDropDownUnderBillingAddress
     */
    public By getStateDropDownUnderBillingAddress() {
        return stateDropDownUnderBillingAddress;
    }

    /**
     * @return Gets the value of countryDropDownUnderShippingAddress and returns countryDropDownUnderShippingAddress
     */
    public By getCountryDropDownUnderShippingAddress() {
        return countryDropDownUnderShippingAddress;
    }

    /**
     * @return Gets the value of stateDropDownUnderShippingAddress and returns stateDropDownUnderShippingAddress
     */
    public By getStateDropDownUnderShippingAddress() {
        return stateDropDownUnderShippingAddress;
    }

    /**
     * @return Gets the value of countryDropDownUnderFreightForwardAddress and returns countryDropDownUnderFreightForwardAddress
     */
    public By getCountryDropDownUnderFreightForwardAddress() {
        return countryDropDownUnderFreightForwardAddress;
    }

    /**
     * @return Gets the value of stateDropDownUnderFreightForwardAddress and returns stateDropDownUnderFreightForwardAddress
     */
    public By getStateDropDownUnderFreightForwardAddress() {
        return stateDropDownUnderFreightForwardAddress;
    }

    /**
     * @return Gets the value of addressDescriptionUnderBillingAddress and returns addressDescriptionUnderBillingAddress
     */
    public By getAddressDescriptionUnderBillingAddress() {
        return addressDescriptionUnderBillingAddress;
    }

    /**
     * @return Gets the value of addressDescriptionUnderShippingAddress and returns addressDescriptionUnderShippingAddress
     */
    public By getAddressDescriptionUnderShippingAddress() {
        return addressDescriptionUnderShippingAddress;
    }

    /**
     * @return Gets the value of addressDescriptionUnderFreightForwardAddress and returns addressDescriptionUnderFreightForwardAddress
     */
    public By getAddressDescriptionUnderFreightForwardAddress() {
        return addressDescriptionUnderFreightForwardAddress;
    }

    /**
     * @return the faxUnderBillingAddress
     */
    public By getFaxUnderBillingAddress() {
        return faxUnderBillingAddress;
    }

    /**
     * @return the faxUnderShippingAddress
     */
    public By getFaxUnderShippingAddress() {
        return faxUnderShippingAddress;
    }

    /**
     * @return the faxUnderFreighForwardAddress
     */
    public By getFaxUnderFreighForwardAddress() {
        return faxUnderFreighForwardAddress;
    }

    /**
     * @return the priceOfProductByIndex
     */
    public By getPriceOfProductByIndex() {
        return priceOfProductByIndex;
    }

    /**
     * @return the scrollElement
     */
    public By getScrollElement() {
        return scrollElement;
    }

    /**
     * @return the promoCodeErrorMessage
     */
    public By getPromoCodeErrorMessage() {
        return promoCodeErrorMessage;
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
     * @return the contactUnderFreightForwardAddress
     */
    public By getContactUnderFreightForwardAddress() {
        return contactUnderFreightForwardAddress;
    }

    /**
     * @return the identifyingNumberTextField
     */
    public By getIdentifyingNumberTextField() {
        return identifyingNumberTextField;
    }

    /**
     * @return the grandTotalExclTaxes
     */
    public By getGrandTotalExclTaxes() {
        return grandTotalExclTaxes;
    }

    /**
     * @return the identiyingNumberRequiredError
     */
    public By getIdentiyingNumberRequiredError() {
        return identiyingNumberRequiredError;
    }

    /**
     * @return the paymentMethodDropDown
     */
    public By getPaymentMethodDropDown() {
        return paymentMethodDropDown;
    }

    /**
     * @return the receiptMethodDropDown
     */
    public By getReceiptMethodDropDown() {
        return receiptMethodDropDown;
    }

    /**
     * @return the amountTextFieldUnderPayment
     */
    public By getAmountTextFieldUnderPayment() {
        return amountTextFieldUnderPayment;
    }

    /**
     * @return the ccTerminalPaymnetMethod
     */
    public By getCcTerminalPaymnetMethod() {
        return ccTerminalPaymnetMethod;
    }

    public By getChangeShippingMethodLink() {
        return ChangeShippingMethodlink;
    }



    /**
     * @return the productNamesInItemOrderedList
     */


    /**
     * @return the subTotal
     */
    public By getSubTotal() {
        return subTotal;
    }

    /**
     * @return the grandTotalWithTaxes
     */
    public By getGrandTotalWithTaxes() {
        return grandTotalWithTaxes;
    }

    /**
     * @return the getPaymentMethod
     */
    public By getGetPaymentMethod() {
        return getPaymentMethod;
    }

    /**
     * @return the productNameUnderSearch
     */
    public By getProductNameUnderSearch() {
        return productNameUnderSearch;
    }

    /**
     * @return the skuUnderSearch
     */
    public By getSkuUnderSearch() {
        return skuUnderSearch;
    }

    /**
     * @return the totalPriceItemOrdered
     */
    public By getTotalPriceItemOrdered() {
        return totalPriceItemOrdered;
    }

    /**
     * @return the standardService
     */
    public By getStandardService() {
        return standardService;
    }

    /**
     * @return the doubleBookingError
     */
    public By getDoubleBookingError() {
        return doubleBookingError;
    }

    /**
     * @return the fedexOverNightDelivery
     */
    public By getFedexOverNightDelivery() {
        return fedexOverNightDelivery;
    }

    /**
     * @return the getCompanyNameUnderBillingAddress
     */
    public By getGetCompanyNameUnderBillingAddress() {
        return getCompanyNameUnderBillingAddress;
    }

    /**
     * @return the getCompanyNameUnderShippingAddress
     */
    public By getGetCompanyNameUnderShippingAddress() {
        return getCompanyNameUnderShippingAddress;
    }

    /**
     * @return the getCompanyNameUnderFreightForwardAddress
     */
    public By getGetCompanyNameUnderFreightForwardAddress() {
        return getCompanyNameUnderFreightForwardAddress;
    }

    /**
     * @return the fedex2ndDayDeliveryRadioButton
     */
    public By getFedex2ndDayDeliveryRadioButton() {
        return fedex2ndDayDeliveryRadioButton;
    }

    /**
     * @return the dhlIntlStandardRadioButton
     */
    public By getDhlIntlStandardRadioButton() {
        return dhlIntlStandardRadioButton;
    }

    /**
     * @return the clickToChangeShippingMethod
     */
    public By getClickToChangeShippingMethod() {
        return clickToChangeShippingMethod;
    }

    /**
     * @return the astmShippingMethodsRates
     */
    public By getAstmShippingMethodsRates() {
        return astmShippingMethodsRates;
    }

    /**
     * @return the customPriceCheckBox
     */
    public By getCustomPriceCheckBox() {
        return customPriceCheckBox;
    }

    /**
     * @return the customPriceTextField
     */
    public By getCustomPriceTextField() {
        return customPriceTextField;
    }

    /**
     * @return the astmShippingMethods
     */
    public By getAstmShippingMethods() {
        return astmShippingMethods;
    }

    /**
     * @return the publishDateField
     */
    public By getPublishDateField() {
        return publishDateField;
    }

    /**
     * @return the subscriptionTypeDropDown
     */
    public By getSubscriptionTypeDropDown() {
        return subscriptionTypeDropDown;
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
    public By getPublishDateFieldd() {
        return publishDateField;
    }

    /**
     * @return the publishDateColumnHeader
     */
    public By getPublishDateColumnHeader() {
        return publishDateColumnHeader;
    }

    /**
     * @return the subscriptionTypeColumnHeader
     */
    public By getSubscriptionTypeColumnHeader() {
        return subscriptionTypeColumnHeader;
    }

    /**
     * @return the startDateColumnHeader
     */
    public By getStartDateColumnHeader() {
        return startDateColumnHeader;
    }

    /**
     * @return the freeShippingRadioButton
     */
    public By getFreeShippingRadioButton() {
        return freeShippingRadioButton;
    }

    /**
     * @return the emailOrderConfirmationCheckBox
     */
    public By getEmailOrderConfirmationCheckBox() {
        return emailOrderConfirmationCheckBox;
    }

    /**
     * @return the productQuantityInItemOrderedList
     */
    public By getProductQuantityInItemOrderedList() {
        return productQuantityInItemOrderedList;
    }

    /**
     * @return the contactDropDownUnderItemOrdered
     */
    public By getContactDropDownUnderItemOrdered() {
        return contactDropDownUnderItemOrdered;
    }

    /**
     * @return the productNameInItemOrderedList
     */
    public By getProductNameInItemOrderedList() {
        return productNameInItemOrderedList;
    }

    /**
     * @return the contactRequiredErrorMessage
     */
    public By getContactRequiredErrorMessage() {
        return contactRequiredErrorMessage;
    }

    /**
     * @return the contactTableHeader
     */
    public By getContactTableHeader() {
        return contactTableHeader;
    }

    /**
     * @return the shippingAndHandlingCharges
     */
    public By getShippingAndHandlingCharges() {
        return shippingAndHandlingCharges;
    }

    /**
     * @return the skuProductQuantityTextField
     */
    public By getSkuProductQuantityTextField() {
        return skuProductQuantityTextField;
    }

    /**
     * @return the skuNumberFieldTwo
     */
    public By getSkuNumberFieldTwo() {
        return skuNumberFieldTwo;
    }

    /**
     * @return the addAnotherButton
     */
    public By getAddAnotherButton() {
        return addAnotherButton;
    }

    /**
     * @return the contactUnderBillingAddressDropDown
     */
    public By getContactUnderBillingAddressDropDown() {
        return contactUnderBillingAddressDropDown;
    }

    /**
     * @return the contactUnderShippingAddressDropDown
     */
    public By getContactUnderShippingAddressDropDown() {
        return contactUnderShippingAddressDropDown;
    }

    /**
     * @return the contactUnderFreightForwardAddressDropDown
     */
    public By getContactUnderFreightForwardAddressDropDown() {
        return contactUnderFreightForwardAddressDropDown;
    }

    /**
     * @return the skuSearchTextField
     */
    public By getSkuSearchTextField() {
        return skuSearchTextField;
    }

    /**
     * @return the shippingMethodRequiredMessage
     */
    public By getShippingMethodRequiredMessage() {
        return shippingMethodRequiredMessage;
    }

    /**
     * @return the fixedRadioButton
     */
    public By getFixedRadioButton() {
        return fixedRadioButton;
    }

    /**
     * @return the customerShipppingAccountRadioButton
     */
    public By getCustomerShipppingAccountRadioButton() {
        return customerShipppingAccountRadioButton;
    }

    /**
     * @return the skuFileUpload
     */
    public By getSkuFileUpload() {
        return skuFileUpload;
    }

    /**
     * @return the skuNumbersInItemOrderedList
     */
    public List<String> getSkuNumbersInItemOrderedList() {
        List<WebElement> list1=getElementsNew(skuNumbersInItemOrderedList);
        List<String> SkuNumbersInItemOrderedList1=new ArrayList<String>();
        for(WebElement  ele:list1) {
            SkuNumbersInItemOrderedList1.add(ele.getText().substring(5));
        }
        return SkuNumbersInItemOrderedList1;
    }

    /**
     * @return the sortByPriceLabel
     */
    public By getSortByPriceLabel() {
        return sortByPriceLabel;
    }

    /**
     * @return the priceList
     */
    public By getPriceList() {
        return priceList;
    }

    /**
     * @return the deliveryMethodCodeDropDowns
     */
    public By getDeliveryMethodCodeDropDowns() {
        return deliveryMethodCodeDropDowns;
    }

    /**
     * @return the deliveryPlatformIdDropDowns
     */
    public By getDeliveryPlatformIdDropDowns() {
        return deliveryPlatformIdDropDowns;
    }

    /**
     * @return the licenseTypeCodeDropDowns
     */
    public By getLicenseTypeCodeDropDowns() {
        return licenseTypeCodeDropDowns;
    }

    /**
     * @return the productItemIdTextFields
     */
    public By getProductItemIdTextFields() {
        return productItemIdTextFields;
    }

    /**
     * @return the shippngMethodDropDown
     */
    public By getShippngMethodDropDown() {
        return shippngMethodDropDown;
    }

    /**
     * @return the shippingAccountNumberTextField
     */
    public By getShippingAccountNumberTextField() {
        return shippingAccountNumberTextField;
    }

    /**
     * @return the selectButton
     */
    public By getSelectButton() {
        return selectButton;
    }

    /**
     * @return the streetAddressFirstTextFieldForBillingAddress
     */
    public By getStreetAddressFirstTextFieldForBillingAddress() {
        return streetAddressFirstTextFieldForBillingAddress;
    }

    /**
     * @return the streetAddressFirstTextFieldForShippingAddress
     */
    public By getStreetAddressFirstTextFieldForShippingAddress() {
        return streetAddressFirstTextFieldForShippingAddress;
    }

    /**
     * @return the streetAddressFirstTextFieldForFreightForwardAddress
     */
    public By getStreetAddressFirstTextFieldForFreightForwardAddress() {
        return streetAddressFirstTextFieldForFreightForwardAddress;
    }

    /**
     * @return the emailField
     */
    public By getEmailField() {
        return emailField;
    }

    /**
     * @return the groupDropDown
     */
    public By getGroupDropDown() {
        return groupDropDown;
    }

    /**
     * @return the orderCommentTextArea
     */
    public By getOrderCommentTextArea() {
        return orderCommentTextArea;
    }

    /**
     * @return the shippingAddressDropDown
     */
    public By getShippingAddressDropDown() {
        return shippingAddressDropDown;
    }

    /**
     * @return the billingAddressDropDown
     */
    public By getBillingAddressDropDown() {
        return billingAddressDropDown;
    }

    /**
     * @return the sameAsBillingAddressCheckBox
     */
    public By getSameAsBillingAddressCheckBox() {
        return sameAsBillingAddressCheckBox;
    }

    /**
     * @return the specifyFrieghtForwardAddressCheckBox
     */
    public By getSpecifyFrieghtForwardAddressCheckBox() {
        return specifyFrieghtForwardAddressCheckBox;
    }

    /**
     * @return the frieghtForwardAddressDropDown
     */
    public By getFrieghtForwardAddressDropDown() {
        return frieghtForwardAddressDropDown;
    }

    /**
     * @return the fromPriceTextField
     */
    public By getFromPriceTextField() {
        return fromPriceTextField;
    }

    /**
     * @return the toPriceTextField
     */
    public By getToPriceTextField() {
        return toPriceTextField;
    }

    /**
     * @return the productActionDropDown
     */
    public By getProductActionDropDown() {
        return productActionDropDown;
    }

    /**
     * @return the deliveryMethodCodeDropDown
     */
    public By getDeliveryMethodCodeDropDown() {
        return deliveryMethodCodeDropDown;
    }

    /**
     * @return the deliveryPlatformIdDropDown
     */
    public By getDeliveryPlatformIdDropDown() {
        return deliveryPlatformIdDropDown;
    }

    /**
     * @return the licenseTypeCodeDropDown
     */
    public By getLicenseTypeCodeDropDown() {
        return licenseTypeCodeDropDown;
    }

    /**
     * @return the updateItemButton
     */
    public By getUpdateItemButton() {
        return updateItemButton;
    }

    public void updateItemButton(){
        PublicAdminCommons.scrollToElement(driver, updateItemButton);
        getElementNew(updateItemButton).click();
    }

    /**
     * @return the orderTypeDropDown
     */
    public By getOrderTypeDropDown() {
        return orderTypeDropDown;
    }

    /**
     * @return the fileCorruptErrorMessage
     */
    public By getFileCorruptErrorMessage() {
        return fileCorruptErrorMessage;
    }

    /**
     * @return the firstNameFieldUnderBillingAddress
     */
    public By getFirstNameFieldUnderBillingAddress() {
        return firstNameFieldUnderBillingAddress;
    }

    /**
     * @return the lastNameFieldUnderBillingAddress
     */
    public By getLastNameFieldUnderBillingAddress() {
        return lastNameFieldUnderBillingAddress;
    }

    /**
     * @return the cityTextFieldUnderBillingAddress
     */
    public By getCityTextFieldUnderBillingAddress() {
        return cityTextFieldUnderBillingAddress;
    }

    /**
     * @return the zipCodeTextFieldUnderBillingAddress
     */
    public By getZipCodeTextFieldUnderBillingAddress() {
        return zipCodeTextFieldUnderBillingAddress;
    }

    /**
     * @return the phoneNumberTextFieldUnderBillingAddress
     */
    public By getPhoneNumberTextFieldUnderBillingAddress() {
        return phoneNumberTextFieldUnderBillingAddress;
    }

    /**
     * @return the addProductBySkuButton
     */
    public By getAddProductBySkuButton() {
        return addProductBySkuButton;
    }

    /**
     * @return the skuNumberTextField
     */
    public By getSkuNumberTextField() {
        return skuNumberTextField;
    }

    /**
     * @return the quantityTextField
     */
    public By getQuantityTextField() {
        return quantityTextField;
    }

    /**
     * @return the addToOrderButton
     */
    public By getAddToOrderButton() {
        return addToOrderButton;
    }

    /**
     * @return the spinnerIcon
     */
    public By getSpinnerIcon() {
        return spinnerIcon;
    }

    /**
     * @return the addProductsButton
     */
    public By getAddProductsButton() {
        return addProductsButton;
    }

    /**
     * @return the searchProductNameTextField
     */
    public By getSearchProductNameTextField() {
        return searchProductNameTextField;
    }

    /**
     * @return the firstSearchResult
     */
    public By getFirstSearchResult() {
        return firstSearchResult;
    }

    /**
     * @return the productQuantityTextField
     */
    public By getProductQuantityTextField() {
        return productQuantityTextField;
    }

    /**
     * @return the addSelectedProductsToOrderButton
     */
    public By getAddSelectedProductsToOrderButton() {
        return addSelectedProductsToOrderButton;
    }

    /**
     * @return the invalidSkuErrorMessage
     */
    public By getInvalidSkuErrorMessage() {
        return invalidSkuErrorMessage;
    }

    /**
     * @return the wireTrabsferRadioButton
     */
    public By getWireTrabsferRadioButton() {
        return wireTrabsferRadioButton;
    }

    /**
     * @return the getShippingMethodsAndRatesLink
     */
    public By getGetShippingMethodsAndRatesLink() {
        return getShippingMethodsAndRatesLink;
    }

    /**
     * @return the flatRateRadioButton
     */
    public By getFlatRateRadioButton() {
        return flatRateRadioButton;
    }

    /**
     * @return the submitOrderButton
     */
    public By getSubmitOrderButton() {
        return submitOrderButton;
    }

    @Step("Click on Submit Order")
    public void ClickOnSubmitOrderButton() {
        getElement(submitOrderButton).click();

    }

    @Step("Click on Submit Order")
    public void ClickOnSubmitOrderButton_WorkAround() {
        //getElement(submitOrderButton).click();
        PublicCommon.JSClick(getElement(submitOrderButton),driver);
    }

    /**
     * @return the majorPromoCodeDropDown
     */
    public By getMajorPromoCodeDropDown() {
        return majorPromoCodeDropDown;
    }

    /**
     * @return the minorPromoCodeDropDown
     */
    public By getMinorPromoCodeDropDown() {
        return minorPromoCodeDropDown;
    }

    /**
     * @return the orderChannelDropDown
     */
    public By getOrderChannelDropDown() {
        return orderChannelDropDown;
    }

    /**
     * @return the searchButton
     */
    public By getSearchButton() {
        PublicAdminCommons.waitForSec(1000);
        return searchButton;
    }

    /**
     * @return the skuFileUpload
     */
    public By getSKUFileUpload() {
        return skuFileUpload;
    }

    /**
     * @return the firstNameFieldUnderShippingAddress
     */
    public By getFirstNameFieldUnderShippingAddress() {
        return firstNameFieldUnderShippingAddress;
    }

    /**
     * @return the lastNameFieldUnderShippingAddress
     */
    public By getLastNameFieldUnderShippingAddress() {
        return lastNameFieldUnderShippingAddress;
    }

    /**
     * @return the cityTextFieldUnderShippingAddress
     */
    public By getCityTextFieldUnderShippingAddress() {
        return cityTextFieldUnderShippingAddress;
    }

    /**
     * @return the zipCodeTextFieldUnderShippingAddress
     */
    public By getZipCodeTextFieldUnderShippingAddress() {
        return zipCodeTextFieldUnderShippingAddress;
    }

    /**
     * @return the phoneNumberTextFieldUnderShippingAddress
     */
    public By getPhoneNumberTextFieldUnderShippingAddress() {
        return phoneNumberTextFieldUnderShippingAddress;
    }

    /**
     * @return the firstNameFieldUnderFreightForwardAddress
     */
    public By getFirstNameFieldUnderFreightForwardAddress() {
        return firstNameFieldUnderFreightForwardAddress;
    }

    /**
     * @return the lastNameFieldUnderFreightForwardAddress
     */
    public By getLastNameFieldUnderFreightForwardAddress() {
        return lastNameFieldUnderFreightForwardAddress;
    }

    /**
     * @return the cityTextFieldUnderFreightForwardAddress
     */
    public By getCityTextFieldUnderFreightForwardAddress() {
        return cityTextFieldUnderFreightForwardAddress;
    }

    /**
     * @return the zipCodeTextFieldUnderFreightForwardAddress
     */
    public By getZipCodeTextFieldUnderFreightForwardAddress() {
        return zipCodeTextFieldUnderFreightForwardAddress;
    }

    /**
     * @return the phoneNumberTextFieldUnderFreightForwardAddress
     */
    public By getPhoneNumberTextFieldUnderFreightForwardAddress() {
        return phoneNumberTextFieldUnderFreightForwardAddress;
    }

    /**
     * @return the poNumberTextField
     */
    public By getPoNumberTextField() {
        return poNumberTextField;
    }

    /**
     * @return the invoiceRadioButton
     */
    public By getInvoiceRadioButton() {
        return invoiceRadioButton;
    }

    public WebElement getTPTOneQuantityError() {
        return getElement(TPTOneQuantityError);
    }

    /****
     * Click on Search By SKU Button
     *
     * @return
     */
    public boolean clickAddProductBySkuButton() {
        try {
            getElementNew(addProductBySkuButton).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /***
     * Enter SKU number in field
     *
     * @param value
     * @return
     */
    public boolean enterTextInSkuNumberTextField(String value) {
        try {
            getElementNew(skuNumberTextField).sendKeys(value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /***
     * Enter quantity in SKU Quantity field
     *
     * @param value
     * @return
     */
    public boolean enterTextInQuantityTextField(String value) {
        try {
            getElementNew(quantityTextField).sendKeys(value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /****
     * Click on Add To Order Button
     *
     * @return
     */
    public boolean clickAddToOrderButton() {
        try {
            getElementNew(addToOrderButton).click();
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Wait for spinner loader to disappear
     */
    public void waitForSpinnerLoaderToDisappear() {
        PublicAdminCommons.waitForElementToDisappear(driver, getElementWithoutWait(spinnerIcon));
    }

    /**
     * Clicks on Add Products Button
     *
     * @return
     */
    public boolean clickAddProductsButton() {
        try {
            getElementNew(addProductsButton).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enters text in Search Product Name Text Field and press 'Enter' key to start
     * the search
     *
     * @param value
     * @return
     */
    public boolean enterTextInSearchProductNameTextField(String value) {
        try {
            WebElement element = getElementNew(searchProductNameTextField);
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on First Search Result
     *
     * @return
     */
    public boolean clickFirstSearchResult() {
        try {
            waitForSpinnerLoaderToDisappear();
            getElementNew(firstSearchResult).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enters text in Product Quantity Text Field
     *
     * @param value
     * @return
     */
    public boolean enterTextInProductQuantityTextField(String value) {
        try {
            WebElement element = getElementNew(productQuantityTextField);
            element.clear();
            element.sendKeys(value);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on Add Selected Products To Order Button
     *
     * @return
     */
    public boolean clickAddSelectedProductsToOrderButton() {
        try {
            getElementNew(addSelectedProductsToOrderButton).click();
            waitForSpinnerLoaderToDisappear();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Returns the error message for invalid sku number
     *
     * @return
     */
    public String getErrorMessageForInvalidSKU() {
        try {
            return getElementNew(invalidSkuErrorMessage).getText();
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Clicks on Wire Trabsfer Radio Button
     *
     * @return
     */
    public boolean clickWireTransferRadioButton() {
        try {
            getElementNew(wireTrabsferRadioButton).click();
            waitForSpinnerLoaderToDisappear();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on Get Shipping Methods And Rates Link
     *
     * @return
     */
    public boolean clickGetShippingMethodsAndRatesLink() {
        try {
            getElementNew(getShippingMethodsAndRatesLink).click();
            waitForSpinnerLoaderToDisappear();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on Flat Rate Radio Button
     *
     * @return
     */
    public boolean clickFlatRateRadioButton() {
        try {
            getElementNew(flatRateRadioButton).click();
            waitForSpinnerLoaderToDisappear();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on Submit Order Button
     *
     * @return
     */
    public boolean clickSubmitOrderButton() {
        try {
            getElementNew(submitOrderButton).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Selects option from Major Promo Code Drop Down
     *
     * @param value
     * @return
     */
    public boolean selectOptionInMajorPromoCodeDropDown(String value) {
        try {
            PublicAdminCommons.selectValueInDropdown(getElement(majorPromoCodeDropDown), value);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Selects option from Minor Promo Code Drop Down
     *
     * @param value
     * @return
     */
    public boolean selectOptionInMinorPromoCodeDropDown(String value) {
        try {
            PublicAdminCommons.selectValueInDropdown(getElement(minorPromoCodeDropDown), value);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Selects option from Order Channel Drop Down
     *
     * @param value
     * @return
     */
    public boolean selectOptionInOrderChannelDropDown(String value) {
        try {
            PublicAdminCommons.selectValueInDropdown(getElement(orderChannelDropDown), value);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Send the file path to input tag for file upload
     *
     * @param filePath
     * @return
     */
    public boolean setFilePathForSkuFileUpload(String filePath) {
        try {
            String fullPath = System.getProperty("user.dir") + filePath;
            getElementNew(skuFileUpload).sendKeys(fullPath);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
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

    /**
     * Remove item from item ordered list
     *
     * @return boolean
     */
    public boolean removeItemFromItemOrderedList() {
        try {
            List<WebElement> listOfActionDropDowns = getElementsNew(productActionDropDown);
            int totalProducts = listOfActionDropDowns.size();
            PublicAdminCommons.selectValueInDropdown(listOfActionDropDowns.get(0), "Remove");
            getElementNew(updateItemButton).click();
            waitForSpinnerLoaderToDisappear();
            waitForSpinnerLoaderToDisappear();
            List<WebElement> listOfActionDropDownsNew = driver.findElements(productActionDropDown);
            int totalProductsNew = listOfActionDropDownsNew.size();
            if (totalProducts > totalProductsNew) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * This method first verify products are present in price range
     */
    public boolean verifyProductsAreSortedAsPerPriceRange(String fromPriceRange, String toPriceRange) {
        try {
            getElementNew(sortByPriceLabel).click();
            waitForSpinnerLoaderToDisappear();
            List<String> priceListOfProducts = PublicAdminCommons.getTextOfWebElements(driver, priceList);
            String priceOfFirstProduct = priceListOfProducts.get(0).replaceAll("[\\$|,|;|']", "");
            if (!(Float.parseFloat(priceOfFirstProduct) >= Float.parseFloat(fromPriceRange))) {
                log.info("Product price was not higher then range");
                return false;
            }
            getElementNew(sortByPriceLabel).click();
            waitForSpinnerLoaderToDisappear();
            List<String> priceListOfProductsNew = PublicAdminCommons.getTextOfWebElements(driver, priceList);
            String priceOfFirstProductNew = priceListOfProductsNew.get(0).replaceAll("[\\$|,|;|']", "");
            if (!(Float.parseFloat(priceOfFirstProductNew) <= Float.parseFloat(toPriceRange))) {
                log.info("Product price was not lower then range");
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Add PIM information to product by index
     *
     * @return boolean
     */
    public boolean addPimInformationByIndex(int index, String deliveryMethodCode, String deliveryPlatformId,
                                            String licenseTypeCode, String productId) {
        try {
            List<WebElement> deliveryMethodCodeDropDownList = getElementsNew(deliveryMethodCodeDropDowns);
            List<WebElement> deliveryPlatformIdDropDownList = getElementsNew(deliveryPlatformIdDropDowns);
            List<WebElement> licenseTypeCodeDropDownList = getElementsNew(licenseTypeCodeDropDowns);
            List<WebElement> productItemIdTextFieldList = getElementsNew(productItemIdTextFields);
            PublicAdminCommons.selectValueInDropdown(deliveryMethodCodeDropDownList.get(index), deliveryMethodCode);
            PublicAdminCommons.selectValueInDropdown(deliveryPlatformIdDropDownList.get(index), deliveryPlatformId);
            PublicAdminCommons.selectValueInDropdown(licenseTypeCodeDropDownList.get(index), licenseTypeCode);
            productItemIdTextFieldList.get(index).sendKeys(productId);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Remove all the items from item ordered list
     *
     * @return boolean
     */
    public boolean removeAllItemsFromItemOrderedList() {
        try {
            PublicAdminCommons.scrollToElement(driver, getElementNew(updateItemButton));
            PublicCommon.waitForSec(3);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            List<WebElement> listOfActionDropDowns = getElementsNew(productActionDropDown);
            for (WebElement dropDown : listOfActionDropDowns) {
                PublicAdminCommons.selectValueInDropdown(dropDown, "Remove");
            }
            PublicAdminCommons.scrollToElement(driver, getElementNew(updateItemButton));
            PublicCommon.waitForSec(3);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicAdminCommons.loaderClick(getElementNew(updateItemButton));
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            Thread.sleep(5000);
            List<WebElement> listOfActionDropDownsNew = PublicAdminCommons.getListOfWebElementsWithoutWait(driver,
                    productActionDropDown);
            int totalProductsNew = listOfActionDropDownsNew.size();
            if (totalProductsNew == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * this function search for contacts drop down and select the contact by index
     *
     * @param indexOfProduct
     * @return
     */
    public boolean selectContactByIndexAndContactValueInItemOrderedTable(int indexOfProduct, String contactValue) {
        try {
            List<WebElement> contactsDropDowns = getElementsNew(contactDropDownUnderItemOrdered);
            Select select = new Select(contactsDropDowns.get(indexOfProduct));
            select.selectByValue(contactValue);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * this function search for contacts drop down and select the contact by index
     *
     * @param indexOfProduct
     * @return
     */
    public boolean selectContactByIndexInItemOrderedTable(int indexOfProduct, int contactIndexInDropDown) {
        try {
            List<WebElement> contactsDropDowns = getElementsNew(contactDropDownUnderItemOrdered);
            Select select = new Select(contactsDropDowns.get(indexOfProduct));
            select.selectByIndex(contactIndexInDropDown);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }



    /**
     * this function search for License drop down and select the contact by index
     *
     * @param indexOfProduct
     * @return
     */
    public boolean selectLicenseByIndexInItemOrderedTable(int indexOfProduct, int licenseIndexInDropDown) {
        try {
            List<WebElement> licenseDropDowns = getElementsNew(licenseDropDownUnderItemOrdered);
            Select select = new Select(licenseDropDowns.get(indexOfProduct));
            select.selectByIndex(licenseIndexInDropDown);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }


    public Contact_PublicAdmin getSelectedContactFromDropDownForTptProductAndReturnContactObject(int indexOfProduct) {
        try {
            List<WebElement> contactsDropDowns = getElementsNew(contactDropDownUnderItemOrdered);
            Select select = new Select(contactsDropDowns.get(indexOfProduct));
            String contactSelected = select.getFirstSelectedOption().getText();
            Contact_PublicAdmin contact = new Contact_PublicAdmin();
            contact.setAttributeFromContactDropDown(contactSelected);
            return contact;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    public float returnShippingRatesByIndex(int index) {
        try {
            List<WebElement> shippingRates = getElementsNew(astmShippingMethodsRates);
            Float convertedRate = Float.parseFloat(shippingRates.get(index).getText().replace("$", ""));
            return convertedRate;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return 0;
        }
    }

    public List<String> getShippingMethodsNameWithoutPrice() {
        try {
            List<String> shippingMethods = PublicAdminCommons.getTextOfWebElements(driver, astmShippingMethods);
            List<String> updateShippingMethodName = new ArrayList<String>();
            for (String method : shippingMethods) {
                updateShippingMethodName.add(method.substring(0, method.indexOf(" - $")));
            }
            log.info("Shipping Methods :" + updateShippingMethodName);
            return updateShippingMethodName;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Set custom price of products present in item ordered table
     */
    @Step("Set custom price for the product")
    public boolean setCustomPriceOfProducts() {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            List<WebElement> customPriceCheckBoxes = getElementsNew(customPriceCheckBox);
            for (WebElement element : customPriceCheckBoxes) {
                PublicAdminCommons.scrollToElement(driver, element);
                PublicAdminCommons.loaderClick(element);
                waitForSpinnerLoaderToDisappear();
            }
            List<WebElement> customPriceTextFields = getElementsNew(customPriceTextField);
            for (WebElement element : customPriceTextFields) {
                PublicAdminCommons.scrollToElement(driver, element);
                element.clear();
                element.sendKeys(RandomStringUtils.getRandomNumbers(3));
            }
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(updateItemButton));
            getElementNew(updateItemButton).click();
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }
    public boolean setCustomPriceOfProducts(int indexOfProduct, int licenseIndexInDropDown) {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            List<WebElement> customPriceCheckBoxes = getElementsNew(customPriceCheckBox);
            for (WebElement element : customPriceCheckBoxes) {
                PublicAdminCommons.scrollToElement(driver, element);
                PublicAdminCommons.loaderClick(element);
                waitForSpinnerLoaderToDisappear();
            }
            List<WebElement> customPriceTextFields = getElementsNew(customPriceTextField);
            for (WebElement element : customPriceTextFields) {
                PublicAdminCommons.scrollToElement(driver, element);
                element.clear();
                element.sendKeys(RandomStringUtils.getRandomNumbers(3));
            }
            List<WebElement> licenseDropDowns = getElementsNew(licenseDropDownUnderItemOrdered);
            Select select = new Select(licenseDropDowns.get(indexOfProduct));
            select.selectByIndex(licenseIndexInDropDown);
            getElementNew(updateItemButton).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Set custom price of products present in item ordered table
     *
     * @param price
     */
    public boolean setCustomPriceOfProducts(String price) {
        try {
            List<WebElement> customPriceCheckBoxes = getElementsNew(customPriceCheckBox);
            for (WebElement element : customPriceCheckBoxes) {
                PublicAdminCommons.scrollToElement(driver, element);
                PublicAdminCommons.loaderClick(element);
//                element.click();
            }
            List<WebElement> customPriceTextFields = getElementsNew(customPriceTextField);
            for (WebElement element : customPriceTextFields) {
                PublicAdminCommons.scrollToElement(driver, element);
                element.clear();
                element.sendKeys(price);
            }
            getElementNew(updateItemButton).click();
            PublicAdminCommons.waitForSec(5000);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Set publish/start date for product by index
     *
     * @param index
     * @param startDate
     * @param publishDate
     * @return
     */
    public boolean setPublishStartDateByIndex(int index, String startDate, String publishDate) {
        try {
            List<WebElement> publishDates = getElementsNew(publishDateField);
            List<WebElement> startDates = getElementsNew(startDateField);
            startDates.get(index).clear();
            startDates.get(index).sendKeys(startDate);
            publishDates.get(index).clear();
            publishDates.get(index).sendKeys(publishDate);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Select Custom Price for the product")
    public int setCustomPriceOfProduct() {
        int CustomPrice = 0;
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver,getSpinnerIcon());
            List<WebElement> customPriceCheckBoxes = basePage.getElementsNew(getCustomPriceCheckBox());
            for (WebElement element : customPriceCheckBoxes) {
                PublicAdminCommons.scrollToElement(driver, element);
                PublicAdminCommons.loaderClick(element);
                waitForSpinnerLoaderToDisappear();
            }
            List<WebElement> customPriceTextFields = basePage.getElementsNew(getCustomPriceTextField());
            for (WebElement element : customPriceTextFields) {
                PublicAdminCommons.scrollToElement(driver, element);
                element.clear();
                element.sendKeys(RandomStringUtils.getRandomNumbers(3));
                CustomPrice= Integer.parseInt(basePage.getElementNew(getCustomPriceTextField()).getAttribute("value"));
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
        } catch (Exception e) {
            e.getStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to Select Custom Price for the product", e);

        }
        return CustomPrice;
    }

    /**
     * Handle Get available payment methods link
     *
     * @return
     */
    public boolean handlePaymentMethodLink() {
        try {
            boolean check = PublicAdminCommons.isWebElementPresentOnPage(driver, getPaymentMethod);
            if (check == true)
                getElementNew(getPaymentMethod).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Returns the product object for product present in item ordered list
     *
     * @param index
     * @return
     */
    public Product_PublicAdmin getProductObjectInItemOrderedByIndex(int index) {
        try {
            Product_PublicAdmin productObject = new Product_PublicAdmin(
                    getElementsNew(productNamesInItemOrderedList).get(index).getText(),
                    getElementsNew(skuNumbersInItemOrderedList).get(index).getText());
            return productObject;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Returns product objects for products under items ordered table
     *
     * @return List<Product_PublicAdmin>
     */
    public List<Product_PublicAdmin> getProductObjectsUnderItemOrdered() {
        try {
            List<Product_PublicAdmin> productObjects = new ArrayList<Product_PublicAdmin>();
            List<WebElement> productNames = getElementsNew(productNamesInItemOrderedList);
            List<WebElement> productSkus = getElementsNew(skuNumbersInItemOrderedList);
            for (WebElement productName : productNames) {
                productObjects.add(new Product_PublicAdmin(productName.getText(),
                        productSkus.get(productNames.indexOf(productName)).getText()));
            }
            return productObjects;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Set custom price of products present in item ordered table
     */
    public boolean setCustomPriceOfProductByIndex(int indexOfProduct, String price) {
        try {
            List<WebElement> customPriceCheckBoxes = getElementsNew(customPriceCheckBox);
            PublicAdminCommons.scrollToElement(driver, customPriceCheckBoxes.get(indexOfProduct));
            PublicAdminCommons.loaderClick(customPriceCheckBoxes.get(indexOfProduct));
            waitForSpinnerLoaderToDisappear();
            List<WebElement> customPriceTextFields = getElementsNew(customPriceTextField);
            PublicAdminCommons.scrollToElement(driver, customPriceTextFields.get(indexOfProduct));
            customPriceTextFields.get(indexOfProduct).clear();
            customPriceTextFields.get(indexOfProduct).sendKeys(price);
            PublicAdminCommons.scrollToElement(driver, updateItemButton);
            getElementNew(updateItemButton).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Set License type by index")
    public boolean setLicenseTypeByIndex(int indexOfLicenseType) {
        try {
            PublicCommon.waitForSec(15);
            WebElement licenseType = getElementNew(licenseTypeCodeDropDown);
            PublicAdminCommons.scrollToElement(driver, licenseType);
            Select select = new Select(licenseType);
            select.selectByIndex(indexOfLicenseType);
            PublicAdminCommons.scrollToElement(driver, updateItemButton);
            getElementNew(updateItemButton).click();
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }
    /**
     * Set custom price of products present in item ordered table
     * Its does not click set price if already checked
     */
    public boolean setCustomPriceOfProductByIndexHandlingCheckbox(int indexOfProduct, String price) {
        try {
            List<WebElement> customPriceCheckBoxes = getElementsNew(customPriceCheckBox);
            PublicAdminCommons.scrollToElement(driver, customPriceCheckBoxes.get(indexOfProduct));
            if (!customPriceCheckBoxes.get(indexOfProduct).isSelected())
                customPriceCheckBoxes.get(indexOfProduct).click();
            List<WebElement> customPriceTextFields = getElementsNew(customPriceTextField);
            PublicAdminCommons.scrollToElement(driver, customPriceTextFields.get(indexOfProduct));
            customPriceTextFields.get(indexOfProduct).clear();
            customPriceTextFields.get(indexOfProduct).sendKeys(price);
            getElementNew(updateItemButton).click();
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * This methods handles automatic selection of address for successful order
     * creation
     *
     * @param freightForward
     * @return
     */
    public boolean handleAddressSectionOnOrderCreationPage(boolean freightForward) {
        try {
            String defaultBillingSelected = PublicAdminCommons.getSelectedValueFromDropDown(driver,
                    billingAddressDropDown);
            if (defaultBillingSelected.contains("Please select")) {
                PublicAdminCommons.selectValueInDropdownByIndexWithoutException(driver, billingAddressDropDown, 1);
            }
            WebElement sameBillingCheckbox = getElementNew(sameAsBillingAddressCheckboxInput);
            if (!sameBillingCheckbox.isSelected()) {
                getElementNew(sameAsBillingAddressCheckBox).click();
                waitForSpinnerLoaderToDisappear();
            }
            if (freightForward) {
                getElementNew(specifyFrieghtForwardAddressCheckBoxInout).click();
                waitForSpinnerLoaderToDisappear();
                PublicAdminCommons.selectValueInDropdownByIndexWithoutException(driver, frieghtForwardAddressDropDown,
                        1);
                waitForSpinnerLoaderToDisappear();
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean checkIfAddressIsPopulatedUnderBillingAddress(Address_PublicAdmin addressObject) {
        try {
            /*getElementNew(firstNameFieldUnderBillingAddress).getAttribute("value").contains(addressObject.getFirstName());
            getElementNew(lastNameFieldUnderBillingAddress).getAttribute("value").contains(addressObject.getLastName());*/
            if (!getElementNew(streetAddressFirstTextFieldForBillingAddress).getAttribute("value").contains(addressObject.getStreetAddress()))
                return false;
            if (!getElementNew(cityTextFieldUnderBillingAddress).getAttribute("value").contains(addressObject.getCity()))
                return false;
            if (!getElementNew(zipCodeTextFieldUnderBillingAddress).getAttribute("value").contains(addressObject.getZipCode()))
                return false;
            if (!getElementNew(phoneNumberTextFieldUnderBillingAddress).getAttribute("value").contains(addressObject.getPhoneNumber()))
                return false;
            if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, countryDropDownUnderBillingAddress).contains(addressObject.getCountry()))
                return false;
            if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, stateDropDownUnderBillingAddress).contains(addressObject.getProvince()))
                return false;
            if (addressObject.getAddressDescription() != null) {
                if (!getElementNew(addressDescriptionUnderBillingAddress).getAttribute("value")
                        .contains(addressObject.getAddressDescription()))
                    return false;
            }
            if (addressObject.getStreetAddress2() != null) {
                if (!getElementNew(streetAddressSecondTextFieldForBillingAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress2()))
                    return false;
            }
            if (addressObject.getStreetAddress3() != null) {
                if (!getElementNew(streetAddressThirdTextFieldForBillingAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress3()))
                    return false;
            }
            if (addressObject.getStreetAddress4() != null) {
                if (!getElementNew(streetAddressForthTextFieldForBillingAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress4()))
                    return false;
            }
            if (addressObject.getCompany() != null) {
                if (!getElementNew(companyBillingAddress).getAttribute("value")
                        .contains(addressObject.getCompany()))
                    return false;
            }
            /*if (addressObject.getMiddleName() != null) {
                if(!getElementNew(middleNameBillingAddress).getAttribute("value")
                        .contains(addressObject.getMiddleName()))
                    return false;
            }*/
            if (addressObject.getVatNumber() != null) {
                if (!getElementNew(vatNumberBillingAddress).getAttribute("value")
                        .contains(addressObject.getVatNumber()))
                    return false;
            }
            //Name Suffix Removed in 6.5
            /*if (addressObject.getNameSuffix() != null) {
                if(!getElementNew(nameSuffixBillingAddress).getAttribute("value")
                        .contains(addressObject.getNameSuffix()))
                    return false;
            }*/
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean checkIfAddressIsPopulatedUnderShippingAddress(Address_PublicAdmin addressObject) {
        try {
            /*getElementNew(firstNameFieldUnderShippingAddress).getAttribute("value").contains(addressObject.getFirstName());
            getElementNew(lastNameFieldUnderShippingAddress).getAttribute("value").contains(addressObject.getLastName());*/
            if (!getElementNew(streetAddressFirstTextFieldForShippingAddress).getAttribute("value").contains(addressObject.getStreetAddress()))
                return false;
            if (!getElementNew(cityTextFieldUnderShippingAddress).getAttribute("value").contains(addressObject.getCity()))
                return false;
            if (!getElementNew(zipCodeTextFieldUnderShippingAddress).getAttribute("value").contains(addressObject.getZipCode()))
                return false;
            if (!getElementNew(phoneNumberTextFieldUnderShippingAddress).getAttribute("value").contains(addressObject.getPhoneNumber()))
                return false;
            if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, countryDropDownUnderShippingAddress).contains(addressObject.getCountry()))
                return false;
            if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, stateDropDownUnderShippingAddress).contains(addressObject.getProvince()))
                return false;
            if (addressObject.getAddressDescription() != null) {
                if (!getElementNew(addressDescriptionUnderShippingAddress).getAttribute("value")
                        .contains(addressObject.getAddressDescription()))
                    return false;
            }
            if (addressObject.getStreetAddress2() != null) {
                if (!getElementNew(streetAddressSecondTextFieldForShippingAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress2()))
                    return false;
            }
            if (addressObject.getStreetAddress3() != null) {
                if (!getElementNew(streetAddressThirdTextFieldForShippingAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress3()))
                    return false;
            }
            if (addressObject.getStreetAddress4() != null) {
                if (!getElementNew(streetAddressForthTextFieldForShippingAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress4()))
                    return false;
            }
            if (addressObject.getCompany() != null) {
                if (!getElementNew(companyShippingAddress).getAttribute("value")
                        .contains(addressObject.getCompany()))
                    return false;
            }
            /*if (addressObject.getMiddleName() != null){
                if(!getElementNew(middleNameShippingAddress).getAttribute("value")
                        .contains(addressObject.getMiddleName()))
                    return false;
            }*/
            if (addressObject.getVatNumber() != null) {
                if (!getElementNew(vatNumberShippingAddress).getAttribute("value")
                        .contains(addressObject.getVatNumber()))
                    return false;
            }
            //Suffix removed in sprint 6.5
            /*if (addressObject.getNameSuffix() != null){
                if(!getElementNew(nameSuffixShippingAddress).getAttribute("value")
                        .contains(addressObject.getNameSuffix()))
                    return false;
            }*/
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean checkIfAddressIsPopulatedUnderFreightForwardAddress(Address_PublicAdmin addressObject) {
        try {
            /*getElementNew(firstNameFieldUnderFreightForwardAddress).getAttribute("value").contains(addressObject.getFirstName());
            getElementNew(lastNameFieldUnderFreightForwardAddress).getAttribute("value").contains(addressObject.getLastName());*/
            if (!getElementNew(streetAddressFirstTextFieldForFreightForwardAddress).getAttribute("value").contains(addressObject.getStreetAddress()))
                return false;
            if (!getElementNew(cityTextFieldUnderFreightForwardAddress).getAttribute("value").contains(addressObject.getCity()))
                return false;
            if (!getElementNew(zipCodeTextFieldUnderFreightForwardAddress).getAttribute("value").contains(addressObject.getZipCode()))
                return false;
            if (!getElementNew(phoneNumberTextFieldUnderFreightForwardAddress).getAttribute("value").contains(addressObject.getPhoneNumber()))
                return false;
            if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, countryDropDownUnderFreightForwardAddress).contains(addressObject.getCountry()))
                return false;
            if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, stateDropDownUnderFreightForwardAddress).contains(addressObject.getProvince()))
                return false;
            if (addressObject.getAddressDescription() != null) {
                if (!getElementNew(addressDescriptionUnderFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getAddressDescription()))
                    return false;
            }
            if (addressObject.getStreetAddress2() != null) {
                if (!getElementNew(streetAddressSecondTextFieldForFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress2()))
                    return false;
            }
            if (addressObject.getStreetAddress3() != null) {
                if (!getElementNew(streetAddressThirdTextFieldForFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress3()))
                    return false;
            }
            if (addressObject.getStreetAddress4() != null) {
                if (!getElementNew(streetAddressForthTextFieldForFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getStreetAddress4()))
                    return false;
            }
            if (addressObject.getCompany() != null) {
                if (!getElementNew(companyFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getCompany()))
                    return false;
            }
            /*if (addressObject.getMiddleName() != null) {
                if(!getElementNew(middleNameFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getMiddleName()))
                    return false;
            }*/
            if (addressObject.getVatNumber() != null) {
                if (!getElementNew(vatNumberFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getVatNumber()))
                    return false;
            }
            //Suffix removed in Sprint 6.5
            /*if (addressObject.getNameSuffix() != null) {
                if(!getElementNew(nameSuffixFreightForwardAddress).getAttribute("value")
                        .contains(addressObject.getNameSuffix()))
                    return false;
            }*/
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Returns the subtotal of product under item ordered
     *
     * @param index
     * @return
     */
    public String getSubTotalOfProductByIndexUnderItemOrdered(int index) {
        try {
            List<WebElement> subTotalElements = getElementsNew(subTotalUnderItemOrdered);
            return subTotalElements.get(index).getText();
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return "";
        }
    }

    public String getPriceOfProductByIndexUnderItemOrdered(int index) {
        try {
            List<WebElement> priceElements = getElementsNew(priceOfProductByIndex);
            return priceElements.get(index).getText();
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return "";
        }
    }

    public String getDiscountOfProductByIndexUnderItemOrdered(int index) {
        try {
            List<WebElement> discountElements = getElementsNew(discountUnderItemOrdered);
            return discountElements.get(index).getText();
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return "";
        }
    }

    /**
     * Checks if remove functionality works
     *
     * @return
     */
    public boolean checkIfRemoveFilterWorks() {
        try {
            int recordsFound = Integer.parseInt(getElementNew(recordFoundLabel).getText().trim());
            getElementNew(resetFilter).click();
            waitForSpinnerLoaderToDisappear();
            int recordsFoundUpdated = Integer.parseInt(getElementNew(recordFoundLabel).getText().trim());
            return recordsFound < recordsFoundUpdated;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * This function adds product by searching for sku
     * Make sure to provide complete SKU as this will search from available products in list
     *
     * @return boolean
     */
    public boolean addProductBySearchingForSku(String properSkuNumber, String quantity) {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            getElementNew(addProductsButton).click();
            PublicAdminCommons.waitForSec(3000);
            getElementNew(skuSearchTextField).sendKeys(properSkuNumber);
            PublicAdminCommons.waitForSec(3000);
            getElementNew(searchButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            PublicAdminCommons.waitForSec(3000);
            List<WebElement> skusInSearchResult = getElementsNew(skuSearchResults);
            for (WebElement skuElement : skusInSearchResult) {
                if (skuElement.getText().trim().equals(properSkuNumber)) {
                    PublicAdminCommons.loaderClick(getElementsNew(selectProductFromListCheckbox).get(skusInSearchResult.indexOf(skuElement)));
                    PublicAdminCommons.waitForSec(500);
                    WebElement quantityTextField = getElementsNew(quantityTextFieldsUnderSearchResult)
                            .get(skusInSearchResult.indexOf(skuElement));
                    if (quantityTextField.isEnabled()) {
                        quantityTextField.clear();
                        quantityTextField.sendKeys(quantity);
                        ReusableMethods.scrollIntoView(getElementNew(addSelectedProductsToOrderButton), driver);
                        PublicAdminCommons.clickElementByJavaScript(driver, addSelectedProductsToOrderButton);
                        //getElementNew(addSelectedProductsToOrderButton).click();
                        PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
                        break;
                    }
                }
            }
            List<WebElement> skusUnderItemOrderedTable = getElementsNew(skuNumbersInItemOrderedList);
            for (WebElement skuElement : skusUnderItemOrderedTable) {
                if (skuElement.getText().replace("SKU:", "").trim()
                        .equals(properSkuNumber)) {
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

    /**
     * Handle billing address on order creation screen
     *
     * @return boolean
     */
    public boolean handleBillingAddress() {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            Select billingDropDown = new Select(getElementNew(billingAddressDropDown));
            String selectedOption = billingDropDown.getFirstSelectedOption().getText();
            if (selectedOption.equals("Please select")) {
                billingDropDown.selectByIndex(1);
                PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Handle shipping address on order creation screen
     *
     * @return boolean
     */
    public boolean handleShippingAddress() {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            if (getElementNew(sameAsBillingAddressCheckBox).isSelected())
                return true;
            Select shippingDropDown = new Select(getElementNew(shippingAddressDropDown));
            String selectedOption = shippingDropDown.getFirstSelectedOption().getText();
            if (selectedOption.equals("Please select")) {
                shippingDropDown.selectByIndex(1);
                PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean setCreditCardDetails(String CreditcardNo, String ExpiryMonth,String ExpiryYear, String cvv) {
        try {
            if(!getElement(PaymentMethod).getText().contains("No Payment Information Required"))
            {
                if(getElement(creditcardOption).isSelected()) {
                    Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframeccnumber),
                            "Unable to switch iframe credit card");
                    PublicAdminCommons.enterTextInTextField(driver, creditcardNo,
                            CreditcardNo, true);
                    PublicAdminCommons.switchToDefaultFrame(driver);
                    Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframeExpMonth),
                            "Unable to switch iframe Expired Month");
                    PublicAdminCommons.enterTextInTextField(driver, expirationMonth,
                            ExpiryMonth, true);
                    PublicAdminCommons.switchToDefaultFrame(driver);
                    Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframeExpYear),
                            "Unable to switch iframe Expired Year");
                    PublicAdminCommons.enterTextInTextField(driver, expirationYear,
                            ExpiryYear, true);
                    PublicAdminCommons.switchToDefaultFrame(driver);
                    Assert.assertTrue(PublicAdminCommons.switchToIframe(driver, iframecvv),
                            "Unable to switch iframe CVV");
                    PublicAdminCommons.enterTextInTextField(driver, cvvNumber,
                            cvv, true);
                    PublicAdminCommons.switchToDefaultFrame(driver);
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
     * Selects freight forward address on order creation screen
     *
     * @return boolean
     */
    public boolean selectFreightForwardAddress() {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            WebElement specifyFreightForwardAddress = getElementNew(specifyFrieghtForwardAddressCheckBox);
            if (!specifyFreightForwardAddress.isSelected()) {
                specifyFreightForwardAddress.click();
                PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            }
            Select freightForwardDropDown = new Select(getElementNew(frieghtForwardAddressDropDown));
            String selectedOption = freightForwardDropDown.getFirstSelectedOption().getText();
            if (selectedOption.equals("Please select")) {
                freightForwardDropDown.selectByIndex(1);
                PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Admin selects promo codes
     *
     * @return boolean
     */
    public boolean selectPromoCodes(String majorPromoCode, String minorPromoCode, String orderChannel) {
        try {
            PublicAdminCommons.selectValueInDropdownByVisibleTextWithoutException(driver, majorPromoCodeDropDown,
                    majorPromoCode);
            PublicAdminCommons.selectValueInDropdownByVisibleTextWithoutException(driver, minorPromoCodeDropDown,
                    minorPromoCode);
            PublicAdminCommons.selectValueInDropdownByVisibleTextWithoutException(driver, orderChannelDropDown,
                    orderChannel);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Returns complete product objects for products under items ordered table
     *
     * @return List<Product_PublicAdmin>
     */
    public List<Product_PublicAdmin> getCompleteDetailsForProductObjectsUnderItemOrdered() {
        try {
            List<Product_PublicAdmin> productObjects = new ArrayList<Product_PublicAdmin>();
            List<WebElement> productNames = getElementsNew(productNamesInItemOrderedList);
            List<WebElement> productSkus = getElementsNew(skuNumbersInItemOrderedList);
            List<WebElement> productEbsSkus = getElementsNew(ebsSkuNumbersInItemOrderedList);
            List<WebElement> productPrices = getElementsNew(productPricesListUnderItemOrderedTable);
            List<WebElement> productRowSubtotals = getElementsNew(productRowSubtotalUnderItemOrderedTable);
            List<WebElement> startDates = getElementsNew(startDateField);
            List<WebElement> publishDates = getElementsNew(publishDateField);
            List<WebElement> subscriptionTypes = getElementsNew(subscriptionTypeDropDown);
            List<WebElement> quantityElements = getElementsNew(productQuantityInItemOrderedList);
            for (WebElement productName : productNames) {
                int index = productNames.indexOf(productName);
                Product_PublicAdmin product = new Product_PublicAdmin(productName.getText(),
                        productSkus.get(index).getText());
                product.setPrice(productPrices.get(index).getText());
                product.setEbsSku(productEbsSkus.get(index).getText());
                product.setRowSubTotal(productRowSubtotals.get(index).getText());
                product.setStartDate(startDates.get(index).getAttribute("value"));
                product.setPublishDate(publishDates.get(index).getAttribute("value"));
                Select subDropDown = new Select(subscriptionTypes.get(index));
                product.setSubscriptionType(subDropDown.getFirstSelectedOption().getText());
                product.setQuantity(quantityElements.get(index).getAttribute("value"));
                productObjects.add(product);
            }
            return productObjects;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    /**
     * Returns if get payment method is visible
     *
     * @return true/false
     */
    public boolean handleGetPaymentMethod() {
        try {
            new WebDriverWait(driver, 2);
            WebElement element = driver.findElement(getPaymentMethod);
            element.click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Returns if get shipping method is visible
     *
     * @return true/false
     */
    public boolean handleGetShippingMethod() {
        try {
            driver.findElement(getShippingMethodsAndRatesLink);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Set Quantity by index
     *
     * @return true/false
     */
    public boolean setQuantityForProductUnderItemOrderByIndex(int index, String quantity) {
        try {
            List<WebElement> quantityCheckBox = getElementsNew(productQuantityInItemOrderedList);
            quantityCheckBox.get(index).clear();
            quantityCheckBox.get(index).sendKeys(quantity);
            getElementNew(updateItemButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Remove items from item ordered list by index
     *
     * @return boolean
     */
    public boolean removeProductFromCartByIndex(int index) {
        try {
            List<WebElement> listOfActionDropDowns = getElementsNew(productActionDropDown);
            PublicAdminCommons.selectValueInDropdown(listOfActionDropDowns.get(index), "Remove");
            PublicAdminCommons.loaderClick(getElementNew(updateItemButton));
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            Thread.sleep(5000);
            List<WebElement> listOfActionDropDownsNew = PublicAdminCommons.getListOfWebElementsWithoutWait(driver,
                    productActionDropDown);
            int totalProductsNew = listOfActionDropDownsNew.size();
            if (totalProductsNew + 1 == listOfActionDropDowns.size()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean addMultipleProductBySkuFunctionality(List<String> skusList, String quantity) {
        try {
           for(int i=0;i<skusList.size();i++) {
                getElementNew(By.cssSelector("input#sku_" + skusList.indexOf(skusList.get(i)))).sendKeys(skusList.get(i));
                getElementNew(By.cssSelector("input#sku_qty_" + skusList.indexOf(skusList.get(i)))).sendKeys(quantity);
                if(i!=skusList.size()-1)
                    getElementNew(addAnotherButton).click();
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean addMultipleProductByEbsSkuFunctionality(List<String> skusList, String quantity) {
        try {
            for(String sku : skusList) {
                getElementNew(addAnotherButtonForEbsSku).click();
            }
            List<WebElement> skuTextFieldList = getElementsNew(By.cssSelector("td.col-sku input[id*=ebs_sku_]"));
            List<WebElement> qtyTextFieldList = getElementsNew(By.cssSelector("input[id*='ebs_sku_qty']"));
            for (String sku : skusList) {
                skuTextFieldList.get(skusList.indexOf(sku)).sendKeys(sku);
                qtyTextFieldList.get(skusList.indexOf(sku)).sendKeys(quantity);
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Gets order total hashmap
     */
    public HashMap<String, String> getOrderTotalsHashMap() {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> labels = PublicAdminCommons.getTextOfWebElements(driver, orderTotalLabels);
            List<String> prices = PublicAdminCommons.getTextOfWebElements(driver, orderTotalPrice);
            for (String label : labels)
                orderTotals.put(label.trim(), prices.get(labels.indexOf(label)));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets order total hashmap
     */
    public HashMap<String, String> getOrderTotalsHashMapWithNumberOnly() {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> labels = PublicAdminCommons.getTextOfWebElements(driver, orderTotalLabels);
            List<String> prices = PublicAdminCommons.getTextOfWebElements(driver, orderTotalPrice);
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
    public List<String> getListOfDetailsPresentUnderItemOrderedByColumn(String column) {
        try {
            List<String> columnHeaders = PublicAdminCommons.getTextOfWebElements(driver, itemOrderedColumn);
            return PublicAdminCommons.getTextOfWebElements(driver, rowsUnderColumnItemOrdered(columnHeaders.indexOf(column) + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets order total hashmap
     */
    public Map<String, String> getPriceMembershipDiscountRowTotalForProductByIndexUnderItemOrdered(int index) {
        try {
            Map<String, String> orderTotals = new HashMap<>();
            List<String> taxAmount = PublicAdminCommons.getTextOfWebElements(driver,RowTaxAmount);
            List<String> membershipDiscount = PublicAdminCommons.getTextOfWebElements(driver,
                    membershipDiscountColumnUnderItemOrderedValues);
            List<String> prices = PublicAdminCommons.getTextOfWebElements(driver, productPricesListUnderItemOrderedTable);
            List<String> subTotals = PublicAdminCommons.getTextOfWebElements(driver,subTotalUnderItemOrdered );
            List<String> rowTotals = PublicAdminCommons.getTextOfWebElements(driver, productRowSubtotalUnderItemOrderedTable);
            orderTotals.put("membershipDiscount", membershipDiscount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("subtotal",subTotals.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("price", prices.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("rowSubTotal", rowTotals.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("TaxAmount", taxAmount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets
     */
    public String getDataFromColumnUnderFootOfItemOrderedTable(String column) {
        try {
            List<String> columnHeaders = PublicAdminCommons.getTextOfWebElements(driver, itemOrderedColumn);
            return getElementNew(rowsUnderColumnFootItemOrdered(columnHeaders.indexOf(column))).getText().replace("$", "").replace("-", "")
                    .replace(",", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verifyIfSkuIsPresentInSearchResults(String properSkuNumber) {
        try {
            List<WebElement> skusInSearchResult = getElementsNew(skuSearchResults);
            for (WebElement skuElement : skusInSearchResult) {
                if (skuElement.getText().trim().equals(properSkuNumber)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
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
    public boolean pickDateFromCalender(String date) {
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
     * Set custom price of products present in item ordered table
     */
    public boolean setCustomPriceOfProductByIndexWithClickingUpdateItem(int indexOfProduct, String price) {
        try {
            List<WebElement> customPriceCheckBoxes = getElementsNew(customPriceCheckBox);
            PublicAdminCommons.scrollToElement(driver, customPriceCheckBoxes.get(indexOfProduct));
            PublicAdminCommons.loaderClick(customPriceCheckBoxes.get(indexOfProduct));
            waitForSpinnerLoaderToDisappear();
            List<WebElement> customPriceTextFields = getElementsNew(customPriceTextField);
            PublicAdminCommons.scrollToElement(driver, customPriceTextFields.get(indexOfProduct));
            customPriceTextFields.get(indexOfProduct).clear();
            customPriceTextFields.get(indexOfProduct).sendKeys(price);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Set Quantity by index
     *
     * @return true/false
     */
    public boolean setQuantityForProductUnderItemOrderByIndexWithoutClickingUpdateItem(int index, String quantity) {
        try {
            List<WebElement> quantityCheckBox = getElementsNew(productQuantityInItemOrderedList);
            quantityCheckBox.get(index).clear();
            quantityCheckBox.get(index).sendKeys(quantity);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Set publish/start date for all products
     *
     * @return
     */
    public boolean setPublishStartDateForAllProduct() {
        try {
            List<WebElement> publishDates = getElementsNew(publishDateField);
            List<WebElement> startDates = getElementsNew(startDateField);
            String date = PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy");
            for (WebElement publishDateElement : publishDates) {
                startDates.get(publishDates.indexOf(publishDateElement)).clear();
                startDates.get(publishDates.indexOf(publishDateElement)).sendKeys(date);
                publishDateElement.clear();
                publishDateElement.sendKeys(date);
            }
            getElementNew(updateItemButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    public boolean verifyUpdateItemPopupMessage() {
        try {
            String message = "Changes to product line items have not been saved. Click ‘OK' to accept without updates. Click 'Cancel' and check Updates were made. Then 'Submit’ the order .";
            String errorMessage = getElementNew(By.cssSelector("aside.modal-popup._show div[id*='modal-content']")).getText();
            return errorMessage.contains("Changes to product line items have not been saved. Click")
                    && errorMessage.contains("OK' to accept without updates. Click 'Cancel' and check Updates were made. Then 'Submit")
                    && errorMessage.contains(" the order");
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Set publish/start date for Sub/Mem
     *
     * @return
     */
    public boolean setPublishStartDateForSubMemProducts() {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            List<WebElement> publishDates = getElementsNew(publishDateField);
            List<WebElement> startDates = getElementsNew(startDateField);
            String date = PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy");
            List<String> productSkus = PublicAdminCommons.getTextOfWebElements(driver, skuNumbersInItemOrderedList);
            for (String sku : productSkus) {
                if(sku.contains("SUB-") || sku.contains("MEM")) {
                    startDates.get(productSkus.indexOf(sku)).clear();
                    startDates.get(productSkus.indexOf(sku)).sendKeys(date);
                    publishDates.get(productSkus.indexOf(sku)).clear();
                    publishDates.get(productSkus.indexOf(sku)).sendKeys(date);
                }
            }
            getElementNew(updateItemButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }


    @Step("Add products by SKU code and input Quantity")
    public boolean addProductSKUandQty(String properSkuNumber, String quantity) {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
           // ReusableMethods.scrollIntoView(getElementNew(addProductsButton), driver);

            Actions a = new Actions(driver);
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.HOME).build().perform();

            getElementNew(addProductsButton).click();
            PublicAdminCommons.waitForSec(9000);
            getElementNew(skuSearchTextField).sendKeys(properSkuNumber);
            PublicAdminCommons.waitForSec(3000);
            getElementNew(searchButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            PublicAdminCommons.waitForSec(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            List<WebElement> skusInSearchResult = getElementsNew(skuSearchResults);
            for (WebElement skuElement : skusInSearchResult) {
                if (skuElement.getText().trim().equals(properSkuNumber)) {
                    PublicAdminCommons.loaderClick(getElementsNew(selectProductFromListCheckbox).get(skusInSearchResult.indexOf(skuElement)));
                    PublicAdminCommons.waitForSec(500);
                    WebElement quantityTextField = getElementsNew(quantityTextFieldsUnderSearchResult).get(skusInSearchResult.indexOf(skuElement));
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    if (quantityTextField.isEnabled()) {
                        quantityTextField.clear();
                        quantityTextField.sendKeys(quantity);
                        ReusableMethods.scrollIntoView(getElementNew(addSelectedProductsToOrderButton), driver);
                        PublicAdminCommons.clickElementByJavaScript(driver, addSelectedProductsToOrderButton);
                        //getElementNew(addSelectedProductsToOrderButton).click();
                        PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
                        ScreenshotUtil.takeScreenshotForAllure(driver);
                        break;
                    }
                }
            }
            List<WebElement> skusUnderItemOrderedTable = getElementsNew(skuNumbersInItemOrderedList);
            for (WebElement skuElement : skusUnderItemOrderedTable) {
                new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(skuElement));
                if (skuElement.getText().replace("SKU:", "").trim()
                        .equals(properSkuNumber)) {
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

    @Step("Add products by SKU code and input Quantity")
    public boolean addProductSKU(String properSkuNumber) {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            // ReusableMethods.scrollIntoView(getElementNew(addProductsButton), driver);

            Actions a = new Actions(driver);
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.HOME).build().perform();

            getElementNew(addProductsButton).click();
            PublicAdminCommons.waitForSec(9000);
            getElementNew(skuSearchTextField).sendKeys(properSkuNumber);
            PublicAdminCommons.waitForSec(3000);
            getElementNew(searchButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            PublicAdminCommons.waitForSec(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            List<WebElement> skusInSearchResult = getElementsNew(skuSearchResults);
            for (WebElement skuElement : skusInSearchResult) {
                if (skuElement.getText().trim().equals(properSkuNumber)) {
                    PublicAdminCommons.loaderClick(getElementsNew(selectProductFromListCheckbox).get(skusInSearchResult.indexOf(skuElement)));
                    PublicAdminCommons.waitForSec(500);
                        ReusableMethods.scrollIntoView(getElementNew(addSelectedProductsToOrderButton), driver);
                        PublicAdminCommons.clickElementByJavaScript(driver, addSelectedProductsToOrderButton);
                        //getElementNew(addSelectedProductsToOrderButton).click();
                        PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
                        ScreenshotUtil.takeScreenshotForAllure(driver);
                        break;
                }
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }

    @Step("Add products by SKU code and input Quantity")
    public List<String> addandReturnProductsBySKU(String properSkuNumber) {
        try {
            List<String> productDetailsList=new ArrayList<String>();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);

            Actions a = new Actions(driver);
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.PAGE_UP).build().perform();
            a.sendKeys(Keys.HOME).build().perform();

            getElementNew(addProductsButton).click();
            PublicAdminCommons.waitForSec(9000);
            getElementNew(skuSearchTextField).sendKeys(properSkuNumber);
            PublicAdminCommons.waitForSec(3000);
            getElementNew(searchButton).click();
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            PublicAdminCommons.waitForSec(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            List<WebElement> skusInSearchResult = getElementsNew(skuSearchResults);
            for (WebElement skuElement : skusInSearchResult) {
                if (skuElement.getText().trim().equals(properSkuNumber)) {
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    productDetailsList.add(skuElement.getText().trim());
                    productDetailsList.add(getElement(skuSearchResultsName).getText().trim());
                    productDetailsList.add(getElement(skuSearchResultsPrice).getText().trim());
                    PublicAdminCommons.loaderClick(getElementsNew(selectProductFromListCheckbox).get(skusInSearchResult.indexOf(skuElement)));
                    PublicAdminCommons.waitForSec(500);
                    ReusableMethods.scrollIntoView(getElementNew(addSelectedProductsToOrderButton), driver);
                    PublicAdminCommons.clickElementByJavaScript(driver, addSelectedProductsToOrderButton);
                    //getElementNew(addSelectedProductsToOrderButton).click();
                    PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    break;
                }
            }
            return productDetailsList;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return null;
        }
    }

    public boolean ModifyQuantity(String Qty){
        getElement(QuantityNumber).clear();
        getElement(QuantityNumber).sendKeys(Qty);
        PublicAdminCommons.waitForSec(5000);
        getElement(updateItemButton).click();
        PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
        PublicAdminCommons.waitForSec(9000);
        return true;
    }
    public String changeShippingMethod(String ShippingMethod){
        WaitStatementUtils.waitForElementToBeClickable(driver,getElement(changeShippingMethod),10);
        getElement(changeShippingMethod).click();
        String standardPrice = getElement(standardServicePrice).getText().replace("$","");
        String newShippingPrice = getElement(changeShippingPrice(ShippingMethod)).getText().replace("$","");
        WaitStatementUtils.waitForElementToBeClickable(driver,getElement(changeShippingCheckbox(ShippingMethod)),10);
        getElement(changeShippingCheckbox(ShippingMethod)).click();
        PublicCommon.waitForSec(5);
        PublicAdminCommons.handleSpinnerIcon(driver, spinnerIcon);
        String price = getElement(ShippingTableRate).getText().substring(1);
        return price;
    }
    public String changeReqShippingMethod(String ShippingMethod){
        WaitStatementUtils.waitForElementToBeClickable(driver,getElement(changeShippingMethod),10);
        getElement(changeShippingMethod).click();
        WaitStatementUtils.waitForElementToBeClickable(driver,getElement(changeShippingCheckbox(ShippingMethod)),10);
        getElement(changeShippingCheckbox(ShippingMethod)).click();
        String newShippingPrice = getElement(changeShippingPrice(ShippingMethod)).getText().replace("$","");
        PublicCommon.waitForSec(5);
        return newShippingPrice;
    }
    public String FEDEX2ndDayValidation(String Value,String Expected){
        String Fedex2ndDayPrice = "37.59";
        Float s =Float.sum(Float.parseFloat(Fedex2ndDayPrice),Float.parseFloat(Value));
        String value = Float.toString(s);
        Assert.assertEquals(Float.parseFloat(value),Float.parseFloat(Expected));
        return value;
    }
    public HashMap<String, String> getPriceBookDealerMembershipDiscountSubTotalForProductByIndexUnderItemOrdered(int index) {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> sku = PublicAdminCommons.getTextOfWebElements(driver, productSKU);
            List<String> subTotal = PublicAdminCommons.getTextOfWebElements(driver, subTotalUnderItemOrdered);
            List<String> Discount = PublicAdminCommons.getTextOfWebElements(driver, BookDealerDiscount);
            List<String> TaxAmount = PublicAdminCommons.getTextOfWebElements(driver, RowTaxAmount);
            List<String> RowSubtotal = PublicAdminCommons.getTextOfWebElements(driver, RowSubtotalAmount);
            List<String> qty = PublicAdminCommons.getAttributeValueForElement(driver, QuantityNumber);
            orderTotals.put("membershipDiscount", Discount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("productSKU", sku.get(index));
            orderTotals.put("subTotal", subTotal.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("TaxAmount", TaxAmount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("RowSubtotal", RowSubtotal.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("QuantityNo",qty.get(index));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, String> getPriceSubscriptionAgencyMembershipDiscountSubTotalForProductByIndexUnderItemOrdered(int index) {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> subTotal = PublicAdminCommons.getTextOfWebElements(driver, subTotalUnderItemOrdered);
            List<String> Discount = PublicAdminCommons.getTextOfWebElements(driver, SubscriptionAgencyDiscount);
            List<String> TaxAmount = PublicAdminCommons.getTextOfWebElements(driver, RowTaxAmount);
            List<String> RowSubtotal = PublicAdminCommons.getTextOfWebElements(driver, RowSubtotalAmount);
            List<String> qty = PublicAdminCommons.getAttributeValueForElement(driver, QuantityNumber);
            orderTotals.put("membershipDiscount", Discount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("subTotal", subTotal.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("TaxAmount", TaxAmount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("RowSubtotal", RowSubtotal.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("QuantityNo",qty.get(index));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, String> getPriceMembershipDiscountSubTotalForProductByIndexUnderItemOrdered(int index) {
        try {
            HashMap<String, String> orderTotals = new HashMap<>();
            List<String> subTotal = PublicAdminCommons.getTextOfWebElements(driver, subTotalUnderItemOrdered);
            List<String> Discount = PublicAdminCommons.getTextOfWebElements(driver, MemberDiscount);
            List<String> TaxAmount = PublicAdminCommons.getTextOfWebElements(driver, RowTaxAmount);
            List<String> RowSubtotal = PublicAdminCommons.getTextOfWebElements(driver, RowSubtotalAmount);
            List<String> qty = PublicAdminCommons.getAttributeValueForElement(driver, QuantityNumber);
            orderTotals.put("membershipDiscount", Discount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("subTotal", subTotal.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("TaxAmount", TaxAmount.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("RowSubtotal", RowSubtotal.get(index).replace("$", "").replace("-", "")
                    .replace(",", ""));
            orderTotals.put("QuantityNo",qty.get(index));
            return orderTotals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<WebElement> getDiscountValues() {
        return getElements(BookDealerDiscount);
    }

    public String OrderTotalBookDealerDiscount(){
        PublicAdminCommons.scrollToElement(driver,getElementNew(OrderTotalBookDealerDiscount));
       return getElement(OrderTotalBookDealerDiscount).getText().replace(",", "").replace("-", "").replace("$","");
    }

    public String OrderTotalSubscriptionDiscount(){
        PublicAdminCommons.scrollToElement(driver,getElementNew(OrderTotalSubscriptionDiscount));
        return getElement(OrderTotalSubscriptionDiscount).getText().replace(",", "").replace("-", "").replace("$","");
    }

    public String OrderTotalMemberDiscount(){
        PublicAdminCommons.scrollToElement(driver,getElementNew(OrderTotalMemberDiscount));
        return getElement(OrderTotalMemberDiscount).getText().replace(",", "").replace("-", "").replace("$","");
    }

    @Step("Admin/ISS Agent select '{paymentMethod}' as payment method and '{receiptMethod}' as receipt method")
    public void issAgentSelectsCcTerminalPaymentMethod(String paymentMethod, String receiptMethod) {
        try {
            ReusableMethods.scrollIntoView(getElementNew(PaymentandShippingInfoLabel), driver);
            ReusableMethods.ScrollIntoViewUpwards(driver);
            ReusableMethods.scrollIntoView(getElementNew(PaymentandShippingInfoLabel), driver);
            //PublicCommon.JSClick(getElement(ccTerminalPaymnetMethod),driver);
            clickONMethod("CC Terminal/Check Checkbox", getCcTerminalPaymnetMethod(),
                    "Admin/ISS Agent is unable to click on 'CC Terminal/Check Checkbox'");
            //clickOnMethod("CC Terminal/Check Checkbox", getElement(ccTerminalPaymnetMethod));
            PublicAdminCommons.waitForSec(10000);
            selectValueFromDropDown("Payment Method Dropdown", getPaymentMethodDropDown(),
                    paymentMethod, "Admin/ISS Agent is unable to select Payment Method Dropdown");
            PublicAdminCommons.waitForSec(5000);
            //waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            selectValueFromDropDown("Receipt Method Dropdown", getReceiptMethodDropDown(),
                    receiptMethod, "Admin/ISS Agent is unable to select Receipt Method Dropdown");
            PublicAdminCommons.waitForSec(5000);
            //waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            enterTextInTextField("Identifying Number Text field", getIdentifyingNumberTextField(),
                    RandomStringUtils.getRandomNumbers(5), true,
                    "Admin/ISS Agent is unable to enter values in Identifying Number text field");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set payment and receipt method", e);
        }
    }

    @Step("Admin selects '{value}' from '{elementName}'")
    private void selectValueFromDropDown(String elementName, By locator, String value, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, locator, value), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to select option from drop down", e);
        }
    }

    @Step("Admin clicks on '{elementName}'")
    private void clickONMethod(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.loaderClick(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
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

    @Step("Admin/ISS Agent select '{paymentMethod}' as payment method and '{receiptMethod}' as receipt method")
    public void issAgentSelectDefaultPaymentMethod(String paymentMethod) {
        try {
            ReusableMethods.scrollIntoView(getElementNew(PaymentandShippingInfoLabel), driver);
            ReusableMethods.ScrollIntoViewUpwards(driver);
            ReusableMethods.scrollIntoView(getElementNew(PaymentandShippingInfoLabel), driver);
            getElement(invoiceRadioButton).getText().trim().equals(paymentMethod);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
        }
    }

    @Step("Admin/ISS Agent selects '{paymentMethod}' as payment method")
    public void selectPaymentMethodForPayment(String paymentMethod) {
        try {
            switch(paymentMethod) {
                case "Invoice":
                    ReusableMethods.scrollIntoView(getElementNew(PaymentandShippingInfoLabel), driver);
                    WaitStatementUtils.waitForElementToBeClickable(driver,getElement(invoiceRadioButton),3);
                    getElement(invoiceRadioButton).click();
                    PublicAdminCommons.handleSpinnerIcon(driver, spinnerIcon);
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    break;
                case "EFT - Wire Transfer":
                    // TODO
                    //Code for selecting EFT
                    break;
                case "CC Terminal/Check":
                    // TODO
                    // Code for selecting CC terminal
                    break;
                case "Credit Card":
                    // TODO
                    // Code for selecting Credit Card terminal
                    break;
                default:
                    // code block
            }

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
        }
    }

    @Step("Admin selects contacts for Billing Address and Shipping Address")
    public String adminSelectsContactsForTPT(int index) {
        String value;
        try {
            Select select = new Select(getElement(contactDropDownUnderBillingAddress));
            select.selectByIndex(index);
            Select select1 = new Select(getElement(contactDropDownUnderShippingAddress));
            select1.selectByIndex(index);
            List<WebElement> Options=select.getOptions();
            System.out.println(Options.get(index).getText());
            value=Options.get(index).getText();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to select contacts for product", e);
            value="null";
        }
        return value;
    }
    @Step("Admin selects contacts for Billing Address")
    public String adminSelectsBillingLearnerContact(int index) {
        String value;
        try {
            Select select = new Select(getElement(contactDropDownUnderBillingAddress));
            select.selectByIndex(index);
            List<WebElement> Options=select.getOptions();
            System.out.println(Options.get(index).getText());
            value=Options.get(index).getText();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to select contacts for product", e);
            value="null";
        }
        return value;
    }

    @Step("Admin selects contacts for Shipping Address")
    public String adminSelectsShippingLearnerContact(int index) {
        String value;
        try {
            Select select = new Select(getElement(contactDropDownUnderShippingAddress));
            select.selectByIndex(index);
            List<WebElement> Options=select.getOptions();
            System.out.println(Options.get(index).getText());
            value=Options.get(index).getText();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin is unable to select contacts for product", e);
            value="null";
        }
        return value;
    }
    public boolean setPublishStartDateForSubMemProductsWithLicenseSelected() {
        try {
            PublicAdminCommons.handleSpinnerIconOnMagento(driver, spinnerIcon);
            List<WebElement> publishDates = getElementsNew(publishDateField);
            List<WebElement> startDates = getElementsNew(startDateField);
            String date = PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy");
            List<String> productSkus = PublicAdminCommons.getTextOfWebElements(driver, skuNumbersInItemOrderedList);
            for (String sku : productSkus) {
                if(sku.contains("SUB-") || sku.contains("MEM")) {
                    WebElement licenseType = getElement(licenseTypeCodeDropDown);
                    PublicAdminCommons.scrollToElement(driver, licenseType);
                    Select select = new Select(licenseType);
                    select.selectByIndex(1);

                    startDates.get(productSkus.indexOf(sku)).clear();
                    startDates.get(productSkus.indexOf(sku)).sendKeys(date);
                    publishDates.get(productSkus.indexOf(sku)).clear();
                    publishDates.get(productSkus.indexOf(sku)).sendKeys(date);
                }
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }
}