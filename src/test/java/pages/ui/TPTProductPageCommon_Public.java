package pages.ui;

import java.util.ArrayList;
import java.util.List;

import base.utils.ReusableMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;

import base.utils.WaitStatementUtils;

public class TPTProductPageCommon_Public extends BasePage {

	/**
	 * Parameterized constructor
	 * 
	 * @param driver
	 */
	public TPTProductPageCommon_Public(WebDriver driver) {
		super(driver);
	}
	public By CartLink = By.xpath("//a[@class='nav-link d-none d-md-block mb-0']//span[text()='Cart']");
	private By TPTProductHeader = By.className("page-title");
	public By addToCartButton = By.cssSelector("button[title='Add to Cart']");
	public By addToCartButton1 = By.cssSelector("form[data-role='add-to-cart-form'] button[title='Add to Cart']");
	
	private By registerOnline = By.xpath("//div[@class='register-online mb-3']//p");
	private By productLogo = By.cssSelector("img[src*='Alpine_TptProduct/images/iacet.png']");
	private By productPriceLabel = By.cssSelector("span[id*='product-price']");
	private By contentsHeading = By.cssSelector(".astm-type-heading--h5-bold");
	private By stockNumber = By.xpath("//div[@class='mb-4'][9]/div");
	public By shoppingCartLink = By.xpath("//a[text()='shopping cart']");
	public By shoppingCart=By.xpath("//span[text()='Cart']");
	private By accessHyperLink = By.xpath("//div[@class='mb-4'][7]//a");
	private By technologyRequirementsHyperLink = By.xpath("//div[@class='mb-4'][8]//a");
	private By faqButton = By.xpath("//div[@class='actions pt-4']//a[contains(text(),'FAQ')]");
	private By errorMessage = By.xpath("//*[@class='astm-type-heading--h2 myt5 mb-3']");
	private By returnToCourseListing = By.xpath("//a[contains(text(),'Return to Course Listing')]");
	public By Count = By.xpath("//p//strong[text()='Webinar:']");
	public By addAttendeesBtnCount = By.xpath("//span[text()='Add Attendees']");
	private By inputNumberOfAttendees = By.xpath("//*[contains(@class,'product_addtocart_form_attendees')]//input[@title='Number of Attendees']");
	public By addAttendeesBtn = By
			.xpath("//*[contains(@class,'product_addtocart_form_attendees')]//span[text()='Add Attendees']");
	private By addAttendeesModelLabel = By.id("AddAttendeesLabel");
	private By attendeesRows = By.xpath("//form[@id='add-attendees']//table//tbody//tr");
	public By closeBtn = By.xpath("//button[text()='Close']");
	public By attendee_addToCartButton = By.xpath("//div[@class='modal-footer']/button[text()='Add to Cart']");
	public By firstName = By.name("attendees[0][first-name]");
	public By intial = By.name("attendees[0][initial]");
	public By lastName = By.name("attendees[0][last-name]");
	public By phoneNumber = By.name("attendees[0][phone]");
	public By email = By.name("attendees[0][email]");
	private By productDate=By.xpath("//div[@class='tpt-products']//p");
	public By firstNameErrorMsg = By.id("attendees[0][first-name]-error");
	public By lastNameErrorMsg = By.id("attendees[0][last-name]-error");
	public By phoneFieldErrorMsg = By.id("attendees[0][phone]-error");
	public By emailErrorMsg = By.id("attendees[0][email]-error");
    public By modalAddToCart=By.xpath("//button[@type='submit' and text()='Add to Cart']");
    
