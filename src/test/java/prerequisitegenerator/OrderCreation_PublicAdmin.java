package testobjects.prerequisitegenerator;

import base.utils.RandomStringUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ui.*;
import testobjects.*;

import java.util.List;

public class OrderCreation_PublicAdmin {

    private WebDriver driver;
    private CreateNewOrderPage_PublicAdmin CreateOrderPage;
    private OrderInformationPage_PublicAdmin OrderInformationPage;
    AccountCreationPage_PublicAdmin accountCreationPage_publicAdmin;
    AccountInformationEdit_PublicAdmin CustomerInformationEditPage;
    CreateAccount_PublicAdmin AccountCreationUtil;
    Account_PublicAdmin accountCreated;
    CommonPage_Public commonpage;
    CustomerViewPage_PublicAdmin CustomerViewPage;
    AllCustomerPage_PublicAdmin AllCustomerPage;
    MenuNavigationPage_PublicAdmin MenuNavigationPage;
    OrderInformationPage_PublicAdmin OrderViewScreen;
    Order_PublicAdmin compassOrder;


    public OrderCreation_PublicAdmin(WebDriver driver, Page page) {
        this.driver = driver;
        CreateOrderPage = page.getInstance(CreateNewOrderPage_PublicAdmin.class);
        OrderInformationPage = page.getInstance(OrderInformationPage_PublicAdmin.class);
        accountCreationPage_publicAdmin = page.getInstance(AccountCreationPage_PublicAdmin.class);
        CustomerInformationEditPage = page.getInstance(AccountInformationEdit_PublicAdmin.class);
        AccountCreationUtil = new CreateAccount_PublicAdmin(driver, page);
        CustomerViewPage = page.getInstance(CustomerViewPage_PublicAdmin.class);
        AllCustomerPage = page.getInstance(AllCustomerPage_PublicAdmin.class);
        MenuNavigationPage = page.getInstance(MenuNavigationPage_PublicAdmin.class);
        OrderViewScreen = page.getInstance(OrderInformationPage_PublicAdmin.class);
        commonpage = page.getInstance(CommonPage_Public.class);


    }

    @Step("User selects contact for order line item")
    public void selectConsortiaDropDown(String value) {
        try {
            selectValueFromDropDown("Consortia Drop Down", CreateOrderPage.getConsortiaFlagDropDown(), value,
                    "Unable to select option from 'Consortia Drop Down'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }


    @Step("Select order type as '{type}'")
    public void selectOrderTypeAsType(String type) {
        try {
            selectValueFromDropDown("Order Type Dropdown", CreateOrderPage.getOrderTypeDropDown(),
                    type, "Admin/ISS Agent is unable to select option from 'Order Type Dropdown'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to select order type as '{type}'", e);
        }
    }

    @Step("Admin/ISS Agent creates a new order")
    public boolean createOrderByObject(Order_PublicAdmin orderObject) {
        try {
            selectValueFromDropDown("Order Type Dropdown", CreateOrderPage.getOrderTypeDropDown(),
                    orderObject.getOrderType(),
                    "Admin/ISS Agent is unable to select option from 'Order Type Dropdown'");
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                addsProductWithSkuToCart(product.getSku(), product.getQuantity());
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            }
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                if (product.getPrice() != null)
                    issAgentChangesThePriceOfProduct(orderObject.getProducts().indexOf(product),
                            product.getPrice());
            }
            try {
                if (CreateOrderPage.selectLicenseByIndexInItemOrderedTable(0, 1)) {
                    Assert.assertTrue(CreateOrderPage.selectLicenseByIndexInItemOrderedTable(0, 1),
                            "Admin is unable to select contact for first line item");
                    //TODO Set License for Second Line Item
                    clickOnMethod("Update Item and Quantities", CreateOrderPage.getUpdateItemButton(),
                            "Admin is unable to click on 'Update items and quantities'");
                    waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
                }
            } catch (Exception e) {
                e.printStackTrace();
                //   PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
            }
            setPublishStartDateForSubMemProducts();
            clickOnMethod("update item button", CreateOrderPage.getUpdateItemButton(), "unable to click on update item button");

            if (orderObject.getBillingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleBillingAddress(),
                        "ISS Agent is unable to select billing address");
            }
            if (orderObject.getShippingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleShippingAddress(),
                        "ISS Agent is unable to select shipping address");
            }
            if (orderObject.getDeliverToAddress() != null) {
                Assert.assertTrue(CreateOrderPage.selectFreightForwardAddress(),
                        "ISS Agent is unable to select freight forward address");
            }
            if (orderObject.getPaymentType() != null) {
                issAgentSelectsCcTerminalPaymentMethod(PrePaymentMethods_PublicAdmin.CHECK.toString(),
                        PrePaymentMethods_PublicAdmin.Reciept.CDR2.toString(), RandomStringUtils.getRandomNumbers(4));

            }
            PublicAdminCommons.waitForSec(10000);
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(orderObject.getMajorPromoCode(), orderObject.getMinorPromoCode(), orderObject.getOrderChannelCode());
            if (!orderObject.isSendEmail())
                clickOnMethod("Email Order Confirmation Checkbox", CreateOrderPage.getEmailOrderConfirmationCheckBox(),
                        "Admin/ISS Agent is unable to click on 'Email Order Confirmation Checkbox'");
            /*Assert.assertTrue(PublicAdminCommons.checkUncheckCheckbox(driver, OrderViewScreen.getNotifyByEmailCheckboxInputTag(), true),
                    "Unable to check 'Notify Customer by Email' checkbox");*/
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Submit Order Button'");
            //PublicAdminCommons.waitForSec(2000);
            PublicAdminCommons.refreshPageTimes(driver, 10);
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "", "EBS order number is not populated and last order comment is '"
                    + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "EBS order status is not success");

            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "Unable to get EBS order number");
            orderObject.setEbsOrderNumber(ebsOrderNumber);
            String orderDate = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderDate());
            Assert.assertNotEquals(orderDate, "", "Unable to get order date");
            orderObject.setOrderDate(orderDate);
            String magentoOrderId = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderId, "", "Unable to get magento order id");
            orderObject.setMagentoOrderId(magentoOrderId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create new order", e);
            return false;
        }
    }

    @Step("Admin/ISS Agent creates a new order")
    public boolean createOrderByObjectWithoutLicenseDropDown(Order_PublicAdmin orderObject) {
        try {
            selectValueFromDropDown("Order Type Dropdown", CreateOrderPage.getOrderTypeDropDown(),
                    orderObject.getOrderType(),
                    "Admin/ISS Agent is unable to select option from 'Order Type Dropdown'");
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                addsProductWithSkuToCart(product.getSku(), product.getQuantity());
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            }
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                if (product.getPrice() != null)
                    issAgentChangesThePriceOfProduct(orderObject.getProducts().indexOf(product),
                            product.getPrice());
            }
           /* try {
                Assert.assertTrue(CreateOrderPage.selectLicenseByIndexInItemOrderedTable(0, 1),
                        "Admin is unable to select contact for first line item");
               *//* clickOnMethod("Update Item and Quantities", CreateOrderPage.getUpdateItemButton(),
                        "Admin is unable to click on 'Update items and quantities'");*//*
                waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            } catch (Exception e) {
                e.printStackTrace();
                PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
            }*/
            setPublishStartDateForSubMemProducts();
            clickOnMethod("update item button", CreateOrderPage.getUpdateItemButton(), "unable to click on update item button");

            if (orderObject.getBillingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleBillingAddress(),
                        "ISS Agent is unable to select billing address");
            }
            if (orderObject.getShippingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleShippingAddress(),
                        "ISS Agent is unable to select shipping address");
            }
            if (orderObject.getDeliverToAddress() != null) {
                Assert.assertTrue(CreateOrderPage.selectFreightForwardAddress(),
                        "ISS Agent is unable to select freight forward address");
            }
            if (orderObject.getPaymentType() != null) {
                issAgentSelectsCcTerminalPaymentMethod(PrePaymentMethods_PublicAdmin.CHECK.toString(),
                        PrePaymentMethods_PublicAdmin.Reciept.CDR2.toString(), RandomStringUtils.getRandomNumbers(4));

            }
            PublicAdminCommons.waitForSec(10000);
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(orderObject.getMajorPromoCode(), orderObject.getMinorPromoCode(), orderObject.getOrderChannelCode());
            if (!orderObject.isSendEmail())
                clickOnMethod("Email Order Confirmation Checkbox", CreateOrderPage.getEmailOrderConfirmationCheckBox(),
                        "Admin/ISS Agent is unable to click on 'Email Order Confirmation Checkbox'");
            Assert.assertTrue(PublicAdminCommons.checkUncheckCheckbox(driver, OrderViewScreen.getNotifyByEmailCheckboxInputTag(), true),
                    "Unable to check 'Notify Customer by Email' checkbox");
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Submit Order Button'");
            PublicAdminCommons.waitForSec(2000);
