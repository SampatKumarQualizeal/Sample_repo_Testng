package pages.ui;

import com.astm.commonFunctions.PublicAdminCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testobjects.Address_PublicAdmin;

public class AddUpdateAddressPage_PublicAdmin extends BasePage {

    public AddUpdateAddressPage_PublicAdmin(WebDriver driver) {
        super(driver);
    }

    private By firstNamField = By.xpath("(//input[@name='firstname'])[2]");
    private By lastNameField = By.xpath("(//input[@name='lastname'])[2]");
    private By defaultBilingAddressCheckbox = By.cssSelector("input[name='default_billing'] + label");
    private By defaultShippingAddressCheckbox = By.cssSelector("input[name='default_shipping'] + label");
    private By defaultFreightForwardCheckbox = By.cssSelector("input[name='default_freight_forward'] + label");
    private By streetAddressTextField = By.cssSelector("input[name='street[0]']");
    private By cityTextField = By.xpath("(//input[@name='city'])[2]");
    private By countryDropDown = By.xpath("(//select[@name='country_id'])[2]");
    private By zipCodeTextField = By.xpath("(//input[@name='postcode'])[2]");
    private By phoneNumberTextField = By.xpath("(//input[@name='telephone'])[3]");
    private By saveButton = By.cssSelector("aside[class*='address_customer_address_update_modal'] #save");
    private By provinceDropDown = By.xpath("(//select[@name='region_id'])[1]");
    private By closeButton = By.cssSelector(".customer_form_areas_address_address_customer_address_update_modal button.action-close");
    private By ebsShippingId = By.cssSelector("input[name='ebs_shipping_id']");
    private By ebsBillingId = By.cssSelector("input[name='ebs_billing_id']");
    private By ebsDelieveringId = By.cssSelector("input[name='ebs_deliver_id']");
    private By companyName = By.cssSelector("input[name='company']");
    private By addressDescription = By.cssSelector("textarea[name='address_description']");
    private By faxTextField = By.cssSelector("input[name='fax']");
    private By nameSuffixTextField = By.cssSelector("input[name='customer[suffix]']");
    private By middleNameTextField = By.cssSelector("input[name='middlename']");
    private By streetAddressSecondTextField = By.cssSelector("input[name='street[1]']");
    private By streetAddressThirdTextField = By.cssSelector("input[name='street[2]']");
    private By streetAddressFourthTextField = By.cssSelector("input[name='street[3]']");
    private By vatNumberTextField = By.cssSelector("input[name='vat_id']");
    private By ebsShippingSiteId = By.cssSelector("input[name='ebs_shipping_site_id']");
    private By ebsBillingSiteId = By.cssSelector("input[name='ebs_billing_site_id']");
    private By ebsDeliverSiteId = By.cssSelector("input[name='ebs_delivery_site_id']");
    private By ebsShippingActiveToggleInputTag = By.cssSelector("input[name='ebs_shipping_active']");
    private By ebsBillingActiveToggleInputTag = By.cssSelector("input[name='ebs_billing_active']");
    private By ebsDeliverActiveToggleInputTag = By.cssSelector("input[name='ebs_delivery_active']");
    private By activeToggleButton = By.cssSelector("input[name='is_active'] + label");
    private By activeToggleInputTag = By.cssSelector("input[name='is_active']");
    private By defaultBillingAddressToggleInputTag = By.cssSelector("input[name='default_billing']");
    private By defaultShippingAddressToggleInputTag = By.cssSelector("input[name='default_shipping']");
    private By defaultFreightForwardToggleInputTag = By.cssSelector("input[name='default_freight_forward']");
    private By ebsShippingActiveToggleButton = By.cssSelector("input[name='ebs_shipping_active'] + label");
    private By ebsBillingActiveToggleButton = By.cssSelector("input[name='ebs_billing_active'] + label");
    private By ebsDeliverActiveToggleButton = By.cssSelector("input[name='ebs_delivery_active'] + label");
    private By errorMessage = By.cssSelector(".customer_form_areas_address_address_customer_address_update_modal_update_customer_address_form_loader div.message-error");
    private By stateDivForRequiredTest = By.cssSelector("div[data-index='region_id']");
    private By requiredErrorMessageForStateField = By.cssSelector("select[name='region_id'] + label.admin__field-error");

