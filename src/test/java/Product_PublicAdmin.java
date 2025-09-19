package testobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product_PublicAdmin {

    public static enum AdjunctProducts {

        ADJD2477 {
            public String toString() {
                return "Adjunct to D2477 Test Method for Dielectric Breakdown Voltage and Dielectric Strength of Insulating Gases at Commercial Power Frequencies";
            }
        },
        ADJD4177 {
            public String toString(){
                return "Adjunct to D4177 Standard Practice for Automatic Sampling of Petroleum and Petroleum Products";
            }
        },
        ADJC704 {
            public String toString(){
                return "Adjunct to C704 Test Method for Abrasion Resistance of Refractory Materials at Room Temperature";
            }
        },
        ADJC0016 {
            public String toString(){
                return "Adjunct to C16 Test Method for Load Testing Refractory Brick at High Temperatures";
            }
        }
    }

    public static enum ProductType {
        STANDARD {
            public String toString() {
                return "Standard Product";
            }
        },
        TPT {
            public String toString() {
                return "TPT Product";
            }
        },
        PTP {
            public String toString() {
                return "PTP Product";
            }
        },
        COMPASS {
            public String toString() {
                return "Compass Product";
            }
        },
        MEMBERSHIP {
            public String toString() {
                return "Membership Product";
            }
        }
    }


    public static enum TestProductWithSkuAndEbsSku {

        COMPASS_PRODUCT_ONE("SUB-IES-ONLINE", "SUB-IES-ONLINE"),
        COMPASS_PRODUCT_TWO("SUB-STP1549-EB", "SUB-STP1549-EB");

        private List<String> productDetails;

        private TestProductWithSkuAndEbsSku(String... productDetails) {
            this.productDetails = Arrays.asList(productDetails);
        }

        public String getSku() {
            return this.productDetails.get(0);
        }

        public String getEbsSku() {
            return this.productDetails.get(1);
        }
    }

    public static enum TestProducts {

        //        		TPT_PRODUCT_ONE("ASTM-TPT-1054"),
        TPT_PRODUCT_ONE("ASTM-TPT-4541"),
        TPT_PRODUCT_ONE1("TPTBIO0123SAEC"),
        TPT_PRODUCT_ONE2("TPTSQR0222SAEC"),

        TPT_PRODUCT_TWO("ASTM-TPT-4496"),
        TPT_PRODUCT_THREE("ASTM-TPT-4697"),
        TPT_PRODUCT_FOUR("ASTM-TPT-4558"),
        TPT_PRODUCT_FIFTH("ASTM-TPT-4450"),
        TPT_PRODUCT_SIXTH("ASTM-TPT-690"),
        TPT_PRODUCT_SEVENTH("ASTM-TPT-1399"),
        TPT_PRODUCT_EIGHTH("ASTM-TPT-1398"),
        PTP_PRODUCT_ONE("PTPATF2024"),
        PTP_PRODUCT_TWO("PTPGO2021"),
        PTP_PRODUCT_THREE("PTPWX2021"),
        PTP_PRODUCT_FOUR("PTPFLAM2024"),
        COMPASS_PRODUCT_ONE("SUB-IES-ONLINE-WL"),
        COMPASS_PRODUCT_TWO("SUB-STP1549-EB"),
        COMPASS_PRODUCT_THREE("SUB-D8333"),
        THREE_PC_PRODUCT_ONE("SUB-API_RP_T-4"),
        THREE_PC_PRODUCT_TWO("SUB-CGA-ONLINE-WL"),
        STANDARD_PRODUCT_ONE("VX0301"),
        STANDARD_PRODUCT_TWO("S01CS20"),
        STANDARD_PRODUCT_THREE("S03CS21"),
        MEM_INDIVIDUAL_21("MEMINDIVIDUAL21"),
        MEM_INDIVIDUAL_23("MEMINDIVIDUAL23"),
        MEM_INDIVIDUAL_24("MEMINDIVIDUAL24"),
        MEM_INDIVIDUAL_25("MEMINDIVIDUAL25"),
        MEM_ORGANIZATIONAL_23("MEMORGANIZATIONAL23"),
        MEM_STUDENT_21("MEMSTUDENT21"),
        MEM_ORG_21("MEMORGANIZATIONAL21"),
        MEM_INDIVIDUAL_20("MEMINDIVIDUAL20"),
        MEM_STUDENT_20("MEMSTUDENT20"),
        MEM_ORG_20("MEMORGANIZATIONAL20"),
        MEM_INDIVIDUAL_22("MEMINDIVIDUAL22"),
        MEM_STUDENT_22("MEMSTUDENT22"),
        MEM_STUDENT_24("MEMSTUDENT24"),
        MEM_STUDENT_25("MEMSTUDENT25"),
        MEM_ORG_22("MEMORGANIZATIONAL22"),
        MEM_ORG_24("MEMORGANIZATIONAL24"),
        MEM_ORG_25("MEMORGANIZATIONAL25"),
        VM0101("VM0101"),
        API_DUMMY_PRODUCT("SUB-ANSI/API_RP_2N-WL"),
        MAIN_DUMMY_PRODUCT("SUB-E2402-PLUS"),
        CGA_DUMMY_PRODUCT("SUB-CGA-NG-WL"),
        DM_COMPASS_PRODUCT_ONE("SUB-E1472"),
        DM_COMPASS_PRODUCT_TWO("SUB-AASHTO_R84"),
        DM_COMPASS_PRODUCT_THREE("SUB-F0853"),
        DM_COMPASS_PRODUCT_FOUR("SUB-D8333"),
        DM_COMPASS_PRODUCT_FIVE("SUB-D8335"),
        SUB_PRODUCT_FOR_DELIVERY_PLATFORM_CODE("SUB-E2030-PLUS"),
        AENOR_SUB_PRODUCT("SUB-UNE-FOOD-ONLINE-WL"),
        DM_MEMBERSHIP_PRODUCT("MEMINDIVNEWUAE20"),
        SUB_PRODUCT_FOR_EBS_SKU("SUB-E1794"),//Updated for stage
        SUB_PRODUCT_WITH_INVALID_EBS_SKU("SUB-API_PUBL_4491"),//Updated for stage
        SUB_PRODUCT_WITHOUT_EBS_SKU("CCABFINST"),//Updated for stage
        ROYALTY_PRODUCT_ONE("EDDPORTAL"),
        SIMPLE_PRODUCT("CTRBFINST"), //CTRBFINST
        ADJUNCNT_PRODUCT("ADJD5379"), // ADJC0177-E-PDF
        ADJUNCNT_PRODUCT_ONE("ADJD2477-E-PDF"),
        COMPILATION_PRODUCT("TESTMETALCMP"), // TEXPLUS
        COMPILATION_PRODUCT_ONE("CONCRETE20"),
        SUB_COMPILATION_PRODUCT("SUB-UPDLBUILD90"), // SUB-UPDLBUILD90
        PUBLICATION_PAPER_PRODUCT("ASTM|SSMS20180036|en-US|PDF"), // ASTM|SSMS20180036|en-US|PDF
        PUBLICATION_CHILD_PRODUCT("TR1-EB-ONLINE"), // TR1-EB-ONLINE
        PUBLICATION_CHILD_PRODUCT_ONE("ACEM14V3N2"),
        STANDARD_CHILD_PRODUCT("A0003-01R19-RED-PDF"), // A0003-01R19-RED-PDF
        STANDARD_CHILD_PRODUCT2("A0001-00R05-PDF"),
        MISC_PRODUCT("STDSVC"),
        JOURNALS_PRODUCT_ONE("JAIBFIND"),
        SUB_JOURNALS_PRODUCT_ONE("SUB-ACEMINST"),
        SUB_JOURNALS_PRODUCT_TWO("SUB-SSMSINST"),
        SUB_JOURNALS_PRODUCT_THREE("SUB-MPCINST"),
        SUB_JOURNALS_PRODUCT_FOUR("SUB-DLGTJ"),
        SUB_JOURNALS_PRODUCT_FIVE("SUB-DLJAI"),
        SUB_JOURNALS_PRODUCT_SIX("SUB-DLJOFS"),
        SUB_JOURNALS_PRODUCT_SEVEN("SUB-DLJOTE"),
        NON_SUB_JOURNALS_PRODUCT_ONE("CCABFINST"),
        NON_SUB_JOURNALS_PRODUCT_TWO("CTRBFINST"),
        PTP_NEXT_YEAR_PRODUCT_ONE("PTPYT2022"),
        PTP_NEXT_YEAR_PRODUCT_TWO("PTPWX2022"),
        PTP_NEXT_YEAR_PRODUCT_THREE("PTPEAT2022"),
        PTP_NEXT_YEAR_PRODUCT_FOUR("PTPULSD2021"),
        PRINT_PHYSICAL_PRODUCT("F2152-07R18-PRINT"),
        BOS_PRODUCT_ONE("S010121"),
        SUB_TRAIN_PRODUCT_ONE("SUB-TRAIN-C1712"),
        SUB_TRAIN_PRODUCT_TWO("SUB-TRAIN-D4294RU-IP"),
        PDF_REDLINE_PRODUCT_ONE("D0086-20B-RED-PDF"),
        CAD_WAREHOUSE_PRODUCT_ONE("C1752-17-PRINT"),
        CAD_WAREHOUSE_PRODUCT_TWO("E1332-16"),
        PMD_WAREHOUSE_PRODUCT_ONE("ADJD0623"),
        POD_WAREHOUSE_PRODUCT_ONE("STP166"),
        POD_WAREHOUSE_PRODUCT_TWO("STP668"),
        ADS_WAREHOUSE_PRODUCT_ONE(""),// TODO add product for ADS
        AIH_WAREHOUSE_PRODUCT_ONE("C1752-11-PDF"),
        AST_WAREHOUSE_PRODUCT_ONE("SUB-API_RP_2MOP"),
        COMPASS_PRODUCT_ONE_EBS_SKU("SUB-IES-ONLINE"),
        COMPASS_PRODUCT_TWO_EBS_SKU("SUB-STP1549-EB"),
        CGA_COMPASS_PRODUCT_ONE("SUB-CGA-NG-WL"),
        API_COMPASS_PRODUCT_TWO("SUB-API_RP_17Q_DATA-WL"),
        API_COMPASS_PRODUCT_ONE("SUB-API_RP_17Q_DATA-WL"),
        API_COMPASS_PRODUCT_THREE("SUB-API-ONLINE_ES-WL"),
        API_COMPASS_PRODUCT_FOUR("SUB-API_TR_997-WL"),


        AWWA_COMPASS_PRODUCT_ONE("SUB-AWWA-TR_MEM-WL"),
        AWWA_COMPASS_PRODUCT_TWO("SUB-AWWA-TR_ALL-WL"),
        AWWA_COMPASS_PRODUCT_THREE("SUB-AWWA_M11-WL"),


        PMD_BIO_PRODUCT_ONE("S140520"),
        PMD_AIRCRAFT_PRODUCT_ONE("S150920"),
        AIH_PLASTICS_PRODUCT_ONE("D4674-02R10"),

        PUBLICATION_HARD_COPY_PRODUCT("MNL7-9TH"),
        STANDARD_PDF_ONE("F2172-02R11-PDF"),
        PUBLICATION_ONLINE_ONE("STP577-EB-ONLINE"),
        JOURNAL_PAPER_ONE("ASTM|MPC20200168|en-US|PDF"),
        JOURNAL_SUBSCRIPTION_ONE("DLJOTEIND"),
        E_LEARNING_SUBSCRIPTION_ONE("ASTM-TPT-4590"),
        RADIOGRAPHS_PRODUCT_ONE("RRE0192"),
        RADIOGRAPHS_PRODUCT_TWO("RRE2422"),
        PRINT_PRODUCT_ONE("C1750-17-PRINT"),
        ADJUNCNT_PRODUCT_TWO("ADJF0112"),
        ADJUNCNT_PRODUCT_THREE("ADJD4177-EA"),

        STANDARD_PRODUCT("S03CS25"),
        SHIPPABLE_PRODUCT("ADJA0255"),
        PREDATED_PRODUCT("MEMINDIVIDUAL23"),
        ADJUNCT_PRODUCT("ADJF0941"),
        ADJUNCT_PRODUCT_PDF("ADJD5489-E-PDF"),
        ADJUNCT_PRODUCT_PDF1("D5489-14-RED-PDF"),
        MONOGRAPHS_PRODUCT("MONO11"),
        STANDARD_HARD_COPY_PRODUCT("D8171-18-PRINT"),
        STANDARD_PRODUCT1("D0257-14R21E01-PRINT"),
        STP1("STP1287"),
        STP2("STP908"),
        STP3("STP195"),
        UOP("UOP829-20-PDF"),
        ASME("SUB-ASME-WELDING_BRAZING"),
        ASME1("SUB-ASME-WATER-RESOURCES-ENG"),
        ASME2("SUB-ASME-METRIC-SYSTEM"),
        ASME3("SUB-ASME-TESTING"),
        ASME4("SUB-ASME-SYMBOLS"),

        LABSERVICEPRODUCT("SUB-COMP_SOP_D02"),
        LABSERVICEPRODUCT1("SUB-COMP_TMA_D02"),
        AMCOEproduct("SUB-TRAIN-AMCOEDED-IP"),
        SUBrandomSKU("SUB-UNE_UNE-EN_13032-3"),
        AdjunctStandardBundle("ADJD225505C"),
        STP4("STP1320");

        private final String method;

        TestProducts(String methodName) {
            method = methodName;
        }

        public String toString() {
            return this.method;
        }


        public static List<String> returnSkuOfThreeNonRoyaltyProduct() {
            List<String> skus = new ArrayList<>();
            skus.add(PTP_PRODUCT_THREE.toString());
            skus.add(MEM_STUDENT_21.toString());
            skus.add(STANDARD_PRODUCT_ONE.toString());
            return skus;
        }

        public static List<String> returnSkusOfNonRoyaltyProduct() {
            List<String> skus = new ArrayList<>();
            skus.add(PTP_PRODUCT_THREE.toString());
            skus.add(MEM_STUDENT_21.toString());
            skus.add(COMPASS_PRODUCT_ONE.toString());
            skus.add(TPT_PRODUCT_ONE.toString());
            skus.add(STANDARD_PRODUCT_ONE.toString());
            return skus;
        }

        public static List<String> returnDiscountedProducts() {
            List<String> skus = new ArrayList<>();
            skus.add(ADJUNCT_PRODUCT.toString());
            return skus;
        }
        public static List<String> returnMultipleDiscountedProducts() {
            List<String> skus = new ArrayList<>();
            skus.add(PUBLICATION_CHILD_PRODUCT_ONE.toString());
            skus.add(STANDARD_CHILD_PRODUCT.toString());
            skus.add(SIMPLE_PRODUCT.toString());
            //skus.add(ADJUNCT_PRODUCT_PDF.toString());
            skus.add(COMPILATION_PRODUCT_ONE.toString());
            skus.add(SUB_COMPILATION_PRODUCT.toString());
            skus.add(PUBLICATION_PAPER_PRODUCT.toString());
            return skus;
        }

        public static List<String> returnDiscountedProductsForMembershipMin() {
            List<String> skus = new ArrayList<>();
            skus.add(STANDARD_PRODUCT.toString());
            skus.add(ADJUNCT_PRODUCT.toString());
            skus.add(MONOGRAPHS_PRODUCT.toString());
            return skus;
        }


        public static List<String> returnSKU() {
            List<String> skus = new ArrayList<>();
            skus.add(STANDARD_PRODUCT.toString());
            return skus;
        }

        public static List<String> returnSKU_SubAgencyLevel_PUBLICATION_HARD_COPY() {
            List<String> skus = new ArrayList<>();
            skus.add(PUBLICATION_HARD_COPY_PRODUCT.toString());
            return skus;
        }
        public static List<String> returnSKU_SubAgencyLevel2_PUBLICATION_HARD_COPY() {
            List<String> skus = new ArrayList<>();
            skus.add(PUBLICATION_HARD_COPY_PRODUCT.toString());
            return skus;
        }



        public static List<String> returnSKU_SubAgencyLevel_JOURNAL() {
            List<String> skus = new ArrayList<>();
            skus.add(JOURNAL_PAPER_ONE.toString());
            return skus;
        }


        public static List<String> returnSKU1() {
            List<String> skus = new ArrayList<>();
            skus.add(STANDARD_PRODUCT.toString());
            skus.add(ADJUNCT_PRODUCT.toString());
            return skus;
        }

        public static List<String> returnPrintSKU1() {
            List<String> skus = new ArrayList<>();
            skus.add(STANDARD_HARD_COPY_PRODUCT.toString());
            skus.add(STANDARD_PRODUCT1.toString());
            skus.add((STANDARD_PRODUCT.toString()));
            skus.add(STP1.toString());
            skus.add(STP2.toString());
            skus.add(STP3.toString());
            skus.add(STP4.toString());
            return skus;
        }

        public static List<String> returnPrintSKU2() {
            List<String> skus = new ArrayList<>();
            skus.add(STANDARD_HARD_COPY_PRODUCT.toString());
            skus.add(STANDARD_PRODUCT1.toString());
            skus.add(STP1.toString());
            skus.add(STP2.toString());
            skus.add((STP3.toString()));
            return skus;
        }

        public static List<String> returnPrintSKU3() {
            List<String> skus = new ArrayList<>();
            skus.add(STANDARD_HARD_COPY_PRODUCT.toString());
            skus.add(STP1.toString());
            skus.add(STP2.toString());
            skus.add((STP3.toString()));
            return skus;
        }

        public static List<String> returnPrintSKU4() {
            List<String> skus = new ArrayList<>();
            skus.add(STANDARD_HARD_COPY_PRODUCT.toString());
            skus.add(STANDARD_PRODUCT1.toString());
            skus.add(STP1.toString());
            skus.add(STP2.toString());
            skus.add(STP3.toString());
            skus.add(STP4.toString());
            return skus;
        }

        public static List<String> returnNonDiscountedMemAndMiscProducts() {
            List<String> skus = new ArrayList<>();
            skus.add(MEM_INDIVIDUAL_24.toString());
            skus.add(MISC_PRODUCT.toString());
            return skus;
        }

        public static List<String> returnNonDiscountedRoyaltyProducts() {
            List<String> skus = new ArrayList<>();
            skus.add(ROYALTY_PRODUCT_ONE.toString());
            return skus;
        }

        public static List<String> returnscountedPMDProducts() {
            List<String> skus = new ArrayList<>();
            skus.add(PMD_BIO_PRODUCT_ONE.toString());
            return skus;
        }

        public static List<String> returnSkuOfSubJournalProduct() {
            List<String> skus = new ArrayList<>();
            skus.add(SUB_JOURNALS_PRODUCT_ONE.toString());
            skus.add(SUB_JOURNALS_PRODUCT_TWO.toString());
            skus.add(SUB_JOURNALS_PRODUCT_THREE.toString());
            skus.add(SUB_JOURNALS_PRODUCT_FOUR.toString());
            skus.add(SUB_JOURNALS_PRODUCT_FIVE.toString());
            skus.add(SUB_JOURNALS_PRODUCT_SIX.toString());
            skus.add(SUB_JOURNALS_PRODUCT_SEVEN.toString());
            return skus;
        }

        public static List<String> returnRenewalAndCurrentYearPtpProducts() {
            List<String> skus = new ArrayList<>();
            skus.add(PTP_NEXT_YEAR_PRODUCT_ONE.toString());
            skus.add(PTP_NEXT_YEAR_PRODUCT_TWO.toString());
            skus.add(PTP_PRODUCT_ONE.toString());
            skus.add(PTP_PRODUCT_TWO.toString());
            return skus;
        }

    }


    private String productName;
    private String sku;
    private String productType;
    private String price;
    private String subTotal;
    private String rowSubTotal;
    private String startDate;
    private String publishDate;
    private String subscriptionType;
    private String quantity;
    private String totalPriceWithTax;
    private String tax;
    private String membershipDiscount;
    private String ebsSku;

    public Product_PublicAdmin(String productName, String sku) {
        this.productName = productName;
        this.sku = sku;
    }

    public Product_PublicAdmin(String sku) {
        this.sku = sku;
    }

    public Product_PublicAdmin() {

    }

    public String getEbsSku() {
        return ebsSku;
    }

    public void setEbsSku(String ebsSku) {
        this.ebsSku = ebsSku;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getMembershipDiscount() {
        return membershipDiscount;
    }

    public void setMembershipDiscount(String membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    public void setTotalPriceWithTax(String totalPriceWithTax) {
        this.totalPriceWithTax = totalPriceWithTax;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getRowSubTotal() {
        return rowSubTotal;
    }

    public void setRowSubTotal(String rowSubTotal) {
        this.rowSubTotal = rowSubTotal;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }


    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }


    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    public float getPriceOfProductWithTax() {
        String priceWithDollar = price.replace("$", "");
        float taxAmount = (float) (Float.parseFloat(priceWithDollar) * 0.06) * (Float.parseFloat(quantity));
        float fullPriceWithTax = Float.parseFloat(priceWithDollar) + taxAmount;
        return fullPriceWithTax;
    }

    public static List<Product_PublicAdmin> getCompassProduct() {
        List<Product_PublicAdmin> products = new ArrayList<>();
        Product_PublicAdmin product = new Product_PublicAdmin(TestProducts.COMPASS_PRODUCT_THREE.toString());
        product.setQuantity("1");
        products.add(product);
        return products;
    }

    public static List<Product_PublicAdmin> getTptProduct() {
        List<Product_PublicAdmin> products = new ArrayList<>();
        Product_PublicAdmin product = new Product_PublicAdmin(TestProducts.TPT_PRODUCT_TWO.toString());
        product.setQuantity("1");
        products.add(product);
        return products;
    }

    public static String[] discountedMembershipTypes() {
        String[] values = new String[]{"name: perpetual institution; code: 3", "name: organizational; code: 4",
                "name: member institution; code: 6", "name: participating; code: 7", "name: informational; code: 8",
                "name: exempt member; code: 9", "name: senior; code: 0", "name: life member; code: L", "name: perpetual industry; code: D",
                "name: representative; code: R", "name: cooperative agreement; code: C", "name: mou member; code: M"};
        return values;
    }

    public static String[] nonDiscountedMembershipTypes() {
        String[] values = new String[]{"name: honorary; code: 1", "name: affiliate; code: 5", "name: temporary; code: T", "name: iso; code: N",
                "name: new member; code: Q", "name: student member; code: B"};
        return values;
    }

    public static String[] discountedProductTypesForMembership() {
        String[] values = new String[]{"Simple Product", "Virtual Product", "Bundle Product", "Downloadable Product",
                "Gift Card", "Configurable Product", "Grouped Product", "Adjunct Product", "Compass Product",
                "Compilation Product", "Individual Subscriptions Product", "Journal Product Type",
                "Publication Paper Product", "Publication Child Product",
                "Standards Child Product", "Section Product", "3PC Child Product", "Volume Product"};
        return values;
    }

    public static String[] nonDiscountedProductTypesForMembership() {
        String[] values = new String[]{"PTP Product", "Membership Product", "TPT Product", "TPT Group Product",
                "Royalty Product", "Miscellaneous Product"};
        return values;
    }

    public static String[] discountedSubProductTypesForMembership() {
        String[] values = new String[]{"Compilation Product"};
        return values;
    }

    public static String[] nonDiscountedSubProductTypesForMembership() {
        String[] values = new String[]{"Simple Product", "Virtual Product", "Bundle Product", "Downloadable Product",
                "Gift Card", "Configurable Product", "Grouped Product", "Adjunct Product", "Compass Product",
                "PTP Product", "Individual Subscriptions Product", "Journal Product Type", "Membership Product", "Publication Paper Product",
                "Publication Child Product", "Section Product", "Standards Child Product",
                "3PC Child Product", "TPT Product",
                "TPT Group Product", "Volume Product", "Royalty Product", "Miscellaneous Product"};
        return values;
    }

    public static String[] returnTptProductSkuNameAndLocationName() {
        String[] values = new String[]{"ASTM-TPT-4540", "Galveston", "Aviation Fuels - An Overview"};
        return values;
    }

    public static String[] returnTptProductSkuNameAndVirtualEvent() {
        String[] values = new String[]{"ASTM-TPT-4541", "Virtual Event", "ASTM/ACES Performance Grading (PG) of Asphalt Binders - Tests Procedures"};
        return values;
    }

    public static String[] returnTptProductSkuNameAndWebinar() {
        String[] values = new String[]{"ASTM-TPT-4496", "Webinar", "Quality Management 101: ISO 17025 Webinar"};
        return values;
    }

    public static String[] returnTptProductSkuNameAndOnline() {
        String[] values = new String[]{"ASTM-TPT-4542", "Online", "ASTM/ACES Performance Grading (PG) of Asphalt Binders - Tests Procedures"};
        return values;
    }

    public static enum accountNoteTypes {

        Callback("Callback"),
        Closure("Closure"),
        Contract_clauses("Contract clauses"),
        Conversation("Conversation"),
        Enhancement_Request("Enhancement Request"),
        Enhancement_Request_Business_Justification("Enhancement Request Business Justification"),
        Enhancement_Request_Response("Enhancement Request Response"),
        Expired_not_Reviewed("Expired not Reviewed"),
        Expired_Reviewed("Expired Reviewed"),
        Fee_Update_Reason("Fee Update"),
        Meeting("Meeting"),
        Not_Reviewed("Not Reviewed"),
        Pushback_Reason("Pushback Reason"),
        Reviewed("Reviewed"),
        Route_Information("Route Information"),
        Service_Request_Attribute_Details("Service Request Attribute Details");
        private final String method;

        accountNoteTypes(String methodName) {
            method = methodName;
        }

        public String toString() {
            return this.method;
        }

    }


}
