/**
 * 
 */
package testobjects;

import base.utils.RandomStringUtils;
import com.astm.commonFunctions.PublicAdminCommons;

import java.util.List;

/**
 * @author aditya.joshi
 *
 */
public class Account_PublicAdmin {

	public static enum Classification {

		SUBSCRIPTION_AGENCY("SUBSCRIPTION AGENCY"),
		SUBSCRIPTION_AGENCY_LEVEL_TWO("SUBSCRIPTION AGENCY LEVEL 2"),
		SUBSCRIPTION_AGENCY_LEVEL_ONE("SUBSCRIPTION AGENCY LEVEL 1"),
		BOOK_DEALER_BASIC_LEVEL("BOOK DEALER BASIC LEVEL"),
		BOOK_DEALER_LEVEL_ONE("BOOK DEALER LEVEL 1"),
		BOOK_DEALER_LEVEL_TWO("BOOK DEALER LEVEL 2"),
		BOOK_DEALER_LEVEL_THREE("BOOK DEALER LEVEL 3"),
		BOOK_DEALER_LEVEL_FOUR("BOOK DEALER LEVEL 4"),
		BOOK_DEALER_LEVEL_FIVE("BOOK DEALER LEVEL 5"),
		BOOK_DEALER_LEVEL_SIX("BOOK DEALER LEVEL 6"),
		BOOK_DEALER_LEVEL_SEVEN("BOOK DEALER LEVEL 7"),
		BOOK_DEALER_LEVEL_EIGHT("BOOK DEALER LEVEL 8"),
		BOOK_DEALER_LEVEL_NINE("BOOK DEALER LEVEL 9"),

