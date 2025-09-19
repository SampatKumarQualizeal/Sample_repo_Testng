package testobjects;

import base.utils.RandomStringUtils;

public class Address_PublicAdmin {

    private String streetAddress;
    private String streetAddress2;
    private String streetAddress3;
    private String streetAddress4;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private String country;
    private String province;
    private String firstName;
    private String lastName;
    private String company;
    private String addressDescription;
    private String faxNumber;
    private String middleName;
    private String vatNumber;
    private String nameSuffix;
    private String ebsShippingSiteId;
    private String ebsShippingId;
    private String ebsShippingActive;
    private String ebsBillingSiteId;
    private String ebsBillingId;
    private String ebsBillingActive;
    private String ebsFreightForwardSiteId;
    private String ebsFreightForwardId;
    private String ebsFreightForwardActive;


    public Address_PublicAdmin(String streetAddress, String city, String zipCode, String phoneNumber, String country,
                               String province) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.province = province;
    }

    public Address_PublicAdmin(String firstName, String lastName, String streetAddress, String city, String zipCode,
                               String phoneNumber, String country, String province) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.province = province;
    }

    public Address_PublicAdmin(String firstName, String lastName, String streetAddress, String city, String zipCode,
                               String phoneNumber, String country, String province, String company, String addressDescription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.province = province;
        this.company = company;
        this.addressDescription = addressDescription;
    }

    public Address_PublicAdmin(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = "100 Main Street";
        this.city = "University Park";
        this.zipCode = "16802";
        this.phoneNumber = "610-555-0987";
        this.country = "United States";
        this.province = "Pennsylvania";
    }

    public Address_PublicAdmin(){

    }

    public String getEbsShippingActive() {
        return ebsShippingActive;
    }

    public void setEbsShippingActive(String ebsShippingActive) {
        this.ebsShippingActive = ebsShippingActive;
    }

    public String getEbsBillingActive() {
        return ebsBillingActive;
    }

    public void setEbsBillingActive(String ebsBillingActive) {
        this.ebsBillingActive = ebsBillingActive;
    }

    public String getEbsFreightForwardActive() {
        return ebsFreightForwardActive;
    }

    public void setEbsFreightForwardActive(String ebsFreightForwardActive) {
        this.ebsFreightForwardActive = ebsFreightForwardActive;
    }

    public String getEbsShippingId() {
        return ebsShippingId;
    }

    public void setEbsShippingId(String ebsShippingId) {
        this.ebsShippingId = ebsShippingId;
    }

    public String getEbsBillingSiteId() {
        return ebsBillingSiteId;
    }

    public void setEbsBillingSiteId(String ebsBillingSiteId) {
        this.ebsBillingSiteId = ebsBillingSiteId;
    }

    public String getEbsBillingId() {
        return ebsBillingId;
    }

    public void setEbsBillingId(String ebsBillingId) {
        this.ebsBillingId = ebsBillingId;
    }

    public String getEbsFreightForwardSiteId() {
        return ebsFreightForwardSiteId;
    }

    public void setEbsFreightForwardSiteId(String ebsFreightForwardSiteId) {
        this.ebsFreightForwardSiteId = ebsFreightForwardSiteId;
    }

    public String getEbsFreightForwardId() {
        return ebsFreightForwardId;
    }

    public void setEbsFreightForwardId(String ebsFreightForwardId) {
        this.ebsFreightForwardId = ebsFreightForwardId;
    }

    public String getEbsShippingSiteId() {
        return ebsShippingSiteId;
    }

    public void setEbsShippingSiteId(String ebsShippingSiteId) {
        this.ebsShippingSiteId = ebsShippingSiteId;
    }

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public String getStreetAddress3() {
        return streetAddress3;
    }

    public String getStreetAddress4() {
        return streetAddress4;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public void setStreetAddress3(String streetAddress3) {
        this.streetAddress3 = streetAddress3;
    }

    public void setStreetAddress4(String streetAddress4) {
        this.streetAddress4 = streetAddress4;
    }

    /**
     * @return the faxNumber
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * @param faxNumber the faxNumber to set
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the addressDescription
     */
    public String getAddressDescription() {
        return addressDescription;
    }

    /**
     * @param addressDescription the addressDescription to set
     */
    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
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
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
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
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method returns the address in format 'First Name, 100 Main Street,
     * University Park, Pennsylvania 16802, United States'
     *
     * @return
     */
    public String returnAddressInFormatForDropDownUnderOrderCreation() {
        if (this.middleName != null) {
            return this.firstName + " " + this.middleName + " " + this.lastName + ", " + this.streetAddress + ", " + this.city + ", "
                    + this.province + " " + this.getZipCode() + ", " + this.country;
        }
        if (this.province == null) {
            return this.firstName + " " + this.lastName + ", " + this.streetAddress + ", " + this.city + ", "
                    +this.getZipCode() + ", " + this.country;
        }
        else {
            return this.firstName + " " + this.lastName + ", " + this.streetAddress + ", " + this.city + ", "
                    + this.province + " " + this.getZipCode() + ", " + this.country;
        }
    }

    public String returnAddressInFormatForDropDownUnderOrderCreationForOrgAccount(String orgName) {
            return orgName+" -" + ", " + this.streetAddress + ", " + this.city + ", "
                    + this.province + " " + this.getZipCode() + ", " + this.country;
    }

    /*public String returnFullAddressInFormatForDropDownUnderOrderCreation() {
        return this.firstName + " " + this.middleName + " " + this.lastName + ", " + this.streetAddress + " "
                + this.streetAddress2 + " " + this.streetAddress3 + " " + this.streetAddress4 + ", " + this.city + ", "
                + this.province + " " + this.zipCode + ", " + this.country;
    }*/

    public String returnFullAddressInFormatForDropDownUnderOrderCreation() {
        return this.firstName + " " + this.lastName + ", " + this.streetAddress + " "
                + this.streetAddress2 + " " + this.streetAddress3 + " " + this.streetAddress4 + ", " + this.city + ", "
                + this.province + " " + this.zipCode + ", " + this.country;
    }

    public String returnFullAddressInFormatForDropDownUnderOrderCreationForOrgAccount(String orgName) {
    	/*if(this.middleName != null) {
    		return orgName+ " "+this.middleName+" -" + ", " + this.streetAddress + " "
                    + this.streetAddress2 + " " + this.streetAddress3 + " " + this.streetAddress4 + ", " + this.city + ", "
                    + this.province + " " + this.zipCode + ", " + this.country;
    	}*/
        return orgName+" -" + ", " + this.streetAddress + " "
                + this.streetAddress2 + " " + this.streetAddress3 + " " + this.streetAddress4 + ", " + this.city + ", "
                + this.province + " " + this.zipCode + ", " + this.country;
    }

    public String returnAddressInFormatForDropDownUnderOrderCreationForCorporateRelatioship() {
        if (this.middleName != null)
            return this.firstName + " " + this.middleName + " " + this.lastName + " - <" + returnAddressInFormatForDropDownUnderOrderCreation() + ">";
        else
            return this.firstName + " " + this.lastName + " - <" + returnAddressInFormatForDropDownUnderOrderCreation() + ">";
    }

    public String returnFullAddressInFormatForDropDownUnderOrderCreationForCorporateRelationship() {
        return this.firstName + " " + this.lastName + " - <"
                + returnFullAddressInFormatForDropDownUnderOrderCreation() + ">";
    }

    public String returnAddressInFormatForDropDownUnderOrderCreationForCorporateRelatioship(String orgName) {
        return orgName + " - <" + returnAddressInFormatForDropDownUnderOrderCreationForOrgAccount(orgName) + ">";
    }

    public String returnFullAddressInFormatForDropDownUnderOrderCreationForCorporateRelatioship(String orgName) {
        return orgName + " - <" + returnFullAddressInFormatForDropDownUnderOrderCreationForOrgAccount(orgName) + ">";
    }

    public static Address_PublicAdmin getAddressObjectWithRandomFaxNumber() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("", "");
        addressObject.setFaxNumber(RandomStringUtils.getRandomNumbers(8));
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleOneObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("100 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleTwoObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("102 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleThreeObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("103 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleFourObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("104 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleFiveObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("105 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleWithRandomStreetAddressObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin(RandomStringUtils.getRandomNumbers(3)+" Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleTwoFiveObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("1908 Cecil Street", "Chicago", "60601",
                "312-228-5169", "United States", "Illinois");
        return addressObject;
    }

    public static Address_PublicAdmin getAddressSampleFiveObject(String firstName, String lastName) {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("105 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        addressObject.setFirstName(firstName);
        addressObject.setLastName(lastName);
        return addressObject;
    }
    public static Address_PublicAdmin getNonUSAddressSampleFiveObject(String firstName, String lastName) {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("3298 MacLaren Street", "Ottawa", "K1P5M7",
                "613-944-0287", "Canada", "Ontario");
        addressObject.setFirstName(firstName);
        addressObject.setLastName(lastName);
        return addressObject;
    }

    public static Address_PublicAdmin getObjectWithCompleteTestData(String firstName,
                                                                    String lastName) {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("105 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        addressObject.setStreetAddress2("106 Main Street");
        addressObject.setStreetAddress3("107 Main Street");
        addressObject.setStreetAddress4("108 Main Street");
        addressObject.setCompany("AutoTestCompany" + RandomStringUtils.getRandomNumbers(5));
        addressObject.setFaxNumber(RandomStringUtils.getRandomNumbers(10));
        addressObject.setAddressDescription("AddressDescription " + RandomStringUtils.getRandomNumbers(10));
//        addressObject.setMiddleName("TestAutoMiddle" + RandomStringUtils.getRandomNumbers(5));
        addressObject.setVatNumber("VAT" + RandomStringUtils.getRandomNumbers(10));
        addressObject.setNameSuffix("Mr.");
        return addressObject;
    }

    public static Address_PublicAdmin getObjectWithCompleteTestDataSampleTwo(String firstName,
                                                                    String lastName) {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("200 Main Street", "University Park", "16802",
                "610-555-0987", "United States", "Pennsylvania");
        addressObject.setStreetAddress2("201 Main Street");
        addressObject.setStreetAddress3("202 Main Street");
        addressObject.setStreetAddress4("203 Main Street");
        addressObject.setCompany("AutoTestCompany" + RandomStringUtils.getRandomNumbers(5));
        addressObject.setFaxNumber(RandomStringUtils.getRandomNumbers(10));
        addressObject.setAddressDescription("AddressDescription " + RandomStringUtils.getRandomNumbers(10));
//        addressObject.setMiddleName("TestAutoMiddle" + RandomStringUtils.getRandomNumbers(5));
        addressObject.setVatNumber("VAT" + RandomStringUtils.getRandomNumbers(10));
        addressObject.setNameSuffix("Mr.");
        return addressObject;
    }

    public static Address_PublicAdmin getCanadaAddressSampleOneObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("95 Rochford St", "Charlottetown",
                "C1A 7N8", "7896541230", "Canada", "Prince Edward Island");
        return addressObject;
    }

    public static Address_PublicAdmin getCanadaAddressSampleOneObject(String firstName, String lastName) {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("95 Rochford St", "Charlottetown",
                "C1A 7N8", "7896541230", "Canada", "Prince Edward Island");
        addressObject.setFirstName(firstName);
        addressObject.setLastName(lastName);
        return addressObject;
    }

    public static Address_PublicAdmin getCanadaAddressSampleTwoObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("1445 Rue Du Grand Tronc", "Quebec",
                "G1N 4G1", "78541236901", "Canada", "Quebec");
        return addressObject;
    }

    public static Address_PublicAdmin getVictoriaAddressSampleOneObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("47-61a Toll Drive", "Altona North",
                "3025", "7896541230", "Australia", "Victoria");
        return addressObject;
    }

    public static Address_PublicAdmin getAustraliaNonStateAddressSampleOneObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("The UNSW Kensington NSW, School of Mining Engineering",
                "Sydney", "11111", "789651230", "Australia", null);
        return addressObject;
    }

    public static Address_PublicAdmin getUkNonStateAddressSampleOneObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("130 Iolaire Road",
                "NEW CROSS", "SY23 8PH", "789651230", "United Kingdom", null);
        return addressObject;
    }

    public static Address_PublicAdmin getIndiaNonStateAddressSampleOneObject() {
        Address_PublicAdmin addressObject = new Address_PublicAdmin("6 , Oriental Apts, Jevvan Bima Marg, Borivali",
                "Mumbai", "400103", "787893344", "India", null);
        return addressObject;
    }

    public String returnAddressInFormOnRelationshipPageUnderAddressColumn(){
        return this.streetAddress + " " + this.city + " "
                + this.province + " " + this.getZipCode();
    }

    public String returnAddressInFormOnDefaultAddressOnAddressListPage(){
        return this.streetAddress + " " + this.city + ", "+ this.province + ", "
                + this.getZipCode() + "\n" + this.country;
    }
}