    /**
    * @return requiredErrorMessageForStateField
    */
    public By getRequiredErrorMessageForStateField(){
        return requiredErrorMessageForStateField;
    }

    /**
     * @return stateDivForRequiredTest
     */
    public By getStateDivForRequiredTest() {
        return stateDivForRequiredTest;
    }


    /**
     * @return errorMessage
     */
    public By getErrorMessage() {
        return errorMessage;
    }

    /**
     * @return ebsDeliverActiveToggleButton
     */
    public By getEbsDeliverActiveToggleButton() {
        return ebsDeliverActiveToggleButton;
    }

    /**
     * @return ebsBillingActiveToggleButton
     */
    public By getEbsBillingActiveToggleButton() {
        return ebsBillingActiveToggleButton;
    }

    /**
     * @return ebsShippingActiveToggleButton
     */
    public By getEbsShippingActiveToggleButton() {
        return ebsShippingActiveToggleButton;
    }

    /**
     * @return defaultFreightForwardToggleInputTag
     */
    public By getDefaultFreightForwardToggleInputTag() {
        return defaultFreightForwardToggleInputTag;
    }

    /**
     * @return defaultShippingAddressToggleInputTag
     */
    public By getDefaultShippingAddressToggleInputTag() {
        return defaultShippingAddressToggleInputTag;
    }

    /**
     * @return defaultBillingAddressToggleInputTag
     */
    public By getDefaultBillingAddressToggleInputTag() {
        return defaultBillingAddressToggleInputTag;
    }

    /**
     * @return activeToggleInputTag
     */
    public By getActiveToggleInputTag() {
        return activeToggleInputTag;
    }

    /**
     * @return activeToggleButton
     */
    public By getActiveToggleButton() {
        return activeToggleButton;
    }

    /**
     * @return ebsDeliverActiveToggleInputTag
     */
    public By getEbsDeliverActiveToggleInputTag() {
        return ebsDeliverActiveToggleInputTag;
    }

    /**
     * @return ebsBillingActiveToggleInputTag
     */
    public By getEbsBillingActiveToggleInputTag() {
        return ebsBillingActiveToggleInputTag;
    }

    /**
     * @return ebsShippingActiveInputTag
     */
    public By getEbsShippingActiveToggleInputTag() {
        return ebsShippingActiveToggleInputTag;
    }

    /**
     * @return ebsDeliverSiteId
     */
    public By getEbsDeliverSiteId() {
        return ebsDeliverSiteId;
    }

    /**
     * @return ebsBillingSiteId
     */
    public By getEbsBillingSiteId() {
        return ebsBillingSiteId;
    }

    /**
     * @return ebsShippingSiteId
     */
    public By getEbsShippingSiteId() {
        return ebsShippingSiteId;
    }

    public By getStreetAddressSecondTextField() {
        return streetAddressSecondTextField;
    }

    public By getStreetAddressThirdTextField() {
        return streetAddressThirdTextField;
    }

    public By getStreetAddressFourthTextField() {
        return streetAddressFourthTextField;
    }

    /**
     * @return vatNumberTextField
     */
    public By getVatNumberTextField() {
        return vatNumberTextField;
    }

    /**
     * @return middleNameTextField
     */
    public By getMiddleNameTextField() {
        return middleNameTextField;
    }

    /**
     * @return nameSuffixTextField
     */
    public By getNameSuffixTextField() {
        return nameSuffixTextField;
    }

    /**
     * @return the faxTextField
     */
    public By getFaxTextField() {
        return faxTextField;
    }

