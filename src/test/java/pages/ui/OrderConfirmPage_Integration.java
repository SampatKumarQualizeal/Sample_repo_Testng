package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.astm.commonFunctions.PublicAdminCommons.switchToTabByIndex;
import static org.testng.Assert.assertTrue;

public class OrderConfirmPage_Integration extends BasePage {

	public OrderConfirmPage_Integration(WebDriver driver) {
		super(driver);
	}
	public By docPurchasedTitles=By.xpath("//tr[@class='astm-table-tr']/td[@class='astm-table-td'][1]");
	public By itemsOrderedSectionHeader=By.xpath("//span[@class='title' and text()='Items Ordered']");
	public By thankYouMsg = By.xpath("//span[contains(text(),'Thank you')]");
	public By OrderConfirmationComment1=By.cssSelector("div.checkout-success > section > div > p:nth-child(1)");  //MyAccountLinkMsg
	public By OrderConfirmationComment2 = By.cssSelector("div.checkout-success > section > div > p:nth-child(2)"); //ReceiptConfirmation
	public By OrderConfirmationComment3 = By.cssSelector("div.checkout-success > section > div > p:nth-child(3)"); //EmailConfirmationMsg
	public By BillingAddressText = By.xpath("//div[@class='billing-address-success']/p[2]");
	public By shippingAddressText = By.xpath("//div[@class='shipping-address-success']/p[2]");
	public By verbiage = By.xpath("//div[contains(text(),'We are also sending')]");
	public By itemDescription = By.xpath("//tbody//tr[@class='astm-table-tr'][1]//td[1]");
	public By Ordersetailspage_ItemDescription = By.xpath("//tbody//tr[@class='astm-table-tr'][1]//td[1]/div/span");
	public By Ordersetailspage_ItemCode = By.xpath("//tbody//tr[@class='astm-table-tr'][1]//td[1]/div/div");
	public By Ordersetailspage_ItemCode1 = By.xpath("(//div[@class='order-history-item-sku'])[2]");
	public By signinDropdown = By.xpath("//*[contains(@class,'headerSignInContainer')]/button");
	public By Cart = By.xpath("(//span[text()='Cart'])[1]");


	public By MyAccountTab = By.xpath("//a[contains(text(),'My Account')]");
	public By MembershipTab = By.xpath("//a[contains(text(),'Membership')]");
	public By AccountNumber = By.xpath("//div[@class='border-top mt-4 pt-4']/p[contains(text(),'Account#:')]");
	public By volumeDescription = By.xpath("//table[@class='table astm-table mt-4']/tbody/tr[2]/td[@class='astm-table-td']");

	public By Ordersetailspage_volumeDescription = By.xpath("//table[@class='table astm-table mt-4']/tbody/tr[2]/td[@class='astm-table-td']/div/span");

	//table[@id='shopping-cart-table']/child::tbody/tr[1]/td[1]/descendant::a
	public By qualityPurchased = By.xpath("//tbody//tr[@class='astm-table-tr']//td[2]");
	public By qualityPurchasedSec = By.xpath("(//tbody//tr[@class='astm-table-tr']//td[2])[2]");
	public By price = By.xpath("//tbody//tr[@class='astm-table-tr']//td[3]/span[@class='price']");
	public By total = By.xpath("//tbody//tr[@class='astm-table-tr']//td[4]/span[@class='price']");
	public By subTotal = By.xpath(
			"//tfoot//tr[@class='astm-table-tr']//td[contains(text(),'Subtotal')]//following::td[1]//span[@class='price']");
	public By shipping = By.xpath(
			"//tfoot//tr[@class='astm-table-tr']//td[contains(text(),'Shipping')]//following::td[1]//span[@class='price']");
	public By tax = By.xpath("//tfoot//tr[@class='astm-table-tr']//td[contains(text(),'Tax')]//following::td[1]//span[@class='price']");
	public By grandTotal = By.xpath(
			"//tfoot//tr[@class='astm-table-tr']//td[contains(text(),'Grand')]//following::td[1]//span[@class='price']");
	public By getBillingAddress = By.xpath("//div[@class='billing-information mb-3']");
	public By getShippingAddress = By.className("shipping-address-success");
	public By invoiceCheckOutSuccessText = By.xpath("//div[@class='col-12 mb-3 pt-4 border-top']//p");
	private By eftCheckOutText = By.xpath("//div[@class='checkout-success']//p");