//            PublicAdminCommons.refreshPage(driver);
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "", "EBS order number is not populated and last order comment is '"
                    + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "EBS order status is not success");

            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "Unable to get EBS order number");
            orderObject.setEbsOrderNumber(ebsOrderNumber);
            String orderDate = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderDate());
            Assert.assertNotEquals(orderDate, "", "Unable to get order date");
            orderObject.setOrderDate(orderDate);
            String magentoOrderId = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderId, "", "Unable to get magento order id");
            orderObject.setMagentoOrderId(magentoOrderId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create new order", e);
            return false;
        }
    }


    @Step("Admin/ISS Agent creates a new order")
    public boolean createOrderByObjectWithCustomPrice(Order_PublicAdmin orderObject) {
        try {
            selectValueFromDropDown("Order Type Dropdown", CreateOrderPage.getOrderTypeDropDown(),
                    orderObject.getOrderType(),
                    "Admin/ISS Agent is unable to select option from 'Order Type Dropdown'");
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                addsProductWithSkuToCart(product.getSku(), product.getQuantity());
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            }
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                if (product.getPrice() != null)
                    issAgentChangesThePriceOfProduct(orderObject.getProducts().indexOf(product),
                            product.getPrice());
            }
            setCustomPriceForSubProduct();
            setPublishStartDateForSubMemProducts();

            clickOnMethod("update item button", CreateOrderPage.getUpdateItemButton(), "unable to click on update item button");

            if (orderObject.getBillingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleBillingAddress(),
                        "ISS Agent is unable to select billing address");
            }
            if (orderObject.getShippingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleShippingAddress(),
                        "ISS Agent is unable to select shipping address");
            }
            if (orderObject.getDeliverToAddress() != null) {
                Assert.assertTrue(CreateOrderPage.selectFreightForwardAddress(),
                        "ISS Agent is unable to select freight forward address");
            }
            if (orderObject.getPaymentType() != null) {
                issAgentSelectsCcTerminalPaymentMethod(PrePaymentMethods_PublicAdmin.CHECK.toString(),
                        PrePaymentMethods_PublicAdmin.Reciept.CDR2.toString(), RandomStringUtils.getRandomNumbers(4));

            }
            PublicAdminCommons.waitForSec(10000);
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(orderObject.getMajorPromoCode(), orderObject.getMinorPromoCode(), orderObject.getOrderChannelCode());
            if (!orderObject.isSendEmail())
                clickOnMethod("Email Order Confirmation Checkbox", CreateOrderPage.getEmailOrderConfirmationCheckBox(),
                        "Admin/ISS Agent is unable to click on 'Email Order Confirmation Checkbox'");
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Submit Order Button'");
            PublicAdminCommons.waitForSec(2000);