		MEMBER_BOOK_DEALER_BASIC_LEVEL("MEMBER - BOOK DEALER BASIC"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_ONE("MEMBER - BOOK DEALER BASIC 1"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_TWO("MEMBER - BOOK DEALER BASIC 2"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_THREE("MEMBER - BOOK DEALER BASIC 3"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_FOUR("MEMBER - BOOK DEALER BASIC 4"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_FIVE("MEMBER - BOOK DEALER BASIC 5"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_SIX("MEMBER - BOOK DEALER BASIC 6"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_SEVEN("MEMBER - BOOK DEALER BASIC 7"),
		MEMBER_BOOK_DEALER_BASIC_LEVEL_EIGHT("MEMBER - BOOK DEALER BASIC 8"),
		MEMBER_BOOK_DEALER_LEVEL_NINE("MEMBER - BOOK DEALER LEVEL 9"),
		NON_MEMBER("NON-MEMBER");


		private final String method;

		Classification(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public static enum Website {

		MAIN_WEBSITE("Main Website"),
		API("API"),
		CGA("CGA"),
		AWWA("AWWA"),
		AENOR("AENOR"),
		IES("IES");
		private final String method;

		Website(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}


	public static enum StoreView {

		DEFAULT_STORE_VIEW("Default Store View"),
		API_STORE_VIEW("API Store View"),
		CGA_STORE_VIEW("CGA Store View"),
		AWWA_STORE_VIEW("AWWA Store View"),
		AENOR_STORE_VIEW("AENOR Store View"),
		IES_STORE_VIEW("IES Store View");;

		private final String method;

		StoreView(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public static enum ShippingMethods {


		FEDEX_2ndDay_Delivery("FEDEX - 2nd Day Delivery");

		private final String method;

		ShippingMethods(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public static enum ReferralCodes {

		ACD("ACD - ACADEMY OF FORENSIC SCIENCE"),
		AWW("AWW - AWWA THIRD-PARTY ACCOUNT"),
		UNE("UNE - AENOR THIRD-PARTY ACCOUNT"),
		IES("IES - IES THIRD-PARTY ACCOUNT"),
		API("API - API THIRD-PARTY ACCOUNT"),
		CCR("CCR - CREDIT CARD REJECTIONS");

		private final String method;

		ReferralCodes(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}

		public String getCode(){
			String code = this.method.split(" - ")[0];
			return code;
		}
	}

	public static enum PaymentTerm {

		NET_30_DAYS("Net 30 Days"),
		PREPAID("Prepaid"),
		NET_DUE_IN_30_DAYS("Net Due in 30 Days"),
		TERM_FOR_CHARGEBACK_OR_DEBIT_MEMO("Term for Chargeback or Debit memo"),
		INDEFINITE_TERMS("Indefinite Terms"),
		NET_60_DAYS("Net 60 Days"),
		NET_90_DAYS("Net 90 Days"),
		NET_120_DAYS("Net 120 Days"),
		WEBSITE("Website Payment (must not be used by any person)");

		private final String method;

		PaymentTerm(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public static enum ProfileClass {

		REGULAR_CUSTOMER("REGULAR CUSTOMERS - REGULAR CUSTOMERS (this is the seeded Default)"),
		Z_OBSOLETE("z-obsolete - DO NOT USE - old REGULAR CUSTOMERS"),
		MOU_COA("MOU/COA - MEMORANDA OF UNDERSTANDING / COOPERATIVE AGREEMENTS"),
		CCRL_CUSTOMER("CCRL - CCRL Customer");

		private final String method;

		ProfileClass(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public static enum AccountRoles {

		ADMIN("Administrator"),
		MANAGER("Manager"),
		AGENT("Agent");

		private final String method;

		AccountRoles(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public static enum ClassificationType {

		MEMBER("MEMBER"),
		NON_MEMBER("NON-MEMBER"),
		ORGANIZATIONAL_MEMBER("ORGANIZATIONAL MEMBER");

		private final String method;

		ClassificationType(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	public enum AccountType {

		PERSON("Person"),
		ORGANIZATION("Organization");

		private final String method;

		AccountType(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}
	private String customerType;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Address_PublicAdmin address;
	private List<Object> contacts;
	private String organizationName;
	private String referralCode;
	private String website;
	private String welcomeMailFromWebSite;
	private String ebsAccountNumber;
	private String arInvoiceType;
	private String maeAccountId;
	private String maeUserId;
	private String maeAccountUserId;
	private String oktaUUID;
	private Address_PublicAdmin additionalAddress;
	private boolean creditHold;
	private String specialHandling;
	private String middleName;
	private String communicationEmail;
	

	public Account_PublicAdmin(String customerType, String firstName, String lastName, String email, String phoneNumber,
			Address_PublicAdmin address) {
		this.customerType = customerType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Account_PublicAdmin(String customerType, String email) {
		this.customerType = customerType;
		this.email = email;
	}

	public Account_PublicAdmin(String customerType) {
		this.customerType = customerType;
		if (customerType.equals("Person")) {
			this.firstName = "TestAuto" + RandomStringUtils.getRandomString(4);
			this.lastName = "TestAuto" + RandomStringUtils.getRandomString(4);
			this.email = "stgintautob2c" + PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"@yopmail.com";
		}
		else {
			this.organizationName = "TestAutoOrg" + RandomStringUtils.getRandomString(4);
			this.communicationEmail = "stgintautob2b" +PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"@yopmail.com";
		}
		this.phoneNumber = RandomStringUtils.getRandomNumbers(10);
		this.address = new Address_PublicAdmin(firstName, lastName);
	}

	public Account_PublicAdmin(String customerType, Address_PublicAdmin address_object) {
		this.customerType = customerType;
		if (customerType.equals("Person")) {
			this.firstName = "TestAuto" + RandomStringUtils.getRandomString(4);
			this.lastName = "TestAuto" + RandomStringUtils.getRandomString(4);
			this.email = "stgintautob2b" +PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"@yopmail.com";
		}
		else {
			this.organizationName = "TestAutoOrg" + RandomStringUtils.getRandomString(4);
			this.communicationEmail = "stgintautob2b" +PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"@yopmail.com";
		}
		this.phoneNumber = RandomStringUtils.getRandomNumbers(10);
		this.address = address_object;
	}
	
	public Account_PublicAdmin() {
		
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSpecialHandling() {
		return specialHandling;
	}

	public void setSpecialHandling(String specialHandling) {
		this.specialHandling = specialHandling;
	}

	public boolean isCreditHold() {
		return creditHold;
	}

	public void setCreditHold(boolean creditHold) {
		this.creditHold = creditHold;
	}

	public Address_PublicAdmin getAdditionalAddress() {
		return additionalAddress;
	}

	public void setAdditionalAddress(Address_PublicAdmin additionalAddress) {
		this.additionalAddress = additionalAddress;
	}

	/**
	 * @return oktaUUID
	 */
	public String getOktaUUID() {
		return oktaUUID;
	}

	/**
	 * Set oktaUUID
	 * @param oktaUUID
	 */
	public void setOktaUUID(String oktaUUID) {
		this.oktaUUID = oktaUUID;
	}

	/**
	 * @return maeAccountId
	 */
	public String getMaeAccountId() {
		return maeAccountId;
	}

	/**
	 * Set maeAccountId
	 * @param maeAccountId
	 */
	public void setMaeAccountId(String maeAccountId) {
		this.maeAccountId = maeAccountId;
	}

	/**
	 * @return maeUserId
	 */
	public String getMaeUserId() {
		return maeUserId;
	}

	/**
	 * Set maeUserId
	 * @param maeUserId
	 */
	public void setMaeUserId(String maeUserId) {
		this.maeUserId = maeUserId;
	}

	/**
	 * @return maeAccountUserId
	 */
	public String getMaeAccountUserId() {
		return maeAccountUserId;
	}

	/**
	 * Set maeAccountUserId
	 * @param maeAccountUserId
	 */
	public void setMaeAccountUserId(String maeAccountUserId) {
		this.maeAccountUserId = maeAccountUserId;
	}

	/**
	 * @return arInvoiceType
	 */
	public String getArInvoiceType() {
		return arInvoiceType;
	}

	/**
	 * @param arInvoiceType the arInvoiceType to set
	 */
	public void setArInvoiceType(String arInvoiceType) {
		this.arInvoiceType = arInvoiceType;
	}

	/**
	 * @return ebsAccountNumber
	 */
	public String getEbsAccountNumber() {
		return ebsAccountNumber;
	}

	/**
	 *
	 * @param ebsAccountNumber
	 */
	public void setEbsAccountNumber(String ebsAccountNumber) {
		this.ebsAccountNumber = ebsAccountNumber;
	}

	/**
	 * @return the welcomeMailFromWebSite
	 */
	public String getWelcomeMailFromWebSite() {
		return welcomeMailFromWebSite;
	}

	/**
	 * @param welcomeMailFromWebSite the welcomeMailFromWebSite to set
	 */
	public void setWelcomeMailFromWebSite(String welcomeMailFromWebSite) {
		this.welcomeMailFromWebSite = welcomeMailFromWebSite;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the referralCode
	 */
	public String getReferralCode() {
		return referralCode;
	}

	/**
	 * @param referralCode the referralCode to set
	 */
	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the contacts
	 */
	public List<Object> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<Object> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the address
	 */
	public Address_PublicAdmin getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address_PublicAdmin address) {
		this.address = address;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/*
	 * Returns the first and last name
	 * 
	 */
	public String getFirstAndLastName() {
		return this.firstName + " " + this.lastName;
	}

	/*
	 * Returns the first middle last name
	 *
	 */
	public String getFirstMiddleLastName() {
		return this.firstName + " " + this.middleName+ " " + this.lastName;
	}

	public String getCommunicationEmail() {
		return communicationEmail;
	}

	public void setCommunicationEmail(String communicationEmail) {
		this.communicationEmail = communicationEmail;
	}

	public static Account_PublicAdmin getAccountObjectForAPIAccount(String customerType) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setReferralCode("API - API THIRD-PARTY ACCOUNT");
		account.setWebsite("API");
		account.setWelcomeMailFromWebSite("API Store View");
		return account;
	}
	
	public static Account_PublicAdmin getAccountObjectForValidYopmailEmail(String customerType) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Organization")) {
			account.setCommunicationEmail("stgintautob2b" +PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"@yopmail.com");
		}else{
			account.setEmail("stgintautob2c" +PublicAdminCommons.getCurrentDateWithFormat("MMddyyyyHHmm") +"@yopmail.com");
		}
		return account;
	}

	public static Account_PublicAdmin getAccountObjectWithCompleteAddress(String customerType){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setAddress(Address_PublicAdmin.getObjectWithCompleteTestData(account.getFirstName(), account.getLastName()));
		return account;
	}

	public static Account_PublicAdmin getAccountObjectWithArInvoiceType(String customerType){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setArInvoiceType("BOM");
		account.setAddress(Address_PublicAdmin.getObjectWithCompleteTestData(account.getFirstName(), account.getLastName()));
		return account;
	}

	public static Account_PublicAdmin createOrgAccount(String orgName, String email, String streetAddress1,
													   String city, String country, String state, String zipCode,
													   String phoneNumber){
		Account_PublicAdmin orgAccount = new Account_PublicAdmin();
		orgAccount.setCustomerType("Organization");
		orgAccount.setOrganizationName(orgName);
		orgAccount.setEmail(email);
		orgAccount.setCommunicationEmail(email);
		orgAccount.setPhoneNumber(RandomStringUtils.getRandomNumbers(10));
		Address_PublicAdmin address = new Address_PublicAdmin();
		address.setStreetAddress(streetAddress1);
		address.setCity(city);
		address.setCountry(country);
		address.setProvince(state);
		address.setZipCode(zipCode);
		address.setPhoneNumber(phoneNumber);
		orgAccount.setAddress(address);
		return orgAccount;
	}

	public static Account_PublicAdmin createPersonAccount(String firstName, String lastName, String email, String streetAddress1,
													   String streetAddress2,
													   String city, String country, String state, String zipCode,
													   String phoneNumber){
		Account_PublicAdmin personAccount = new Account_PublicAdmin();
		personAccount.setCustomerType("Person");
		personAccount.setFirstName(firstName);
		personAccount.setLastName(lastName);
		personAccount.setEmail(email);
		personAccount.setPhoneNumber(RandomStringUtils.getRandomNumbers(10));
		Address_PublicAdmin address = new Address_PublicAdmin();
		address.setStreetAddress(streetAddress1);
		address.setStreetAddress2(streetAddress2);
		address.setCity(city);
		address.setCountry(country);
		address.setProvince(state);
		address.setZipCode(zipCode);
		address.setPhoneNumber(phoneNumber);
		personAccount.setAddress(address);
		return personAccount;
	}

	public static Account_PublicAdmin getAccountObjectWithReferralCode(String customerType, String referralCode){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setReferralCode(referralCode);
		account.setAddress(Address_PublicAdmin.getObjectWithCompleteTestData(account.getFirstName(), account.getLastName()));
		return account;
	}
	public static Account_PublicAdmin getAccountObjectWithReferralCode_PTP(String customerType, String referralCode){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setReferralCode(referralCode);
		account.setAddress(Address_PublicAdmin.getAddressSampleFiveObject(account.getFirstName(), account.getLastName()));
		return account;
	}

	public static Account_PublicAdmin getAccountObjectWithReferralCode_PTPandForeignAddress(String customerType, String referralCode){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setReferralCode(referralCode);
		account.setAddress(Address_PublicAdmin.getNonUSAddressSampleFiveObject(account.getFirstName(), account.getLastName()));
		return account;
	}

	public static Account_PublicAdmin getAccountObjectWithReferralCodeRequiredOnly(String customerType, String referralCode){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setReferralCode(referralCode);
		return account;
	}

	public static Account_PublicAdmin getAccountObjectWithTwoAddresswithReferralCode_PTP(String customerType,String referralCode ){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Person")) {
			account.setAddress(Address_PublicAdmin.getAddressSampleTwoFiveObject());
			account.setAdditionalAddress(Address_PublicAdmin.getAddressSampleFiveObject(account.getFirstName(), account.getLastName()));
			account.setReferralCode(referralCode);
		}else{
			account.setAddress(Address_PublicAdmin.getAddressSampleTwoFiveObject());
			account.setAdditionalAddress(Address_PublicAdmin.getAddressSampleFiveObject("-", "-"));
			account.setReferralCode(referralCode);
		}
		return account;
	}

	public static Account_PublicAdmin getAccountObjectWithTwoAddresswithNonUsAddressandReferralCode_PTP(String customerType,String referralCode ){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Person")) {
			account.setAddress(Address_PublicAdmin.getAddressSampleTwoFiveObject());
			account.setAdditionalAddress(Address_PublicAdmin.getNonUSAddressSampleFiveObject(account.getFirstName(), account.getLastName()));
			account.setReferralCode(referralCode);
		}else{
			account.setAddress(Address_PublicAdmin.getAddressSampleTwoFiveObject());
			account.setAdditionalAddress(Address_PublicAdmin.getNonUSAddressSampleFiveObject("-", "-"));
			account.setReferralCode(referralCode);
		}
		return account;
	}

	public static Account_PublicAdmin getAccountObjectWithTwoAddressWithMailinatorEmail(String customerType){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Person")) {
			account.setEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
			account.setAddress(Address_PublicAdmin.getCanadaAddressSampleOneObject(account.getFirstName(), account.getLastName()));
			account.setAdditionalAddress(Address_PublicAdmin.getAddressSampleFiveObject(account.getFirstName(), account.getLastName()));
		}else{
			account.setCommunicationEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
			account.setAddress(Address_PublicAdmin.getCanadaAddressSampleOneObject("-", "-"));
			account.setAdditionalAddress(Address_PublicAdmin.getAddressSampleFiveObject("-", "-"));
		}
		return account;
	}

	public static Account_PublicAdmin getAccountObjectForValidMailinatorEmail(String customerType) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Organization")) {
			account.setCommunicationEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}else{
			account.setEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}
		return account;
	}

	public static Account_PublicAdmin getAccountObjectForValidEmail(String customerType,String email) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Organization")) {
			account.setCommunicationEmail(email);
		}else{
			account.setEmail(email);
		}
		return account;
	}

	public static Account_PublicAdmin getAccountObjectForValidMailinatorEmailwithOrgName(String customerType) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Organization")) {
			account.setCommunicationEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
			account.organizationName = "TestAutoOrg" + RandomStringUtils.getRandomString(4);
		}else{
			account.setEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}
		return account;
	}
	public static Account_PublicAdmin getAccountObjectForValidMailinatorEmailForAwwaStore(String customerType) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Organization")) {
			account.setCommunicationEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}else{
			account.setEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}
		account.setWebsite(Website.AWWA.toString());
		account.setWelcomeMailFromWebSite(StoreView.AWWA_STORE_VIEW.toString());
		account.setReferralCode(ReferralCodes.AWW.toString());
		return account;
	}

	public static Account_PublicAdmin getAccountObjectForValidMailinatorEmailForAenorStore(String customerType) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Organization")) {
			account.setCommunicationEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}else{
			account.setEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}
		account.setWebsite(Website.AENOR.toString());
		account.setWelcomeMailFromWebSite(StoreView.AENOR_STORE_VIEW.toString());
		account.setReferralCode(ReferralCodes.UNE.toString());
		return account;
	}

	public static Account_PublicAdmin getAccountObjectForValidMailinatorEmailForIesStore(String customerType) {
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		if(customerType.equals("Organization")) {
			account.setCommunicationEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}else{
			account.setEmail(RandomStringUtils.getRandomString(10) + "@mailinator.com");
		}
		account.setWebsite(Website.IES.toString());
		account.setWelcomeMailFromWebSite(StoreView.IES_STORE_VIEW.toString());
		account.setReferralCode(ReferralCodes.IES.toString());
		return account;
	}

	public static Account_PublicAdmin getAccountObjectForAccountWithTenantAsApiRefCodeAsApiAndBomInvoice(String customerType){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setWebsite(Website.API.toString());
		account.setReferralCode(ReferralCodes.API.toString());
		account.setArInvoiceType("BOM");
		return account;
	}

	public static Account_PublicAdmin getAccountObjectForAccountWithWebsite(String customerType, String website){
		Account_PublicAdmin account = new Account_PublicAdmin(customerType);
		account.setWebsite(website);
		return account;
	}
}
