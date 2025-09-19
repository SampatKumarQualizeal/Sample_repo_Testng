package pages.ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

public class PaymentOptionsPage_Public extends BasePage {

	public PaymentOptionsPage_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By pageTitle = By.xpath("//*[@id='checkout-step-select-payment']//*[@data-role='title']");

	private By paymentOptionCreditCardLabel = By.xpath("//*[@class='field choice']//*[contains(text(),'Credit Card')]");
	private By paymentOptionCreditCardRadioButton = By.xpath("(//*[@class='field choice']//input[@type='radio'])[1]");
	private By paymentOptionInvoiceLabel = By.xpath("//*[@class='field choice']//*[contains(text(),'Invoice')]");
	private By paymentOptionInvoiceRadioButton = By.xpath("(//*[@class='field choice']//input[@type='radio'])[2]");
	private By paymentOptionEFTLabel = By
			.xpath("//*[@class='field choice']//*[contains(text(),'Electronic Funds Transfer')]");
	private By paymentOptionEFTRadioButton = By.xpath("(//*[@class='field choice']//input[@type='radio'])[3]");

	public By creditCardRadioButton = By
			.xpath("//input[@id='braintree']//following-sibling::label[text()='Credit Card ']");
	private By creditCardRadioButton1 = By.xpath("//*[@id='select-payment']/fieldset/div[1]/div/label");
	private By invoiceRadioButton = By.xpath("//input[@id='astminvoice']//following-sibling::label[text()='Invoice']");
	private By eftRadioButton = By
			.xpath("//input[@id='astmeft']//following-sibling::label[text()='Electronic Funds Transfer']");
	public By paymentMethod = By.xpath("//div[@class='field choice']");
	// *[@id="select-payment"]/fieldset/div[1]/div/label
	private By maskloader = By.xpath("//div[@data-role=\"loader\"]");

	private By poNumberInputField = By.xpath("//input[@name='po']");
	private By poMandatoryMsg = By.xpath("//input[@name='po']//following::span[@data-bind='text: element.error']");
	public By continueButton = By.xpath("//button[@title='Continue']");
	public By goBackButton = By.xpath("//button[@title='Go Back']");
	public By BillingShippingBreadCrumb=By.xpath("//a[text()='Billing/Shipping']");
	public By changeBtnBillingAddress = By.xpath("//div[contains(@class,'billing-information-title mb-3')]//child::button");
	public By loader = By.id("checkout-loader");
	private By invoiceToolTip = By.xpath("//label[contains(text(),'Invoice')]/following-sibling::div");
	private By invoiceToolTipPopup = By.xpath("//label[contains(text(),'Invoice')]//following-sibling::div//div");

	private By eftToolTip = By.xpath("//label[contains(text(),'Electronic Funds Transfer')]/following-sibling::div");
	private By eftToolTipPopup = By
			.xpath("//label[contains(text(),'Electronic Funds Transfer')]//following-sibling::div//div"); // (//*[@class='field-tooltip-content'])[7]");

	private By noteSection = By.xpath("//*[@class='note-block']");
	public By errorMsgForCreditField = By.xpath("//*[@class=\"field-error\"]/span");
	public By poNumTextField = By
			.xpath("//div[@id='checkout-step-select-payment']/div/form/fieldset/div[2]/div/input[@class='input-text']");

	public WebElement creditCardRadio() {
		return getElement(creditCardRadioButton1);
	}

	public WebElement poNumTextField() {
		getElement(poNumTextField).sendKeys("none");
		;
		return null;
	}

	public WebElement invoiceRadio() {
		return getElement(invoiceRadioButton);
	}

	public WebElement eftRadio() {
		return getElement(eftRadioButton);
	}

	public WebElement getMaskLoader() {
		return getElement(maskloader);
	}