    /**
     * @return the companyName
     */
    public By getCompanyName() {
        return companyName;
    }

    /**
     * @return the addressDescription
     */
    public By getAddressDescription() {
        return addressDescription;
    }

    /**
     * @return the ebsShippingId
     */
    public By getEbsShippingId() {
        return ebsShippingId;
    }

    /**
     * @return the ebsBillingId
     */
    public By getEbsBillingId() {
        return ebsBillingId;
    }

    /**
     * @return the ebsDelieveringId
     */
    public By getEbsDelieveringId() {
        return ebsDelieveringId;
    }

    /**
     * @return the closeButton
     */
    public By getCloseButton() {
        return closeButton;
    }

    /**
     * @return the firstNamField
     */
    public By getFirstNamField() {
        return firstNamField;
    }

    /**
     * @return the lastNameField
     */
    public By getLastNameField() {
        return lastNameField;
    }

    /**
     * @return the defaultBilingAddressCheckbox
     */
    public By getDefaultBilingAddressCheckbox() {
        return defaultBilingAddressCheckbox;
    }

    /**
     * @return the defaultShippingAddressCheckbox
     */
    public By getDefaultShippingAddressCheckbox() {
        return defaultShippingAddressCheckbox;
    }

    /**
     * @return the defaultFreightForwardCheckbox
     */
    public By getDefaultFreightForwardCheckbox() {
        return defaultFreightForwardCheckbox;
    }

    /**
     * @return the streetAddressTextField
     */
    public By getStreetAddressTextField() {
        return streetAddressTextField;
    }

    /**
     * @return the cityTextField
     */
    public By getCityTextField() {
        return cityTextField;
    }

    /**
     * @return the countryDropDown
     */
    public By getCountryDropDown() {
        return countryDropDown;
    }

    /**
     * @return the zipCodeTextField
     */
    public By getZipCodeTextField() {
        return zipCodeTextField;
    }

    /**
     * @return the phoneNumberTextField
     */
    public By getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    /**
     * @return the saveButton
     */
    public By getSaveButton() {
        return saveButton;
    }

    /**
     * @return the provinceDropDown
     */
    public By getProvinceDropDown() {
        return provinceDropDown;
    }

