package tests;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import com.astm.commonFunctions.EBSAPIs;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import testobjects.Account_PublicAdmin;
import testobjects.Product_PublicAdmin;
import testobjects.prerequisitegenerator.OrderCreation_PublicAdmin;
import tests.ui.base.BaseTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionAgencyLevel1_ToValidateDiscountAppliedOnProductOnB2BAccount_INT_4241 extends BaseTest {

    static final String jiraTestID = "INT-4241";
    MagentoLoginAndVerifyDashboardPage magentoLogin;
    CommonPage_Public commonpage;
    OrderCreation_PublicAdmin OrderCreationUtil;
    MembershipDiscountsCommon_PublicAdmin MembershipDiscountsCommon;
    AccountCreationPage_PublicAdmin AccountCreationPage;
    BillingAddressPage_Public billingAddressPage;
    MembershipBecomeMemberPage newMembershipPage;
    CreateNewOrderPage_PublicAdmin CreateOrderPage;
    CustomerLogin_Public loginPage;
    AllCustomerPage_PublicAdmin AllCustomerPage;
    OrderInformationPage_PublicAdmin OrderViewPage;
    AccountDropDownMenuPage_RAP accountdropdownpage;
    JsonFileReader jsonFileReader;
    List<String> productsToAdd;
    String ProductType = "Delivery Method Code == PRINT";
    String environment = null;
    String CustomerType = "B2B";
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_PUB_ADMIN_ASTM"));
        environment = PublicCommon.environmentSelector().toUpperCase();
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("To validate that for an account having Classification as Subscription Agency Level 1 while submitting order, correct discount is applied on the products which are eligible for subscription agency discount || B2B")
    @Test(description = jiraTestID
            + ": To validate that for an account having Classification as Subscription Agency Level 1 while submitting order, correct discount is applied on the products which are eligible for subscription agency discount || B2B", groups = {""})
    public void VerifySubscriptionAgencyLevel1_ToValidateDiscountAppliedOnProductOnB2BAccount() {
        try {
            commonpage = page.getInstance(CommonPage_Public.class);
            magentoLogin = page.getInstance(MagentoLoginAndVerifyDashboardPage.class);
            OrderCreationUtil = new OrderCreation_PublicAdmin(driver, page);
            MembershipDiscountsCommon = new MembershipDiscountsCommon_PublicAdmin(driver, page);
            CreateOrderPage = page.getInstance(CreateNewOrderPage_PublicAdmin.class);
            newMembershipPage = page.getInstance(MembershipBecomeMemberPage.class);
            accountdropdownpage = page.getInstance(AccountDropDownMenuPage_RAP.class);
            loginPage = page.getInstance(CustomerLogin_Public.class);
            AllCustomerPage = page.getInstance(AllCustomerPage_PublicAdmin.class);
            billingAddressPage = page.getInstance(BillingAddressPage_Public.class);
            AccountCreationPage = page.getInstance(AccountCreationPage_PublicAdmin.class);
            OrderViewPage = page.getInstance(OrderInformationPage_PublicAdmin.class);
            jsonFileReader=new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            productsToAdd = Product_PublicAdmin.TestProducts.returnSKU_SubAgencyLevel_PUBLICATION_HARD_COPY();

            magentoLogin.login(jsonFileReader.getJsonString("CredentialsMap", "Magento", "StageUser"),
                    jsonFileReader.getJsonString("CredentialsMap", "Magento", "StagePassword"));
            Map<String, String> map = commonpage.AddClassificationChoosingCustomerType(jsonFileReader.getJsonString("SubscriptionAgencyAccounts", "SubscriptionAgencyAccounts", "B2B"),CustomerType,Account_PublicAdmin.Classification.SUBSCRIPTION_AGENCY_LEVEL_ONE.toString());

            OrderCreationUtil.addsProductBySKUCode(Product_PublicAdmin.TestProducts.PUBLICATION_HARD_COPY_PRODUCT.toString());
            String OrderTotalBookDealerDiscount = MembershipDiscountsCommon.verifySubtotalAndSubscriptionDiscountDetailsForTheProductsAddedInCart(ProductType, productsToAdd, Account_PublicAdmin.Classification.SUBSCRIPTION_AGENCY_LEVEL_ONE.toString(),CustomerType);
            CreateOrderPage.selectPaymentMethodForPayment("Invoice");
            String PTPLearnerSelected=CreateOrderPage.adminSelectsContactsForTPT(1);
            commonpage.FillPromoCode();
            CreateOrderPage.ClickOnSubmitOrderButton();
            commonpage.EbsOrderStatus();

            String BookDealerDiscountOrderViewScreen =  commonpage.BookDealerDiscountOrderViewScreen();
            Assert.assertEquals(OrderTotalBookDealerDiscount,BookDealerDiscountOrderViewScreen);

            String EBSOrderNumber_UI = OrderViewPage.getMagentoEBSOrderNumber();
            String MagentoOrderNumber_UI = OrderViewPage.getMagentoOrderNumber();
            String GrandTotalInclusiveTax_UI = commonpage.GrandTotalIncTaxAfterOrderSubmit().replace("$", "").replace(",", "").trim();
            String GrandTotalExclusiveTax_UI = commonpage.GrandTotalExcTaxAfterOrderSubmit().replace("$", "").replace(",", "").trim();
            String TotalTaxAfterOrderSubmit_UI = commonpage.TotalTaxAfterOrderSubmit().replace("$", "").replace(",", "").trim();
            String LineItemTotalTaxAfterSubmit_UI = commonpage.LineItemTotalTaxAfterOrderSubmit().replace("$", "").replace(",", "").trim();
            String LineItemExtendedPrice_UI = commonpage.returnLineItemSubTotal();
            String ShippingHandlingAfterOrderSubmit_UI = commonpage.ShippingHandlingAfterOrderSubmit().replace("$", "").replace(",", "").trim();

            String EBSAccountNumber_UI = map.get("EBSAccountNumber_UI");

            Map<String,String> UIValues = new HashMap<>();
            UIValues.put("EBSOrderNumber", EBSOrderNumber_UI);
            UIValues.put("MagentoOrderNumber", MagentoOrderNumber_UI);

            UIValues.put("GrandTotalInclusiveTax", GrandTotalInclusiveTax_UI);
            UIValues.put("GrandTotalExclusiveTax", GrandTotalExclusiveTax_UI);
            UIValues.put("TotalTax", TotalTaxAfterOrderSubmit_UI);
            UIValues.put("ShippingAndHandling", ShippingHandlingAfterOrderSubmit_UI);
            UIValues.put("EBSAccountNumber", EBSAccountNumber_UI);

            UIValues.put(("LineItemTotalTax"),LineItemTotalTaxAfterSubmit_UI);
            UIValues.put(("LineItemExtendedPrice"),LineItemExtendedPrice_UI);

            EBSAPIs.EBSOrderAPIValidation_Sub(environment, UIValues);

        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to validate that correct discount is applied on products eligible foe subscription agency discount || B2B", e);
        }
        System.out.println("Successfully Verified correct discount is applied on products eligible foe subscription agency discount || B2B");
    }

}