	public By printButton = By.xpath("//p[contains(text(),'Print ')]//a");
	public By MyDigitalDocuments = By.xpath("//a[text()='My Digital Documents.']");
	public By DocumentTitle = By.xpath("//td[@class='astm-table-td']/a");
	public By DocTitle1 = By.xpath("//tr[@class='astm-table-tr odd']/td[2]");
	public By DocTitle2 = By.xpath("//tr[@class='astm-table-tr even']/td[2]");
	public By poNumberLabel = By.xpath("//strong[text()='PO Number']");
	private By poNumber = By.xpath("//strong[text()='PO Number']//following::p[1]");
	private By paymentTyeLabel = By.xpath("//strong[text()='Payment Type']");
	private By paymentTye = By.xpath("//strong[text()='Payment Type']//following::p[1]");
	public By shippingAgentLabel = By.xpath("//strong[text()='Shipping Agent']");
	public By ShippingAddressLabel = By.xpath("//strong[text()='Shipping Address']");

	// attendee information
	public By attendeeInformationHeaderText = By.xpath("//h4[text()='Attendee Information']");
	public By attendeeInformationTable = By.xpath("//table[@class='table astm-table attendees-table']//tbody");
	public By nameHeader = By.xpath("//table[@class='table astm-table attendees-table']//thead//th[text()='Name']");
	public By emailHeader = By.xpath("//table[@class='table astm-table attendees-table']//thead//th[text()='Email']");
	public By phoneHeader = By.xpath("//table[@class='table astm-table attendees-table']//thead//th[text()='Phone']");

	public By printLink = By.partialLinkText("Print");
	public By pageHeader = By.xpath("//h3[text()='My Digital Documents']");
	public By digitalDocumentLink = By.partialLinkText("My Digital Documents");
	public By myDigitalDocumentsLeftNavLink = By.linkText("My Digital Documents");
	public By myAccountsLink = By.partialLinkText("My Account");
	public By MyAccountHeader=By.xpath("(//h3)[1]");
	public By printPdf = By.id("plugin");
	public By billingAddress = By.className("billing-address-success");
	public By shippingAddress = By.className("shipping-address-success");
	public By addressHeadersList = By.cssSelector("*[class='container pt-4 mt-3 border-top'] strong");
	public By orderConfirmationPage_orderNumber = By.xpath("//h4[text()='Order Summary']/../p[1]");
	public By SuccessPageGrandTotal = By.xpath("//td[text()='Grand Total:']/../td[3]/span");
	public By SuccessPagePoNumber = By.xpath("//strong[text()='PO Number']/../../p[2]");
	public By SuccessPagePaymentType = By.xpath("//strong[text()='Payment Type']/../../p[4]");
	public By OrderDetailsPage_OrderNumber = By.xpath("(//p[@class='ml-2'])[1]");
	public By learnerNoification_ClickHere = By.cssSelector(".learner-notification-popup a");
	public By OrderNum=By.xpath("//*[text()='Order Summary']/parent::div/p[1]");
	public By Price=By.xpath("(//span[@class='price'])[1]");


	public By totalPrice=By.xpath("(//span[@class='price'])[2]");
	public By PriceSec=By.xpath("(//tr[2]/td/span[@class='price'])[1]");
	public By totalPriceSec=By.xpath("(//tr[2]/td/span[@class='price'])[2]");
	public By subTotalPrice=By.xpath("(//span[@class='price'])[3]");
	public By subTotalPriceforTwoLineItems=By.xpath("(//span[@class='price'])[5]");
	public By shippingHandlingPrice=By.xpath("(//span[@class='price'])[4]");
	public By OrderDetailspage_subTotal = By.xpath("//tr[@class='astm-table-tr']/td[text()='Shipping:']/../td[2]/span");
	public By OrderDetailspage_Shipping = By.xpath("//tr[@class='astm-table-tr']/td[text()='Shipping:']/../td[3]/span");
	public By orderDetailsPageTax = By.xpath("//tr[@class='astm-table-tr']/td[text()='Tax:']/../td[3]/span");
	public By orderDetailsPageGrandTotal = By.xpath("//tr[@class='astm-table-tr']/td[text()='Grand Total:']/../td[3]/span");
	public By orderConfirmationPage_orderDate = By.xpath("//strong[text()='Order Date']/..");
	public By orderConfirmationPage_orderTime = By.xpath("//strong[text()='Order Time']/..");
	public By memberDiscount = By.xpath("//td[text()='Member Discount:']/..//span[@class='price']");
	public By locationCityNStateOrdrpge = By.xpath("//td[@class='astm-table-td' and contains(text(),'ASTM/ACES Performance Grading (PG) of Asphalt Binders - Tests Procedures')]");
	public By ETFThankyouMsg = By.xpath("//section[@class='checkout-confirmation container']/div[1]/div[1]/p[1]");
	public By ETFAccountDetails = By.xpath("//section[@class='checkout-confirmation container']/div[1]/div[1]/p[2]");
	public By OrdersTab = By.xpath("//a[text()='Orders']");
	public By OrderpageTitle = By.xpath("(//tr[@class='astm-table-tr']/td)[1]");
	public By compassDropdown = By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']//a[contains(text(),'Compass')]");