    /**
     * Enters text on first name field
     *
     * @param value
     * @return
     */
    public boolean enterTextInFirstNamField(String value) {
        try {
            WebElement element = getElementNew(firstNamField);
            element.clear();
            element.sendKeys(value);
            return true;
        } catch (Exception e) {
            log.info("Element", e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enters text on last name field
     *
     * @param value
     * @return
     */
    public boolean enterTextInLastNameField(String value) {
        try {
            WebElement element = getElementNew(lastNameField);
            element.clear();
            element.sendKeys(value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on 'Default Billing address' checkbox
     *
     * @return
     */
    public boolean clickDefaultBilingAddressCheckbox() {
        try {
            getElementNew(defaultBilingAddressCheckbox).click();
            return true;
        } catch (Exception e) {
            log.info("Element", e);
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on 'Default Shipping address' checkbox
     *
     * @return
     */
    public boolean clickDefaultShippingAddressCheckbox() {
        try {
            getElementNew(defaultShippingAddressCheckbox).click();
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on 'Default Freight Forward address' checkbox
     *
     * @return
     */
    public boolean clickDefaultFreightForwardCheckbox() {
        try {
            getElementNew(defaultFreightForwardCheckbox).click();
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enter text in street address text field
     *
     * @param value
     * @return
     */
    public boolean enterTextInStreetAddressTextField(String value) {
        try {
            getElementNew(streetAddressTextField).sendKeys(value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enters text in city text field
     *
     * @param value
     * @return
     */
    public boolean enterTextInCityTextField(String value) {
        try {
            getElementNew(cityTextField).sendKeys(value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enters text in city text field
     *
     * @param value
     * @return
     */
    public boolean selectOptionInCountryDropDown(String value) {
        try {
            PublicAdminCommons.selectValueInDropdown(getElement(countryDropDown), value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enters text in zip code text field
     *
     * @param value
     * @return
     */
    public boolean enterTextInZipCodeTextField(String value) {
        try {
            getElementNew(zipCodeTextField).sendKeys(value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Enters text in phone number text field
     *
     * @param value
     * @return
     */
    public boolean enterTextInPhoneNumberTextField(String value) {
        try {
            getElementNew(phoneNumberTextField).sendKeys(value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Clicks on save button
     *
     * @return
     */
    public boolean clickSaveButton() {
        try {
            getElementNew(saveButton).click();
            PublicAdminCommons.waitForElementToDisappear(driver, getElementWithoutWait(saveButton));
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * Selects option from province/state drop down
     *
     * @param value
     * @return
     */
    public boolean selectOptionInProvinceDropDown(String value) {
        try {
            PublicAdminCommons.selectValueInDropdown(getElement(provinceDropDown), value);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public boolean checkIfAddressIsPopulatedOnUpdateAddressPage(Address_PublicAdmin addressObject) {
        try {
			/*getElementNew(firstNamField).getAttribute("value").contains(addressObject.getFirstName());
			getElementNew(lastNameField).getAttribute("value").contains(addressObject.getLastName());*/
            // Removed/Commented because first/last name field removed from add/edit address page
            if (!getElementNew(streetAddressTextField).getAttribute("value").contains(addressObject.getStreetAddress()))
                return false;
            if (!getElementNew(cityTextField).getAttribute("value").contains(addressObject.getCity()))
                return false;
            if (!getElementNew(zipCodeTextField).getAttribute("value").contains(addressObject.getZipCode()))
                return false;
            if (!getElementNew(phoneNumberTextField).getAttribute("value").contains(addressObject.getPhoneNumber()))
                return false;
            if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, countryDropDown).contains(addressObject.getCountry()))
                return false;
            if (addressObject.getProvince() != null) {
                if (!PublicAdminCommons.getSelectedValueFromDropDown(driver, provinceDropDown).contains(addressObject.getProvince()))
                    return false;
            }
            if (addressObject.getAddressDescription() != null) {
                if (!getElementNew(addressDescription).getAttribute("value")
                        .contains(addressObject.getAddressDescription()))
                    return false;
            }
            if (addressObject.getStreetAddress2() != null) {
                if (!getElementNew(streetAddressSecondTextField).getAttribute("value")
                        .contains(addressObject.getStreetAddress2()))
                    return false;
            }
            if (addressObject.getStreetAddress3() != null) {
                if (!getElementNew(streetAddressThirdTextField).getAttribute("value")
                        .contains(addressObject.getStreetAddress3()))
                    return false;
            }
            if (addressObject.getStreetAddress4() != null) {
                if (!getElementNew(streetAddressFourthTextField).getAttribute("value")
                        .contains(addressObject.getStreetAddress4()))
                    return false;
            }
            if (addressObject.getCompany() != null) {
                if (!getElementNew(companyName).getAttribute("value")
                        .contains(addressObject.getCompany()))
                    return false;
            }
            /*if (addressObject.getMiddleName() != null) {
                if (!getElementNew(middleNameTextField).getAttribute("value")
                        .contains(addressObject.getMiddleName()))
                    return false;
            }*/
            if (addressObject.getVatNumber() != null) {
                if (!getElementNew(vatNumberTextField).getAttribute("value")
                        .contains(addressObject.getVatNumber()))
                    return false;
            }
            if (addressObject.getNameSuffix() != null) {
                if (!getElementNew(nameSuffixTextField).getAttribute("value")
                        .contains(addressObject.getNameSuffix()))
                    return false;
            }
            return true;
        } catch (Exception e) {
            log.info(e);
            e.getStackTrace();
            return false;
        }
    }
}