//            PublicAdminCommons.refreshPage(driver);
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "", "EBS order number is not populated and last order comment is '"
                    + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "EBS order status is not success");

            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "Unable to get EBS order number");
            orderObject.setEbsOrderNumber(ebsOrderNumber);
            String orderDate = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderDate());
            Assert.assertNotEquals(orderDate, "", "Unable to get order date");
            orderObject.setOrderDate(orderDate);
            String magentoOrderId = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderId, "", "Unable to get magento order id");
            orderObject.setMagentoOrderId(magentoOrderId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create new order", e);
            return false;
        }
    }


    @Step("Get magento order id")
    public String getMagentoOrderId() {
        try {
            String magentoOrderId = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderId, "", "Unable to get magento order id");
            return magentoOrderId;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to get magento order id", e);
            return "";
        }
    }

    @Step("Admin/ISS Agent creates a new order")
    public Order_PublicAdmin createPtpOrder() {
        try {
            Order_PublicAdmin orderObject = new Order_PublicAdmin();
            selectValueFromDropDown("Order Type Dropdown", CreateOrderPage.getOrderTypeDropDown(),
                    Order_PublicAdmin.OrderTypes.REGULAR_ORDER.toString(),
                    "Admin/ISS Agent is unable to select option from 'Order Type Dropdown'");
            addsProductWithSkuToCart(Product_PublicAdmin.TestProducts.PTP_PRODUCT_TWO.toString(), "1");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(CreateOrderPage.selectFreightForwardAddress(),
                    "ISS Agent is unable to select freight forward address");
            selectsContactUnderAddress(1);
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            issAgentSelectsCcTerminalPaymentMethod(PrePaymentMethods_PublicAdmin.CHECK.toString(),
                    PrePaymentMethods_PublicAdmin.Reciept.CDR2.toString(), RandomStringUtils.getRandomNumbers(4));
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(PromoCodes_PublicAdmin.Major.PTP.toString(),
                    PromoCodes_PublicAdmin.Minor.PTP.toString(), PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
            clickOnMethod("Email Order Confirmation Checkbox", CreateOrderPage.getEmailOrderConfirmationCheckBox(),
                    "Admin/ISS Agent is unable to click on 'Email Order Confirmation Checkbox'");
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Submit Order Button'");
            PublicAdminCommons.waitForSec(2000);
//            PublicAdminCommons.refreshPage(driver);
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "", "EBS order number is not populated and last order comment is '"
                    + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "EBS order status is not success");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "Unable to get EBS order number");
            orderObject.setEbsOrderNumber(ebsOrderNumber);
            String orderDate = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderDate());
            Assert.assertNotEquals(orderDate, "", "Unable to get order date");
            orderObject.setOrderDate(orderDate);
            String magentoOrderId = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderId, "", "Unable to get magento order id");
            orderObject.setMagentoOrderId(magentoOrderId);
            return orderObject;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create new order", e);
            return null;
        }
    }

    @Step("Admin/ISS Agent creates a new TPT order")
    public Order_PublicAdmin createTtpOrder() {
        try {
            Order_PublicAdmin orderObject = new Order_PublicAdmin();
            selectValueFromDropDown("Order Type Dropdown", CreateOrderPage.getOrderTypeDropDown(),
                    Order_PublicAdmin.OrderTypes.TPT_ORDER.toString(),
                    "Admin/ISS Agent is unable to select option from 'Order Type Dropdown'");
            addsProductWithSkuToCart(Product_PublicAdmin.TestProducts.TPT_PRODUCT_ONE.toString(), "1");
            selectContactForLineItemByIndex(0, 1);
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(PromoCodes_PublicAdmin.Major.TPT.toString(),
                    PromoCodes_PublicAdmin.Minor.TPT.toString(), PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
            clickOnMethod("Email Order Confirmation Checkbox", CreateOrderPage.getEmailOrderConfirmationCheckBox(),
                    "Admin/ISS Agent is unable to click on 'Email Order Confirmation Checkbox'");
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Submit Order Button'");
            PublicAdminCommons.waitForSec(2000);
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "", "EBS order number is not populated and last order comment is '"
                    + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "EBS order status is not success");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "Unable to get EBS order number");
            orderObject.setEbsOrderNumber(ebsOrderNumber);
            String orderDate = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderDate());
            Assert.assertNotEquals(orderDate, "", "Unable to get order date");
            orderObject.setOrderDate(orderDate);
            String magentoOrderId = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderId, "", "Unable to get magento order id");
            orderObject.setMagentoOrderId(magentoOrderId);
            return orderObject;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create new order", e);
            return null;
        }
    }

    @Step("Admin/ISS Agent creates a new order")
    public boolean createOrderByObjectWithoutValidatingOrderStatus(Order_PublicAdmin orderObject) {
        try {
            selectValueFromDropDown("Order Type Dropdown", CreateOrderPage.getOrderTypeDropDown(),
                    orderObject.getOrderType(),
                    "Admin/ISS Agent is unable to select option from 'Order Type Dropdown'");
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                addsProductWithSkuToCart(product.getSku(), product.getQuantity());
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            }
            setPublishStartDateForSubMemProducts();
            for (Product_PublicAdmin product : orderObject.getProducts()) {
                if (product.getPrice() != null)
                    issAgentChangesThePriceOfProduct(orderObject.getProducts().indexOf(product),
                            product.getPrice());
            }
            if (orderObject.getBillingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleBillingAddress(),
                        "ISS Agent is unable to select billing address");
            }
            if (orderObject.getShippingAddress() != null) {
                Assert.assertTrue(CreateOrderPage.handleShippingAddress(),
                        "ISS Agent is unable to select shipping address");
            }
            if (orderObject.getDeliverToAddress() != null) {
                Assert.assertTrue(CreateOrderPage.selectFreightForwardAddress(),
                        "ISS Agent is unable to select freight forward address");
            }
            if (orderObject.getPaymentType() != null) {
                issAgentSelectsCcTerminalPaymentMethod(PrePaymentMethods_PublicAdmin.CHECK.toString(),
                        PrePaymentMethods_PublicAdmin.Reciept.CDR2.toString(), RandomStringUtils.getRandomNumbers(4));
            }
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(orderObject.getMajorPromoCode(), orderObject.getMinorPromoCode(), orderObject.getOrderChannelCode());
            if (!orderObject.isSendEmail())
                clickOnMethod("Email Order Confirmation Checkbox", CreateOrderPage.getEmailOrderConfirmationCheckBox(),
                        "Admin/ISS Agent is unable to click on 'Email Order Confirmation Checkbox'");
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Submit Order Button'");
            PublicAdminCommons.waitForGetTextLengthToBeChanged(driver, OrderInformationPage.getEbsOrderStatus(), 4);
            String orderDate = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderDate());
            Assert.assertNotEquals(orderDate, "", "Unable to get order date");
            orderObject.setOrderDate(orderDate);
            String magentoOrderId = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderId, "", "Unable to get magento order id");
            orderObject.setMagentoOrderId(magentoOrderId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to create new order", e);
            return false;
        }
    }

    @Step("Admin/ISS selects billing/shipping/freight forward address")
    public void adminIssSelectsBillingShippingFreightForwardAddress() {
        try {
            Assert.assertTrue(CreateOrderPage.handleAddressSectionOnOrderCreationPage(false),
                    "Admin is unable to appropriate billing/shipping address");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS is unable to select billing/shipping/freight forward address", e);
        }
    }

    @Step("Admin/ISS Agent click on Reorder Button")
    public void adminIssAgentClickOnReorderButton() {
        try {
            clickOnMethod("Reorder Button", OrderInformationPage.getReorderButton(),
                    "Admin is unable to click on 'Reorder Button'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to click on Reorder Button", e);
        }
    }

    @Step("Admin/ISS Agent adds start and publish date")
    public void adminAddsStartAndPublishDateByIndex(int index) {
        try {
            Assert.assertTrue(CreateOrderPage.setPublishStartDateByIndex(index, PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy"),
                    PublicAdminCommons.getCurrentDateWithFormat("MM/dd/yyyy")));
            clickOnMethod("Update Items Button", CreateOrderPage.getUpdateItemButton(),
                    "Unable to click on 'Update Items Button'");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set start and publish date", e);
        }
    }

    @Step("Admin/ISS Agent adds start and publish date")
    public void adminAddsStartAndPublishDateByIndex(int index, String startDate, String publishDate) {
        try {
            Assert.assertTrue(CreateOrderPage.setPublishStartDateByIndex(index, startDate,
                    publishDate));
            clickOnMethod("Update Items Button", CreateOrderPage.getUpdateItemButton(),
                    "Unable to click on 'Update Items Button'");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set start and publish date", e);
        }
    }

    @Step("Admin/ISS Agent set publish and start date for all products to current date")
    public void adminAddsStartAndPublishDateForAllProducts() {
        try {
            Assert.assertTrue(CreateOrderPage.setPublishStartDateForAllProduct(), "Unable to set publish and start date for products");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set start and publish date", e);
        }
    }

    @Step("Verify EBS order number is generated")
    public void verifyEbsOrderNumberIsGenerated() {
        try {
            Assert.assertTrue(OrderInformationPage.handleRefreshOfPage(), "Admin/ISS Agent is unable to refresh page");
            Assert.assertFalse(
                    PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()).equals(""),
                    "EBS order number is not populated with order comment as '"
                            + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertTrue(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus())
                    .equals("Success"), "EBS order status is not success");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertFalse(ebsOrderNumber.equals(""), "Unable to get EBS order number");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to verify if EBS order number is generated", e);
        }
    }

    @Step("[{testCaseId}] Verify EBS order number is generated")
    public void verifyEbsOrderNumberIsGenerated(String testCaseId) {
        try {
            Assert.assertTrue(OrderInformationPage.handleRefreshOfPage(), "Admin/ISS Agent is unable to refresh page");
            Assert.assertFalse(
                    PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()).equals(""),
                    "[" + testCaseId + "] EBS order number is not populated with order comment as '"
                            + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertTrue(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus())
                    .equals("Success"), "[" + testCaseId + "] EBS order status is not success");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertFalse(ebsOrderNumber.equals(""), "[" + testCaseId + "] Unable to get EBS order number");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify if EBS order number is generated", e);
        }
    }

    @Step("[{testCaseId}] Verify EBS order number is generated")
    public void verifyEbsOrderNumberIsGeneratedWithDynamicRefresh(String testCaseId) {
        try {
            PublicAdminCommons.waitForSec(20000);
            Assert.assertTrue(OrderInformationPage.handleRefreshOfPage(), "Admin/ISS Agent is unable to refresh page");
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "",
                    "[" + testCaseId + "] EBS order number is not populated with order comment as '"
                            + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "[" + testCaseId + "] EBS order status is not success");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "[" + testCaseId + "] Unable to get EBS order number");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify if EBS order number is generated", e);
        }
    }

    @Step("[{testCaseId}] Verify EBS order number is generated")
    public String verifyEbsOrderNumberIsGeneratedWithDynamicRefreshandReturnEBSOrderNumber(String testCaseId) {
        String ebsOrderNumber=null;
        try {
            PublicAdminCommons.waitForSec(20000);
            Assert.assertTrue(OrderInformationPage.handleRefreshOfPage(), "Admin/ISS Agent is unable to refresh page");
            PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success");
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "",
                    "[" + testCaseId + "] EBS order number is not populated with order comment as '"
                            + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "[" + testCaseId + "] EBS order status is not success");
            ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "[" + testCaseId + "] Unable to get EBS order number");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify if EBS order number is generated", e);
        }
        return ebsOrderNumber;
    }


    @Step("[{testCaseId}] Verify EBS order number is generated")
    public void verifyEbsOrderNumberIsGeneratedWithDynamicRefreshWithTime(String testCaseId, int time) {
        try {
            //PublicAdminCommons.waitForGetTextToBeChangedTo(driver, OrderInformationPage.getEbsOrderStatus(), "Success", time);
            Assert.assertNotEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber()), "",
                    "[" + testCaseId + "] EBS order number is not populated with order comment as '"
                            + PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getOrderComments()) + "'");
            Assert.assertEquals(PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderStatus()), "Success", "[" + testCaseId + "] EBS order status is not success");
            String ebsOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderInformationPage.getEbsOrderNumber());
            Assert.assertNotEquals(ebsOrderNumber, "", "[" + testCaseId + "] Unable to get EBS order number");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify if EBS order number is generated", e);
        }
    }

    @Step("Admin/ISS Agent selects 'Standard Service' shipping details")
    public void selectStandardServiceShippingDetails() {
        try {
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to select payment and shipping options", e);
        }
    }

    @Step("Admin/ISS Agent selects 'Standard Service' shipping details")
    public void selectCustomerShippingOption(String shippingMethod, String ShippingaccountNumber) {
        try {
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            clickOnMethod("Change Shipping Link", CreateOrderPage.getClickToChangeShippingMethod(),
                    "Admin/ISS Agent is unable to click 'Change Shipping Method Link'");
            ReusableMethods.scrollIntoView(commonpage.getElement(CreateOrderPage.getCustomerShipppingAccountRadioButton()) ,driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,commonpage.getElement(CreateOrderPage.getCustomerShipppingAccountRadioButton()),10);
            PublicCommon.JSClick(commonpage.getElement(CreateOrderPage.getCustomerShipppingAccountRadioButton()) ,driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            /*clickOnMethod("Customer Shipping Account Radio Button", CreateOrderPage.getCustomerShipppingAccountRadioButton(),
                    "Admin/ISS Agent is unable to click 'Customer Shipping Account Radio Button'");*/
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            selectValueFromDropDown("Shipping Method Drop Down", CreateOrderPage.getShippngMethodDropDown(), shippingMethod,
                    "Admin/ISS Agent is unable to set shipping method");
            enterTextInTextField("Account Number Text Field", CreateOrderPage.getShippingAccountNumberTextField(),
                    ShippingaccountNumber, true,
                    "Admin/ISS Agent is unable to enter text in Shipping Account Number Text Field");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to select customer shipping method", e);
        }
    }

    @Step("Admin/ISS Agent selects '{majorPromoCode}', '{minorPromoCode}', '{orderChannel}' as Major, Minor and Order Channel promo codes")
    public void selectMajorMinorOrderChannelPromoCodes(String majorPromoCode, String minorPromoCode, String orderChannel) {
        try {
            Assert.assertTrue(CreateOrderPage.selectPromoCodes(majorPromoCode, minorPromoCode, orderChannel),
                    "Admin/ISS Agent is unable to select Major, Minor and Order Channel promo codes");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent is unable to select Major, Minor and Order Channel promo codes", e);
        }
    }

    @Step("Admin/ISS Agent selects address from billing address dropdown")
    public void selectsAddressFromBillingAddressDropdown(int addressValue) {
        try {
            selectValueFromDropDownByValue("Billing Address Drop down", CreateOrderPage.getBillingAddressDropDown(), addressValue,
                    "Admin/ISS Agent is unable to select option from 'Billing Address Drop down'");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from billing address dropdown", e);
        }
    }

    @Step("View Billing and Shipping Address")
    public void getBillingShippingAddress(){
        try{
            PublicAdminCommons.scrollToElement(driver,commonpage.getElement(commonpage.StreetAddressLabel));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent views address from billing address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects shipping and billing address")
    public void selectsBillingShippingAddressDropdown() {
        try {
            Assert.assertTrue(CreateOrderPage.handleBillingAddress(), "Unable to select billing address");
            Assert.assertTrue(CreateOrderPage.handleShippingAddress(), "Unable to select shipping address");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from billing address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects shipping, billing and freight forward address")
    public void selectsBillingShippingFreightAddressDropdown() {
        try {
            Assert.assertTrue(CreateOrderPage.handleAddressSectionOnOrderCreationPage(true),
                    "Unable to select address on order creation screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent randomly enters PO number")
    public void enterPoNumberRandomly() {
        try {
            enterTextInTextField("PO Number Text Field", CreateOrderPage.getPoNumberTextField(), RandomStringUtils.getRandomNumbers(8),
                    true, "Unable to enter text in 'PO Number Text Field'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects shipping, billing and freight forward address")
    public void selectsBillingShippingFreightAddressDropdownByIndex(int bill, int ship, int deliver) {
        try {
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getBillingAddressDropDown(),
                    bill), "Unable to select address under billing address dropdown");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            PublicAdminCommons.waitForSec(5000);
            Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, CreateOrderPage.getSameAsBillingAddressCheckBox(), CreateOrderPage.getSameAsBillingAddressCheckboxInput(), false),
                    "Unable to handle same as billing checkbox");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getShippingAddressDropDown(),
                    ship), "Unable to select address under shipping address dropdown");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            PublicAdminCommons.waitForSec(5000);
            Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, CreateOrderPage.getSpecifyFrieghtForwardAddressCheckBox(), CreateOrderPage.getSpecifyFreightForwardAddressCheckBoxInout(), true),
                    "Unable to click on Specify Freight Forward address");
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getFrieghtForwardAddressDropDown(),
                    deliver), "Unable to select address under freight forward address dropdown");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            PublicAdminCommons.waitForSec(5000);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects shipping, billing address by index")
    public void selectsBillingShippingAddressDropdownByIndex(int bill, int ship) {
        try {
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getBillingAddressDropDown(),
                    bill), "Unable to select address under billing address dropdown");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            WaitStatementUtils.waitForElementToBeClickable(driver, MenuNavigationPage.getElement(CreateOrderPage.getSameAsBillingAddressCheckBox()), 10);
            Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, CreateOrderPage.getSameAsBillingAddressCheckBox(), CreateOrderPage.getSameAsBillingAddressCheckboxInput(), false),
                    "Unable to handle same as billing checkbox");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getShippingAddressDropDown(),
                    ship), "Unable to select address under shipping address dropdown");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects shipping address by index")
    public void selectsShippingAddressDropdownByIndex(int ship) {
        try {
            Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, CreateOrderPage.getSameAsBillingAddressCheckBox(), CreateOrderPage.getSameAsBillingAddressCheckboxInput(), false),
                    "Unable to handle same as billing checkbox");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getShippingAddressDropDown(),
                    ship), "Unable to select address under shipping address dropdown");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects contact under billing,shipping and freight forward address")
    public void selectsContactUnderAddress(int optionNumberToSelect) {
        try {
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getContactUnderBillingAddressDropDown(),
                    optionNumberToSelect), "Unable to select contact under billing address dropdown");
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getContactUnderShippingAddressDropDown(),
                    optionNumberToSelect), "Unable to select contact under shipping address dropdown");
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getContactUnderFreightForwardAddressDropDown(),
                    optionNumberToSelect), "Unable to select contact under freight forward address dropdown");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects contact from contact dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects contact under billing and shipping address")
    public void selectsContactUnderBillingShippingAddress(int optionNumberToSelect) {
        try {
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getContactUnderBillingAddressDropDown(),
                    optionNumberToSelect), "Unable to select contact under billing address dropdown");
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdownByIndex(driver, CreateOrderPage.getContactUnderShippingAddressDropDown(),
                    optionNumberToSelect), "Unable to select contact under shipping address dropdown");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects contact from contact dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects contact under billing, shipping and freight forward address")
    public void selectsContactUnderBillingShippingFreightAddressByContactObject(String billContact, String shipContact,
                                                                                String deliverContact) {
        try {
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, CreateOrderPage.getContactUnderBillingAddressDropDown(),
                    billContact), "Unable to select contact under billing address dropdown");
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, CreateOrderPage.getContactUnderShippingAddressDropDown(),
                    shipContact), "Unable to select contact under shipping address dropdown");
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, CreateOrderPage.getContactUnderFreightForwardAddressDropDown(),
                    deliverContact), "Unable to select contact under freight forward address dropdown");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects contact from contact dropdown", e);
        }
    }

    @Step("Admin/ISS Agent selects address from shipping address dropdown")
    public void selectsAddressFromShippingAddressDropdown(int address) {
        try {
            clickOnMethod("Same As Billing Address Checkbox", CreateOrderPage.getSameAsBillingAddressCheckBox(),
                    "Admin/ISS Agent is unable to click on 'Same As Billing Address Checkbox'");
            Assert.assertTrue(PublicAdminCommons.turnOnOrOffToggleButton(driver, CreateOrderPage.getSameAsBillingAddressCheckBox(), CreateOrderPage.getSameAsBillingAddressCheckboxInput(),
                    false), "Unable to select 'Same As Billing Address Checkbox'");
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            PublicAdminCommons.waitForSec(3000);
            selectValueFromDropDownByValue("Shipping Address Drop down", CreateOrderPage.getShippingAddressDropDown(), address,
                    "Admin/ISS Agent is unable to select option from 'Shipping Address Drop down'");
            PublicAdminCommons.waitForSec(3000);
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from billing address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent submits the order")
    public void submitTheOrder() {
        try {
            PublicAdminCommons.waitForSec(10);
            ReusableMethods.scrollIntoView(CreateOrderPage.getElement(CreateOrderPage.getEmailOrderConfirmationCheckBox()),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, CreateOrderPage.getElement(CreateOrderPage.getEmailOrderConfirmationCheckBox()),10);
            clickOnMethod("Email Order Confirmation Checkbox", CreateOrderPage.getEmailOrderConfirmationCheckBox(),
                    "ISS Agent is unable to click on 'Email Order Confirmation Checkbox'");
            WaitStatementUtils.waitForElementToBeClickable(driver, CreateOrderPage.getElement(CreateOrderPage.getSubmitOrderButton()),10);
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Same As Billing Address Checkbox'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from billing address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent submits the order")
    public void submittheOrder() {
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, CreateOrderPage.getElement(CreateOrderPage.getSubmitOrderButton()),10);
            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Same As Billing Address Checkbox'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from billing address dropdown", e);
        }
    }

    @Step("Select current date for publish and start date")
    public void selectCurrentDateForPublishAndStartDate() {
        try {
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            clickOnMethod("Calender Icon For Start Date", CreateOrderPage.getStartDateCalenderIcon(),
                    "Unable to click on 'Calender Icon For Start Date'");
            clickOnMethod("Go Today", CreateOrderPage.getGoToTodayButton(),
                    "Unable to click on 'Go Today'");
            clickOnMethod("Close Button", CreateOrderPage.getCloseButtonForCalender(),
                    "Unable to click on 'Close Button'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            clickOnMethod("Calender Icon For Publish Date", CreateOrderPage.getPublishDateCalenderIcon(),
                    "Unable to click on 'Calender Icon For Start Date'");
            clickOnMethod("Go Today", CreateOrderPage.getGoToTodayButton(),
                    "Unable to click on 'Go Today'");
            clickOnMethod("Close Button", CreateOrderPage.getCloseButtonForCalender(),
                    "Unable to click on 'Close Button'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(CreateOrderPage.selectLicenseByIndexInItemOrderedTable(0, 1),
                    "Admin is unable to select License for first line item");
            clickOnMethod("Update Item and Quantities", CreateOrderPage.getUpdateItemButton(),
                    "Unable to click on 'Update Item and Quantities'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to select current date for publish and start date", e);
        }
    }

    @Step("Admin/ISS Agent submits the order")
    public void submitTheOrderWithEmailOptionEnabled() {
        try {

            clickOnMethod("Submit Order Button", CreateOrderPage.getSubmitOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Same As Billing Address Checkbox'");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent selects address from billing address dropdown", e);
        }
    }

    @Step("Admin/ISS Agent select '{paymentMethod}' as payment method and '{receiptMethod}' as receipt method")
    public void issAgentSelectsCcTerminalPaymentMethod(String paymentMethod, String receiptMethod, String amount) {
        try {
            clickOnMethod("CC Terminal/Check Checkbox", CreateOrderPage.getCcTerminalPaymnetMethod(),
                    "Admin/ISS Agent is unable to click on 'CC Terminal/Check Checkbox'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            selectValueFromDropDown("Payment Method Dropdown", CreateOrderPage.getPaymentMethodDropDown(),
                    paymentMethod, "Admin/ISS Agent is unable to select Payment Method Dropdown");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            selectValueFromDropDown("Receipt Method Dropdown", CreateOrderPage.getReceiptMethodDropDown(),
                    receiptMethod, "Admin/ISS Agent is unable to select Receipt Method Dropdown");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            enterTextInTextField("Identifying Number Text field", CreateOrderPage.getIdentifyingNumberTextField(),
                    RandomStringUtils.getRandomNumbers(5), true,
                    "Admin/ISS Agent is unable to enter values in Identifying Number text field");
            Assert.assertTrue(PublicAdminCommons.clickOnElement(driver, CreateOrderPage.getCcTerminalPaymnetMethod()),
                    "Unable to handle loading screen");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            enterTextInTextField("Amount Text field", CreateOrderPage.getAmountTextFieldUnderPayment(),
                    amount, true,
                    "Admin/ISS Agent is unable to enter values in Amount text field");
            Assert.assertTrue(PublicAdminCommons.clickOnElement(driver, CreateOrderPage.getCcTerminalPaymnetMethod()),
                    "Unable to handle loading screen");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set payment and receipt method", e);
        }
    }

    @Step("Admin/ISS Agent changes the price of product")
    public void issAgentChangesThePriceOfProduct() {
        try {
            Assert.assertTrue(CreateOrderPage.setCustomPriceOfProductByIndex(0, "200"),
                    "Admin/ISS Agent is unable to set price of product");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            PublicAdminCommons.waitForSec(3000);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent changes the price of product", e);
        }
    }

    @Step("Admin/ISS Agent changes the price of product to {price}")
    public void issAgentChangesThePriceOfProduct(String price) {
        try {
            Assert.assertTrue(CreateOrderPage.setCustomPriceOfProductByIndex(0, price),
                    "Admin/ISS Agent is unable to set price of product");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent changes the price of product", e);
        }
    }

    @Step("Admin/ISS Agent changes the price of product to {price}")
    public void issAgentChangesThePriceOfProduct(int index, String price) {
        try {
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            Assert.assertTrue(CreateOrderPage.setCustomPriceOfProductByIndex(index, price),
                    "Admin/ISS Agent is unable to set price of product");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            PublicAdminCommons.waitForSec(3000);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent changes the price of product", e);
        }
    }

    @Step("Admin/ISS Agent changes the price of product to {price}")
    public void issAgentChangesThePriceOfProductHandleCheckbox(int index, String price) {
        try {
            Assert.assertTrue(CreateOrderPage.setCustomPriceOfProductByIndexHandlingCheckbox(index, price),
                    "Admin/ISS Agent is unable to set price of product");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            PublicAdminCommons.waitForSec(3000);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent changes the price of product", e);
        }
    }

    @Step("Admin/ISS Agent changes the price of all products")
    public void issAgentChangesThePriceOfAllProducts() {
        try {
            Assert.assertTrue(CreateOrderPage.setCustomPriceOfProducts(),
                    "Admin/ISS Agent is unable to set price of product");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent changes the price of products", e);
        }
    }

    @Step("Admin/ISS Agent adds product with '{skuOne}' sku and quantity as '{quantity}' to cart")
    public void addsProductWithSkuToCart(String skuOne, String quantity) {
        try {
            Assert.assertTrue(CreateOrderPage.addProductBySearchingForSku(skuOne, quantity), "Admin/ISS Agent is unable to add product to cart");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("Admin/ISS Agent adds product to cart")
    public void addsProductBySearchUnderSkuField(String searchQuery) {
        try {
            clickOnMethod("Add Products Button", CreateOrderPage.getAddProductsButton(),
                    "Admin is unable to click on 'Add Products Button'");
            enterTextInTextField("SKU Search Field", CreateOrderPage.getSkuSearchTextField(), searchQuery, true,
                    "Admin is unable to enter text in 'SKU Search Field'");
            clickOnMethod("Search Button", CreateOrderPage.getSearchButton(),
                    "Admin is unable to click on 'Search Button'");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, CreateOrderPage.getSpinnerIcon()),
                    "Spinner icon did not disappear from screen");
            clickOnMethod("First Search Result", CreateOrderPage.getFirstSearchResult(),
                    "Admin is unable to click on First Search Result'");
            enterTextInTextField("Product Quantity Text Field", CreateOrderPage.getProductQuantityTextField(), "1",
                    true, "Admin is unable to enter text in 'Product Quantity Text Field'");
            clickOnMethod("Add Selected Products To Order Button",
                    CreateOrderPage.getAddSelectedProductsToOrderButton(),
                    "Admin is unable to click on 'Add Selected Products to order button'");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, CreateOrderPage.getSpinnerIcon()),
                    "Spinner icon did not disappear from screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("Admin/ISS Agent enters '{searchQuery}' in SKU field")
    public void searchForProductUsingSkuField(String searchQuery) {
        try {
            clickOnMethod("Add Products Button", CreateOrderPage.getAddProductsButton(),
                    "Admin is unable to click on 'Add Products Button'");
            enterTextInTextField("SKU Search Field", CreateOrderPage.getSkuSearchTextField(), searchQuery, true,
                    "Admin is unable to enter text in 'SKU Search Field'");
            clickOnMethod("Search Button", CreateOrderPage.getSearchButton(),
                    "Admin is unable to click on 'Search Button'");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, CreateOrderPage.getSpinnerIcon()),
                    "Spinner icon did not disappear from screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to search for product", e);
        }
    }

    @Step("ISS Agent adds product to cart")
    public void addsProductBySearchUnderEbsSkuField(String searchQuery) {
        try {
            clickOnMethod("Add Products Button", CreateOrderPage.getAddProductsButton(),
                    "Admin is unable to click on 'Add Products Button'");
            enterTextInTextField("EBS SKU Search Field", CreateOrderPage.getEbsSkuFilterField(), searchQuery, true,
                    "Admin is unable to enter text in 'EBS SKU Search Field'");
            clickOnMethod("Search Button", CreateOrderPage.getSearchButton(),
                    "Admin is unable to click on 'Search Button'");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, CreateOrderPage.getSpinnerIcon()),
                    "Spinner icon did not disappear from screen");
            clickOnMethod("First Search Result", CreateOrderPage.getFirstSearchResult(),
                    "Admin is unable to click on First Search Result'");
            enterTextInTextField("Product Quantity Text Field", CreateOrderPage.getProductQuantityTextField(), "1",
                    true, "Admin is unable to enter text in 'Product Quantity Text Field'");
            clickOnMethod("Add Selected Products To Order Button",
                    CreateOrderPage.getAddSelectedProductsToOrderButton(),
                    "Admin is unable to click on 'Add Selected Products to order button'");
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, CreateOrderPage.getSpinnerIcon()),
                    "Spinner icon did not disappear from screen");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("ISS Agent set quantity '{quantity}' for product in cart")
    public void issAgentSetQuantityOfProductInCartByIndex(int index, String quantity) {
        try {
            Assert.assertTrue(
                    CreateOrderPage.setQuantityForProductUnderItemOrderByIndex(index,
                            quantity),
                    "Admin/ISS Agent is unable to set quantity of product in cart");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to set quantity of product in cart", e);
        }
    }

    @Step("ISS Agent/Admin removes all product from cart")
    public void issAgentAdminRemovesAllProductFromCart() {
        try {
            // PublicAdminCommons.waitForSec(2000);
            Assert.assertTrue(CreateOrderPage.removeAllItemsFromItemOrderedList(),
                    "ISS Agent/Admin is unable to remove all product from cart");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent/Admin is unable to remove all product from cart", e);
        }
    }

    @Step("ISS Agent/Admin removes product from cart")
    public void issAgentAdminRemovesProductFromCartByIndex(int index) {
        try {
            PublicAdminCommons.waitForSec(2000);
            Assert.assertTrue(CreateOrderPage.removeProductFromCartByIndex(index),
                    "ISS Agent/Admin is unable to remove product from cart");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent/Admin is unable to remove product from cart", e);
        }
    }

    @Step("ISS Agent adds product with '{skuOne}' sku and quantity as '{quantity}' to cart using 'Add Products By SKU'")
    public void addsProductWithSkuToCartByAddProductBySkuFunctionality(String skuOne, String quantity) {
        try {
            clickOnMethod("Add Product By SKU number", CreateOrderPage.getAddProductBySkuButton(),
                    "Admin/ISS Agent is unable to click on 'Add Product By SKU number'");
            enterTextInTextField("SKU Number Text Field", CreateOrderPage.getSkuNumberTextField(), skuOne, true,
                    "Admin/ISS Agent is unable to enter text in 'SKU Number Text Field'");
            enterTextInTextField("Product Quantity Text Field", CreateOrderPage.getQuantityTextField(), quantity, true,
                    "Admin/ISS Agent is unable to enter text in 'Quantity Text Field'");
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, CreateOrderPage.getAddToOrderButton()),
                    "Admin/ISS Agent is unable to scroll to 'Add To Order Button'");
            clickOnMethod("Add To Order Button", CreateOrderPage.getAddToOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Add To Order Button'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("ISS Agent adds products to cart using 'Add Products By EBS SKU'")
    public void addsProductWithSkuToCartByAddProductByEbsSkuFunctionalityWithList(List<String> skusList, String quantity) {
        try {
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            clickOnMethod("Add Product By EBS SKU Button", CreateOrderPage.getAddProductByEbsSkuButton(),
                    "Admin/ISS Agent is unable to click on 'Add Product By EBS SKU Button'");
            Assert.assertTrue(CreateOrderPage.addMultipleProductByEbsSkuFunctionality(skusList, quantity),
                    "Unable to enter product ebs sku");
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, CreateOrderPage.getAddToOrderForEbsSkuFunc()),
                    "Admin/ISS Agent is unable to scroll to 'Add To Order Button'");
            clickOnMethod("Add To Order Button", CreateOrderPage.getAddToOrderForEbsSkuFunc(),
                    "Admin/ISS Agent is unable to click on 'Add To Order Button'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("ISS Agent adds products to cart using 'Add Products By SKU'")
    public void addsProductWithSkuToCartByAddProductBySkuFunctionalityWithList(List<String> skusList, String quantity) {
        try {
            clickOnMethod("Add Product By SKU number", CreateOrderPage.getAddProductBySkuButton(),
                    "Admin/ISS Agent is unable to click on 'Add Product By SKU number'");
            Assert.assertTrue(CreateOrderPage.addMultipleProductBySkuFunctionality(skusList, quantity),
                    "Unable to enter product sku");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, CreateOrderPage.getAddToOrderButton()),
                    "Admin/ISS Agent is unable to scroll to 'Add To Order Button'");
            clickOnMethod("Add To Order Button", CreateOrderPage.getAddToOrderButton(),
                    "Admin/ISS Agent is unable to click on 'Add To Order Button'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
          //  ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }


    @Step("Admin/ISS Agent Selects payment, shipping and additional details")
    public void adminIssAgentSelectsPaymentShippingAndAdditionalDetails() {
        try {
            String rowTotalPrice = PublicAdminCommons.getTextOfElement(driver, CreateOrderPage.getTotalPriceItemOrdered());
            if (!rowTotalPrice.equals("$0.00")) {
                CreateOrderPage.handleGetPaymentMethod();
                clickOnMethod("Invoice Button", CreateOrderPage.getInvoiceRadioButton(),
                        "Admin/ISS Agent is unable to click on 'Invoice Button'");
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(PromoCodes_PublicAdmin.Major.WEB.toString(),
                    PromoCodes_PublicAdmin.Minor.UNDEFINED.toString(), PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to select payment, shipping and additional details", e);
        }
    }

    @Step("Admin/ISS Agent Selects payment, shipping and additional details")
    public void adminIssAgentSelectsPaymentShippingAndAdditionalDetailswithCreditcard(String CreditcardNo, String ExpiryMonth,String ExpiryYear,String cvv) {
        try {
            String rowTotalPrice = PublicAdminCommons.getTextOfElement(driver, CreateOrderPage.getTotalPriceItemOrdered());
            if (!rowTotalPrice.equals("$0.00")) {
                CreateOrderPage.handleGetPaymentMethod();
                Assert.assertTrue(CreateOrderPage.setCreditCardDetails(CreditcardNo, ExpiryMonth,ExpiryYear, cvv),
                        "Admin/ISS Agent is unable to set  Credit Card Detials");
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "No shipping method is selected as default");
            selectMajorMinorOrderChannelPromoCodes(PromoCodes_PublicAdmin.Major.WEB.toString(),
                    PromoCodes_PublicAdmin.Minor.UNDEFINED.toString(), PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to select payment, shipping and additional details", e);
        }
    }

    @Step("[{testCaseId}] Admin/ISS Agent Selects payment, shipping and additional details")
    public void adminIssAgentSelectsPaymentShippingAndAdditionalDetails(String testCaseId) {
        try {
            String rowTotalPrice = PublicAdminCommons.getTextOfElement(driver, CreateOrderPage.getTotalPriceItemOrdered());
            if (!rowTotalPrice.equals("$0.00")) {
                CreateOrderPage.handleGetPaymentMethod();
                CreateOrderPage.setCustomPriceOfProducts("100");
                PublicAdminCommons.waitForSec(2000);
                clickOnMethod("update item button", CreateOrderPage.getUpdateItemButton(), "unable to click on update item button");
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
                clickOnMethod("Invoice Button", CreateOrderPage.getInvoiceRadioButton(),
                        "[" + testCaseId + "] Admin/ISS Agent is unable to click on 'Invoice Button'");
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "[" + testCaseId + "] No shipping method is selected as default");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            selectMajorMinorOrderChannelPromoCodes(PromoCodes_PublicAdmin.Major.WEB.toString(),
                    PromoCodes_PublicAdmin.Minor.UNDEFINED.toString(), PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Admin/ISS Agent is unable to select payment, shipping and additional details", e);
        }
    }

    @Step("[{testCaseId}] Admin/ISS Agent Selects payment, shipping and additional details")
    public void adminIssAgentSelectsPaymentShippingAndAdditionalDetailsWithoutInvoice(String testCaseId) {
        try {
            String rowTotalPrice = PublicAdminCommons.getTextOfElement(driver, CreateOrderPage.getTotalPriceItemOrdered());
            if (!rowTotalPrice.equals("$0.00")) {
                CreateOrderPage.handleGetPaymentMethod();
                CreateOrderPage.setCustomPriceOfProducts("100");
                clickOnMethod("update item button", CreateOrderPage.getUpdateItemButton(), "unable to click on update item button");
                waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            Assert.assertTrue(PublicAdminCommons.isWebElementPresentOnPage(driver, CreateOrderPage.getClickToChangeShippingMethod()),
                    "[" + testCaseId + "] No shipping method is selected as default");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            selectMajorMinorOrderChannelPromoCodes(PromoCodes_PublicAdmin.Major.WEB.toString(),
                    PromoCodes_PublicAdmin.Minor.UNDEFINED.toString(), PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Admin/ISS Agent is unable to select payment, shipping and additional details", e);
        }
    }

    @Step("Admin/ISS Agent Selects payment and additional details")
    public void adminIssAgentSelectsPaymentAndAdditionalDetails() {
        try {
            //PublicAdminCommons.scrollToElement(driver, CreateOrderPage.getInvoiceRadioButton());
            ReusableMethods.scrollIntoView(commonpage.getElement(CreateOrderPage.getInvoiceRadioButton()), driver);
            /*clickOnMethod("Invoice Button", CreateOrderPage.getInvoiceRadioButton(),
                    "Admin/ISS Agent is unable to click on 'Invoice Button'");*/
            WaitStatementUtils.waitForElementToBeClickable(driver, commonpage.getElement(CreateOrderPage.getInvoiceRadioButton()), 5);
            PublicCommon.JSClick(commonpage.getElement(CreateOrderPage.getInvoiceRadioButton()), driver);
            waitForLoadingScreenToAppearAndDisappear(CreateOrderPage.getSpinnerIcon());
            selectMajorMinorOrderChannelPromoCodes(PromoCodes_PublicAdmin.Major.WEB.toString(),
                    PromoCodes_PublicAdmin.Minor.UNDEFINED.toString(), PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to select payment, shipping and additional details", e);
        }
    }

    @Step("ISS Agent selects contact for order line item")
    public void selectContactForLineItemByIndex(int lineItemIndex, int contactIndex) {
        try {
            Assert.assertTrue(CreateOrderPage.selectContactByIndexInItemOrderedTable(lineItemIndex, contactIndex),
                    "Admin is unable to select contact for first line item");
            clickOnMethod("Update Item and Quantities", CreateOrderPage.getUpdateItemButton(),
                    "Admin is unable to click on 'Update items and quantities'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("ISS Agent selects License for order line item")
    public void selectLicenseForLineItemByIndex(int lineItemIndex, int licenseIndex) {
        try {
            PublicAdminCommons.waitForSec(3000);
            WaitStatementUtils.implicitWaitForSeconds(driver, 5);
            Assert.assertTrue(CreateOrderPage.selectLicenseByIndexInItemOrderedTable(lineItemIndex, licenseIndex),
                    "Admin is unable to select contact for first line item");
            clickOnMethod("Update Item and Quantities", CreateOrderPage.getUpdateItemButton(),
                    "Admin is unable to click on 'Update items and quantities'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            WaitStatementUtils.implicitWaitForSeconds(driver, 5);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("Set the publish and start date for SUB-/MEM products under item ordered table")
    public void setPublishStartDateForSubMemProducts() {
        try {
            Assert.assertTrue(CreateOrderPage.setPublishStartDateForSubMemProducts(),
                    "Unable to set publish and start date for the products");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to set publish and start date for the products", e);
        }
    }

    @Step("Set Custom price for products with 0 price")
    public void setCustomPriceForSubProduct() {
        try {
            Assert.assertTrue(CreateOrderPage.setCustomPriceOfProducts("100"),
                    "Unable to set publish and start date for the products");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to set custom price", e);
        }

    }

    @Step("ISS Agent selects contact for order line item")
    public void selectContactForLineItemByIndex(int lineItemIndex, String contact) {
        try {
            Assert.assertTrue(CreateOrderPage.selectContactByIndexAndContactValueInItemOrderedTable(lineItemIndex, contact),
                    "Admin is unable to select contact for first line item");
            clickOnMethod("Update Item and Quantities", CreateOrderPage.getUpdateItemButton(),
                    "Admin is unable to click on 'Update items and quantities'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product to cart", e);
        }
    }

    @Step("Admin/ISS Agent clicks on '{elementName}'")
    private void clickOnMethod(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin/ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.loaderClick(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("Admin/ISS Agent clicks on '{elementName}'")
    private void clickOnMethodWithoutWait(String elementName, By locator, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.clickWebElementWithoutWait(driver, locator), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Click on element", e);
        }
    }

    @Step("Admin/ISS Agent enters '{value}' in '{elementName}'")
    private void enterTextInTextField(String elementName, By locator, String value, boolean clear,
                                      String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin/ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.enterTextInTextField(driver, locator, value, clear), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to enter text in text field", e);
        }
    }

    @Step("Admin/ISS Agent selects '{value}' from '{elementName}'")
    private void selectValueFromDropDown(String elementName, By locator, String value, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin/ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.selectValueFromDropdown(driver, locator, value), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to select option from drop down", e);
        }
    }

    @Step("Admin/ISS Agent selects '{value}' from '{elementName}'")
    private void selectValueFromDropDownByValue(String elementName, By locator, int value, String assertionMessage) {
        try {
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, locator),
                    "Admin/ISS Agent is unable to scroll to " + elementName);
            Assert.assertTrue(PublicAdminCommons.selectValueInDropdownbyValue(driver, locator, value), assertionMessage);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to select option from drop down", e);
        }
    }

    @Step("Admin/ISS Agent waits for loading screen to disappear")
    private void waitForLoadingScreenToDisappear(By locator) {
        try {
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, locator),
                    "Loading screen did not disapeear.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Loading screen did not disapeear.", e);
        }
    }

    @Step("Admin/ISS Agent waits for loading screen to first appear and disappear")
    public void waitForLoadingScreenToAppearAndDisappear(By locator) {
        try {
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, locator),
                    "Loading screen did not disappear.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Loading screen did not disappear.", e);
        }
    }

    @Step("Create new account and place a Membership order from it")
    public String createNewAccountAndPlaceMembershipOrderAndReturnEBSAccount(String customerType, Order_PublicAdmin OrderObject) {
        try {
            MenuNavigationPage.navigatesToAllCustomerTab();
            clickOnMethod("Add New Customer Button", AllCustomerPage.getAddNewCustomerButton(),
                    "Unable to click on Add Customer Button");
            accountCreated = AccountCreationUtil.createAccountByObject(new Account_PublicAdmin(customerType)); //Organization
            AccountCreationUtil.adminGetsEbsAccountNumber(accountCreated);
            //CommonActions.manualEbsStep("Account created with email "+accountCreated.getEmail());
            // Above two lines create a customer

            clickOnMethod("Create Order Button", CustomerViewPage.getCreateOrderButton(),
                    "ISS Agent is unable to click on 'Create Order Button'");

            // Above line click on create order button

            createOrderByObject(OrderObject); // This will create order using membership object
            return accountCreated.getEbsAccountNumber();

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Failed to Create new account and place a Membership order from it", e);
        }
        return customerType;
    }

    @Step("Admin/ISS Agent adds product By '{skuOne}' sku and quantity as '{quantity}' and submit Order")
    public void addsProductBySKU(String skuOne, int quantity) {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            CreateOrderPage.addProductSKUandQty(skuOne, String.valueOf(quantity));
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product and submit", e);
        }
    }

    @Step("Admin/ISS Agent adds product By '{skuOne}' sku and quantity as '{quantity}' and submit Order")
    public void addsProductBySKUCode(String skuOne) {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(CreateOrderPage.addProductSKU(skuOne), "Admin/ISS Agent is unable to add product to cart");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product and submit", e);
        }
    }

    public void ModifyQuantity(int Quantity) {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(CreateOrderPage.ModifyQuantity(String.valueOf(Quantity)));
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to add product and submit", e);
        }
    }

    @Step("Change the Shipping method")
    public String ChangeShippingMethod(String ShippingMethod) {
        String newPrice = null;
        try {
            newPrice = CreateOrderPage.changeShippingMethod(ShippingMethod);

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Admin/ISS Agent is unable to Change the Shipping method", e);
        }
        return newPrice;
    }

    @Step("Admin/ISS Agent selects '{majorPromoCode}', '{minorPromoCode}', '{orderChannel}' as Major, Minor and Order Channel promo codes")
    public void EnterCreditCardDetails(String CreditcardNo, String ExpiryMonth, String ExpiryYear,String cvv) {
        try {
             Assert.assertTrue(commonpage.setCreditCardDetails(CreditcardNo, ExpiryMonth,ExpiryYear, cvv),
                    "Admin/ISS Agent is unable to set  Credit Card Detials");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("ISS Agent is unable to select Major, Minor and Order Channel promo codes", e);
        }
    }


    @Step("Verify admin add products by SKU numbers")
    public void verifyAdminAddProductsBySkuNumbers(String skuNumberOne, String quantity) {
        try {
            clickOnMethod("Add Product By SKU number", CreateOrderPage.getAddProductBySkuButton(),
                    "Admin is unable to click on 'Add Product By SKU number'");
            enterTextInTextField("SKU Number Text Field", CreateOrderPage.getSkuNumberTextField(), skuNumberOne, true,
                    "Admin is unable to enter text in 'SKU Number Text Field'");
            enterTextInTextField("Product Qunatity Text Field", CreateOrderPage.getQuantityTextField(), quantity, true,
                    "Admin is unable to enter text in 'Quantity Text Field'");
            Assert.assertTrue(PublicAdminCommons.scrollToElement(driver, CreateOrderPage.getAddToOrderButton()),
                    "Admin is unable to scroll to 'Add To Order Button'");
            clickOnMethod("Add To Order Button", CreateOrderPage.getAddToOrderButton(),
                    "Admin is unable to click on 'Add To Order Button'");
            waitForLoadingScreenToDisappear(CreateOrderPage.getSpinnerIcon());
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[PUB-5244] Admin is unable to add product to order.", e);
        }
    }

    @Step("Click on Create new order")
    public void createOrder() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, commonpage.getElement(commonpage.createOrder),10);
            WaitStatementUtils.waitForElementToBeClickable(driver, commonpage.getElement(commonpage.createOrder),5);
            clickOnMethod("Create Order button",commonpage.createOrder,"Failed to click on Create Order button");
            PublicCommon.waitForSec(5);
            driver.navigate().refresh();
            PublicCommon.waitForSec(5);
            PublicAdminCommons.waitForSec(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("unable to click on create order", e);
        }
    }
}