	public By productUnitPrice=By.xpath("(//span[@class='price'])[2]");
	YopMail yopMail;

	public String getETFThankyouMsg() {
		try {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(ETFThankyouMsg));
		return getElement(ETFThankyouMsg).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}
	public String getETFAccountDetails() {
		return getElement(ETFAccountDetails).getText();
	}
	public String getMemberbshipDiscount() {
		return getElement(memberDiscount).getText();
	}
	public WebElement getorderConfirmationPageOrderDate() {
		return getElement(orderConfirmationPage_orderDate);
	}

	public List<WebElement> getAddressHeadersList() {
		return getElements(addressHeadersList);
	}

	public WebElement getBillingAddress() {
		return getElement(billingAddress);
	}

	public WebElement getShippingAddress() {
		return getElement(getShippingAddress);
	}

	public boolean clickPrintLink() {
		try {
			getElement(printLink).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	public List<WebElement> getElements(By locator) {
		try {
			waitForElementPresent(locator);
			return driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some error occured while getting list of elements" + locator.toString());
			e.getStackTrace();
			return null;
		}
	}

	public void sendKeys(By locator, String data) {
		try {
			waitForElementPresent(locator);
			WebElement elm = getElement(locator);
			elm.sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isWebElementDisplayed(By locator) {
		try {
			waitForElementPresent(locator);
			WebElement elm = getElement(locator);
			return elm.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean clickonWebElement(By locator) {
		try {
			WebElement elm = getElement(locator);
			if (elm.isDisplayed() == true)
				elm.click();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks confirmation text
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkReceiptConfirmationToEmail() {
		try {
			return getElement(OrderConfirmationComment2).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public String checkLandingOnOrderConfirmationPage() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(thankYouMsg),10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMsg));
			return getElement(thankYouMsg).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public String checkOrderDetailPageBillingAddress() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(BillingAddressText));
			return getElement(BillingAddressText).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}
	public String checkOrderDetailPageShippingAddress() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(BillingAddressText));
			return getElement(BillingAddressText).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks verbiage text
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkVerbiageOnOrderConfirmationPage() {
		try {
			return getElement(verbiage).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks Item Description text
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkItemDescriptionOnOrderConfirmationPage() {
		try {
			return getElement(itemDescription).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public String checkItemDescriptionOnOrderDetailsPage() {
		try {
			return getElement(Ordersetailspage_ItemDescription).getText().trim();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public String checkItemCodeOnOrderDetailsPage() {
		try {
			return getElement(Ordersetailspage_ItemCode).getText().trim();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public String checkSecondItemCodeOnOrderDetailsPage() {
		try {
			return getElement(Ordersetailspage_ItemCode1).getText().trim();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}


	public String checkAccountNumberOnAccountNumber(){
		try {
			//PublicAdminCommons.scrollToElement(driver,AccountNumber);
			ReusableMethods.scrollDownToBottomOfPage(driver);
			PublicCommon.waitForSec(5);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			String AccountNumberTrim = getElement(AccountNumber).getText();
			AccountNumberTrim = AccountNumberTrim.split(":")[1].trim();
			return AccountNumberTrim;
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}



	public String checkVolumeDescriptionOnOrderConfirmationPage() {
		try {
			return getElement(volumeDescription).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public String checkVolumeDescriptionOnOrderDetailsPage() {
		try {
			return getElement(Ordersetailspage_volumeDescription).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Get Order Number")
	public String getOrderNumber() {
		try {
			ReusableMethods.scrollIntoView(getElement(orderConfirmationPage_orderNumber),driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return getElement(orderConfirmationPage_orderNumber).getText().replaceAll("Order Number: ","");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getDocumentTitleList(){
		return getElements(DocumentTitle);
	}

	public String getDocumentTitleByIndex(int i)
	{
		return 	getDocumentTitleList().get(i).getText();
	}
	public List<String> getDocumentTitles() {
		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getDocumentTitleList(), driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String DocumentTitle1(){
		return getElement(DocTitle1).getText();
	}
	public String DocumentTitle2(){
		return getElement(DocTitle2).getText();
	}

	public String getOrderNumber_OrderDetailspage() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver,getElement(OrderDetailsPage_OrderNumber),10);
			return getElement(OrderDetailsPage_OrderNumber).getText().split(":")[1].trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getShippingDetails() {
		return getElement(OrderDetailspage_Shipping).getText();

	}

	public String getTaxDetails() {
		return getElement(orderDetailsPageTax).getText();

	}

	public String getGrandTotalDetails() {
		return getElement(orderDetailsPageGrandTotal).getText();

	}

	@Step("Verify GrandTotal in Order details Page")
	public String getOrderDetailsGrandTotal(){
		try{
			String discountInString = getElement(orderDetailsPageGrandTotal).getText();
			discountInString = discountInString.replace("$", "").replace("-","");
			return discountInString;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}





	/**
	 * This method checks quantity of products
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkQuantityOnOrderConfirmationPage() {
		try {
			return getElement(qualityPurchased).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks price of products
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkPriceOnOrderConfirmationPage() {
		try {
			return getElement(price).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks total of products
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkTotalOnOrderConfirmationPage() {
		try {
			return getElement(total).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks sub total of products
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkSubTotalOnOrderConfirmationPage() {
		try {
			return getElement(subTotal).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks shipping cost of products
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkShippingOnOrderConfirmationPage() {
		try {
			return getElement(shipping).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks tax on products
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkTaxOnOrderConfirmationPage() {
		try {
			return getElement(tax).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks grand total on products
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkGrandTotalOnOrderConfirmationPage() {
		try {
			return getElement(grandTotal).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkAddressInfoOnOrderConfirmationPage() {
		try {

			String text = driver.findElement(By.xpath("//div[@class='billing-address-success']"))
					.getAttribute("innerText");
			System.out.println(text);
			String str = text.substring(text.indexOf("\n"));
			return str;
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks
	 * 
	 * @return True/false based on visibility of header.
	 */
	public String checkPaymentInfoOnOrderConfirmationPage() {
		try {
			String text = driver.findElement(By.xpath("//strong[text()='Payment Type']//following::div[1]")).getText();
			// .getAttribute("innerText");
			System.out.println(text);
			// String value = text.substring(text.indexOf("\n"));
			return text;
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This Method is used to Get Credit card Text on Order confirmation Page
	 * 
	 * @return
	 */
	public String getCreditCardCheckOutSuccess() {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(eftCheckOutText)));
			List<WebElement> getText = driver.findElements(eftCheckOutText);
			String text = "";
			for (int i = 0; i < 4; i++) {
				text = text + getText.get(i).getText() + "\n";
			}
			return text;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This Method is used to Get Invoice Text on Order confirmation Page
	 * 
	 * @return
	 */
	public String getInvoiceCheckOutSuccess() {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(invoiceCheckOutSuccessText)));
			List<WebElement> getText = driver.findElements(invoiceCheckOutSuccessText);
			String text = "";
			for (int i = 0; i < getText.size(); i++) {
				text = text + getText.get(i).getText().trim();
				System.out.println(text);
			}
			return text;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This Method is used to Get EFT Text on Order confirmation Page
	 * 
	 * @return
	 */
	public String getEftCheckOutSuccess() {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(eftCheckOutText)));
			List<WebElement> getText = driver.findElements(eftCheckOutText);
			String text = "";
			for (int i = 0; i < 5; i++) {
				text = text + getText.get(i).getText() + "\n";
			}
			return text;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method checks PO Number Label
	 * 
	 * @return PONumber text as String
	 */
	public String getPONumberLabel() {
		try {
			return getElement(poNumberLabel).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks PO Number
	 * 
	 * @return PONumber text as String
	 */
	public String getPONumber() {
		try {
			return getElement(poNumber).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks Payment Type Label
	 * 
	 * @return PaymentType text as String
	 */
	public String getPaymentTypeLabel() {
		try {
			return getElement(paymentTyeLabel).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	/**
	 * This method checks Payment Type
	 * 
	 * @return PaymentType text as String
	 */
	public String getPaymentType() {
		try {
			return getElement(paymentTye).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Click on Print Button and Navigate to Receipt Page")
	public void navigationToPrintableReceipt1() {
		try {
			String parentID = driver.getWindowHandle();
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(printLink),5);
			clickONMethod("Print link on Order Confirmation page", printLink, "Click on Print Link");
			Set<String> windows = driver.getWindowHandles();
			String childId = parentID;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			System.out.println(windows.size());
			PublicCommon.waitForSec(10);
			//wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Iterator<String> itr = windows.iterator();
			if (itr.next().equals(parentID) && itr.hasNext())
				childId = itr.next();
			driver.switchTo().window(childId);
			driver.switchTo().defaultContent();
			driver.getCurrentUrl();
			verifyUrl("Print Receipt Url", "/sales/order/print/order_id/", "");
//			driver.switchTo().frame("pdf-viewer");
//			verifyVisibility("Print pdf is visible", order.printPdf, "Print PDF is not visible");
//			driver.switchTo().defaultContent();
//			driver.switchTo().window(parentID);
//			verifyUrl("Print Receipt Url", "/sales/order/print/order_id/", "PUB-3244");
			driver.close();
			switchToTabByIndex(driver, 0);
			//driver.switchTo().window(parentID);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info(ex.toString());
			PublicCommon.reportFailAssert("Navigation to Login Page from homepage failed.", ex);
		}
	}

	@Step("Click on Print Button and Navigate to Receipt Page")
	public void navigationToPrintableReceipt(String jiraTestID) {
		try {
			//String parentID = driver.getWindowHandle();
			clickONMethod("Print link on Order Confirmation page", printLink, "Click on Print Link");
		/*	String childId = null;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			if (itr.next().equals(parentID))
				childId = itr.next();
			driver.switchTo().window(childId);*/
			ReusableMethods.switchToLastWindowTabOpenedByDefault(driver);
			verifyUrl("Print Receipt Url", "/sales/order/print/order_id/", jiraTestID);
			ScreenshotUtil.takeFullPageScreenshot();
		//	driver.close();
			//driver.switchTo().window(parentID);
			PublicAdminCommons.closeNewTabAndSwitchToOriginalTab(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info(ex.toString());
			PublicCommon.reportFailAssert("Navigation to Login Page from homepage failed.", ex);
		}
	}

	@Step("Verify Url for {0}.")
	private void verifyUrl(String elementName, String expectedUrl, String testID) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains(expectedUrl));

			PublicCommon.verifyContentOnPage("Verify Url", driver.getCurrentUrl(), expectedUrl);

		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Exception occured.");
		}
	}

	@Step("Click on {elementName}")
	private void clickONMethod(String elementName, By locator, String assertionMessage) {
		assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
	}

	@Step("Get Account Number")
	public String getAccountNumberFromOrderConfirmationPage(){
		String AcconttNumberOnOrderConfirmationPage = "";
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(AccountNumber), 30);
			ReusableMethods.scrollIntoView(getElement(AccountNumber), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			AcconttNumberOnOrderConfirmationPage = checkAccountNumberOnAccountNumber();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to get Account Number on Order confirmation Page", e);
		}
		return AcconttNumberOnOrderConfirmationPage;
	}

	@Step("Validate Order confirmation Email")
	public void validateEmailConfirmationOnPurchase(String emailID,String orderNumber) {
		try {
			yopMail = getInstance(YopMail.class);

			PublicCommon.openNewTabAndSwitch(driver);
			yopMail.SearchEmailConfirmationAfterPurchase(emailID, orderNumber);
			driver.close();
			Set<String> handles = driver.getWindowHandles();
			for (String handle : handles) {
				driver.switchTo().window(handle);
			}
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			e.getStackTrace();
			log.info(e.toString());
			PublicCommon.reportFailAssert("Failed to Validate the details in Email", e);
		}
	}


	@Step("Verify Order confirmation page and it's grandTotal")
	public void VerifyOrderDetailsPage(String PaymentPageGrandTotal){
		try{
			String OrdersPageGrandTotal = getOrderDetailsGrandTotal();
			Assert.assertEquals(OrdersPageGrandTotal,PaymentPageGrandTotal);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Order Order details Page", e);
		}
	}

	public String getPrice(int i)
	{
		try {
			WebElement ele = driver.findElement(By.xpath("(//span[@class='price'])["+i+"]"));
			return ele.getText();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("unable to get Price",e);
			return "EMPTY";
		}
	}



}
