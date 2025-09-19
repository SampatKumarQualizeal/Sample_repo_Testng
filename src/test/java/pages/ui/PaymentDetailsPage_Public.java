package pages.ui;

import base.utils.*;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class PaymentDetailsPage_Public extends BasePage {

	public PaymentDetailsPage_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By billingAddressText=By.xpath("//div[@class='billing-information']");
	public By shippingAddressText=By.xpath("//div[contains(@class,'shipping-information ')]");
	public By nopaymentrequired = By.xpath("//span[text()='No Payment Information Required']");

	public By paymentModule = By.xpath("//*[@class='payment-group']");
	private By cardImages = By.xpath("//*[@class='credit-card-types']//img");

	public By cardNumberLabel = By.xpath("//label[contains(@class, 'label') and contains(., 'Credit Card Number')]");
	private String iframeCardNumberField = "braintree-hosted-field-number";
	private By cardNumberField = By.id("credit-card-number");

	private By securityCodeLabel = By.xpath("//label[contains(@class, 'label') and contains(., 'Security Code')]");
	private String iframeSecurityCodeField = "braintree-hosted-field-cvv";
	private By securityCodeField = By.id("cvv");

	private By expiryDetailsLabel = By.xpath("//label[contains(@class, 'label') and contains(., 'Expiration Date')]");
	public By expiryError = By
			.xpath("//*[@class='hosted-error' and contains(.,'Please, enter valid Expiration Date')]");

	private String iframeExpiryMonth = "braintree-hosted-field-expirationMonth";
	private By expiryMonth = By.id("expiration-month");
	private String iframeExpiryYear = "braintree-hosted-field-expirationYear";
	private By expiryYear = By.id("expiration-year");

	public By cardNumberErrorMessage = By
			.xpath("//div[@id='braintree_cc_number']//following::span[contains(text(),'Credit Card Number')]");
	private By cvvErrorMessage = By
			.xpath("//div[@id='braintree_cc_number']//following::span[contains(text(),'valid Card Verification ')]");
	private By expiryDateErrorMessage = By
			.xpath("//div[@id='braintree_cc_number']//following::span[contains(text(),'valid Expiration')]");
	private By transactionErrorMessage = By
			.xpath("//div[@data-ui-id='checkout-cart-validationmessages-message-error']");
	public By creditCardNum = By.xpath("//input[@id='credit-card-number']");
	private By securityCode = By.id("cvv");
	private By monthExpiryDate = By.id("expiration-month");
	private By dateExpiryDate = By.id("expiration");
	// public By tooltipLinkButton = By.xpath("//*[@class='field-tooltip']");
	public By tooltipLinkButton = By.xpath("//div[@id='cvv_tooltip']//preceding-sibling::span[@title='What is this?']");

	private By tooltipPopUp = By.xpath("//*[@id='cvv_tooltip']");
	public By tooltipCloseButton = By.xpath("//*[@id='cvv_tooltip']//*[@class='modal-body']//button[@class='close']");
	private By tooltipVisaMCImage = By.xpath("//*[@id='cvv_tooltip']//img[contains(@src, 'visamccvv.jpg')]");
	private By tooltipAmexImage = By.xpath("//*[@id='cvv_tooltip']//img[contains(@src, 'amexcvv.jpg')]");

	private By toolTipLine1Label = By
			.xpath("//div[@id='cvv_tooltip']//child::span[contains(text(),'printed on your card')]");
	private By toolTipLeftSideLabel = By.xpath("//div[@id='cvv_tooltip']//child::span[contains(text(),'Mastercard,')]");
	private By toolTipRightSideLabel = By
			.xpath("//div[@id='cvv_tooltip']//child::span[contains(text(),'American Express card,')]");
   public By estimatedTax = By.xpath("//tr[@class='totals-tax-summary']//*[text()='Estimated Tax:'] | //tr[@class='totals-tax']//*[text()='Estimated Tax:']");
	public By estimatedTaxTPT = By.xpath("//*[text()='Estimated Tax:']");
   public By membershipDiscount=By.xpath("//*[text()='Member Discount:']/following-sibling::td/span");
   public By selectPaymentHeader = By.xpath("//h4[text()='Select Payment Method']");
   public By memberDiscountPrice = By.xpath("//th[text()= 'Member Discount:']/../td");
   public By paymentPageHeader = By.xpath("//h4[text()='Payment Information']");
   public By locationCityNState = By.xpath("//strong[@class='product-item-name m-0 d-inline' and contains(text(),'ASTM/ACES Performance Grading (PG) of Asphalt Binders - Tests Procedures')]");
   public By stndrdNRedlineProd = By.xpath("//strong[contains(text(),'Standard Specification for  Carbon and Low-Alloy Steel Forgings, Requiring Notch Toughness   Testing for Piping Components')]");
   public By BillingInformation_Change = By.xpath("//div[@class='billing-information']/div/button/span");
   public By ShippingInformation_Change = By.xpath("//div[@class='shipping-information pt-3']/div/button/span");
   public By FreightForwarder_Change = By.xpath("//div[@class='freight-forwarder-information my-3']/div/button/span");
   public By goBackButton = By.xpath("//button[@title='Go Back']");
	public By BillingShippingBreadCrumb=By.xpath("//a[text()='Billing/Shipping']");



	public List<WebElement> getITemsStndrdNRedlineProduct() {
		return getElements(stndrdNRedlineProd);
	}
   public List<WebElement> getMembershipDiscount() {
	   return getElements(membershipDiscount);
   }

	@Step("Get Payment page Membership Discount Price")
	public String getPaymentPageMemDiscount(){
		try{
			String discountInString = getElement(membershipDiscount).getText();
			discountInString = discountInString.replace("$", "").replace("-","");
			return discountInString;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Get Payment page Membership Discount Price")
	public String getPaymentPageGrandTotal(){
		try{
			String discountInString = getElement(grandTotalPayment).getText();
			discountInString = discountInString.replace("$", "");
			return discountInString;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

   public WebElement getEstimatedTax() {
	   return getElement(estimatedTax);
   }
   
	public boolean securityToooltip() {
		try {
			PublicCommon.waitForSec(3);
			PublicCommon.JSClick(getElement(tooltipPopUp), driver);
			// getElement(tooltipPopUp).click();
			boolean tooltipVisible = false;

			tooltipVisible = (driver.findElements(tooltipVisaMCImage).size() == 1);
			tooltipVisible = tooltipVisible && (driver.findElements(tooltipVisaMCImage).size() == 1);
			tooltipVisible = tooltipVisible && (driver.findElements(tooltipAmexImage).size() == 1);
			tooltipVisible = tooltipVisible && (driver.findElements(toolTipLine1Label).size() == 1);

			return tooltipVisible;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public By orderSummaryTitle = By.xpath("//*[@data-role='title' and contains(text(), 'Order Summary')]");
	private By shippingCharges = By.xpath("//*[@data-th='Shipping']");
	private By grandTotalTax = By.xpath("//*[@data-th='Tax']//span");
	public By totalTax = By.xpath("//*[@class='totals-tax']//span");
	private By grandTotalPayment = By.xpath("//*[@data-th='Grand Total']//span");

	public By changeBtnBillingAddress = By.xpath("//div[contains(@class,'billing-information-title mb-3')]//child::button");

	public By changeBtnShippingAddress = By.xpath("//div[contains(@class,'shipping-information-title mb-3')]//child::button");

	public By viewBtnOrgCompanyAddress = By
			.xpath("//div[contains(@class,'company-information-title mb-3')]//child::button[contains(@data-bind,'view')]");

	public By hideBtnOrgCompanyAddress = By
			.xpath("//div[contains(@class,'company-information-title mb-3')]//child::button[contains(@data-bind,'hide')]");

	public By changeBtnOrgCompanyAddress = By
			.xpath("//div[contains(@class,'company-information-title mb-3')]//child::button[contains(@data-bind,'edit')]");

	public By changeBtnShippingCourierServices = By.xpath(
			"//div[contains(@class,'shipping-courier-information ')]//child::button[contains(@data-bind,'edit')]");

	public By changeBtnFreightForwarder = By.xpath(
			"//div[contains(@class,'freight-forwarder-information ')]//child::button[contains(@data-bind,'edit')]");
	public By continueThirdPartyShippingAddress = By
			.xpath("//parent::button[@type='button' and contains(@data-bind,'click: saveThirdPartyShippingAddress')]");

	public By changeBtnContactPersonAddress = By.xpath(
			"//div[@class='contact-information contact-information-shipping col-sm-6 order-4 px-0 py-3 border-bottom']//child::button");
	public By continueContactPersonAddress = By
			.xpath("//*[@class='contact-person-form']//button[@data-bind='click: saveContactData']");

	public By getBillingAddress = By.xpath("(//div[contains(@class,'billing-information')])[1]");
	public By getShippingAddress = By.xpath("(//div[contains(@class,'shipping-information')])[1]");
	public By getOrgCompanyAddress = By
			.xpath("//div[contains(@class,'company-information')]//child::div[contains(@data-bind,'visible')]");

	public By getFreightForwarderAddress = By.xpath("//div[contains(@class,'freight-forwarder-information ')]");
	public By getShippingCourierServicesAddress = By.xpath(
			"//div[contains(@class,'shipping-courier-information ')]//div[@data-bind='if: freightForwardAddress()']");
	public By getContactPersonAddress = By.xpath("//div[contains(@class,'contact-information-shipping')]");

	public By streetBillingAddress = By.xpath("//div[@name='billingAddress.street.0']//child::input");
	private By OrgCompanyBillingAddress = By.xpath("//div[@name='billingAddress.company']//child::input");
	public By continueBillingAddress = By.xpath("//button[@data-bind='click: saveBillingAddress']");
	private By changeMobileNoBillingAddress = By.xpath("//div[@name='billingAddress.telephone']//child::input");
	private By streetShippingAddress = By.xpath("//div[@name='shippingAddress.street.0']//child::input");
	public By shippingAddress2Textbox = By.cssSelector("div[name='shippingAddress.street.1'] input");
	public By continueShippingAddress = By
			.xpath("//form[@id='co-shipping-method-form']//child::button[@type='submit']");

	private By companyNameOrgCompanyAddres = By.xpath("//div[@name='organizationAddress.company']//child::input");
	public By streetOrgCompanyAddress = By.xpath("//div[@name='organizationAddress.street.0']//child::input");

	public By saveChangesOrgCompanyAddress = By.xpath("//span[text()='Save Changes']//parent::button");
	public By orgNoChangeBtn = By
			.xpath("//fieldset[@id='organization-new-address-form']//following::span[text()='No Changes'][1]");
	public By noChangesBtn = By.xpath(
			"//button[@data-role='opc-continue']//span[text()='Continue']//preceding::span[text()='No Changes'][1]");
	public By country = By.cssSelector("div[name*='shippingAddress.country_id'] select");
	public By continueBtn = By.xpath("//button[@data-role='opc-continue']//span[text()='Continue']");
	public By errorMsg = By.xpath("//span[contains(text(),'Ship-to country')]");
	public By thankYouMsg = By.xpath("//span[contains(text(),'Thank you')]");
	public By submitButton = By.xpath("//span[text()='Submit Order']");
	public By GrandtotalPrice = By.xpath("//strong[text()='Grand Total:']/../../td[2]/strong/span");
	
	private By readingRoom = By.linkText("Reading Room");
	public By PPItemDescription = By.xpath("//tr[@class='product-item']//child::strong");
	public By PPQuality = By.xpath("//tr[@class='product-item']//child::span[@class='value']");
	public By PPPrice = By.xpath("//tr[@class='product-item']//child::span[@class='subtotal']");
	public By PPTotal = By.xpath("//tbody//tr[@class='astm-table-tr']//td[3]/span[@class='price']");
	public By PPSubTotal = By.xpath("//tr[@class='totals']//child::span[@class='price']");
	public By PPShippingCharges = By.xpath("//tr[@class='totals shipping excl']//child::span[@class='price']");
	public By PPGrandTotal = By.xpath("//tr[@class='grand totals']//child::span[@class='price']");
	public By loader = By.xpath("//div[@class='loading-mask']");

	public By creditCardTypes = By.className("credit-card-types");
	public By cancelOrder = By.xpath("//button[@title='Cancel Order']");
	// Created for PUB-3883
	public By cancelOrderTextHeader_Popup = By.id("abandonShoppingCart");
	public By cancelOrderBtn_Popup = By.xpath("//div[@class='modal-footer']/button[@title='Cancel Order']");
	public By noBtn_Popup = By.xpath("//span[text()='No']");
	public By cancelOrderbodyText_popup = By.xpath("//strong[contains(text(),'Do you wish to abandon')]");

	private By paymentInformationHeader = By.xpath("//*[contains(text(),'Payment Information')]");
	private By addressInformationHeader = By.xpath("//*[text()='Address Information']");
	private By orderSummaryHeader = By.xpath("//*[text()='Order Summary']");

	private By invoiceLabel = By.xpath("//*[@data-bind='text: getTitle()' and contains(text(), 'Invoice')]");
	private By invoiceValue = By.xpath("(//*[@data-bind='text: poNumber'])[2]");

	private By eftLabel = By.xpath("//*[@data-bind='text: getTitle()' and contains(text(), 'EFT - Wire Transfer')]");
	private By eftValue = By.xpath("(//*[@data-bind='text: poNumber'])[1]");
	private By shippingAddressTitleForChangePage = By
			.xpath("//h2[@data-role=\"title\" and contains(text(),'Shipping Address')]");
	private By billingAddressTitleForChangePage = By
			.xpath("//h2[@data-role=\"title\" and contains(text(),'Billing Address')]");
	private By orgAddressTitleForChangePage = By
			.xpath("//h2[@data-role=\"title\" and contains(text(),'Organization Address')]");
	private By noChangeButton = By.xpath("//span[contains(text(),'No Changes')]//parent::button");
	private By noChangeButtonForOrgPage = By.xpath("//button[@data-bind=\"click: cancelChanges\"]");
	private By affilationCheckBox = By.xpath(
			"//label[text()='Check here if you do not have a company affiliation']//preceding-sibling::input[@type='checkbox']");
	public By freightForwarderInformation = By.xpath(
			"//div[contains(@class,'freight-forwarder-information ')]//div[@data-bind='if: freightForwardAddress()']");
	public By shippingCourierInformation = By.xpath(
			"//div[contains(@class,'shipping-courier-information ')]//div[@data-bind='if: freightForwardAddress()']");

	public By freightForwarderInformationVisible = By.xpath("//div[contains(@class,'freight-forwarder-information ')]");
	public By shippingCourierInformationVisible = By.xpath("//div[contains(@class,'courier-service-information')]");

	public By shippingContactInformation = By.xpath(
			"//div[@class='contact-information contact-information-shipping col-sm-6 order-4 px-0 py-3 border-bottom']//div[@data-bind='if: contactShipping()']//span[1]");
	private By firstProductDescription = By.xpath("//tr[@class='product-item'][1]//child::strong");
	// attendees information
	public By attendeeInformationHeaderText = By.xpath("//h4[text()='Attendee Information']");
	public By nameHeader = By.xpath("//table[@class='table astm-table']//thead//th[text()='Name']");
	public By emailHeader = By.xpath("//table[@class='table astm-table']//thead//th[text()='Email']");
	public By phoneHeader = By.xpath("//table[@class='table astm-table']//thead//th[text()='Phone']");
	public By attendeeName = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[1]");
	public By attendeeFirstName = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[1]//span[1]");
	public By attendeeMiddleName = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[1]//span[2]");
	public By attendeeLastName = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[1]//span[3]");
	public By attendeeEmail = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[2]");
	public By attendeePhone = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[3]");
	public By attendeeChangeButton = By
			.xpath("//h4[text()='Attendee Information']//following::button//span[text()='Change']");
	//public By tax = By.cssSelector(".totals-tax .price");
	public By tax = By.xpath("//*[text()='Estimated Tax:']/following-sibling::td/span");
	public By addressInfo = By.className("address-information");
	public By paymentInfo = By.xpath("//*[text()='Payment Information']");
	public By totalsList = By.cssSelector("*[class='data table totals'] *[class='mark text-right']");
	public By viewButton = By.xpath("//button[@class='btn astm-btn btn-secondary px-2 py-0 ml-2 align-top']//*[text()='view']");
	public By changeButton = By.xpath("(//button[@class='btn astm-btn btn-secondary px-2 py-0 ml-3 align-top']//*[text()='change'])[2]");
	public By organizationNameAdd = By.xpath("(//div[text()='ASTM'])[3]");
	public By continueButton = By.xpath("//button[@class='btn astm-btn btn-primary']//span[text()='Continue']");
	
	public WebElement getPPShippingCharges() {
		return getElement(PPShippingCharges);
	}
	
	public WebElement freightForwarderInformationVisible() {
		return getElement(freightForwarderInformationVisible);
	}

	public WebElement shippingCourierInformationVisible() {
		return getElement(shippingCourierInformationVisible);
	}
	
	public WebElement getSubmitButton() {
		return getElement(submitButton);
	}

	public WebElement creditCardTypes() {
		return getElement(creditCardTypes);
	}

	public List<WebElement> totalsListElements() {
		try {
			return getElements(totalsList);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getPTPGrandTotalprice(){
		try {
			return getElement(GrandtotalPrice).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}


	public WebElement getAddressInfo() {
		try {
			return getElement(addressInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getTax() {
		try {
			return getElement(tax);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getChangeBtnBillingAddress() {
		try {
			return getElement(changeBtnBillingAddress);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getChangeBtnShippingAddress() {
		try {
			return getElement(changeBtnShippingAddress);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public WebElement getOrderSummaryTitle() {
		try {
			return getElement(orderSummaryTitle);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean paymentInformationHeaderIsVisible() {
		try {

			getElement(paymentInformationHeader).isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public WebElement getPaymentInformationHeader() {
		return getElement(paymentInformationHeader);
	}

	public boolean addressInformationHeaderIsVisible() {
		try {

			getElement(addressInformationHeader).isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean orderSummaryHeaderIsVisible() {
		try {

			getElement(orderSummaryHeader).isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public WebElement getTransactionErrorMessage() {
		try {
			return getElement(transactionErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement paymentInformation() {
		try {
			return getElement(paymentInformationHeader);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getInvoiceNumber() {
		try {
			return getElement(invoiceValue).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getEFTNumber() {
		try {
			return getElement(eftValue).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * invoice: (//*[@data-bind='text: poNumber'])[2] //*[@data-bind='text:
	 * getTitle()' and contains(text(), 'Invoice')]
	 * 
	 * eft: (//*[@data-bind='text: poNumber'])[1] //*[@data-bind='text: getTitle()'
	 * and contains(text(), 'EFT - Wire Transfer')]
	 * 
	 */

	@Step("Click on Cancel Order.")
	public boolean clickCancelOrder() {
		try {
			waitforVisibility(cancelOrder);
			getElement(cancelOrder).click();

			waitforVisibility(cancelOrderBtn_Popup);
			getElement(cancelOrderBtn_Popup).click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void waitforVisibility(By locator) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public String getBillingAddress() {
		try {
			waitforVisibility(getBillingAddress);
			Thread.sleep(2000);
			return getElement(getBillingAddress).getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getErrorMessageCreditCard() {
		try {
			waitforVisibility(cardNumberErrorMessage);
			ReusableMethods.scrollIntoView(getElement(cardNumberErrorMessage), driver);
			// WaitStatementUtils.explicitWaitForVisibility(driver,
			// getElement(cardNumberErrorMessage));
			return getElement(cardNumberErrorMessage).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getErrorMessageExpirationDate() {
		try {

			ReusableMethods.scrollIntoView(getElement(expiryDateErrorMessage), driver);
			waitforVisibility(expiryDateErrorMessage);
			return getElement(expiryDateErrorMessage).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getErrorMessageCardVerification() {
		try {
			waitforVisibility(cvvErrorMessage);
			ReusableMethods.scrollIntoView(getElement(cvvErrorMessage), driver);
			return getElement(cvvErrorMessage).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getErrorMessageTransactionInvalidCard() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(transactionErrorMessage));
			return getElement(transactionErrorMessage).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getShippingAddress() {
		try {
			waitforVisibility(getShippingAddress);
			return getElement(getShippingAddress).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getfreightForwarderInformation() {
		try {
			waitforVisibility(freightForwarderInformation);
			return getElement(freightForwarderInformation).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getshippingCourierInformation() {
		try {
			waitforVisibility(shippingCourierInformation);
			return getElement(shippingCourierInformation).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getshippingContactInformation() {
		try {
			waitforVisibility(shippingContactInformation);
			return getElement(shippingContactInformation).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getOrgCompanyAddress() {
		try {
			waitforVisibility(getOrgCompanyAddress);
			return getElement(getOrgCompanyAddress).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getShippingCourierAddress() {
		try {
			waitforVisibility(getShippingCourierServicesAddress);
			return getElement(getShippingCourierServicesAddress).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getFreightForwarderAddress() {
		try {
			waitforVisibility(getFreightForwarderAddress);
			return getElement(getFreightForwarderAddress).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getContactPersonAddress() {
		try {
			waitforVisibility(getContactPersonAddress);
			return getElement(getContactPersonAddress).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String toolTipHeaderText() {
		try {
			waitforVisibility(toolTipLine1Label);
			return getElement(toolTipLine1Label).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String toolTipLeftSideText() {
		try {
			waitforVisibility(toolTipLeftSideLabel);
			return getElement(toolTipLeftSideLabel).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String toolTipRightSideText() {
		try {
			return getElement(toolTipRightSideLabel).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void goToOrderSummarySection() {
		try {
			ReusableMethods.scrollIntoView(getElement(orderSummaryTitle), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getShippingCharges() {
		try {
			return getElement(shippingCharges).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getTotalTax() {
		try {
			return getElement(grandTotalTax).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getTaxPrice() {
		try {
			return getElement(totalTax).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getTotalPayment() {
		try {
			return getElement(grandTotalPayment).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// @Step("Check user lands on the Payment page.")
	public boolean landingOnPaymentDetailsPage() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(paymentModule), 10);
			return (driver.findElements(paymentModule).size() > 0);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@Step("Checking Payment Info Section fields availability - Card Images.")
	public boolean payMentInfoSectionCardImagesCheck() {
		try {
			boolean fieldsLoaded = false;
			fieldsLoaded = (driver.findElements(cardImages).size() == 7);
			return fieldsLoaded;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Step("Checking Payment Info Section fields availability - Credit Card.")
	public boolean payMentInfoCreditCardSectionCheck() {
		try {
			boolean fieldsLoaded = false;
			fieldsLoaded = (driver.findElements(cardNumberLabel).size() == 1);
			Thread.sleep(3000);
			// WaitStatementUtils.explicitWaitForVisibility(driver,
			// getElement(paymentModule), 10);

			driver.switchTo().frame(iframeCardNumberField);
			fieldsLoaded = (fieldsLoaded && (driver.findElements(cardNumberField).size() == 1));
			driver.switchTo().defaultContent();

			return fieldsLoaded;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Step("Checking Payment Info Section fields availability - Security Code field.")
	public boolean payMentInfoSecurityCodeSectionCheck() {
		try {
			boolean fieldsLoaded = false;
			fieldsLoaded = (driver.findElements(securityCodeLabel).size() == 1);

			driver.switchTo().frame(iframeSecurityCodeField);
			fieldsLoaded = (driver.findElements(securityCodeField).size() == 1);
			driver.switchTo().defaultContent();

			return fieldsLoaded;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Step("Checking Payment Info Section fields availability - Expiry Details Section.")
	public boolean payMentInfoExpirySectionCheck() {
		try {
			boolean fieldsLoaded = false;
			fieldsLoaded = (driver.findElements(expiryDetailsLabel).size() == 1);

			// iframeExpiryMonth
			driver.switchTo().frame(iframeExpiryMonth);
			System.out.println("cc code sec:" + driver.findElements(expiryMonth).size());
			fieldsLoaded = (driver.findElements(expiryMonth).size() == 1);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(iframeExpiryYear);
			System.out.println("cc code sec:" + driver.findElements(expiryYear).size());
			fieldsLoaded = (driver.findElements(expiryYear).size() == 1);
			driver.switchTo().defaultContent();

			return fieldsLoaded;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public void iFrameInteraction() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method is to clear and Send keys to Any text field
	 * 
	 * @param locator
	 * @param keys
	 */
	public void clearTxtFieldsendKeys(By locator, String keys) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			getElement(locator).clear();
			getElement(locator).sendKeys(keys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clearTxtField(By locator) {
		try {
			getElement(locator).clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean clearCreditCardNumber() {
		try {
			switchToFrameAndSendKeys("braintree-hosted-field-number", creditCardNum, "grb");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean clearExpiryMonth() {
		try {
			switchToFrameAndSendKeys("braintree-hosted-field-expirationMonth", monthExpiryDate, "grb");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean clearExpiryYear() {
		try {
			switchToFrameAndSendKeys("braintree-hosted-field-expirationYear", dateExpiryDate, "");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private By maskloader = By.xpath("//div[@data-role=\"loader\"]");

	public WebElement getMaskLoader() {
		return getElement(maskloader);
	}

	/**
	 * This Method Edit and Save the billing Address
	 * 
	 * @param companyName
	 * @param streetAddress
	 * @param mobileNumber
	 * @return
	 */

	public boolean changeBillingAddress(String companyName, String streetAddress, String mobileNumber) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(changeBtnBillingAddress));
			getElement(changeBtnBillingAddress).click();
			clearTxtFieldsendKeys(OrgCompanyBillingAddress, companyName);
			clearTxtFieldsendKeys(streetBillingAddress, streetAddress);
			PublicCommon.waitForSec(2);
			ReusableMethods.scrollIntoView(getElement(changeMobileNoBillingAddress), driver);
			clearTxtFieldsendKeys(changeMobileNoBillingAddress, mobileNumber);
			getElement(continueBillingAddress).click();
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method used to Edit and Save the Shipping Address
	 * 
	 * @param streetAddress
	 * @return
	 */
	public boolean changeShippingAddress(String streetAddress) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(changeBtnShippingAddress));
			getElement(changeBtnShippingAddress).click();
			clearTxtFieldsendKeys(streetShippingAddress, streetAddress);
			PublicCommon.waitForSec(2);
			clearTxtFieldsendKeys(shippingAddress2Textbox, "Test Street");
			PublicCommon.waitForSec(2);
			ReusableMethods.scrollIntoView(getElement(continueShippingAddress), driver);
			wait.until(ExpectedConditions.elementToBeClickable(continueShippingAddress));
			/*
			 * WebElement button = getElement(continueShippingAddress); new
			 * Actions(driver).moveToElement(button);
			 */
			getElement(continueShippingAddress).click();
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method used to Edit and Save the Organization/Company Address
	 * 
	 * @param companyName
	 * @param streetAddress
	 * @return
	 */
	public boolean changeOrgCompanyAddress(String companyName, String streetAddress) {
		try {
			getElement(changeBtnOrgCompanyAddress).click();
			clearTxtFieldsendKeys(companyNameOrgCompanyAddres, companyName);
			clearTxtFieldsendKeys(streetOrgCompanyAddress, streetAddress);
			ReusableMethods.scrollIntoView(getElement(saveChangesOrgCompanyAddress), driver);
			getElement(saveChangesOrgCompanyAddress).click();
			PublicCommon.waitForSec(3);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method used to click Change button for Org/Company Address
	 * 
	 * @return
	 */
	public boolean clickOnViewAndChangeButtonOrgCompany() {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(getElement(loader)));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(viewBtnOrgCompanyAddress));
			if (getElement(viewBtnOrgCompanyAddress).isDisplayed()) {
				getElement(viewBtnOrgCompanyAddress).click();
			}
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(changeBtnOrgCompanyAddress));
			getElement(changeBtnOrgCompanyAddress).click();
			return true;
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This Method Edit and Save the billing Address
	 * 
	 * @param streetAddress
	 * @return
	 */
	public String noChangeShippingAddress(String streetAddress) {
		try {
			getElement(changeBtnShippingAddress).click();
			String text = getElement(streetShippingAddress).getAttribute("value");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clearTxtFieldsendKeys(streetShippingAddress, streetAddress);
			ReusableMethods.scrollIntoView(getElement(noChangesBtn), driver);
			getElement(noChangesBtn).click();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getStreetName() {
		try {
			getElement(changeBtnShippingAddress).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String text = getElement(streetShippingAddress).getAttribute("value");
			getElement(noChangesBtn).click();
			return text;
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public boolean changeCountryShippingAddress() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(changeBtnShippingAddress), 10);
			getElement(changeBtnShippingAddress).click();
			ReusableMethods.scrollIntoView(getElement(country), driver);
			Select select = new Select(getElement(country));
			select.selectByValue("EG");
			getElement(continueBtn).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			boolean value = getElement(errorMsg).isDisplayed();

			getElement(noChangesBtn).click();
			return value;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This Method Edit billing Address
	 * 
	 * @param streetAddress
	 * @return
	 */
	public String noChangeOrganizationAddress(String streetAddress) {
		try {
			ReusableMethods.scrollIntoView(getElement(changeBtnOrgCompanyAddress), driver);
			// getElement(viewBtnOrgCompanyAddress).click();
			getElement(changeBtnOrgCompanyAddress).click();
			String text = getElement(streetOrgCompanyAddress).getAttribute("value");
			System.out.println(text);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clearTxtFieldsendKeys(streetOrgCompanyAddress, streetAddress);
			ReusableMethods.scrollIntoView(getElement(orgNoChangeBtn), driver);
			getElement(orgNoChangeBtn).click();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This Method Edit billing Address
	 * 
	 * @param streetAddress
	 * @return
	 */
	public String noChangebillingAddress(String streetAddress) {
		try {
			ReusableMethods.scrollIntoView(getElement(changeBtnBillingAddress), driver);
			// getElement(viewBtnOrgCompanyAddress).click();
			getElement(changeBtnBillingAddress).click();
			String text = getElement(streetOrgCompanyAddress).getAttribute("value");
			System.out.println(text);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clearTxtFieldsendKeys(streetOrgCompanyAddress, streetAddress);
			ReusableMethods.scrollIntoView(getElement(orgNoChangeBtn), driver);
			getElement(orgNoChangeBtn).click();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getOrganizationStreetName() {
		try {
			// ReusableMethods.scrollIntoView(getElement(viewBtnOrgCompanyAddress), driver);
			getElement(changeBtnOrgCompanyAddress).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String text = getElement(streetOrgCompanyAddress).getAttribute("value");
			ReusableMethods.scrollIntoView(getElement(orgNoChangeBtn), driver);
			getElement(orgNoChangeBtn).click();
			return text;
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method scroll and click on Submit Order
	 * 
	 * @return True/false
	 */
	public boolean scrollAndClickSubmitOrder()

	{
		try {
			ReusableMethods.scrollIntoView(getElement(submitButton), driver);
			clickOnMethod("clicked on submit Order", submitButton);
			// getElement(submitButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean scrollAndClickContinue()

	{
		try {
			ReusableMethods.scrollIntoView(getElement(continueButton), driver);
			clickOnMethod("clicked on Continue", continueButton);
			// getElement(submitButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean clickChangeButton()
	{
		try {
			//ReusableMethods.scrollIntoView(getElement(changeButton), driver);
			clickOnMethod("clicked on change Button", changeButton);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean clickViewButton()
	{
		try {
			//ReusableMethods.scrollIntoView(getElement(changeButton), driver);
			clickOnMethod("clicked on view Button", viewButton);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Step("Click on {0}")
	private void clickOnMethod(String message, By element) {
		try {
			driver.findElement(element).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception.", e);
		}
	}

	/**
	 * This Method Edit and Save the billing Address
	 * 
	 * @param streetAddress
	 * @return
	 */
	public String ChangeBillingAddress(String streetAddress, String companyName, String mobileNumber) {
		try {
			getElement(changeBtnBillingAddress).click();

			clearTxtFieldsendKeys(OrgCompanyBillingAddress, companyName);
			String text = getElement(streetBillingAddress).getAttribute("value");
			ReusableMethods.scrollIntoView(getElement(changeMobileNoBillingAddress), driver);
			clearTxtFieldsendKeys(changeMobileNoBillingAddress, mobileNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clearTxtFieldsendKeys(streetBillingAddress, streetAddress);
			ReusableMethods.scrollIntoView(getElement(continueBillingAddress), driver);
			getElement(continueBillingAddress).click();
			String billingAddress = getBillingAddress();
			String str1 = billingAddress.substring(billingAddress.indexOf("\n"), billingAddress.lastIndexOf("\n"));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return str1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean enterCreditCardDetails(String keys) {
		try {
			switchToFrameAndSendKeys("braintree-hosted-field-number", creditCardNum, keys);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean enterSecurityCodeDetails(String keys) {
		try {
			switchToFrameAndSendKeys("braintree-hosted-field-cvv", securityCode, keys);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean enterMonthDetails(String keys) {
		try {
			switchToFrameAndSendKeys("braintree-hosted-field-expirationMonth", monthExpiryDate, keys);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean enterYearDetails(String keys) {
		try {
			switchToFrameAndSendKeys("braintree-hosted-field-expirationDate", dateExpiryDate, keys);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

//This method doesn't verify the Thank you message.
	public boolean fillCreditCardDetails2(String card, String code, String month, String year) {
		try {
			ReusableMethods.scrollIntoView(getElement(getBillingAddress), driver);
			enterCreditCardDetails(card);
			enterSecurityCodeDetails(code);
			String date = month+"/20"+year;
			enterYearDetails(date);
			ReusableMethods.scrollIntoView(getElement(submitButton), driver);
			getElement(submitButton).click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Step("Fill credit card details and Click on Submit button")
	public boolean fillCreditCardDetails(String card, String code, String month, String year) {
		try {
			PublicCommon.waitForSec(10);
			WaitStatementUtils.waitForElementStaleness(driver,getElement(creditCardNum),30);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(creditCardNum),30);
			enterCreditCardDetails(card);
			enterSecurityCodeDetails(code);
			String date = month + "/20" + year;
			enterYearDetails(date);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElementNew(submitButton), driver);
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		//	PublicCommon.JSClick(driver.findElement(submitButton), driver);
			IntegrationCommon.clickonWebElement(driver, submitButton);
			 //getElement(submitButton).click();
			Thread.sleep(5000);
			boolean value = getElement(thankYouMsg).isDisplayed();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean fillCreditCardDetailsNew(String card, String code, String month, String year) {
		try {
			PublicCommon.waitForSec(10);
			//ReusableMethods.scrollIntoView(getElement(getBillingAddress), driver);
			try {
				enterCreditCardDetails(card);
				enterSecurityCodeDetails(code);
				String date = month + "/20" + year;
				enterYearDetails(date);
				return true;
			}
			catch(Exception e1) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean clickOnSubmitAndverifyThankYouMessage(){
		try {
			ReusableMethods.scrollIntoView(getElementNew(submitButton), driver);
			//	PublicCommon.JSClick(driver.findElement(submitButton), driver);
			IntegrationCommon.clickonWebElement(driver, submitButton);
			//getElement(submitButton).click();
			Thread.sleep(10000);
			boolean value = getElement(thankYouMsg).isDisplayed();
			return value;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public void switchToFrameAndSendKeys(String switchNameOrID, By locator, String keys) {
		try {
			driver.switchTo().frame(switchNameOrID);
			getElement(locator).clear();
			getElement(locator).sendKeys(keys);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String address() {
		String billingAddress = getBillingAddress();
		String str1 = billingAddress.substring(billingAddress.indexOf("\n"), billingAddress.lastIndexOf("\n"));

		return str1;

	}

	public String getItemDescription() {
		try {
			ReusableMethods.scrollIntoView(getElement(PPItemDescription), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getElement(PPItemDescription).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method is used to fetch all the product descriptions
	 * 
	 * @return
	 */
	public List<String> getItemsDescription() {

		ReusableMethods.scrollIntoView(getElement(PPItemDescription), driver);
		List<WebElement> elementList = driver.findElements(PPItemDescription);
		List<String> itemDescriptionList = new ArrayList<String>();
		for (WebElement element : elementList) {
			itemDescriptionList.add(element.getText());
		}
		return itemDescriptionList;
	}

	public String getQuantityofProduct() {
		try {
			return getElement(PPQuality).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getPrice() {
		try {
			return getElement(PPPrice).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getProductName() {
		try {
			return getElement(PPPrice).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public String getTotal() {
		try {
			return getElement(PPTotal).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getSubTotal() {
		try {
			return getElement(PPSubTotal).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getShippingCharge() {
		try {
			return getElement(PPShippingCharges).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getGrandtotal() {
		try {
			return getElement(PPGrandTotal).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method checks if Change button is visible for Shipping Address and is
	 * functional
	 */
	public boolean viewAndVerifyChangeButtonForShippingAddress() {
		// Clicking on Change button
		WebElement changeButton = getElement(changeBtnShippingAddress);
		if (WaitStatementUtils.waitForElementToBeClickable(driver, changeButton, 1))
			changeButton.click();
		// Checking if navigated to Change Page for Shipping Address
		WebElement element = getElement(shippingAddressTitleForChangePage);

		if (element.isDisplayed()) {
			// Clicking on No Changes Button
			getElement(noChangesBtn).click();
			return true;
		} else
			return false;

	}

	/**
	 * This method checks if Change button is visible for Billing Address and is
	 * functional
	 */
	public boolean viewAndVerifyChangeButtonForBillingAddress() {
		// Clicking on Change button
		WebElement changeButton = getElement(changeBtnBillingAddress);
		if (WaitStatementUtils.waitForElementToBeClickable(driver, changeButton, 1))
			changeButton.click();
		// Checking if navigated to Change Page for Shipping Address
		WebElement element = getElement(billingAddressTitleForChangePage);

		if (element.isDisplayed()) {
			// Clicking on No Changes Button
			WebElement noChange = getElement(noChangeButton);
			ReusableMethods.scrollIntoView(noChange, driver);
			noChange.click();
			return true;
		} else
			return false;

	}

	/**
	 * This method used to click Change button for Org/Company Address
	 * 
	 * @return
	 */
	public boolean clickAndVerifyAndChangeButtonOrgCompany() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(viewBtnOrgCompanyAddress), 1);
		getElement(viewBtnOrgCompanyAddress).click();
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(changeBtnOrgCompanyAddress), 1);
		getElement(changeBtnOrgCompanyAddress).click();
		// Checking if navigated to Change Page for Shipping Address
		WebElement element = getElement(orgAddressTitleForChangePage);
		if (element.isDisplayed()) {
			WebElement noChange = getElement(noChangeButtonForOrgPage);
			ReusableMethods.scrollIntoView(noChange, driver);
			noChange.click();
			return true;
		} else
			return false;

	}

	/**
	 * This method used to click View button for Org/Company Address
	 * 
	 * @return
	 */
	public boolean clickViewButtonOnPaymentPageforOrgAddress() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(viewBtnOrgCompanyAddress), 1);
		getElement(viewBtnOrgCompanyAddress).click();
		return true;
	}

	/**
	 * Method checks if affiliation check box is selected in Billing Address Page
	 * 
	 * @return
	 */
	public boolean verifyAffilationChkBoxisSelected() {
		WebElement changeButton = getElement(changeBtnBillingAddress);
		WaitStatementUtils.waitForElementToBeClickable(driver, changeButton);
		changeButton.click();
		boolean status = getElement(affilationCheckBox).isSelected();
		WebElement noChange = getElement(noChangeButton);
		ReusableMethods.scrollIntoView(noChange, driver);
		noChange.click();
		return status;

	}

	@Step("Fill credit card details and Click on Submit button")
	public void enterCreditCardDetailsAndSubmit(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapCC = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			assertTrue(fillCreditCardDetails(dataMapCC.get("creditCard"), dataMapCC.get("securityCode"),dataMapCC.get("expiryMonth"), dataMapCC.get("expiryYear")),
					"Fill Credit card details and click on submit button");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info(ex.toString());
			PublicCommon.reportFailAssert("Failed to enter credit card details to Payement Page", ex);
		}
	}

	@Step("Validating element: {0} is Visible")
	public void verifyElementIsVisible(String elementName, WebElement element, WebDriver driver) {
		WaitStatementUtils.explicitWaitForVisibility(driver, element);
		assertTrue(element.isDisplayed(), elementName + " is not visible.");
	}
	@Step("Verify Order summary in Payment page")
	public String VerifyOrderSummaryInPaymentPage(String DiscountedAmount) {
		String PaymentPageGrandTotal = null;
		try {
			String PaymentPageMemDiscount = String.valueOf(getPaymentPageMemDiscount());
			Assert.assertEquals(DiscountedAmount, PaymentPageMemDiscount);
			verifyElementIsVisible("'Estimated Tax' Text", getEstimatedTax(), driver);
			PaymentPageGrandTotal = String.valueOf(getPaymentPageGrandTotal());
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Order Summary in Payment Page", e);
		}
		return PaymentPageGrandTotal;
	}

	@Step("Click on Billing Address change button in Payment details page")
	public void click_BillingAddress_Change(){
		try{
			getElement(BillingInformation_Change).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click Billing Address Change", e);
		}
	}

	@Step("Click on Shipping Information change button in Payment details page")
	public void click_ShippingInformation_Change(){
		try{
			getElement(ShippingInformation_Change).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click Shipping Information Change", e);
		}
	}

	@Step("Click on Freight Forwarder change button in Payment details page")
	public void click_FreightForwarder_Change(){
		try{
			getElement(FreightForwarder_Change).click();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click Freight Forwarder Change", e);
		}
	}



}
