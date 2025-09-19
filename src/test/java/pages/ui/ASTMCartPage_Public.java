package pages.ui;

import base.utils.EncryptionUtil;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testobjects.prerequisitegenerator.CommonWebActions_PublicAdmin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class ASTMCartPage_Public extends BasePage {

	IronAndSteelProductsPage_Public ironAndSteelProductsPage;
	CommonWebActions_PublicAdmin CommonActions;

	public ASTMCartPage_Public(WebDriver driver) {
		super(driver);
		ironAndSteelProductsPage = getInstance(IronAndSteelProductsPage_Public.class);
	}
	public By getDocHeaderInCartPage_var(int index) {
		return By.xpath("//tbody[@class='cart item']["+index+"]/tr[1]/td[1]//a");
	}
	public By emptyCartMessageHeader = By.xpath("//b[text()='Your cart is empty']");
	private By cartTable = By.id("shopping-cart-table");
	private By cartItems = By.xpath("//*[@class='item-info ']");
	private By qty = By.cssSelector("input[id*='cart'][title='Qty']");
	private By qtyOfItem = By.xpath("//input[@title='Qty']");
	public By qtyHeader = By.xpath("//th//span[text()='Qty']");
	public By priceHeader = By.xpath("//th//span[text()='Price']");
	public By totalHeader = By.xpath("//th//span[text()='Total']");
	public By subTotalHeader = By.xpath("//div//strong[text()='Subtotal:']");
	public By subTotalprice = By.xpath("//tbody//tr//td[@data-th=\"Subtotal\"]");
	public By itemName = By.xpath("//*[@class='product-item-name']");
	public By descriptionHeader = By.xpath("//th//span[text()='Description']");
	public By price = By.xpath("//td[@data-th='Price']//span[@class='cart-price']//span");
	public By updateQty = By.xpath("//button[@name='update_cart_action']");
	public By updateQtyBtn = By.xpath("//button[@title='Update Qty.']");
	public By quanityOnCartPage = By.xpath("//input[@title='Qty']");
	private String cartItemsXpathString = "//*[@class='item-info']";
	private By quantityofItem = By.xpath("(//*[@class='item-info'])[1]//*[@class='col qty']//input[@title='Qty']");
	public By rushShippingCloseButton = By.xpath("//div[@id='rush-shipping-popup']//button[@class='close']//span");
	public By msg_rushshippinh = By.xpath("//span[contains(text(),'Need rush shipping')]");
	public By rushShippingContactBtn = By.xpath("//a[contains(@class,'contact-link')]");
	public By rushShippingText = By.xpath("//*[contains(text(),'Need rush shipping? Please')]");
	public By rushShippingmessage = By.xpath("//span[contains(text(),'Need rush shipping')]");
	public By rushShippingCustomerService = By.xpath("//a[contains(text(),'contact customer service')]");

	public By orgAdminRoleForB2bmessage = By.xpath("//div[@class='prepare-message astm-alert-text']");
	public By orgAdminRoleForB2bmessage1 = By.xpath("(//div[@class='prepare-message astm-alert-text'])[2]");
	public By wrongAccountErrorMessage = By.xpath("//*[contains(text(),'You are currently shopping as')]");
	public By existingPTPCustomerErrorMessage = By.xpath("//*[contains(text(),'You are already a PTP customer.')]");

	public By selectADifferentAccountLink = By.linkText("select a different account.");
	public By memberDiscount = By.xpath("//strong[text()='Member Discount:']/../span/span");
	public By subTotalPrice = By.xpath("//strong[text()='Member Discount:']/preceding-sibling::span/span");
	public By subTotalPrice1 = By.xpath("//*[text()='Subtotal:']/../span/span[@class='price']");
	public By discountPrice = By.xpath("//strong[text()='Member Discount:']/following-sibling::span/span");
	public By memberDiscountonCart = By.xpath("//*[text()='Member Discount:']/following-sibling::td/span");
	public By membershipDiscount = By.xpath("//*[text()='Member Discount:']");
	public By error_Message=By.xpath("//*[text()='You should have an organization admin role to make a B2B product purchase']");
	public List<WebElement> getMemberDiscountOnCart() {
		return getElements(memberDiscountonCart);
	}

	public String getOrgAdminRoleForB2bmessage() {
		return getElement(orgAdminRoleForB2bmessage).getText();
	}

	public String getOrgAdminRoleForB2bmessage1() {
		return getElement(orgAdminRoleForB2bmessage1).getText();
	}

	public String getRushShippingmessage() {
		return getElement(rushShippingmessage).getText();
	}

	public String getRushShippingText() {
		return getElement(rushShippingText).getText();
	}

	public WebElement getWrongAccountErrorMessage() {
		return getElement(wrongAccountErrorMessage);
	}

	public List<WebElement> getRushShippingCloseButtonList() {
		return getElements(rushShippingCloseButton);
	}

	public By getRushShippingCloseButton() {
		return rushShippingCloseButton;
	}

	public By b2bOrgAdminAlert = By.xpath("//div[@data-ui-id='checkout-cart-validationmessages-message-error']");
	// String itemDescription = "(//*[@class='item-info'])[itemIndex]//*[@class='col
	// item']";
	String itemDescription = "(//td[@data-th='Item'])[itemIndex]//child::a";
	// String itemQuantity = "(//*[@class='item-info'])[itemIndex]//*[@class='col
	// qty']//input[@title='Qty']";
	String itemQuantity = "(//div[@class='field qty'])[itemIndex]//child::input";

	// String itemPrice = "(//*[@class='item-info'])[itemIndex]//*[@class='col
	// price']";
	String itemPrice = "(//td[@data-th='Price'])[itemIndex]//child::span[@class='cart-price']";
	// String itemTotal = "(//*[@class='item-info'])[itemIndex]//*[@class='col
	// subtotal']";
	String itemTotal = "(//td[@data-th='Total'])[itemIndex]//child::span[@class='cart-price']";
	String itemDelete = "(//*[@class='item-info'])[itemIndex]//*[@class='item-actions']//a";
	String productDelete = "//*[@class='action action-delete']";
	// public By productsDifferenceError=By.xpath("//div[@class='alert astm-alert
	// bg-danger--light']/div");

	public By productsDifferenceError = By.xpath("//div[@data-ui-id='message-error']/div");
	private By differentTypeError = By.xpath("//*[contains(text(),'We are sorry')]");
	public By conflictProductError = By.xpath("//*[contains(text(),'We are sorry. This product conflicts with a product currently in your cart. To add this product, you must first clear your cart. Please ')]");
	private By cartItemList = By.xpath("//td//div[@class='product-item-details']//a");

	private By firstItemDescription = By.xpath("//tbody[@class='cart item'][1]//strong[@class='product-item-name']");
	public By emptyPageHeader = By.xpath("//div[@class='cart-empty pl-2']//b");
	public By emptyPageHeader2 = By.xpath("//h1[contains(text(),'Do you want to:')]");
	public By restoreLink = By.xpath("//a[contains(text(),'Restore')]");
	public By purchaseStandardLink = By.xpath("//a[contains(text(),'Purchase a standard or a standards')]");
	public By joinASTMLink = By.xpath("//a[contains(text(),'Join ASTM')]");
	public By continueShoppingLink = By.xpath("//a[contains(text(),'Continue Shopping')]");
	public By restoreErrorMessage = By.xpath("//div[contains(text(),'nothing to restore')]");
	public By deleteOption = By.cssSelector("*[title='delete']");
	public By emptyCartMessage = By.xpath("//*[text()='Your cart is empty']");
	public By cartPageIdentifier = By.cssSelector("div[class*='astm-type-body--lead'] div");
	public By OKButton = By.xpath("//a[@class='btn astm-btn btn-secondary button-confirm']");
	public By DeleteBtn = By.xpath("//a[@class='action action-delete']");
	public By cartIndicator = By.xpath("//span[text()='Cart']//following::span[@class='counter-number']");
	public By productInfo = By.className("product-item-details");
	public By switchAccounts = By.xpath("//a[contains(text(),'Switch Account')]");
	public By switchaccountIndicator = By
			.xpath("//*[@class='warning-container']//span[contains(text(),'You are currently logged in as')]");
	public By accountCreationPopup = By.xpath("//*[contains(text(),'You are currently signed')]");
	public By accountCrtnPopup = By.xpath("(//span[contains(text(),'You are currently logged in')])[2]");

	public By continueToCheckoutBtn = By.xpath("//a[contains(text(),'Continue to Checkout')]");
	public By continueToChkButton = By.xpath("//a/span[contains(text(),'Continue to Checkout')]");

	public By deleteProduct(String productToDelete) {
		return By.xpath("//*[text()='" + productToDelete + "']/ancestor::tbody//a[@class='action action-delete']");
	}

	// *[text()='Motor Gasoline']/ancestor::tbody//a[@class='action action-delete']

	public String getAccountCreationPopupText() {
		return getElement(accountCreationPopup).getText();
	}

	public String getB2BOrgAdminAlertText() {
		return getElement(b2bOrgAdminAlert).getText();
	}

	public WebElement getSwitchAccountIndicatorText() {
		return getElement(switchaccountIndicator);
	}

	public WebElement getProductInfo() {
		return getElement(productInfo);
	}

	public WebElement getIndicatorCart() {
		return getElement(cartIndicator);
	}

	public WebElement getOKButton() {
		return getElement(OKButton);
	}

	public WebElement getDeleteBtn() {
		return getElement(DeleteBtn);
	}

	public WebElement getEmptyCartMessage() {
		return getElement(emptyCartMessage);
	}

	public List<WebElement> getSizeOfProduct() {
		return driver.findElements(deleteOption);
	}

	public String getFirstItemDescription() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemDescription));
			return getElement(firstItemDescription).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public WebElement getLastProductInTable() {
		try {
			int size = getElements(deleteOption).size();
			return getElements(deleteOption).get(size - 1);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Get the SubTotal price.
	 * 
	 * @return
	 */
	public String getSubTotalPrice() {
		try {
			return getElement(subTotalprice).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Method to get empty cart page header "Do You Know"
	 * 
	 * @return
	 */
	public String getEmptyProductHeader2() {
		try {
			return getElement(emptyPageHeader2).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Method to get empty cart page header
	 * 
	 * @return
	 */
	public String getEmptyProductHeader() {
		try {
			return getElement(emptyPageHeader).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public List<WebElement> getSizeProduct() {
		return driver.findElements(DeleteBtn);
	}

	public int getCartItemsCount() {
		try {
			// reducing implicit driver wait time here to optimize lookup time for cart
			// items.
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Items in Cart: " + getElements(cartItems).size());
			return getElements(cartItems).size();
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("master catch block, cart item count");
			return -1;
		} finally {
			System.out.println("Cart Items Count Finally Block.");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	/*
	 * public String getProductsDifferenceError() { try { return
	 * getElement(productsDifferenceError).getText(); } catch (Exception ex) {
	 * ex.printStackTrace(); return null;
	 * 
	 * } finally{ }
	 * 
	 * clearCart(); }
	 * 
	 * }
	 */
	public String getDifferentProductTypeErrorMessage() {
		try {
			return getElement(differentTypeError).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/*
	 * Get Restore Error Message
	 * 
	 */
	public String getRestoreErrorMessage() {
		try {
			return getElement(restoreErrorMessage).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public String getItemDescription() {
		try {
			return getElement(itemName).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getQuantity() {
		try {
			return getElement(qtyOfItem).getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getPrice() {
		try {
			return getElement(price).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getItemDescriptionInCartRowByIndex(int index) {
		try {
			return getElement(PublicCommon.createByOperatorXpath(itemDescription, "itemIndex", String.valueOf(index)))
					.getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getItemQuantityInCartRowByIndex(int index) {
		try {
			return getElement(PublicCommon.createByOperatorXpath(itemQuantity, "itemIndex", String.valueOf(index)))
					.getAttribute("value");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getItemPriceInCartRowByIndex(int index) {
		try {
			return getElement(PublicCommon.createByOperatorXpath(itemPrice, "itemIndex", String.valueOf(index)))
					.getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getItemTotalInCartRowByIndex(int index) {
		try {
			return getElement(PublicCommon.createByOperatorXpath(itemTotal, "itemIndex", String.valueOf(index)))
					.getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Step("Deleting Cart item at index: {index}")
	public boolean deleteItemInCartRowByIndex(int index) {
		try {
			System.out.println("Deleting Cart item at index: " + index);
			int items = this.getCartItemsCount();
			boolean deleteAction = false;

			getElement(PublicCommon.createByOperatorXpath(itemDelete, "itemIndex", String.valueOf(index))).click();
			deleteAction = PublicCommon.waitForNumberOfElementsToBe(driver, cartItemsXpathString, (items - 1), 5);
			return deleteAction;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteProductsInCartRowByIndex(int index) {
		try {
			System.out.println("Deleting Cart item at index: " + index);
			int items = this.getCartItemsCount();
			boolean deleteAction = false;

			getElement(PublicCommon.createByOperatorXpath(productDelete, "itemIndex", String.valueOf(index))).click();
			deleteAction = PublicCommon.waitForNumberOfElementsToBe(driver, cartItemsXpathString, (items - 1), 10);
			return deleteAction;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean clearCart() {
		try {
			if (getElement(cartPageIdentifier).getAttribute("class").contains("cart-empty")) {
				return true;
			}
			int size = getElements(deleteOption).size();

			for (int i = 0; i < size; i++) {
				getElements(deleteOption).get(0).click();
				PublicCommon.waitForSec(3);
			}
			if (PublicCommon.isVisibleInViewport(getElement(emptyCartMessage), driver))
				return true;
			else
				clearCart();

			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean clearCart2() {
		try {
			boolean cartCleared = false;

			if (this.getCartItemsCount() == 0) {
				noCartItems();
				return true;
			}

			int itemsInCart = this.getCartItemsCount();
			for (int i = itemsInCart; i > 0; i--) {
				if (this.deleteItemInCartRowByIndex(i))
					continue;
				else
					break;
			}

			if (this.getCartItemsCount() == 0)
				cartCleared = true;

			return cartCleared;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public By yourShoppingCartHeader = By.xpath("//span[text()='Your Shopping Cart:']");
	private By tableHeaderList = By.cssSelector("thead span");
	public By productNameList = By.className("product-item-name");
	public By productPriceList = By.cssSelector("td[data-th='Price'] .price");
	private By productExtendedPriceList = By.cssSelector("td[data-th='Total'] .price");

	private By productQtyTextboxElements = By.xpath("//span[text()='Qty']//following-sibling::input");

	private By productQtyTextbox1 = By.xpath("(//div[@class='field qty']//input)[1]");
	private By productQtyTextbox2 = By.xpath("(//div[@class='field qty']//input)[2]");

	public By productDeleteOption = By.cssSelector(".action-delete");

	private By productsTotalPrice = By.cssSelector("div[class='subtotal-row'] .price");
	private By updateButton = By.xpath("//button[@type='submit' and @name='update_cart_action']");
	public By continueShoppingButton = By.xpath("//span[text()='Continue Shopping']");
	public By continueButton = By.xpath("//button[text()='Continue']");

	// private By checkoutButton = By.xpath("//*[@title='Proceed to
	// Checkout']//span");
	public By checkoutButton = By.xpath("//span[text()='Checkout']/..");
	public By FormatType = By.xpath("//dt[text()='Format']/../dd");
	public By FormatTypePrint = By.xpath("//dt[text()='Format']/../dt/../dd[2]");
	public By CartSubtotal = By.xpath("//strong[text()='Subtotal:']/../span/span");
	public By CartPageTitle = By.xpath("//div[@class='product-item-details']/strong");
	public By astmLicenceCloseButton = By.xpath("//*[@id=\"astm_license_agreement\"]/div/div/div[1]/button/span");
	public By selectDifferentAccount = By.xpath("//a[text()='select a different account.']");

	public By checkOutBtn = By.xpath("//button[@title='Proceed to Checkout']");
	public By checkOutBtnAfterLogin = By.linkText("Checkout");
	public By checkOutAfterUpdate = By.xpath("//a//child::span[text()='Checkout']");
	public By productTitleCartPage = By.xpath("//strong[@class='product-item-name']/a");

	public By popupModalHeader = By.className("modal-header");

	// Create Account Sign up:
	public By createNewAccount = By.xpath("//h4[text()='New Customers']//following::span[text()='Create an Account']");
	public By emptyCart = By.className("cart-empty");

	private By emailTextBox = By.id("customer-email");
	private By passwordTextBox = By.name("password");

	private By signInButton = By.xpath("//span[text()='Sign In']");

	private By ptpAuthenticationPopupHeader = By.id("PtpAuthenticationPopup");
	private By ptpAuthenticationPopupBody = By.cssSelector(".modal-body-wrapper p");
	private By newPatientButton = By.partialLinkText("New Participant");
	private By newParticipantButton = By.partialLinkText("New Participant");
	public By yesPopupButton = By.partialLinkText("Yes");
	private By closePopupButton = By.cssSelector("#ptp-authentication-popup .close");

	public By createAccountButton = By.xpath("//*[@class='block-new-customer']//*[text()='Create an Account']");

	public By createAccountButtonForMobile = By.xpath("//a[@class=btn astm-btn btn-secondary w-100]");
	public By ProductTitle = By.xpath("(//strong[@class='product-item-name']/a)[1]");
	public By ProductTitleNew = By.xpath("//strong[@class='product-item-name']");
	public By CollectionSku = By.xpath("//dl[@class='item-options item-additional-info']/dd");
	public By MemberSubtotal = By.cssSelector("p > span:nth-child(2) > span");
	public By MemberDiscount = By.cssSelector("p > span:nth-child(5) > span");
	public By CartPageProductTitle = By.xpath("//strong[@class='product-item-name']");
	public By cartLinkOnHomePage = By.xpath("//span[@class='cart-title' and text()='Cart']");
	public By QuantityBox = By.xpath("//input[@title='Qty']");
	public By UpdateQtyBtn = By.xpath("//button[@title='Update Qty.']");
	public By PopUpMsg = By.xpath("//h1[contains(text(),'Attention')]/../../div[@class='modal-content']/div");
	public By OkBtn = By.xpath("//button[@class='action-primary action-accept']");
	public By RestoreLastRemovedProduct = By.xpath("//a[text()='Restore the last removed product']");
	public WebElement getCheckoutButton() {
		return getElement(checkoutButton);
	}

	public By getASTMLicenceCloseButton() {
		return astmLicenceCloseButton;
	}

	public WebElement getYourShoppingCartHeader() {
		return getElement(yourShoppingCartHeader);
	}

	public List<WebElement> getTableHeaderListElements() {
		return getElements(tableHeaderList);
	}

	public List<WebElement> getProductNameListElements() {
		return getElements(productNameList);
	}

	public List<WebElement> getProductPriceListElements() {
		return getElements(productPriceList);
	}

	public List<WebElement> getProductTitlesList(){
		return getElements(ProductTitle);
	}

	public List<WebElement> getProductExtendedPriceListElements() {
		return getElements(productExtendedPriceList);
	}

	public List<WebElement> getProductQtyElements() {
		return getElements(productQtyTextboxElements);
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

	public void selectValueInDropdown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Add Two Iron And Steel Products to the ASTM Cart.")
	public void addTwoINSProductsToCart() {
		try {
			ironAndSteelProductsPage.clickPreviousYearAddToCartButton();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(2);
			ironAndSteelProductsPage.clickCurrentYearAddToCartButton();

			PublicCommon.waitForSec(2);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			// Assert.assertFalse(ironAndSteelProductsPage.checkErrorMessageIsVisible(),
			// "Error: 'Invalid Form Key. Please refresh the page' found." );
			assertNotNull(ironAndSteelProductsPage.clickShoppingCartLink(), "Clicking Shopping Cart retuned null");

			assertTrue(getCartPageUrl().contains("/checkout/cart/"), "Cart URL Validation on Cart Page.");
			// getCartPageUrl();
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PublicCommon.reportFailAssert("Exception while adding items to cart..", e);
		}

	}

	@Step("Add Iron And Steel Product to the ASTM Cart.")
	public void addProductsToCart() {
		ironAndSteelProductsPage.clickPreviousYearAddToCartButton();

		assertNotNull(ironAndSteelProductsPage.clickShoppingCartLink(), "Clicking Shopping Cart retuned null");
		getCartPageUrl();

	}

	@Step("Click on Close Button for AsTM License")
	public void closeASTMLicenceBtn() {
		try {
			Thread.sleep(2000);
			clickOnMethod("Close Button ", getASTMLicenceCloseButton(), "Failed to click");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Add One Iron And Steel Products to the ASTM Cart.")
	public void addOneINSProductsToCart() {
		ironAndSteelProductsPage.clickCurrentYearAddToCartButton();
		/*
		 * Assert.assertFalse(ironAndSteelProductsPage.checkErrorMessageIsVisible(),
		 * "Error: 'Invalid Form Key. Please refresh the page' found.");
		 */ ironAndSteelProductsPage.clickShoppingCartLink();
		getCartPageUrl();

	}

	@Step("Get 'Cart' page url.")
	public String getCartPageUrl() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains("/checkout/cart/"));

			return driver.getCurrentUrl();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Get Headers of the Table on ASTM Cart Page.")
	public List<String> getTableHeaderList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getTableHeaderListElements(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Click Checkout Button")
	public void clickCheckoutButton() {
		try {

			if (verifyVisibilityofSelectDifferentAccount()) {
				clickOnMethod("Select different account", selectADifferentAccountLink,
						"Failed to click on select different account");
			}
			// TODO: Change wait to Explicit wait
			ReusableMethods.scrollIntoView(getElement(checkoutButton), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(checkoutButton));
			PublicCommon.JSClick(getElement(checkoutButton), driver);
			/*if (getElement(rushShippingCloseButton).isDisplayed()) {
				closeRushButton();

			}*/

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Click Checkout Button")
	public void clickCheckoutButton11() {
		try {

			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(checkoutButton));
			PublicCommon.JSClick(getElement(checkoutButton), driver);


		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public String getProductsDifferenceError() {
		try {
			return getElement(productsDifferenceError).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally{
			clearCart();
		}


	}

	@Step("Click Checkout Button")
	public void clickCheckoutButton1() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(checkoutButton));
			PublicCommon.JSClick(getElement(checkoutButton), driver);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Click Create Account Button")
	public CreateAccountPage_Public clickCreateAccountButton() {
		try {

			PublicCommon.waitForSec(5);// TODO: Change wait to Explicit wait
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(createAccountButton));
			getElement(createAccountButton).click();
			return getInstance(CreateAccountPage_Public.class);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Login with the right credentials.")
	public void loginWithRightCreds(String username, String encryptedPassword) {
		try {
			EncryptionUtil encryptionUtil = new EncryptionUtil();
			getElement(emailTextBox).sendKeys(username);
			getElement(passwordTextBox).sendKeys(encryptionUtil.decrypt(encryptedPassword));
			PublicCommon.waitForSec(3);
			ReusableMethods.mouseHoverAndClick(driver, getElement(signInButton), "Click Sign-in Button");
			// getElement(signInButton).submit();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Step("Get Product names in the table on ASTM Cart Page.")
	public List<String> getProductNameList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getProductNameListElements(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getProductTitle() {
		try {
			return getElement(ProductTitleNew).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getCollectionSku() {
		try {
			return getElement(CollectionSku).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getSubtotal(){
		try{
			return getElement(MemberSubtotal).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Get Membership Discount Price")
	public String getMembershipDiscountInCartPage(){
		try{
			String discountInString = getElement(MemberDiscount).getText();
			discountInString = discountInString.replace("$", "").replace("-","");
			return discountInString;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	static Logger log = Logger.getLogger(PublicAdminCommons.class.getName());

	public static String returnDiscountedAmount(String priceInString, int discountPercentage) {
		try {
			priceInString = priceInString.replace("$", "");
			double priceInDouble = Double.parseDouble(priceInString);

			double discountedPrice = priceInDouble - (priceInDouble * discountPercentage / 100);
			double AfterDiscount = priceInDouble - discountedPrice;
			return String.format("%.2f", AfterDiscount);
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return "";
		}
	}

	public List<String> getProductTitles() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			return PublicCommon.getListOfTextFromListOfWebelements(getProductTitlesList(), driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String getCartPageProductTitle() {
		try {
			return getElement(CartPageProductTitle).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public WebElement getQuantityTextbox() {
		return getElement(QuantityBox);
	}

	public WebElement getUpdateQtyBtn(){
		return getElement(UpdateQtyBtn);
	}

	public String getAttentionPopupMsg(){
		try {
			return getElement(PopUpMsg).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getPTPPopupHeader() {

		try {
			return getElement(ptpAuthenticationPopupHeader).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getPTPPopupBody() {

		try {
			return getElement(ptpAuthenticationPopupBody).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * This method click on New Patient Button
	 * 
	 * @return True/false
	 */

	public boolean clickNewPatientButton() {
		try {
			getElement(newPatientButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * This method click on New Participant Button
	 * 
	 * @return True/false
	 */

	public boolean clickNewParticipantButton() {
		try {
			getElement(newParticipantButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public void clickClosePTPPopupButton() {
		try {
			getElement(closePopupButton).click();
		} catch (Exception e) {
			e.getStackTrace();

		}
	}

	public boolean clickYesButtonOnPTPPopup() {
		try {
			getElement(yesPopupButton).click();
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	@Step("Get Product price in the table on ASTM Cart Page.")
	public List<String> getProductPriceList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getProductPriceListElements(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Get Product's Extended Price in the table on ASTM Cart Page.")
	public List<String> getProductExtendedPriceList() {

		try {
			return PublicCommon.getListOfTextFromListOfWebelements(getProductExtendedPriceListElements(), driver);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Step("Get 'Your Shopping Cart' Header text.")
	public String getYourShoppingCartHeaderText() {
		return getElement(yourShoppingCartHeader).getText();

	}

	@Step("Get 'Sub-Total Amount' below the cart table.")
	public String getProductsTotalPriceText() {
		try {
			return getElement(productsTotalPrice).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Get Product quantity for first product.")
	public String getProductsQtyTextbox1Value() {
		try {
			return getElement(productQtyTextbox1).getAttribute("value");
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Get Product quantity for second product.")
	public String getProductsQtyTextbox2Value() {
		try {
			return getElement(productQtyTextbox2).getAttribute("value");
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Set Product quantity .")
	public void setProductsQtyTextbox1Value(String value) {
		try {
			getElement(productQtyTextbox1).clear();
			getElement(productQtyTextbox1).sendKeys(value);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	/* This method sends same value to all product quantity textbox */
	public void setAllProductsQty(String value) {
		try {
			int textboxCount = getProductQtyElements().size();
			for (int i = 0; i < textboxCount; i++) {
				getProductQtyElements().get(i).clear();
				getProductQtyElements().get(i).sendKeys(value);
			}
			getElement(updateButton).click();
			PublicCommon.waitForSec(3);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Check 'Pop-up Modal'  is Visible.")
	public boolean checkPopupModalIsPresent() {
		try {
			return (getElement(popupModalHeader).isDisplayed()); // popupModalHeader
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	public boolean checkYourShoppingCartHeaderIsPresent() {
		try {
			return (getElement(yourShoppingCartHeader).isDisplayed());
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Step("Click Update Qty Button")
	public void clickUpdateQtyButton() {
		try {
			WebElement qtyUpdateButton = getElement(updateButton);
			ReusableMethods.scrollIntoView(qtyUpdateButton, driver);
			qtyUpdateButton.click();

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Click Continue Shopping Button")
	public StandardsAndPublicationsPage_Public clickContinueShoppingButton() {
		try {
			ReusableMethods.scrollIntoView(ironAndSteelProductsPage.getElement(continueShoppingButton), driver);
			getElement(continueShoppingButton).click();
			return getInstance(StandardsAndPublicationsPage_Public.class);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
			// TODO: handle exception
		}
	}

	@Step("Check Cart is Empty.")
	public boolean checkCartIsEmpty() {
		try {
			return getElement(emptyCart).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Click Checkout Button")
	public void clickCheckoutButtonUnauthenticatedSession() {
		try {

			int i = 0;
			// int retry =10;
			do {
				System.out.println("retry - " + (i + 1));

				getElement(checkoutButton).click();

				if (i > 0) {
					driver.navigate().refresh();
					System.out.println("page reload");
				}
				++i;
			} while (!(WaitStatementUtils.explicitWaitForVisibility(driver, getElement(createNewAccount))) && i < 4); // WaitStatementUtils.explicitWaitForVisibility(driver,
																														// getElement(popupModalHeader)
																														// checkoutButton
		} catch (Exception e) {
			e.getStackTrace();

			// TODO: handle exception
		}
	}

	@Step("Click Delete Product Link")
	public void clickDeleteProductLink() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(productDeleteOption), 10);
			getElement(productDeleteOption).click();

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Click Create an Account Button")
	public void clickCreateNewAccountButton() {
		try {
			getElement(createNewAccount).click();

		} catch (Exception e) {
			e.getStackTrace();

			// TODO: handle exception
		}
	}

	@Step("There are no items in the cart.")
	public void noCartItems() {
		// Placeholder function to print in report
		System.out.println("Cart is empty.");
	}

	/**
	 * This method is use to Click on CheckOutbutton
	 * 
	 * @return True/False
	 */
	public boolean clickOnCheckoutButton() {
		try {
			// checkOutBtnAfterLogin old: checkOutBtn
			ReusableMethods.scrollIntoView(getElement(checkoutButton), driver);
			if (getElement(checkoutButton).isDisplayed() == true) {
				// checkOutBtnAfterLogin old: checkOutBtn
				new WebDriverWait(driver, 10).until(ExpectedConditions.and(
						ExpectedConditions.textToBePresentInElement(getElement(checkoutButton), "Checkout"),
						ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(checkoutButton)),
						ExpectedConditions.elementToBeClickable(checkoutButton)));

				// checkOutBtnAfterLogin old: checkoutButton
				PublicCommon.JSClick(getElement(checkoutButton), driver);

				/*
				 * Actions act =new Actions(driver); act.moveToElement(getElement(checkOutBtn));
				 * act.click(getElement(checkOutBtn)).build().perform();
				 */
				return true;
			}

			// PublicCommon.JSClick(getElement(checkoutButton), driver);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;

	}

	public void setProductsQtyTextbox1Value1(String value) {
		try {
			getElement(productQtyTextbox1).clear();
			getElement(productQtyTextbox1).sendKeys(value);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	public void clickUpdateQtyButton1() {
		try {
			getElement(updateButton).click();

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	public List<WebElement> getWebElementsForCartItems() {
		try {
			return getElements(cartItemList);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Check Qty Column is visible or not
	 */
	public boolean verifyVisibilityofQtyofItemforWebniar() {
		try {
			return getElements(quantityofItem).size() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyVisibilityofSelectDifferentAccount() {
		try {
			return getElements(selectADifferentAccountLink).size() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Step("Click on Select A different account link in the Cart page")
	public void SelectDifferentAccountInCartPage() {
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementStaleness(driver, getElement(selectADifferentAccountLink));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(selectADifferentAccountLink));

			getElement(selectADifferentAccountLink).click();

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(switchAccounts));
			WaitStatementUtils.waitForElementStaleness(driver, getElement(switchAccounts));
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(switchAccounts));
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Click on Close Button for Rush Shipping")
	public void closeRushButton() {
		try {
			Thread.sleep(2000);
			clickOnMethod("Close Button ", getRushShippingCloseButton(), "Failed to click");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCartSubTotal(){
		try {
			return getElement(CartSubtotal).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	@Step("Click on {elementName}")
	public void clickOnMethod(String elementName, By locator, String assertionMessage) {
		try {
			// ReusableMethods.scrollIntoView(driver.findElement(locator), driver);
			IntegrationCommon.clickonWebElement(driver, locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String verifyText(By locator){
		return getElement(locator).getText();
	}

	@Step("Verify Product Details In Cart page")
	public void VerifyProductDetailsInCart(String ProgramName,String ProgramTitle) {
		try {
			String CartProductName = getProductTitle();
			String CartProductTitle = getCollectionSku();
			Assert.assertEquals(ProgramName, CartProductName);
			Assert.assertEquals(ProgramTitle,CartProductTitle);
			PublicAdminCommons.scrollToOffSet(driver,"0","100");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Product Details In Cart page", e);
		}
	}


	@Step("To verify that 10% Discount is applied on the total amount")
	public String VerifyMembershipDiscount() {
		String DiscountedAmount = null;
		try {
			String Subtotal = getSubtotal();
			Integer discount = 10;
			DiscountedAmount = String.valueOf(getMembershipDiscountInCartPage());
			assertEqualWithStep(returnDiscountedAmount(Subtotal, discount), DiscountedAmount,
					"Verify subtotal is the discounted price",
					"Subtotal is not having the discounted price");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify if 10% Discount is applied on the total amount", e);
		}
		return DiscountedAmount;
	}

	@Step("Click on Checkout button")
	public void VerifyCheckOut(){
		try{
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickOnMethod("Checkout Button", checkoutButton, "Failed to click on checkout button");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to click on checkout button", e);
		}
	}

	@Step("{stepDef}")
	public void assertEqualWithStep(String actual, String expected, String stepDef, String assertionMessage) {
		try {
			Assert.assertEquals(actual, expected,
					assertionMessage);
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicAdminCommons.reportFailAssert(assertionMessage, e);
		}
	}


}
