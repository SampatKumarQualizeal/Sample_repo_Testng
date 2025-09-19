/**
 * 
 */
package testobjects;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author aditya.joshi
 *
 */
public class Order_PublicAdmin {

	public static enum PaymentTypes {

		INVOICE("Invoice"),
		CCTERMINAL("CC Terminal/Check");

		private final String method;

		PaymentTypes(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}
	public static enum CreditCard {

		CREDITCARDNO("4111 1111 1111 1111"),
		EXPIRYMONTH("12"),
		EXPIRYYEAR("25"),
		CVV("123");

		private final String method;

		CreditCard(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public static enum StateSuggestedPrefix {

		ALABAMA("AL"),
		ALASKA("AK"),
		ARIZONA("AZ"),
		ARKANSAS("AR"),
		CALIFORNIA("CA"),
		COLORADO("CO"),
		CONNECTICUT("CT"),
		DELAWARE("DE"),
		DISTRICT_OF_COLUMBIA("DC"),
		FLORIDA("FL"),
		GEORGIA("GA"),
		HAWAII("HI"),
		IDAHO("ID"),
		ILLINOIS("IL"),
		INDIANA("IN"),
		IOWA("IA"),
		KANSAS("KS"),
		KENTUCKY("KY"),
		LOUISIANA("LA"),
		MAINE("ME"),
		MARYLAND("MD"),
		MASSACHUSETTS("MA"),
		MICHIGAN("MI"),
		MINNESOTA("MN"),
		MISSISSIPPI("MS"),
		MISSOURI("MO"),
		MONTANA("MT"),
		NEBRASKA("NE"),
		NEVADA("NV"),
		NEW_HAMPSHIRE("NH"),
		NEW_JERSEY("NJ"),
		NEW_MEXICO("NM"),
		NEWYORK("NY"),
		NORTH_CAROLINA("NC"),
		NORTH_DAKOTA("ND"),
		OHIO("OH"),
		OKLAHOMA("OK"),
		OREGON("OR"),
		PENNSYLVANIA("PA"),
		RHODE_ISLAND("RI"),
		SOUTH_CAROLINA("SC"),
		SOUTH_DAKOTA("SD"),
		TENNESSEE("TN"),
		TEXAS("TX"),
		UTAH("UT"),
		VERMONT("VT"),
		VIRGINIA("VA"),
		WASHINGTON("WA"),
		WEST_VIRGINIA("WV"),
		WISCONSIN("WI"),
		WYOMINGA("WY");

		private final String method;

		StateSuggestedPrefix(String methodName) {
			method = methodName;
		}
		public String toString() {
			return this.method;
		}
	}

	public static enum CountrySuggestedPrefix {

		UNITEDSTATES("US");
		private final String method;

		CountrySuggestedPrefix(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}


	public static enum OrderTypes {

		REGULAR_ORDER("REGULAR ORDER"),
		TPT_PREPAID("TPTPREPAID"),
		TPT_ORDER("TPT ORDER"),
		Y_MICRONEXX_ORDER("Y-MICRONEXX ORDER"),
		BILL_ONLY_ORDER("BILL ONLY ORDER"),
		IN_HOUSE_ORDER("IN-HOUSE ORDER"),
		ASTM_CREDIT_RETURN("ASTM RMA-RECEIPT & CREDIT RETURN"),
		ASTM_ONLY_RETURN("ASTM RMA-CREDIT ONLY RETURN");

		private final String method;

		OrderTypes(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}

		public static List<String[]> getOrderTypeCombinationsForTestCases(){
			List<String[]> combos = new ArrayList<String[]>() {};
			combos.add(new String[]{"ISS REGULAR", "REGULAR ORDER"});
			combos.add(new String[]{"TPT PREPAID", "TPTPREPAID"});
			combos.add(new String[]{"TPT ORDER", "TPT ORDER"});
			combos.add(new String[]{"REGULAR", "Y-MICRONEXX ORDER"});
			combos.add(new String[]{"BILL ONLY", "BILL ONLY ORDER"});
			combos.add(new String[]{"IN-HOUSE", "IN-HOUSE ORDER"});
			combos.add(new String[]{"RMA-RECEIPT & CREDIT RETURN", "ASTM RMA-RECEIPT & CREDIT RETURN"});
			combos.add(new String[]{"RMA-CREDIT ONLY", "ASTM RMA-CREDIT ONLY RETURN"});
			return combos;
		}
	}

	public static enum ShippingMethod {

		STANDARD_SERVICE("Standard Service"),
		IMEX_INTL_OVERNIGHT_TRACABLE("IMEX - Intl Overnight Delivery (Traceable)"),
		UPS_INTL_STANDARD("UPS - Intl Standard"),
		USPS_Postal_Service_Standard("USPS-Postal-Service-Standard"),
		DHL_INTL_STANDARD("DHL - Intl Standard");

		private final String method;

		ShippingMethod(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}

		public static List<String> returnListOfShippingMethodAsPerExpectedUI(){
			String[] shippingMethodsInStory = { "FEDEX - Standard Ground",
					"Standard Service", "UPS - Standard Ground",
					"USPS-Postal-Service-Standard", "DHL - Intl Standard", "FEDEX - Intl Standard",
					"FEDEX - 2nd Day Delivery",
					"FEDEX - Overnight Delivery by 12:00 PM", "IMEX - Intl Overnight Delivery (Traceable)",
					"IMEX - Intl Standard Ground Service (Un-tracked)", "UPS - 2nd Day Delivery", "UPS - Intl Standard",
					"UPS - Overnight Delivery by 12:00 PM" };
			return new ArrayList<>(Arrays.asList(shippingMethodsInStory));
		}
	}

	public static enum ConsortiaFlag {

		YES("Yes"),
		NO("No");

		private final String method;

		ConsortiaFlag(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	private String orderType;
	private List<Product_PublicAdmin> products;
	private Address_PublicAdmin billingAddress;
	private Address_PublicAdmin shippingAddress;
	private Address_PublicAdmin deliverToAddress;
	private String subTotal;
	private String grandTotalWithTaxes;
	private String paymentType;
	private String shippingType;
	private String rowSubTotal;
	private String majorPromoCode;
	private String minorPromoCode;
	private String orderChannelCode;
	private String ebsOrderNumber;
	private String orderDate;
	private boolean sendEmail;
	private String magentoOrderId;

	public Order_PublicAdmin(String orderType, List<Product_PublicAdmin> products, Address_PublicAdmin billingAddress,
			Address_PublicAdmin shippingAddress, Address_PublicAdmin deliverToAddress) {
		this.orderType = orderType;
		this.products = products;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.deliverToAddress = deliverToAddress;
	}
	
	public Order_PublicAdmin() {

	}

	public String getMagentoOrderId() {
		return magentoOrderId;
	}

	public void setMagentoOrderId(String magentoOrderId) {
		this.magentoOrderId = magentoOrderId;
	}

	public boolean isSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(boolean sendEmail) {
		this.sendEmail = sendEmail;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getEbsOrderNumber() {
		return ebsOrderNumber;
	}

	public void setEbsOrderNumber(String ebsOrderNumber) {
		this.ebsOrderNumber = ebsOrderNumber;
	}

	public String getRowSubTotal() {
		return rowSubTotal;
	}

	public void setRowSubTotal(String rowSubTotal) {
		this.rowSubTotal = rowSubTotal;
	}

	public String getMajorPromoCode() {
		return majorPromoCode;
	}

	public void setMajorPromoCode(String majorPromoCode) {
		this.majorPromoCode = majorPromoCode;
	}

	public String getMinorPromoCode() {
		return minorPromoCode;
	}

	public void setMinorPromoCode(String minorPromoCode) {
		this.minorPromoCode = minorPromoCode;
	}

	public String getOrderChannelCode() {
		return orderChannelCode;
	}

	public void setOrderChannelCode(String orderChannelCode) {
		this.orderChannelCode = orderChannelCode;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the shippingType
	 */
	public String getShippingType() {
		return shippingType;
	}

	/**
	 * @param shippingType the shippingType to set
	 */
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @param grandTotalWithTaxes the grandTotalWithTaxes to set
	 */
	public void setGrandTotalWithTaxes(String grandTotalWithTaxes) {
		this.grandTotalWithTaxes = grandTotalWithTaxes;
	}

	/**
	 * @return the subTotal
	 */
	public String getSubTotal() {
		return subTotal;
	}

	/**
	 * @return the grandTotalWithTaxes
	 */
	public String getGrandTotalWithTaxes() {
		return grandTotalWithTaxes;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the products
	 */
	public List<Product_PublicAdmin> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product_PublicAdmin> products) {
		this.products = products;
	}

	/**
	 * @return the billingAddress
	 */
	public Address_PublicAdmin getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Address_PublicAdmin billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the shippingAddress
	 */
	public Address_PublicAdmin getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(Address_PublicAdmin shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the deliverToAddress
	 */
	public Address_PublicAdmin getDeliverToAddress() {
		return deliverToAddress;
	}

	/**
	 * @param deliverToAddress the deliverToAddress to set
	 */
	public void setDeliverToAddress(Address_PublicAdmin deliverToAddress) {
		this.deliverToAddress = deliverToAddress;
	}

	public static Order_PublicAdmin getOrderObjectForCompassOrder(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		compassOrder.setProducts(Product_PublicAdmin.getCompassProduct());
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(false);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForInvalidSubDeliveryPlatCodeCompassOrder(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.SUB_PRODUCT_FOR_DELIVERY_PLATFORM_CODE.toString());
		product.setQuantity("1");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(false);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForCompassOrderWithEmailNotificationEnabled(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		compassOrder.setProducts(Product_PublicAdmin.getCompassProduct());
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForProductWithEbsSku(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.SUB_PRODUCT_FOR_EBS_SKU.toString());
		product.setQuantity("1");
		product.setPrice("123");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForProductWithoutEbsSku(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.SUB_PRODUCT_WITHOUT_EBS_SKU.toString());
		product.setQuantity("1");
		product.setPrice("123");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForProductWithAndWithoutEbsSku(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.SUB_PRODUCT_FOR_EBS_SKU.toString());
		Product_PublicAdmin productTwo = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.SUB_PRODUCT_WITHOUT_EBS_SKU.toString());
		product.setQuantity("1");
		product.setPrice("123");
		productTwo.setQuantity("1");
		productTwo.setPrice("123");
		products.add(product);
		products.add(productTwo);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForProductWithInvalidEbsSku(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.SUB_PRODUCT_WITH_INVALID_EBS_SKU.toString());
		product.setQuantity("1");
		product.setPrice("123");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForMemIndWithFreeProduct(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.COMPASS_PRODUCT_ONE.toString());  //MEM_INDIVIDUAL_21
		product.setQuantity("1");
		Product_PublicAdmin productTwo = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.COMPASS_PRODUCT_TWO.toString());		//	VM0101
		productTwo.setQuantity("1");
		products.add(product);
		products.add(productTwo);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForMemInd(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.MEM_INDIVIDUAL_21.toString());
		product.setQuantity("1");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForNextYearMemIndWithFreeProduct(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.MEM_INDIVIDUAL_22.toString());
		product.setQuantity("1");
		Product_PublicAdmin productTwo = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.VM0101.toString());
		productTwo.setQuantity("1");
		products.add(product);
		products.add(productTwo);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForMemOrgWithFreeProduct(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.MEM_ORG_21.toString());
		product.setQuantity("1");
		Product_PublicAdmin productTwo = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.VM0101.toString());
		productTwo.setQuantity("1");
		products.add(product);
		products.add(productTwo);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForNextYearMemOrgWithFreeProduct(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.MEM_ORG_22.toString());
		product.setQuantity("1");
		Product_PublicAdmin productTwo = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.VM0101.toString());
		productTwo.setQuantity("1");
		products.add(product);
		products.add(productTwo);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForSubProductAndCustomOrderChannel(String orderChannelCode){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.COMPASS_PRODUCT_ONE.toString());
		product.setQuantity("1");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(orderChannelCode);
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForCgaEmailNotificationEnabled(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.CGA_COMPASS_PRODUCT_ONE.toString());
		product.setQuantity("1");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}

	public static Order_PublicAdmin getOrderObjectForApiEmailNotificationEnabled(){
		Order_PublicAdmin compassOrder = new Order_PublicAdmin();
		compassOrder.setOrderType(OrderTypes.REGULAR_ORDER.toString());
		List<Product_PublicAdmin> products = new ArrayList<>();
		Product_PublicAdmin product = new Product_PublicAdmin(Product_PublicAdmin.TestProducts.API_COMPASS_PRODUCT_TWO.toString());
		product.setQuantity("1");
		products.add(product);
		compassOrder.setProducts(products);
		compassOrder.setMajorPromoCode(PromoCodes_PublicAdmin.Major.WEB.toString());
		compassOrder.setMinorPromoCode(PromoCodes_PublicAdmin.Minor.UNDEFINED.toString());
		compassOrder.setOrderChannelCode(PromoCodes_PublicAdmin.OrderChannel.WEB.toString());
		compassOrder.setSendEmail(true);
		return compassOrder;
	}
}