    public By PersonalRadioBtn =By.xpath("//*[@id='b2c']/following-sibling::label");
    public By SelectOrgBtn1 =By.xpath("//*[@id='account-select-container']/div[2]/div/a");
    public By BusinessRadioBtn =By.xpath("//*[@id='b2b']/following-sibling::label");
    public By submitPurchaseDetailsBtn  = By.xpath("//*[@class='modal-footer']/*[contains(text(),'Submit')]");
    public By errorMessageMaxLimit  = By.xpath("//*[text()='There is a limit of 1 Webinar, Live or Virtual Training Course per order. Please ']");
    public By errorMsg =By.xpath("//div[@role='alert'][@class='messages']");
    public By paymentInformationHeader=By.xpath("//h4[text()='Payment Information']");
	public By purchaseDetails_EnterQty = By.cssSelector("#learner-qty");
	ASTMProficiencyTestingPage_Public productPage;
	MembershipBecomeMemberPage newMembershipPage;
	public Page page;
	public WebElement getErrorMessageMaxLimit() {
		return getElement(errorMessageMaxLimit);
	}
	public WebElement getErrorMessageAlert() {
		return getElement(errorMsg);
	}
    public boolean selectPurchaseAccount(String type) {
		try {
			switch (type) {
			case "b2c":
				getElement(PersonalRadioBtn).click();
				break;

			default:
				getElement(BusinessRadioBtn).click();
				break;
			}
			IntegrationCommon.clickonWebElement(driver, submitPurchaseDetailsBtn);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean selectPurchaseAccount(String type, int qty) {
		try {
			switch (type) {
				case "b2c":
					getElement(PersonalRadioBtn).click();
					break;

				case "b2b":
					getElement(BusinessRadioBtn).click();
					getElement(purchaseDetails_EnterQty).isDisplayed();
					getElement(purchaseDetails_EnterQty).click();
					getElement(purchaseDetails_EnterQty).sendKeys(Integer.toString(qty));
					break;

				default:
					getElement(purchaseDetails_EnterQty).isDisplayed();
					getElement(purchaseDetails_EnterQty).click();
					getElement(purchaseDetails_EnterQty).sendKeys(Integer.toString(qty));

					break;
			}
			IntegrationCommon.clickonWebElement(driver, submitPurchaseDetailsBtn);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
    
	/**
	 * Get Page header
	 * 
	 * @return
	 */
	public String getTPTProductHeader() {
		try {
			return getElement(TPTProductHeader).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Get bold content headings
	 * 
	 * @return
	 */
	public List<String> getContentHeadings() {

		try {
			List<String> contentHeadingList = new ArrayList<String>();
			List<WebElement> contentHeadingElements = getElements(contentsHeading);

			for (WebElement element : contentHeadingElements) {
				contentHeadingList.add(element.getText());
			}
			return contentHeadingList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Get Webinar Date
	 * 
	 * @return S
	 */
	public String getWebinarDate() 
	{
		try {
			return getElement(productDate).getText().substring(9);
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}	
	}
	
	public String getWebinarDate(int i) 
	{
		try {
			return getElements(productDate).get(i).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}	
	}
	
	/**
	 * Get product logo url
	 * 
	 * 
	 * @return
	 */
	public String getProductLogoInfo() {
		try {
			return getElement(productLogo).getAttribute("src");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get product price from page
	 * 
	 * @return
	 */
	public String getProductPrice() {
		try {
			return getElement(productPriceLabel).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get Stock number from page
	 * 
	 * @return
	 */
	public String getStockNumber() {
		try {
			return getElement(stockNumber).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Clicks on Add Cart Button
	 * 
	 * @return
	 */
	public boolean clickAddToCartutton() {
		try {
			waitForElementPresent(addToCartButton);
			ReusableMethods.scrollIntoView(getElement(addToCartButton), driver);
			//PublicCommon.JSClick(getElement(addToCartButton), driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(addToCartButton));
			getElement(addToCartButton).click();


			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	/**
	 * Checks if the shopping cart link is visible
	 * 
	 * @return
	 */
	public boolean shoppingCartLinkShow() {
		try {
			return (getElements(shoppingCartLink).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Click on shopping cart link
	 * 
	 * @return
	 */
	public boolean clickOnShoppingCartLink() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(shoppingCartLink));
			PublicCommon.JSClick(getElement(shoppingCartLink), driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method to get webelements in the list
	 * 
	 * @param locator
	 * @return
	 */
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
	 * Clicks on Access Link on the page
	 * 
	 * @return
	 */
	public boolean clickHyperLinkUnderAccess() {
		try {
			getElement(accessHyperLink).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	/**
	 * Clicks link under Technology requirement column
	 * 
	 * @return
	 */
	public boolean clickHyperLinkUnderTechnologyRequirements() {
		try {
			getElement(technologyRequirementsHyperLink).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	/**
	 * Clicks FAQ Button
	 * 
	 * @return
	 */
	public boolean clickFaqButton() {
		try {
			getElement(faqButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	/**
	 * Gets the error message on page
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		try {
			return getElement(errorMessage).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Click on returnToCourseListing button
	 * 
	 * @return
	 */
	public boolean clickReturnToCourseListingButton() {
		try {
			getElement(returnToCourseListing).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	public WebElement getProductLogo() {
		try {
			return getElement(productLogo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Visibility of Return to Course Listing
	 * 
	 * @return
	 */
	public boolean clickReturnToCourseListing() {
		try {
			getElement(returnToCourseListing).isDisplayed();
			getElement(returnToCourseListing).click();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * Enter The value of Attendees
	 * 
	 * @return
	 */
	public boolean enterAttendees(String value) {
		try {
			getElement(inputNumberOfAttendees).isDisplayed();
			getElement(inputNumberOfAttendees).sendKeys(value);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	
	/**
	 * get values of add attendees field error messages
	 * 
	 * @return
	 */
	public String getErrorMsg(By locator) {
		try {
			String value = getElement(locator).getText();
			return value;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Enter The value of add attendees
	 * 
	 * @return
	 */
	public boolean getAttendeesRowCount(String value) {
		try {
			getElement(addAttendeesBtn).click();
			int size = getElements(attendeesRows).size();
			System.out.println("size of rows" + size);
			int count = Integer.parseInt(value);
			if (count == size)
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Enter The value of add attendees
	 * 
	 * @return
	 */
	public boolean addAttendee(String value) {
		try {
			getElement(inputNumberOfAttendees).clear();
			getElement(inputNumberOfAttendees).sendKeys(value);
			getElement(addAttendeesBtn).click();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Enter The value of add attendees
	 * 
	 * @return
	 */
	public boolean addAttendeeDetails(String fName, String intialValue, String LName, String Phone, String Email,
			String value) {
		try {
			getElement(inputNumberOfAttendees).clear();
			getElement(inputNumberOfAttendees).sendKeys(value);
			// waitForElementPresent(addAttendeesBtn);
			// WaitStatementUtils.waitForElementToBeClickable(driver,
			// getElement(addAttendeesBtn),10);
			wait.until(ExpectedConditions.elementToBeClickable(addAttendeesBtn));
			getElement(addAttendeesBtn).click();
			WebElement fname = getElement(firstName);
			WebElement lname = getElement(lastName);
			WebElement intialElement = getElement(intial);
			WebElement phn = getElement(phoneNumber);
			WebElement emailElement = getElement(email);
			WaitStatementUtils.waitForElementToBeClickable(driver, fname);
			fname.sendKeys(fName);
			WaitStatementUtils.waitForElementToBeClickable(driver, intialElement);
			intialElement.sendKeys(intialValue);
			WaitStatementUtils.waitForElementToBeClickable(driver, lname);
			lname.sendKeys(LName);
			WaitStatementUtils.waitForElementToBeClickable(driver, phn);
			phn.sendKeys(Phone);
			WaitStatementUtils.waitForElementToBeClickable(driver, emailElement);
			emailElement.sendKeys(Email);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String getRegisterOnlineVeribage() {
		try {
			return getElement(registerOnline).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * check no of add attendees buttons and count
	 * 
	 * @return
	 */
	public boolean checkAddAttendeesBtnForDiffWebinar() {
		try {
			if (getElements(Count).size() == getElements(addAttendeesBtnCount).size())
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Step("Select any program from list of Multiple PTP Programs")
	public void selectTPTprogram(String CommitteName, String productName) {
		try{
			newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
			productPage = getInstance(ASTMProficiencyTestingPage_Public.class);
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(productPage.committeeLink(CommitteName)), 30);
			ReusableMethods.scrollIntoView(getElement(productPage.committeeLink(CommitteName)), driver);
			PublicCommon.JSClick(getElement(productPage.committeeLink(CommitteName)), driver);

			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(productPage.committeeLink(productName)), 30);
			ReusableMethods.scrollIntoView(getElement(productPage.committeeLink(productName)), driver);
			PublicCommon.JSClick( getElement(productPage.committeeLink(productName)), driver);

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select any program from list of Multiple TPT Programs", e);
		}
	}

}
