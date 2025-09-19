package pages.ui;

import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testobjects.Product_PublicAdmin;
import testobjects.prerequisitegenerator.CommonWebActions_PublicAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MembershipDiscountsCommon_PublicAdmin {
    private WebDriver driver;
    OrderInformationPage_PublicAdmin OrderViewPage;
    CreateNewOrderPage_PublicAdmin CreateOrderPage;
    CommonWebActions_PublicAdmin CommonActions;
    List<Map<String, String>> productsDetails = new ArrayList<>();
    HashMap<String, String> orderTotals;
    String membershipDiscount;
    String discountedRowSubtotal;
    String subTotalUnderItemOrderedTable;
    String grandTotalInclTax;
    String grandTotalExclTax;

    public MembershipDiscountsCommon_PublicAdmin(WebDriver driver, Page page) {
        this.driver = driver;
        OrderViewPage = page.getInstance(OrderInformationPage_PublicAdmin.class);
        CreateOrderPage = page.getInstance(CreateNewOrderPage_PublicAdmin.class);
        CommonActions = new CommonWebActions_PublicAdmin(driver, page);
    }

    @Step("[{testCaseId}] Verify price and tax of each line item")
    public void VerifyPriceAndTaxOfEachLineItem(String testCaseId) {
        try {
            String magentoOrderNumber = PublicAdminCommons.getTextOfElement(driver, OrderViewPage.getOrderNumber());
            Assert.assertNotEquals(magentoOrderNumber, "", "Unable to get magento order number for the order");
            CommonActions.addEbsValidationDetails("["+testCaseId+"] Verify price and tax of each line item " +
                    "on the EBS for order number :"+magentoOrderNumber);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("["+testCaseId+"] Unable to verify price and tax of each line item", e);
        }
    }
    @Step("[{testCaseId}] Verify subtotal and membership discount details for the products added in cart")
    public void verifySubtotalAndMembershipDiscountDetailsForTheProductsAddedInCart(String testCaseId, List<String> productsToAdd) {
        try {
            for(int i=0;i<productsToAdd.size();i++) {
                Map<String, String> prodHashMap = CreateOrderPage.getPriceMembershipDiscountRowTotalForProductByIndexUnderItemOrdered(
                        productsToAdd.indexOf(productsToAdd.get(i)));
                Assert.assertNotNull(prodHashMap, "Unable to get product details from item ordered table");
                productsDetails.add(prodHashMap);
            }

            Assert.assertEquals(productsDetails.size(), productsToAdd.size(),
                    "Unable to get details for products present under item ordered table");

            for (Map<String, String> prodHashMap : productsDetails) {
                System.out.println(prodHashMap.get("rowSubTotal"));
                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountedAmountForStringPriceWithFormat(prodHashMap.get("price"),prodHashMap.get("TaxAmount") ,10),
                        prodHashMap.get("rowSubTotal"), "[" + testCaseId + "] Verify row subtotal is the discounted price",
                        "[" + testCaseId + "] Row subtotal is not having the discounted price");
                System.out.println(prodHashMap.get("membershipDiscount"));
                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountAmountForStringPriceWithFormat(prodHashMap.get("price"), 10),
                        prodHashMap.get("membershipDiscount"), "[" + testCaseId + "] Verify membership discount amount of the product",
                        "[DON-1526] Membership discount amount is not correct for product");
            }
            membershipDiscount = returnTotalMembershipDiscount();

            CommonActions.assertEqualWithStep(membershipDiscount, CreateOrderPage.getDataFromColumnUnderFootOfItemOrderedTable("Member Discount"),
                    "[DON-1526] Verify Membership discount for all products is correct under item ordered table",
                    "[DON-1526] Membership discount for all products is incorrect under item ordered table");

           // discountedRowSubtotal = returnDiscountedRowTotal();
            grandTotalInclTax= returnDiscountedRowTotalInclTax();

            CommonActions.assertEqualWithStep(grandTotalInclTax, CreateOrderPage.getDataFromColumnUnderFootOfItemOrderedTable("Row Subtotal"),
                    "[DON-1526] Verify Row Subtotal for all products is correct under item ordered table",
                    "[DON-1526] Row Subtotal for all products is incorrect under item ordered table");

            subTotalUnderItemOrderedTable = CreateOrderPage.getDataFromColumnUnderFootOfItemOrderedTable("Subtotal");

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify subtotal and membership discount details " +
                    "for the products added in cart", e);
        }
    }

    @Step("Verify subtotal and membership discount details for the products added in cart")
    public String verifySubtotalAndMembershipDiscountDetailsForTheProductsAddedInCart(String ProductType, List<String> productsToAdd,String classification) {
        String OrderTotalBookDealerDiscount = null;
        try {
            PublicCommon.waitForSec(10);
            int discount = 0;
            for (String product : productsToAdd) {
                HashMap<String, String> prodHashMap = CreateOrderPage.getPriceBookDealerMembershipDiscountSubTotalForProductByIndexUnderItemOrdered(
                        productsToAdd.indexOf(product));
                Assert.assertNotNull(prodHashMap, "Unable to get product details from item ordered table");
                productsDetails.add(prodHashMap);
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertEquals(productsDetails.size(), productsToAdd.size(),
                    "Unable to get details for products present under item ordered table");

            for (Map<String, String> prodHashMap : productsDetails) {
                int Quantity = Integer.parseInt(prodHashMap.get("QuantityNo"));

                if(ProductType == "Print") {
                    discount = getBookDealerDiscount_Print(classification, Quantity);
                } else if (ProductType == "Non-Print") {
                    discount = getBookDealerDiscount_Non_Print(classification, Quantity);
                }
                if(prodHashMap.get("productSKU").contains("Adjunct"))
                {
                    discount =0;
                }
                ScreenshotUtil.takeScreenshotForAllure(driver);
                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountedAmountWithTaxAmount(prodHashMap.get("subTotal"), discount, prodHashMap.get("TaxAmount")), prodHashMap.get("RowSubtotal"),
                        "Verify row subtotal is the discounted price",
                        " Row subtotal is not having the discounted price");
            }
            double sumOfDiscounts = 0.0;
            for (Map<String, String> prodHashMap : productsDetails) {
                double BookDealerDiscInDouble = Double.parseDouble(prodHashMap.get("membershipDiscount"));
                sumOfDiscounts = sumOfDiscounts + BookDealerDiscInDouble;
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            String SumOfDiscountsInString = String.format("%.2f", sumOfDiscounts);

            OrderTotalBookDealerDiscount = CreateOrderPage.OrderTotalBookDealerDiscount();
            Assert.assertEquals(SumOfDiscountsInString, OrderTotalBookDealerDiscount);
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to verify subtotal and membership discount details " +
                    "for the products added in cart", e);
        }
        return OrderTotalBookDealerDiscount;
    }


    @Step("Verify subtotal and Subscription discount details for the products added in cart")
    public String verifySubtotalAndSubscriptionDiscountDetailsForTheProductsAddedInCart(String ProductType, List<String> productsToAdd,String classification,String CustomerType) {
        String OrderTotalSubscriptionDiscount = null;
        try {
            int discount = 0;
            for (String product : productsToAdd) {
                Map<String, String> prodHashMap = CreateOrderPage.getPriceSubscriptionAgencyMembershipDiscountSubTotalForProductByIndexUnderItemOrdered(
                        productsToAdd.indexOf(product));
                Assert.assertNotNull(prodHashMap, "Unable to get product details from item ordered table");
                productsDetails.add(prodHashMap);
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertEquals(productsDetails.size(), productsToAdd.size(),
                    "Unable to get details for products present under item ordered table");

            for (Map<String, String> prodHashMap : productsDetails) {
                 if(ProductType == ProductType && CustomerType == CustomerType && classification == classification){
                    discount = getSubscriptionAgencyDiscountPrint(ProductType,CustomerType,classification);
                }

                ScreenshotUtil.takeScreenshotForAllure(driver);
                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountedAmountWithTaxAmount(prodHashMap.get("subTotal"), discount, prodHashMap.get("TaxAmount")), prodHashMap.get("RowSubtotal"),
                        "Verify row subtotal is the discounted price",
                        " Row subtotal is not having the discounted price");
            }
            double sumOfDiscounts = 0.0;
            for (Map<String, String> prodHashMap : productsDetails) {
                double BookDealerDiscInDouble = Double.parseDouble(prodHashMap.get("membershipDiscount"));
                sumOfDiscounts = sumOfDiscounts + BookDealerDiscInDouble;
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            String SumOfDiscountsInString = String.format("%.2f", sumOfDiscounts);

            OrderTotalSubscriptionDiscount = CreateOrderPage.OrderTotalSubscriptionDiscount();
            Assert.assertEquals(SumOfDiscountsInString, OrderTotalSubscriptionDiscount);
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to verify subtotal and membership discount details " +
                    "for the products added in cart", e);
        }
        return OrderTotalSubscriptionDiscount;
    }

    @Step("Verify Subscription Agency Discount with product type")
    public int getSubscriptionAgencyDiscountPrint(String ProductType,String CustomerType,String classification) {
        int discount = 0;
        if (ProductType.equals("Delivery Method Code == PRINT") && CustomerType.equals("B2B") && classification.equals("SUBSCRIPTION AGENCY LEVEL 1")) {
                discount = 10;
            } else if (ProductType.equals("Journal Child") && CustomerType.equals("B2C") && classification.equals("SUBSCRIPTION AGENCY LEVEL 1")) {
            discount = 10;
        } else if (ProductType.equals("Delivery Method Code == PRINT") && CustomerType.equals("B2B") && classification.equals("SUBSCRIPTION AGENCY LEVEL 2")) {
            discount = 35;
        } else if (ProductType.equals("Journal Child") && CustomerType.equals("B2C") && classification.equals("SUBSCRIPTION AGENCY LEVEL 2")) {
            discount = 10;
        }
        return discount;
    }

    @Step("Verify Book Dealer Discount with product type as /PRINT/")

    public int getBookDealerDiscount_Print(String BookDealer, int Quantity){

    int discount = 0;
        if(BookDealer.equals("BOOK DEALER BASIC LEVEL")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 10;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 1")) {
            if (Quantity >= 1 && Quantity <= 9) {
                discount = 20;
            } else if (Quantity >= 10 && Quantity <= 24) {
                discount = 25;
            } else if (Quantity >= 25 && Quantity <= 49) {
                discount = 30;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 2")) {
            if (Quantity >= 1 && Quantity <= 49) {
                discount = 30;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 3")) {
            if (Quantity >= 1 && Quantity <= 49) {
                discount = 35;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 4")) {
            if (Quantity >= 1 && Quantity <= 49) {
                discount = 40;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 5")) {
            if (Quantity >= 1 && Quantity <= 49) {
                discount = 45;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 6")) {
            if (Quantity >= 1 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 7")) {
            if (Quantity >= 1 && Quantity <= 24) {
                discount = 25;
            } else if (Quantity >= 25 && Quantity <= 49) {
                discount = 30;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 8")) {
            if (Quantity >= 1 && Quantity <= 9) {
                discount = 12;
            } else if (Quantity >= 10 && Quantity <= 24) {
                discount = 25;
            } else if (Quantity >= 25 && Quantity <= 49) {
                discount = 30;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 9")) {
            if (Quantity >= 1 && Quantity <= 9) {
                discount = 15;
            } else if (Quantity >= 10 && Quantity <= 24) {
                discount = 25;
            } else if (Quantity >= 25 && Quantity <= 49) {
                discount = 30;
            } else if (Quantity >= 50 && Quantity <= 99) {
                discount = 50;
            } else if (Quantity >= 100 && Quantity <= 249) {
                discount = 60;
            } else if (Quantity >= 250 && Quantity <= 499) {
                discount = 70;
            } else if (Quantity >= 500 && Quantity <= 999) {
                discount = 80;
            }
        }
        return discount;
    }

    @Step("Verify Book Dealer Discount with product type as /PRINT/")
    public int getBookDealerDiscount_Non_Print(String BookDealer, int Quantity){
        int discount = 0;
        if(BookDealer.equals("BOOK DEALER BASIC LEVEL")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 10;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 1")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 20;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 2")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 30;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 3")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 35;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 4")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 40;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 5")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 45;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 6")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 50;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 7")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 25;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 8")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 12;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }

        if(BookDealer.equals("BOOK DEALER LEVEL 9")) {
            if (Quantity >= 1 && Quantity <= 10) {
                discount = 15;
            } else if (Quantity > 10 && Quantity <= 25) {
                discount = 25;
            } else if (Quantity > 25) {
                discount = 30;
            }
        }
        return discount;
    }


    @Step("Verify Quantity modification to verify Discount price")
    public void verifyQuantityModificationToVerifyDiscountPrice(String ProductType, List<String> productsToAdd,String BookDealer) {
        try {
            int discount = 0;
            for (String product : productsToAdd) {
                HashMap<String, String> prodHashMap1 = CreateOrderPage.getPriceBookDealerMembershipDiscountSubTotalForProductByIndexUnderItemOrdered(
                        productsToAdd.indexOf(product));
                Assert.assertNotNull(prodHashMap1, "Unable to get product details from item ordered table");
                productsDetails.add(prodHashMap1);
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertEquals(productsDetails.size(), productsToAdd.size(),
                    "Unable to get details for products present under item ordered table");

                for (Map<String, String> prodHashMap1 : productsDetails) {
                    int Quantity = Integer.parseInt(prodHashMap1.get("QuantityNo"));
                    if (ProductType == "Non-Print") {
                        discount = getBookDealerDiscount_Non_Print(BookDealer, Quantity);
                    } else if (ProductType == "Print") {
                        discount = getBookDealerDiscount_Print(BookDealer, Quantity);
                    }
                ScreenshotUtil.takeScreenshotForAllure(driver);
                    PublicAdminCommons.waitForSec(15);

                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountedAmountWithTaxAmount(prodHashMap1.get("subTotal"), discount, prodHashMap1.get("TaxAmount")), prodHashMap1.get("RowSubtotal"),
                        "Verify row subtotal is the discounted price",
                        " Row subtotal is not having the discounted price");
            }
            productsDetails.clear();
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to Verify Quantity modification to verify Discount price " +
                    "for the products added in cart", e);
        }
    }

    @Step("Add desired products and calculate Discount price")
    public String verifyMembershipDiscount(List<String> productsToAdd, int discount) {
        String OrderTotalMembershipDiscount = null;
        try {
            for (String product : productsToAdd) {
                Map<String, String> prodHashMap1 = CreateOrderPage.getPriceMembershipDiscountSubTotalForProductByIndexUnderItemOrdered(
                        productsToAdd.indexOf(product));
                Assert.assertNotNull(prodHashMap1, "Unable to get product details from item ordered table");
                productsDetails.add(prodHashMap1);
            }
            Assert.assertEquals(productsDetails.size(), productsToAdd.size(),
                    "Unable to get details for products present under item ordered table");

            for (Map<String, String> prodHashMap1 : productsDetails) {

                PublicAdminCommons.waitForSec(15);
                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountedAmountWithTaxAmount(prodHashMap1.get("subTotal"), discount, prodHashMap1.get("TaxAmount")), prodHashMap1.get("RowSubtotal"),
                        "Verify row subtotal is the discounted price",
                        " Row subtotal is not having the discounted price");
            }
            double sumOfDiscounts = 0.0;
            for (Map<String, String> prodHashMap : productsDetails) {
                double BookDealerDiscInDouble = Double.parseDouble(prodHashMap.get("membershipDiscount"));
                sumOfDiscounts = sumOfDiscounts + BookDealerDiscInDouble;
                ScreenshotUtil.takeScreenshotForAllure(driver);
            }
            String SumOfDiscountsInString = String.format("%.2f", sumOfDiscounts);

            OrderTotalMembershipDiscount = CreateOrderPage.OrderTotalMemberDiscount();
            Assert.assertEquals(SumOfDiscountsInString, OrderTotalMembershipDiscount);
            ScreenshotUtil.takeScreenshotForAllure(driver);

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to verify subtotal and membership discount details " +
                    "for the products added in cart", e);
        }
        return OrderTotalMembershipDiscount;
    }

    @Step("[{testCaseId}] Verify subtotal and membership discount details for the products added in cart")
    public void verifySubTotalAndDiscountPriceForNonDiscountedProducts(String testCaseId, List<String> productsToAdd) {
        try {
            for (String product : productsToAdd) {
                Map<String, String> prodHashMap = CreateOrderPage.getPriceMembershipDiscountRowTotalForProductByIndexUnderItemOrdered(
                        productsToAdd.indexOf(product));
                Assert.assertNotNull(prodHashMap, "Unable to get product details from item ordered table");
                productsDetails.add(prodHashMap);
            }

            Assert.assertEquals(productsDetails.size(), productsToAdd.size(),
                    "Unable to get details for products present under item ordered table");

            for (Map<String, String> prodHashMap : productsDetails) {
                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountedAmountForStringPriceWithFormat(prodHashMap.get("price"), 0),
                        prodHashMap.get("rowTotal"), "[" + testCaseId + "] Verify row subtotal is the discounted price",
                        "[" + testCaseId + "] Row subtotal is not having the discounted price");
                CommonActions.assertEqualWithStep(PublicAdminCommons.returnDiscountAmountForStringPriceWithFormat(prodHashMap.get("price"), 0),
                        prodHashMap.get("membershipDiscount"), "[" + testCaseId + "] Verify membership discount amount of the product",
                        "[DON-1526] Membership discount amount is not correct for product");
            }
            membershipDiscount = returnTotalMembershipDiscount(0);

            CommonActions.assertEqualWithStep(membershipDiscount, CreateOrderPage.getDataFromColumnUnderFootOfItemOrderedTable("Member Discount"),
                    "[DON-1526] Verify Membership discount for all products is correct under item ordered table",
                    "[DON-1526] Membership discount for all products is incorrect under item ordered table");

            discountedRowSubtotal = returnDiscountedRowTotal(0);

            CommonActions.assertEqualWithStep(discountedRowSubtotal, CreateOrderPage.getDataFromColumnUnderFootOfItemOrderedTable("Row Subtotal"),
                    "[DON-1526] Verify Row Subtotal for all products is correct under item ordered table",
                    "[DON-1526] Row Subtotal for all products is incorrect under item ordered table");

            subTotalUnderItemOrderedTable = CreateOrderPage.getDataFromColumnUnderFootOfItemOrderedTable("Subtotal");

        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify subtotal and membership discount details " +
                    "for the products added in cart", e);
        }
    }

    @Step("[{testCaseId}] Verify products details on order view screen")
    public void verifyProductsDetailsOnOrderViewScreen(String testCaseId, List<String> productsToAdd) {
        try {
            List<Product_PublicAdmin> products = OrderViewPage.getProductDetailsReplaceExtraChar();
            Assert.assertNotNull(products, "ISS Agent is unable to get product details on order view screen");
            for (Map<String, String> productMap : productsDetails) {
                CommonActions.assertEqualWithStep(products.get(productsDetails.indexOf(productMap)).getPrice(),
                        productMap.get("price"), "[DON-1526] Verify price of the ordered item is correct",
                        "[DON-1526] Price of the ordered item is incorrect");
                CommonActions.assertEqualWithStep(products.get(productsDetails.indexOf(productMap)).getMembershipDiscount(),
                        productMap.get("membershipDiscount"),
                        "[DON-1526] Verify membership discount amount of the product",
                        "[DON-1526] Membership discount amount is not correct for product");
                CommonActions.assertEqualWithStep(products.get(productsDetails.indexOf(productMap)).getSku().replace("SKU: ", ""),
                        productsToAdd.get(productsDetails.indexOf(productMap)),
                        "[DON-1526] Verify SKU of the product",
                        "[DON-1526] SKU is not correct for product");
                String subTotalLineItem = products.get(productsDetails.indexOf(productMap)).getRowSubTotal();
                String taxLineItem = products.get(productsDetails.indexOf(productMap)).getTax();
                String membershipDiscountLineItem = products.get(productsDetails.indexOf(productMap)).getMembershipDiscount();
                CommonActions.assertEqualWithStep(products.get(productsDetails.indexOf(productMap)).getTotalPriceWithTax(),
                        returnRowTotalForLineItemOnOrderViewScreen(subTotalLineItem,
                                taxLineItem, membershipDiscountLineItem),
                        "[DON-1526] Verify Row Subtotal of line item is calculated correctly",
                        "[DON-1526] Row Subtotal of line item is not calculated correctly");
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify products details on order view screen", e);
        }
    }

    @Step("[{testCaseId}] Verify order total details")
    public void verifyOrderTotalDetails(String testCaseId) {
        try {
            orderTotals = CreateOrderPage.getOrderTotalsHashMapWithNumberOnly();
            Assert.assertNotNull(orderTotals, "[" + testCaseId + "] Unable to get order total details");
            CommonActions.assertEqualWithStep(orderTotals.get("Member Discount"), membershipDiscount
                    , "[" + testCaseId + "] Verify Membership discount order totals is same as on item ordered table",
                    "[" + testCaseId + "] Membership discount order totals is different from item ordered table");
            grandTotalExclTax = returnGrandTotalExclTax();
            CommonActions.assertEqualWithStep(orderTotals.get("Grand Total Excl. Tax"), grandTotalExclTax,
                    "[" + testCaseId + "] Verify Grand total Excluding Tax under order totals is correctly calculated",
                    "[" + testCaseId + "] Grand total Excluding Tax under order totals is incorrect");
            grandTotalInclTax = returnGrandTotalInclTax();
            CommonActions.assertEqualWithStep(orderTotals.get("Grand Total Incl. Tax"), grandTotalInclTax,
                    "[" + testCaseId + "] Verify Grand total Including Tax under order totals is correctly calculated",
                    "[" + testCaseId + "] Grand total Including Tax under order totals is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify order total details", e);
        }
    }

    @Step("[{testCaseId}] Verify order total details")
    public void verifyOrderTotalDetailsWhereMembershipDiscountAreZero(String testCaseId) {
        try {
            orderTotals = CreateOrderPage.getOrderTotalsHashMapWithNumberOnly();
            Assert.assertNotNull(orderTotals, "[" + testCaseId + "] Unable to get order total details");
            grandTotalExclTax = returnGrandTotalExclTax();
            CommonActions.assertEqualWithStep(orderTotals.get("Grand Total Excl. Tax"), grandTotalExclTax,
                    "[" + testCaseId + "] Verify Grand total Excluding Tax under order totals is correctly calculated",
                    "[" + testCaseId + "] Grand total Excluding Tax under order totals is incorrect");
            grandTotalInclTax = returnGrandTotalInclTax();
            CommonActions.assertEqualWithStep(orderTotals.get("Grand Total Incl. Tax"), grandTotalInclTax,
                    "[" + testCaseId + "] Verify Grand total Including Tax under order totals is correctly calculated",
                    "[" + testCaseId + "] Grand total Including Tax under order totals is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify order total details", e);
        }
    }

    @Step("[{testCaseId}] Verify order total details")
    public void verifyOrderTotalDetailsWhereMembershipDiscountAreZeroAndTaxIsZero(String testCaseId) {
        try {
            orderTotals = CreateOrderPage.getOrderTotalsHashMapWithNumberOnly();
            Assert.assertNotNull(orderTotals, "[" + testCaseId + "] Unable to get order total details");
            grandTotalExclTax = returnGrandTotalExclTax();
            CommonActions.assertEqualWithStep(orderTotals.get("Grand Total Excl. Tax"), grandTotalExclTax,
                    "[" + testCaseId + "] Verify Grand total Excluding Tax under order totals is correctly calculated",
                    "[" + testCaseId + "] Grand total Excluding Tax under order totals is incorrect");
            grandTotalInclTax = returnGrandTotalInclTaxWithoutTax();
            CommonActions.assertEqualWithStep(orderTotals.get("Grand Total Incl. Tax"), grandTotalInclTax,
                    "[" + testCaseId + "] Verify Grand total Including Tax under order totals is correctly calculated",
                    "[" + testCaseId + "] Grand total Including Tax under order totals is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify order total details", e);
        }
    }

    @Step("[{testCaseId}] Verify order total details on order view screen")
    public void verifyOrderTotalDetailsOnOrderViewScreen(String testCaseId) {
        try {
            HashMap<String, String> orderTotalsOnOrderViewScreen = OrderViewPage.getOrderTotalsHashMapWithReplacedCharacters();
            Assert.assertNotNull(orderTotalsOnOrderViewScreen, "[" + testCaseId + "] Unable to get order total details");
            CommonActions.assertEqualWithStep(orderTotalsOnOrderViewScreen.get("Member Discount"), membershipDiscount
                    , "[" + testCaseId + "] Verify Membership discount under order totals on order view screen is same as " +
                            "Membership discount on order create screen",
                    "[" + testCaseId + "] Membership discount under order totals on order view screen is different " +
                            "from Membership discount on order create screen");
            CommonActions.assertEqualWithStep(orderTotalsOnOrderViewScreen.get("Grand Total (Excl.Tax)"), grandTotalExclTax,
                    "[" + testCaseId + "] Verify Grand total Excluding Tax under order totals on order view screen " +
                            "is correctly calculated",
                    "[" + testCaseId + "] Grand total Excluding Tax under order totals on order view screen " +
                            "is incorrect");
            CommonActions.assertEqualWithStep(orderTotalsOnOrderViewScreen.get("Grand Total (Incl.Tax)"), grandTotalInclTax,
                    "[" + testCaseId + "] Verify Grand total Including Tax under order totals on order view screen " +
                            "is correctly calculated",
                    "[" + testCaseId + "] Grand total Including Tax under order totals on order view screen " +
                            "is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify order total details on order view screen", e);
        }
    }

    @Step("[{testCaseId}] Verify order total details on order view screen")
    public void verifyOrderTotalDetailsWhereMembershipDiscountsAreZeroOnOrderViewScreen(String testCaseId) {
        try {
            HashMap<String, String> orderTotalsOnOrderViewScreen = OrderViewPage.getOrderTotalsHashMapWithReplacedCharacters();
            Assert.assertNotNull(orderTotalsOnOrderViewScreen, "[" + testCaseId + "] Unable to get order total details");
            CommonActions.assertEqualWithStep(orderTotalsOnOrderViewScreen.get("Grand Total (Excl.Tax)"), grandTotalExclTax,
                    "[" + testCaseId + "] Verify Grand total Excluding Tax under order totals on order view screen " +
                            "is correctly calculated",
                    "[" + testCaseId + "] Grand total Excluding Tax under order totals on order view screen " +
                            "is incorrect");
            CommonActions.assertEqualWithStep(orderTotalsOnOrderViewScreen.get("Grand Total (Incl.Tax)"), grandTotalInclTax,
                    "[" + testCaseId + "] Verify Grand total Including Tax under order totals on order view screen " +
                            "is correctly calculated",
                    "[" + testCaseId + "] Grand total Including Tax under order totals on order view screen " +
                            "is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify order total details on order view screen", e);
        }
    }

    @Step("[{testCaseId}] Verify order total details on order view screen")
    public void verifyOrderTotalDetailsWhereMembershipDiscountsAreZeroAndTaxZeroOnOrderViewScreen(String testCaseId) {
        try {
            HashMap<String, String> orderTotalsOnOrderViewScreen = OrderViewPage.getOrderTotalsHashMapWithReplacedCharacters();
            Assert.assertNotNull(orderTotalsOnOrderViewScreen, "[" + testCaseId + "] Unable to get order total details");
            HashMap<String, String> orderTotalsFootOnOrderViewScreen = OrderViewPage.getOrderTotalsFootHashMapWithReplacedCharacters();
            Assert.assertNotNull(orderTotalsFootOnOrderViewScreen, "[" + testCaseId + "] Unable to get order total details");
            CommonActions.assertEqualWithStep(orderTotalsFootOnOrderViewScreen.get("Grand Total"), grandTotalExclTax,
                    "[" + testCaseId + "] Verify Grand total under order totals on order view screen " +
                            "is correctly calculated",
                    "[" + testCaseId + "] Grand total under order totals on order view screen " +
                            "is incorrect");
            CommonActions.assertEqualWithStep(orderTotalsOnOrderViewScreen.get("Subtotal"), subTotalUnderItemOrderedTable,
                    "[" + testCaseId + "] Verify Subtotal under order totals on order view screen " +
                            "is correctly calculated",
                    "[" + testCaseId + "] Subtotal under order totals on order view screen " +
                            "is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("[" + testCaseId + "] Unable to verify order total details on order view screen", e);
        }
    }

    public String returnRowTotalForLineItemOnOrderViewScreen(String subTotal, String tax, String membershipDiscount) {
        double rowTotal = PublicAdminCommons.returnPriceInDoubleFormat(subTotal) +
                PublicAdminCommons.returnPriceInDoubleFormat(tax);
        return String.format("%.2f", rowTotal);
    }

    public String returnDiscountedValue(String subTotalDiscounted, String tax) {
        double rowTotal = PublicAdminCommons.returnPriceInDoubleFormat(subTotalDiscounted) +
                PublicAdminCommons.returnPriceInDoubleFormat(tax);
        return String.format("%.2f", rowTotal);
    }

    public String returnTotalMembershipDiscount() {
        double membershipDiscount = 0;
        for (Map<String, String> prodHashMap : productsDetails) {
            double price = PublicAdminCommons.returnPriceInDoubleFormat(
                    PublicAdminCommons.returnDiscountAmountForStringPriceWithFormat(prodHashMap.get("price"), 10));
            membershipDiscount = membershipDiscount + price;
        }
        return String.format("%.2f", membershipDiscount);
    }

    public String returnTotalMembershipDiscount(int discountPerc) {
        double membershipDiscount = 0;
        for (Map<String, String> prodHashMap : productsDetails) {
            double price = PublicAdminCommons.returnPriceInDoubleFormat(
                    PublicAdminCommons.returnDiscountAmountForStringPriceWithFormat(prodHashMap.get("price"), discountPerc));
            membershipDiscount = membershipDiscount + price;
        }
        return String.format("%.2f", membershipDiscount);
    }

    public String returnDiscountedRowTotal() {
        double discountedRowTotal = 0;
        for (Map<String, String> prodHashMap : productsDetails) {
            double price = PublicAdminCommons.returnPriceInDoubleFormat(
                    PublicAdminCommons.returnDiscountedAmountForStringPriceWithFormat(prodHashMap.get("price"), 10));
            discountedRowTotal = discountedRowTotal + price;
        }
        return String.format("%.2f", discountedRowTotal);
    }
    public String returnDiscountedRowTotalInclTax() {
        double discountedRowTotal = 0;
        for (Map<String, String> prodHashMap : productsDetails) {
            double subTotal = PublicAdminCommons.returnPriceInDoubleFormat(
                    PublicAdminCommons.returnDiscountedAmountForStringPriceWithFormat(prodHashMap.get("subtotal"), 0));
            double tax = PublicAdminCommons.returnPriceInDoubleFormat(
                    PublicAdminCommons.returnDiscountedAmountForStringPriceWithFormat(prodHashMap.get("TaxAmount"), 0));
            double discount = PublicAdminCommons.returnPriceInDoubleFormat(
                    PublicAdminCommons.returnDiscountedAmountForStringPriceWithFormat(prodHashMap.get("membershipDiscount"), 0));

            discountedRowTotal = discountedRowTotal + (subTotal-discount+tax);
        }
        return String.format("%.2f", discountedRowTotal);
    }

    public String returnDiscountedRowTotal(int discountPerc) {
        double discountedRowTotal = 0;
        for (Map<String, String> prodHashMap : productsDetails) {
            double price = PublicAdminCommons.returnPriceInDoubleFormat(
                    PublicAdminCommons.returnDiscountedAmountForStringPriceWithFormat(prodHashMap.get("price"), discountPerc));
            discountedRowTotal = discountedRowTotal + price;
        }
        return String.format("%.2f", discountedRowTotal);
    }

    public String returnGrandTotalExclTax() {
        double grandTotalExclTax = 0;
        grandTotalExclTax = PublicAdminCommons.returnPriceInDoubleFormat(subTotalUnderItemOrderedTable) -
                PublicAdminCommons.returnPriceInDoubleFormat(membershipDiscount) +
                PublicAdminCommons.returnPriceInDoubleFormat(orderTotals.get("Shipping & Handling (Shipping Table Rates - Standard Service)"));
        return String.format("%.2f", grandTotalExclTax);
    }

    public String returnGrandTotalInclTax() {
        double grandTotalIncTax = 0;
        grandTotalIncTax = PublicAdminCommons.returnPriceInDoubleFormat(subTotalUnderItemOrderedTable) -
                PublicAdminCommons.returnPriceInDoubleFormat(membershipDiscount) +
                PublicAdminCommons.returnPriceInDoubleFormat(orderTotals.get("Shipping & Handling (Shipping Table Rates - Standard Service)")) +
                PublicAdminCommons.returnPriceInDoubleFormat(orderTotals.get("Tax"));
        return String.format("%.2f", grandTotalIncTax);
    }

    public String returnGrandTotalInclTaxWithoutTax() {
        double grandTotalIncTax = 0;
        grandTotalIncTax = PublicAdminCommons.returnPriceInDoubleFormat(subTotalUnderItemOrderedTable) -
                PublicAdminCommons.returnPriceInDoubleFormat(membershipDiscount) +
                PublicAdminCommons.returnPriceInDoubleFormat(orderTotals.get("Shipping & Handling (Shipping Table Rates - Standard Service)"));
        return String.format("%.2f", grandTotalIncTax);
    }

}