	public String getPaymentOptionsHeader() {
		try {
			return getElement(pageTitle).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getNoteText() {
		try {
			return getElement(noteSection).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean clickInvoiceToolTip() {
		try {
			getElement(invoiceToolTip).click();
			PublicCommon.waitForElementAttributeToBe(driver, invoiceToolTip, "aria-hidden", "false", 10);
			String popupAttribute = getElement(invoiceToolTipPopup).getAttribute("aria-hidden");
			return popupAttribute.equalsIgnoreCase("false");
		} catch (Exception e) {
			System.out.println("invoice tooltip exception.");
			e.printStackTrace();
			return false;
		}
	}

	public String invoiceToolTipText() {
		try {
			return getElement(invoiceToolTipPopup).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean clickEFTToolTip() {
		try {
			getElement(eftToolTip).click();

			PublicCommon.waitForElementAttributeToBe(driver, eftToolTip, "aria-hidden", "false", 10);
			String popupAttribute = getElement(eftToolTipPopup).getAttribute("aria-hidden");
			return popupAttribute.equalsIgnoreCase("false");
		} catch (Exception e) {
			System.out.println("eft tool tip exception.");
			e.printStackTrace();
			return false;
		}
	}

	public String eftToolTipText() {
		try {
			return getElement(eftToolTipPopup).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean poNumberFieldVisibility() {
		try {
			boolean visible = false;
			visible = (getElements(poNumberInputField).size() > 0);
			// return ((getElements(paymentOptionCreditCardLabel).size() > 0) &&
			// (getElements(paymentOptionCreditCardRadioButton).size() > 0));
			return visible;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String poNumberMandatoryMsg() {
		try {
			return getElement(poMandatoryMsg).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean creditCardOptionVisibility() {
		try {
			boolean visible = false;
			visible = (getElements(paymentOptionCreditCardLabel).size() > 0);
			// return ((getElements(paymentOptionCreditCardLabel).size() > 0) &&
			// (getElements(paymentOptionCreditCardRadioButton).size() > 0));
			return visible;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean invoiceOptionVisibility() {
		try {
			boolean visible = false;
			visible = (getElements(paymentOptionInvoiceLabel).size() > 0);
			// return ((getElements(paymentOptionInvoiceLabel).size() > 0) &&
			// (getElements(paymentOptionInvoiceRadioButton).size() > 0));
			return visible;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean eFTOptionVisibility() {
		try {
			boolean visible = false;
			visible = (getElements(paymentOptionEFTLabel).size() > 0);
			// return ((getElements(paymentOptionEFTLabel).size() > 0) &&
			// (getElements(paymentOptionEFTRadioButton).size() > 0));
			return visible;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectCreditCardOption() {
		try {
			getElement(paymentOptionCreditCardLabel).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectCreditCardOption(String poNumber) {
		try {
			getElement(paymentOptionCreditCardLabel).click();
			getElement(poNumberInputField).clear();
			getElement(poNumberInputField).sendKeys(poNumber);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Selecting Credit Card as Payment option.")
	public boolean paywithCreditCard() {
		try {
			boolean outcome = false;
			outcome = selectCreditCardOption();
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(poNumberInputField));
			getElement(poNumberInputField).clear();
			getElement(poNumberInputField).sendKeys("none");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			outcome = continueToPaymentDetailsPage();
			return outcome;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Selecting Credit Card as Payment option (with PO Number: {poNumber}).")
	public boolean paywithCreditCard(String poNumber) {
		try {
			boolean outcome = false;
			outcome = selectCreditCardOption(poNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			outcome = continueToPaymentDetailsPage();
			return outcome;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectInvoiceOption() {
		try {
			getElement(paymentOptionInvoiceLabel).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectInvoiceOption(String poNumber) {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOf(getMaskLoader()));
			getElement(paymentOptionInvoiceLabel).click();
			getElement(poNumberInputField).clear();
			getElement(poNumberInputField).sendKeys(poNumber);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Selecting Invoice as Payment option (with PO Number: {poNumber}).")
	public boolean paywithInvoice(String poNumber) {
		try {
			boolean outcome = false;
			outcome = selectInvoiceOption(poNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			outcome = continueToPaymentDetailsPage();
			return outcome;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectEFTOption() {
		try {
			getElement(paymentOptionEFTLabel).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectEFTOption(String poNumber) {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOf(getMaskLoader()));
			getElement(paymentOptionEFTLabel).click();
			getElement(poNumberInputField).clear();
			getElement(poNumberInputField).sendKeys(poNumber);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@Step("Selecting EFT as Payment option (with PO Number: {poNumber}).")
	public boolean paywithEFT(String poNumber) {
		try {
			boolean outcome = false;
			outcome = selectEFTOption(poNumber);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			outcome = continueToPaymentDetailsPage();
			return outcome;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean continueToPaymentDetailsPage() {
		try {
			WebElement ele = getElement(continueButton);
			WaitStatementUtils.waitForElementToBeClickable(driver, ele);
			ele.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean goBackToPreviousPage() {
		try {
			PublicCommon.JSClick(getElement(goBackButton), driver);
			// getElement(goBackButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some error occured while creating element" + locator.toString());
			e.getStackTrace();
		}
		return element;
	}

	/**
	 * This method will select the Payment Method <br>
	 * "Credit" -To Select Credit Card as payment <br>
	 * "Invoice" -To Select Invoice as payment <br>
	 * "EFT - Wire Transfer" -To Select Electronic Fund Transfer as payment
	 * 
	 * @param paymentMethod
	 * @return True/False
	 * 
	 */
	public boolean selectPaymentMethodAndEnterPONumber(String paymentMethod, String poNumber) {
		try {
			//wait.until(ExpectedConditions.invisibilityOf(getMaskLoader()));
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(creditCardRadioButton),20);
			if (paymentMethod.equalsIgnoreCase("Credit")) {
				(new Actions(driver)).moveToElement(getElement(creditCardRadioButton)).click().build().perform();
			}

			else if (paymentMethod.equalsIgnoreCase("Invoice")) {
				getElement(invoiceRadioButton).click();
			}

			else if (paymentMethod.equalsIgnoreCase("EFT - Wire Transfer")) {
				getElement(eftRadioButton).click();
			} else {
				System.out.println("Payment Method is not Correct");
				return false;
			}
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(poNumberInputField));
			getElement(poNumberInputField).clear();
			getElement(poNumberInputField).sendKeys(poNumber);

			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(continueButton), driver);
			getElement(continueButton).click();
			//getElement(continueButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean selectPaymentMethodAndEnterPONumber1(String paymentMethod) {
		try {
			// wait.until(ExpectedConditions.invisibilityOf(getMaskLoader()));
			// WaitStatementUtils.explicitWaitForVisibility(driver,
			// getElement(creditCardRadioButton));
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(creditCardRadioButton1));
			// getElement(creditCardRadioButton).click();

			if (paymentMethod.equalsIgnoreCase("Credit")) {
				getElement(creditCardRadioButton).click();
			}

			else if (paymentMethod.equalsIgnoreCase("Invoice")) {
				getElement(invoiceRadioButton).click();
			}

			else if (paymentMethod.equalsIgnoreCase("EFT - Wire Transfer")) {
				getElement(eftRadioButton).click();
			} else {
				System.out.println("Payment Method is not Correct");
				return false;
			}
			/*
			 * WaitStatementUtils.explicitWaitForVisibility(driver,
			 * getElement(poNumberInputField)); getElement(poNumberInputField).clear();
			 */

			// getElement(poNumberInputField).sendKeys(poNumber);

			ScreenshotUtil.takeScreenshotForAllure(driver);
			ReusableMethods.scrollIntoView(getElement(continueButton), driver);
			getElement(continueButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean enterPONumber(String poNumber) {
		try {
			getElement(poNumberInputField).clear();
			getElement(poNumberInputField).sendKeys(poNumber);
			getElement(continueButton).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
